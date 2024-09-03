package service;

import dao.interfaces.UbicacionDAO;
import java.util.List;
import model.Ubicacion;

public class UbicacionService {
    private final UbicacionDAO ubicacionDAO;

    public UbicacionService(UbicacionDAO ubicacionDAO) {
        this.ubicacionDAO = ubicacionDAO;
    }
    
    public void agregarUbicacion(Ubicacion ubicacion){
        ubicacionDAO.crearUbicacion(ubicacion);
    }
    
    public List<Ubicacion> listarUbicaciones() {
        return ubicacionDAO.obtenerUbicaciones();
    }
    
    public Ubicacion obtenerUbicacionPorId(int id) {
        // Lógica adicional si es necesario
        return ubicacionDAO.obtenerUbicacion(id);
    }
    
    public void editarUbicacionPorId(Ubicacion ubicacion){
        ubicacionDAO.actualizarUbicacion(ubicacion);
    }
    
    public void eliminarUbicacionPorId(int id){
        ubicacionDAO.eliminarUbicacion(id);
    }
    
    // Método para imprimir las categorías (si esto es parte de la lógica de negocio)
    public void imprimirUbicacions() {
        List<Ubicacion> listaUbicaciones = listarUbicaciones();
        
        for(Ubicacion ubi : listaUbicaciones){
            System.out.println("------------------");
            System.out.println("Id: " + ubi.getId_ubicacion());
            System.out.println("Nombre: " + ubi.getNombre_ubicacion());
        }
    }
}
