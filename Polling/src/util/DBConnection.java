package util;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() 
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("localhost:3306","root","Tavera123*");
			System.out.println("Connected");
		}
		
		catch(ClassNotFoundException | SQLException e )
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	public static void closeConnection(Connection con)
	{
		if(con!=null)
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static void closeResultSet(ResultSet rs)
	{
		if(rs!=null)
		{
			try
			{
				rs.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	 public static void closeStatement(PreparedStatement searchCustomerPS)
	 {
		 if( searchCustomerPS!=null)
			{
				try
				{
					searchCustomerPS.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
	 }
}
