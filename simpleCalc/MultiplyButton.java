package simpleCalc;

/*
 * This Class MultiplyButton are the same except for their label and the implementation of apply.
 */

public class MultiplyButton extends OperatorButton {
	
	public MultiplyButton() {
		super("*");
	}
	
	public int apply(int lhs, int rhs) {
		return lhs * rhs;
	}
}
