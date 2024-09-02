package dao.interfaces;

import java.util.List;
import model.Estado;

public interface EstadoDAO {
    public void crearEstado(Estado estado);
    public List<Estado> obtenerEstado();
    public void actualizarEstado(Estado estado, int id);
    public void eliminarEstado(int id);
    public void toStringEstado();
}
