package bdtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class helper_bd_accusuarios {
	public static void insert(int uID, int aID) {
        String sql   = "INSERT INTO accusuarios(uID, aID) VALUES (?,?)";
        BaseDatos bd = new BaseDatos();    
        try (Connection conn = bd.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, uID);
	            pstmt.setInt(2, aID);
	            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
        	bd.closeConnection();
        }
    }
	/**
	 * @return Devuelve el número de acciones realizadas por usuario hay en la BBDD
	 */
	public static int Count(){
		BaseDatos bd = new BaseDatos();
		String sql   = "SELECT count(*) FROM accusuarios";
		ResultSet rs = bd.Query(sql);
		int count = 0;
		try {
				count = rs.getInt(1);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
        	bd.closeConnection();
        }
		return count;
	}
	public static int CountbyID(int id){
		BaseDatos bd = new BaseDatos();
		String sql   = "SELECT count(*) FROM accusuarios where aID ="+ id;
		ResultSet rs = bd.Query(sql);
		int count = 0;
		try {
				count = rs.getInt(1);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
        	bd.closeConnection();
        }
		return count;
	}
	/**
	 * @param id
	 * @return Devuelve la lista de usuarios que ha realizado una acción
	 */
	public static int[] getAccionesbyID(int id){
		BaseDatos bd    = new BaseDatos(); 
		 String sql     = "SELECT * FROM accusuarios WHERE aID ="+ id;
		 int uID        = 0;
		 int cont       = 0;
		 int[] acciones = new int[CountbyID(id)];
		 
		 try (Connection conn = bd.getConnection();
	             Statement stmt  = conn.createStatement();
				 ResultSet rs = bd.Query(sql);){
	            
	            while (rs.next()) {
	               uID            = rs.getInt("uID");
	               acciones[cont] = uID;	
	               cont++;
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	        	bd.closeConnection();
	        }
		 return acciones;
	}
}
