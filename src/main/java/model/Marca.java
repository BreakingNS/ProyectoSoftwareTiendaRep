package model;

import java.util.List;

public class Marca {
    private int id_marca;
    private String nombre_marca;
    private List<Repuesto> listaRepuestos;

    public Marca() {
    }

    public Marca(int id_marca, String nombre_marca, List<Repuesto> listaRepuestos) {
        this.id_marca = id_marca;
        this.nombre_marca = nombre_marca;
        this.listaRepuestos = listaRepuestos;
    }

    public int getId_marca() {
        return id_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public List<Repuesto> getListaRepuestos() {
        return listaRepuestos;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public void setListaRepuesto(List<Repuesto> listaRepuesto) {
        this.listaRepuestos = listaRepuesto;
    }
    
    @Override
    public String toString() {
        return this.nombre_marca;
    }
}
