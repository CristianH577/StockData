package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import static ventanas.Stock.ventanas_stock;

public class FichaProducto extends javax.swing.JFrame {

    String user, nivel, ult_fechaV0, ult_fechaC0, preciov0, precioc0, direccion_imagen, direccion_origen = "", nombre_imagen, direccion_imagen0;
    int id_producto_update;

    public FichaProducto() {
        initComponents();

        user = Login.user;
        nivel = Login.user_nivel;
        id_producto_update = (int) ventanas_stock.get(ventanas_stock.size() - 1);

        setResizable(false);
        setTitle("Ficha de producto - Sesion de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaper_principal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icono);
        this.repaint();

        //vista por nivel
        if (nivel.equals("Administrador")) {
            setSize(750, 700);
            tf_unidad_stock.setVisible(false);
            tf_unidad_venta.setVisible(false);
            tf_unidad_compra.setVisible(false);
            footer1.setVisible(false);
        } else {
            setSize(750, 650);
            tf_nombre.setEditable(false);
            tf_material.setEditable(false);
            tf_medida.setEditable(false);
            tf_marca.setEditable(false);
            tf_ubicacion.setEditable(false);
            boton_subir_imagen.setVisible(false);
            boton_eliminar_imagen.setVisible(false);
            tp_comentarios_producto.setEditable(false);
            tf_precio_venta.setEditable(false);
            tf_precio_compra.setEditable(false);
            tf_stock.setEditable(false);
            box_unidad_stock.setVisible(false);
            box_unidad_venta.setVisible(false);
            box_unidad_compra.setVisible(false);
            tf_operacion.setVisible(false);
            boton_sumar.setVisible(false);
            boton_restar.setVisible(false);
            boton_actualizar.setVisible(false);
            boton_eliminarProducto.setVisible(false);
            footer.setVisible(false);
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from productos where id_producto = '" + id_producto_update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                label_ult_act.setText("Ultima actualizacion: " + rs.getString("ult_actualizacion"));

                tf_codigo.setText(rs.getString("id_producto"));
                tf_nombre.setText(rs.getString("nombre_producto"));
                tf_medida.setText(rs.getString("medida"));
                tf_material.setText(rs.getString("material"));
                tf_marca.setText(rs.getString("marca"));
                tf_ubicacion.setText(rs.getString("ubicacion"));
                tp_comentarios_producto.setText(rs.getString("comentario"));

                tf_precio_venta.setText(rs.getString("precio_venta"));
                box_unidad_venta.setSelectedItem(rs.getString("unidad_venta"));
                tf_unidad_venta.setText(rs.getString("unidad_venta"));
                tf_act_preciov.setText(rs.getString("ult_actualizacion_venta"));

                tf_precio_compra.setText(rs.getString("precio_compra"));
                box_unidad_compra.setSelectedItem(rs.getString("unidad_compra"));
                tf_unidad_compra.setText(rs.getString("unidad_compra"));
                tf_act_precioc.setText(rs.getString("ult_actualizacion_compra"));

                tf_stock.setText(rs.getString("stock"));
                box_unidad_stock.setSelectedItem(rs.getString("unidad_stock"));
                tf_unidad_stock.setText(rs.getString("unidad_stock"));

                direccion_imagen = rs.getString("direccion_imagen");
                direccion_imagen0 = rs.getString("direccion_imagen");

                ImageIcon imagen = new ImageIcon(direccion_imagen);
                Icon icono_imagen = new ImageIcon(imagen.getImage().getScaledInstance(label_imagen.getWidth(),
                        label_imagen.getHeight(), Image.SCALE_DEFAULT));
                label_imagen.setIcon(icono_imagen);
                this.repaint();
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al consultar la informacion del producto" + e);
        }

        preciov0 = tf_precio_venta.getText().trim();
        ult_fechaV0 = tf_act_preciov.getText().trim();
        precioc0 = tf_precio_compra.getText().trim();
        ult_fechaC0 = tf_act_precioc.getText().trim();
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
        jLabel4 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        boton_actualizar = new javax.swing.JButton();
        label_imagen = new javax.swing.JLabel();
        tf_material = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_stock = new javax.swing.JTextField();
        tf_codigo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        label_ult_act = new javax.swing.JLabel();
        tf_act_preciov = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_act_precioc = new javax.swing.JTextField();
        boton_sumar = new javax.swing.JButton();
        boton_restar = new javax.swing.JButton();
        box_unidad_stock = new javax.swing.JComboBox<>();
        tf_operacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_ubicacion = new javax.swing.JTextField();
        tf_unidad_stock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_medida = new javax.swing.JTextField();
        tf_marca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        boton_subir_imagen = new javax.swing.JButton();
        boton_eliminar_imagen = new javax.swing.JButton();
        boton_eliminarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tp_comentarios_producto = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_precio_venta = new javax.swing.JTextField();
        tf_precio_compra = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        box_unidad_compra = new javax.swing.JComboBox<>();
        box_unidad_venta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_unidad_venta = new javax.swing.JTextField();
        tf_unidad_compra = new javax.swing.JTextField();
        footer1 = new javax.swing.JLabel();
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
        label_titulo.setText("Ficha de producto");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        tf_nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 200, -1));

