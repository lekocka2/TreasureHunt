
public class Treasure extends GameBlock {

	private int treasureAmt;
	
	public Treasure(int col, int row, int treasureAmt) {
		super(col, row, "treasure.png");
		this.treasureAmt = treasureAmt;
	}

	public int getTreasureAmt() {
		return treasureAmt;
	}
	
	
}

