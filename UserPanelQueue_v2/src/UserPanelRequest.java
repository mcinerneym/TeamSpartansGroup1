
public class UserPanelRequest {
	
	private int destinationFloorNumber = 1;
	
	
	
	public UserPanelRequest(int destinationFloorNumber, ICar car){
		this.destinationFloorNumber = destinationFloorNumber;
		
	}

	public int getDestinationFloorNumber() {
		return destinationFloorNumber;
	}

	public void setDestinationFloorNumber(int destinationFloorNumber) {
		this.destinationFloorNumber = destinationFloorNumber;
	}

		
	//TBD - implement equals method
	@Override
	public boolean equals(Object arg0) {
		UserPanelRequest u = (UserPanelRequest)arg0;
		if(destinationFloorNumber == u.destinationFloorNumber){
			return true;
		}
		
		return false;
	}
}
