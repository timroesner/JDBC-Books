/**
 * JDBC-Books
 * Authors: Ravin Sardal
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class InsertTestData {

	public static void main(String[] argv) {
		updateAuthorsTables();
	}

	private static void updateAuthorsTables() {
		String authorFirstNames[] = { "Jane", "Dan", "Ralph Waldo", "F.Scott", "Ernest", "Walter", "Stephen", "Stieg",
				"George", "Joanne K.", "John", "John R. R.", "Kurt", "Andy" };
		String authorLastNames[] = { "Austen", "Brown", "Emerson", "Firtzgerald", "Grisham", "Hemingway", "Isaacson",
				"King", "Larsson", "Orwell", "Rowling", "Steinbeck", "Tolkien", "Vonnegut", "Weir" };
		Statement stmt = null;
		try {
			JDBC.connect();
			stmt = JDBC.connection.createStatement();

			for (int i=1;i<=authorFirstNames.length;i++) {
        String updateAuthorsTables = "INSERT INTO Authors (authorID, firstName, lastName)"
  					+ "VALUES ("+i+", '"+ authorFirstNames[i-1] +"', '"+authorLastNames[i-1]+"')";
  			stmt.executeUpdate(updateAuthorsTables);
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
			return;
		}

		JDBC.close();
	}
}
