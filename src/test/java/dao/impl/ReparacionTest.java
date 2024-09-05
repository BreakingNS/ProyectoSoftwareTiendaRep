package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Cliente;
import model.Estado;
import model.NombreRepuesto;
import model.Reparacion;
import model.Repuesto;
import model.Venta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReparacionTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    private static ReparacionDAOImpl reparacionDAO;
    private static CategoriaDAOImpl categoriaDAO;
    private static ClienteDAOImpl clienteDAO;
    private static RepuestoDAOImpl repuestoDAO;
    private static EstadoDAOImpl estadoDAO;
    /*
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    private static MarcaDAOImpl marcaDAO;
    
    private static UbicacionDAOImpl ubicacionDAO;
    */
    public ReparacionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        repuestoDAO = new RepuestoDAOImpl(connection);
        categoriaDAO = new CategoriaDAOImpl(connection);
        reparacionDAO = new ReparacionDAOImpl(connection);
        clienteDAO = new ClienteDAOImpl(connection);
        estadoDAO = new EstadoDAOImpl(connection);
    }
    
    @AfterAll
    public static void tearDownClass() {
        conexionDataBase.cerrarConexion(connection);
    }
    
    @BeforeEach
    public void setUp() {
        configuracion = new ConfiguracionDataBase(connection);
        configuracion.crearTablaCategoria();
        configuracion.crearTablaEstado();
        configuracion.crearTablaCliente();
        configuracion.crearTablaRepuesto();
        configuracion.crearTablaReparacion();
    }
    
    @AfterEach
    public void tearDown() {
        configuracion.crearTablaReparacion();
        configuracion.crearTablaRepuesto();
        configuracion.crearTablaCliente();
        configuracion.crearTablaEstado();
        configuracion.crearTablaCategoria();
    }

    @Test
    public void pruebaCrearTablas(){
        
    }
    
    /*
    crearReparacion
    obtenerReparaciones
    actualizarReparacion
    eliminarReparacion
    obtenerReparacion
    obtenerReparacionesPorIdCliente
    obtenerReparacionesPorIdCategoria
    */
    
    @Test
    public void pruebaCrearPrecio(){
        //Categoria
        List<Reparacion> listaReparaciones = new ArrayList<>();
        Categoria categoria = new Categoria(1, "Lavarropas", listaReparaciones);
        Categoria categoria1 = new Categoria(2, "Heladera", listaReparaciones);
        categoriaDAO.crearCategoria(categoria);
        categoriaDAO.crearCategoria(categoria1);
        //Estado
        Estado estado = new Estado(1, "Recibido", listaReparaciones);
        Estado estado1 = new Estado(2, "Presupuesto", listaReparaciones);
        estadoDAO.crearEstado(estado);
        estadoDAO.crearEstado(estado1);
        //Cliente
        List<Venta> listaVentas = new ArrayList<>();
        Cliente cliente = new Cliente(1, "Carlos", "Perez", "3834123456", listaVentas, listaReparaciones);
        Cliente cliente1 = new Cliente(2, "Maria", "Carrizo", "3834654321", listaVentas, listaReparaciones);
        clienteDAO.crearCliente(cliente);
        clienteDAO.crearCliente(cliente1);
        //Repuesto
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(2, "Fuente");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
        Repuesto repuesto = new Repuesto(1, 10, nombreRepuesto, marca, categoria, listaPrecios, ubicacion);
        Repuesto repuesto1 = new Repuesto(2, 20, nombreRepuesto1, marca1, categoria1, listaPrecios, ubicacion1);
        repuestoDAO.crearRepuesto(repuesto);
        repuestoDAO.crearRepuesto(repuesto1);
        
        //Reparacion
        
    }
    
    @Test
    public void pruebaObtenerPrecios(){

    }
    
    @Test
    public void pruebaObtenerPrecio(){

    }
    
    @Test
    public void pruebaModificarPrecios(){

    }
    
    @Test
    public void pruebaEliminarPrecios(){

    }
    
    @Test
    public void pruebaObtenerPrecioPorIdRepuesto(){

    }
}
