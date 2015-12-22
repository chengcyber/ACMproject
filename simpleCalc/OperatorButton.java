package simpleCalc;

/*
 * this abstract class is the superclass of the various operator buttons.
 * Each concrete subclass must override the apply method.
 */

public abstract class OperatorButton extends CalculatorButton {

	
	/* Create a new OperatorButton with the specified name. */
	public OperatorButton(String name) {
		super(name);
	}
	
	
	/* Informs the display that this operator button has been clicked */
	public void action(CalculatorDisplay display) {
		display.setOperator(this);
	}
	
	/* Applies this operator (every subclass must implement this method) */
	public abstract int apply(int lhs, int rhs);
	
}
