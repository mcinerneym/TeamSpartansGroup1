
public class CarFactory {
	
	
	
	public static ICar getCarInstance(){
		
		ICar car = null;
		if(CarConfiguration.getCarType().equals("default")){
			car = new Car();
		}
		
		if(CarConfiguration.getCarControllerType().equals("default")){
			car.setCarController(new CarController());
		}
		
		if(CarConfiguration.getDoorType().equals("singledoor")){
			DoorConfiguration.setDoorType(CarConfiguration.getDoorType());
			car.setDoor(DoorFactory.createDoor());
		}else if(CarConfiguration.getDoorType().equals("doubledoor")){
			DoorConfiguration.setDoorType(CarConfiguration.getDoorType());
			car.setDoor(DoorFactory.createDoor());
		}else if(CarConfiguration.getDoorType().equals("testdoor")){

			car.setDoor(new TestDoor());
		}
		
		if(CarConfiguration.getUserPanelQueueType().equals("default")){
			car.setUserPanelQueue(new UserPanelQueue());
		}else if(CarConfiguration.getUserPanelQueueType().equals("testuserpanelqueue")){
				car.setUserPanelQueue(new TestUserPanelQueue());
				
		}
		
		if(CarConfiguration.getUserPanelType().equals("default")){
			UserPanelConfiguration.setUserPanelType("default");
			IUserPanel userPanel = UserPanelFactory.getUserPanelInstance();
			userPanel.setCar(car);
			car.setUserPanel(userPanel);
		}else if(CarConfiguration.getUserPanelType().equals("testuserpanel")){
			car.setUserPanel(new TestUserPanel());
		}
		
		
		
		if(CarConfiguration.getDoorPanelType().equals("default")){
			car.setDoorPanel(new DoorPanel());
		}
		
		
		return car;
	}

}
