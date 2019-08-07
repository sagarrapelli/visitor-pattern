package troubleShootSearch.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import troubleShootSearch.util.MyLogger.DebugLevel;

public class FileProcessor {
	private File file;
	private Scanner sc;
	
	/**
	 * no arg constructor
	 * 
	 */
	public FileProcessor() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: FileProcessor obj created");
	}
	
	/**
	 * constructor to set input file.
	 *
	 * @param String filename
	 */
	public void openFile(String filename) {
		try {
			file = new File(filename);
			sc = new Scanner(file);
		}
		catch(FileNotFoundException fn) {
			System.out.println("File not found");
			fn.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * method for reading one line from input file.
	 * ref = "https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html"
	 *
	 * @param no args
	 */
	public String readLine() {
		if(sc.hasNextLine())
			return sc.nextLine();
		else
			return null;
	}
	
	/**
	 * toString method
	 * 
	 */
	public String toString() {
		return "File processor";
	}
}
