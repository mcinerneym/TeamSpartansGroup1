
public class FloorPanelFactory 
{
	public static IFloorPanel createFloorPanel()
	{
		IFloorPanel ifloorPanel = null;
		
		
		
		if(FloorPanelConfiguration.getfloorPanelQueueType().equalsIgnoreCase("default"))
		{
			ifloorPanel = new FloorPanel();
			ifloorPanel.setFloorPanelQueueType(new FloorPanelQueue());
			ifloorPanel.setButtonColor(FloorPanelConfiguration.getButtonColor());
			ifloorPanel.setActiveButtonColor(FloorPanelConfiguration.getActiveButtonColor());;
			//add code - Lavanya
			ifloorPanel.setNumAlarmIndicators(FloorPanelConfiguration.getNumAlarmIndicators());
		}
		

		if (FloorPanelConfiguration.getTextType().equalsIgnoreCase("text")){
			ifloorPanel.setUpText("UP");
			ifloorPanel.seDownText("DOWN");
		}else if (FloorPanelConfiguration.getTextType().equalsIgnoreCase("symbol")){
			ifloorPanel.setUpText("^");
			ifloorPanel.seDownText("v");
		
		}
		
			
		return ifloorPanel;
	}
}
