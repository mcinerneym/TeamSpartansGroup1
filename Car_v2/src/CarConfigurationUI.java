import javax.swing.*;
import com.jgoodies.forms.layout.*;
/*
 * Created by JFormDesigner on Wed Apr 28 14:11:21 PDT 2010
 */



/**
 * @author sandhya rajagopalan
 */
public class CarConfigurationUI  {

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - sandhya rajagopalan
		panel1 = new JPanel();
		label4 = new JLabel();
		comboBox1 = new JComboBox();
		label2 = new JLabel();
		comboBox2 = new JComboBox();
		label3 = new JLabel();
		comboBox3 = new JComboBox();
		CellConstraints cc = new CellConstraints();

		//======== panel1 ========
		{

			// JFormDesigner evaluation mark
			panel1.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel1.setLayout(new FormLayout(
				"7*(default)",
				"9*(default)"));

			//---- label4 ----
			label4.setText(" User Panel type");
			panel1.add(label4, cc.xy(3, 5));
			panel1.add(comboBox1, cc.xy(4, 5));

			//---- label2 ----
			label2.setText("Door Type");
			panel1.add(label2, cc.xy(3, 6));
			panel1.add(comboBox2, cc.xy(4, 6));

			//---- label3 ----
			label3.setText("User panel queue type");
			panel1.add(label3, cc.xy(3, 7));
			panel1.add(comboBox3, cc.xy(4, 7));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - sandhya rajagopalan
	private JPanel panel1;
	private JLabel label4;
	private JComboBox comboBox1;
	private JLabel label2;
	private JComboBox comboBox2;
	private JLabel label3;
	private JComboBox comboBox3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
