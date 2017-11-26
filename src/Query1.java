/**
 * JDBC-Books
 * Authors: Tyler Bruno
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class Query1 {
   
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

	      
	      System.out.println("Alphabatized all rows by first and last name:");
	      
	      ResultSet rs1 = stmt.executeQuery(query);
	      
	      
	      while (rs1.next()) {
	          	int id = rs1.getInt("authorID");
	            String firstName = rs1.getString("firstName");
	            String lastName = rs1.getString("lastName");
	            System.out.println(id + "\t" + firstName + "\t" + lastName);
	          }

	   } catch(SQLException se) {
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } finally {
	      //finally block used to close resources
	      JDBC.close();
	   }
	}
}