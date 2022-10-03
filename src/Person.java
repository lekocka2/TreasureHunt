import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Person {

	BufferedImage image;
	private int col, row;

	public Person(int col, int row) {
		this.col = col;
		this.row = row;
		try {image = ImageIO.read(new File("person.png"));} 
		catch (Exception e) {}
	}

	public void draw(Graphics g) {
		g.drawImage(image, 30 * col, 30 * row, null);
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	

}
