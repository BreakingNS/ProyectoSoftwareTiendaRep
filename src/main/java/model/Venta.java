package model;

import java.sql.Date;

public class Venta {
    private int id_venta;
    private Integer cantidad;
    private Date fecha_venta;
    private int id_cliente;

    public Venta() {
    }

    public Venta(int id_venta, Integer cantidad, Date fecha_venta, int id_cliente) {
        this.id_venta = id_venta;
        this.cantidad = cantidad;
        this.fecha_venta = fecha_venta;
        this.id_cliente = id_cliente;
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

    public int getId_cliente() {
        return id_cliente;
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

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
}
