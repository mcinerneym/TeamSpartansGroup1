import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ElevatorConfigurationReader {

	/**
	 * @param args
	 */
	public static void showElevator() {
		
		//Setting layout 
		JFrame frame = new JFrame("Elevator Simulation System");
		frame.setLayout(new FlowLayout());
		JPanel completeFloorPanel = new JPanel();
		completeFloorPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		int centerrow = 0;
		gbc.gridx = 0;
		gbc.gridy = centerrow;
		
		//Setting number of floors and cars
		int numberOfFloors = GuiConfiguration.getNumOfFloors();
		int numberOfCars = GuiConfiguration.getNumOfCars();
		UserPanelConfiguration.setNumberFloors(numberOfFloors);
		UserPanelConfiguration.setSelection(GuiConfiguration.getUserPanelType());
		
		//Setting floorpanel configuration
		FloorPanelConfiguration.setButtonColor(resolveFloorPanelColor(GuiConfiguration.getFloorPanelColor()));
		FloorPanelConfiguration.setActiveButtonColor(resolveFloorPanelColor(GuiConfiguration.getFloorPanelPressedButtonColor()));
		FloorPanelConfiguration.setTextType(GuiConfiguration.getFloorPanelDisplay());
		//add code - Lavanya
		FloorPanelConfiguration.setNumAlarmIndicators(GuiConfiguration.getNumOfCars());
	
		//Setting userpanel configuration
		UserPanelConfiguration.setButtonColor(resolveUserPanelColor(GuiConfiguration.getUserPanelColor()));
		UserPanelConfiguration.setActiveButtonColor(resolveUserPanelColor(GuiConfiguration.getUserPanelPressedButtonColor()));
		UserPanelConfiguration.setAlarmType(GuiConfiguration.getAlarmType());
		
		//String doorpanel configuration
		DoorPanelConfiguration.setTextType(GuiConfiguration.getDoorPanelDisplay());
		
		//Setting algorithm configuration
		AlgorithmConfiguration.setAlgorithm(GuiConfiguration.getAlgorithmType());
		
		// Anshu added next one line
		MetaControllerConfiguration.setAlgorithm(GuiConfiguration.getAlgorithmType());
				
		
		//Setting door configuration
		List<IDoor> lstDoors = new ArrayList<IDoor>();
		String doorConfiguration = GuiConfiguration.getDoorConfiguration();
		if(doorConfiguration.trim().equalsIgnoreCase("Alternate Single/Double Door")){
			for(int index = 0; index < numberOfCars; index++){
				if(index%2==0){
					DoorConfiguration.setDoorType("singledoor");
					
				}else{
					DoorConfiguration.setDoorType("doubledoor");
					
				}
				lstDoors.add(DoorFactory.createDoor());;
			}
		}else if(doorConfiguration.trim().equalsIgnoreCase("Single Door")){
			for(int index = 0; index < numberOfCars; index++){
				DoorConfiguration.setDoorType("singledoor");
				lstDoors.add(DoorFactory.createDoor());;
			}
		}else if(doorConfiguration.trim().equalsIgnoreCase("Double Door")){
			for(int index = 0; index < numberOfCars; index++){
				DoorConfiguration.setDoorType("doubledoor");
				lstDoors.add(DoorFactory.createDoor());;
			}
		}
		
		
		IMetaController metaController = MetaControllerFactory.getMetaControllerInstance();
		
		IFloorPanelQueue floorPanelQueue = new FloorPanelQueue();
		
		floorPanelQueue.setMetaContoller(metaController);
		//add code Lavanya
		
		UserPanelConfiguration.setMetaController(metaController);
		
		IFloorPanel ifloorPanel = null;
		
		gbc.gridy = centerrow++;
		
				
		for(int j=numberOfFloors;j>=1;j--)
		{				
			 ifloorPanel = FloorPanelFactory.createFloorPanel();
			JPanel panel = ifloorPanel.createFloorPanel(j);
			if(j==numberOfFloors)
				ifloorPanel.disableUpButton();
			if(j==1){
				ifloorPanel.disableDownButton();
			}
			
			ifloorPanel.setFloorPanelQueueType(floorPanelQueue);
			completeFloorPanel.add(panel, gbc);
			
			/*JLabel floorInd1= new JLabel("Car ID");
			JTextField floorInd2 = new JTextField(1);
			JLabel floorInd3= new JLabel("Car Type");
			JTextField floorInd4 = new JTextField(5);
			JTextField floorInd5 = new JTextField(6);
			completeFloorPanel.add(floorInd1);
			completeFloorPanel.add(floorInd2);
			completeFloorPanel.add(floorInd3);
			completeFloorPanel.add(floorInd4);
			completeFloorPanel.add(floorInd5);*/
			//FloorIndicator f1=new FloorIndicator();
			//IFloorIndicator fl= new FloorIndicator();
			//gbc.gridy=centerrow++;
			//completeFloorPanel.add(f1.createFloorIndicatorUI());
			gbc.gridy = centerrow++;
			
		}
		frame.add(completeFloorPanel);
		 ArrayList<Integer> lst=new ArrayList<Integer>();
			
		lst=GuiConfiguration.getSelectioArray();
		
		if(lst.size()==0){
			for(int i=0;i<numberOfCars;i++){
				 lst.add(new Integer(0));
			}
		}
		
		for(int i=0;i<numberOfCars;i++){
			 
			 ICar car = CarFactory.getCarInstance();
			 car.setCarID(i+1);
			 //setting current floor number for even
			 if(lst.get(i).intValue()==1)
				 car.setCurrentFloorNumber(2);
			 
			 UserPanelConfiguration.setSelection(lst.get(i).intValue());
			 System.out.println(lst.get(i).intValue());
			 IUserPanel userPanel = UserPanelFactory.getUserPanelInstance();
			 userPanel.setSelection(lst.get(i).intValue());
			 
			 IUserPanelQueue userPanelQueue = new UserPanelQueue();
			 ICarController carController = new CarController();
			 IDoorPanel doorPanel = DoorPanelFactory.createDoorPanel();
			 IDoor door = lstDoors.get(i);
			 
			 
			 car.setUserPanel(userPanel);
			 car.setUserPanelQueue(userPanelQueue);
			 car.setCarController(carController);
			 car.setDoor(door);
			 car.setDoorPanel(doorPanel);
			 
			 
			 userPanel.setCar(car);
			 userPanel.setNumberFloors(numberOfFloors);
			 
			 
			 userPanelQueue.setCar(car);
			 System.out.println("ElevConfigReader");
			 carController.setCar(car);
			 carController.setFloorPanel(ifloorPanel);
			 
			 doorPanel.setCar(car);
			 
			  
			 metaController.registerCar(car);
			 
			frame.add(car.createCar());
		}
		frame.setSize(400*numberOfCars, numberOfFloors * 90);
		frame.setVisible(true);
		
			
		
	
	//	car[0].moveUp(9);

	}

	public static void main(String[] args){
		showElevator();
	}
	static FloorPanelColor resolveFloorPanelColor(String color){
		if(color.equalsIgnoreCase("Red")){
			return FloorPanelColor.RED;
		}else if(color.equalsIgnoreCase("Blue")){
			return FloorPanelColor.BLUE;
		}else if(color.equalsIgnoreCase("Green")){
			return FloorPanelColor.GREEN;
		}else if(color.equalsIgnoreCase("Yellow")){
			return FloorPanelColor.YELLOW;
		}
		
		return null;
	}
	
	static UserPanelColor resolveUserPanelColor(String color){
		if(color.equalsIgnoreCase("Red")){
			return UserPanelColor.RED;
		}else if(color.equalsIgnoreCase("Blue")){
			return UserPanelColor.BLUE;
		}else if(color.equalsIgnoreCase("Green")){
			return UserPanelColor.GREEN;
		}else if(color.equalsIgnoreCase("Yellow")){
			return UserPanelColor.YELLOW;
		}
		
		return null;
	}
	
}
