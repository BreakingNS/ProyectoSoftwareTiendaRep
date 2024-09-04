package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.List;
import model.NombreRepuesto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NombreRepuestoTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    
    public NombreRepuestoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
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
    public void pruebaCrearNombreRepuesto(){
        NombreRepuesto nombreRepuesto = new NombreRepuesto();
        nombreRepuesto.setNombre_repuesto("Bobina");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto();
        nombreRepuesto1.setNombre_repuesto("Fuente");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
    }
    
    @Test
    public void pruebaObtenerNombreRepuestos(){
        pruebaCrearNombreRepuesto();
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoDAO.obtenerNombreRepuestos();
        
        assertEquals(1, listaNombreRepuestos.get(0).getId_nombrerepuesto());
        assertEquals("Bobina", listaNombreRepuestos.get(0).getNombre_repuesto());
        assertEquals(2, listaNombreRepuestos.get(1).getId_nombrerepuesto());
        assertEquals("Fuente", listaNombreRepuestos.get(1).getNombre_repuesto());
    }
    
    @Test
    public void pruebaObtenerNombreRepuesto(){
        pruebaCrearNombreRepuesto();
        NombreRepuesto nombreRepuesto = nombreRepuestoDAO.obtenerNombreRepuesto(1);
        assertEquals(1, nombreRepuesto.getId_nombrerepuesto());
        assertEquals("Bobina", nombreRepuesto.getNombre_repuesto());
    }
    
    @Test
    public void pruebaModificarNombreRepuestos(){
        pruebaCrearNombreRepuesto();
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoDAO.obtenerNombreRepuestos();
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(1, "Sensor");
        NombreRepuesto nombreRepuesto2 = new NombreRepuesto(2, "Termostato");
        nombreRepuestoDAO.actualizarNombreRepuesto(nombreRepuesto1);
        nombreRepuestoDAO.actualizarNombreRepuesto(nombreRepuesto2);
        listaNombreRepuestos = nombreRepuestoDAO.obtenerNombreRepuestos();
        assertEquals(1, listaNombreRepuestos.get(0).getId_nombrerepuesto());
        assertEquals("Sensor", listaNombreRepuestos.get(0).getNombre_repuesto());
        assertEquals(2, listaNombreRepuestos.get(1).getId_nombrerepuesto());
        assertEquals("Termostato", listaNombreRepuestos.get(1).getNombre_repuesto());
    }
    
    @Test
    public void pruebaEliminarNombreRepuestos(){
        pruebaCrearNombreRepuesto();
        nombreRepuestoDAO.eliminarNombreRepuesto(1);
        List<NombreRepuesto> listaNombreRepuestos = nombreRepuestoDAO.obtenerNombreRepuestos();
        assertEquals(1, listaNombreRepuestos.size());
        assertEquals(2, listaNombreRepuestos.get(0).getId_nombrerepuesto());
    }
}
