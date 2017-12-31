import BBDD.Entidad;
import ProyectoTalentum.ProyectoTalentum.Equipo;
import ProyectoTalentum.ProyectoTalentum.Usuario;

public class test {

	public static void main(String[] args) {
		Usuario user = new Usuario(0, "hey", "hey", "hey", "hey", "hey");
		Entidad entidad = new Entidad();
		user.setTeam(new Equipo(0, null, null, null));
		entidad.Insert(user);
		
	}

}
