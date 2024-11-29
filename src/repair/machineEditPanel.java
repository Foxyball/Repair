package repair;

import java.util.ArrayList;

public class machineEditPanel extends javax.swing.JPanel {

    private int product_id;
    config q = new config();

    public machineEditPanel(int product_id, String product_name, int category_id, String category_name, int brand_id, String brand_name, double price, int qty) {
        initComponents();

        this.product_id = product_id;
        
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

        txtMachineName.setText(product_name);
//        comboMachineCategory.setSelectedIndex(category_id);
        comboMachineBrand.setSelectedIndex(brand_id);
        txtMachinePrice.setText(String.valueOf(price));
        txtMachineQTY.setText(String.valueOf(qty));
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
