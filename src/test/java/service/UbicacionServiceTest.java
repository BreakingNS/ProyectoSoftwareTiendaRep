package service;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import dao.impl.CategoriaDAOImpl;
import dao.impl.MarcaDAOImpl;
import dao.impl.NombreRepuestoDAOImpl;
import dao.impl.RepuestoDAOImpl;
import dao.impl.UbicacionDAOImpl;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Marca;
import model.NombreRepuesto;
import model.Repuesto;
import model.Ubicacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UbicacionServiceTest {
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    
    private static Connection connection;
    
    private static RepuestoDAOImpl repuestoDAO;
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    private static MarcaDAOImpl marcaDAO;
    private static CategoriaDAOImpl categoriaDAO;
    private static UbicacionDAOImpl ubicacionDAO;
    
    private static UbicacionService ubicacionService;
    
    public UbicacionServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        
        repuestoDAO = new RepuestoDAOImpl(connection);
        nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
        marcaDAO = new MarcaDAOImpl(connection);
        categoriaDAO = new CategoriaDAOImpl(connection);
        ubicacionDAO = new UbicacionDAOImpl(connection);
        
        ubicacionService = new UbicacionService(ubicacionDAO, repuestoDAO);
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
        configuracion.crearTablaRepuesto();
    }
    
    @AfterEach
    public void tearDown() {
        
        configuracion.eliminarTablaRepuesto();
        configuracion.eliminarTablaCategoria();
        configuracion.eliminarTablaUbicacion();
        configuracion.eliminarTablaNombreRepuesto();
        configuracion.eliminarTablaMarca();
        
    }
    /*
    @Test
    public void eliminarTablas(){
        configuracion.eliminarTablaRepuesto();
        configuracion.eliminarTablaCategoria();
        configuracion.eliminarTablaUbicacion();
        configuracion.eliminarTablaNombreRepuesto();
        configuracion.eliminarTablaMarca();
    }
    */

    @Test
    public void agregarMarcaTest(){
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(2, "Termostato");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
        Marca marca = new Marca(1, "Philips", new ArrayList<>());
        Marca marca1 = new Marca(2, "Generico", new ArrayList<>());
        marcaDAO.crearMarca(marca);
        marcaDAO.crearMarca(marca1);
        Categoria categoria = new Categoria(1, "Lavarropas", new ArrayList<>(), new ArrayList<>());
        Categoria categoria1 = new Categoria(2, "Heladera", new ArrayList<>(), new ArrayList<>());
        categoriaDAO.crearCategoria(categoria);
        categoriaDAO.crearCategoria(categoria1);
        Ubicacion ubicacion = new Ubicacion(1, "Deposito", new ArrayList<>());
        Ubicacion ubicacion1 = new Ubicacion(2, "Mostrador", new ArrayList<>());
        ubicacionService.agregarUbicacion(ubicacion);
        ubicacionService.agregarUbicacion(ubicacion1);
        
        Repuesto repuesto = new Repuesto(1, 10, nombreRepuesto, marca, categoria, new ArrayList<>(), ubicacion);
        Repuesto repuesto1 = new Repuesto(2, 20, nombreRepuesto1, marca1, categoria1, new ArrayList<>(), ubicacion1);
        repuestoDAO.crearRepuesto(repuesto);
        repuestoDAO.crearRepuesto(repuesto1);
    }
    
    @Test
    public void listarUbicacionesTest(){
        agregarMarcaTest();
        List<Ubicacion> listaUbicaciones = ubicacionService.listarUbicaciones();
        
        assertEquals(1, listaUbicaciones.get(0).getId_ubicacion());
        assertEquals("Deposito", listaUbicaciones.get(0).getNombre_ubicacion());
        assertEquals(2, listaUbicaciones.get(1).getId_ubicacion());
        assertEquals("Mostrador", listaUbicaciones.get(1).getNombre_ubicacion());
    }
    
    @Test
    public void obtenerUbicacionPorIdTest(){
        agregarMarcaTest();
        Ubicacion ubicacion = ubicacionService.obtenerUbicacionPorId(1);
        
        assertEquals(1, ubicacion.getId_ubicacion());
        assertEquals("Deposito", ubicacion.getNombre_ubicacion());
    }
    
    @Test
    public void editarUbicacionPorIdTest(){
        agregarMarcaTest();
        Ubicacion ubicacion = new Ubicacion(1, "Repisa", new ArrayList<>());
        ubicacionService.editarUbicacionPorId(ubicacion);
        
        List<Ubicacion> listaUbicaciones = ubicacionService.listarUbicaciones();
        
        assertEquals(1, listaUbicaciones.get(0).getId_ubicacion());
        assertEquals("Repisa", listaUbicaciones.get(0).getNombre_ubicacion());
    }
    
    //A revision, pareciera necesitar la query metodo cascada
    /*
    @Test
    public void eliminarUbicacionPorIdTest(){
        agregarMarcaTest();
        ubicacionService.eliminarUbicacionPorId(1);
        List<Ubicacion> listaUbicaciones = ubicacionService.listarUbicaciones();
        assertEquals(1, listaUbicaciones.size());
        assertEquals("Mostrador", listaUbicaciones.get(0).getNombre_ubicacion());
        assertEquals(1,2);
    }
    */
}
