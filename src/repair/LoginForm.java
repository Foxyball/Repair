package repair;

import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hristo Sabev
 */
public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();

        // ЛОГО
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        // заключване промяната на размера
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new repair.Button();
        showPasswordCheckBox = new javax.swing.JCheckBox();
        txtPassword = new repair.PasswordField();
        txtUsername = new repair.TextField();
        lblLogin = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button1.setBackground(new java.awt.Color(0, 151, 236));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("ВХОД");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        showPasswordCheckBox.setText("Покажи парола");
        showPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordCheckBoxActionPerformed(evt);
            }
        });

        txtPassword.setText("parolata1");
        txtPassword.setLabelText("Парола");

        txtUsername.setText("admin@repair.bg");
        txtUsername.setLabelText("Имейл");

        lblLogin.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("ВХОД");
        lblLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel1.setBackground(new java.awt.Color(241, 241, 230));

        lblImage.setBackground(new java.awt.Color(241, 241, 230));
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/6b111291-a264-41d4-8760-51602e30e47d.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(showPasswordCheckBox)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)))
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(showPasswordCheckBox)
                .addGap(18, 18, 18)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showPasswordCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordCheckBoxActionPerformed
        if (showPasswordCheckBox.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasswordCheckBoxActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        // Създаване на нова инстанция на config за връзка с базата данни
        config dbConfig = new config();

        String email = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        // proverqva dali poletata sa prazni
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Моля, попълнете Потребителско име и Парола", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String q = "SELECT * FROM users WHERE email = ? AND password = ?";
            try (PreparedStatement stmt = dbConfig.conn.prepareStatement(q)) {
                stmt.setString(1, email);
                stmt.setString(2, password);

                try (ResultSet ress = stmt.executeQuery()) {
                    if (ress.next()) {
                        int id = ress.getInt("id");
                        String user_name = ress.getString("name"); // Вземане на име за dashboard
                        String user_email = ress.getString("email");
                        String user_role = ress.getString("role");

                        User user = new User(id, user_name, user_email, "", "", user_role,
                                ress.getInt("pkod"), ress.getString("city"), ress.getString("status"),
                                ress.getString("egn"), ress.getInt("is_firm"), ress.getString("firm_name"),
                                ress.getString("firm_eik"), ress.getString("firm_mol"), ress.getString("firm_dds"),
                                ress.getString("firm_address"));

                        // Създаване на потребител, който да бъде записан като влязъл
                        User loggedInUser = new User(id, user_name, user_email, "", "", user_role, 0, "", "", "", 0, "", "", "", "", "");
                        LoggedInUser.setUser(loggedInUser);
                        System.out.println("Welcome, " + LoggedInUser.getUser().getName());

                        // Показване на подходящата форма в зависимост от ролята
                        if (user_role.equals("admin")) {
                            AdminForm adminform = new AdminForm("admin");
                            adminform.setVisible(true);
                            this.dispose();
                        } else if (user_role.equals("user")) {
                            int loggedInUserId = loggedInUser.getUserId();
                            UserForm userform = new UserForm(loggedInUserId);
                            userform.setVisible(true);
                            this.dispose();
                        }
                    } else {
                        // Потребителят не е намерен
                        JOptionPane.showMessageDialog(null, "Грешен имейл или парола");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConfig.close(); // Затваряне на връзката в края
        }
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button button1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JCheckBox showPasswordCheckBox;
    private repair.PasswordField txtPassword;
    private repair.TextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
