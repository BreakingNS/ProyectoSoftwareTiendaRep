package service;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import dao.impl.MarcaDAOImpl;
import java.sql.Connection;
import java.util.List;
import model.Marca;
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
    private static MarcaService marcaService;
    
    public MarcaServiceTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        marcaDAO = new MarcaDAOImpl(connection);
        marcaService = new MarcaService(marcaDAO);
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
    public void agregarMarcaTest(){
        Marca marca = new Marca(1, "Fiat");
        Marca marca1 = new Marca(2, "Renault");
        marcaService.agregarMarca(marca);
        marcaService.agregarMarca(marca1);
    }
    
    @Test
    public void listarMarcasTest(){
        agregarMarcaTest();
        List<Marca> listaMarcas = marcaService.listarMarcas();
        
        assertEquals(1, listaMarcas.get(0).getId_marca());
        assertEquals("Fiat", listaMarcas.get(0).getNombre_marca());
        assertEquals(2, listaMarcas.get(1).getId_marca());
        assertEquals("Renault", listaMarcas.get(1).getNombre_marca());
    }
    
    @Test
    public void obtenerMarcaPorIdTest(){
        agregarMarcaTest();
        Marca marca = marcaService.obtenerMarcaPorId(1);
        assertEquals(1, marca.getId_marca());
        assertEquals("Fiat", marca.getNombre_marca());
    }
    
    @Test
    public void editarMarcaPorIdTest(){
        agregarMarcaTest();
        Marca marca = new Marca(1, "Volkswagen");
        Marca marca1 = new Marca(2, "BMW");
        marcaService.editarMarcaPorId(marca);
        marcaService.editarMarcaPorId(marca1);
        List<Marca> listaMarcas =marcaService.listarMarcas();
        
        assertEquals(1, listaMarcas.get(0).getId_marca());
        assertEquals("Volkswagen", listaMarcas.get(0).getNombre_marca());
        assertEquals(2, listaMarcas.get(1).getId_marca());
        assertEquals("BMW", listaMarcas.get(1).getNombre_marca());
        
    }
    
    @Test
    public void eliminarMarcaPorIdTest(){
        agregarMarcaTest();
        marcaService.eliminarMarcaPorId(1);
        List<Marca> listaMarcas = marcaService.listarMarcas();
        assertEquals(1, listaMarcas.size());
        assertEquals(2, listaMarcas.get(0).getId_marca());
    }
        
    @Test
    public void imprimirMarcasTest(){
        //assertEquals(1, 2);
    }
    
}
