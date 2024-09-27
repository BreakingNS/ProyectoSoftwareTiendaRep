package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Reparacion;
import model.Venta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteDAOImplTest {
    
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
    
    public ClienteDAOImplTest() {
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
    public void pruebaCrearCliente(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Carlos");
        cliente.setApellido("Perez");
        cliente.setTelefono("3834123456");
        cliente.setDomicilio("Achachay");
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Maria");
        cliente1.setApellido("Carrizo");
        cliente1.setTelefono("3834654321");
        cliente1.setDomicilio("Parque Norte");
        clienteDAO.crearCliente(cliente);
        clienteDAO.crearCliente(cliente1);
    }
    
    @Test
    public void pruebaObtenerClientes(){
        pruebaCrearCliente();
        List<Cliente> listaClientes = clienteDAO.obtenerClientes();
        
        assertEquals(1, listaClientes.get(0).getId_cliente());
        assertEquals("Carlos", listaClientes.get(0).getNombre());
        assertEquals("Perez", listaClientes.get(0).getApellido());
        assertEquals("3834123456", listaClientes.get(0).getTelefono());
        assertEquals("Achachay", listaClientes.get(0).getDomicilio());
        assertEquals(2, listaClientes.get(1).getId_cliente());
        assertEquals("Maria", listaClientes.get(1).getNombre());
        assertEquals("Carrizo", listaClientes.get(1).getApellido());
        assertEquals("3834654321", listaClientes.get(1).getTelefono());
        assertEquals("Parque Norte", listaClientes.get(1).getDomicilio());
    }
    
    @Test
    public void pruebaObtenerCliente(){
        pruebaCrearCliente();
        Cliente cliente = clienteDAO.obtenerCliente(2);
        assertEquals(2, cliente.getId_cliente());
        assertEquals("Maria", cliente.getNombre());
        assertEquals("Carrizo", cliente.getApellido());
        assertEquals("3834654321", cliente.getTelefono());
        assertEquals("Parque Norte", cliente.getDomicilio());
    }
    
    @Test
    public void buscarCliente(){
        pruebaCrearCliente();
        Cliente cliente = new Cliente(0, "", "", "", "Norte", new ArrayList<>(), new ArrayList<>());
        List<Cliente> listaClientes = clienteDAO.buscarCliente(cliente);
        
        assertEquals(1, listaClientes.size());
        assertEquals("Maria", listaClientes.get(0).getNombre());
        
    }
    
    @Test
    public void pruebaModificarClientes(){
        pruebaCrearCliente();
        List<Venta> listaVentas = null;
        List<Reparacion> listaReparaciones = null;
        Cliente cliente1 = new Cliente(1, "Mauro", "Ayosa", "3834654987", "Malvinas", listaVentas, listaReparaciones);
        Cliente cliente2 = new Cliente(2, "Cristian", "Quiroga", "3834987654", "Jumeal", listaVentas, listaReparaciones);
        clienteDAO.actualizarCliente(cliente1);
        clienteDAO.actualizarCliente(cliente2);
        List<Cliente> listaClientes = clienteDAO.obtenerClientes();
        
        assertEquals(1, listaClientes.get(0).getId_cliente());
        assertEquals("Mauro", listaClientes.get(0).getNombre());
        assertEquals("Ayosa", listaClientes.get(0).getApellido());
        assertEquals("3834654987", listaClientes.get(0).getTelefono());
        assertEquals("Malvinas", listaClientes.get(0).getDomicilio());
        assertEquals(2, listaClientes.get(1).getId_cliente());
        assertEquals("Cristian", listaClientes.get(1).getNombre());
        assertEquals("Quiroga", listaClientes.get(1).getApellido());
        assertEquals("3834987654", listaClientes.get(1).getTelefono());
        assertEquals("Jumeal", listaClientes.get(1).getDomicilio());
    }
    
    @Test
    public void pruebaEliminarClientes(){
        pruebaCrearCliente();
        clienteDAO.eliminarCliente(1);
        List<Cliente> listaClientes = clienteDAO.obtenerClientes();
        assertEquals(1, listaClientes.size());
        assertEquals(2, listaClientes.get(0).getId_cliente());
    }
}