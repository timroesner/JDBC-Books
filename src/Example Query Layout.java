/**
 * JDBC-Books
 * Authors: Tim Roesner,
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class CreateTables {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://sql3.freemysqlhosting.net/sql3203681";

   //  Database credentials
   static final String USER = "sql3203681";
   static final String PASS = "I3HZcVbb6k";
   
   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      Class.forName(JDBC_DRIVER);

	      // Open a connection
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully");
	      
	      // Execute a query
	      stmt = conn.createStatement();
	      
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
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } catch(Exception e) {
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   } finally {
	      //finally block used to close resources
	      try {
	         if(stmt!=null)
	            conn.close();
	      } catch(SQLException se) {
	      }// do nothing
	      try {
	         if(conn!=null)
	            conn.close();
	        	System.out.println("Connection closed");
	      } catch(SQLException se) {
	         se.printStackTrace();
	      }
	   }
	}
}