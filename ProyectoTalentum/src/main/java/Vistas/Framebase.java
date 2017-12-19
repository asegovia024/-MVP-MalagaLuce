package Vistas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.synth.SynthLookAndFeel;

public abstract class Framebase  extends JFrame {

	public Framebase(String s) {
	       super(s);
	       initLaF();
		 //tamaño movil
	       Toolkit pantalla = Toolkit.getDefaultToolkit(); //Coge los datos de la pantalla
	       Dimension pantallaD = pantalla.getScreenSize(); //Coge la resolución y la divide en 2 variables
	       int width = pantallaD.width;
	       int height = pantallaD.height;
	       Dimension tamano = new Dimension(height/2 -10, width/2 + 25);
	       //Dimension tamano = new Dimension(640, 1171);
	       this.setSize(tamano);
	       setPreferredSize(tamano); //El tamaño de la ventana es 1/4 de la resolución
	       setLocationRelativeTo(null); //Pone la ventana en el centro
	       setResizable(false); //No cambiar el tamaño de la ventana
	       setDefaultCloseOperation(EXIT_ON_CLOSE);
	      }
	
	private void initLaF() {
		SynthLookAndFeel lookAndFeel = new SynthLookAndFeel();
	    
		 
	    try {
	    	lookAndFeel.load(Login.class.getResourceAsStream("loginSkin.xml"),
	        				  Login.class);
	        UIManager.setLookAndFeel(lookAndFeel);
	        System.out.println(UIManager.getSystemLookAndFeelClassName());
	    } 
	    
	    catch (Exception e) {
	        System.err.println("Couldn't get specified look and feel ("
	                           + lookAndFeel
	                           + "), for some reason.");
	        System.err.println("Using the default look and feel.");
	        e.printStackTrace();
	    }
	}
}
