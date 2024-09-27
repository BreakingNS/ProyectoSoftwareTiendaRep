package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.math.BigDecimal;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

public class VentaDAOImplTest {
    
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
    
    public VentaDAOImplTest() {
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
    public void pruebaCrearVenta(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Carlos");
        cliente.setApellido("Perez");
        cliente.setTelefono("3834123456");
        clienteDAO.crearCliente(cliente);
        
        cliente = clienteDAO.obtenerCliente(1);
        
        LocalDateTime ahora = LocalDateTime.now();
        
        Venta venta = new Venta();
        venta.setCantidad(5);
        venta.setFecha_venta(ahora);
        venta.setPrecioFinal(new BigDecimal("9000"));
        venta.setCliente(cliente);
        
        Venta venta1 = new Venta();
        venta1.setCantidad(10);
        venta1.setFecha_venta(ahora);
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
        LocalDate fechaEsperada = new java.sql.Date(new Date().getTime()).toLocalDate();
        LocalDate fechaVenta = listaVentas.get(0).getFecha_venta().toLocalDate();
        assertEquals(fechaEsperada, fechaVenta);
        assertEquals("9000.00", listaVentas.get(0).getPrecioFinal().toString());
        assertEquals(1, listaVentas.get(0).getCliente().getId_cliente());
        
        assertEquals(2, listaVentas.get(1).getId_venta());
        assertEquals(10, listaVentas.get(1).getCantidad());
        fechaEsperada = new java.sql.Date(new Date().getTime()).toLocalDate();
        fechaVenta = listaVentas.get(1).getFecha_venta().toLocalDate();
        assertEquals(fechaEsperada, fechaVenta);
        assertEquals("3000.00", listaVentas.get(1).getPrecioFinal().toString());
        assertEquals(1, listaVentas.get(1).getCliente().getId_cliente());
    }
    
    @Test
    public void pruebaObtenerVentasPorIdCliente(){
        pruebaCrearVenta();
        List<Venta> listaVentas = ventaDAO.obtenerVentasPorIdCliente(1);
        
        String ahora = new java.sql.Date(new Date().getTime()).toString();
        
        assertEquals(1, listaVentas.get(0).getId_venta());
        assertEquals(5, listaVentas.get(0).getCantidad());
        LocalDate fechaEsperada = new java.sql.Date(new Date().getTime()).toLocalDate();
        LocalDate fechaVenta = listaVentas.get(0).getFecha_venta().toLocalDate();
        assertEquals(fechaEsperada, fechaVenta);
        assertEquals("9000.00", listaVentas.get(0).getPrecioFinal().toString());
        assertEquals(1, listaVentas.get(0).getCliente().getId_cliente());
        
        assertEquals(2, listaVentas.get(1).getId_venta());
        assertEquals(10, listaVentas.get(1).getCantidad());
        fechaEsperada = new java.sql.Date(new Date().getTime()).toLocalDate();
        fechaVenta = listaVentas.get(1).getFecha_venta().toLocalDate();
        assertEquals(fechaEsperada, fechaVenta);
        assertEquals("3000.00", listaVentas.get(1).getPrecioFinal().toString());
        assertEquals(1, listaVentas.get(1).getCliente().getId_cliente());
    }
    
    @Test
    public void pruebaObtenerVenta(){
        pruebaCrearVenta();
        Venta venta = ventaDAO.obtenerVenta(1);
        
        String ahora = new java.sql.Date(new Date().getTime()).toString();
        
        assertEquals(1, venta.getId_venta());
        assertEquals(5, venta.getCantidad());
        LocalDate fechaEsperada = new java.sql.Date(new Date().getTime()).toLocalDate();
        LocalDate fechaVenta = venta.getFecha_venta().toLocalDate();
        assertEquals(fechaEsperada, fechaVenta);
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
        
        String ahora = new java.sql.Date(new Date().getTime()).toString();
        
        assertEquals(1, listaVentas.get(0).getId_venta());
        assertEquals(15, listaVentas.get(0).getCantidad());
        LocalDate fechaEsperada = new java.sql.Date(new Date().getTime()).toLocalDate();
        LocalDate fechaVenta = listaVentas.get(0).getFecha_venta().toLocalDate();
        assertEquals(fechaEsperada, fechaVenta);
        assertEquals("19000.00", listaVentas.get(0).getPrecioFinal().toString());
        assertEquals(1, listaVentas.get(0).getCliente().getId_cliente());
        
        assertEquals(2, listaVentas.get(1).getId_venta());
        assertEquals(110, listaVentas.get(1).getCantidad());
        fechaEsperada = new java.sql.Date(new Date().getTime()).toLocalDate();
        fechaVenta = listaVentas.get(1).getFecha_venta().toLocalDate();
        assertEquals(fechaEsperada, fechaVenta);
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