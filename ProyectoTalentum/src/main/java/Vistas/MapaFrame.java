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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import ProyectoTalentum.ProyectoTalentum.ControladorAccion;
import ProyectoTalentum.ProyectoTalentum.SelectorArchivos;
import ProyectoTalentum.ProyectoTalentum.Usuario;
import bdtest.helper_bd_usuario;
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
	private ImageIcon iconoMapa = new ImageIcon("src/resources/icono_mapa.png");//soporta al menos .jpg y .png
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
		final Image imagen = new Image("src/resources/mapaBueno.png");
		final Image imagenAdmin = new Image("src/resources/mapaValidar.png");
	    imagen.resize(height/2,width/2, true);
	    imagenAdmin.resize(height/2, width/2, true);
		mapaPanel = new JPanel(new BorderLayout()) {
	 	   /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
	
			@Override
	 		  protected void paintComponent(Graphics g) {

	 		    super.paintComponent(g);
				if(usuario.getSuper()) {
					g.drawImage(imagenAdmin.getImage(), 0, 0, null);
				}
				else {
					g.drawImage(imagen.getImage(), 0, 0, null);
				}
	 		    
	 		}
	    };
	    mapaPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getButton() == e.BUTTON1) {
					int x = e.getX();
					int y = e.getY();
					System.out.print(y + " y ");
					System.out.print(x + " x ");
					File f=null;

				   SelectorArchivos subirFoto =  new ProyectoTalentum.ProyectoTalentum.SelectorArchivos();//Abre el selector de foto al pincahr en el mapa
				    
				   try{
				   	f=subirFoto.subirFoto();
					    Graphics g = getGraphics();
						g.drawImage(iconoMapa.getImage(), x, y, null);
						ControladorAccion.addAccion(f,usuario.getID()); //enlaza usuario y accion realizada
						usuario.PuntosAdd(); //añade puntos al usuaior
						int p=usuario.getPuntos();//Guarda los puntos acutales del usuario
						helper_bd_usuario.AddPuntos(p, usuario.getID()); //modificador de puntos del usuario sen la bd
						
						System.out.println("5");
				   }catch(Exception e1){
					   System.out.println("No se ha podido subir el fichero");
				   }
				   
					
				
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	    
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
		botonesabajo.add(vacio);	
		botonesabajo.add(ranking);
		botonesabajo.add(validar);
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
