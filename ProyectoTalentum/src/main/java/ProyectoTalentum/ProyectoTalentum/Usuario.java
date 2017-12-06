package ProyectoTalentum.ProyectoTalentum;
import ProyectoTalentum.ProyectoTalentum.Equipo;


public class Usuario {
	
	private String Nombre;
	private String Correo;
	private String Pass;
	private Equipo team;
	protected Boolean Super;
	private int Puntos;
	private String Fecha;
	//ID?
	//array de acciones
	
	/**
	 * 
	 * @param nombre Introducir el nombre del usuario
	 * @param correo Introducir el correo electronico
	 * @param pass Introducir la contraseña
	 * @param fecha Introducir la fecha de nacimiento
	 */
	public Usuario(String nombre, String correo, String pass, String fecha) {
		super();
		Nombre = nombre;
		Correo = correo;
		Pass = pass;
		Puntos =0;
		Fecha =fecha;
		
	}
	
	
	/**
	 * @return Devuelve el nombre del usuario
	 */
	public String getNombre() {
		return Nombre;
	}
	

	/**
	 * 
	 * @param nombre Modifica el nombre del usuario
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	/**
	 * 
	 * @return Devuelve el correo del usuario
	 */
	public String getCorreo() {
		return Correo;
	}
	/**
	 * 
	 * @param correo Modifica el correo del usuario
	 */
	public void setCorreo(String correo) {
		Correo = correo;
	}
	/**
	 * 
	 * @return Obtiene la contraseña,funcion privada para el logeo
	 */
	
	private String getPass() {
		return Pass;
	}
	/**
	 * 
	 * @param pass Modifica la contraseña
	 */
	public void setPass(String pass) {
		Pass = pass;
	}
	/**
	 * 
	 * @return Devuelve el Equipo al que pertenece
	 */
	public Equipo getTeam() {
		return team;
	}
	/**
	 * 
	 * @param team Cambiar a un nuevo equipo
	 */
	public void setTeam(Equipo team) {
		this.team = team;
	}
	/**
	 * 
	 * @return Comprobar si el usuario es super usuario
	 */
	public Boolean getSuper() {
		return Super;
	}

	/**
	 * @see Establece el usuario a super usuario, solo se puede llamar desde superUsuario
	 */
	protected void setsuper() {
		this.Super = true;
	}
	
	/**
	 * 
	 * @return Devuelve los puntos del usuario
	 */
	public int getPuntos() {
		return Puntos;
	}
	/**
	 * 
	 * @see Incrementa los puntos del usuario
	 */
	public void addPuntos() {
		Puntos = Puntos+10;
	}
	
	/**
	 * 
	 * @return Devuelve la fecha de nacimiento del usuario
	 */
	public String getFecha() {
		return Fecha;
	}
	/**
	 * 
	 * @param fecha Modifica la fecha de nacimiento del usuario
	 */
	public void setFecha(String fecha) {
		Fecha = fecha;
	}


}
