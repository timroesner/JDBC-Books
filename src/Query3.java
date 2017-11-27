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
          
          String query3 = "SELECT isbn, title, year, publisherID FROM titles WHERE publisherID=3 ORDER BY title";
           
	      ResultSet rs = stmt.executeQuery(query3);
	      System.out.println();
          System.out.println("--------------------------------------------------");
          System.out.println("List of books by selected publisher");
          System.out.println("--------------------------------------------------");

          while(rs.next()){
                  int id = rs.getInt("publisherID");
                  String isbn = rs.getString("isbn");
                  String title = rs.getString("title");
                  String year = rs.getString("year");
                  System.out.println(id + " - " + title + " - " + year + " - " + isbn);
              
              
          }
          System.out.println("--------------------------------------------------");
          System.out.println();
	      

	   } catch(SQLException se) {
	      // Handle errors for JDBC
          System.out.println("Connection Failed!");
	      se.printStackTrace();
	   } finally {
	      // Finally block, used to close resources
	      JDBC.close();
	   }
	}
}