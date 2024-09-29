package controller;

import java.util.ArrayList;
import java.util.List;
import model.Modelo;
import service.ModeloService;

public class ModeloController {
    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }
    
    public void agregarModelo(String nombre){
        Modelo modelo = new Modelo(0, nombre);
        modeloService.agregarModelo(modelo);
    }
    
    public List<Modelo> listarModelosOrdenadasPorId(){
        return modeloService.listarModelos();
    }
    
    public Modelo obtenerModeloPorId(int id){
        Modelo modelo = modeloService.obtenerModeloPorId(id);
        return modelo;
    }
    /*
    public List<Modelo> busquedaDeModelo(String nombre, String apellido, String telefono){
        Modelo modelo = new Modelo(0, nombre, apellido, telefono, new ArrayList<>(), new ArrayList<>());
        List<Modelo> listaModelos = modeloService.busquedaDeModelo(modelo);
        
        return listaModelos;
    }
    */
    public void editarModelo(int id, String nombre){
        Modelo modelo = new Modelo(id, nombre);
        modeloService.editarModeloPorId(modelo);
    }
    
    public void eliminarModelo(int id){
        modeloService.eliminarModeloPorId(id);
    }
    
    public boolean existeModelo(String nombre) {   
        return modeloService.existeModelo(nombre);
    }
}
