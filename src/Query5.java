/**
 * Query 5: Edit/Update the existing information about an author
 * Author: Nityam Shrestha
 * CS 157A
 */


import java.sql.*;
import java.util.*;

public class Query5 {

	public static void main(String[] args) {
		Statement stmt = null;
		try{

			// Open a connection
			JDBC.connect();

			// Execute a query
			stmt = JDBC.connection.createStatement();

			String query = "SELECT * FROM authors"; 

			// Prints the original Value
			ResultSet rs1 = stmt.executeQuery(query);
			System.out.println("Author's name changed from : ");
			while(rs1.next()){
				int id = rs1.getInt("authorID");
				if(id == 16){
					String firstName = rs1.getString("firstName");
					String lastName = rs1.getString("lastName");
					System.out.println(id + "\t" + firstName + "\t" + lastName);
				}
			}

			// Update Author's information
			String query5Author = "UPDATE authors SET firstName = 'NotWilliam' WHERE authorID= 16";
			stmt.executeUpdate(query5Author);
			
			// Prints the Updated Value
			ResultSet rs2 = stmt.executeQuery(query);
			while(rs2.next()){
				int id = rs2.getInt("authorID");
				if(id == 16){
					System.out.println(" to ");
					
					String updatedFName = rs2.getString("firstName");
					String updatedLName = rs2.getString("lastName");
					System.out.println(id + "\t" + updatedFName + "\t" + updatedLName);
					
				}
			}
			
			System.out.println();
			// Prints the Update Author table
			rs2 = stmt.executeQuery(query);
			System.out.println("----***-----");
			System.out.println("Show all Authors");
			System.out.println();
			while (rs2.next()) {
				int id = rs2.getInt("authorID");
				String firstName = rs2.getString("firstName");
				String lastName = rs2.getString("lastName");
				System.out.println(id + "\t" + firstName + "\t" + lastName);
			}

		} catch(SQLException se) {
			//Handle errors for JDBC
			System.out.println("Connection Failed!");
			se.printStackTrace();
		} finally {
			//finally block used to close resources
			JDBC.close();
		}
	}
}
