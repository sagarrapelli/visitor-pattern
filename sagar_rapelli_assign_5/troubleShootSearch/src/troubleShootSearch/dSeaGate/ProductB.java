package troubleShootSearch.dSeaGate;

import java.util.ArrayList;
import java.util.List;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;
import troubleShootSearch.visitor.Visitor;

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
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: ProductB created ");
	}
	
	public static void readTechSentence(FileProcessor fp) {
		Helper.getSentence(fp, "src/troubleShootSearch/dSeaGate/productB.txt", techSentence);
		if(MyLogger.getDebugValue() == DebugLevel.FROM_RESULTS)
			System.out.println("Technical sentences for product B read");
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
		return "product B";
	}

	
}
