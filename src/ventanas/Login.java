package ventanas;

import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public static String user = "", user_nivel = "";
    String pass = "";

    public Login() {
        initComponents();

        setSize(400, 600);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaper_principal.jpg");
        Icon icono;
        icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icono);
        this.repaint();

        ImageIcon wallpaper_logo = new ImageIcon("src/images/logo.png");
        Icon icono_logo = new ImageIcon(wallpaper_logo.getImage().getScaledInstance(label_logo.getWidth(),
                label_logo.getHeight(), Image.SCALE_DEFAULT));
        label_logo.setIcon(icono_logo);
        this.repaint();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_pass = new javax.swing.JPasswordField();
        footer = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        label_logo = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_username.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tf_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 200, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("USUARIO:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 270, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("CONTRASEÑA:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, -1, -1));

        tf_pass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tf_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(tf_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 200, -1));

        footer.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        footer.setText("Creado por Cosme Fulanito C.O.");
        footer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footerMouseClicked(evt);
            }
        });
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("ACCEDER");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 160, 40));
        getContentPane().add(label_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 200, 190));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        user = tf_username.getText().trim();
        pass = tf_pass.getText().trim();

        if (!user.equals("") || !pass.equals("")) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select nivel, estatus from usuarios where username = '" + user + "' and password = '" + pass + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    String nivel = rs.getString("nivel");
                    user_nivel = nivel;
                    String estatus = rs.getString("estatus");

                    if (nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Administrador().setVisible(true);
                    } else if (nivel.equalsIgnoreCase("1") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Nivel1().setVisible(true);
                    } else if (nivel.equalsIgnoreCase("2") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Nivel2().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario inactivo");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrecto");
                    tf_username.setText("");
                    tf_pass.setText("");
                }
            } catch (SQLException e) {
                System.err.println("Error en el boton accder" + e);
                JOptionPane.showMessageDialog(null, "Error, contacte al administrador");
            }
            /*String nivel = user;
            user_nivel = nivel;
            dispose();
            switch (user) {
                case "admin":
                    new Administrador().setVisible(true);
                    break;
                case "1":
                    new Nivel1().setVisible(true);
                    break;
                case "2":
                    new Nivel2().setVisible(true);
                    break;
                default:
                    throw new AssertionError();
            }*/
            
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void footerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footerMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Por soporte tecnico comuniquese al e-mail: soporte@lachucha.com.ar");
    }//GEN-LAST:event_footerMouseClicked

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
    private javax.swing.JLabel footer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JPasswordField tf_pass;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
