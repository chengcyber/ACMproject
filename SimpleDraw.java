/** 
 * 	simple drawing Oval Rect select by buttons.
 *  */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class SimpleDraw extends GraphicsProgram{

	public void run() {
		setup();
		addMouseListeners();
	}
	
	// draw buttons
	private void setup() {
		button1 = new GRect(10,10,50,50);
		button2 = new GRect(10,100,50,50);
		button1.setFilled(true);
		add(button1);
		add(button2);
		label = new GLabel("hello");
		label2 = new GLabel("2");
		add(label, 100, 100);
		add(label2,100,150);
	}
	
	/**
	 * press button : change state,the object to draw.
	 * press is not button : drawing !
	 * @param e MouseEvent
	 */
	public void mousePressed(MouseEvent e) {
		GObject clkObj = getElementAt(e.getX(), e.getY());
//		label.setLabel(clkObj.toString());
//		isDrawing = true;
		if (clkObj == null) {
			startX = e.getX();
			startY = e.getY();
			
			currentRect = null;
			currentOval = null;
			
			switch (state) {
			case 1:currentRect = new GRect(startX,startY,0,0); add(currentRect); break;
			case 2:currentOval = new GOval(startX,startY,0,0); add(currentOval); break;
			default: break;
			}
			
			
		}
		
//		label2.setLabel(Boolean.toString(isDrawing));
		
	}
	
	/**
	 * called on mouse drag to reshape the current object
	 * @param e
	 */
	public void mouseDragged(MouseEvent e) {
		double x = Math.min(startX, e.getX());
		double y = Math.min(startY, e.getY());
		double width = Math.abs(e.getX() - startX);
		double height = Math.abs(e.getY() - startY);
		switch (state) {
		case 1 : currentRect.setBounds(x, y, width, height);
		case 2 : currentOval.setBounds(x, y, width, height);
		default : break;
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		GObject clkObj = getElementAt(e.getX(), e.getY());
		if (clkObj == button1) {
			state = 1;
		} else if (clkObj == button2) {
			state = 2;
		} else {
			state = 0;
		}
	}
	
//	/** draw a square 30x30
//	 * @param x startpoint x
//	 * @param y startpoint y
//	 */
//	private void drawSquare(int x,int y) {
//		GRect rect = new GRect(x, y, 30,30);
//		add(rect);
//	}
	
	
	/* Pirvate instance variable */
	private GRect currentRect; //current Rectangle
	private GOval currentOval; //current oval
	//private GRect clkObj;
	private GRect button1;
	private GRect button2;
	private double startX;
	private double startY;
	private int state = 0; // 1 for Rect ,2 for Oval
	//private boolean isDrawing = false;
	
	
	//
	private GLabel label;
	private GLabel label2;
}
