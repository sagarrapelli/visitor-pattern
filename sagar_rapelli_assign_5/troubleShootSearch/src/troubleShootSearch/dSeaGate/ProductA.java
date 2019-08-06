package troubleShootSearch.dSeaGate;

import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;

/**
 * @author Sagar Rapelli
 *
 */
public class ProductA implements DSeaGateI{

	private static List<String> techSentence = new ArrayList<String>();
	
	public ProductA() {
		// TODO Auto-generated constructor stub
	}
	
	public static void getTechSentence(FileProcessor fp) {
		Helper.getSentence(fp, "src/troubleShootSearch/dSeaGate/productA.txt", techSentence);
	}

	@Override
	public List<String> getTechSentence() {
		// TODO Auto-generated method stub
		return techSentence;
	}
	

}
