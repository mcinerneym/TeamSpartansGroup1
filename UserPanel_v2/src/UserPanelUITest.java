import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;
import javax.swing.JButton;



class UserPanelUITest {

	@Test
	void ButtonOnTest() {
		System.out.println("Testing Button ON");
		JButton elevatorSwitch = new JButton();
		EmergencySwitchListener e = new EmergencySwitchListener(5, new Car());
		elevatorSwitch.addActionListener(e);
		elevatorSwitch.setBackground(Color.GRAY);
		elevatorSwitch.doClick();
		assert(e.state == "On");
		assert(e.status == "emergency");
	}
	
	@Test
	void ButtonOffTest() {
		System.out.println("Testing Button OFF");
		JButton elevatorSwitch = new JButton();
		EmergencySwitchListener e = new EmergencySwitchListener(5, new Car());
		elevatorSwitch.addActionListener(e);
		elevatorSwitch.setBackground(Color.RED);
		elevatorSwitch.doClick();
		assert(e.state == "Off");
		assert(e.status == "emergency off");
	}
	
	@Test
	void ButtonOnAndOffTest() {
		System.out.println("Testing switch on / off");
		System.out.println("Switched on");
		JButton elevatorSwitch = new JButton();
		EmergencySwitchListener e = new EmergencySwitchListener(5, new Car());
		elevatorSwitch.addActionListener(e);
		elevatorSwitch.setBackground(Color.GRAY);
		elevatorSwitch.doClick();
		assert(e.state == "On");
		assert(e.status == "emergency");
		
		System.out.println("Switched off");
		elevatorSwitch.doClick();
		assert(e.state == "Off");
		assert(e.status == "emergency off");
	}

}
