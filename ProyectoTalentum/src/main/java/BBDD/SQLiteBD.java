package BBDD;

public class SQLiteBD extends bbdd{
	 String sDriverForClass = "org.sqlite.JDBC";
	 public SQLiteBD(String sUrlKey) {
		 try {
			init(sDriverForClass, sUrlKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 //https://en.wikibooks.org/wiki/Java_JDBC_using_SQLite/Extending_the_base_class
		 }
}
