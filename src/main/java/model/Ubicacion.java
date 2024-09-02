package model;

public class Ubicacion {
    private int id_ubicacion;
    private String nombre_ubicacion;

    public Ubicacion() {
    }
    
    public Ubicacion(int id_ubicacion, String nombre_ubicacion) {
        this.id_ubicacion = id_ubicacion;
        this.nombre_ubicacion = nombre_ubicacion;
    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public String getNombre_ubicacion() {
        return nombre_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public void setNombre_ubicacion(String nombre_ubicacion) {
        this.nombre_ubicacion = nombre_ubicacion;
    }
}
