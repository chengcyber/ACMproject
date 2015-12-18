

import acm.program.*;
import java.util.*;
public class findLargestAndSecondLargest extends ConsoleProgram {
	
	public void run() {
		println("This program finds the two Largest integers in a list. Enter Values, one per line, using 0 to signal the end of list");
		
		input = readInt(" ? ");
		list.add(input);
		count++;
		while (input!=SENTINEL) {
			input = readInt(" ? ");
			list.add(input);
			count++;
			if ( input > large ) {
				large = input;
			} else if (input > slarge) {
				slarge = input;
			}
		}
		if (count<=2) {
			println("Not enough number.");
		} else {
			println("The largest number is " + large);
			println("The second largest number is " + slarge);
		}
		
	}
	
	
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private static final int SENTINEL = 0;
	private int count = 0;
	private int input = 0;
	private int large = 0;
	private int slarge = 0;
}
