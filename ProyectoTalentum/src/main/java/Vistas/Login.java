package Vistas;
import java.awt.GridBagConstraints;

import ProyectoTalentum.ProyectoTalentum.ControladorUser;
import ProyectoTalentum.ProyectoTalentum.Usuario;
import bdtest.helper_bd_usuario;
import javaxt.io.Image;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import javax.swing.*;


public class Login extends Framebase  {
	
	//
	private static final long serialVersionUID = 1L;
   private JTextField textUsername = new JTextField(20);
   private JPasswordField fieldPassword = new JPasswordField(20);
   private JButton buttonLogin = new JButton();
    private JPanel background;
    private ImageIcon fondo;
    private JLabel lFondo;
   public Login() {
       super("JPanel Demo Program");
       
   //
    
       Toolkit pantalla = Toolkit.getDefaultToolkit(); //Coge los datos de la pantalla
       Dimension pantallaD = pantalla.getScreenSize(); //Coge la resolución y la divide en 2 variables
       int width = pantallaD.width/2;
       int height = pantallaD.height/2;
       System.out.println(pantallaD.height + " "+ " "+pantallaD.width);
       final Image imagen = new Image("src/resources/Registro.jpg");
       imagen.resize(height,width, true);
        //create a new panel with GridBagLayout manager
       JPanel newPanel = new JPanel(new GridBagLayout()) {
    	   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
    		  protected void paintComponent(Graphics g) {

    		    super.paintComponent(g);
    		    g.drawImage(imagen.getImage(), 0, 0, null);
    		}
       };
       // background = new JPanel();
       // lFondo = new JLabel();
       // lFondo.setIcon(new ImageIcon(fondo.getImage()));
       GridBagConstraints constraints = new GridBagConstraints();
       Insets ins = new Insets(pantallaD.height/12, pantallaD.width/136, -pantallaD.height/75, 0);
       constraints.insets = ins;
       
    // add components to the panel
       constraints.gridx = 0;
       constraints.gridy = 0;     
      newPanel.add(Box.createHorizontalGlue(), constraints);

       constraints.gridx = 1;
       newPanel.add(Box.createHorizontalGlue(), constraints);
     //  constraints.insets = new Insets(10, 10, 10, 10);
       
       // add components to the panel
       constraints.gridx = 0;
       constraints.gridy = 1;     
      newPanel.add(Box.createHorizontalGlue(), constraints);

       constraints.gridx = 1;
       newPanel.add(textUsername, constraints);
        
      
       
       constraints.gridx = 0;
       constraints.gridy = 2;     
       newPanel.add(Box.createHorizontalGlue(), constraints);
        
       
       constraints.gridx = 1;
       newPanel.add(fieldPassword, constraints);
        
       
       constraints.gridx = 0;
       constraints.gridy = 3;
       constraints.gridwidth = 2;
       constraints.anchor = GridBagConstraints.CENTER;
       buttonLogin.setPreferredSize(new Dimension((int)pantallaD.getWidth()/14, (int)pantallaD.getHeight()/23));
       newPanel.add(buttonLogin, constraints);
       
        buttonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//funcion de login
				
				//Bucle
			
				try {
					JLabel jlabel = null;
					char[] arrayC = fieldPassword.getPassword();
					String pass = new String(arrayC);
					


					String correo = textUsername.getText();
					String password = ControladorUser.encripta(pass);
					
					if(helper_bd_usuario.login(correo, password)){
						//carga otra vista o haz algo impresionante 
						 System.out.print("si se ha podido loggear ");
						 
						 	Usuario usuarioLogeado = helper_bd_usuario.getUsuarioByCorreo(correo);
							new Vistas.MpPanel(usuarioLogeado).setVisible(true);
							setVisible(false);
						 
						 
					}else{
						setVisible(true);

						
						 System.out.print("no se ha podido loggear"); //muestra que no logea
					}
					
					
					 
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					 System.out.print("no se ha podido loggear por la seguridad");

					e.printStackTrace();
				}
				
			
				

			}
		});
       
      
       // set border for the panel
       
      // newPanel.setBorder(BorderFactory.createTitledBorder(
        //       BorderFactory.createEtchedBorder(), "Login Panel"));
        
       // add the panel to this frame
      // lFondo.add(newPanel);
       add(newPanel);
       //background.add(lFondo);
      // setContentPane(background);
       
       pack();
       setLocationRelativeTo(null);
   }
	

}
//key of google//AIzaSyAYWbV_Op779NEsbTlYYGyTKwQcfFHYKnQ
