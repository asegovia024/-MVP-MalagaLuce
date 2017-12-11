package ProyectoTalentum.ProyectoTalentum;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.security.NoSuchAlgorithmException;

import javax.swing.*;

import ProyectoTalentum.ProyectoTalentum.ControladorUser;


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
            	new Vistas.MpPanel().setVisible(true);
            }
        });
    }
}
