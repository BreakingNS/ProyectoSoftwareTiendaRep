package model;

import java.math.BigDecimal;
import java.util.Date;

public class Reparacion {
    private int id_reparacion;
    private BigDecimal costo;
    private String detalles;
    private Date fecha_ingreso;
    private Date fecha_devolucion;
    private Categoria categoria;
    private Cliente cliente;
    private Estado estado;

    public Reparacion() {
    }

    public Reparacion(int id_reparacion, BigDecimal costo, String detalles, Date fecha_ingreso, Date fecha_devolucion, Categoria categoria, Cliente cliente, Estado estado) {
        this.id_reparacion = id_reparacion;
        this.costo = costo;
        this.detalles = detalles;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_devolucion = fecha_devolucion;
        this.categoria = categoria;
        this.cliente = cliente;
        this.estado = estado;
    }

    public int getId_reparacion() {
        return id_reparacion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public String getDetalles() {
        return detalles;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setId_reparacion(int id_reparacion) {
        this.id_reparacion = id_reparacion;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
}
