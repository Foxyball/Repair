package repair;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import repair.config;

/**
 *
 * @author thefo
 */
public class userEditPanel extends javax.swing.JPanel {

    private boolean isFirmChecked = false;
    private int id;
    config q = new config();

    public userEditPanel(int id, String name, String email, String phone, String city, String status, String egn, String pkod, String role, String is_firm, String firm_name, String firm_eik, String firm_mol, String firm_dds, String firm_address) {
        initComponents();

        this.id = id;

        jTextField8.setText(String.valueOf(id));
        jTextField2.setText(name);
        jTextField3.setText(email);
        jTextField4.setText(phone);
        jTextField6.setText(city);
        jComboBox1.setSelectedItem(status);
        jTextField7.setText(egn);
        jTextField5.setText(pkod);
        if (role.equals("admin")) {
            jComboBox2.setSelectedIndex(1);
        } else if (role.equals("user")) {
            jComboBox2.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "Възникна грешка при избиране на достъп");
        }

        // Manage firm details visibility
        if (is_firm.equals("1")) {
            is_firm_checkbox.setSelected(true);
            toggleFirmFieldsVisibility(true);
        } else {
            is_firm_checkbox.setSelected(false);
            toggleFirmFieldsVisibility(false);
        }

        // Set firm fields
        firm_name_txt.setText(firm_name);
        firm_eik_txt.setText(firm_eik);
        firm_mol_txt.setText(firm_mol);
        firm_address_txt.setText(firm_address);
        firm_dds_txt.setText(firm_dds);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        firm_name_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        firm_eik_txt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        firm_mol_txt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        firm_dds_txt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        firm_address_txt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        is_firm_lbl = new javax.swing.JLabel();
        is_firm_checkbox = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        firm_name_lbl = new javax.swing.JLabel();
        firm_eik_lbl = new javax.swing.JLabel();
        firm_mol_lbl = new javax.swing.JLabel();
        firm_dds_lbl = new javax.swing.JLabel();
        firm_address_lbl = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();

        jLabel10.setText("Телефон");

        jLabel6.setText("Достъп");

        jLabel12.setText("Пощенски код");

        jLabel13.setText("Град");

        jLabel14.setText("Статус");

        jLabel15.setText("ЕГН");

        is_firm_lbl.setText("Фирма ?");

        is_firm_checkbox.setText("ДА");
        is_firm_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                is_firm_checkboxActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        jButton1.setText("Запази");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        firm_name_lbl.setText("Име на фирма");

        firm_eik_lbl.setText("Фирма ЕИК");

        firm_mol_lbl.setText("Фирма МОЛ");

        firm_dds_lbl.setText("Фирма ДДС");

        firm_address_lbl.setText("Адрес на фирма");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Клиент", "Администратор" }));

        jLabel7.setText("Име и Фамилия");

        jLabel8.setText("Имейл");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Активен", "Неактивен" }));

        jLabel9.setText("ID");

        jTextField8.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(396, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jTextField8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(79, 79, 79)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField6)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))))
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(is_firm_lbl)
                            .addComponent(firm_name_lbl))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firm_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(is_firm_checkbox)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firm_eik_lbl)
                            .addComponent(firm_mol_lbl)
                            .addComponent(firm_dds_lbl)
                            .addComponent(firm_address_lbl))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firm_eik_txt)
                            .addComponent(firm_mol_txt)
                            .addComponent(firm_dds_txt)
                            .addComponent(firm_address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(411, 411, 411)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(is_firm_lbl)
                                    .addComponent(is_firm_checkbox)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firm_name_lbl)
                            .addComponent(firm_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firm_eik_lbl)
                            .addComponent(firm_eik_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firm_mol_lbl)
                            .addComponent(firm_mol_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firm_dds_lbl)
                            .addComponent(firm_dds_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firm_address_lbl)
                            .addComponent(firm_address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
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
        firm_name_lbl.setVisible(visible);
        firm_mol_lbl.setVisible(visible);
        firm_eik_lbl.setVisible(visible);
        firm_dds_lbl.setVisible(visible);
        firm_address_lbl.setVisible(visible);
        firm_name_txt.setVisible(visible);
        firm_mol_txt.setVisible(visible);
        firm_eik_txt.setVisible(visible);
        firm_dds_txt.setVisible(visible);
        firm_address_txt.setVisible(visible);
    }


    private void is_firm_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_is_firm_checkboxActionPerformed
        isFirmChecked = is_firm_checkbox.isSelected();
        toggleFirmFieldsVisibility(isFirmChecked);
    }//GEN-LAST:event_is_firm_checkboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String name = jTextField2.getText();
        String email = jTextField3.getText();
        String phone = jTextField4.getText();
        String city = jTextField6.getText();
        String status = jComboBox1.getSelectedItem().toString();
        String egn = jTextField7.getText();
        String pkod = jTextField5.getText();
        String role = jComboBox2.getSelectedItem().toString();
        String is_firm = isFirmChecked ? "1" : "0";

        role = jComboBox2.getSelectedItem().toString();
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

        String firm_name = firm_name_txt.getText();
        String firm_mol = firm_mol_txt.getText();
        String firm_eik = firm_eik_txt.getText();
        String firm_dds = firm_dds_txt.getText();
        String firm_address = firm_address_txt.getText();

        String[] columns = {"name", "email", "phone", "city", "status", "egn", "pkod", "role", "is_firm", "firm_name", "firm_mol", "firm_eik", "firm_dds", "firm_address"};
        Object[] values = {name, email, phone, city, status, egn, pkod, role, is_firm, firm_name, firm_mol, firm_eik, firm_dds, firm_address};

        // Call the update method from config
        boolean success = q.update("users", columns, values, "id", id);

        if (success) {
            JOptionPane.showMessageDialog(this, "Промените са запазени успешно.");
        } else {
            JOptionPane.showMessageDialog(this, "Грешка при запазване на промените.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed

    }//GEN-LAST:event_jButton1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel firm_address_lbl;
    private javax.swing.JTextField firm_address_txt;
    private javax.swing.JLabel firm_dds_lbl;
    private javax.swing.JTextField firm_dds_txt;
    private javax.swing.JLabel firm_eik_lbl;
    private javax.swing.JTextField firm_eik_txt;
    private javax.swing.JLabel firm_mol_lbl;
    private javax.swing.JTextField firm_mol_txt;
    private javax.swing.JLabel firm_name_lbl;
    private javax.swing.JTextField firm_name_txt;
    private javax.swing.JCheckBox is_firm_checkbox;
    private javax.swing.JLabel is_firm_lbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
