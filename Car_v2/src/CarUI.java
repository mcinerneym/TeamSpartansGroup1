import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CarUI extends JPanel {
	
	JTextField textCurrentFloorNumber = null;
	JTextField textStatus = null;
	
	
	
	public CarUI(int currentFloorNumber, String carName, IDoor door, IUserPanel  userPanel, IDoorPanel doorPanel){
		
		setBorder( BorderFactory.createLineBorder(Color.black));
		JPanel floor = new JPanel();
		JPanel statusPanel = new JPanel();
		
		floor.setLayout(new FlowLayout());
		statusPanel.setLayout(new FlowLayout());
		
		JLabel label = new JLabel(carName);
		
		JLabel floorNumber = new JLabel("FloorNumber");
		JLabel status = new JLabel("Car Status");
		
		textCurrentFloorNumber = new JTextField(4);
		textCurrentFloorNumber.setText(new Integer(currentFloorNumber).toString());
		
		textStatus = new JTextField(11);
		textStatus.setText("IDLE");
		
		floor.add(floorNumber);
		floor.add(textCurrentFloorNumber);
		
		statusPanel.add(status);
		statusPanel.add(textStatus);
		
		textCurrentFloorNumber.setEditable(false);
		textStatus.setEditable(false);
		
		int centerRow = 0;
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridy = centerRow++;
		
	    add(label,gbc);
	    
	    
	    gbc.gridy = centerRow++;
	    gbc.gridx = 0;
	    add(floor,gbc);
	    
	    gbc.gridy = centerRow++;
	    gbc.gridx = 0;
	    add(statusPanel,gbc);
	    
	    gbc.gridy = centerRow++;
	    gbc.gridx = 0;
	    if(door!=null)
	    	add(door.createDoorUI(),gbc);
	    
	    gbc.gridy = centerRow++;
	    gbc.gridx = 0;
	    if(userPanel!=null)
	    	add(userPanel.createUserPanel(), gbc);
	    
	    gbc.gridy = centerRow++;
	    gbc.gridx = 0;
	    if(doorPanel!=null)
	    	add(doorPanel.createDoorPanelUI(), gbc);
		
		
	}
	
	public void setCurrentFloorNumber(int currentFloorNumber){
		textCurrentFloorNumber.setBackground(Color.yellow);
		textCurrentFloorNumber.setText(new Integer(currentFloorNumber).toString());
		
	}
	
	public void setCarStatus(CarStatus carStatus){
		textStatus.setBackground(Color.yellow);
		textStatus.setText(carStatus.toString());
		
		if(carStatus.equals(CarStatus.IDLE)){
			textStatus.setBackground(null);
			textCurrentFloorNumber.setBackground(null);
		}
		
	}
	
	/*public static void main(String args[]) throws InterruptedException{
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setPreferredSize(new Dimension(300, 300));
		SingleDoor door = new SingleDoor();
		
		UserPanelInterface panel = new UserPanel();
		panel.setNumberFloors(10);
		frame.add(new Car("Hello", new SingleDoor(), panel));
		frame.setVisible(true);
		
		
	}*/
}
