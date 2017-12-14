package Vistas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class Framebase  extends JFrame {

	public Framebase(String s) {
	       super(s);

		 //tamaño movil
	       Toolkit pantalla = Toolkit.getDefaultToolkit(); //Coge los datos de la pantalla
	       Dimension pantallaD = pantalla.getScreenSize(); //Coge la resolución y la divide en 2 variables
	       int width = pantallaD.width;
	       int height = pantallaD.height;
	       this.setSize(new Dimension(height/2, width/2));
	       setPreferredSize(new Dimension(height/2, width/2)); //El tamaño de la ventana es 1/4 de la resolución
	       setLocationRelativeTo(null); //Pone la ventana en el centro
	       setResizable(false); //No cambiar el tamaño de la ventana	
	       setDefaultCloseOperation(EXIT_ON_CLOSE);
	       }
	
}
