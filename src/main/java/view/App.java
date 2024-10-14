package view;

import config.BackupDataBase;
import config.ConexionDataBase;
import controller.CategoriaController;
import controller.ClienteController;
import controller.EstadoController;
import controller.FacturaController;
import controller.MarcaController;
import controller.ModeloController;
import controller.NombreRepuestoController;
import controller.PagoController;
import controller.ReparacionController;
import controller.RepuestoController;
import controller.TecnicoController;
import controller.UbicacionController;
import controller.VentaController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Pago;
import model.Reparacion;
import model.Repuesto;
import view.administrador.VistaBD;
import view.categoria.VistaCategorias;
import view.clientes.AltaCliente;
import view.clientes.VistaCliente;
import view.estado.VistaEstados;
import view.marca.VistaMarcas;
import view.modelo.VistaModelo;
import view.nombreRepuesto.VistaNombreRepuesto;
import view.reparaciones.AltaReparacion;
import view.reparaciones.VistaReparaciones;
import view.repuestos.AltaRepuesto;
import view.repuestos.VistaRepuestos;
import view.tecnico.VistaTecnico;
import view.ubicacion.VistaUbicacion;
import view.ventas.AltaVenta;
import view.ventas.VistaVentas;

public class App extends javax.swing.JFrame {
    
    private Connection connection;
    private ConexionDataBase conexionDataBase;

    private BackupDataBase backupDataBase;
    
    private MarcaController marcaController;
    private ModeloController modeloController;
    private NombreRepuestoController nombreRepuestoController;
    private UbicacionController ubicacionController;
    private CategoriaController categoriaController;
    private EstadoController estadoController;
    private TecnicoController tecnicoController;
    private FacturaController facturaController;
    private PagoController pagoController;
    
    private ClienteController clienteController;
    private RepuestoController repuestoController;
    private VentaController ventaController;
    private ReparacionController reparacionController;
    
    private ScheduledExecutorService scheduler;
    
