package controller;

import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import service.CategoriaService;

public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
    public void agregarCategoria(String nombre){
        Categoria categoria = new Categoria(1, nombre, new ArrayList<>(), new ArrayList<>());
        categoriaService.agregarCategoria(categoria);
    }
    
    public List<Categoria> listarCategoriasOrdenadasPorId(){
        return categoriaService.listarCategoriasOrdenadasPorId();
    }
    
    public List<Categoria> listarCategoriasOrdenadasPorNombre(){
        List<Categoria> listaCategorias= categoriaService.listarCategoriasOrdenadasPorNombre();
        return listaCategorias;
    }
    
    public Categoria obtenerCategoriaPorId(int id){
        Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
        return categoria;
    }
    /*
    public List<Categoria> busquedaDeCategoria(String nombre, String apellido, String telefono){
        Categoria categoria = new Categoria(0, nombre, apellido, telefono, new ArrayList<>(), new ArrayList<>());
        List<Categoria> listaCategorias = categoriaService.busquedaDeCategoria(categoria);
        
        return listaCategorias;
    }
    */
    public void editarCategoria(int id, String nombre){
        Categoria categoria = new Categoria(id, nombre, new ArrayList<>(), new ArrayList<>());
        categoriaService.editarCategoriaPorId(categoria);
    }
    
    public void eliminarCategoria(int id){
        categoriaService.eliminarCategoriaPorId(id);
    }
    
    public boolean existeCategoria(String nombre) {   
        return categoriaService.existeCategoria(nombre);
    }
    
}
