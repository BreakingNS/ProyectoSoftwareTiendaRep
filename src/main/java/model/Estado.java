package model;

import java.util.List;

public class Estado {
    private int id_estado;
    private String nombre_estado;
    private List<Reparacion> listaReparaciones;

    public Estado() {
    }

    public Estado(int id_estado, String nombre_estado, List<Reparacion> listaReparaciones) {
        this.id_estado = id_estado;
        this.nombre_estado = nombre_estado;
        this.listaReparaciones = listaReparaciones;
    }

    public int getId_estado() {
        return id_estado;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public List<Reparacion> getListaReparaciones() {
        return listaReparaciones;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }

    public void setListaReparaciones(List<Reparacion> listaReparaciones) {
        this.listaReparaciones = listaReparaciones;
    }

    @Override
    public String toString() {
        return this.nombre_estado;
    }
}
