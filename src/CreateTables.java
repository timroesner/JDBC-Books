/**
 * JDBC-Books
 * Authors: Tim Roesner,
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class CreateTables {
   
   public static void main(String[] args) {
	   Statement stmt = null;
	   try{

	      // Open a connection
	      JDBC.connect();
	      
	      // Execute a query
	      stmt = JDBC.connection.createStatement();
	      
	      String authorsTable = "CREATE TABLE Authors " +
	                   "(authorID INTEGER NOT NULL AUTO_INCREMENT, " +
	                   " firstName CHAR(20), " + 
	                   " lastName CHAR(20), " +  
	                   " PRIMARY KEY (authorID))"; 

	      stmt.executeUpdate(authorsTable);
	      System.out.println("Created Authors table");

	      String titlesTable = "CREATE TABLE Titles " +
	                   "(isbn CHAR(13) not NULL, " +
	                   " title VARCHAR(255), " + 
	                   " editionNumber INTEGER, " + 
	                   " year CHAR(4), " + 
	                   " publisherID INTEGER REFERENCES Publishers(publisherID), " + 
	                   " price DECIMAL(8,2), " +
	                   " PRIMARY KEY (isbn))"; 

	      stmt.executeUpdate(titlesTable);
	      System.out.println("Created Titles table");

	      String publishersTable = "CREATE TABLE Publishers " +
	                   "(publisherID INTEGER NOT NULL AUTO_INCREMENT, " +
	                   " publisherName CHAR(100), " + 
	                   " PRIMARY KEY (publisherID))"; 

	      stmt.executeUpdate(publishersTable);
	      System.out.println("Created Publishers table");

	      String authorISBNTable = "CREATE TABLE authorISBN " +
	                   "(authorID INTEGER REFERENCES Authors(authorID), " +
	                   " isbn CHAR(10) REFERENCES Titles(isbn))";  

	      stmt.executeUpdate(authorISBNTable);
	      System.out.println("Created authorISBN table");

	   } catch(SQLException se) {
	      // Handle errors for JDBC
	      se.printStackTrace();
	   } finally {
	      // Finally block, used to close resources
	      JDBC.close();
	   }
	}
}