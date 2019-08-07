package troubleShootSearch.util;

import java.util.List;

public class Helper {
	
	public static Results result = new Results();
	public static int flag = 0;
	
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
	
	public static void write(String s) {
		result.results = result.results + s + "\n";
	}
	
	public static Results getResult() {
		return result;
	}
	
}
