/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repair;
import java.sql.*;
/**
 *
 * @author thefo
 */
public class config {
    
    private static final String DATABASE_URL="jdbc:sqlite:.//db/repair.sqlite";
    private static Connection connection;
    
    public static Connection getConnection(){
         Connection connection = null; // Create a new connection each time
        if(connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection=DriverManager.getConnection(DATABASE_URL);
                System.out.println("Connected to database");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return connection;
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected from database");
            } catch (Exception e) {
                   e.printStackTrace();
            }
        }
        
    }
    
}
