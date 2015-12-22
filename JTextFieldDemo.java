import acm.program.*;
import java.awt.event.*;
import javax.swing.*;


public class JTextFieldDemo extends ConsoleProgram {

	public void init() {
		
		tf = new JTextField(10);// the length is 10
		tf.addActionListener(this);
		add(new JLabel("Name:"),SOUTH);
		add(tf,SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tf) {
			println("hi " + tf.getText());
		}
	}
	
	/* ivars */
	private JTextField tf;
	
}
