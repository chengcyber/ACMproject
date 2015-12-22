/**
 * 
 * @author liu.cheng
 * This program shows an example of using text and two different
 * graphis convases in a Console Program.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TextAndGraphics extends ConsoleProgram {

	public void init() {
		setLayout(new GridLayout(1,3));
		
		// first element is Console because extends ConsoleProgram
		
		leftCanvas = new GCanvas();
		add(leftCanvas);
		
		rightCanvas = new GCanvas();
		add(rightCanvas);
	
		textField = new JTextField(10);
		add(new JLabel("Some text"), SOUTH);
		add(textField, SOUTH);
		textField.addActionListener(this);
		
		
		add(new JButton("Draw left"), SOUTH);
		add(new JButton("Draw right"), SOUTH);
		
		/* Test */
		btn1 = new JButton("Test");
		add(btn1, SOUTH);
		
		addActionListeners();
	}
	
	/* action performed */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == textField) {
			println("You typed: " + textField.getText());
		}
		String cmd = e.getActionCommand();
		if (cmd.equals("Draw left")) {
			leftCanvas.add(createFilledRect(), 20, leftY);
			leftY += SPACER;
		} else if (e.getSource() == btn1) {
			leftCanvas.add(createFilledRect(), 20, leftY);
			leftY += SPACER;
		} else if(cmd.equals("Draw right")) {
			rightCanvas.add(createFilledRect(), 20, rightY);
			rightY += SPACER;
		}
		
	}
	
	/* create filled rectangle */
	private GRect createFilledRect() {
		// create retangle by 50x20
		GRect rect = new GRect(50, 20);
		rect.setFilled(true);
		return rect; 
	}
	
	/* CONSTANTS */
	private static double SPACER = 30;
	
	/* Private instance variables */
	private GCanvas leftCanvas;
	private GCanvas rightCanvas;
	private JTextField textField;
	
	private double rightY = 10;
	private double leftY = 10;
	
	private JButton btn1;
	
}
