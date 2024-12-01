package repair;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class machineEditPanel extends javax.swing.JPanel {

    private int product_id;
    config q = new config();

    public machineEditPanel(int product_id, String product_name, int category_id, String category_name, int brand_id, String brand_name, double price, int qty) {
        initComponents();

        this.product_id = product_id;

        // Set text fields
        txtMachineName.setText(product_name);
        txtMachinePrice.setText(String.valueOf(price));
        txtMachineQTY.setText(String.valueOf(qty));

        ArrayList<Category> categories = q.loadCategoryData();
        DefaultComboBoxModel<Category> catModel = new DefaultComboBoxModel<>();
        for (Category category : categories) {
            catModel.addElement(category);
        }
        comboMachineCategory.setModel(catModel);

        for (int i = 0; i < catModel.getSize(); i++) {
            Category category = catModel.getElementAt(i);
            if (category.getCatId() == category_id) {
                comboMachineCategory.setSelectedItem(category);
                break;
            }
        }

        ArrayList<Brand> brands = q.loadBrandData();
        DefaultComboBoxModel<Brand> brandModel = new DefaultComboBoxModel<>();
        for (Brand brand : brands) {
            brandModel.addElement(brand);
        }
        comboMachineBrand.setModel(brandModel);

        for (int i = 0; i < brandModel.getSize(); i++) {
            Brand brand = brandModel.getElementAt(i);
            if (brand.getBrandId() == brand_id) {
                comboMachineBrand.setSelectedItem(brand);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEditMachine = new javax.swing.JLabel();
        txtMachineName = new repair.TextField();
        comboMachineBrand = new repair.ComboBox();
        txtMachinePrice = new repair.TextField();
        comboMachineCategory = new repair.ComboBox();
        txtMachineQTY = new repair.TextField();
        btnEditMachine = new repair.Button();

        lblEditMachine.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblEditMachine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditMachine.setText("РЕДАКТИРАНЕ НА МАШИНА");
        lblEditMachine.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblEditMachine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtMachineName.setLabelText("Име на машина");

        txtMachinePrice.setLabelText("Цена на машина");

        txtMachineQTY.setLabelText("Количество");

        btnEditMachine.setBackground(new java.awt.Color(0, 153, 255));
        btnEditMachine.setForeground(new java.awt.Color(255, 255, 255));
        btnEditMachine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        btnEditMachine.setText("Запази");
        btnEditMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditMachineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(295, 295, 295)
                        .addComponent(btnEditMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(383, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblEditMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblEditMachine)
                .addGap(34, 34, 34)
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
                .addComponent(btnEditMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditMachineActionPerformed

        String machine_name = txtMachineName.getText();
        String machine_price = txtMachinePrice.getText();
        String machine_qty = txtMachineQTY.getText();
        Brand selectedBrand = (Brand) comboMachineBrand.getSelectedItem();
        Category selectedCategory = (Category) comboMachineCategory.getSelectedItem();

        double price;
        int quantity;

        if (machine_name.isEmpty() || machine_price.isEmpty() || machine_qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Моля, попълнете всички полета", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            price = Double.parseDouble(machine_price);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Моля, въведете валидна цена.", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            quantity = Integer.parseInt(machine_qty);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Моля, въведете валидно количество.", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (selectedBrand == null || selectedCategory == null) {
            JOptionPane.showMessageDialog(this, "Моля, изберете валидна категория и марка.", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int brand_id = selectedBrand.getBrandId();
        int category_id = selectedCategory.getCatId();

        String[] columns = {"product_name", "category_id", "brand_id", "price", "qty"};
        Object[] values = {machine_name, category_id, brand_id, price, quantity};

        boolean success = q.update("products", columns, values, "product_id", product_id);

        if (success) {
            JOptionPane.showMessageDialog(this, "Промените са запазени успешно.");
        } else {
            JOptionPane.showMessageDialog(this, "Грешка при запазване на промените.");
        }
    }//GEN-LAST:event_btnEditMachineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnEditMachine;
    private repair.ComboBox comboMachineBrand;
    private repair.ComboBox comboMachineCategory;
    private javax.swing.JLabel lblEditMachine;
    private repair.TextField txtMachineName;
    private repair.TextField txtMachinePrice;
    private repair.TextField txtMachineQTY;
    // End of variables declaration//GEN-END:variables
}
