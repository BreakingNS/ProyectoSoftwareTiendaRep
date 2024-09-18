package controller;

import java.sql.SQLException;
import java.util.List;
import model.Estado;
import model.Repuesto;
import model.Reparacion;
import service.CategoriaService;
import service.ClienteService;
import service.EstadoService;
import service.ReparacionService;
import service.ReparacionService;

public class ReparacionController {
    
    private final ReparacionService reparacionService;
    private final CategoriaService categoriaService;
    private final ClienteService clienteService;
    private final EstadoService estadoService;
    private final RepuestoController repuestoController;
    
    
    public ReparacionController(ReparacionService reparacionService,
            CategoriaService categoriaService, 
            ClienteService clienteService, 
            EstadoService estadoService, 
            RepuestoController repuestoController){
        this.reparacionService= reparacionService;
        this.categoriaService = categoriaService;
        this.clienteService = clienteService;
        this.estadoService = estadoService;
        this.repuestoController = repuestoController;
    }
    
    public void agregarReparacion(Reparacion reparacion, List<Repuesto> listaRepuestos) throws SQLException{
        reparacionService.agregarReparacion(reparacion, listaRepuestos);
    }
    
    public List<Reparacion> listarReparaciones(){
        List<Reparacion> listaReparacions= reparacionService.listarReparaciones();
        return listaReparacions;
    }
    /*
    public void obtenerRepuestosPorIdReparacion(int id) {
        repuestoController.obtenerRepuestosPorIdReparacion(id);
    }
    
    public Reparacion obtenerReparacionPorId(int id) {
        return reparacionService.obtenerReparacionPorId(id);
    }
    */
    /*
    public List<Reparacion> busquedaDeReparacion(String nombre, String apellido, String telefono){
        Reparacion reparacion = new Reparacion(0, nombre, apellido, telefono, new ArrayList<>(), new ArrayList<>());
        List<Reparacion> listaReparacions = reparacionService.busquedaDeReparacion(reparacion);
        
        return listaReparacions;
    }
    */
    /*
    public void editarReparacion(int idReparacion, String nombreMarca, String nombreCategoria, String nombreNombreReparacion, String nombreUbicacion, int stock, int precio){
        Marca marcaEdit = marcaService.obtenerMarcaPorNombre(nombreMarca);
        Categoria categoriaEdit = categoriaService.obtenerCategoriaPorNombre(nombreCategoria);
        NombreReparacion nombreReparacionEdit = nombreReparacionService.obtenerNombreReparacionPorNombre(nombreNombreReparacion);
        Ubicacion ubicacionEdit = ubicacionService.obtenerUbicacionPorNombre(nombreUbicacion);
        
        Reparacion reparacion = new Reparacion(idReparacion, stock, nombreReparacionEdit, marcaEdit, categoriaEdit, new ArrayList<>(), ubicacionEdit);
        reparacionService.editarReparacionPorId(reparacion);
        
        BigDecimal precioBig = new BigDecimal(precio);
        List<Precio> listaPreciosDeReparacion = precioService.obtenerPrecioPorIdReparacion(reparacion.getId_reparacion());
        if(listaPreciosDeReparacion.get(listaPreciosDeReparacion.size() - 1).getValor() != precioBig){
            Precio precioNuevo = new Precio(1, reparacion, new Date(), precioBig);
            precioService.agregarPrecio(precioNuevo);
        }
    }
    
    
    public void eliminarReparacion(int id){
        precioService.eliminarPreciosPorIdReparacion(id);
        reparacionService.eliminarReparacionPorId(id);
    }
    
    
    public List<NombreReparacion> retornarListaNombreReparacions(){
        return nombreReparacionService.listarNombreReparacions();
    }
    
    public List<Marca> retornarListaMarcas(){
        return marcaService.listarMarcas();
    }
    
    public List<Categoria> retornarCategorias(){
        return categoriaService.listarCategorias();
    }
    
    public List<Ubicacion> retornarUbicaciones(){
        return ubicacionService.listarUbicaciones();
    } 

    public List<Reparacion> busquedaDeReparacion(String nombreMarca, String nombreCategoria, String nombreNombreReparacion, String nombreUbicacion, int stock, int precio) {

        Marca marcaNuevo;
        Categoria categoriaNuevo;
        NombreReparacion nombreReparacionNuevo;
        Ubicacion ubicacionNuevo;
        
        if(!nombreMarca.equals("-")){
            marcaNuevo = marcaService.obtenerMarcaPorNombre(nombreMarca);
        }
        else{
            marcaNuevo = new Marca(0, "-", new ArrayList<>());
        }
        
        if(!nombreCategoria.equals("-")){
            categoriaNuevo = categoriaService.obtenerCategoriaPorNombre(nombreCategoria);
        }
        else{
            categoriaNuevo = new Categoria(0, "-", new ArrayList<>(), new ArrayList<>());
        }
        
        if(!nombreNombreReparacion.equals("-")){
            nombreReparacionNuevo = nombreReparacionService.obtenerNombreReparacionPorNombre(nombreNombreReparacion);
        }
        else{
            nombreReparacionNuevo = new NombreReparacion(0, "-");
        }
        
        if(!nombreUbicacion.equals("-")){
            ubicacionNuevo = ubicacionService.obtenerUbicacionPorNombre(nombreUbicacion);
        }
        else{
            ubicacionNuevo = new Ubicacion(0, "-", new ArrayList<>());
        }
        
        Reparacion reparacion = new Reparacion(1, stock, nombreReparacionNuevo, marcaNuevo, categoriaNuevo, new ArrayList<>(), ubicacionNuevo);
        
        List<Reparacion> listaReparacions = reparacionService.busquedaDeReparacion(reparacion);
        
        for(Reparacion rep : listaReparacions){
            rep.setListaPrecios(precioService.obtenerPrecioPorIdReparacion(rep.getId_reparacion()));
        }
        /*
        System.out.println("stock " + stock);
        System.out.println("nombreReparacion " + nombreReparacionNuevo.getNombre_reparacion());
        System.out.println("marca " + marcaNuevo.getNombre_marca());
        System.out.println("categoria " + categoriaNuevo.getNombre_categoria());
        System.out.println("ubicacion " + ubicacionNuevo.getNombre_ubicacion());
        
        System.out.println("tamaño de lista de busqueda: " + listaReparacions.size());
        
        int cont = 0;
        for(Reparacion rep : listaReparacions){
            cont = cont + 1;
            System.out.println(cont + ". id: " + rep.getId_reparacion());
        }
        
        return listaReparacions;
    }
    */

    public List<Estado> obtenerEstados() {
        return estadoService.listarEstados();
    }

    public Reparacion obtenerReparacionPorId(int idReparacion) {
        return reparacionService.obtenerReparacionPorId(idReparacion);
    }


}

