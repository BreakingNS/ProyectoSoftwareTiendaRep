package model;

public class VentaRepuesto {
    private int id_venta;
    private int id_repuesto;

    public VentaRepuesto() {
    }

    public VentaRepuesto(int id_venta, int id_repuesto) {
        this.id_venta = id_venta;
        this.id_repuesto = id_repuesto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public int getId_repuesto() {
        return id_repuesto;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }
}
