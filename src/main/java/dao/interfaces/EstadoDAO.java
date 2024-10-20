package dao.interfaces;

import java.util.List;
import model.Estado;

public interface EstadoDAO {
    public void crearEstado(Estado estado);
    public List<Estado> obtenerEstados();
    public Estado obtenerEstado(int id);
    public void actualizarEstado(Estado estado);
    public void eliminarEstado(int id);
    public boolean existeEstado(String nombre);
    public Estado obtenerEstadosPorNombre(String estadoSeleccionado);
}
