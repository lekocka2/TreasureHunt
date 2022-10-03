import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public abstract class GameBlock {
	
	
	//========================================================================================== Properties
	public static final int SIZE = 30;
	int col, row;
	BufferedImage image;
	
	//========================================================================================== Constructors
	public GameBlock(int col, int row, String fileName) {
		this.col = col;
		this.row = row;
		setImage(fileName);
	}
	
	//========================================================================================== Methods
	public void draw(Graphics g) {
		g.drawImage(image, getX(), getY(), null);
	}
	
	//========================================================================================== Getters / Setters
	public boolean setImage(String fileName) {
		try {
			image = ImageIO.read(new File(fileName));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public int getX() { return col * SIZE; }
	public int getY() { return row * SIZE; }
	
	
}
