/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */
import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexiconMy extends HangmanLexicon{
	
	//constructor
	public HangmanLexiconMy() {
		BufferedReader rd = openFile("Lexico.txt");
		
		try {
			while (true) {
				String line = rd.readLine();
				list.add(line);
				count++;
				if ( line == null) break;
			}
			rd.close(); 
		}catch (Exception e) {
				e.printStackTrace();
			}			
		
		
	}
	
	public String getWord(int index) {
		return list.get(index);
	}
	
	public int getWordCount() {
		return count;
	}
	
	/* openFile */
	private BufferedReader openFile(String url) {
		BufferedReader rd = null;
		
		while(rd == null){
			
			try {
				rd = new BufferedReader(new FileReader(url));
			} catch (IOException e) {
				e.printStackTrace();
			}			
			
		}
		
		return rd;
	}
	
	/* private instance variables */
	private int count=0;
	private ArrayList<String> list = new ArrayList<String>();
}
