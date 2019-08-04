package troubleShootSearch.dSeaGate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;

/**
 * @author Sagar Rapelli
 *
 */
public class ProductA {

	private static List<String> techSentence = new ArrayList<String>();
	
	public ProductA() {
		// TODO Auto-generated constructor stub
	}
	
	public static void getTechSentence(FileProcessor fp) {
		Helper.getSentence(fp, "productA.txt", techSentence);
	}
	
	

}
