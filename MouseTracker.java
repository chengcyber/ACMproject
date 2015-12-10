/**
 * show the x,y with a label when mouse move 
 */


import acm.program.*;
import acm.graphics.*;
//import acm.util.*;
import java.awt.event.*;

public class MouseTracker extends GraphicsProgram {

	public void run() {
		label = new GLabel("");
		label.setFont("Times New Roman-36");
		add(label, 50, 50);
		
		// Must call this method to be able to get mouse
		addMouseListeners();
	}
	
	// This method is called evertimes user moves mouse
	public void mouseMoved(MouseEvent e) {
		label.setLabel("Mouse:(" + e.getX() + "," + e.getY() + ").");
	}
	
	
	/* Private instance variable */
	private GLabel label;
}
