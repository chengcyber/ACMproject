package JCompenentEx;
/**
 * FirstButton program
 * @author liu.cheng
 * show button in south window region
 * click then print hello on the screen.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class FirstButton extends ConsoleProgram {

	public void init() {
		setFont("Courier-24");
		
		hi = new JButton("Hi");
		add(hi,SOUTH);
		addActionListeners();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		/* check command */
		if(cmd.equals("Hi")) {
			println("Hello there");
		}
		
		/* check object */
		if(e.getSource()==hi){}
	}
	
	/* ivars */
	private JButton hi;
	
}
