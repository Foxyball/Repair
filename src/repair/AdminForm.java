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

    catAddPanel catAddPanel;
    catListPanel catListPanel;

    orderAddPanel orderAddPanel;
    orderListPanel orderListPanel;

    invoiceListPanel invoiceListPanel;

    LoggedInUser LoggedInUser;

    public AdminForm(String role) {
        initComponents();
        this.setLocationRelativeTo(null); // Centrirane
        this.setSize(1250, 900);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setSize((int) (screenSize.width * 0.9), (int) (screenSize.height * 0.9));

        User loggedInUser = LoggedInUser.getUser();
        String email = LoggedInUser.getUser().getEmail();
        lbl_user.setText(LoggedInUser.getUser().getName());

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));

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
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnDashboard);
        sideLayoutPanel.add(Box.createVerticalStrut(20));

        lblOrder.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblOrder.setFont(new Font("Arial", Font.BOLD, 16));
        sideLayoutPanel.add(lblOrder);

        // Добавяне на заявка (repair_orders)
        orderAddPanel = new orderAddPanel();
        contentPanel.add(orderAddPanel, "addOrder");
        btnAddOrder.addActionListener(switchPanelListener);
        btnAddOrder.setActionCommand("addOrder");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAddOrder);

        // Всички заявка (repair_orders)
        orderListPanel = new orderListPanel(this);
        contentPanel.add(orderListPanel, "listOrder");
        btnAllOrder.addActionListener(switchPanelListener);
        btnAllOrder.setActionCommand("listOrder");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAllOrder);

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

        lblCategory.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblCategory.setFont(new Font("Arial", Font.BOLD, 16));
        sideLayoutPanel.add(lblCategory);

        // Добавяне на категория (categories)
        catAddPanel = new catAddPanel();
        contentPanel.add(catAddPanel, "addCategory");
        btnAddCategory.addActionListener(switchPanelListener);
        btnAddCategory.setActionCommand("addCategory");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAddCategory);

        // Всички категории (categories)
        catListPanel = new catListPanel(this);
        contentPanel.add(catListPanel, "listCategory");
        btnAllCategory.addActionListener(switchPanelListener);
        btnAllCategory.setActionCommand("listCategory");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAllCategory);

        lblInvoice.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblInvoice.setFont(new Font("Arial", Font.BOLD, 16));
        sideLayoutPanel.add(lblInvoice);

        // Всички фактури (invoices)
        invoiceListPanel = new invoiceListPanel(this);
        contentPanel.add(invoiceListPanel, "listInvoice");
        btnAllInvoice.addActionListener(switchPanelListener);
        btnAllInvoice.setActionCommand("listInvoice");
        sideLayoutPanel.add(Box.createVerticalStrut(10));
        sideLayoutPanel.add(btnAllInvoice);

        // Layout, не променяй
        //************************************  
        this.setLayout(new BorderLayout());
        this.add(jPanel1, BorderLayout.NORTH);
//        this.add(sideLayoutPanel, BorderLayout.WEST);
        JScrollPane scrollableSidePanel = new JScrollPane(sideLayoutPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollableSidePanel, BorderLayout.WEST);

