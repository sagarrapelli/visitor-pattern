package troubleShootSearch.util;

import java.io.FileWriter;
import troubleShootSearch.util.MyLogger.DebugLevel;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	private FileWriter fileWriter;
	//data member for storing results.
	public String results = "";
	
	/**
	 * no args constructor
	 *
	 */
	public Results() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: Results created ");
	}
	
	/**
	 * constructor
	 *
	 * @param String filename
	 */
	public Results(String name) {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: Results created ");
		try {
		fileWriter = new FileWriter(name);
		}
		catch(Exception e) {
			System.err.println("Error in creating file");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	/**
	 * method for writing to file using FileWriter.
	 * ref = "https://docs.oracle.com/javase/8/docs/api/index.html?java/io/FileWriter.html"
	 *
	 * @param String
	 */
	public void writeToFile(String s) {
		try {
			fileWriter = new FileWriter(s);
			
				fileWriter.write(results);
			
			fileWriter.close();
		}
		catch(Exception e){
			System.err.println("Error: In writeToFile method");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	/**
	 * method for writing to console.
	 *
	 * @param String
	 */
	public void writeToStdOut(String s) {
		System.out.print(s);
	}
	
	
	/**
	 * toString method
	 * 
	 */
	public String toString() {
		return results;
	}
}
