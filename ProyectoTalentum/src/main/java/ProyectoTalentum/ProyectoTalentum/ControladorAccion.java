package ProyectoTalentum.ProyectoTalentum;

import java.io.File;

import bdtest.helper_bd_accion;
import bdtest.helper_bd_accusuarios;

public class ControladorAccion {

	
	public static void addAccion(File f,int n){
		
		//TODO: Recojer los metadatos de la foto y crear la accion
		
	
		LibreriaMetadata m =new LibreriaMetadata(f);//recojemos los metadatos de f
	
		String s =m.getDate().toString();
		String rutaImagenes = "src\\resources/" + f.getName() ;
		System.out.println(f.getName());
		Accion a = new Accion(0 , m.getGPS(),s , rutaImagenes);
		
		
		helper_bd_accion.insert(a);
		
		helper_bd_accusuarios.insert(n);
		
		///usuario add puntos
		
		
		
	}
}
