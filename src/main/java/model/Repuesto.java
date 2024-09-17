package model;

import java.util.List;
import java.util.Objects;

public class Repuesto {
    private int id_repuesto;
    private int stock;
    private NombreRepuesto nombreRepuesto;
    private Marca marca;
    private Categoria categoria;
    private List<Precio> listaPrecios;
    private Ubicacion ubicacion;

    public Repuesto() {
    }

    public Repuesto(int id_repuesto, int stock, NombreRepuesto nombreRepuesto, Marca marca, Categoria categoria, List<Precio> listaPrecios, Ubicacion ubicacion) {
        this.id_repuesto = id_repuesto;
        this.stock = stock;
        this.nombreRepuesto = nombreRepuesto;
        this.marca = marca;
        this.categoria = categoria;
        this.listaPrecios = listaPrecios;
        this.ubicacion = ubicacion;
    }

    public int getId_repuesto() {
        return id_repuesto;
    }

    public int getStock() {
        return stock;
    }

    public NombreRepuesto getNombreRepuesto() {
        return nombreRepuesto;
    }

    public Marca getMarca() {
        return marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public List<Precio> getListaPrecios() {
        return listaPrecios;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setNombreRepuesto(NombreRepuesto nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setListaPrecios(List<Precio> precio) {
        this.listaPrecios = precio;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Repuesto repuesto = (Repuesto) obj;
        return id_repuesto == repuesto.id_repuesto; // Compara los ID de los repuestos
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_repuesto); // Usa el ID del repuesto para generar el hash
    }

}
