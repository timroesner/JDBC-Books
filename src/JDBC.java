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
			return;
		}
    	connection = DriverManager
		.getConnection("jdbc:mysql://sql3.freemysqlhosting.net/sql3203681","sql3203681", "I3HZcVbb6k");
		if(connection == null) {
			throw new SQLException("Failed to make connection");
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