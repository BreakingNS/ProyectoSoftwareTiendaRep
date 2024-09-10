package service;

import dao.interfaces.RepuestoDAO;
import dao.interfaces.UbicacionDAO;
import java.util.List;
import model.Repuesto;
import model.Ubicacion;

public class UbicacionService {
    private final UbicacionDAO ubicacionDAO;
    private final RepuestoDAO repuestoDAO;

    public UbicacionService(UbicacionDAO ubicacionDAO, RepuestoDAO repuestoDAO) {
        this.ubicacionDAO = ubicacionDAO;
        this.repuestoDAO = repuestoDAO;
    }
    
    public void agregarUbicacion(Ubicacion ubicacion){
        ubicacionDAO.crearUbicacion(ubicacion);
    }
    
    public List<Ubicacion> listarUbicaciones() {
        List<Repuesto> listaRepuestosAuxiliar = repuestoDAO.obtenerRepuestos();
        List<Ubicacion> listaUbicaciones = ubicacionDAO.obtenerUbicaciones();
        for(Ubicacion ubi : listaUbicaciones){
            for(Repuesto rep : listaRepuestosAuxiliar){
                if(rep.getUbicacion().getId_ubicacion() == (ubi.getId_ubicacion())){
                    ubi.getListaRepuestos().add(rep);
                }
            }
        }
        
        return listaUbicaciones;
    }
    
    public Ubicacion obtenerUbicacionPorId(int id) {
        List<Repuesto> listaRepuestosAuxiliar = repuestoDAO.obtenerRepuestos();
        Ubicacion ubicacion = ubicacionDAO.obtenerUbicacion(id);
        for(Repuesto rep : listaRepuestosAuxiliar){
            if(rep.getUbicacion().getId_ubicacion() == (ubicacion.getId_ubicacion())){
                ubicacion.getListaRepuestos().add(rep);
            }
        }

        return ubicacion;
    }
    
    public void editarUbicacionPorId(Ubicacion ubicacion){
        ubicacionDAO.actualizarUbicacion(ubicacion);
    }
    
    public void eliminarUbicacionPorId(int id){
        ubicacionDAO.eliminarUbicacion(id);
    }
}
