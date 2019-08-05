package troubleShootSearch.visitor;

import troubleShootSearch.dSeaGate.DSeaGateI;

public class NaiveStemmingSearchVisitor extends SearchVisitor {

	public NaiveStemmingSearchVisitor(String input) {
		keywords = input ;
	}
	
	@Override
	public void visit(DSeaGateI product) {
		// TODO Auto-generated method stub
		String[] s1 = keywords.split(" ");
		for(String s: product.getTechSentence()) {
			String[] array = s.split(" ");
			for(String temp: array)
			if(temp.contains(s1[0]))
				//print to output.txt
				System.out.print("match");
		}

	}

}
