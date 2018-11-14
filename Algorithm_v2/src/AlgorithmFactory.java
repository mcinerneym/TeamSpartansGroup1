
public class AlgorithmFactory {

	public static IAlgorithm getAlgorithmInstance(){
		IAlgorithm algorithm = null;
		
		if(AlgorithmConfiguration.getAlgorithm().equalsIgnoreCase("shortestPath")){
			algorithm = new ShortestPathAlgorithm();
		}else if(AlgorithmConfiguration.getAlgorithm().equalsIgnoreCase("leastTasks")){
			algorithm = new LeastTasksAlgorithm();
		}
		/* **********************Anshu added************ */
		else if(AlgorithmConfiguration.getAlgorithm().equalsIgnoreCase("SCAN")){
			algorithm = new ScanAlgorithm();
		}
		/* **********End Add************ */
		
		return algorithm;
	}
	
}