        boton_actualizar.setBackground(new java.awt.Color(0, 153, 153));
        boton_actualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        boton_actualizar.setText("Actualizar");
        boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 200, 40));

        label_imagen.setText("IMG");
        label_imagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(label_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 200, 200));

        tf_material.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_material.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_material, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 200, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Material/es:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Codigo:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        tf_stock.setBackground(new java.awt.Color(204, 204, 204));
        tf_stock.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tf_stock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_stock.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_stock.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tf_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_stockKeyTyped(evt);
            }
        });
        getContentPane().add(tf_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 170, -1));

        tf_codigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_codigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_codigo.setEnabled(false);
        getContentPane().add(tf_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 200, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Stock:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        label_ult_act.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        label_ult_act.setForeground(new java.awt.Color(255, 255, 255));
        label_ult_act.setText("Ultima actualizacion: ");
        getContentPane().add(label_ult_act, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        tf_act_preciov.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_act_preciov.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_act_preciov.setEnabled(false);
        getContentPane().add(tf_act_preciov, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 150, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Ult. Actualizacion");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ult. Actualizacion");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, -1));

        tf_act_precioc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_act_precioc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_act_precioc.setEnabled(false);
        getContentPane().add(tf_act_precioc, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 150, -1));

        boton_sumar.setBackground(new java.awt.Color(0, 153, 153));
        boton_sumar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_sumar.setForeground(new java.awt.Color(255, 255, 255));
        boton_sumar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sumar.png"))); // NOI18N
        boton_sumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_sumarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_sumar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 50, 50));

        boton_restar.setBackground(new java.awt.Color(0, 153, 153));
        boton_restar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_restar.setForeground(new java.awt.Color(255, 255, 255));
        boton_restar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restar.png"))); // NOI18N
        boton_restar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_restarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_restar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, 50, 50));

        box_unidad_stock.setBackground(new java.awt.Color(0, 153, 153));
        box_unidad_stock.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        box_unidad_stock.setForeground(new java.awt.Color(255, 255, 255));
        box_unidad_stock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "U", "Doc", "Cajas", "Kg", "Bolsas", "L" }));
        box_unidad_stock.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(box_unidad_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 130, 30));

        tf_operacion.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        tf_operacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_operacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_operacionKeyTyped(evt);
            }
        });
        getContentPane().add(tf_operacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 150, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ubicacion:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        tf_ubicacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_ubicacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_ubicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 200, -1));

        tf_unidad_stock.setEditable(false);
        tf_unidad_stock.setBackground(new java.awt.Color(204, 204, 204));
        tf_unidad_stock.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tf_unidad_stock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_unidad_stock.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_unidad_stock.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(tf_unidad_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 150, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Medida/Tamaño:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        tf_medida.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_medida.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_medida, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 200, -1));

        tf_marca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_marca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 200, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Marca:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        boton_subir_imagen.setBackground(new java.awt.Color(0, 153, 153));
        boton_subir_imagen.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_subir_imagen.setForeground(new java.awt.Color(255, 255, 255));
        boton_subir_imagen.setText("Subir");
        boton_subir_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_subir_imagenActionPerformed(evt);
            }
        });
        getContentPane().add(boton_subir_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 100, 40));

        boton_eliminar_imagen.setBackground(new java.awt.Color(0, 153, 153));
        boton_eliminar_imagen.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_eliminar_imagen.setForeground(new java.awt.Color(255, 255, 255));
        boton_eliminar_imagen.setText("Eliminar");
        boton_eliminar_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminar_imagenActionPerformed(evt);
            }
        });
        getContentPane().add(boton_eliminar_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 100, 40));

        boton_eliminarProducto.setBackground(new java.awt.Color(0, 153, 153));
        boton_eliminarProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_eliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        boton_eliminarProducto.setText("Eliminar");
        boton_eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(boton_eliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 200, 40));

        jScrollPane1.setViewportView(tp_comentarios_producto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 200, 80));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Comentarios:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Precio de venta:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        tf_precio_venta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_precio_venta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_precio_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_precio_ventaKeyTyped(evt);
            }
        });
        getContentPane().add(tf_precio_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 150, -1));

        tf_precio_compra.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_precio_compra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_precio_compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_precio_compraKeyTyped(evt);
            }
        });
        getContentPane().add(tf_precio_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 150, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Precio de compra:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        box_unidad_compra.setBackground(new java.awt.Color(0, 153, 153));
        box_unidad_compra.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        box_unidad_compra.setForeground(new java.awt.Color(255, 255, 255));
        box_unidad_compra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "U", "Doc", "Cajas", "Kg", "Bolsas", "L" }));
        box_unidad_compra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(box_unidad_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 130, 30));

        box_unidad_venta.setBackground(new java.awt.Color(0, 153, 153));
        box_unidad_venta.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        box_unidad_venta.setForeground(new java.awt.Color(255, 255, 255));
        box_unidad_venta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "U", "Doc", "Cajas", "Kg", "Bolsas", "L" }));
        box_unidad_venta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(box_unidad_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 130, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("$");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 365, 20, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("$");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 435, 20, 20));

        tf_unidad_venta.setEditable(false);
        tf_unidad_venta.setBackground(new java.awt.Color(204, 204, 204));
        tf_unidad_venta.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tf_unidad_venta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_unidad_venta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_unidad_venta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(tf_unidad_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 150, -1));

        tf_unidad_compra.setEditable(false);
        tf_unidad_compra.setBackground(new java.awt.Color(204, 204, 204));
        tf_unidad_compra.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tf_unidad_compra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_unidad_compra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_unidad_compra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(tf_unidad_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 150, -1));

        footer1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        footer1.setText("Creado por Cosme Fulanito C.O.");
        footer1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footer1MouseClicked(evt);
            }
        });
        getContentPane().add(footer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 570, -1, -1));

        footer.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        footer.setText("Creado por Cosme Fulanito C.O.");
        footer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footerMouseClicked(evt);
            }
        });
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 620, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        // TODO add your handling code here:
        String nombre, medida, material, marca, ubicacion, comentarios, unidadS, fecha, preciov_string, precioc_string, ult_fechaV, ult_fechaC, unidadV, unidadC;
        int validacion = 0;
        float stock;
        double preciov, precioc;

        DateTimeFormatter ult = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        fecha = ult.format(LocalDateTime.now());

        nombre = tf_nombre.getText();
        medida = tf_medida.getText();
        material = tf_material.getText();
        marca = tf_marca.getText();
        ubicacion = tf_ubicacion.getText();
        comentarios = tp_comentarios_producto.getText();

        preciov_string = tf_precio_venta.getText().trim();
        unidadV = box_unidad_venta.getSelectedItem().toString();

        precioc_string = tf_precio_compra.getText().trim();
        unidadC = box_unidad_compra.getSelectedItem().toString();

        stock = Float.parseFloat(tf_stock.getText().trim());
        unidadS = box_unidad_stock.getSelectedItem().toString();

        if (preciov_string.equals(preciov0)) {
            ult_fechaV = ult_fechaV0;
        } else {
            ult_fechaV = fecha;
        }
        if (precioc_string.equals(precioc0)) {
            ult_fechaC = ult_fechaC0;
        } else {
            ult_fechaC = fecha;
        }

        preciov = Double.parseDouble(preciov_string);
        precioc = Double.parseDouble(precioc_string);

        if (nombre.equals("")) {
            tf_nombre.setBackground(Color.red);
            validacion++;
        } else {
            tf_nombre.setBackground(Color.white);
        }

        if (!direccion_origen.equals("")) {
            direccion_imagen = direccion_origen;
            Path origenPath = FileSystems.getDefault().getPath(direccion_origen);

            Random rand = new Random();
            direccion_imagen = "src/images/productos/" + rand.nextInt(100) + nombre_imagen;
            Path destinoPath = FileSystems.getDefault().getPath(direccion_imagen);
            try {
                Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println("Error al subir la imagen" + e);
            }
        }

        if (validacion == 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("update productos set nombre_producto=?, medida=?, material=?, marca=?, ubicacion=?, comentario=?, precio_venta=?, unidad_venta=?, ult_actualizacion_venta=?, precio_compra=?, unidad_compra=?, ult_actualizacion_compra=?, stock=?, unidad_stock=?, direccion_imagen=?, ult_actualizacion=? where id_producto = '" + id_producto_update + "'");

                pst.setString(1, nombre);
                pst.setString(2, medida);
                pst.setString(3, material);
                pst.setString(4, marca);
                pst.setString(5, ubicacion);
                pst.setString(6, comentarios);
                pst.setDouble(7, preciov);
                pst.setString(8, unidadV);
                pst.setString(9, ult_fechaV);
                pst.setDouble(10, precioc);
                pst.setString(11, unidadC);
                pst.setString(12, ult_fechaC);
                pst.setFloat(13, stock);
                pst.setString(14, unidadS);
                pst.setString(15, direccion_imagen);
                pst.setString(16, fecha);

                pst.executeUpdate();
                cn.close();

                boton_actualizar.setBackground(Color.green);

                JOptionPane.showMessageDialog(null, "Ficha actualizada");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error al actualizar producto" + e);
                JOptionPane.showMessageDialog(null, "Error al actualizar producto, contacte al administrador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene los campos en rojo");
        }
    }//GEN-LAST:event_boton_actualizarActionPerformed

    private void boton_sumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_sumarActionPerformed
        // TODO add your handling code here:
        float stock, op, nuevo_stock;

        if (!tf_operacion.getText().equals("")) {
            stock = Float.parseFloat(tf_stock.getText());
            op = Float.parseFloat(tf_operacion.getText());
            nuevo_stock = stock + op;
            tf_stock.setText("" + nuevo_stock);
            tf_operacion.setText("");
        }

    }//GEN-LAST:event_boton_sumarActionPerformed

    private void boton_restarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_restarActionPerformed
        // TODO add your handling code here:
        float stock, op, nuevo_stock;

        if (!tf_operacion.getText().equals("")) {
            stock = Float.parseFloat(tf_stock.getText());
            op = Float.parseFloat(tf_operacion.getText());
            nuevo_stock = stock - op;
            tf_stock.setText("" + nuevo_stock);
            tf_operacion.setText("");
        }
    }//GEN-LAST:event_boton_restarActionPerformed

    private void tf_operacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_operacionKeyTyped
        // TODO add your handling code here:
        filtroMonto(evt, tf_operacion);
    }//GEN-LAST:event_tf_operacionKeyTyped

    private void boton_subir_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_subir_imagenActionPerformed
        // TODO add your handling code here:
        //creo file choser
        JFileChooser fc = new JFileChooser();

        //creo e indico filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPG", "jpg", "*.PNG", "png");
        fc.setFileFilter(filtro);

        //abre buscador
        int seleccion = fc.showOpenDialog(this);

        //cuando se presiona aceptar:
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            direccion_origen = fichero.getAbsolutePath();
            nombre_imagen = fichero.getName();

            ImageIcon imagen = new ImageIcon(direccion_origen);
            Icon icono_imagen = new ImageIcon(imagen.getImage().getScaledInstance(label_imagen.getWidth(), label_imagen.getHeight(), Image.SCALE_DEFAULT));
            label_imagen.setIcon(icono_imagen);
            this.repaint();
        }
    }//GEN-LAST:event_boton_subir_imagenActionPerformed

    private void boton_eliminar_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminar_imagenActionPerformed
        // TODO add your handling code here:
        direccion_origen = "";

        direccion_imagen = "src/images/productos/indefinido.jpg";
        ImageIcon imagen = new ImageIcon(direccion_imagen);
        Icon icono_imagen = new ImageIcon(imagen.getImage().getScaledInstance(label_imagen.getWidth(),label_imagen.getHeight(), Image.SCALE_DEFAULT));
        label_imagen.setIcon(icono_imagen);
        this.repaint();

    }//GEN-LAST:event_boton_eliminar_imagenActionPerformed

    private void boton_eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarProductoActionPerformed
        // TODO add your handling code here:
        //Icon iconWarning = new ImageIcon(getClass().getResource("src/images/warning.png"));
        
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Eliminar producto?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE/*, iconWarning*/);

        if (confirmar == 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("DELETE from productos where id_producto = '" + id_producto_update + "'");

                pst.executeUpdate();
                cn.close();

                JOptionPane.showMessageDialog(null, "Producto eliminado");
                this.dispose();
            } catch (SQLException e) {
                System.err.println("Error al eliminar producto" + e);
                JOptionPane.showMessageDialog(null, "Error al eliminar producto, contacte al administrador");
            }
        }
    }//GEN-LAST:event_boton_eliminarProductoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ventanas_stock.remove(ventanas_stock.indexOf(id_producto_update));
    }//GEN-LAST:event_formWindowClosed

    private void tf_precio_ventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_precio_ventaKeyTyped
        // TODO add your handling code here:
        filtroMonto(evt, tf_precio_venta);
    }//GEN-LAST:event_tf_precio_ventaKeyTyped

    private void tf_precio_compraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_precio_compraKeyTyped
        // TODO add your handling code here:
        filtroMonto(evt, tf_precio_compra);
    }//GEN-LAST:event_tf_precio_compraKeyTyped

    private void tf_stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_stockKeyTyped
        // TODO add your handling code here:
        filtroMonto(evt, tf_stock);
    }//GEN-LAST:event_tf_stockKeyTyped

    private void footer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footer1MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Por soporte tecnico comuniquese al e-mail: soporte@lachucha.com.ar");
    }//GEN-LAST:event_footer1MouseClicked

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
            java.util.logging.Logger.getLogger(FichaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_actualizar;
    private javax.swing.JButton boton_eliminarProducto;
    private javax.swing.JButton boton_eliminar_imagen;
    private javax.swing.JButton boton_restar;
    private javax.swing.JButton boton_subir_imagen;
    private javax.swing.JButton boton_sumar;
    private javax.swing.JComboBox<String> box_unidad_compra;
    private javax.swing.JComboBox<String> box_unidad_stock;
    private javax.swing.JComboBox<String> box_unidad_venta;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel footer1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_imagen;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_ult_act;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTextField tf_act_precioc;
    private javax.swing.JTextField tf_act_preciov;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_marca;
    private javax.swing.JTextField tf_material;
    private javax.swing.JTextField tf_medida;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_operacion;
    private javax.swing.JTextField tf_precio_compra;
    private javax.swing.JTextField tf_precio_venta;
    private javax.swing.JTextField tf_stock;
    private javax.swing.JTextField tf_ubicacion;
    private javax.swing.JTextField tf_unidad_compra;
    private javax.swing.JTextField tf_unidad_stock;
    private javax.swing.JTextField tf_unidad_venta;
    private javax.swing.JTextPane tp_comentarios_producto;
    // End of variables declaration//GEN-END:variables

    public void filtroMonto(KeyEvent evt, JTextField lab) {
        int key = evt.getKeyChar();

        boolean numeros;

        numeros = (key >= 48 && key <= 57) || key == 46;

        if (lab.getText().contains(".")) {
            numeros = (key >= 48 && key <= 57);
        }

        if (!numeros) {
            evt.consume();
        }
    }
}
