# CSX42: Assignment 5
## Name: Sagar Rapelli

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in troubleShootSearch/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile troubleShootSearch/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile troubleShootSearch/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile troubleShootSearch/src/build.xml run -Darg0=<userInputs.txt> -Darg1=<output.txt> -Darg2=<MyLogger-value> 

Example:

The last argument is the Logger value. 
ant -buildfile troubleShootSearch/src/build.xml run -Darg0=userInputs.txt -Darg1=output.txt -Darg2=0



-----------------------------------------------------------------------
## Description:

The data structures used for storing the technical sentences is ArrayList. Time Complexity of ArrayList is O(n).
  The technical sentences are stored in the following files for the products
  Product A = productA.txt location = "src/troubleShootSearch/dSeaGate/productA.txt"
  Product B = productB.txt location = "src/troubleShootSearch/dSeaGate/productB.txt"
  Product C = productC.txt location = "src/troubleShootSearch/dSeaGate/productC.txt"
  Product D = productD.txt location = "src/troubleShootSearch/dSeaGate/productD.txt"
The location of the files is hardcoded in the program.


The data structure used for storing synonyms is HashMap. 'synonyms.txt' is located in "src/troubleShootSearch/visitor/synonyms.txt".


The time complexity of Exact Search and Semantic Search is O(n^2).
The time complexity of Naive Search is O(n).
	-where n is number of letters in technical sentence.


Note :- Whenever there will be an exact match then there will also be a Naive match as every string is substring of itself.



MyLogger has been implemented as follows

	  DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime everytime match found from synonyms.txt and Semantic search is also found]
      DEBUG_VALUE=2 [No output printed from the application to stdout. It is written to the output file though]
      DEBUG_VALUE=1 [Print to stdout everytime searches are found]
      DEBUG_VALUE=0 [Print to stdout the error messages only]



The method for reading from file i.e. readLine() in FileProcessor.java 
has been implemented by using reference from
"https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html"


The method for writing to file i.e. writeToFile() in Results.java 
has been implemented by using reference from
"https://docs.oracle.com/javase/8/docs/api/index.html?java/io/FileWriter.html"


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 08/05/19


