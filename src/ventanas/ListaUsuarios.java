package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static ventanas.Administrador.ventanas_abiertas;

public class ListaUsuarios extends javax.swing.JFrame {

    String user;
    public static String user_update = "";
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }
    };
    public static ArrayList ventanas_usuarios = new ArrayList();

    public ListaUsuarios() {
        initComponents();

        user = Login.user;

        setSize(700, 600);
        setResizable(false);
        setTitle("Lista de usuarios - Sesion de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaper_principal.jpg");
        Icon icono;
        icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icono);
        this.repaint();

        //creo tabla
        tabla_usuarios = new JTable(model);
        jScrollPane1.setViewportView(tabla_usuarios);

        model.addColumn(" ");
        model.addColumn("Nombre");
        model.addColumn("Username");
        model.addColumn("Nivel");
        model.addColumn("Estatus");

        //diseño tabla
        diseñoTabla(tabla_usuarios);

        //cargo datos a la tabla
        int c = tabla_usuarios.getColumnCount();
        String query = "select id_usuario, nombre_usuario, username, nivel, estatus from usuarios";
        cargarDatosTabla(c, query);

        //doy funciones a la tabla
        obtenerDatosDeTabla(tabla_usuarios);
    }

    //icono
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_titulo = new javax.swing.JLabel();
        boton_agregarUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usuarios = new javax.swing.JTable();
        box_nivel = new javax.swing.JComboBox<>();
        box_estatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boton_actualizar = new javax.swing.JButton();
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
        label_titulo.setText("Lista de usuarios");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, 40));

        boton_agregarUsuario.setBackground(new java.awt.Color(0, 153, 153));
        boton_agregarUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_agregarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        boton_agregarUsuario.setText("Agregar usuario");
        boton_agregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agregarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(boton_agregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 200, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_usuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_usuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 650, 320));

        box_nivel.setBackground(new java.awt.Color(0, 153, 153));
        box_nivel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        box_nivel.setForeground(new java.awt.Color(255, 255, 255));
        box_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Administrador", "1", "2" }));
        box_nivel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box_nivel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                box_nivelItemStateChanged(evt);
            }
        });
        getContentPane().add(box_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        box_estatus.setBackground(new java.awt.Color(0, 153, 153));
        box_estatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        box_estatus.setForeground(new java.awt.Color(255, 255, 255));
        box_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Activo", "Inactivo" }));
        box_estatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box_estatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                box_estatusItemStateChanged(evt);
            }
        });
        getContentPane().add(box_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estatus:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nivel:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        boton_actualizar.setBackground(new java.awt.Color(0, 153, 153));
        boton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 40, 40));

        footer.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        footer.setText("Creado por Cosme Fulanito C.O.");
        footer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footerMouseClicked(evt);
            }
        });
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

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

    private void box_nivelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_box_nivelItemStateChanged
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_box_nivelItemStateChanged

    private void box_estatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_box_estatusItemStateChanged
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_box_estatusItemStateChanged

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        int c = tabla_usuarios.getColumnCount();
        String query = "select id_usuario, nombre_usuario, username, nivel, estatus from usuarios";
        cargarDatosTabla(c, query);
    }//GEN-LAST:event_boton_actualizarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ventanas_abiertas.remove(ventanas_abiertas.indexOf("listaU"));
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_actualizar;
    private javax.swing.JButton boton_agregarUsuario;
    private javax.swing.JComboBox<String> box_estatus;
    private javax.swing.JComboBox<String> box_nivel;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTable tabla_usuarios;
    // End of variables declaration//GEN-END:variables

    public void diseñoTabla(JTable tabla) {
        tabla.setFillsViewportHeight(true);

        TableRowSorter sorter = new TableRowSorter(model);
        tabla.setRowSorter(sorter);

        int[] ancho = {20, 180, 180, 60, 40};
        for (int i = 0; i < 5; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
        }

        ((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer())
                       .setHorizontalAlignment(CENTER);
        
        DefaultTableCellRenderer centerText = new DefaultTableCellRenderer();
        centerText.setHorizontalAlignment(CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(centerText);
        tabla.getColumnModel().getColumn(3).setCellRenderer(centerText);
        tabla.getColumnModel().getColumn(4).setCellRenderer(centerText);
    }
    
    public void cargarDatosTabla(int c, String query){
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[c];

                for (int i = 1; i <= c; i++) {
                    fila[i-1] = rs.getObject(i);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar tabla" + e);
            JOptionPane.showMessageDialog(null, "Eror, contacte al administrador");
        }
    }
    
    public void filtro(){
        
        String nivel = box_nivel.getSelectedItem().toString(), estatus = box_estatus.getSelectedItem().toString();
        
        LinkedList listaFiltros = new LinkedList();
        if (!nivel.equals("Todo")) {
            listaFiltros.add(RowFilter.regexFilter(nivel, 3));
        }
        if (!estatus.equals("Todo")) {
            listaFiltros.add(RowFilter.regexFilter(estatus, 4));
        }
        
        RowFilter filtroAnd = RowFilter.andFilter(listaFiltros);
        
        TableRowSorter sorter = new TableRowSorter(model);
        sorter.setRowFilter(RowFilter.andFilter(listaFiltros));
        tabla_usuarios.setRowSorter(sorter);
    }
    
    public void obtenerDatosDeTabla(JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.convertRowIndexToModel(tabla.getSelectedRow());
                int columna_point = 2;

                if (fila_point > -1) {
                    user_update = (String) model.getValueAt(fila_point, columna_point);
                }
                if (!ventanas_usuarios.contains(user_update)) {
                    ventanas_usuarios.add(user_update);
                    InformacionUsuario info_user = new InformacionUsuario();
                    info_user.setVisible(true);
                }
            }
        });
    }
}
