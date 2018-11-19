import java.util.List;

public class FirstInFirstOutAlgorithm implements IAlgorithm {

	@Override
	public ICar findBestCar(List<ICar> lstCars, Direction direction, int destinationFloorNumber) {
		// TODO Auto-generated method stub
		ICar bestCar = null;
		
		if(lstCars.size() == 1) {
			//Only one car, so this is the best car
			bestCar = lstCars.get(0);
			return bestCar;
		}
		
		for(int i = 0; i < lstCars.size()-1; i++) {
			ICar currentCar = lstCars.get(i);
			int carFloor = currentCar.getCurrentFloorNumber();
			CarStatus currentStatus = currentCar.getStatus();
			
			//The best car for the user would be the one going toward their destination floor number
			if(destinationFloorNumber > carFloor) {
				if(currentStatus == CarStatus.MOVING_UP) {
					bestCar = currentCar;
				}
			}
			if(destinationFloorNumber < carFloor) {
				if(currentStatus == CarStatus.MOVING_DOWN) {
					bestCar = currentCar;
				}
			}
			System.out.print("Current best car" + bestCar.getCarID());
			//If neither condition is satisfied, then were on the same floor were trying to go too
		}
		
		return bestCar;
	}

}
