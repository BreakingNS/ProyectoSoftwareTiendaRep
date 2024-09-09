package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReparacionTest {
    
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
    
    public ReparacionTest() {
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
        configuracion.crearTablaUbicacion();
        configuracion.crearTablaCategoria();
        configuracion.crearTablaEstado();
        configuracion.crearTablaCliente();
        configuracion.crearTablaVenta();
        configuracion.crearTablaRepuesto();
        configuracion.crearTablaPrecio();
        configuracion.crearTablaReparacion();
        configuracion.crearTablaVentaRepuesto();
        configuracion.crearTablaVentaReparacion();
        
    }
    
    @AfterEach
    public void tearDown() {
        
        configuracion.crearTablaVentaReparacion();
        configuracion.crearTablaVentaRepuesto();
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
        configuracion.crearTablaVentaReparacion();
        configuracion.crearTablaVentaRepuesto();
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
    /*
    crearReparacion + 
    obtenerReparaciones  +
    actualizarReparacion +
    eliminarReparacion +
    obtenerReparacion +
    obtenerReparacionesPorIdCliente
    obtenerReparacionesPorIdCategoria*/
    
    @Test
    public void pruebaCrearReparacion(){
        //Marca
        Marca marca = new Marca(1, "Fiat");
        Marca marca1 = new Marca(2, "Renault");
        marcaDAO.crearMarca(marca);
        marcaDAO.crearMarca(marca1);
        //NombreRepuesto +
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(2, "Fuente");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
        //Ubicacion 
        Ubicacion ubicacion = new Ubicacion(1, "Deposito");
        Ubicacion ubicacion1 = new Ubicacion(2, "Piso 1");
        ubicacionDAO.crearUbicacion(ubicacion);
        ubicacionDAO.crearUbicacion(ubicacion1);
        //Categoria
        List<Reparacion> listaReparaciones = new ArrayList<>();
        Categoria categoria = new Categoria(1, "Lavarropas", listaReparaciones);
        Categoria categoria1 = new Categoria(2, "Heladera", listaReparaciones);
        categoriaDAO.crearCategoria(categoria);
        categoriaDAO.crearCategoria(categoria1);
        //Estado
        Estado estado = new Estado(1, "Recibido", listaReparaciones);
        Estado estado1 = new Estado(2, "Presupuesto", listaReparaciones);
        estadoDAO.crearEstado(estado);
        estadoDAO.crearEstado(estado1);
        //Cliente
        List<Venta> listaVentas = new ArrayList<>();
        Cliente cliente = new Cliente(1, "Carlos", "Perez", "3834123456", listaVentas, listaReparaciones);
        Cliente cliente1 = new Cliente(2, "Maria", "Carrizo", "3834654321", listaVentas, listaReparaciones);
        clienteDAO.crearCliente(cliente);
        clienteDAO.crearCliente(cliente1);
        //Repuesto +
        List<Precio> listaPrecios = new ArrayList<>();
        Repuesto repuesto = new Repuesto(1, 10, nombreRepuesto, marca, categoria, listaPrecios, ubicacion);
        Repuesto repuesto1 = new Repuesto(2, 20, nombreRepuesto1, marca1, categoria1, listaPrecios, ubicacion1);
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
        Reparacion reparacion = new Reparacion(1, new BigDecimal("3000"), "Rota la tapa", new Date(), new Date(), categoria, cliente, repuesto, estado);
        Reparacion reparacion1 = new Reparacion(2, new BigDecimal("9000"), "Color plateado", new Date(), new Date(), categoria1, cliente1, repuesto1, estado1);
        reparacionDAO.crearReparacion(reparacion);
        reparacionDAO.crearReparacion(reparacion1);
        //Venta
        Venta venta = new Venta(1, 20, new Date(), cliente, new BigDecimal("3500"));
        Venta venta1 = new Venta(2, 50, new Date(), cliente1, new BigDecimal("9000"));
        ventaDAO.crearVenta(venta);
        ventaDAO.crearVenta(venta1);
    }
    
    @Test
    public void pruebaObtenerReparaciones(){
        pruebaCrearReparacion();
        List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparaciones();
        
        assertEquals(1, listaReparaciones.get(0).getId_reparacion());
        assertEquals("Rota la tapa", listaReparaciones.get(0).getDetalles());
        assertEquals("Perez", listaReparaciones.get(0).getCliente().getApellido());
        
        assertEquals(2, listaReparaciones.get(1).getId_reparacion());
        assertEquals("Color plateado", listaReparaciones.get(1).getDetalles());
        assertEquals("Carrizo", listaReparaciones.get(1).getCliente().getApellido());
    }
    
    @Test
    public void pruebaObtenerReparacion(){
        pruebaCrearReparacion();
        Reparacion reparacion = reparacionDAO.obtenerReparacion(2);
        
        assertEquals(2, reparacion.getId_reparacion());
        assertEquals("Color plateado", reparacion.getDetalles());
        assertEquals("Presupuesto", reparacion.getEstado().getNombre_estado());
    }
    
    @Test
    public void pruebaActualizarReparacion(){
        pruebaCrearReparacion();
        Reparacion reparacion = reparacionDAO.obtenerReparacion(1);
        reparacion.setDetalles("Sin tapa");
        reparacionDAO.actualizarReparacion(reparacion);
        reparacionDAO.obtenerReparacion(1);
        
        assertEquals(1, reparacion.getId_reparacion());
        assertEquals("Sin tapa", reparacion.getDetalles());
    }
    
    @Test
    public void pruebaEliminarReparacion(){
        pruebaCrearReparacion();
        reparacionDAO.eliminarReparacion(1);
        List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparaciones();
        
        assertEquals(1, listaReparaciones.size());
        assertEquals("Color plateado", listaReparaciones.get(0).getDetalles());
    }
    
    @Test
    public void pruebaObtenerReparacionesPorIdCliente(){
        pruebaCrearReparacion();
        List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparacionesPorIdCliente(1);
        
        assertEquals(1, listaReparaciones.get(0).getCliente().getId_cliente());
        assertEquals("Rota la tapa", listaReparaciones.get(0).getDetalles());
    }
    
    @Test
    public void pruebaObtenerReparacionesPorIdCategoria(){
        pruebaCrearReparacion();
        List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparacionesPorIdCategoria(2);
        
        assertEquals(2, listaReparaciones.get(0).getCliente().getId_cliente());
        assertEquals("Color plateado", listaReparaciones.get(0).getDetalles());
    }
}
