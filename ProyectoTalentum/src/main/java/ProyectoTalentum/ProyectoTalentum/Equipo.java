package ProyectoTalentum.ProyectoTalentum;

public class Equipo {
	private String nombre;
	private String Color;
	private String Escudo;
	// ID?
	
	
	/**
	 * 
	 * 
	 * @param nombre Se Introduce el nombre del equipo
	 * @param color Introduce el color en formato hexadecimal
	 * @param escudo Introduce la ruta de la imagen
	 */
	public Equipo(String nombre, String color, String escudo) {
		super();
		this.nombre = nombre;
		Color = color;
		Escudo = escudo;
	}
	
	/**
	 * 
	 * @return Devuelve el nombre del equipo 
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param nombre Modificar el nombre del equipo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * 
	 * @return Devuelve el color del equipo
	 */
	public String getColor() {
		return Color;
	}
	
	/**
	 * 
	 * @param color Modifica el color del equipo
	 */
	public void setColor(String color) {
		Color = color;
	}
	
	
	/**
	 * 
	 * @return Devuelve la ruta del escudo
	 */
	public String getEscudo() {
		return Escudo;
	}
	/**
	 * 
	 * @param escudo Modifica la ruta del escudo
	 */
	public void setEscudo(String escudo) {
		Escudo = escudo;
	}

}

