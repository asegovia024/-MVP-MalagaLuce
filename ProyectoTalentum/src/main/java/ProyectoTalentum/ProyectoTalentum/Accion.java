package ProyectoTalentum.ProyectoTalentum;

import org.javatuples.Pair;

import java.util.Date;

import ProyectoTalentum.ProyectoTalentum.Usuario;



public class Accion {

	private int id;
	//private Pair<Double, Double> coordenadas = new Pair<Double, Double>(null, null);
	private Pair<String,String> coordenadas = new Pair<>(null, null);
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
	 * @param coordenadas
	 * @param fechaInicio
	 * @param fotoInicio
	 * @param grupo
	 */
	public Accion(int id, Pair<String, String> coordenadas, String fechaInicio,
			String fotoInicio, Usuario[] grupo) {
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
	 * @param coordenadas
	 * @param fechaInicio
	 * @param fotoInicio
	 */
	public Accion(int id, Pair<String, String> coordenadas,
			String fechaInicio, String fotoInicio) {
		super();		
		this.id=id;
		this.coordenadas = coordenadas;
		FechaInicio = fechaInicio;
		FotoInicio = fotoInicio;
		this.Validada = false;
	}

	public void Validar() {
		this.Validada = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pair<String, String> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Pair<String, String> coordenadas) {
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
