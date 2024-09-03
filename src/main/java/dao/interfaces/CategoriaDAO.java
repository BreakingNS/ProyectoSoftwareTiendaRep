package dao.interfaces;

import java.util.List;
import model.Categoria;

public interface CategoriaDAO {
    public void crearCategoria(Categoria categoria);
    public List<Categoria> obtenerCategorias();
    public Categoria obtenerCategoria(int id);
    public void actualizarCategoria(Categoria categoria);
    public void eliminarCategoria(int id);
}
