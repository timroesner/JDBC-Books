/**
 * JDBC-Books
 * Authors: Tim Roesner,
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class ExampleQueryLayout {
   
   public static void main(String[] args) {
	   Statement stmt = null;
	   try{

	      // Open a connection
	      JDBC.connect();
	      
	      // Execute a query
	      stmt = JDBC.connection.createStatement();
	      
	      String exampleQuery = " Your Query here"; 

	      stmt.executeUpdate(exampleQuery);
	      System.out.println("Executed Example Query");

	   } catch(SQLException se) {
	      // Handle errors for JDBC
	      se.printStackTrace();
	   } finally {
	      // Finally block, used to close resources
	      JDBC.close();
	   }
	}
}