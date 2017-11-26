# JDBC-Books
The goal of this project is to use JDBC to create a Booksdatabase, populate it, and then execute different SQL statements to query or manipulate the Booksdatabase.


## Overview
In this project, using JDBC application that access an installed RDBMS (you need to have an account), you will need to:
* Create the Booksdatabase tables as specified in the schema definition below.
* Initialize the different tables (at least 15 entries per table) appropriately: all fields cannot be null.
* Issue the following SQL statements. For queries print the results from java into your console:
  * 1. Select all authors from the authorstable. Order the information alphabetically by the author’s last name and first name.
  * 2. Select all publishers from the publisherstable.
  * 3. Select a specific publisher and list all books published by that publisher. Include the title, yearand ISBN number. Order the information alphabetically by title.
  * 4. Add new author
  * 5. Edit/Update the existing information about an author
  * 6. Add a new title for an author
  * 7. Add new publisher
  * 8. Edit/Update the existing information about a publisher

## Setup
To run this project on your machine you need to make sure you have the MySQL JDBC driver installed. You can find the .jar file in this repo. Mac users should copy it to /Library/Java/Extensions    
To make sure you setup everything correctly and the JDBC is running on your machine run the TestDatabase file from your shell.  

## JDBC API
To make things a little easier I created an API with the credentials to our database so that you don't have to do the setup yourself. The two methods in the API are as follows:
```java
public static void connect() throws SQLException
public static void close()
```
As you can see you need to take care of error handeling if the connection isn't established, so make sure to wrap that method in a try catch block and only precede if the conenction was successful. Here is a little example how your code could look like to open and close connections to our database:
```java
try {
  JDBC.connect();
  // Your code here
  JDBC.close();
} catch (SQLException e) {
  System.out.println("Connection Failed!");
  e.printStackTrace();
  return;
}
```
If you are catching other exepctions make sure to put the close statement into the finally block, but don't close connections that weren't established.  

## To-Do
:white_check_mark: Initialize repo  
:white_check_mark: Create database  
:white_check_mark: Compile demo data for tables  
:white_check_mark: Created tables    
:white_check_mark: Initialize tables with demo data  Ravin  
:black_square_button: Code: Query 1  Tyler  
:black_square_button: Code: Query 2  Shri  
:black_square_button: Code: Query 3  Shweta  
:white_check_mark: Code: Query 4  Shivangi  
:black_square_button: Code: Query 5  Nit  
:white_check_mark: Code: Query 6  Tim  
:white_check_mark: Code: Query 7  Avani  
:black_square_button: Code: Query 8  Karan , James  
:black_square_button: One/two page documentation of the implementation  
:black_square_button: Print out two copies of documentation and output  
:black_square_button: Turn in during class Dec 5  

## Guidelines
1. Open an issue when you start working on one of the queries
2. You can work on it in a fork or branch
3. Submit a PR when you finished and tested your code and want to merge
4. Update the To-Do accordingly
