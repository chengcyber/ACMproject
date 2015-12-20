/**
 * Translate input string to morse code.
 * @author Administrator
 *
 */

import java.util.*;

import acm.program.*;

public class TranslateMorseCode extends ConsoleProgram {

	public void run() {
		setup();
		println("This program tanslates a line into Morse Code.");
		
		while(true) {
			String line = readLine("Enter English text: ");
			if (line.equals(SENTINEL)) {
				break;
			}
			StringTokenizer token = new StringTokenizer(line);
			
			while(token.hasMoreTokens()){
				String morse = translateWordToMorse(token.nextToken());
				println(morse);
			}
			
		}
			println("Bye-bye.");
	}
	
	
	/* translate a word to MorseCod */
	private String translateWordToMorse(String str) {
		String result = "";
		for (int i=0; i < str.length(); i++) {
			char ch = Character.toUpperCase(str.charAt(i));
			result += translateCharToMorse(ch) + " ";
		}
		return result;
	}
	
	/* translate a UPPER CASE char to Morse Code */
	private String translateCharToMorse(char ch) {
		String result = "";
		if ( Character.isUpperCase(ch)) {
			result += morsecode.get(ch);
		}
		return result;
	}
	
	/* setup : initial the hashmap */
	private void setup() {
		/* setFont */
		setFont("Times New Roman-24");
		
		/* Hashmap for decode morsecod */
		morsecode = new HashMap<Character, String>();
		morsecode.put('A', ".-");
		morsecode.put('B', "-...");
		morsecode.put('C', "-.-.");
		morsecode.put('D', "-..");
		morsecode.put('E', ".");
		morsecode.put('F', "..-.");
		morsecode.put('G', "--.");
		morsecode.put('H', "....");
		morsecode.put('I', "..");
		morsecode.put('J', ".---");
		morsecode.put('K', "-.-");
		morsecode.put('L', ".-..");
		morsecode.put('M', "--");
		morsecode.put('N', "-.");
		morsecode.put('O', "---");
		morsecode.put('P', ".--.");
		morsecode.put('Q', "--.-");
		morsecode.put('R', ".-.");
		morsecode.put('S', "...");
		morsecode.put('T', "-");
		morsecode.put('U', "..-");
		morsecode.put('V', "...-");
		morsecode.put('W', ".--");
		morsecode.put('X', "-..-");
		morsecode.put('Y', "-.--");
		morsecode.put('Z', "--..");
	}
	
	/* CONSTANTS */
	private static final String SENTINEL = "";
	/* private instance variables */
	private Map<Character, String> morsecode;
	
	
}
