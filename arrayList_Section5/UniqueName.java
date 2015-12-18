package arrayList_Section5;

/**
 * Write a program that asks the user for a list of names (one per line) until the user enters a
 * blank line (i.e., just hits return when asked for a name). At that point the program should
 * print out the list of names entered, where each name is listed only once (i.e., uniquely) no
 * matter how many times the user entered the name in the program. You may find that
 * using an ArrayList to keep track of the names entered by user may greatly simplify this
 * problem. 
 */


import java.util.*;
import acm.program.*;


public class UniqueName extends ConsoleProgram {

	public void run() {
		sList = new ArrayList<String>();
		
		while (true) {
			String line = readLine("Enter name: ");
			if (line.equals(SENTINEL)) break;
			
			if (!sList.contains(line)) {
				sList.add(line);
			}			
		}
		
		/* print ArrayList */
		println("The name contains: ");
		for (int i=0;i<sList.size();i++) {
			println(sList.get(i));
		}
	}
	
	
	
//	/* openFile */
//	private BufferedReader openFile(String prompt) {
//		BufferedReader rd = null;
//		
//		while (rd == null) {
//			try {
//				String filename = readLine(prompt);
//				rd = new BufferedReader(new FileReader(filename));
//			} catch (IOException e) {
//				println("File doesn't exists.");
//			}
//		}
//		
//		return rd;
//	}
	
	/* CONSTANTS */
	private static final String SENTINEL = "";
	
	/* private instance variables */
	private ArrayList<String> sList ;
	
}
