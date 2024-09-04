package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.List;
import model.Estado;
import model.Reparacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstadoTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    private static EstadoDAOImpl estadoDAO;
    
    public EstadoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        estadoDAO = new EstadoDAOImpl(connection);
    }
    
    @AfterAll
    public static void tearDownClass() {
        conexionDataBase.cerrarConexion(connection);
    }
    
    @BeforeEach
    public void setUp() {
        configuracion = new ConfiguracionDataBase(connection);
        configuracion.crearTablaEstado();
    }
    
    @AfterEach
    public void tearDown() {
        configuracion.eliminarTablaEstado();
    }

    @Test
    public void pruebaCrearEstado(){
        Estado estado = new Estado();
        estado.setNombre_estado("Recibido");
        Estado estado1 = new Estado();
        estado1.setNombre_estado("Presupuesto");
        estadoDAO.crearEstado(estado);
        estadoDAO.crearEstado(estado1);
    }
    
    @Test
    public void pruebaObtenerEstados(){
        pruebaCrearEstado();
        List<Estado> listaEstados = estadoDAO.obtenerEstados();
        
        assertEquals(1, listaEstados.get(0).getId_estado());
        assertEquals("Recibido", listaEstados.get(0).getNombre_estado());
        assertEquals(2, listaEstados.get(1).getId_estado());
        assertEquals("Presupuesto", listaEstados.get(1).getNombre_estado());
    }
    
    @Test
    public void pruebaObtenerEstado(){
        pruebaCrearEstado();
        Estado estado = estadoDAO.obtenerEstado(1);
        assertEquals(1, estado.getId_estado());
        assertEquals("Recibido", estado.getNombre_estado());
    }
    
    @Test
    public void pruebaModificarEstados(){
        pruebaCrearEstado();
        List<Reparacion> listaReparaciones = null;
        Estado estado1 = new Estado(1, "Entregado", listaReparaciones);
        Estado estado2 = new Estado(2, "Devuelto", listaReparaciones);
        estadoDAO.actualizarEstado(estado1);
        estadoDAO.actualizarEstado(estado2);
        List<Estado> listaEstados = estadoDAO.obtenerEstados();
        
        assertEquals(1, listaEstados.get(0).getId_estado());
        assertEquals("Entregado", listaEstados.get(0).getNombre_estado());
        assertEquals(2, listaEstados.get(1).getId_estado());
        assertEquals("Devuelto", listaEstados.get(1).getNombre_estado());
    }
    
    @Test
    public void pruebaEliminarEstados(){
        pruebaCrearEstado();
        estadoDAO.eliminarEstado(1);
        List<Estado> listaEstados = estadoDAO.obtenerEstados();
        assertEquals(1, listaEstados.size());
        assertEquals(2, listaEstados.get(0).getId_estado());
    }
}
