package dao.interfaces;

import java.util.List;
import model.Ubicacion;

public interface UbicacionDAO {
    public void crearUbicacion(Ubicacion ubicacion);
    public List<Ubicacion> obtenerUbicaciones();
    public Ubicacion obtenerUbicacion(int id);
    public void actualizarUbicacion(Ubicacion ubicacion);
    public void eliminarUbicacion(int id);
    public void toStringUbicacion();
}
