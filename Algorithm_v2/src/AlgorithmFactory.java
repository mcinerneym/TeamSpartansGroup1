
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
		//Added by Michael McInerney
		else if(AlgorithmConfiguration.getAlgorithm().equalsIgnoreCase("First in first out")){
			algorithm = new FirstInFirstOutAlgorithm();
		}
		
		return algorithm;
	}
	
}
