
package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.math.BigDecimal;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Marca;
import model.Modelo;
import model.NombreRepuesto;
import model.Precio;
import model.Reparacion;
import model.Repuesto;
import model.Ubicacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrecioDAOImplTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    
    private static MarcaDAOImpl marcaDAO;
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    private static ModeloDAOImpl modeloDAO;
    private static UbicacionDAOImpl ubicacionDAO;
    private static CategoriaDAOImpl categoriaDAO;
    private static EstadoDAOImpl estadoDAO;
    private static ClienteDAOImpl clienteDAO;
    private static TecnicoDAOImpl tecnicoDAO;
    private static FacturaDAOImpl facturaDAO;
    private static PagoDAOImpl pagoDAO;
    private static RepuestoDAOImpl repuestoDAO;
    private static PrecioDAOImpl precioDAO;
    private static ReparacionDAOImpl reparacionDAO;
    private static VentaDAOImpl ventaDAO;
    
    public PrecioDAOImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        
        marcaDAO = new MarcaDAOImpl(connection);
        nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
        modeloDAO = new ModeloDAOImpl(connection);
        ubicacionDAO = new UbicacionDAOImpl(connection);
        categoriaDAO = new CategoriaDAOImpl(connection);
        estadoDAO = new EstadoDAOImpl(connection);
        clienteDAO = new ClienteDAOImpl(connection);
        tecnicoDAO = new TecnicoDAOImpl(connection);
        facturaDAO = new FacturaDAOImpl(connection);
        pagoDAO = new PagoDAOImpl(connection);
        repuestoDAO = new RepuestoDAOImpl(connection);
        precioDAO = new PrecioDAOImpl(connection);
        reparacionDAO = new ReparacionDAOImpl(connection);
        ventaDAO = new VentaDAOImpl(connection);
        
    }
    
    @AfterAll
    public static void tearDownClass() {
        conexionDataBase.cerrarConexion(connection);
    }
    
    @BeforeEach
    public void setUp() {
        configuracion = new ConfiguracionDataBase(connection);
        
        configuracion.crearTablaMarca();
        configuracion.crearTablaNombreRepuesto();
        configuracion.crearTablaModelo();
        configuracion.crearTablaUbicacion();
        configuracion.crearTablaCategoria();
        configuracion.crearTablaEstado();
        configuracion.crearTablaCliente();
        configuracion.crearTablaTecnico();
        configuracion.crearTablaFactura();
        configuracion.crearTablaPago();
        configuracion.crearTablaVenta();
        configuracion.crearTablaRepuesto();
        configuracion.crearTablaPrecio();
        configuracion.crearTablaReparacion();
        configuracion.crearTablaVentaRepuesto();
        configuracion.crearTablaReparacionRepuesto();
        
    }
    
    @AfterEach
    public void tearDown() {
        
        configuracion.eliminarTablaReparacionRepuesto();
        configuracion.eliminarTablaVentaRepuesto();
        configuracion.eliminarTablaReparacion();
        configuracion.eliminarTablaPrecio();
        configuracion.eliminarTablaRepuesto();
        configuracion.eliminarTablaVenta();
        configuracion.eliminarTablaPago();
        configuracion.eliminarTablaFactura();
        configuracion.eliminarTablaTecnico();
        configuracion.eliminarTablaCliente();
        configuracion.eliminarTablaEstado();
        configuracion.eliminarTablaCategoria();
        configuracion.eliminarTablaUbicacion();
        configuracion.eliminarTablaModelo();
        configuracion.eliminarTablaNombreRepuesto();
        configuracion.eliminarTablaMarca();
        
    }

    @Test
    public void eliminarTablas(){
        configuracion.eliminarTablaReparacionRepuesto();
        configuracion.eliminarTablaVentaRepuesto();
        configuracion.eliminarTablaReparacion();
        configuracion.eliminarTablaPrecio();
        configuracion.eliminarTablaRepuesto();
        configuracion.eliminarTablaVenta();
        configuracion.eliminarTablaPago();
        configuracion.eliminarTablaFactura();
        configuracion.eliminarTablaTecnico();
        configuracion.eliminarTablaCliente();
        configuracion.eliminarTablaEstado();
        configuracion.eliminarTablaCategoria();
        configuracion.eliminarTablaUbicacion();
        configuracion.eliminarTablaModelo();
        configuracion.eliminarTablaNombreRepuesto();
        configuracion.eliminarTablaMarca();
    }
    
    @Test
    public void pruebaCrearPrecio(){
        //Crear Repuestos
        
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(2, "Termostato");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
        Marca marca = new Marca(1, "Philips", new ArrayList<>());
        Marca marca1 = new Marca(2, "Generico", new ArrayList<>());
        marcaDAO.crearMarca(marca);
        marcaDAO.crearMarca(marca1);
        Categoria categoria = new Categoria(1, "Lavarropas", new ArrayList<>(), new ArrayList<>());
        Categoria categoria1 = new Categoria(2, "Heladera", new ArrayList<>(), new ArrayList<>());
        categoriaDAO.crearCategoria(categoria);
        categoriaDAO.crearCategoria(categoria1);
        Ubicacion ubicacion = new Ubicacion(1, "Deposito", new ArrayList<>());
        Ubicacion ubicacion1 = new Ubicacion(2, "Mostrador", new ArrayList<>());
        ubicacionDAO.crearUbicacion(ubicacion);
        ubicacionDAO.crearUbicacion(ubicacion1);
        Modelo modelo = new Modelo(1, "Plus");
        Modelo modelo1 = new Modelo(1, "Plus Ultra");
        modeloDAO.crearModelo(modelo);
        modeloDAO.crearModelo(modelo1);        
        Repuesto repuesto = new Repuesto(1, 10, nombreRepuesto, marca, categoria, modelo, new ArrayList<>(), ubicacion, "A000");
        Repuesto repuesto1 = new Repuesto(2, 20, nombreRepuesto1, marca1, categoria1, modelo1, new ArrayList<>(), ubicacion1, "A001");
        repuestoDAO.crearRepuesto(repuesto);
        repuestoDAO.crearRepuesto(repuesto1);
        
        //Crear Precio
        
        LocalDateTime ahora = LocalDateTime.now();
        Precio precio1 = new Precio(1, repuesto, ahora, new BigDecimal("3000"));
        Precio precio2 = new Precio(2, repuesto, ahora, new BigDecimal("4000"));
        Precio precio3 = new Precio(3, repuesto1, ahora, new BigDecimal("7000"));
        Precio precio4 = new Precio(4, repuesto1, ahora, new BigDecimal("8000"));
        precioDAO.crearPrecio(precio1);
        precioDAO.crearPrecio(precio2);
        precioDAO.crearPrecio(precio3);
        precioDAO.crearPrecio(precio4);
    }
    
    @Test
    public void pruebaObtenerPrecios(){
        pruebaCrearPrecio();
        List<Precio> listaPrecios = precioDAO.obtenerPrecios();
        
        System.out.println("Tamaño de la lista: " + listaPrecios.size());
        
        assertEquals(1, listaPrecios.get(0).getId_precio());
        assertEquals("3000.00", listaPrecios.get(0).getValor().toString());
        assertEquals("Philips" , listaPrecios.get(0).getRepuesto().getMarca().getNombre_marca());
        
        assertEquals(3, listaPrecios.get(2).getId_precio());
        assertEquals("7000.00", listaPrecios.get(2).getValor().toString());
        assertEquals("Generico" , listaPrecios.get(2).getRepuesto().getMarca().getNombre_marca());
    }
    
    @Test
    public void pruebaObtenerPrecio(){
        pruebaCrearPrecio();
        Precio precio = precioDAO.obtenerPrecio(1);
        
        assertEquals(1, precio.getId_precio());
        assertEquals("3000.00", precio.getValor().toString());
        assertEquals("Philips" , precio.getRepuesto().getMarca().getNombre_marca());
    }
    
    @Test
    public void pruebaModificarPrecios(){
        pruebaCrearPrecio();
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Lampara");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
        Marca marca = new Marca(1, "Bosch", new ArrayList<>());
        marcaDAO.actualizarMarca(marca);
        List<Reparacion> listaReparaciones = null;
        Categoria categoria = new Categoria(1, "Linea Blanca", new ArrayList<>(), new ArrayList<>());
        categoriaDAO.actualizarCategoria(categoria);
        Ubicacion ubicacion = new Ubicacion(1, "Local 2", new ArrayList<>());
        ubicacionDAO.actualizarUbicacion(ubicacion);
        Modelo modelo = new Modelo(1, "Gold");
        modeloDAO.crearModelo(modelo);
        List<Precio> listaPrecios = new ArrayList<>();
        Repuesto repuesto = new Repuesto(1, 40, nombreRepuesto, marca, categoria, modelo, listaPrecios, ubicacion, "A999");
        repuestoDAO.actualizarRepuesto(repuesto);
        
        LocalDateTime ahora = LocalDateTime.now();
        Precio precio = new Precio(1, repuesto, ahora, new BigDecimal("18000"));
        precioDAO.actualizarPrecio(precio);
        
        listaPrecios = precioDAO.obtenerPrecios();
        
        assertEquals(1, listaPrecios.get(0).getId_precio());
        assertEquals(40, listaPrecios.get(0).getRepuesto().getStock());
        assertEquals("18000.00", listaPrecios.get(0).getValor().toString());
        assertEquals("Bosch" , listaPrecios.get(0).getRepuesto().getMarca().getNombre_marca());
    }
    
    @Test
    public void pruebaEliminarPrecios(){
        pruebaCrearPrecio();
        precioDAO.eliminarPrecio(1);
        
        List<Precio> listaPrecios = precioDAO.obtenerPrecios();
        
        assertEquals(3, listaPrecios.size());
        assertEquals(2, listaPrecios.get(0).getId_precio());
    }
    
    @Test
    public void pruebaObtenerPrecioPorIdRepuesto(){
        pruebaCrearPrecio();
        List<Precio> listaPrecios = precioDAO.obtenerPreciosPorIdRepuesto(1);
        
        assertEquals("4000.00", listaPrecios.get(listaPrecios.size() - 1).getValor().toString());
        
    }
}