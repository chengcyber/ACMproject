
import acm.program.*;

public class Palindrome extends ConsoleProgram {
	
	public void run() {
		println("The program check the string input is palindrome or not.");
		while (true) {
		String str = readLine("Enter a String:");
		if (str == null) break;
		if(isPalindrome(str)) {
			println(str + " is palindrome string!");
		} else {
			println("oh no , try again.");
		}
		}
	}
	
	private boolean isPalindrome(String str) {
//		println("one char is " + str.substring(0,1));
//		println("next str is " + str.substring(1,str.length()-1));
//		println("" + str.endsWith(str.substring(0, 1)));
		if( str.length() == 1) {
//			println("One character is always palindrome :)");
			return true;
		} else if(str.length() == 2) {
			return str.endsWith(str.substring(0,1));
		} else {
			return (str.endsWith(str.substring(0, 1)) && (isPalindrome(str.substring(1, str.length() - 1))));
		}
	}
	
}
