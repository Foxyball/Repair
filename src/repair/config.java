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
    
    
     // SELECT заявка за извличане на shelves
    public ArrayList<Category> loadCategoryData() {
        ArrayList<Category> categories = new ArrayList<>();
        String q = "SELECT cat_id, category_name FROM categories";

        try (PreparedStatement stmt = conn.prepareStatement(q)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("cat_id"),
                        rs.getString("category_name")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            System.out.println("Error loading category data: " + e.getMessage());
        }

        return categories;
    }
    
    
    

    // SELECT заявка за извличане на machines с JOIN към categories и brands
    public ArrayList<Machine> loadMachineData() {
        ArrayList<Machine> machines = new ArrayList<>();
        String q = """
    SELECT p.product_id, 
           p.product_name, 
           p.category_id, 
           c.category_name, 
           p.brand_id, 
           b.brand_name, 
           p.price, 
           p.qty
    FROM products p
    JOIN categories c ON p.category_id = c.cat_id
    JOIN brands b ON p.brand_id = b.brand_id
""";

        try (PreparedStatement stmt = conn.prepareStatement(q)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Machine machine = new Machine(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getInt("brand_id"),
                        rs.getString("brand_name"),
                        rs.getDouble("price"),
                        rs.getInt("qty")
                );
                machines.add(machine);
            }
        } catch (SQLException e) {
            System.out.println("Error loading product data: " + e.getMessage());
        }

        return machines;
    }

    // SELECT заявка за извличане на shelves
    public ArrayList<Shelf> loadShelfData() {
        ArrayList<Shelf> shelves = new ArrayList<>();
        String q = "SELECT shelf_id, shelf_name, max_capacity,current_load FROM shelves";

        try (PreparedStatement stmt = conn.prepareStatement(q)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Shelf shelf = new Shelf(
                        rs.getInt("shelf_id"),
                        rs.getString("shelf_name"),
                        rs.getInt("max_capacity"),
                        rs.getInt("current_load")
                );
                shelves.add(shelf);
            }
        } catch (SQLException e) {
            System.out.println("Error loading shelf data: " + e.getMessage());
        }

        return shelves;
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

        System.out.println("Executing SQL: " + sql);  // debug

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    stmt.setObject(i + 1, params[i]);
                }
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    StringBuilder row = new StringBuilder();
                    for (String column : columns) {
                        String columnName = column.contains(".") ? column.split("\\.")[1] : column;
                        row.append(rs.getString(columnName)).append("---");
//                        row.append(rs.getString(column)).append("---");
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
