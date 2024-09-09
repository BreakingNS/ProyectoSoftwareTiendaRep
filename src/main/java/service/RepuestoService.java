package service;

import dao.interfaces.PrecioDAO;
import dao.interfaces.RepuestoDAO;
import java.util.List;
import model.Precio;
import model.Repuesto;

public class RepuestoService {
    private final RepuestoDAO repuestoDAO;
    private final PrecioDAO precioDAO;

    public RepuestoService(RepuestoDAO repuestoDAO, PrecioDAO precioDAO) {
        this.repuestoDAO = repuestoDAO;
        this.precioDAO = precioDAO;
    }
    
    public void agregarRepuesto(Repuesto repuesto){
        repuestoDAO.crearRepuesto(repuesto);
    }
    
    public List<Repuesto> listarRepuestos() {
        List<Precio> listaPreciosAuxiliar = precioDAO.obtenerPrecios();
        List<Repuesto> listaRepuesto = repuestoDAO.obtenerRepuestos();
        for(Repuesto rep : listaRepuesto){
            for(Precio pre : listaPreciosAuxiliar){
                if((pre.getRepuesto().getId_repuesto()) == rep.getId_repuesto()){
                    rep.getListaPrecios().add(pre);
                }
            }
        }
        
        return listaRepuesto;
    }
    
    public Repuesto obtenerRepuestoPorId(int id) {
        List<Precio> listaPreciosAuxiliar = precioDAO.obtenerPrecios();
        Repuesto repuesto = repuestoDAO.obtenerRepuesto(id);
        for(Precio pre : listaPreciosAuxiliar){
            if((pre.getRepuesto().getId_repuesto()) == repuesto.getId_repuesto()){
                repuesto.getListaPrecios().add(pre);
            }
        }
        
        return repuesto;
    }
    
    public void editarRepuestoPorId(Repuesto repuesto){
        repuestoDAO.actualizarRepuesto(repuesto);
    }
    
    public void eliminarRepuestoPorId(int id){
        repuestoDAO.eliminarRepuesto(id);
    }
    
    public void actualizarStock(Repuesto repuesto, int nuevoStock){
        int stock = repuesto.getStock();
        stock = stock + nuevoStock;
        repuesto.setStock(stock);
        repuestoDAO.actualizarRepuesto(repuesto);
    }
    
}
