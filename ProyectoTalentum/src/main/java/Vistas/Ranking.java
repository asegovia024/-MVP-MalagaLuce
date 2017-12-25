package Vistas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.javatuples.Pair;

import ProyectoTalentum.ProyectoTalentum.Usuario;
import bdtest.helper_bd_usuario;


public class Ranking extends Framebase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable mitabla;
	JPanel mibarra;
	JButton botonCancelar,BoUsuario,BoEq;
	Usuario usuario;
	static int flag;
	
	
	 public Ranking(Usuario usuario)  {
		super("Ranking");
		
	//	Rank = helper_bd_usuario.getRanking();
		this.usuario = usuario;
		botonCancelar = new JButton();
		botonCancelar.setText("Volver");
		
		BoUsuario = new JButton();
		BoUsuario.setText("usuarios");
		
		BoEq = new JButton();
		BoEq.setText("grupos");
		botonvolver ();
		botonopc ();
		

		mibarra = new JPanel(new GridBagLayout()); 
		
		//labelTabla1.setBounds(40, 300, 400, 130);
        
/*
		mibarra = new JPanel(new GridBagLayout()); 
		
		
			mostrarDatosUsandoLogica2();
		
		
		
		
		mibarra.add(BoUsuario, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 2, 0), 0, 0));
		mibarra.add(BoEq, new GridBagConstraints(1, 0, 0, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 2, 0), 0, 0));
		
		
		mibarra.add(mitabla, new GridBagConstraints(0, 1, 1, 3, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));
		mibarra.add(botonCancelar, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0) );
		*/
		crearmibarra();
		
		add(mibarra);		
		
	}
	 
	 
	 
	 private void crearmibarra(){
		 

			mostrarDatosUsandoLogica();

			
		mibarra.add(BoUsuario, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 2, 0), 0, 0));
		mibarra.add(BoEq, new GridBagConstraints(1, 0, 0, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 2, 0), 0, 0));
		
		
		mibarra.add(mitabla, new GridBagConstraints(0, 1, 1, 3, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));
		mibarra.add(botonCancelar, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0) );  
	 }
	 
	 
	 private void crearmibarra2(){
		 

			mostrarDatosUsandoLogica2();

		mibarra.add(BoUsuario, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 2, 0), 0, 0));
		mibarra.add(BoEq, new GridBagConstraints(1, 0, 0, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 2, 0), 0, 0));
		
		
		mibarra.add(mitabla, new GridBagConstraints(0, 1, 1, 3, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));
		mibarra.add(botonCancelar, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0) );
		 
		 
		 
	 }


private void mostrarDatosUsandoLogica(){
	
	 String[] columnNames = {"Puesto",
             "Usuario",
             "Puntos"};

			String info[][] = obtieneMariz();// obtenemos la informacion de
			mitabla = new JTable(info, columnNames);
			mitabla.setEnabled(false);	 
}





private void mostrarDatosUsandoLogica2(){
	
	 String[] columnNames = {"Puesto",
            "Equipo",
            "Puntos"};

	
			String info[][] = obtieneMariz2();// obtenemos la informacion de
			mitabla = new JTable(info, columnNames);
			mitabla.setEnabled(false);

	 
}






private String[][] obtieneMariz(){
	
	ArrayList <Usuario> Rank;
	Rank = helper_bd_usuario.getRanking();

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
			//new Vistas.MpPanel(usuario).setVisible(true);
			new Vistas.MapaFrame(usuario);
			dispose();
			
		}
		
	};
	botonCancelar.addActionListener(action);
}




private void botonopc () {
	ActionListener action = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		mibarra.removeAll();
		crearmibarra();
		mibarra.updateUI();
			
			
			flag=1;
			
		}
		
	};
	BoUsuario.addActionListener(action);
	
	
	
	ActionListener action2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			mibarra.removeAll();
			crearmibarra2();
			mibarra.updateUI();
			flag=2;

			
		}
		
	};
	BoEq.addActionListener(action2);
	
}


private String[][] obtieneMariz2(){
		int totalpuntos=0;
	//	String nombreeq=" ";
	
		
		ArrayList <Pair<String,Integer>> lista = new ArrayList<Pair<String,Integer>>();
		 Pair<String,Integer> e = new Pair<>(null, null);

		
		String informacion[][] = new String[5][3];
		
		lista = helper_bd_usuario.getRankingG();
		
		
	
		for (int x = 0; x < lista.size(); x++) {
			informacion[x][0] = Integer.toString(x+1) ;
			
			informacion[x][1] = lista.get(x).getValue0();

			informacion[x][2] = Integer.toString(lista.get(x).getValue1()) ;

		} 
	
	
	
	return informacion;
	
	
	
}
	
}
