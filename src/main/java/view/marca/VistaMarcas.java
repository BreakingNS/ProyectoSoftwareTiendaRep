package view.marca;

import controller.MarcaController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import model.Marca;
import view.nombreRepuesto.VistaNombreRepuesto;

public class VistaMarcas extends javax.swing.JFrame {
    
    private final MarcaController marcaController;
    
    public VistaMarcas(MarcaController marcaController) {
        
        this.marcaController = marcaController;
        initComponents();
        configurarEventos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMarcas = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("MARCAS");

        tablaMarcas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tablaMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaMarcas.setRowHeight(24);
        tablaMarcas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaMarcas);

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

        btnAtras.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de que desea eliminar este usuario?", 
                "Confirmar eliminacion", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            int idMarca = 0;
        
            if(tablaMarcas.getRowCount() > 0){
                if(tablaMarcas.getSelectedRow()!=-1){
                    idMarca = Integer.parseInt(String.valueOf(tablaMarcas.getValueAt(tablaMarcas.getSelectedRow(), 0)));
                }
            }

            marcaController.eliminarMarca(idMarca);
            JOptionPane.showMessageDialog(null, "Eliminación realizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.setEnabled(false);
        AltaMarca alta = new AltaMarca(marcaController);
        //alta.setSize(600, 400);
        alta.setTitle("Software ElectroClima");
        alta.setResizable(false);
        alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);
        
        alta.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                VistaMarcas.this.setEnabled(true);
                VistaMarcas.this.setState(JFrame.NORMAL);  
                VistaMarcas.this.toFront();                
                VistaMarcas.this.requestFocus();   
                cargarTabla(); // Actualiza la tabla después de cerrar AltaMarca.
            }
        });
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int idMarca = 0;

        if(tablaMarcas.getRowCount() > 0){
            if(tablaMarcas.getSelectedRow()!=-1){
                idMarca = Integer.parseInt(String.valueOf(tablaMarcas.getValueAt(tablaMarcas.getSelectedRow(), 0)));
                
                this.setEnabled(false);
                EditarMarca alta = new EditarMarca(idMarca, marcaController);
                //alta.setSize(600, 400);
                alta.setTitle("Software ElectroClima");
                alta.setResizable(false);
                alta.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                alta.setVisible(true);
                alta.setLocationRelativeTo(null);

                alta.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        VistaMarcas.this.setEnabled(true);
                        VistaMarcas.this.setState(JFrame.NORMAL);  
                        VistaMarcas.this.toFront();                
                        VistaMarcas.this.requestFocus();   
                        cargarTabla(); // Actualiza la tabla después de cerrar AltaMarca.
                    }
                });
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMarcas;
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
        String titulos[] = {"Id", "Marca"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        //Traer Marcas desde la base de datos
        List<Marca> listaMarcas = marcaController.listarMarcasOrdenadasPorNombre();
        
        //Setear los datos en la tabla
        if(listaMarcas != null){
            //System.out.println("tamaño de la lista: " + listaMarcas.size());
            for(Marca marca : listaMarcas){
                Object[] objeto = {marca.getId_marca(), marca.getNombre_marca()};
                
                modeloTabla.addRow(objeto);
            }
        }

        tablaMarcas.setModel(modeloTabla);
    }
    
    private void configurarEventos() {
        btnEliminar.setEnabled(false); // Deshabilita el botón inicialmente.

        tablaMarcas.getSelectionModel().addListSelectionListener(e -> {
            btnEliminar.setEnabled(tablaMarcas.getSelectedRow() != -1); // Habilita si hay una fila seleccionada.
        });
        
        btnEditar.setEnabled(false); // Deshabilita el botón inicialmente.

        tablaMarcas.getSelectionModel().addListSelectionListener(e -> {
            btnEditar.setEnabled(tablaMarcas.getSelectedRow() != -1); // Habilita si hay una fila seleccionada.
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

}
