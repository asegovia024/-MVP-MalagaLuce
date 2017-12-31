package Vistas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class test extends JPanel {


	private void button2ActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Paco Lopez
		panel4 = new JPanel();
		scrollPane1 = new JScrollPane();
		panel5 = new JPanel();
		label1 = new JLabel();
		label2 = new JLabel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		button2 = new JButton();
		button3 = new JButton();

		//======== panel4 ========
		{
			panel4.setBorder(new TitledBorder("Acci\u00f3n 1"));

			// JFormDesigner evaluation mark
			panel4.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel4.getBorder())); panel4.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel4.setLayout(new GridBagLayout());

			//======== scrollPane1 ========
			{

				//======== panel5 ========
				{
					panel5.setLayout(new GridBagLayout());
					((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
					((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
					((GridBagLayout)panel5.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
					((GridBagLayout)panel5.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

					//---- label1 ----
					label1.setText("Fecha:");
					panel5.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 5), 0, 0));

					//---- label2 ----
					label2.setText("Fecha aqui");
					panel5.add(label2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 5), 0, 0));

					//======== panel6 ========
					{
						panel6.setLayout(null);

						{ // compute preferred size
							Dimension preferredSize = new Dimension();
							for(int i = 0; i < panel6.getComponentCount(); i++) {
								Rectangle bounds = panel6.getComponent(i).getBounds();
								preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
								preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
							}
							Insets insets = panel6.getInsets();
							preferredSize.width += insets.right;
							preferredSize.height += insets.bottom;
							panel6.setMinimumSize(preferredSize);
							panel6.setPreferredSize(preferredSize);
						}
					}
					panel5.add(panel6, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 5), 0, 0));

					//======== panel7 ========
					{
						panel7.setLayout(new GridBagLayout());

						//---- button2 ----
						button2.setText("Validar");
						panel7.add(button2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 5, 0), 0, 0));

						//---- button3 ----
						button3.setText("Rechazar");
						panel7.add(button3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
					}
					panel5.add(panel7, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 5), 0, 0));
				}
				scrollPane1.setViewportView(panel5);
			}
			panel4.add(scrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Paco Lopez
	private JPanel panel4;
	private JScrollPane scrollPane1;
	private JPanel panel5;
	private JLabel label1;
	private JLabel label2;
	private JPanel panel6;
	private JPanel panel7;
	private JButton button2;
	private JButton button3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
