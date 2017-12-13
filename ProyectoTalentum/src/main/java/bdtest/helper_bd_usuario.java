package bdtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import ProyectoTalentum.ProyectoTalentum.Usuario;

public class helper_bd_usuario {
	public static void insert(Usuario usuario){
		String sql = "INSERT INTO usuario(nombre, password, correo, puntos, eID) VALUES(?,?,?,?,?)";
        BaseDatos bd = new BaseDatos();
        try (Connection conn = bd.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, usuario.getNombre());
	            pstmt.setString(2, usuario.getPass());
	            pstmt.setString(3, usuario.getCorreo());
	            pstmt.setInt(4, usuario.getPuntos());
	          //pstmt.setInt(5, usuario.getTeam());
	            pstmt.setInt(5, usuario.getTeam().getID());

	            pstmt.executeUpdate(); 
	            bd.closeConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); //TODO: cambiar por registro de logs?
        }
	}
	public static ArrayList<Usuario> getUsuario() {
		 BaseDatos bd = new BaseDatos(); 
		 String sql      = "SELECT * FROM usuario";
		 String nombre   = "";
		 String password = "";
		 String correo   = "";
		 String nick     = "";
		 int puntos      = 0;
		 int team        = 0;
		 int id          = 0;
		// Usuario usuario = new Usuario(id, nombre, correo, password, correo);
		 ArrayList <Usuario> listausuarios = new ArrayList<Usuario>();
		 try (Connection conn = bd.getConnection();
	             Statement stmt  = conn.createStatement();
				 ResultSet rs = bd.Query(sql);){
	            
	            while (rs.next()) {
	               id       = rs.getInt("uID");
	               team     = rs.getInt("eID");
	               puntos   = rs.getInt("puntos");
	               nombre   = rs.getString("nombre");
	               password = rs.getString("password");
	               correo   = rs.getString("correo");
	               nick     = rs.getString("nick");
	               
	               
	      		 Usuario usuario = new Usuario(id, nombre, correo, password, correo, nick);
	      		 usuario.setPuntos(puntos);

	             /*  usuario.setNombre(nombre);
	               usuario.setCorreo(correo);
	               usuario.setPass(password);
	               usuario.setID(id);
	               usuario.setTeam();
	               	*/
	      		// usuario.setPuntos(puntos);
	      		 listausuarios.add(usuario);
	               
	            }
	            bd.closeConnection();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		 return listausuarios;
	 }
	public static ArrayList<Usuario> getRanking() {
		 BaseDatos bd = new BaseDatos(); 
		 String sql      = "SELECT * FROM usuario ORDER BY puntos DESC LIMIT 0,5";
		 String nombre   = "";
		 String password = "";
		 String correo   = "";
		 String nick     = "";
		 int puntos      = 0;
		 int team        = 0;
		 int id          = 0;
		// Usuario usuario = new Usuario(id, nombre, correo, password, correo);
		 ArrayList <Usuario> listausuarios = new ArrayList<Usuario>();
		 try (Connection conn = bd.getConnection();
	             Statement stmt  = conn.createStatement();
				 ResultSet rs = bd.Query(sql);){
	            
	            while (rs.next()) {
	               id       = rs.getInt("uID");
	               team     = rs.getInt("eID");
	               puntos   = rs.getInt("puntos");
	               nombre   = rs.getString("nombre");
	               password = rs.getString("password");
	               correo   = rs.getString("correo");
	               nick     = rs.getString("nick");
	               
	               
	      		 Usuario usuario = new Usuario(id, nombre, correo, password, correo, nick);
	      		 usuario.setPuntos(puntos);
	             /*  usuario.setNombre(nombre);
	               usuario.setCorreo(correo);
	               usuario.setPass(password);
	               usuario.setID(id);
	               usuario.setTeam();
	               	*/
	      		// usuario.setPuntos(puntos);
	      		 listausuarios.add(usuario);
	               
	            }
	            bd.closeConnection();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		 return listausuarios;
	 }
	public static Usuario getUsuarioByCorreo(String correo) {
		 BaseDatos bd = new BaseDatos(); 
		 String sql      = "SELECT * FROM usuario WHERE correo = ?";
		 String nombre   = "";
		 String password = "";
		 String nick     = "";
		 int puntos      = 0;
		 int team        = 0;
		 int id          = 0;
		 Usuario usuario = null;
		 try (Connection conn = bd.getConnection();
	             Statement stmt  = conn.createStatement();
				 PreparedStatement pstmt = conn.prepareStatement(sql)){
				 pstmt.setString(1, correo);
				 ResultSet rs  = pstmt.executeQuery();
	               id       = rs.getInt("uID");
	               team     = rs.getInt("eID");
	               puntos   = rs.getInt("puntos");
	               nombre   = rs.getString("nombre");
	               password = rs.getString("password");
	               correo   = rs.getString("correo");
	               nick     = rs.getString("nick");	                              
	      		   usuario = new Usuario(id, nombre, correo, password, correo, nick);
	      		   usuario.setPuntos(puntos);
	            bd.closeConnection();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		 return usuario;
	 }
	public static Usuario getUsuariofromList(int id, ArrayList<Usuario> lista) {
		 Iterator<Usuario> iterator = lista.iterator();
		 boolean noencontrado = true;
		 Usuario usuario = null;
		while(iterator.hasNext() && noencontrado) {
			usuario = iterator.next();
			if(usuario.getID() == id) {
				noencontrado = false;
			}
		}
		return usuario;
	 }
	
	
	public static boolean login(String correo, String pass){
		String sql = "SELECT password FROM usuario WHERE correo = ?";
		BaseDatos bd = new BaseDatos(); 
		boolean login_correcto = false;
		String password = "";
		
		
		 try (Connection conn = bd.getConnection();
	          Statement stmt  = conn.createStatement();
			  PreparedStatement pstmt = conn.prepareStatement(sql)){
				 pstmt.setString(1, correo);
				 ResultSet rs  = pstmt.executeQuery();
				 password = rs.getString("password");
				 if(pass.equals(password)){
					 login_correcto = true;
			 }
			 
		 } catch (SQLException e) {
			 
		 } 
		 
		 bd.closeConnection();
		return login_correcto;
	}
}