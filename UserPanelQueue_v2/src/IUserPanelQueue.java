
public interface IUserPanelQueue {
	
	void putMessage(int destinationFloorNumber);
	
	int getNumTasks();
	
	int pathLength(Direction direction, int destinationFloorNumber);
	
	void setCar(ICar car);
	
	//code added - Lavanya
	
	void flushQueue();
	
	//Anshu - added next two lines
	
		int isRequestUp();

		int isRequestDown();
	
}
