import java.util.LinkedList;

public class FloorPanelQueue implements IFloorPanelQueue {
	
	protected LinkedList<FloorPanelRequest> queueFloorPanelRequest = new LinkedList<FloorPanelRequest>();
	
	IMetaController metaController = null;
	
	static boolean isThreadStarted = false;

	public FloorPanelQueue() {
		
	}

	protected LinkedList<FloorPanelRequest> getQueueFloorPanelRequest() {
		return queueFloorPanelRequest;
	}

	@Override
	public void dispatchFloorRequest(int currentFloornumber, Direction direction) {
		System.out.println("dispatching requests to meta controller..."
				+ currentFloornumber + " " + direction);
		//
	}

	public void setMetaContoller(IMetaController metaController) {
		this.metaController = metaController;
		
	}

	@Override
	public void putFloorRequest(int currentFloornumber, Direction direction) {
		
		queueFloorPanelRequest.offer(new FloorPanelRequest(currentFloornumber,direction));
		System.out.println("putting requests to floor panel queue..."
				+ currentFloornumber + " " + direction);
		System.out.println("queue : " + queueFloorPanelRequest.toString());
		
		if(isThreadStarted == false){
			Thread floorPanelQueueMonitorThread = new Thread(new FloorPanelQueueMonitorThread(this, metaController));
			floorPanelQueueMonitorThread.start();
			isThreadStarted = true;
		}
		
	}
}

class FloorPanelQueueMonitorThread implements Runnable {

	LinkedList<FloorPanelRequest> queueFloorPanelRequest = null;

	IMetaController metaController = null;
	
	public FloorPanelQueueMonitorThread(FloorPanelQueue floorPanelQueue, IMetaController metaController) {
		queueFloorPanelRequest = floorPanelQueue.getQueueFloorPanelRequest();
		this.metaController = metaController;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				while (queueFloorPanelRequest.size() != 0) {
					FloorPanelRequest floorPanelRequest = queueFloorPanelRequest.pollFirst();
					System.out.println(floorPanelRequest);
					 metaController.processRequest(floorPanelRequest.getcurrentFloornumber(), floorPanelRequest.getdirection());
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
