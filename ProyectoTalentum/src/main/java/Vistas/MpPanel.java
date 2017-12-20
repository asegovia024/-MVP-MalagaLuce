package Vistas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ProyectoTalentum.ProyectoTalentum.ControladorUser;
import ProyectoTalentum.ProyectoTalentum.Usuario;
import javaxt.io.Image;
 

public class MpPanel extends Framebase

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	panelMap mapa;
	JPanel botonesizq;
	JPanel fotousuario;
	JPanel botonessuperior;
	JButton validar;
	JButton ranking;
	Usuario usuario;
	JButton bSalir;
	public MpPanel()

	{
		super("Muestra de Imagen en JAVA...");
        generarFrame();
        

	}
	
	public MpPanel(Usuario usuario)

	{
		super("Muestra de Imagen en JAVA...");
		this.usuario = usuario;
        generarFrame();
        

	}
	private void generarFrame() {
		
		getContentPane().setLayout(new GridBagLayout());
		colocarMapa();
		colocarBotonesIzq();
		colocarBotonesSuperior();
		colocarFotoUsuario();
		
        pack();
        setVisible(false);
        
        
	}
	/*private void colocarMapa() {
		this.mapa = new panelMap();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridheight = 2;
		constraints.gridwidth= 2;
		this.getContentPane().add (mapa, constraints);
		
	}*/
	private void colocarMapa() {
		//JLabel mapal = new JLabel("mapa aqui");
		this.mapa = new panelMap(usuario);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth= 2;
		constraints.weighty = 1;
		constraints.weightx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		this.getContentPane().add (mapa, constraints);
		
	}
	private void colocarBotonesIzq() {		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridheight = 2;
		constraints.gridwidth = 1;
		generarBotonesIzq();
		this.getContentPane().add(botonesizq, constraints);
	}
	private void colocarFotoUsuario() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.BOTH;
		generarFotoUsuario();
		this.getContentPane().add(fotousuario, constraints);
	}
	private void colocarBotonesSuperior() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 1;      //columna donde empieza
		constraints.gridy = 0;      //fila donde empieza
		constraints.gridheight = 1; //ocupa filas
		constraints.gridwidth = 2;  //ocupa columnas
		constraints.weightx = 1;
		generarBotonesSuperior();
		this.getContentPane().add(botonessuperior, constraints);
	}
	private void generarBotonesIzq() {
		
		if(ControladorUser.esAdmin(this.usuario)) {
			this.botonesizq = new JPanel(new GridLayout(0,1));
			this.validar = new JButton("");
			validar.setSize(30,30);
			//validar.setBorder(null);
			validar.setBorder(BorderFactory.createEmptyBorder());
			validar.setOpaque(true);
			validar.setMargin(new Insets(0, 0, 0, 0));
			this.validar.setIcon(new ImageIcon("src\\resources\\avatar.png"));
			llamadabotonvalidar();
			botonesizq.add(validar);
		}
		else {
			this.botonesizq = new JPanel();
		}
		this.ranking = new JButton("ranking");
		llamadabotonranking();
		botonesizq.add(ranking);
	}
	
	private void generarFotoUsuario() {
		Image imagen = new Image("src/resources/user/user1.png");
		imagen.resize(72, 72, true);
		this.fotousuario = new JPanel();
		JLabel etiqueta = new JLabel(new ImageIcon(imagen.getImage()));
		this.fotousuario.add(etiqueta);
		
	}
	private void generarBotonesSuperior() {
		this.botonessuperior = new JPanel(new GridLayout(0,3));
		JButton opciones = new JButton("Configuración");
		JButton boton1 = new JButton("boton 1");
		bSalir = new JButton("Salir");
		llamadabotonsalir();
		botonessuperior.add(opciones);
		botonessuperior.add(boton1);
		botonessuperior.add(bSalir);
	}
	
	private void llamadabotonranking(){
		ranking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Vistas.Ranking(usuario).setVisible(true);
				setVisible(false);
				
			}
		});
	}
private void llamadabotonvalidar() {
	validar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new Vistas.Acciones(usuario).setVisible(true);
			setVisible(false);
			
		}
	});
}
private void llamadabotonsalir() {
	bSalir.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new Vistas.Login().setVisible(true);
			dispose();
			
		}
	});
}
}
