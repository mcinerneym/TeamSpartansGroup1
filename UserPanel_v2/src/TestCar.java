import javax.swing.JPanel;


public class TestCar implements ICar {

	
	IUserPanelQueue usePanelQueue = null;
	IUserPanel userPanel1 = null;
	ICarController carController = null;
	int carId = 0;
	
	
	@Override
	public JPanel createCar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICarController getCarController() {
		// TODO Auto-generated method stub
		return carController;
	}

	@Override
	public int getCurrentFloorNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IUserPanelQueue getUserPanelQueue() {
		// TODO Auto-generated method stub
		return usePanelQueue;
	}

	@Override
	public void setCarController(ICarController arg0) {
		// TODO Auto-generated method stub
         carController = arg0;      
	}

	@Override
	public void setCurrentFloorNumber(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDoor(IDoor arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUserPanel(IUserPanel arg0) {
		// TODO Auto-generated method stub
		userPanel1 = arg0;

	}

	@Override
	public void setUserPanelQueue(IUserPanelQueue arg0) {
		this.usePanelQueue = arg0;

	}

	@Override
	public IDoor getDoor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarStatus getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IUserPanel getUserPanel() {
		// TODO Auto-generated method stub
		return userPanel1;
	}

	@Override
	public void moveDown(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatus(CarStatus arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IDoorPanel getDoorPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDoorPanel(IDoorPanel arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void setCarId(int arg0){
		
	}
	
	public int getCarId(){
		return 0;
	}
	
	public String getCarType(){
		return "seq";
	}

	@Override
	public void setCarID(int id) {
		// TODO Auto-generated method stub
		carId = id;
	}

	@Override
	public int getCarID() {
		// TODO Auto-generated method stub
		return carId;
	}

}
