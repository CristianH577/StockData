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
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static ventanas.Administrador.ventanas_abiertas;

public class Stock extends javax.swing.JFrame {

    String user, user_nivel;
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }
    };
    public static int id_producto_update = 0;
    public static ArrayList ventanas_stock = new ArrayList();

    public Stock() {
        initComponents();

        user = Login.user;
        user_nivel = Login.user_nivel;

        setSize(1200, 680);
        setResizable(false);
        setTitle("Lista de Stock - Sesion de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaper_principal.jpg");
        Icon icono;
        icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icono);
        this.repaint();

        //vista por nivel
        if (!user_nivel.equals("Administrador")) {
            boton_agregar.setVisible(false);
        }

        if (user_nivel.equals("2")) {
            boton_imprimir.setVisible(false);
            boton_imprimir_listaPrecios.setVisible(false);
        }

        //creo tabla
        tabla_stock = new JTable(model);
        jScrollPane1.setViewportView(tabla_stock);

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Medida/Tamaño");
        model.addColumn("Material/es");
        model.addColumn("Marca");
        model.addColumn("Precio $");
        model.addColumn("Venta por");
        model.addColumn("Stock");
        model.addColumn("");
        model.addColumn("Ultima Actualizacion");

        //diseño tabla
        diseñoTabla(tabla_stock);

        //cargo datos a la tabla
        String query = "select id_producto, nombre_producto, medida, material, marca, precio_venta, unidad_venta, stock, unidad_stock, ult_actualizacion from productos";
        cargarDatosTabla(tabla_stock, query);

        //doy funciones a la tabla
        obtenerDatosDeTabla(tabla_stock);

        label_titulo1.setOpaque(true);
        label_titulo1.setBackground(new Color(0, 102, 102));
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

        label_titulo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_stock = new javax.swing.JTable();
        boton_agregar = new javax.swing.JButton();
        label_titulo = new javax.swing.JLabel();
        boton_imprimir = new javax.swing.JButton();
        boton_iragaleria = new javax.swing.JButton();
        boton_imprimir_listaPrecios = new javax.swing.JButton();
        boton_actualizar = new javax.swing.JButton();
        tf_codigo = new javax.swing.JTextField();
        tf_material = new javax.swing.JTextField();
        tf_nombre = new javax.swing.JTextField();
        tf_medida = new javax.swing.JTextField();
        tf_marca = new javax.swing.JTextField();
        tf_precioV = new javax.swing.JTextField();
        tf_unidadV = new javax.swing.JTextField();
        tf_stock = new javax.swing.JTextField();
        tf_unidadS = new javax.swing.JTextField();
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

        label_titulo1.setBackground(new java.awt.Color(255, 255, 255));
        label_titulo1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        label_titulo1.setForeground(new java.awt.Color(255, 255, 255));
        label_titulo1.setText("  Buscador    ");
        label_titulo1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        getContentPane().add(label_titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 73, -1, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_stock.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_stock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Medida/Tamaño", "Material/es", "Marca", "Precio $", "Venta por", "Stock"
            }
        ));
        jScrollPane1.setViewportView(tabla_stock);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1140, 360));

        boton_agregar.setBackground(new java.awt.Color(0, 153, 153));
        boton_agregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_agregar.setForeground(new java.awt.Color(255, 255, 255));
        boton_agregar.setText("Agregar producto");
        boton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 200, 40));

        label_titulo.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        label_titulo.setForeground(new java.awt.Color(255, 255, 255));
        label_titulo.setText("Stock");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, 40));

        boton_imprimir.setBackground(new java.awt.Color(0, 153, 153));
        boton_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        boton_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(boton_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 490, 100, 80));

        boton_iragaleria.setBackground(new java.awt.Color(0, 153, 153));
        boton_iragaleria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_iragaleria.setForeground(new java.awt.Color(255, 255, 255));
        boton_iragaleria.setText("Ir a galeria");
        boton_iragaleria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_iragaleriaActionPerformed(evt);
            }
        });
        getContentPane().add(boton_iragaleria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 200, 40));

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
        getContentPane().add(boton_imprimir_listaPrecios, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, 200, 40));

        boton_actualizar.setBackground(new java.awt.Color(0, 153, 153));
        boton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 90, 40, 40));

        tf_codigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_codigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        tf_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_codigoKeyReleased(evt);
            }
        });
        getContentPane().add(tf_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 67, -1));

        tf_material.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_material.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_material.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        tf_material.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_materialKeyReleased(evt);
            }
        });
        getContentPane().add(tf_material, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 110, 148, -1));

        tf_nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        tf_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_nombreKeyReleased(evt);
            }
        });
        getContentPane().add(tf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 110, 299, -1));

        tf_medida.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_medida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_medida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        tf_medida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_medidaKeyReleased(evt);
            }
        });
        getContentPane().add(tf_medida, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 127, -1));

        tf_marca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_marca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        tf_marca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_marcaKeyReleased(evt);
            }
        });
        getContentPane().add(tf_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 110, 88, -1));

        tf_precioV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_precioV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_precioV.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        tf_precioV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_precioVKeyReleased(evt);
            }
        });
        getContentPane().add(tf_precioV, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 110, 87, -1));

        tf_unidadV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_unidadV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_unidadV.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        tf_unidadV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_unidadVKeyReleased(evt);
            }
        });
        getContentPane().add(tf_unidadV, new org.netbeans.lib.awtextra.AbsoluteConstraints(818, 110, 68, -1));

        tf_stock.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_stock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_stock.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        tf_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_stockKeyReleased(evt);
            }
        });
        getContentPane().add(tf_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(883, 110, 67, -1));

        tf_unidadS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_unidadS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_unidadS.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 3, true));
        tf_unidadS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_unidadSKeyReleased(evt);
            }
        });
        getContentPane().add(tf_unidadS, new org.netbeans.lib.awtextra.AbsoluteConstraints(947, 110, 68, -1));

        footer.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        footer.setText("Creado por Cosme Fulanito C.O.");
        footer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footerMouseClicked(evt);
            }
        });
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 600, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

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

    private void boton_iragaleriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_iragaleriaActionPerformed
        // TODO add your handling code here:
        StockGaleria galeria = new StockGaleria();
        galeria.setVisible(true);
        dispose();
    }//GEN-LAST:event_boton_iragaleriaActionPerformed

    private void boton_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_imprimirActionPerformed
        // TODO add your handling code here:
        Document documento = new Document();

        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Stock " + formato.format(LocalDateTime.now()) + ".pdf"));

            DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/bannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 30, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("\n\nStock " + formato1.format(LocalDateTime.now()) + "\n \n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable stock = new PdfPTable(8);
            stock.setWidthPercentage(110);

            //titulos de tabla
            String titulos[] = {"Codigo", "Nombre", "Medida/Tamaño", "Material/es", "Marca", "Stock", "", "Ultima Actualizacion"};

            PdfPCell colTitulo;
            for (int i = 0; i < 8; i++) {
                colTitulo = new PdfPCell(new Paragraph(titulos[i], FontFactory.getFont("Arial", 10, Font.BOLD)));
                colTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                stock.addCell(colTitulo);
            }

            //anchos de columnas
            int anchos[] = {8, 20, 10, 10, 10, 10, 6, 14};
            stock.setWidths(anchos);

            //datos tabla
            int f = tabla_stock.getRowCount();
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 5 || j == 6) {
                    } else {
                        stock.addCell(tabla_stock.getValueAt(i, j).toString());
                    }
                }
            }
            documento.add(stock);

            documento.close();
            JOptionPane.showMessageDialog(null, "Lista de stock creada en PDF en el escritorio");
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
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Lista de precios " + ult.format(LocalDateTime.now()) + ".pdf"));

            DateTimeFormatter ult1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/bannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 30, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("\n\nLista de precios " + ult1.format(LocalDateTime.now()) + "\n \n");

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            PdfPTable stock = new PdfPTable(8);
            stock.setWidthPercentage(110);

            //titulos de tabla
            String titulos[] = {"Codigo", "Nombre", "Medida/Tamaño", "Material/es", "Marca", "Precio $", "", "Ultima Actualizacion"};

            PdfPCell colTitulo;
            for (int i = 0; i < 8; i++) {
                colTitulo = new PdfPCell(new Paragraph(titulos[i], FontFactory.getFont("Arial", 10, Font.BOLD)));
                colTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
                stock.addCell(colTitulo);
            }

            //anchos de columnas
            int anchos[] = {8, 20, 10, 10, 10, 10, 6, 14};
            stock.setWidths(anchos);

            //datos tabla
            tabla_stock.getRowSorter().toggleSortOrder(1);
            int f = tabla_stock.getRowCount();
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 7 || j == 8) {
                    } else {
                        stock.addCell(tabla_stock.getValueAt(i, j).toString());
                    }
                }
            }
            documento.add(stock);

            documento.close();
            JOptionPane.showMessageDialog(null, "Lista de precios creada en PDF en el escritorio");
        } catch (DocumentException | IOException e) {
            System.err.println("Error, PDF lista de precios");
            JOptionPane.showMessageDialog(null, "Error al generar pdf");
        }
    }//GEN-LAST:event_boton_imprimir_listaPreciosActionPerformed

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        String query = "select id_producto, nombre_producto, medida, material, marca, precio_venta, unidad_venta, stock, unidad_stock, ult_actualizacion from productos";
        cargarDatosTabla(tabla_stock, query);
    }//GEN-LAST:event_boton_actualizarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ventanas_abiertas.remove(ventanas_abiertas.indexOf("stock"));
    }//GEN-LAST:event_formWindowClosed

    private void tf_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_codigoKeyReleased
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_tf_codigoKeyReleased

    private void tf_materialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_materialKeyReleased
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_tf_materialKeyReleased

    private void tf_marcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_marcaKeyReleased
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_tf_marcaKeyReleased

    private void tf_precioVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_precioVKeyReleased
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_tf_precioVKeyReleased

    private void tf_unidadVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_unidadVKeyReleased
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_tf_unidadVKeyReleased

    private void tf_stockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_stockKeyReleased
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_tf_stockKeyReleased

    private void tf_unidadSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_unidadSKeyReleased
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_tf_unidadSKeyReleased

    private void tf_medidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_medidaKeyReleased
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_tf_medidaKeyReleased

    private void tf_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombreKeyReleased
        // TODO add your handling code here:
        filtro();
    }//GEN-LAST:event_tf_nombreKeyReleased

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
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_actualizar;
    private javax.swing.JButton boton_agregar;
    private javax.swing.JButton boton_imprimir;
    private javax.swing.JButton boton_imprimir_listaPrecios;
    private javax.swing.JButton boton_iragaleria;
    private javax.swing.JLabel footer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_titulo1;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTable tabla_stock;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_marca;
    private javax.swing.JTextField tf_material;
    private javax.swing.JTextField tf_medida;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_precioV;
    private javax.swing.JTextField tf_stock;
    private javax.swing.JTextField tf_unidadS;
    private javax.swing.JTextField tf_unidadV;
    // End of variables declaration//GEN-END:variables

    public void diseñoTabla(JTable tabla) {
        tabla.setFillsViewportHeight(true);

        TableRowSorter sorter = new TableRowSorter(model);
        tabla.setRowSorter(sorter);

        int[] ancho = {20, 250, 80, 100, 40, 40, 20, 20, 20, 100};
        for (int i = 0; i < 10; i++) {
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
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            int c = tabla_stock.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[c];

                for (int i = 1; i <= c; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar tabla" + e);
            JOptionPane.showMessageDialog(null, "Eror, contacte al administrador");
        }
    }

    public void obtenerDatosDeTabla(JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.convertRowIndexToModel(tabla.getSelectedRow());

                if (fila_point > -1) {
                    id_producto_update = (int) model.getValueAt(fila_point, 0);
                }
                if (!ventanas_stock.contains(id_producto_update)) {
                    ventanas_stock.add(id_producto_update);
                    FichaProducto ficha = new FichaProducto();
                    ficha.setVisible(true);
                }
            }
        });
    }

    public void filtro() {

        String codigo, nombre, medida, material, marca, precioV, unidadV, stock, unidadS;

        codigo = tf_codigo.getText().trim();
        nombre = tf_nombre.getText();
        medida = tf_medida.getText();
        material = tf_material.getText();
        marca = tf_marca.getText();
        precioV = tf_precioV.getText();
        unidadV = tf_unidadV.getText();
        stock = tf_stock.getText();
        unidadS = tf_unidadS.getText();

        LinkedList listaFiltros = new LinkedList();
        if (!codigo.equals("")) {
            listaFiltros.add(RowFilter.regexFilter(codigo, 0));
        }
        if (!nombre.equals("")) {
            listaFiltros.add(RowFilter.regexFilter(nombre, 1));
        }
        if (!medida.equals("")) {
            listaFiltros.add(RowFilter.regexFilter(medida, 2));
        }
        if (!material.equals("")) {
            listaFiltros.add(RowFilter.regexFilter(material, 3));
        }
        if (!marca.equals("")) {
            listaFiltros.add(RowFilter.regexFilter(marca, 4));
        }
        if (!precioV.equals("")) {
            listaFiltros.add(RowFilter.regexFilter(precioV, 5));
        }
        if (!unidadV.equals("")) {
            listaFiltros.add(RowFilter.regexFilter(unidadV, 6));
        }
        if (!stock.equals("")) {
            listaFiltros.add(RowFilter.regexFilter(stock, 7));
        }
        if (!unidadS.equals("")) {
            listaFiltros.add(RowFilter.regexFilter(unidadS, 8));
        }

        RowFilter filtroAnd = RowFilter.andFilter(listaFiltros);

        TableRowSorter sorter = new TableRowSorter(model);
        sorter.setRowFilter(RowFilter.andFilter(listaFiltros));
        tabla_stock.setRowSorter(sorter);
    }
}
