package Vistas;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

 

public class MpPanel extends JFrame

{
	
	public MpPanel()

	{
		super("Muestra de Imagen en JAVA...");
		//SE AÑADE LA IMAGEN AL PANEL
		getContentPane().add(new panelMap());

		//ESTABLECEMOS EL TAMAÑO DEL Jpanel
		
		Toolkit pantalla = Toolkit.getDefaultToolkit(); //Coge los datos de la pantalla
        Dimension pantallaD = pantalla.getScreenSize(); //Coge la resolución y la divide en 2 variables
        int width = pantallaD.width;
        int height = pantallaD.height;
        this.setSize(new Dimension(width/2, height/2));
        setPreferredSize(new Dimension(width/2, height/2)); //El tamaño de la ventana es 1/4 de la resolución
        setLocationRelativeTo(null); //Pone la ventana en el centro
        setResizable(false); //No cambiar el tamaño de la ventana
        pack();
        setVisible(false);
        
        

	}



}
