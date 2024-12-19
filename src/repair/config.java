package repair;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class config {

    // път към базата данни
    private String DATABASE_URL = "jdbc:sqlite:.//db/repair.sqlite";
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;

    // Mailtrap SMTP глобални променливи за логин към сървъра, като (.env) в Laravel
    static final String EMAIL_FROM = "50d681784392ba";
    private static final String EMAIL_PASSWORD = "8d34b76e584db4";
    private static final String SMTP_HOST = "sandbox.smtp.mailtrap.io";
    private static final String SMTP_PORT = "587"; // Mailtrap SMTP port

    // Конструктор за връзка с базата
    public config() {
        try {
            conn = DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Затваряне на връзка с базата
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

    // съдържа настройките за връзка със SMTP
    public static Properties getMailProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Use STARTTLS
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        return props;
    }

    // създава и връща Session обект, който се използва за изпращане на имейли
    public static Session getMailSession() {
        return Session.getInstance(getMailProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_FROM, EMAIL_PASSWORD);
            }
        });
    }
    
    
    
    
    
      // SELECT заявка за извличане на фактурите
    public ArrayList<Invoice> loadAllInvoices() {
    ArrayList<Invoice> invoices = new ArrayList<>();
    String query = """
        SELECT i.invoice_id, 
               i.repair_id, 
               i.user_id, 
               i.total, 
               i.payment_status, 
               i.created_at, 
               u.name AS user_name, 
               p.product_name
        FROM invoices i
        JOIN users u ON i.user_id = u.id
        JOIN repair_orders ro ON i.repair_id = ro.repair_id
        JOIN products p ON ro.product_id = p.product_id
        ORDER BY i.created_at DESC
    """;

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Invoice invoice = new Invoice(
                rs.getInt("invoice_id"),
                rs.getInt("repair_id"),
                rs.getInt("user_id"),
                rs.getDouble("total"),
                rs.getString("payment_status"),
                rs.getString("created_at"),
                rs.getString("user_name"),
                rs.getString("product_name")
            );
            invoices.add(invoice);
        }
    } catch (SQLException e) {
        System.out.println("Error loading invoices: " + e.getMessage());
    }

    return invoices;
}

    
    // Заявка за сравнение и промяна на парола
    public boolean changeUserPassword(int user_id, String currentPassword, String newPassword) {
    String checkQuery = """
        SELECT password 
        FROM users 
        WHERE id = ?
    """;

    String updateQuery = """
        UPDATE users 
        SET password = ? 
        WHERE id = ?
    """;

    try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
        checkStmt.setInt(1, user_id);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            String dbPassword = rs.getString("password");
            if (!dbPassword.equals(currentPassword)) { 
                return false; 
            }
        } else {
            return false; 
        }

        // Обновяване на новата парола
        try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
            updateStmt.setString(1, newPassword); 
            updateStmt.setInt(2, user_id);

            int rowsUpdated = updateStmt.executeUpdate();
            return rowsUpdated > 0; 
        }
    } catch (SQLException e) {
        System.out.println("Error changing user password: " + e.getMessage());
        return false;
    }
}

    

    // SELECT заявка за извличане на заявките на конкретен клиент, който е логнат в системата (userDashboard)
    public ArrayList<Order> loadUserPersonalData(int user_id) {
        ArrayList<Order> orders = new ArrayList<>();
        String query = """
    SELECT ro.repair_id, 
           u.name AS user_name, 
           u.phone as phone,                       
           p.product_name, 
           ro.status, 
           s.shelf_name, 
           ro.created_at
    FROM repair_orders ro
    JOIN users u ON ro.user_id = u.id
    JOIN products p ON ro.product_id = p.product_id
    JOIN shelves s ON ro.shelf_id = s.shelf_id
    WHERE ro.user_id = ?
    ORDER BY ro.created_at DESC
    """;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("repair_id"),
                        rs.getString("product_name"),
                        rs.getString("user_name"),
                        rs.getString("phone"),
                        rs.getString("status"),
                        rs.getString("shelf_name"),
                        rs.getString("created_at")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error loading repair orders for user: " + e.getMessage());
        }

        return orders;
    }

    // SELECT заявка за извличане на последните 10 заявки със статус "Незавършен"
    public ArrayList<Order> loadOrderData() {
        ArrayList<Order> orders = new ArrayList<>();
        String query = """
SELECT ro.repair_id, 
       u.name AS user_name, 
    u.phone as phone,                       
       p.product_name, 
       ro.status, 
       s.shelf_name, 
       ro.created_at
FROM repair_orders ro
JOIN users u ON ro.user_id = u.id
JOIN products p ON ro.product_id = p.product_id
JOIN shelves s ON ro.shelf_id = s.shelf_id
ORDER BY ro.created_at DESC
""";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("repair_id"),
                        rs.getString("product_name"),
                        rs.getString("user_name"),
                        rs.getString("phone"),
                        rs.getString("status"),
                        rs.getString("shelf_name"),
                        rs.getString("created_at")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error loading last 10 repair orders: " + e.getMessage());
        }

        return orders;
    }

    // SELECT заявка за извличане на последните 10 заявки със статус "Незавършен"
    public ArrayList<Order> loadLast10Orders() {
        ArrayList<Order> orders = new ArrayList<>();
        String query = """
SELECT ro.repair_id, 
       u.name AS user_name, 
                       u.phone AS phone,
       p.product_name, 
       ro.status, 
       s.shelf_name, 
       ro.created_at
FROM repair_orders ro
JOIN users u ON ro.user_id = u.id
JOIN products p ON ro.product_id = p.product_id
JOIN shelves s ON ro.shelf_id = s.shelf_id
WHERE ro.status = 'Незавършен'
ORDER BY ro.created_at DESC
LIMIT 10
""";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("repair_id"),
                        rs.getString("product_name"),
                        rs.getString("user_name"),
                        rs.getString("phone"),
                        rs.getString("status"),
                        rs.getString("shelf_name"),
                        rs.getString("created_at")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Error loading last 10 repair orders: " + e.getMessage());
        }

        return orders;
    }

    // UPDATE Заявка за обновяване капацитета на рафтовете след създаване на заявка
    public boolean updateShelfLoad(int shelf_id, int increment) {
        String query = "UPDATE shelves SET current_load = current_load + ? WHERE shelf_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, increment);
            stmt.setInt(2, shelf_id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error updating shelf load: " + e.getMessage());
            return false;
        }
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
//        списък с колоните, разделени със запетая
        String columnsString = String.join(", ", columns);
        String sql = "SELECT " + columnsString + " FROM " + table;

        if (!whereClause.isEmpty()) {
            sql += " WHERE " + whereClause;
        }

        System.out.println("Executing SQL: " + sql);  // debug

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Ако има параметри за WHERE клаузата, добавяме ги към заявката
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    // Параметрите започват от 1 (PreparedStatement е 1-базирано, а не от 0)
                    stmt.setObject(i + 1, params[i]);
                }
            }
            // Изпълнение на заявката и получаване на ResultSet
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Събиране на данните от текущия ред
                    StringBuilder row = new StringBuilder();
                    for (String column : columns) {
                        // Ако колоната съдържа '.', вземаме само името след '.'
                        String columnName = column.contains(".") ? column.split("\\.")[1] : column;
                        row.append(rs.getString(columnName)).append("---");
                    }
                    // Премахваме последния разделител и добавяме реда към масива
                    result.add(row.substring(0, row.length() - 3));
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
        // Генериране на placeholders ("?, ?, ?") за стойностите
        // Използва се "?" според броя на стойностите, след което с регулярния израз се добавя запетая и премахва последната такава
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
        // Конструиране на SQL заявката: "UPDATE table SET column1 = ?, column2 = ?, ... WHERE whereColumn = ?"
        StringBuilder sql = new StringBuilder("UPDATE " + table + " SET ");
        for (int i = 0; i < columns.length; i++) {
            // Добавяне на всяка колона със стойност като placeholder
            sql.append(columns[i]).append(" = ?, ");
        }
        // Премахване на последната запетая и интервал
        sql.setLength(sql.length() - 2);
        // Добавяне на WHERE условие
        sql.append(" WHERE ").append(whereColumn).append(" = ?");

        try (PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }

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
