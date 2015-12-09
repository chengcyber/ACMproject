import acm.program.*;

public class SolveEquation extends ConsoleProgram {
	public void run() {
		println("Solve the equations: ax^2 + bx + c = 0");
		int a = readInt("Input integer a:");
		int b = readInt("Input integer b:");
		int c = readInt("Input integer c:");
		if ( delta(a,b,c)>0 ) {
			println("x1 = " + solvex(a,b,c,0));
			println("x2 = " + solvex(a,b,c,1));
		} else if (delta(a,b,c)<0) {
			println("Error");
		} else {
			println("only x = " + solvex(a,b,c,0));
		}
		
	}
	
	private double solvex(int a,int b,int c,int d) {
		if ( d==0 ) {
			return ( -b + Math.sqrt(delta(a,b,c)) ) / 2 / a;
		} else {
			return ( -b - Math.sqrt(delta(a,b,c)) ) / 2 / a;
		}
				
	}
	
	private double delta(int a , int b , int c) {
		return (double)b * b - 4 * a * c;
	}
		
	
}
