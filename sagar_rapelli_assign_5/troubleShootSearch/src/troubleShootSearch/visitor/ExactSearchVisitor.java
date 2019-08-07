package troubleShootSearch.visitor;

import troubleShootSearch.dSeaGate.DSeaGateI;
import troubleShootSearch.util.Helper;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

public class ExactSearchVisitor implements Visitor {

	String keywords;
	public ExactSearchVisitor() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: ExactSearchVisitor created ");
	}
	
	public void setSearchKeywords(String line) {
		keywords = line;
	}
	
	@Override
	public void visit(DSeaGateI product) {
		// TODO Auto-generated method stub
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
						Helper.write("Exact Match : " + product.toString() + " - " + s);
						if(MyLogger.getDebugValue() == DebugLevel.IN_RESULTS)
							System.out.println("Exact match for "+keywords+" found\n" + product.toString() + " - " + s);
					}
					else
						Helper.write("Semantic Match : " + product.toString() + " - " + s);
				}
			}
		}
		
	}

}
