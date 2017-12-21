package Vistas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

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
	        setVisible(true);
	        
	        
		}
	private void colocarMapa() {
		Toolkit pantalla = Toolkit.getDefaultToolkit(); //Coge los datos de la pantalla
	    Dimension pantallaD = pantalla.getScreenSize(); //Coge la resolución y la divide en 2 variables
	    width = pantallaD.width;
	    height = pantallaD.height;
		final Image imagen = new Image("src/resources/mapa.jpg");
	    imagen.resize(height/2,width/2, true);
		mapaPanel = new JPanel(new BorderLayout()) {
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
		int ancho = width/25;
		int alto = height/15;
		Dimension dimension = new Dimension(ancho,alto);
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT,width/90, height/40);	
		botonesabajo = new JPanel(layout);
		validar = new JButton();
		ranking = new JButton();
		vacio = new JButton();
		Box box = Box.createHorizontalBox();
		
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		validar.setPreferredSize(dimension);
	    validar.setCursor(cursor);
	    ranking.setPreferredSize(dimension);
	    ranking.setCursor(cursor);
	    vacio.setPreferredSize(dimension);
	    box.setPreferredSize(new Dimension((width/28)*3, (int)dimension.getHeight()));
	    vacio.setCursor(cursor);
		botonesabajo.add(validar);	
		botonesabajo.add(ranking);
		botonesabajo.add(vacio);
		botonesabajo.add(box);
		botonesabajo.setVisible(true);
		mapaPanel.add(botonesabajo, BorderLayout.SOUTH);
	}
	
}