    public App(Connection connection, 
            ConexionDataBase conexionDataBase, 
            ClienteController clienteController, 
            RepuestoController repuestoController, 
            MarcaController marcaController,
            ModeloController modeloController,
            NombreRepuestoController nombreRepuestoController,
            UbicacionController ubicacionController,
            TecnicoController tecnicoController,
            CategoriaController categoriaController,
            EstadoController estadoController,
            VentaController ventaController,
            ReparacionController reparacionController,
            FacturaController facturaController,
            PagoController pagoController
            ) {
        this.connection = connection;
        this.conexionDataBase = conexionDataBase;
        this.marcaController = marcaController;
        this.modeloController = modeloController;
        this.nombreRepuestoController = nombreRepuestoController;
        this.ubicacionController = ubicacionController;
        this.categoriaController = categoriaController;
        this.estadoController = estadoController;
        this.tecnicoController = tecnicoController;
        this.facturaController = facturaController;
        this.pagoController = pagoController;
        
        this.clienteController = clienteController;
        this.repuestoController = repuestoController;
        this.ventaController = ventaController;
        this.reparacionController = reparacionController;
        
        // Programar backup automático cada 1 hora
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.scheduler.scheduleAtFixedRate(() -> {
           String backupFilePath = "C:\\Users\\BreakingNS\\Documents\\BASES DE DATOS H2\\backup_" + System.currentTimeMillis() + ".sql";
           BackupDataBase.exportBackup(backupFilePath, this.jPanel1);
           BackupDataBase.cleanOldBackups();
           System.out.println("Copia de seguridad realizada con éxito! (Una hora de uso del programa)" + LocalDateTime.now());
        }, 1L, 1L, TimeUnit.HOURS);
        
        initComponents();
        cargarTablas();
        configurarEventos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRepuestos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnReparaciones = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReparaciones = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaRepuestos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menuNuevoCliente = new javax.swing.JMenuItem();
        menuNuevoRepuesto = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuClientes = new javax.swing.JMenuItem();
        menuRepuestos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuNombreRepuesto = new javax.swing.JMenuItem();
        menuMarca = new javax.swing.JMenuItem();
        menuModelo = new javax.swing.JMenuItem();
        menuCategoria = new javax.swing.JMenuItem();
        menuUbicacion = new javax.swing.JMenuItem();
        menuEstado = new javax.swing.JMenuItem();
        menuTecnico = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuConfigBD = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Programa Local de Reparacion de Electrodomesticos y Venta de Repuestos");

        btnRepuestos.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnRepuestos.setText("LISTA DE REPARACIONES");
        btnRepuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepuestosActionPerformed(evt);
            }
        });

        btnVentas.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        btnVentas.setText("NUEVA VENTA");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnClientes.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        btnClientes.setText("LISTA DE VENTAS");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnReparaciones.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        btnReparaciones.setText("NUEVA REPARACION");
        btnReparaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReparacionesActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tablaReparaciones.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tablaReparaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaReparaciones.setRowHeight(20);
        jScrollPane1.setViewportView(tablaReparaciones);

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
        jScrollPane2.setViewportView(tablaRepuestos);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Tabla Reparaciones");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Control Stock Repuestos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReparaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 265, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReparaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        jMenu3.setText("Nuevo      ");
        jMenu3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        menuNuevoCliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuNuevoCliente.setText("Nuevo Cliente");
        menuNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoClienteActionPerformed(evt);
            }
        });
        jMenu3.add(menuNuevoCliente);

        menuNuevoRepuesto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuNuevoRepuesto.setText("Nuevo Repuesto");
        menuNuevoRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoRepuestoActionPerformed(evt);
            }
        });
        jMenu3.add(menuNuevoRepuesto);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Listas       ");
        jMenu1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        menuClientes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuClientes.setText("Lista Clientes");
        menuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesActionPerformed(evt);
            }
        });
        jMenu1.add(menuClientes);

        menuRepuestos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuRepuestos.setText("Lista Repuestos");
        menuRepuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRepuestosActionPerformed(evt);
            }
        });
        jMenu1.add(menuRepuestos);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Configuracion       ");
        jMenu2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        menuNombreRepuesto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuNombreRepuesto.setText("NombreRepuesto");
        menuNombreRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNombreRepuestoActionPerformed(evt);
            }
        });
        jMenu2.add(menuNombreRepuesto);

        menuMarca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuMarca.setText("Marca");
        menuMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMarcaActionPerformed(evt);
            }
        });
        jMenu2.add(menuMarca);

        menuModelo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuModelo.setText("Modelo");
        menuModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModeloActionPerformed(evt);
            }
        });
        jMenu2.add(menuModelo);

        menuCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuCategoria.setText("Categoria");
        menuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCategoriaActionPerformed(evt);
            }
        });
        jMenu2.add(menuCategoria);

        menuUbicacion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuUbicacion.setText("Ubicacion");
        menuUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUbicacionActionPerformed(evt);
            }
        });
        jMenu2.add(menuUbicacion);

        menuEstado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuEstado.setText("Estado");
        menuEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEstadoActionPerformed(evt);
            }
        });
        jMenu2.add(menuEstado);

        menuTecnico.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuTecnico.setText("Tecnico");
        menuTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTecnicoActionPerformed(evt);
            }
        });
        jMenu2.add(menuTecnico);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Administrador        ");
        jMenu6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        menuConfigBD.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuConfigBD.setText("Configurar Base de Datos");
        menuConfigBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConfigBDActionPerformed(evt);
            }
        });
        jMenu6.add(menuConfigBD);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

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

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        setVisible(false);
        VistaVentas alta = new VistaVentas(ventaController, repuestoController, clienteController);
        //alta.setSize(600, 400);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        //alta.setLocationRelativeTo(null);
        alta.setLocation(-8, 0);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnRepuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepuestosActionPerformed
        setVisible(false);
        VistaReparaciones alta = new VistaReparaciones(reparacionController, ventaController, repuestoController, clienteController, estadoController, facturaController, pagoController);
        //alta.setSize(600, 400);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocation(-8, 0);
        //alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_btnRepuestosActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        setVisible(false);
        AltaVenta alta = new AltaVenta(ventaController, repuestoController, clienteController);
        //alta.setSize(600, 400);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        //alta.setLocationRelativeTo(null);
        alta.setLocation(-8, 0);
        
        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnReparacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReparacionesActionPerformed
        setVisible(false);
        AltaReparacion alta = new AltaReparacion(reparacionController, ventaController, repuestoController, clienteController, estadoController, facturaController, pagoController);
        //alta.setSize(600, 400);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        //alta.setLocationRelativeTo(null);
        alta.setLocation(-8, 0);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_btnReparacionesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de que desea salir?", 
            "Confirmar salida", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            System.out.println("entro1");

            // Realizar la copia de seguridad al salir
            String backupFilePath = "C:\\Users\\BreakingNS\\Documents\\BASES DE DATOS H2" + "\\backup_shutdown_" + System.currentTimeMillis() + ".sql";
            BackupDataBase.exportBackup(backupFilePath, this.jPanel1);
            System.out.println("Copia de seguridad realizada con éxito! (Cierre del programa)" + LocalDateTime.now());

            // Cerrar la conexión y el scheduler antes de salir
            conexionDataBase.cerrarConexion(connection);

            // Asegúrate de que el scheduler se detenga antes de salir
            scheduler.shutdown();
            try {
                // Esperar a que se completen las tareas pendientes
                if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                    scheduler.shutdownNow();
                }
            } catch (InterruptedException e) {
                scheduler.shutdownNow();
            }

            System.out.println("salio1");
            dispose();
            System.exit(0); // Asegúrate de salir del programa
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    
    
    private void menuMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMarcaActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaMarcas alta = new VistaMarcas(marcaController);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuMarcaActionPerformed

    private void menuNombreRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNombreRepuestoActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaNombreRepuesto alta = new VistaNombreRepuesto(nombreRepuestoController);
        //alta.setSize(1280, 720);
        //alta.setTitle("Alta NombreRepuesto");
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuNombreRepuestoActionPerformed

    private void menuUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUbicacionActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaUbicacion alta = new VistaUbicacion(ubicacionController);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuUbicacionActionPerformed

    private void menuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCategoriaActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaCategorias alta = new VistaCategorias(categoriaController);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuCategoriaActionPerformed

    private void menuEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEstadoActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaEstados alta = new VistaEstados(estadoController);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuEstadoActionPerformed

    private void menuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaCliente alta = new VistaCliente(clienteController, connection);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuClientesActionPerformed

    private void menuRepuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRepuestosActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaRepuestos alta = new VistaRepuestos(repuestoController);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuRepuestosActionPerformed

    private void menuNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoClienteActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        AltaCliente alta = new AltaCliente(clienteController);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuNuevoClienteActionPerformed

    private void menuNuevoRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoRepuestoActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        AltaRepuesto alta = new AltaRepuesto(repuestoController);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuNuevoRepuestoActionPerformed

    private void menuModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModeloActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaModelo alta = new VistaModelo(modeloController);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuModeloActionPerformed

    private void menuTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTecnicoActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaTecnico alta = new VistaTecnico(tecnicoController, connection);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuTecnicoActionPerformed

    private void menuConfigBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfigBDActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaBD alta = new VistaBD(connection);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas();
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuConfigBDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnReparaciones;
    private javax.swing.JButton btnRepuestos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem menuCategoria;
    private javax.swing.JMenuItem menuClientes;
    private javax.swing.JMenuItem menuConfigBD;
    private javax.swing.JMenuItem menuEstado;
    private javax.swing.JMenuItem menuMarca;
    private javax.swing.JMenuItem menuModelo;
    private javax.swing.JMenuItem menuNombreRepuesto;
    private javax.swing.JMenuItem menuNuevoCliente;
    private javax.swing.JMenuItem menuNuevoRepuesto;
    private javax.swing.JMenuItem menuRepuestos;
    private javax.swing.JMenuItem menuTecnico;
    private javax.swing.JMenuItem menuUbicacion;
    private javax.swing.JTable tablaReparaciones;
    private javax.swing.JTable tablaRepuestos;
    // End of variables declaration//GEN-END:variables

    private void cargarTablas(){
        
        //Tabla Repuestos

        //Hacemos que la tabla no sea editable
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Ponemos titulos a las columnas
        String titulos[] = {"Codigo", "Nombre Repuesto", "Marca", "Modelo", "Categoria", "Ubicacion", "Stock", "Precio"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        JTableHeader header = tablaRepuestos.getTableHeader();
        header.setFont(new Font("Arial", Font.ITALIC, 16)); // Cambia "Arial" y 16 por la fuente y tamaño deseados
        
        //Traer Repuestos desde la base de datos
        List<Repuesto> listaRepuestos = repuestoController.listarRepuestosOrdenadoPorStock();
        
        //Setear los datos en la tabla
        if(listaRepuestos != null){
            for(Repuesto repuesto : listaRepuestos){
                Object[] objeto = {repuesto.getCodigo(),
                    repuesto.getNombreRepuesto().getNombre_repuesto(), 
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
        
        tablaRepuestos.getColumnModel().getColumn(0).setPreferredWidth(100); // ID más pequeño
        tablaRepuestos.getColumnModel().getColumn(1).setPreferredWidth(200); // Nombre más grande
        tablaRepuestos.getColumnModel().getColumn(2).setPreferredWidth(200); // Apellido
        tablaRepuestos.getColumnModel().getColumn(3).setPreferredWidth(200); // Teléfono
        tablaRepuestos.getColumnModel().getColumn(4).setPreferredWidth(350); // Domicilio
        tablaRepuestos.getColumnModel().getColumn(5).setPreferredWidth(200); // Domicilio
        tablaRepuestos.getColumnModel().getColumn(6).setPreferredWidth(100); // Domicilio
        tablaRepuestos.getColumnModel().getColumn(7).setPreferredWidth(200); // Domicilio        
        
        tablaRepuestos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Cambiar el color de fondo solo para la columna "Stock" (índice 6)
                if (column == 6) { // La columna de "Stock" es la 6
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
        
        //Tabla Reparaciones
        
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
        
        JTableHeader header1 = tablaReparaciones.getTableHeader();
        header1.setFont(new Font("Arial", Font.ITALIC, 16)); // Cambia "Arial" y 16 por la fuente y tamaño deseados
        
        //Traer Ventas desde la base de datos
        List<Reparacion> listaReparaciones = reparacionController.listarReparacionesOrdenadasPorFechaActual();
        
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
                
                Object[] objeto = { 
                    reparacion.getId_reparacion(),
                    reparacion.getCategoria(), 
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
                    cell.setForeground(Color.BLACK); // Color de texto por defecto
                }

                return cell;
            }
        });
        
    }
    
    private void configurarEventos() {
        // Configura el mapeo de la tecla Esc para activar btnAtras
        String escKey = "ESCAPE";
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), escKey);
        getRootPane().getActionMap().put(escKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSalir.doClick(); // Simula un clic en btnAtras
            }
        });
    }

}
