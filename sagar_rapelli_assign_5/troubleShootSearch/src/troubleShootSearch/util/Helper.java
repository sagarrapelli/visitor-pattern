package troubleShootSearch.util;

import java.util.List;

/**
 * @author Sagar Rapelli
 *
 */
public class Helper {
	
	public static Results result = new Results();
	public static int flag = 0;
	
	/**
	 * static method for reading techSentences from files
	 * @param fp = FileProccesor obj
	 * @param fileName = name of file to be read
	 * @param l = list to store contents read
	 */
	public static void getSentence(FileProcessor fp, String fileName, List<String> l) {
		fp.openFile(fileName);
		String line;
		while(true) {
			line = fp.readLine();
			if(line == null)
				break;
			else
				l.add(line);
		}
	}
	
	/**
	 * static method for storing results
	 * @param s = String to be stored.
	 */
	public static void write(String s) {
		result.results = result.results + s + "\n";
	}
	
	/**
	 * getter for result
	 * @return Results object
	 */
	public static Results getResult() {
		return result;
	}
	
}
