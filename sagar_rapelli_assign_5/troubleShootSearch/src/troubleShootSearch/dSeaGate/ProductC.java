package troubleShootSearch.dSeaGate;

import java.util.ArrayList;
import java.util.List;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;
import troubleShootSearch.visitor.Visitor;

public class ProductC implements DSeaGateI{

	private static List<String> techSentence = new ArrayList<String>();
	
	/**
	 * Constructor
	 */
	public ProductC() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: ProductC created ");
	}
	
	/**
	 * static method for reading technical sentences from file.
	 * @param fp = FileProcessor object.
	 */
	public static void readTechSentence(FileProcessor fp) {
		Helper.getSentence(fp, "src/troubleShootSearch/dSeaGate/productC.txt", techSentence);
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
		return "product C";
	}

}
