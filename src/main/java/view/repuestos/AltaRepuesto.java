package view.repuestos;

import config.NumerosSoloDocumentFilter;
import controller.RepuestoController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import model.Categoria;
import model.Marca;
import model.Modelo;
import model.NombreRepuesto;
import model.Repuesto;
import model.Ubicacion;

public class AltaRepuesto extends javax.swing.JFrame {

    private final RepuestoController repuestoController;
    
    public AltaRepuesto(RepuestoController repuestoController) {
        this.repuestoController = repuestoController;
        initComponents();
        configurarEventos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboMarca = new javax.swing.JComboBox<>();
        comboCategoria = new javax.swing.JComboBox<>();
        comboUbicacion = new javax.swing.JComboBox<>();
        comboNombreRepuesto = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        comboModelo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("Alta Repuesto");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Nombre Repuesto:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Marca:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Categoria:");

        btnAtras.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel5.setText("Precio:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("Ubicacion:");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setText("Stock:");

        comboMarca.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        comboMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboCategoria.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboUbicacion.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        comboUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboNombreRepuesto.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        comboNombreRepuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtPrecio.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        txtStock.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        comboModelo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        comboModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setText("Modelo:");

        txtCodigo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel9.setText("Codigo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboNombreRepuesto, 0, 330, Short.MAX_VALUE)
                            .addComponent(comboMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboUbicacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboNombreRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
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

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
        comboNombreRepuesto.setSelectedItem("-");
        comboModelo.setSelectedItem("-");
        comboMarca.setSelectedItem("-");
        comboCategoria.setSelectedItem("-");
        comboUbicacion.setSelectedItem("-");
        
        txtCodigo.setText("");
        txtStock.setText("");
        txtPrecio.setText("");
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        String nombreRepuestoSeleccionado = comboNombreRepuesto.getSelectedItem().toString();
        String marcaSeleccionada = comboMarca.getSelectedItem().toString();
        String modeloSeleccionada = comboModelo.getSelectedItem().toString();
        String ubicacionSeleccionada = comboUbicacion.getSelectedItem().toString();
        String categoriaSeleccionada = comboCategoria.getSelectedItem().toString();
        
        String codigo = txtCodigo.getText();
        int stock = Integer.parseInt(txtStock.getText());
        int precio = Integer.parseInt(txtPrecio.getText()); 
        
        Repuesto repuesto = new Repuesto();
        repuestoController.agregarRepuesto(nombreRepuestoSeleccionado, marcaSeleccionada, modeloSeleccionada, categoriaSeleccionada, ubicacionSeleccionada, codigo, stock, precio);
        JOptionPane.showMessageDialog(null, "Carga realizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        cargarComboBoxes();
        
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboMarca;
    private javax.swing.JComboBox<String> comboModelo;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

    private void configurarEventos(){
        btnGuardar.setEnabled(false); // Deshabilita el botón inicialmente.

        DocumentListener docListener = new DocumentListener() {

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

        // Agrega el DocumentListener a los JTextField
        txtPrecio.getDocument().addDocumentListener(docListener);
        txtStock.getDocument().addDocumentListener(docListener);
        txtCodigo.getDocument().addDocumentListener(docListener);
        
        NumerosSoloDocumentFilter filter = new NumerosSoloDocumentFilter(15);
        ((AbstractDocument) txtPrecio.getDocument()).setDocumentFilter(filter);
        ((AbstractDocument) txtStock.getDocument()).setDocumentFilter(filter);

        // Agrega ActionListener a los JComboBox para detectar cambios de selección
        ActionListener comboListener = e -> actualizarEstadoBoton();
        comboMarca.addActionListener(comboListener);
        comboCategoria.addActionListener(comboListener);
        comboNombreRepuesto.addActionListener(comboListener);
        comboUbicacion.addActionListener(comboListener);
        comboModelo.addActionListener(comboListener);

        // Configura el mapeo de la tecla Enter para activar btnGuardar
        String enterKey = "ENTER";
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enterKey);
        getRootPane().getActionMap().put(enterKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGuardar.doClick(); // Simula un clic en btnGuardar
            }
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
    
    private void cargarComboBoxes(){
        comboCategoria.removeAllItems();
        comboMarca.removeAllItems();
        comboNombreRepuesto.removeAllItems();
        comboUbicacion.removeAllItems();
        comboModelo.removeAllItems();
        
        comboCategoria.addItem("-");
        comboMarca.addItem("-");
        comboNombreRepuesto.addItem("-");
        comboUbicacion.addItem("-");
        comboModelo.addItem("-");
        
        List<NombreRepuesto> listaNombreRepuestos = repuestoController.retornarListaNombreRepuestos();
        List<Marca> listaMarcas = repuestoController.retornarListaMarcas();
        List<Categoria> listaCategorias = repuestoController.retornarCategorias();
        List<Ubicacion> listaUbicaciones = repuestoController.retornarUbicaciones();
        List<Modelo> listaModelos = repuestoController.retornarModelos();
        
        for(NombreRepuesto nomb : listaNombreRepuestos){
            comboNombreRepuesto.addItem(nomb.getNombre_repuesto());
        }
        
        for(Marca marca : listaMarcas){
            comboMarca.addItem(marca.getNombre_marca());
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
    }
    
    private void actualizarEstadoBoton() {
        // Verifica si los campos de texto no están vacíos
        boolean textoNoVacio = !txtPrecio.getText().trim().isEmpty() &&
                               !txtStock.getText().trim().isEmpty() &&
                               !txtCodigo.getText().trim().isEmpty();

        // Verifica si se ha seleccionado una opción válida en todos los JComboBox
        boolean comboSeleccionado = comboMarca.getSelectedIndex() != 0 &&
                                    comboCategoria.getSelectedIndex() != 0 &&
                                    comboNombreRepuesto.getSelectedIndex() != 0 &&
                                    comboUbicacion.getSelectedIndex() != 0 &&
                                    comboModelo.getSelectedIndex() != 0;

        // Habilita el botón si todos los campos tienen texto y todos los JComboBox tienen una opción seleccionada
        btnGuardar.setEnabled(textoNoVacio && comboSeleccionado);
    }

}
