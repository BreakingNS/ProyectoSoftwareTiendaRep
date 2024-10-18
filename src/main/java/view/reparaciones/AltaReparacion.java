package view.reparaciones;

import config.NumerosSoloDocumentFilter;
import controller.ClienteController;
import controller.EstadoController;
import controller.FacturaController;
import controller.PagoController;
import controller.ReparacionController;
import controller.RepuestoController;
import controller.VentaController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import model.Estado;
import model.Marca;
import model.Modelo;
import model.NombreRepuesto;
import model.Precio;
import model.Reparacion;
import model.Repuesto;
import model.Tecnico;
import model.Ubicacion;
import view.clientes.AltaCliente;

public class AltaReparacion extends javax.swing.JFrame {

    private final ReparacionController reparacionController;
    private final VentaController ventaController;
    private final RepuestoController repuestoController;
    private final ClienteController clienteController;
    private final EstadoController estadoController;
    private final FacturaController facturaController;
    private final PagoController pagoController;
    
    private final List<Repuesto> listaRepuestos;
    
    private BigDecimal totalRepuesto = BigDecimal.ZERO;
    private BigDecimal costoManoDeObra = BigDecimal.ZERO;
    private BigDecimal costoTotal = BigDecimal.ZERO;
    
    public AltaReparacion(ReparacionController reparacionController, 
            VentaController ventaController, 
            RepuestoController repuestoController, 
            ClienteController clienteController, 
            EstadoController estadoController, 
            FacturaController facturaController, 
            PagoController pagoController
    ) {
        this.reparacionController = reparacionController;
        this.ventaController = ventaController;
        this.repuestoController = repuestoController;
        this.clienteController = clienteController;
        this.estadoController = estadoController;
        this.facturaController = facturaController;
        this.pagoController = pagoController;
        
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
        lblCliente = new javax.swing.JLabel();
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
        lblFechaDevolucion = new javax.swing.JLabel();
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
        lblEstado = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaDetalles = new javax.swing.JTextArea();
        lblCosto = new javax.swing.JLabel();
        comboEstado2 = new javax.swing.JComboBox<>();
        comboTecnico = new javax.swing.JComboBox<>();
        comboCategoria2 = new javax.swing.JComboBox<>();
        txtManoDeObra = new javax.swing.JTextField();
        lblCosto1 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblDetalles1 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        comboModelo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lblDetalles2 = new javax.swing.JLabel();
        comboFechaDevolucion1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("Alta Reparacion");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("Buscar Repuesto:");

        lblCliente.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblCliente.setText("Cliente: ...                     ");

        btnAtras.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnGuardar.setText("SIGUIENTE");
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

        btnCheckR.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnCheckR.setForeground(new java.awt.Color(102, 255, 102));
        btnCheckR.setText("✔");
        btnCheckR.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setText("Repuestos Seleccionados:");

        lblFechaDevolucion.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblFechaDevolucion.setText("Fecha de Devolucion: ");

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

        lblEstado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblEstado.setText("Estado:");

        lblFechaIngreso.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblFechaIngreso.setText("Fecha de Ingreso: ");

        lblCategoria.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCategoria.setText("Categoria:");

        txtAreaDetalles.setColumns(20);
        txtAreaDetalles.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtAreaDetalles.setLineWrap(true);
        txtAreaDetalles.setRows(5);
        txtAreaDetalles.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtAreaDetalles);

        lblCosto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCosto.setText("Mano de Obra:");

        comboEstado2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboEstado2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboTecnico.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboTecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboCategoria2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboCategoria2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtManoDeObra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblCosto1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCosto1.setText("Costo Total:");

