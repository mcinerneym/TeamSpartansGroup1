import javax.swing.JPanel;


public interface IUserPanel {
	
	
	JPanel createUserPanel();
	
	void setCar(ICar car);
	
	void setNumberFloors(int numberFloors);
    
    void setButtonColor(UserPanelColor color);
    
    void setActiveButtonColor(UserPanelColor color);
    
    void deactivateFloorButton(int floorNumber);
	
    void setSelection(int selection);
    
    int getSelection();
    
    //code add - Lavanya
    void setAlarmType(String alarmType);
    
    void setAlarmStatus(String alarmStatus);
    
    String getAlarmStatus();
    
    int getNumberFloors();
    
    void processAlarmRequest(String alarmStatus, int carId);
    
    void setMetaController(IMetaController metaController);
    //end
}
