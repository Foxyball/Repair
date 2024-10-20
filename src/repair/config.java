package repair;
import java.sql.*;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
/**
 *
 * @author thefo
 */

// Config for db connection
public class config {
    
    private static final String DATABASE_URL="jdbc:sqlite:.//db/repair.sqlite";
    private static Connection connection;
    
    
    // Mailtrap SMTP credentials
    static final String EMAIL_FROM = "50d681784392ba"; 
    private static final String EMAIL_PASSWORD = "8d34b76e584db4"; 
    private static final String SMTP_HOST = "sandbox.smtp.mailtrap.io";
    private static final String SMTP_PORT = "587"; // Mailtrap SMTP port
    
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
    
    
 public static Properties getMailProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Use STARTTLS
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        return props;
    }

    public static Session getMailSession() {
        return Session.getInstance(getMailProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_FROM, EMAIL_PASSWORD);
            }
        });
    }
    
}
