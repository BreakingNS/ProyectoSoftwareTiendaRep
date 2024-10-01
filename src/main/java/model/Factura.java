package model;

import java.math.BigDecimal;

public class Factura {
    private int id_factura;
    private String estado;
    private BigDecimal montoTotal;

    public Factura() {
    }

    public Factura(int id_factura, String estado, BigDecimal montoTotal) {
        this.id_factura = id_factura;
        this.estado = estado;
        this.montoTotal = montoTotal;
    }

    public int getId_factura() {
        return id_factura;
    }

    public String getEstado() {
        return estado;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    
}
