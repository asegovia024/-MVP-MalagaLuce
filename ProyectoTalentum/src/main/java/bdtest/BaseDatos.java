package bdtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class BaseDatos {
     /**
     * Connect to a sample database
     */
	private final String URL_DEFAULT = "jdbc:sqlite:C:/workspace/db/proyecto.s3db";
	Connection conn = null;
    /**
     * Realiza la conexión a la base de datos
     */
    private Connection connect() {
        try {            
            // create a connection to the database
            conn = DriverManager.getConnection(URL_DEFAULT);
            System.out.println("Se ha conectado a la base de datos SQLite.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }
    public void close(){
    	try {
			conn.close();
            System.out.println("Se ha desconectado a la base de datos SQLite.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	BaseDatos db = new BaseDatos();
    	db.connect();
    	db.connect();
    	db.close();
    }
}