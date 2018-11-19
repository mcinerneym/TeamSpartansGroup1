import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class DoorPanelUI extends JPanel
{

	JButton openButton = null;
	
	JButton closeButton = null;
		
	DoorPanelQueue doorPanelQueue = null;
	
	public DoorPanelUI(DoorPanelQueue doorPanelQueue, String openText, String closeText)
	{
		
		this.doorPanelQueue = doorPanelQueue;
		setLayout (new FlowLayout());
		openButton = new JButton(openText);
		OpenListener openListener = new OpenListener();
	    openButton.addActionListener(openListener);
	    add(openButton);
		closeButton = new JButton(closeText);
		CloseListener closeListener = new CloseListener();
		closeButton.addActionListener(closeListener);
		add(closeButton);
	}
	
	void activateOpenButton(){
		
		openButton.setBackground(Color.YELLOW);
	}
	
	void activateCloseButton(){
		closeButton.setBackground(Color.YELLOW);
	}
	
	void deactivateOpenButton(){
		System.out.println("Inside deactivate..........");
		openButton.setBackground(null);
	}
	
	void deactivateCloseButton(){
		closeButton.setBackground(null);
	}
	
	private class OpenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			doorPanelQueue.putDoorPanelRequest(DoorCommand.OPEN);
		}
	}
	
	private class CloseListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			doorPanelQueue.putDoorPanelRequest(DoorCommand.CLOSE);
		}
	}


}

