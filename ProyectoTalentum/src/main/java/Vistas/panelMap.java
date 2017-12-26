package Vistas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bdtest.helper_bd_usuario;
import ProyectoTalentum.ProyectoTalentum.ControladorAccion;
import ProyectoTalentum.ProyectoTalentum.SelectorArchivos;
import ProyectoTalentum.ProyectoTalentum.Usuario;

public class panelMap extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imagen = new ImageIcon("src/resources/mapa.png");//soporta al menos .jpg y .png
	private ImageIcon iconoMapa = new ImageIcon("src/resources/icono_mapa.png");//soporta al menos .jpg y .png
	private JLabel etiqueta;
	private Usuario usuario;
	public panelMap(Usuario usuario) {
		etiqueta = new JLabel(imagen);
		this.usuario=usuario;
		add(etiqueta);
		addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
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
}
