package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.List;
import model.Cliente;
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
        cliente.setNombre_cliente("Fiat");
        Cliente cliente1 = new Cliente();
        cliente1.setNombre_cliente("Renault");
        clienteDAO.crearCliente(cliente);
        clienteDAO.crearCliente(cliente1);
    }
    
    @Test
    public void pruebaObtenerClientes(){
        pruebaCrearCliente();
        List<Cliente> listaClientes = clienteDAO.obtenerClientes();
        
        assertEquals(1, listaClientes.get(0).getId_cliente());
        assertEquals("Fiat", listaClientes.get(0).getNombre_cliente());
        assertEquals(2, listaClientes.get(1).getId_cliente());
        assertEquals("Renault", listaClientes.get(1).getNombre_cliente());
    }
    
    @Test
    public void pruebaObtenerCliente(){
        pruebaCrearCliente();
        Cliente cliente = clienteDAO.obtenerCliente(1);
        assertEquals(1, cliente.getId_cliente());
        assertEquals("Fiat", cliente.getNombre_cliente());
    }
    
    @Test
    public void pruebaModificarClientes(){
        pruebaCrearCliente();
        Cliente cliente1 = new Cliente(1, "Peugeot");
        Cliente cliente2 = new Cliente(2, "Citroen");
        clienteDAO.actualizarCliente(cliente1);
        clienteDAO.actualizarCliente(cliente2);
        List<Cliente> listaClientes = clienteDAO.obtenerClientes();
        
        assertEquals(1, listaClientes.get(0).getId_cliente());
        assertEquals("Peugeot", listaClientes.get(0).getNombre_cliente());
        assertEquals(2, listaClientes.get(1).getId_cliente());
        assertEquals("Citroen", listaClientes.get(1).getNombre_cliente());
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
