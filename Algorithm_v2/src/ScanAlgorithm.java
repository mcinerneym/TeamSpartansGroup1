/* created by Anshu */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ScanAlgorithm implements IAlgorithm {

	@Override
	
	
	public ICar findBestCar(List<ICar> lstCars, Direction direction, int destinationFloorNumber) {
		
		ICar bestCar = null;
		//int pathLength = 0;
		
		System.out.println("Anshu-------------------------inside Scan");
		
		if(lstCars.size() ==1){
			bestCar = lstCars.get(0);
			return bestCar;
		}
		
		lstCars =partitionCars(lstCars,destinationFloorNumber);
				
		for(int i=0;i<lstCars.size();i++){
			System.out.println("After Separating");
			System.out.println("Car  is of type : "+i+lstCars.get(i).getUserPanel().getSelection());				
		}
		
		
		
		for(int i=0; i< lstCars.size(); i++){			
			
			ICar car = lstCars.get(i);
			
			
			System.out.println("Inside loop ..."+ car + " "+i );
			System.out.println("Car status: " + car.getStatus());
			System.out.println("car floor: " + car.getCurrentFloorNumber());
			
			//if(pathLength < car.getUserPanelQueue().pathLength(direction, destinationFloorNumber)){
			if((direction == Direction.UP) & ((car.getStatus() == CarStatus.MOVING_UP) || ((car.getStatus() == CarStatus.STOPPED) & (car.getUserPanelQueue().isRequestUp() == 1) )) & (car.getCurrentFloorNumber() <= destinationFloorNumber ) ) {	 
				bestCar = lstCars.get(i);
				break;	
			}else if((direction == Direction.DOWN) & ((car.getStatus() == CarStatus.MOVING_DOWN) || ((car.getStatus() == CarStatus.STOPPED) & (car.getUserPanelQueue().isRequestDown() == 1) )) & (car.getCurrentFloorNumber() >= destinationFloorNumber ) ) {
				bestCar = lstCars.get(i);
				break;	
				}else if(car.getStatus() == CarStatus.IDLE)
					{	bestCar = lstCars.get(i);
					}
			}
		if(bestCar == null){
			System.out.println("no best car found so randomly assigning a car..........");
			Random generator = new Random();
			int randomInt = generator.nextInt(lstCars.size());
			bestCar = lstCars.get(randomInt);
		}
		
		System.out.println("Best Car = " + bestCar.toString());		
		// TODO Auto-generated method stub
		return bestCar;
	}
	
		
	//}
	private List<ICar> partitionCars(List<ICar> lstCars, int destinationFloorNumber) {
		// TODO Auto-generated method stub
		
		ArrayList<ICar> oddCars=new ArrayList<ICar>();
		ArrayList<ICar> evenCars=new ArrayList<ICar>();
		//ArrayList<ICar> seqCars= new ArrayList<ICar>();
		
		for(int i=0;i<lstCars.size();i++){
				ICar car1=lstCars.get(i);
				IUserPanel us=car1.getUserPanel();
				System.out.println("Car 1 "+i+"selection"+us.getSelection());
				if(us.getSelection()==1)
					evenCars.add(car1);
				else if(us.getSelection()==2)
					oddCars.add(car1);
				else{
					oddCars.add(car1);
					evenCars.add(car1);
				}
					
					
		}
		
		if (destinationFloorNumber%2==0)
					return evenCars;
		else
			return oddCars;
		
	}

	public static void main(String args[]){
		ICar car1 = new Car();
		IUserPanel u1=new UserPanel();
		
		u1.setSelection(1);
		
		ICarController carController1 = new CarController();
		IUserPanelQueue q1 = new UserPanelQueue();
		q1.setCar(car1);
		
		car1.setCurrentFloorNumber(3);
		car1.setUserPanelQueue(q1);
		car1.setCarController(carController1);
		car1.setUserPanel(u1);

		
		
	
		u1.setCar(car1);
		carController1.setCar(car1);
		car1.setStatus(CarStatus.IDLE);
				
		
		
		List<ICar> a =  new ArrayList<ICar>();
		
		a.add(car1);
		
		
		IAlgorithm al = new ScanAlgorithm();
		
		al.findBestCar(a, Direction.UP, 1);
		
		
	}
	
	
}
