package service;

import dao.interfaces.CategoriaDAO;
import java.util.List;
import model.Categoria;

public class CategoriaService {
    
    private final CategoriaDAO categoriaDAO;

    public CategoriaService(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }
    
    public void agregarCategoria(Categoria categoria){
        categoriaDAO.crearCategoria(categoria);
    }
    
    public List<Categoria> listarCategorias() {
        return categoriaDAO.obtenerCategorias();
    }
    
    public Categoria obtenerCategoriaPorId(int id) {
        // Lógica adicional si es necesario
        return categoriaDAO.obtenerCategoria(id);
    }
    
    public void editarCategoriaPorId(Categoria categoria){
        categoriaDAO.actualizarCategoria(categoria);
    }
    
    public void eliminarCategoriaPorId(int id){
        categoriaDAO.eliminarCategoria(id);
    }
    
    // Método para imprimir las categorías (si esto es parte de la lógica de negocio)
    public void imprimirCategorias() {
        List<Categoria> listaCategorias = listarCategorias(); // Usando el método para obtener categorías
        
        for(Categoria cate : listaCategorias){
            System.out.println("------------------");
            System.out.println("Id: " + cate.getId_categoria());
            System.out.println("Nombre: " + cate.getNombre_categoria());
        }
    }
}

