package troubleShootSearch.visitor;

import troubleShootSearch.dSeaGate.DSeaGateI;
import troubleShootSearch.util.Helper;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

public class NaiveStemmingSearchVisitor implements Visitor {

	String keywords;
	public NaiveStemmingSearchVisitor() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: NaiveStemmingSearchVisitor created ");
	}
	
	public void setSearchKeywords(String line) {
		keywords = line;
	}
	
	@Override
	public void visit(DSeaGateI product) {
		// TODO Auto-generated method stub
		String[] s1 = keywords.split(" ");
		for(String s: product.getTechSentence()) {
			String[] array = s.split(" ");
			for(int i = 0; i < array.length ; i++) {
				String temp = array[i];
				if(temp.contains(s1[0]))
				//print to output.txt
				Helper.write("Naive Stemming Match : " + product.toString() + " - " + s);
			}
				
		}

	}

}
