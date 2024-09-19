package dao.interfaces;

import java.util.List;
import model.Marca;

public interface MarcaDAO {
    public void crearMarca(Marca marca);
    public List<Marca> obtenerMarcasOrdenadasPorNombre();
    public List<Marca> obtenerMarcasOrdenadasPorId();
    public Marca obtenerMarca(int id);
    public void actualizarMarca(Marca marca);
    public void eliminarMarca(int id);
    public boolean existeMarca(String marca);
    public Marca obtenerMarcaPorNombre(String nombre);
}
