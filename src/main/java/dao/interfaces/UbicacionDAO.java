package dao.interfaces;

import java.util.List;
import model.Ubicacion;

public interface UbicacionDAO {
    public void crearUbicacion(Ubicacion ubicacion);
    public List<Ubicacion> obtenerUbicaciones();
    public List<Ubicacion> obtenerUbicacionesPorNombre();
    public Ubicacion obtenerUbicacion(int id);
    public void actualizarUbicacion(Ubicacion ubicacion);
    public void eliminarUbicacion(int id);
    public boolean existeUbicacion(String nombre);
    public Ubicacion obtenerUbicacionPorNombre(String nombre);

    
}
