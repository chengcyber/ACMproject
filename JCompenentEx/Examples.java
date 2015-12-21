package JCompenentEx;

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
import acm.graphics.*;

public class Examples extends GraphicsProgram {

	
	public void init() {
		
		/* CheckBox */
		check = new JCheckBox("Front");
		/* init */
		check.setSelected(true);
		add(check,SOUTH);
		
		//check.isSelected()
		/*****************/
		
		/* RadioBox */
		sm = new JRadioButton("Small");
		med = new JRadioButton("Medium");
		lrg = new JRadioButton("Large");
		/* create ButtonGroup */
		ButtonGroup size = new ButtonGroup();
		size.add(sm);
		size.add(med);
		size.add(lrg);
		/* init */
		med.setSelected(true);
		add(sm,SOUTH);
		add(med,SOUTH);
		add(lrg,SOUTH);
		
		//sm.isSelected() med.isSelected() lrg.isSelected()
		
		/********************/
		
		/* Combo Box */
		pick = new JComboBox();
		pick.addItem("Black");
		pick.addItem("Blue");
		pick.addItem("Green");
		pick.addItem("Red");
		/* init */
		pick.setEditable(false);
		pick.setSelectedItem("Black");
		// show Color:
		add(new JLabel("  Color:"),SOUTH);
		add(pick,SOUTH);
	}
	
	
	/* private instance variables */
	private JCheckBox check;
	private JRadioButton sm;
	private JRadioButton med;
	private JRadioButton lrg;
	private JComboBox pick;
	
}
