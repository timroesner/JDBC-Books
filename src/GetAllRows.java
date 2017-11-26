/**
 * JDBC-Books
 * Authors: Tim Roesner,
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class GetAllRows {
   
   public static void main(String[] args) {
	   Statement stmt = null;
	   try{

	      // Open a connection
	      JDBC.connect();
	      
	      // Execute a query
	      stmt = JDBC.connection.createStatement();
	      
	      String exampleQuery1 = "SELECT * FROM Authors";
	      System.out.println("Authors:");
	      ResultSet rs1 = stmt.executeQuery(exampleQuery1);
          while (rs1.next()) {
          	int id = rs1.getInt("authorID");
            String firstName = rs1.getString("firstName");
            String lastName = rs1.getString("lastName");
            System.out.println(id + "\t" + firstName + "\t" + lastName);
          }
	      
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
	      // Handle errors for JDBC
	      se.printStackTrace();
	   } finally {
	      // Finally block, used to close resources
	      JDBC.close();
	   }
	}
}