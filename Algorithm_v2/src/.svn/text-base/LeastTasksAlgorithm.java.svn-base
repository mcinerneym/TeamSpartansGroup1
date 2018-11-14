import java.util.List;


public class LeastTasksAlgorithm implements IAlgorithm {

	@Override
	public ICar findBestCar(List<ICar> lstCars, Direction direction, int destinationFloorNumber) {
		
		ICar bestCar = null;
		int numTasks = 0;
		if(lstCars.size() > 0){
			numTasks = lstCars.get(0).getUserPanelQueue().getNumTasks();
		}
		
		if(lstCars.size() ==1){
			bestCar = lstCars.get(0);
			return bestCar;
		}
		
		for(int i=0; i< lstCars.size()-1; i++){
			if(numTasks < lstCars.get(i+1).getUserPanelQueue().getNumTasks()){
				
			}else{
				numTasks = lstCars.get(i+1).getUserPanelQueue().getNumTasks();
			}
		}
		
		
		return null;
	}
	
	

}
