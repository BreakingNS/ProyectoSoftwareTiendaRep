package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Precio {
    private int id_precio;
    private Repuesto repuesto;
    private LocalDateTime fechaPrecio;
    private BigDecimal valor;

    public Precio() {
    }

    public Precio(int id_precio, Repuesto repuesto, LocalDateTime fechaPrecio, BigDecimal valor) {
        this.id_precio = id_precio;
        this.repuesto = repuesto;
        this.fechaPrecio = fechaPrecio;
        this.valor = valor;
    }

    public int getId_precio() {
        return id_precio;
    }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public LocalDateTime getFechaPrecio() {
        return fechaPrecio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setId_precio(int id_precio) {
        this.id_precio = id_precio;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }

    public void setFechaPrecio(LocalDateTime fechaPrecio) {
        this.fechaPrecio = fechaPrecio;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
