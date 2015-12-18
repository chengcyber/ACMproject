

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import java.awt.Color;

public class frogMove extends GraphicsProgram {
	
	public void run() {
		setup();
		add(label);
		addMouseListeners();
	}
	
	
	public void mouseClicked(MouseEvent e) {
		int ex = e.getX()/SQSIZE;
		int ey = e.getY()/SQSIZE;
		int ox = (int)oval.getX()/SQSIZE;
		int oy = (int)oval.getY()/SQSIZE;
		int dx = 0;
		int dy = 0;
		
		/* get dx */
		if ( ex == ox) {
			dx = 0;
		} else if ( ex < ox ) {
			if ( ox != 0 ) {
				dx = -1;
			}			
		} else if ( ox < NCOLS - 1 ) {
			dx = 1;
		}
		
		/* get dy */
		if ( ey == oy) {
			dy = 0;
		} else if ( ey < oy ) {
			if ( oy != 0 ) {
				dy = -1;
			}			
		} else if ( oy < NROWS - 1 ) {
			dy = 1;
		}
		
				
		moveStep(dx,dy);
	}
	
	/* just for tesing */
//	public void mouseMoved(MouseEvent e) {
//		int ex = e.getX()/SQSIZE;
//		int ey = e.getY()/SQSIZE;
//		int ox = (int)oval.getX()/SQSIZE;
//		int oy = (int)oval.getY()/SQSIZE;
//		int dx = 0;
//		int dy = 0;
//		if ( ex == ox) {
//			dx = 0;
//		} else if ( ex < ox ) {
//			if ( ox != 0 ) {
//				dx = -1;
//			}			
//		} else if ( ox < NCOLS - 1 ) {
//			dx = 1;
//		}
//		label.setLabel("ex,ey,ox,oy,dx,dy:" + ex + ", " + ey + ", " + ox + ", " + oy + ", " + dx + ", " + dy + ", ");
//	}
	
	
	/* move frog 
	 * dx, dy is  row and col
	 * */
	private void moveStep(int dx, int dy) {
		oval.move(dx * SQSIZE, dy * SQSIZE );
	}
	
	
	/* initial the square 3 * 7 */
	private void setup() {
		this.setSize(SQSIZE * NCOLS + 10, SQSIZE * NROWS + 60);
		for(int i = 0; i < NROWS ; i++) {
			for(int j = 0; j < NCOLS; j++) {
				drawSquare(i,j);
			}
		}
		
		oval = new GOval(NCOLS/2 * SQSIZE, (NROWS-1) * SQSIZE,75,75);
		oval.setFilled(true);
		oval.setFillColor(Color.GREEN);
		add(oval);
	}
	
	private void drawSquare(int row, int col){
		
		GRect rect = new GRect(col * SQSIZE, row * SQSIZE, SQSIZE, SQSIZE);
		add(rect);
	}
	
	/* CONSTANTS */
	private static final int SQSIZE = 75 ;
	private static final int NCOLS = 7 ;
	private static final int NROWS = 3 ;

	/* private instance variables */
	private GOval oval ;
	
	private GLabel label = new GLabel("label",300,300);

}
