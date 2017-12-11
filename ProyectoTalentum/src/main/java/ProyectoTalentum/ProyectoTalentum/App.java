package ProyectoTalentum.ProyectoTalentum;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.NoSuchAlgorithmException;

import javax.swing.*;

import ProyectoTalentum.ProyectoTalentum.ControladorUser;
import Vistas.MpPanel;


public class App {
    

     
    public static void main(String[] args)   {
        // set look and feel to the system look and feel
    	ControladorUser c =new ControladorUser();
    	
    	
    
    
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	new Vistas.Login().setVisible(true);
            	new Vistas.MpPanel().setVisible(false);
            }
        });
        
		//COLOCAMOS EL CODIGO QUE PERMITE CERRAR LA VENTANA
		MpPanel p = new MpPanel();

		p.show();
		p.addWindowListener(new WindowAdapter()

		{

			public void windowClosing(WindowEvent evt)

			{

				System.exit(0);

			}

		});
    }
}
