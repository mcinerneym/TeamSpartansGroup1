import javax.swing.JPanel;
import java.awt.Color;


public interface ICar {
	
	void setDoor(IDoor door);
	
	void setUserPanel(IUserPanel userPanel);
	
	void setCarController(ICarController carController);
	
	void setUserPanelQueue(IUserPanelQueue userPanelQueue);
	
	IUserPanelQueue getUserPanelQueue();
	
	ICarController getCarController();
	
	JPanel createCar();
	
	void setDoorPanel(IDoorPanel doorPanel);
	
	IDoorPanel getDoorPanel();
	
	void setCurrentFloorNumber(int currentFloorNumber);
	
	int getCurrentFloorNumber();
	
	void moveUp(int destinationFloorNo);
	
	void moveDown(int destinationFloorNo);
	
	CarStatus getStatus();
	
	void setStatus(CarStatus status);
	
	void setStatus(CarStatus status, Color color);

	
	IUserPanel getUserPanel();

	IDoor getDoor();
	
	//Pinky added
	void setCarID(int id);
	int getCarID();
	String getCarType();
}
