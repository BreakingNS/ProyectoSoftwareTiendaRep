package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.List;
import model.Ubicacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UbicacionTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    private static UbicacionDAOImpl ubicacionDAO;
    
    public UbicacionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        ubicacionDAO = new UbicacionDAOImpl(connection);
    }
    
    @AfterAll
    public static void tearDownClass() {
        conexionDataBase.cerrarConexion(connection);
    }
    
    @BeforeEach
    public void setUp() {
        configuracion = new ConfiguracionDataBase(connection);
        configuracion.crearTablaUbicacion();
    }
    
    @AfterEach
    public void tearDown() {
        configuracion.eliminarTablaUbicacion();
    }

    @Test
    public void pruebaCrearUbicacion(){
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setNombre_ubicacion("Deposito");
        Ubicacion ubicacion1 = new Ubicacion();
        ubicacion1.setNombre_ubicacion("Piso 1");
        ubicacionDAO.crearUbicacion(ubicacion);
        ubicacionDAO.crearUbicacion(ubicacion1);
    }
    
    @Test
    public void pruebaObtenerUbicaciones(){
        pruebaCrearUbicacion();
        List<Ubicacion> listaUbicaciones = ubicacionDAO.obtenerUbicaciones();
        
        assertEquals(1, listaUbicaciones.get(0).getId_ubicacion());
        assertEquals("Deposito", listaUbicaciones.get(0).getNombre_ubicacion());
        assertEquals(2, listaUbicaciones.get(1).getId_ubicacion());
        assertEquals("Piso 1", listaUbicaciones.get(1).getNombre_ubicacion());
    }
    
    @Test
    public void pruebaObtenerUbicacion(){
        pruebaCrearUbicacion();
        Ubicacion ubicacion = ubicacionDAO.obtenerUbicacion(1);
        assertEquals(1, ubicacion.getId_ubicacion());
        assertEquals("Deposito", ubicacion.getNombre_ubicacion());
    }
    
    @Test
    public void pruebaModificarUbicaciones(){
        pruebaCrearUbicacion();
        Ubicacion ubicacion1 = new Ubicacion(1, "Mostrador");
        Ubicacion ubicacion2 = new Ubicacion(2, "Vitrina");
        ubicacionDAO.actualizarUbicacion(ubicacion1);
        ubicacionDAO.actualizarUbicacion(ubicacion2);
        List<Ubicacion> listaUbicaciones = ubicacionDAO.obtenerUbicaciones();
        
        assertEquals(1, listaUbicaciones.get(0).getId_ubicacion());
        assertEquals("Mostrador", listaUbicaciones.get(0).getNombre_ubicacion());
        assertEquals(2, listaUbicaciones.get(1).getId_ubicacion());
        assertEquals("Vitrina", listaUbicaciones.get(1).getNombre_ubicacion());
    }
    
    @Test
    public void pruebaEliminarUbicaciones(){
        pruebaCrearUbicacion();
        ubicacionDAO.eliminarUbicacion(1);
        List<Ubicacion> listaUbicaciones = ubicacionDAO.obtenerUbicaciones();
        assertEquals(1, listaUbicaciones.size());
        assertEquals(2, listaUbicaciones.get(0).getId_ubicacion());
    }
}
