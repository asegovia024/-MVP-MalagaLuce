package Vistas;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

 

public class MpPanel extends JFrame

{
	panelMap mapa;
	JPanel botonesizq;
	JPanel fotousuario;
	JPanel botonessuperior;
	JButton validar;
	JButton ranking;
	public MpPanel()

	{
		super("Muestra de Imagen en JAVA...");
        generarFrame();
        

	}
	private void generarFrame() {
		
		getContentPane().setLayout(new GridBagLayout());
		colocarMapa();
		colocarBotonesIzq();
		colocarBotonesSuperior();
		colocarFotoUsuario();
		Toolkit pantalla = Toolkit.getDefaultToolkit(); //Coge los datos de la pantalla
        Dimension pantallaD = pantalla.getScreenSize(); //Coge la resolución y la divide en 2 variables
        int width = pantallaD.width;
        int height = pantallaD.height;
        this.setSize(new Dimension(width/2, height/2));
        setPreferredSize(new Dimension(width/2, height/2)); //El tamaño de la ventana es 1/4 de la resolución
        setLocationRelativeTo(null); //Pone la ventana en el centro
        setResizable(false); //No cambiar el tamaño de la ventana
        pack();
        setVisible(false);
	}
	private void colocarMapa() {
		this.mapa = new panelMap();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridheight = 2;
		constraints.gridwidth= 2;
		this.getContentPane().add (mapa, constraints);
		
	}
	private void colocarBotonesIzq() {
		this.botonesizq = new JPanel(new GridLayout(1, 0));
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
		generarFotoUsuario();
		this.getContentPane().add(fotousuario, constraints);
	}
	private void colocarBotonesSuperior() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;      //columna donde empieza
		constraints.gridy = 1;      //fila donde empieza
		constraints.gridheight = 1; //ocupa filas
		constraints.gridwidth = 2;  //ocupa columnas
		generarBotonesSuperior();
		this.getContentPane().add(botonessuperior, constraints);
	}
	private void generarBotonesIzq() {
		this.validar = new JButton("Validar");
		this.ranking = new JButton("ranking");
		botonesizq.add(ranking);
		botonesizq.add(validar);
	}
	
	private void generarFotoUsuario() {
		this.fotousuario = new JPanel();
		JLabel texto = new JLabel("Foto usuario aqui");
		fotousuario.add(texto);
		
	}
	private void generarBotonesSuperior() {
		this.botonessuperior = new JPanel(new GridLayout(0, 3));
		JButton opciones = new JButton("Configuración");
		JButton boton1 = new JButton("boton 1");
		JButton boton2 = new JButton("boton 2");
		botonessuperior.add(opciones);
		botonessuperior.add(boton2);
		botonessuperior.add(boton1);
	}


}
