package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Marca;
import model.NombreRepuesto;
import model.Precio;
import model.Repuesto;
import model.Ubicacion;
import service.RepuestoService;

public class RepuestoController {
    
    private final RepuestoService repuestoService;

    public RepuestoController(RepuestoService repuestoService) {
        this.repuestoService = repuestoService;
    }
    /*
    public void agregarRepuesto(String nombre, String apellido, String telefono){

    }
    */
    public List<Repuesto> listarRepuestos(){
        List<Repuesto> listaRepuestos = repuestoService.listarRepuestos();
        return listaRepuestos;
    }
    /*
    public Repuesto obtenerRepuestoPorId(int id){

    }
    */
    public List<Repuesto> busquedaDeRepuesto(String nombreRepuesto, String marca, String categoria, String ubicacion, String stock, String precio){
        List<Repuesto> listaRepuesto = new ArrayList<>();
        /*
        
        NombreRepuesto nombreRepuestoAux = new NombreRepuesto(1, nombreRepuesto);
        Marca marcaAux = new Marca(1, marca, new ArrayList<>());
        Categoria categoriaAux = new Categoria(1, categoria, new ArrayList<>(), new ArrayList<>());
        Ubicacion ubicacionAux = new Ubicacion(1, ubicacion, new ArrayList<>());
        int stockAux = Integer.parseInt(stock);
        
        List<Precio> listaPrecios = new ArrayList<>();
        Precio precioAux = new Precio(1, null, null, new BigDecimal(precio));
        listaPrecios.add(precioAux);
        
        Repuesto repuesto = new Repuesto(1, stockAux, nombreRepuestoAux, marcaAux, categoriaAux, listaPrecios, ubicacionAux);
        */
        listaRepuesto = repuestoService.busquedaDeRepuesto(nombreRepuesto, marca, categoria, ubicacion, stock, precio);
        
        return listaRepuesto;
    }
    /*
    public void editarRepuesto(int id, String nombre, String apellido, String telefono){

    }
    
    public void eliminarRepuesto(int id){
        repuestoService.eliminarRepuestoPorId(id);
    }
    */
}
