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
import dao.impl.ReparacionRepuestoDAOImpl;
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

public class ReparacionServiceTest {
    
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
    private static ReparacionRepuestoDAOImpl reparacionRepuestoDAO;
    
    private static ReparacionService reparacionService;
    private static VentaRepuestoDAOImpl ventaRepuestoDAO;
    
    public ReparacionServiceTest() {
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
        reparacionRepuestoDAO = new ReparacionRepuestoDAOImpl(connection);
        ventaRepuestoDAO = new VentaRepuestoDAOImpl(connection);
        
        reparacionService = new ReparacionService(reparacionDAO, repuestoDAO, reparacionRepuestoDAO, connection);
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
    public void agregarReparacion(){
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
        Reparacion reparacion1 = new Reparacion(1, new BigDecimal("3000"), "Rota la tapa", new Date(), new Date(), categoria, cliente, estado);
        Reparacion reparacion2 = new Reparacion(2, new BigDecimal("9000"), "Color plateado", new Date(), new Date(), categoria1, cliente1, estado1);
        Reparacion reparacion3 = new Reparacion(1, new BigDecimal("3000"), "Rota la tapa", new Date(), new Date(), categoria, cliente, estado);
        Reparacion reparacion4 = new Reparacion(2, new BigDecimal("9000"), "Color plateado", new Date(), new Date(), categoria1, cliente1, estado1);
        reparacionDAO.crearReparacion(reparacion1);
        reparacionDAO.crearReparacion(reparacion2);
        reparacionDAO.crearReparacion(reparacion3);
        reparacionDAO.crearReparacion(reparacion4);        
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
        //Reparacion-Repuesto
        /*
        reparacionRepuestoDAO.crearReparacionRepuesto(reparacion1, listaRepuestos1);
        reparacionRepuestoDAO.crearReparacionRepuesto(reparacion2, listaRepuestos2);
        reparacionRepuestoDAO.crearReparacionRepuesto(reparacion3, listaRepuestos3);
        reparacionRepuestoDAO.crearReparacionRepuesto(reparacion4, listaRepuestos4);
        */
    }
    
    @Test
    public void listarReparaciones(){
        agregarReparacion();
        List<Reparacion> listaReparaciones = reparacionService.listarReparaciones();
        
        assertEquals(1, listaReparaciones.get(0).getId_reparacion());
        assertEquals("Rota la tapa", listaReparaciones.get(0).getDetalles());
    
        assertEquals(2, listaReparaciones.get(1).getId_reparacion());
        assertEquals("Color plateado", listaReparaciones.get(1).getDetalles());
    
    }
    
    @Test
    public void obtenerReparacionPorId(){
        agregarReparacion();
        Reparacion reparacion = reparacionService.obtenerReparacionPorId(1);
        
        assertEquals(1, reparacion.getId_reparacion());
        assertEquals("Rota la tapa", reparacion.getDetalles());
    }
    
    @Test
    public void editarReparacion(){
        agregarReparacion();
        Reparacion reparacion = reparacionService.obtenerReparacionPorId(1);
        reparacion.setDetalles("No funciona la bocha");
        reparacionService.editarReparacion(reparacion);
        reparacion = null;
        reparacion = reparacionService.obtenerReparacionPorId(1);
        
        assertEquals(1, reparacion.getId_reparacion());
        assertEquals("No funciona la bocha", reparacion.getDetalles());
    }
    /*
    @Test
    public void eliminarReparacionPorId() throws SQLException{
        agregarReparacion();
        reparacionService.eliminarReparacionPorId(1);
        List<Reparacion> listaReparaciones = reparacionService.listarReparaciones();
        
        assertEquals(2, listaReparaciones.get(0).getId_reparacion());
        assertEquals("Color plateado", listaReparaciones.get(0).getDetalles());
    }
    */
    
    @Test
    public void nuevaReparacion() throws SQLException{
        agregarReparacion();
        Cliente cliente = clienteDAO.obtenerCliente(1);
        Categoria categoria = categoriaDAO.obtenerCategoria(1);
        Estado estado = estadoDAO.obtenerEstado(1);
        Date ahora = new Date();
        Reparacion reparacion1 = new Reparacion(0, new BigDecimal("3000"), "Sin patas traseras", ahora, ahora, categoria, cliente, estado);
        reparacionDAO.crearReparacion(reparacion1);
        reparacion1 = reparacionDAO.obtenerReparacion(5);
        
        assertEquals(5, reparacion1.getId_reparacion());
        assertEquals("3000.00", reparacion1.getCosto().toString());
        
        Repuesto repuesto1 = repuestoDAO.obtenerRepuesto(1);
        Repuesto repuesto2 = repuestoDAO.obtenerRepuesto(2);
        List<Repuesto> listaRepuestos = new ArrayList<>();
        listaRepuestos.add(repuesto1);
        listaRepuestos.add(repuesto2);
        
        //reparacionService.nuevaReparacion(reparacion1, listaRepuestos);
        repuesto1 = repuestoDAO.obtenerRepuesto(1);
        repuesto2 = repuestoDAO.obtenerRepuesto(2);
        
        assertEquals(9, repuesto1.getStock());
        assertEquals(19, repuesto2.getStock());
    }
    
}
