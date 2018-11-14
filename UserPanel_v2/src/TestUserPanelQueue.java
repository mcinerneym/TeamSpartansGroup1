
public class TestUserPanelQueue implements IUserPanelQueue{

	@Override
	public int getNumTasks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pathLength(Direction arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void putMessage(int arg0) {
		System.out.println("Message put in queue " + arg0);
		
	}

	@Override
	public void setCar(ICar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flushQueue() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int isRequestUp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int isRequestDown() {
		// TODO Auto-generated method stub
		return 0;
	}

}
