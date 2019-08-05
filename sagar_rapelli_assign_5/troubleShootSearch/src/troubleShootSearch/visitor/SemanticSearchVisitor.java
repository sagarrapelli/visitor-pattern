package troubleShootSearch.visitor;

import java.util.HashMap;

import troubleShootSearch.dSeaGate.DSeaGateI;
import troubleShootSearch.util.FileProcessor;

public class SemanticSearchVisitor extends SearchVisitor {

	private static HashMap<String, String> synonyms = new HashMap<String, String>();
	
	public SemanticSearchVisitor(String input) {
		keywords = input;
	}
	
	public static void getTechSentence(FileProcessor fp) {
		fp.openFile("synonyms.txt");
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
		String[] s1 = keywords.split(" ");
	}
	

}
