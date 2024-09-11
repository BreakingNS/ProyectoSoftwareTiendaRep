package model;

public class ReparacionRepuesto {
    private int id_reparacion;
    private int id_repuesto;
    private int cantidad_repuestos;

    public ReparacionRepuesto() {
    }

    public ReparacionRepuesto(int id_reparacion, int id_repuesto, int cantidad_repuestos) {
        this.id_reparacion = id_reparacion;
        this.id_repuesto = id_repuesto;
        this.cantidad_repuestos = cantidad_repuestos;
    }

    public int getId_reparacion() {
        return id_reparacion;
    }

    public int getId_repuesto() {
        return id_repuesto;
    }

    public int getCantidad_repuestos() {
        return cantidad_repuestos;
    }

    public void setId_reparacion(int id_reparacion) {
        this.id_reparacion = id_reparacion;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public void setCantidad_repuestos(int cantidad_repuestos) {
        this.cantidad_repuestos = cantidad_repuestos;
    }
}
