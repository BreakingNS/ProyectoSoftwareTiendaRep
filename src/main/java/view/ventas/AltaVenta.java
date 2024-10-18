package view.ventas;

import config.NumerosSoloDocumentFilter;
import controller.ClienteController;
import controller.RepuestoController;
import controller.VentaController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.AbstractDocument;
import model.Categoria;
import model.Cliente;
import model.Marca;
import model.Modelo;
import model.NombreRepuesto;
import model.Precio;
import model.Repuesto;
import model.Ubicacion;
import model.Venta;
import view.clientes.AltaCliente;

public class AltaVenta extends javax.swing.JFrame {

    private final VentaController ventaController;
    private final RepuestoController repuestoController;
    private final ClienteController clienteController;
    
    private final List<Repuesto> listaRepuestos;
    
    public AltaVenta(VentaController ventaController, RepuestoController repuestoController, ClienteController clienteController) {
        this.ventaController = ventaController;
        this.repuestoController = repuestoController;
        this.clienteController = clienteController;
        listaRepuestos = repuestoController.listarRepuestosOrdenadoPorStock();
        initComponents();
        cargarComboBoxes();
        configurarEventos();
        configurarListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRepuestosSeleccionados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaRepuestos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnCheckR = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnNuevoCli = new javax.swing.JButton();
        lblApellido = new javax.swing.JLabel();
        comboNombreRepuesto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboMarca = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboUbicacion = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnLimpiarFiltroC = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnLimpiarFiltroR = new javax.swing.JButton();
        lblDomicilio = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        comboModelo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("Alta Venta");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("Buscar Repuesto:");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel7.setText("Cliente Seleccionado:");

        btnAtras.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnGuardar.setText("CREAR VENTA");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tablaRepuestosSeleccionados.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tablaRepuestosSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaRepuestosSeleccionados.setRowHeight(24);
        tablaRepuestosSeleccionados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaRepuestosSeleccionados);

