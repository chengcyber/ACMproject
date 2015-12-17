/**
 * File ScaffoldGame.java
 * -------------------
 * Scaffold game ,guess word ,eight wrong guesses game over. 
 */

import acm.program.*;
import acm.util.*;

public class HangmanGame extends ConsoleProgram {
	
	public void run() {
		setup();
		//initCanvas();
		while(isGameOver()) {
			
			char myGuess = readLine("Enter a character: ").charAt(0);
			while (!Character.isLetter(myGuess)) {
				println("Please input a character!");
				myGuess = readLine("Enter a character: ").charAt(0);
			}
			
			myGuess = Character.toUpperCase(myGuess);
			//println(myGuess);
			
			checkGuess(myGuess, myWord); 
			if (isCorrect(myGuess, myWord)) {
				println("Correct: " + result);
				
			} else { 
				
				println("Wrong: " + result);
				canvas.noteIncorrectGuess(myGuess);
				canvas.drawNext(lives);
				lives--;
			}
			canvas.displayWord(result);
			
			
			/* WIN */
			if (result.equals(myWord)) {
				println("Congurations!");
				break;
			}
		}
	}
	
	
	/* Initial Canvas */
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}
	
	
	/* check correct */
	private boolean isCorrect(char ch, String str) {
		for(int i=0;i<str.length();i++) {
			if (ch==str.charAt(i)){
				return true;
			} 		
		}
		return false;
	}
	
	/* check the input is correct */
	private void checkGuess(char ch,String str) {
		for(int i=0;i<str.length();i++) {
			if (ch==str.charAt(i)){
				result = result.substring(0,i) +  ch + result.substring(i+1);
			} 				
		}
	}
	
	/* Game Over or not */
	private boolean isGameOver() {
		if(lives == 0) {
			println("Bad Times.You are die.");
			canvas.displayWord("GAME OVER");
			return false;
		}
		println("Remain: " + lives);
		return true;
	}
	
	/* initial. the answer */
	private void setup() {
		myWord = hl.getWord(rg.nextInt(0,hl.getWordCount()-1));
		println(myWord);
		println("" + myWord.length());
		for (int i = 0;i < myWord.length();i++) {
			result += "-";
		}
		
		canvas.reset();
		
	}
	
	/* private instance variables */
	private String myWord;
	private String result = "";
	private HangmanLexicon hl = new HangmanLexiconMy();
	private RandomGenerator rg = RandomGenerator.getInstance();
	private int lives = 6 ;
	
	private HangmanCanvas canvas ;
}
