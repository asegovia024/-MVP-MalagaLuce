package Vistas;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;



public class Login extends JFrame  {
	
	private static final long serialVersionUID = 1L;
	private JLabel labelUsername = new JLabel("Usuario: ");
   private JLabel labelPassword = new JLabel("Contraseña: ");
   private JTextField textUsername = new JTextField(20);
   private JPasswordField fieldPassword = new JPasswordField(20);
   private JButton buttonLogin = new JButton("Login");
    
   public Login() {
       super("JPanel Demo Program");
        
       // create a new panel with GridBagLayout manager
       JPanel newPanel = new JPanel(new GridBagLayout());
        
       GridBagConstraints constraints = new GridBagConstraints();
       constraints.anchor = GridBagConstraints.WEST;
       constraints.insets = new Insets(10, 10, 10, 10);
        
       // add components to the panel
       constraints.gridx = 0;
       constraints.gridy = 0;     
       newPanel.add(labelUsername, constraints);

       constraints.gridx = 1;
       newPanel.add(textUsername, constraints);
        
       constraints.gridx = 0;
       constraints.gridy = 1;     
       newPanel.add(labelPassword, constraints);
        
       constraints.gridx = 1;
       newPanel.add(fieldPassword, constraints);
        
       constraints.gridx = 0;
       constraints.gridy = 2;
       constraints.gridwidth = 2;
       constraints.anchor = GridBagConstraints.CENTER;
       newPanel.add(buttonLogin, constraints);
        
       // set border for the panel
       newPanel.setBorder(BorderFactory.createTitledBorder(
               BorderFactory.createEtchedBorder(), "Login Panel"));
        
       // add the panel to this frame
       add(newPanel);
        
       pack();
       setLocationRelativeTo(null);
   }
	

}
