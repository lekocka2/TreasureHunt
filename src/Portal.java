
public class Portal extends GameBlock {
	
	public String loadMap;
	public int putCol, putRow;
	
	public Portal(int col, int row, String loadMap, int putCol, int putRow) {
		super(col, row, "blank.png");
		this.loadMap = loadMap;
		this.putCol = putCol;
		this.putRow = putRow;
	}

	public int getPutCol() {
		return putCol;
	}
	public int getPutRow() {
		return putRow;
	}
	
}
