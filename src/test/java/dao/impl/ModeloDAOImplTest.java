package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.List;
import model.Modelo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModeloDAOImplTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    
    private static ModeloDAOImpl modeloDAO;

    public ModeloDAOImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
  
        modeloDAO = new ModeloDAOImpl(connection);

    }
    
    @AfterAll
    public static void tearDownClass() {
        conexionDataBase.cerrarConexion(connection);
    }
    
    @BeforeEach
    public void setUp() {
        configuracion = new ConfiguracionDataBase(connection);
        
        configuracion.crearTablaModelo();
    }
    
    @AfterEach
    public void tearDown() {
        configuracion.eliminarTablaModelo();
    }
    
    @Test
    public void eliminarTablas(){
        configuracion.eliminarTablaModelo();
    }
    
    @Test
    public void pruebaCrearModelo(){
        Modelo modelo = new Modelo(1, "Plus");
        Modelo modelo1 = new Modelo(2, "Smart");
        modeloDAO.crearModelo(modelo);
        modeloDAO.crearModelo(modelo1);
    }
    
    @Test
    public void pruebaObtenerModelos(){
        pruebaCrearModelo();
        List<Modelo> listaModelos = modeloDAO.obtenerModelos();
        
        assertEquals(1, listaModelos.get(0).getId_modelo());
        assertEquals("Plus", listaModelos.get(0).getNombre_modelo());
        assertEquals(2, listaModelos.get(1).getId_modelo());
        assertEquals("Smart", listaModelos.get(1).getNombre_modelo());
    }
    
    @Test
    public void pruebaObtenerModelo(){
        pruebaCrearModelo();
        Modelo modelo = modeloDAO.obtenerModelo(1);
        assertEquals(1, modelo.getId_modelo());
        assertEquals("Plus", modelo.getNombre_modelo());
    }
    
    @Test
    public void pruebaModificarModelos(){
        pruebaCrearModelo();
        Modelo modelo1 = new Modelo(1, "Gama");
        Modelo modelo2 = new Modelo(2, "Plus Ultra");
        modeloDAO.actualizarModelo(modelo1);
        modeloDAO.actualizarModelo(modelo2);
        List<Modelo> listaModelos = modeloDAO.obtenerModelos();
        assertEquals(1, listaModelos.get(0).getId_modelo());
        assertEquals("Gama", listaModelos.get(0).getNombre_modelo());
        assertEquals(2, listaModelos.get(1).getId_modelo());
        assertEquals("Plus Ultra", listaModelos.get(1).getNombre_modelo());
    }
    
    @Test
    public void pruebaEliminarModelos(){
        pruebaCrearModelo();
        modeloDAO.eliminarModelo(1);
        List<Modelo> listaModelos = modeloDAO.obtenerModelos();
        assertEquals(1, listaModelos.size());
        assertEquals(2, listaModelos.get(0).getId_modelo());
    }
    
}
