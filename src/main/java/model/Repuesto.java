package model;

public class Repuesto {
    private int id_repuesto;
    private int stock;
    private int id_nombrerepuesto;
    private int id_marca;
    private int id_categoria;
    private int id_precio;
    private int id_ubicacion;

    public Repuesto() {
    }

    public Repuesto(int id_repuesto, int stock, int id_nombrerepuesto, int id_marca, int id_categoria, int id_precio, int id_ubicacion) {
        this.id_repuesto = id_repuesto;
        this.stock = stock;
        this.id_nombrerepuesto = id_nombrerepuesto;
        this.id_marca = id_marca;
        this.id_categoria = id_categoria;
        this.id_precio = id_precio;
        this.id_ubicacion = id_ubicacion;
    }

    public int getId_repuesto() {
        return id_repuesto;
    }

    public int getStock() {
        return stock;
    }

    public int getId_nombrerepuesto() {
        return id_nombrerepuesto;
    }

    public int getId_marca() {
        return id_marca;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public int getId_precio() {
        return id_precio;
    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setId_nombrerepuesto(int id_nombrerepuesto) {
        this.id_nombrerepuesto = id_nombrerepuesto;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setId_precio(int id_precio) {
        this.id_precio = id_precio;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }
}
