
package repair;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thefo
 */
public class machineAddPanel extends javax.swing.JPanel {

    config q = new config();

    public machineAddPanel() {
        initComponents();
        
       
        comboMachineCategory.removeAllItems();
        ArrayList<Category> categories = q.loadCategoryData();
        for (Category category : categories) {
            comboMachineCategory.addItem(category);
        }
//         Добавяне на ActionListener за отпечатване на ID при избран елемент
        comboMachineCategory.addActionListener(e -> {
            Category selectedCategory = (Category) comboMachineCategory.getSelectedItem();
            if (selectedCategory != null) {
                System.out.println("Selected Category ID: " + selectedCategory.getCatId());
            }
        });
        
        
        comboMachineBrand.removeAllItems();
        ArrayList<Brand> brands = q.loadBrandData();
        for (Brand brand : brands) {
            comboMachineBrand.addItem(brand);
        }

        // Добавяне на ActionListener за отпечатване на ID при избран елемент
        comboMachineBrand.addActionListener(e -> {
            Brand selectedBrand = (Brand) comboMachineBrand.getSelectedItem();
            if (selectedBrand != null) {
                System.out.println("Selected Brand ID: " + selectedBrand.getBrandId());
            }
        });
        
    }

    private void clearFields() {
        txtMachineName.setText("");
        txtMachinePrice.setText("0");
        txtMachineQTY.setText("0");
        comboMachineBrand.setSelectedIndex(0);
        comboMachineCategory.setSelectedIndex(0);
    }

    public void refreshComboBoxes() {
        comboMachineCategory.removeAllItems();
        ArrayList<Category> categories = q.loadCategoryData();
        for (Category category : categories) {
            comboMachineCategory.addItem(category);
        }

        comboMachineBrand.removeAllItems();
        ArrayList<Brand> brands = q.loadBrandData();
        for (Brand brand : brands) {
            comboMachineBrand.addItem(brand);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAddMachine = new javax.swing.JLabel();
        txtMachineName = new repair.TextField();
        txtMachinePrice = new repair.TextField();
        txtMachineQTY = new repair.TextField();
        comboMachineBrand = new repair.ComboBox();
        comboMachineCategory = new repair.ComboBox();
        btnAddMachine = new repair.Button();
        btnRefreshMachine = new repair.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 10, true));

        lblAddMachine.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAddMachine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddMachine.setText("ДОБАВЯНЕ НА МАШИНА");
        lblAddMachine.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblAddMachine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtMachineName.setLabelText("Име на машина");

        txtMachinePrice.setLabelText("Цена на машина");

        txtMachineQTY.setLabelText("Количество");

        comboMachineBrand.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMachineBrandItemStateChanged(evt);
            }
        });

        btnAddMachine.setBackground(new java.awt.Color(0, 151, 236));
        btnAddMachine.setForeground(new java.awt.Color(255, 255, 255));
        btnAddMachine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        btnAddMachine.setText("Добави");
        btnAddMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMachineActionPerformed(evt);
            }
        });

        btnRefreshMachine.setBackground(new java.awt.Color(0, 151, 236));
        btnRefreshMachine.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshMachine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/refresh.png"))); // NOI18N
        btnRefreshMachine.setText("Обнови");
        btnRefreshMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshMachineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(lblAddMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMachineQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtMachinePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboMachineCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtMachineName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(114, 114, 114)
                                    .addComponent(comboMachineBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(btnRefreshMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblAddMachine)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMachineName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboMachineBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMachinePrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboMachineCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtMachineQTY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMachineActionPerformed
        String machine_name = txtMachineName.getText();
        String machine_price = txtMachinePrice.getText();
        String machine_qty = txtMachineQTY.getText();
        Brand selectedBrand = (Brand) comboMachineBrand.getSelectedItem();
        Category selectedCategory = (Category) comboMachineCategory.getSelectedItem();

        if (machine_name.isEmpty() || machine_price.isEmpty() || machine_qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Моля, попълнете всички полета", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Double.parseDouble(machine_price);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Моля, въведете валидна цена.", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Integer.parseInt(machine_qty);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Моля, въведете валидно количество.", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] columns = {
            "product_name", "category_id", "brand_id", "price", "qty"
        };

        Object[] values = {
            machine_name, selectedCategory.getCatId(), selectedBrand.getBrandId(), machine_price, machine_qty
        };

        boolean success = q.insert("products", columns, values);

        if (success) {
            JOptionPane.showMessageDialog(this, "Успешно добавяне!");
            refreshComboBoxes();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Възникна грешка при добавянето на машина.", "Грешка", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAddMachineActionPerformed

    private void comboMachineBrandItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMachineBrandItemStateChanged
      
    }//GEN-LAST:event_comboMachineBrandItemStateChanged

    private void btnRefreshMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshMachineActionPerformed
        refreshComboBoxes();
    }//GEN-LAST:event_btnRefreshMachineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnAddMachine;
    private repair.Button btnRefreshMachine;
    private repair.ComboBox comboMachineBrand;
    private repair.ComboBox comboMachineCategory;
    private javax.swing.JLabel lblAddMachine;
    private repair.TextField txtMachineName;
    private repair.TextField txtMachinePrice;
    private repair.TextField txtMachineQTY;
    // End of variables declaration//GEN-END:variables
}
