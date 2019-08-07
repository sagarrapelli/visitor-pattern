package troubleShootSearch.visitor;

import java.util.Arrays;
import java.util.HashMap;
import troubleShootSearch.dSeaGate.DSeaGateI;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

public class SemanticSearchVisitor implements Visitor {

	private static HashMap<String, String> synonyms = new HashMap<String, String>();
	String keywords;
	ExactSearchVisitor exact;
	
	public SemanticSearchVisitor() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: SemanticSearchVisitor created ");
		exact = new ExactSearchVisitor();
	}
	
	public void setSearchKeywords(String line) {
		keywords = line;
	}
	
	public static void readSynonyms(FileProcessor fp) {
		fp.openFile("src/troubleShootSearch/visitor/synonyms.txt");
		String line;
		while(true) {
			line = fp.readLine();
			if(line == null)
				break;
			else {
				String[] temp = line.split(":");
				synonyms.put(temp[0], temp[1]);
			}
				
		}
		if(MyLogger.getDebugValue() == DebugLevel.FROM_RESULTS)
			System.out.println("Synonyms.txt read and stored");
	}
	
	@Override
	public void visit(DSeaGateI product) {
		// TODO Auto-generated method stub
		String[] keys = keywords.split(" ");
		String key = keys[keys.length - 1];
		String temp = null;
		if(synonyms.containsKey(key)) {
			temp = synonyms.get(key);
			if(MyLogger.getDebugValue() == DebugLevel.IN_RUN)
				System.out.println("Match found for synonym : "+key+" = "+ temp);
		}
		else if(synonyms.containsValue(key)) {
			for(String s : synonyms.keySet()) {
				if(synonyms.get(s).equals(key))
					temp = s;
				if(MyLogger.getDebugValue() == DebugLevel.IN_RUN)
					System.out.println("Match found for synonym : "+key+" = "+ temp);
			}
		}
		if(temp!=null) {
			keys[keys.length - 1] = temp;
			String newKeywords = Arrays.toString(keys);
			newKeywords = newKeywords.substring(1,newKeywords.length()-1).replace(",", "");
			Helper.flag = 1;
			exact.setSearchKeywords(newKeywords);
			exact.visit(product);
			Helper.flag = 0;
		}
	}
}
