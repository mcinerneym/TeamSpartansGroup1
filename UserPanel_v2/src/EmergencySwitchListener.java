/* created by Lavanya*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class EmergencySwitchListener implements ActionListener{

	
	ICar car = null;
	int numberOfFloors; 
	String state = "";
	String status = "";
	
	public EmergencySwitchListener(int numberOfFloors, ICar car){
		
		this.car = car;
		this.numberOfFloors = numberOfFloors;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton buttonPressed = (JButton)e.getSource();
		System.out.println("Emergency pressed");
		
		if(buttonPressed.getBackground() == Color.GRAY) {
			buttonPressed.setBackground(Color.RED);	
			System.out.println("Status: On!");
			state = "On";
			status = "emergency";
			try {
				car.getUserPanel().processAlarmRequest(status, car.getCarID());
				car.getCarController().processAlarmRequest(status,car.getCarID());
			} catch (NullPointerException ex) {
				return;
			}
		}else {
			buttonPressed.setBackground(Color.GRAY);	
			System.out.println("Status: Off!");
			state = "Off";
			status = "emergency off";
			try {
				car.getUserPanel().processAlarmRequest(status, car.getCarID());
				car.getCarController().processAlarmRequest(status,car.getCarID());
				car.setStatus(CarStatus.IDLE);
			} catch (NullPointerException ex) {
				return;
			}
			
		}			
	}
	
}