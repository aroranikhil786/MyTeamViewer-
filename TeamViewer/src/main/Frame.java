/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.ListModel;

/**
 *
 * @author Nikhil Arora
 */
public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
        Main.setVisible(true);
        Rece.setVisible(false);
        Send.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Rece = new javax.swing.JPanel();
        chs = new javax.swing.JButton();
        path = new javax.swing.JLabel();
        pair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<String>();
        rece = new javax.swing.JButton();
        Send = new javax.swing.JPanel();
        cf_send = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<String>();
        sd_send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jButton3.setBackground(new java.awt.Color(0, 123, 169));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Send");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 123, 169));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Receive");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        getContentPane().add(Main, "card4");

        chs.setText("Choose Path");
        chs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chsActionPerformed(evt);
            }
        });

        path.setText("C:\\Users\\Nikhil Arora\\Desktop\\fl");

        pair.setText("Pair");
        pair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pairActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(list);

        rece.setText("Rece");
        rece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReceLayout = new javax.swing.GroupLayout(Rece);
        Rece.setLayout(ReceLayout);
        ReceLayout.setHorizontalGroup(
            ReceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ReceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(path, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReceLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReceLayout.createSequentialGroup()
                        .addComponent(chs)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ReceLayout.createSequentialGroup()
                        .addComponent(pair, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ReceLayout.setVerticalGroup(
            ReceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(chs, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ReceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pair, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rece, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        getContentPane().add(Rece, "card2");

        cf_send.setText("Choose File ");
        cf_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cf_sendActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        sd_send.setText("Send");
        sd_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sd_sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SendLayout = new javax.swing.GroupLayout(Send);
        Send.setLayout(SendLayout);
        SendLayout.setHorizontalGroup(
            SendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SendLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addGroup(SendLayout.createSequentialGroup()
                        .addGroup(SendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cf_send, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SendLayout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(sd_send, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SendLayout.setVerticalGroup(
            SendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SendLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(cf_send, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(sd_send, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        getContentPane().add(Send, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pairActionPerformed
 Project_clients p= new Project_clients();
 p.broadCast(this);
 p.ExitRec(15);
    }//GEN-LAST:event_pairActionPerformed

    private void receActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receActionPerformed
    String p=path.getText();
    
    if(!list.isSelectionEmpty()){
    String ip=list.getSelectedValue();
    ip=ip.substring(0,ip.indexOf("("));
    
        File f=new File(p);
        if(f.isDirectory())
        {
            new Project_clients().Rec(this,f,ip);
        }
    }
    
    }//GEN-LAST:event_receActionPerformed

    private void chsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chsActionPerformed
       JFileChooser jfc=new JFileChooser();
       jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      int n= jfc.showDialog(this, "Select Folder");
      if(JFileChooser.APPROVE_OPTION==n){
        System.out.println(jfc.getSelectedFile().getAbsolutePath());
        path.setText(jfc.getSelectedFile().getAbsolutePath());
      }
    }//GEN-LAST:event_chsActionPerformed

    private void cf_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cf_sendActionPerformed
       JFileChooser jfc=new JFileChooser();
       jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
      int n= jfc.showDialog(this, "Select File");
      if(JFileChooser.APPROVE_OPTION==n){
        System.out.println(jfc.getSelectedFile().getAbsolutePath());
        
          ListModel lm=jList1.getModel();
          DefaultListModel dl=new DefaultListModel();
          for(int x=0;x<lm.getSize();x++){
          dl.add(x,lm.getElementAt(x));
          }
          dl.add(lm.getSize(),jfc.getSelectedFile().getAbsolutePath());
          jList1.setModel(dl);
      }
    }//GEN-LAST:event_cf_sendActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 
        Main.setVisible(false);
        Rece.setVisible(true);
        Send.setVisible(false);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 
        Main.setVisible(false);
        Rece.setVisible(false);
        Send.setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void sd_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sd_sendActionPerformed
  if(!jList1.isSelectionEmpty()){
      String fpath=jList1.getSelectedValue();
      File f=new File(fpath);
      if(f.exists()){
      Project_Send p=new Project_Send();
        if(p.port(8888))
        {
            p.dGS(this);
        }
        p.send(this, f);
      }
  }// TODO add your handling code here:
    }//GEN-LAST:event_sd_sendActionPerformed

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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Rece;
    private javax.swing.JPanel Send;
    private javax.swing.JButton cf_send;
    private javax.swing.JButton chs;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JList<String> list;
    private javax.swing.JButton pair;
    private javax.swing.JLabel path;
    private javax.swing.JButton rece;
    private javax.swing.JButton sd_send;
    // End of variables declaration//GEN-END:variables
}