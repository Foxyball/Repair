package repair;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author thefo
 */
public class orderAddPanel extends javax.swing.JPanel {

    config q = new config();

    public orderAddPanel() {
        initComponents();

        comboOrderUser.removeAllItems();
        ArrayList<User> users = q.loadUserData("");
        User loggedInUser = LoggedInUser.getUser();
        comboOrderUser.addItem("-- Изберете клиент --");

        for (User user : users) {
            comboOrderUser.addItem(user);
        }

        // настройва визуално текущия логнат да е в сив цвят
        comboOrderUser.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (value instanceof User user) {
                    if (user.getUserId() == loggedInUser.getUserId()) {
                        c.setEnabled(false);
                        c.setForeground(Color.GRAY);
                    } else {
                        c.setEnabled(true);
                        c.setForeground(Color.BLACK);
                    }
                }
                return c;
            }
        });

            // Забранява избирането на текущия логнат потребител да избира себе си в заявката
        comboOrderUser.addActionListener(e -> {
            Object selected = comboOrderUser.getSelectedItem();
            if (selected instanceof User user && user.getUserId() == loggedInUser.getUserId()) {
                comboOrderUser.setSelectedIndex(0);
                JOptionPane.showMessageDialog(comboOrderUser, "Не може да изберете себе си.");
            }
        });

        // Добавяне на ActionListener за отпечатване на ID при избран елемент
        comboOrderUser.addActionListener(e -> {
            User selectedUser = (User) comboOrderUser.getSelectedItem();
            if (selectedUser != null) {
                System.out.println("Selected User ID: " + selectedUser.getUserId());
            }
        });

        comboOrderMachine.removeAllItems();
        ArrayList<Machine> machines = q.loadMachineData();
        for (Machine machine : machines) {
            comboOrderMachine.addItem(machine);
        }
//         Добавяне на ActionListener за отпечатване на ID при избран елемент
        comboOrderMachine.addActionListener(e -> {
            Machine selectedMachine = (Machine) comboOrderMachine.getSelectedItem();
            if (selectedMachine != null) {
                System.out.println("Selected Machine ID: " + selectedMachine.getMachineId());
            }
        });

    }

    private void clearFields() {
        txtOrderFaultDesc.setText("0");
        txtOrderLaborCost.setText("0");
        comboOrderUser.setSelectedIndex(0);
        comboOrderMachine.setSelectedIndex(0);
    }

    public void refreshComboBoxes() {
        comboOrderMachine.removeAllItems();
        ArrayList<Category> categories = q.loadCategoryData();
        for (Category category : categories) {
            comboOrderMachine.addItem(category);
        }

        comboOrderUser.removeAllItems();
        ArrayList<Brand> brands = q.loadBrandData();
        for (Brand brand : brands) {
            comboOrderUser.addItem(brand);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAddOrder = new javax.swing.JLabel();
        txtOrderLaborCost = new repair.TextField();
        comboOrderUser = new repair.ComboBox();
        comboOrderMachine = new repair.ComboBox();
        btnAddOrder = new repair.Button();
        btnRefreshOrder = new repair.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOrderFaultDesc = new javax.swing.JTextArea();
        comboOrderShelf = new repair.ComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOrderConfirmedFault = new javax.swing.JTextArea();
        comboOrderStatus = new repair.ComboBox();
        is_warranty_checkbox = new javax.swing.JCheckBox();
        txtOrderPartsCost = new repair.TextField();

        lblAddOrder.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAddOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddOrder.setText("ДОБАВЯНЕ НА ЗАЯВКА");
        lblAddOrder.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblAddOrder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtOrderLaborCost.setLabelText("Труд");

        comboOrderUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboOrderUserItemStateChanged(evt);
            }
        });

        btnAddOrder.setBackground(new java.awt.Color(0, 153, 255));
        btnAddOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnAddOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        btnAddOrder.setText("Добави");
        btnAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderActionPerformed(evt);
            }
        });

        btnRefreshOrder.setBackground(new java.awt.Color(0, 153, 255));
        btnRefreshOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/refresh.png"))); // NOI18N
        btnRefreshOrder.setText("Обнови");
        btnRefreshOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshOrderActionPerformed(evt);
            }
        });

        txtOrderFaultDesc.setColumns(20);
        txtOrderFaultDesc.setRows(5);
        jScrollPane1.setViewportView(txtOrderFaultDesc);

        txtOrderConfirmedFault.setColumns(20);
        txtOrderConfirmedFault.setRows(5);
        jScrollPane2.setViewportView(txtOrderConfirmedFault);

        comboOrderStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Незавършен", "Завършен" }));

        is_warranty_checkbox.setText("Гаранционна");

        txtOrderPartsCost.setLabelText("Цена на части");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comboOrderUser, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtOrderLaborCost, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(114, 114, 114)
                                    .addComponent(comboOrderMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtOrderPartsCost, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(is_warranty_checkbox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboOrderShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(btnRefreshOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(597, Short.MAX_VALUE)
                .addComponent(lblAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(is_warranty_checkbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblAddOrder)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboOrderUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboOrderShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboOrderMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtOrderLaborCost, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(txtOrderPartsCost, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed

        String machine_price = txtOrderFaultDesc.getText();
        String machine_qty = txtOrderLaborCost.getText();
        Brand selectedBrand = (Brand) comboOrderUser.getSelectedItem();
        Category selectedCategory = (Category) comboOrderMachine.getSelectedItem();

        if (machine_price.isEmpty() || machine_qty.isEmpty()) {
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
            "category_id", "brand_id", "price", "qty"
        };

        Object[] values = {
            selectedCategory.getCatId(), selectedBrand.getBrandId(), machine_price, machine_qty
        };

        boolean success = q.insert("products", columns, values);

        if (success) {
            JOptionPane.showMessageDialog(this, "Успешно добавяне!");
            refreshComboBoxes();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Възникна грешка при добавянето на машина.", "Грешка", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAddOrderActionPerformed

    private void comboOrderUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboOrderUserItemStateChanged

    }//GEN-LAST:event_comboOrderUserItemStateChanged

    private void btnRefreshOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshOrderActionPerformed
        refreshComboBoxes();
    }//GEN-LAST:event_btnRefreshOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnAddOrder;
    private repair.Button btnRefreshOrder;
    private repair.ComboBox comboOrderMachine;
    private repair.ComboBox comboOrderShelf;
    private repair.ComboBox comboOrderStatus;
    private repair.ComboBox comboOrderUser;
    private javax.swing.JCheckBox is_warranty_checkbox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddOrder;
    private javax.swing.JTextArea txtOrderConfirmedFault;
    private javax.swing.JTextArea txtOrderFaultDesc;
    private repair.TextField txtOrderLaborCost;
    private repair.TextField txtOrderPartsCost;
    // End of variables declaration//GEN-END:variables
}
