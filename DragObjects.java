/** 
 * @author liu.cheng
 * drag objects with mouse
 * random change color for the last object selected when press a key.
 *
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import acm.util.*;

public class DragObjects extends GraphicsProgram {
	
	// Initializes the program
	// give the init objects for drag
	public void init() {
		GRect rect = new GRect(100,100,150,200);
		rect.setFilled(true);
		add(rect);
		GOval oval = new GOval(80,80,100,100);
		oval.setFilled(true);
		add(oval);
		addMouseListeners();
		addKeyListeners();
	}
	
	// called on mouse press to record the coordinates of the click.
	public void mousePressed(MouseEvent e) {
		last = new GPoint(e.getPoint());
		gobj = getElementAt(last);
	}
	
	// called on mouse drag to reposition the object
	public void mouseDragged(MouseEvent e) {
		if (gobj != null) {
			gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}
	}
	
	// change color of last object dragged
	public void keyTyped(KeyEvent e) {
		if (gobj != null) {
			gobj.setColor(rgen.nextColor());
		}
	}
	
	
	/* private instance variable */
	private GObject gobj;
	private GPoint last;
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
