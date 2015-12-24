

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import acm.graphics.*;

public class MusicShopDisplay extends GCanvas implements ComponentListener{
	
	public MusicShopDisplay() {
		addComponentListener(this);
		lastAlbum = null;
	}
	
	public void update() {
		displayInventory(lastAlbum);
	}
	
	public void displayInventory(Album al) {
		removeAll();
		lastAlbum = al;
		if (al != null) {
			int numStocked = al.getStock();
			add(new GLabel("Album [" + al.getAlbumName() + "] by [" + al.getBandName() + "]"),
				10, (getHeight() - BAR_HEIGHT) / 2 - SPACER);	
		
			
			// Display squares in dication how man inventory.
			double nextX = SPACER;
			for(int i = 0; i < numStocked; i++) {
				double barLength = (getWidth() / (double)MAX_INVENTORY) - SPACER;
				
				GRect rect = new GRect(nextX, (getHeight() - BAR_HEIGHT) / 2,
						barLength, BAR_HEIGHT);
				rect.setFilled(true);
				add(rect);
				nextX += barLength + SPACER;
			}
			
			GLabel label = new GLabel(numStocked + " in stock");
			add(label, 10, (getHeight() + BAR_HEIGHT) / 2 +
					SPACER + label.getHeight());
		}
		
	}
	
	public void componentResized(ComponentEvent e) {update();}
	public void componentHidden(ComponentEvent e) {}
	public void componentMoved(ComponentEvent e) {}
	public void componentShown(ComponentEvent e) {}
	
	private static final double BAR_HEIGHT = 20;
	private static final double SPACER = 10;
	private static final int MAX_INVENTORY = 20;
	
	private Album lastAlbum;
}
