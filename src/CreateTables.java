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

	   	System.out.println("This will DELETE all data, do you want to continue? (y/n) ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		if(input == "y" || input == "Y") {
			// Open a connection
		    JDBC.connect();

		    // Drop Tables
		    String drop1 = "IF EXISTS(select * from sysobjects where name='Authors') DROP TABLE Authors ";
		  	stmt.executeUpdate(drop1);

		  	String drop2 = "IF EXISTS(select * from sysobjects where name='Titles') DROP TABLE Titles ";
		  	stmt.executeUpdate(drop2);

		  	String drop3 = "IF EXISTS(select * from sysobjects where name='Publishers') DROP TABLE Publishers ";
		  	stmt.executeUpdate(drop3);

		  	String drop4 = "IF EXISTS(select * from sysobjects where name='authorISBN') DROP TABLE authorISBN ";
		  	stmt.executeUpdate(drop4);
		      
		    // Create Tables
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