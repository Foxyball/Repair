package repair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminForm extends javax.swing.JFrame {

    JPanel contentPanel;
    dashboardPanel dashboardPanel;

    userAddPanel userAddPanel;
    userListPanel userListPanel;

    brandListPanel brandListPanel;
    brandAddPanel brandAddPanel;

    shelfAddPanel shelfAddPanel;
    shelfListPanel shelfListPanel;

    machineAddPanel machineAddPanel;
    machineListPanel machineListPanel;

    LoggedInUser LoggedInUser;

    public AdminForm(String role) {
        initComponents();
        this.setLocationRelativeTo(null); // Centrirane
        this.setSize(1250, 800);

        User loggedInUser = LoggedInUser.getUser();
        String email = LoggedInUser.getUser().getEmail();
        lbl_user.setText(LoggedInUser.getUser().getName());

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));

        //Ще показваме и скриваме елементи според ролята
        if (role.equals("admin")) {
//      
        } else if (role.equals("user")) {
            // Show user
        } else {

        }

        contentPanel = new JPanel(new CardLayout());
        sideLayoutPanel.setLayout(new BoxLayout(sideLayoutPanel, BoxLayout.Y_AXIS));

        // Зарежда динамичните панели при стартиране
        LoadDynamicPanels();
    }

    // Динамично зареждане на панелите [не трием]
    void LoadDynamicPanels() {

        dashboardPanel = new dashboardPanel();
        contentPanel.add(dashboardPanel, "dashboard");
        btnDashboard.addActionListener(switchPanelListener);
        btnDashboard.setActionCommand("dashboard");
        sideLayoutPanel.add(Box.createVerticalStrut(10)); // Add more spacing
        sideLayoutPanel.add(btnDashboard);                    // Add button2
        sideLayoutPanel.add(Box.createVerticalStrut(20)); // Add vertical spacing

        lblUsers.setAlignmentX(Component.LEFT_ALIGNMENT); // Center the label horizontally
        lblUsers.setFont(new Font("Arial", Font.BOLD, 16));  // Optional: Set font for better visibility

        sideLayoutPanel.add(lblUsers);

        // Добавяне на потребител
        userAddPanel = new userAddPanel();
        contentPanel.add(userAddPanel, "addUser");
        btnAddUser.addActionListener(switchPanelListener);
        btnAddUser.setActionCommand("addUser");
        sideLayoutPanel.add(Box.createVerticalStrut(10)); // Add vertical spacing
        sideLayoutPanel.add(btnAddUser);                    // Add button1

        // Всички потребители
        userListPanel = new userListPanel(this);
        contentPanel.add(userListPanel, "listUser");
        btnAllUser.addActionListener(switchPanelListener);
        btnAllUser.setActionCommand("listUser");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAllUser);

        lblBrands.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblBrands.setFont(new Font("Arial", Font.BOLD, 16));

        sideLayoutPanel.add(lblBrands);

        // Добавяне на марка
        brandAddPanel = new brandAddPanel();
        contentPanel.add(brandAddPanel, "addBrand");
        btnAddBrand.addActionListener(switchPanelListener);
        btnAddBrand.setActionCommand("addBrand");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAddBrand);

        // Всички марки (brands)
        brandListPanel = new brandListPanel(this);
        contentPanel.add(brandListPanel, "listBrand");
        btnAllBrand.addActionListener(switchPanelListener);
        btnAllBrand.setActionCommand("listBrand");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAllBrand);

        lblShelfs.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblShelfs.setFont(new Font("Arial", Font.BOLD, 16));
        sideLayoutPanel.add(lblShelfs);

        // Добавяне на рафт (shelves)
        shelfAddPanel = new shelfAddPanel();
        contentPanel.add(shelfAddPanel, "addShelf");
        btnAddShelf.addActionListener(switchPanelListener);
        btnAddShelf.setActionCommand("addShelf");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAddShelf);

        // Всички рафтове (shelves)
        shelfListPanel = new shelfListPanel(this);
        contentPanel.add(shelfListPanel, "listShelf");
        btnAllShelf.addActionListener(switchPanelListener);
        btnAllShelf.setActionCommand("listShelf");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAllShelf);

        lblMachines.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblMachines.setFont(new Font("Arial", Font.BOLD, 16));
        sideLayoutPanel.add(lblMachines);

        // Добавяне на машина (products)
        machineAddPanel = new machineAddPanel();
        contentPanel.add(machineAddPanel, "addMachine");
        btnAddMachine.addActionListener(switchPanelListener);
        btnAddMachine.setActionCommand("addMachine");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAddMachine);

        // Всички машини (products)
        machineListPanel = new machineListPanel(this);
        contentPanel.add(machineListPanel, "listMachine");
        btnAllMachine.addActionListener(switchPanelListener);
        btnAllMachine.setActionCommand("listMachine");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAllMachine);

        // Layout, не променяй
        //************************************  
        this.setLayout(new BorderLayout());
        this.add(jPanel1, BorderLayout.NORTH);
        this.add(sideLayoutPanel, BorderLayout.WEST);
        this.add(contentPanel, BorderLayout.CENTER);
    }

    ActionListener switchPanelListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
            String actionCommand = e.getActionCommand();
            cardLayout.show(contentPanel, actionCommand);
        }
    };

    //************************************
    // СЛУШАЧИ ОТ ПАНЕЛИТЕ ЗА ПРЕВКЛЮЧВАНЕ МЕЖДУ ПАНЕЛИТЕ
    // Слушач за клик на бутона от панела за Всички Потребители - Добавяне
    public void switchToUserAddPanel() {
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "addUser");
    }

    // Слушач за клик на бутона от панела за Всички Потребители - Редактиране
    public void switchToUserEditPanel(int id, String name, String email, String phone, String city, String status, String egn, String pkod, String role, String is_firm, String firm_name, String firm_eik, String firm_mol, String firm_dds, String firm_address) {
        // Нова инстанция на userEditPanel с параметрите
        userEditPanel editPanel = new userEditPanel(id, name, email, phone, city, status, egn, pkod, role, is_firm, firm_name, firm_eik, firm_mol, firm_dds, firm_address);
        contentPanel.add(editPanel, "editUser");
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "editUser");
    }

    // Слушач за клик на бутона от панела за Всички Марки - Добавяне
    public void switchToBrandAddPanel() {
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "addBrand");
    }

    // Слушач за клик на бутона от панела за Всички Марки - Редактиране
    public void switchToBrandEditPanel(int brand_id, String brand_name) {
        // Нова инстанция на brandEditPanel с параметрите
        brandEditPanel editPanel = new brandEditPanel(brand_id, brand_name);
        contentPanel.add(editPanel, "editBrand");
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "editBrand");
    }

    // Слушач за клик на бутона от панела за Всички Рафтове - Добавяне
    public void switchToShelfAddPanel() {
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "addShelf");
    }

    // Слушач за клик на бутона от панела за Всички Рафтове - Редактиране
    public void switchToShelfEditPanel(int shelf_id, String shelf_name, int max_capacity, int current_load) {
        // Нова инстанция на shelfEditPanel с параметрите
        shelfEditPanel editPanel = new shelfEditPanel(shelf_id, shelf_name, max_capacity, current_load);
        contentPanel.add(editPanel, "editShelf");
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "editShelf");
    }

    // Слушач за клик на бутона от панела за Всички Машини - Добавяне
    public void switchToMachineAddPanel() {
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "addMachine");
    }

    // Слушач за клик на бутона от панела за Всички Машини - Редактиране
    public void switchToMachineEditPanel(int product_id, String product_name, int category_id, String category_name, int brand_id, String brand_name, double price, int qty) {
        // Нова инстанция на machineEditPanel с параметрите
        machineEditPanel editPanel = new machineEditPanel(product_id, product_name, category_id, category_name, brand_id, brand_name, price, qty);
        contentPanel.add(editPanel, "editMachine");
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "editMachine");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideLayoutPanel = new javax.swing.JPanel();
        btnAddUser = new javax.swing.JButton();
        lblUsers = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnAllUser = new javax.swing.JButton();
        btnAllBrand = new javax.swing.JButton();
        lblBrands = new javax.swing.JLabel();
        btnAddBrand = new javax.swing.JButton();
        lblShelfs = new javax.swing.JLabel();
        btnAddShelf = new javax.swing.JButton();
        btnAllShelf = new javax.swing.JButton();
        lblMachines = new javax.swing.JLabel();
        btnAddMachine = new javax.swing.JButton();
        btnAllMachine = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sideLayoutPanel.setBackground(new java.awt.Color(241, 241, 230));

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/addUser.png"))); // NOI18N
        btnAddUser.setText("Добави потребител");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        lblUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsers.setText("ПОТРЕБИТЕЛИ");

        btnDashboard.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/dashboard.png"))); // NOI18N
        btnDashboard.setText("НАЧАЛО");
        btnDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAllUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/user.png"))); // NOI18N
        btnAllUser.setText("Всички потребители");
        btnAllUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllUserActionPerformed(evt);
            }
        });

        btnAllBrand.setText("Всички марки");
        btnAllBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllBrandActionPerformed(evt);
            }
        });

        lblBrands.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBrands.setText("МАРКИ");

        btnAddBrand.setText("Добави марка");
        btnAddBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBrandActionPerformed(evt);
            }
        });

        lblShelfs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblShelfs.setText("РАФТОВЕ");

        btnAddShelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/shelfAdd.png"))); // NOI18N
        btnAddShelf.setText("Добави рафт");
        btnAddShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddShelfActionPerformed(evt);
            }
        });

        btnAllShelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/shelf.png"))); // NOI18N
        btnAllShelf.setText("Всички рафтове");
        btnAllShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllShelfActionPerformed(evt);
            }
        });

        lblMachines.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMachines.setText("МАШИНИ");

        btnAddMachine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/machineAdd.png"))); // NOI18N
        btnAddMachine.setText("Добави машина");
        btnAddMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMachineActionPerformed(evt);
            }
        });

        btnAllMachine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/machine.png"))); // NOI18N
        btnAllMachine.setText("Всички машини");
        btnAllMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllMachineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideLayoutPanelLayout = new javax.swing.GroupLayout(sideLayoutPanel);
        sideLayoutPanel.setLayout(sideLayoutPanelLayout);
        sideLayoutPanelLayout.setHorizontalGroup(
            sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                .addGroup(sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAllBrand, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAllShelf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddShelf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                        .addGroup(sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnDashboard))
                            .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMachines)
                                    .addComponent(lblUsers))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAllUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                                .addGroup(sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBrands)
                                    .addComponent(lblShelfs))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnAllMachine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddMachine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        sideLayoutPanelLayout.setVerticalGroup(
            sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnDashboard)
                .addGap(50, 50, 50)
                .addComponent(lblUsers)
                .addGap(18, 18, 18)
                .addComponent(btnAddUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllUser)
                .addGap(23, 23, 23)
                .addComponent(lblBrands)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblShelfs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddShelf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllShelf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMachines)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddMachine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllMachine)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(241, 241, 230));

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/logout.png"))); // NOI18N
        logoutButton.setText("Изход");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Здравейте, ");

        lbl_user.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_user.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_user)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_user)
                        .addComponent(jLabel3))
                    .addComponent(logoutButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jMenu1.setText("Файл");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Запази");
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Изход");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Редактиране");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Помощ");

        jMenuItem1.setText("За приложението");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sideLayoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 675, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sideLayoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed

    }//GEN-LAST:event_btnAddUserActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Сигурни ли сте, че искате да се отпишете?", "Изход", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // izvikvame metoda za izxod
            logout();
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    // [Menu Bar] За приложението
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JDialog dialog = new JDialog(this, "За Приложението", true);
        AboutAppPanel about = new AboutAppPanel(dialog);

        dialog.getContentPane().add(about);

        dialog.setSize(800, 800);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // [Menu Bar] За Изход
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Сигурни ли сте, че искате да се отпишете?", "Изход", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // izvikvame metoda za izxod
            logout();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnAllUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllUserActionPerformed

    private void btnAllBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllBrandActionPerformed

    private void btnAddBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddBrandActionPerformed

    private void btnAddShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddShelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddShelfActionPerformed

    private void btnAllShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllShelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllShelfActionPerformed

    private void btnAddMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMachineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMachineActionPerformed

    private void btnAllMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllMachineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllMachineActionPerformed

    // logout user function
    public void logout() {
        // Assuming you're storing the logged-in user in a class like LoggedInUser
        LoggedInUser.setUser(null);  // Clear the stored user (this is a custom utility class)

        // Create and show the LoginForm
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);

        // Close the current window
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String role = (args.length > 0) ? args[0] : "none";
                new AdminForm(role).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBrand;
    private javax.swing.JButton btnAddMachine;
    private javax.swing.JButton btnAddShelf;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnAllBrand;
    private javax.swing.JButton btnAllMachine;
    private javax.swing.JButton btnAllShelf;
    private javax.swing.JButton btnAllUser;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblBrands;
    private javax.swing.JLabel lblMachines;
    private javax.swing.JLabel lblShelfs;
    private javax.swing.JLabel lblUsers;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel sideLayoutPanel;
    // End of variables declaration//GEN-END:variables
}
