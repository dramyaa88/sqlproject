import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCclass2 {
	static String mysqlcname = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/Employee";
	static String userid = "root";
	static String password = "root";
	
	static void connectToMySql()
	{
		try
		{
		//register the driver class
		Class.forName(mysqlcname);
		
		//Establishing the connection
		Connection conn = DriverManager.getConnection(url,userid,password);
		System.out.println("Successfully connected to database");
		Statement stmt = conn.createStatement();
		String sql_query = "select deptName,deptId from department where deptId>=200";
		ResultSet rs = stmt.executeQuery(sql_query);
		
		//traversing the resultset
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			System.out.println(rs.getInt(2));
			//System.out.println(rs.getString());
		}
		rs.close();
		stmt.close();
		conn.close();
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		connectToMySql();
	}

}
