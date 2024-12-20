package repair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserForm extends javax.swing.JFrame {

    JPanel contentPanel;
    userdashboardPanel userdashboardPanel;
    accountPanel accountPanel;
    

    private int loggedInUserId;

    public UserForm(int userId) {
        initComponents();
        this.setLocationRelativeTo(null); // Centrirane
        this.setSize(1250, 800);

             this.loggedInUserId = userId;
      
      
        lbl_user.setText(LoggedInUser.getUser().getName());

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));

  

        contentPanel = new JPanel(new CardLayout());
        sideLayoutPanel.setLayout(new BoxLayout(sideLayoutPanel, BoxLayout.Y_AXIS));

        // Зарежда динамичните панели при стартиране
        LoadDynamicPanels();
    }
    

    // Динамично зареждане на панелите [не трием]
    void LoadDynamicPanels() {

        userdashboardPanel = new userdashboardPanel(loggedInUserId);
        contentPanel.add(userdashboardPanel, "dashboard");
        btnDashboard.addActionListener(switchPanelListener);
        btnDashboard.setActionCommand("dashboard");
        sideLayoutPanel.add(Box.createVerticalStrut(10)); // Add more spacing
        sideLayoutPanel.add(btnDashboard);                    // Add button2
        sideLayoutPanel.add(Box.createVerticalStrut(20)); // Add vertical spacing

       
        accountPanel = new accountPanel(loggedInUserId);
          contentPanel.add(accountPanel, "account");
        btnAccount.addActionListener(switchPanelListener);
        btnAccount.setActionCommand("account");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAccount);               
        sideLayoutPanel.add(Box.createVerticalStrut(20));

        // Layout, не променяй
        //************************************  
        this.setLayout(new BorderLayout());
        this.add(jPanel1, BorderLayout.NORTH);
        this.add(sideLayoutPanel, BorderLayout.WEST);
        this.add(contentPanel, BorderLayout.CENTER);
    }

    ActionListener switchPanelListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
            String actionCommand = e.getActionCommand();
            cardLayout.show(contentPanel, actionCommand);
        }
    };

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideLayoutPanel = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        sideLayoutPanel.setBackground(new java.awt.Color(235, 247, 248));
        sideLayoutPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N

        btnDashboard.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/dashboard.png"))); // NOI18N
        btnDashboard.setText("НАЧАЛО");
        btnDashboard.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N
        btnDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/addUser.png"))); // NOI18N
        btnAccount.setText("Профил");
        btnAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideLayoutPanelLayout = new javax.swing.GroupLayout(sideLayoutPanel);
        sideLayoutPanel.setLayout(sideLayoutPanelLayout);
        sideLayoutPanelLayout.setHorizontalGroup(
            sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                .addGroup(sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sideLayoutPanelLayout.setVerticalGroup(
            sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnDashboard)
                .addGap(31, 31, 31)
                .addComponent(btnAccount)
                .addContainerGap(544, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(235, 247, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/logout.png"))); // NOI18N
        logoutButton.setText("Изход");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Здравейте, ");

        lbl_user.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_user.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(603, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_user)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_user)
                        .addComponent(jLabel3))
                    .addComponent(logoutButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jMenu1.setText("Файл");
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Изход");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Помощ");

        jMenuItem1.setText("За приложението");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sideLayoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sideLayoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Сигурни ли сте, че искате да се отпишете?", "Изход", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // izvikvame metoda za izxod
            logout();
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    // [Menu Bar] За приложението
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JDialog dialog = new JDialog(this, "За Приложението", true);
        AboutAppPanel about = new AboutAppPanel(dialog);

        dialog.getContentPane().add(about);

        dialog.setSize(800, 800);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // [Menu Bar] За Изход
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Сигурни ли сте, че искате да се отпишете?", "Изход", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // izvikvame metoda za izxod
            logout();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed

    }//GEN-LAST:event_btnAccountActionPerformed

    // logout user function
    public void logout() {
        // Assuming you're storing the logged-in user in a class like LoggedInUser
        LoggedInUser.setUser(null);  // Clear the stored user (this is a custom utility class)

        // Create and show the LoginForm
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);

        // Close the current window
        this.dispose();
    }

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
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 int loggedInUserId = 123;
                new UserForm(loggedInUserId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel sideLayoutPanel;
    // End of variables declaration//GEN-END:variables
}
