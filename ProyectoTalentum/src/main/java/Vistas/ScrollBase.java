package Vistas;

import javax.swing.JScrollPane;
public abstract class ScrollBase extends Framebase {

	public JScrollPane scroll;
	
	public ScrollBase(String s) {
		super(s);
		// TODO Auto-generated constructor stub
		
		JScrollPane scroll = new JScrollPane(); 

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		

	   
		
	}

	
	
	
}
