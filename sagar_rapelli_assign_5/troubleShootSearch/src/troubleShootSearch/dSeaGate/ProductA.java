package troubleShootSearch.dSeaGate;

import java.util.ArrayList;
import java.util.List;
import troubleShootSearch.visitor.Visitor;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * @author Sagar Rapelli
 *
 */
public class ProductA implements DSeaGateI{

	private static List<String> techSentence = new ArrayList<String>();
	
	/**
	 * Constructor
	 */
	public ProductA() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: ProductA created ");
	}
	
	/**
	 * static method for reading technical sentences from file.
	 * @param fp = FileProcessor object.
	 */
	public static void readTechSentence(FileProcessor fp) {
		Helper.getSentence(fp, "src/troubleShootSearch/dSeaGate/productA.txt", techSentence);
	}

	/**
	 * getter method for techSentence
	 */
	public List<String> getTechSentence() {
		// TODO Auto-generated method stub
		return techSentence;
	}
	
	/**
	 * method for accepting the visitors
	 * @param Visitor = the visitors.
	 */
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	/**
	 * toString() method
	 * @return String
	 */
	public String toString() {
		return "product A";
	}

}
