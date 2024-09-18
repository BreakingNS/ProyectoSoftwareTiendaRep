package view.ventas;

import controller.ClienteController;
import controller.RepuestoController;
import controller.VentaController;
import controller.VentaController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Marca;
import model.Precio;
import model.Repuesto;
import model.Venta;
import model.Ubicacion;

public class VistaVentas extends javax.swing.JFrame {

    private final VentaController ventaController;
    private final RepuestoController repuestoController;
    private final ClienteController clienteController; 
    
    public VistaVentas(VentaController ventaController, RepuestoController repuestoController, ClienteController clienteController) {
        this.ventaController = ventaController;
        this.repuestoController = repuestoController;
        this.clienteController = clienteController;
        initComponents();
        //cargarComboBoxes();
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
        tablaVentas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalleVenta = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblNroRepuestos = new javax.swing.JLabel();
        lblIdVenta = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPrecioFinal = new javax.swing.JLabel();
        lblFechaVenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("MODELO VISTA VENTAS");

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

        tablaVentas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaVentas);

        tablaDetalleVenta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaDetalleVenta);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setText("Detalle de Venta:                  ");

        lblTelefono.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTelefono.setText("Telefono:                     ");

        lblNroRepuestos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblNroRepuestos.setText("N° de Repuestos:                  ");

        lblIdVenta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblIdVenta.setText("Id Venta:                  ");

        lblApellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblApellido.setText("Apellido:                  ");

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel13.setText("Id Cliente:                  ");

        lblNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:                  ");

        lblPrecioFinal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblPrecioFinal.setText("Precio Final:                  ");

        lblFechaVenta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFechaVenta.setText("Fecha Venta:                  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(339, 339, 339))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                .addGap(262, 262, 262))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblPrecioFinal)
                                                .addGap(186, 186, 186))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblIdVenta, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(4, 4, 4)
                                                            .addComponent(jLabel8)))
                                                    .addComponent(lblNroRepuestos)
                                                    .addComponent(lblFechaVenta))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblTelefono)
                                                    .addComponent(lblApellido)
                                                    .addComponent(lblNombre)
                                                    .addComponent(jLabel13))
                                                .addGap(43, 43, 43)))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))))
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
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblIdVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNroRepuestos)
                                .addGap(9, 9, 9)
                                .addComponent(lblFechaVenta))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTelefono)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrecioFinal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
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
        
        AltaVenta alta = new AltaVenta(ventaController, repuestoController, clienteController);
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
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblFechaVenta;
    private javax.swing.JLabel lblIdVenta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNroRepuestos;
    private javax.swing.JLabel lblPrecioFinal;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tablaDetalleVenta;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables

    private void cargarTablas(){
        
        //Hacemos que la tabla no sea editable
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Ponemos titulos a las columnas
        String titulos[] = {"Id", "Repuesto", "Cantidad", "Fecha Venta", "Precio Final", "Cliente"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        //Traer Ventas desde la base de datos
        List<Venta> listaVentas = ventaController.listarVentas();
        
        //Setear los datos en la tabla
        if(listaVentas != null){
            System.out.println("tamaño de la lista: " + listaVentas.size());
            for(Venta venta : listaVentas){
                Object[] objeto = {venta.getId_venta(), 
                    null, 
                    venta.getCantidad(),
                    venta.getFecha_venta(), 
                    venta.getPrecioFinal(), 
                    venta.getCliente().getApellido()
                };
                modeloTabla.addRow(objeto);
            }
        }
        
        tablaVentas.setModel(modeloTabla);
        
        //Hacemos que la tabla no sea editable
        DefaultTableModel modeloTabla1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Ponemos titulos a las columnas
        String titulos1[] = {"Id", "Repuesto", "Marca", "Categoria", "Precio"};
        modeloTabla1.setColumnIdentifiers(titulos1);
        
        tablaDetalleVenta.setModel(modeloTabla1);
    }
    
    private void cargarTablaBusqueda(List<Venta> listaVentas){
        /*
        // Hacemos que la tabla no sea editable
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Ponemos títulos a las columnas
        String[] titulos = {"Id", "Nombre Venta", "Marca", "Categoria", "Ubicacion", "Stock", "Precio"};
        modeloTabla.setColumnIdentifiers(titulos);

        // Setear los datos en la tabla
        if (listaVentas != null) {
            System.out.println("Tamaño de la lista: " + listaVentas.size());
            for (Venta venta : listaVentas) {
                // Asegurarse de que la lista de precios no esté vacía
                List<Precio> listaPrecios = venta.getListaPrecios();
                Object precio = "No disponible"; // Valor predeterminado si la lista está vacía

                if (listaPrecios != null && !listaPrecios.isEmpty()) {
                    precio = listaPrecios.get(listaPrecios.size() - 1).getValor();
                }

                // Asegurarse de que los métodos no devuelvan null
                Object[] objeto = {
                    venta.getId_venta(),
                    venta.getNombreVenta() != null ? venta.getNombreVenta().getNombre_venta() : "Desconocido",
                    venta.getMarca() != null ? venta.getMarca().getNombre_marca() : "Desconocido",
                    venta.getCategoria() != null ? venta.getCategoria().getNombre_categoria() : "Desconocido",
                    venta.getUbicacion() != null ? venta.getUbicacion().getNombre_ubicacion() : "Desconocido",
                    venta.getStock(),
                    precio
                };
                modeloTabla.addRow(objeto);
            }
        }

        // Asignar el modelo a la tabla
        tablaVentas.setModel(modeloTabla);
        */
    }

    
    private void configurarEventos() {
        
        btnEliminar.setEnabled(false); // Deshabilita el botón inicialmente.

        tablaVentas.getSelectionModel().addListSelectionListener(e -> {
            btnEliminar.setEnabled(tablaVentas.getSelectedRow() != -1); // Habilita si hay una fila seleccionada.
        });
        
        btnEditar.setEnabled(false); // Deshabilita el botón inicialmente.

        tablaVentas.getSelectionModel().addListSelectionListener(e -> {
            btnEditar.setEnabled(tablaVentas.getSelectedRow() != -1); // Habilita si hay una fila seleccionada.
        });

        // Configura el mapeo de la tecla Esc para activar btnAtras
        String escKey = "ESCAPE";
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), escKey);
        getRootPane().getActionMap().put(escKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAtras.doClick(); // Simula un clic en btnAtras
            }
        });
        
        tablaVentas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaVentas.getSelectedRow();
                if (filaSeleccionada != -1) {
                    agregarRepuestoSeleccionado(filaSeleccionada); // Método para agregar a la tabla de seleccionados
                }
            }
        });
        
    }
    
    private void agregarRepuestoSeleccionado(int filaSeleccionada) {
        DefaultTableModel modeloVentas = (DefaultTableModel) tablaVentas.getModel();
        DefaultTableModel modeloVentaDetalles = (DefaultTableModel) tablaDetalleVenta.getModel();

        // Obtener datos de la fila seleccionada
        int idVenta = (int) modeloVentas.getValueAt(filaSeleccionada, 0); // Por ejemplo, columna 0 es ID
        List<Repuesto> listaRepuestos = repuestoController.obtenerRepuestosPorIdVenta(idVenta);
        modeloVentaDetalles.setRowCount(0);
        for (Repuesto repuesto : listaRepuestos) {
            int idRepuesto = repuesto.getId_repuesto();
            String nombreRepuesto = repuesto.getNombreRepuesto().getNombre_repuesto();
            String marca = repuesto.getMarca().getNombre_marca();
            String categoria = repuesto.getCategoria().getNombre_categoria();
            String precio = repuesto.getListaPrecios().get(repuesto.getListaPrecios().size()-1).getValor().toString();
            
            // Agregar cada repuesto como una fila en la tabla
            modeloVentaDetalles.addRow(new Object[]{idRepuesto, nombreRepuesto, marca, categoria, precio});
        }
        
        Venta venta = ventaController.obtenerVentaPorId(idVenta);
        
        lblNombre.setText("Nombre: " + venta.getCliente().getNombre());
        lblApellido.setText("Apellido: " + venta.getCliente().getApellido());
        lblTelefono.setText("Telefono: " + venta.getCliente().getTelefono());
        
        lblIdVenta.setText("Id Venta: " + venta.getId_venta());
        lblNroRepuestos.setText("N° de Repuestos: " + listaRepuestos.size());
        lblFechaVenta.setText("Fecha Venta: " + venta.getFecha_venta());
        lblPrecioFinal.setText("Precio Final: " + venta.getPrecioFinal());
    }
    
    private void configurarListeners() {
        /*
        // ActionListener para los JComboBox
        ActionListener comboListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarYActualizarTabla(); // Actualiza la tabla cuando seleccionas una opción en los ComboBox
            }
        };
        
        // DocumentListener para los JTextField
        DocumentListener docListener = new DocumentListener() {
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
            }
        };
        
        // Agrega ActionListener a los ComboBox
        comboMarca.addActionListener(comboListener);
        comboCategoria.addActionListener(comboListener);
        comboNombreVenta.addActionListener(comboListener);
        comboUbicacion.addActionListener(comboListener);
        
        // Agrega DocumentListener a los JTextField
        txtStock.getDocument().addDocumentListener(docListener);
        txtPrecio.getDocument().addDocumentListener(docListener);
        */
    }
    
    // Método para realizar la búsqueda y actualizar la tabla
    private void buscarYActualizarTabla() {
        /*
        String marcaSeleccionada = (comboMarca.getSelectedItem() != null) ? comboMarca.getSelectedItem().toString() : "-";
        String categoriaSeleccionada = (comboCategoria.getSelectedItem() != null) ? comboCategoria.getSelectedItem().toString() : "-";
        String nombreVentaSeleccionado = (comboNombreVenta.getSelectedItem() != null) ? comboNombreVenta.getSelectedItem().toString() : "-";
        String ubicacionSeleccionada = (comboUbicacion.getSelectedItem() != null) ? comboUbicacion.getSelectedItem().toString() : "-";/*
        */
        /*
        int stock = 0;
        int precio = 0;

        // Verifica que los campos de texto no estén vacíos antes de convertirlos
        if (!txtStock.getText().isEmpty()) {
            stock = Integer.parseInt(txtStock.getText());
        }

        if (!txtPrecio.getText().isEmpty()) {
            precio = Integer.parseInt(txtPrecio.getText());
        }

        //List<Venta> listaVentas = ventaController.busquedaDeVenta(marcaSeleccionada, categoriaSeleccionada, nombreVentaSeleccionado, ubicacionSeleccionada, stock, precio);
        
        System.out.println("comienzo carga de busqueda");
        
        List<Venta> listaVentas = ventaController.busquedaDeVenta(
                marcaSeleccionada, 
                categoriaSeleccionada, 
                nombreVentaSeleccionado, 
                ubicacionSeleccionada, 
                stock, 
                precio);
        
        cargarTablaBusqueda(listaVentas);
        */
    }
    
    private void cargarComboBoxes(){
        /*
        comboCategoria.removeAllItems();
        comboMarca.removeAllItems();
        comboNombreVenta.removeAllItems();
        comboUbicacion.removeAllItems();
        
        NombreVenta nombreVenta = new NombreVenta(0, "-");
        Marca marca = new Marca(0, "-", new ArrayList<>());
        Categoria categoria = new Categoria(0, "-", new ArrayList<>(), new ArrayList<>());
        Ubicacion ubicacion = new Ubicacion(0, "-", new ArrayList<>());
        
        comboCategoria.addItem(nombreVenta.getNombre_venta());
        comboMarca.addItem(marca.getNombre_marca());
        comboNombreVenta.addItem(categoria.getNombre_categoria());
        comboUbicacion.addItem(ubicacion.getNombre_ubicacion());
        
        List<NombreVenta> listaNombreVentas = ventaController.retornarListaNombreVentas();
        List<Marca> listaMarcas = ventaController.retornarListaMarcas();
        List<Categoria> listaCategorias = ventaController.retornarCategorias();
        List<Ubicacion> listaUbicaciones = ventaController.retornarUbicaciones();
        
        for(NombreVenta nomb : listaNombreVentas){
            comboNombreVenta.addItem(nomb.getNombre_venta());
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
        
        System.out.println("fin carga comboboxes");
        */
    }
}
