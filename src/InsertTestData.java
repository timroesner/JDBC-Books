/**
 * JDBC-Books
 * Authors: Ravin Sardal
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class InsertTestData {

	public static void main(String[] argv) {
		// updateAuthorsTable();
    updateAuthorISBNTable();
	}

	private static void updateAuthorsTable() {
		String authorFirstNames[] = { "Jane", "Dan", "Ralph Waldo", "F.Scott", "Ernest", "Walter", "Stephen", "Stieg",
				"George", "Joanne K.", "John", "John R. R.", "Kurt", "Andy" };
		String authorLastNames[] = { "Austen", "Brown", "Emerson", "Firtzgerald", "Grisham", "Hemingway", "Isaacson",
				"King", "Larsson", "Orwell", "Rowling", "Steinbeck", "Tolkien", "Vonnegut", "Weir" };
		Statement stmt = null;
		try {
			JDBC.connect();
			stmt = JDBC.connection.createStatement();

			for (int i=1;i<=authorFirstNames.length;i++) {
        String updateAuthorsTable = "INSERT INTO Authors (authorID, firstName, lastName)"
  					+ "VALUES ("+i+", '"+ authorFirstNames[i-1] +"', '"+authorLastNames[i-1]+"')";
  			stmt.executeUpdate(updateAuthorsTable);
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
			return;
		}
		JDBC.close();
	}

  private static void updateAuthorISBNTable(){
    String authorISBN[] = { "0141439518", "0307474278", "0142437629", "0743273565", "0345543240", "0684801223", "1501127625",
				"1501175466", "0307949486", "0451524935", "0439708180", "0142000687", "0547928227", "0385333849", "0553418026" };
		Statement stmt = null;
		try {
			JDBC.connect();
			stmt = JDBC.connection.createStatement();

			for (int i=1;i<=authorISBN.length;i++) {
        String updateAuthorISBNTable = "INSERT INTO authorISBN (authorID, isbn)"
  					+ "VALUES ("+i+", '"+ authorISBN[i-1] +"')";
  			stmt.executeUpdate(updateAuthorISBNTable);
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
			return;
		}
		JDBC.close();
  }
}
