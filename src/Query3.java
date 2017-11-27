/**
 * JDBC-Books
 * Authors: Shweta More
 * CS 157A
 * Query 3: Select a specific publisher and list all 
 * books published by that publisher. 
 * Include the title, year and ISBN number. 
 * Order the information alphabetically by title.
 */

import java.sql.*;
import java.util.*;

public class Query3 {
   
   public static void main(String[] args) {
	   Statement stmt = null;
	   try{

	      // Open a connection
	      JDBC.connect();
	      
	      // Execute a query
	      stmt = JDBC.connection.createStatement();
	      
	      String query3_publisher = "SELECT isbn, title, year FROM Titles WHERE publisherID=1 ORDER BY title"; 
          System.out.println("List of books by selected publisher");
          System.out.println("-----------------------------------");
          ResultSet rs3 = stmt.executeQuery(query3_publisher);
          while(rs3.next()){
              int isbn = rs3.getInt("isbn");
              String title = rs3.getString("title");
              int year = rs3.getInt("year");
              int id = rs3.getInt("publisherID");
              System.out.println(id + "\t" + title + "\t" + year + "\t" + isbn);
          }
	      

	   } catch(SQLException se) {
	      // Handle errors for JDBC
	      se.printStackTrace();
	   } finally {
	      // Finally block, used to close resources
	      JDBC.close();
	   }
	}
}