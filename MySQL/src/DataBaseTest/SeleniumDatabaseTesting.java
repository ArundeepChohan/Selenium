package DataBaseTest;

import java.sql.*;
/*
 * Don't use XAMPP use MYSQL Notifier
 */
public class SeleniumDatabaseTesting {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String databaseName = "mydatabase";
		String username = "root";
		String password = "root";		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver"); //depreciated
			conn = DriverManager.getConnection(url+databaseName,username,password);
			//String sqlQuery = "Select * from signupdetails";
			String sqlQuery = "Select * from signupdetails ORDER BY s_id DESC";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sqlQuery);
			result.next();
			System.out.println(result.getString("LastName"));	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			if(conn != null) {
				conn = null;
			}
		}
	}

}
