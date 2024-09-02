package model;

public class NombreRepuesto {
    private int id_nombrerepuesto;
    private String nombre_repuesto;

    public NombreRepuesto() {
    }

    public NombreRepuesto(int id_nombrerepuesto, String nombre_repuesto) {
        this.id_nombrerepuesto = id_nombrerepuesto;
        this.nombre_repuesto = nombre_repuesto;
    }

    public int getId_nombrerepuesto() {
        return id_nombrerepuesto;
    }

    public String getNombre_repuesto() {
        return nombre_repuesto;
    }

    public void setId_nombrerepuesto(int id_nombrerepuesto) {
        this.id_nombrerepuesto = id_nombrerepuesto;
    }

    public void setNombre_repuesto(String nombre_repuesto) {
        this.nombre_repuesto = nombre_repuesto;
    }
}
