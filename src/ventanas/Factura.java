package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static ventanas.Administrador.ventanas_abiertas;
import static ventanas.Stock.ventanas_stock;

public class Factura extends javax.swing.JFrame {

    String user;
    float total = 0;
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }
    };
    DefaultListModel<String> modelLista = new DefaultListModel();
    ArrayList productos = new ArrayList();
    int fila_seleccionada;
    public static int id_producto_update;

    public Factura() {
        initComponents();

        user = Login.user;

        setSize(900, 700);
        setResizable(false);
        setTitle("Factura - Sesion de " + user);
        setLocationRelativeTo(null);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaper_principal.jpg");
        Icon icono;
        icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(),
                label_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        label_wallpaper.setIcon(icono);
        this.repaint();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //tabla factura
        tabla_factura = new JTable(model);
        jScrollPane1.setViewportView(tabla_factura);

        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn(" ");
        model.addColumn("Precio");
        model.addColumn("SubTotal");

        //diseño tabla
        diseñoTabla(tabla_factura);

        //funciones tabla
        OpcionesTabla(tabla_factura);

        setJTexFieldChanged(tf_codigo);

        //lista de productos
        lista = new JList(modelLista);
        jScrollPane2.setViewportView(lista);
        jScrollPane2.setVisible(false);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select nombre_producto from productos");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                productos.add(rs.getString("nombre_producto"));
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        Collections.sort(productos);
        for (int i = 0; i < productos.size(); i++) {
            modelLista.addElement((String) productos.get(i));
        }
        obtenerProducto(lista);

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

        Pmenu = new javax.swing.JPopupMenu();
        ficha = new javax.swing.JMenuItem();
        modificar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        label_titulo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_precio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_cantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_nombre_producto = new javax.swing.JTextField();
        tf_codigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        boton_fin = new javax.swing.JButton();
        box_envio = new javax.swing.JComboBox<>();
        boton_sumar = new javax.swing.JButton();
        boton_restar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_factura = new javax.swing.JTable();
        tf_total = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_nombre_cliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_direc_cliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_unidad = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tp_comentario_venta = new javax.swing.JTextPane();
        footer = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        ficha.setText("Ficha del producto");
        ficha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fichaActionPerformed(evt);
            }
        });
        Pmenu.add(ficha);

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        Pmenu.add(modificar);

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        Pmenu.add(eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lista);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 200, -1));

        label_titulo.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        label_titulo.setForeground(new java.awt.Color(255, 255, 255));
        label_titulo.setText("Nueva Factura");
        getContentPane().add(label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Codigo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        tf_precio.setEditable(false);
        tf_precio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_precio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 100, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre del producto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        tf_cantidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_cantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_cantidadKeyTyped(evt);
            }
        });
        getContentPane().add(tf_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 200, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio $:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, -1, -1));

        tf_nombre_producto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_nombre_producto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_nombre_producto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_nombre_productoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_nombre_productoFocusLost(evt);
            }
        });
        tf_nombre_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_nombre_productoMouseClicked(evt);
            }
        });
        tf_nombre_producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_nombre_productoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_nombre_productoKeyTyped(evt);
            }
        });
        getContentPane().add(tf_nombre_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 200, -1));

        tf_codigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_codigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_codigoKeyReleased(evt);
            }
        });
        getContentPane().add(tf_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Comentario de la venta:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        boton_fin.setBackground(new java.awt.Color(0, 153, 153));
        boton_fin.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        boton_fin.setForeground(new java.awt.Color(255, 255, 255));
        boton_fin.setText("FIN");
        boton_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_finActionPerformed(evt);
            }
        });
        getContentPane().add(boton_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 520, 100, 80));

        box_envio.setBackground(new java.awt.Color(0, 153, 153));
        box_envio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        box_envio.setForeground(new java.awt.Color(255, 255, 255));
        box_envio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        box_envio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(box_envio, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        boton_sumar.setBackground(new java.awt.Color(0, 153, 153));
        boton_sumar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        boton_sumar.setForeground(new java.awt.Color(255, 255, 255));
        boton_sumar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sumar.png"))); // NOI18N
        boton_sumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_sumarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_sumar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, 50, 50));

        boton_restar.setBackground(new java.awt.Color(0, 153, 153));
        boton_restar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_restar.setForeground(new java.awt.Color(255, 255, 255));
        boton_restar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restar.png"))); // NOI18N
        boton_restar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_restarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_restar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 50, 50));

        tabla_factura.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_factura);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 850, 240));

        tf_total.setEditable(false);
        tf_total.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tf_total.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, 150, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total: $");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, -1, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre del cliente:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        tf_nombre_cliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_nombre_cliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_nombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 250, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Direccion del cliente:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        tf_direc_cliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_direc_cliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_direc_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 530, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Envio a domicilio:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cantidad:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        tf_unidad.setEditable(false);
        tf_unidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tf_unidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tf_unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 100, -1));

        tp_comentario_venta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(tp_comentario_venta);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 430, 40));

        footer.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        footer.setText("Creado por Cosme Fulanito C.O.");
        footer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footerMouseClicked(evt);
            }
        });
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 620, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_finActionPerformed
        // TODO add your handling code here:
        int validacion = 0, a;
        String nombre_cliente, direccion_cliente, envio, total_string, comentario_venta, codigos = "", cantidades = "", checks = "", fecha;

        if (tabla_factura.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay articulos en la factura");
        } else {
            //tomo los valores de los text field
            nombre_cliente = tf_nombre_cliente.getText().trim();
            direccion_cliente = tf_direc_cliente.getText().trim();
            envio = box_envio.getSelectedItem().toString();
            total_string = tf_total.getText().trim();
            comentario_venta = tp_comentario_venta.getText();

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            fecha = formato.format(LocalDateTime.now());

            //creo la lista de codigos
            a = tabla_factura.getRowCount();
            for (int i = 0; i < a; i++) {
                codigos += tabla_factura.getValueAt(i, 0);
                if (!(i == a - 1)) {
                    codigos += ",";
                }
            }

            //creo la lista de cantidades
            for (int i = 0; i < a; i++) {
                cantidades += tabla_factura.getValueAt(i, 2);
                if (!(i == a - 1)) {
                    cantidades += ",";
                }
            }

            //creo lista checks
            for (int i = 0; i < a; i++) {
                checks += "f";
            }

            if (codigos.equals("")) {
                boton_fin.setBackground(Color.red);
                validacion++;
            }

            if (validacion == 0) {
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("insert into remitos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                    pst.setInt(1, 0);
                    pst.setString(2, nombre_cliente);
                    pst.setString(3, direccion_cliente);
                    pst.setString(4, envio);
                    pst.setString(5, codigos);
                    pst.setString(6, cantidades);
                    pst.setString(7, total_string);
                    pst.setString(8, comentario_venta);
                    pst.setString(9, user);
                    pst.setString(10, "");
                    pst.setString(11, "");
                    pst.setString(12, "Nuevo");
                    pst.setString(13, checks);
                    pst.setString(14, fecha);
                    pst.setString(15, "");

                    pst.executeUpdate();
                    cn.close();

                    JOptionPane.showMessageDialog(null, "Enviado");
                    this.dispose();
                } catch (SQLException e) {
                    System.err.println("Error en crear factura" + e);
                    JOptionPane.showMessageDialog(null, "Error, contacte al administrador");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
            }
        }

    }//GEN-LAST:event_boton_finActionPerformed

    private void boton_sumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_sumarActionPerformed
        // TODO add your handling code here:
        int a, filaCambia = 0;
        float precio, cantidad, subtotal, cantidad_tabla, cantidad_nueva;
        String codigo, nombre, cantidad_string;
        boolean bandera = false;

        codigo = tf_codigo.getText().trim();
        nombre = tf_nombre_producto.getText();
        cantidad_string = tf_cantidad.getText().trim();

        if (!(codigo.equals("") || codigo.equals("0") || nombre.equals("") || cantidad_string.equals("") || cantidad_string.equals("0"))) {

            cantidad = Float.parseFloat(cantidad_string);
            precio = Float.parseFloat(tf_precio.getText());

            //reviso si ya se agrego el producto
            a = tabla_factura.getRowCount();
            for (int i = 0; i < a; i++) {
                if (codigo.equals(tabla_factura.getValueAt(i, 0))) {
                    filaCambia = i;
                    bandera = true;
                    break;
                }
            }

            if (bandera == false) {

                //nueva fila
                subtotal = cantidad * precio;

                Object[] fila = new Object[6];

                fila[0] = codigo;
                fila[1] = nombre;
                fila[2] = cantidad;
                fila[3] = tf_unidad.getText();
                fila[4] = precio;
                fila[5] = subtotal;
                model.addRow(fila);

                total += subtotal;
                tf_total.setText("" + total);

                tf_cantidad.setText("");
            } else {
                //modifico cantidad
                cantidad_tabla = (float) tabla_factura.getValueAt(filaCambia, 2);
                cantidad_nueva = cantidad_tabla + cantidad;
                tabla_factura.setValueAt(cantidad_nueva, filaCambia, 2);

                //modifico subtotal
                subtotal = cantidad_nueva * precio;
                tabla_factura.setValueAt(subtotal, filaCambia, 5);

                //recalculo el total
                CalcularTotal();
            }

        }


    }//GEN-LAST:event_boton_sumarActionPerformed

    private void boton_restarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_restarActionPerformed
        // TODO add your handling code here:
        int a, filaCambia = 0;
        float cantidad, precio, subtotal, cantidad_tabla, cantidad_nueva;
        String codigo, cantidad_string, nombre;
        boolean bandera = false;

        codigo = tf_codigo.getText().trim();
        nombre = tf_nombre_producto.getText();
        cantidad_string = tf_cantidad.getText().trim();
        a = tabla_factura.getRowCount();

        if (!(codigo.equals("") || codigo.equals("0") || nombre.equals("") || cantidad_string.equals("") || cantidad_string.equals("0") || a == 0)) {

            //reviso si ya se agrego el producto
            for (int i = 0; i < a; i++) {
                if (codigo.equals(tabla_factura.getValueAt(i, 0))) {
                    filaCambia = i;
                    bandera = true;
                    break;
                }
            }

            if (bandera == true) {

                //modifico cantidad
                cantidad_tabla = (float) tabla_factura.getValueAt(filaCambia, 2);
                cantidad = Float.parseFloat(cantidad_string);
                cantidad_nueva = cantidad_tabla - cantidad;

                if (cantidad_nueva == 0) {
                    model.removeRow(filaCambia);
                } else {
                    tabla_factura.setValueAt(cantidad_nueva, filaCambia, 2);

                    //modifico subtotal
                    precio = Float.parseFloat(tf_precio.getText());
                    subtotal = cantidad_nueva * precio;
                    tabla_factura.setValueAt(subtotal, filaCambia, 5);
                }

                //recalculo el total
                CalcularTotal();
            }
        }


    }//GEN-LAST:event_boton_restarActionPerformed

    private void tf_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_codigoKeyReleased
        // TODO add your handling code here:
        CodigoCambia();

    }//GEN-LAST:event_tf_codigoKeyReleased

    private void tf_nombre_productoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombre_productoKeyReleased
        // TODO add your handling code here:
        NombreCambia();

    }//GEN-LAST:event_tf_nombre_productoKeyReleased

    private void tf_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cantidadKeyTyped
        // TODO add your handling code here:
        filtroMonto(evt, tf_cantidad);
    }//GEN-LAST:event_tf_cantidadKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ventanas_abiertas.remove(ventanas_abiertas.indexOf("factura"));
    }//GEN-LAST:event_formWindowClosed

    private void tf_nombre_productoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_nombre_productoFocusGained
        // TODO add your handling code here:
        jScrollPane2.setVisible(true);
    }//GEN-LAST:event_tf_nombre_productoFocusGained

    private void tf_nombre_productoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_nombre_productoFocusLost
        // TODO add your handling code here:
        jScrollPane2.setVisible(false);
    }//GEN-LAST:event_tf_nombre_productoFocusLost

    private void tf_nombre_productoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombre_productoKeyTyped
        // TODO add your handling code here:String nombre;
        String nombre = tf_nombre_producto.getText();

        modelLista.clear();
        for (Iterator it = productos.iterator(); it.hasNext();) {
            String name = (String) it.next();
            if (name.contains(nombre)) {
                modelLista.addElement(name);
            }
        }
    }//GEN-LAST:event_tf_nombre_productoKeyTyped

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        jScrollPane2.setVisible(false);
    }//GEN-LAST:event_formMouseClicked

    private void tf_nombre_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_nombre_productoMouseClicked
        // TODO add your handling code here:
        jScrollPane2.setVisible(true);
    }//GEN-LAST:event_tf_nombre_productoMouseClicked

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        tf_codigo.setText((String) tabla_factura.getValueAt(fila_seleccionada, 0));
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        model.removeRow(fila_seleccionada);
        CalcularTotal();
    }//GEN-LAST:event_eliminarActionPerformed

    private void fichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fichaActionPerformed
        // TODO add your handling code here:
        id_producto_update = Integer.parseInt(model.getValueAt(fila_seleccionada, 0).toString());

        if (!ventanas_stock.contains(id_producto_update)) {
            ventanas_stock.add(id_producto_update);
            FichaProducto ficha = new FichaProducto();
            ficha.setVisible(true);
        }
    }//GEN-LAST:event_fichaActionPerformed

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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu Pmenu;
    private javax.swing.JButton boton_fin;
    private javax.swing.JButton boton_restar;
    private javax.swing.JButton boton_sumar;
    private javax.swing.JComboBox<String> box_envio;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JMenuItem ficha;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JList<String> lista;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JTable tabla_factura;
    private javax.swing.JTextField tf_cantidad;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_direc_cliente;
    private javax.swing.JTextField tf_nombre_cliente;
    private javax.swing.JTextField tf_nombre_producto;
    private javax.swing.JTextField tf_precio;
    private javax.swing.JTextField tf_total;
    private javax.swing.JTextField tf_unidad;
    private javax.swing.JTextPane tp_comentario_venta;
    // End of variables declaration//GEN-END:variables

    public void diseñoTabla(JTable tabla) {
        tabla.setFillsViewportHeight(true);

        TableRowSorter sorter = new TableRowSorter(model);
        tabla.setRowSorter(sorter);

        int[] ancho = {20, 250, 80, 100, 40, 40};
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
        }

        ((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(CENTER);

        DefaultTableCellRenderer centerText = new DefaultTableCellRenderer();
        centerText.setHorizontalAlignment(CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(centerText);

        DefaultTableCellRenderer rightText = new DefaultTableCellRenderer();
        rightText.setHorizontalAlignment(RIGHT);
        tabla.getColumnModel().getColumn(2).setCellRenderer(rightText);
        tabla.getColumnModel().getColumn(4).setCellRenderer(rightText);
        tabla.getColumnModel().getColumn(5).setCellRenderer(rightText);
    }

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

    private void setJTexFieldChanged(JTextField txt) {
        DocumentListener documentListener = new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                printIt(documentEvent);
            }

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                printIt(documentEvent);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                printIt(documentEvent);
            }
        };
        txt.getDocument().addDocumentListener(documentListener);

    }

    private void printIt(DocumentEvent documentEvent) {
        DocumentEvent.EventType type = documentEvent.getType();

        if (type.equals(DocumentEvent.EventType.CHANGE)) {
            CodigoCambia();
        } else if (type.equals(DocumentEvent.EventType.INSERT)) {
            CodigoCambia();
        } else if (type.equals(DocumentEvent.EventType.REMOVE)) {
            CodigoCambia();
        }
    }

    public void CodigoCambia() {
        String codigo;

        codigo = tf_codigo.getText().trim();

        if (!codigo.equals("")) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select nombre_producto, unidad_venta, precio_venta from productos where id_producto = '" + codigo + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    tf_nombre_producto.setText(rs.getString("nombre_producto"));
                    tf_unidad.setText(rs.getString("unidad_venta"));
                    tf_precio.setText(rs.getString("precio_venta"));
                } else {
                    tf_nombre_producto.setText("");
                    tf_unidad.setText("");
                    tf_precio.setText("");
                }
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error en buscar nombre del codigo" + e);
            }
        } else {
            //tf_nombre_producto.setText("");
            tf_unidad.setText("");
            tf_precio.setText("");
        }
    }

    public void obtenerProducto(JList lista) {
        lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String producto = (String) lista.getSelectedValue();
                tf_nombre_producto.setText(producto);
                NombreCambia();
                jScrollPane2.setVisible(false);
            }
        });
    }

    public void NombreCambia() {
        String nombre;

        nombre = tf_nombre_producto.getText();

        if (!nombre.equals("")) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select id_producto from productos where nombre_producto = '" + nombre + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    tf_codigo.setText(rs.getString("id_producto"));
                } else {
                    tf_codigo.setText("");
                    tf_unidad.setText("");
                    tf_precio.setText("");
                }
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error en buscar codigo del nombre" + e);
            }
        } else {
            tf_codigo.setText("");
        }
    }

    public void CalcularTotal() {
        int a = tabla_factura.getRowCount();

        total = 0;
        for (int i = 0; i < a; i++) {
            total += (float) tabla_factura.getValueAt(i, 5);
        }
        tf_total.setText("" + total);

        tf_cantidad.setText("");
    }

    public void OpcionesTabla(JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                fila_seleccionada = tabla.getSelectedRow();

                if (fila_seleccionada > -1) {
                    Pmenu.show(e.getComponent(), e.getX(), e.getY());
                }

            }
        });
    }

}