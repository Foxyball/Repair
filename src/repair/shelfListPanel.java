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
public class shelfListPanel extends javax.swing.JPanel {

    config q = new config();
    DefaultTableModel model;
    private AdminForm adminForm;

    public shelfListPanel(AdminForm adminForm) {
        initComponents();
        this.adminForm = adminForm;

        lblSearchResults.setVisible(false); // Резултати от търсене етикет

        btnAddShelf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminForm.switchToShelfAddPanel();
            }
        });

        ArrayList<Shelf> shelves = q.loadShelfData();

        model = (DefaultTableModel) shelfTable.getModel();

        for (Shelf shelf : shelves) {
            model.addRow(shelf.toArray());
        }

        // да не може да се редактира в самата таблица
        shelfTable.setDefaultEditor(Object.class, null);
        shelfTable.setAutoCreateRowSorter(true); // позволява сортиране по колони

        shelfTable.setModel(model);

    }

    // Обновяване на данните в таблицата
    public void refreshTable() {
        model.setRowCount(0);
        ArrayList<Shelf> shelves = q.loadShelfData();
        for (Shelf shelf : shelves) {
            model.addRow(shelf.toArray());
        }
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
        lblAllShelf = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        shelfTable = new repair.Table();
        btnAddShelf = new repair.Button();
        btnEditShelf = new repair.Button();
        btnDeleteShelf = new repair.Button();
        btnRefreshShelf = new repair.Button();
        txtSearchShelf = new javax.swing.JTextField();
        btnSearchShelf = new repair.Button();
        lblSearchResults = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 10, true));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblAllShelf.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAllShelf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAllShelf.setText("ВСИЧКИ РАФТОВЕ");
        lblAllShelf.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblAllShelf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N
        lblAllShelf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        shelfTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Рафт", "Капацитет", "Заетост"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(shelfTable);

        btnAddShelf.setBackground(new java.awt.Color(0, 153, 255));
        btnAddShelf.setForeground(new java.awt.Color(255, 255, 255));
        btnAddShelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        btnAddShelf.setText("Добавяне");
        btnAddShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddShelfActionPerformed(evt);
            }
        });

        btnEditShelf.setBackground(new java.awt.Color(0, 153, 255));
        btnEditShelf.setForeground(new java.awt.Color(255, 255, 255));
        btnEditShelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/editing.png"))); // NOI18N
        btnEditShelf.setText("Редактиране");
        btnEditShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditShelfActionPerformed(evt);
            }
        });

        btnDeleteShelf.setBackground(new java.awt.Color(0, 153, 255));
        btnDeleteShelf.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteShelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/erase.png"))); // NOI18N
        btnDeleteShelf.setText("Изтриване");
        btnDeleteShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteShelfActionPerformed(evt);
            }
        });

        btnRefreshShelf.setBackground(new java.awt.Color(0, 153, 255));
        btnRefreshShelf.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshShelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/refresh.png"))); // NOI18N
        btnRefreshShelf.setText("Обнови");
        btnRefreshShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshShelfActionPerformed(evt);
            }
        });

        txtSearchShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchShelfActionPerformed(evt);
            }
        });

        btnSearchShelf.setBackground(new java.awt.Color(0, 153, 255));
        btnSearchShelf.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchShelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/search.png"))); // NOI18N
        btnSearchShelf.setText("Търсене");
        btnSearchShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchShelfActionPerformed(evt);
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
                        .addComponent(btnAddShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtSearchShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSearchResults)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAllShelf)
                .addGap(354, 354, 354))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAllShelf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnEditShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditShelfActionPerformed
        int selectedRow = shelfTable.getSelectedRow();
        if (selectedRow != -1) {

            // Кастване на ID-то към int от String
            String idString = shelfTable.getValueAt(selectedRow, 0).toString();
            int shelfId = Integer.parseInt(idString);

            // Извикване на универсалния метод select
            String[] columns = {"shelf_id", "shelf_name", "max_capacity", "current_load"};
            String whereClause = "shelf_id = ?";
            Object[] params = {shelfId};

            ArrayList<String> result = q.select(columns, "shelves", whereClause, params);

            if (!result.isEmpty()) {
                // Разделяне на първия (и единствен) ред на масив от стойности
                String[] shelfData = result.get(0).split("---");

                int shelf_id = Integer.parseInt(shelfData.length > 0 ? shelfData[0] : "0");
                String shelf_name = shelfData.length > 1 ? shelfData[1] : "";
                int shelf_max_capacity = Integer.parseInt(shelfData.length > 2 ? shelfData[2] : "0");
                int shelf_current_load = Integer.parseInt(shelfData.length > 3 ? shelfData[3] : "0");

                // Подаване на данните към панела за редактиране, за да се визуализират
                adminForm.switchToShelfEditPanel(shelf_id, shelf_name, shelf_max_capacity, shelf_current_load);
            } else {
                JOptionPane.showMessageDialog(this, "Не е намерен рафт с това ID!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Моля, изберете ред от таблицата!");
        }
    }//GEN-LAST:event_btnEditShelfActionPerformed

    private void btnDeleteShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteShelfActionPerformed
        int selectedRow = shelfTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Моля, изберете рафт за изтриване.");
            return;
        }

        // Кастване на ID-то към int от String
        String idString = shelfTable.getValueAt(selectedRow, 0).toString();
        int shelfId = Integer.parseInt(idString);

        int confirm = JOptionPane.showConfirmDialog(this, "Сигурни ли сте, че искате да изтриете този рафт?", "Потвърждение", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean isDeleted = q.delete("shelves", "shelf_id", shelfId);

            if (isDeleted) {
                refreshTable();
                JOptionPane.showMessageDialog(this, "Рафтът е изтрит успешно.");
            } else {
                JOptionPane.showMessageDialog(this, "Грешка при изтриване на рафт.");
            }
        }
    }//GEN-LAST:event_btnDeleteShelfActionPerformed

    private void btnRefreshShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshShelfActionPerformed
        refreshShelfList();
    }//GEN-LAST:event_btnRefreshShelfActionPerformed

    private void txtSearchShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchShelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchShelfActionPerformed

    // Търсачка
    private void btnSearchShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchShelfActionPerformed
        String keyword = txtSearchShelf.getText().trim();

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Моля, въведете ключова дума за търсене!", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] columns = {"shelf_id", "shelf_name"};
        String whereClause = "shelf_name LIKE ?";
        Object[] params = {"%" + keyword + "%"};

        ArrayList<String> searchResults = q.select(columns, "shelves", whereClause, params);

        String[] columnNames = {"id", "Рафт"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (String row : searchResults) {
            String[] shelfData = row.split("---");
            model.addRow(shelfData);
        }

        shelfTable.setModel(model);
        shelfTable.setDefaultEditor(Object.class, null);

        lblSearchResults.setVisible(true);
        int resultCount = searchResults.size();
        lblSearchResults.setText("Резултати: " + resultCount);
    }//GEN-LAST:event_btnSearchShelfActionPerformed

    private void btnAddShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddShelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddShelfActionPerformed

    // Обновяване на данните с бутон
    public void refreshShelfList() {

        model.setRowCount(0);

        String[] columns = {"shelf_id", "shelf_name", "max_capacity", "current_load"};
        String table = "shelves";
        String whereClause = "";
        Object[] params = null;

        ArrayList<String> shelfList = q.select(columns, table, whereClause, params);

        for (String shelf : shelfList) {
            String[] shelfDetails = shelf.split("---");

            model.addRow(shelfDetails);
        }

        shelfTable.setModel(model);

        // да не може да се редактира в самата таблица
        shelfTable.setDefaultEditor(Object.class, null);

        // Скриване на резултати: 4
        lblSearchResults.setVisible(false);
        txtSearchShelf.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnAddShelf;
    private repair.Button btnDeleteShelf;
    private repair.Button btnEditShelf;
    private repair.Button btnRefreshShelf;
    private repair.Button btnSearchShelf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAllShelf;
    private javax.swing.JLabel lblSearchResults;
    private repair.Table shelfTable;
    private javax.swing.JTextField txtSearchShelf;
    // End of variables declaration//GEN-END:variables
}
