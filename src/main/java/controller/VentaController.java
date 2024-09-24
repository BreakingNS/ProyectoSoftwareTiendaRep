package controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Categoria;
import model.Cliente;
import model.Marca;
import model.NombreRepuesto;
import model.Precio;
import model.Repuesto;
import model.Venta;
import model.Ubicacion;
import service.CategoriaService;
import service.ClienteService;
import service.MarcaService;
import service.NombreRepuestoService;
import service.PrecioService;
import service.RepuestoService;
import service.VentaService;
import service.UbicacionService;
import service.VentaService;

public class VentaController {
    
    private final VentaService ventaService;
    private final ClienteService clienteService;
    private final RepuestoController repuestoController;

    public VentaController(VentaService ventaService, 
            ClienteService clienteService, 
            RepuestoController repuestoController
            ){
        this.ventaService = ventaService;
        this.clienteService = clienteService;
        this.repuestoController = repuestoController;
    }
    
    public void agregarVenta(Venta venta, List<Repuesto> listaRepuestos) throws SQLException{
        ventaService.agregarVenta(venta, listaRepuestos);
    }
    
    public List<Venta> listarVentas(){
        List<Venta> listaVentas= ventaService.listarVentas();
        return listaVentas;
    }
    
    public void obtenerRepuestosPorIdVenta(int id) {
        repuestoController.obtenerRepuestosPorIdVenta(id);
    }
    
    public Venta obtenerVentaPorId(int id) {
        return ventaService.obtenerVentaPorId(id);
    }
    
    public void modificarVenta(Venta venta) {
        ventaService.editarVenta(venta);
    }
    /*
    public List<Venta> busquedaDeVenta(String nombre, String apellido, String telefono){
        Venta venta = new Venta(0, nombre, apellido, telefono, new ArrayList<>(), new ArrayList<>());
        List<Venta> listaVentas = ventaService.busquedaDeVenta(venta);
        
        return listaVentas;
    }
    */
    /*
    public void editarVenta(int idVenta, String nombreMarca, String nombreCategoria, String nombreNombreVenta, String nombreUbicacion, int stock, int precio){
        Marca marcaEdit = marcaService.obtenerMarcaPorNombre(nombreMarca);
        Categoria categoriaEdit = categoriaService.obtenerCategoriaPorNombre(nombreCategoria);
        NombreVenta nombreVentaEdit = nombreVentaService.obtenerNombreVentaPorNombre(nombreNombreVenta);
        Ubicacion ubicacionEdit = ubicacionService.obtenerUbicacionPorNombre(nombreUbicacion);
        
        Venta venta = new Venta(idVenta, stock, nombreVentaEdit, marcaEdit, categoriaEdit, new ArrayList<>(), ubicacionEdit);
        ventaService.editarVentaPorId(venta);
        
        BigDecimal precioBig = new BigDecimal(precio);
        List<Precio> listaPreciosDeVenta = precioService.obtenerPrecioPorIdVenta(venta.getId_venta());
        if(listaPreciosDeVenta.get(listaPreciosDeVenta.size() - 1).getValor() != precioBig){
            Precio precioNuevo = new Precio(1, venta, new Date(), precioBig);
            precioService.agregarPrecio(precioNuevo);
        }
    }
    
    
    public void eliminarVenta(int id){
        precioService.eliminarPreciosPorIdVenta(id);
        ventaService.eliminarVentaPorId(id);
    }
    
    
    public List<NombreVenta> retornarListaNombreVentas(){
        return nombreVentaService.listarNombreVentas();
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

    public List<Venta> busquedaDeVenta(String nombreMarca, String nombreCategoria, String nombreNombreVenta, String nombreUbicacion, int stock, int precio) {

        Marca marcaNuevo;
        Categoria categoriaNuevo;
        NombreVenta nombreVentaNuevo;
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
        
        if(!nombreNombreVenta.equals("-")){
            nombreVentaNuevo = nombreVentaService.obtenerNombreVentaPorNombre(nombreNombreVenta);
        }
        else{
            nombreVentaNuevo = new NombreVenta(0, "-");
        }
        
        if(!nombreUbicacion.equals("-")){
            ubicacionNuevo = ubicacionService.obtenerUbicacionPorNombre(nombreUbicacion);
        }
        else{
            ubicacionNuevo = new Ubicacion(0, "-", new ArrayList<>());
        }
        
        Venta venta = new Venta(1, stock, nombreVentaNuevo, marcaNuevo, categoriaNuevo, new ArrayList<>(), ubicacionNuevo);
        
        List<Venta> listaVentas = ventaService.busquedaDeVenta(venta);
        
        for(Venta rep : listaVentas){
            rep.setListaPrecios(precioService.obtenerPrecioPorIdVenta(rep.getId_venta()));
        }
        /*
        System.out.println("stock " + stock);
        System.out.println("nombreVenta " + nombreVentaNuevo.getNombre_venta());
        System.out.println("marca " + marcaNuevo.getNombre_marca());
        System.out.println("categoria " + categoriaNuevo.getNombre_categoria());
        System.out.println("ubicacion " + ubicacionNuevo.getNombre_ubicacion());
        
        System.out.println("tamaño de lista de busqueda: " + listaVentas.size());
        
        int cont = 0;
        for(Venta rep : listaVentas){
            cont = cont + 1;
            System.out.println(cont + ". id: " + rep.getId_venta());
        }
        
        return listaVentas;
    }
    */

    public Precio obtenerPrecioRepuestoPorFechaVenta(int idVenta, Repuesto repuesto) {
        return ventaService.obtenerPrecioRepuestoPorFechaVenta(idVenta, repuesto);
    }

    public List<Venta> busquedaDeVentas(int dia, int mes, int anio) {
        return ventaService.busquedaDeVentas(dia, mes, anio);
    }

    public void actualizarListaRepuestosPorVenta(Venta venta, List<Repuesto> listaRepuestosNuevos) throws SQLException {
        ventaService.actualizarListaRepuestosPorVenta(venta, listaRepuestosNuevos);
    }

    public void agregarRepuestosAVenta(Venta venta, List<Repuesto> listaRepuestos) throws SQLException {
        ventaService.agregarRepuestosAVenta(venta, listaRepuestos);
    }

    public void eliminarVenta(int idVenta) throws SQLException {
        ventaService.eliminarVentaPorId(idVenta);
    }
}
