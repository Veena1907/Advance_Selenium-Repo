package DDTPractise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeletingDataFromDB {

	public static void main(String[] args) throws SQLException {
		Driver driverRef= new Driver();
		 DriverManager.registerDriver(driverRef);
		 
		 Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_E18", "root", "Nokia@2690");
		 Statement stmt = conn.createStatement();
		 int result = stmt.executeUpdate("Delete from Ninza_CRM_Details where Browser='safari'");
		 if(result!=0)
		 {
			 System.out.println("Data stored succesfully");
		 }
		 else
		 {
			 System.out.println("Operation failed");
		 }
		 conn.close();
	}

}
