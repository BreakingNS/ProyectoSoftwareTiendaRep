package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reparacion {
    private int id_reparacion;
    private BigDecimal costo;
    private String detalles;
    private LocalDateTime fecha_ingreso;
    private LocalDateTime fecha_devolucion;
    private Pagado pagado;
    private Categoria categoria;
    private Cliente cliente;
    private Estado estado;
    private Tecnico tecnico;

    public Reparacion() {
    }

    public Reparacion(int id_reparacion, BigDecimal costo, String detalles, LocalDateTime fecha_ingreso, LocalDateTime fecha_devolucion, Pagado pagado, Categoria categoria, Cliente cliente, Estado estado, Tecnico tecnico) {
        this.id_reparacion = id_reparacion;
        this.costo = costo;
        this.detalles = detalles;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_devolucion = fecha_devolucion;
        this.pagado = pagado;
        this.categoria = categoria;
        this.cliente = cliente;
        this.estado = estado;
        this.tecnico = tecnico;
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

    public LocalDateTime getFecha_ingreso() {
        return fecha_ingreso;
    }

    public LocalDateTime getFecha_devolucion() {
        return fecha_devolucion;
    }

    public Pagado getPagado() {
        return pagado;
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

    public Tecnico getTecnico() {
        return tecnico;
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

    public void setFecha_ingreso(LocalDateTime fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setFecha_devolucion(LocalDateTime fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public void setPagado(Pagado pagado) {
        this.pagado = pagado;
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

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
}
