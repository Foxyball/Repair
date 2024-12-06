package repair;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import repair.config;

/**
 *
 * @author hristo
 */
public class userEditPanel extends javax.swing.JPanel {

    private boolean isFirmChecked = false;
    private int id;
    config q = new config();

    public userEditPanel(int id, String name, String email, String phone, String city, String status, String egn, String pkod, String role, String is_firm, String firm_name, String firm_eik, String firm_mol, String firm_dds, String firm_address) {
        initComponents();
        
        lblEditUser.setText("РЕДАКТИРАНЕ НА ПОТРЕБИТЕЛ - " + name);

        this.id = id;

        txtUserID.setText(String.valueOf(id));
        txtUserName.setText(name);
        txtUserEmail.setText(email);
        txtUserPhone.setText(phone);
        txtUserCity.setText(city);
        comboUserStatus.setSelectedItem(status);
        txtUserEGN.setText(egn);
        txtUserPKOD.setText(pkod);
        if (role.equals("admin")) {
            comboUserRole.setSelectedIndex(1);
        } else if (role.equals("user")) {
            comboUserRole.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "Възникна грешка при избиране на достъп");
        }

       
        if (is_firm.equals("1")) {
            is_firm_checkbox.setSelected(true);
            toggleFirmFieldsVisibility(true);
        } else {
            is_firm_checkbox.setSelected(false);
            toggleFirmFieldsVisibility(false);
        }

      
        firm_name_txt.setText(firm_name);
        firm_eik_txt.setText(firm_eik);
        firm_mol_txt.setText(firm_mol);
        firm_address_txt.setText(firm_address);
        firm_dds_txt.setText(firm_dds);

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        is_firm_lbl = new javax.swing.JLabel();
        is_firm_checkbox = new javax.swing.JCheckBox();
        lblEditUser = new javax.swing.JLabel();
        txtUserID = new repair.TextField();
        btnAddUser = new repair.Button();
        txtUserName = new repair.TextField();
        txtUserEmail = new repair.TextField();
        txtUserPhone = new repair.TextField();
        txtUserCity = new repair.TextField();
        txtUserEGN = new repair.TextField();
        firm_name_txt = new repair.TextField();
        txtUserPKOD = new repair.TextField();
        comboUserRole = new repair.ComboBox();
        comboUserStatus = new repair.ComboBox();
        firm_eik_txt = new repair.TextField();
        firm_mol_txt = new repair.TextField();
        firm_dds_txt = new repair.TextField();
        firm_address_txt = new repair.TextField();

        is_firm_lbl.setText("Фирма ?");

