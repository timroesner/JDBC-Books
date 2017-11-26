/**
 * Query 7
 * @author Avani Bhatnagar
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class Query7 {
	
	public static void main(String[] args){
		Statement stmt = null;
		try{
			
			JDBC.connect();
			
			stmt = JDBC.connection.createStatement();
			
			String query4Publisher = "INSERT INTO Publishers(publisherID, publisherName)" + "VALUES('12', 'Random House')";
			
			stmt.executeUpdate(query4Publisher);
			System.out.println("Added Publisher");

			String query = "SELECT * FROM publishers"; 

	      
	      System.out.println("Added publisher 'Random House':");
	      
	      ResultSet rs1 = stmt.executeQuery(query);
	      
	      
	      while (rs1.next()) {
	          	int id = rs1.getInt("publisherID");
	            String publisherName = rs1.getString("publisherName");
	            System.out.println(id + "\t" + publisherName);
	          }

		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally{
			JDBC.close();
		}
	}

}