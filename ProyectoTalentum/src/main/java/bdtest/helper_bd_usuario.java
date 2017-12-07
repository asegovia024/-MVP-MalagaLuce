package bdtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import ProyectoTalentum.ProyectoTalentum.Equipo;
import ProyectoTalentum.ProyectoTalentum.Usuario;

public class helper_bd_usuario {
	public static void insert(Usuario usuario){
		String sql = "INSERT INTO usuario(nombre, password, correo, puntos, eID) VALUES(?,?,?,?,?)";
        BaseDatos bd = new BaseDatos();
        try (Connection conn = bd.connect();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, usuario.getNombre());
	            pstmt.setString(2, usuario.getPass());
	            pstmt.setString(3, usuario.getCorreo());
	            pstmt.setInt(4, usuario.getPuntos());
	          //  pstmt.setInt(5, usuario.getTeam());
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
		// Usuario usuario = new Usuario(id, nombre, correo, password, correo); // TODO: Añadir ID a las clases
		 ArrayList <Usuario> listausuarios = new ArrayList<Usuario>();
		 try (Connection conn = bd.connect();
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
	               
	               
	      		 Usuario usuario = new Usuario(id, nombre, correo, password, correo, nick); // TODO: Añadir ID a las clases

	             /*  usuario.setNombre(nombre);
	               usuario.setCorreo(correo);
	               usuario.setPass(password);
	               usuario.setID(id);
	               usuario.setTeam();
	               usuario.setPuntos(puntos);
	               listausuarios.add(usuario);	*/               
	               
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		 return listausuarios;
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
		 try (Connection conn = bd.connect();
	          Statement stmt  = conn.createStatement();
			  PreparedStatement pstmt = conn.prepareStatement(sql)){
			 
			 pstmt.setString(1, correo);
			 ResultSet rs  = pstmt.executeQuery();
			 password = rs.getString("password");
			 if(password == pass){
				 login_correcto = true;
			 }
			 
		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
		 }
		return login_correcto;
	}
	
	
	
	
	
	

}
