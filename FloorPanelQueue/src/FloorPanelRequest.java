public class FloorPanelRequest {

	private int currentFloornumber = 1;
	Direction direction = null;

	public FloorPanelRequest(int currentFloornumber, Direction direction) {
		this.currentFloornumber = currentFloornumber;
		this.direction = direction;
	}

	public int getcurrentFloornumber() {
		return currentFloornumber;
	}

	public void setcurrentFloornumber(int currentFloornumber) {
		this.currentFloornumber = currentFloornumber;
	}

	public Direction getdirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public String toString() {
		return "currentFloornumber is " + currentFloornumber
				+ " and direction is " + direction;
	}

}
