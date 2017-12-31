package BBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ProyectoTalentum.ProyectoTalentum.Usuario;
import bdtest.BaseDatos;

public class Entidad extends SQLiteBD implements DataMapper{
	
	public Entidad() {
		super();
	}
	@Override
	public void Insert(Object user) {
		String sql = "INSERT INTO usuario(nombre, password, correo, puntos, eID) VALUES(?,?,?,?,?)";
        BaseDatos bd = new BaseDatos();
        Usuario usuario = (Usuario) user;
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

	@Override
	public void Update(Object t) {
		
		
	}

	@Override
	public void Delete(Object t) {
		
	}

	@Override
	public Iterable<Usuario> getAll() {
		
		return null;
	}
	@Override
	public Iterable<Usuario> GetFiltered(String conditions, String order, int pageSize, int pageIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
