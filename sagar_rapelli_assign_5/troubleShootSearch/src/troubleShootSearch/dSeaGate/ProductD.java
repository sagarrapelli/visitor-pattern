package troubleShootSearch.dSeaGate;

import java.util.ArrayList;
import java.util.List;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;
import troubleShootSearch.visitor.Visitor;

public class ProductD implements DSeaGateI{

	private static List<String> techSentence = new ArrayList<String>();
	
	public ProductD() {
		// TODO Auto-generated constructor stub
	}
	
	public static void getTechSentence(FileProcessor fp) {
		Helper.getSentence(fp, "src/troubleShootSearch/dSeaGate/productD.txt", techSentence);
	}

	@Override
	public List<String> getTechSentence() {
		// TODO Auto-generated method stub
		return techSentence;
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}

	public String toString() {
		return "product D";
	}

}