        tablaRepuestos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tablaRepuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaRepuestos.setRowHeight(24);
        tablaRepuestos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tablaRepuestos);

        tablaClientes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaClientes.setRowHeight(24);
        tablaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tablaClientes);

        btnEliminar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 51, 51));
        btnEliminar.setText("✘");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCheckR.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnCheckR.setForeground(new java.awt.Color(102, 255, 102));
        btnCheckR.setText("✔");
        btnCheckR.setToolTipText("");
        btnCheckR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckRActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setText("Repuestos Seleccionados:");

        btnNuevoCli.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnNuevoCli.setText("NUEVO CLIENTE");
        btnNuevoCli.setToolTipText("");
        btnNuevoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCliActionPerformed(evt);
            }
        });

        lblApellido.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblApellido.setText("Apellido:");

        comboNombreRepuesto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboNombreRepuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Nombre Repuesto");

        comboMarca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Marca");

        comboCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Categoria");

        comboUbicacion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Ubicacion");

        lblTotal.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lblTotal.setText("Total: $0");

        btnLimpiarFiltroC.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLimpiarFiltroC.setText("LIMPIAR");
        btnLimpiarFiltroC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFiltroCActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });

        txtApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoFocusLost(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        jLabel10.setText("Telefono");

        jLabel11.setText("Apellido");

        jLabel14.setText("Nombre");

        btnLimpiarFiltroR.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLimpiarFiltroR.setText("LIMPIAR");
        btnLimpiarFiltroR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFiltroRActionPerformed(evt);
            }
        });

        lblDomicilio.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDomicilio.setText("Domicilio:");

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblNombre.setText("Nombre:");

        comboModelo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Modelo");

        txtCodigo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoFocusLost(evt);
            }
        });

        jLabel15.setText("Codigo");

        lblTelefono.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTelefono.setText("Telefono:");

        txtDomicilio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtDomicilio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDomicilioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDomicilioFocusLost(evt);
            }
        });
        txtDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomicilioActionPerformed(evt);
            }
        });

        jLabel16.setText("Domicilio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(comboNombreRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(56, 56, 56)
                                                .addComponent(jLabel12)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(comboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(comboUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(108, 108, 108)
                                                .addComponent(jLabel5)
                                                .addGap(92, 92, 92)
                                                .addComponent(jLabel13)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCheckR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiarFiltroR, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(lblApellido)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnLimpiarFiltroC, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel16)))
                        .addComponent(lblNombre)
                        .addComponent(lblDomicilio)
                        .addComponent(lblTelefono)
                        .addComponent(btnNuevoCli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel7))
                .addGap(136, 136, 136))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(717, 717, 717)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(403, 403, 403))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLimpiarFiltroC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLimpiarFiltroR, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboNombreRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNuevoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDomicilio))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel8))
                                    .addComponent(btnCheckR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblTotal)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        List<Repuesto> listaRepuestos = new ArrayList<>();
        
        int idCliente = 0;
        BigDecimal precioFinal= BigDecimal.ZERO;
        
        int filaClienteSeleccionada = tablaClientes.getSelectedRow();
        if (filaClienteSeleccionada != -1) {
            idCliente = Integer.parseInt(tablaClientes.getValueAt(filaClienteSeleccionada, 0).toString());
        }
        
        Cliente cliente = clienteController.obtenerClientePorId(idCliente);
        
        DefaultTableModel modelo = (DefaultTableModel) tablaRepuestosSeleccionados.getModel();
        int rowCount = modelo.getRowCount();
        
        for (int i = 0; i < rowCount; i++) {
            int idRepuesto = (int) modelo.getValueAt(i, 0);
            
            Repuesto repuesto = repuestoController.obtenerRepuestoPorId(idRepuesto);
            precioFinal = precioFinal.add(repuesto.getListaPrecios().get(repuesto.getListaPrecios().size()-1).getValor());
            
            listaRepuestos.add(repuesto);
        }
        
        LocalDateTime ahora = LocalDateTime.now();
        Venta venta = new Venta(1, listaRepuestos.size(), ahora, cliente, precioFinal);
        
        try {
            ventaController.agregarVenta(venta, listaRepuestos);
            JOptionPane.showMessageDialog(null, "Carga realizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(AltaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dispose();
        
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTablas();
    }//GEN-LAST:event_formWindowOpened

    private void btnLimpiarFiltroCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltroCActionPerformed
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtDomicilio.setText("");
    }//GEN-LAST:event_btnLimpiarFiltroCActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
    }//GEN-LAST:event_txtNombreFocusGained
    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
    }//GEN-LAST:event_txtNombreFocusLost
    private void txtApellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusGained
    }//GEN-LAST:event_txtApellidoFocusGained
    private void txtApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusLost
    }//GEN-LAST:event_txtApellidoFocusLost
    private void txtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusGained
    }//GEN-LAST:event_txtTelefonoFocusGained
    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
    }//GEN-LAST:event_txtTelefonoFocusLost
    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnLimpiarFiltroRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltroRActionPerformed
        comboCategoria.setSelectedItem("-");
        comboMarca.setSelectedItem("-");
        comboNombreRepuesto.setSelectedItem("-");
        comboUbicacion.setSelectedItem("-");
        comboModelo.setSelectedItem("-");
        txtCodigo.setText("");
    }//GEN-LAST:event_btnLimpiarFiltroRActionPerformed

    private void btnNuevoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCliActionPerformed
        this.setEnabled(false);
        AltaCliente alta = new AltaCliente(clienteController);
        //alta.setSize(600, 400);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);
        
        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                AltaVenta.this.setEnabled(true);
                AltaVenta.this.setState(JFrame.NORMAL);  
                AltaVenta.this.toFront();                
                AltaVenta.this.requestFocus();  
                cargarTablaClientes(); // Actualiza la tabla después de cerrar AltaCliente.
            }
        });
    }//GEN-LAST:event_btnNuevoCliActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //configurarListeners();
    }//GEN-LAST:event_formMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tablaRepuestosSeleccionados.getRowCount() == 0) {
            configurarListeners();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        
    }//GEN-LAST:event_formMouseMoved

    private void btnCheckRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheckRActionPerformed

    private void txtCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoFocusGained

    private void txtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoFocusLost

    private void txtDomicilioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDomicilioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioFocusGained

    private void txtDomicilioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDomicilioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioFocusLost

    private void txtDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCheckR;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiarFiltroC;
    private javax.swing.JButton btnLimpiarFiltroR;
    private javax.swing.JButton btnNuevoCli;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboMarca;
    private javax.swing.JComboBox<String> comboModelo;
    private javax.swing.JComboBox<String> comboNombreRepuesto;
    private javax.swing.JComboBox<String> comboUbicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaRepuestos;
    private javax.swing.JTable tablaRepuestosSeleccionados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void cargarTablas(){
        //Tabla Repuestos
        cargarTablaRepuestos();
        
        //Tabla Clientes
        cargarTablaClientes();
        
        //Tabla RepuestosSeleccionados
        DefaultTableModel modeloTabla2 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        String titulos2[] = {"Id", "Nombre Repuesto", "Codigo", "Marca", "Modelo", "Categoria", "Precio"};
        modeloTabla2.setColumnIdentifiers(titulos2);
       
        tablaRepuestosSeleccionados.setModel(modeloTabla2);
        
        JTableHeader header = tablaRepuestos.getTableHeader();
        JTableHeader header1 = tablaRepuestosSeleccionados.getTableHeader();
        JTableHeader header2 = tablaClientes.getTableHeader();
        header.setFont(new Font("Arial", Font.ITALIC, 16)); // Cambia "Arial" y 16 por la fuente y tamaño deseados
        header1.setFont(new Font("Arial", Font.ITALIC, 16)); // Cambia "Arial" y 16 por la fuente y tamaño deseados
        header2.setFont(new Font("Arial", Font.ITALIC, 16)); // Cambia "Arial" y 16 por la fuente y tamaño deseados
        
    }
    
    private void cargarTablaRepuestos(){
        //Tabla Repuestos
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        String titulos[] = {"Id", "Nombre Repuesto", "Codigo", "Marca", "Modelo",  "Categoria", "Ubicacion", "Stock", "Precio"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        if(listaRepuestos != null){
            //System.out.println("tamaño de la lista: " + listaRepuestos.size());
            for(Repuesto repuesto : listaRepuestos){
                Object[] objeto = {repuesto.getId_repuesto(), 
                    repuesto.getNombreRepuesto().getNombre_repuesto(),
                    repuesto.getCodigo(),
                    repuesto.getMarca().getNombre_marca(), 
                    repuesto.getModelo().getNombre_modelo(),
                    repuesto.getCategoria().getNombre_categoria(), 
                    repuesto.getUbicacion().getNombre_ubicacion(),
                    repuesto.getStock(), 
                    repuesto.getListaPrecios().get((repuesto.getListaPrecios().size()) - 1).getValor()
                };
                modeloTabla.addRow(objeto);
            }
        }
        
        tablaRepuestos.setModel(modeloTabla);
        
        tablaRepuestos.getColumnModel().getColumn(0).setPreferredWidth(30);
        tablaRepuestos.getColumnModel().getColumn(7).setPreferredWidth(30);
        
        tablaRepuestos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Cambiar el color de fondo solo para la columna "Stock" (índice 6)
                if (column == 7) { // La columna de "Stock" es la 6
                    if (isSelected) {
                        cell.setBackground(table.getSelectionBackground()); // Color de selección
                        cell.setForeground(table.getSelectionForeground()); // Color de texto al seleccionar
                    } else {
                        int stock = Integer.parseInt(value.toString());

                        // Aplicar color según el valor de stock
                        if (stock > 20) {
                            cell.setBackground(Color.GREEN); // Mucho stock
                        } else if (stock <= 20 && stock > 10) {
                            cell.setBackground(Color.YELLOW); // Stock medio
                        } else {
                            cell.setBackground(Color.RED); // Poco stock
                        }
                        cell.setForeground(Color.BLACK); // Asegurarse de que el texto sea legible
                    }
                } else {
                    // Para otras columnas, usa el color predeterminado
                    if (isSelected) {
                        cell.setBackground(table.getSelectionBackground());
                        cell.setForeground(table.getSelectionForeground());
                    } else {
                        cell.setBackground(Color.WHITE); // Fondo predeterminado
                        cell.setForeground(Color.BLACK); // Texto predeterminado
                    }
                }

                return cell;
            }
        });
    }
    
    private void cargarTablaClientes() {
        DefaultTableModel modeloTabla1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        String titulos1[] = {"Id", "Nombre", "Apellido", "Telefono", "Domicilio"};
        modeloTabla1.setColumnIdentifiers(titulos1);

        List<Cliente> listaClientes = clienteController.listarClientes();
        
        if(listaClientes != null){
            //System.out.println("tamaño de la lista: " + listaClientes.size());
            for(Cliente cliente : listaClientes){
                Object[] objeto = {cliente.getId_cliente(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getDomicilio()};
                
                modeloTabla1.addRow(objeto);
            }
        }

        tablaClientes.setModel(modeloTabla1);
    }
    
    private void configurarListeners() {
        // ActionListener para los JComboBox
        ActionListener comboListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarYActualizarTablaRepuestos(); // Actualiza la tabla cuando seleccionas una opción en los ComboBox
            }
        };
        
        // DocumentListener para los JTextField
        DocumentListener docListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarYActualizarTablaRepuestos(); // Actualiza la tabla cuando se inserta texto
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarYActualizarTablaRepuestos(); // Actualiza la tabla cuando se elimina texto
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método no se usa en la mayoría de las implementaciones de DocumentListener
            }
        };
        
        // Agrega ActionListener a los ComboBox
        comboMarca.addActionListener(comboListener);
        comboCategoria.addActionListener(comboListener);
        comboNombreRepuesto.addActionListener(comboListener);
        comboUbicacion.addActionListener(comboListener);
        comboModelo.addActionListener(comboListener);
        
        // Agrega DocumentListener a los JTextField
        txtCodigo.getDocument().addDocumentListener(docListener);
        
        DocumentListener docListener1 = new DocumentListener() {
            private void actualizarEstadoBoton() {
                // No es necesario si eliminas el botón
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarYActualizarTablaClientes(); // Actualiza la tabla cuando se inserta texto
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarYActualizarTablaClientes(); // Actualiza la tabla cuando se elimina texto
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método no se usa en la mayoría de las implementaciones de DocumentListener
                // pero puedes incluir la llamada si necesitas manejar cambios en el documento
            }
        };

        txtNombre.getDocument().addDocumentListener(docListener1);
        txtApellido.getDocument().addDocumentListener(docListener1);
        txtTelefono.getDocument().addDocumentListener(docListener1);
        txtDomicilio.getDocument().addDocumentListener(docListener1);
        
        NumerosSoloDocumentFilter filter = new NumerosSoloDocumentFilter(15);
        ((AbstractDocument) txtTelefono.getDocument()).setDocumentFilter(filter);
        
        // ---------- Desabilitar btnGuardar
        
        btnGuardar.setEnabled(false); // Deshabilita el botón inicialmente.

        DocumentListener docBtnListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarEstadoBoton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarEstadoBoton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarEstadoBoton();
            }
        };

        // Listener para detectar selección en tablaClientes
        tablaClientes.getSelectionModel().addListSelectionListener(e -> actualizarEstadoBoton());

        // Listener para detectar cambios en tablaRepuestosSeleccionados
        tablaRepuestosSeleccionados.getModel().addTableModelListener(e -> actualizarEstadoBoton());

        // Agregar un ListSelectionListener para tablaRepuestosSeleccionados
        tablaRepuestosSeleccionados.getSelectionModel().addListSelectionListener(e -> actualizarEstadoBoton());

        }

    
    // Método para actualizar el estado del botón
    private void actualizarEstadoBoton() {
        boolean clienteSeleccionado = tablaClientes.getSelectedRow() != -1; // Verifica si hay fila seleccionada en tablaClientes
        boolean repuestosSeleccionados = tablaRepuestosSeleccionados.getRowCount() > 0; // Verifica si hay elementos en tablaRepuestosSeleccionados

        // Habilita el botón solo si hay un cliente seleccionado y hay repuestos seleccionados
        btnGuardar.setEnabled(clienteSeleccionado && repuestosSeleccionados);
    }
    
    private void configurarEventos() {
        String escKey = "ESCAPE";
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), escKey);
        getRootPane().getActionMap().put(escKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAtras.doClick(); // Simula un clic en btnAtras
            }
        });
        //Seleccionar Repuesto doble click
        tablaRepuestos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int filaSeleccionada = tablaRepuestos.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        agregarRepuestoSeleccionado(filaSeleccionada); // Método para agregar a la tabla de seleccionados
                    }
                }
            }
        });
        //Seleccionar Repuesto con boton
        btnCheckR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaRepuestos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    agregarRepuestoSeleccionado(filaSeleccionada);
                }
            }
        });
        //Eliminar Repuesto tabla repuestos seleccionados
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaRepuestosSeleccionados.getSelectedRow();
                if (filaSeleccionada != -1) {
                    eliminarRepuestoSeleccionado(filaSeleccionada);
                }
            }
        });
        //Seleccionar Cliente seleccionando en tabla
        tablaClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaClientes.getSelectedRow();
                if (filaSeleccionada != -1) {
                    agregarClienteSeleccionado(filaSeleccionada); // Método para agregar a la tabla de seleccionados
                }
            }
        });
    }
    
    private void cargarComboBoxes(){
        comboCategoria.removeAllItems();
        comboMarca.removeAllItems();
        comboNombreRepuesto.removeAllItems();
        comboUbicacion.removeAllItems();
        comboModelo.removeAllItems();
        
        NombreRepuesto nombreRepuesto = new NombreRepuesto(0, "-");
        Marca marca = new Marca(0, "-", new ArrayList<>());
        Categoria categoria = new Categoria(0, "-", new ArrayList<>(), new ArrayList<>());
        Ubicacion ubicacion = new Ubicacion(0, "-", new ArrayList<>());
        Modelo modelo = new Modelo(0, "-");
        
        comboCategoria.addItem(nombreRepuesto.getNombre_repuesto());
        comboMarca.addItem(marca.getNombre_marca());
        comboNombreRepuesto.addItem(categoria.getNombre_categoria());
        comboUbicacion.addItem(ubicacion.getNombre_ubicacion());
        comboModelo.addItem(ubicacion.getNombre_ubicacion());
        
        List<NombreRepuesto> listaNombreRepuestos = repuestoController.retornarListaNombreRepuestos();
        List<Marca> listaMarcas = repuestoController.retornarListaMarcas();
        List<Categoria> listaCategorias = repuestoController.retornarCategorias();
        List<Ubicacion> listaUbicaciones = repuestoController.retornarUbicaciones();
        List<Modelo> listaModelos = repuestoController.retornarModelos();
        
        //System.out.println("lista modelo tamaño: " + listaModelos.size());
        
        for(NombreRepuesto nomb : listaNombreRepuestos){
            comboNombreRepuesto.addItem(nomb.getNombre_repuesto());
        }
        
        for(Marca mar : listaMarcas){
            comboMarca.addItem(mar.getNombre_marca());
        }
        
        for(Categoria cat : listaCategorias){
            comboCategoria.addItem(cat.getNombre_categoria());
        }
        
        for(Ubicacion ubi : listaUbicaciones){
            comboUbicacion.addItem(ubi.getNombre_ubicacion());
        }
        
        for(Modelo mod : listaModelos){
            comboModelo.addItem(mod.getNombre_modelo());
        }
        
        //System.out.println("fin carga comboboxes");
    }
    
    
    private void buscarYActualizarTablaRepuestos() {
        
        String marcaSeleccionada = (comboMarca.getSelectedItem() != null) ? comboMarca.getSelectedItem().toString() : "-";
        String categoriaSeleccionada = (comboCategoria.getSelectedItem() != null) ? comboCategoria.getSelectedItem().toString() : "-";
        String nombreRepuestoSeleccionado = (comboNombreRepuesto.getSelectedItem() != null) ? comboNombreRepuesto.getSelectedItem().toString() : "-";
        String ubicacionSeleccionada = (comboUbicacion.getSelectedItem() != null) ? comboUbicacion.getSelectedItem().toString() : "-";
        String modeloSeleccionada = (comboModelo.getSelectedItem() != null) ? comboModelo.getSelectedItem().toString() : "-";
        
        String codigo = "";
        
        if (!txtCodigo.getText().isEmpty()) {
            codigo = txtCodigo.getText();
        }
        
        //System.out.println("comienzo carga de busqueda");
        
        List<Repuesto> listaRepuestosFiltrados = repuestoController.busquedaDeRepuesto(marcaSeleccionada, 
                categoriaSeleccionada, 
                nombreRepuestoSeleccionado, 
                ubicacionSeleccionada, 
                modeloSeleccionada, 
                codigo);
        
        cargarTablaBusquedaRepuestos(listaRepuestosFiltrados);
        
        tablaRepuestos.getColumnModel().getColumn(0).setPreferredWidth(30);
        tablaRepuestos.getColumnModel().getColumn(7).setPreferredWidth(30);
        
    }
    
    private void cargarTablaBusquedaRepuestos(List<Repuesto> listaRepuestosFiltrados){
        //Repuestos
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] titulos = {"Id", "Nombre Repuesto", "Codigo", "Marca", "Modelo",  "Categoria", "Ubicacion", "Stock", "Precio"};
        modeloTabla.setColumnIdentifiers(titulos);

        if (listaRepuestosFiltrados != null) {
            //System.out.println("Tamaño de la lista: " + listaRepuestosFiltrados.size());
            for (Repuesto repuesto : listaRepuestosFiltrados) {
                // Asegurarse de que la lista de precios no esté vacía
                List<Precio> listaPrecios = repuesto.getListaPrecios();
                Object precio = "No disponible"; // Valor predeterminado si la lista está vacía

                if (listaPrecios != null && !listaPrecios.isEmpty()) {
                    precio = listaPrecios.get(listaPrecios.size() - 1).getValor();
                }
                
                int stockBuscado = 0;
                
                for(Repuesto rep : listaRepuestos){
                    if(rep.getId_repuesto() == repuesto.getId_repuesto()){
                        stockBuscado = rep.getStock();
                    }
                }
                
                Object[] objeto = {
                    repuesto.getId_repuesto(),
                    repuesto.getNombreRepuesto() != null ? repuesto.getNombreRepuesto().getNombre_repuesto() : "Desconocido",
                    repuesto.getCodigo(),
                    repuesto.getMarca() != null ? repuesto.getMarca().getNombre_marca() : "Desconocido",
                    repuesto.getModelo()!= null ? repuesto.getModelo().getNombre_modelo(): "Desconocido",
                    repuesto.getCategoria() != null ? repuesto.getCategoria().getNombre_categoria() : "Desconocido",
                    repuesto.getUbicacion() != null ? repuesto.getUbicacion().getNombre_ubicacion() : "Desconocido",
                    stockBuscado,
                    precio
                };
                modeloTabla.addRow(objeto);
            }
        }

        tablaRepuestos.setModel(modeloTabla);
    }

    private void agregarRepuestoSeleccionado(int filaSeleccionada) {
        DefaultTableModel modeloRepuestos = (DefaultTableModel) tablaRepuestos.getModel();
        DefaultTableModel modeloRepuestosSeleccionados = (DefaultTableModel) tablaRepuestosSeleccionados.getModel();
        
        // Obtener datos de la fila seleccionada
        Object idRepuesto = modeloRepuestos.getValueAt(filaSeleccionada, 0);
        Object nombreRepuesto = modeloRepuestos.getValueAt(filaSeleccionada, 1); 
        Object marca = modeloRepuestos.getValueAt(filaSeleccionada, 2);
        Object modelo = modeloRepuestos.getValueAt(filaSeleccionada, 3);
        Object categoria = modeloRepuestos.getValueAt(filaSeleccionada, 4);
        Object codigo = modeloRepuestos.getValueAt(filaSeleccionada, 5);
        Object precio = modeloRepuestos.getValueAt(filaSeleccionada, 8);
        if (precio == null || precio.toString().isEmpty()) {
            precio = BigDecimal.ZERO; // Valor predeterminado si el precio es nulo
        }
        
        for(Repuesto rep : listaRepuestos){
            if(rep.getId_repuesto() == (int) idRepuesto){
                if(rep.getStock() != 0){
                    // Agregar los datos a la tabla de repuestos seleccionados
                    modeloRepuestosSeleccionados.addRow(new Object[]{idRepuesto, nombreRepuesto, marca, modelo, categoria, codigo, precio});

                    //Actualizar Stock del repuesto en listaRepuestos (Quitar 1)
                    rep.setStock(rep.getStock() - 1);  

                    calcularTotalVenta(modeloRepuestosSeleccionados);

                    tablaRepuestosSeleccionados.getColumnModel().getColumn(0).setPreferredWidth(20);
                }else{
                    JOptionPane.showMessageDialog(null, "No hay mas stock del producto.", "Error", JOptionPane.WARNING_MESSAGE);
                    cargarTablaRepuestos();
                }
            }
        }
        cargarTablaRepuestos();
    }
    
    private void eliminarRepuestoSeleccionado(int filaSeleccionada) {
        DefaultTableModel modeloRepuestosSeleccionados = (DefaultTableModel) tablaRepuestosSeleccionados.getModel();
        
        Object idRepuesto = modeloRepuestosSeleccionados.getValueAt(filaSeleccionada, 0);
        
        for(Repuesto rep : listaRepuestos){
            if(rep.getId_repuesto() == (int) idRepuesto){
                // Elimina los datos a la tabla de repuestos seleccionados
                modeloRepuestosSeleccionados.removeRow(filaSeleccionada);

                rep.setStock(rep.getStock() + 1);  

                calcularTotalVenta(modeloRepuestosSeleccionados);
                
                cargarTablaRepuestos();
                
                break;
            }
        }
    }
    
    private void calcularTotalVenta(DefaultTableModel modeloRepuestosSeleccionados){
        BigDecimal total = BigDecimal.ZERO;
        
        for (int i = 0; i < modeloRepuestosSeleccionados.getRowCount(); i++) {
            BigDecimal precioTot = new BigDecimal(modeloRepuestosSeleccionados.getValueAt(i, 6).toString());
            total = total.add(precioTot); // Sumar el precio al total
        }
        
        lblTotal.setText("Total: $" + total.toString());
    }

    
    private void buscarYActualizarTablaClientes() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String domicilio = txtDomicilio.getText();
        
        List<Cliente> listaClientes = clienteController.busquedaDeCliente(nombre, apellido, telefono, domicilio);
        cargarTablaBusquedaClientes(listaClientes);
    }
    
    private void cargarTablaBusquedaClientes(List<Cliente> listaClientes){
        //Hacemos que la tabla no sea editable
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Ponemos titulos a las columnas
        String titulos[] = {"Id", "Nombre", "Apellido", "Telefono", "Domicilio"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        //Setear los datos en la tabla
        if(listaClientes != null){
            //System.out.println("tamaño de la lista: " + listaClientes.size());
            for(Cliente cliente : listaClientes){
                Object[] objeto = {cliente.getId_cliente(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getDomicilio()};
                
                modeloTabla.addRow(objeto);
            }
        }

        tablaClientes.setModel(modeloTabla);
    }

    private void agregarClienteSeleccionado(int filaSeleccionada){
        DefaultTableModel modeloCliente = (DefaultTableModel) tablaClientes.getModel();
        
        // Obtener datos de la fila seleccionada
        Object idCliente = modeloCliente.getValueAt(filaSeleccionada, 0); // Por ejemplo, columna 0 es ID
        Object nombreCliente = modeloCliente.getValueAt(filaSeleccionada, 1); // Columna 1 es Nombre
        Object apellidoCliente = modeloCliente.getValueAt(filaSeleccionada, 2); // Columna 2 es Marca
        Object telefonoCliente = modeloCliente.getValueAt(filaSeleccionada, 3); // Columna 3 es Categoría
        Object domicilioCliente = modeloCliente.getValueAt(filaSeleccionada, 4); // Columna 3 es Categoría
        
        lblNombre.setText("Nombre: " + nombreCliente);
        lblApellido.setText("Apellido: " + apellidoCliente);
        lblTelefono.setText("Telefono: " + telefonoCliente);
        lblDomicilio.setText("Domicilio: " + domicilioCliente);
    }

    
    
}
