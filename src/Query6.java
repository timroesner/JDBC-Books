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
	      System.out.println("Added Publisher 'Crown' ");

	      
	      // Add new title
	      String query6Title = "INSERT INTO Titles (isbn, title, editionNumber, year, publisherID, price)" +
	      				       "VALUES ('0553448122', 'Artemis: A Novel', '1', '2017', (SELECT publisherID FROM Publishers WHERE publisherName = 'Crown'), '16.20')"; 
	      stmt.executeUpdate(query6Title);
	      System.out.println("Added title 'Artemis: A Novel' ");


	      // Link new title to author (In this case Andy Weir)
	      String query6authorISBN = "INSERT INTO authorISBN (authorID, isbn)" +
	      				       "VALUES ((SELECT authorID FROM Authors WHERE firstName = 'Andy' AND lastName = 'Weir'), '0553448122')"; 
	      stmt.executeUpdate(query6authorISBN);
	      System.out.println("Added authorISBN relation");

	      // Print modified tables
	      String exampleQuery2 = "SELECT * FROM Titles"; 
	      System.out.println("Titles:");
	      ResultSet rs2 = stmt.executeQuery(exampleQuery2);
          while (rs2.next()) {
            String isbn = rs2.getString("isbn");
            String title = rs2.getString("title");
            int edition = rs2.getInt("editionNumber");
            String year = rs2.getString("year");
            int pubID = rs2.getInt("publisherID");
            float price = rs2.getFloat("price");
            System.out.println(isbn + "\t" + title + "\t" + edition + "\t" + year + "\t" + pubID + "\t" + price);
          }

	      String exampleQuery3 = "SELECT * FROM Publishers"; 
	      System.out.println("Publishers:");
	      ResultSet rs3 = stmt.executeQuery(exampleQuery3);
          while (rs3.next()) {
          	int id = rs3.getInt("publisherID");
            String name = rs3.getString("publisherName");
            System.out.println(id + "\t" + name);
          }

	      String exampleQuery4 = "SELECT * FROM authorISBN";
	      System.out.println("authorISBN:"); 
	      ResultSet rs4 = stmt.executeQuery(exampleQuery4);
          while (rs4.next()) {
          	int id = rs4.getInt("authorID");
          	String isbn = rs4.getString("isbn");
            System.out.println(id + "\t" + isbn);
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