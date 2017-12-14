package Vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ProyectoTalentum.ProyectoTalentum.Accion;
import ProyectoTalentum.ProyectoTalentum.Usuario;
import bdtest.helper_bd_accion;

public class Acciones extends Framebase {
	
	private JLabel labelTabla1;
	JTable mitabla;
	JPanel miPanel;
	 ArrayList <Accion> Acc = new ArrayList();
	 JButton botonCancelar;
	
	public Acciones() {
		super("Listado de acciones");
		// TODO Auto-generated constructor stub
		
	Acc=helper_bd_accion.getAccion();
	
    
	

		labelTabla1 = new JLabel();	
		miPanel = new JPanel(new GridLayout(0,1));

		botonCancelar = new JButton();
		botonCancelar.setText("Cancelar");
		
		
		
		miPanel.add(mitabla);

		
		miPanel.add(botonCancelar);
		
		add(miPanel);
	
	}

	
	
	private void mostrarDatosUsandoLogica(){
		
		 String[] columnNames = {"Fecha",
	             "Foto",
	             "Usuario"};
		 
			String info[][] = obtieneMariz();// obtenemos la informacion de

			mitabla = new JTable(info, columnNames);
			mitabla.setEnabled(false);
			mitabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			//mibarra.setViewportView(mitabla);
	}


	private String[][] obtieneMariz(){
		
		
		String informacion[][] = new String[Acc.size()][3];

		//tratar que no se salga del rango de usuarios ni de 5 
		
		
		for (int x = 0; x < Acc.size(); x++) {
			if(!Acc.get(x).isValidada()){
				informacion[x][0] = Acc.get(x).getFechaInicio() ;
				informacion[x][1] = Acc.get(x).getFotoInicio();
				informacion[x][2] = Acc.get(x).getGrupo()[0].getNick();
			}
		}
		return informacion;
		
		
		
	}
	

}
