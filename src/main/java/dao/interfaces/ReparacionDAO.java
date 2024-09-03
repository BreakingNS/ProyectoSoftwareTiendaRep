package dao.interfaces;

import java.util.List;
import model.Reparacion;

public interface ReparacionDAO {
    public void crearReparacion(Reparacion reparacion);
    public List<Reparacion> obtenerReparaciones();
    public Reparacion obtenerReparacion(int id);
    public void actualizarReparacion(Reparacion reparacion);
    public void eliminarReparacion(int id);
}
