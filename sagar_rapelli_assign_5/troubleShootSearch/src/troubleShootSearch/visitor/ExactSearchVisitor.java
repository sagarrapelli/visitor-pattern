package troubleShootSearch.visitor;

import troubleShootSearch.dSeaGate.DSeaGateI;
import troubleShootSearch.util.Helper;

public class ExactSearchVisitor extends SearchVisitor {

	public ExactSearchVisitor(String input) {
		keywords = input;
	}
	
	@Override
	public void visit(DSeaGateI product) {
		// TODO Auto-generated method stub
		for(String s: product.getTechSentence()) {
			if(s.contains(keywords))
				Helper.write(s);
				//System.out.print("match");
		}
	}

}
