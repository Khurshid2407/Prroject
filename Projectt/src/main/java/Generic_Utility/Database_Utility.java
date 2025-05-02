package Generic_Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Database_Utility {
	
	Connection conn=null;
	public void getDatabaseConnection(String url, String username, String password) throws Throwable
	{
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}	
	}
	
	public void closeDatabaseConnection() throws Throwable
	{
		try {
			conn.close();
		} catch (Exception e) {
		}
	}
	
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet result=null;
		try {
			Statement state = conn.createStatement();
			result=state.executeQuery(query);
			
		} catch (Exception e) {
		}
		return result;
	}
	
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		try {
			Statement state = conn.createStatement();
			result=state.executeUpdate(query);
			
		} catch (Exception e) {
		}
		return result;	
	}

}
