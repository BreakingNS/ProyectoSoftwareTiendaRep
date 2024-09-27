package model;

import java.util.List;

public class Tecnico {
    private int id_tecnico;
    private String nombre_tecnico;
    private String apellido_tecnico;
    private String telefono_tecnico;
    private String domicilio_tecnico;
    private List<Reparacion> listaReparaciones;

    public Tecnico() {
    }

    public Tecnico(int id_tecnico, String nombre_tecnico, String apellido_tecnico, String telefono_tecnico, String domicilio_tecnico, List<Reparacion> listaReparaciones) {
        this.id_tecnico = id_tecnico;
        this.nombre_tecnico = nombre_tecnico;
        this.apellido_tecnico = apellido_tecnico;
        this.telefono_tecnico = telefono_tecnico;
        this.domicilio_tecnico = domicilio_tecnico;
        this.listaReparaciones = listaReparaciones;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public String getNombre_tecnico() {
        return nombre_tecnico;
    }

    public String getApellido_tecnico() {
        return apellido_tecnico;
    }

    public String getTelefono_tecnico() {
        return telefono_tecnico;
    }

    public String getDomicilio_tecnico() {
        return domicilio_tecnico;
    }

    public List<Reparacion> getListaReparaciones() {
        return listaReparaciones;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public void setNombre_tecnico(String nombre_tecnico) {
        this.nombre_tecnico = nombre_tecnico;
    }

    public void setApellido_tecnico(String apellido_tecnico) {
        this.apellido_tecnico = apellido_tecnico;
    }

    public void setTelefono_tecnico(String telefono_tecnico) {
        this.telefono_tecnico = telefono_tecnico;
    }

    public void setDomicilio_tecnico(String domicilio_tecnico) {
        this.domicilio_tecnico = domicilio_tecnico;
    }

    public void setListaReparaciones(List<Reparacion> listaReparaciones) {
        this.listaReparaciones = listaReparaciones;
    }

    
}
