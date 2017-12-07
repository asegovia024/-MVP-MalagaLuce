package bdtest;

public class testbd {

	public static void main(String[] args) {
		if(helper_bd_usuario.login("123", "password"))
			System.out.println("Login correcto");
		else{
			System.out.println("Login incorrecto");
		}

	}

}
