package ProyectoTalentum.ProyectoTalentum;

import org.javatuples.Pair;

import com.drew.lang.GeoLocation;

import java.util.Date;

import ProyectoTalentum.ProyectoTalentum.Usuario;



public class Accion {

	private int id;
	//private Pair<Double, Double> coordenadas = new Pair<Double, Double>(null, null);
	//private Pair<Integer,Integer> coordenadas = new Pair<>(null, null);
	private GeoLocation coordenadas;
	//private Date FechaInicio;//Cambiar a string si dan por saco
	//private Date FechaFin;
	private String FechaInicio;
	private String FechaFin;
	private String FotoInicio;
	private String FotoFin;
	
	private boolean Validada;
	
	private Usuario[] grupo = new Usuario[10]; //TODO: se puede usar un arraylist o una variable para indicar el MAX

	/**
	 * 
	 * @param coordenadas Se introduce las coordenadas de la geo
	 * @param fechaInicio Se introduce la fecha en la que se inicio la accion
	 * @param fotoInicio Se introduce la fecha en la que se finalizo la accion
	 */
	public Accion(int id, GeoLocation coordenadas, String fechaInicio,
			String fotoInicio) {
		super();
		
		this.id=id;
		this.coordenadas = coordenadas;
		FechaInicio = fechaInicio;
		FotoInicio = fotoInicio;
		this.grupo = grupo;
		this.Validada = false;
	}
	
	
	
/**
 * @category funcion que valida la accion
 */
	public void Validar() {
		this.Validada = true;
	}

	/**
	 * 
	 * @return devuelve el identificador del usuario
	 */
	public int getID() {
		return id;
	}
/**
 * 
 * @param id introducimos el identificador del usuario
 */
	public void setID(int id) {
		this.id = id;
	}
/**
 * 
 * @return devuelve la GeoLocalizacion de la accion
 */
	public GeoLocation getCoordenadas() {
		return coordenadas;
	}

	/**
	 * 
	 * @param coordenadas Introducimos las coordenadas mediante GeoLocalizacion
	 */
	public void setCoordenadas(GeoLocation coordenadas) {
		this.coordenadas = coordenadas;
	}

	/**
	 * 
	 * @return devuelve la fecha en la que se inicio la accion
	 */
	public String getFechaInicio() {
		return FechaInicio;
	}
	/**
	 * 
	 * @param fechaInicio Introducimos la fecha en la que se inicio la accion
	 */
	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}
	
	/**
	 * 
	 * @return devuelve la fecha de finalizacion de la accion
	 */
	public String getFechaFin() {
		return FechaFin;
	}

	/**
	 * 
	 * @param fechaFin Introducimos la fecha en la que se finalizacion la accion
	 */
	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}

	/**
	 * 
	 * @return devuelve la ruta de la foto principal de la accion
	 */
	public String getFotoInicio() {
		return FotoInicio;
	}

	/**
	 * 
	 * @param fotoInicio establece la ruta de la foto principal de la accion
	 */
	public void setFotoInicio(String fotoInicio) {
		FotoInicio = fotoInicio;
	}

	/**
	 * 
	 * @return  devuelve la ruta de la foto final de la accion
	 */
	public String getFotoFin() {
		return FotoFin;
	}

	/**
	 * 
	 * @param fotoFin establece la ruta de la foto final de la accion
	 */
	public void setFotoFin(String fotoFin) {
		FotoFin = fotoFin;
	}

	/**
	 * 
	 * @return comprueba si la accion esta validada o no
	 */
	public boolean isValidada() {
		return Validada;
	}

	/**
	 *  
	 * @param validada establece la validacion de la accion a true o false
	 */
	public void setValidada(boolean validada) {
		Validada = validada;
	}

	/**
	 * 
	 * @return devuelve un array de usuarios que han realizado dicha accion
	 */
	public Usuario[] getGrupo() {
		return grupo;
	}

	/**
	 * 
	 * @param grupo copia una lista de usuarios que han participado en la accion
	 */
	public void setGrupo(Usuario[] grupo) {
		this.grupo = grupo;
	}

}
