import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DoorPanel implements IDoorPanel
{
	ICar car = null;
		
	DoorPanelUI doorPanelUI = null;
	
	String destinationFloorNumber = null;
	
	DoorPanelQueue doorPanelQueue = null;	
	
	String openText = null;
	
	String closeText = null;
	
	
	public JPanel createDoorPanelUI() {
		
		doorPanelQueue = new DoorPanelQueue(car);
		doorPanelUI = new DoorPanelUI(doorPanelQueue, openText, closeText);		
		return doorPanelUI ;
	}

	@Override
	public void setCar(ICar car) {
		// TODO Auto-generated method stub
		this.car = car;
	}

		
	public static void main(String args[]){
		
		IDoorPanel d = new DoorPanel();
		ICar car = new Car();
		ICarController c = new CarController();
		IDoor door = new SingleDoor();
		
		car.setCarController(c);
		car.setDoorPanel(d);
		car.setDoor(door);
		
		d.setCar(car);
		c.setCar(car);
		

		
		JFrame j = new JFrame();
		j.setLayout(new FlowLayout());
		j.add(d.createDoorPanelUI());
		j.add(door.createDoorUI());
		j.setVisible(true);
		
		
		
		/*synchronized(door){
			door.openDoor();
			try {
				door.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		
	}

	@Override
	public void activateOpenButton() {
		doorPanelUI.activateOpenButton();
		
	}

	@Override
	public void activateCloseButton() {
		doorPanelUI.activateCloseButton();
		
	}

	@Override
	public void deactivateOpenButton() {
		doorPanelUI.deactivateOpenButton();
		
	}

	@Override
	public void deactivateCloseButton() {
		doorPanelUI.deactivateCloseButton();
		
	}

	@Override
	public void setCloseText(String text) {
		this.closeText = text;
		
		
	}

	@Override
	public void setOpenText(String text) {
		this.openText = text;
		
	}

	
}

