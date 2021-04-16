import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCMySqlDB {
	
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
		String sql_query = "select deptId,deptName from department where headQuarters like 'chennai'";
		ResultSet rs = stmt.executeQuery(sql_query);
		
		//traversing the resultset
		while(rs.next())
		{
			System.out.println(rs.getInt("deptId"));
			System.out.println(rs.getString("deptName"));
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
