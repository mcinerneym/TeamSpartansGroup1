
public class DoorPanelConfiguration {

	static private String carType = "default";
	static private String carControllerType = "default";
	static private String doorPanelType = "default";
	static private String textType = "symbol";
	
	
	public static String getTextType() {
		return textType;
	}
	public static void setTextType(String textType) {
		DoorPanelConfiguration.textType = textType;
	}
	public static String getDoorPanelType() {
		return doorPanelType;
	}
	public static void setDoorPanelType(String doorPanelType) {
		DoorPanelConfiguration.doorPanelType = doorPanelType;
	}
	public static String getCarType() {
		return carType;
	}
	public static void setCarType(String carType) {
		DoorPanelConfiguration.carType = carType;
	}
	public static String getCarControllerType() {
		return carControllerType;
	}
	public static void setCarControllerType(String carControllerType) {
		DoorPanelConfiguration.carControllerType = carControllerType;
	}
	
	
	
}
