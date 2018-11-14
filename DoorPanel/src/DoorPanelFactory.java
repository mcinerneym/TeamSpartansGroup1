
public class DoorPanelFactory {

	public static IDoorPanel createDoorPanel()
	{
		
		IDoorPanel iDoorPanel= null;
		
		if(DoorPanelConfiguration.getDoorPanelType().equalsIgnoreCase("default")){
			iDoorPanel = new DoorPanel();		
		}
		
		if(DoorPanelConfiguration.getCarType().equalsIgnoreCase("default")){
			ICar car = new Car();
			iDoorPanel.setCar(car);
			
		}
		
		if (DoorPanelConfiguration.getTextType().equalsIgnoreCase("text")){
			iDoorPanel.setOpenText("OPEN");
			iDoorPanel.setCloseText("CLOSE");
		}else if (DoorPanelConfiguration.getTextType().equalsIgnoreCase("symbol")){
			iDoorPanel.setOpenText("<|>");
			iDoorPanel.setCloseText(">|<");
		}
		
		
		
	
	return iDoorPanel;
}}
