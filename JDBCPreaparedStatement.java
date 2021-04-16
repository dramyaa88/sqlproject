import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import demo.JDBC.MySQL.connect.MySQLConnection;

public class JDBCPreaparedStatement {
	
	
	static MySQLConnection myconn;
	static Connection conn;
	
	static void selectDepartments()
	{
		conn=myconn.mySqlDBConnection();
		String sql = "select deptId,deptName from department where deptId=?";
		try
		{
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setInt(1,100);
		ResultSet rs = psmt.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString("deptName"));
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		
		selectDepartments();
		
	}

}
