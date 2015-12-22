package simpleCalc;

/*
 * This ClearButton class resets the calculator by setting the operator to null
 * and the display value to 0
 */

public class ClearButton extends CalculatorButton {
	public ClearButton() {
		super("C");
	}
	
	public void action(CalculatorDisplay display) {
//		display.setValue(0);
		
		/* the sequence is must setOperator first */
		display.setOperator(null);
		display.setValue(0);
	}
}
