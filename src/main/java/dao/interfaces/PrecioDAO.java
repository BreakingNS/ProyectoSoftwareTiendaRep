package dao.interfaces;

import java.util.List;
import model.Precio;

public interface PrecioDAO {
    public void crearPrecio(Precio precio);
    public List<Precio> obtenerPrecios();
    public Precio obtenerPrecio(int id);
    public void actualizarPrecio(Precio precio);
    public void eliminarPrecio(int id);
    public List<Precio> obtenerPreciosPorIdRepuesto(int id);
}
