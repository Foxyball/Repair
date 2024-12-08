package repair;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class orderAddPanel extends javax.swing.JPanel {

    config q = new config();

    public orderAddPanel() {
        initComponents();

        txtOrderLaborCost.setText("0");
        txtOrderPartsCost.setText("0");

        comboOrderUser.removeAllItems();
        ArrayList<User> users = q.loadUserData("");

        for (User user : users) {
            comboOrderUser.addItem(user);
        }

        // Добавяне на ActionListener за отпечатване на ID при избран елемент
        comboOrderUser.addActionListener(e -> {
            User selectedUser = (User) comboOrderUser.getSelectedItem();
            if (selectedUser != null) {
                System.out.println("Selected User ID: " + selectedUser.getUserId());
            }
        });
        
        
        AutoCompleteDecorator.decorate(comboOrderUser);

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
        
        AutoCompleteDecorator.decorate(comboOrderMachine);

        comboOrderShelf.removeAllItems();
        ArrayList<Shelf> shelves = q.loadShelfData();
        for (Shelf shelf : shelves) {
            comboOrderShelf.addItem(shelf);
        }
//         Добавяне на ActionListener за отпечатване на ID при избран елемент
        comboOrderShelf.addActionListener(e -> {
            Shelf selectedShelf = (Shelf) comboOrderShelf.getSelectedItem();
            if (selectedShelf != null) {
                System.out.println("Selected Shelf ID: " + selectedShelf.getShelfId());
            }
        });
        
        AutoCompleteDecorator.decorate(comboOrderShelf);

    }

    private void clearFields() {
        txtOrderFaultDesc.setText("");
        txtOrderLaborCost.setText("0");

        if (comboOrderUser.getItemCount() > 0) {
            comboOrderUser.setSelectedIndex(0);
        }
        if (comboOrderMachine.getItemCount() > 0) {
            comboOrderMachine.setSelectedIndex(0);
        }
        if (comboOrderShelf.getItemCount() > 0) {
            comboOrderShelf.setSelectedIndex(0);
        }

        txtOrderPartsCost.setText("0");
        txtOrderConfirmedFault.setText("");

        if (comboOrderStatus.getItemCount() > 0) {
            comboOrderStatus.setSelectedIndex(0);
        }

        is_warranty_checkbox.setSelected(false);
    }

    public void refreshComboBoxes() {
        comboOrderMachine.removeAllItems();
        ArrayList<Machine> machines = q.loadMachineData();
        for (Machine machine : machines) {
            comboOrderMachine.addItem(machine);
        }

        comboOrderUser.removeAllItems();
        ArrayList<User> users = q.loadUserData("");
        for (User user : users) {
            comboOrderUser.addItem(user);
        }

        comboOrderShelf.removeAllItems();
        ArrayList<Shelf> shelves = q.loadShelfData();
        for (Shelf shelf : shelves) {
            comboOrderShelf.addItem(shelf);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 10, true));

        lblAddOrder.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAddOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddOrder.setText("ДОБАВЯНЕ НА ЗАЯВКА");
        lblAddOrder.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblAddOrder.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N
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
        txtOrderFaultDesc.setToolTipText("");
        txtOrderFaultDesc.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtOrderFaultDesc);

        comboOrderShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrderShelfActionPerformed(evt);
            }
        });

        txtOrderConfirmedFault.setColumns(20);
        txtOrderConfirmedFault.setRows(5);
        jScrollPane2.setViewportView(txtOrderConfirmedFault);

        comboOrderStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Незавършен", "Завършен", "Отказан" }));

        is_warranty_checkbox.setText("Гаранционна");

        txtOrderPartsCost.setLabelText("Цена на части");

        jLabel1.setText("Инфорамция (Клиент)");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N

        jLabel3.setText("Проблем (Служител)");
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N

        jLabel4.setText("Потребител");
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N

        jLabel5.setText("Рафт");
        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N

        jLabel6.setText("Марка");
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N

        jLabel7.setText("Статус");
        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtOrderLaborCost, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOrderPartsCost, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(136, 136, 136)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboOrderUser, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboOrderMachine, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboOrderShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(is_warranty_checkbox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefreshOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblAddOrder)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboOrderUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboOrderShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboOrderMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtOrderLaborCost, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrderPartsCost, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(is_warranty_checkbox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed

        String labor_cost = txtOrderLaborCost.getText();
        String parts_cost = txtOrderPartsCost.getText();
        String confirmed_fault = txtOrderConfirmedFault.getText();
        String fault_desc = txtOrderFaultDesc.getText();
        int warranty_denied = 0;
        double total_price = 0;

        User selectedUser = (User) comboOrderUser.getSelectedItem();
        Machine selectedMachine = (Machine) comboOrderMachine.getSelectedItem();
        Shelf selectedShelf = (Shelf) comboOrderShelf.getSelectedItem();
        String status = comboOrderStatus.getSelectedItem().toString();
        boolean is_warranty = is_warranty_checkbox.isSelected();

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = sdf.format(now);

        // валидация за непопълнени полета
        if (labor_cost.isEmpty() || parts_cost.isEmpty() || fault_desc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Моля попълнете всички полета.", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // валидация за проверка на капацитета на рафтовете
        if (selectedShelf.getShelfCurrentLoad() >= selectedShelf.getShelfMaxCapacity()) {
            JOptionPane.showMessageDialog(this, selectedShelf.getShelfName() + " е пълен!", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // валидация за дали машината е в гаранция
        if (is_warranty) {
            warranty_denied = 0;
            total_price = 0;
        } else {
            warranty_denied = 1;
            try {
                total_price = Double.parseDouble(labor_cost) + Double.parseDouble(parts_cost);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Моля, въведете валидни стойности за разходите.", "Грешка", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String[] columns = {
            "user_id", "product_id", "shelf_id", "fault_desc", "work_carried_out_desc", "created_at", "status", "is_warranty", "warranty_denied", "labor_cost", "parts_cost", "total_price"
        };

        Object[] values = {
            selectedUser.getUserId(), selectedMachine.getMachineId(), selectedShelf.getShelfId(), fault_desc, confirmed_fault, formattedDate, status, is_warranty, warranty_denied, labor_cost, parts_cost, total_price
        };

        boolean success = q.insert("repair_orders", columns, values);

        if (success) {
            // Обновява капацитета на рафтовете
            boolean shelfUpdated = q.updateShelfLoad(selectedShelf.getShelfId(), 1);

            if (shelfUpdated) {
                JOptionPane.showMessageDialog(this, "Успешно добавяне");
                refreshComboBoxes();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Успешно добавяне, но възникна грешка при актуализирането на рафта.", "Грешка", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Възникна грешка при добавянето на заявка.", "Грешка", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnAddOrderActionPerformed

    private void comboOrderUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboOrderUserItemStateChanged

    }//GEN-LAST:event_comboOrderUserItemStateChanged

    private void btnRefreshOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshOrderActionPerformed
        refreshComboBoxes();
    }//GEN-LAST:event_btnRefreshOrderActionPerformed

    private void comboOrderShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrderShelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboOrderShelfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnAddOrder;
    private repair.Button btnRefreshOrder;
    private repair.ComboBox comboOrderMachine;
    private repair.ComboBox comboOrderShelf;
    private repair.ComboBox comboOrderStatus;
    private repair.ComboBox comboOrderUser;
    private javax.swing.JCheckBox is_warranty_checkbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddOrder;
    private javax.swing.JTextArea txtOrderConfirmedFault;
    private javax.swing.JTextArea txtOrderFaultDesc;
    private repair.TextField txtOrderLaborCost;
    private repair.TextField txtOrderPartsCost;
    // End of variables declaration//GEN-END:variables
}
