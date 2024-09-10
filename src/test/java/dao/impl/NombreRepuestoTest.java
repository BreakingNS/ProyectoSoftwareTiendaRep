package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.List;
import model.NombreRepuesto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NombreRepuestoTest {
    
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
    
    public NombreRepuestoTest() {
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
    public void pruebaCrearNombreRepuesto(){
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(2, "Fuente");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
    }
    
    @Test
    public void pruebaObtenerNombreRepuestos(){
        pruebaCrearNombreRepuesto();
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoDAO.obtenerNombreRepuestos();
        
        assertEquals(1, listaNombreRepuestos.get(0).getId_nombrerepuesto());
        assertEquals("Bobina", listaNombreRepuestos.get(0).getNombre_repuesto());
        assertEquals(2, listaNombreRepuestos.get(1).getId_nombrerepuesto());
        assertEquals("Fuente", listaNombreRepuestos.get(1).getNombre_repuesto());
    }
    
    @Test
    public void pruebaObtenerNombreRepuesto(){
        pruebaCrearNombreRepuesto();
        NombreRepuesto nombreRepuesto = nombreRepuestoDAO.obtenerNombreRepuesto(1);
        assertEquals(1, nombreRepuesto.getId_nombrerepuesto());
        assertEquals("Bobina", nombreRepuesto.getNombre_repuesto());
    }
    
    @Test
    public void pruebaModificarNombreRepuestos(){
        pruebaCrearNombreRepuesto();
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(1, "Sensor");
        NombreRepuesto nombreRepuesto2 = new NombreRepuesto(2, "Termostato");
        nombreRepuestoDAO.actualizarNombreRepuesto(nombreRepuesto1);
        nombreRepuestoDAO.actualizarNombreRepuesto(nombreRepuesto2);
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoDAO.obtenerNombreRepuestos();
        assertEquals(1, listaNombreRepuestos.get(0).getId_nombrerepuesto());
        assertEquals("Sensor", listaNombreRepuestos.get(0).getNombre_repuesto());
        assertEquals(2, listaNombreRepuestos.get(1).getId_nombrerepuesto());
        assertEquals("Termostato", listaNombreRepuestos.get(1).getNombre_repuesto());
    }
    
    @Test
    public void pruebaEliminarNombreRepuestos(){
        pruebaCrearNombreRepuesto();
        nombreRepuestoDAO.eliminarNombreRepuesto(1);
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoDAO.obtenerNombreRepuestos();
        assertEquals(1, listaNombreRepuestos.size());
        assertEquals(2, listaNombreRepuestos.get(0).getId_nombrerepuesto());
    }
}
