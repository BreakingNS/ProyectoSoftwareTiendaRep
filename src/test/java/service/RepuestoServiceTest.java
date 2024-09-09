package service;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import dao.impl.CategoriaDAOImpl;
import dao.impl.MarcaDAOImpl;
import dao.impl.NombreRepuestoDAOImpl;
import dao.impl.RepuestoDAOImpl;
import dao.impl.UbicacionDAOImpl;
import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RepuestoServiceTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    private static RepuestoDAOImpl repuestoDAO;
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    private static MarcaDAOImpl marcaDAO;
    private static CategoriaDAOImpl categoriaDAO;
    private static UbicacionDAOImpl ubicacionDAO;
    
    
    
    public RepuestoServiceTest() {
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

    
}
