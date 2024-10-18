package controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Cliente;
import model.Estado;
import model.Marca;
import model.Modelo;
import model.NombreRepuesto;
import model.Pago;
import model.Precio;
import model.Repuesto;
import model.Reparacion;
import model.Tecnico;
import model.Ubicacion;
import service.CategoriaService;
import service.ClienteService;
import service.EstadoService;
import service.PagoService;
import service.ReparacionService;
import service.ReparacionService;
import service.TecnicoService;

public class ReparacionController {
    
    private final ReparacionService reparacionService;
    private final CategoriaService categoriaService;
    private final ClienteService clienteService;
    private final EstadoService estadoService;
    private final PagoService pagoService;
    private final TecnicoService tecnicoService; 
    
    private final RepuestoController repuestoController;
        
    public ReparacionController(ReparacionService reparacionService,
            CategoriaService categoriaService, 
            ClienteService clienteService, 
            EstadoService estadoService, 
            TecnicoService tecnicoService,
            PagoService pagoService,
            RepuestoController repuestoController
            ){
        this.reparacionService= reparacionService;
        this.categoriaService = categoriaService;
        this.clienteService = clienteService;
        this.estadoService = estadoService;
        this.pagoService = pagoService;
        this.tecnicoService = tecnicoService;
        
        this.repuestoController = repuestoController;
    }
    
    public void agregarReparacion(Reparacion reparacion, List<Repuesto> listaRepuestos) throws SQLException{        
        reparacionService.agregarReparacion(reparacion, listaRepuestos);
    }
    
    public List<Reparacion> listarReparaciones(){
        return reparacionService.listarReparaciones();
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
    
    public void editarReparacionSoloEstado(Reparacion reparacion){
        reparacionService.editarReparacionSoloEstado(reparacion);
    }
    /*
    
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

    public List<Reparacion> listarReparacionesOrdenadasPorFechaActual() {
        return reparacionService.listarReparacionesOrdenadasPorFechaActual();
    }

    public List<Reparacion> busquedaDeReparacion(String categoriaSeleccionada, 
            /*String pagadoSeleccionado, */
            String estadoSeleccionado, 
            String tecnicoSeleccionado, 
            String clienteSeleccionado) {
        
        Categoria categoriaNuevo;
        Cliente clienteNuevo;
        Estado estadoNuevo;
        Tecnico tecnicoNuevo;
        
        if(!categoriaSeleccionada.equals("-")){
            categoriaNuevo = categoriaService.obtenerCategoriaPorNombre(categoriaSeleccionada);
        }
        else{
            categoriaNuevo = new Categoria(0, ("-"), new ArrayList<>(), new ArrayList<>());
        }
        
        if(!clienteSeleccionado.equals("")){
            clienteNuevo = clienteService.obtenerClientePorId(Integer.parseInt(clienteSeleccionado));
        }
        else{
            clienteNuevo = new Cliente(0, "-", "-", "-", "-", new ArrayList<>(), new ArrayList<>());
        }
        
        if(!estadoSeleccionado.equals("-")){
            estadoNuevo = estadoService.obtenerEstadoPorNombre(estadoSeleccionado);
        }
        else{
            estadoNuevo = new Estado(0, "-", new ArrayList<>());
        }
        
        if(!tecnicoSeleccionado.equals("-")){
            tecnicoNuevo = tecnicoService.obtenerTecnicoPorNombre(tecnicoSeleccionado);
        }
        else{
            tecnicoNuevo = new Tecnico(0, "-", "-", "-", "-", new ArrayList<>());
        }
        
        
        Reparacion reparacion = new Reparacion(0, 
                BigDecimal.ZERO, 
                "", 
                LocalDateTime.MIN, 
                LocalDateTime.MIN, 
                null, 
                categoriaNuevo, 
                clienteNuevo, 
                estadoNuevo, 
                tecnicoNuevo);
        
        /*
        System.out.println("nombrerep : " + repuesto.getNombreRepuesto().getNombre_repuesto());
        System.out.println("marca: " + repuesto.getMarca().getNombre_marca());
        System.out.println("categ: " + repuesto.getCategoria().getNombre_categoria());
        System.out.println("ubi: " + repuesto.getUbicacion().getNombre_ubicacion());
        System.out.println("modelo: " + repuesto.getModelo().getNombre_modelo());
        System.out.println("codigo: " + repuesto.getCodigo());
        */
        
        List<Reparacion> listaReparaciones = reparacionService.busquedaDeReparacion(reparacion/*, pagadoNuevo*/);
        /*
        for(Repuesto rep : listaRepuestos){
            rep.setListaPrecios(precioService.obtenerPrecioPorIdRepuesto(rep.getId_repuesto()));
        }
        */
        return listaReparaciones;
    }

    public List<Categoria> retornarCategorias(){
        return categoriaService.listarCategoriasOrdenadasPorId();
    }
    
    public List<String> retornarPagos(){
        return pagoService.listarPagos();
    }
    
    public List<Estado> retornarEstados(){
        return estadoService.listarEstados();
    }

    public List<Tecnico> retornarTecnicos() {
        return tecnicoService.listarTecnicos();
    }

    public void editarReparacionSoloTecnico(Reparacion reparacion) {
        reparacionService.editarReparacionSoloTecnico(reparacion);
    }

    public void editarReparacionCompleta(Reparacion reparacion, List<Repuesto> listaRepuestosSeleccionadosVIEJA, List<Repuesto> listaRepuestosSeleccionadosNUEVA) throws SQLException {
        reparacionService.editarReparacionCompleta(reparacion, listaRepuestosSeleccionadosVIEJA, listaRepuestosSeleccionadosNUEVA);
    }

    public void editarReparacion(Reparacion reparacion) {
        reparacionService.editarReparacion(reparacion);
    }

    public void eliminarReparacion(int idReparacion) throws SQLException {
        reparacionService.eliminarReparacion(idReparacion);
    }

    public Precio obtenerPrecioRepuestoPorFechaReparacion(int idReparacion, Repuesto repuesto) {
        return reparacionService.obtenerPrecioRepuestoPorFechaReparacion(idReparacion, repuesto);
    }

}

