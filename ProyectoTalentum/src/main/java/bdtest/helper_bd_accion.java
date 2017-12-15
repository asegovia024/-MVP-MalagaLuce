package bdtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import org.javatuples.Pair;

import com.drew.lang.GeoLocation;

import ProyectoTalentum.ProyectoTalentum.Accion;
import ProyectoTalentum.ProyectoTalentum.Usuario;

public class helper_bd_accion {
	public static void insert(Accion accion) {
        String sql   = "INSERT INTO accion(coordenadasX, coordenadasY, foto_inicio, foto_fin, fecha_inicio, fecha_fin, validado) VALUES(?,?,?,?,?,?,?)";
        BaseDatos bd = new BaseDatos();     
        try (Connection conn = bd.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        		//se prepara el statment
	
            pstmt.setInt(1, (int)accion.getCoordenadas().getLatitude());
            
            pstmt.setInt(2, (int)accion.getCoordenadas().getLongitude());
	            pstmt.setString(3, accion.getFotoInicio());
	            pstmt.setString(4, accion.getFotoInicio()); //TODO: Cambiar for foto inicio
	            pstmt.setString(5, accion.getFechaInicio());
	            pstmt.setString(6, accion.getFechaInicio()); //TODO: Cambiar for fecha fin
	            pstmt.setInt(7, 0);
	    //        pstmt.setBoolean(7, accion.isValidada());

	            pstmt.executeUpdate(); 	         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
        	bd.closeConnection();
        }
    }


	
	
	
	public static void validarAccion(int id) {
		String sql = "UPDATE accion SET validado = 1 WHERE aID = ?";
		BaseDatos bd = new BaseDatos(); 
		try (Connection conn = bd.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            pstmt.setInt(1, id);
		            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	        	bd.closeConnection();
	        }
	}


public static ArrayList<Accion> getAccion() {
	BaseDatos bd      = new BaseDatos();
	String sql        = "SELECT * FROM accion";
	int id            = 0;
	String FechaInicio  = "";
	String FechaFin     = "";
    String FotoInicio = "";
	String FotoFin    = "";		
	int Validada  = 0;
    Accion accion = null;
	 ArrayList <Accion> listaacciones = new ArrayList<>();
	 try (Connection conn = bd.getConnection();
             Statement stmt  = conn.createStatement();
			 ResultSet rs = bd.Query(sql);){
            
            while (rs.next()) {
               id = rs.getInt("aID");
               FechaInicio = rs.getString("fecha_inicio");
               FechaFin    = rs.getString("fecha_fin");
               FotoInicio  = rs.getString("foto_inicio");
               FotoFin     = rs.getString("foto_fin");
               Validada    = rs.getInt("validado");
               
               //coordenadas.setAt0(rs.getInt("coordenadasX"));
               //coordenadas.setAt1(rs.getInt("coordenadasY"));
               
               double la =(double)  rs.getInt("coordenadasX");
            	double lo =(double)  rs.getInt("coordenadasY");
            	
               GeoLocation geo =new GeoLocation(la, lo); 
               
               accion = new Accion(id, geo,  FechaInicio,
           			FotoInicio);
               if(Validada == 1)
            	   accion.setValidada(true);
               accion.setFechaFin(FechaFin);
               accion.setFotoFin(FotoFin);
               listaacciones.add(accion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
        	bd.closeConnection();
        }
	 return listaacciones;
 }




	public static Accion getAccionFromList(int id, ArrayList<Accion> lista) {
		 Iterator<Accion> iterator = lista.iterator();
		 boolean noencontrado = true;
		 Accion accion = null;
		 while(iterator.hasNext() && noencontrado) {
			accion = iterator.next();
			if(accion.getID() == id) {
				noencontrado = false;
			}
		}
		return accion;
	}
	public static Accion getAccionFromList(Accion accion, ArrayList<Accion> lista) {
		Accion res = null;
			if(lista.contains(accion)) {
				res = accion;
			}
		return res;
	}
	

}
