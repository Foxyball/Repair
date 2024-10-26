package repair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author thefo
 */
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
        String q = "SELECT name, email, phone, role, city, status FROM users";

        try (Connection connection = config.getConnection(); PreparedStatement stmt = connection.prepareStatement(q)) {

            // Изпълняване на заявката
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) { // като $name=$row['name']; $email=$row['email']; ?>
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String role = resultSet.getString("role");
                String city = resultSet.getString("city");
                String status = resultSet.getString("status");

                // Добавяне на данните в масив
                users.add(new Object[]{name, email, phone, role, city, status});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
