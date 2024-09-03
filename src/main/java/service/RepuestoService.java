package service;

import dao.interfaces.RepuestoDAO;
import java.util.List;
import model.Repuesto;

public class RepuestoService {
    private final RepuestoDAO repuestoDAO;

    public RepuestoService(RepuestoDAO repuestoDAO) {
        this.repuestoDAO = repuestoDAO;
    }
    
    public void agregarRepuesto(Repuesto repuesto){
        repuestoDAO.crearRepuesto(repuesto);
    }
    
    public List<Repuesto> listarRepuestos() {
        return repuestoDAO.obtenerRepuestos();
    }
    
    public Repuesto obtenerRepuestoPorId(int id) {
        // Lógica adicional si es necesario
        return repuestoDAO.obtenerRepuesto(id);
    }
    
    public void editarRepuestoPorId(Repuesto repuesto){
        repuestoDAO.actualizarRepuesto(repuesto);
    }
    
    public void eliminarRepuestoPorId(int id){
        repuestoDAO.eliminarRepuesto(id);
    }
    
    // Método para imprimir las categorías (si esto es parte de la lógica de negocio)
    public void imprimirRepuestos() {
        List<Repuesto> listaRepuestos = listarRepuestos();
        
        for(Repuesto rep : listaRepuestos){
            System.out.println("------------------");
            System.out.println("Id: " + rep.getId_repuesto());
            System.out.println("Stock: " + rep.getStock());
            System.out.println("Nombre Repuesto: " + rep.getNombreRepuesto());
            System.out.println("Marca: " + rep.getMarca());
            System.out.println("Categoria: " + rep.getCategoria());
            System.out.println("Precio: " + rep.getPrecio());
            System.out.println("Ubicacion: " + rep.getUbicacion());
        }
    }
}
