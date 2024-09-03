package model;

import java.util.List;

public class Categoria {
    private int id_categoria;
    private String nombre_categoria;
    private List<Reparacion> listaReparaciones;

    public Categoria() {
    }

    public Categoria(int id_categoria, String nombre_categoria, List<Reparacion> listaReparaciones) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.listaReparaciones = listaReparaciones;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public List<Reparacion> getListaReparaciones() {
        return listaReparaciones;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public void setListaReparaciones(List<Reparacion> listaReparaciones) {
        this.listaReparaciones = listaReparaciones;
    }
}
