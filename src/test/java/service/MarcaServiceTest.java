package service;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import dao.impl.CategoriaDAOImpl;
import dao.impl.ClienteDAOImpl;
import dao.impl.EstadoDAOImpl;
import dao.impl.MarcaDAOImpl;
import dao.impl.ModeloDAOImpl;
import dao.impl.NombreRepuestoDAOImpl;
import dao.impl.PrecioDAOImpl;
import dao.impl.ReparacionDAOImpl;
import dao.impl.RepuestoDAOImpl;
import dao.impl.UbicacionDAOImpl;
import dao.impl.VentaDAOImpl;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Marca;
import model.Modelo;
import model.NombreRepuesto;
import model.Repuesto;
import model.Ubicacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarcaServiceTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    
    private static MarcaDAOImpl marcaDAO;
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    private static ModeloDAOImpl modeloDAO;
    private static UbicacionDAOImpl ubicacionDAO;
    private static CategoriaDAOImpl categoriaDAO;
    private static EstadoDAOImpl estadoDAO;
    private static ClienteDAOImpl clienteDAO;
    private static RepuestoDAOImpl repuestoDAO;
    private static PrecioDAOImpl precioDAO;
    private static ReparacionDAOImpl reparacionDAO;
    private static VentaDAOImpl ventaDAO;
    
    private static MarcaService marcaService;
    
    public MarcaServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        
        marcaDAO = new MarcaDAOImpl(connection);
        nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
        modeloDAO = new ModeloDAOImpl(connection);
        ubicacionDAO = new UbicacionDAOImpl(connection);
        categoriaDAO = new CategoriaDAOImpl(connection);
        estadoDAO = new EstadoDAOImpl(connection);
        clienteDAO = new ClienteDAOImpl(connection);
        repuestoDAO = new RepuestoDAOImpl(connection);
        precioDAO = new PrecioDAOImpl(connection);
        reparacionDAO = new ReparacionDAOImpl(connection);
        ventaDAO = new VentaDAOImpl(connection);
        
        marcaService = new MarcaService(marcaDAO, repuestoDAO);
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
    public void agregarMarcaTest(){
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(2, "Termostato");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
        Marca marca = new Marca(1, "Philips", new ArrayList<>());
        Marca marca1 = new Marca(2, "Generico", new ArrayList<>());
        marcaService.agregarMarca(marca);
        marcaService.agregarMarca(marca1);
        Categoria categoria = new Categoria(1, "Lavarropas", new ArrayList<>(), new ArrayList<>());
        Categoria categoria1 = new Categoria(2, "Heladera", new ArrayList<>(), new ArrayList<>());
        categoriaDAO.crearCategoria(categoria);
        categoriaDAO.crearCategoria(categoria1);
        Ubicacion ubicacion = new Ubicacion(1, "Deposito", new ArrayList<>());
        Ubicacion ubicacion1 = new Ubicacion(2, "Mostrador", new ArrayList<>());
        ubicacionDAO.crearUbicacion(ubicacion);
        ubicacionDAO.crearUbicacion(ubicacion1);
        Modelo modelo = new Modelo(1, "Plus");
        Modelo modelo1 = new Modelo(2, "Plus Ultra");
        modeloDAO.crearModelo(modelo);
        modeloDAO.crearModelo(modelo1);
        Repuesto repuesto = new Repuesto(1, 10, nombreRepuesto, marca, categoria, modelo, new ArrayList<>(), ubicacion, "A000");
        Repuesto repuesto1 = new Repuesto(2, 20, nombreRepuesto1, marca1, categoria1, modelo1, new ArrayList<>(), ubicacion1, "A001");
        repuestoDAO.crearRepuesto(repuesto);
        repuestoDAO.crearRepuesto(repuesto1);
    }
    
    @Test
    public void listarMarcasTest(){
        agregarMarcaTest();
        List<Marca> listaMarcas = marcaService.listarMarcasOrdenadasPorNombre();
        
        
        assertEquals(2, listaMarcas.get(0).getId_marca());
        assertEquals("Generico", listaMarcas.get(0).getNombre_marca());
        assertEquals(20, listaMarcas.get(0).getListaRepuestos().get(0).getStock());
        assertEquals(1, listaMarcas.get(1).getId_marca());
        assertEquals("Philips", listaMarcas.get(1).getNombre_marca());
        assertEquals(10, listaMarcas.get(1).getListaRepuestos().get(0).getStock());
    }
    
    @Test
    public void obtenerMarcaPorIdTest(){
        agregarMarcaTest();
        Marca marca = marcaService.obtenerMarcaPorId(1);
        assertEquals(1, marca.getId_marca());
        assertEquals("Philips", marca.getNombre_marca());
        assertEquals(10, marca.getListaRepuestos().get(0).getStock());
    }
    
    @Test
    public void editarMarcaPorIdTest(){
        agregarMarcaTest();
        Marca marca = new Marca(1, "Volkswagen", new ArrayList<>());
        Marca marca1 = new Marca(2, "BMW", new ArrayList<>());
        marcaService.editarMarcaPorId(marca);
        marcaService.editarMarcaPorId(marca1);
        List<Marca> listaMarcas = marcaService.listarMarcasOrdenadasPorNombre();
        
        
        assertEquals(2, listaMarcas.get(0).getId_marca());
        assertEquals("BMW", listaMarcas.get(0).getNombre_marca());
        assertEquals(20, listaMarcas.get(0).getListaRepuestos().get(0).getStock());
        assertEquals(1, listaMarcas.get(1).getId_marca());
        assertEquals("Volkswagen", listaMarcas.get(1).getNombre_marca());
        assertEquals(10, listaMarcas.get(1).getListaRepuestos().get(0).getStock());
    }
    
    //A revision, pareciera necesitar la query metodo cascada
    /*
    @Test
    public void eliminarMarcaPorIdTest(){
        agregarMarcaTest();
        marcaService.eliminarMarcaPorId(1);
        List<Marca> listaMarcas = marcaService.listarMarcas();
        assertEquals(1, listaMarcas.size());
        assertEquals(2, listaMarcas.get(0).getId_marca());
        assertEquals(20, listaMarcas.get(0).getListaRepuestos().get(0).getStock());
        assertEquals(1,2);
    }
    */
}
