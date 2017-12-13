package ProyectoTalentum.ProyectoTalentum;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;



public class SelectorArchivos {

	
	public SelectorArchivos(){
		
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setCurrentDirectory(new File("/User"));
		
		int result = jFileChooser.showOpenDialog(new JFrame());
	
	
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = jFileChooser.getSelectedFile();
		    
		    
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
	}
	
	
	public static void main(String[] args) {
		new SelectorArchivos();
	}
}
