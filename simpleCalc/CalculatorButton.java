package simpleCalc;

/**
 * this abstract class is the superclass for ever calculator button. Every button
 * must define an action method, which is called whenever the button is clicked.
 */

import java.awt.Font;
import javax.swing.JButton;

public abstract class CalculatorButton extends JButton {

	
	/* Creates a new CalculatorButton with the specified name */
	public CalculatorButton(String name) {
		super(name);
		setFont(new Font("SansSerif", Font.PLAIN, 24));
	}
	
	/* Called when the button is clicked ( every subclass must implement this method) */
	public abstract void action(CalculatorDisplay display);
	
}
