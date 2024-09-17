package service;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import dao.impl.CategoriaDAOImpl;
import dao.impl.ClienteDAOImpl;
import dao.impl.EstadoDAOImpl;
import dao.impl.MarcaDAOImpl;
import dao.impl.NombreRepuestoDAOImpl;
import dao.impl.PrecioDAOImpl;
import dao.impl.ReparacionDAOImpl;
import dao.impl.RepuestoDAOImpl;
import dao.impl.UbicacionDAOImpl;
import dao.impl.VentaDAOImpl;
import dao.impl.VentaRepuestoDAOImpl;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Categoria;
import model.Cliente;
import model.Estado;
import model.Marca;
import model.NombreRepuesto;
import model.Precio;
import model.Reparacion;
import model.Repuesto;
import model.Ubicacion;
import model.Venta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VentaServiceTest {
    
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
    private static VentaRepuestoDAOImpl ventaRepuestoDAO;
    
    private static VentaService ventaService;
    
    public VentaServiceTest() {
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
        ventaRepuestoDAO = new VentaRepuestoDAOImpl(connection);
        
        ventaService = new VentaService(ventaDAO, repuestoDAO, ventaRepuestoDAO, connection);
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
    public void agregarVenta(){
        //Marca
        Marca marca = new Marca(1, "Fiat", new ArrayList<>());
        Marca marca1 = new Marca(2, "Renault", new ArrayList<>());
        marcaDAO.crearMarca(marca);
        marcaDAO.crearMarca(marca1);
        //NombreRepuesto +
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto2 = new NombreRepuesto(2, "Fuente");
        NombreRepuesto nombreRepuesto3 = new NombreRepuesto(1, "Compresor");
        NombreRepuesto nombreRepuesto4 = new NombreRepuesto(2, "Fusible");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto2);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto3);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto4);
        //Ubicacion 
        Ubicacion ubicacion = new Ubicacion(1, "Deposito", new ArrayList<>());
        Ubicacion ubicacion1 = new Ubicacion(2, "Piso 1", new ArrayList<>());
        ubicacionDAO.crearUbicacion(ubicacion);
        ubicacionDAO.crearUbicacion(ubicacion1);
        //Categoria
        Categoria categoria = new Categoria(1, "Lavarropas", new ArrayList<>(), new ArrayList<>());
        Categoria categoria1 = new Categoria(2, "Heladera", new ArrayList<>(), new ArrayList<>());
        categoriaDAO.crearCategoria(categoria);
        categoriaDAO.crearCategoria(categoria1);
        //Estado
        Estado estado = new Estado(1, "Recibido", new ArrayList<>());
        Estado estado1 = new Estado(2, "Presupuesto", new ArrayList<>());
        estadoDAO.crearEstado(estado);
        estadoDAO.crearEstado(estado1);
        //Cliente
        Cliente cliente = new Cliente(1, "Carlos", "Perez", "3834123456", new ArrayList<>(), new ArrayList<>());
        Cliente cliente1 = new Cliente(2, "Maria", "Carrizo", "3834654321", new ArrayList<>(), new ArrayList<>());
        clienteDAO.crearCliente(cliente);
        clienteDAO.crearCliente(cliente1);
        //Repuesto +
        Repuesto repuesto1 = new Repuesto(1, 10, nombreRepuesto1, marca, categoria, new ArrayList<>(), ubicacion);
        Repuesto repuesto2 = new Repuesto(2, 20, nombreRepuesto2, marca, categoria, new ArrayList<>(), ubicacion);
        Repuesto repuesto3 = new Repuesto(3, 40, nombreRepuesto3, marca1, categoria1, new ArrayList<>(), ubicacion1);
        Repuesto repuesto4 = new Repuesto(4, 50, nombreRepuesto4, marca1, categoria1, new ArrayList<>(), ubicacion1);
        repuestoDAO.crearRepuesto(repuesto1);
        repuestoDAO.crearRepuesto(repuesto2);
        repuestoDAO.crearRepuesto(repuesto3);
        repuestoDAO.crearRepuesto(repuesto4);
        //Precio
        Precio precio1 = new Precio(1, repuesto1, new Date(), new BigDecimal("3000"));
        Precio precio2 = new Precio(2, repuesto1, new Date(), new BigDecimal("4000"));
        Precio precio3 = new Precio(3, repuesto2, new Date(), new BigDecimal("7000"));
        Precio precio4 = new Precio(4, repuesto2, new Date(), new BigDecimal("8000"));
        Precio precio5 = new Precio(5, repuesto3, new Date(), new BigDecimal("9000"));
        Precio precio6 = new Precio(6, repuesto3, new Date(), new BigDecimal("10000"));
        Precio precio7 = new Precio(7, repuesto4, new Date(), new BigDecimal("15000"));
        Precio precio8 = new Precio(8, repuesto4, new Date(), new BigDecimal("18000"));
        precioDAO.crearPrecio(precio1);
        precioDAO.crearPrecio(precio2);
        precioDAO.crearPrecio(precio3);
        precioDAO.crearPrecio(precio4);
        precioDAO.crearPrecio(precio5);
        precioDAO.crearPrecio(precio6);
        precioDAO.crearPrecio(precio7);
        precioDAO.crearPrecio(precio8);
        //Reparacion
        Reparacion reparacion = new Reparacion(1, new BigDecimal("3000"), "Rota la tapa", new Date(), new Date(), categoria, cliente, estado);
        Reparacion reparacion1 = new Reparacion(2, new BigDecimal("9000"), "Color plateado", new Date(), new Date(), categoria1, cliente1, estado1);
        reparacionDAO.crearReparacion(reparacion);
        reparacionDAO.crearReparacion(reparacion1);
        //Venta
        Venta venta1 = new Venta(1, 20, new Date(), cliente, new BigDecimal("15000"));
        Venta venta2 = new Venta(2, 50, new Date(), cliente, new BigDecimal("40000"));
        Venta venta3 = new Venta(3, 10, new Date(), cliente1, new BigDecimal("9000"));
        Venta venta4 = new Venta(4, 40, new Date(), cliente1, new BigDecimal("50000"));
        ventaDAO.crearVenta(venta1);
        ventaDAO.crearVenta(venta2);
        ventaDAO.crearVenta(venta3);
        ventaDAO.crearVenta(venta4);
        //Listas Repuestos
        venta1 = ventaDAO.obtenerVenta(1);
        venta2 = ventaDAO.obtenerVenta(2);
        venta3 = ventaDAO.obtenerVenta(3);
        venta4 = ventaDAO.obtenerVenta(4);
        List<Repuesto> listaRepuestos1 = new ArrayList<>();
        listaRepuestos1.add(repuesto1);
        listaRepuestos1.add(repuesto1);
        listaRepuestos1.add(repuesto2);
        List<Repuesto> listaRepuestos2 = new ArrayList<>();
        listaRepuestos2.add(repuesto3);
        listaRepuestos2.add(repuesto4);
        List<Repuesto> listaRepuestos3 = new ArrayList<>();
        listaRepuestos3.add(repuesto2);
        List<Repuesto> listaRepuestos4 = new ArrayList<>();
        //Venta-Repuesto
        /*
        ventaRepuestoDAO.crearVentaRepuesto(venta1, listaRepuestos1);
        ventaRepuestoDAO.crearVentaRepuesto(venta2, listaRepuestos2);
        ventaRepuestoDAO.crearVentaRepuesto(venta3, listaRepuestos3);
        ventaRepuestoDAO.crearVentaRepuesto(venta4, listaRepuestos4);
        */
    }
    
    @Test
    public void listarVentas(){
        agregarVenta();
        List<Venta> listaVentas = ventaService.listarVentas();
        
        assertEquals(1, listaVentas.get(0).getId_venta());
        assertEquals(20, listaVentas.get(0).getCantidad());
        assertEquals("Perez", listaVentas.get(0).getCliente().getApellido());
        
        assertEquals(2, listaVentas.get(1).getId_venta());
        assertEquals(50, listaVentas.get(1).getCantidad());
        assertEquals("Perez", listaVentas.get(1).getCliente().getApellido());
    }
    
    @Test
    public void obtenerVentaPorId(){
        agregarVenta();
        Venta venta = ventaService.obtenerVentaPorId(2);
        
        assertEquals(2, venta.getId_venta());
        assertEquals(50, venta.getCantidad());
        assertEquals("Perez", venta.getCliente().getApellido());
    }
    
    @Test
    public void editarVenta(){
        agregarVenta();
        Cliente cliente = clienteDAO.obtenerCliente(1);
        Venta venta = new Venta(1, 5, new Date(), cliente, new BigDecimal("3500"));
        
        ventaService.editarVenta(venta);
        venta = ventaService.obtenerVentaPorId(1);
        
        assertEquals(1, venta.getId_venta());
        assertEquals(5, venta.getCantidad());
    }
    /*
    @Test
    public void eliminarVentaPorId(){
        agregarVenta();
        ventaService.eliminarVentaPorId(2);
        
        List<Venta> listaVentas = ventaService.listarVentas();
        
        assertEquals(2, listaVentas.get(0).getId_venta());
        assertEquals(50, listaVentas.get(0).getCantidad());
        assertEquals("Carrizo", listaVentas.get(0).getCliente().getApellido());
    }
    */
    @Test
    public void nuevaVenta() throws SQLException{
        agregarVenta();
        Cliente cliente = clienteDAO.obtenerCliente(1);
        Venta venta1 = new Venta(1, 4, new Date(), cliente, new BigDecimal("15000"));
        ventaDAO.crearVenta(venta1);
        venta1 = ventaDAO.obtenerVenta(5);
        
        assertEquals(5, venta1.getId_venta());
        assertEquals(4, venta1.getCantidad());
        
        Repuesto repuesto1 = repuestoDAO.obtenerRepuesto(1);
        Repuesto repuesto2 = repuestoDAO.obtenerRepuesto(2);
        List<Repuesto> listaRepuestos = new ArrayList<>();
        listaRepuestos.add(repuesto1);
        listaRepuestos.add(repuesto2);
        //ventaService.nuevaVenta(venta1, listaRepuestos);
        repuesto1 = repuestoDAO.obtenerRepuesto(1);
        repuesto2 = repuestoDAO.obtenerRepuesto(2);
        
        assertEquals(9, repuesto1.getStock());
        assertEquals(19, repuesto2.getStock());
    }
    
}
