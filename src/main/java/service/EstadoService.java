package service;

import dao.interfaces.EstadoDAO;
import java.util.List;
import model.Estado;

public class EstadoService {
    private final EstadoDAO estadoDAO;

    public EstadoService(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }
    
    public void agregarEstado(Estado estado){
        estadoDAO.crearEstado(estado);
    }
    
    public List<Estado> listarEstados() {
        return estadoDAO.obtenerEstados();
    }
    
    public Estado obtenerEstadoPorId(int id) {
        // Lógica adicional si es necesario
        return estadoDAO.obtenerEstado(id);
    }
    
    public void editarEstadoPorId(Estado estado){
        estadoDAO.actualizarEstado(estado);
    }
    
    public void eliminarEstadoPorId(int id){
        estadoDAO.eliminarEstado(id);
    }
    
    // Método para imprimir las categorías (si esto es parte de la lógica de negocio)
    public void imprimirEstados() {
        List<Estado> listaEstados = listarEstados();
        
        for(Estado est : listaEstados){
            System.out.println("------------------");
            System.out.println("Id: " + est.getId_estado());
            System.out.println("Nombre Estado: " + est.getNombre_estado());
        }
    }
}
