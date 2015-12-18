package arrayList_Section5;

/**
 * Write a program that reads a list of exam scores from the file
 * MidtermScores.txt (which contains one score per line) and
 * then displays a histogram of those numbers, divided into the
 * ranges 0¨C9, 10¨C19, 20¨C29, and so forth, up to the range
 * containing only the value 100. 
 * @author liu.cheng
 *
 */

import java.io.*;

import acm.program.*;
import java.util.*;

public class Histograms extends ConsoleProgram {

	public void run() {
		BufferedReader rd = openFile("File: ");
		Scanner sc = new Scanner(rd);
		intList = new ArrayList<Integer>();
		
		/* put all scores into intList */
		while (sc.hasNextInt()) {
			int score = sc.nextInt();
			intList.add(score);			
		}

		/* show intList size */
		println("Stu number: " + intList.size());
		
		/* show histograms */
		for(int i=0;i<intList.size();i++) {
			int x = intList.get(i);
			growup(x);
		}
		
//		println("0-9: " + printStars(s0));
//		println("10-19: " + printStars(s1));
//		println("20-29: " + printStars(s2));
//		println("30-39: " + printStars(s3));
//		println("40-49: " + printStars(s4));
//		println("50-59: " + printStars(s5));
//		println("60-69: " + printStars(s6));
//		println("70-79: " + printStars(s7));
//		println("80-89: " + printStars(s8));
//		println("90-99: " + printStars(s9));
//		println("100: " + printStars(s10));
		
		for(int j=0;j <= 10 ; j++) {
			switch (j) {
			case 10 : println("100: " + printStars(scArr[j])); break;
			default : println( j+"0 - " + j + "9: " + printStars(scArr[j])); break;
			}
		}
		
		try {
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/* print  certan stars */
	private String printStars(int x) {
		String str ="";
		for(int i=0;i < x;i++) {
			str += "*";
		}
		return str;
	}
	
	/* count the number of level */
	private void growup(int x) {
		int y = x / 10;
		scArr[y]++;
		//println(y);
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
	private ArrayList<Integer> intList;
	private int[] scArr = new int[11];
}