        is_firm_checkbox.setText("ДА");
        is_firm_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                is_firm_checkboxActionPerformed(evt);
            }
        });

        lblEditUser.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblEditUser.setText("РЕДАКТИРАНЕ НА ПОТРЕБИТЕЛ");

        txtUserID.setEnabled(false);
        txtUserID.setLabelText("ID");

        btnAddUser.setBackground(new java.awt.Color(0, 153, 255));
        btnAddUser.setForeground(new java.awt.Color(255, 255, 255));
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        btnAddUser.setText("Запази");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        txtUserName.setLabelText("Име и Фамилия");

        txtUserEmail.setLabelText("Имейл");

        txtUserPhone.setLabelText("Телефон");

        txtUserCity.setLabelText("Град");

        txtUserEGN.setLabelText("ЕГН");

        firm_name_txt.setLabelText("Име на фирма");

        txtUserPKOD.setLabelText("Пощ. код");

        comboUserRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Клиент", "Администратор" }));

        comboUserStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Активен", "Неактивен" }));

        firm_eik_txt.setLabelText("Фирма ЕИК");

        firm_mol_txt.setLabelText("Фирма МОЛ");

        firm_dds_txt.setLabelText("Фирма ДДС");

        firm_address_txt.setLabelText("Адрес на фирма");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUserCity, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUserPKOD, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUserPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUserEGN, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboUserStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboUserRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(198, 198, 198))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(firm_eik_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(firm_dds_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(firm_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(firm_mol_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(is_firm_lbl)
                                .addGap(18, 18, 18)
                                .addComponent(is_firm_checkbox)
                                .addGap(51, 51, 51))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(firm_address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblEditUser)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(is_firm_lbl)
                                    .addComponent(is_firm_checkbox)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firm_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firm_mol_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firm_eik_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firm_dds_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firm_address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserPKOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserEGN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(comboUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboUserStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void toggleFirmFieldsVisibility(boolean visible) {
        firm_name_txt.setVisible(visible);
        firm_mol_txt.setVisible(visible);
        firm_eik_txt.setVisible(visible);
        firm_dds_txt.setVisible(visible);
        firm_address_txt.setVisible(visible);
        
         // преизчислява промените по layout-a заради скритите полета
            this.revalidate();
            this.repaint();
    }


    private void is_firm_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_is_firm_checkboxActionPerformed
        isFirmChecked = is_firm_checkbox.isSelected();
        toggleFirmFieldsVisibility(isFirmChecked);
    }//GEN-LAST:event_is_firm_checkboxActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed

        String name = txtUserName.getText();
        String email = txtUserEmail.getText();
        String phone = txtUserPhone.getText();
        String city = txtUserCity.getText();
        String status = comboUserStatus.getSelectedItem().toString();
        String egn = txtUserEGN.getText();
        String pkod = txtUserPKOD.getText();
        String role = comboUserRole.getSelectedItem().toString();
        String is_firm = isFirmChecked ? "1" : "0";
        
        
         if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || role.isEmpty() || city.isEmpty() || egn.isEmpty() || txtUserPKOD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Моля, попълнете всички полета", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        role = comboUserRole.getSelectedItem().toString();
        if (role.equals("Клиент")) {
            role = "user";
        } else if (role.equals("Администратор")) {
            role = "admin";
        }

        if (status.equals("Активен")) {
            status = "active";
        } else if (status.equals("Неактивен")) {
            status = "inactive";
        }

        is_firm = is_firm_checkbox.isSelected() ? "1" : "0";

        // Взимаме стойностите на фирмените полета, като проверяваме дали е чекнато или не, при ънчек нулира полетата на празен низ, защото не е фирма
        String firm_name = isFirmChecked ? firm_name_txt.getText() : "";
        String firm_mol = isFirmChecked ? firm_mol_txt.getText() : "";
        String firm_eik = isFirmChecked ? firm_eik_txt.getText() : "";
        String firm_dds = isFirmChecked ? firm_dds_txt.getText() : "";
        String firm_address = isFirmChecked ? firm_address_txt.getText() : "";

        String[] columns = {"name", "email", "phone", "city", "status", "egn", "pkod", "role", "is_firm", "firm_name", "firm_eik", "firm_mol", "firm_dds", "firm_address"};
        Object[] values = {name, email, phone, city, status, egn, pkod, role, is_firm, firm_name, firm_eik, firm_mol, firm_dds, firm_address};

        boolean success = q.update("users", columns, values, "id", id);

        if (success) {
            JOptionPane.showMessageDialog(this, "Промените са запазени успешно.");
        } else {
            JOptionPane.showMessageDialog(this, "Грешка при запазване на промените.");
        }

    }//GEN-LAST:event_btnAddUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnAddUser;
    private repair.ComboBox comboUserRole;
    private repair.ComboBox comboUserStatus;
    private repair.TextField firm_address_txt;
    private repair.TextField firm_dds_txt;
    private repair.TextField firm_eik_txt;
    private repair.TextField firm_mol_txt;
    private repair.TextField firm_name_txt;
    private javax.swing.JCheckBox is_firm_checkbox;
    private javax.swing.JLabel is_firm_lbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEditUser;
    private repair.TextField txtUserCity;
    private repair.TextField txtUserEGN;
    private repair.TextField txtUserEmail;
    private repair.TextField txtUserID;
    private repair.TextField txtUserName;
    private repair.TextField txtUserPKOD;
    private repair.TextField txtUserPhone;
    // End of variables declaration//GEN-END:variables
}
