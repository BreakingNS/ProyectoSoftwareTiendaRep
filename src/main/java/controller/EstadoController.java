package controller;

import java.util.ArrayList;
import java.util.List;
import model.Estado;
import service.EstadoService;

public class EstadoController {
    
    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }
    
    public void agregarEstado(String nombre){
        Estado estado = new Estado(1, nombre, new ArrayList<>());
        estadoService.agregarEstado(estado);
    }
    
    public List<Estado> listarEstados(){
        List<Estado> listaEstados= estadoService.listarEstados();
        return listaEstados;
    }
    
    public Estado obtenerEstadoPorId(int id){
        Estado estado = estadoService.obtenerEstadoPorId(id);
        return estado;
    }
    /*
    public List<Estado> busquedaDeEstado(String nombre, String apellido, String telefono){
        Estado estado = new Estado(0, nombre, apellido, telefono, new ArrayList<>(), new ArrayList<>());
        List<Estado> listaEstados = estadoService.busquedaDeEstado(estado);
        
        return listaEstados;
    }
    */
    public void editarEstado(int id, String nombre){
        Estado estado = new Estado(id, nombre, new ArrayList<>());
        estadoService.editarEstadoPorId(estado);
    }
    
    public void eliminarEstado(int id){
        estadoService.eliminarEstadoPorId(id);
    }
    
    public boolean existeEstado(String nombre) {   
        return estadoService.existeEstado(nombre);
    }
}
