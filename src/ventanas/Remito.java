package ventanas;

import java.sql.*;
import clases.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static ventanas.ListaRemitos.ventanas_remitos;
import static ventanas.Stock.ventanas_stock;

public class Remito extends javax.swing.JFrame {

    String user, user_nivel, estado0;
    int remito_update;
    public static int id_producto_update;
    DefaultTableModel model = new DefaultTableModel() {

        boolean ColumnasEditables[] = {false, false, false, false, true};

        @Override
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return ColumnasEditables[vColIndex];
        }

        Class tipo[] = new Class[]{java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class};

        @Override
        public Class getColumnClass(int columnIndex) {
            return tipo[columnIndex];
        }
    };

    public Remito() {
        initComponents();

        user = Login.user;
        user_nivel = Login.user_nivel;
        remito_update = ListaRemitos.remito_update;
        estado0 = ListaRemitos.estado0;

        setSize(790, 800);
        setResizable(false);
        setTitle("Remito #" + remito_update + " - Sesion de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaper_principal.jpg");
        Icon icono;
        icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icono);
        this.repaint();

        label_titulo.setText("Remito #" + remito_update);

        //permisos por nivel
        //admin
        if (user_nivel.equals("Administrador")) {
            tf_nombre_cliente.setEditable(true);
            tf_direc_cliente.setEditable(true);
            tf_cargado_por.setEditable(true);
            tf_envio.setEditable(true);
            tf_tomado_por.setEditable(true);
        }

        //nivel 1
        if (user_nivel.equals("1")) {
            ta_comentario_entrega.setEditable(false);
            boton_fin.setVisible(false);
            box_estado.setEnabled(false);
        }

        //nivel 2
        if (user_nivel.equals("2")) {
            boton_imprimir.setVisible(false);
            if (estado0.equals("Entregado") || estado0.equals("Entregado - Incompleto") || estado0.equals("Cancelado")) {
                boton_fin.setVisible(false);
            }
        }

        //tabla remito
        tabla_productos = new JTable(model);
        tabla_productos.setModel(model);
        jScrollPane1.setViewportView(tabla_productos);

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn(" ");
        model.addColumn("Check");

        //diseño tabla
        diseñoTabla(tabla_productos);

        //cargo datos a la tabla
        String query = "select * from remitos where id_remito = '" + remito_update + "'";
        cargarDatosTabla(tabla_productos, query);

        //doy funciones a la tabla
        obtenerDatosDeTabla(tabla_productos);
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
        tf_envio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        boton_imprimir = new javax.swing.JButton();
        boton_fin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tf_nombre_cliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_direc_cliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_tomado_por = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tf_total = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ta_comentario_venta = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        ta_comentario_entrega = new javax.swing.JTextPane();
        tf_cargado_por = new javax.swing.JTextField();
        tf_fecha_actualizacion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tf_fecha_creado = new javax.swing.JTextField();
        box_estado = new javax.swing.JComboBox<>();
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
        label_titulo.setText("Remito");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, 40));

        tf_envio.setEditable(false);
        tf_envio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_envio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_envio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 100, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Comentario del vendedor:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        boton_imprimir.setBackground(new java.awt.Color(0, 153, 153));
        boton_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        boton_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(boton_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 580, 100, 80));

        boton_fin.setBackground(new java.awt.Color(0, 153, 153));
        boton_fin.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        boton_fin.setForeground(new java.awt.Color(255, 255, 255));
        boton_fin.setText("FIN");
        boton_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_finActionPerformed(evt);
            }
        });
        getContentPane().add(boton_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 580, 100, 80));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_productos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 740, 240));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre del cliente:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        tf_nombre_cliente.setEditable(false);
        tf_nombre_cliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_nombre_cliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_nombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 250, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Direccion del cliente:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        tf_direc_cliente.setEditable(false);
        tf_direc_cliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_direc_cliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_direc_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 530, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Envio a domicilio:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cargado por:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Comentario de la entrega:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tomado por:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        tf_tomado_por.setEditable(false);
        tf_tomado_por.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_tomado_por.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_tomado_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 250, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Estado:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, -1, -1));

        tf_total.setEditable(false);
        tf_total.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tf_total.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 520, 150, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Total: $");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, -1, 30));

        ta_comentario_venta.setEditable(false);
        ta_comentario_venta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane4.setViewportView(ta_comentario_venta);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 430, 40));

        ta_comentario_entrega.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane5.setViewportView(ta_comentario_entrega);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 430, 40));

        tf_cargado_por.setEditable(false);
        tf_cargado_por.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_cargado_por.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_cargado_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 250, -1));

        tf_fecha_actualizacion.setEditable(false);
        tf_fecha_actualizacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_fecha_actualizacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_fecha_actualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 250, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Ultima actualizacion:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Creado el:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        tf_fecha_creado.setEditable(false);
        tf_fecha_creado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_fecha_creado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_fecha_creado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 250, -1));

        box_estado.setBackground(new java.awt.Color(0, 153, 153));
        box_estado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        box_estado.setForeground(new java.awt.Color(255, 255, 255));
        box_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "En preparacion", "Listo", "Listo - Incompleto", "Entregado", "Entregado - Incompleto", "Cancelado" }));
        box_estado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(box_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 140, -1));

        footer.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        footer.setText("Creado por Cosme Fulanito C.O.");
        footer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footerMouseClicked(evt);
            }
        });
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 720, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 790, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_imprimirActionPerformed
        // TODO add your handling code here:
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Remito #" + remito_update + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/bannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("\n\nRemito #" + remito_update + " \n \n");
            parrafo.setFont(FontFactory.getFont("Arial", 22, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from remitos where id_remito = '" + remito_update + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    Paragraph parrafo1 = new Paragraph();
                    parrafo1.setAlignment(Paragraph.ALIGN_LEFT);
                    parrafo1.add("Nombre del cliente: " + rs.getString("nombre_cliente") + "\n \n"
                            + "Direccion del cliente: " + rs.getString("direccion_cliente") + "\n \n"
                            + "Envio a domicilio: " + rs.getString("envio") + "\n \n"
                            + "Cargado por: " + rs.getString("cargado_por") + "\n \n"
                            + "Comentario del vendedor: " + rs.getString("comentario_venta") + "\n \n"
                            + "Tomado por: " + rs.getString("tomado_por") + "\n \n"
                            + "Comentario de la entrega: " + rs.getString("comentario_entrega") + "\n \n");
                    parrafo1.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.DARK_GRAY));

                    documento.add(parrafo1);
                }
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error cargar remito en pdf " + e);
            }

            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo2.add("Compra \n \n");
            parrafo2.setFont(FontFactory.getFont("Arial", 22, Font.BOLD, BaseColor.DARK_GRAY));

            documento.add(parrafo2);

            PdfPTable tablaRemito = new PdfPTable(5);

            tablaRemito.addCell("Codigo");
            tablaRemito.addCell("Nombre");
            tablaRemito.addCell("Cantidad");
            tablaRemito.addCell("");
            tablaRemito.addCell("Check");

            int a = tabla_productos.getRowCount();
            for (int i = 0; i < a; i++) {
                for (int j = 0; j <= 4; j++) {
                    if (j != 4) {
                        tablaRemito.addCell((String) tabla_productos.getValueAt(i, j));
                    } else {
                        if (tabla_productos.getValueAt(i, j).equals(true)) {
                            tablaRemito.addCell("OK");
                        } else {
                            tablaRemito.addCell("X");
                        }
                    }
                }
            }

            documento.add(tablaRemito);

            Paragraph parrafo3 = new Paragraph();
            parrafo3.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo3.add("\n \n Total: $" + tf_total.getText());
            parrafo3.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.DARK_GRAY));

            documento.add(parrafo3);

            documento.close();
            JOptionPane.showMessageDialog(null, "Remito creado en PDF en el escritorio");
        } catch (DocumentException | IOException e) {
            System.err.println("Error, PDF");
            JOptionPane.showMessageDialog(null, "Error al generar pdf");
        }
    }//GEN-LAST:event_boton_imprimirActionPerformed

    private void boton_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_finActionPerformed
        // TODO add your handling code here:
        String comentario_entrega, estado, check = "", nombre, direccion, envio, cargado, tomado, fecha;
        int n = 0, confirm;
        boolean b = false, b1 = false, enviar = true;

        nombre = tf_nombre_cliente.getText();
        direccion = tf_direc_cliente.getText();
        envio = tf_envio.getText();
        cargado = tf_cargado_por.getText();
        tomado = tf_cargado_por.getText();
        comentario_entrega = ta_comentario_entrega.getText();
        estado = (String) box_estado.getSelectedItem();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        fecha = formato.format(LocalDateTime.now());

        tabla_productos.getRowSorter().toggleSortOrder(0);

        n = tabla_productos.getRowCount();
        for (int i = 0; i < n; i++) {
            if ((boolean) tabla_productos.getValueAt(i, 4)) {
                check += "t";
                b = true;
            } else {
                check += "f";
                b1 = true;
            }
        }

        //defino el estado
        if (!user_nivel.equals("Administrador")) {
            if (!estado.equals("Cancelado")) {
                confirm = JOptionPane.showConfirmDialog(null, "¿Se entrego la compra al cliente?", "Confirmar entrega", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (confirm == 0) {
                    if (!b) {
                        enviar = false;
                        JOptionPane.showMessageDialog(null, "No se marcado ningun elemento");
                    } else if (b1) {
                        estado = "Entregado - Incompleto";
                    } else {
                        estado = "Entregado";
                    }
                } else {
                    if (!b) {
                        estado = "En preparacion";
                    } else if (b1) {
                        estado = "Listo - Incompleto";
                    } else {
                        estado = "Listo";
                    }
                }
            }

            if (enviar) {
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("update remitos set tomado_por=?, comentario_entrega=?, estado=?, checks=?, fecha_actualizacion=? where id_remito = '" + remito_update + "'");

                    pst.setString(1, user);
                    pst.setString(2, comentario_entrega);
                    pst.setString(3, estado);
                    pst.setString(4, check);
                    pst.setString(5, fecha);

                    pst.executeUpdate();
                    cn.close();

                    boton_fin.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Actualizado");
                    this.dispose();
                } catch (SQLException e) {
                    System.err.println("Error al actualizar remito" + e);
                }
            }

        } else {
            if (enviar) {
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("update remitos set nombre_cliente=?, direccion_cliente=?, envio=?, cargado_por=?, tomado_por=?, comentario_entrega=?, estado=?, checks=?, fecha_actualizacion=? where id_remito = '" + remito_update + "'");

                    pst.setString(1, nombre);
                    pst.setString(2, direccion);
                    pst.setString(3, envio);
                    pst.setString(4, cargado);
                    pst.setString(5, tomado);
                    pst.setString(6, comentario_entrega);
                    pst.setString(7, estado);
                    pst.setString(8, check);
                    pst.setString(9, fecha);

                    pst.executeUpdate();
                    cn.close();

                    boton_fin.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Actualizado");
                    this.dispose();
                } catch (SQLException e) {
                    System.err.println("Error al actualizar remito" + e);
                }
            }
        }


    }//GEN-LAST:event_boton_finActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ventanas_remitos.remove(ventanas_remitos.indexOf(remito_update));
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
            java.util.logging.Logger.getLogger(Remito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Remito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Remito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Remito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Remito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_fin;
    private javax.swing.JButton boton_imprimir;
    private javax.swing.JComboBox<String> box_estado;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTextPane ta_comentario_entrega;
    private javax.swing.JTextPane ta_comentario_venta;
    private javax.swing.JTable tabla_productos;
    private javax.swing.JTextField tf_cargado_por;
    private javax.swing.JTextField tf_direc_cliente;
    private javax.swing.JTextField tf_envio;
    private javax.swing.JTextField tf_fecha_actualizacion;
    private javax.swing.JTextField tf_fecha_creado;
    private javax.swing.JTextField tf_nombre_cliente;
    private javax.swing.JTextField tf_tomado_por;
    private javax.swing.JTextField tf_total;
    // End of variables declaration//GEN-END:variables

    public void diseñoTabla(JTable tabla) {
        tabla.setFillsViewportHeight(true);

        TableRowSorter sorter = new TableRowSorter(model);
        tabla.setRowSorter(sorter);

        tabla_productos.getRowSorter().toggleSortOrder(0);

        int[] ancho = {40, 250, 40, 40, 40};
        for (int i = 0; i < 5; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
        }

        ((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);

        DefaultTableCellRenderer centerText = new DefaultTableCellRenderer();
        centerText.setHorizontalAlignment(CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(centerText);

        DefaultTableCellRenderer rightText = new DefaultTableCellRenderer();
        rightText.setHorizontalAlignment(RIGHT);
        tabla.getColumnModel().getColumn(2).setCellRenderer(rightText);
    }

    public void cargarDatosTabla(JTable tabla, String query) {
        int f = tabla.getRowCount();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                tf_nombre_cliente.setText(rs.getString("nombre_cliente"));
                tf_direc_cliente.setText(rs.getString("direccion_cliente"));
                tf_envio.setText(rs.getString("envio"));
                tf_cargado_por.setText(rs.getString("cargado_por"));
                tf_tomado_por.setText(rs.getString("tomado_por"));
                tf_fecha_creado.setText(rs.getString("fecha_creado"));
                tf_fecha_actualizacion.setText(rs.getString("fecha_actualizacion"));
                ta_comentario_venta.setText(rs.getString("comentario_venta"));
                ta_comentario_entrega.setText(rs.getString("comentario_entrega"));
                tf_total.setText(rs.getString("total"));

                box_estado.setSelectedItem(rs.getString("estado"));

                //consigo los codigos
                String codigos = rs.getString("id_productos");
                ObetenerCodigos(codigos);

                //consigo cantidades
                String cantidades = rs.getString("cantidades");
                ObtenerCantidades(cantidades);

                //congigo nombre y unidad
                for (int i = 0; i < f; i++) {
                    String codigo = (String) tabla.getValueAt(i, 0);
                    ObtenerInfo(codigo, i);
                }

                //verifico check
                String check = rs.getString("checks");
                int k = 0;
                while (k != f) {
                    if (check.substring(k, k + 1).equals("t")) {
                        tabla.setValueAt(true, k, 4);
                    } else {
                        tabla.setValueAt(false, k, 4);
                    }
                    k++;
                }
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error cargar remito " + e);
            JOptionPane.showMessageDialog(null, "Eror al cargar, contacte al administrador");
        }
    }

    public void obtenerDatosDeTabla(JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.convertRowIndexToModel(tabla.getSelectedRow());

                if (fila_point > -1) {
                    id_producto_update = Integer.parseInt(model.getValueAt(fila_point, 0).toString());
                }
                if (!ventanas_stock.contains(id_producto_update)) {
                    ventanas_stock.add(id_producto_update);
                    FichaProducto ficha = new FichaProducto();
                    ficha.setVisible(true);
                }
            }
        });
    }

    public void ObetenerCodigos(String codigos) {

        String codigo = "", a;
        int b;
        b = codigos.length();

        while (b != 0) {
            a = codigos.substring(0, 1);
            if (!a.equals(",")) {
                codigo += a;
            } else {
                Object[] fila = new Object[5];

                fila[0] = codigo;
                fila[1] = "";
                fila[2] = "";
                fila[3] = "";
                fila[4] = false;

                model.addRow(fila);
                codigo = "";
            }
            codigos = codigos.substring(1, b);
            b--;
        }
        //consigo el ultimo codigo
        Object[] fila = new Object[5];

        fila[0] = codigo;
        fila[1] = "";
        fila[2] = "";
        fila[3] = "";
        fila[4] = false;

        model.addRow(fila);
    }

    public void ObtenerCantidades(String cantidades) {
        String cantidad = "", a;
        int b, f = 0;

        b = cantidades.length();

        while (b != 0) {
            a = cantidades.substring(0, 1);
            if (!a.equals(",")) {
                cantidad += a;
            } else {
                tabla_productos.setValueAt(cantidad, f, 2);
                cantidad = "";
                f++;
            }
            cantidades = cantidades.substring(1, b);
            b--;
        }

        //consigo la ultima cantidad
        tabla_productos.setValueAt(cantidad, f, 2);
    }

    public void ObtenerInfo(String codigo, int f) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre_producto, unidad_venta from productos where id_producto = '" + codigo + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                tabla_productos.setValueAt(rs.getString("nombre_producto"), f, 1);
                tabla_productos.setValueAt(rs.getString("unidad_venta"), f, 3);
            }

            cn.close();
        } catch (SQLException e) {
            System.err.println("Error cargar informacion del producto " + e);
        }
    }
}
