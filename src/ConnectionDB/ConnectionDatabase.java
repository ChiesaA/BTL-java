package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
	static String url = "jdbc:mysql://localhost:3306/vanphongpham";
	static String username = "root";
	static String password = "vu180300";
	
	private static Connection connection;
  
     public static Connection getConnection() throws SQLException, ClassNotFoundException { 
        if (connection == null) { 
             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection(url, username, password);
         } 
         return connection; 
     } 
     public static void closeConnection() throws SQLException { 
         if (connection != null) { 
        	 connection.close(); 
         } 
     } 
}

