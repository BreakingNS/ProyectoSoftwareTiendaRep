package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import model.Cliente;
import model.Venta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VentaTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    private static VentaDAOImpl ventaDAO;
    private static ClienteDAOImpl clienteDAO;
    
    public VentaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        ventaDAO = new VentaDAOImpl(connection);
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
        configuracion.crearTablaVenta();
    }
    
    @AfterEach
    public void tearDown() {
        configuracion.eliminarTablaVenta();
        configuracion.eliminarTablaCliente();
    }
    
    @Test
    public void pruebaCrearTablas(){
        
    }

    @Test
    public void pruebaCrearVenta(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Carlos");
        cliente.setApellido("Perez");
        cliente.setTelefono("3834123456");
        clienteDAO.crearCliente(cliente);
        
        cliente = clienteDAO.obtenerCliente(1);
        
        Venta venta = new Venta();
        venta.setCantidad(5);
        venta.setFecha_venta(new Date());
        venta.setPrecioFinal(new BigDecimal("9000"));
        venta.setCliente(cliente);
        
        Venta venta1 = new Venta();
        venta1.setCantidad(10);
        venta1.setFecha_venta(new Date());
        venta1.setPrecioFinal(new BigDecimal("3000"));
        venta1.setCliente(cliente);
        
        ventaDAO.crearVenta(venta);
        ventaDAO.crearVenta(venta1);
    }
    
    @Test
    public void pruebaObtenerVentas(){
        pruebaCrearVenta();
        List<Venta> listaVentas = ventaDAO.obtenerVentas();
        System.out.println("fecha hoy : " + listaVentas.get(0).getFecha_venta());
        
        assertEquals(1, listaVentas.get(0).getId_venta());
        assertEquals(5, listaVentas.get(0).getCantidad());
        assertEquals("2024-09-04", listaVentas.get(0).getFecha_venta().toString());
        assertEquals("9000.00", listaVentas.get(0).getPrecioFinal().toString());
        assertEquals(1, listaVentas.get(0).getCliente().getId_cliente());
        
        assertEquals(2, listaVentas.get(1).getId_venta());
        assertEquals(10, listaVentas.get(1).getCantidad());
        assertEquals("2024-09-04", listaVentas.get(1).getFecha_venta().toString());
        assertEquals("3000.00", listaVentas.get(1).getPrecioFinal().toString());
        assertEquals(1, listaVentas.get(1).getCliente().getId_cliente());
    }
    
    @Test
    public void pruebaObtenerVenta(){
        pruebaCrearVenta();
        Venta venta = ventaDAO.obtenerVenta(1);
        
        assertEquals(1, venta.getId_venta());
        assertEquals(5, venta.getCantidad());
        assertEquals("2024-09-04", venta.getFecha_venta().toString());
        assertEquals("9000.00", venta.getPrecioFinal().toString());
        assertEquals(1, venta.getCliente().getId_cliente());
    }
    
    @Test
    public void pruebaModificarVentas(){
        pruebaCrearVenta();
        
        Venta venta = ventaDAO.obtenerVenta(1);
        venta.setCantidad(15);
        venta.setPrecioFinal(new BigDecimal("19000"));
        
        Venta venta1 = ventaDAO.obtenerVenta(2);
        venta1.setCantidad(110);
        venta1.setPrecioFinal(new BigDecimal("13000"));
        
        ventaDAO.actualizarVenta(venta);
        ventaDAO.actualizarVenta(venta1);
        
        List<Venta> listaVentas = ventaDAO.obtenerVentas();
        
        assertEquals(1, listaVentas.get(0).getId_venta());
        assertEquals(15, listaVentas.get(0).getCantidad());
        assertEquals("2024-09-04", listaVentas.get(0).getFecha_venta().toString());
        assertEquals("19000.00", listaVentas.get(0).getPrecioFinal().toString());
        assertEquals(1, listaVentas.get(0).getCliente().getId_cliente());
        
        assertEquals(2, listaVentas.get(1).getId_venta());
        assertEquals(110, listaVentas.get(1).getCantidad());
        assertEquals("2024-09-04", listaVentas.get(1).getFecha_venta().toString());
        assertEquals("13000.00", listaVentas.get(1).getPrecioFinal().toString());
        assertEquals(1, listaVentas.get(1).getCliente().getId_cliente());
    }
    
    @Test
    public void pruebaEliminarVentas(){
        pruebaCrearVenta();
        ventaDAO.eliminarVenta(1);
        
        List<Venta> listaVentas = ventaDAO.obtenerVentas();
        
        assertEquals(1, listaVentas.size());
        assertEquals(10, listaVentas.get(0).getCantidad());
    }
}
