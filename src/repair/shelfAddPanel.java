package repair;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thefo
 */
public class shelfAddPanel extends javax.swing.JPanel {

    config q = new config();

    public shelfAddPanel() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAddShelf = new javax.swing.JLabel();
        txtShelfName = new repair.TextField();
        btnAddShelf = new repair.Button();
        txtShelfMaxCapacity = new repair.TextField();
        txtShelfCurrentLoad = new repair.TextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 10, true));

        lblAddShelf.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAddShelf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddShelf.setText("ДОБАВЯНЕ НА РАФТ");
        lblAddShelf.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblAddShelf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtShelfName.setLabelText("Име на рафт");

        btnAddShelf.setBackground(new java.awt.Color(0, 153, 255));
        btnAddShelf.setForeground(new java.awt.Color(255, 255, 255));
        btnAddShelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        btnAddShelf.setText("Добави");
        btnAddShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddShelfActionPerformed(evt);
            }
        });

        txtShelfMaxCapacity.setLabelText("Капацитет на рафт");

        txtShelfCurrentLoad.setText("0");
        txtShelfCurrentLoad.setLabelText("Заетост на рафт");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(lblAddShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(366, 366, 366))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtShelfMaxCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtShelfName, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtShelfCurrentLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(btnAddShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblAddShelf)
                .addGap(180, 180, 180)
                .addComponent(txtShelfName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtShelfMaxCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtShelfCurrentLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnAddShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearFields() {
        txtShelfName.setText("");
        txtShelfMaxCapacity.setText("");
        txtShelfCurrentLoad.setText("0");
    }

    private void btnAddShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddShelfActionPerformed
        String shelf_name = txtShelfName.getText();
        String shelf_max_capacity = txtShelfMaxCapacity.getText();
        String shelf_current_load = txtShelfCurrentLoad.getText();

        try {
            Integer.parseInt(shelf_max_capacity);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Моля, въведете валиден капацитет на рафт.", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Integer.parseInt(shelf_current_load);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Моля, въведете валидна заетост на рафт.", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (shelf_name.isEmpty() || shelf_max_capacity.isEmpty() || shelf_current_load.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Моля, попълнете всички полета", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] columns = {
            "shelf_name","max_capacity","current_load"
        };

        Object[] values = {
            shelf_name,shelf_max_capacity,shelf_current_load
        };

        boolean success = q.insert("shelves", columns, values);

        if (success) {
            JOptionPane.showMessageDialog(this, "Успешно добавяне!");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Възникна грешка при добавянето на рафт.", "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddShelfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnAddShelf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddShelf;
    private repair.TextField txtShelfCurrentLoad;
    private repair.TextField txtShelfMaxCapacity;
    private repair.TextField txtShelfName;
    // End of variables declaration//GEN-END:variables
}
