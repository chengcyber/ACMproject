/** 
 * File MyCaesarCipher.java
 * @author liu.cheng
 * implement Caesar Cipher Encryption, by rorate the alphic n letter
 */

import acm.program.*;

public class MyCaesarCipher extends ConsoleProgram {
	
	/**
	 * encrpytion str rotate every char n letter
	 * @param str plaintext
	 * @param caesar key 
	 * @return ciphertext
	 */
	private String encryptCaesar(String str, int key) {
		
		/*
		 * if key is negative , the key equals to 26 add key , i.e.  -3 equals 23
		 * mod math consider the key less than -26
		 */
		if (key < 0) {
			key = 26 - (-key % 26);
		}
		
		String result = "" ;
		for(int i=0; i < str.length(); i++) {
			char ch = str.charAt(i);
			result += encryptChar(ch, key);
		}
		
		return result; 
	}
	
	
	/**
	 * 
	 * @param ch every char in plaintext
	 * @param key caesar key
	 * @return cipher char
	 */
	private char encryptChar(char ch, int key) {
		
		if (Character.isUpperCase(ch)){
			
			/* mod math consider the key larger than 26 */
			return  ( (char)('A' + (ch - 'A' + key) % 26) );
		}
		return ch;
	}
	
	
	public void run() {
		println("This program uses a Caesar cipher for encryption.");
		int key = readInt("Enter encryption key: ");
		String plaintext = readLine("Plaintext: ");
		String ciphertext = encryptCaesar(plaintext, key);
		println("Ciphertext: " + ciphertext);
		
		/* decryption */
		String newplaintext = encryptCaesar(ciphertext, -key);
		println("Newplaintext: " + newplaintext);
	}

}
