package service;

import dao.interfaces.PrecioDAO;
import dao.interfaces.RepuestoDAO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    
    public List<Repuesto> busquedaDeRepuesto(Repuesto repuesto){
        List<Repuesto> listaRepuestos = repuestoDAO.buscarRepuesto(repuesto);
        return listaRepuestos;
    }
    
    public void editarRepuestoPorId(Repuesto repuesto){
        repuestoDAO.actualizarRepuesto(repuesto);
    }
    
    public void eliminarRepuestoPorId(int id){
        repuestoDAO.eliminarRepuesto(id);
    }
    
    public int obtenerUltimoIdRepuesto() {
        return repuestoDAO.obtenerUltimoIdRepuesto();
    }

    public List<Repuesto> obtenerRepuestosPorIdVenta(int id) {
        return repuestoDAO.obtenerRepuestosPorIdVenta(id);
    }

    public List<Repuesto> obtenerRepuestosPorIdReparacion(int idReparacion) {
        return repuestoDAO.obtenerRepuestosPorIdReparacion(idReparacion);
    }
    
    public void actualizarStock(Repuesto repuesto, int nuevoStock){
        int stock = repuesto.getStock();
        stock = stock + nuevoStock;
        repuesto.setStock(stock);
        repuestoDAO.actualizarRepuesto(repuesto);
    }
    
    public void actualizarPrecio(Repuesto repuesto, BigDecimal precio) {
        LocalDateTime ahora = LocalDateTime.now();
        Precio precioNuevo = new Precio(1, repuesto, ahora, precio);
        precioDAO.crearPrecio(precioNuevo);
    }

    public int obtenerIdPorCodigo(String codigo) {
        return repuestoDAO.obtenerIdPorCodigo(codigo);
    }

    public List<Repuesto> listarRepuestosOrdenadoPorStock() {
        List<Precio> listaPreciosAuxiliar = precioDAO.obtenerPrecios();
        List<Repuesto> listaRepuesto = repuestoDAO.listarRepuestosOrdenadoPorStock();
        for(Repuesto rep : listaRepuesto){
            for(Precio pre : listaPreciosAuxiliar){
                if((pre.getRepuesto().getId_repuesto()) == rep.getId_repuesto()){
                    rep.getListaPrecios().add(pre);
                }
            }
        }
        
        return listaRepuesto;
    }

}
