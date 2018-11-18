package JDBC;

import java.sql.*;

public class ConnectionFactory {
	private static Connection dbconnection;
	private static String connectionString = "jdbc:mysql://localhost:3306/web_tech";

	public static Connection getConnection() {
		try {
			dbconnection = DriverManager.getConnection(connectionString, "root", "aXXo1212");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return dbconnection;
	}
}
