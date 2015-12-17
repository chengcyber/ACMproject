/**
 * CopyFile.java
 * ----------------------------
 * BufferedReader readfile and PrintWriter to the copy one.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;


public class CopyFile extends ConsoleProgram {
	
	
	
	public void run() {
		setFont("Courier-24");
		BufferedReader rd = openFile("Please enter filename: ");
		
		try {
			PrintWriter wr = new PrintWriter(new FileWriter("copy.txt"));
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				println("Cope line: [" + line + "]");
				wr.println(line);
			}
			rd.close();
			wr.close();
		} catch (IOException e) {
			throw new ErrorException(e);
		}		
		
	}
	
	
	/**
	 * open file with following parameters
	 * @param prompt is leading clienter to type filename
	 * @return rd
	 */
	private BufferedReader openFile(String prompt) {
		BufferedReader rd = null;

		while (rd == null) {
			try {
				String filename = readLine(prompt);
				rd = new BufferedReader(new FileReader(filename));
			} catch (IOException e) {
				println("That file doesn't exist.");
			}			
		}
		return rd;
	}
	
}
