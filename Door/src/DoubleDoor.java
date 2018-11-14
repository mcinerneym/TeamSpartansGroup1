import javax.swing.JFrame;
import javax.swing.JPanel;


public class DoubleDoor implements IDoor{
	
	
	//ICar car = null;
	
	ICarController carController = null;
	
	String doorStatus = "CLOSED";
	
	DoubleDoorUI doubleDoorUI = null;
	
	@Override
	public void closeDoor() {
		DoorThread1 doorThread = new DoorThread1(this, "Close");
		Thread thread = new Thread(doorThread);
		thread.start();
		
	}

	@Override
	public void openDoor() {
		
		DoorThread1 doorThread= new DoorThread1(this, "Open");
		Thread thread = new Thread(doorThread);
		thread.start();
		
	}

	/*@Override
	public void setCar(ICar car) {
		this.car = car;
		
	}*/

	@Override
	public void setCarController(ICarController carController) {
		this.carController = carController;
		
	}

	@Override
	public JPanel createDoorUI() {
		
		doubleDoorUI = new DoubleDoorUI();
		return doubleDoorUI;
	}

	@Override
	public String getDoorStatus() {
		// TODO Auto-generated method stub
		return doorStatus;
	}

	@Override
	public void setDoorStatus(String doorStatus) {
		this.doorStatus = doorStatus;
		doubleDoorUI.setDoorStatus(doorStatus);
		
		
		
	}
	
	public static void main(String[] args){
		IDoor door = new SingleDoor();
		JFrame j = new JFrame();
		j.add(door.createDoorUI());
		j.setVisible(true);
		
		synchronized(door){
			door.openDoor();
			try {
				door.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}


class DoorThread1 implements Runnable{
	
	
	IDoor door = null;
	
	String command = null;
	
	DoorThread1(IDoor door, String command){
		this.door = door;
		this.command = command;
	}

	@Override
	public void run() {
		
		int i = 0;
		if(command.equalsIgnoreCase("Open")){
			synchronized(door){
				while( i < 5){
					System.out.println("i value"+i);
					door.setDoorStatus("OPENING");
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					i = i+2;
					
				}
				
				door.setDoorStatus("OPENED");
				door.notifyAll();
			}
		}else{
			
			synchronized(door){
				while( i < 5){
					System.out.println("i value"+i);
					door.setDoorStatus("CLOSING");
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					i = i+2;
					
				}
				
				door.setDoorStatus("CLOSED");
				door.notifyAll();
			}
			
		}
		
	}
	

	
}