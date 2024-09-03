package dao.interfaces;

import java.util.List;
import model.Reparacion;

public interface ReparacionDAO {
    public void crearReparacion(Reparacion reparacion);
    public List<Reparacion> obtenerReparaciones();
    public List<Reparacion> obtenerReparacionesPorIdCliente(int id);
    public List<Reparacion> obtenerReparacionesPorIdCategoria(int id);
    public Reparacion obtenerReparacion(int id);
    public void actualizarReparacion(Reparacion reparacion);
    public void eliminarReparacion(int id);
}
