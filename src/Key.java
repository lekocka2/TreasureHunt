
public class Key extends GameBlock {

	private int keyNum;
	
	public Key(int col, int row, int keyNum) {
		super(col, row, "key0" + keyNum + ".png");
		this.keyNum = keyNum;
	}

	public int getKeyNum() {
		return keyNum;
	}
	
}
