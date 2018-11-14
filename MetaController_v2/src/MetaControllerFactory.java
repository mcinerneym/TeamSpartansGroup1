

public class MetaControllerFactory {
	
	public static IMetaController getMetaControllerInstance(){
		IMetaController metaController = null;
		
		if(MetaControllerConfiguration.getMetaControllerType().equalsIgnoreCase("default")){
			metaController = new MetaController();
		}
		
		if(MetaControllerConfiguration.getAlgorithm().equalsIgnoreCase("Shortest Path")){
			metaController.setAlgorithm(new ShortestPathAlgorithm());
		}else if(MetaControllerConfiguration.getAlgorithm().equalsIgnoreCase("Random")){
//			metaController.setAlgorithm(new RandomAlgorithm());
		}
		
		/* *******Anshu Added*********** */
		else if(MetaControllerConfiguration.getAlgorithm().equalsIgnoreCase("SCAN")){
			System.out.println("Anshu - Metafactory- inside scan");
			metaController.setAlgorithm(new ScanAlgorithm());
		}
		/* **********End Add************** */
		
		return metaController;
	}

}
