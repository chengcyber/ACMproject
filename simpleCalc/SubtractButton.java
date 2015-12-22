package simpleCalc;
/*
 * This Class SubtarctButton are the same except for their label and the implementation of apply.
 */

public class SubtractButton extends OperatorButton {
	
	public SubtractButton() {
		super("-");
	}
	
	public int apply(int lhs, int rhs) {
		return lhs - rhs;
	}
}
