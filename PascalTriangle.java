import acm.graphics.*;
import acm.program.*;
import java.lang.String;

public class PascalTriangle extends GraphicsProgram {


//	
//	//run
//	
	private int panelwidth;
//	
	public void run() {
		panelwidth = this.getWidth();
		for (int i=0;i<8;i++) {
			for (int j=0;j<=i;j++) {
				drawCom(i,j);	
			}	
		}
	}
	
	private void drawCom(int i,int j) {
		GLabel label = new GLabel(Integer.toString(combinations(i,j)));
		add(label,(panelwidth-(i*25))/2+25*j,20*i+20);
	}

	
	//combinations n for k    C(n,k)
	private int combinations(int n,int k) {
		return factorial(n)/( factorial(k) * factorial(n-k) );
	}
	
	private int factorial(int n) {
		int result = 1;
		for (int i=1;i<=n;i++) {
			result *= i;
		}
		return result;
	}
}
