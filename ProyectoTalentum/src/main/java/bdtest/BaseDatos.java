package bdtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Carlos Javier Gutiérrez Sánchez
 * Objeto encargado de la base de datos; Conexión, desconexión y ejecución de consultas.
 */
public class BaseDatos {
	
	//Esta variable constante almacena la ruta de la base de datos SQLite
	private static final String URL_DEFAULT = "jdbc:sqlite:C:/workspace/db/proyecto.s3db";
	private Connection conn = null;
	private static BaseDatos bd;
	
	private BaseDatos(){
		try {            
            // create a connection to the database
        	
            conn = DriverManager.getConnection(URL_DEFAULT);
            System.out.println("Se ha conectado a la base de datos SQLite.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	 public static BaseDatos createInstanceOfBD() {
	        if (bd == null){
	            bd = new BaseDatos();
	        }
	        else{
	            //no conecta
	        }
	        
	        return bd;
	 }
	 
    /**
     * Realiza la conexión a la base de datos SQLite, 
     * @return Devuelve la conexión de tipo Connection 
     */
    public Connection getConnection() {
        return this.conn;
    }
    
    /**
     * Cierra la conexión de la base de datos
     */
    public void closeConnection(){
    	try {
			conn.close();
            System.out.println("Se ha desconectado a la base de datos SQLite.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
    }
    /**
     * Método para ejecutar consultas simples
     * @param query - Parámetro de tipo String, que contendrá el valor de la query a ejecutar
     * @return Devuelve un parámetro tipo ResulSet con el resultado de la query
     */
    public ResultSet Query(String query){
    	ResultSet rs = null;
    	try {
    		Connection conn = this.conn;
            Statement stmt  = conn.createStatement();
            rs              = stmt.executeQuery(query);
           
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
    	return rs;
    }
 }