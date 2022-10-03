import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tester extends JPanel {
	JFrame window = new JFrame("Game Template");
	Random rnd = new Random();
	int cols = 0, rows = 0;
	Person person;
	HashMap<String, GameBlock> blocks = new HashMap<String, GameBlock>();

	public Tester() {
		loadMap("floor-01.txt");
		window.setBounds(50, 50, cols * GameBlock.SIZE, rows * GameBlock.SIZE + 28);
		window.setAlwaysOnTop(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.getContentPane().add(this);
		window.setVisible(true);

		//============================================================ Key pressed
		window.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getExtendedKeyCode()) {
					case 37:    person.setCol(person.getCol()-1); break;	// west
					case 38: 	person.setRow(person.getRow()-1); break;	// north
					case 39: 	person.setCol(person.getCol()+1); break;	// east
					case 40: 	person.setRow(person.getRow()+1); break;	// south
				}
				repaint();
			}

			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
		});
	}

	private void loadMap(String fileName) {
		blocks.clear();
		try(Scanner fin = new Scanner(new File(fileName))){
			while(fin.hasNextLine()) {
				String ln = fin.nextLine();
				cols = ln.length();
				for(int i = 0; i < cols; i++)
					blocks.put(i + "-" + rows, getBlock(ln.charAt(i), i, rows));

				rows++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GameBlock getBlock(char c, int col, int row) {
		switch(c) {
		case 'W'	:	return new Wall(col, row, false);
		case 'w'	:	return new Wall(col, row, true);
		case 'D'	:	return new Door(col, row, false);
		case 'd'	:	return new Door(col, row, true);
		case '1'	:	return new Key(col, row, 1);
		case '2'	:	return new Key(col, row, 2);
		case '3'	:	return new Key(col, row, 3);
		case 'T'	:	return new Treasure(col, row, rnd.nextInt(501) + 500);
		case 't'	:	return new Treasure(col, row, rnd.nextInt(51) + 50);	
		case 'X'	:	person = new Person(col, row);	return new EmptyFloor(col, row);
		default		:	return new EmptyFloor(col, row);
		}
	}

	//============================================================ Drawing
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(GameBlock gb : blocks.values())
			gb.draw(g);
		person.draw(g);
	}

	//======================================================
	public static void main(String[] args) {new Tester();}
	//======================================================
}