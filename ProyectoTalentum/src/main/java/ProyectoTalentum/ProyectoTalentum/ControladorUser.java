package ProyectoTalentum.ProyectoTalentum;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import bdtest.helper_bd_usuario;


public class ControladorUser {
	
	
	/**
	 * 
	 * @param pass Introducimos la contraseña en texto plano
	 * @return Obtenemos la contraseña encriptada para poder guardarla
	 * @throws NoSuchAlgorithmException Pueden ocurir errores criptograficos
	 */
	public static String encripta(String pass) throws NoSuchAlgorithmException  {
	
		MessageDigest sha256=MessageDigest.getInstance("SHA-256");
		try {
			sha256.update(pass.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		byte[] digest = sha256.digest();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<digest.length;i++){
		    sb.append(String.format("%02x", digest[i]));
		}
		
		// String hash=sb.toString(); //2bb80d5...527a25b	 
		//System.out.print(sb.toString());
		return sb.toString();	
	}
	

	
	 /**
	  * 
	  * @param usuario Introducimos un usuario para validar si es superUsuario
	  * @return Nos devuelve si el usuario es superUsuario o no
	  */
	public static boolean esAdmin(Usuario usuario) {
		if(usuario.getSuper()){
			return true;
		}
		else {
			return false;
		}
	}

}
