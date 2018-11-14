import java.util.ArrayList;
import java.util.List;


public class ShortestPathAlgorithm implements IAlgorithm {

	@Override
	
	
	public ICar findBestCar(List<ICar> lstCars, Direction direction, int destinationFloorNumber) {
		
		ICar bestCar = null;
		int pathLength = 0;
		
		
		if(lstCars.size() ==1){
			bestCar = lstCars.get(0);
			return bestCar;
		}
		
		lstCars =partitionCars(lstCars,destinationFloorNumber);
				
		for(int i=0;i<lstCars.size();i++){
			System.out.println("After Separating");
			System.out.println("Car  is of type : "+i+lstCars.get(i).getUserPanel().getSelection());				
		}
		
		
		
		
		
		
		System.out.println(lstCars.get(0).getUserPanelQueue());
		pathLength = lstCars.get(0).getUserPanelQueue().pathLength(direction, destinationFloorNumber);
		bestCar = lstCars.get(0);
		
		for(int i=1; i< lstCars.size(); i++){			
			
			ICar car = lstCars.get(i);
			
			System.out.println("Inside loop ..."+ car + " "+i );
			
			if(pathLength < car.getUserPanelQueue().pathLength(direction, destinationFloorNumber)){
				 
				
			}else{
				pathLength = car.getUserPanelQueue().pathLength(direction, destinationFloorNumber);
				bestCar = lstCars.get(i); 
			}
		}
		
		System.out.println("-------------"+ pathLength + "" +bestCar);
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
				
		
		/*ICar car2 = new Car();
		ICar car3 = new Car();
		
		
		
		
		ICarController carController1 = new CarController();
		ICarController carController2 = new CarController();
		ICarController carController3 = new CarController();
		
		IUserPanelQueue q1 = new UserPanelQueue();
		IUserPanelQueue q2 = new UserPanelQueue();
		IUserPanelQueue q3 = new UserPanelQueue();
		
		car1.setStatus(CarStatus.IDLE);
		car2.setStatus(CarStatus.IDLE);
		car3.setStatus(CarStatus.IDLE);
		
		car1.setCurrentFloorNumber(3);
		car2.setCurrentFloorNumber(4);
		car3.setCurrentFloorNumber(5);
		q1.setCar(car1);
		q2.setCar(car2);
		q3.setCar(car3);
		
		 q1.putMessage(3);
		//q1.putMessage(2);
		//q1.putMessage(4);
		//q1.putMessage(5);
		
		
	
		car1.setCarController(carController1);
		car2.setCarController(carController2);
		car3.setCarController(carController3);
		
		car1.setUserPanelQueue(q1);
		car2.setUserPanelQueue(q2);
		car3.setUserPanelQueue(q3);
		
		
		IUserPanel u1=new UserPanel();
		u1.setSelection(1);
		
		IUserPanel u2=new UserPanel();
		u2.setSelection(2);
		
		car1.setUserPanel(u1);
		car2.setUserPanel(u2);
		car3.setUserPanel(u1); 
		/*carController1.setCar(car1);
		carController2.setCar(car2);
		carController3.setCar(car3);
		*/
		List<ICar> a =  new ArrayList<ICar>();
		
		a.add(car1);
		//a.add(car2);
		//a.add(car3);
		
		IAlgorithm al = new ShortestPathAlgorithm();
		
		al.findBestCar(a, Direction.UP, 1);
		
		
	}
	
	
}
