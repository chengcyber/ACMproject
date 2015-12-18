package arrayList_Section5;

/**
 * Write a program WordCount that reads a file and reports how many lines, words, and
 * characters appear in it
 * @author liu.cheng
 *
 */

import acm.program.*;
import java.util.*;
import java.io.*;

public class WordCount extends ConsoleProgram {
	
	public void run() {
		BufferedReader rd = openFile("File: ");
		strList = new ArrayList<String>();
		
		/* ArrayList to store contents */
		readFile(rd);
		
		/* print lines */
		countLines = getLines();
		/* print Words */
		countWords = getWords();
		/* print chars */
		countChars = getChars();
		
		/* print result counts */
		println("lines: " + countLines);
		println("words: " + countWords);
		println("Chars: " + countChars);
	}
	
	/* put file contents to strlist */
	private void readFile(BufferedReader rd) {
		try {
			while (true) {
				String str = rd.readLine();
				if (str == null) break;
				strList.add(str);
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	/* print lines */
	private int getLines() {
		return strList.size();
	} 
	
	/* print Words */
	private int getWords() {
		int count = 0;

		for (int i=0 ; i<strList.size(); i++) {
			String str = strList.get(i);
			StringTokenizer token = new StringTokenizer(str);
			count += token.countTokens();
		}
		return count;
	}
	
	/* print chars */
	private int getChars() {
		int count = 0;
		
		for (int i=0; i< strList.size(); i++) {
			String str = strList.get(i);
			for (int j=0;j<str.length();j++) {
				char ch = str.charAt(j);
				if (Character.isLetterOrDigit(ch)) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	/* openFile */
	private BufferedReader openFile(String prompt) {
		BufferedReader rd = null;
		
		while (rd == null) {
			try {
				String filename = readLine(prompt);
				rd = new BufferedReader(new FileReader(filename));
			} catch (IOException e) {
				println("File doesn't exists.");
			}
		}
		
		return rd;
	}
	
	
	/* private instance variables */
	private int countLines = 0;
	private int countWords = 0;
	private int countChars = 0;
	private ArrayList<String> strList;
	
}
