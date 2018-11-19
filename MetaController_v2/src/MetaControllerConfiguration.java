
public class MetaControllerConfiguration {
	
	private static String metaControllerType = "default";
	
	private static String algorithm = "shortestPath";

	public static String getMetaControllerType() {
		return metaControllerType;
	}
	
	public static void setMetaControllerType(String metaControllerType) {
		MetaControllerConfiguration.metaControllerType = metaControllerType;
	}

	public static String getAlgorithm() {
		return algorithm;
	}

	public static void setAlgorithm(String algorithm) {
		MetaControllerConfiguration.algorithm = algorithm;
	}
	
	

}
