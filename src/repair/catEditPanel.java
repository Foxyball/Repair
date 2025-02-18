/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package repair;

import javax.swing.JOptionPane;

/**
 *
 * @author Strix
 */
public class catEditPanel extends javax.swing.JPanel {

    private int cat_id;
    config q = new config();

    public catEditPanel(int cat_id, String category_name) {
        initComponents();

        this.cat_id = cat_id;

        txtCategoryName.setText(category_name);
        lblEditCategory.setText("РЕДАКТИРАНЕ НА КАТЕГОРИЯ - " + category_name);
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
        lblEditCategory = new javax.swing.JLabel();
        btnSaveCategory = new repair.Button();
        txtCategoryName = new repair.TextField();

        setBackground(new java.awt.Color(235, 247, 248));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 10, true));

        lblEditCategory.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblEditCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditCategory.setText("РЕДАКТИРАНЕ НА КАТЕГОРИЯ");
        lblEditCategory.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N
        lblEditCategory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnSaveCategory.setBackground(new java.awt.Color(0, 153, 255));
        btnSaveCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        btnSaveCategory.setText("Запази");
        btnSaveCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCategoryActionPerformed(evt);
            }
        });

        txtCategoryName.setLabelText("Име на категория");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(lblEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblEditCategory)
                .addGap(148, 148, 148)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(211, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 938, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCategoryActionPerformed
        String category_name = txtCategoryName.getText();

        if (category_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Моля, попълнете всички полета", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] columns = {"category_name"};
        Object[] values = {category_name};

        boolean success = q.update("categories", columns, values, "cat_id", cat_id);

        if (success) {
            JOptionPane.showMessageDialog(this, "Промените са запазени успешно.");
        } else {
            JOptionPane.showMessageDialog(this, "Грешка при запазване на промените.");
        }
    }//GEN-LAST:event_btnSaveCategoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnSaveCategory;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEditCategory;
    private repair.TextField txtCategoryName;
    // End of variables declaration//GEN-END:variables
}
