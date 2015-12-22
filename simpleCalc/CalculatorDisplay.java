package simpleCalc;

import java.awt.Font;

import acm.gui.IntField;

public class CalculatorDisplay extends IntField {

	public CalculatorDisplay() {
		setEditable(false);
		setFont(new Font("SansSerif", Font.PLAIN, 24));
		setValue(0);
		startNewValue = false;
		op = null;
	}
	
	/* add the value to display */
	public void addDight(int dight) {
		int value = (startNewValue) ? 0 : getValue();
		setValue( value * 10 + dight);
		startNewValue = false;
	}
	
	/* Sets a new operator */
	public void setOperator(OperatorButton button) {
		if (op == null) {
			memory = getValue();
		} else {
			memory = op.apply(memory, getValue());
			setValue(memory);
		}
		op = button;
		startNewValue = true;
	}
	
	/* private instance variables */
	private OperatorButton op;		// the last operator button pressed
	private int memory;				// the value to switch the operator is applied
	private boolean startNewValue;	// set after an operatorbutton is pressed to start a new value
}



