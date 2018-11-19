import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main 
{
	
	public static void main (String agrs[])
	{
		JFrame frame = new JFrame();
		int numberOfFloors = 5;
		//int numberOfFloors = UserPanel 's getNumberFloors();
		frame.setLayout(new FlowLayout());
	    IFloorPanel ifloorPanel = null;
		FloorPanelConfiguration.setfloorPanelQueueType("default");
		for(int i=numberOfFloors;i>=1;i--)
		{		
			ifloorPanel = FloorPanelFactory.createFloorPanel();
			JPanel panel = ifloorPanel.createFloorPanel(i);
			if(i==numberOfFloors){
				System.out.println("Heloooooooo");
				ifloorPanel.disableUpButton();
			}
			
			if(i==1)
				ifloorPanel.disableDownButton();
			
			frame.add(panel);
		}
		frame.setSize(100, 500);
		frame.setVisible(true);
	}
}
