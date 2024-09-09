package edu.asu.DatabasePart1.DatabasePart1;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;
//import java.sql.ResultSet; 

/**
 * Hello world!
 *
 */
public class Part3 
{
	   // JDBC driver name and database URL 
	   static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:~/firstDatabase";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 

    public static void main( String[] args )
    {
        System.out.println( "In-Memory Database by Lynn Robert Carter: Part 3!" );
        Connection conn = null; 
        Statement stmt = null; 
        try { 
           // STEP 1: Register JDBC driver 
           Class.forName(JDBC_DRIVER); 
               
           //STEP 2: Open a connection 
           System.out.println("Connecting to database..."); 
           conn = DriverManager.getConnection(DB_URL,USER,PASS);  
           
           //STEP 3: Execute a query 
           stmt = conn.createStatement(); 
           
           System.out.println("Insert records into the table Registration..."); 

           String sql = "INSERT INTO Registration " + "VALUES (100, 'Zara', 'Ali', 18)"; 
           
           stmt.executeUpdate(sql); 
           sql = "INSERT INTO Registration " + "VALUES (101, 'Mahnaz', 'Fatma', 25)";  
           
           System.out.println("One record was inserted into the table Registration..."); 
           
           stmt.executeUpdate(sql); 
           sql = "INSERT INTO Registration " + "VALUES (102, 'Zaid', 'Khan', 30)"; 
           
           System.out.println("Two records were inserted into the table Registration..."); 
           
           stmt.executeUpdate(sql); 
           sql = "INSERT INTO Registration " + "VALUES(103, 'Sumit', 'Mittal', 28)"; 
           
           System.out.println("Three records were inserted into the table Registration..."); 
           
           stmt.executeUpdate(sql); 
           
           System.out.println("Four records were inserted into the table Registration..."); 

           // STEP 4: Clean-up environment 
           stmt.close(); 
           conn.close(); 
        } catch(SQLException se) { 
           //Handle errors for JDBC 
           se.printStackTrace(); 
        } catch(Exception e) { 
           //Handle errors for Class.forName 
           e.printStackTrace(); 
        } finally { 
           //finally block used to close resources 
           try{ 
              if(stmt!=null) stmt.close(); 
           } catch(SQLException se2) { 
           } // nothing we can do 
           try { 
              if(conn!=null) conn.close(); 
           } catch(SQLException se){ 
              se.printStackTrace(); 
           } //end finally try 
        } //end try 
        System.out.println("Goodbye!");
    }

}
