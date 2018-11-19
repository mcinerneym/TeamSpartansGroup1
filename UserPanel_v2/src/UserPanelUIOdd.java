import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class UserPanelUIOdd extends JPanel{


	private ICar car = null;

	private UserPanelColor activeButtonColor = null;

	private UserPanelColor buttonColor = null;

	private List<JButton> lstUserPanelButtons = new ArrayList<JButton>();
	
	//modify code - Lavanya	
	private String alarmType;
	
	JButton alarmOn;
	 JButton alarmOff;
	//public UserPanelUIOdd(int numFloors, UserPanelColor buttonColor,
	//UserPanelColor activeButtonColor, ICar car) {
		
	public UserPanelUIOdd(int numFloors, UserPanelColor buttonColor,
				UserPanelColor activeButtonColor, ICar car, String alarmType) {
		//end
		
		System.out.println("Inside UsserPanel UI "+ car);

		this.car = car;

		this.activeButtonColor = activeButtonColor;

		this.buttonColor = buttonColor;

		int newNumFloors = 0;
        int numButtons = numFloors + 2;  //for alarmOn and alarmOff buttons;
		
		//add code - Lavanya
		this.alarmType = alarmType; //end

		setPreferredSize(new Dimension(200, 200));
		if (numButtons % 3 != 0) {
			newNumFloors = numButtons + (3 - (numButtons % 3));
		} else {
			newNumFloors = numButtons;
		}

		setLayout(new GridLayout(newNumFloors / 3, 3));

		for (int i = 1; i <= numFloors; i+=2) {
			JButton button = new JButton("" + i);
			
			System.out.println("Button Text" + button.getText());
			System.out.println("Button Color" + buttonColor);
			button.setBackground(buttonColor.getJColor());
			button.addActionListener(
					new UserPanelButtonListener(button.getText(), car, activeButtonColor));
			add(button);
			lstUserPanelButtons.add(button);

		}
		
//add code - Lavanya
		
		ImageIcon alarm = new ImageIcon("images/alarmbell2.jpg");
		ImageIcon noAlarm = new ImageIcon("images/alarm.jpg");
		
		if(alarmType == "Text"){
		  alarmOn = new JButton("AlarmOn");
		  alarmOn.setMargin(new Insets(1,1,1,1));
		  alarmOff = new JButton("AlarmOff");
		  alarmOff.setMargin(new Insets(1,1,1,1));
		  alarmOff.setEnabled(false);
		
		}
		
		else{
			alarmOn = new JButton(alarm);
			 alarmOff = new JButton(noAlarm);
			 alarmOff.setEnabled(false);
		}
		alarmOn.setBackground(Color.GRAY);
		alarmOff.setBackground(Color.GRAY);
		alarmOn.addActionListener(new AlarmButtonListener("on",numFloors,car));
		alarmOff.addActionListener(new AlarmButtonListener("off",numFloors,car));
		add(alarmOn);
		add(alarmOff);
		
		
        //end
	}

	
	
	public void deactivateFloorButton(int floorNumber){
		
		for(JButton button : lstUserPanelButtons){
			if(Integer.parseInt(button.getText()) == floorNumber){
				button.setBackground(buttonColor.getJColor());
				break;
			}
		}
		
	}
	
	public void deactivateFloorButtons(){
		for(JButton button : lstUserPanelButtons){
			button.setEnabled(false);
			button.setBackground(buttonColor.getJColor());
		}
		alarmOff.setEnabled(true);
	}
	
	public void activateFloorButtons(){
		for(JButton button : lstUserPanelButtons)
			button.setEnabled(true);
		alarmOff.setBackground(Color.GRAY);
	}
	

}
