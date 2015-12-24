package MusicShop;

import acm.program.*;
import acm.util.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class MusicShop extends Program {
	
	public void init() {
		label = new JLabel("Album Name");
		albumName = new JTextField(20);
		add(label, SOUTH);
		add(albumName, SOUTH);
		
		canvas = new MusicShopDisplay();
		add(canvas);
		
		//loadInventory();
		
		albumName.addActionListener(this);
		addActionListeners();
		
	}
	

	
	private void loadInventory() {
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader("music.txt"));
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				Album album = parseLine(line);
				inventory.put(album.getAlbumName(), album);
			} 
			rd.close();
		} catch (IOException e) {
			throw new ErrorException(e);
		}		
	}
	
	private Album parseLine(String line) {
		int albumNameStart = line.indexOf("[") + 1;
		int albumNameEnd = line.indexOf("]");
		String albumName = line.substring(albumNameStart, albumNameEnd);
		
		int bandNameStart = line.indexOf("[", albumNameEnd + 1) + 1;
		int bandNameEnd = line.indexOf("]",albumNameEnd + 1);
		String bandName = line.substring(bandNameStart, bandNameEnd);
		
		int numStockedStart = line.indexOf(" ", bandNameEnd + 1) + 1;
		int numStocked = Integer.parseInt(line.substring(numStockedStart));
		
		return (new Album(albumName, bandName, numStocked));
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == albumName) {
			canvas.displayInventory(inventory.get(albumName.getText()));
		}
	}

	/* ivars */
	private JLabel label;
	private JTextField albumName;
	private MusicShopDisplay canvas;
	private HashMap<String, Album> inventory = new HashMap<String, Album>();
}
