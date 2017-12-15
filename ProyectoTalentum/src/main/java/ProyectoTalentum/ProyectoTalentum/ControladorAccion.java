package ProyectoTalentum.ProyectoTalentum;

import java.io.File;

import bdtest.helper_bd_accion;

public class ControladorAccion {

	
	public static void addAccion(File f){
		//TODO: Recojer los metadatos de la foto y crear la accion
		
	
		LibreriaMetadata m =new LibreriaMetadata(f);//recojemos los metadatos de f
	
		String s =m.getDate().toString();
		
		Accion a = new Accion(0 , m.getGPS(),s , f.getPath());
		
		
		helper_bd_accion.insert(a);
		
		
	}
}
