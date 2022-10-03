
public class Wall extends GameBlock {

	private boolean isFake;

	public Wall(int col, int row, boolean isFake) {
		super(col, row, "brick-wall.png");
		this.isFake = isFake;
	}

	public boolean getIsFake() {
		return isFake;
	}

}



