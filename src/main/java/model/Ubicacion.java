package model;

import java.util.List;

public class Ubicacion {
    private int id_ubicacion;
    private String nombre_ubicacion;
    private List<Repuesto> listaRepuestos;

    public Ubicacion() {
    }

    public Ubicacion(int id_ubicacion, String nombre_ubicacion, List<Repuesto> listaRepuestos) {
        this.id_ubicacion = id_ubicacion;
        this.nombre_ubicacion = nombre_ubicacion;
        this.listaRepuestos = listaRepuestos;
    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public String getNombre_ubicacion() {
        return nombre_ubicacion;
    }

    public List<Repuesto> getListaRepuestos() {
        return listaRepuestos;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public void setNombre_ubicacion(String nombre_ubicacion) {
        this.nombre_ubicacion = nombre_ubicacion;
    }

    public void setListaRepuestos(List<Repuesto> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }
}
