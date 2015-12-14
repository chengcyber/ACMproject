import acm.graphics.*;
import acm.program.*;
//import Rational.*;

public class test  extends ConsoleProgram {

	public void run () {
			Rational a = new Rational(1,2);
			Rational b = new Rational(1,3);
			Rational c = new Rational(1,6);
			Rational sum = a.add(b).add(c);
			println(a.toString() + " + " + b.toString() + " + " + c.toString() + " = " + sum.toString());
		}
	
}
