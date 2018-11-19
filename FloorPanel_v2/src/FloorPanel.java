import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class FloorPanel implements IFloorPanel
{

	static List<FloorPanel> lstFloorPanel = new ArrayList<FloorPanel>();
	
	private int CurrentFloorNumber;
	private FloorPanelColor color = null;
	private FloorPanelColor activeButtonColor = null;
	private IFloorPanelQueue floorPanelQueue = null;
	private String FloorPanelStatus = "idle";
	private FloorPanelUI floorPanelUI = null;
	
	private String upText = null;
	private String downText = null;
	
	//add code - Lavanya
	private int numAlarmIndicators;

	public FloorPanel(){
		lstFloorPanel.add(this);
	}
	
	@Override
	public JPanel createFloorPanel(int CurrentFloorNumber) 
	{
		this.CurrentFloorNumber = CurrentFloorNumber;
		System.out.println("creating new floor panel for floor "+ CurrentFloorNumber);
		floorPanelUI = new FloorPanelUI(this,color,activeButtonColor, CurrentFloorNumber, upText, downText, numAlarmIndicators);		
		return floorPanelUI;
	}
	
	public void setFloorPanelQueueType(IFloorPanelQueue floorPanelQueue)
	{
		this.floorPanelQueue = floorPanelQueue;
	}
	
	public IFloorPanelQueue getFloorPanelQueueType()
	{
		return  floorPanelQueue;
	}
	
	@Override
	public String getUserRequest() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getCurrentFloor() 
	{
	return CurrentFloorNumber;
	}
	
	@Override
	public void setActiveButtonColor(FloorPanelColor floorPanelColor) 
	{
		this.activeButtonColor = floorPanelColor;
		
	}

	@Override
	public void setButtonColor(FloorPanelColor floorPanelColor) 
	{
		this.color = floorPanelColor;
		
	}
	
    @Override
	public String getFloorPanelStatus() 
    {
			return FloorPanelStatus;
	}
    
    public void setFloorPanelStatus(String FloorPanelStatus)
    {
    	this.FloorPanelStatus = FloorPanelStatus;
    	System.out.println("Status set to "+FloorPanelStatus);
    }

	@Override
	public void disableDownButton() {
		floorPanelUI.disableDownButton();
		
	}

	@Override
	public void disableUpButton() {
		floorPanelUI.disableUpButton();
		
	}

	@Override
	public void seDownText(String text) {
		this.downText = text;
		
	}

	@Override
	public void setUpText(String text) {
		this.upText = text;
		
	}

	@Override
	public void processedRequest(int floorNumber) {
		
		FloorPanel floorPanel = lstFloorPanel.get(lstFloorPanel.size() - floorNumber);
		floorPanel.floorPanelUI.processedRequest();
		
	}
	public void processIndicatorRequest(int floorNumber,int id,String type) {
		
		FloorPanel floorPanel = lstFloorPanel.get(lstFloorPanel.size() - floorNumber);
		floorPanel.floorPanelUI.processIndicatorRequest(id,type);
		
	}
	public void processStatusRequest(int floorNumber,int currentFloor) {
		
		FloorPanel floorPanel = lstFloorPanel.get(lstFloorPanel.size() - floorNumber);
		floorPanel.floorPanelUI.processStatusRequest(currentFloor);		
	}
	
	//add code - Lavanya
	
	public void setNumAlarmIndicators(int numAlarmIndicators){
		this.numAlarmIndicators = numAlarmIndicators;
	}
	
	public int getNumAlarmIndicators(){
		return numAlarmIndicators;
	}
	
	public void processAlarmRequest(String alarmStatus, int carId){
		System.out.println("in floorpanel :alarm pressed");
		  for(int i=0;i<lstFloorPanel.size();i++)
		  {
			  FloorPanel floorPanel = lstFloorPanel.get(i);
			  floorPanel.floorPanelUI.processAlarmRequest(alarmStatus,carId);
			
	}
	
	}
}


