package simpleCalc;

/*
 * This class is used for each of the dight buttons. The action consists of 
 * adding the digit used as a label on the button, which is returned by getText.
 */

public class DightButton extends CalculatorButton {
	
	public DightButton(int dight) {
		super("" + dight);
	}

	public void action(CalculatorDisplay display) {
		display.addDight(Integer.parseInt(getText()));
	}
	
}
