import javax.swing.JLabel;
import javax.swing.JPanel;


public class TestDoor implements IDoor {

	@Override
	public void closeDoor() {
		// TODO Auto-generated method stub

	}

	@Override
	public JPanel createDoorUI() {
		JPanel j = new JPanel();
		j.add(new JLabel("This is test door"));
		return j;
	}

	@Override
	public String getDoorStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void openDoor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCarController(ICarController arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDoorStatus(String arg0) {
		// TODO Auto-generated method stub

	}

}
