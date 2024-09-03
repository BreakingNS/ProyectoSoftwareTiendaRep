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
        // Lógica adicional si es necesario
        return reparacionDAO.obtenerReparacion(id);
    }
    
    public void editarReparacion(Reparacion reparacion){
        reparacionDAO.actualizarReparacion(reparacion);
    }
    
    public void eliminarReparacionPorId(int id){
        reparacionDAO.eliminarReparacion(id);
    }
    
    // Método para imprimir las categorías (si esto es parte de la lógica de negocio)
    public void imprimirReparacions() {
        List<Reparacion> listaReparaciones = listarReparaciones();
        
        for(Reparacion repa : listaReparaciones){
            System.out.println("------------------");
            System.out.println("Id: " + repa.getId_reparacion());
            System.out.println("Costo: " + repa.getCosto());
            System.out.println("Detalles: " + repa.getDetalles());
            System.out.println("Fecha Ingreso: " + repa.getFecha_ingreso());
            System.out.println("Fecha Devolucion: " + repa.getFecha_devolucion());
            System.out.println("Categoria: " + repa.getCategoria());
            System.out.println("Cliente: " + repa.getCliente());
            System.out.println("Repuesto: " + repa.getRepuesto());
            System.out.println("Estado: " + repa.getEstado());
        }
    }
    
    //Reportes Reparacion
}
