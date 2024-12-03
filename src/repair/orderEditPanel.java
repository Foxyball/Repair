package repair;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class orderEditPanel extends javax.swing.JPanel {

    private int repair_id;
    config q = new config();

    public orderEditPanel(int repair_id, int user_id, int product_id, int shelf_id, String fault_desc, String work_carried_out_desc, String created_at, String status, int is_warranty, int warranty_denied, double labor_cost, double parts_cost, double total_price, String user_name, String product_name, String shelf_name, String category_name, String brand_name) {
        initComponents();

        this.repair_id = repair_id;

        txtOrderLaborCost.setText(String.valueOf(labor_cost));
        txtOrderPartsCost.setText(String.valueOf(parts_cost));
        txtOrderFaultDesc.setText(fault_desc);
        txtOrderConfirmedFault.setText(work_carried_out_desc);

        // проверява дали е гаранционна, за да постави отметка
        is_warranty_checkbox.setSelected(is_warranty == 1);

        ArrayList<User> users = q.loadUserData("");
        DefaultComboBoxModel<User> userModel = new DefaultComboBoxModel<>();
        for (User user : users) {
            userModel.addElement(user);
        }
        comboOrderUser.setModel(userModel);

        for (int i = 0; i < userModel.getSize(); i++) {
            User user = userModel.getElementAt(i);
            if (user.getUserId() == user_id) {
                comboOrderUser.setSelectedItem(user);
                break;
            }
        }

        ArrayList<Machine> machines = q.loadMachineData();
        DefaultComboBoxModel<Machine> machineModel = new DefaultComboBoxModel<>();
        for (Machine machine : machines) {
            machineModel.addElement(machine);
        }
        comboOrderMachine.setModel(machineModel);

        for (int i = 0; i < machineModel.getSize(); i++) {
            Machine machine = machineModel.getElementAt(i);
            if (machine.getMachineId() == product_id) {
                comboOrderMachine.setSelectedItem(machine);
                break;
            }
        }

        ArrayList<Shelf> shelves = q.loadShelfData();
        DefaultComboBoxModel<Shelf> shelfModel = new DefaultComboBoxModel<>();
        for (Shelf shelf : shelves) {
            shelfModel.addElement(shelf);
        }
        comboOrderShelf.setModel(shelfModel);

        for (int i = 0; i < shelfModel.getSize(); i++) {
            Shelf shelf = shelfModel.getElementAt(i);
            if (shelf.getShelfId() == shelf_id) {
                comboOrderShelf.setSelectedItem(shelf);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEditOrder = new javax.swing.JLabel();
        btnEditOrder = new repair.Button();
        txtOrderLaborCost = new repair.TextField();
        txtOrderPartsCost = new repair.TextField();
        comboOrderUser = new repair.ComboBox();
        comboOrderMachine = new repair.ComboBox();
        comboOrderShelf = new repair.ComboBox();
        comboOrderStatus = new repair.ComboBox();
        is_warranty_checkbox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOrderFaultDesc = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOrderConfirmedFault = new javax.swing.JTextArea();
        btnOrderInvoice = new repair.Button();

        lblEditOrder.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblEditOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditOrder.setText("РЕДАКТИРАНЕ НА МАШИНА");
        lblEditOrder.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblEditOrder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnEditOrder.setBackground(new java.awt.Color(0, 153, 255));
        btnEditOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnEditOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        btnEditOrder.setText("Запази");
        btnEditOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditOrderActionPerformed(evt);
            }
        });

        txtOrderLaborCost.setLabelText("Труд");

        txtOrderPartsCost.setLabelText("Цена на части");

        comboOrderUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboOrderUserItemStateChanged(evt);
            }
        });

        comboOrderStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Незавършен", "Завършен", "Отказан" }));

        is_warranty_checkbox.setText("Гаранционна");

        txtOrderFaultDesc.setColumns(20);
        txtOrderFaultDesc.setRows(5);
        jScrollPane1.setViewportView(txtOrderFaultDesc);

        txtOrderConfirmedFault.setColumns(20);
        txtOrderConfirmedFault.setRows(5);
        jScrollPane2.setViewportView(txtOrderConfirmedFault);

        btnOrderInvoice.setBackground(new java.awt.Color(0, 153, 255));
        btnOrderInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnOrderInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/save.png"))); // NOI18N
        btnOrderInvoice.setText("Фактура");
        btnOrderInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderInvoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(btnEditOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOrderInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblEditOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblEditOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(is_warranty_checkbox))
                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(txtOrderPartsCost, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrderInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditOrderActionPerformed
        User selectedUser = (User) comboOrderUser.getSelectedItem();
        Machine selectedMachine = (Machine) comboOrderMachine.getSelectedItem();
        Shelf selectedShelf = (Shelf) comboOrderShelf.getSelectedItem();
        String status = (String) comboOrderStatus.getSelectedItem();

        String fault_desc = txtOrderFaultDesc.getText();
        String work_carried_out_desc = txtOrderConfirmedFault.getText();

        double labor_cost;
        double parts_cost;
        try {
            labor_cost = Double.parseDouble(txtOrderLaborCost.getText());
            parts_cost = Double.parseDouble(txtOrderPartsCost.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Моля въведете коректни стойности за труд и части");
            return;
        }

        int is_warranty = is_warranty_checkbox.isSelected() ? 1 : 0;

        if (labor_cost < 0 || parts_cost < 0) {
            JOptionPane.showMessageDialog(null, "Моля въведете коректни стойности за труд и части");
            return;
        }

        if (fault_desc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Моля попълнете всички полета");
            return;
        }

        int user_id = selectedUser.getUserId();
        int product_id = selectedMachine.getMachineId();
        int shelf_id = selectedShelf.getShelfId();

        double total_price = 0;
        int warranty_denied = 0;
        if (is_warranty == 1) {

            warranty_denied = 0;
            total_price = 0;
        } else {

            warranty_denied = 1;
            try {
                total_price = labor_cost + parts_cost;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Моля, въведете валидни стойности за гаранция.", "Грешка", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String[] columns = {
            "user_id", "product_id", "shelf_id", "fault_desc", "work_carried_out_desc",
            "status", "is_warranty", "warranty_denied", "labor_cost", "parts_cost", "total_price"
        };

        Object[] values = {user_id, product_id, shelf_id, fault_desc, work_carried_out_desc,
            status, is_warranty, warranty_denied, labor_cost, parts_cost, total_price
        };

        boolean success = q.update("repair_orders", columns, values, "repair_id", repair_id);

        if (success) {
            JOptionPane.showMessageDialog(this, "Промените са запазени успешно.");

            if ("Завършен".equals(status)) {
                sendCompletionEmail(selectedUser, selectedMachine, total_price);
            } else if ("Отказан".equals(status)) {
                sendDeniedEmail(selectedUser, selectedMachine, fault_desc);
            } else {
                JOptionPane.showMessageDialog(this, "Грешка при запазване на промените.");
            }

    }//GEN-LAST:event_btnEditOrderActionPerformed

    }

    // Изпраща имейл до клиента, когато статуса е променен на Отказан
    private void sendDeniedEmail(User user, Machine machine, String faultDesc) {
        String userName = user.getName();
        String userEmail = user.getEmail();
        String productName = machine.getMachineName();

        String subject = "Статус на Вашата машина - Hristov-08 ЕООД";
        String messageText = "Здравейте, " + userName + ",\n"
                + "Вашата машина " + productName + " не може да бъде ремонтирана. Отказан ремонт \n"
                + "Причина за повреда: " + faultDesc + "\n";

        try {
            MimeMessage message = new MimeMessage(config.getMailSession());
            message.setFrom(new InternetAddress(config.EMAIL_FROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
            message.setSubject(subject);
            message.setText(messageText);
            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (Exception ex) {
            System.out.println("Error sending email: " + ex);
        }
    }

    // Изпраща имейл до клиента, когато статуса е променен на Завършен
    private void sendCompletionEmail(User user, Machine machine, double totalPrice) {

        String userName = user.getName();
        String userEmail = user.getEmail();
        String productName = machine.getMachineName();
        String subject = "Вашата машина е готова - Hristov-08 ЕООД";
        String messageText = "Здравейте, " + userName + ",\n"
                + "Вашата машина " + productName + " е готова за взимане.\n"
                + "Причина за повреда: " + txtOrderConfirmedFault.getText() + ",\n"
                + "Сума за плащане: " + totalPrice + " лв.";

        try {
            MimeMessage message = new MimeMessage(config.getMailSession());
            message.setFrom(new InternetAddress(config.EMAIL_FROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
            message.setSubject(subject);
            message.setText(messageText);
            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (Exception ex) {
            System.out.println("Error sending email: " + ex);
        }
    }


    private void comboOrderUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboOrderUserItemStateChanged

    }//GEN-LAST:event_comboOrderUserItemStateChanged

    // ФАКТУРА
    private void btnOrderInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderInvoiceActionPerformed
        generateInvoice();
    }//GEN-LAST:event_btnOrderInvoiceActionPerformed

    private void generateInvoice() {
        User selectedUser = (User) comboOrderUser.getSelectedItem();
        Machine selectedMachine = (Machine) comboOrderMachine.getSelectedItem();
        double laborCost = Double.parseDouble(txtOrderLaborCost.getText());
        double partsCost = Double.parseDouble(txtOrderPartsCost.getText());
        int isWarranty = is_warranty_checkbox.isSelected() ? 1 : 0;
        double totalPrice = 0;

        if (isWarranty == 0) {
            totalPrice = laborCost + partsCost;
        } else {
            totalPrice = 0;
        }

        String invoiceText = generateInvoiceText(selectedUser, selectedMachine, laborCost, partsCost, totalPrice, isWarranty);

        String filePath = chooseFilePath();
        if (filePath != null) {
            generatePdfInvoice(invoiceText, filePath);
        }
    }

    private String generateInvoiceText(User user, Machine machine, double laborCost, double partsCost, double totalPrice, int isWarranty) {
        String userName = user.getName();
        String userEmail = user.getEmail();
        String productName = machine.getMachineName();

        StringBuilder invoiceText = new StringBuilder();
        invoiceText.append("Repair Order Invoice\n\n");
        invoiceText.append("Customer: ").append(userName).append("\n");
        invoiceText.append("Email: ").append(userEmail).append("\n");
        invoiceText.append("Product: ").append(productName).append("\n");

        if (isWarranty == 1) {
            invoiceText.append("\nWarranty - Free\n");
        } else {
            invoiceText.append("\nLabor Fee: ").append(laborCost).append(" лв.\n");
            invoiceText.append("Parts Fee: ").append(partsCost).append(" лв.\n");
            invoiceText.append("Total: ").append(totalPrice).append(" лв.\n");
        }

        invoiceText.append("\nDate: ").append(java.time.LocalDate.now()).append("\n");
        return invoiceText.toString();
    }

    private void generatePdfInvoice(String invoiceText, String filePath) {
        try {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            String logoPath = ".\\src\\repair\\logo.png";
            Image logo = Image.getInstance(logoPath);
            logo.setAlignment(Element.ALIGN_CENTER);
            logo.scaleToFit(200, 200);
            document.add(logo);

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Фактура за ремонт", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Chunk("\n"));
            document.add(new LineSeparator());

            Font contentFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            Paragraph invoiceContent = new Paragraph(invoiceText, contentFont);
            document.add(invoiceContent);

            document.add(new Chunk("\n"));
            document.add(new LineSeparator());

            Font footerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC);
            Paragraph footer = new Paragraph("Hristov-08 ЕООД - All rights reserved", footerFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);

            document.close();
            System.out.println("Invoice PDF generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Грешка при генериране на фактура", "Грешка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String chooseFilePath() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Invoice");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Files", "pdf"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {

            return fileChooser.getSelectedFile().getAbsolutePath() + ".pdf";
        }

        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private repair.Button btnEditOrder;
    private repair.Button btnOrderInvoice;
    private repair.ComboBox comboOrderMachine;
    private repair.ComboBox comboOrderShelf;
    private repair.ComboBox comboOrderStatus;
    private repair.ComboBox comboOrderUser;
    private javax.swing.JCheckBox is_warranty_checkbox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEditOrder;
    private javax.swing.JTextArea txtOrderConfirmedFault;
    private javax.swing.JTextArea txtOrderFaultDesc;
    private repair.TextField txtOrderLaborCost;
    private repair.TextField txtOrderPartsCost;
    // End of variables declaration//GEN-END:variables
}
