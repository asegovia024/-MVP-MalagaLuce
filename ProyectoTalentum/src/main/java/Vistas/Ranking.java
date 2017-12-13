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

import ProyectoTalentum.ProyectoTalentum.Usuario;
import bdtest.helper_bd_usuario;


public class Ranking extends Framebase {
	
	private JLabel labelTabla1;
	JTable mitabla;
	JPanel mibarra;
	 ArrayList <Usuario> Rank = new ArrayList();
	 JButton botonCancelar;

	 public Ranking()  {
		super("Ranking");
		
		Rank= helper_bd_usuario.getRanking();
		 
        
        
		botonCancelar = new JButton();
		botonCancelar.setText("Cancelar");

        
		labelTabla1 = new JLabel();
		labelTabla1.setBounds(40, 300, 400, 130);
        
        
		mibarra = new JPanel(new GridLayout(0,1));
		mibarra.setBounds(40, 300, 400, 130);
		mostrarDatosUsandoLogica();// mostramos la tabla
		
		
		mibarra.add(mitabla);

		
		mibarra.add(botonCancelar);
		
		add(mibarra);

		
		
		
		
		
	}


private void mostrarDatosUsandoLogica(){
	
	 String[] columnNames = {"Puesto",
             "Usuario",
             "Puntos"};
	 
		String info[][] = obtieneMariz();// obtenemos la informacion de

		mitabla = new JTable(info, columnNames);
		mitabla.setEnabled(false);
		mitabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//mibarra.setViewportView(mitabla);
}


private String[][] obtieneMariz(){
	
	
	String informacion[][] = new String[Rank.size()][3];

	//tratar que no se salga del rango de usuarios ni de 5 
	
	
	for (int x = 0; x < Rank.size(); x++) {
		informacion[x][0] = Integer.toString(x) ;
		informacion[x][1] = Rank.get(x).getNick();
		informacion[x][2] = Integer.toString(Rank.get(x).getPuntos());
	}
	return informacion;
	
	
	
}



	
}
