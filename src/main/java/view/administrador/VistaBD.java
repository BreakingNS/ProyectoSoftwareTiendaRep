package view.administrador;

import config.BackupDataBase;
import config.RestoreDataBase;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class VistaBD extends javax.swing.JFrame {

    private final Connection connection;
    
    public VistaBD(Connection connection) {
        this.connection = connection;
        initComponents();
        configurarEventos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSchemas = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnImportar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnImportar.setText("IMPORTAR");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        tablaSchemas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tablaSchemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaSchemas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaSchemas);

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

        btnExportar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnExportar.setText("EXPORTAR");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("LISTA BASES DE DATOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(66, 66, 66)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        int selectedRow = this.tablaSchemas.getSelectedRow();
        if (selectedRow != -1) {
            String fileName = (String)this.tablaSchemas.getValueAt(selectedRow, 0);
            System.out.println("Archivo seleccionado para importar: " + fileName);
            String filePath = "C:\\BASES DE DATOS H2\\" + fileName;
            RestoreDataBase.clearDatabase();
            RestoreDataBase.importBackup(filePath);
            JOptionPane.showMessageDialog((Component)null, "Base de Datos IMPORTADA correctamente.", "Éxito", 1);
        } else {
            System.out.println("Por favor, selecciona un archivo para importar.");
        }
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        String fileName = JOptionPane.showInputDialog("Ingresa el nombre para el backup:");
        if (fileName != null && !fileName.trim().isEmpty()) {
            String filePath = "C:\\BASES DE DATOS H2\\" + fileName + ".sql";
            BackupDataBase.exportBackup(filePath, this.jPanel1);
            JOptionPane.showMessageDialog((Component)null, "Base de Datos EXPORTADA correctamente.", "Éxito", 1);
        }

    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnImportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaSchemas;
    // End of variables declaration//GEN-END:variables
    
    private void configurarEventos(){
        btnEliminar.setEnabled(false); // Deshabilita el botón inicialmente.

        tablaSchemas.getSelectionModel().addListSelectionListener(e -> {
            btnEliminar.setEnabled(tablaSchemas.getSelectedRow() != -1); // Habilita si hay una fila seleccionada.
        });
        
        btnImportar.setEnabled(false); // Deshabilita el botón inicialmente.

        tablaSchemas.getSelectionModel().addListSelectionListener(e -> {
            btnImportar.setEnabled(tablaSchemas.getSelectedRow() != -1); // Habilita si hay una fila seleccionada.
        });
        
        // Configura el mapeo de la tecla Enter para activar btnGuardar
        String enterKey = "ENTER";
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enterKey);
        getRootPane().getActionMap().put(enterKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnImportar.doClick(); // Simula un clic en btnGuardar
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
    
    private void cargarTabla() {
        
        File folder = new File("C:\\BASES DE DATOS H2");
        
        if (folder.exists() && folder.isDirectory()) {
            File[] backups = folder.listFiles((dir, name) -> {
                return name.endsWith(".sql");
            });
            DefaultTableModel model = (DefaultTableModel)this.tablaSchemas.getModel();
            model.setRowCount(0);
            if (model.getColumnCount() == 0) {
                model.addColumn("Backup");
                model.addColumn("Fecha de Modificación");
            }

            if (backups != null && backups.length > 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                File[] var5 = backups;
                int var6 = backups.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                File backup = var5[var7];
                String lastModified = sdf.format(new Date(backup.lastModified()));
                model.addRow(new Object[]{backup.getName(), lastModified});
                }
            }
        }
    }


}
