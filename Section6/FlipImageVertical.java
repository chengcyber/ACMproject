package Section6;

/**
 * Write a method flipHorizontal that works similarly to the flipVertical method
 * presented in the chapter except that it reverses the picture in the horizontal dimension.
 * Thus, if you had a GImage containing the image on the left (of Jan Vermeer¡¯s The
 * Milkmaid, c. 1659), calling flipHorizontal on that image would return a new GImage
 * as shown on the right:
 * @author liu.cheng
 *
 */

import acm.program.*;
import acm.graphics.*;

public class FlipImageVertical extends GraphicsProgram {

	public void run() {
		GImage img = new GImage("The Milkmaid.gif");
		GImage flipImg = createFlipImage(img);
		
		img.scale(0.5);
		add(img,10,50);
		
		flipImg.scale(0.5);
		add(flipImg,420,50);
		
	}
	
	
	private GImage createFlipImage(GImage image) {
		// Gets copy of pixel array from image
		int[][] arr = image.getPixelArray();
		
		int height = arr.length;
		int width = arr[0].length;
		
		for(int i=0;i<height;i++) {
			for(int j=0;j<width/2;j++) {
				int p0 = arr[i][j];
				int p1 = arr[i][width-1-j];
				
				//swap pixel value
				int temp = p0;
				p0 = p1;
				p1 = temp;
				
				arr[i][j] = p0;
				arr[i][width-1-j] = p1;
			}
			
		}
		return new GImage(arr);
	}
	
}
