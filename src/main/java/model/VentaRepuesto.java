package model;

public class VentaRepuesto {
    private int id_venta;
    private int id_repuesto;
    private int cantidad_repuestos;

    public VentaRepuesto() {
    }

    public VentaRepuesto(int id_venta, int id_repuesto, int cantidad_repuestos) {
        this.id_venta = id_venta;
        this.id_repuesto = id_repuesto;
        this.cantidad_repuestos = cantidad_repuestos;
    }

    public int getId_venta() {
        return id_venta;
    }

    public int getId_repuesto() {
        return id_repuesto;
    }

    public int getCantidad_repuestos() {
        return cantidad_repuestos;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public void setCantidad_repuestos(int cantidad_repuestos) {
        this.cantidad_repuestos = cantidad_repuestos;
    }
}
