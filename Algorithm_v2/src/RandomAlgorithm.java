import java.util.List;
import java.util.Random;


public class RandomAlgorithm implements IAlgorithm {

	@Override
	public ICar findBestCar(List<ICar> lstCars, Direction direction,
			int destinationFloorNumber) {
		
		ICar bestCar = null;
		
		if(lstCars.size() ==1){
			bestCar = lstCars.get(0);
			return bestCar;
		}
		
		Random generator = new Random();
		int randomInt = generator.nextInt(lstCars.size());
		bestCar = lstCars.get(randomInt);
		
		
		return bestCar;
	}

}
