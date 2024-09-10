package model;

public class ReparacionRepuesto {
    private int id_reparacion;
    private int id_repuesto;

    public ReparacionRepuesto() {
    }

    public ReparacionRepuesto(int id_reparacion, int id_repuesto) {
        this.id_reparacion = id_reparacion;
        this.id_repuesto = id_repuesto;
    }

    public int getId_reparacion() {
        return id_reparacion;
    }

    public int getId_repuesto() {
        return id_repuesto;
    }

    public void setId_reparacion(int id_reparacion) {
        this.id_reparacion = id_reparacion;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }
}
