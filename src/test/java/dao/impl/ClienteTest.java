package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
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

public class ClienteTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    private static ClienteDAOImpl clienteDAO;
    
    public ClienteTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        clienteDAO = new ClienteDAOImpl(connection);
    }
    
    @AfterAll
    public static void tearDownClass() {
        conexionDataBase.cerrarConexion(connection);
    }
    
    @BeforeEach
    public void setUp() {
        configuracion = new ConfiguracionDataBase(connection);
        configuracion.crearTablaCliente();
    }
    
    @AfterEach
    public void tearDown() {
        configuracion.eliminarTablaCliente();
    }

    @Test
    public void pruebaCrearCliente(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Carlos");
        cliente.setApellido("Perez");
        cliente.setTelefono("3834123456");
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Maria");
        cliente1.setApellido("Carrizo");
        cliente1.setTelefono("3834654321");
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
        assertEquals(2, listaClientes.get(1).getId_cliente());
        assertEquals("Maria", listaClientes.get(1).getNombre());
        assertEquals("Carrizo", listaClientes.get(1).getApellido());
        assertEquals("3834654321", listaClientes.get(1).getTelefono());
    }
    
    @Test
    public void pruebaObtenerCliente(){
        pruebaCrearCliente();
        Cliente cliente = clienteDAO.obtenerCliente(2);
        assertEquals(2, cliente.getId_cliente());
        assertEquals("Maria", cliente.getNombre());
        assertEquals("Carrizo", cliente.getApellido());
        assertEquals("3834654321", cliente.getTelefono());
    }
    
    @Test
    public void pruebaModificarClientes(){
        pruebaCrearCliente();
        List<Venta> listaVentas = null;
        List<Reparacion> listaReparaciones = null;
        Cliente cliente1 = new Cliente(1, "Mauro", "Ayosa", "3834654987", listaVentas, listaReparaciones);
        Cliente cliente2 = new Cliente(2, "Cristian", "Quiroga", "3834987654", listaVentas, listaReparaciones);
        clienteDAO.actualizarCliente(cliente1);
        clienteDAO.actualizarCliente(cliente2);
        List<Cliente> listaClientes = clienteDAO.obtenerClientes();
        
        assertEquals(1, listaClientes.get(0).getId_cliente());
        assertEquals("Mauro", listaClientes.get(0).getNombre());
        assertEquals("Ayosa", listaClientes.get(0).getApellido());
        assertEquals("3834654987", listaClientes.get(0).getTelefono());
        assertEquals(2, listaClientes.get(1).getId_cliente());
        assertEquals("Cristian", listaClientes.get(1).getNombre());
        assertEquals("Quiroga", listaClientes.get(1).getApellido());
        assertEquals("3834987654", listaClientes.get(1).getTelefono());
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
