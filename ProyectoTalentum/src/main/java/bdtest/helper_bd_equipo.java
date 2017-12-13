package bdtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import ProyectoTalentum.ProyectoTalentum.Equipo;

public class helper_bd_equipo {
	 /**
	  * Inserta un equipo en la base de datos
	 * @param equipo a insertar
	 */
	public static void insert(Equipo equipo) {
	        String sql   = "INSERT INTO equipo(nombre, color, escudo) VALUES(?,?,?)";
	        BaseDatos bd = new BaseDatos();     
	        try (Connection conn = bd.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        		//se prepara el statment
		            pstmt.setString(1, equipo.getNombre());
		            pstmt.setString(2, equipo.getColor());
		            pstmt.setString(3, equipo.getEscudo());
		            //se ejecuta
		            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	        	bd.closeConnection();
	        }
	    }
	 /**
	  * Obtiene una lista de Equipos de la base de datos
	 * @return ArrayList<Equipo>
	 */
	public static ArrayList<Equipo> getEquipo() {
		 BaseDatos bd  = new BaseDatos(); 
		 String sql    = "SELECT * FROM equipo";
		 String escudo = "";
		 String nombre = "";
		 String color  = "";
		 int id        = 0;
		 Equipo equipo = new Equipo(id, nombre, color, escudo);
		 ArrayList <Equipo> listaequipos = new ArrayList<Equipo>();
		 try (Connection conn = bd.getConnection();
	             Statement stmt  = conn.createStatement();
				 ResultSet rs = bd.Query(sql);){
	            
	            while (rs.next()) {
	               id = rs.getInt("eID");
	               escudo = rs.getString("escudo");
	               nombre = rs.getString("nombre");
	               color = rs.getString("color");
	               equipo.setColor(color);
	               equipo.setEscudo(escudo);
	               equipo.setNombre(nombre);
	               equipo.setID(id);
	               listaequipos.add(equipo);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	        	bd.closeConnection();
	        }
		 return listaequipos;
	 }
	 
	 /**
	  * Extrae un equipo de un ArrayList de equipos, dada la ID del equipo deseado
	 * @param id del equipo que se quiere buscar
	 * @param lista de equipos
	 * @return objeto de tipo Equipo
	 */
	public static Equipo getEquipofromList(int id, ArrayList<Equipo> lista) {
		 Iterator<Equipo> iterator = lista.iterator();
		 boolean noencontrado = true;
		 Equipo equipo = null;
		while(iterator.hasNext() && noencontrado) {
			equipo = iterator.next();
			if(equipo.getID() == id) {
				noencontrado = false;
			}
		}
		return equipo;
	 }
}
