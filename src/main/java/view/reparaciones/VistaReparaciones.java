package view.reparaciones;

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
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
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
import model.Categoria;
import model.Cliente;
import model.Estado;
import model.Factura;
import model.Pago;
import model.Precio;
import model.Reparacion;
import model.Repuesto;
import model.Tecnico;

public class VistaReparaciones extends javax.swing.JFrame {
    
    private final ReparacionController reparacionController;
    private final VentaController ventaController;
    private final RepuestoController repuestoController; 
    private final ClienteController clienteController; 
    private final EstadoController estadoController;
    private final FacturaController facturaController; 
    private final PagoController pagoController;
    
    private String id_cliente_seleccionado;
    
    public VistaReparaciones(ReparacionController reparacionController, 
            VentaController ventaController, 
            RepuestoController repuestoController, 
            ClienteController clienteController,
            EstadoController estadoController,
            FacturaController facturaController,
            PagoController pagoController) {
        this.reparacionController = reparacionController;
        this.ventaController = ventaController;
        this.repuestoController = repuestoController;
        this.clienteController = clienteController;
        this.estadoController = estadoController;
        this.facturaController = facturaController;
        this.pagoController = pagoController;
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReparaciones = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalleReparacion = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblIdReparacion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        lblManoDeObra = new javax.swing.JLabel();
        lblFechaDevolucion = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaDetalles = new javax.swing.JTextArea();
        lblPrecioFinal4 = new javax.swing.JLabel();
        lblIdVenta1 = new javax.swing.JLabel();
        lblCostoTotal = new javax.swing.JLabel();
        lblTotalRepuestos = new javax.swing.JLabel();
        lblPagado = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDetallePagos = new javax.swing.JTable();
        lblIdVenta2 = new javax.swing.JLabel();
        lblTecnico = new javax.swing.JLabel();
        btnActualizarPago = new javax.swing.JButton();
        comboTecnico = new javax.swing.JComboBox<>();
        comboEstado = new javax.swing.JComboBox<>();
        comboCategoria = new javax.swing.JComboBox<>();
        txtIdCliente = new javax.swing.JTextField();
        btnActualizarTecnico = new javax.swing.JButton();
        btnActualizarEstado = new javax.swing.JButton();
        btnSeleccionarCliente = new javax.swing.JButton();
        btnActualizarRepuestos = new javax.swing.JButton();
        btnLimpiarBusqueda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("REPARACIONES");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Buscar:");

        jLabel3.setText("Categoria");

        jLabel5.setText("Estado");

        jLabel6.setText("Tecnico");

        jLabel7.setText("Cliente");

        btnAgregar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnActualizar.setText("LIMPIAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        tablaReparaciones.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tablaReparaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaReparaciones.setRowHeight(20);
        tablaReparaciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaReparaciones);

        tablaDetalleReparacion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tablaDetalleReparacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaDetalleReparacion.setRowHeight(20);
        tablaDetalleReparacion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tablaDetalleReparacion);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setText("Detalle de Reparacion:                  ");

        lblCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblCategoria.setText("Categoria:                  ");

        lblIdReparacion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblIdReparacion.setText("Id Reparacion:                ");

        lblTelefono.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTelefono.setText("Telefono:                  ");

        lblCliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblCliente.setText("Cliente:                              ");

        lblFechaIngreso.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFechaIngreso.setText("Fecha Ingreso:                     ");

        lblManoDeObra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblManoDeObra.setText("Mano de Obra: $0                  ");

        lblFechaDevolucion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFechaDevolucion.setText("Fecha Devolucion:                   ");

