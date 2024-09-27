package model;

import java.util.List;
import java.util.Objects;

public class Repuesto {
    private int id_repuesto;
    private int stock;
    private NombreRepuesto nombreRepuesto;
    private Marca marca;
    private Categoria categoria;
    private Modelo modelo;
    private List<Precio> listaPrecios;
    private Ubicacion ubicacion;
    private String codigo;

    public Repuesto() {
    }

    public Repuesto(int id_repuesto, int stock, NombreRepuesto nombreRepuesto, Marca marca, Categoria categoria, Modelo modelo, List<Precio> listaPrecios, Ubicacion ubicacion, String codigo) {
        this.id_repuesto = id_repuesto;
        this.stock = stock;
        this.nombreRepuesto = nombreRepuesto;
        this.marca = marca;
        this.categoria = categoria;
        this.modelo = modelo;
        this.listaPrecios = listaPrecios;
        this.ubicacion = ubicacion;
        this.codigo = codigo;
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

    public Modelo getModelo() {
        return modelo;
    }

    public List<Precio> getListaPrecios() {
        return listaPrecios;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public String getCodigo() {
        return codigo;
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

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public void setListaPrecios(List<Precio> listaPrecios) {
        this.listaPrecios = listaPrecios;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
