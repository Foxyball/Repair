package repair;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 *
 * @author thefo
 */
// Config for db connection
public class config {

    private String DATABASE_URL = "jdbc:sqlite:.//db/repair.sqlite";
//    private static Connection connection;
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;

    // Mailtrap SMTP credentials
    static final String EMAIL_FROM = "50d681784392ba";
    private static final String EMAIL_PASSWORD = "8d34b76e584db4";
    private static final String SMTP_HOST = "sandbox.smtp.mailtrap.io";
    private static final String SMTP_PORT = "587"; // Mailtrap SMTP port

    // Конструктор
    public config() {
        try {
            conn = DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Throwable ex) {
            Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
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

    // SELECT заявка за извличане на brands
    public ArrayList<Brand> loadBrandData() {
        ArrayList<Brand> brands = new ArrayList<>();
        String q = "SELECT * FROM brands";

        try (PreparedStatement stmt = conn.prepareStatement(q)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Brand brand = new Brand(
                        rs.getInt("brand_id"),
                        rs.getString("brand_name")
                );
                brands.add(brand);
            }
        } catch (SQLException e) {
            System.out.println("Error loading brand data: " + e.getMessage());
        }

        return brands;
    }

    // SELECT заявка за извличане на users
    public ArrayList<User> loadUserData(String filter) {
        ArrayList<User> users = new ArrayList<>();
        String q = "SELECT * FROM users";

        if (!filter.isEmpty()) {
            q += " WHERE " + filter;
        }

        try (PreparedStatement stmt = conn.prepareStatement(q)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        rs.getString("role"),
                        rs.getInt("pkod"),
                        rs.getString("city"),
                        rs.getString("status"),
                        rs.getString("egn"),
                        rs.getInt("is_firm"),
                        rs.getString("firm_name"),
                        rs.getString("firm_eik"),
                        rs.getString("firm_mol"),
                        rs.getString("firm_dds"),
                        rs.getString("firm_address")
                );
                users.add(user); // добавяне към масива ArrayList<User> users 
            }
        } catch (SQLException e) {
            System.out.println("Error loading user data: " + e.getMessage());
        }

        return users;
    }

    // SELECT универсална заявка с/без WHERE/
    public ArrayList<String> select(String[] columns, String table, String whereClause, Object[] params) {
        ArrayList<String> result = new ArrayList<>();
        String columnsString = String.join(", ", columns);
        String sql = "SELECT " + columnsString + " FROM " + table;

        if (!whereClause.isEmpty()) {
            sql += " WHERE " + whereClause;
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set parameters if available
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    stmt.setObject(i + 1, params[i]);
                }
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    StringBuilder row = new StringBuilder();
                    for (String column : columns) {
                        row.append(rs.getString(column)).append("---");
                    }
                    result.add(row.substring(0, row.length() - 3)); // Remove last separator
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // INSERT универсална заявка
    public boolean insert(String table, String[] columns, Object[] values) {
        String columnsString = String.join(", ", columns);
        // регулярен израз за добавяне на  "?,?,?" и премахване на последната запетая с ",$"
        String placeholders = "?".repeat(values.length).replaceAll("(.{1})", "$1,").replaceAll(",$", "");

        String sql = "INSERT INTO " + table + " (" + columnsString + ") VALUES (" + placeholders + ")";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }
            stmt.executeUpdate();
            System.out.println("Data inserted successfully into " + table);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE универсална заявка
    public boolean update(String table, String[] columns, Object[] values, String whereColumn, Object whereValue) {
        StringBuilder sql = new StringBuilder("UPDATE " + table + " SET ");
        for (int i = 0; i < columns.length; i++) {
            sql.append(columns[i]).append(" = ?, ");
        }
        sql.setLength(sql.length() - 2); // Remove last comma
        sql.append(" WHERE ").append(whereColumn).append(" = ?");

        try (PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            // Set values for columns
            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }
            // Set WHERE condition
            stmt.setObject(values.length + 1, whereValue);

            stmt.executeUpdate();
            System.out.println("Data updated successfully in " + table);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE универсална заявка
    public boolean delete(String table, String whereColumn, Object whereValue) {
        String sql = "DELETE FROM " + table + " WHERE " + whereColumn + " = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, whereValue);
            stmt.executeUpdate();
            System.out.println("Data deleted successfully from " + table);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
