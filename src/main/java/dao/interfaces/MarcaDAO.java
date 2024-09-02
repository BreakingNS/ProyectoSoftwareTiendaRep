package dao.interfaces;

import java.util.List;
import model.Marca;

public interface MarcaDAO {
    public void crearMarca(Marca marca);
    public List<Marca> obtenerMarcas();
    public Marca obtenerMarca(int id);
    public void actualizarMarca(Marca marca, int id);
    public void eliminarMarca(int id);
    public void toStringMarcas();
}
