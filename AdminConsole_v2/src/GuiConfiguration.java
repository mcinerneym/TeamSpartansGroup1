import java.util.ArrayList;


public class GuiConfiguration {
	
	private static int numOfFloors = 10;
	private static int numOfCars = 5;
	private static String doorConfiguration = "Alternate Single/Double Door";
	private static String userPanelColor = "Green";
	private static String userPanelPressedButtonColor = "Red";
	private static String floorPanelColor = "Yellow";
	private static String floorPanelPressedButtonColor = "Blue";
	private static String floorPanelDisplay = "Symbol";
	private static String doorPanelDisplay = "text";
	private static String algorithmType = "Shortest Path";
	private static String alarmType = "text";
	
	private static ArrayList<Integer> selectioArray=new ArrayList<Integer>();
	
	public static ArrayList<Integer> getSelectioArray() {
		return selectioArray;
	}
	public static void setSelectioArray(ArrayList<Integer> selectioArray) {
		GuiConfiguration.selectioArray = selectioArray;
	}
	private static int userPanelType=0;
	
	public static int getUserPanelType() {
		return userPanelType;
	}
	public static void setUserPanelType(int userPanelType) {
		GuiConfiguration.userPanelType = userPanelType;
	}
	public static int getNumOfFloors() {
		return numOfFloors;
	}
	public static void setNumOfFloors(int numOfFloors) {
		GuiConfiguration.numOfFloors = numOfFloors;
	}
	public static int getNumOfCars() {
		return numOfCars;
	}
	public static void setNumOfCars(int numOfCars) {
		GuiConfiguration.numOfCars = numOfCars;
	}
	public static String getDoorConfiguration() {
		return doorConfiguration;
	}
	public static void setDoorConfiguration(String doorConfiguration) {
		GuiConfiguration.doorConfiguration = doorConfiguration;
	}
	public static String getUserPanelColor() {
		return userPanelColor;
	}
	public static void setUserPanelColor(String userPanelColor) {
		GuiConfiguration.userPanelColor = userPanelColor;
	}
	public static String getUserPanelPressedButtonColor() {
		return userPanelPressedButtonColor;
	}
	public static void setUserPanelPressedButtonColor(
			String userPanelPressedButtonColor) {
		GuiConfiguration.userPanelPressedButtonColor = userPanelPressedButtonColor;
	}
	
	public static String getFloorPanelPressedButtonColor() {
		return floorPanelPressedButtonColor;
	}
	public static void setFloorPanelPressedButtonColor(
			String floorPanelPressedButtonColor) {
		GuiConfiguration.floorPanelPressedButtonColor = floorPanelPressedButtonColor;
	}
	public static String getFloorPanelDisplay() {
		return floorPanelDisplay;
	}
	public static void setFloorPanelDisplay(String floorPanelDisplay) {
		GuiConfiguration.floorPanelDisplay = floorPanelDisplay;
	}
	public static String getDoorPanelDisplay() {
		return doorPanelDisplay;
	}
	public static void setDoorPanelDisplay(String doorPanelDisplay) {
		GuiConfiguration.doorPanelDisplay = doorPanelDisplay;
	}
	public static String getAlgorithmType() {
		return algorithmType;
	}
	public static void setAlgorithmType(String algorithmType) {
		GuiConfiguration.algorithmType = algorithmType;
	}
	public static void setFloorPanelColor(String floorPanelColor) {
		GuiConfiguration.floorPanelColor = floorPanelColor;
	}
	public static String getFloorPanelColor() {
		return floorPanelColor;
	}
	public static void setAlarmType(String alarmType){
		GuiConfiguration.alarmType = alarmType;
	}
	public static String getAlarmType(){
		return alarmType;
	}

}
