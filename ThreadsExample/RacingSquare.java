package ThreadsExample;

import acm.graphics.*;
import acm.util.*;
import java.awt.*;

public class RacingSquare extends GRect implements Runnable{
	
	public RacingSquare(int index,boolean[] finished) {
		super(SIZE, SIZE);
		setFilled(true);
		this.index = index;
		this.finishers = finished;
	}
	
	public void run() {
		
		finishers[index] = false;
		
		// running
		for( int i = 0; i < 100; i++) {
			pause(rgen.nextInt(50,150));
			move(STEP,0);
		}
		
		
		// watch out for photo finishes! (BUGGY!)
		
		
		// count how man others finished before me.
		int count = 0;
		for(int i = 0; i < finishers.length; i++) {
			if(finishers[i]) count++;
		}
		
		//take some time to do a victory dance
		pause(50);
		
		
		// make myself as having finished.
		finishers[index] = true;
		
		// if no oen finished before me, then I win!(turn red)
		if (count == 0) {
			setColor(Color.RED);
		}
		
		
	}
	
	/* CONSTANTS */
	private static final int SIZE = 20;
	private static final int STEP = 5;
	
	/* ivars */
	private int index;
	private boolean[] finishers;
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
