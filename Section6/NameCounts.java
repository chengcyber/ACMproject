package Section6;

/**
 * Write a program that asks the user for a list of names (one per line) until the user enters a
 * blank line (i.e., just hits return when asked for a name). At that point the program should
 * print out how many times each name in the list was entered. You may find that using a
 * HashMap to keep track of the information entered by user may greatly simplify this
 * problem. 
 * @author liu.cheng
 *
 */

import acm.program.*;
import java.util.*;

public class NameCounts extends ConsoleProgram {
	
	public void run() {
		
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<Integer> timeList = new ArrayList<Integer>();
		
		while(true) {
			String name = readLine("Enter a name: ");
			if (name.equals(SENTINEL)) break;
			if (nameList.contains(name)) {
				int index = nameList.indexOf(name);
				timeList.set(index, timeList.get(index) + 1);
			} else {
				nameList.add(name);
				timeList.add(1);
			}
		}
		
		for(int i=0;i<nameList.size();i++) {
			println(nameList.get(i) + " counts " + timeList.get(i));
		}
		
	}
	
	/* CONSTANTS */
	private static final String SENTINEL = ""; 
}
