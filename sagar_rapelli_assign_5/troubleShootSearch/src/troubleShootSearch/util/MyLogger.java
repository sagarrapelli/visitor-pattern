package troubleShootSearch.util;

public class MyLogger{

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime everytime match found from synonyms.txt and Semantic search is also found]
      DEBUG_VALUE=2 [No output should be printed from the application to stdout. It is OK to write to the output file though]
      DEBUG_VALUE=1 [Print to stdout everytime searches are found]
      DEBUG_VALUE=0 [Print to stdout the error messages only]
    */

    public static enum DebugLevel {RELEASE, FROM_RESULTS, IN_RESULTS, IN_RUN, CONSTRUCTOR
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; 
	  		  	writeMessage("Logger Value 4 :- Printing everytime constructor is called", debugLevel);
	  			break;
	  
	  case 3: debugLevel = DebugLevel.IN_RUN; 
		writeMessage("Logger Value 3 :- Print everytime match found from synonyms.txt and Semantic search is also found", debugLevel);
		break;

	  case 2: debugLevel = DebugLevel.IN_RESULTS; 
		break;

	  case 1: debugLevel = DebugLevel.FROM_RESULTS;
		writeMessage("Logger Value 1 :- Printing to std output the search results", debugLevel);
		break;
	      
	  case 0: debugLevel = DebugLevel.RELEASE; 
	  writeMessage("Logger Value 0 :- Printing to std output the error messages, and no output will be written to outputfile", debugLevel);
		break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {

	if (levelIn == debugLevel)
	    System.out.println(message+"\n");
    }
    
    public static DebugLevel getDebugValue () {
    	return debugLevel;
    }

    /**
	 * @return String
	 */
    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
