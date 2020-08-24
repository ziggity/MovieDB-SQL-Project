package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

//import dao.DBConnection;

public class DBConnection {
	
	
	static Scanner scanner = new Scanner(System.in);

	private final static String URL = "jdbc:mysql://uo3emq7vxcyxytdo:eGmoOf4maoeJZUnBeOc5@bikdplp4e0h9teynppoh-mysql.services.clever-cloud.com:3306/bikdplp4e0h9teynppoh";
	private final static String USERNAME = "uo3emq7vxcyxytdo";
	private final static String PASSWORD = "eGmoOf4maoeJZUnBeOc5";
	private static Connection connection;
	private static DBConnection instance;
	
	private DBConnection(Connection connection) {
		DBConnection.connection = connection;
	}
//	
//	private static String getPassword() {
//		System.out.println("Enter the database password: ");
//		String userPassword = scanner.nextLine();
//		return userPassword;
//	}

	public static Connection getConnection() {
		if ( instance == null ) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnection(connection);
				System.out.println("Connection successful.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return DBConnection.connection;
	}
	
}
