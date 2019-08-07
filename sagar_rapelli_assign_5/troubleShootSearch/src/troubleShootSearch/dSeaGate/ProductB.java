package troubleShootSearch.dSeaGate;

import java.util.ArrayList;
import java.util.List;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;
import troubleShootSearch.visitor.Visitor;

/**
 * @author Sagar Rapelli
 *
 */
public class ProductB implements DSeaGateI {

	private static List<String> techSentence = new ArrayList<String>();
	
	/**
	 * Constructor
	 */
	public ProductB() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: ProductB created ");
	}
	
	/**
	 * static method for reading technical sentences from file.
	 * @param fp = FileProcessor object.
	 */
	public static void readTechSentence(FileProcessor fp) {
		Helper.getSentence(fp, "src/troubleShootSearch/dSeaGate/productB.txt", techSentence);
		if(MyLogger.getDebugValue() == DebugLevel.FROM_RESULTS)
			System.out.println("Technical sentences for product B read");
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
		return "product B";
	}

	
}
