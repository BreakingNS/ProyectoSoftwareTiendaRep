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

public class CategoriaServiceTest {
    
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
    
    private static CategoriaService categoriaService;
    
    public CategoriaServiceTest() {
        
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
        
        categoriaService = new CategoriaService(categoriaDAO, repuestoDAO, reparacionDAO);
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
    public void agregarCategoria(){
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
        categoriaService.agregarCategoria(categoria);
        categoriaService.agregarCategoria(categoria1);
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
        repuestoDAO.crearRepuesto(repuesto);
        repuestoDAO.crearRepuesto(repuesto1);
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
    public void listarCategorias(){
        agregarCategoria();
        List<Categoria> listaCategorias = categoriaService.listarCategorias();
        
        assertEquals(1, listaCategorias.get(0).getId_categoria());
        assertEquals("Lavarropas", listaCategorias.get(0).getNombre_categoria());
    }
    
    @Test
    public void obtenerCategoriaPorId(){
        agregarCategoria();
        Categoria categoria = categoriaService.obtenerCategoriaPorId(1);
        
        assertEquals(1, categoria.getId_categoria());
        assertEquals("Lavarropas", categoria.getNombre_categoria());
    }
    
    @Test
    public void editarCategoriaPorId(){
        agregarCategoria();
        Categoria categoria = new Categoria(1, "Linea Blanca", new ArrayList<>(), new ArrayList<>());
        categoriaService.editarCategoriaPorId(categoria);
        categoria = categoriaService.obtenerCategoriaPorId(1);
        
        assertEquals(1, categoria.getId_categoria());
        assertEquals("Linea Blanca", categoria.getNombre_categoria());
    }
    
    //A revision, pareciera necesitar la query metodo cascada
    
    @Test
    public void eliminarCategoriaPorId(){
        agregarCategoria();
        categoriaService.eliminarCategoriaPorId(1);
        
        List<Categoria> listaCategorias = categoriaService.listarCategorias();
        assertEquals(1, listaCategorias.size());
        assertEquals(2, listaCategorias.get(0).getId_categoria());
        assertEquals("Heladera", listaCategorias.get(0).getNombre_categoria());
        assertEquals(1,2);
    }
}
