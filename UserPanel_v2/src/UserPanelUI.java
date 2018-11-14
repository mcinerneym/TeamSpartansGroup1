import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;



public class UserPanelUI extends JPanel  {

	private ICar car = null;

	private UserPanelColor activeButtonColor = null;

	private UserPanelColor buttonColor = null;

	private List<JButton> lstUserPanelButtons = new ArrayList<JButton>();
	
//modify code - Lavanya	
	private String alarmType;
	
	 JButton alarmOn;
	 JButton alarmOff;
	//public UserPanelUI(int numFloors, UserPanelColor buttonColor,
		//	UserPanelColor activeButtonColor, ICar car) {
		
	public UserPanelUI(int numFloors, UserPanelColor buttonColor,
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
		

		for (int i = 1; i <= numFloors; i++) {
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
		/*setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 1;
		gbc.gridy = 1;*/
		//setLayout(new GridLayout(1,2));
		
		ImageIcon alarm = new ImageIcon("images/alarmbell2.jpg");
		ImageIcon noAlarm = new ImageIcon("images/alarm.jpg");
		
		if(alarmType == "Text"){
		  alarmOn = new JButton("AlarmOn");
		  alarmOn.setSize(200,200);
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
		System.out.println("userpanelui - alarm on-ddeactivate");
		for(JButton button : lstUserPanelButtons){
			button.setEnabled(false);
			button.setBackground(buttonColor.getJColor());
		}
		alarmOff.setEnabled(true);
	}
	
	public void activateFloorButtons(){
		System.out.println("userpanelui - alarm off-activate");
		for(JButton button : lstUserPanelButtons)
			button.setEnabled(true);
		alarmOff.setBackground(Color.GRAY);
	}

}
