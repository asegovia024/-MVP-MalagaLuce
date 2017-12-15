package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout.Constraints;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javaxt.io.Image;
import ProyectoTalentum.ProyectoTalentum.Accion;
import ProyectoTalentum.ProyectoTalentum.Usuario;
import bdtest.helper_bd_accion;

public class Acciones extends Framebase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel miPanel, fotoAcc, aux;
	 ArrayList <Accion> Acc;
	 Accion a;
	 JButton BValidar,BCancelar, Bvolver;
	 Usuario usuario;
	// ScrollBase scroll;
	 JScrollPane scroll;
	 JPanel panelp;
	 
	 
	 
	public Acciones(Usuario usuario) {
		super("Validar");
		// TODO Auto-generated constructor stub
		this.usuario=usuario;
		//scroll = new ScrollBase();
		scroll = new JScrollPane(miPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		panelp = new JPanel(new GridBagLayout());
		
		
		Acc=helper_bd_accion.getAccion();
	
		   Iterator it = Acc.iterator();
		
		//for (int i=0;i<Acc.size();i++){
			while (it.hasNext()){
			//if(!Acc.get(i).isValidada())
				a=(Accion) it.next();
				if(!a.isValidada())
				
				  aux = CrearPanel(a);	
			
			scroll .setViewportView(aux);
			scroll .getViewport().setView(aux);
			
			
			//scroll.getViewport().add(aux);

		}
		
		panelp.add(scroll);
		Bvolver = new JButton("Volver");
		botonvolver();
		panelp.add(Bvolver, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		add(panelp);
		
		
		  pack();
	      setVisible(true);

	}

	
	private JPanel CrearPanel(Accion a ){

		miPanel = new JPanel(new GridBagLayout());
		miPanel.setBorder(new TitledBorder("Accion "+ a.getID()));
		
		//Fecha
		JLabel fechalabel =new JLabel("Fecha: " + a.getFechaInicio());
		miPanel.add(fechalabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
		
		//Foto  "src/resources/prueba.jpg"
		Image imagen = new Image("src/resources/Penguins.jpg"); //a.getFotoInicio()
		imagen.resize(120, 120, true);
		
		this.fotoAcc = new JPanel();
		JLabel etiqueta = new JLabel(new ImageIcon(imagen.getImage()));
		this.fotoAcc.add(etiqueta);
		
		fotoAcc.setBackground(Color.LIGHT_GRAY);
		miPanel.add(fotoAcc,new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));
		
		
		JPanel panelbotones = new JPanel(new GridBagLayout());
		
		BValidar = new JButton();
		BValidar.setText("Validar");
		
		BCancelar = new JButton();
		BCancelar.setText("Cancelar");

		
		panelbotones.add(BValidar, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));
		panelbotones.add(BCancelar, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
				
		
		miPanel.add(panelbotones,new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));
		
		return miPanel;
		//scroll.getViewport().add(miPanel);

	}
	
	
	
	
	
	private void botonvolver () {
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Vistas.MpPanel(usuario).setVisible(true);
				dispose();
				
			}
			
		};
		Bvolver.addActionListener(action);
	}
	
	
	
	private GridBagConstraints Generaconstraints(int xc, int yc, int xt, int yt, int _fill){
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = xc;      //columna donde empieza
		constraints.gridy = yc;      //fila donde empieza
		constraints.gridheight = yt; //ocupa filas
		constraints.gridwidth = xt;  //ocupa columnas
		//constraints.weightx = 0;
		//constraints.weighty = 0;
		
		constraints.fill = _fill;

		
		return constraints;
	}
	

}
