package controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Estado;
import model.Repuesto;
import model.Marca;
import model.NombreRepuesto;
import model.Precio;
import model.Repuesto;
import model.Ubicacion;
import service.CategoriaService;
import service.MarcaService;
import service.NombreRepuestoService;
import service.PrecioService;
import service.RepuestoService;
import service.RepuestoService;
import service.UbicacionService;

public class RepuestoController {
    /*
    private final RepuestoService repuestoService;

    public RepuestoController(RepuestoService repuestoService) {
        this.repuestoService = repuestoService;
    }
    
    public void agregarRepuesto(String nombre, String apellido, String telefono){

    }
    
    public List<Repuesto> listarRepuestos(){
        List<Repuesto> listaRepuestos = repuestoService.listarRepuestos();
        return listaRepuestos;
    }
    
    public Repuesto obtenerRepuestoPorId(int id){

    }
    
    public List<Repuesto> busquedaDeRepuesto(String nombreRepuesto, String marca, String categoria, String ubicacion, String stock, String precio){
        List<Repuesto> listaRepuesto = new ArrayList<>();
        
        
        NombreRepuesto nombreRepuestoAux = new NombreRepuesto(1, nombreRepuesto);
        Marca marcaAux = new Marca(1, marca, new ArrayList<>());
        Categoria categoriaAux = new Categoria(1, categoria, new ArrayList<>(), new ArrayList<>());
        Ubicacion ubicacionAux = new Ubicacion(1, ubicacion, new ArrayList<>());
        int stockAux = Integer.parseInt(stock);
        
        List<Precio> listaPrecios = new ArrayList<>();
        Precio precioAux = new Precio(1, null, null, new BigDecimal(precio));
        listaPrecios.add(precioAux);
        
        Repuesto repuesto = new Repuesto(1, stockAux, nombreRepuestoAux, marcaAux, categoriaAux, listaPrecios, ubicacionAux);
        
        listaRepuesto = repuestoService.busquedaDeRepuesto(nombreRepuesto, marca, categoria, ubicacion, stock, precio);
        
        return listaRepuesto;
    }
    
    public void editarRepuesto(int id, String nombre, String apellido, String telefono){

    }
    
    public void eliminarRepuesto(int id){
        repuestoService.eliminarRepuestoPorId(id);
    }
    */
    
    private final RepuestoService repuestoService;
    private final MarcaService marcaService;
    private final CategoriaService categoriaService;
    private final UbicacionService ubicacionService;
    private final PrecioService precioService;
    private final NombreRepuestoService nombreRepuestoService;

    public RepuestoController(NombreRepuestoService nombreRepuestoService,
            RepuestoService repuestoService,
            MarcaService marcaService, 
            CategoriaService categoriaService, 
            UbicacionService ubicacionService, 
            PrecioService precioService) {
        this.repuestoService = repuestoService;
        this.marcaService = marcaService;
        this.categoriaService = categoriaService;
        this.ubicacionService = ubicacionService;
        this.precioService = precioService;
        this.nombreRepuestoService = nombreRepuestoService;
    }
    
    public void agregarRepuesto(String nombreRepuesto, 
            String marca, 
            String categoria, 
            String ubicacion, 
            int stock, 
            int precio){
        Marca marcaNuevo;
        Categoria categoriaNuevo;
        Ubicacion ubicacionNuevo;
        NombreRepuesto nombreRepuestoNuevo;
        
        if(!marca.equals("-")){
            marcaNuevo = marcaService.obtenerMarcaPorNombre(marca);
        }
        else{
            marcaNuevo = new Marca(0, "-", new ArrayList<>());
        }
        
        if(!categoria.equals("-")){
            categoriaNuevo = categoriaService.obtenerCategoriaPorNombre(categoria);
        }
        else{
            categoriaNuevo = new Categoria(0, "-", new ArrayList<>(), new ArrayList<>());
        }
        
        if(!ubicacion.equals("-")){
            ubicacionNuevo = ubicacionService.obtenerUbicacionPorNombre(ubicacion);
        }
        else{
            ubicacionNuevo = new Ubicacion(0, "-", new ArrayList<>());
        }
        
        if(!nombreRepuesto.equals("-")){
            nombreRepuestoNuevo = nombreRepuestoService.obtenerNombreRepuestoPorNombre(nombreRepuesto);
        }
        else{
            nombreRepuestoNuevo = new NombreRepuesto(0, "-");
        }

        Repuesto repuesto = new Repuesto(1, stock, nombreRepuestoNuevo, marcaNuevo, categoriaNuevo, new ArrayList<>(), ubicacionNuevo);
        repuestoService.agregarRepuesto(repuesto);
        repuesto.setId_repuesto(repuestoService.obtenerUltimoIdRepuesto());
        
        
        
        Precio precioNuevo = new Precio(1, repuesto, LocalDateTime.now(), new BigDecimal(precio));
        precioService.agregarPrecio(precioNuevo);
    }
    
