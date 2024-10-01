package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.math.BigDecimal;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;
import model.Factura;
import model.Pago;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PagoDAOImplTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    
    private static MarcaDAOImpl marcaDAO;
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    private static ModeloDAOImpl modeloDAO;
    private static UbicacionDAOImpl ubicacionDAO;
    private static CategoriaDAOImpl categoriaDAO;
    private static EstadoDAOImpl estadoDAO;
    private static ClienteDAOImpl clienteDAO;
    private static TecnicoDAOImpl tecnicoDAO;
    private static FacturaDAOImpl facturaDAO;
    private static PagoDAOImpl pagoDAO;
    private static RepuestoDAOImpl repuestoDAO;
    private static PrecioDAOImpl precioDAO;
    private static ReparacionDAOImpl reparacionDAO;
    private static VentaDAOImpl ventaDAO;
    
    public PagoDAOImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        
        marcaDAO = new MarcaDAOImpl(connection);
        nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
        modeloDAO = new ModeloDAOImpl(connection);
        ubicacionDAO = new UbicacionDAOImpl(connection);
        categoriaDAO = new CategoriaDAOImpl(connection);
        estadoDAO = new EstadoDAOImpl(connection);
        clienteDAO = new ClienteDAOImpl(connection);
        tecnicoDAO = new TecnicoDAOImpl(connection);
        facturaDAO = new FacturaDAOImpl(connection);
        pagoDAO = new PagoDAOImpl(connection);
        repuestoDAO = new RepuestoDAOImpl(connection);
        precioDAO = new PrecioDAOImpl(connection);
        reparacionDAO = new ReparacionDAOImpl(connection);
        ventaDAO = new VentaDAOImpl(connection);
        
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
        configuracion.crearTablaModelo();
        configuracion.crearTablaUbicacion();
        configuracion.crearTablaCategoria();
        configuracion.crearTablaEstado();
        configuracion.crearTablaCliente();
        configuracion.crearTablaTecnico();
        configuracion.crearTablaFactura();
        configuracion.crearTablaPago();
        configuracion.crearTablaVenta();
        configuracion.crearTablaRepuesto();
        configuracion.crearTablaPrecio();
        configuracion.crearTablaReparacion();
        configuracion.crearTablaVentaRepuesto();
        configuracion.crearTablaReparacionRepuesto();
        
    }
    
    @AfterEach
    public void tearDown() {
        
        configuracion.eliminarTablaReparacionRepuesto();
        configuracion.eliminarTablaVentaRepuesto();
        configuracion.eliminarTablaReparacion();
        configuracion.eliminarTablaPrecio();
        configuracion.eliminarTablaRepuesto();
        configuracion.eliminarTablaVenta();
        configuracion.eliminarTablaPago();
        configuracion.eliminarTablaFactura();
        configuracion.eliminarTablaTecnico();
        configuracion.eliminarTablaCliente();
        configuracion.eliminarTablaEstado();
        configuracion.eliminarTablaCategoria();
        configuracion.eliminarTablaUbicacion();
        configuracion.eliminarTablaModelo();
        configuracion.eliminarTablaNombreRepuesto();
        configuracion.eliminarTablaMarca();
        
    }

    @Test
    public void eliminarTablas(){
        configuracion.eliminarTablaReparacionRepuesto();
        configuracion.eliminarTablaVentaRepuesto();
        configuracion.eliminarTablaReparacion();
        configuracion.eliminarTablaPrecio();
        configuracion.eliminarTablaRepuesto();
        configuracion.eliminarTablaVenta();
        configuracion.eliminarTablaPago();
        configuracion.eliminarTablaFactura();
        configuracion.eliminarTablaTecnico();
        configuracion.eliminarTablaCliente();
        configuracion.eliminarTablaEstado();
        configuracion.eliminarTablaCategoria();
        configuracion.eliminarTablaUbicacion();
        configuracion.eliminarTablaModelo();
        configuracion.eliminarTablaNombreRepuesto();
        configuracion.eliminarTablaMarca();
    }
    
    @Test
    public void pruebaCrearPago(){
        Factura factura = new Factura(1, "Pagado", new BigDecimal("3000"));
        Factura factura1 = new Factura(2, "No Pagado", new BigDecimal("5000"));
        facturaDAO.crearFactura(factura);
        facturaDAO.crearFactura(factura1);
        Pago pago = new Pago(1, factura, new BigDecimal("3000"), LocalDateTime.now(), "nada");
        Pago pago1 = new Pago(2, factura1, new BigDecimal("5000"), LocalDateTime.now(), "algo");
        pagoDAO.crearPago(pago);
        pagoDAO.crearPago(pago1);
    }
    
    @Test
    public void pruebaObtenerPagos(){
        pruebaCrearPago();
        List<Pago> listaPagos = pagoDAO.obtenerPagos();
        
        assertEquals(1, listaPagos.get(0).getId_pago());
        assertEquals("nada", listaPagos.get(0).getDetalle());
        assertEquals(2, listaPagos.get(1).getId_pago());
        assertEquals("algo", listaPagos.get(1).getDetalle());
    }
    
    @Test
    public void pruebaObtenerPago(){
        pruebaCrearPago();
        Pago pago = pagoDAO.obtenerPago(2);
        assertEquals(1, pago.getId_pago());
        assertEquals("nada", pago.getDetalle());
    }
    
    @Test
    public void pruebaModificarPagos(){
        pruebaCrearPago();
        Pago pago = pagoDAO.obtenerPago(1);
        pago.setDetalle("otra cosa");
        pagoDAO.actualizarPago(pago);
        pago = null;
        
        pagoDAO.obtenerPago(1);
        List<Pago> listaPagos = pagoDAO.obtenerPagos();
        
        assertEquals(1, listaPagos.get(0).getId_pago());
        assertEquals("otra cosa", listaPagos.get(0).getDetalle());
        assertEquals(2, listaPagos.get(1).getId_pago());
        assertEquals("algo", listaPagos.get(1).getDetalle());
    }
    
    @Test
    public void pruebaEliminarPagos(){
        pruebaCrearPago();
        pagoDAO.eliminarPago(1);
        List<Pago> listaPagos = pagoDAO.obtenerPagos();
        assertEquals(1, listaPagos.size());
        assertEquals(2, listaPagos.get(0).getId_pago());
    }
}
