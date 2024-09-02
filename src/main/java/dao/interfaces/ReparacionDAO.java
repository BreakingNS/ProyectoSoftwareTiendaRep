package dao.interfaces;

import java.util.List;
import model.Reparacion;

public interface ReparacionDAO {
    public void crearReparacion(Reparacion reparacion);
    public List<Reparacion> obtenerReparacion();
    public void actualizarReparacion(Reparacion reparacion, int id);
    public void eliminarReparacion(int id);
    public void toStringReparacion();
}
