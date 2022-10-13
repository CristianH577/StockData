package ventanas;

import java.sql.*;
import clases.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
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
import javax.swing.JTextArea;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import static ventanas.Administrador.ventanas_abiertas;
import static ventanas.Stock.ventanas_stock;

public class StockGaleria extends javax.swing.JFrame {

    String user, user_nivel;
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public Class getColumnClass(int column) {
            switch (column) {
                case 0:
                    return ImageIcon.class;
                default:
                    return String.class;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }
    };
    public static int id_producto_update = 0;

    public StockGaleria() {
        initComponents();

        user = Login.user;
        user_nivel = Login.user_nivel;

        setSize(1010, 850);
        setResizable(false);
        setTitle("Lista de Stock - Galeria - Sesion de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaper_principal.jpg");
        Icon icono;
        icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icono);
        this.repaint();

        if (!user_nivel.equals("Administrador")) {
            boton_agregar.setVisible(false);
        }

        //esconder boton imprimir para los nivel 2
        if (user_nivel.equals("2")) {
            boton_imprimir.setVisible(false);
            boton_imprimir_listaPrecios.setVisible(false);
        }

        //creo tabla
        tabla_stock = new JTable(model);
        jScrollPane1.setViewportView(tabla_stock);

        model.addColumn("");
        model.addColumn("Codigo");
        model.addColumn("Informacion");

        //diseño tabla
        diseñoTabla(tabla_stock);

        //cargar datos a la tabla
        int c = tabla_stock.getColumnCount();
        String query = "select direccion_imagen, id_producto, nombre_producto, medida, material, marca, precio_venta, unidad_venta, stock, unidad_stock, ult_actualizacion from productos";
        cargarDatosTabla(c, query);

