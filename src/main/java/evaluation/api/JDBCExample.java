package evaluation.api;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 
public class JDBCExample {
 
  public static void main(String[] argv) throws SQLException {
	  Connection connection = null;
	   Statement statement = null;
	   String sql;
 
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
 
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	}
 
	System.out.println("MySQL JDBC Driver Registered!");
	
	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost","root", "password");
		statement = connection.createStatement();
		
//	sql = "CREATE DATABASE oms";
  //  statement.executeUpdate(sql);
	      sql = "CREATE TABLE oms.ORDERS " +
	                   "(orderid INTEGER not NULL, " +
	                   "sellerid INTEGER not NULL, " +
	                   "productid INTEGER not NULL, " +
	                   "price INTEGER, " +
	                   "discount INTEGER, " +
	                   "PRIMARY KEY ( orderid ))"; 

	     statement.executeUpdate(sql);

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}
 
	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
  }
}