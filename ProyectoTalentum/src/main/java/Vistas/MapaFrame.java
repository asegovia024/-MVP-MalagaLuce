package Vistas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JPanel botonesarriba;
	JButton validar;
	JButton ranking;
	Usuario usuario;
	JButton bSalir;
	JButton vacio;
	JButton salir;
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
			colocarBotonesArriba();
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
	    llamadabotonvalidar();
	    
	    ranking.setPreferredSize(dimension);
	    ranking.setCursor(cursor);
	    llamadabotonranking();
	    
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
	private void colocarBotonesArriba() {
		int ancho = width/25;
		int alto = height/15;
		Dimension dimension = new Dimension(ancho,alto);
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT,width/120, height/80);	
		botonesarriba = new JPanel(layout);
		salir = new JButton();
		Box box = Box.createHorizontalBox();
		
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		salir.setPreferredSize(dimension);
		salir.setCursor(cursor);
		llamadabotonsalir();
	    box.setPreferredSize(new Dimension((width/25)*5, (int)dimension.getHeight()));
	    botonesarriba.add(box);
	    botonesarriba.add(salir);		    
	    botonesarriba.setVisible(true);
		mapaPanel.add(botonesarriba, BorderLayout.NORTH);
	}
	private void llamadabotonranking(){
		ranking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Vistas.Ranking(usuario).setVisible(true);
				setVisible(false);
				
			}
		});
	}
private void llamadabotonvalidar() {
	validar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new Vistas.Acciones(usuario).setVisible(true);
			setVisible(false);
			
		}
	});
}
private void llamadabotonsalir() {
	salir.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new Vistas.Login().setVisible(true);
			dispose();
			
		}
	});
}
}