    public List<Repuesto> listarRepuestos(){
        List<Repuesto> listaRepuestos= repuestoService.listarRepuestos();
        return listaRepuestos;
    }

    
    public Repuesto obtenerRepuestoPorId(int id){
        Repuesto repuesto = repuestoService.obtenerRepuestoPorId(id);
        return repuesto;
    }
    /*
    public List<Repuesto> busquedaDeRepuesto(String nombre, String apellido, String telefono){
        Repuesto repuesto = new Repuesto(0, nombre, apellido, telefono, new ArrayList<>(), new ArrayList<>());
        List<Repuesto> listaRepuestos = repuestoService.busquedaDeRepuesto(repuesto);
        
        return listaRepuestos;
    }
    */
    public void editarRepuesto(int idRepuesto, String nombreMarca, String nombreCategoria, String nombreNombreRepuesto, String nombreUbicacion, int stock, int precio){
        Marca marcaEdit = marcaService.obtenerMarcaPorNombre(nombreMarca);
        Categoria categoriaEdit = categoriaService.obtenerCategoriaPorNombre(nombreCategoria);
        NombreRepuesto nombreRepuestoEdit = nombreRepuestoService.obtenerNombreRepuestoPorNombre(nombreNombreRepuesto);
        Ubicacion ubicacionEdit = ubicacionService.obtenerUbicacionPorNombre(nombreUbicacion);
        
        Repuesto repuesto = new Repuesto(idRepuesto, stock, nombreRepuestoEdit, marcaEdit, categoriaEdit, new ArrayList<>(), ubicacionEdit);
        repuestoService.editarRepuestoPorId(repuesto);
        
        BigDecimal precioBig = new BigDecimal(precio);
        List<Precio> listaPreciosDeRepuesto = precioService.obtenerPrecioPorIdRepuesto(repuesto.getId_repuesto());
        if(listaPreciosDeRepuesto.get(listaPreciosDeRepuesto.size() - 1).getValor() != precioBig){
            Precio precioNuevo = new Precio(1, repuesto, LocalDateTime.now(), precioBig);
            precioService.agregarPrecio(precioNuevo);
        }
    }
    
    
    public void eliminarRepuesto(int id){
        precioService.eliminarPreciosPorIdRepuesto(id);
        repuestoService.eliminarRepuestoPorId(id);
    }
    
    
    public List<NombreRepuesto> retornarListaNombreRepuestos(){
        return nombreRepuestoService.listarNombreRepuestos();
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

    public List<Repuesto> busquedaDeRepuesto(String nombreMarca, String nombreCategoria, String nombreNombreRepuesto, String nombreUbicacion, int stock, int precio) {

        Marca marcaNuevo;
        Categoria categoriaNuevo;
        NombreRepuesto nombreRepuestoNuevo;
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
        
        if(!nombreNombreRepuesto.equals("-")){
            nombreRepuestoNuevo = nombreRepuestoService.obtenerNombreRepuestoPorNombre(nombreNombreRepuesto);
        }
        else{
            nombreRepuestoNuevo = new NombreRepuesto(0, "-");
        }
        
        if(!nombreUbicacion.equals("-")){
            ubicacionNuevo = ubicacionService.obtenerUbicacionPorNombre(nombreUbicacion);
        }
        else{
            ubicacionNuevo = new Ubicacion(0, "-", new ArrayList<>());
        }
        
        Repuesto repuesto = new Repuesto(1, stock, nombreRepuestoNuevo, marcaNuevo, categoriaNuevo, new ArrayList<>(), ubicacionNuevo);
        
        System.out.println("stock: " + stock);
        System.out.println("nombrerep : " + repuesto.getNombreRepuesto().getNombre_repuesto());
        System.out.println("marca: " + repuesto.getMarca().getNombre_marca());
        System.out.println("categ: " + repuesto.getCategoria().getNombre_categoria());
        System.out.println("ubi: " + repuesto.getUbicacion().getNombre_ubicacion());
        
        List<Repuesto> listaRepuestos = repuestoService.busquedaDeRepuesto(repuesto);
        
        for(Repuesto rep : listaRepuestos){
            rep.setListaPrecios(precioService.obtenerPrecioPorIdRepuesto(rep.getId_repuesto()));
        }
        /*
        System.out.println("stock " + stock);
        System.out.println("nombreRepuesto " + nombreRepuestoNuevo.getNombre_repuesto());
        System.out.println("marca " + marcaNuevo.getNombre_marca());
        System.out.println("categoria " + categoriaNuevo.getNombre_categoria());
        System.out.println("ubicacion " + ubicacionNuevo.getNombre_ubicacion());
        
        System.out.println("tamaño de lista de busqueda: " + listaRepuestos.size());
        
        int cont = 0;
        for(Repuesto rep : listaRepuestos){
            cont = cont + 1;
            System.out.println(cont + ". id: " + rep.getId_repuesto());
        }
        */
        
        return listaRepuestos;
    }

    public List<Repuesto> obtenerRepuestosPorIdVenta(int id) {
        return repuestoService.obtenerRepuestosPorIdVenta(id);
    }

    public List<Repuesto> obtenerRepuestosPorIdReparacion(int idReparacion) {
        return repuestoService.obtenerRepuestosPorIdReparacion(idReparacion);
    }

}
