
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;



public class sqlconn {
	
	static Connection conn =  null;
	private static String class_name = null;
	private static String url = null;
	private static String dbname = null;
	private static String uid = null;
	private static String pwd = null;
	
	
	static public Connection selectDepart()
	{
		ResourceBundle bundle = ResourceBundle.getBundle("resources",Locale.US);
		
		class_name = bundle.getString("class_name");
		url = bundle.getString("url");
		dbname = bundle.getString("dbname");
		uid = bundle.getString("userid");
		pwd = bundle.getString("password");
		
		url = url+dbname;
		
		try
		{
			Class.forName(class_name);
			conn = DriverManager.getConnection(url,uid,pwd);
			System.out.println("connected to my sql database");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException ee)
		{
			ee.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static void main(String[] args) {
		selectDepart();
	}

}
