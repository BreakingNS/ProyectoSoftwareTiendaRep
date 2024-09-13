package service;

import dao.interfaces.EstadoDAO;
import dao.interfaces.ReparacionDAO;
import java.util.List;
import model.Estado;
import model.Reparacion;

public class EstadoService {
    private final EstadoDAO estadoDAO;
    private final ReparacionDAO reparacionDAO;

    public EstadoService(EstadoDAO estadoDAO, ReparacionDAO reparacionDAO) {
        this.estadoDAO = estadoDAO;
        this.reparacionDAO = reparacionDAO;
    }
    
    public void agregarEstado(Estado estado){
        estadoDAO.crearEstado(estado);
    }
    
    public List<Estado> listarEstados() {
        List<Reparacion> listaReparacionesAuxiliar = reparacionDAO.obtenerReparaciones();
        List<Estado> listaEstados = estadoDAO.obtenerEstados();
        for(Estado est : listaEstados){
            for(Reparacion rep : listaReparacionesAuxiliar){
                if(rep.getEstado().getId_estado() == (est.getId_estado())){
                    est.getListaReparaciones().add(rep);
                }
            }
        }
        
        return listaEstados;
    }
    
    public Estado obtenerEstadoPorId(int id) {
        List<Reparacion> listaReparacionesAuxiliar = reparacionDAO.obtenerReparaciones();
        Estado estado = estadoDAO.obtenerEstado(id);
        for(Reparacion rep : listaReparacionesAuxiliar){
            if(rep.getEstado().getId_estado() == (estado.getId_estado())){
                estado.getListaReparaciones().add(rep);
            }
        }

        return estado;
    }
    
    public void editarEstadoPorId(Estado estado){
        estadoDAO.actualizarEstado(estado);
    }
    
    public void eliminarEstadoPorId(int id){
        estadoDAO.eliminarEstado(id);
    }
    
    public boolean existeEstado(String nombre) {   
        return estadoDAO.existeEstado(nombre);
    }
}
