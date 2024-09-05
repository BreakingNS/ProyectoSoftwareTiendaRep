package dao.impl;
/*
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

public class VentaTestFALLADO {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    //private static VentaDAOImpl ventaDAO;
    //private static ClienteDAOImpl clienteDAO;
    
    public VentaTestFALLADO() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        //clienteDAO = new ClienteDAOImpl(connection);
        //ventaDAO = new VentaDAOImpl(connection);
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
        assertEquals(1, 1);
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
    //
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
        Venta venta1 = new Venta(1, "Peugeot");
        Venta venta2 = new Venta(2, "Citroen");
        ventaDAO.actualizarVenta(venta1);
        ventaDAO.actualizarVenta(venta2);
        List<Venta> listaVentas = ventaDAO.obtenerVentas();
        
        assertEquals(1, listaVentas.get(0).getId_venta());
        assertEquals("Peugeot", listaVentas.get(0).getNombre_venta());
        assertEquals(2, listaVentas.get(1).getId_venta());
        assertEquals("Citroen", listaVentas.get(1).getNombre_venta());
    }
    
    @Test
    public void pruebaEliminarVentas(){
        pruebaCrearVenta();
        ventaDAO.eliminarVenta(1);
        List<Venta> listaVentas = ventaDAO.obtenerVentas();
        assertEquals(1, listaVentas.size());
        assertEquals(2, listaVentas.get(0).getId_venta());
    }
    
}*/
