package view.repuestos;

import controller.RepuestoController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Marca;
import model.NombreRepuesto;
import model.Precio;
import model.Repuesto;
import model.Ubicacion;

public class VistaRepuestos extends javax.swing.JFrame {

    private final RepuestoController repuestoController;
    
    public VistaRepuestos(RepuestoController repuestoController) {
        this.repuestoController = repuestoController;
        initComponents();
        cargarComboBoxes();
        configurarEventos();
        configurarListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRepuestos = new javax.swing.JTable();
        txtStock = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        comboMarca = new javax.swing.JComboBox<>();
        comboUbicacion = new javax.swing.JComboBox<>();
        comboCategoria = new javax.swing.JComboBox<>();
        comboNombreRepuesto = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Buscar:");

        jLabel3.setText("Nombre Repuesto");

        jLabel4.setText("Marca");

        jLabel5.setText("Categoria");

        jLabel6.setText("Ubicacion");

        jLabel7.setText("Stock");

        jLabel8.setText("Precio");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("MODELO VISTA REPUESTOS");

        btnLimpiar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

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

        tablaRepuestos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tablaRepuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaRepuestos);

        txtStock.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtPrecio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        comboMarca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboUbicacion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboNombreRepuesto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboNombreRepuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(56, 56, 56))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(comboNombreRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(125, 125, 125)
                                        .addComponent(jLabel5)
                                        .addGap(104, 104, 104)
                                        .addComponent(jLabel6)
                                        .addGap(103, 103, 103))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpiar)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboNombreRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        comboCategoria.setSelectedItem("-");
        comboMarca.setSelectedItem("-");
        comboNombreRepuesto.setSelectedItem("-");
        comboUbicacion.setSelectedItem("-");
        
        txtStock.setText("");
        txtPrecio.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AltaRepuesto alta = new AltaRepuesto(repuestoController);
        //alta.setSize(600, 400);
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);

        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTabla(); // Actualiza la tabla después de cerrar AltaRepuesto.
            }
        });
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        if(tablaRepuestos.getRowCount() > 0){
            if(tablaRepuestos.getSelectedRow()!=-1){
                
                int idRepuesto = Integer.parseInt(String.valueOf(tablaRepuestos.getValueAt(tablaRepuestos.getSelectedRow(), 0)));
                String comboNombreRep = String.valueOf(tablaRepuestos.getValueAt(tablaRepuestos.getSelectedRow(), 1));
                String comboMarca = String.valueOf(tablaRepuestos.getValueAt(tablaRepuestos.getSelectedRow(), 2));
                String comboCategoria = String.valueOf(tablaRepuestos.getValueAt(tablaRepuestos.getSelectedRow(), 3));
                String comboUbicacion = String.valueOf(tablaRepuestos.getValueAt(tablaRepuestos.getSelectedRow(), 4));
                int stock = Integer.parseInt(String.valueOf(tablaRepuestos.getValueAt(tablaRepuestos.getSelectedRow(), 5)));
                BigDecimal precio = new BigDecimal(tablaRepuestos.getValueAt(tablaRepuestos.getSelectedRow(), 6).toString());
                
                EditarRepuesto alta = new EditarRepuesto(idRepuesto, 
                        comboNombreRep,
                        comboMarca,
                        comboCategoria,
                        comboUbicacion,
                        stock,
                        precio,
                        repuestoController);
                //alta.setSize(600, 400);
                alta.setResizable(false);
                alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                alta.setVisible(true);
                alta.setLocationRelativeTo(null);

                alta.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        cargarTabla(); // Actualiza la tabla después de cerrar AltaRepuesto.
                    }
                });
                
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de que desea eliminar este REPUESTO, se eliminaran todos los PRECIOS del mismo?",
            "Confirmar eliminacion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            int idRepuesto = 0;

            if(tablaRepuestos.getRowCount() > 0){
                if(tablaRepuestos.getSelectedRow()!=-1){
                    idRepuesto = Integer.parseInt(String.valueOf(tablaRepuestos.getValueAt(tablaRepuestos.getSelectedRow(), 0)));
                }
            }

            repuestoController.eliminarRepuesto(idRepuesto);
            JOptionPane.showMessageDialog(null, "Eliminación realizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboMarca;
    private javax.swing.JComboBox<String> comboNombreRepuesto;
    private javax.swing.JComboBox<String> comboUbicacion;
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
    private javax.swing.JTable tablaRepuestos;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
    
    private void cargarTabla(){
        //Hacemos que la tabla no sea editable
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //Ponemos titulos a las columnas
        String titulos[] = {"Id", "Nombre Repuesto", "Marca", "Categoria", "Ubicacion", "Stock", "Precio"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        //Traer Repuestos desde la base de datos
        List<Repuesto> listaRepuestos = repuestoController.listarRepuestos();
        
        //Setear los datos en la tabla
        if(listaRepuestos != null){
            System.out.println("tamaño de la lista: " + listaRepuestos.size());
            for(Repuesto repuesto : listaRepuestos){
                Object[] objeto = {repuesto.getId_repuesto(), 
                    repuesto.getNombreRepuesto().getNombre_repuesto(), 
                    repuesto.getMarca().getNombre_marca(), 
                    repuesto.getCategoria().getNombre_categoria(), 
                    repuesto.getUbicacion().getNombre_ubicacion(), 
                    repuesto.getStock(), 
                    repuesto.getListaPrecios().get((repuesto.getListaPrecios().size()) - 1).getValor()
                };
                modeloTabla.addRow(objeto);
            }
        }
        
        tablaRepuestos.setModel(modeloTabla);
    }
    
    private void cargarTablaBusqueda(List<Repuesto> listaRepuestos){
        // Hacemos que la tabla no sea editable
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Ponemos títulos a las columnas
        String[] titulos = {"Id", "Nombre Repuesto", "Marca", "Categoria", "Ubicacion", "Stock", "Precio"};
        modeloTabla.setColumnIdentifiers(titulos);

        // Setear los datos en la tabla
        if (listaRepuestos != null) {
            System.out.println("Tamaño de la lista: " + listaRepuestos.size());
            for (Repuesto repuesto : listaRepuestos) {
                // Asegurarse de que la lista de precios no esté vacía
                List<Precio> listaPrecios = repuesto.getListaPrecios();
                Object precio = "No disponible"; // Valor predeterminado si la lista está vacía

                if (listaPrecios != null && !listaPrecios.isEmpty()) {
                    precio = listaPrecios.get(listaPrecios.size() - 1).getValor();
                }

                // Asegurarse de que los métodos no devuelvan null
                Object[] objeto = {
                    repuesto.getId_repuesto(),
                    repuesto.getNombreRepuesto() != null ? repuesto.getNombreRepuesto().getNombre_repuesto() : "Desconocido",
                    repuesto.getMarca() != null ? repuesto.getMarca().getNombre_marca() : "Desconocido",
                    repuesto.getCategoria() != null ? repuesto.getCategoria().getNombre_categoria() : "Desconocido",
                    repuesto.getUbicacion() != null ? repuesto.getUbicacion().getNombre_ubicacion() : "Desconocido",
                    repuesto.getStock(),
                    precio
                };
                modeloTabla.addRow(objeto);
            }
        }

        // Asignar el modelo a la tabla
        tablaRepuestos.setModel(modeloTabla);
    }

    
    private void configurarEventos() {
        btnEliminar.setEnabled(false); // Deshabilita el botón inicialmente.

        tablaRepuestos.getSelectionModel().addListSelectionListener(e -> {
            btnEliminar.setEnabled(tablaRepuestos.getSelectedRow() != -1); // Habilita si hay una fila seleccionada.
        });
        
        btnEditar.setEnabled(false); // Deshabilita el botón inicialmente.

        tablaRepuestos.getSelectionModel().addListSelectionListener(e -> {
            btnEditar.setEnabled(tablaRepuestos.getSelectedRow() != -1); // Habilita si hay una fila seleccionada.
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
    }
    
    private void configurarListeners() {
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
        comboNombreRepuesto.addActionListener(comboListener);
        comboUbicacion.addActionListener(comboListener);
        
        // Agrega DocumentListener a los JTextField
        txtStock.getDocument().addDocumentListener(docListener);
        txtPrecio.getDocument().addDocumentListener(docListener);
        
    }
    
    // Método para realizar la búsqueda y actualizar la tabla
    private void buscarYActualizarTabla() {
        
        String marcaSeleccionada = (comboMarca.getSelectedItem() != null) ? comboMarca.getSelectedItem().toString() : "-";
        String categoriaSeleccionada = (comboCategoria.getSelectedItem() != null) ? comboCategoria.getSelectedItem().toString() : "-";
        String nombreRepuestoSeleccionado = (comboNombreRepuesto.getSelectedItem() != null) ? comboNombreRepuesto.getSelectedItem().toString() : "-";
        String ubicacionSeleccionada = (comboUbicacion.getSelectedItem() != null) ? comboUbicacion.getSelectedItem().toString() : "-";/*
        */
        int stock = 0;
        int precio = 0;

        // Verifica que los campos de texto no estén vacíos antes de convertirlos
        if (!txtStock.getText().isEmpty()) {
            stock = Integer.parseInt(txtStock.getText());
        }

        if (!txtPrecio.getText().isEmpty()) {
            precio = Integer.parseInt(txtPrecio.getText());
        }

        //List<Repuesto> listaRepuestos = repuestoController.busquedaDeRepuesto(marcaSeleccionada, categoriaSeleccionada, nombreRepuestoSeleccionado, ubicacionSeleccionada, stock, precio);
        
        System.out.println("comienzo carga de busqueda");
        
        List<Repuesto> listaRepuestos = repuestoController.busquedaDeRepuesto(
                marcaSeleccionada, 
                categoriaSeleccionada, 
                nombreRepuestoSeleccionado, 
                ubicacionSeleccionada, 
                stock, 
                precio);
        
        cargarTablaBusqueda(listaRepuestos);
    }
    
    private void cargarComboBoxes(){
        comboCategoria.removeAllItems();
        comboMarca.removeAllItems();
        comboNombreRepuesto.removeAllItems();
        comboUbicacion.removeAllItems();
        
        NombreRepuesto nombreRepuesto = new NombreRepuesto(0, "-");
        Marca marca = new Marca(0, "-", new ArrayList<>());
        Categoria categoria = new Categoria(0, "-", new ArrayList<>(), new ArrayList<>());
        Ubicacion ubicacion = new Ubicacion(0, "-", new ArrayList<>());
        
        comboCategoria.addItem(nombreRepuesto.getNombre_repuesto());
        comboMarca.addItem(marca.getNombre_marca());
        comboNombreRepuesto.addItem(categoria.getNombre_categoria());
        comboUbicacion.addItem(ubicacion.getNombre_ubicacion());
        
        List<NombreRepuesto> listaNombreRepuestos = repuestoController.retornarListaNombreRepuestos();
        List<Marca> listaMarcas = repuestoController.retornarListaMarcas();
        List<Categoria> listaCategorias = repuestoController.retornarCategorias();
        List<Ubicacion> listaUbicaciones = repuestoController.retornarUbicaciones();
        
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
        
        System.out.println("fin carga comboboxes");
    }
}
