package bdtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import org.javatuples.Pair;

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
        } catch (SQLException e) {
            System.out.println(e.getMessage()); //TODO: cambiar por registro de logs?
        } finally {
        	bd.closeConnection();
        }
	}
	public static ArrayList<Usuario> getUsuario() {
		 BaseDatos bd = new BaseDatos(); 
		 String sql      = "SELECT * FROM usuario";
		 String nombre   = "";
		 String password = "";
		 String correo   = "";
		 String nick     = "";
		 int Super       = 0;
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
	               Super    = rs.getInt("super");
	               
	               
	      		 Usuario usuario = new Usuario(id, nombre, correo, password, correo, nick);
	      		 usuario.setPuntos(puntos);
	      		if(Super == 1)
		      		   usuario.setSuper(true);

	             /*  usuario.setNombre(nombre);
	               usuario.setCorreo(correo);
	               usuario.setPass(password);
	               usuario.setID(id);
	               usuario.setTeam();
	               	*/
	      		// usuario.setPuntos(puntos);
	      		 listausuarios.add(usuario);
	               
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }finally {
	        	bd.closeConnection();
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
		 int Super       = 0;
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
	               Super    = rs.getInt("super");
	               
	      		 Usuario usuario = new Usuario(id, nombre, correo, password, correo, nick);
	      		 usuario.setPuntos(puntos);
	      		if(Super == 1)
		      		   usuario.setSuper(true);
	      		 
	             /*  usuario.setNombre(nombre);
	               usuario.setCorreo(correo);
	               usuario.setPass(password);
	               usuario.setID(id);
	               usuario.setTeam();
	               	*/
	      		// usuario.setPuntos(puntos);
	      		 listausuarios.add(usuario);
	               
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	        	bd.closeConnection();
	        }
		 return listausuarios;
	 }
	
	
	
	
	public static ArrayList<Pair<String,Integer>> getRankingG() {
		
		 BaseDatos bd = new BaseDatos(); 
		 String sql      = "SELECT equipo.nombre, SUM(usuario.puntos) FROM usuario INNER JOIN equipo ON usuario.eID = equipo.eID GROUP BY equipo.nombre  ORDER BY usuario.puntos DESC LIMIT 0,5; ";
		 String nombre   = "";
		 int puntos      = 0;

		 ArrayList <Pair<String,Integer>> lista = new ArrayList<Pair<String,Integer>>();
		 
		 Pair<String,Integer> eq = new Pair<>(null, null);
		 
		 
		 try (Connection conn = bd.getConnection();
	             Statement stmt  = conn.createStatement();
				 ResultSet rs = bd.Query(sql);){
	            
	            while (rs.next()) {
	            	
	               puntos   = rs.getInt("SUM(usuario.puntos)");
	               nombre   = rs.getString("nombre");
	               
	               
	              // System.out.println(nombre +" "+ puntos+" bd"); 

	             eq=  eq.setAt0(nombre);
	            eq=   eq.setAt1(puntos);
	                 	               
	               lista.add(eq);
	      
	               
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	        	bd.closeConnection();
	        }
		 return lista;
	 }
	
	

	
	
	public static void AddPuntos(int p,int id){
		String sql = " UPDATE usuario SET puntos= '?' WHERE uID=?";
        BaseDatos bd = new BaseDatos();
        try (Connection conn = bd.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, p);
	            pstmt.setInt(2, id);
	            pstmt.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        } finally {
        	bd.closeConnection();
        }
	}
	
	
	
	
	
	
	// UPDATE usuario SET puntos= '2' WHERE uID=0
	
	public static Usuario getUsuarioByCorreo(String correo) {
		 BaseDatos bd = new BaseDatos(); 
		 String sql      = "SELECT * FROM usuario WHERE correo = ?";
		 String nombre   = "";
		 String password = "";
		 String nick     = "";
		 int Super   = 0;
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
	               Super    = rs.getInt("super");
	      		   usuario = new Usuario(id, nombre, correo, password, correo, nick);
	      		   usuario.setPuntos(puntos);
	      		   if(Super == 1)
	      		   usuario.setSuper(true);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	        	bd.closeConnection();
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
			 
		 } finally {
	        	bd.closeConnection();
	        }
		return login_correcto;
	}
}