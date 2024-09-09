package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.List;
import model.Categoria;
import model.Marca;
import model.NombreRepuesto;
import model.Precio;
import model.Reparacion;
import model.Repuesto;
import model.Ubicacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RepuestoTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    private static RepuestoDAOImpl repuestoDAO;
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    private static MarcaDAOImpl marcaDAO;
    private static CategoriaDAOImpl categoriaDAO;
    private static UbicacionDAOImpl ubicacionDAO;
    
    
    
    public RepuestoTest() {
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
    
    @Test
    public void pruebaCrearTablas(){
        
    }

    @Test
    public void pruebaCrearRepuesto(){
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(2, "Termostato");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
        Marca marca = new Marca(1, "Philips");
        Marca marca1 = new Marca(2, "Generico");
        marcaDAO.crearMarca(marca);
        marcaDAO.crearMarca(marca1);
        List<Reparacion> listaReparaciones = null;
        Categoria categoria = new Categoria(1, "Lavarropas", listaReparaciones);
        Categoria categoria1 = new Categoria(2, "Heladera", listaReparaciones);
        categoriaDAO.crearCategoria(categoria);
        categoriaDAO.crearCategoria(categoria1);
        Ubicacion ubicacion = new Ubicacion(1, "Deposito");
        Ubicacion ubicacion1 = new Ubicacion(2, "Mostrador");
        ubicacionDAO.crearUbicacion(ubicacion);
        ubicacionDAO.crearUbicacion(ubicacion1);
        
        List<Precio> listaPrecios = null;
        
        Repuesto repuesto = new Repuesto(1, 10, nombreRepuesto, marca, categoria, listaPrecios, ubicacion);
        Repuesto repuesto1 = new Repuesto(2, 20, nombreRepuesto1, marca1, categoria1, listaPrecios, ubicacion1);
        repuestoDAO.crearRepuesto(repuesto);
        repuestoDAO.crearRepuesto(repuesto1);
    }
    
    @Test
    public void pruebaObtenerRepuestos(){
        pruebaCrearRepuesto();
        
        List<Repuesto> listaRepuestos = repuestoDAO.obtenerRepuestos();
        
        assertEquals(10, listaRepuestos.get(0).getStock());
        assertEquals(20, listaRepuestos.get(1).getStock());
    }
    
    @Test
    public void pruebaObtenerRepuesto(){
        pruebaCrearRepuesto();
        
        Repuesto repuesto = repuestoDAO.obtenerRepuesto(1);
        
        assertEquals("Philips", repuesto.getMarca().getNombre_marca());
        assertEquals(1, repuesto.getCategoria().getId_categoria());
        assertEquals(1, repuesto.getMarca().getId_marca());
        assertEquals(1, repuesto.getNombreRepuesto().getId_nombrerepuesto());
        assertEquals(1, repuesto.getUbicacion().getId_ubicacion());
    }
    
    @Test
    public void pruebaModificarRepuestos(){
        pruebaCrearRepuesto();
        
        Repuesto repuesto = repuestoDAO.obtenerRepuesto(1);
        repuesto.setStock(50);
        repuestoDAO.actualizarRepuesto(repuesto);
        
        repuesto = repuestoDAO.obtenerRepuesto(1);
        
        assertEquals(50, repuesto.getStock());
        
    }
    
    @Test
    public void pruebaEliminarRepuestos(){
        pruebaCrearRepuesto();
        
        repuestoDAO.eliminarRepuesto(1);
        
        List<Repuesto> listaRepuestos = repuestoDAO.obtenerRepuestos();
        assertEquals(1, listaRepuestos.size());
        assertEquals(20, listaRepuestos.get(0).getStock());
    }
}
