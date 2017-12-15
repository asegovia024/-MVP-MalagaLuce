package Vistas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ProyectoTalentum.ProyectoTalentum.SelectorArchivos;

public class panelMap extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imagen = new ImageIcon("src/resources/mapa.png");//soporta al menos .jpg y .png
	private ImageIcon iconoMapa = new ImageIcon("src/resources/icono_mapa.png");//soporta al menos .jpg y .png
	private JLabel etiqueta;
	public panelMap() {
		etiqueta = new JLabel(imagen);
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
			

		   SelectorArchivos subirFoto =  new ProyectoTalentum.ProyectoTalentum.SelectorArchivos();//Abre el selector de foto al pincahr en el mapa
		    
		   	if (subirFoto.subirFoto()) { 
			    Graphics g = getGraphics();
				g.drawImage(iconoMapa.getImage(), x, y, null);
			}
		
		}
	}
}
