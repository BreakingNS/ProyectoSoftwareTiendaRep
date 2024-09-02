package dao.interfaces;

import java.util.List;
import model.Ubicacion;

public interface UbicacionDAO {
    public void crearUbicacion(Ubicacion ubicacion);
    public List<Ubicacion> obtenerUbicacion();
    public void actualizarUbicacion(Ubicacion ubicacion, int id);
    public void eliminarUbicacion(int id);
    public void toStringUbicacion();
}
