package troubleShootSearch.util;

import java.util.List;

public class Helper {
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
}
