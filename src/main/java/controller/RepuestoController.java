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
import model.Modelo;
import model.NombreRepuesto;
import model.Precio;
import model.Repuesto;
import model.Tecnico;
import model.Ubicacion;
import service.CategoriaService;
import service.MarcaService;
import service.ModeloService;
import service.NombreRepuestoService;
import service.PrecioService;
import service.RepuestoService;
import service.RepuestoService;
import service.TecnicoService;
import service.UbicacionService;

public class RepuestoController {
    
    private final RepuestoService repuestoService;
    private final MarcaService marcaService;
    private final CategoriaService categoriaService;
    private final UbicacionService ubicacionService;
    private final PrecioService precioService;
    private final NombreRepuestoService nombreRepuestoService;
    private final ModeloService modeloService;
    private final TecnicoService tecnicoService;

    public RepuestoController(NombreRepuestoService nombreRepuestoService,
            RepuestoService repuestoService,
            MarcaService marcaService, 
            CategoriaService categoriaService, 
            UbicacionService ubicacionService, 
            PrecioService precioService,
            ModeloService modeloService,
            TecnicoService tecnicoService) {
        this.repuestoService = repuestoService;
        this.marcaService = marcaService;
        this.categoriaService = categoriaService;
        this.ubicacionService = ubicacionService;
        this.precioService = precioService;
        this.nombreRepuestoService = nombreRepuestoService;
        this.modeloService = modeloService;
        this.tecnicoService = tecnicoService;
    }
    
