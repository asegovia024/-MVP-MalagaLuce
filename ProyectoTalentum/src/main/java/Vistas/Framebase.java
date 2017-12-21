package Vistas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.synth.SynthLookAndFeel;

public abstract class Framebase  extends JFrame {

	private static final long serialVersionUID = 1L;

	public Framebase(String s) {
	       super(s);
	       try {
			initLaF(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public static void initLaF(Boolean Default) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ParseException {
		Boolean opcion = Default!=null ? Default : true;
		
		
		SynthLookAndFeel lookAndFeel = new SynthLookAndFeel();
		System.out.println(UIManager.getSystemLookAndFeelClassName());
		
    	if(opcion) {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		}
    	else {
    		lookAndFeel.load(Login.class.getResourceAsStream("frameSkin.xml"),
  				  Login.class);
    		UIManager.setLookAndFeel(lookAndFeel);
    	}
	    	
	} 

}
