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
	
	/**
	 * Constructor
	 * @param no args
	 */
	public SemanticSearchVisitor() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: SemanticSearchVisitor created ");
		exact = new ExactSearchVisitor();
	}
	
	/**
	 * method for setting search keywords
	 * 
	 * @param line = keywords to be searched
	 */
	public void setSearchKeywords(String line) {
		keywords = line;
	}
	
	/**
	 * static method for reading synonyms from synonyms.txt
	 * 
	 * @param fp = FileProcessor object
	 */
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
	}
	
	/**
	 * @Override
	 * method for implementing the visitor functionality
	 * 
	 * @param product = element which is being visited.
	 * @return void
	 */
	public void visit(DSeaGateI product) {
		// TODO Auto-generated method stub
		String[] keys = keywords.split(" ");
		String key = keys[keys.length - 1];
		String temp = null;
		if(synonyms.containsKey(key)) {
			temp = synonyms.get(key);
		}
		else if(synonyms.containsValue(key)) {
			for(String s : synonyms.keySet()) {
				if(synonyms.get(s).equals(key)) {
					temp = s;
				}
			}
		}
		if(temp!=null) {
			keys[keys.length - 1] = temp;
			String newKeywords = Arrays.toString(keys);
			newKeywords = newKeywords.substring(1,newKeywords.length()-1).replace(",", "");
			Helper.flag = 1;
			exact.setSearchKeywords(newKeywords);
			exact.visit(product);
			if(exact.flag == 1) {
				if(MyLogger.getDebugValue() == DebugLevel.IN_RUN)
					System.out.println("Match found for synonym in "+ product.toString()+" : "+key+" = "+ temp);
				exact.flag = 0;
			}
			Helper.flag = 0;
		}
	}
	
	/**
	 * toString() method
	 * 
	 * @param = no args
	 * @return = String
	 */
	public String toString() {
		return "SemanticSearchVisitor";
	}
}
