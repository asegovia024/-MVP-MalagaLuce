package Vistas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import ProyectoTalentum.ProyectoTalentum.Usuario;
import bdtest.helper_bd_usuario;


public class Ranking extends Framebase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable mitabla;
	JPanel mibarra;
	ArrayList <Usuario> Rank;
	JButton botonCancelar;
	Usuario usuario;
	
	
	 public Ranking(Usuario usuario)  {
		super("Ranking");
		
		Rank = helper_bd_usuario.getRanking();
		this.usuario = usuario;
		botonCancelar = new JButton();
		botonCancelar.setText("Volver");
		botonvolver ();
		//labelTabla1.setBounds(40, 300, 400, 130);
        

		mibarra = new JPanel(new GridBagLayout()); 		

		mostrarDatosUsandoLogica();// mostramos la tabla
		
		mibarra.add(mitabla, new GridBagConstraints(0, 0, 1, 3, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));
		mibarra.add(botonCancelar, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0) );
		
		add(mibarra);		
		
	}


private void mostrarDatosUsandoLogica(){
	
	 String[] columnNames = {"Puesto",
             "Usuario",
             "Puntos"};
	 
		String info[][] = obtieneMariz();// obtenemos la informacion de

		mitabla = new JTable(info, columnNames);
		mitabla.setEnabled(false);
		//mitabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//mibarra.setViewportView(mitabla);
}


private String[][] obtieneMariz(){
	
	
	String informacion[][] = new String[Rank.size()][3];

	//tratar que no se salga del rango de usuarios ni de 5 
	
	
	for (int x = 0; x < Rank.size(); x++) {
		informacion[x][0] = Integer.toString(x+1) ;
		informacion[x][1] = Rank.get(x).getNick();
		informacion[x][2] = Integer.toString(Rank.get(x).getPuntos());
	}
	return informacion;
	
	
	
}
private void botonvolver () {
	ActionListener action = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new Vistas.MpPanel(usuario).setVisible(true);
			dispose();
			
		}
		
	};
	botonCancelar.addActionListener(action);
}



	
}
