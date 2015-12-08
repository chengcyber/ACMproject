
/**
 * Draw Calendar
 * @author Administrator
 *
 */

import acm.graphics.*;
import acm.program.*;
import java.lang.String;

public class DrawCalendar extends GraphicsProgram {
	
	public void run () {
		drawPanel();
		drawCalNumber(DAY_MONTH_STARTS,DAYS_IN_MONTH);
		}
	
	private static final int DAYS_IN_MONTH = 31;
	private static final int DAY_MONTH_STARTS = 5;
	private static final int DAY_WIDTH = 40;
	private static final int DAY_HEIGHT = 30;

	
	public void drawPanel() {
		for(int i=0;i<6;i++) {
			int y = i;
			int x = 0;
			int n = 7;
			drawLine(x,y,n);
		}
	}

	public void drawLine(int x, int y, int n) {
		for(int i = 0;i<n;i++) {
			drawOne(i , y);
		}
	}
	
	public void drawOne(int x, int y) {
		GRect rect = new GRect(x*DAY_WIDTH,y*DAY_HEIGHT,DAY_WIDTH,DAY_HEIGHT);
		add(rect);
	}
	
	public void drawCalNumber(int s,int d) {
		int x=0,y=0;
		for(int a=0;a<s;a++) {
			x++;
		}
		
//		drawNumOne(x,y,1);
//		sentinel(x,y);
		for(int b=0;b<d;b++) {
			int num =b+1;
			drawNumOne(x,y,num);
			x++;
			if( (x)%7==0 ) {
				y++;
				x=0;
			}
		}
			
	}
	
	public void drawNumOne(int x,int y,int num) {
		String str = Integer.toString(num);
		GLabel label = new GLabel(str,x*DAY_WIDTH+20,y*DAY_HEIGHT+15);
		add(label);
	}
	
//	public void sentinel(int x,int y){
//		GLabel sen = new GLabel("Here",x*DAY_WIDTH,y*DAY_HEIGHT+15);
//		add(sen);
//	}
		
	
}
