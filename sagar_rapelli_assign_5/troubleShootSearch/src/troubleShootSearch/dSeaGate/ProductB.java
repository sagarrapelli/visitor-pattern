package troubleShootSearch.dSeaGate;

import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;

/**
 * @author sagarsmac
 *
 */
public class ProductB implements DSeaGateI {

	private static List<String> techSentence = new ArrayList<String>();
	
	/**
	 * 
	 */
	public ProductB() {
		// TODO Auto-generated constructor stub
	}
	
	public static void getTechSentence(FileProcessor fp) {
		Helper.getSentence(fp, "src/troubleShootSearch/dSeaGate/productB.txt", techSentence);
	}

	@Override
	public List<String> getTechSentence() {
		// TODO Auto-generated method stub
		return techSentence;
	}
}
