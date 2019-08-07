package troubleShootSearch.visitor;

import troubleShootSearch.dSeaGate.DSeaGateI;
import troubleShootSearch.util.Helper;

public class ExactSearchVisitor implements Visitor {

	String keywords;
	public ExactSearchVisitor() {	
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
					if (Helper.flag == 0)
						Helper.write("Exact Match : " + product.toString() + " " + s);
					else
						Helper.write("Semantic Match : " + product.toString() + " " + s);
				}
			}
		}
		
		
		
		/*if(sArray.length > 1)
			for(String s: product.getTechSentence()) {
				if(s.contains(keywords))
					Helper.write("Exact : " + s);
			}
		else {
			for(String s: product.getTechSentence()) {
				s = s.replaceAll(",", "");
				String[] array = s.split(" ");
				for(String temp: array)
				if(temp.equals(sArray[0]))
					//print to output.txt
					Helper.write(s);
			}
		}*/
	}

}
