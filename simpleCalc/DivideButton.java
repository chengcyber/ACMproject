package simpleCalc;
/*
 * This Class DivideButton are the same except for their label and the implementation of apply.
 */

public class DivideButton extends OperatorButton {
	
	public DivideButton() {
		super("/");
	}
	
	public int apply(int lhs, int rhs) {
		return lhs / rhs;
	}
	
}
