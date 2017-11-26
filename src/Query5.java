/**
 * Query 5: Edit/Update the existing information about an author
 * Author: Nityam Shrestha
 * CS 157A
 */


import java.sql.*;
import java.util.*;

public class Query5 {

	 public static void main(String[] args) {
	        Statement stmt = null;
	        try{

	            // Open a connection
	            JDBC.connect();

	            // Execute a query
	            stmt = JDBC.connection.createStatement();

	            // Update Author's information
	            String query5Author = "UPDATE authors SET firstName = 'NotWilliam' WHERE authorID= 16";
	            
	            
	            stmt.executeUpdate(query5Author);
	            System.out.println("Author's name changed");
	  	      
	            System.out.println("Show all Authors");
	            
	            
	            String query = "SELECT * FROM authors"; 
	  	      
	  	      ResultSet rs1 = stmt.executeQuery(query);
	  	      
	  	      
	  	      while (rs1.next()) {
	  	          	int id = rs1.getInt("authorID");
	  	            String firstName = rs1.getString("firstName");
	  	            String lastName = rs1.getString("lastName");
	  	            System.out.println(id + "\t" + firstName + "\t" + lastName);
	  	          }

	        } catch(SQLException se) {
	            //Handle errors for JDBC
	        	System.out.println("Connection Failed!");
	            se.printStackTrace();
	        } finally {
	            //finally block used to close resources
	            JDBC.close();
	        }
	    }
}
