package BBDD;

public interface DataMapper<T> {
	void Insert(T t);
	void Update(T t);
	void Delete(T t);
	Iterable<T> getAll();
	Iterable<T> GetFiltered(String conditions, String order, int pageSize, int pageIndex);
}
