package controller;

import java.util.ArrayList;
import java.util.List;
import model.Ubicacion;
import service.UbicacionService;

public class UbicacionController {
    private final UbicacionService ubicacionService;

    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }
    
    public void agregarUbicacion(String nombre){
        Ubicacion ubicacion = new Ubicacion(1, nombre, new ArrayList<>());
        ubicacionService.agregarUbicacion(ubicacion);
    }
    
    public List<Ubicacion> listarUbicaciones(){
        List<Ubicacion> listaUbicaciones= ubicacionService.listarUbicaciones();
        return listaUbicaciones;
    }
    
    public Ubicacion obtenerUbicacionPorId(int id){
        Ubicacion ubicacion = ubicacionService.obtenerUbicacionPorId(id);
        return ubicacion;
    }
    /*
    public List<Ubicacion> busquedaDeUbicacion(String nombre, String apellido, String telefono){
        Ubicacion ubicacion = new Ubicacion(0, nombre, apellido, telefono, new ArrayList<>(), new ArrayList<>());
        List<Ubicacion> listaUbicaciones = ubicacionService.busquedaDeUbicacion(ubicacion);
        
        return listaUbicaciones;
    }
    */
    public void editarUbicacion(int id, String nombre){
        Ubicacion ubicacion = new Ubicacion(id, nombre, new ArrayList<>());
        ubicacionService.editarUbicacionPorId(ubicacion);
    }
    
    public void eliminarUbicacion(int id){
        ubicacionService.eliminarUbicacionPorId(id);
    }
    
    public boolean existeUbicacion(String nombre) {   
        return ubicacionService.existeUbicacion(nombre);
    }

    public List<Ubicacion> listarUbicacionesPorNombre() {
        return ubicacionService.obtenerUbicacionesPorNombre();
    }
    
}
