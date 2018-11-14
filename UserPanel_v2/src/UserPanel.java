import java.awt.Color;

import javax.swing.JPanel;

public class UserPanel implements IUserPanel {

	private ICar car = null;
	
	private UserPanelColor buttonColor = null;
	
	private UserPanelColor activeButtonColor = null;
	
	private UserPanelUI userPanelUI = null;
	
	private UserPanelUIEven userPanelUIEven = null;
	
	private UserPanelUIOdd userPanelUIOdd = null;
	
	private int selection =0;
	
	private IMetaController metaController = null;
	
	
	public int getSelection() {
		return selection;
	}

	public void setSelection(int selection) {
		this.selection = selection;
	}

	public ICar getCar() {
		return car;
	}

	public void setCar(ICar car) {
		this.car = car;
	}

	public void setNumberFloors(int numberFloors) {
		this.numberFloors = numberFloors;
	}

	private int numberFloors = 1;

	public int getNumberFloors() {
		return numberFloors;
	}
	
	//code add - Lavanya
	public void setAlarmType(String alarmType){
		this.alarmType = alarmType;
	}
	
	private String alarmType = "Text";
	
	public String getAlarmType(){
		return alarmType;
	}
	
	public void setAlarmStatus(String alarmStatus){
		this.alarmStatus = alarmStatus;
	}

	private String alarmStatus = "off";
	
	public String getAlarmStatus(){
		return alarmStatus;
	}
	
	//end
	
	public UserPanel() {
	
	}


	@Override
	public JPanel createUserPanel() {
		if (selection==0){
			//modify code - Lavanya
			//userPanelUI =  new UserPanelUI(numberFloors, buttonColor, activeButtonColor,  car);
			userPanelUI = new UserPanelUI(numberFloors, buttonColor, activeButtonColor, car, alarmType);
			return userPanelUI;
		}
		else if(selection==1){
			//modify code - Lavanya
			//userPanelUIEven =  new UserPanelUIEven(numberFloors, buttonColor, activeButtonColor,  car);
			userPanelUIEven = new UserPanelUIEven(numberFloors, buttonColor, activeButtonColor, car, alarmType);
			return userPanelUIEven;
		}
		else 
			//modify code - Lavanya
			//userPanelUIOdd =  new UserPanelUIOdd(numberFloors, buttonColor, activeButtonColor,  car);
			userPanelUIOdd = new UserPanelUIOdd(numberFloors, buttonColor, activeButtonColor, car, alarmType);
		
		return userPanelUIOdd;
	}
	
	@Override
	public void setActiveButtonColor(UserPanelColor color) {
		this.activeButtonColor = color;
		
	}

	@Override
	public void setButtonColor(UserPanelColor color) {
		this.buttonColor = color;
		
	}

	@Override
	public void deactivateFloorButton(int floorNumber) {
		if (selection==0)
			userPanelUI.deactivateFloorButton(floorNumber);
		else if (selection==1)
			userPanelUIEven.deactivateFloorButton(floorNumber);
		else
			userPanelUIOdd.deactivateFloorButton(floorNumber);
		
	}
	
	//add code - Lavanya
	public void setMetaController(IMetaController metaController){
		this.metaController = metaController;
	}

	
	public void processAlarmRequest(String alarmStatus, int carId){
	     System.out.println("userpanel.processalarmrequest"); 
		car.getUserPanel().setAlarmStatus(alarmStatus);
		
		if(alarmStatus.equalsIgnoreCase("on")){
			System.out.println("userpanel - alarm on");
			car.setStatus(CarStatus.ALARM_ON);
			if (selection==0)
				userPanelUI.deactivateFloorButtons();
			else if (selection==1)
				userPanelUIEven.deactivateFloorButtons();
			else
				userPanelUIOdd.deactivateFloorButtons();
			
			car.getUserPanelQueue().flushQueue();
			car.getUserPanelQueue().putMessage(1);
			car.setStatus(CarStatus.ALARM_ON);
			//if(UserPanelConfiguration.getCarType().equals("default"))
			      metaController.unregisterCar(car);
		}
		
		if(alarmStatus.equalsIgnoreCase("off")){
			System.out.println("userpanel - alarm off");
			car.setStatus(CarStatus.IDLE);
			//if(UserPanelConfiguration.getCarType().equals("default"))
			       metaController.registerCar(car);
			if (selection==0)
			{
				userPanelUI.activateFloorButtons();
			    userPanelUI.alarmOn.setBackground(Color.GRAY);
			    
			}
			else if (selection==1)
			{
				userPanelUIEven.activateFloorButtons();
				userPanelUIEven.alarmOn.setBackground(Color.GRAY);
			}
			else
			{
				userPanelUIOdd.activateFloorButtons();
				userPanelUIOdd.alarmOn.setBackground(Color.GRAY);
			}
	
	
	
	}
	}

	
}


