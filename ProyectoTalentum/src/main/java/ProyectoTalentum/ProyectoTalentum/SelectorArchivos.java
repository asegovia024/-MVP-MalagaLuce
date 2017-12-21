package ProyectoTalentum.ProyectoTalentum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

import javaxt.io.Directory;



public class SelectorArchivos {

	
	public File subirFoto(){
		try {
			Vistas.Login.initLaF(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setCurrentDirectory(new File("/User"));
		
			
		int result = jFileChooser.showOpenDialog(new JFrame());
		File selectedFile=null;
	
		if (result == JFileChooser.APPROVE_OPTION) {
			
		     selectedFile = jFileChooser.getSelectedFile();
		    
		    javaxt.io.File file = new javaxt.io.File(selectedFile);
		    javaxt.io.Directory dir = new javaxt.io.Directory("src\\resources/");
		    file.copyTo(dir, true); //true to overwrite any existing file
		    
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
		try {
			Vistas.Login.initLaF(false);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		    return selectedFile;
	
		
	}
	
	public boolean subirFotoPerfil(){
		
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setCurrentDirectory(new File("/User"));
		
		int result = jFileChooser.showOpenDialog(new JFrame());
	
	
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = jFileChooser.getSelectedFile();
		    javaxt.io.File file = new javaxt.io.File(selectedFile);
		    file.rename("user1.png");
		    javaxt.io.Directory dir = new javaxt.io.Directory("src\\resources\\user/");
		    file.copyTo(dir, true); //true to overwrite any existing file
		  
		    return true;
		    
		}else {
		return false;
		}
		
	}
	


}