    public void agregarRepuesto(String nombreRepuesto, 
            String marca, 
            String modelo,
            String categoria, 
            String ubicacion, 
            String codigo,
            int stock, 
            int precio            
        ){

        Marca marcaNuevo;
        Modelo modeloNuevo;
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
        
        if(!modelo.equals("-")){
            modeloNuevo = modeloService.obtenerModeloPorNombre(modelo);
        }
        else{
            modeloNuevo = new Modelo(0, "-");
        }
        
        Repuesto repuesto = new Repuesto(1, stock, nombreRepuestoNuevo, marcaNuevo, categoriaNuevo, modeloNuevo, new ArrayList<>(), ubicacionNuevo, codigo);
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
    
    public void editarRepuesto(int idRepuesto, 
            String nombreMarca, 
            String nombreCategoria,
            String nombreModelo,
            String nombreNombreRepuesto, 
            String nombreUbicacion, 
            String codigo,
            int stock,
            BigDecimal precio
    ){
        Marca marcaEdit = marcaService.obtenerMarcaPorNombre(nombreMarca);
        Categoria categoriaEdit = categoriaService.obtenerCategoriaPorNombre(nombreCategoria);
        Modelo modeloEdit = modeloService.obtenerModeloPorNombre(nombreModelo);
        NombreRepuesto nombreRepuestoEdit = nombreRepuestoService.obtenerNombreRepuestoPorNombre(nombreNombreRepuesto);
        Ubicacion ubicacionEdit = ubicacionService.obtenerUbicacionPorNombre(nombreUbicacion);
        
        Repuesto repuesto = new Repuesto(idRepuesto, stock, nombreRepuestoEdit, marcaEdit, categoriaEdit, modeloEdit, new ArrayList<>(), ubicacionEdit, codigo);
        System.out.println("id: " + repuesto.getId_repuesto());
        System.out.println("stock: " + repuesto.getStock());
        System.out.println("nombreRepuesto: " + repuesto.getNombreRepuesto());
        System.out.println("marca: " + repuesto.getMarca());
        System.out.println("categoria: " + repuesto.getCategoria());
        System.out.println("modelo: " + repuesto.getModelo());
        System.out.println("ubicacion: " + repuesto.getUbicacion());
        System.out.println("codigo: " + repuesto.getCodigo());
        
        repuestoService.editarRepuestoPorId(repuesto);
        
        //BigDecimal precioBig = new BigDecimal(precio);
        List<Precio> listaPreciosDeRepuesto = precioService.obtenerPrecioPorIdRepuesto(repuesto.getId_repuesto());
        if(listaPreciosDeRepuesto.get(listaPreciosDeRepuesto.size() - 1).getValor() != precio){
            Precio precioNuevo = new Precio(1, repuesto, LocalDateTime.now(), precio);
            precioService.agregarPrecio(precioNuevo);
        }
    }
    
    
    public void eliminarRepuesto(int id){
        precioService.eliminarPreciosPorIdRepuesto(id);
        repuestoService.eliminarRepuestoPorId(id);
    }
    
    
    public List<NombreRepuesto> retornarListaNombreRepuestos(){
        return nombreRepuestoService.listarNombreRepuestosOrdenadosPorId();
    }
    
    public List<Marca> retornarListaMarcas(){
        return marcaService.listarMarcasOrdenadasPorNombre();
    }
    
    public List<Categoria> retornarCategorias(){
        return categoriaService.listarCategoriasOrdenadasPorId();
    }
    
    public List<Ubicacion> retornarUbicaciones(){
        return ubicacionService.listarUbicaciones();
    }
    
    public List<Modelo> retornarModelos(){
        return modeloService.listarModelos();
    }

    public List<Tecnico> retornarTecnicos() {
        return tecnicoService.listarTecnicos();
    }
    
    public List<Repuesto> busquedaDeRepuesto(String nombreMarca, String nombreCategoria, String nombreNombreRepuesto, String nombreUbicacion, String nombreModelo, String codigo) {

        Marca marcaNuevo;
        Categoria categoriaNuevo;
        NombreRepuesto nombreRepuestoNuevo;
        Ubicacion ubicacionNuevo;
        Modelo modeloNuevo;
        
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
        
        if(!nombreModelo.equals("-")){
            modeloNuevo = modeloService.obtenerModeloPorNombre(nombreModelo);
        }
        else{
            modeloNuevo = new Modelo(0, "-");
        }
        
        Repuesto repuesto = new Repuesto(0, 0, nombreRepuestoNuevo, marcaNuevo, categoriaNuevo, modeloNuevo, new ArrayList<>(), ubicacionNuevo, codigo);
        
        System.out.println("nombrerep : " + repuesto.getNombreRepuesto().getNombre_repuesto());
        System.out.println("marca: " + repuesto.getMarca().getNombre_marca());
        System.out.println("categ: " + repuesto.getCategoria().getNombre_categoria());
        System.out.println("ubi: " + repuesto.getUbicacion().getNombre_ubicacion());
        System.out.println("modelo: " + repuesto.getModelo().getNombre_modelo());
        System.out.println("codigo: " + repuesto.getCodigo());
        
        List<Repuesto> listaRepuestos = repuestoService.busquedaDeRepuesto(repuesto);
        
        for(Repuesto rep : listaRepuestos){
            rep.setListaPrecios(precioService.obtenerPrecioPorIdRepuesto(rep.getId_repuesto()));
        }
        
        return listaRepuestos;
    }
    
    public List<Repuesto> obtenerRepuestosPorIdVenta(int id) {
        return repuestoService.obtenerRepuestosPorIdVenta(id);
    }

    public List<Repuesto> obtenerRepuestosPorIdReparacion(int idReparacion) {
        return repuestoService.obtenerRepuestosPorIdReparacion(idReparacion);
    }

    public void actualizarStockDeRepuesto(Repuesto repuesto, int stock) {
        repuestoService.actualizarStock(repuesto, stock);
    }
    
    public void actualizarPrecioDeRepuesto(Repuesto repuesto, BigDecimal precio) {
        repuestoService.actualizarPrecio(repuesto, precio);
    }

    public int obtenerIdPorCodigo(String codigo) {
        return repuestoService.obtenerIdPorCodigo(codigo);
    }

    

}
