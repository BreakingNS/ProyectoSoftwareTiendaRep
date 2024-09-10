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
import java.math.BigDecimal;
import java.sql.Connection;
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

public class RepuestoServiceTest {
    
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
    
    private static RepuestoService repuestoService;
    
    public RepuestoServiceTest() {
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
        
        repuestoService = new RepuestoService(repuestoDAO, precioDAO);
        
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
    public void agregarCliente(){
        //Marca
        Marca marca = new Marca(1, "Fiat", new ArrayList<>());
        Marca marca1 = new Marca(2, "Renault", new ArrayList<>());
        marcaDAO.crearMarca(marca);
        marcaDAO.crearMarca(marca1);
        //NombreRepuesto +
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(2, "Fuente");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
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
        Repuesto repuesto = new Repuesto(1, 10, nombreRepuesto, marca, categoria, new ArrayList<>(), ubicacion);
        Repuesto repuesto1 = new Repuesto(2, 20, nombreRepuesto1, marca1, categoria1, new ArrayList<>(), ubicacion1);
        repuestoService.agregarRepuesto(repuesto);
        repuestoService.agregarRepuesto(repuesto1);
        //Precio
        Precio precio1 = new Precio(1, repuesto, new Date(), new BigDecimal("3000"));
        Precio precio2 = new Precio(2, repuesto, new Date(), new BigDecimal("4000"));
        Precio precio3 = new Precio(3, repuesto1, new Date(), new BigDecimal("7000"));
        Precio precio4 = new Precio(4, repuesto1, new Date(), new BigDecimal("8000"));
        precioDAO.crearPrecio(precio1);
        precioDAO.crearPrecio(precio2);
        precioDAO.crearPrecio(precio3);
        precioDAO.crearPrecio(precio4);
        //Reparacion
        Reparacion reparacion = new Reparacion(1, new BigDecimal("3000"), "Rota la tapa", new Date(), new Date(), categoria, cliente, estado);
        Reparacion reparacion1 = new Reparacion(2, new BigDecimal("9000"), "Color plateado", new Date(), new Date(), categoria1, cliente1, estado1);
        reparacionDAO.crearReparacion(reparacion);
        reparacionDAO.crearReparacion(reparacion1);
        //Venta
        Venta venta = new Venta(1, 20, new Date(), cliente, new BigDecimal("3500"));
        Venta venta1 = new Venta(2, 50, new Date(), cliente1, new BigDecimal("9000"));
        ventaDAO.crearVenta(venta);
        ventaDAO.crearVenta(venta1);
    }

    @Test
    public void listarRepuestos(){
        agregarCliente();
        List<Repuesto> listaRepuestos = repuestoService.listarRepuestos();
        
        assertEquals(1, listaRepuestos.get(0).getId_repuesto());
        assertEquals(10, listaRepuestos.get(0).getStock());
        assertEquals("Fiat", listaRepuestos.get(0).getMarca().getNombre_marca());
        
        assertEquals(2, listaRepuestos.get(1).getId_repuesto());
        assertEquals(20, listaRepuestos.get(1).getStock());
        assertEquals("Renault", listaRepuestos.get(1).getMarca().getNombre_marca());
    }
    
    @Test
    public void obtenerRepuestoPorId(){
        agregarCliente();
        Repuesto repuesto = repuestoService.obtenerRepuestoPorId(2);
        
        assertEquals(2, repuesto.getId_repuesto());
        assertEquals(20, repuesto.getStock());
        assertEquals("Renault", repuesto.getMarca().getNombre_marca());
    }
    
    @Test
    public void editarRepuestoPorId(){
        agregarCliente();
        Repuesto repuesto = repuestoService.obtenerRepuestoPorId(1);
        repuesto.setStock(80);
        repuestoService.editarRepuestoPorId(repuesto);
        repuesto = null;
        repuesto = repuestoService.obtenerRepuestoPorId(1);
        
        assertEquals(1, repuesto.getId_repuesto());
        assertEquals(80, repuesto.getStock());
    }
    /*
    @Test
    public void eliminarRepuestoPorId(){
        agregarCliente();
        repuestoService.eliminarRepuestoPorId(1);
        List<Repuesto> listaRepuestos = repuestoService.listarRepuestos();
        
        assertEquals(2, listaRepuestos.get(0).getId_repuesto());
        assertEquals(20, listaRepuestos.get(0).getStock());
        assertEquals("Renault", listaRepuestos.get(0).getMarca().getNombre_marca());
    }
    */
    @Test
    public void actualizarStock(){
        agregarCliente();
        Repuesto repuesto = repuestoService.obtenerRepuestoPorId(1);
        repuestoService.actualizarStock(repuesto, 50);
        repuestoService.editarRepuestoPorId(repuesto);
        repuesto = null;
        repuesto = repuestoService.obtenerRepuestoPorId(1);
        
        assertEquals(1, repuesto.getId_repuesto());
        assertEquals(60, repuesto.getStock());
    }
}
