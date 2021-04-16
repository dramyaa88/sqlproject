package demo.JDBC.MySQL.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	
	static String url = "jdbc:mysql://localhost:3306/Employee";
	static String uid = "root";
	static String pwd = "root";
	static Connection conn = null;
	
	public static Connection mySqlDBConnection()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		
		conn = DriverManager.getConnection(url,uid,pwd);
		
		return conn;
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException ee)
		{
			ee.printStackTrace();
		}
		
		return conn;
	}
}
