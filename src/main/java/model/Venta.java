package model;

import java.math.BigDecimal;
import java.util.Date;

public class Venta {
    private int id_venta;
    private Integer cantidad;
    private Date fecha_venta;
    private Cliente cliente;
    private BigDecimal precioFinal;

    public Venta() {
    }
    
    public Venta(int id_venta, Integer cantidad, Date fecha_venta, Cliente cliente, BigDecimal precioFinal) {
        this.id_venta = id_venta;
        this.cantidad = cantidad;
        this.fecha_venta = fecha_venta;
        this.cliente = cliente;
        this.precioFinal = precioFinal;
    }

    public int getId_venta() {
        return id_venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getPrecioFinal() {
        return precioFinal;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPrecioFinal(BigDecimal precioFinal) {
        this.precioFinal = precioFinal;
    }
}
