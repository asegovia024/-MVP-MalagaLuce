package bdtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.javatuples.Pair;

import ProyectoTalentum.ProyectoTalentum.Accion;
import ProyectoTalentum.ProyectoTalentum.Usuario;

public class helper_bd_accion {
	public static void insert(Accion accion) {
        String sql   = "INSERT INTO accion(coordenadas, foto_inicio, foto_fin, fecha_inicio, fecha_fin, validado) VALUES(?,?,?,?,?,?)";
        BaseDatos bd = BaseDatos.createInstanceOfBD();     
        try (Connection conn = bd.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        		//se prepara el statment
	            pstmt.setString(1, accion.getCoordenadas().getValue0()); //TODO: revisar tema de coordenadas
	            pstmt.setString(2, accion.getCoordenadas().getValue1());
	            pstmt.setString(3, accion.getFotoInicio());
	            pstmt.setString(4, accion.getFotoFin());
	            pstmt.setString(5, accion.getFechaInicio());
	            pstmt.setString(6, accion.getFechaFin()); //TODO: revisar tema de las fechas
	            pstmt.setBoolean(7, accion.isValidada());
	            pstmt.executeUpdate(); 
	            bd.closeConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
public static ArrayList<Accion> getAccion() {
	BaseDatos bd      = BaseDatos.createInstanceOfBD(); 
	String sql        = "SELECT * FROM accion";
	int id            = 0;
	String FechaInicio  = "";
	String FechaFin     = "";
    String FotoInicio = "";
	String FotoFin    = "";		
	boolean Validada  = false;
    Pair<String, String> coordenadas = new Pair<>(null, null);	
	Accion accion = new Accion(id, coordenadas,  FechaInicio,
			FotoInicio);
	 ArrayList <Accion> listaacciones = new ArrayList<>();
	 try (Connection conn = bd.getConnection();
             Statement stmt  = conn.createStatement();
			 ResultSet rs = bd.Query(sql);){
            
            while (rs.next()) {
               id = rs.getInt("eID");
              
               listaacciones.add(accion);
               bd.closeConnection();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	 return listaacciones;
 }
 

}
