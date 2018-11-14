
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class UserPanelButtonListener implements ActionListener{

	
	int floorNumber = 1;
	
	
	
	ICar car = null;
	
	UserPanelColor buttonColor = null;
	
	public UserPanelButtonListener(String buttonText,  ICar car, UserPanelColor buttonColor){
		floorNumber = Integer.parseInt(buttonText);
		
		this.car = car;
		this.buttonColor = buttonColor;
	}
	
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton)arg0.getSource();
		button.setBackground(buttonColor.getJColor());
		System.out.println(car.getUserPanelQueue());
		car.getUserPanelQueue().putMessage(floorNumber);		
		
	}
	

}