        //doy funciones a la tabla
        obtenerDatosDeTabla(tabla_stock);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_agregar = new javax.swing.JButton();
        label_titulo = new javax.swing.JLabel();
        boton_imprimir = new javax.swing.JButton();
        boton_iralista = new javax.swing.JButton();
        boton_imprimir_listaPrecios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_stock = new javax.swing.JTable();
        boton_actualizar = new javax.swing.JButton();
        footer = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton_agregar.setBackground(new java.awt.Color(0, 153, 153));
        boton_agregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_agregar.setForeground(new java.awt.Color(255, 255, 255));
        boton_agregar.setText("Agregar producto");
        boton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, 200, 40));

        label_titulo.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        label_titulo.setForeground(new java.awt.Color(255, 255, 255));
        label_titulo.setText("Stock Galeria");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 20, -1, 40));

        boton_imprimir.setBackground(new java.awt.Color(0, 153, 153));
        boton_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        boton_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(boton_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 660, 100, 80));

        boton_iralista.setBackground(new java.awt.Color(0, 153, 153));
        boton_iralista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_iralista.setForeground(new java.awt.Color(255, 255, 255));
        boton_iralista.setText("Ir a Lista");
        boton_iralista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_iralistaActionPerformed(evt);
            }
        });
        getContentPane().add(boton_iralista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 200, 40));

        boton_imprimir_listaPrecios.setBackground(new java.awt.Color(0, 153, 153));
        boton_imprimir_listaPrecios.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_imprimir_listaPrecios.setForeground(new java.awt.Color(255, 255, 255));
        boton_imprimir_listaPrecios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora-chica.png"))); // NOI18N
        boton_imprimir_listaPrecios.setText("  Lista de precios");
        boton_imprimir_listaPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_imprimir_listaPreciosActionPerformed(evt);
            }
        });
        getContentPane().add(boton_imprimir_listaPrecios, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 660, 200, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_stock.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_stock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null},
                {"", null, null, null},
                {"", null, null, null},
                {"", null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_stock);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 960, 580));

        boton_actualizar.setBackground(new java.awt.Color(0, 153, 153));
        boton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 40, 40));

        footer.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        footer.setText("Creado por Cosme Fulanito C.O.");
        footer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footerMouseClicked(evt);
            }
        });
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 770, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_agregarActionPerformed
        // TODO add your handling code here:
        AgregarProducto agregar = new AgregarProducto();

        if (!ventanas_abiertas.contains("agregar")) {
            ventanas_abiertas.add("agregar");
            agregar.setVisible(true);
        }
    }//GEN-LAST:event_boton_agregarActionPerformed

    private void boton_iralistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_iralistaActionPerformed
        // TODO add your handling code here:
        Stock stock = new Stock();
        stock.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_iralistaActionPerformed

    private void boton_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_imprimirActionPerformed
        // TODO add your handling code here:
        Document documento = new Document();

        try {
            DateTimeFormatter ult = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/CatalogoStock " + ult.format(LocalDateTime.now()) + ".pdf"));

            DateTimeFormatter ult1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/bannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 30, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("\n\nCatalogo de Stock " + ult1.format(LocalDateTime.now()) + "\n \n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable stock = new PdfPTable(2);
            stock.setWidthPercentage(110);

            //titulos de tabla
            String titulos[] = {"", "Informacion"};

            PdfPCell colTitulo;
            for (int i = 0; i < 2; i++) {
                colTitulo = new PdfPCell(new Paragraph(titulos[i], FontFactory.getFont("Arial", 18, Font.BOLD)));
                colTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                stock.addCell(colTitulo);
            }

            //anchos de columnas
            int anchos[] = {250, 250};
            stock.setWidths(anchos);

            //datos tabla
            int f = tabla_stock.getRowCount();
            float a = 250, b = 250;//medidas de la imagen
            for (int i = 0; i < f; i++) {

                //imagen
                String id = (String) tabla_stock.getValueAt(i, 1);
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("select direccion_imagen from productos where id_producto = '" + id + "'");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(rs.getString("direccion_imagen"));
                        img.scaleAbsolute(a, b);
                        PdfPCell celdaImg = new PdfPCell(img);
                        celdaImg.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        celdaImg.setHorizontalAlignment(Element.ALIGN_CENTER);
                        stock.addCell(celdaImg);
                    }
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Error al tomar imagen" + e);
                }

                //info
                stock.addCell((String) tabla_stock.getValueAt(i, 2) + "\n\n*Codigo: " + id + "\n\n");
            }

            documento.add(stock);

            documento.close();
            JOptionPane.showMessageDialog(null, "Catalogo de stock creado en PDF en el escritorio");
        } catch (DocumentException | IOException e) {
            System.err.println("Error, PDF");
            JOptionPane.showMessageDialog(null, "Error al generar pdf");
        }
    }//GEN-LAST:event_boton_imprimirActionPerformed

    private void boton_imprimir_listaPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_imprimir_listaPreciosActionPerformed
        // TODO add your handling code here:
        Document documento = new Document();

        try {
            DateTimeFormatter ult = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Catalogo " + ult.format(LocalDateTime.now()) + ".pdf"));

            DateTimeFormatter ult1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/bannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 30, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("\n\nCatalogo " + ult1.format(LocalDateTime.now()) + "\n \n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable stock = new PdfPTable(2);
            stock.setWidthPercentage(110);

            //titulos de tabla
            String titulos[] = {"", "Informacion"};

            PdfPCell colTitulo;
            for (int i = 0; i < 2; i++) {
                colTitulo = new PdfPCell(new Paragraph(titulos[i], FontFactory.getFont("Arial", 18, Font.BOLD)));
                colTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                stock.addCell(colTitulo);
            }

            //anchos de columnas
            int anchos[] = {250, 250};
            stock.setWidths(anchos);

            //datos tabla
            tabla_stock.getRowSorter().toggleSortOrder(2);
            int f = tabla_stock.getRowCount();
            float a = 220, b = 220;//medidas de la imagen

            for (int i = 0; i < f; i++) {

                //imagen
                String id = (String) tabla_stock.getValueAt(i, 1);
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("select direccion_imagen, nombre_producto, medida, marca, precio_venta, unidad_venta, ult_actualizacion from productos where id_producto = '" + id + "'");
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(rs.getString("direccion_imagen"));
                        img.scaleAbsolute(a, b);
                        PdfPCell celdaImg = new PdfPCell(img);
                        celdaImg.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        celdaImg.setHorizontalAlignment(Element.ALIGN_CENTER);
                        stock.addCell(celdaImg);

                        //info
                        stock.addCell("\n\nNombre: " + rs.getString("nombre_producto") + "\n\nMedida/Tamaño: " + rs.getString("medida")+ "\n\nMarca: " + rs.getString("marca") + "\n\nPrecio: $" + rs.getString("precio_venta") + " x" + rs.getString("unidad_venta") + "\n\nUltima actualizacion: " + rs.getString("ult_actualizacion") + "\n\n*Codigo: " + id + "\n\n\n\n\n\n\n\n\n");
                    }
                    
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Error al tomar imagen" + e);
                }

            }

            documento.add(stock);

            documento.close();
            JOptionPane.showMessageDialog(null, "Catalogo creado en PDF en el escritorio");
        } catch (DocumentException | IOException e) {
            System.err.println("Error, PDF");
            JOptionPane.showMessageDialog(null, "Error al generar pdf");
        }
    }//GEN-LAST:event_boton_imprimir_listaPreciosActionPerformed

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        int c = tabla_stock.getColumnCount();
        String query = "select direccion_imagen, id_producto, nombre_producto, stock, unidad_stock, ult_actualizacion from productos";
        cargarDatosTabla(c, query);
    }//GEN-LAST:event_boton_actualizarActionPerformed

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
            java.util.logging.Logger.getLogger(StockGaleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockGaleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockGaleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockGaleria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockGaleria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_actualizar;
    private javax.swing.JButton boton_agregar;
    private javax.swing.JButton boton_imprimir;
    private javax.swing.JButton boton_imprimir_listaPrecios;
    private javax.swing.JButton boton_iralista;
    private javax.swing.JLabel footer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTable tabla_stock;
    // End of variables declaration//GEN-END:variables

    public void diseñoTabla(JTable tabla) {
        tabla.setFillsViewportHeight(true);

        TableRowSorter sorter = new TableRowSorter(model);
        tabla.setRowSorter(sorter);

        int[] ancho = {200, 100, 50};
        for (int i = 0; i < 3; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
        }

        ((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);

        //centro el texto de las celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(CENTER);
        for (int i = 1; i < 3; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        //cambio el tamaño de las celdas para mostrar las imagenes
        tabla.setRowHeight(350);
        tabla.setFont(new java.awt.Font("Arial", 1, 30));

        //formateo la columna para mostrar datos en forma de lista
        tabla.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
    }

    public void cargarDatosTabla(int c, String query) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                //cargo la imagen
                Object[] fila = new Object[c];
                String direccion_imagen;

                direccion_imagen = rs.getString("direccion_imagen");
                ImageIcon imagen = new ImageIcon(direccion_imagen);
                Icon icono_imagen = new ImageIcon(imagen.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
                fila[0] = icono_imagen;

                fila[1] = rs.getString("id_producto");

                fila[2] = "-Nombre: \n" + rs.getString("nombre_producto") + "\n\n-Medida/Tamaño: \n" + rs.getString("medida") + "\n\n-Material/es: \n" + rs.getString("material") + "\n\n-Marca: \n" + rs.getString("marca") + "\n\n-Precio $: \n" + rs.getString("precio_venta") + " x" + rs.getString("unidad_venta") + "\n\n-Stock: \n" + rs.getString("stock") + " " + rs.getString("unidad_stock") + "\n\n-Ultima Actualizacion: \n" + rs.getString("ult_actualizacion");
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar tabla de stock" + e);
        }
    }

    public void obtenerDatosDeTabla(JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.convertRowIndexToModel(tabla.getSelectedRow());
                int columna_point = 1;

                if (fila_point > -1) {
                    id_producto_update = Integer.valueOf((String) model.getValueAt(fila_point, columna_point));
                }
                if (!ventanas_stock.contains(id_producto_update)) {
                    ventanas_stock.add(id_producto_update);
                    FichaProducto ficha = new FichaProducto();
                    ficha.setVisible(true);
                }
            }
        });
    }

    public class TextAreaRenderer extends JTextArea
            implements TableCellRenderer {

        public TextAreaRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable jTable,
                Object obj, boolean isSelected, boolean hasFocus, int row,
                int column) {
            setText((String) obj);
            return this;
        }
    }
}
