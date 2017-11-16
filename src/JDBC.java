/**
 * JDBC-Books
 * Authors: Tim Roesner
 * CS 157A
 */

import java.util.*;
import java.sql.*;

public class JDBC {

	public static Connection connection = null;

    public static void connect() throws SQLException {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL JDBC Driver Registered!");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			throw new SQLException();
		}
    	connection = DriverManager
		.getConnection("jdbc:mysql://mysql6.gear.host/books3?autoReconnect=true&useSSL=false","books3", "Pf69!-47Wtuz");
		if(connection == null) {
			throw new SQLException();
		} else {
			System.out.println("Successfully connected");
		}
    }

    public static void close() {
    	try {
			connection.close();
			System.out.println("Closing connection");
		} catch (SQLException e) {
			System.out.println("Failed to close connection!");
		}
    }
    
}