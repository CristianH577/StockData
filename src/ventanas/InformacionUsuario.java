package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static ventanas.ListaUsuarios.ventanas_usuarios;

public class InformacionUsuario extends javax.swing.JFrame {

    String user = "", user_update = "";
    int id;

    public InformacionUsuario() {
        initComponents();

        user = Login.user;
        user_update = ListaUsuarios.user_update;

        setSize(550, 450);
        setResizable(false);
        setTitle("Informacion de usuario - Sesion de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaper_principal.jpg");
        Icon icono;
        icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icono);
        this.repaint();

        label_titulo.setText("Informacion de: " + user_update);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from usuarios where username = '" + user_update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_usuario");

                tf_nombre.setText(rs.getString("nombre_usuario"));
                tf_telefono.setText(rs.getString("telefono"));
                tf_username.setText(rs.getString("username"));
                tf_registradoPor.setText(rs.getString("registro"));

                box_nivel.setSelectedItem(rs.getString("nivel"));
                box_estatus.setSelectedItem(rs.getString("estatus"));
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error cargar usuario " + e);
            JOptionPane.showMessageDialog(null, "Eror al cargar, contacte al administrador");
        }
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
        tf_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_telefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_registradoPor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        boton_actualizar = new javax.swing.JButton();
        boton_restaurar = new javax.swing.JButton();
        box_estatus = new javax.swing.JComboBox<>();
        box_nivel = new javax.swing.JComboBox<>();
        boton_eliminarProducto = new javax.swing.JButton();
        footer = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_titulo.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        label_titulo.setForeground(new java.awt.Color(255, 255, 255));
        label_titulo.setText("Informacion de: ");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 40));

        tf_nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 200, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        tf_telefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        tf_username.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 200, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        tf_registradoPor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_registradoPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_registradoPor.setEnabled(false);
        getContentPane().add(tf_registradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 200, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Registrado por:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nivel:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Estatus:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        boton_actualizar.setBackground(new java.awt.Color(0, 153, 153));
        boton_actualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        boton_actualizar.setText("Actualizar");
        boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 120, 40));

        boton_restaurar.setBackground(new java.awt.Color(0, 153, 153));
        boton_restaurar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_restaurar.setForeground(new java.awt.Color(255, 255, 255));
        boton_restaurar.setText("Restaurar password");
        boton_restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_restaurarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_restaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 200, 40));

        box_estatus.setBackground(new java.awt.Color(0, 153, 153));
        box_estatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        box_estatus.setForeground(new java.awt.Color(255, 255, 255));
        box_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        box_estatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(box_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 120, 22));

        box_nivel.setBackground(new java.awt.Color(0, 153, 153));
        box_nivel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        box_nivel.setForeground(new java.awt.Color(255, 255, 255));
        box_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "1", "2" }));
        box_nivel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(box_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 120, 22));

        boton_eliminarProducto.setBackground(new java.awt.Color(0, 153, 153));
        boton_eliminarProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_eliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        boton_eliminarProducto.setText("Eliminar");
        boton_eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(boton_eliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 120, 40));

        footer.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        footer.setText("Creado por Cosme Fulanito C.O.");
        footer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footerMouseClicked(evt);
            }
        });
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        // TODO add your handling code here:
        int validacion = 0;
        String nombre, telefono, username, pass, nivel, estatus;

        username = tf_username.getText().trim();
        nombre = tf_nombre.getText().trim();
        telefono = tf_telefono.getText().trim();
        nivel = (String) box_nivel.getSelectedItem();
        estatus = (String) box_estatus.getSelectedItem();

        if (username.equals("")) {
            tf_username.setBackground(Color.red);
            validacion++;
        } else {
            tf_username.setBackground(Color.white);
        }

        if (nombre.equals("")) {
            tf_nombre.setBackground(Color.red);
            validacion++;
        } else {
            tf_nombre.setBackground(Color.white);
        }

        if (telefono.equals("")) {
            tf_telefono.setBackground(Color.red);
            validacion++;
        } else {
            tf_telefono.setBackground(Color.white);
        }


        if (validacion == 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select username from usuarios where username = '" + username + "' and not id_usuario = '" + id + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    tf_username.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible");
                    cn.close();
                } else {
                    Connection cn1 = Conexion.conectar();
                    PreparedStatement pst1 = cn1.prepareStatement("update usuarios set nombre_usuario=?, telefono=?, username=?, nivel=?, estatus=? where id_usuario = '" + id + "'");

                    pst1.setString(1, nombre);
                    pst1.setString(2, telefono);
                    pst1.setString(3, username);
                    pst1.setString(4, nivel);
                    pst1.setString(5, estatus);

                    pst1.executeUpdate();
                    cn1.close();

                    JOptionPane.showMessageDialog(null, "Modificacion correcta");
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar" + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_boton_actualizarActionPerformed

    private void boton_restaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_restaurarActionPerformed
        // TODO add your handling code here:
        RestaurarPassword restaurar = new RestaurarPassword();
        restaurar.setVisible(true);
    }//GEN-LAST:event_boton_restaurarActionPerformed

    private void boton_eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarProductoActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("DELETE from usuarios where id_usuario = '" + user_update + "'");

            pst.executeUpdate();
            cn.close();

            JOptionPane.showMessageDialog(null, "Usuario eliminado");
            this.dispose();
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario " + e);
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario, contacte al administrador");
        }
    }//GEN-LAST:event_boton_eliminarProductoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ventanas_usuarios.remove(ventanas_usuarios.indexOf(user_update));
    }//GEN-LAST:event_formWindowClosed

    private void footerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footerMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Por soporte tecnico comuniquese al e-mail: soporte@lachucha.com.ar");
    }//GEN-LAST:event_footerMouseClicked

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
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_actualizar;
    private javax.swing.JButton boton_eliminarProducto;
    private javax.swing.JButton boton_restaurar;
    private javax.swing.JComboBox<String> box_estatus;
    private javax.swing.JComboBox<String> box_nivel;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_registradoPor;
    private javax.swing.JTextField tf_telefono;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
