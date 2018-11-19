
import java.util.ArrayList;
import java.util.List;


public class MetaController implements IMetaController {
	
	
	private List<ICar> lstCars = new ArrayList<ICar>();
	
	private IAlgorithm algorithm = null;

	public void setAlgorithm(IAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	@Override
	public void processRequest(int destinationFloorNumber, Direction direction) {
		
		ICar car = algorithm.findBestCar(lstCars,direction,destinationFloorNumber);
		
		car.getUserPanelQueue().putMessage(destinationFloorNumber);
		
		
		
	}

	@Override
	public void registerCar(ICar car) {
		System.out.println("MetaContrller - RegisterCar");
		if(car != null){
			lstCars.add(car);
		}
		
	}
	
	public void unregisterCar(ICar car){
		System.out.println("MetaController - unregister");
		lstCars.remove(car);
	}
	
	
}
