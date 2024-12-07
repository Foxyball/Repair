
package repair;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thefo
 */
public class brandAddPanel extends javax.swing.JPanel {

    config q = new config();

    public brandAddPanel() {
        initComponents();
      
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
        lblAddBrand = new javax.swing.JLabel();
        txtBrandName = new repair.TextField();
        btnAddBrand = new repair.Button();

        setBackground(new java.awt.Color(0, 153, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 153, 255))); // NOI18N

        lblAddBrand.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAddBrand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddBrand.setText("ДОБАВЯНЕ НА МАРКА");
        lblAddBrand.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblAddBrand.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N
        lblAddBrand.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtBrandName.setLabelText("Име на марка");

        btnAddBrand.setBackground(new java.awt.Color(0, 153, 255));
        btnAddBrand.setForeground(new java.awt.Color(255, 255, 255));
        btnAddBrand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        btnAddBrand.setText("Добави");
        btnAddBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBrandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(lblAddBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(txtBrandName, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnAddBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblAddBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBrandName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(289, 289, 289))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearFields() {
        txtBrandName.setText("");
    }

    private void btnAddBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBrandActionPerformed
        String brand_name = txtBrandName.getText();

        if (brand_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Моля, попълнете всички полета", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] columns = {
            "brand_name"
        };

        Object[] values = {
            brand_name
        };

        boolean success = q.insert("brands", columns, values);

        if (success) {
            JOptionPane.showMessageDialog(this, "Успешно добавяне!");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Възникна грешка при добавянето на марка.", "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddBrandActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnAddBrand;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddBrand;
    private repair.TextField txtBrandName;
    // End of variables declaration//GEN-END:variables
}
