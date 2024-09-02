package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Reparacion {
    private int id_reparacion;
    private BigDecimal costo;
    private String detalles;
    private Date fecha_ingreso;
    private Date fecha_devolucion;
    private int id_categoria;
    private int id_cliente;
    private int id_repuesto;
    private int id_estado;

    public Reparacion() {
    }

    public Reparacion(int id_reparacion, BigDecimal costo, String detalles, Date fecha_ingreso, Date fecha_devolucion, int id_categoria, int id_cliente, int id_repuesto, int id_estado) {
        this.id_reparacion = id_reparacion;
        this.costo = costo;
        this.detalles = detalles;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_devolucion = fecha_devolucion;
        this.id_categoria = id_categoria;
        this.id_cliente = id_cliente;
        this.id_repuesto = id_repuesto;
        this.id_estado = id_estado;
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

    public int getId_categoria() {
        return id_categoria;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_repuesto() {
        return id_repuesto;
    }

    public int getId_estado() {
        return id_estado;
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

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
    
    
}
