/**
 * Query 6
 * Authors: Tim Roesner,
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class Query6 {
   
   public static void main(String[] args) {
	   Statement stmt = null;
	   try{

	      // Open a connection
	      JDBC.connect();
	      
	      // Execute a query
	      stmt = JDBC.connection.createStatement();


	      // Create new publisher for new title
	      String query6Publisher = "INSERT INTO Publishers (publisherName)" +
	      				       "VALUES ('Crown')"; 
	      stmt.executeUpdate(query6Publisher);
	      System.out.println("Added Publisher");

	      
	      // Add new title
	      String query6Title = "INSERT INTO Titles (isbn, title, editionNumber, year, publisherID, price)" +
	      				       "VALUES ('0553448122', 'Artemis: A Novel', '1', '2017', '12', '16.20')"; 
	      stmt.executeUpdate(query6Title);
	      System.out.println("Added title");


	      // Link new title to author (In this case Andy Weir)
	      String query6authorISBN = "INSERT INTO authorISBN (authorID, isbn)" +
	      				       "VALUES ('15', '0553448122')"; 
	      stmt.executeUpdate(query6authorISBN);
	      System.out.println("Added authorISBN relation");

	   } catch(SQLException se) {
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } finally {
	      //finally block used to close resources
	      JDBC.close();
	   }
	}
}