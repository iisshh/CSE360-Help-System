//package edu.asu.DatabasePart1.DatabasePart1;
//import java.sql.Connection; 
//import java.sql.DriverManager; 
//import java.sql.SQLException; 
//import java.sql.Statement;
//import java.util.Scanner;
//
//
//public class Main
//{
//	private static final DatabaseHelper dbHelper = new DatabaseHelper();
//	private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main( String[] args )
//    {
//        
//        try { 
//           
//        	dbHelper.connect();  // Connect to the database
//            
//            // Check if the database is empty (no users registered)
//            if (dbHelper.isDatabaseEmpty()) {
//            	System.out.println( "In-Memory Database  is empty" );
//            	//set up administrator access
//            	setupAdministrator();
//            }
//            else {
//            	System.out.println( "If you are an administrator, then select a\nIf you are an user then select u\nEnter your choice:  " );
//            	String role = scanner.nextLine();
//            	
//            	switch (role) {
//                case "u":
//                    userFlow();
//                    break;
//                case "a":
//                    adminFlow();
//                    break;
//                
//                default:
//                    System.out.println("Invalid choice. Please select 'a', 'u'");
//                    dbHelper.closeConnection();
//            	}
//            	
//            }
//        } catch (SQLException e) {
//            System.err.println("Database error: " + e.getMessage());
//        }
//    }
//    
//    private static void setupAdministrator() throws SQLException {
//        System.out.println("Setting up the Administrator access.");
//        System.out.print("Enter Admin Email: ");
//        String email = scanner.nextLine();
//        System.out.print("Enter Admin Password: ");
//        String password = scanner.nextLine();
//        dbHelper.register(email, password, "admin");
//        System.out.println("Administrator setup completed.");
//
//    }
//    private static void userFlow() throws SQLException {
//        
//    }
//    
//    private static void adminFlow() throws SQLException {
//    	 System.out.println("admin flow");
//    	 System.out.print("Enter Admin Email: ");
//         String email = scanner.nextLine();
//         System.out.print("Enter Admin Password: ");
//         String password = scanner.nextLine();
//         if (dbHelper.login(email, password, "admin")) {
//             System.out.println("Admin login successful.");
//             dbHelper.displayUsers();
//             
//         } else {
//             System.out.println("Invalid admin credentials.");
//         }
//    }
//    
//}
