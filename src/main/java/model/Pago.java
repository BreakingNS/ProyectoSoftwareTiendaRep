package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pago {
    private int id_pago;
    private Factura factura;
    private BigDecimal montoAbonado;
    private LocalDateTime fechaPago;
    private String detalle;

    public Pago() {
    }

    public Pago(int id_pago, Factura factura, BigDecimal montoAbonado, LocalDateTime fechaPago, String detalle) {
        this.id_pago = id_pago;
        this.factura = factura;
        this.montoAbonado = montoAbonado;
        this.fechaPago = fechaPago;
        this.detalle = detalle;
    }

    public int getId_pago() {
        return id_pago;
    }

    public Factura getFactura() {
        return factura;
    }

    public BigDecimal getMontoAbonado() {
        return montoAbonado;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void setMontoAbonado(BigDecimal montoAbonado) {
        this.montoAbonado = montoAbonado;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    
    
    
}
