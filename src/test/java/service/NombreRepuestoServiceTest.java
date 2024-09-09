package service;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import dao.impl.NombreRepuestoDAOImpl;
import java.sql.Connection;
import java.util.List;
import model.NombreRepuesto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NombreRepuestoServiceTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    private static NombreRepuestoService nombreRepuestoService;
    
    public NombreRepuestoServiceTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
        nombreRepuestoService = new NombreRepuestoService(nombreRepuestoDAO);
    }
    
    @AfterAll
    public static void tearDownClass() {
        conexionDataBase.cerrarConexion(connection);
    }
    
    @BeforeEach
    public void setUp() {
        configuracion = new ConfiguracionDataBase(connection);
        configuracion.crearTablaNombreRepuesto();
    }
    
    @AfterEach
    public void tearDown() {
        configuracion.eliminarTablaNombreRepuesto();
    }
    
    @Test
    public void agregarNombreRepuestoTest(){
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(2, "Fuente");
        nombreRepuestoService.agregarNombreRepuesto(nombreRepuesto);
        nombreRepuestoService.agregarNombreRepuesto(nombreRepuesto1);
    }
    
    @Test
    public void listarNombreRepuestosTest(){
        agregarNombreRepuestoTest();
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoService.listarNombreRepuestos();
    
        assertEquals(1, listaNombreRepuestos.get(0).getId_nombrerepuesto());
        assertEquals("Bobina", listaNombreRepuestos.get(0).getNombre_repuesto());
        assertEquals(2, listaNombreRepuestos.get(1).getId_nombrerepuesto());
        assertEquals("Fuente", listaNombreRepuestos.get(1).getNombre_repuesto());
    }
    
    @Test
    public void obtenerNombreRepuestoPorIdTest(){
        agregarNombreRepuestoTest();
        NombreRepuesto nombreRepuesto = nombreRepuestoService.obtenerNombreRepuestoPorId(1);
        assertEquals(1, nombreRepuesto.getId_nombrerepuesto());
        assertEquals("Bobina", nombreRepuesto.getNombre_repuesto());
    }
    
    @Test
    public void editarNombreRepuestoPorIdTest(){
        agregarNombreRepuestoTest();
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(1, "Sensor");
        NombreRepuesto nombreRepuesto2 = new NombreRepuesto(2, "Termostato");
        nombreRepuestoService.editarNombreRepuestoPorId(nombreRepuesto1);
        nombreRepuestoService.editarNombreRepuestoPorId(nombreRepuesto2);
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoService.listarNombreRepuestos();
        assertEquals(1, listaNombreRepuestos.get(0).getId_nombrerepuesto());
        assertEquals("Sensor", listaNombreRepuestos.get(0).getNombre_repuesto());
        assertEquals(2, listaNombreRepuestos.get(1).getId_nombrerepuesto());
        assertEquals("Termostato", listaNombreRepuestos.get(1).getNombre_repuesto());
    }
    
    @Test
    public void eliminarNombreRepuestoPorIdTest(){
        agregarNombreRepuestoTest();
        nombreRepuestoService.eliminarNombreRepuestoPorId(1);
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoService.listarNombreRepuestos();
        assertEquals(1, listaNombreRepuestos.size());
        assertEquals(2, listaNombreRepuestos.get(0).getId_nombrerepuesto());
    }
    
    @Test
    public void imprimirNombreRepuestosTest(){
        
    }
    
    
}
