package troubleShootSearch.visitor;

import troubleShootSearch.dSeaGate.DSeaGateI;

public class ExactSearchVisitor extends SearchVisitor {

	public ExactSearchVisitor(String input) {
		keywords = input;
	}
	
	@Override
	public void visit(DSeaGateI product) {
		// TODO Auto-generated method stub
		for(String s: product.getTechSentence()) {
			if(s.contains(keywords))
				//print to output.txt
				System.out.print("match");
		}
	}

}
