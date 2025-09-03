package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Connection Conn;
	public void getDBConnection(String url, String uname, String password) throws SQLException
	{
		try {
		 Driver driverRef= new Driver();
		 DriverManager.registerDriver(driverRef);		 
		 Conn= DriverManager.getConnection(url,uname, password);
		    }
		catch(Exception e) {
			//TODO: handle exception
			System.out.println("connection not established");
		    }
	}
	
//Hardcode the DB connection (in entire project there is only one database so better to call this method instead of giving URl ,UN etc
	//method overloading
			public void getDBConnection() throws SQLException
			{
				try {
				 Driver driverRef= new Driver();
				 DriverManager.registerDriver(driverRef);		 
				 Conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_E18", "root", "Nokia@2690");
				    }
				catch(Exception e) {
					//TODO: handle exception
					System.out.println("connection not established");
				    }
			}
	
	public void closeDBConnection()
	{
		try {
			Conn.close();
		}
		catch (Exception e) {
			//TODO: handle exception
		}
	}
		public ResultSet executeSelectQuery(String query)
		{
			ResultSet result=null;
			try {
		 Statement stmt = Conn.createStatement();
		  result=stmt.executeQuery(query);
			}
			catch (Exception e) {
				//TODO: handle exception
			}
			return result;
	}
		public int executeNonSelectQuery(String query)
		{
			int result=0;
			try {
		 Statement stmt = Conn.createStatement();
		  result=stmt.executeUpdate(query);
			}
			catch (Exception e) {
				//TODO: handle exception
			}
			return result;

		}
		

}
