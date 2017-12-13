package ProyectoTalentum.ProyectoTalentum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javaxt.io.Directory;



public class SelectorArchivos {

	
	public SelectorArchivos(){
		
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setCurrentDirectory(new File("/User"));
		
		int result = jFileChooser.showOpenDialog(new JFrame());
	
	
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = jFileChooser.getSelectedFile();
		    
		    javaxt.io.File file = new javaxt.io.File(selectedFile);
		    javaxt.io.Directory dir = new javaxt.io.Directory("C:\\workspace\\ProyectoTalentum\\src\\resources/");
		    file.copyTo(dir, true); //true to overwrite any existing file
		    
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
	}
	
	
	public static void main(String[] args) {
		new SelectorArchivos();
	}
}
