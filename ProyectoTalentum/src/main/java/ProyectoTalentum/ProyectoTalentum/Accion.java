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
	 * @param id
	 * @param coordenadas2
	 * @param fechaInicio
	 * @param fotoInicio
	 */


	public void Validar() {
		this.Validada = true;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public GeoLocation getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(GeoLocation coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}

	public String getFotoInicio() {
		return FotoInicio;
	}

	public void setFotoInicio(String fotoInicio) {
		FotoInicio = fotoInicio;
	}

	public String getFotoFin() {
		return FotoFin;
	}

	public void setFotoFin(String fotoFin) {
		FotoFin = fotoFin;
	}

	public boolean isValidada() {
		return Validada;
	}

	public void setValidada(boolean validada) {
		Validada = validada;
	}

	public Usuario[] getGrupo() {
		return grupo;
	}

	public void setGrupo(Usuario[] grupo) {
		this.grupo = grupo;
	}

}
