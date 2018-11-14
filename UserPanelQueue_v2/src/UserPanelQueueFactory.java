
public class UserPanelQueueFactory {
	
	public static IUserPanelQueue getUserPanelQueueInstance(){
		
		IUserPanelQueue userPanelQueue = null;
		ICar car = null;
		ICarController carController = null;
		
		if(UserPanelQueueConfiguration.getUserPanelQueueType().equalsIgnoreCase("default")){
			userPanelQueue = new UserPanelQueue();
		}
		if(UserPanelQueueConfiguration.getCarType().equalsIgnoreCase("default")){
			 car = new Car();
			 userPanelQueue.setCar(car);
		}
		
		if(UserPanelQueueConfiguration.getCarControllerType().equalsIgnoreCase("default")){
			carController = new CarController();
			car.setCarController(carController);
		}
		
		
		
		return userPanelQueue;
	}

}
