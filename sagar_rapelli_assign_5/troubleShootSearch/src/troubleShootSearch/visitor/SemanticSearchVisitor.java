package troubleShootSearch.visitor;

import java.util.HashMap;

import troubleShootSearch.dSeaGate.DSeaGateI;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;

public class SemanticSearchVisitor extends SearchVisitor {

	private static HashMap<String, String> synonyms = new HashMap<String, String>();
	
	public SemanticSearchVisitor(String input) {
		keywords = input;
	}
	
	public static void getSynonyms(FileProcessor fp) {
		fp.openFile("src/troubleShootSearch/visitor/synonyms.txt");
		String line;
		while(true) {
			line = fp.readLine();
			if(line == null)
				break;
			else {
				String[] temp = line.split(",");
				synonyms.put(temp[0], temp[1]);
			}
				
		}
	}
	
	@Override
	public void visit(DSeaGateI product) {
		// TODO Auto-generated method stub
		String[] keys = keywords.split(" ");
		String key = keys[keys.length - 1];
		String temp = null;
		if(synonyms.containsKey(key))
			temp = synonyms.get(key);
		else if(synonyms.containsValue(key)) {
			for(String s : synonyms.keySet()) {
				if(synonyms.get(s).equals(key))
					temp = s;
			}
		}
		if(temp!=null) {
			keys[keys.length - 1] = temp;
			keywords = keys.toString();
			for(String s: product.getTechSentence()) {
				if(s.contains(keywords))
					//print to output.txt
					Helper.write(s);
					System.out.print("match");
			}
		}
	}
}
