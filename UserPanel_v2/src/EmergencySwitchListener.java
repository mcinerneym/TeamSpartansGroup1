/* created by Lavanya*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class EmergencySwitchListener implements ActionListener{

	
	ICar car = null;
	int numberOfFloors;
	
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
			car.getUserPanel().processAlarmRequest("emergency", car.getCarID());
			car.getCarController().processAlarmRequest("emergency",car.getCarID());
		}else {
			buttonPressed.setBackground(Color.GRAY);	
			System.out.println("Status: Off!");
			car.getUserPanel().processAlarmRequest("emergency off", car.getCarID());
			car.getCarController().processAlarmRequest("emergency off",car.getCarID());
			car.setStatus(CarStatus.IDLE);
		}
					
	}	
}