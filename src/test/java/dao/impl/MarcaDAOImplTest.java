package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Marca;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class MarcaDAOImplTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    
    private static MarcaDAOImpl marcaDAO;
    
    public MarcaDAOImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        
        marcaDAO = new MarcaDAOImpl(connection);
        
    }
    
    @AfterAll
    public static void tearDownClass() {
        conexionDataBase.cerrarConexion(connection);
    }
    
    @BeforeEach
    public void setUp() {
        configuracion = new ConfiguracionDataBase(connection);
        
        configuracion.crearTablaMarca();
        
    }
    
    @AfterEach
    public void tearDown() {
        
        configuracion.eliminarTablaMarca();
        
    }
    
    @Test
    public void eliminarTablas(){
        configuracion.eliminarTablaMarca();
    }
    
    @Test
    public void pruebaCrearMarca(){
        Marca marca = new Marca(1, "Fiat", new ArrayList<>());
        Marca marca1 = new Marca(2, "Renault", new ArrayList<>());
        marcaDAO.crearMarca(marca);
        marcaDAO.crearMarca(marca1);
    }
    
    @Test
    public void pruebaObtenerMarcas(){
        pruebaCrearMarca();
        List<Marca> listaMarcas = marcaDAO.obtenerMarcasOrdenadasPorNombre();
        
        assertEquals(1, listaMarcas.get(0).getId_marca());
        assertEquals("Fiat", listaMarcas.get(0).getNombre_marca());
        assertEquals(2, listaMarcas.get(1).getId_marca());
        assertEquals("Renault", listaMarcas.get(1).getNombre_marca());
    }
    
    @Test
    public void pruebaObtenerMarca(){
        pruebaCrearMarca();
        Marca marca = marcaDAO.obtenerMarca(1);
        assertEquals(1, marca.getId_marca());
        assertEquals("Fiat", marca.getNombre_marca());
    }
    
    @Test
    public void pruebaModificarMarcas(){
        pruebaCrearMarca();
        Marca marca1 = new Marca(1, "Peugeot", new ArrayList<>());
        Marca marca2 = new Marca(2, "Citroen", new ArrayList<>());
        marcaDAO.actualizarMarca(marca1);
        marcaDAO.actualizarMarca(marca2);
        List<Marca> listaMarcas = marcaDAO.obtenerMarcasOrdenadasPorNombre();
        
        assertEquals(2, listaMarcas.get(0).getId_marca());
        assertEquals("Citroen", listaMarcas.get(0).getNombre_marca());
        assertEquals(1, listaMarcas.get(1).getId_marca());
        assertEquals("Peugeot", listaMarcas.get(1).getNombre_marca());
        
    }
    
    @Test
    public void pruebaEliminarMarcas(){
        pruebaCrearMarca();
        marcaDAO.eliminarMarca(1);
        List<Marca> listaMarcas = marcaDAO.obtenerMarcasOrdenadasPorNombre();
        assertEquals(1, listaMarcas.size());
        assertEquals(2, listaMarcas.get(0).getId_marca());
    }
    
}
