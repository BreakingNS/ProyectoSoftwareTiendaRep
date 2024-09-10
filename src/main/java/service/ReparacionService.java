package service;

import dao.interfaces.ReparacionDAO;
import java.util.List;
import model.Reparacion;

public class ReparacionService {
    private final ReparacionDAO reparacionDAO;

    public ReparacionService(ReparacionDAO reparacionDAO) {
        this.reparacionDAO = reparacionDAO;
    }
    
    public void agregarReparacion(Reparacion reparacion){
        reparacionDAO.crearReparacion(reparacion);
    }
    
    public List<Reparacion> listarReparaciones() {
        return reparacionDAO.obtenerReparaciones();
    }
    
    public Reparacion obtenerReparacionPorId(int id) {
        return reparacionDAO.obtenerReparacion(id);
    }
    
    public void editarReparacion(Reparacion reparacion){
        reparacionDAO.actualizarReparacion(reparacion);
    }
    
    public void eliminarReparacionPorId(int id){
        reparacionDAO.eliminarReparacion(id);
    }
    
}
