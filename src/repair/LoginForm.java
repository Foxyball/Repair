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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelTransparent1 = new repair.PanelTransparent();
        showPasswordCheckBox = new javax.swing.JCheckBox();
        txtPassword = new repair.PasswordField();
        txtUsername = new repair.TextField();
        button1 = new repair.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ВХОД");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(342, 342, 342))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        showPasswordCheckBox.setText("Покажи парола");
        showPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordCheckBoxActionPerformed(evt);
            }
        });

        txtPassword.setText("parolata1");
        txtPassword.setLabelText("Парола");

        txtUsername.setText("admin@abv.bg");
        txtUsername.setLabelText("Имейл");

        button1.setBackground(new java.awt.Color(0, 151, 236));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("ВХОД");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparent1Layout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showPasswordCheckBox)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(215, 215, 215))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showPasswordCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTransparent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                        User loggedInUser = new User(id, user_name, user_email, "", "", "", 0, "", "", "", 0, "", "", "", "", "");
                        LoggedInUser.setUser(loggedInUser);
                        System.out.println("Welcome, " + LoggedInUser.getUser().getName());

                        // Показване на подходящата форма в зависимост от ролята
                        if (user_role.equals("admin")) {
                            AdminForm adminform = new AdminForm("admin");
                            adminform.setVisible(true);
                            this.dispose();
                        } else if (user_role.equals("user")) {
                            AdminForm adminform = new AdminForm("user");
                            adminform.setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private repair.PanelTransparent panelTransparent1;
    private javax.swing.JCheckBox showPasswordCheckBox;
    private repair.PasswordField txtPassword;
    private repair.TextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
