package view;

import config.BackupDataBase;
import static config.BackupDataBase.cleanOldBackups;
import static config.BackupDataBase.exportBackup;
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
import dao.impl.MarcaDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import service.ClienteService;
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
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            String backupFilePath = "C:\\Users\\BreakingNS\\Documents\\BASES DE DATOS H2" + "\\backup_" + System.currentTimeMillis() + ".sql";
            exportBackup(backupFilePath);
            cleanOldBackups(); // Limpiar copias antiguas después de cada backup
            System.out.println("Copia de seguridad realizada con éxito! (Una hora de uso del programa)" + LocalDateTime.now());
        }, 0, 1, TimeUnit.HOURS);
        
        initComponents();
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
        menuIngresoAdmin = new javax.swing.JMenuItem();
        menuCerrarAdmin = new javax.swing.JMenuItem();
        menuConfigBD = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Programa Local de Reparacion de Electrodomesticos y Venta de Repuestos");

        btnRepuestos.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        btnRepuestos.setText("LISTA DE REPARACIONES");
        btnRepuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepuestosActionPerformed(evt);
            }
        });

        btnVentas.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
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

        btnReparaciones.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnReparaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(420, 420, 420)))))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReparaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
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

        jMenu2.setText("Configuracion");
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

        jMenu6.setText("Administrador");
        jMenu6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        menuIngresoAdmin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuIngresoAdmin.setText("Ingreso Admin");
        menuIngresoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIngresoAdminActionPerformed(evt);
            }
        });
        jMenu6.add(menuIngresoAdmin);

        menuCerrarAdmin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        menuCerrarAdmin.setText("Cerrar Admin");
        jMenu6.add(menuCerrarAdmin);

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
            .addGap(0, 1588, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
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
            exportBackup(backupFilePath);
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
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuMarcaActionPerformed

    private void menuNombreRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNombreRepuestoActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaNombreRepuesto alta = new VistaNombreRepuesto(nombreRepuestoController);
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
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
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuRepuestosActionPerformed

    private void menuIngresoAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIngresoAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuIngresoAdminActionPerformed

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
                setVisible(true); // Muestra la ventana anterior cuando la nueva se cierra
            }
        });
    }//GEN-LAST:event_menuTecnicoActionPerformed

    private void menuConfigBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfigBDActionPerformed
        this.setVisible(false); // Oculta la ventana actual
        VistaBD alta = new VistaBD();
        //alta.setSize(1280, 720);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuCategoria;
    private javax.swing.JMenuItem menuCerrarAdmin;
    private javax.swing.JMenuItem menuClientes;
    private javax.swing.JMenuItem menuConfigBD;
    private javax.swing.JMenuItem menuEstado;
    private javax.swing.JMenuItem menuIngresoAdmin;
    private javax.swing.JMenuItem menuMarca;
    private javax.swing.JMenuItem menuModelo;
    private javax.swing.JMenuItem menuNombreRepuesto;
    private javax.swing.JMenuItem menuNuevoCliente;
    private javax.swing.JMenuItem menuNuevoRepuesto;
    private javax.swing.JMenuItem menuRepuestos;
    private javax.swing.JMenuItem menuTecnico;
    private javax.swing.JMenuItem menuUbicacion;
    // End of variables declaration//GEN-END:variables

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