        txtCosto.setEditable(false);
        txtCosto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setText("NUEVO CLIENTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblDetalles1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDetalles1.setText("Detalles: ");

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

        jLabel15.setText("Domicilio");

        comboModelo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setText("Modelo");

        txtCodigo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoFocusLost(evt);
            }
        });

        jLabel17.setText("Codigo");

        lblDetalles2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDetalles2.setText("Tecnico a cargo: ");

        comboFechaDevolucion1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboFechaDevolucion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboNombreRepuesto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(comboUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiarFiltroR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFechaDevolucion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboFechaDevolucion1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEstado2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDetalles2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDetalles1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCosto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtManoDeObra, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCosto1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiarFiltroC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(613, 613, 613)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(532, 532, 532)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 522, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLimpiarFiltroC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(comboCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboNombreRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(comboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLimpiarFiltroR, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCheckR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstado)
                            .addComponent(comboEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFechaIngreso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFechaDevolucion)
                                    .addComponent(comboFechaDevolucion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDetalles2))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtManoDeObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCosto))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCosto1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblDetalles1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        
        List<Repuesto> listaRepuestosSeleccionados = new ArrayList<>();
        
        //Cliente
        int idCliente = 0;
        BigDecimal precioFinal= BigDecimal.ZERO;

        int filaClienteSeleccionada = tablaClientes.getSelectedRow();
        if (filaClienteSeleccionada != -1) {
            idCliente = Integer.parseInt(tablaClientes.getValueAt(filaClienteSeleccionada, 0).toString());
        }

        Cliente cliente = clienteController.obtenerClientePorId(idCliente);
        
        //Repuestos Seleccionados
                
        if(tablaRepuestosSeleccionados.getRowCount() != 0){
            DefaultTableModel modelo = (DefaultTableModel) tablaRepuestosSeleccionados.getModel();
            int rowCount = modelo.getRowCount();

            for (int i = 0; i < rowCount; i++) {
                int idRepuesto = (int) modelo.getValueAt(i, 0);

                Repuesto repuesto = repuestoController.obtenerRepuestoPorId(idRepuesto);
                precioFinal = precioFinal.add(repuesto.getListaPrecios().get(repuesto.getListaPrecios().size()-1).getValor());

                listaRepuestosSeleccionados.add(repuesto);
            }
        }
                
        //Reparacion
        
        LocalDateTime ahora = LocalDateTime.now();
        Categoria categoriaSeleccionada = new Categoria();
        Estado estadoSeleccionado = new Estado();
        Tecnico tecnicoSeleccionado = new Tecnico();
        LocalDateTime fechaIngresoAhora = LocalDateTime.now();
        LocalDateTime fechaDevolucion = LocalDateTime.now();
        String detalles = txtAreaDetalles.getText();
        
        List<Categoria> listaCategorias = repuestoController.retornarCategorias();
        for(Categoria cat : listaCategorias){
            if(cat.getNombre_categoria().equals(comboCategoria2.getSelectedItem().toString())){
                categoriaSeleccionada = cat;
                break;
            }
        }
                
        String estadoObtenido = comboEstado2.getSelectedItem().toString();
        List<Estado> listaEstados = estadoController.listarEstados();
        for(Estado est : listaEstados){
            if(est.getNombre_estado().equals(comboEstado2.getSelectedItem().toString())){
                estadoSeleccionado = est;
                break;
            }
        }
        
        List<Tecnico> listaTecnicos = repuestoController.retornarTecnicos();
        if(comboTecnico.getSelectedItem().equals(" - ")){
            tecnicoSeleccionado = null;
        }
        else{
            for(Tecnico tec : listaTecnicos){
                if((tec.getApellido_tecnico() + " " + tec.getNombre_tecnico()).equals(comboTecnico.getSelectedItem().toString())){
                    tecnicoSeleccionado = tec;
                    break;
                }
            }
        }
        
        LocalDateTime fechaIngresoObtenida = ahora;
        String fechaDevolucionObtenida = comboFechaDevolucion1.getSelectedItem().toString();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEEE, dd-MM-yyyy", new Locale("es", "ES"));
        LocalDate fecha;
        
        if(fechaDevolucionObtenida.equals(" - ")){
            fechaDevolucion = LocalDateTime.of(1900, 1, 1, 0, 0);  // Asigna 1900-01-01 00:00
        } else {
            fecha = LocalDate.parse(fechaDevolucionObtenida, formato);
            fechaDevolucion = fecha.atStartOfDay().truncatedTo(ChronoUnit.SECONDS);
        }
        
        LocalDateTime fechaIngreso = fechaIngresoAhora.truncatedTo(ChronoUnit.SECONDS);

        Reparacion reparacion = new Reparacion(1, costoTotal, detalles, fechaIngreso, fechaDevolucion, null, categoriaSeleccionada, cliente, estadoSeleccionado, tecnicoSeleccionado);
        
        this.setEnabled(false);
        VistaPago alta = new VistaPago(facturaController, reparacionController, pagoController, precioFinal, costoTotal, reparacion, listaRepuestosSeleccionados);
        //alta.setSize(600, 400);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);
        
        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                AltaReparacion.this.setEnabled(true);
                AltaReparacion.this.setState(JFrame.NORMAL);  
                AltaReparacion.this.toFront();                
                AltaReparacion.this.requestFocus();  
                cargarTablas(); // Actualiza la tabla después de cerrar AltaCliente.
                dispose();
            }
        });
        
    }//GEN-LAST:event_btnGuardarActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed
    private void btnLimpiarFiltroRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltroRActionPerformed
        comboCategoria.setSelectedItem("-");
        comboMarca.setSelectedItem("-");
        comboNombreRepuesto.setSelectedItem("-");
        comboUbicacion.setSelectedItem("-");
        comboModelo.setSelectedItem("-");
        txtCodigo.setText("");
    }//GEN-LAST:event_btnLimpiarFiltroRActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTablas();
    }//GEN-LAST:event_formWindowOpened

    private void txtDomicilioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDomicilioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioFocusGained

    private void txtDomicilioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDomicilioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioFocusLost

    private void txtDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioActionPerformed

    private void txtCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoFocusGained

    private void txtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
                AltaReparacion.this.setEnabled(true);
                AltaReparacion.this.setState(JFrame.NORMAL);  
                AltaReparacion.this.toFront();                
                AltaReparacion.this.requestFocus();  
                cargarTablaClientes(); // Actualiza la tabla después de cerrar AltaCliente.
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCheckR;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiarFiltroC;
    private javax.swing.JButton btnLimpiarFiltroR;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboCategoria2;
    private javax.swing.JComboBox<String> comboEstado2;
    private javax.swing.JComboBox<String> comboFechaDevolucion1;
    private javax.swing.JComboBox<String> comboMarca;
    private javax.swing.JComboBox<String> comboModelo;
    private javax.swing.JComboBox<String> comboNombreRepuesto;
    private javax.swing.JComboBox<String> comboTecnico;
    private javax.swing.JComboBox<String> comboUbicacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblCosto1;
    private javax.swing.JLabel lblDetalles1;
    private javax.swing.JLabel lblDetalles2;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaDevolucion;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaRepuestos;
    private javax.swing.JTable tablaRepuestosSeleccionados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextArea txtAreaDetalles;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtManoDeObra;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void cargarTablas(){
        
        //Tabla Repuestos
        cargarTablaRepuestos();
        
        //Tabla Clientes
        cargarTablaClientes();
        
        //Tabla RepuestosSeleccionados
        cargarTablaRepuestosSeleccionados();
        
        JTableHeader header = tablaClientes.getTableHeader();
        JTableHeader header1 = tablaRepuestos.getTableHeader();
        JTableHeader header2 = tablaRepuestosSeleccionados.getTableHeader();
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
    
    private void cargarTablaClientes(){
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
            for(Cliente cliente : listaClientes){
                Object[] objeto = {cliente.getId_cliente(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getDomicilio()};
                
                modeloTabla1.addRow(objeto);
            }
        }

        tablaClientes.setModel(modeloTabla1);
    }
    
    private void cargarTablaRepuestosSeleccionados(){
        DefaultTableModel modeloTabla2 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String[] titulos2 = {"Id", "Nombre Repuesto", "Codigo", "Marca", "Modelo", "Categoria", "Precio"};
        modeloTabla2.setColumnIdentifiers(titulos2);
        
        tablaRepuestosSeleccionados.setModel(modeloTabla2);
        
        tablaRepuestosSeleccionados.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablaRepuestosSeleccionados.getColumnModel().getColumn(5).setPreferredWidth(100);
    }
    
    private void configurarListeners() {
        
        // ActionListener para los JComboBox
        ActionListener comboListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarYActualizarTablaRepuestos(); // Actualiza la tabla cuando seleccionas una opciÃ³n en los ComboBox
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
                // Este mÃ©todo no se usa en la mayorÃ­a de las implementaciones de DocumentListener
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
                // No es necesario si eliminas el botÃ³n
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
                // Este mÃ©todo no se usa en la mayorÃ­a de las implementaciones de DocumentListener
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

        // Listener para cambios en tablaRepuestosSeleccionados
        tablaRepuestosSeleccionados.getModel().addTableModelListener(e -> actualizarEstadoBoton());

        // Agregar un ListSelectionListener para tablaRepuestosSeleccionados
        tablaRepuestosSeleccionados.getSelectionModel().addListSelectionListener(e -> actualizarEstadoBoton());
        
        //Habilitar el boton despues de
        
        tablaClientes.getSelectionModel().addListSelectionListener(e -> {
            actualizarEstadoBoton(); // Llamar al método cada vez que cambias el cliente
        });

        // Listener para seleccionar repuestos
        btnCheckR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaRepuestos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    agregarRepuestoSeleccionado(filaSeleccionada);
                    actualizarEstadoBoton();
                }
            }
        });

        // Listener en combo boxes
        comboCategoria2.addActionListener(e -> actualizarEstadoBoton());
        comboEstado2.addActionListener(e -> actualizarEstadoBoton());
        
        
        // Listener para el campo txtManoDeObra
        txtManoDeObra.getDocument().addDocumentListener(docBtnListener);
        
        // Configurar el DocumentListener para el costoTotal
        txtManoDeObra.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarValor();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarValor();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarValor();
            }

            // Método para actualizar el valor de la variable
            private void actualizarValor() {
                try {
                    // Verificar si el campo de texto está vacío
                    String texto = txtManoDeObra.getText().trim();
                    if (texto.isEmpty()) {
                        costoManoDeObra = BigDecimal.ZERO; // Valor por defecto si está vacío
                    } else {
                        // Obtener el texto del JTextField y convertirlo a BigDecimal
                        costoManoDeObra = new BigDecimal(texto);
                    }
                    calcularValorTotal();
                } catch (NumberFormatException e) {
                    // Manejar caso en que el texto no sea un número válido
                    costoManoDeObra = BigDecimal.ZERO; // Valor por defecto si no es válido
                    calcularValorTotal();
                }
            }
        });
        
    }
    
    private void actualizarEstadoBoton() {
        boolean clienteSeleccionado = tablaClientes.getSelectedRow() != -1; // Verifica si hay fila seleccionada en tablaClientes
        boolean categoriaSeleccionada = !comboCategoria2.getSelectedItem().toString().equals(" - "); // Verifica que la categoría no sea " - "
        boolean estadoSeleccionado = !comboEstado2.getSelectedItem().toString().equals(" - "); // Verifica que el estado no sea " - "
        boolean manoDeObraDeclarada = !txtManoDeObra.getText().isEmpty();
        
        // Habilita el botón solo si todas las condiciones son verdaderas
        btnGuardar.setEnabled(clienteSeleccionado && categoriaSeleccionada && estadoSeleccionado && manoDeObraDeclarada);
    }

    
    public void calcularValorTotal(){
        costoTotal = totalRepuesto.add(costoManoDeObra) ;
        txtCosto.setText(costoTotal.toString());
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
                        agregarRepuestoSeleccionado(filaSeleccionada); // MÃ©todo para agregar a la tabla de seleccionados
                    }
                }
            }
        });
        // En el botón de selección
        btnCheckR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaRepuestos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    agregarRepuestoSeleccionado(filaSeleccionada);
                    actualizarEstadoBoton(); // Llamar al método después de agregar el repuesto
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
        
        //--------------- Combos Repuestos
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
        
        comboCategoria.addItem(categoria.getNombre_categoria());
        comboMarca.addItem(marca.getNombre_marca());
        comboNombreRepuesto.addItem(nombreRepuesto.getNombre_repuesto());
        comboUbicacion.addItem(ubicacion.getNombre_ubicacion());
        comboModelo.addItem(modelo.getNombre_modelo());
        
        List<NombreRepuesto> listaNombreRepuestos = repuestoController.retornarListaNombreRepuestos();
        List<Marca> listaMarcas = repuestoController.retornarListaMarcas();
        List<Categoria> listaCategorias = repuestoController.retornarCategorias();
        List<Ubicacion> listaUbicaciones = repuestoController.retornarUbicaciones();
        List<Modelo> listaModelos = repuestoController.retornarModelos();
        
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
        //--------------- Combos Reparacion
        
        comboCategoria2.removeAllItems();
        comboEstado2.removeAllItems();
        comboFechaDevolucion1.removeAllItems();
        comboTecnico.removeAllItems();
        
        Categoria categoria2 = new Categoria(0, " - ", new ArrayList<>(), new ArrayList<>());
        Estado estado2 = new Estado(0, " - ", new ArrayList<>());
        Tecnico tecnico = new Tecnico(0, "", " - ", "", "", new ArrayList<>());
        
        comboCategoria2.addItem(categoria2.getNombre_categoria());
        comboEstado2.addItem(estado2.getNombre_estado());
        comboTecnico.addItem(tecnico.getApellido_tecnico() + " " + tecnico.getNombre_tecnico());
        
        List<Categoria> listaCategorias2 = repuestoController.retornarCategorias();
        List<Estado> listaEstado2 = reparacionController.obtenerEstados();
        List<Tecnico> listaTecnicos = repuestoController.retornarTecnicos();
        
        for(Categoria cat : listaCategorias2){
            comboCategoria2.addItem(cat.getNombre_categoria());
        }
        
        int i = 0;
        
        for(Estado est : listaEstado2){
            i++;
            comboEstado2.addItem(est.getNombre_estado());
        }
        
        for(Tecnico tec : listaTecnicos){
            comboTecnico.addItem(tec.getApellido_tecnico() + " " + tec.getNombre_tecnico());
        }
        
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatoDiasHoras = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
        String fechaIngreso = ahora.format(formatoDiasHoras);
        lblFechaIngreso.setText("Fecha de Ingreso: " + fechaIngreso);
        
        Calendar cal = Calendar.getInstance(); // Fecha actual
        SimpleDateFormat formato = new SimpleDateFormat("EEEE, dd-MM-yyyy", new Locale("es", "ES"));

        comboFechaDevolucion1.addItem(" - ");
        
        for (i = 0; i < 14; i++) {
            Date fecha = cal.getTime();

            // Verifica si es domingo
            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                String fechaFormateada = formato.format(fecha);
                comboFechaDevolucion1.addItem(fechaFormateada);
            }

            cal.add(Calendar.DAY_OF_MONTH, 1); // Incrementar un día
        }
        
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

                    calcularTotalReparacion(modeloRepuestosSeleccionados);
                    
                    tablaRepuestosSeleccionados.getColumnModel().getColumn(0).setPreferredWidth(20);
                    tablaRepuestosSeleccionados.getColumnModel().getColumn(5).setPreferredWidth(100);

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

                calcularTotalReparacion(modeloRepuestosSeleccionados);
                
                cargarTablaRepuestos();
                
                break;
            }
        }
    }
    
    private void calcularTotalReparacion(DefaultTableModel modeloRepuestosSeleccionados){
        BigDecimal total = BigDecimal.ZERO;
        
        for (int i = 0; i < modeloRepuestosSeleccionados.getRowCount(); i++) {
            BigDecimal precioTot = new BigDecimal(modeloRepuestosSeleccionados.getValueAt(i, 6).toString());
            total = total.add(precioTot); // Sumar el precio al total
        }
        
        if(total != BigDecimal.ZERO){
            totalRepuesto = total;
        }
        else{
            totalRepuesto = BigDecimal.ZERO;
        }
        
        calcularValorTotal();
        
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
        //Object idCliente = modeloCliente.getValueAt(filaSeleccionada, 0); // Por ejemplo, columna 0 es ID
        Object nombreCliente = modeloCliente.getValueAt(filaSeleccionada, 1); // Columna 1 es Nombre
        Object apellidoCliente = modeloCliente.getValueAt(filaSeleccionada, 2); // Columna 2 es Marca
        
        lblCliente.setText("Cliente: " + apellidoCliente + " " + nombreCliente);
    }
}
