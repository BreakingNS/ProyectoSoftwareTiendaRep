package view.reparaciones;

import config.NumerosSoloDocumentFilter;
import controller.FacturaController;
import controller.PagoController;
import controller.ReparacionController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.text.AbstractDocument;
import model.Factura;
import model.Reparacion;
import model.Repuesto;

public class VistaPago extends javax.swing.JFrame {

    private final FacturaController facturaController;
    private final ReparacionController reparacionController;
    private final PagoController pagoController;
    private final BigDecimal precioFinal;
    private final BigDecimal costoTotal;
    private final Reparacion reparacion;
    private final List<Repuesto> listaRepuestos;
    
    private ButtonGroup group;
    
    public VistaPago(FacturaController facturaController,
            ReparacionController reparacionController,
            PagoController pagoController, 
            BigDecimal precioFinal, 
            BigDecimal costoTotal, 
            Reparacion reparacion,
            List<Repuesto> listaRepuestos
    ) {
        this.facturaController = facturaController;
        this.reparacionController = reparacionController;
        this.pagoController = pagoController;
        this.precioFinal = precioFinal;
        this.costoTotal = costoTotal;
        this.reparacion = reparacion;
        this.listaRepuestos = listaRepuestos;
        initComponents();
        configuracionComponentes();
        configurarEventos();
        cargarTextFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDetalles = new javax.swing.JLabel();
        radioBtnNO = new javax.swing.JRadioButton();
        radioBtnPARCIAL = new javax.swing.JRadioButton();
        radioBtnSI = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        lblCosto1 = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        txtCostoTotal = new javax.swing.JTextField();
        txtManoDeObra = new javax.swing.JTextField();
        lblCosto2 = new javax.swing.JLabel();
        txtTotalRepuestos = new javax.swing.JTextField();
        txtParcial = new javax.swing.JTextField();
        lblDetalles1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDetalles.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDetalles.setText("Pagado: ");

        radioBtnNO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        radioBtnNO.setText("NO");
        radioBtnNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnNOActionPerformed(evt);
            }
        });

        radioBtnPARCIAL.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        radioBtnPARCIAL.setText("PARCIAL:");
        radioBtnPARCIAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPARCIALActionPerformed(evt);
            }
        });

        radioBtnSI.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        radioBtnSI.setText("SI");
        radioBtnSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnSIActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("Alta Reparacion - Pago");

        btnGuardar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        lblCosto1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCosto1.setText("Costo Total:");

        lblCosto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCosto.setText("Total Repuestos:");

        txtCostoTotal.setEditable(false);
        txtCostoTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtManoDeObra.setEditable(false);
        txtManoDeObra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblCosto2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCosto2.setText("Mano de Obra:");

        txtTotalRepuestos.setEditable(false);
        txtTotalRepuestos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtParcial.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblDetalles1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDetalles1.setText("Detalle: ");

        txtDetalle.setColumns(20);
        txtDetalle.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1)
                        .addGap(79, 79, 79))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCosto2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtManoDeObra, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCosto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCosto1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDetalles1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDetalles)
                                    .addComponent(radioBtnNO)
                                    .addComponent(radioBtnSI)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(radioBtnPARCIAL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)))))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCosto)
                            .addComponent(txtTotalRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtManoDeObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCosto2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCosto1))
                        .addGap(30, 30, 30)
                        .addComponent(lblDetalles1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblDetalles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioBtnNO)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioBtnPARCIAL)
                            .addComponent(txtParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(radioBtnSI)
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
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

    private void radioBtnNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtnNOActionPerformed

    private void radioBtnPARCIALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPARCIALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtnPARCIALActionPerformed

    private void radioBtnSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtnSIActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String estado = group.getSelection().getActionCommand();
        BigDecimal montoAbonado = costoTotal;

        facturaController.agregarFactura(estado, costoTotal);
        Factura factura = facturaController.obtenerUltimaFactura();

        if(estado.equals("PARCIAL")){
            montoAbonado = new BigDecimal(txtParcial.getText());
        }
        else if(estado.equals("NO")){
            montoAbonado = BigDecimal.ZERO;
        }

        pagoController.agregarPago(factura, montoAbonado, LocalDateTime.now(), txtDetalle.getSelectedText());
        
        reparacion.setFactura(factura);
        
        if(estado.equals("PARCIAL")){
            if(montoAbonado == costoTotal) {
                JOptionPane.showMessageDialog(null, "Seleccione 'SI' para realizar pago total.", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else if (montoAbonado.compareTo(new BigDecimal("1")) < 0 || (montoAbonado.compareTo(costoTotal) > 0)) {
                JOptionPane.showMessageDialog(null, "Ingrese un monto correcto.", "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }else{
            try {
                reparacionController.agregarReparacion(reparacion, listaRepuestos);
                JOptionPane.showMessageDialog(null, "Carga realizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(VistaPago.class.getName()).log(Level.SEVERE, null, ex);
            }

            dispose();
        }
        

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblCosto1;
    private javax.swing.JLabel lblCosto2;
    private javax.swing.JLabel lblDetalles;
    private javax.swing.JLabel lblDetalles1;
    private javax.swing.JRadioButton radioBtnNO;
    private javax.swing.JRadioButton radioBtnPARCIAL;
    private javax.swing.JRadioButton radioBtnSI;
    private javax.swing.JTextField txtCostoTotal;
    private javax.swing.JTextArea txtDetalle;
    private javax.swing.JTextField txtManoDeObra;
    private javax.swing.JTextField txtParcial;
    private javax.swing.JTextField txtTotalRepuestos;
    // End of variables declaration//GEN-END:variables

    private void cargarTextFields(){
        txtTotalRepuestos.setText(precioFinal.toString());
        txtManoDeObra.setText((costoTotal.subtract(precioFinal)).toString());
        txtCostoTotal.setText(costoTotal.toString());
    }
    
    private void configuracionComponentes(){
        group = new ButtonGroup();
        group.add(radioBtnNO);
        group.add(radioBtnPARCIAL);
        group.add(radioBtnSI);
        
        radioBtnNO.setSelected(true);
        
        radioBtnNO.setActionCommand("NO");
        radioBtnPARCIAL.setActionCommand("PARCIAL");
        radioBtnSI.setActionCommand("SI");

    }
    
    private void configurarEventos() {
        txtParcial.setEnabled(false);
        
        NumerosSoloDocumentFilter filter = new NumerosSoloDocumentFilter(15);
        ((AbstractDocument) txtParcial.getDocument()).setDocumentFilter(filter);
        
        radioBtnPARCIAL.addActionListener(e -> {
            txtParcial.setEnabled(radioBtnPARCIAL.isSelected());  // Habilita o deshabilita según la selección
        });

        // Si cambias a otra opción, deshabilita el TextField
        radioBtnNO.addActionListener(e -> {
            txtParcial.setEnabled(false);
        });
        radioBtnSI.addActionListener(e -> {
            txtParcial.setEnabled(false);
        });
        
        String enterKey = "ENTER";
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enterKey);
        getRootPane().getActionMap().put(enterKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGuardar.doClick(); // Simula un clic en btnGuardar
            }
        });
        
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
