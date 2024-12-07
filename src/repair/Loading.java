
package repair;

import java.time.Duration;

public class Loading extends javax.swing.JFrame implements Runnable {

    int s = 0;
    Thread th;

    public Loading() {
        initComponents();
        th = new Thread(this);
         setLocationRelativeTo(null);
          this.setResizable(false);

    }


    public void setUploading() {
        setVisible(true);
        th.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 200; i++) {
                int currentValue = loadingProgress.getValue();
                if (currentValue < loadingProgress.getMaximum()) {
                    loadingProgress.setValue(currentValue + 1);
                } else {
                    Thread.sleep(50); 
                    setVisible(false);
                    dispose(); 

                    java.awt.EventQueue.invokeLater(() -> {
                        LoginForm loginForm = new LoginForm();
                        loginForm.setVisible(true);
                    });

                    break;
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        heading = new javax.swing.JLabel();
        loadingProgress = new javax.swing.JProgressBar();
        waiting = new javax.swing.JLabel();
        loadingImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        heading.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("Hristov-08 ЕООД ");
        heading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        loadingProgress.setForeground(new java.awt.Color(0, 153, 255));
        loadingProgress.setStringPainted(true);

        waiting.setText("Моля изчакайте...");

        loadingImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/repair/assets/loading.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(heading))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(loadingProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(waiting))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(loadingImg, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(heading)
                .addGap(36, 36, 36)
                .addComponent(loadingProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(waiting)
                .addGap(18, 18, 18)
                .addComponent(loadingImg, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Loading loading = new Loading();
                loading.setUploading();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel heading;
    private javax.swing.JLabel loadingImg;
    private javax.swing.JProgressBar loadingProgress;
    private javax.swing.JLabel waiting;
    // End of variables declaration//GEN-END:variables
}