//        this.add(contentPanel, BorderLayout.CENTER);
        JScrollPane scrollableContentPanel = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollableContentPanel, BorderLayout.CENTER);

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

    // Слушач за клик на бутона от панела за Всички Категории - Добавяне
    public void switchToCategoryAddPanel() {
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "addCategory");
    }

    // Слушач за клик на бутона от панела за Всички Категории - Редактиране
    public void switchToCategoryEditPanel(int cat_id, String category_name) {
        // Нова инстанция на catEditPanel с параметрите
        catEditPanel editPanel = new catEditPanel(cat_id, category_name);
        contentPanel.add(editPanel, "editCategory");
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "editCategory");
    }

    // Слушач за клик на бутона от панела за Всички Заявки - Добавяне
    public void switchToOrderAddPanel() {
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "addOrder");
    }

    // Слушач за клик на бутона от панела за Всички Заявки - Редактиране
    public void switchToOrderEditPanel(int repair_id, int user_id, int product_id, int shelf_id, String fault_desc, String work_carried_out_desc, String created_at, String status, int is_warranty, int warranty_denied, double labor_cost, double parts_cost, double total_price, String user_name, String product_name, String shelf_name, String category_name, String brand_name) {
        // Нова инстанция на catEditPanel с параметрите
        orderEditPanel editPanel = new orderEditPanel(repair_id, user_id, product_id, shelf_id,
                fault_desc, work_carried_out_desc, created_at,
                status, is_warranty, warranty_denied,
                labor_cost, parts_cost, total_price,
                user_name, product_name, shelf_name,
                category_name, brand_name);
        contentPanel.add(editPanel, "editOrder");
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "editOrder");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
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
        lblCategory = new javax.swing.JLabel();
        btnAddCategory = new javax.swing.JButton();
        btnAllCategory = new javax.swing.JButton();
        lblOrder = new javax.swing.JLabel();
        btnAddOrder = new javax.swing.JButton();
        btnAllOrder = new javax.swing.JButton();
        lblInvoice = new javax.swing.JLabel();
        btnAllInvoice = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFIle = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuAdd = new javax.swing.JMenu();
        menuOrder = new javax.swing.JMenuItem();
        menuUser = new javax.swing.JMenuItem();
        menuMachine = new javax.swing.JMenuItem();
        menuCat = new javax.swing.JMenuItem();
        menuBrand = new javax.swing.JMenuItem();
        menuShelf = new javax.swing.JMenuItem();
        menuTools = new javax.swing.JMenu();
        menuExportDatabase = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));

        jPanel1.setBackground(new java.awt.Color(235, 247, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 153, 255))); // NOI18N

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/logout.png"))); // NOI18N
        logoutButton.setText("Изход");
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addContainerGap(650, Short.MAX_VALUE)
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(lbl_user)
                    .addComponent(jLabel3))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        sideLayoutPanel.setBackground(new java.awt.Color(235, 247, 248));
        sideLayoutPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 153, 255))); // NOI18N

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/addUser.png"))); // NOI18N
        btnAddUser.setText("Добави потребител");
        btnAddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        lblUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsers.setText("ПОТРЕБИТЕЛИ");

        btnDashboard.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/home.png"))); // NOI18N
        btnDashboard.setText("НАЧАЛО");
        btnDashboard.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(235, 247, 248))); // NOI18N
        btnDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAllUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/user.png"))); // NOI18N
        btnAllUser.setText("Всички потребители");
        btnAllUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAllUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllUserActionPerformed(evt);
            }
        });

        btnAllBrand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/brandAll.png"))); // NOI18N
        btnAllBrand.setText("Всички марки");
        btnAllBrand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAllBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllBrandActionPerformed(evt);
            }
        });

        lblBrands.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBrands.setText("МАРКИ");

        btnAddBrand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/brandAdd.png"))); // NOI18N
        btnAddBrand.setText("Добави марка");
        btnAddBrand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBrandActionPerformed(evt);
            }
        });

        lblShelfs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblShelfs.setText("РАФТОВЕ");

        btnAddShelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/shelfAdd.png"))); // NOI18N
        btnAddShelf.setText("Добави рафт");
        btnAddShelf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddShelfActionPerformed(evt);
            }
        });

        btnAllShelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/shelf.png"))); // NOI18N
        btnAllShelf.setText("Всички рафтове");
        btnAllShelf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAllShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllShelfActionPerformed(evt);
            }
        });

        lblMachines.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMachines.setText("МАШИНИ");

        btnAddMachine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/machineAdd.png"))); // NOI18N
        btnAddMachine.setText("Добави машина");
        btnAddMachine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMachineActionPerformed(evt);
            }
        });

        btnAllMachine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/machine.png"))); // NOI18N
        btnAllMachine.setText("Всички машини");
        btnAllMachine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAllMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllMachineActionPerformed(evt);
            }
        });

        lblCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategory.setText("КАТЕГОРИИ");

        btnAddCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/addCategory.png"))); // NOI18N
        btnAddCategory.setText("Добави категория");
        btnAddCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        btnAllCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/category.png"))); // NOI18N
        btnAllCategory.setText("Всички категории");
        btnAllCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAllCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllCategoryActionPerformed(evt);
            }
        });

        lblOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrder.setText("ЗАЯВКИ");

        btnAddOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/repairOrderAdd.png"))); // NOI18N
        btnAddOrder.setText("Добави заявка");
        btnAddOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderActionPerformed(evt);
            }
        });

        btnAllOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/repairOrder.png"))); // NOI18N
        btnAllOrder.setText("Всички заявки");
        btnAllOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAllOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllOrderActionPerformed(evt);
            }
        });

        lblInvoice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInvoice.setText("Фактури");

        btnAllInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/invoices.png"))); // NOI18N
        btnAllInvoice.setText("Всички фактури");
        btnAllInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAllInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllInvoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideLayoutPanelLayout = new javax.swing.GroupLayout(sideLayoutPanel);
        sideLayoutPanel.setLayout(sideLayoutPanelLayout);
        sideLayoutPanelLayout.setHorizontalGroup(
            sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                .addGroup(sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAllBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnAddOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAllCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(lblCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAllMachine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddMachine, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                .addComponent(lblMachines, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAllShelf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddShelf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblShelfs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAllOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAllInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnAllUser, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblBrands, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAddBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        sideLayoutPanelLayout.setVerticalGroup(
            sideLayoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLayoutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMachines)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddMachine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllMachine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInvoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllInvoice)
                .addGap(63, 63, 63))
        );

        menuFIle.setText("Файл");
        menuFIle.add(jSeparator1);

        jMenuItem2.setText("Изход");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuFIle.add(jMenuItem2);

        jMenuBar1.add(menuFIle);

        menuAdd.setText("Добави");

        menuOrder.setText("Заявка");
        menuOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOrderActionPerformed(evt);
            }
        });
        menuAdd.add(menuOrder);

        menuUser.setText("Потребител");
        menuUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUserActionPerformed(evt);
            }
        });
        menuAdd.add(menuUser);

        menuMachine.setText("Машина");
        menuMachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMachineActionPerformed(evt);
            }
        });
        menuAdd.add(menuMachine);

        menuCat.setText("Категория");
        menuCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCatActionPerformed(evt);
            }
        });
        menuAdd.add(menuCat);

        menuBrand.setText("Марка");
        menuBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBrandActionPerformed(evt);
            }
        });
        menuAdd.add(menuBrand);

        menuShelf.setText("Рафт");
        menuShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuShelfActionPerformed(evt);
            }
        });
        menuAdd.add(menuShelf);

        jMenuBar1.add(menuAdd);

        menuTools.setText("Инструменти");

        menuExportDatabase.setText("Архив на Sqlite");
        menuExportDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExportDatabaseActionPerformed(evt);
            }
        });
        menuTools.add(menuExportDatabase);

        jMenuBar1.add(menuTools);

        menuHelp.setText("Помощ");

        jMenuItem1.setText("Относно");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuHelp.add(jMenuItem1);

        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sideLayoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sideLayoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void menuOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOrderActionPerformed
        switchToOrderAddPanel();
    }//GEN-LAST:event_menuOrderActionPerformed

    private void menuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUserActionPerformed
        switchToUserAddPanel();
    }//GEN-LAST:event_menuUserActionPerformed

    private void menuMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMachineActionPerformed
        switchToMachineAddPanel();
    }//GEN-LAST:event_menuMachineActionPerformed

    private void menuCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCatActionPerformed
        switchToCategoryAddPanel();
    }//GEN-LAST:event_menuCatActionPerformed

    private void menuBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBrandActionPerformed
        switchToBrandAddPanel();
    }//GEN-LAST:event_menuBrandActionPerformed

    private void menuExportDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExportDatabaseActionPerformed
        String sourcePath = ".//db/repair.sqlite";

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Изберете местоположение");
        fileChooser.setSelectedFile(new java.io.File("backup_" + System.currentTimeMillis() + "-repair" + ".sqlite"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File backupFile = fileChooser.getSelectedFile();
            String backupPath = backupFile.getAbsolutePath();

            try (java.nio.channels.FileChannel sourceChannel = new java.io.FileInputStream(sourcePath).getChannel(); java.nio.channels.FileChannel destChannel = new java.io.FileOutputStream(backupPath).getChannel()) {

                destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
                JOptionPane.showMessageDialog(null, "Успешно архивиране на базата данни!\nМестоположение: " + backupPath,
                        "Успешно архивиране", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Грешка при архивиране на базата данни: " + ex.getMessage(),
                        "Неуспешно архивиране", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_menuExportDatabaseActionPerformed

    private void menuShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuShelfActionPerformed
        switchToShelfAddPanel();
    }//GEN-LAST:event_menuShelfActionPerformed

    private void btnAllInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllInvoiceActionPerformed

    private void btnAllOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllOrderActionPerformed

    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddOrderActionPerformed

    private void btnAllCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllCategoryActionPerformed

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnAllMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllMachineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllMachineActionPerformed

    private void btnAddMachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMachineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMachineActionPerformed

    private void btnAllShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllShelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllShelfActionPerformed

    private void btnAddShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddShelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddShelfActionPerformed

    private void btnAddBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddBrandActionPerformed

    private void btnAllBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllBrandActionPerformed

    private void btnAllUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllUserActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed

    }//GEN-LAST:event_btnAddUserActionPerformed

    public void logout() {
        LoggedInUser.setUser(null);
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
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
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnAddMachine;
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnAddShelf;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnAllBrand;
    private javax.swing.JButton btnAllCategory;
    private javax.swing.JButton btnAllInvoice;
    private javax.swing.JButton btnAllMachine;
    private javax.swing.JButton btnAllOrder;
    private javax.swing.JButton btnAllShelf;
    private javax.swing.JButton btnAllUser;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblBrands;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblInvoice;
    private javax.swing.JLabel lblMachines;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblShelfs;
    private javax.swing.JLabel lblUsers;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JButton logoutButton;
    private javax.swing.JMenu menuAdd;
    private javax.swing.JMenuItem menuBrand;
    private javax.swing.JMenuItem menuCat;
    private javax.swing.JMenuItem menuExportDatabase;
    private javax.swing.JMenu menuFIle;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuMachine;
    private javax.swing.JMenuItem menuOrder;
    private javax.swing.JMenuItem menuShelf;
    private javax.swing.JMenu menuTools;
    private javax.swing.JMenuItem menuUser;
    private javax.swing.JPanel sideLayoutPanel;
    // End of variables declaration//GEN-END:variables
}
