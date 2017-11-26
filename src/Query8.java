/**
 * JDBC-Books
 * Authors: Jameson Thai
 * Query 8 Aims to update/edit existing information about a publisher
 * CS 157A
 */
import java.sql.*;
import java.util.*;

public class Query8 {
   
   public static void main(String[] args) {
	   Statement stmt = null;
       try{

           // Open a connection
           JDBC.connect();

           // Execute a query
           stmt = JDBC.connection.createStatement();

           // Display all current information to see original listing
           String query8View = "SELECT * FROM publishers;";

           System.out.println("Show all publishers Here!");

           ResultSet rs1 = stmt.executeQuery(query8View);

           while (rs1.next()) {
               int id = rs1.getInt("publisherID");
               String pubName = rs1.getString("publisherName");
               System.out.println(id + "\t" + pubName);
           }
           
           String query8Publisher = "UPDATE publishers SET publisherName='Lupin' WHERE publisherID = 1";

           // executeUpdate to manipulate data information for update command
           stmt.executeUpdate(query8Publisher);
           System.out.println("Command being executed: " + query8Publisher);
           ResultSet rs2 = stmt.executeQuery(query8View);
           while (rs2.next()) {
               int id = rs2.getInt("publisherID");
               String pubName = rs2.getString("publisherName");
               System.out.println(id + "\t" + pubName);
           }
           
           // Reset the Information
           String resetQuery = "UPDATE publishers SET publisherName='Penguin' WHERE publisherID = 1";
           stmt.executeUpdate(resetQuery);
           
       } catch(SQLException se) {
           //Handle errors for JDBC
           se.printStackTrace();
       } finally {
           //finally block used to close resources
           JDBC.close();
       }
	}
}