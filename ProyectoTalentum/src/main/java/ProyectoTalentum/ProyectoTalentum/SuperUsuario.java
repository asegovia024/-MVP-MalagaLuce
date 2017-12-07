package ProyectoTalentum.ProyectoTalentum;
import ProyectoTalentum.ProyectoTalentum.Usuario;
import ProyectoTalentum.ProyectoTalentum.Accion;

public class SuperUsuario extends Usuario{

	
	


	public SuperUsuario(int id, String nombre, String correo, String pass, String fecha) {
		
		super(id, nombre, correo, pass, fecha);
		
		this.Super=true;//Combierte el usuario en super usuario
		
	}
	
	//Acciones
	/**
	 * @param accionAvalidar Objeto a validar
	 * @return devuelve true en caso de que se haya realizado correctamente
	 */
	public  boolean Validar(Accion accionAvalidar){
		accionAvalidar.Validar(); //cambia el estado de una accion a validado asdf 
		
		return true;
	}
	
	
	/**
	 * @param nombre Se Introduce el nombre del equipo
	 * @param color Introduce el color en formato hexadecimal
	 * @param escudo Introduce la ruta de la imagen
	 * @return devuelve true en caso de que se haya realizado correctamente
	 */
	public  boolean CrearEquipo(int id ,String nombre, String color, String escudo){	
		Equipo equipo = new Equipo(id, nombre, color, escudo); //este equipo hay que guardarlo juego en la BBDD
		return true;
	}
	
	
	public  boolean AddUsuario(Usuario usuario, Equipo equipo){
		
		if(usuario.getTeam() == null){
			usuario.setTeam(equipo);//si el usuario no tiene equipo se añade al designado
			return true;
		}
		
		return false;
	}
	

}
