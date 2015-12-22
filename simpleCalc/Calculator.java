package simpleCalc;
/**
 * simple calculator implement with self-build CalculatorDisplay Class
 * and CalculateButton hierarchy. 
 * layout with TableLayout(5,4)
 */


import acm.program.*;
import acm.gui.*;
import java.awt.event.*;

public class Calculator extends Program {

	public void init() {
		setLayout(new TableLayout(5,4));
		display = new CalculatorDisplay();
		add(display, "gridwidth=4 height=" + BUTTON_SIZE );
		addButtons();
		addActionListeners();
	}
	
	
	/* add all buttons */
	private void addButtons() {
		String constraint = "width=" + BUTTON_SIZE + " height=" + BUTTON_SIZE;
		add(new DightButton(7), constraint);
		add(new DightButton(8), constraint);
		add(new DightButton(9), constraint);
		add(new AddButton(), constraint);
		add(new DightButton(4), constraint);
		add(new DightButton(5), constraint);
		add(new DightButton(6), constraint);
		add(new SubtractButton(), constraint);
		add(new DightButton(1), constraint);
		add(new DightButton(2), constraint);
		add(new DightButton(3), constraint);
		add(new MultiplyButton(), constraint);
		add(new ClearButton(), constraint);
		add(new DightButton(0), constraint);
		add(new EqualsButton(), constraint);
		add(new DivideButton(), constraint);
	}
	
	/* Call whenver clicked the buttons */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		// check is CalculatorButton or not
		if(source instanceof CalculatorButton) {
			((CalculatorButton) source).action(display);
		}
	}
	
	/* CONSTANTS */
	private static final int BUTTON_SIZE = 60;
	
	/* Private instance variables */
	private CalculatorDisplay display;
}



