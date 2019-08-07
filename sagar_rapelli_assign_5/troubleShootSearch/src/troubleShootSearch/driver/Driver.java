package troubleShootSearch.driver;

import troubleShootSearch.dSeaGate.DSeaGateI;
import troubleShootSearch.dSeaGate.ProductA;
import troubleShootSearch.dSeaGate.ProductB;
import troubleShootSearch.dSeaGate.ProductC;
import troubleShootSearch.dSeaGate.ProductD;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;
import troubleShootSearch.visitor.ExactSearchVisitor;
import troubleShootSearch.visitor.NaiveStemmingSearchVisitor;
import troubleShootSearch.visitor.SemanticSearchVisitor;

/**
 * @author Sagar Rapelli
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}
		
		FileProcessor fp = new FileProcessor();
		
		ProductA.getTechSentence(fp);
		ProductB.getTechSentence(fp);
		ProductC.getTechSentence(fp);
		ProductD.getTechSentence(fp);
		SemanticSearchVisitor.getSynonyms(fp);
		
		
		
		
		//System.out.println("Hello World! Lets get started with the assignment");
		
		//System.out.println(Helper.output);
		
	}
}
