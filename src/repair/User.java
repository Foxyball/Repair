package repair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    public static int user_id;
    public static String name;
    public static String email;
    private String password;
    private String phone;
    private String role;
    private int pkod;
    private String city;
    private String status;
    private String egn;
    private int is_firm;
    private String firm_name;
    private String firm_eik;
    private String firm_mol;
    private String firm_dds;
    private String firm_address;

    // SELECT EMAIL
    public static void loadUserEmail(int id) {
        try (Connection connection = config.getConnection()) {
            String sql = "SELECT email FROM users WHERE id = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    User.email = rs.getString("email");
                } else {
                    System.out.println("User not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // INSERT
    public static boolean insertUser(String name, String password, String email, String phone, String role, int pkod, String city, String status, String egn, int is_firm, String firm_name, String firm_eik, String firm_mol, String firm_dds, String firm_address) {
        String sql = "INSERT INTO users(name, password, email, phone, role, pkod, city, status, egn, is_firm, firm_name, firm_eik, firm_mol, firm_dds, firm_address, created_at) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, datetime('now'))"; // SQLite datetime

        try (Connection connection = config.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setString(5, role);
            stmt.setInt(6, pkod);
            stmt.setString(7, city);
            stmt.setString(8, status);
            stmt.setString(9, egn);

            if (is_firm == 1) {
                stmt.setInt(10, 1);
                stmt.setString(11, firm_name);
                stmt.setString(12, firm_eik);
                stmt.setString(13, firm_mol);
                stmt.setString(14, firm_dds);
                stmt.setString(15, firm_address);
            } else {
                stmt.setInt(10, 0);
                stmt.setNull(11, java.sql.Types.VARCHAR);
                stmt.setNull(12, java.sql.Types.VARCHAR);
                stmt.setNull(13, java.sql.Types.VARCHAR);
                stmt.setNull(14, java.sql.Types.VARCHAR);
                stmt.setNull(15, java.sql.Types.VARCHAR);
            }

            stmt.executeUpdate();
            return true; // Success
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Failure
        }
    }

    // SELECT
    public static List<Object[]> getAllUsers() {
        List<Object[]> users = new ArrayList<>();
        String q = "SELECT id, name, email, phone,city, status,egn,pkod,role,is_firm,firm_name,firm_eik,firm_mol,firm_dds,firm_address FROM users";

        try (Connection connection = config.getConnection(); PreparedStatement stmt = connection.prepareStatement(q)) {

            // Изпълняване на заявката
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) { // като $name=$row['name']; $email=$row['email']; ?>
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String city = resultSet.getString("city");
                String status = resultSet.getString("status");
                String egn = resultSet.getString("egn");
                String pkod = resultSet.getString("pkod");
                String role = resultSet.getString("role");
                int isFirm = resultSet.getInt("is_firm");
                String firmName = resultSet.getString("firm_name");
                String firmEik = resultSet.getString("firm_eik");
                String firmMol = resultSet.getString("firm_mol");
                String firmDds = resultSet.getString("firm_dds");
                String firmAddress = resultSet.getString("firm_address");

                // Добавяне на данните в масив
                users.add(new Object[]{id, name, email, phone, city, status, egn, pkod, role, isFirm, firmName, firmEik, firmMol, firmDds, firmAddress});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // UPDATE
    public static boolean updateUser(int id, String name, String email, String phone, String city, String status, String egn, String pkod, String role, String is_firm, String firmName, String firmMol, String firmEik, String firmDds, String firmAddress) {
        try (Connection connection = config.getConnection()) {
            String q = "UPDATE users SET name = ?, email = ?, phone = ?, city = ?, status = ?, egn = ?, pkod = ?, role = ?, is_firm = ?, firm_name = ?, firm_mol = ?, firm_eik = ?, firm_dds = ?, firm_address = ? WHERE id = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(q)) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, phone);
                pstmt.setString(4, city);
                pstmt.setString(5, status);
                pstmt.setString(6, egn);
                pstmt.setString(7, pkod);
                pstmt.setString(8, role);
                pstmt.setString(9, is_firm);
                pstmt.setString(10, firmName);
                pstmt.setString(11, firmMol);
                pstmt.setString(12, firmEik);
                pstmt.setString(13, firmDds);
                pstmt.setString(14, firmAddress);
                pstmt.setInt(15, id);

                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0; // Return true if the update was successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of an error
        }
    }

    // DELETE
    public static boolean deleteUser(int userId) {
    try (Connection connection = config.getConnection()) {
        String q = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(q)) {
            pstmt.setInt(1, userId);

            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false; 
    }
}

   
    // Search % %
     public static List<Object[]> searchUsers(String searchText) {
        List<Object[]> users = new ArrayList<>();

        try (Connection connection = config.getConnection()) {
            String sql = "SELECT * FROM users WHERE name LIKE ? OR egn LIKE ? OR firm_name LIKE ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                String query = "%" + searchText + "%"; 
                pstmt.setString(1, query);
                pstmt.setString(2, query);
                pstmt.setString(3, query);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Object[] userData = {
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getString("city"),
                            rs.getString("status"),
                            rs.getString("egn"),
                            rs.getString("pkod"),
                            rs.getString("role"),
                            rs.getInt("is_firm") == 1 ? "Да" : "Не",
                            rs.getString("firm_name"),
                            rs.getString("firm_eik"),
                            rs.getString("firm_mol"),
                            rs.getString("firm_dds"),
                            rs.getString("firm_address")
                        };
                        users.add(userData);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


}
