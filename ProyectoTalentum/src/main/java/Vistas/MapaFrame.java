package Vistas;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import ProyectoTalentum.ProyectoTalentum.Usuario;
import javaxt.io.Image;

public class MapaFrame extends Framebase {
	private static final long serialVersionUID = 1L;
	JPanel mapaPanel;
	panelMap mapa;
	JPanel botonesabajo;
	JPanel botonessuperior;
	JButton validar;
	JButton ranking;
	Usuario usuario;
	JButton bSalir;
	JButton vacio;
	int width;
	int height;
	public MapaFrame(Usuario usuario) {
		super("Frame principal");
		this.usuario = usuario;
        generarFrame();
	}
	private void generarFrame() {
	    
			colocarMapa();
			colocarBotonesAbajo();
			add(mapaPanel);
	        pack();
	        setVisible(false);
	        
	        
		}
	private void colocarMapa() {
		Toolkit pantalla = Toolkit.getDefaultToolkit(); //Coge los datos de la pantalla
	    Dimension pantallaD = pantalla.getScreenSize(); //Coge la resolución y la divide en 2 variables
	    width = pantallaD.width;
	    height = pantallaD.height;
		final Image imagen = new Image("src/resources/mapa.jpg");
	    imagen.resize(height/2,width/2, true);
		mapaPanel = new JPanel() {
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
	    
	}
	private void colocarBotonesAbajo() {
		SpringLayout layout = new SpringLayout();		
		botonesabajo = new JPanel(layout);
		validar = new JButton();
		ranking = new JButton();
		vacio = new JButton();
		int ancho = width/20;
		int alto = height/23;
		validar.setPreferredSize(new Dimension(ancho, alto));
	    validar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    ranking.setPreferredSize(new Dimension(ancho, alto));
	    ranking.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    vacio.setPreferredSize(new Dimension(ancho, alto));
	    vacio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botonesabajo.add(validar);
		botonesabajo.add(ranking);
		botonesabajo.add(vacio);
		layout.putConstraint(SpringLayout.WEST, vacio, 5, SpringLayout.WEST, botonesabajo);
		layout.putConstraint(SpringLayout.WEST, ranking,ancho +  5, SpringLayout.WEST, vacio);
		layout.putConstraint(SpringLayout.WEST, validar,ancho +  5, SpringLayout.WEST, ranking);
		mapaPanel.add(botonesabajo);
	}
	
}
