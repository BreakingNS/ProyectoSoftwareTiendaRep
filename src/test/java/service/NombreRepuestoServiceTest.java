package service;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import dao.impl.CategoriaDAOImpl;
import dao.impl.ClienteDAOImpl;
import dao.impl.EstadoDAOImpl;
import dao.impl.MarcaDAOImpl;
import dao.impl.NombreRepuestoDAOImpl;
import dao.impl.PrecioDAOImpl;
import dao.impl.ReparacionDAOImpl;
import dao.impl.RepuestoDAOImpl;
import dao.impl.UbicacionDAOImpl;
import dao.impl.VentaDAOImpl;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Marca;
import model.NombreRepuesto;
import model.Repuesto;
import model.Ubicacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NombreRepuestoServiceTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    
    private static MarcaDAOImpl marcaDAO;
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    private static UbicacionDAOImpl ubicacionDAO;
    private static CategoriaDAOImpl categoriaDAO;
    private static EstadoDAOImpl estadoDAO;
    private static ClienteDAOImpl clienteDAO;
    private static RepuestoDAOImpl repuestoDAO;
    private static PrecioDAOImpl precioDAO;
    private static ReparacionDAOImpl reparacionDAO;
    private static VentaDAOImpl ventaDAO;
    
    private static NombreRepuestoService nombreRepuestoService;
    
    public NombreRepuestoServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        
        marcaDAO = new MarcaDAOImpl(connection);
        nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
        ubicacionDAO = new UbicacionDAOImpl(connection);
        categoriaDAO = new CategoriaDAOImpl(connection);
        estadoDAO = new EstadoDAOImpl(connection);
        clienteDAO = new ClienteDAOImpl(connection);
        repuestoDAO = new RepuestoDAOImpl(connection);
        precioDAO = new PrecioDAOImpl(connection);
        reparacionDAO = new ReparacionDAOImpl(connection);
        ventaDAO = new VentaDAOImpl(connection);
        
        nombreRepuestoService = new NombreRepuestoService(nombreRepuestoDAO);
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
        configuracion.crearTablaUbicacion();
        configuracion.crearTablaCategoria();
        configuracion.crearTablaEstado();
        configuracion.crearTablaCliente();
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
        configuracion.eliminarTablaCliente();
        configuracion.eliminarTablaEstado();
        configuracion.eliminarTablaCategoria();
        configuracion.eliminarTablaUbicacion();
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
        configuracion.eliminarTablaCliente();
        configuracion.eliminarTablaEstado();
        configuracion.eliminarTablaCategoria();
        configuracion.eliminarTablaUbicacion();
        configuracion.eliminarTablaNombreRepuesto();
        configuracion.eliminarTablaMarca();
    }
    
    @Test
    public void agregarNombreRepuesto(){
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(2, "Termostato");
        nombreRepuestoService.agregarNombreRepuesto(nombreRepuesto);
        nombreRepuestoService.agregarNombreRepuesto(nombreRepuesto1);
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
        
        Repuesto repuesto = new Repuesto(1, 10, nombreRepuesto, marca, categoria, new ArrayList<>(), ubicacion);
        Repuesto repuesto1 = new Repuesto(2, 20, nombreRepuesto1, marca1, categoria1, new ArrayList<>(), ubicacion1);
        repuestoDAO.crearRepuesto(repuesto);
        repuestoDAO.crearRepuesto(repuesto1);
    }
    
    @Test
    public void listarNombreRepuestos(){
        agregarNombreRepuesto();
        
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoService.listarNombreRepuestosOrdenadosPorId();
        
        assertEquals(1, listaNombreRepuestos.get(0).getId_nombrerepuesto());
        assertEquals("Bobina", listaNombreRepuestos.get(0).getNombre_repuesto());
        
    }
    
    @Test
    public void obtenerNombreRepuestoPorId(){
        agregarNombreRepuesto();
        
        NombreRepuesto nombreRepuesto = nombreRepuestoService.obtenerNombreRepuestoPorId(2);
        
        assertEquals(2, nombreRepuesto.getId_nombrerepuesto());
        assertEquals("Termostato", nombreRepuesto.getNombre_repuesto());
    }
    
    @Test
    public void editarNombreRepuestoPorId(){
        agregarNombreRepuesto();
        
        NombreRepuesto nombreRepuesto = nombreRepuestoService.obtenerNombreRepuestoPorId(1);
        nombreRepuesto.setNombre_repuesto("Fuente");
        nombreRepuestoService.editarNombreRepuestoPorId(nombreRepuesto);
        
        nombreRepuesto = null;
        nombreRepuesto = nombreRepuestoService.obtenerNombreRepuestoPorId(1);
        
        assertEquals("Fuente", nombreRepuesto.getNombre_repuesto());
        
    }
    /*
    @Test
    public void eliminarNombreRepuestoPorId(){
        agregarNombreRepuesto();
        
        nombreRepuestoService.eliminarNombreRepuestoPorId(1);
        
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoService.listarNombreRepuestos();
        assertEquals(1, listaNombreRepuestos.size());
    }
    */
}
