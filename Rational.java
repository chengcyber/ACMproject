/** File:Rational.jva
 *  Class for Rational Number,
 *  Rational Number will preprocess by gcd method,
 *  implement add subtract multipy divide toString.
 *  
 *  */

import acm.util.*;

/** The Rational Class is used to represent rational numbers, which are defined to be the quotient of two integers.
 *  */

public class Rational {
	
	/**
	 * Create Rational default zero( 0/1 ) 
	 * */
	public Rational() {
		this(0);
	}
	
	/** 
	 * Create Rational default n/1
	 * */
	public Rational(int n) {
		this(n,1);
	}
	
	/** 
	 * Create Rational from the two integers
	 * */
	public Rational(int x,int y) {
		if (y==0) throw new ErrorException("Division by 0");
		int g = gcd(Math.abs(x), Math.abs(y));
		num = x / g;
		den = Math.abs(y) / g;
		if (y < 0) num = -num;
	}
	
	/**
	 * Method gcd  to find the greatest common divison by two integers. 
	 * */
	private int gcd(int x, int y) {
		int r = x % y ;
		while (r != 0) {
			x = y;
			y = r;
			r = x % y;
		}
		return y ;
		
	}
	
	
	/** 
	 *  Method add two integers.
	 *  */
	public Rational add(Rational r) {
			return new Rational((this.num * r.den + r.num * this.den ),(this.den * r.den));
	}
	
	
	/** 
	 *  Method ToString to convert Rational number as String datatype.
	 *  */
	public String toString() {
		if (den == 1) {
			return "" + num;
		} else {
			return num + "/" + den;
		}
	}
	
	/* private instance variable */
	private int num;
	private int den;

}
