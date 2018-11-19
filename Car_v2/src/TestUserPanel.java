import javax.swing.JLabel;
import javax.swing.JPanel;


public class TestUserPanel implements IUserPanel{

	int selection;
	
	@Override
	public JPanel createUserPanel() {
		JPanel j = new JPanel();
		j.add(new JLabel("This is test user panel"));
		return j ;
	}
	public int getSelection() {
		return selection;
	}

	public void setSelection(int selection) {
		this.selection = selection;
	}

	@Override
	public void deactivateFloorButton(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActiveButtonColor(UserPanelColor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setButtonColor(UserPanelColor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCar(ICar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNumberFloors(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setAlarmType(String alarmType) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setAlarmStatus(String alarmStatus) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getAlarmStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getNumberFloors() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void processAlarmRequest(String alarmStatus, int carId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setMetaController(IMetaController metaController) {
		// TODO Auto-generated method stub
		
	}

}
