package service;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import controller.CategoriaController;
import controller.ClienteController;
import controller.EstadoController;
import controller.MarcaController;
import controller.NombreRepuestoController;
import controller.ReparacionController;
import controller.RepuestoController;
import controller.UbicacionController;
import controller.VentaController;
import dao.impl.CategoriaDAOImpl;
import dao.impl.ClienteDAOImpl;
import dao.impl.EstadoDAOImpl;
import dao.impl.FacturaDAOImpl;
import dao.impl.MarcaDAOImpl;
import dao.impl.ModeloDAOImpl;
import dao.impl.NombreRepuestoDAOImpl;
import dao.impl.PagoDAOImpl;
import dao.impl.PrecioDAOImpl;
import dao.impl.ReparacionDAOImpl;
import dao.impl.ReparacionRepuestoDAOImpl;
import dao.impl.RepuestoDAOImpl;
import dao.impl.TecnicoDAOImpl;
import dao.impl.UbicacionDAOImpl;
import dao.impl.VentaDAOImpl;
import dao.impl.VentaRepuestoDAOImpl;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Categoria;
import model.Cliente;
import model.Estado;
import model.Factura;
import model.Marca;
import model.Modelo;
import model.NombreRepuesto;
import model.Pago;
import model.Precio;
import model.Reparacion;
import model.Repuesto;
import model.Tecnico;
import model.Ubicacion;
import model.Venta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoriaServiceTest {
    
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
    private static ReparacionRepuestoDAOImpl reparacionRepuestoDAO;
    private static VentaRepuestoDAOImpl ventaRepuestoDAO;
    
    private static ClienteService clienteService;
    private static RepuestoService repuestoService;
    private static ReparacionService reparacionService;
    private static VentaService ventaService;
    private static MarcaService marcaService;
    private static ModeloService modeloService;
    private static NombreRepuestoService nombreRepuestoService;
    private static UbicacionService ubicacionService;
    private static CategoriaService categoriaService;
    private static EstadoService estadoService;
    private static PrecioService precioService;
    private static TecnicoService tecnicoService;
    private static PagoService pagoService;
    
    private static VentaController ventaController;
    private static MarcaController marcaController;
    private static NombreRepuestoController nombreRepuestoController;
    private static UbicacionController ubicacionController;
    private static EstadoController estadoController;
    
    private static CategoriaController categoriaController;
    private static ClienteController clienteController;
    private static RepuestoController repuestoController;
    private static ReparacionController reparacionController;
    
    public CategoriaServiceTest() {
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
        reparacionRepuestoDAO = new ReparacionRepuestoDAOImpl(connection);
        ventaRepuestoDAO = new VentaRepuestoDAOImpl(connection);
        reparacionService = new ReparacionService(reparacionDAO, repuestoDAO, reparacionRepuestoDAO, facturaDAO, connection);
        
        clienteService = new ClienteService(clienteDAO, ventaDAO, reparacionDAO);
        repuestoService = new RepuestoService(repuestoDAO, precioDAO);
        marcaService = new MarcaService(marcaDAO, repuestoDAO);
        modeloService = new ModeloService(modeloDAO);
        nombreRepuestoService = new NombreRepuestoService(nombreRepuestoDAO);
        ubicacionService = new UbicacionService(ubicacionDAO, repuestoDAO);
        categoriaService = new CategoriaService(categoriaDAO, repuestoDAO, reparacionDAO);
        estadoService = new EstadoService(estadoDAO, reparacionDAO);
        precioService = new PrecioService(precioDAO);
        ventaService = new VentaService(ventaDAO, repuestoDAO, ventaRepuestoDAO, connection);
        tecnicoService = new TecnicoService(tecnicoDAO, ventaDAO, reparacionDAO);
        pagoService = new PagoService(pagoDAO);
        
        marcaController = new MarcaController(marcaService);
        nombreRepuestoController = new NombreRepuestoController(nombreRepuestoService);
        ubicacionController = new UbicacionController(ubicacionService);
        categoriaController = new CategoriaController(categoriaService);
        estadoController = new EstadoController(estadoService);
        
        clienteController = new ClienteController(clienteService);
        repuestoController = new RepuestoController(nombreRepuestoService, repuestoService, marcaService, categoriaService, ubicacionService, precioService, modeloService, tecnicoService);
        ventaController = new VentaController(ventaService, clienteService, repuestoController);
        reparacionController = new ReparacionController(reparacionService, categoriaService, clienteService, estadoService, tecnicoService, pagoService, repuestoController);
        
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
    public void agregarCategoria() throws SQLException{
        //Marca
        Marca marca = new Marca(1, "Fiat", new ArrayList<>());
        Marca marca1 = new Marca(2, "Renault", new ArrayList<>());
        marcaDAO.crearMarca(marca);
        marcaDAO.crearMarca(marca1);
        //NombreRepuesto +
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(1, "Bobina");
        NombreRepuesto nombreRepuesto2 = new NombreRepuesto(2, "Fuente");
        NombreRepuesto nombreRepuesto3 = new NombreRepuesto(1, "Compresor");
        NombreRepuesto nombreRepuesto4 = new NombreRepuesto(2, "Fusible");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto2);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto3);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto4);
        //Ubicacion 
        Ubicacion ubicacion = new Ubicacion(1, "Deposito", new ArrayList<>());
        Ubicacion ubicacion1 = new Ubicacion(2, "Piso 1", new ArrayList<>());
        ubicacionDAO.crearUbicacion(ubicacion);
        ubicacionDAO.crearUbicacion(ubicacion1);
        //Categoria
        Categoria categoria = new Categoria(1, "Lavarropas", new ArrayList<>(), new ArrayList<>());
        Categoria categoria1 = new Categoria(2, "Heladera", new ArrayList<>(), new ArrayList<>());
        categoriaDAO.crearCategoria(categoria);
        categoriaDAO.crearCategoria(categoria1);
        //Estado
        Estado estado = new Estado(1, "Recibido", new ArrayList<>());
        Estado estado1 = new Estado(2, "Presupuesto", new ArrayList<>());
        estadoDAO.crearEstado(estado);
        estadoDAO.crearEstado(estado1);
        //Modelo
        Modelo modelo = new Modelo(1, "Plus");
        Modelo modelo1 = new Modelo(2, "Plus Ultra");
        Modelo modelo2 = new Modelo(3, "Gold");
        Modelo modelo3 = new Modelo(4, "Platinum");
        Modelo modelo4 = new Modelo(5, "White");
        modeloDAO.crearModelo(modelo);
        modeloDAO.crearModelo(modelo1);
        modeloDAO.crearModelo(modelo2);
        modeloDAO.crearModelo(modelo3);
        modeloDAO.crearModelo(modelo4);
        //Factura
        Factura factura1 = new Factura(1, "Pagado", new BigDecimal("3000"));
        Factura factura2 = new Factura(2, "No Pagado", new BigDecimal("5000"));
        Factura factura3 = new Factura(3, "Parcial", new BigDecimal("90000"));
        Factura factura4 = new Factura(4, "No Pagado", new BigDecimal("55000"));
        Factura factura5 = new Factura(5, "Pagado", new BigDecimal("30000"));
        facturaDAO.crearFactura(factura1);
        facturaDAO.crearFactura(factura2);
        facturaDAO.crearFactura(factura3);
        facturaDAO.crearFactura(factura4);
        facturaDAO.crearFactura(factura5);
        //Pago
        Pago pago1 = new Pago(1, factura1, new BigDecimal("3000"), LocalDateTime.now(), "nada");
        Pago pago2 = new Pago(2, factura2, new BigDecimal("5000"), LocalDateTime.now(), "algo");
        Pago pago3 = new Pago(3, factura3, new BigDecimal("2000"), LocalDateTime.now(), "nada");
        Pago pago4 = new Pago(4, factura4, new BigDecimal("4000"), LocalDateTime.now(), "algo");
        Pago pago5 = new Pago(5, factura5, new BigDecimal("10000"), LocalDateTime.now(), "nada");
        pagoDAO.crearPago(pago1);
        pagoDAO.crearPago(pago2);
        pagoDAO.crearPago(pago3);
        pagoDAO.crearPago(pago4);
        pagoDAO.crearPago(pago5);
        //Cliente
        Cliente cliente = new Cliente(1, "Carlos", "Perez", "3834123456", "Valle Viejo", new ArrayList<>(), new ArrayList<>());
        Cliente cliente1 = new Cliente(2, "Maria", "Carrizo", "3834654321", "Achachay", new ArrayList<>(), new ArrayList<>());
        clienteDAO.crearCliente(cliente);
        clienteDAO.crearCliente(cliente1);
        //Tecnico
        Tecnico tecnico = new Tecnico(1, "Mario", "Montenegro", "3834557788", "Centro", new ArrayList<>());
        Tecnico tecnico1 = new Tecnico(2, "Pablo", "Castro", "3834650078", "Sur", new ArrayList<>());
        Tecnico tecnico2 = new Tecnico(3, "Silvio", "Martinez", "3834882104", "Centro", new ArrayList<>());
        tecnicoDAO.crearTecnico(tecnico);
        tecnicoDAO.crearTecnico(tecnico1);
        tecnicoDAO.crearTecnico(tecnico2);
        //Repuesto +
        Repuesto repuesto1 = new Repuesto(1, 10, nombreRepuesto1, marca, categoria, modelo, new ArrayList<>(), ubicacion, "A000");
        Repuesto repuesto2 = new Repuesto(2, 20, nombreRepuesto2, marca1, categoria1, modelo1, new ArrayList<>(), ubicacion1, "A001");
        Repuesto repuesto3 = new Repuesto(3, 45, nombreRepuesto3, marca, categoria, modelo2, new ArrayList<>(), ubicacion, "A002");
        Repuesto repuesto4 = new Repuesto(4, 100, nombreRepuesto4, marca1, categoria1, modelo3, new ArrayList<>(), ubicacion1, "A007");
        repuestoDAO.crearRepuesto(repuesto1);
        repuestoDAO.crearRepuesto(repuesto2);
        repuestoDAO.crearRepuesto(repuesto3);
        repuestoDAO.crearRepuesto(repuesto4);
        //Precio
        LocalDateTime ahora = LocalDateTime.now();
        Precio precio1 = new Precio(1, repuesto1, ahora, new BigDecimal("3000"));
        Precio precio2 = new Precio(2, repuesto1, ahora, new BigDecimal("4000"));
        Precio precio3 = new Precio(3, repuesto2, ahora, new BigDecimal("7000"));
        Precio precio4 = new Precio(4, repuesto2, ahora, new BigDecimal("8000"));
        Precio precio5 = new Precio(5, repuesto3, ahora, new BigDecimal("9000"));
        Precio precio6 = new Precio(6, repuesto3, ahora, new BigDecimal("10000"));
        Precio precio7 = new Precio(7, repuesto4, ahora, new BigDecimal("15000"));
        Precio precio8 = new Precio(8, repuesto4, ahora, new BigDecimal("18000"));
        precioDAO.crearPrecio(precio1);
        precioDAO.crearPrecio(precio2);
        precioDAO.crearPrecio(precio3);
        precioDAO.crearPrecio(precio4);
        precioDAO.crearPrecio(precio5);
        precioDAO.crearPrecio(precio6);
        precioDAO.crearPrecio(precio7);
        precioDAO.crearPrecio(precio8);
        //Reparacion
        LocalDateTime fecha3 = LocalDateTime.of(2024, 4, 2, 8, 42);
        LocalDateTime fecha4 = LocalDateTime.of(2024, 4, 22, 18, 5);
        LocalDateTime fecha5 = LocalDateTime.of(2024, 5, 12, 20, 2);
        LocalDateTime fecha6 = LocalDateTime.of(2024, 5, 4, 21, 58);
        LocalDateTime fecha7 = LocalDateTime.of(2024, 6, 9, 9, 21);
        LocalDateTime fecha8 = LocalDateTime.of(2024, 6, 4, 11, 56);
        LocalDateTime fecha9 = LocalDateTime.of(2024, 7, 23, 10, 40);
        LocalDateTime fecha10 = LocalDateTime.of(2024, 7, 21, 13, 30);
        LocalDateTime fecha11 = LocalDateTime.of(2024, 8, 7, 16, 58);
        LocalDateTime fecha12 = LocalDateTime.of(2024, 8, 30, 18, 14);
        LocalDateTime fecha0 = LocalDateTime.of(1900, 1, 1, 0, 0);
        Reparacion reparacion1 = new Reparacion(1, new BigDecimal("20000"), "Rota la tapa", fecha3, fecha4, factura1, categoria, cliente, estado, tecnico); 
        Reparacion reparacion2 = new Reparacion(2, new BigDecimal("18000"), "Color plateado", fecha4, fecha5, factura2, categoria1, cliente1, estado1, tecnico1); 
        Reparacion reparacion3 = new Reparacion(3, new BigDecimal("80000"), "no gira", fecha5, fecha0, factura3, categoria, cliente, estado, tecnico2); 
        Reparacion reparacion4 = new Reparacion(4, new BigDecimal("9000"), "", fecha6, fecha7, factura4, categoria1, cliente1, estado1, tecnico1); 
        //Venta
        Venta venta1 = new Venta(1, 20, ahora, cliente, new BigDecimal("15000"));
        Venta venta2 = new Venta(2, 50, ahora, cliente, new BigDecimal("40000"));
        Venta venta3 = new Venta(3, 10, ahora, cliente1, new BigDecimal("9000"));
        Venta venta4 = new Venta(4, 40, ahora, cliente1, new BigDecimal("50000"));
        //Listas Repuestos
        List<Repuesto> listaRepuestos1 = new ArrayList<>();
        listaRepuestos1.add(repuesto1);
        listaRepuestos1.add(repuesto1);
        listaRepuestos1.add(repuesto2);
        List<Repuesto> listaRepuestos2 = new ArrayList<>();
        listaRepuestos2.add(repuesto3);
        listaRepuestos2.add(repuesto4);
        List<Repuesto> listaRepuestos3 = new ArrayList<>();
        listaRepuestos3.add(repuesto2);
        List<Repuesto> listaRepuestos4 = new ArrayList<>();
        //Venta-Repuesto
        ventaService.agregarVenta(venta1, listaRepuestos1);
        ventaService.agregarVenta(venta2, listaRepuestos2);
        ventaService.agregarVenta(venta3, listaRepuestos3);
        ventaService.agregarVenta(venta4, listaRepuestos4);
        //Reparacion-Repuesto
        reparacionService.agregarReparacion(reparacion1, listaRepuestos1);
        reparacionService.agregarReparacion(reparacion2, listaRepuestos2);
        reparacionService.agregarReparacion(reparacion3, listaRepuestos3);
        reparacionService.agregarReparacion(reparacion4, listaRepuestos4);
    }
    
    @Test
    public void listarCategorias() throws SQLException{
        agregarCategoria();
        List<Categoria> listaCategorias = categoriaService.listarCategoriasOrdenadasPorNombre();
        
        assertEquals(2, listaCategorias.get(0).getId_categoria());
        assertEquals("Heladera", listaCategorias.get(0).getNombre_categoria());
    }
    
    @Test
    public void obtenerCategoriaPorId() throws SQLException{
        agregarCategoria();
        Categoria categoria = categoriaService.obtenerCategoriaPorId(1);
        
        assertEquals(1, categoria.getId_categoria());
        assertEquals("Lavarropas", categoria.getNombre_categoria());
    }
    
    @Test
    public void editarCategoriaPorId() throws SQLException{
        agregarCategoria();
        Categoria categoria = new Categoria(1, "Linea Blanca", new ArrayList<>(), new ArrayList<>());
        categoriaService.editarCategoriaPorId(categoria);
        categoria = categoriaService.obtenerCategoriaPorId(1);
        
        assertEquals(1, categoria.getId_categoria());
        assertEquals("Linea Blanca", categoria.getNombre_categoria());
    }
    
    //A revision, pareciera necesitar la query metodo cascada
    /*
    @Test
    public void eliminarCategoriaPorId(){
        agregarCategoria();
        categoriaService.eliminarCategoriaPorId(1);
        
        List<Categoria> listaCategorias = categoriaService.listarCategorias();
        assertEquals(1, listaCategorias.size());
        assertEquals(2, listaCategorias.get(0).getId_categoria());
        assertEquals("Heladera", listaCategorias.get(0).getNombre_categoria());
        assertEquals(1,2);
    }
    */
}
