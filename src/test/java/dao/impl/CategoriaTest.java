package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.List;
import model.Categoria;
import model.Reparacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    private static CategoriaDAOImpl categoriaDAO;
    
    public CategoriaTest() {
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
    public void pruebaCrearCategoria(){
        Categoria categoria = new Categoria();
        categoria.setNombre_categoria("Lavarropa");
        Categoria categoria1 = new Categoria();
        categoria1.setNombre_categoria("Aire Acondicionado");
        categoriaDAO.crearCategoria(categoria);
        categoriaDAO.crearCategoria(categoria1);
    }
    
    @Test
    public void pruebaObtenerCategorias(){
        pruebaCrearCategoria();
        List<Categoria> listaCategorias = categoriaDAO.obtenerCategorias();
        
        assertEquals(1, listaCategorias.get(0).getId_categoria());
        assertEquals("Lavarropa", listaCategorias.get(0).getNombre_categoria());
        assertEquals(2, listaCategorias.get(1).getId_categoria());
        assertEquals("Aire Acondicionado", listaCategorias.get(1).getNombre_categoria());
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
        List<Reparacion> listaReparacion = null;
        Categoria categoria1 = new Categoria(1, "Heladera", listaReparacion);
        Categoria categoria2 = new Categoria(2, "Linea Blanca", listaReparacion);
        categoriaDAO.actualizarCategoria(categoria1);
        categoriaDAO.actualizarCategoria(categoria2);
        List<Categoria> listaCategorias = categoriaDAO.obtenerCategorias();
        
        assertEquals(1, listaCategorias.get(0).getId_categoria());
        assertEquals("Heladera", listaCategorias.get(0).getNombre_categoria());
        assertEquals(2, listaCategorias.get(1).getId_categoria());
        assertEquals("Linea Blanca", listaCategorias.get(1).getNombre_categoria());
    }
    
    @Test
    public void pruebaEliminarCategorias(){
        pruebaCrearCategoria();
        categoriaDAO.eliminarCategoria(1);
        List<Categoria> listaCategorias = categoriaDAO.obtenerCategorias();
        assertEquals(1, listaCategorias.size());
        assertEquals(2, listaCategorias.get(0).getId_categoria());
    }
}
