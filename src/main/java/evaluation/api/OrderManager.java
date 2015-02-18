package evaluation.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderManager {
	static Connection connection = null;
	static Statement statement = null;
	static Random random = new Random();
	static String sql;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createOMSDatabase() throws SQLException,
			ClassNotFoundException {

		connection = DriverManager.getConnection("jdbc:mysql://localhost",
				"root", "password");
		statement = connection.createStatement();

		sql = "CREATE DATABASE oms";
		statement.executeUpdate(sql);

	}

	public static void createOrderTable() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost",
				"root", "password");
		statement = connection.createStatement();

		sql = "CREATE TABLE oms.ORDERS " + "(orderid INTEGER not NULL, "
				+ "sellerid INTEGER not NULL, "
				+ "productid INTEGER not NULL, " + "price INTEGER, "
				+ "discount INTEGER, " + "PRIMARY KEY ( orderid ))";

		statement.executeUpdate(sql);
	}

	public static List<Integer> getProductsBySellerDiscount(int sellerid,
			int discount) throws SQLException {
		List<Integer> productList = new ArrayList<Integer>();
		connection = DriverManager.getConnection("jdbc:mysql://localhost",
				"root", "password");
		statement = connection.createStatement();

		sql = "SELECT distinct productid from oms.ORDERS where " + "sellerid="
				+ sellerid + " and discount=" + discount;

		ResultSet rs = statement.executeQuery(sql);
		 while(rs.next()){
	     productList.add(rs.getInt(1));  
		 }
		return productList;
	}

	public static void main(String[] argv) throws SQLException {
		populateOrders();
	}

	public static void populateOrders() throws SQLException {
		for (int i = 1; i < 10000; i++) {
			createOrder(i);
		}
	}

	public static void createOrder(int i) throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost",
				"root", "password");
		statement = connection.createStatement();
		int j = 10000 + random.nextInt(10);
		int discount = random.nextInt(10) * 10;
		sql = "INSERT INTO oms.ORDERS " + "VALUES (" + i + ","
				+ random.nextInt(101) + "," + random.nextInt(10) + "," + j
				+ "," + random.nextInt(10000) + ")";
		statement.executeUpdate(sql);
	}
}
