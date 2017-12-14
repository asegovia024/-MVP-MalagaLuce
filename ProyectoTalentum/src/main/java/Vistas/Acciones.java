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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout.Constraints;
import javax.swing.border.Border;
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
	JPanel miPanel, fotoAcc;
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
		
		panelp = new JPanel(new GridLayout(0,1));
		
		
		Acc=helper_bd_accion.getAccion();
	
		for (int i=0;i<Acc.size();i++){
			if(!Acc.get(i).isValidada())
				CrearPanel(Acc.get(i));	
		}
		
		panelp.add(scroll);
		Bvolver = new JButton("Volver");
		botonvolver();
		panelp.add(Bvolver);
		add(panelp);
		
		
		  pack();
	      setVisible(true);

	}

	
	private void CrearPanel(Accion a ){

		miPanel = new JPanel(new GridBagLayout());

		//miPanel.setBackground(Color.LIGHT_GRAY);
		
		//Fecha
		JLabel fechalabel =new JLabel("Fecha: ");
		GridBagConstraints constraints = Generaconstraints(0, 0, 1, 1, GridBagConstraints.NONE);
		miPanel.add(fechalabel,constraints);
		
		
		JLabel fechalabel2 =new JLabel(a.getFechaInicio());
		GridBagConstraints constraintsf = Generaconstraints(1, 0, 1, 1, GridBagConstraints.NONE);
		miPanel.add(fechalabel2, constraintsf);
		
		//Foto
		Image imagen = new Image("src/resources/Penguins.jpg"); //a.getFotoInicio()
		imagen.resize(120, 120, true);
		
		this.fotoAcc = new JPanel();
		JLabel etiqueta = new JLabel(new ImageIcon(imagen.getImage()));
		this.fotoAcc.add(etiqueta);
		
		fotoAcc.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints constraints2 = Generaconstraints(0, 1, 1, 2, GridBagConstraints.BOTH);
		constraints2.anchor = GridBagConstraints.CENTER;
		miPanel.add(fotoAcc,constraints2);
		
		
		JPanel panelbotones = new JPanel();
		
		BValidar = new JButton();
		BValidar.setText("Validar");
		
		BCancelar = new JButton();
		BCancelar.setText("Cancelar");

		
		panelbotones.add(BValidar);
		panelbotones.add(BCancelar);
		
		GridBagConstraints constraints3 = Generaconstraints(2, 1, 2, 1, GridBagConstraints.NONE);
		constraints3.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;

		
		
		miPanel.add(panelbotones,constraints3);
		
		scroll.getViewport().add(miPanel);
		//scroll.add(miPanel);

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
