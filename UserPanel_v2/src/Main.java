import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main  {
	
	private static JPanel panel = null;
	static JFrame frame = new JFrame();
	
	
	public Main(){
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(300, 300));
		
		
		panel = new UserPanelConfigurationUI(this) ;
		frame.add(panel,BorderLayout.CENTER);
		
		
		 frame.setSize(640, 400);
	//	frame.add(UserPanelFactory.getUserPanelInstance().createUserPanel());
		
		frame.setVisible(true);
		
	}
	public static void main(String args[]){
		
		new Main();
	}
	
	public void createUI(){
		frame.setLayout(new BorderLayout());
		
		frame.add(UserPanelFactory.getUserPanelInstance().createUserPanel(), BorderLayout.CENTER);
		frame.setSize(new Dimension(640, 400));
		frame.setVisible(true);
	}
	
	public void disposeMainScreenComponents() {
		if (panel != null) {

			frame.getContentPane().remove(panel);
			panel = null;
		}
	}

}
