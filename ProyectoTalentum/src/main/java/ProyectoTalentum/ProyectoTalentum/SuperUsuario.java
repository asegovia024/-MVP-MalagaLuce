package ProyectoTalentum.ProyectoTalentum;
import ProyectoTalentum.ProyectoTalentum.Usuario;
import ProyectoTalentum.ProyectoTalentum.Accion;

public class SuperUsuario extends Usuario {

	
	public SuperUsuario(String nombre, String correo, String pass, String fecha) {
		
		super(nombre, correo, pass, fecha);
		
		this.Super=true;//Combierte el usuario en super usuario
		
	}
	
	public  boolean Validar(){
		
		
		return true;
	}
	

}
