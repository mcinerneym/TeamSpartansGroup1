
import java.awt.Color;


public enum FloorPanelColor {

	BLUE,
	GREEN,
	RED,
	YELLOW;
	
	
	
	public Color getJColor(){
		
		
		Color color = null;
		switch(this){
			case BLUE:
				color =  Color.BLUE;
				break;
			case GREEN:
				color =  Color.GREEN;
				break;
			case RED:
				color =  Color.RED;
				break;
			case YELLOW:
				color =  Color.YELLOW;
				break;
			
		}
		return color;
	}
}
