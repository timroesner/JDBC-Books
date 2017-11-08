/**
 * JDBC-Books
 * Authors: Tim Roesner
 * CS 157A
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabase {

  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");

	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	}

	System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;

	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://sql3.freemysqlhosting.net/sql3203681","sql3203681", "I3HZcVbb6k");

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}

	if (connection != null) {
		System.out.println("Successfully connected");
		try {
			connection.close();
			System.out.println("Closing connection");
		} catch (SQLException e) {
			System.out.println("Failed to close connection!");
		}
	} else {
		System.out.println("Failed to make connection!");
	}
  }
}