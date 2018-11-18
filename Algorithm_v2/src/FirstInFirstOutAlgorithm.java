import java.util.List;

public class FirstInFirstOutAlgorithm implements IAlgorithm {

	@Override
	public ICar findBestCar(List<ICar> lstCars, Direction direction, int destinationFloorNumber) {
		// TODO Auto-generated method stub
		ICar firstCar = null;
		if(lstCars.size() == 1) {
			firstCar = lstCars.get(0);
		}
		else if (lstCars.size() > 1) {
			firstCar = lstCars.remove(0);
			lstCars.add(firstCar);
		}
		return firstCar;
	}

}
