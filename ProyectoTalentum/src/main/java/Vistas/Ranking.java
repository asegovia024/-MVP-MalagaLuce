package Vistas;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ProyectoTalentum.ProyectoTalentum.Usuario;
import bdtest.helper_bd_usuario;


public class Ranking extends JFrame {
	
	private JLabel labelTabla1;
	JTable mitabla;
	JScrollPane mibarra;
	 ArrayList <Usuario> Rank = new ArrayList();
JButton botonCancelar;

	 public Ranking()  {
		super("Ranking");
		
		Rank= helper_bd_usuario.getRanking();
		 
		Toolkit pantalla = Toolkit.getDefaultToolkit(); //Coge los datos de la pantalla
        Dimension pantallaD = pantalla.getScreenSize(); //Coge la resolución y la divide en 2 variables
        int width = pantallaD.width;
        int height = pantallaD.height;
        this.setSize(new Dimension(width/2, height/2));
        setPreferredSize(new Dimension(width/2, height/2)); //El tamaño de la ventana es 1/4 de la resolución
        setLocationRelativeTo(null); //Pone la ventana en el centro
        setResizable(false); //No cambiar el tamaño de la ventana
        
        
        
        
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 200, 120, 25);
		botonCancelar.setText("Cancelar");

        
		labelTabla1 = new JLabel();
		labelTabla1.setText("Tabla Usando Matriz de datos");
		labelTabla1.setBounds(40, 300, 400, 130);
        
        
		mibarra = new JScrollPane();
		mibarra.setBounds(40, 300, 400, 130);
		mostrarDatosUsandoLogica();// mostramos la tabla
		
		add(labelTabla1);
		add(mibarra);
		//add(botonCancelar);

		
		
		
		
		
	}


private void mostrarDatosUsandoLogica(){
	
	 String[] columnNames = {"Puesto",
             "Usuario",
             "Puntos"};
	 
		String info[][] = obtieneMariz();// obtenemos la informacion de

		mitabla = new JTable(info, columnNames);
		mitabla.setEnabled(false);
		mitabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mibarra.setViewportView(mitabla);
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
