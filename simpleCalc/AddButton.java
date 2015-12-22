package simpleCalc;

/*
 * This Class AddButton are the same except for their label and the implementation of apply.
 */

public class AddButton extends OperatorButton {
	
	public AddButton() {
		super("+");
	}
	public int apply(int lhs, int rhs) {
		return lhs + rhs;
	}
	
}
