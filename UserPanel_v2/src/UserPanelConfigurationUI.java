import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class UserPanelConfigurationUI  extends JPanel{
	
	 String[] floorNumbers= { "2", "3", "4","5", "6", "7", "8", "9","10", "11", "12", "13", "14","15", "16", "17", "18", "19","20"};
	 JComboBox list1 = new JComboBox(floorNumbers);
	
	 String[] color= {"RED", "GREEN", "BLUE", "YELLOW"};
	 JComboBox list2 = new JComboBox(color);
	 
	 JComboBox list3 = new JComboBox(new String[]{"testcar", "default"});
	 JComboBox list4 = new JComboBox(new String[]{"testuserpanelqueue", "default"});
	 
	 String[] color1= {"RED", "GREEN", "BLUE", "YELLOW"};
	 JComboBox list5 = new JComboBox(color1);
	 
	 JComboBox list6 = new JComboBox(new String[]{"Current", "Even","Odd"});
	 
	 //code add begin - Lavanya
	 JComboBox list7 = new JComboBox(new String[]{"Text", "Symbol"});
	 //end
	 
	 Main owner = null;
	
	public UserPanelConfigurationUI(Main owner){
		this.owner = owner;
		setLayout(new GridBagLayout());
		
		JLabel label1 = new JLabel("Number of Floors");
		JLabel label2 = new JLabel("Button Color");
		JLabel label3 = new JLabel("Button Pressed Color");
		JLabel label4 = new JLabel("Car Type");
		JLabel label5 = new JLabel("User panel queue Type");
		
		JLabel label6 = new JLabel("User panel Numbering Type");
		
		//code add - Lavanya
		JLabel label7 = new JLabel("User panel Alarm Type");
		//end
		
		//JLabel label3 = new JLabel("Queue Type");
		//JLabel label4 = new JLabel("Number of Floors");
		//JLabel label5 = new JLabel("Number of Floors");
		
		
		
		 int centerRow = 0;
		   GridBagConstraints gbc = new GridBagConstraints();
		    gbc.gridy = centerRow++;
		   		    
		    add(label1,gbc);
		    gbc.gridx = 1;
		    add(list1,gbc);
		    
		    gbc.gridy = centerRow++;
		    gbc.gridx = 0;
		    add(label2,gbc);
		    gbc.gridx = 1;
		    add(list2,gbc);
		    
		    gbc.gridy = centerRow++;
		    gbc.gridx = 0;
		    add(label3,gbc);
		    gbc.gridx = 1;
		    add(list5,gbc);
		    
		    gbc.gridy = centerRow++;
		    gbc.gridx = 0;
		    add(label4,gbc);
		    gbc.gridx = 1;
		    add(list3,gbc);
		    
		    gbc.gridy = centerRow++;
		    gbc.gridx = 0;
		    add(label5,gbc);
		    gbc.gridx = 1;
		    add(list4,gbc);
		   
		    gbc.gridy = centerRow++;
		    gbc.gridx = 0;
		    add(label6,gbc);
		    gbc.gridx = 1;
		    add(list6,gbc);
		    
		    //code add - Lavanya
		    gbc.gridy = centerRow++;
		    gbc.gridx = 0;
		    add(label7,gbc);
		    gbc.gridx = 1;
		    add(list7,gbc);
		    //code end
		    
		    gbc.gridx = 1;
		   //code modify - Lavanya gbc.gridy = 6;
		    gbc.gridy = 9;
		    JButton ok = new JButton ("OK");
			add(ok, gbc);
			
			InitialAction initialaction= new InitialAction(owner);
  		    ok.addActionListener(initialaction);
	}
	
	
	private class InitialAction implements ActionListener 
	   {
		
		Main appUI = null;
	       public  InitialAction(Main owner){
	    	   appUI = owner;
	       }

	       public void actionPerformed(ActionEvent event)
	       {
	    	  
	    	   String floorNum = (String)list1.getSelectedItem();
	    	   System.out.println("Floor Num="+floorNum);
               int floorn=Integer.parseInt(floorNum);
	    	  UserPanelConfiguration.setNumberFloors(floorn);
	    	  
	    	  
	    	  String numberingType = (String)list6.getSelectedItem();
	    	   System.out.println("Floor Num="+numberingType);
	    	   
	    	   if(numberingType.equalsIgnoreCase("Current")){
		    		  UserPanelConfiguration.setSelection(0);
		    	  }
	    	   if(numberingType.equalsIgnoreCase("Even")){
		    		  UserPanelConfiguration.setSelection(1);
		    	  }
	    	   if(numberingType.equalsIgnoreCase("Odd")){
		    		  UserPanelConfiguration.setSelection(2);
		    	  }	    	   
             
	    	  
	    	  
	    	  String color = (String)list2.getSelectedItem();
	    	  System.out.println("color="+color);
	    	  if(color.equals("RED")){
	    		  UserPanelConfiguration.setButtonColor(UserPanelColor.RED);
	    	  }
	    	  if(color.equals("BLUE")){
	    		  UserPanelConfiguration.setButtonColor(UserPanelColor.BLUE);
	    	  }
	    	  if(color.equals("GREEN")){
	    		  UserPanelConfiguration.setButtonColor(UserPanelColor.GREEN);
	    	  }
	    	  if(color.equals("YELLOW")){
	    		  UserPanelConfiguration.setButtonColor(UserPanelColor.YELLOW);
	    	  }
	    	  
	    	  
	    	  color = (String)list5.getSelectedItem();
	    	  System.out.println("color="+color);
	    	  if(color.equals("RED")){
	    		  UserPanelConfiguration.setActiveButtonColor(UserPanelColor.RED);
	    	  }
	    	  if(color.equals("BLUE")){
	    		  UserPanelConfiguration.setActiveButtonColor(UserPanelColor.BLUE);
	    	  }
	    	  if(color.equals("GREEN")){
	    		  UserPanelConfiguration.setActiveButtonColor(UserPanelColor.GREEN);
	    	  }
	    	  if(color.equals("YELLOW")){
	    		  UserPanelConfiguration.setActiveButtonColor(UserPanelColor.YELLOW);
	    	  }
	    	  
	    	  UserPanelConfiguration.setCarType((String)list3.getSelectedItem());
	    	  UserPanelConfiguration.setQueueType((String)list4.getSelectedItem());
	    	  
	    	  
	    	  
	    	  UserPanelConfiguration.setNumberFloors(floorn);
	    	  
	    	  //add code - Lavanya
	    	  
	    	  UserPanelConfiguration.setAlarmType((String)list7.getSelectedItem());
	    	
	    	  //end  
            
	    	  appUI.disposeMainScreenComponents();
	    	  appUI.createUI();
	    	  
	    	  
	    	  
	    	  
	       }
	      
	    }

}
