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
import model.Pago;
import model.Reparacion;
import model.Repuesto;

public class ActualizarPago extends javax.swing.JFrame {

    private final FacturaController facturaController;
    private final ReparacionController reparacionController;
    private final PagoController pagoController;
    private final int idFactura;
    private final BigDecimal precioFinal;
    private final BigDecimal costoTotal;
    private final Reparacion reparacion;
    private final List<Repuesto> listaRepuestos;
    
    private ButtonGroup group;
    
    public ActualizarPago(FacturaController facturaController,
            ReparacionController reparacionController,
            PagoController pagoController, 
            int idFactura,
            BigDecimal precioFinal, 
            BigDecimal costoTotal, 
            Reparacion reparacion,
            List<Repuesto> listaRepuestos
    ) {
        this.facturaController = facturaController;
        this.reparacionController = reparacionController;
        this.pagoController = pagoController;
        this.idFactura = idFactura;
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
        jLabel1 = new javax.swing.JLabel();
        txtTotalRepuestos = new javax.swing.JTextField();
        lblCosto = new javax.swing.JLabel();
        lblCosto2 = new javax.swing.JLabel();
        txtManoDeObra = new javax.swing.JTextField();
        txtCostoTotal = new javax.swing.JTextField();
        lblCosto1 = new javax.swing.JLabel();
        lblDetalles1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        radioBtnTOTAL = new javax.swing.JRadioButton();
        radioBtnPARCIAL = new javax.swing.JRadioButton();
        txtTotal = new javax.swing.JTextField();
        lblDetalles = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtParcial = new javax.swing.JTextField();
        lblCosto3 = new javax.swing.JLabel();
        txtPagado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("Actualizacion Pago");

        txtTotalRepuestos.setEditable(false);
        txtTotalRepuestos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblCosto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCosto.setText("Total Repuestos:");

        lblCosto2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCosto2.setText("Mano de Obra:");

        txtManoDeObra.setEditable(false);
        txtManoDeObra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtCostoTotal.setEditable(false);
        txtCostoTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblCosto1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCosto1.setText("Costo Total:");

        lblDetalles1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDetalles1.setText("Detalle: ");

        txtDetalle.setColumns(20);
        txtDetalle.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

        radioBtnTOTAL.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        radioBtnTOTAL.setText("TOTAL: ");
        radioBtnTOTAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnTOTALActionPerformed(evt);
            }
        });

        radioBtnPARCIAL.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        radioBtnPARCIAL.setText("PARCIAL:");
        radioBtnPARCIAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPARCIALActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblDetalles.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDetalles.setText("Actualizar Pago: ");

        btnAtras.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtParcial.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblCosto3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCosto3.setText("Pagado a la Fecha:");

        txtPagado.setEditable(false);
        txtPagado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioBtnTOTAL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioBtnPARCIAL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDetalles)
                            .addComponent(lblCosto3))
                        .addGap(69, 69, 69))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCosto)
                            .addComponent(txtTotalRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCosto3))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtManoDeObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCosto2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCosto1))
                        .addGap(18, 18, 18)
                        .addComponent(lblDetalles1)
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(txtPagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lblDetalles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioBtnPARCIAL)
                            .addComponent(txtParcial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioBtnTOTAL)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, Short.MAX_VALUE))))
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

    private void radioBtnTOTALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnTOTALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtnTOTALActionPerformed

    private void radioBtnPARCIALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPARCIALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtnPARCIALActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        BigDecimal totalPagos = BigDecimal.ZERO;
        List<Pago> listaPagos = pagoController.obtenerPagosPorIdFactura(idFactura);
        for(Pago pago : listaPagos){
            totalPagos = totalPagos.add(pago.getMontoAbonado());
        }
        
        Factura factura = facturaController.obtenerFacturaPorId(idFactura);
        String pagoSeleccionado = group.getSelection().getActionCommand();
        BigDecimal montoAbonado = BigDecimal.ZERO;
        String pagado;
        
        if(pagoSeleccionado.equals("PARCIAL")){
            montoAbonado = new BigDecimal(txtParcial.getText());
            pagado = "PARCIAL";
        }else{
            montoAbonado = new BigDecimal(txtTotal.getText());
            pagado = "SI";
        }
        
        String detalle = txtDetalle.getText();
        
        pagoController.agregarPago(factura, montoAbonado, LocalDateTime.now(), detalle);
        
        
        if(!totalPagos.equals(0) || !factura.getEstado().equals(pagado)){
            facturaController.editarFactura(idFactura, pagado, costoTotal);
        }
        
        //------

        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblCosto1;
    private javax.swing.JLabel lblCosto2;
    private javax.swing.JLabel lblCosto3;
    private javax.swing.JLabel lblDetalles;
    private javax.swing.JLabel lblDetalles1;
    private javax.swing.JRadioButton radioBtnPARCIAL;
    private javax.swing.JRadioButton radioBtnTOTAL;
    private javax.swing.JTextField txtCostoTotal;
    private javax.swing.JTextArea txtDetalle;
    private javax.swing.JTextField txtManoDeObra;
    private javax.swing.JTextField txtPagado;
    private javax.swing.JTextField txtParcial;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalRepuestos;
    // End of variables declaration//GEN-END:variables

    private void cargarTextFields(){
        txtTotalRepuestos.setText(precioFinal.toString());
        txtManoDeObra.setText((costoTotal.subtract(precioFinal)).toString());
        txtCostoTotal.setText(costoTotal.toString());
        
        Factura factura = facturaController.obtenerFacturaPorId(idFactura);
        BigDecimal totalPagos = BigDecimal.ZERO;
        List<Pago> listaPagos = pagoController.obtenerPagosPorIdFactura(idFactura);
        for(Pago pago : listaPagos){
            totalPagos = totalPagos.add(pago.getMontoAbonado());
        }
        
        txtPagado.setText(totalPagos.toString());
        
        txtTotal.setText((factura.getMontoTotal().subtract(totalPagos)).toString());
    }
    
    private void configuracionComponentes(){
        group = new ButtonGroup();
        group.add(radioBtnPARCIAL);
        group.add(radioBtnTOTAL);
        
        radioBtnPARCIAL.setSelected(true);
        
        radioBtnPARCIAL.setActionCommand("PARCIAL");
        radioBtnTOTAL.setActionCommand("TOTAL");

    }
    
    private void configurarEventos() {
        txtParcial.setEnabled(true);
        
        NumerosSoloDocumentFilter filter = new NumerosSoloDocumentFilter(15);
        ((AbstractDocument) txtParcial.getDocument()).setDocumentFilter(filter);
        
        radioBtnPARCIAL.addActionListener(e -> {
            txtParcial.setEnabled(radioBtnPARCIAL.isSelected());  // Habilita o deshabilita según la selección
        });

        // Si cambias a otra opción, deshabilita el TextField
        radioBtnTOTAL.addActionListener(e -> {
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
