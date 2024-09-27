package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoriaDAOImplTest {
    
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
    
    public CategoriaDAOImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        
        categoriaDAO = new CategoriaDAOImpl(connection);
    }
    
    @AfterAll
    public static void tearDownClass() {
        conexionDataBase.cerrarConexion(connection);
    }
    
    @BeforeEach
    public void setUp() {
        configuracion = new ConfiguracionDataBase(connection);
        
        configuracion.crearTablaCategoria();
    }
    
    @AfterEach
    public void tearDown() {
        configuracion.eliminarTablaCategoria();
    }

    @Test
    public void eliminarTablas(){
        configuracion.eliminarTablaCategoria();
    }

    @Test
    public void pruebaCrearCategoria(){
        Categoria categoria = new Categoria(1, "Lavarropa", new ArrayList<>(), new ArrayList<>());
        Categoria categoria1 = new Categoria(1, "Aire Acondicionado", new ArrayList<>(), new ArrayList<>());
        categoriaDAO.crearCategoria(categoria);
        categoriaDAO.crearCategoria(categoria1);
    }
    
    @Test
    public void pruebaObtenerCategorias(){
        pruebaCrearCategoria();
        List<Categoria> listaCategorias = categoriaDAO.obtenerCategoriasOrdenadasPorNombre();
        
        assertEquals(2, listaCategorias.get(0).getId_categoria());
        assertEquals("Aire Acondicionado", listaCategorias.get(0).getNombre_categoria());
        assertEquals(1, listaCategorias.get(1).getId_categoria());
        assertEquals("Lavarropa", listaCategorias.get(1).getNombre_categoria());
    }
    
    @Test
    public void pruebaObtenerCategoria(){
        pruebaCrearCategoria();
        Categoria categoria = categoriaDAO.obtenerCategoria(1);
        assertEquals(1, categoria.getId_categoria());
        assertEquals("Lavarropa", categoria.getNombre_categoria());
    }
    
    @Test
    public void pruebaModificarCategorias(){
        pruebaCrearCategoria();
        Categoria categoria1 = new Categoria(1, "Heladera", new ArrayList<>(), new ArrayList<>());
        Categoria categoria2 = new Categoria(2, "Linea Blanca", new ArrayList<>(), new ArrayList<>());
        categoriaDAO.actualizarCategoria(categoria1);
        categoriaDAO.actualizarCategoria(categoria2);
        List<Categoria> listaCategorias = categoriaDAO.obtenerCategoriasOrdenadasPorNombre();
        
        assertEquals(1, listaCategorias.get(0).getId_categoria());
        assertEquals("Heladera", listaCategorias.get(0).getNombre_categoria());
        assertEquals(2, listaCategorias.get(1).getId_categoria());
        assertEquals("Linea Blanca", listaCategorias.get(1).getNombre_categoria());
    }
    
    @Test
    public void pruebaEliminarCategorias(){
        pruebaCrearCategoria();
        categoriaDAO.eliminarCategoria(1);
        List<Categoria> listaCategorias = categoriaDAO.obtenerCategoriasOrdenadasPorNombre();
        assertEquals(1, listaCategorias.size());
        assertEquals(2, listaCategorias.get(0).getId_categoria());
    }
}