package edu.asu.DatabasePart1.DatabasePart1;
import java.sql.Connection; 
import java.sql.ResultSet;

import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;
//import java.sql.ResultSet; 

/**
 * Hello world!
 *
 */
public class Part2 
{
	   // JDBC driver name and database URL 
	   static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:~/firstDatabase";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 

    public static void main( String[] args )
    {
        System.out.println( "In-Memory Database by Lynn Robert Carter: Part 2!" );
        Connection conn = null; 
        Statement stmt = null; 
        ResultSet rs = null;
        try { 
           // STEP 1: Register JDBC driver 
           Class.forName(JDBC_DRIVER); 
               
           //STEP 2: Open a connection 
           System.out.println("Connecting to database..."); 
           conn = DriverManager.getConnection(DB_URL,USER,PASS);  
           
           //STEP 3: Execute a query 
           stmt = conn.createStatement(); 
           
           rs = stmt.executeQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'REGISTRATION'");

           if (!rs.next()) {
               System.out.println("Creating table in the given database..."); 
               String sql =  "CREATE TABLE REGISTRATION " + 
                             "(id INTEGER not NULL, " + 
                             " first VARCHAR(255), " +  
                             " last VARCHAR(255), " +  
                             " age INTEGER, " +  
                             " PRIMARY KEY (id))";  
               stmt.executeUpdate(sql);
               System.out.println("Created table in given database...");
           } else {
               System.out.println("Table 'REGISTRATION' already exists in the database.");
           }

//           System.out.println("Creating table in given database..."); 
//           
//           String sql =  "CREATE TABLE   REGISTRATION " + 
//              "(id INTEGER not NULL, " + 
//              " first VARCHAR(255), " +  
//              " last VARCHAR(255), " +  
//              " age INTEGER, " +  
//              " PRIMARY KEY ( id ))";  
//           stmt.executeUpdate(sql);
//           
//           System.out.println("Created table in given database...");
                     
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
