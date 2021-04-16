import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import demo.JDBC.MySQL.connect.MySQLConnection;

public class MySQLclass {
	
	static MySQLConnection myconn;
	static Connection conn;
	
	static void selectDepartment()
	{
		conn=myconn.mySqlDBConnection();
		String sqlQuery = "select deptId,deptName from department where deptId > ?";
		String addQuery = "insert into department values(?,?,?,?)";
		String updateQuery = "update department set strength = 90 where deptId = 300";
		String deleteQuery = "delete from department where deptId = 10";
		String displayQuery = "select deptId,deptName,headQuarters,strength from department group by deptName";
		try
		{
//		PreparedStatement psmt = conn.prepareStatement(sqlQuery);
//		psmt.setInt(1,100);
//		PreparedStatement psmt1 = conn.prepareStatement(addQuery);
//		psmt1.setInt(1, 95);
//		psmt1.setString(2, "Alien");
//		psmt1.setInt(3, 102);
//		psmt1.setString(4, "Nagapattinaam");
//		psmt1.execute();
//		PreparedStatement psmt2 = conn.prepareStatement(deleteQuery);
//		psmt2.execute();
		PreparedStatement psmt3 = conn.prepareStatement(displayQuery);
		psmt3.execute();
		ResultSet rs = psmt3.executeQuery();
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+" ");
			System.out.print(rs.getString("deptName")+" ");
			System.out.print(rs.getString("headQuarters")+" ");
			System.out.print(rs.getInt(4));
			System.out.println();
//		
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
		
		selectDepartment();
		
	}

}
