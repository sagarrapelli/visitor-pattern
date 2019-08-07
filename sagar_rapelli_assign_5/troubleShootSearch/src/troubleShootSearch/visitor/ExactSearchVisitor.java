package troubleShootSearch.visitor;

import troubleShootSearch.dSeaGate.DSeaGateI;
import troubleShootSearch.util.Helper;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

public class ExactSearchVisitor implements Visitor {

	String keywords;
	int flag = 0;
	/**
	 * Constructor
	 * @param no args
	 */
	public ExactSearchVisitor() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: ExactSearchVisitor created ");
	}
	
	/**
	 * method for setting search keywords
	 * 
	 * @param line = keywords to be searched
	 */
	public void setSearchKeywords(String line) {
		keywords = line;
	}
	
	@Override
	/**
	 * @Override
	 * method for implementing the visitor functionality
	 * 
	 * @param product = element which is being visited.
	 * @return void
	 */
	public void visit(DSeaGateI product) {
		
		String[] sArray = keywords.split(" ");
		
		for(String s: product.getTechSentence()) {
			int c = 0;
			String snew = s.replaceAll(",", "");
			String[] ss = snew.split(" ");
			
			for(int i = 0 ; i < sArray.length ; i++) {
				for(String temp: ss) {
					if(temp.replace(".","").equals(sArray[i]))
						c++;
				}
			}
			
			if(sArray.length <= c) {
				if(snew.contains(keywords)) {
					if (Helper.flag == 0) {
						Helper.write("("+product.toString() + ") - " + s);
						if(MyLogger.getDebugValue() == DebugLevel.FROM_RESULTS)
							System.out.println("Exact match found\n" + product.toString() + " - " + s);
					}
					else {
						Helper.write("("+product.toString() + ") - " + s);
						if(MyLogger.getDebugValue() == DebugLevel.FROM_RESULTS)
							System.out.println("Semantic match found\n" + product.toString() + " - " + s);
						flag = 1;
					}
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
		return "ExactSearchVisitor";
	}

}
