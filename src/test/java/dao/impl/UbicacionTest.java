package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Ubicacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UbicacionTest {
    
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
    
    public UbicacionTest() {
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
    public void pruebaCrearUbicacion(){
        Ubicacion ubicacion = new Ubicacion(1, "Deposito", new ArrayList<>());
        Ubicacion ubicacion1 = new Ubicacion(2, "Piso 1", new ArrayList<>());
        ubicacionDAO.crearUbicacion(ubicacion);
        ubicacionDAO.crearUbicacion(ubicacion1);
    }
    
    @Test
    public void pruebaObtenerUbicaciones(){
        pruebaCrearUbicacion();
        List<Ubicacion> listaUbicaciones = ubicacionDAO.obtenerUbicaciones();
        
        assertEquals(1, listaUbicaciones.get(0).getId_ubicacion());
        assertEquals("Deposito", listaUbicaciones.get(0).getNombre_ubicacion());
        assertEquals(2, listaUbicaciones.get(1).getId_ubicacion());
        assertEquals("Piso 1", listaUbicaciones.get(1).getNombre_ubicacion());
    }
    
    @Test
    public void pruebaObtenerUbicacion(){
        pruebaCrearUbicacion();
        Ubicacion ubicacion = ubicacionDAO.obtenerUbicacion(1);
        assertEquals(1, ubicacion.getId_ubicacion());
        assertEquals("Deposito", ubicacion.getNombre_ubicacion());
    }
    
    @Test
    public void pruebaModificarUbicaciones(){
        pruebaCrearUbicacion();
        Ubicacion ubicacion1 = new Ubicacion(1, "Mostrador", new ArrayList<>());
        Ubicacion ubicacion2 = new Ubicacion(2, "Vitrina", new ArrayList<>());
        ubicacionDAO.actualizarUbicacion(ubicacion1);
        ubicacionDAO.actualizarUbicacion(ubicacion2);
        List<Ubicacion> listaUbicaciones = ubicacionDAO.obtenerUbicaciones();
        
        assertEquals(1, listaUbicaciones.get(0).getId_ubicacion());
        assertEquals("Mostrador", listaUbicaciones.get(0).getNombre_ubicacion());
        assertEquals(2, listaUbicaciones.get(1).getId_ubicacion());
        assertEquals("Vitrina", listaUbicaciones.get(1).getNombre_ubicacion());
    }
    
    @Test
    public void pruebaEliminarUbicaciones(){
        pruebaCrearUbicacion();
        ubicacionDAO.eliminarUbicacion(1);
        List<Ubicacion> listaUbicaciones = ubicacionDAO.obtenerUbicaciones();
        assertEquals(1, listaUbicaciones.size());
        assertEquals(2, listaUbicaciones.get(0).getId_ubicacion());
    }
}
