/* created by Lavanya*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class AlarmButtonListener implements ActionListener{

	
	ICar car = null;
	String alarmStatus = null;
	int numberOfFloors;
	
	public AlarmButtonListener(String alarmStatus,int numberOfFloors,ICar car){
		
		this.car = car;
		this.alarmStatus = alarmStatus;
		this.numberOfFloors = numberOfFloors;

	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton buttonPressed = (JButton)e.getSource();
		buttonPressed.setBackground(Color.RED);	
		System.out.println("alarm pressed");
		System.out.println("alarmStatus:" + alarmStatus);
		
		System.out.println("alrmlistener" + car.getUserPanel());
		car.getUserPanel().processAlarmRequest(alarmStatus, car.getCarID());
		System.out.println("alrmlistenre:" + car.getCarController() + "id:" + car.getCarID());
		car.getCarController().processAlarmRequest(alarmStatus,car.getCarID());
					
		}	
	
					
		
	
	

}