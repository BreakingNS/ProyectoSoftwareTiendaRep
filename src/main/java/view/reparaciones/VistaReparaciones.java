package view.reparaciones;

import controller.ClienteController;
import controller.EstadoController;
import controller.ReparacionController;
import controller.RepuestoController;
import controller.VentaController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Reparacion;
import model.Repuesto;
import model.Venta;

public class VistaReparaciones extends javax.swing.JFrame {
    
    private final ReparacionController reparacionController;
    private final VentaController ventaController;
    private final RepuestoController repuestoController; 
    private final ClienteController clienteController; 
    private final EstadoController estadoController;
    
    public VistaReparaciones(ReparacionController reparacionController, 
            VentaController ventaController, 
            RepuestoController repuestoController, 
            ClienteController clienteController,
            EstadoController estadoController) {
        this.reparacionController = reparacionController;
        this.ventaController = ventaController;
        this.repuestoController = repuestoController;
        this.clienteController = clienteController;
        this.estadoController = estadoController;
        
        initComponents();
        //cargarComboBoxes();
        configurarEventos();
        //configurarListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("MODELO VISTA REPARACIONES");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Buscar:");

        jLabel3.setText("Cantidad max");

        jLabel4.setText("Fecha Venta");

        jLabel5.setText("cantidad");

        jLabel6.setText("Cliente");

        jLabel7.setText("Precio Final max");

        btnAgregar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
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

        tablaReparaciones.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tablaReparaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaReparaciones);

        tablaDetalleReparacion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tablaDetalleReparacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaDetalleReparacion);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setText("Detalle de Reparacion:                  ");

        lblCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblCategoria.setText("Categoria:                  ");

        lblIdReparacion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblIdReparacion.setText("Id Reparacion:                  ");

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

        lblTotalRepuestos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTotalRepuestos.setText("Total Repuestos: $0                 ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel4)
                                .addGap(125, 125, 125)
                                .addComponent(jLabel5)
                                .addGap(104, 104, 104)
                                .addComponent(jLabel6)
                                .addGap(103, 103, 103)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIdVenta1)
                                    .addComponent(jLabel8)
                                    .addComponent(lblTotalRepuestos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechaDevolucion)
                                    .addComponent(lblFechaIngreso)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblPrecioFinal4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblIdReparacion)
                                            .addComponent(lblCategoria))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblTelefono))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(lblCliente))))
                                    .addComponent(lblCostoTotal)
                                    .addComponent(lblManoDeObra))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(12, 12, 12)
                                .addComponent(lblIdVenta1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblIdReparacion)
                                    .addComponent(lblCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCategoria)
                                    .addComponent(lblTelefono))
                                .addComponent(lblFechaIngreso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFechaDevolucion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPrecioFinal4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblManoDeObra)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCostoTotal)
                            .addComponent(lblTotalRepuestos))
                        .addGap(0, 21, Short.MAX_VALUE))))
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        AltaReparacion alta = new AltaReparacion(reparacionController, ventaController, repuestoController, clienteController, estadoController);
        //alta.setSize(600, 400);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablas(); // Actualiza la tabla después de cerrar AltaVenta.
            }
        });
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        /*
        if(tablaVentas.getRowCount() > 0){
            if(tablaVentas.getSelectedRow()!=-1){

                int idVenta = Integer.parseInt(String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 0)));
                String comboNombreRep = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 1));
                String comboMarca = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 2));
                String comboCategoria = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 3));
                String comboUbicacion = String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 4));
                int stock = Integer.parseInt(String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 5)));
                BigDecimal precio = new BigDecimal(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 6).toString());

                EditarVenta alta = new EditarVenta(idVenta,
                    comboNombreRep,
                    comboMarca,
                    comboCategoria,
                    comboUbicacion,
                    stock,
                    precio,
                    ventaController);
                //alta.setSize(600, 400);
                alta.setResizable(false);
                alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                alta.setVisible(true);
                alta.setLocationRelativeTo(null);

                alta.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        cargarTabla(); // Actualiza la tabla después de cerrar AltaVenta.
                    }
                });

            }
        }
        */
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTablas();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        /*
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de que desea eliminar este REPUESTO, se eliminaran todos los PRECIOS del mismo?",
            "Confirmar eliminacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            int idVenta = 0;

            if(tablaVentas.getRowCount() > 0){
                if(tablaVentas.getSelectedRow()!=-1){
                    idVenta = Integer.parseInt(String.valueOf(tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 0)));
                }
            }

            ventaController.eliminarVenta(idVenta);
            JOptionPane.showMessageDialog(null, "Eliminación realizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
        }
        */
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTablas();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCostoTotal;
    private javax.swing.JLabel lblFechaDevolucion;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblIdReparacion;
    private javax.swing.JLabel lblIdVenta1;
    private javax.swing.JLabel lblManoDeObra;
    private javax.swing.JLabel lblPrecioFinal4;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTotalRepuestos;
    private javax.swing.JTable tablaDetalleReparacion;
    private javax.swing.JTable tablaReparaciones;
    private javax.swing.JTextArea txtAreaDetalles;
    // End of variables declaration//GEN-END:variables

    private void cargarTablas(){
        
        //Hacemos que la tabla no sea editable
        DefaultTableModel modeloTablaReparaciones = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Ponemos titulos a las columnas
        String titulosReparaciones[] = {"Id", "Categoria", "Cliente", "Telefono", "Fecha Ingreso", "Fecha Devolucion", "Costo", "Estado"};
        modeloTablaReparaciones.setColumnIdentifiers(titulosReparaciones);
        
        //Traer Ventas desde la base de datos
        List<Reparacion> listaReparaciones = reparacionController.listarReparaciones();
        
        //Setear los datos en la tabla
        if(listaReparaciones != null){
            System.out.println("tamaño de la lista: " + listaReparaciones.size());
            for(Reparacion reparacion : listaReparaciones){
                Object[] objeto = { 
                    reparacion.getId_reparacion(),
                    reparacion.getCategoria(), 
                    reparacion.getCliente().getApellido().concat(" " + reparacion.getCliente().getNombre()),
                    reparacion.getCliente().getTelefono(),
                    reparacion.getFecha_ingreso(),
                    reparacion.getFecha_devolucion(),
                    reparacion.getCosto(),
                    reparacion.getEstado().getNombre_estado()
                };
                modeloTablaReparaciones.addRow(objeto);
            }
        }
        
        tablaReparaciones.setModel(modeloTablaReparaciones);
        
        //Hacemos que la tabla no sea editable
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
        lblFechaIngreso.setText("Fecha Ingreso: " + reparacion.getFecha_ingreso());
        lblFechaDevolucion.setText("Fecha Devolucion: " + reparacion.getFecha_devolucion());
        txtAreaDetalles.setText(reparacion.getDetalles());
        lblCliente.setText("Cliente: " + reparacion.getCliente().getApellido().concat(" " + reparacion.getCliente().getNombre()));
        lblTelefono.setText("Telefono: " + reparacion.getCliente().getTelefono());
        
        BigDecimal TotalRepuestos = BigDecimal.ZERO;
        
        for(Repuesto rep : listaRepuestos){
            TotalRepuestos = TotalRepuestos.add(rep.getListaPrecios().get(rep.getListaPrecios().size()-1).getValor());
        }
        
        lblTotalRepuestos.setText("Total Repuestos: $" + TotalRepuestos);
        
        lblManoDeObra.setText("Mano de Obra: $" + reparacion.getCosto().subtract(TotalRepuestos));
        
        lblCostoTotal.setText("Costo: $" + reparacion.getCosto());
        
    }
}
