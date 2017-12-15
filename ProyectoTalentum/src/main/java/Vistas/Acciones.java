package Vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

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
	 JPanel panelp, panelscroll;
	 
	 
	 
	public Acciones(Usuario usuario) {
		super("Validar");
		this.usuario=usuario;
		//scroll = new ScrollBase();
		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		panelp = new JPanel(new GridBagLayout());
		
		Dimension dimensionscroll = new Dimension();
		dimensionscroll.setSize(this.getSize().getHeight()/2, this.getSize().getWidth()/2);
		scroll.setPreferredSize(dimensionscroll);
		generarPanelScroll();

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

	private void generarPanelScroll() {
		Acc=helper_bd_accion.getAccion();
		int contvalidadas = 0;
		for (int i=0;i<Acc.size();i++){
			if(!Acc.get(i).isValidada())
				contvalidadas++;	
		}
		if(contvalidadas > 0) {
			panelscroll = new JPanel(new GridLayout(contvalidadas, 1));
			for (int i=0;i<Acc.size();i++){
				if(!Acc.get(i).isValidada())
					panelscroll.add(CrearPanel(Acc.get(i)));	
			}
		}
		else
		{
			panelscroll = new JPanel();
			panelscroll.add(new JLabel("No hay acciones sin validar"));
		}
		
		scroll.getViewport().add(panelscroll);
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
		
		BValidar = new JButton("Validar");
		BValidar.setActionCommand(Integer.toString(a.getID()));
		BValidar.setName(Integer.toString(a.getID()));
		BValidar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				int aID = Integer.parseInt(accion);
				helper_bd_accion.validarAccion(aID);
				panelscroll.removeAll();				
				generarPanelScroll();
				panelscroll.updateUI();
			}
		});
		BCancelar = new JButton();
		BCancelar.setText("Rechazar");

		
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

	//	panelscroll.add(miPanel);
		//scroll.getViewport().add(miPanel);
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
