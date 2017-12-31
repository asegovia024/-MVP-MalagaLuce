package BBDD;

import java.util.Collection;

public interface Repository<T> extends Collection<Entidad> {
	Iterable<T> FilterBy ();
}
