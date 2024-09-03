package model;

import java.util.List;

public class Cliente {
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private List<Venta> listaVentas;
    private List<Reparacion> listaReparaciones;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String apellido, String telefono, List<Venta> listaVentas, List<Reparacion> listaReparaciones) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.listaVentas = listaVentas;
        this.listaReparaciones = listaReparaciones;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public List<Reparacion> getListaReparaciones() {
        return listaReparaciones;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public void setListaReparaciones(List<Reparacion> listaReparaciones) {
        this.listaReparaciones = listaReparaciones;
    }
}
