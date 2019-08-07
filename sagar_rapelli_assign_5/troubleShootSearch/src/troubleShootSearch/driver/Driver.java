package troubleShootSearch.driver;

import troubleShootSearch.dSeaGate.DSeaGateI;
import troubleShootSearch.dSeaGate.ProductA;
import troubleShootSearch.dSeaGate.ProductB;
import troubleShootSearch.dSeaGate.ProductC;
import troubleShootSearch.dSeaGate.ProductD;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.Helper;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger.DebugLevel;
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
		if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 3 argumnets.");
			System.exit(0);
		}
		
		MyLogger.setDebugValue(Integer.parseInt(args[2]));
		FileProcessor fp = new FileProcessor();
		
		ProductA.readTechSentence(fp);
		ProductB.readTechSentence(fp);
		ProductC.readTechSentence(fp);
		ProductD.readTechSentence(fp);
		SemanticSearchVisitor.readSynonyms(fp);
		
		DSeaGateI a = new ProductA();
		DSeaGateI b = new ProductB();
		DSeaGateI c = new ProductC();
		DSeaGateI d = new ProductD();
		
		ExactSearchVisitor exactSearch = new ExactSearchVisitor();
		NaiveStemmingSearchVisitor naiveSearch = new NaiveStemmingSearchVisitor();
		SemanticSearchVisitor semanticSearch = new SemanticSearchVisitor();
		
		
		fp.openFile(args[0]);
		String line;
		while(true) {
			line = fp.readLine();
			if(line == null)
				break;
			else {
				Helper.write("keywords - " + line + "\n");
				exactSearch.setSearchKeywords(line);
				naiveSearch.setSearchKeywords(line);
				semanticSearch.setSearchKeywords(line);
				
				a.accept(exactSearch);
				b.accept(exactSearch);
				c.accept(exactSearch);
				d.accept(exactSearch);
				
				a.accept(naiveSearch);
				b.accept(naiveSearch);
				c.accept(naiveSearch);
				d.accept(naiveSearch);
				
				a.accept(semanticSearch);
				b.accept(semanticSearch);
				c.accept(semanticSearch);
				d.accept(semanticSearch);
				Helper.write(" \n");
			}
				
		}
		
		
		Results result = Helper.getResult();
		if(MyLogger.getDebugValue() == DebugLevel.RELEASE)
			result.writeToFile(args[1]);
		
	}
}
