import java.util.Comparator;


public class UserPanelRequestAscComparator implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		
		UserPanelRequest upr1 = (UserPanelRequest)arg0;
		UserPanelRequest upr2 = (UserPanelRequest)arg1;
		
		if(upr1.getDestinationFloorNumber() < upr2.getDestinationFloorNumber()){
			return -1;
		}
		
		if(upr1.getDestinationFloorNumber() > upr2.getDestinationFloorNumber()){
			return 1;
		}
	
		return 0;
	}

}
