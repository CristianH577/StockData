package ventanas;

import java.sql.*;
import clases.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

public class ListaRemitos extends javax.swing.JFrame {

    String user;
    public static int remito_update;
    public static String estado0;
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }
    };
    public static ArrayList ventanas_remitos = new ArrayList();

    public ListaRemitos() {
        initComponents();

        user = Login.user;

        setSize(900, 600);
        setResizable(false);
        setTitle("Lista de remitos - Sesion de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaper_principal.jpg");
        Icon icono;
        icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icono);
        this.repaint();

        //tabla remitos
        tabla_remitos = new JTable(model);
        jScrollPane1.setViewportView(tabla_remitos);

        model.addColumn("ID");
        model.addColumn("Nombre del cliente");
        model.addColumn("Envio");
        model.addColumn("Estado");
        model.addColumn("Cargado por");
        model.addColumn("Creado el");
        model.addColumn("Tomado por");
        model.addColumn("Ultima actualizacion");

        //diseño tabla
        diseñoTabla(tabla_remitos);

        //cargo datos a la tabla
        String query = "select id_remito, nombre_cliente, envio, estado, cargado_por, fecha_creado, tomado_por, fecha_actualizacion from remitos";
        cargarDatosTabla(tabla_remitos, query);

        //doy funciones a la tabla
        obtenerDatosDeTabla(tabla_remitos);

        cargarListas();

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_remitos = new javax.swing.JTable();
        box_envio = new javax.swing.JComboBox<>();
        box_estado = new javax.swing.JComboBox<>();
        boton_imprimir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        boton_actualizar1 = new javax.swing.JButton();
        box_tomado = new javax.swing.JComboBox<>();
        box_cargado = new javax.swing.JComboBox<>();
        boton_eliminar = new javax.swing.JButton();
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
        label_titulo.setText("Lista de Remitos");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 20, -1, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_remitos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_remitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre del cliente", "Envio a domicilio", "Estado", "Tomado por", "Cargado por"
            }
        ));
        jScrollPane1.setViewportView(tabla_remitos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 840, 260));

        box_envio.setBackground(new java.awt.Color(0, 153, 153));
        box_envio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        box_envio.setForeground(new java.awt.Color(255, 255, 255));
        box_envio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "NO", "SI" }));
        box_envio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box_envio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                box_envioItemStateChanged(evt);
            }
        });
        getContentPane().add(box_envio, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, -1, -1));

        box_estado.setBackground(new java.awt.Color(0, 153, 153));
        box_estado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        box_estado.setForeground(new java.awt.Color(255, 255, 255));
        box_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Nuevo", "En preparacion", "Listo", "Listo - Incompleto", "Entregado", "Entregado - Incompleto", "Cancelado" }));
        box_estado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box_estado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                box_estadoItemStateChanged(evt);
            }
        });
        getContentPane().add(box_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 80, -1, -1));

        boton_imprimir.setBackground(new java.awt.Color(0, 153, 153));
        boton_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        boton_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(boton_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, 100, 80));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cargado por:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Filtros:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Envio a domicilio:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estado:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tomado por:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        boton_actualizar1.setBackground(new java.awt.Color(0, 153, 153));
        boton_actualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        boton_actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizar1ActionPerformed(evt);
            }
        });
        getContentPane().add(boton_actualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 40, 40));

        box_tomado.setBackground(new java.awt.Color(0, 153, 153));
        box_tomado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        box_tomado.setForeground(new java.awt.Color(255, 255, 255));
        box_tomado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo" }));
        box_tomado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box_tomado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                box_tomadoItemStateChanged(evt);
            }
        });
        getContentPane().add(box_tomado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 200, -1));

        box_cargado.setBackground(new java.awt.Color(0, 153, 153));
        box_cargado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        box_cargado.setForeground(new java.awt.Color(255, 255, 255));
        box_cargado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo" }));
        box_cargado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box_cargado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                box_cargadoItemStateChanged(evt);
            }
        });
        getContentPane().add(box_cargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 200, -1));

        boton_eliminar.setBackground(new java.awt.Color(0, 153, 153));
        boton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        boton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 40, 40));

        footer.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        footer.setText("Creado por Cosme Fulanito C.O.");
        footer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footerMouseClicked(evt);
            }
        });
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 510, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_imprimirActionPerformed
        // TODO add your handling code here:
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Lista de remitos.pdf"));

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Lista de remitos \n \n");
            parrafo.setFont(FontFactory.getFont("Arial", 22, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(parrafo);

            PdfPTable listaRemitos = new PdfPTable(8);

            listaRemitos.addCell("ID");
            listaRemitos.addCell("Nombre del cliente");
            listaRemitos.addCell("Envio a domicilio");
            listaRemitos.addCell("Estado");
            listaRemitos.addCell("Cargado por");
            listaRemitos.addCell("Creado el");
            listaRemitos.addCell("Tomado por");
            listaRemitos.addCell("Ultima actualizacion");

            int f = tabla_remitos.getRowCount(), c = tabla_remitos.getColumnCount();
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    listaRemitos.addCell(tabla_remitos.getValueAt(i, j).toString());
                }
            }
            documento.add(listaRemitos);

            documento.close();
            JOptionPane.showMessageDialog(null, "Lista creada en PDF en el escritorio");
        } catch (DocumentException | IOException e) {
            System.err.println("Error, PDF");
            JOptionPane.showMessageDialog(null, "Error al generar pdf");
        }
    }//GEN-LAST:event_boton_imprimirActionPerformed

    private void box_estadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_box_estadoItemStateChanged
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_box_estadoItemStateChanged

    private void box_envioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_box_envioItemStateChanged
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_box_envioItemStateChanged

    private void boton_actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizar1ActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        String query = "select id_remito, nombre_cliente, envio, estado, cargado_por, fecha_creado, tomado_por, fecha_actualizacion from remitos";
        cargarDatosTabla(tabla_remitos, query);
    }//GEN-LAST:event_boton_actualizar1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ventanas_abiertas.remove(ventanas_abiertas.indexOf("listaR"));
    }//GEN-LAST:event_formWindowClosed

    private void box_tomadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_box_tomadoItemStateChanged
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_box_tomadoItemStateChanged

    private void box_cargadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_box_cargadoItemStateChanged
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_box_cargadoItemStateChanged

    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed
        // TODO add your handling code here:
        int[] eliminar = tabla_remitos.getSelectedRows();
        int k = eliminar.length;

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Eliminar remitos seleccionados?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirmar == 0) {
            try {
                Connection cn = Conexion.conectar();

                for (int i = 0; i < k; i++) {
                    PreparedStatement pst = cn.prepareStatement("DELETE from remitos where id_remito = '" + tabla_remitos.getValueAt(eliminar[i], 0) + "'");
                    pst.executeUpdate();
                }

                cn.close();

                JOptionPane.showMessageDialog(null, "Remito/s eliminado/s");
            } catch (SQLException e) {
                System.err.println("Error al eliminar remito/s" + e);
                JOptionPane.showMessageDialog(null, "Error al remito/s, contacte al administrador");
            }
        }
    }//GEN-LAST:event_boton_eliminarActionPerformed

    private void footerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footerMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Por soporte tecnico comuniquese al e-mail: soporte@lachucha.com.ar");
    }//GEN-LAST:event_footerMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaRemitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaRemitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaRemitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaRemitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaRemitos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_actualizar1;
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JButton boton_imprimir;
    private javax.swing.JComboBox<String> box_cargado;
    private javax.swing.JComboBox<String> box_envio;
    private javax.swing.JComboBox<String> box_estado;
    private javax.swing.JComboBox<String> box_tomado;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTable tabla_remitos;
    // End of variables declaration//GEN-END:variables

    public void diseñoTabla(JTable tabla) {
        tabla.setFillsViewportHeight(true);

        TableRowSorter sorter = new TableRowSorter(model);
        tabla.setRowSorter(sorter);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(20);

        for (int i = 0; i < tabla.getColumnCount(); i++) {

            DefaultTableCellRenderer centerText = new DefaultTableCellRenderer();
            centerText.setHorizontalAlignment(CENTER);
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerText);
        }

        ((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);

    }

    public void cargarDatosTabla(JTable tabla, String query) {
        int c = tabla.getColumnCount();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[c];

                for (int i = 0; i < c; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar tabla" + e);
            JOptionPane.showMessageDialog(null, "Eror al mostrar informacion, contacte al administrador");
        }
    }

    public void obtenerDatosDeTabla(JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.convertRowIndexToModel(tabla.getSelectedRow());

                if (fila_point > -1) {
                    remito_update = (Integer) model.getValueAt(fila_point, 0);
                    estado0 = (String) model.getValueAt(fila_point, 3);
                }
                if (!ventanas_remitos.contains(remito_update)) {
                    ventanas_remitos.add(remito_update);
                    Remito remito = new Remito();
                    remito.setVisible(true);
                }
            }
        });
    }

    public void cargarListas() {
        ArrayList tomado = new ArrayList();
        ArrayList cargado = new ArrayList();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select username from usuarios where nivel = '2' or nivel = 'Administrador'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                tomado.add(rs.getString("username"));
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar lista tomado por" + e);
            JOptionPane.showMessageDialog(null, "Eror al mostrar informacion, contacte al administrador");
        }

        Collections.sort(tomado);
        for (int i = 0; i < tomado.size(); i++) {
            box_tomado.addItem((String) tomado.get(i));
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select username from usuarios where nivel = '1' or nivel = 'Administrador'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                cargado.add(rs.getString("username"));
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar lista tomado por" + e);
            JOptionPane.showMessageDialog(null, "Eror al mostrar informacion, contacte al administrador");
        }

        Collections.sort(cargado);
        for (int i = 0; i < cargado.size(); i++) {
            box_cargado.addItem((String) cargado.get(i));
        }
    }

    public void filtro() {

        String tomado, cargado, estado, envio;

        tomado = box_tomado.getSelectedItem().toString();
        cargado = box_cargado.getSelectedItem().toString();
        envio = box_envio.getSelectedItem().toString();
        estado = box_estado.getSelectedItem().toString();

        LinkedList listaFiltros = new LinkedList();
        if (!envio.equals("Todo")) {
            listaFiltros.add(RowFilter.regexFilter(envio, 2));
        }
        if (!estado.equals("Todo")) {
            listaFiltros.add(RowFilter.regexFilter(estado, 3));
        }
        if (!cargado.equals("Todo")) {
            listaFiltros.add(RowFilter.regexFilter(cargado, 4));
        }
        if (!tomado.equals("Todo")) {
            listaFiltros.add(RowFilter.regexFilter(tomado, 6));
        }

        RowFilter filtroAnd = RowFilter.andFilter(listaFiltros);

        TableRowSorter sorter = new TableRowSorter(model);
        sorter.setRowFilter(RowFilter.andFilter(listaFiltros));
        tabla_remitos.setRowSorter(sorter);
    }
}
