package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.List;
import model.Estado;
import model.Reparacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstadoTest {
    
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
    
    public EstadoTest() {
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
    public void pruebaCrearEstado(){
        Estado estado = new Estado();
        estado.setNombre_estado("Recibido");
        Estado estado1 = new Estado();
        estado1.setNombre_estado("Presupuesto");
        estadoDAO.crearEstado(estado);
        estadoDAO.crearEstado(estado1);
    }
    
    @Test
    public void pruebaObtenerEstados(){
        pruebaCrearEstado();
        List<Estado> listaEstados = estadoDAO.obtenerEstados();
        
        assertEquals(1, listaEstados.get(0).getId_estado());
        assertEquals("Recibido", listaEstados.get(0).getNombre_estado());
        assertEquals(2, listaEstados.get(1).getId_estado());
        assertEquals("Presupuesto", listaEstados.get(1).getNombre_estado());
    }
    
    @Test
    public void pruebaObtenerEstado(){
        pruebaCrearEstado();
        Estado estado = estadoDAO.obtenerEstado(1);
        assertEquals(1, estado.getId_estado());
        assertEquals("Recibido", estado.getNombre_estado());
    }
    
    @Test
    public void pruebaModificarEstados(){
        pruebaCrearEstado();
        List<Reparacion> listaReparaciones = null;
        Estado estado1 = new Estado(1, "Entregado", listaReparaciones);
        Estado estado2 = new Estado(2, "Devuelto", listaReparaciones);
        estadoDAO.actualizarEstado(estado1);
        estadoDAO.actualizarEstado(estado2);
        List<Estado> listaEstados = estadoDAO.obtenerEstados();
        
        assertEquals(1, listaEstados.get(0).getId_estado());
        assertEquals("Entregado", listaEstados.get(0).getNombre_estado());
        assertEquals(2, listaEstados.get(1).getId_estado());
        assertEquals("Devuelto", listaEstados.get(1).getNombre_estado());
    }
    
    @Test
    public void pruebaEliminarEstados(){
        pruebaCrearEstado();
        estadoDAO.eliminarEstado(1);
        List<Estado> listaEstados = estadoDAO.obtenerEstados();
        assertEquals(1, listaEstados.size());
        assertEquals(2, listaEstados.get(0).getId_estado());
    }
}
