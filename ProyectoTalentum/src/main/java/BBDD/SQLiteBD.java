package BBDD;

public class SQLiteBD extends bbdd{
	 String sDriverForClass = config.DRIVER;
	 String URL = config.URL;
	 public SQLiteBD() {
		 try {
			init(sDriverForClass, URL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 //https://en.wikibooks.org/wiki/Java_JDBC_using_SQLite/Extending_the_base_class
		 }
}
