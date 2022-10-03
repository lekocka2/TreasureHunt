
public class Door extends GameBlock {
	
	private boolean isOpen;
	
	public Door(int col, int row, boolean isOpen) {
		super(col, row, (isOpen ? "door-open.png" : "door-closed.png") );
		this.isOpen = isOpen;
	}

	public boolean unlockDoor() {
		if(isOpen) return false;
		isOpen = true;
		setImage("door-open.png");
		return true;
	}
	
	public boolean getIsOpen() { return isOpen; }
	
}
