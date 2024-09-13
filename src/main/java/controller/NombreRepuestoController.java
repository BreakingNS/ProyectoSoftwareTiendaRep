package controller;

import java.util.ArrayList;
import java.util.List;
import model.NombreRepuesto;
import service.NombreRepuestoService;

public class NombreRepuestoController {
    private final NombreRepuestoService nombreRepuestoService;

    public NombreRepuestoController(NombreRepuestoService nombreRepuestoService) {
        this.nombreRepuestoService = nombreRepuestoService;
    }
    
    public void agregarNombreRepuesto(String nombre){
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, nombre);
        nombreRepuestoService.agregarNombreRepuesto(nombreRepuesto);
    }
    
    public List<NombreRepuesto> listarNombreRepuestos(){
        List<NombreRepuesto> listaNombreRepuestos= nombreRepuestoService.listarNombreRepuestos();
        return listaNombreRepuestos;
    }
    
    public NombreRepuesto obtenerNombreRepuestoPorId(int id){
        NombreRepuesto nombreRepuesto = nombreRepuestoService.obtenerNombreRepuestoPorId(id);
        return nombreRepuesto;
    }
    /*
    public List<NombreRepuesto> busquedaDeNombreRepuesto(String nombre, String apellido, String telefono){
        NombreRepuesto nombreRepuesto = new NombreRepuesto(0, nombre, apellido, telefono, new ArrayList<>(), new ArrayList<>());
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoService.busquedaDeNombreRepuesto(nombreRepuesto);
        
        return listaNombreRepuestos;
    }
    */
    public void editarNombreRepuesto(int id, String nombre){
        NombreRepuesto nombreRepuesto = new NombreRepuesto(id, nombre);
        nombreRepuestoService.editarNombreRepuestoPorId(nombreRepuesto);
    }
    
    public void eliminarNombreRepuesto(int id){
        nombreRepuestoService.eliminarNombreRepuestoPorId(id);
    }
    
    public boolean existeNombreRepuesto(String nombre) {   
        return nombreRepuestoService.existeNombreRepuesto(nombre);
    }
    
}
