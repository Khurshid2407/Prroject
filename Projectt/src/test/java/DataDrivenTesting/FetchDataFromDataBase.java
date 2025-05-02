package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDataFromDataBase {

	public static void main(String[] args) throws Exception {
		
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","khurshid0786");
		System.out.println("Connection sucessfully");
		Statement state=conn.createStatement();
//------------------------------------------------------------------------------------------------------------------
		                                     // For create database
	/*	String createDatabaseQuery = "CREATE DATABASE teachers";
        state.executeUpdate(createDatabaseQuery);                
        System.out.println("Database is created sucessfully");
        conn.close(); */
//------------------------------------------------------------------------------------------------------------------
		                                     // For create table
	/*	String createTable= "CREATE TABLE teachers("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "username VARCHAR(255) NOT NULL, "
                + "email VARCHAR(255) NOT NULL, "
                + "age INT)";
		state.executeUpdate(createTable);                        

        System.out.println("Table 'teachers' created successfully in the database.");
        conn.close(); */
 //-----------------------------------------------------------------------------------------------------------------
		                                    // For Insert data
	/*	int result = state.executeUpdate("insert into teachers(username,email,age)value('Kanisk_01','kanisk@gmail.com','26'),('Ashok_02','ashok@gmail.com','30')");
		System.out.println(result);
		conn.close(); */                                         
//------------------------------------------------------------------------------------------------------------------
		                                   // For print all data
	/*	ResultSet res = state.executeQuery("select * from teachers");
		while(res.next())
		{
			System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
		}                                                         
		conn.close(); */
//------------------------------------------------------------------------------------------------------------------
		                                 // For print a particular data
	/*	ResultSet res = state.executeQuery("select * from teachers");
		res.next();
		System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
		conn.close(); */                                            
		
        
		

	}

}
