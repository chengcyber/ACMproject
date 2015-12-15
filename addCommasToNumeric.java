/**
 * add Commas to numeric string, 1000000 -> 1,000,000.
 * @author liu.cheng
 *
 */

import acm.program.*;

public class addCommasToNumeric extends ConsoleProgram {

	
	private String addCommasToNumericString(String str) {
		String result = "";
		int position = 0;
		
		position = str.length() % 3 ;
		
		for(int i=0; i < str.length() ; i++) {
			char ch = str.charAt(i);
			
			if (i%3 == position) {
				result += "," ;
			}
			
			result += ch;
		}
		
		result = correctFirstCommas(result);
		
		return result;
	}
	
	private String correctFirstCommas(String str) {
		//String result = str;
		if ( str.startsWith(",")) {
			str = str.substring(1);
		}
		return str;
	}
	
	public void run() {
		while(true) {
			String digits = readLine("Enter a numeric string: ");
			if (digits.length() == 0) break;
			println(addCommasToNumericString(digits));
		}
	}
	
	
}
