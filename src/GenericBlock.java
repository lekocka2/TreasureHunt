
public class GenericBlock extends GameBlock {

	public boolean canEnter;
	
	public GenericBlock(int col, int row, String fileName, boolean canEnter) {
		super(col, row, fileName);
		this.canEnter = canEnter;
	}

	public boolean getCanEnter() {
		return canEnter;
	}


}
