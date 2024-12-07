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
public class catListPanel extends javax.swing.JPanel {

    config q = new config();
    DefaultTableModel model;
    private AdminForm adminForm;

    public catListPanel(AdminForm adminForm) {
        initComponents();
        this.adminForm = adminForm;

        lblSearchResults.setVisible(false); // Резултати от търсене етикет

        btnAddCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminForm.switchToCategoryAddPanel();
            }
        });

        ArrayList<Category> categories = q.loadCategoryData();

        model = (DefaultTableModel) catTable.getModel();

        for (Category category : categories) {
            model.addRow(category.toArray());
        }

        // да не може да се редактира в самата таблица
        catTable.setDefaultEditor(Object.class, null);
        catTable.setAutoCreateRowSorter(true); // позволява сортиране по колони

        catTable.setModel(model);

    }

    // Обновяване на данните в таблицата
    public void refreshTable() {
        model.setRowCount(0);
        ArrayList<Category> categories = q.loadCategoryData();
        for (Category category : categories) {
            model.addRow(category.toArray());
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
        lblAllCategory = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        catTable = new repair.Table();
        btnAddCategory = new repair.Button();
        btnEditCategory = new repair.Button();
        btnDeleteCategory = new repair.Button();
        btnRefreshCategory = new repair.Button();
        txtSearchCategory = new javax.swing.JTextField();
        btnSearchCategory = new repair.Button();
        lblSearchResults = new javax.swing.JLabel();

        lblAllCategory.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAllCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAllCategory.setText("ВСИЧКИ КАТЕГОРИИ");
        lblAllCategory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        catTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Категория"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(catTable);

        btnAddCategory.setBackground(new java.awt.Color(0, 153, 255));
        btnAddCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        btnAddCategory.setText("Добавяне");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        btnEditCategory.setBackground(new java.awt.Color(0, 153, 255));
        btnEditCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnEditCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/editing.png"))); // NOI18N
        btnEditCategory.setText("Редактиране");
        btnEditCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCategoryActionPerformed(evt);
            }
        });

        btnDeleteCategory.setBackground(new java.awt.Color(0, 153, 255));
        btnDeleteCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/erase.png"))); // NOI18N
        btnDeleteCategory.setText("Изтриване");
        btnDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCategoryActionPerformed(evt);
            }
        });

        btnRefreshCategory.setBackground(new java.awt.Color(0, 153, 255));
        btnRefreshCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/refresh.png"))); // NOI18N
        btnRefreshCategory.setText("Обнови");
        btnRefreshCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCategoryActionPerformed(evt);
            }
        });

        txtSearchCategory.setBackground(new java.awt.Color(255, 255, 255));
        txtSearchCategory.setForeground(new java.awt.Color(0, 0, 0));
        txtSearchCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchCategoryActionPerformed(evt);
            }
        });

        btnSearchCategory.setBackground(new java.awt.Color(0, 153, 255));
        btnSearchCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/search.png"))); // NOI18N
        btnSearchCategory.setText("Търсене");
        btnSearchCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCategoryActionPerformed(evt);
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
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSearchResults)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAllCategory)
                .addGap(313, 313, 313))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAllCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnEditCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCategoryActionPerformed
        int selectedRow = catTable.getSelectedRow();
        if (selectedRow != -1) {

            // Кастване на ID-то към int от String
            String idString = catTable.getValueAt(selectedRow, 0).toString();
            int catId = Integer.parseInt(idString);

            // Извикване на универсалния метод select
            String[] columns = {"cat_id", "category_name"};
            String whereClause = "cat_id = ?";
            Object[] params = {catId};

            ArrayList<String> result = q.select(columns, "categories", whereClause, params);

            if (!result.isEmpty()) {
                // Разделяне на първия (и единствен) ред на масив от стойности
                String[] catData = result.get(0).split("---");

                int cat_id = Integer.parseInt(catData.length > 0 ? catData[0] : "0");
                String category_name = catData.length > 1 ? catData[1] : "";

                // Подаване на данните към панела за редактиране, за да се визуализират
                adminForm.switchToCategoryEditPanel(cat_id, category_name);
            } else {
                JOptionPane.showMessageDialog(this, "Не е намерена категория с това ID!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Моля, изберете ред от таблицата!");
        }
    }//GEN-LAST:event_btnEditCategoryActionPerformed

    private void btnDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCategoryActionPerformed
        int selectedRow = catTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Моля, изберете категория за изтриване.");
            return;
        }

        // Кастване на ID-то към int от String
        String idString = catTable.getValueAt(selectedRow, 0).toString();
        int catId = Integer.parseInt(idString);

        int confirm = JOptionPane.showConfirmDialog(this, "Сигурни ли сте, че искате да изтриете тази категория?", "Потвърждение", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean isDeleted = q.delete("categories", "cat_id", catId);

            if (isDeleted) {
                refreshTable();
                JOptionPane.showMessageDialog(this, "Категорията е изтрита успешно.");
            } else {
                JOptionPane.showMessageDialog(this, "Грешка при изтриване на категория.");
            }
        }
    }//GEN-LAST:event_btnDeleteCategoryActionPerformed

    private void btnRefreshCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCategoryActionPerformed
        refreshCatList();
    }//GEN-LAST:event_btnRefreshCategoryActionPerformed

    private void txtSearchCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchCategoryActionPerformed

    // Търсачка
    private void btnSearchCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCategoryActionPerformed
        String keyword = txtSearchCategory.getText().trim();

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Моля, въведете ключова дума за търсене!", "Грешка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] columns = {"cat_id", "category_name"};
        String whereClause = "category_name LIKE ?";
        Object[] params = {"%" + keyword + "%"};

        ArrayList<String> searchResults = q.select(columns, "categories", whereClause, params);

        String[] columnNames = {"id", "Категория"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (String row : searchResults) {
            String[] catData = row.split("---");
            model.addRow(catData);
        }

        catTable.setModel(model);
        catTable.setDefaultEditor(Object.class, null);

        lblSearchResults.setVisible(true);
        int resultCount = searchResults.size();
        lblSearchResults.setText("Резултати: " + resultCount);
    }//GEN-LAST:event_btnSearchCategoryActionPerformed

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    // Обновяване на данните с бутон
    public void refreshCatList() {

        model.setRowCount(0);

        String[] columns = {"cat_id", "category_name"};
        String table = "categories";
        String whereClause = "";
        Object[] params = null;

        ArrayList<String> catList = q.select(columns, table, whereClause, params);

        for (String category : catList) {
            String[] catDetails = category.split("---");

            model.addRow(catDetails);
        }

        catTable.setModel(model);

        // да не може да се редактира в самата таблица
        catTable.setDefaultEditor(Object.class, null);

        // Скриване на резултати: 4
        lblSearchResults.setVisible(false);
        txtSearchCategory.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnAddCategory;
    private repair.Button btnDeleteCategory;
    private repair.Button btnEditCategory;
    private repair.Button btnRefreshCategory;
    private repair.Button btnSearchCategory;
    private repair.Table catTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAllCategory;
    private javax.swing.JLabel lblSearchResults;
    private javax.swing.JTextField txtSearchCategory;
    // End of variables declaration//GEN-END:variables
}
