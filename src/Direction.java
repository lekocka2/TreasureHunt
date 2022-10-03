
public enum Direction {
 //           col  row
	NORTH    ( 0,   -1 ),
	SOUTH    ( 0,    1 ),
	EAST     ( 1,    0 ),
	WEST     (-1,    0 ),
	NO_MOVE  ( 0,    0 );
	
	
	private int dCol, dRow;
	
	private Direction(int dCol, int dRow) {
		this.dCol = dCol;
		this.dRow = dRow;
	}
	
	public int getdCol() { return dCol; }
	public int getdRow() { return dRow; }
	
	
}
