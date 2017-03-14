/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uh.kasir;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dhenarra
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtUser = new javax.swing.JTextField();
        jbSignIn = new javax.swing.JButton();
        jbSignUp = new javax.swing.JButton();
        jpPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(178, 235, 242));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(178, 235, 242));
        jPanel1.setForeground(new java.awt.Color(178, 235, 242));
        jPanel1.setLayout(null);

        jLabel2.setText("Username");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 90, 120, 20);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setText("Indomaret Login Kasir");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 280, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 70);
        getContentPane().add(jtUser);
        jtUser.setBounds(10, 120, 380, 30);

        jbSignIn.setBackground(new java.awt.Color(178, 235, 242));
        jbSignIn.setText("Sign In");
        jbSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSignInActionPerformed(evt);
            }
        });
        getContentPane().add(jbSignIn);
        jbSignIn.setBounds(230, 240, 150, 40);

        jbSignUp.setBackground(new java.awt.Color(178, 235, 242));
        jbSignUp.setText("Sign Up");
        jbSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(jbSignUp);
        jbSignUp.setBounds(10, 240, 150, 40);
        getContentPane().add(jpPass);
        jpPass.setBounds(10, 180, 380, 30);

        jLabel1.setText("Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 160, 120, 20);

        jLabel4.setText("Username");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 90, 120, 20);

        setBounds(0, 0, 416, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSignUpActionPerformed
        // TODO add your handling code here:
        String username = jtUser.getText();
        String password = jpPass.getText();
        
        try{
            try (Statement statement = (Statement) FileKoneksi.GetConnection().createStatement()) {
                statement.executeUpdate("insert into tb_akun(username,password) VALUES ('" + username + "','" + password + "');");
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Selamat! Anda berhasil sign up!");
        } catch (Exception t){
            JOptionPane.showMessageDialog(null, "Mohon maaf, ulangi lagi prosedur");
        }
        
        jtUser.setText("");
        jpPass.setText("");
    }//GEN-LAST:event_jbSignUpActionPerformed

    private void jbSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSignInActionPerformed
        // TODO add your handling code here:
        Connection connection;
        PreparedStatement ps;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_toko", "root", "");
            ps = connection.prepareStatement("SELECT username, password FROM tb_akun WHERE username = ? AND password = ?");
            ps.setString(1, jtUser.getText());
            ps.setString(2, jpPass.getText());
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                new MainFrame().show();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                jpPass.setText("");
                jtUser.requestFocus();
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "gagal");
        }
    }//GEN-LAST:event_jbSignInActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbSignIn;
    private javax.swing.JButton jbSignUp;
    private javax.swing.JPasswordField jpPass;
    private javax.swing.JTextField jtUser;
    // End of variables declaration//GEN-END:variables
}
