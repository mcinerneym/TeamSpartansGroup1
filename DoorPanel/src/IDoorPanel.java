import javax.swing.JPanel;


public interface IDoorPanel {

	JPanel createDoorPanelUI();
	
	void setCar(ICar car);
	
	void activateOpenButton();
	
	void activateCloseButton();
	
	void deactivateOpenButton();
	
	void deactivateCloseButton();
	
	void setCloseText(String text);
	
	void setOpenText(String text);
	
	
}
