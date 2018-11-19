
public class UserPanelQueueConfiguration {
	
	public static String userPanelQueueType = "default";
	
	public static String carType = "default";
	
	public static String carControllerType = "default";

	public static String getUserPanelQueueType() {
		return userPanelQueueType;
	}

	public static void setUserPanelQueueType(String userPanelQueueType) {
		UserPanelQueueConfiguration.userPanelQueueType = userPanelQueueType;
	}

	public static String getCarType() {
		return carType;
	}

	public static void setCarType(String carType) {
		UserPanelQueueConfiguration.carType = carType;
	}

	public static String getCarControllerType() {
		return carControllerType;
	}

	public static void setCarControllerType(String carControllerType) {
		UserPanelQueueConfiguration.carControllerType = carControllerType;
	}

}
