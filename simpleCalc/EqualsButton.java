package simpleCalc;

/*
 * This EqualsButton class displays the current value. As it happens, this operation
 * can be implemented simply by setting the operator to null.
 */

public class EqualsButton extends CalculatorButton {
	
	public EqualsButton() {
		super("=");
	}
	
	public void action(CalculatorDisplay display) {
		display.setOperator(null);
	}

}
