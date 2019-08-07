package troubleShootSearch.visitor;

import troubleShootSearch.dSeaGate.DSeaGateI;
import troubleShootSearch.util.Helper;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

public class NaiveStemmingSearchVisitor implements Visitor {

	String keywords;
	
	/**
	 * Constructor
	 * @param no args
	 */
	public NaiveStemmingSearchVisitor() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: NaiveStemmingSearchVisitor created ");
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
	 * @Override
	 * method for implementing the visitor functionality
	 * 
	 * @param product = element which is being visited.
	 * @return void
	 */
	public void visit(DSeaGateI product) {
		// TODO Auto-generated method stub
		String[] s1 = keywords.split(" ");
		for(String s: product.getTechSentence()) {
			String[] array = s.split(" ");
			for(int i = 0; i < array.length ; i++) {
				String temp = array[i];
				if(temp.contains(s1[0])) {
				//print to output.txt
					Helper.write("Naive Stemming Match : " + product.toString() + " - " + s);
					if(MyLogger.getDebugValue() == DebugLevel.FROM_RESULTS)
						System.out.println("Naive match for "+keywords+" found\n" + product.toString() + " - " + s);
				}
			}
				
		}

	}
	
	/**
	 * toString() method
	 * 
	 * @param = no args
	 * @return = String
	 */
	public String toString() {
		return "NaiveStemmingSearchVisitor";
	}

}
