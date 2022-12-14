
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Administrador extends javax.swing.JFrame {

    String user;
    public static ArrayList ventanas_abiertas = new ArrayList();
    
    public Administrador() {
        initComponents();
        
        user = Login.user;
        
        setSize(650,500);
        setResizable(false);
        setTitle("Administrador - Sesion de " + user);
        setLocationRelativeTo(null);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaper_principal.jpg");
        Icon icono;
        icono = new ImageIcon(wallpaper.getImage().getScaledInstance( label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
         label_wallpaper.setIcon(icono);
        this.repaint();
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_titulo = new javax.swing.JLabel();
        boton_agregarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        boton_vistaVendedor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        boton_vistaAtencion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        boton_listaUsuario = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        boton_stock = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        boton_agregarProducto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        footer1 = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        label_titulo.setForeground(new java.awt.Color(255, 255, 255));
        label_titulo.setText("Admistrador");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 20, -1, 40));

        boton_agregarUsuario.setBackground(new java.awt.Color(0, 153, 153));
        boton_agregarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser.png"))); // NOI18N
        boton_agregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agregarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(boton_agregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 120, 100));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Agregar usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        boton_vistaVendedor.setBackground(new java.awt.Color(0, 153, 153));
        boton_vistaVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/capturista.png"))); // NOI18N
        boton_vistaVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_vistaVendedorActionPerformed(evt);
            }
        });
        getContentPane().add(boton_vistaVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 120, 100));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Vista vendedor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        boton_vistaAtencion.setBackground(new java.awt.Color(0, 153, 153));
        boton_vistaAtencion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/atencion.png"))); // NOI18N
        boton_vistaAtencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_vistaAtencionActionPerformed(evt);
            }
        });
        getContentPane().add(boton_vistaAtencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 120, 100));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Vista atencion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 200, -1, -1));

        boton_listaUsuario.setBackground(new java.awt.Color(0, 153, 153));
        boton_listaUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        boton_listaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_listaUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(boton_listaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 120, 100));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Lista de usuarios");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 350, -1, -1));

        boton_stock.setBackground(new java.awt.Color(0, 153, 153));
        boton_stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock.png"))); // NOI18N
        boton_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_stockActionPerformed(evt);
            }
        });
        getContentPane().add(boton_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 120, 100));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Stock");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 350, -1, -1));

        boton_agregarProducto.setBackground(new java.awt.Color(0, 153, 153));
        boton_agregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agregar.png"))); // NOI18N
        boton_agregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agregarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(boton_agregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 120, 100));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Agregar producto");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 350, -1, -1));

        footer1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        footer1.setText("Creado por Cosme Fulanito C.O.");
        footer1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footer1MouseClicked(evt);
            }
        });
        getContentPane().add(footer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 420, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_agregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_agregarUsuarioActionPerformed
        // TODO add your handling code here:
        RegistrarUsuario registrar = new RegistrarUsuario();
        
        if (!ventanas_abiertas.contains("registrar")) {
            ventanas_abiertas.add("registrar");
            registrar.setVisible(true);
        }
        
    }//GEN-LAST:event_boton_agregarUsuarioActionPerformed

    private void boton_vistaVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_vistaVendedorActionPerformed
        // TODO add your handling code here:
        Nivel1 nivel1 = new Nivel1();
        
        if (!ventanas_abiertas.contains("nivel1")) {
            ventanas_abiertas.add("nivel1");
            nivel1.setVisible(true);
        }
        
    }//GEN-LAST:event_boton_vistaVendedorActionPerformed

    private void boton_vistaAtencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_vistaAtencionActionPerformed
        // TODO add your handling code here:
        Nivel2 nivel2 = new Nivel2();
        
        if (!ventanas_abiertas.contains("nivel2")) {
            ventanas_abiertas.add("nivel2");
            nivel2.setVisible(true);
        }
    }//GEN-LAST:event_boton_vistaAtencionActionPerformed

    private void boton_listaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_listaUsuarioActionPerformed
        // TODO add your handling code here:
        ListaUsuarios listaU = new ListaUsuarios();
        
        if (!ventanas_abiertas.contains("listaU")) {
            ventanas_abiertas.add("listaU");
            listaU.setVisible(true);
        }
        
    }//GEN-LAST:event_boton_listaUsuarioActionPerformed

    private void boton_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_stockActionPerformed
        // TODO add your handling code here:
        Stock stock = new Stock();
        
        if (!ventanas_abiertas.contains("stock")) {
            ventanas_abiertas.add("stock");
            stock.setVisible(true);
        }
        
    }//GEN-LAST:event_boton_stockActionPerformed

    private void boton_agregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_agregarProductoActionPerformed
        // TODO add your handling code here:
        AgregarProducto agregar = new AgregarProducto();
        
        if (!ventanas_abiertas.contains("agregar")) {
            ventanas_abiertas.add("agregar");
            agregar.setVisible(true);
        }
        
    }//GEN-LAST:event_boton_agregarProductoActionPerformed

    private void footer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footer1MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Por soporte tecnico comuniquese al e-mail: soporte@lachucha.com.ar");
    }//GEN-LAST:event_footer1MouseClicked

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_agregarProducto;
    private javax.swing.JButton boton_agregarUsuario;
    private javax.swing.JButton boton_listaUsuario;
    private javax.swing.JButton boton_stock;
    private javax.swing.JButton boton_vistaAtencion;
    private javax.swing.JButton boton_vistaVendedor;
    private javax.swing.JLabel footer1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_wallpaper;
    // End of variables declaration//GEN-END:variables
}
