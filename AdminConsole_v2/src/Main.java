import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		
		FloorPanelConfiguration.setButtonColor(FloorPanelColor.RED);

		UserPanelConfiguration.setActiveButtonColor(UserPanelColor.YELLOW);
		
		UserPanelConfiguration.setButtonColor(UserPanelColor.BLUE);
		
		int numberOfFloors = 8;
		int numberOfCars = 5;
		
		JPanel completeFloorPanel = new JPanel();
		completeFloorPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		int centerrow = 0;
		gbc.gridx = 0;
		gbc.gridy = centerrow;
		
		IMetaController metaController = MetaControllerFactory.getMetaControllerInstance();
		
		IFloorPanelQueue floorPanelQueue = new FloorPanelQueue();
		
		floorPanelQueue.setMetaContoller(metaController);

		FloorPanelConfiguration.setTextType("text");
		
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
			gbc.gridy = centerrow++;
		}
		frame.add(completeFloorPanel);
		
		//int size = GuiConfiguration.getSelectioArray().size();
		 //for(int i=0;i<size;i++){
		//GuiConfiguration.getSelectioArray().get(i);
		
		 ArrayList<Integer> lst=new ArrayList<Integer>();
		
		lst =GuiConfiguration.getSelectioArray();
		
		for(int i=0;i<numberOfCars;i++){
			 ICar car = CarFactory.getCarInstance();
			 
			 //UserPanelConfiguration.setSelection(lst.get(i).intValue());
			 
			 IUserPanel userPanel = UserPanelFactory.getUserPanelInstance();
			 
			 
			 IUserPanelQueue userPanelQueue = new UserPanelQueue();
			 ICarController carController = new CarController();
			 IDoorPanel doorPanel = DoorPanelFactory.createDoorPanel();
			 IDoor door = DoorFactory.createDoor();
			 
				 
			 car.setUserPanel(userPanel);
			 car.setUserPanelQueue(userPanelQueue);
			 car.setCarController(carController);
			 car.setDoor(door);
			 car.setDoorPanel(doorPanel);
			 
			 
			 userPanel.setCar(car);
			 userPanel.setNumberFloors(numberOfFloors);
			 
			 
			 userPanelQueue.setCar(car);
			 carController.setCar(car);
			 carController.setFloorPanel(ifloorPanel);
			 
			 doorPanel.setCar(car);
			 
			  
			 metaController.registerCar(car);
			 
			frame.add(car.createCar());
		}
		frame.setSize(300*numberOfCars, numberOfFloors * 80);
		frame.setVisible(true);
		
			
		
	
	//	car[0].moveUp(9);

	}

}
