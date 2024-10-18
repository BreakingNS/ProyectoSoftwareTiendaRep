package view.ventas;

import config.NumerosSoloDocumentFilter;
import controller.ClienteController;
import controller.RepuestoController;
import controller.VentaController;
import controller.VentaController;
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
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.AbstractDocument;
import model.Categoria;
import model.Marca;
import model.Precio;
import model.Repuesto;
import model.Venta;
import model.Ubicacion;
import service.PrecioService;
import view.clientes.VistaCliente;

public class VistaVentas extends javax.swing.JFrame {

    private final VentaController ventaController;
    private final RepuestoController repuestoController;
    private final ClienteController clienteController; 
    
    public VistaVentas(VentaController ventaController, RepuestoController repuestoController, ClienteController clienteController) {
        this.ventaController = ventaController;
        this.repuestoController = repuestoController;
        this.clienteController = clienteController;
        initComponents();
        configurarEventos();
        configuracionInicial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
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
        lblFechaVenta = new javax.swing.JLabel();
        lblPrecioFinal = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("VENTAS");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Buscar:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Fecha Venta: ");

        btnAgregar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnAgregar.setText("AGREGAR VENTA");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnActualizar.setText("ACTUALIZAR TABLA");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnEliminar.setText("ELIMINAR VENTA");
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

        tablaVentas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaVentas.setRowHeight(24);
        tablaVentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaVentas);

        tablaDetalleVenta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaDetalleVenta.setRowHeight(24);
        tablaDetalleVenta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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

        lblFechaVenta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblFechaVenta.setText("Fecha Venta:                  ");

        lblPrecioFinal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblPrecioFinal.setText("Precio Final:                  ");

        txtMes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtAnio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtDia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Mes:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Año:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("Dia:");

        btnBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setText("LIMPIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIdVenta)
                                    .addComponent(lblNroRepuestos)
                                    .addComponent(lblFechaVenta)
                                    .addComponent(jLabel8))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblApellido)
                                            .addComponent(lblNombre))
                                        .addGap(115, 115, 115)
                                        .addComponent(lblPrecioFinal))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(584, 584, 584)
                                .addComponent(jLabel1)))
                        .addGap(0, 425, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(btnBuscar)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(lblIdVenta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNroRepuestos)
                                        .addGap(9, 9, 9)
                                        .addComponent(lblFechaVenta))
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblNombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblApellido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTelefono)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPrecioFinal)
                                .addGap(57, 57, 57)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
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
        setVisible(false);
        AltaVenta alta = new AltaVenta(ventaController, repuestoController, clienteController);
        //alta.setSize(600, 400);
        alta.setTitle("Software ElectroClima");
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                setVisible(true);
                cargarTablasPrincipales(); // Actualiza la tabla después de cerrar AltaVenta.
            }
        });
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTablasPrincipales();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de que desea eliminar esta VENTA, se restablecera el stock de los REPUSTOS de la misma?",
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

            try {
                ventaController.eliminarVenta(idVenta);
                JOptionPane.showMessageDialog(null, "Eliminación realizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(VistaVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargarTablasPrincipales();
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTablasPrincipales();
    }//GEN-LAST:event_formWindowOpened

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarYActualizarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtAnio.setText("");
        txtDia.setText("");
        txtMes.setText("");
        btnActualizar.doClick();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    // End of variables declaration//GEN-END:variables

    private void cargarTablasPrincipales(){
        //Traer Ventas desde la base de datos
        List<Venta> listaVentas = ventaController.listarVentas();
        
        cargarTablas(listaVentas);
    }
    
    private void cargarTablas(List<Venta> listaVentas){
        
        //Hacemos que la tabla no sea editable
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Ponemos titulos a las columnas
        String titulos[] = {"Id", "Cliente", "Cantidad", "Precio Final", "Fecha Venta"};
        modeloTabla.setColumnIdentifiers(titulos);

        
        
        //Setear los datos en la tabla
        if(listaVentas != null){
            
            //System.out.println("tamaño de la lista: " + listaVentas.size());
            
            for(Venta venta : listaVentas){
                
                DateTimeFormatter formatoDiasHoras = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
                String fechaIngreso = venta.getFecha_venta().format(formatoDiasHoras);
                
                Object[] objeto = {venta.getId_venta(),
                    venta.getCliente().getApellido().concat(" " + venta.getCliente().getNombre()),
                    venta.getCantidad(),
                    venta.getPrecioFinal(), 
                    fechaIngreso,
                };
                
                modeloTabla.addRow(objeto);
            }
        }

        tablaVentas.setModel(modeloTabla);
        
        tablaVentas.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaVentas.getColumnModel().getColumn(1).setPreferredWidth(250);
        tablaVentas.getColumnModel().getColumn(2).setPreferredWidth(50);
        tablaVentas.getColumnModel().getColumn(3).setPreferredWidth(200);
        tablaVentas.getColumnModel().getColumn(4).setPreferredWidth(250);
        
        //Hacemos que la tabla no sea editable
        DefaultTableModel modeloTabla1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Ponemos titulos a las columnas
        String titulos1[] = {"Id", "Repuesto", "Codigo", "Marca", "Modelo", "Categoria", "Precio"};
        modeloTabla1.setColumnIdentifiers(titulos1);
        
        JTableHeader header1 = tablaDetalleVenta.getTableHeader();
        JTableHeader header2 = tablaVentas.getTableHeader();
        header1.setFont(new Font("Arial", Font.ITALIC, 16)); // Cambia "Arial" y 16 por la fuente y tamaño deseados
        header2.setFont(new Font("Arial", Font.ITALIC, 16)); // Cambia "Arial" y 16 por la fuente y tamaño deseados    
        
        tablaDetalleVenta.setModel(modeloTabla1);
        
        tablaDetalleVenta.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaDetalleVenta.getColumnModel().getColumn(1).setPreferredWidth(150);
        tablaDetalleVenta.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaDetalleVenta.getColumnModel().getColumn(3).setPreferredWidth(150);
        tablaDetalleVenta.getColumnModel().getColumn(4).setPreferredWidth(200);
        tablaDetalleVenta.getColumnModel().getColumn(5).setPreferredWidth(200);
        tablaDetalleVenta.getColumnModel().getColumn(6).setPreferredWidth(150);
        
    }

    private void configurarEventos() {
        
        btnEliminar.setEnabled(false); // Deshabilita el botón inicialmente.

        tablaVentas.getSelectionModel().addListSelectionListener(e -> {
            btnEliminar.setEnabled(tablaVentas.getSelectedRow() != -1); // Habilita si hay una fila seleccionada.
        });
        /*
        btnEditar.setEnabled(false); // Deshabilita el botón inicialmente.

        tablaVentas.getSelectionModel().addListSelectionListener(e -> {
            btnEditar.setEnabled(tablaVentas.getSelectedRow() != -1); // Habilita si hay una fila seleccionada.
        });
        */
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
            String modelo = repuesto.getModelo().getNombre_modelo();
            String categoria = repuesto.getCategoria().getNombre_categoria();
            String codigo = repuesto.getCodigo();
            
            Precio precioEnFechaVenta = ventaController.obtenerPrecioRepuestoPorFechaVenta(idVenta, repuesto); // Precio del repuesto en la fecha de venta
            
            String precio = precioEnFechaVenta.getValor().toString();
            
            // Agregar cada repuesto como una fila en la tabla
            modeloVentaDetalles.addRow(new Object[]{idRepuesto, nombreRepuesto, codigo, marca, modelo, categoria, precio});
        }
        
        Venta venta = ventaController.obtenerVentaPorId(idVenta);
        
        lblNombre.setText("Nombre: " + venta.getCliente().getNombre());
        lblApellido.setText("Apellido: " + venta.getCliente().getApellido());
        lblTelefono.setText("Telefono: " + venta.getCliente().getTelefono());
        
        lblIdVenta.setText("Id Venta: " + venta.getId_venta());
        lblNroRepuestos.setText("N° de Repuestos: " + listaRepuestos.size());
        
        DateTimeFormatter formatoDiasHoras = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm");
        String fechaIngreso = venta.getFecha_venta().format(formatoDiasHoras);
        
        lblFechaVenta.setText("Fecha Venta: " + fechaIngreso);
        lblPrecioFinal.setText("Precio Final: " + venta.getPrecioFinal());
    }
    
    private void configuracionInicial() {
        ((AbstractDocument) txtDia.getDocument()).setDocumentFilter(new NumerosSoloDocumentFilter(2));
        ((AbstractDocument) txtMes.getDocument()).setDocumentFilter(new NumerosSoloDocumentFilter(2));
        ((AbstractDocument) txtAnio.getDocument()).setDocumentFilter(new NumerosSoloDocumentFilter(4));
    }
    
    private void buscarYActualizarTabla() {
        
        int dia;
        int mes;
        int anio;
        
        if(txtDia.getText().equals("")){
            dia = -1;
        }else{
            dia = Integer.parseInt(txtDia.getText());
        }
        
        if(txtMes.getText().equals("")){
            mes = -1;
        }else{
            mes = Integer.parseInt(txtMes.getText());
        }
        
        if(txtAnio.getText().equals("")){
            anio = -1;
        }else{
            anio = Integer.parseInt(txtAnio.getText());
        }
        
        if(dia != -1 && mes != -1 && anio != -1){
            if (anio < 1900 || anio > 2100) {
                JOptionPane.showMessageDialog(null, "Año fuera de rango.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (mes < 1 || mes > 12) {
                JOptionPane.showMessageDialog(null, "Mes fuera de rango.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int maxDias;
                switch (mes) {
                    case 2: // Febrero
                        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                            maxDias = 29;
                        } else {
                            maxDias = 28;
                        }
                        break;
                    case 4: case 6: case 9: case 11:
                        maxDias = 30; // Meses con 30 días
                        break;
                    default:
                        maxDias = 31; // Meses con 31 días
                }

                if (dia < 1 || dia > maxDias) {
                    JOptionPane.showMessageDialog(null, "Dia fuera de rango.", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    List<Venta> listaVentas = ventaController.busquedaDeVentas(dia, mes, anio);
                    //System.out.println("tamaño lista: " + listaVentas.size());

                    if(listaVentas.isEmpty()){
                        JOptionPane.showMessageDialog(null, "No hay coincidencias con la búsqueda.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        cargarTablas(listaVentas);
                    }
                }  
            }
        }else{
            JOptionPane.showMessageDialog(null, "Una o mas casillas vacias.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
            
        
        
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
