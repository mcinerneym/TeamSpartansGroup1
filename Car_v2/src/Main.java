import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main {

	
	JComboBox list1 = new JComboBox(new String[]{"testuserpanel", "default"});
	JComboBox list2 = new JComboBox(new String[]{"testdoor", "singledoor", "doubledoor"});
	JComboBox list3 = new JComboBox(new String[]{"testuserpanelqueue", "default"});
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		new Main().createConfigurationUI();
		

	}
	
	public static String getUserInput(){
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       String input = null;
	       try {
	    	   input = br.readLine();
	       } catch (IOException e) {
	         System.out.println("Error!");
	         System.exit(1);
	       }
	       
		
		return input;
	}
 
	public  void createConfigurationUI(){
		JPanel panel = new JPanel();
	panel.setLayout(new GridBagLayout());
		
		JLabel label1 = new JLabel("User panel type:");
		JLabel label2 = new JLabel("Door type:");
		JLabel label3 = new JLabel("User panel queue type:");
		
		
		
		 int centerRow = 0;
		   GridBagConstraints gbc = new GridBagConstraints();
		    gbc.gridy = centerRow++;
		   		    
		    panel. add(label1,gbc);
		    gbc.gridx = 1;
		    panel.add(list1,gbc);
		    
		    gbc.gridy = centerRow++;
		    gbc.gridx = 0;
		    panel. add(label2,gbc);
		    gbc.gridx = 1;
		    panel. add(list2,gbc);
		    
		    gbc.gridy = centerRow++;
		    gbc.gridx = 0;
		    panel. add(label3,gbc);
		    gbc.gridx = 1;
		    panel. add(list3,gbc);
		   
		    gbc.gridx = 1;
		    gbc.gridy = 3;
		    JButton ok = new JButton ("OK");
		     panel.add(ok, gbc);
		     ok.addActionListener(new ButtonListener());
		     JFrame frame = new JFrame();
		     frame.add(panel);
		     frame.setSize(400,200);
		     frame.setVisible(true);
	}
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Setting car configuration...");
			CarConfiguration.setUserPanelType((String)list1.getSelectedItem());
			// CarConfiguration.setDoorPanelType("null");
			 CarConfiguration.setDoorPanelType("null");
			 CarConfiguration.setDoorType((String)list2.getSelectedItem());
			 CarConfiguration.setUserPanelQueueType((String)list3.getSelectedItem());
			 JFrame frame = new JFrame();
			frame.setLayout(new FlowLayout());
			ICar car = null;
			 car = CarFactory.getCarInstance();
			 
				
			 System.out.println("Creating car UI...");
			 
			 frame.add(car.createCar());

			frame.setSize(300*1, 400);
			frame.setVisible(true);
		
			int i=0;
			int destinationFloorNo = 9;
			
			
		}
	}
	
	

}