        txtAreaDetalles.setEditable(false);
        txtAreaDetalles.setColumns(20);
        txtAreaDetalles.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtAreaDetalles.setLineWrap(true);
        txtAreaDetalles.setRows(5);
        txtAreaDetalles.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtAreaDetalles);

        lblPrecioFinal4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblPrecioFinal4.setText("Detalles:");

        lblIdVenta1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblIdVenta1.setText("Lista de Repuestos:                  ");

        lblCostoTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblCostoTotal.setText("Costo: $0                 ");

        lblTotalRepuestos.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTotalRepuestos.setText("Total Repuestos: $0             ");

        lblPagado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblPagado.setText("Pagado:     ");

        tablaDetallePagos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tablaDetallePagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaDetallePagos.setRowHeight(20);
        jScrollPane3.setViewportView(tablaDetallePagos);

        lblIdVenta2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblIdVenta2.setText("Lista de Pagos:                  ");

        lblTecnico.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTecnico.setText("Tecnico:                              ");

        btnActualizarPago.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnActualizarPago.setText("ACTUALIZAR PAGO");
        btnActualizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPagoActionPerformed(evt);
            }
        });

        comboTecnico.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboTecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboEstado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtIdCliente.setEditable(false);
        txtIdCliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnActualizarTecnico.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnActualizarTecnico.setText("ACTUALIZAR TECNICO");
        btnActualizarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTecnicoActionPerformed(evt);
            }
        });

        btnActualizarEstado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnActualizarEstado.setText("ACTUALIZAR ESTADO");
        btnActualizarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEstadoActionPerformed(evt);
            }
        });

        btnSeleccionarCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSeleccionarCliente.setText("SELECCIONAR CLIENTE");
        btnSeleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarClienteActionPerformed(evt);
            }
        });

        btnActualizarRepuestos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        btnActualizarRepuestos.setText("ACTUALIZAR REPUESTOS");
        btnActualizarRepuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarRepuestosActionPerformed(evt);
            }
        });

        btnLimpiarBusqueda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLimpiarBusqueda.setText("LIMPIAR");
        btnLimpiarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(comboTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiarBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIdVenta2)
                                    .addComponent(lblTotalRepuestos)
                                    .addComponent(lblIdVenta1)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaIngreso)
                            .addComponent(lblIdReparacion)
                            .addComponent(lblFechaDevolucion)
                            .addComponent(lblCliente)
                            .addComponent(lblTelefono)
                            .addComponent(lblTecnico)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPrecioFinal4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCostoTotal)
                            .addComponent(lblManoDeObra)
                            .addComponent(lblPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoria))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(278, 278, 278)))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnActualizarTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnActualizarRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboEstado)
                            .addComponent(btnLimpiarBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeleccionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIdVenta1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotalRepuestos)
                                .addGap(11, 11, 11)
                                .addComponent(lblIdVenta2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblIdReparacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFechaIngreso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFechaDevolucion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTecnico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrecioFinal4)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblPagado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblManoDeObra)
                                .addGap(2, 2, 2)
                                .addComponent(lblCostoTotal)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        setVisible(false);
        AltaReparacion alta = new AltaReparacion(reparacionController, ventaController, repuestoController, clienteController, estadoController, facturaController, pagoController);
        //alta.setSize(600, 400);
        alta.setTitle("Software ElectroClima");
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocation(-8, 0);
        //alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                setVisible(true);
                cargarTablas(); // Actualiza la tabla después de cerrar AltaVenta.
            }
        });
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTablas();
        configurarListeners();
        btnLimpiarBusqueda.doClick();
        lblIdReparacion.setText("Id Reparacion: ");
        lblCategoria.setText("Categoria: ");
        lblFechaIngreso.setText("Fecha Ingreso: ");
        lblFechaDevolucion.setText("Fecha Devolucion: ");
        lblCliente.setText("Cliente: ");
        lblTelefono.setText("Telefono: ");
        lblTecnico.setText("Tecnico: ");
        txtAreaDetalles.setText("");
        lblPagado.setText("Pagado: ");
        lblManoDeObra.setText("Mano de Obra: ");
        lblCostoTotal.setText("Costo: ");
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de que desea eliminar esta REPARACION? se agregara el stock de cada REPUESTO si posee",
            "Confirmar eliminacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (opcion == JOptionPane.YES_OPTION) {
            int idReparacion = 0;

            if(tablaReparaciones.getRowCount() > 0){
                if(tablaReparaciones.getSelectedRow()!=-1){
                    idReparacion = Integer.parseInt(String.valueOf(tablaReparaciones.getValueAt(tablaReparaciones.getSelectedRow(), 0)));
                }
            }

            try {
                reparacionController.eliminarReparacion(idReparacion);
                JOptionPane.showMessageDialog(null, "Eliminación realizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException ex) {
                Logger.getLogger(VistaReparaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargarTablas();
            configurarListeners();
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTablas();
    }//GEN-LAST:event_formWindowOpened

    private void btnActualizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPagoActionPerformed
        
        if(tablaReparaciones.getRowCount() > 0){
            if(tablaReparaciones.getSelectedRow()!=-1){

                int idReparacion = Integer.parseInt(String.valueOf(tablaReparaciones.getValueAt(tablaReparaciones.getSelectedRow(), 0)));
                Reparacion reparacion = reparacionController.obtenerReparacionPorId(idReparacion);
                Factura factura = facturaController.obtenerFacturaPorId(reparacion.getFactura().getId_factura());
                
                BigDecimal precioFinal = BigDecimal.ZERO;
                List<Repuesto> listaRepuestos = new ArrayList<>();
                BigDecimal costoTotal = reparacion.getCosto();
                
                DefaultTableModel modelo = (DefaultTableModel) tablaDetalleReparacion.getModel();
                int rowCount = modelo.getRowCount();

                for (int i = 0; i < rowCount; i++) {
                    int idRepuesto = (int) modelo.getValueAt(i, 0);

                    Repuesto repuesto = repuestoController.obtenerRepuestoPorId(idRepuesto);
                    precioFinal = precioFinal.add(repuesto.getListaPrecios().get(repuesto.getListaPrecios().size()-1).getValor());

                    listaRepuestos.add(repuesto);
                }
                

                int idFactura = reparacion.getFactura().getId_factura();
                /*
                System.out.println("\n--------------------0");
                System.out.println("id reparacion: " + reparacion.getId_reparacion());
                System.out.println("cliente: " + reparacion.getCliente().getApellido().concat(" " + reparacion.getCliente().getNombre()));
                System.out.println("precio final: " + precioFinal);
                System.out.println("costo: " + reparacion.getCosto());
                System.out.println("factura: " + reparacion.getFactura().getId_factura());
                System.out.println("cantidad de repuestos: " + listaRepuestos.size());
                System.out.println("-----Factura");
                System.out.println("id factura: " + reparacion.getFactura().getId_factura());
                System.out.println("monto total: " + reparacion.getFactura().getMontoTotal());
                System.out.println("estado: " + reparacion.getFactura().getEstado());
                */
                this.setEnabled(false);
                ActualizarPago alta = new ActualizarPago(facturaController, 
                        reparacionController, 
                        pagoController, 
                        idFactura, 
                        precioFinal, 
                        costoTotal, 
                        reparacion, 
                        listaRepuestos);
                //alta.setSize(600, 400);
                alta.setTitle("Software ElectroClima");
                alta.setResizable(false);
                alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                alta.setVisible(true);
                alta.setLocationRelativeTo(null);

                alta.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        VistaReparaciones.this.setEnabled(true);
                        VistaReparaciones.this.setState(JFrame.NORMAL);  
                        VistaReparaciones.this.toFront();                
                        VistaReparaciones.this.requestFocus();  
                        cargarTablas(); // Actualiza la tabla después de cerrar AltaVenta.
                        //btnActualizar.doClick();
                        buscarYActualizarTabla();
                    }
                });

            }
        }
    }//GEN-LAST:event_btnActualizarPagoActionPerformed

    private void btnActualizarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTecnicoActionPerformed
        if(tablaReparaciones.getRowCount() > 0){
            if(tablaReparaciones.getSelectedRow()!=-1){

                int idReparacion = Integer.parseInt(String.valueOf(tablaReparaciones.getValueAt(tablaReparaciones.getSelectedRow(), 0)));
                Reparacion reparacion = reparacionController.obtenerReparacionPorId(idReparacion);
                Factura factura = facturaController.obtenerFacturaPorId(reparacion.getFactura().getId_factura());
                
                BigDecimal precioFinal = BigDecimal.ZERO;
                List<Repuesto> listaRepuestos = new ArrayList<>();
                BigDecimal costoTotal = reparacion.getCosto();
                
                DefaultTableModel modelo = (DefaultTableModel) tablaDetalleReparacion.getModel();
                int rowCount = modelo.getRowCount();

                for (int i = 0; i < rowCount; i++) {
                    int idRepuesto = (int) modelo.getValueAt(i, 0);

                    Repuesto repuesto = repuestoController.obtenerRepuestoPorId(idRepuesto);
                    precioFinal = precioFinal.add(repuesto.getListaPrecios().get(repuesto.getListaPrecios().size()-1).getValor());

                    listaRepuestos.add(repuesto);
                }
                
                int idFactura = reparacion.getFactura().getId_factura();
                
                this.setEnabled(false);
                ActualizarTecnico alta = new ActualizarTecnico(reparacionController, reparacion);
                //alta.setSize(600, 400);
                alta.setTitle("Software ElectroClima");
                alta.setResizable(false);
                alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                alta.setVisible(true);
                alta.setLocationRelativeTo(null);

                alta.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        VistaReparaciones.this.setEnabled(true);
                        VistaReparaciones.this.setState(JFrame.NORMAL);  
                        VistaReparaciones.this.toFront();                
                        VistaReparaciones.this.requestFocus();  
                        cargarTablas(); // Actualiza la tabla después de cerrar AltaVenta.
                        //btnActualizar.doClick();
                        buscarYActualizarTabla();
                    }
                });

            }
        }
    }//GEN-LAST:event_btnActualizarTecnicoActionPerformed

    private void btnActualizarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEstadoActionPerformed
        if(tablaReparaciones.getRowCount() > 0){
            if(tablaReparaciones.getSelectedRow()!=-1){

                int idReparacion = Integer.parseInt(String.valueOf(tablaReparaciones.getValueAt(tablaReparaciones.getSelectedRow(), 0)));
                Reparacion reparacion = reparacionController.obtenerReparacionPorId(idReparacion);
                   
                this.setEnabled(false);
                ActualizarEstado alta = new ActualizarEstado(reparacionController, reparacion);
                //alta.setSize(600, 400);
                alta.setTitle("Software ElectroClima");
                alta.setResizable(false);
                alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                alta.setVisible(true);
                alta.setLocationRelativeTo(null);

                alta.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        VistaReparaciones.this.setEnabled(true);
                        VistaReparaciones.this.setState(JFrame.NORMAL);  
                        VistaReparaciones.this.toFront();                
                        VistaReparaciones.this.requestFocus();  
                        cargarTablas(); // Actualiza la tabla después de cerrar AltaVenta.
                        //btnActualizar.doClick();
                        buscarYActualizarTabla();
                    }
                });

            }
        }
    }//GEN-LAST:event_btnActualizarEstadoActionPerformed

    private void btnSeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarClienteActionPerformed
        SeleccionarCliente alta = new SeleccionarCliente(this, clienteController);
        //alta.setSize(600, 400);
        alta.setTitle("Software ElectroClima");
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas(); // Actualiza la tabla después de cerrar AltaVenta.
                buscarYActualizarTabla();
            }
        });
    }//GEN-LAST:event_btnSeleccionarClienteActionPerformed

    private void btnActualizarRepuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarRepuestosActionPerformed
        if(tablaReparaciones.getRowCount() > 0){
            if(tablaReparaciones.getSelectedRow()!=-1){

                int idReparacion = Integer.parseInt(String.valueOf(tablaReparaciones.getValueAt(tablaReparaciones.getSelectedRow(), 0)));
                Reparacion reparacion = reparacionController.obtenerReparacionPorId(idReparacion);
                List<Repuesto> listaRepuestos = repuestoController.obtenerRepuestosPorIdReparacion(idReparacion);
                /*
                System.out.println("\n--------------------1");
                System.out.println("id reparacion: " + reparacion.getId_reparacion());
                System.out.println("cliente: " + reparacion.getCliente().getApellido().concat(" " + reparacion.getCliente().getNombre()));
                System.out.println("costo: " + reparacion.getCosto());
                System.out.println("factura: " + reparacion.getFactura().getId_factura());
                */
                setVisible(false);
                ActualizarRepuestos alta = new ActualizarRepuestos(reparacionController, ventaController, repuestoController, clienteController, estadoController, facturaController, pagoController, listaRepuestos, reparacion);
                //alta.setSize(600, 400);
                alta.setTitle("Software ElectroClima");
                alta.setResizable(false);
                alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                alta.setVisible(true);
                alta.setLocation(-8, 0);
                //alta.setLocationRelativeTo(null);
                
                alta.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        //btnActualizar.doClick();
                        buscarYActualizarTabla();
                        setVisible(true);
                    }
                });
            }
        }
    }//GEN-LAST:event_btnActualizarRepuestosActionPerformed

    private void btnLimpiarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarBusquedaActionPerformed
        comboCategoria.setSelectedItem("-");
        comboEstado.setSelectedItem("-");
        comboTecnico.setSelectedItem("-");
        
        txtIdCliente.setText("");
        

    }//GEN-LAST:event_btnLimpiarBusquedaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarEstado;
    private javax.swing.JButton btnActualizarPago;
    private javax.swing.JButton btnActualizarRepuestos;
    private javax.swing.JButton btnActualizarTecnico;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiarBusqueda;
    private javax.swing.JButton btnSeleccionarCliente;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboTecnico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCostoTotal;
    private javax.swing.JLabel lblFechaDevolucion;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblIdReparacion;
    private javax.swing.JLabel lblIdVenta1;
    private javax.swing.JLabel lblIdVenta2;
    private javax.swing.JLabel lblManoDeObra;
    private javax.swing.JLabel lblPagado;
    private javax.swing.JLabel lblPrecioFinal4;
    private javax.swing.JLabel lblTecnico;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTotalRepuestos;
    private javax.swing.JTable tablaDetallePagos;
    private javax.swing.JTable tablaDetalleReparacion;
    private javax.swing.JTable tablaReparaciones;
    private javax.swing.JTextArea txtAreaDetalles;
    private javax.swing.JTextField txtIdCliente;
    // End of variables declaration//GEN-END:variables

    private void cargarTablas(){
        
        //Traer Ventas desde la base de datos
        List<Reparacion> listaReparaciones = reparacionController.listarReparacionesOrdenadasPorFechaActual();
        
        cargarTablaReparaciones(listaReparaciones);
        
        //Tabla Detalles Repuestos
        DefaultTableModel modeloTablaSeleccion = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Ponemos titulos a las columnas
        String titulosSeleccion[] = {"Id", "Repuesto", "Marca", "Categoria", "Precio"};
        modeloTablaSeleccion.setColumnIdentifiers(titulosSeleccion);
        
        tablaDetalleReparacion.setModel(modeloTablaSeleccion);
        
        tablaDetalleReparacion.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablaDetalleReparacion.getColumnModel().getColumn(1).setPreferredWidth(100);
        tablaDetalleReparacion.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaDetalleReparacion.getColumnModel().getColumn(3).setPreferredWidth(100);
        tablaDetalleReparacion.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        //Tabla Detalles Pagos
        DefaultTableModel modeloTablaPagos = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };        
        
        //Ponemos titulos a las columnas
        String titulosPagos[] = {"Id", "Monto Abonado", "Fecha Pago", "Detalle"};
        modeloTablaPagos.setColumnIdentifiers(titulosPagos);
        
        tablaDetallePagos.setModel(modeloTablaPagos);
        
        tablaDetallePagos.getColumnModel().getColumn(0).setPreferredWidth(30);
        tablaDetallePagos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tablaDetallePagos.getColumnModel().getColumn(2).setPreferredWidth(150);
        tablaDetallePagos.getColumnModel().getColumn(3).setPreferredWidth(400);
        
        JTableHeader header = tablaDetallePagos.getTableHeader();
        JTableHeader header1 = tablaDetalleReparacion.getTableHeader();
        JTableHeader header2 = tablaReparaciones.getTableHeader();
        header.setFont(new Font("Arial", Font.ITALIC, 16)); // Cambia "Arial" y 16 por la fuente y tamaño deseados
        header1.setFont(new Font("Arial", Font.ITALIC, 16)); // Cambia "Arial" y 16 por la fuente y tamaño deseados
        header2.setFont(new Font("Arial", Font.ITALIC, 16)); // Cambia "Arial" y 16 por la fuente y tamaño deseados
        
    }
    
    private void cargarTablaReparaciones(List<Reparacion> listaReparaciones){
        //Hacemos que la tabla no sea editable
        DefaultTableModel modeloTablaReparaciones = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Ponemos titulos a las columnas
        String titulosReparaciones[] = {"Id", "Categoria", "Cliente", "Telefono", "Fecha Ingreso", "Fecha Devolucion", "Costo", "Pagado", "Restante", "Tecnico", "Estado"};
        modeloTablaReparaciones.setColumnIdentifiers(titulosReparaciones);
        
        //System.out.println("POR CARGAR TABLA ... ");
        
        //Setear los datos en la tabla
        if(listaReparaciones != null){
            for(Reparacion reparacion : listaReparaciones){
                
                DateTimeFormatter formatoDiasHoras = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
                DateTimeFormatter formatoDias = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String fechaIngreso = reparacion.getFecha_ingreso().format(formatoDiasHoras);
                String fechaDevolucion;

                if(reparacion.getFecha_devolucion() == null){
                    fechaDevolucion = " - ";
                }
                else{
                    fechaDevolucion = reparacion.getFecha_devolucion().format(formatoDias);
                }        
                
                
                BigDecimal restante = BigDecimal.ZERO;
                BigDecimal pagosRealizados = BigDecimal.ZERO;
                List<Pago> listaPagos = pagoController.obtenerPagosPorIdFactura(reparacion.getFactura().getId_factura());
                
                for(Pago pago : listaPagos){
                    pagosRealizados = pagosRealizados.add(pago.getMontoAbonado());
                }
                
                restante = (reparacion.getFactura().getMontoTotal().subtract(pagosRealizados));
                
                String nombreTecnico;
                
                if(reparacion.getTecnico()!=null){
                    nombreTecnico = reparacion.getTecnico().getApellido_tecnico().concat(" " + reparacion.getTecnico().getNombre_tecnico());
                }
                else{
                    nombreTecnico = "NO SELECCIONADO";
                }
                /*
                System.out.println("ID REPARACION: " + reparacion.getId_reparacion());
                System.out.println("CATEGORIA: " + reparacion.getCategoria().getNombre_categoria());
                */
                Object[] objeto = { 
                    reparacion.getId_reparacion(),
                    reparacion.getCategoria().getNombre_categoria(), 
                    reparacion.getCliente().getApellido().concat(" " + reparacion.getCliente().getNombre()),
                    reparacion.getCliente().getTelefono(),
                    fechaIngreso,
                    fechaDevolucion,
                    reparacion.getCosto(),
                    reparacion.getFactura().getEstado(),
                    restante,
                    nombreTecnico,
                    reparacion.getEstado().getNombre_estado()
                };

                modeloTablaReparaciones.addRow(objeto);
            }
        }
        
        tablaReparaciones.setModel(modeloTablaReparaciones);
        
        tablaReparaciones.getColumnModel().getColumn(0).setPreferredWidth(100);
        tablaReparaciones.getColumnModel().getColumn(1).setPreferredWidth(200);
        tablaReparaciones.getColumnModel().getColumn(2).setPreferredWidth(200);
        tablaReparaciones.getColumnModel().getColumn(3).setPreferredWidth(200);
        tablaReparaciones.getColumnModel().getColumn(4).setPreferredWidth(200);
        tablaReparaciones.getColumnModel().getColumn(5).setPreferredWidth(200);
        tablaReparaciones.getColumnModel().getColumn(6).setPreferredWidth(200);
        tablaReparaciones.getColumnModel().getColumn(7).setPreferredWidth(150);    
        tablaReparaciones.getColumnModel().getColumn(8).setPreferredWidth(200);
        tablaReparaciones.getColumnModel().getColumn(9).setPreferredWidth(200);
        tablaReparaciones.getColumnModel().getColumn(10).setPreferredWidth(200);
        
        // Renderer personalizado para cambiar el color de fondo
        tablaReparaciones.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Cambiar el color de fondo según el valor del String solo si no está seleccionada
                if (isSelected) {
                    cell.setBackground(table.getSelectionBackground()); // Color de selección
                    cell.setForeground(table.getSelectionForeground()); // Color de texto al seleccionar
                } else {
                    if (value != null) {
                        String estado = value.toString();
                        switch (estado) {
                            case "SI":
                                cell.setBackground(Color.GREEN);
                                break;
                            case "PARCIAL":
                                cell.setBackground(Color.YELLOW);
                                break;
                            case "NO":
                                cell.setBackground(Color.RED);
                                break;
                            default:
                                cell.setBackground(Color.WHITE); // Color por defecto
                                break;
                        }
                    } else {
                        cell.setBackground(Color.WHITE); // Si el valor es nulo, usa el color por defecto
                    }
                    cell.setForeground(Color.BLACK); // Color de texto por defecto
                }

                return cell;
            }
        });

        
        tablaReparaciones.getColumnModel().getColumn(9).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if ("NO SELECCIONADO".equals(value)) {
                    cell.setForeground(Color.RED);  // Cambia el color de la fuente a rojo
                } else {
                    cell.setForeground(Color.BLACK);  // Color normal si está seleccionado
                }
                return cell;
            }
        });
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
        tablaReparaciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaReparaciones.getSelectedRow();
                if (filaSeleccionada != -1) {
                    agregarRepuestoSeleccionado(filaSeleccionada); // Método para agregar a la tabla de seleccionados
                    agregarPagosSeleccionado(filaSeleccionada);
                }
            }
        });
        /*
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
        */
    }

    
    private void agregarRepuestoSeleccionado(int filaSeleccionada) {
        
        DefaultTableModel modeloReparaciones = (DefaultTableModel) tablaReparaciones.getModel();
        DefaultTableModel modeloDetalleReparacion = (DefaultTableModel) tablaDetalleReparacion.getModel();

        // Obtener datos de la fila seleccionada
        int idReparacion = (int) modeloReparaciones.getValueAt(filaSeleccionada, 0); // Por ejemplo, columna 0 es ID
        List<Repuesto> listaRepuestos = repuestoController.obtenerRepuestosPorIdReparacion(idReparacion);
        
        modeloDetalleReparacion.setRowCount(0);
        for (Repuesto repuesto : listaRepuestos) {
            int idRepuesto = repuesto.getId_repuesto();
            String nombreRepuesto = repuesto.getNombreRepuesto().getNombre_repuesto();
            String marca = repuesto.getMarca().getNombre_marca();
            String categoria = repuesto.getCategoria().getNombre_categoria();
            String precio = repuesto.getListaPrecios().get(repuesto.getListaPrecios().size()-1).getValor().toString();
            
            // Agregar cada repuesto como una fila en la tabla
            modeloDetalleReparacion.addRow(new Object[]{idRepuesto, nombreRepuesto, marca, categoria, precio});
        }
        
        Reparacion reparacion = reparacionController.obtenerReparacionPorId(idReparacion);
        
        lblIdReparacion.setText("Id Reparacion: " + idReparacion);
        lblCategoria.setText("Categoria: " + reparacion.getCategoria().getNombre_categoria());
        
        DateTimeFormatter formatoDiasHoras = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
        DateTimeFormatter formatoDias = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaIngreso = reparacion.getFecha_ingreso().format(formatoDiasHoras);
        String fechaDevolucion;
        
        if(reparacion.getFecha_devolucion() == null){
            fechaDevolucion = " - ";
        }
        else{
            fechaDevolucion = reparacion.getFecha_devolucion().format(formatoDias);
        } 
        
        lblFechaIngreso.setText("Fecha Ingreso: " + fechaIngreso);
        lblFechaDevolucion.setText("Fecha Devolucion: " + fechaDevolucion);
        txtAreaDetalles.setText(reparacion.getDetalles());
        lblCliente.setText("Cliente: " + reparacion.getCliente().getApellido().concat(" " + reparacion.getCliente().getNombre()));
        lblTelefono.setText("Telefono: " + reparacion.getCliente().getTelefono());
        if(reparacion.getTecnico()!=null){
            lblTecnico.setText("Tecnico: " + reparacion.getTecnico().getApellido_tecnico() + " " + reparacion.getTecnico().getNombre_tecnico());
        }
        else{
            lblTecnico.setText("Tecnico: NO SELECCIONADO");
        }
        
        BigDecimal TotalRepuestos = BigDecimal.ZERO;
        
        for(Repuesto rep : listaRepuestos){
            TotalRepuestos = TotalRepuestos.add(rep.getListaPrecios().get(rep.getListaPrecios().size()-1).getValor());
        }
        
        lblPagado.setText("Pagado: " + reparacion.getFactura().getEstado());
        
        lblTotalRepuestos.setText("Total Repuestos: $" + TotalRepuestos);
        
        lblManoDeObra.setText("Mano de Obra: $" + reparacion.getCosto().subtract(TotalRepuestos));
        
        lblCostoTotal.setText("Costo: $" + reparacion.getCosto());
        
    }
    
    private void agregarPagosSeleccionado(int filaSeleccionada){
        DefaultTableModel modeloReparaciones = (DefaultTableModel) tablaReparaciones.getModel();
        DefaultTableModel modeloPagos = (DefaultTableModel) tablaDetallePagos.getModel();
        
        // Obtener datos de la fila seleccionada
        int idReparacion = (int) modeloReparaciones.getValueAt(filaSeleccionada, 0); // Por ejemplo, columna 0 es ID
        Reparacion reparacion = reparacionController.obtenerReparacionPorId(idReparacion);
        
        List<Pago> listaPagos = pagoController.obtenerPagosPorIdFactura(reparacion.getFactura().getId_factura());
        
        modeloPagos.setRowCount(0);
        for (Pago pago : listaPagos) {
            int idPago = pago.getId_pago();
            BigDecimal montoAbonado = pago.getMontoAbonado();
            
            DateTimeFormatter formatoDiasHoras = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
            String fecha = pago.getFechaPago().format(formatoDiasHoras);

            String detalle = pago.getDetalle();
            
            modeloPagos.addRow(new Object[]{idPago, montoAbonado, fecha, detalle});
        }
    }
    
    private void cargarComboBoxes(){
        
        comboCategoria.removeAllItems();
        comboTecnico.removeAllItems();
        comboEstado.removeAllItems();
        
        Categoria categoria = new Categoria(0, "-", new ArrayList<>(), new ArrayList<>());
        Tecnico tecnico = new Tecnico(0, "-", "-", "_", "-", new ArrayList<>());
        Estado estado = new Estado(0, "-", new ArrayList<>());
        
        comboCategoria.addItem(categoria.getNombre_categoria());
        comboTecnico.addItem(tecnico.getApellido_tecnico());
        comboEstado.addItem(estado.getNombre_estado());
        
        List<Categoria> listaCategorias = reparacionController.retornarCategorias();
        List<Tecnico> listaTecnicos = reparacionController.retornarTecnicos();
        List<Estado> listaEstados = reparacionController.obtenerEstados();
        
        for(Categoria cat : listaCategorias){
            comboCategoria.addItem(cat.getNombre_categoria());
        }
        
        for(Tecnico tec : listaTecnicos){
            comboTecnico.addItem(tec.getApellido_tecnico().concat(" " + tec.getNombre_tecnico()));
        }
        
        for(Estado est : listaEstados){
            comboEstado.addItem(est.getNombre_estado());
        }
                
    }
    
    private void configurarListeners() {
        btnActualizarEstado.setEnabled(false);
        btnActualizarTecnico.setEnabled(false);
        btnActualizarPago.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnActualizarRepuestos.setEnabled(false);
        btnEliminar.setEnabled(false);
        
        
        tablaReparaciones.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tablaReparaciones.getSelectedRow() != -1) {
                // Habilita los botones de editar y eliminar siempre
                btnActualizarEstado.setEnabled(true);
                btnActualizarTecnico.setEnabled(true);
                btnActualizarPago.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnActualizarRepuestos.setEnabled(true);
                btnEliminar.setEnabled(true);

                // Obtiene la reparación y factura
                int idReparacion = Integer.parseInt(String.valueOf(tablaReparaciones.getValueAt(tablaReparaciones.getSelectedRow(), 0)));
                Reparacion reparacion = reparacionController.obtenerReparacionPorId(idReparacion);
                Factura factura = facturaController.obtenerFacturaPorId(reparacion.getFactura().getId_factura());

                // Deshabilita los botones antes de verificar el estado
                //btnActualizarEstado.setEnabled(false);
                //btnActualizarPago.setEnabled(false);
                //btnActualizarTecnico.setEnabled(false);

                // Si el estado no es "SI", habilita los botones
                if ("SI".equals(reparacion.getFactura().getEstado())) {
                    //btnActualizarEstado.setEnabled(true);
                    btnActualizarPago.setEnabled(false);
                    //btnActualizarTecnico.setEnabled(true);
                }
            }
        });
        
        // ActionListener para los JComboBox
        ActionListener comboListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarYActualizarTabla(); // Actualiza la tabla cuando seleccionas una opción en los ComboBox
            }
        };
        
        DocumentListener docListener = new DocumentListener() {
            private void actualizarEstadoBoton() {
                // No es necesario si eliminas el botón
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarYActualizarTabla(); // Actualiza la tabla cuando se inserta texto
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarYActualizarTabla(); // Actualiza la tabla cuando se elimina texto
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método no se usa en la mayoría de las implementaciones de DocumentListener
                // pero puedes incluir la llamada si necesitas manejar cambios en el documento
            }
        };

        //txtNombre.getDocument().addDocumentListener(docListener);
        txtIdCliente.getDocument().addDocumentListener(docListener);
        
        comboEstado.addActionListener(comboListener);
        comboCategoria.addActionListener(comboListener);
        comboTecnico.addActionListener(comboListener);
    }
    
    private void buscarYActualizarTabla() {
        
        String categoriaSeleccionada = (comboCategoria.getSelectedItem() != null) ? comboCategoria.getSelectedItem().toString() : "-";
        //String pagadoSeleccionado = (comboPagado.getSelectedItem() != null) ? comboPagado.getSelectedItem().toString() : "-";
        String estadoSeleccionado = (comboEstado.getSelectedItem() != null) ? comboEstado.getSelectedItem().toString() : "-";
        String tecnicoSeleccionado = (comboTecnico.getSelectedItem() != null) ? comboTecnico.getSelectedItem().toString() : "-";
        
        String idCliente = "";

        // Verifica que los campos de texto no estén vacíos antes de convertirlos
        if (!txtIdCliente.getText().isEmpty()) {
            idCliente = id_cliente_seleccionado;
        }
        
        List<Reparacion> listaReparaciones = reparacionController.busquedaDeReparacion(categoriaSeleccionada, /*pagadoSeleccionado,*/ estadoSeleccionado, tecnicoSeleccionado, idCliente);
        
        cargarTablaReparaciones(listaReparaciones);
    }
    
    // Método para recibir el ID del cliente desde el formulario de búsqueda
    public void setClienteId(int id) {
        id_cliente_seleccionado = String.valueOf(id);
        Cliente cliente = clienteController.obtenerClientePorId(id);
        txtIdCliente.setText(id + " - " + cliente.getApellido() + " " + cliente.getNombre());
    }
    
}
