/**
 * 
 * @author liu.cheng
 * Example for opening file
 */


import acm.program.*;
import acm.util.*;
import java.io.*;
//import java.util.*;

public class AnotherFileExample extends ConsoleProgram{

	@Override
	public void run() {
		setFont("Courier-24");
		BufferedReader rd = openFile("Please enter filename: ");
		
		
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				println("Readline: [" + line + " ]");
			}
			rd.close();
		} catch (IOException e) {
			// TODO: handle exception
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
