/**
 * JDBC-Books
 * Authors: Tim Roesner,
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class queryLayout {
   
   public static void main(String[] args) {
	   Statement stmt = null;
	   try{

	      // Open a connection
	      JDBC.connect();
	      
	      // Execute a query
	      stmt = JDBC.connection.createStatement();
	      
	      /*
	       * Creates the query to alphabatize all rows from authors by their first and last name
	       * 
	       * SELECT *
	       * FROM authors
	       * ORDER BY firstName, lastName
	       */
	      String query = "SELECT * FROM authors ORDER BY lastName , firstName "; 

	      stmt.executeUpdate(query);
	      System.out.println("Executed Query");

	   } catch(SQLException se) {
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } finally {
	      //finally block used to close resources
	      JDBC.close();
	   }
	}
}