package repair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thefo
 */
public class invoiceListPanel extends javax.swing.JPanel {

    config q = new config();
    DefaultTableModel model;
    private AdminForm adminForm;

    public invoiceListPanel(AdminForm adminForm) {
        initComponents();
        this.adminForm = adminForm;

        lblSearchResults.setVisible(false); // Резултати от търсене етикет

        ArrayList<Invoice> invoices = q.loadAllInvoices();

        model = (DefaultTableModel) invoiceTable.getModel();

        for (Invoice invoice : invoices) {
            model.addRow(invoice.toArray());
        }

        // да не може да се редактира в самата таблица
        invoiceTable.setDefaultEditor(Object.class, null);
        invoiceTable.setAutoCreateRowSorter(true); // позволява сортиране по колони

        invoiceTable.setModel(model);

    }

    // Обновяване на данните в таблицата
    public void refreshTable() {
        model.setRowCount(0);
        ArrayList<Invoice> invoices = q.loadAllInvoices();
        for (Invoice invoice : invoices) {
            model.addRow(invoice.toArray());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAllInvoice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new repair.Table();
        btnDeleteInvoice = new repair.Button();
        btnRefreshInvoice = new repair.Button();
        txtSearchInvoice = new javax.swing.JTextField();
        btnSearchInvoice = new repair.Button();
        lblSearchResults = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 10, true));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblAllInvoice.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAllInvoice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAllInvoice.setText("ВСИЧКИ ФАКТУРИ");
        lblAllInvoice.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblAllInvoice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Клиент", "Машина", "Статус", "Стойност"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(invoiceTable);

        btnDeleteInvoice.setBackground(new java.awt.Color(0, 153, 255));
        btnDeleteInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/erase.png"))); // NOI18N
        btnDeleteInvoice.setText("Изтриване");
        btnDeleteInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteInvoiceActionPerformed(evt);
            }
        });

        btnRefreshInvoice.setBackground(new java.awt.Color(0, 153, 255));
        btnRefreshInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/refresh.png"))); // NOI18N
        btnRefreshInvoice.setText("Обнови");
        btnRefreshInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshInvoiceActionPerformed(evt);
            }
        });

        txtSearchInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchInvoiceActionPerformed(evt);
            }
        });

        btnSearchInvoice.setBackground(new java.awt.Color(0, 153, 255));
        btnSearchInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/search.png"))); // NOI18N
        btnSearchInvoice.setText("Търсене");
        btnSearchInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchInvoiceActionPerformed(evt);
            }
        });

        lblSearchResults.setText("Резултати: 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDeleteInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefreshInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(239, 239, 239)
                        .addComponent(txtSearchInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSearchResults)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAllInvoice)
                .addGap(354, 354, 354))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAllInvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchResults))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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

    private void btnDeleteInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteInvoiceActionPerformed
        int selectedRow = invoiceTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Моля, изберете фактура за изтриване.");
            return;
        }

        // Кастване на ID-то към int от String
        String idString = invoiceTable.getValueAt(selectedRow, 0).toString();
        int invoiceId = Integer.parseInt(idString);

        int confirm = JOptionPane.showConfirmDialog(this, "Сигурни ли сте, че искате да изтриете тази фактура?", "Потвърждение", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean isDeleted = q.delete("invoices", "invoice_id", invoiceId);

            if (isDeleted) {
                refreshTable();
                JOptionPane.showMessageDialog(this, "Фактурата е изтрита успешно.");
            } else {
                JOptionPane.showMessageDialog(this, "Грешка при изтриване на фактура.");
            }
        }
    }//GEN-LAST:event_btnDeleteInvoiceActionPerformed

    private void btnRefreshInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshInvoiceActionPerformed
        refreshInvoiceList();
    }//GEN-LAST:event_btnRefreshInvoiceActionPerformed

    private void txtSearchInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchInvoiceActionPerformed

    // Търсачка
    private void btnSearchInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchInvoiceActionPerformed
        String keyword = txtSearchInvoice.getText().trim();

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Моля, въведете ключова дума за търсене!", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] columns = {"invoice_id", "name", "product_name",  "payment_status","total"};
        String whereClause = "name LIKE ? OR product_name LIKE ?";
        Object[] params = {"%" + keyword + "%", "%" + keyword + "%"};

        ArrayList<String> searchResults = q.select(columns, "invoices i "
                + "JOIN users u ON i.user_id = u.id "
                + "JOIN repair_orders ro ON i.repair_id = ro.repair_id "
                + "JOIN products p ON ro.product_id = p.product_id",
                whereClause, params);

        String[] columnNames = {"ID", "Клиент", "Машина", "Сума", "Статус"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (String row : searchResults) {
            String[] invoiceData = row.split("---");
            model.addRow(invoiceData);
        }

        invoiceTable.setModel(model);
        invoiceTable.setDefaultEditor(Object.class, null);

        lblSearchResults.setVisible(true);
        int resultCount = searchResults.size();
        lblSearchResults.setText("Резултати: " + resultCount);
    }//GEN-LAST:event_btnSearchInvoiceActionPerformed

    // Обновяване на данните с бутон
    public void refreshInvoiceList() {
        model.setRowCount(0);

        String[] columns = {"invoice_id", "name", "product_name", "payment_status", "total"};
        String table = "invoices i "
                + "JOIN users u ON i.user_id = u.id "
                + "JOIN repair_orders ro ON i.repair_id = ro.repair_id "
                + "JOIN products p ON ro.product_id = p.product_id";
        String whereClause = "";
        Object[] params = null;

        ArrayList<String> invoiceList = q.select(columns, table, whereClause, params);

        for (String invoice : invoiceList) {
            String[] invoiceDetails = invoice.split("---");
            model.addRow(invoiceDetails);
        }

        invoiceTable.setModel(model);

        invoiceTable.setDefaultEditor(Object.class, null);

        lblSearchResults.setVisible(false);
        txtSearchInvoice.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnDeleteInvoice;
    private repair.Button btnRefreshInvoice;
    private repair.Button btnSearchInvoice;
    private repair.Table invoiceTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAllInvoice;
    private javax.swing.JLabel lblSearchResults;
    private javax.swing.JTextField txtSearchInvoice;
    // End of variables declaration//GEN-END:variables
}
