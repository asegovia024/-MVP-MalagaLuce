package ProyectoTalentum.ProyectoTalentum;

import java.io.File;

import bdtest.helper_bd_accion;
import bdtest.helper_bd_accusuarios;
import bdtest.helper_bd_usuario;

public class ControladorAccion {

	/**
	 * 
	 * @param f Archivo que se va a subir como foto de la accion
	 * @param n Identificador del usuario
	 */
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
		helper_bd_usuario.AddPuntos(1, n);
		
		
		
		
	}
}
