package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Tecnico;
import model.Reparacion;
import model.Venta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TecnicoDAOImplTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    
    private static MarcaDAOImpl marcaDAO;
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    private static ModeloDAOImpl modeloDAO;
    private static UbicacionDAOImpl ubicacionDAO;
    private static CategoriaDAOImpl categoriaDAO;
    private static EstadoDAOImpl estadoDAO;
    private static PagadoDAOImpl pagadoDAO;
    private static ClienteDAOImpl clienteDAO;
    private static TecnicoDAOImpl tecnicoDAO;
    private static RepuestoDAOImpl repuestoDAO;
    private static PrecioDAOImpl precioDAO;
    private static ReparacionDAOImpl reparacionDAO;
    private static VentaDAOImpl ventaDAO;
    
    public TecnicoDAOImplTest() {
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
        pagadoDAO = new PagadoDAOImpl(connection);
        clienteDAO = new ClienteDAOImpl(connection);
        tecnicoDAO = new TecnicoDAOImpl(connection);
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
        configuracion.crearTablaPagado();
        configuracion.crearTablaCliente();
        configuracion.crearTablaTecnico();
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
        configuracion.eliminarTablaTecnico();
        configuracion.eliminarTablaCliente();
        configuracion.eliminarTablaPagado();
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
        configuracion.eliminarTablaTecnico();
        configuracion.eliminarTablaCliente();
        configuracion.eliminarTablaPagado();
        configuracion.eliminarTablaEstado();
        configuracion.eliminarTablaCategoria();
        configuracion.eliminarTablaUbicacion();
        configuracion.eliminarTablaModelo();
        configuracion.eliminarTablaNombreRepuesto();
        configuracion.eliminarTablaMarca();
    }

    @Test
    public void pruebaCrearTecnico(){
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre_tecnico("Carlos");
        tecnico.setApellido_tecnico("Perez");
        tecnico.setTelefono_tecnico("3834123456");
        tecnico.setDomicilio_tecnico("Achachay");
        Tecnico tecnico1 = new Tecnico();
        tecnico1.setNombre_tecnico("Maria");
        tecnico1.setApellido_tecnico("Carrizo");
        tecnico1.setTelefono_tecnico("3834654321");
        tecnico1.setDomicilio_tecnico("Parque Norte");
        tecnicoDAO.crearTecnico(tecnico);
        tecnicoDAO.crearTecnico(tecnico1);
    }
    
    @Test
    public void pruebaObtenerTecnicos(){
        pruebaCrearTecnico();
        List<Tecnico> listaTecnicos = tecnicoDAO.obtenerTecnicos();
        
        assertEquals(1, listaTecnicos.get(0).getId_tecnico());
        assertEquals("Carlos", listaTecnicos.get(0).getNombre_tecnico());
        assertEquals("Perez", listaTecnicos.get(0).getApellido_tecnico());
        assertEquals("3834123456", listaTecnicos.get(0).getTelefono_tecnico());
        assertEquals("Achachay", listaTecnicos.get(0).getDomicilio_tecnico());
        assertEquals(2, listaTecnicos.get(1).getId_tecnico());
        assertEquals("Maria", listaTecnicos.get(1).getNombre_tecnico());
        assertEquals("Carrizo", listaTecnicos.get(1).getApellido_tecnico());
        assertEquals("3834654321", listaTecnicos.get(1).getTelefono_tecnico());
        assertEquals("Parque Norte", listaTecnicos.get(1).getDomicilio_tecnico());
    }
    
    @Test
    public void pruebaObtenerTecnico(){
        pruebaCrearTecnico();
        Tecnico tecnico = tecnicoDAO.obtenerTecnico(2);
        assertEquals(2, tecnico.getId_tecnico());
        assertEquals("Maria", tecnico.getNombre_tecnico());
        assertEquals("Carrizo", tecnico.getApellido_tecnico());
        assertEquals("3834654321", tecnico.getTelefono_tecnico());
        assertEquals("Parque Norte", tecnico.getDomicilio_tecnico());
    }
    
    @Test
    public void buscarTecnico(){
        pruebaCrearTecnico();
        Tecnico tecnico = new Tecnico(0, "", "", "", "Norte", new ArrayList<>());
        List<Tecnico> listaTecnicos = tecnicoDAO.buscarTecnico(tecnico);
        
        assertEquals(1, listaTecnicos.size());
        assertEquals("Maria", listaTecnicos.get(0).getNombre_tecnico());
        
    }
    
    @Test
    public void pruebaModificarTecnicos(){
        pruebaCrearTecnico();
        List<Venta> listaVentas = null;
        List<Reparacion> listaReparaciones = null;
        Tecnico tecnico1 = new Tecnico(1, "Mauro", "Ayosa", "3834654987", "Malvinas", listaReparaciones);
        Tecnico tecnico2 = new Tecnico(2, "Cristian", "Quiroga", "3834987654", "Jumeal", listaReparaciones);
        tecnicoDAO.actualizarTecnico(tecnico1);
        tecnicoDAO.actualizarTecnico(tecnico2);
        List<Tecnico> listaTecnicos = tecnicoDAO.obtenerTecnicos();
        
        assertEquals(1, listaTecnicos.get(0).getId_tecnico());
        assertEquals("Mauro", listaTecnicos.get(0).getNombre_tecnico());
        assertEquals("Ayosa", listaTecnicos.get(0).getApellido_tecnico());
        assertEquals("3834654987", listaTecnicos.get(0).getTelefono_tecnico());
        assertEquals("Malvinas", listaTecnicos.get(0).getDomicilio_tecnico());
        assertEquals(2, listaTecnicos.get(1).getId_tecnico());
        assertEquals("Cristian", listaTecnicos.get(1).getNombre_tecnico());
        assertEquals("Quiroga", listaTecnicos.get(1).getApellido_tecnico());
        assertEquals("3834987654", listaTecnicos.get(1).getTelefono_tecnico());
        assertEquals("Jumeal", listaTecnicos.get(1).getDomicilio_tecnico());
    }
    
    @Test
    public void pruebaEliminarTecnicos(){
        pruebaCrearTecnico();
        tecnicoDAO.eliminarTecnico(1);
        List<Tecnico> listaTecnicos = tecnicoDAO.obtenerTecnicos();
        assertEquals(1, listaTecnicos.size());
        assertEquals(2, listaTecnicos.get(0).getId_tecnico());
    }
}
