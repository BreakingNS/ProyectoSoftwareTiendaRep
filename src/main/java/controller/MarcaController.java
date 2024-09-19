package controller;

import java.util.ArrayList;
import java.util.List;
import model.Marca;
import service.MarcaService;

public class MarcaController {
    
    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }
    
    public void agregarMarca(String nombre){
        Marca marca = new Marca(1, nombre, new ArrayList<>());
        marcaService.agregarMarca(marca);
    }
    
    public List<Marca> listarMarcasOrdenadasPorNombre(){
        List<Marca> listaMarcas= marcaService.listarMarcasOrdenadasPorNombre();
        return listaMarcas;
    }
    
    public List<Marca> listarMarcasOrdenadasPorId(){
        List<Marca> listaMarcas= marcaService.listarMarcasOrdenadasPorId();
        return listaMarcas;
    }
    
    public Marca obtenerMarcaPorId(int id){
        Marca marca = marcaService.obtenerMarcaPorId(id);
        return marca;
    }
    /*
    public List<Marca> busquedaDeMarca(String nombre, String apellido, String telefono){
        Marca marca = new Marca(0, nombre, apellido, telefono, new ArrayList<>(), new ArrayList<>());
        List<Marca> listaMarcas = marcaService.busquedaDeMarca(marca);
        
        return listaMarcas;
    }
    */
    public void editarMarca(int id, String nombre){
        Marca marca = new Marca(id, nombre, new ArrayList<>());
        marcaService.editarMarcaPorId(marca);
    }
    
    public void eliminarMarca(int id){
        marcaService.eliminarMarcaPorId(id);
    }

    public boolean existeMarca(String nombre) {   
        return marcaService.existeMarca(nombre);
    }

}
