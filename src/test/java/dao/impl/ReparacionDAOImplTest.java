package dao.impl;

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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.CategoriaService;
import service.ClienteService;
import service.EstadoService;
import service.MarcaService;
import service.ModeloService;
import service.NombreRepuestoService;
import service.PagoService;
import service.PrecioService;
import service.ReparacionService;
import service.RepuestoService;
import service.TecnicoService;
import service.UbicacionService;
import service.VentaService;

public class ReparacionDAOImplTest {
    
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
    
    public ReparacionDAOImplTest() {
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
        /*
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
        */
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
    public void crearTablas() {
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
    
    @Test
    public void pruebaCrearReparacion() throws SQLException{
        //Marca
        Marca marca = new Marca(1, "GENERICO", new ArrayList<>());
        Marca marca1 = new Marca(2, "PANASONIC", new ArrayList<>());
        Marca marca2 = new Marca(3, "LG", new ArrayList<>());
        Marca marca3 = new Marca(4, "ARIETE", new ArrayList<>());
        Marca marca4 = new Marca(5, "WHIRLPOOL", new ArrayList<>());
        Marca marca5 = new Marca(6, "PHILIPS", new ArrayList<>());
        marcaDAO.crearMarca(marca);
        marcaDAO.crearMarca(marca1);
        marcaDAO.crearMarca(marca2);
        marcaDAO.crearMarca(marca3);
        marcaDAO.crearMarca(marca4);
        marcaDAO.crearMarca(marca5);
        //NombreRepuesto +
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "BOBINA");
        NombreRepuesto nombreRepuesto1 = new NombreRepuesto(2, "FUENTE");
        NombreRepuesto nombreRepuesto2 = new NombreRepuesto(3, "ACOPLE");
        NombreRepuesto nombreRepuesto3 = new NombreRepuesto(4, "ACTUADOR");
        NombreRepuesto nombreRepuesto4 = new NombreRepuesto(5, "AGITADOR");
        NombreRepuesto nombreRepuesto5 = new NombreRepuesto(6, "EMBRAGUE");
        NombreRepuesto nombreRepuesto6 = new NombreRepuesto(7, "SEMICONDUCTOR");
        NombreRepuesto nombreRepuesto7 = new NombreRepuesto(8, "SELLO DE AGUA");
        NombreRepuesto nombreRepuesto8 = new NombreRepuesto(9, "TERMINAL");
        NombreRepuesto nombreRepuesto9 = new NombreRepuesto(10, "PLAQUETA");
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto1);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto2);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto3);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto4);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto5);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto6);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto7);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto8);
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto9);
        //Ubicacion 
        Ubicacion ubicacion = new Ubicacion(1, "DEPOSITO", new ArrayList<>());
        Ubicacion ubicacion1 = new Ubicacion(2, "PISO 1", new ArrayList<>());
        Ubicacion ubicacion2 = new Ubicacion(3, "PISO 2", new ArrayList<>());
        Ubicacion ubicacion3 = new Ubicacion(4, "MOSTRADOR", new ArrayList<>());
        Ubicacion ubicacion4 = new Ubicacion(5, "VIDRIERA", new ArrayList<>());
        Ubicacion ubicacion5 = new Ubicacion(6, "ALMACEN", new ArrayList<>());
        ubicacionDAO.crearUbicacion(ubicacion);
        ubicacionDAO.crearUbicacion(ubicacion1);
        ubicacionDAO.crearUbicacion(ubicacion2);
        ubicacionDAO.crearUbicacion(ubicacion3);
        ubicacionDAO.crearUbicacion(ubicacion4);
        ubicacionDAO.crearUbicacion(ubicacion5);
        //Categoria
        Categoria categoria = new Categoria(1, "LAVARROPAS", new ArrayList<>(), new ArrayList<>());
        Categoria categoria1 = new Categoria(2, "HELADERA", new ArrayList<>(), new ArrayList<>());
        Categoria categoria2 = new Categoria(3, "AIRE ACONDICIONADO", new ArrayList<>(), new ArrayList<>());
        Categoria categoria3 = new Categoria(4, "LINEA BLANCA", new ArrayList<>(), new ArrayList<>());
        categoriaDAO.crearCategoria(categoria);
        categoriaDAO.crearCategoria(categoria1);
        categoriaDAO.crearCategoria(categoria2);
        categoriaDAO.crearCategoria(categoria3);
        //Estado
        
        Estado estado = new Estado(1, "INGRESADO", new ArrayList<>());
        Estado estado1 = new Estado(2, "EN REVISION", new ArrayList<>());
        Estado estado2 = new Estado(3, "PRESUPUESTO EMITIDO", new ArrayList<>());
        Estado estado3 = new Estado(4, "APROBADO PARA REPARACION", new ArrayList<>());
        Estado estado4 = new Estado(5, "EN REPARACION", new ArrayList<>());
        Estado estado5 = new Estado(6, "REPARACION", new ArrayList<>());
        Estado estado6 = new Estado(7, "LISTO PARA RETIRAR", new ArrayList<>());
        Estado estado7 = new Estado(8, "DDEVUELTO SIN REPARAR", new ArrayList<>());
        Estado estado8 = new Estado(9, "CANCELADO", new ArrayList<>());
        estadoDAO.crearEstado(estado);
        estadoDAO.crearEstado(estado1);
        estadoDAO.crearEstado(estado2);
        estadoDAO.crearEstado(estado3);
        estadoDAO.crearEstado(estado4);
        estadoDAO.crearEstado(estado5);
        estadoDAO.crearEstado(estado6);
        estadoDAO.crearEstado(estado7);
        estadoDAO.crearEstado(estado8);
        //Modelo
        Modelo modelo = new Modelo(1, "PLUS");
        Modelo modelo1 = new Modelo(2, "PLUS ULTRA");
        Modelo modelo2 = new Modelo(3, "GOLD");
        Modelo modelo3 = new Modelo(4, "PLATINUM");
        Modelo modelo4 = new Modelo(5, "WHITE");
        modeloDAO.crearModelo(modelo);
        modeloDAO.crearModelo(modelo1);
        modeloDAO.crearModelo(modelo2);
        modeloDAO.crearModelo(modelo3);
        modeloDAO.crearModelo(modelo4);
        //Pagado
        /*
        Factura factura1 = new Factura(1, "PAGADO", new BigDecimal("3000"));
        Factura factura2 = new Factura(2, "No Pagado", new BigDecimal("5000"));
        Factura factura3 = new Factura(3, "Parcial", new BigDecimal("90000"));
        Factura factura4 = new Factura(4, "No Pagado", new BigDecimal("55000"));
        Factura factura5 = new Factura(5, "Pagado", new BigDecimal("30000"));
        Factura factura6 = new Factura(6, "Parcial", new BigDecimal("15000"));
        Factura factura7 = new Factura(7, "Parcial", new BigDecimal("13000"));
        Factura factura8 = new Factura(8, "No Pagado", new BigDecimal("5000"));
        Factura factura9 = new Factura(9, "Parcial", new BigDecimal("33000"));
        Factura factura10 = new Factura(10, "No Pagado", new BigDecimal("51000"));
        facturaDAO.crearFactura(factura1);
        facturaDAO.crearFactura(factura2);
        facturaDAO.crearFactura(factura3);
        facturaDAO.crearFactura(factura4);
        facturaDAO.crearFactura(factura5);
        facturaDAO.crearFactura(factura6);
        facturaDAO.crearFactura(factura7);
        facturaDAO.crearFactura(factura8);
        facturaDAO.crearFactura(factura9);
        facturaDAO.crearFactura(factura10);
        //Pago
        Pago pago1 = new Pago(1, factura1, new BigDecimal("3000"), LocalDateTime.now(), "nada");
        Pago pago2 = new Pago(2, factura2, new BigDecimal("5000"), LocalDateTime.now(), "algo");
        Pago pago3 = new Pago(3, factura3, new BigDecimal("2000"), LocalDateTime.now(), "nada");
        Pago pago4 = new Pago(4, factura4, new BigDecimal("4000"), LocalDateTime.now(), "algo");
        Pago pago5 = new Pago(5, factura5, new BigDecimal("10000"), LocalDateTime.now(), "nada");
        Pago pago6 = new Pago(6, factura6, new BigDecimal("15000"), LocalDateTime.now(), "algo");
        Pago pago7 = new Pago(7, factura7, new BigDecimal("9000"), LocalDateTime.now(), "nada");
        Pago pago8 = new Pago(8, factura8, new BigDecimal("15500"), LocalDateTime.now(), "algo");
        Pago pago9 = new Pago(9, factura9, new BigDecimal("10000"), LocalDateTime.now(), "nada");
        Pago pago10 = new Pago(10, factura10, new BigDecimal("7000"), LocalDateTime.now(), "algo");
        pagoDAO.crearPago(pago1);
        pagoDAO.crearPago(pago2);
        pagoDAO.crearPago(pago3);
        pagoDAO.crearPago(pago4);
        pagoDAO.crearPago(pago5);
        pagoDAO.crearPago(pago6);
        pagoDAO.crearPago(pago7);
        pagoDAO.crearPago(pago8);
        pagoDAO.crearPago(pago9);
        pagoDAO.crearPago(pago10);
        //Cliente
        */
        Cliente cliente = new Cliente(1, "Carlos", "Perez", "3834123456", "Valle Viejo", new ArrayList<>(), new ArrayList<>());
        Cliente cliente1 = new Cliente(2, "Maria", "Carrizo", "3834654321", "Achachay", new ArrayList<>(), new ArrayList<>());
        Cliente cliente2 = new Cliente(1, "Franco", "Espindola", "3834001234", "Eva Peron", new ArrayList<>(), new ArrayList<>());
        Cliente cliente3 = new Cliente(2, "Cristina", "Aguilera", "3834874457", "Valle Viejo", new ArrayList<>(), new ArrayList<>());
        Cliente cliente4 = new Cliente(1, "Miriam", "Nieva", "3834987445", "1000 Viviendas", new ArrayList<>(), new ArrayList<>());
        Cliente cliente5 = new Cliente(2, "Lisandro", "Martinez", "3834132345", "Achachay", new ArrayList<>(), new ArrayList<>());
        Cliente cliente6 = new Cliente(1, "Pablo", "Perez", "3834445778", "1000 Viviendas", new ArrayList<>(), new ArrayList<>());
        Cliente cliente7 = new Cliente(2, "Judith", "Argañaraz", "3834998665", "Valle Viejo", new ArrayList<>(), new ArrayList<>());
        Cliente cliente8 = new Cliente(1, "Marla", "Perea", "3834774477", "Eva Peron", new ArrayList<>(), new ArrayList<>());
        Cliente cliente9 = new Cliente(2, "Vanesa", "Rizzardo", "3834887552", "1000 Viviendas", new ArrayList<>(), new ArrayList<>());
        clienteDAO.crearCliente(cliente);
        clienteDAO.crearCliente(cliente1);
        clienteDAO.crearCliente(cliente2);
        clienteDAO.crearCliente(cliente3);
        clienteDAO.crearCliente(cliente4);
        clienteDAO.crearCliente(cliente5);
        clienteDAO.crearCliente(cliente6);
        clienteDAO.crearCliente(cliente7);
        clienteDAO.crearCliente(cliente8);
        clienteDAO.crearCliente(cliente9);
        //Tecnico
        Tecnico tecnico = new Tecnico(1, "Mario", "Montenegro", "3834557788", "Centro", new ArrayList<>());
        Tecnico tecnico1 = new Tecnico(2, "Pablo", "Castro", "3834650078", "Sur", new ArrayList<>());
        Tecnico tecnico2 = new Tecnico(3, "Silvio", "Martinez", "3834882104", "Centro", new ArrayList<>());
        tecnicoDAO.crearTecnico(tecnico);
        tecnicoDAO.crearTecnico(tecnico1);
        tecnicoDAO.crearTecnico(tecnico2);
        //Repuesto +
        /*
        Repuesto repuesto = new Repuesto(1, 10, nombreRepuesto, marca, categoria, modelo, new ArrayList<>(), ubicacion, "A000");
        Repuesto repuesto1 = new Repuesto(2, 20, nombreRepuesto1, marca1, categoria1, modelo1, new ArrayList<>(), ubicacion1, "A001");
        Repuesto repuesto2 = new Repuesto(3, 45, nombreRepuesto2, marca2, categoria2, modelo2, new ArrayList<>(), ubicacion2, "A002");
        Repuesto repuesto3 = new Repuesto(4, 100, nombreRepuesto3, marca3, categoria3, modelo3, new ArrayList<>(), ubicacion3, "A007");
        Repuesto repuesto4 = new Repuesto(5, 90, nombreRepuesto4, marca4, categoria2, modelo4, new ArrayList<>(), ubicacion4, "A015");
        Repuesto repuesto5 = new Repuesto(6, 80, nombreRepuesto5, marca5, categoria3, modelo2, new ArrayList<>(), ubicacion5, "A032");
        repuestoDAO.crearRepuesto(repuesto);
        repuestoDAO.crearRepuesto(repuesto1);
        repuestoDAO.crearRepuesto(repuesto2);
        repuestoDAO.crearRepuesto(repuesto3);
        repuestoDAO.crearRepuesto(repuesto4);
        repuestoDAO.crearRepuesto(repuesto5);
        //Precio
        LocalDateTime fecha1 = LocalDateTime.of(2024, 9, 20, 8, 42);
        LocalDateTime fecha2 = LocalDateTime.of(2024, 9, 22, 16, 50);
        Precio precio1 = new Precio(1, repuesto, fecha1, new BigDecimal("3000"));
        Precio precio2 = new Precio(2, repuesto, fecha2, new BigDecimal("4000"));
        Precio precio3 = new Precio(3, repuesto1, fecha1, new BigDecimal("7000"));
        Precio precio4 = new Precio(4, repuesto1, fecha2, new BigDecimal("8000"));
        Precio precio5 = new Precio(5, repuesto2, fecha1, new BigDecimal("10000"));
        Precio precio6 = new Precio(6, repuesto2, fecha2, new BigDecimal("12000"));
        Precio precio7 = new Precio(7, repuesto3, fecha1, new BigDecimal("15000"));
        Precio precio8 = new Precio(8, repuesto3, fecha2, new BigDecimal("20000"));
        Precio precio9 = new Precio(9, repuesto4, fecha1, new BigDecimal("25000"));
        Precio precio10 = new Precio(10, repuesto5, fecha2, new BigDecimal("30000"));
        precioDAO.crearPrecio(precio1);
        precioDAO.crearPrecio(precio2);
        precioDAO.crearPrecio(precio3);
        precioDAO.crearPrecio(precio4);
        precioDAO.crearPrecio(precio5);
        precioDAO.crearPrecio(precio6);
        precioDAO.crearPrecio(precio7);
        precioDAO.crearPrecio(precio8);
        precioDAO.crearPrecio(precio9);
        precioDAO.crearPrecio(precio10);
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
        Reparacion reparacion3 = new Reparacion(3, new BigDecimal("80000"), "no gira", fecha5, fecha0, factura3, categoria2, cliente2, estado2, tecnico2); 
        Reparacion reparacion4 = new Reparacion(4, new BigDecimal("9000"), "", fecha6, fecha7, factura4, categoria3, cliente3, estado3, tecnico1); 
        Reparacion reparacion5 = new Reparacion(5, new BigDecimal("9000"), "pierde por manguera", fecha7, fecha7, factura5, categoria, cliente4, estado4, tecnico); 
        Reparacion reparacion6 = new Reparacion(6, new BigDecimal("15000"), "no tiene gas", fecha8, fecha0, factura6, categoria, cliente2, estado5, tecnico); 
        Reparacion reparacion7 = new Reparacion(7, new BigDecimal("10000"), "no enfria", fecha9, fecha10, factura7, categoria, cliente4, estado6, tecnico); 
        Reparacion reparacion8 = new Reparacion(8, new BigDecimal("10000"), "", fecha10, fecha11, factura8, categoria, cliente2, estado7, tecnico2); 
        Reparacion reparacion9 = new Reparacion(9, new BigDecimal("6000"), "no cierra la tapa", fecha11, fecha0, factura9, categoria, cliente, estado8, tecnico1); 
        Reparacion reparacion10 = new Reparacion(10, new BigDecimal("15000"), "plaqueta dañada", fecha12, fecha0, factura10, categoria, cliente8, estado1, tecnico2);
        
        //ListaRepuestos Reparacion
        List<Repuesto> listaRepuestos0 = new ArrayList<>();
        List<Repuesto> listaRepuestos1 = new ArrayList<>();
        listaRepuestos1.add(repuesto1);
        listaRepuestos1.add(repuesto1);
        listaRepuestos1.add(repuesto2);
        List<Repuesto> listaRepuestos2 = new ArrayList<>();
        listaRepuestos2.add(repuesto3);
        listaRepuestos2.add(repuesto3);
        listaRepuestos2.add(repuesto4);
        listaRepuestos2.add(repuesto4);
        listaRepuestos2.add(repuesto2);
        List<Repuesto> listaRepuestos3 = new ArrayList<>();
        listaRepuestos3.add(repuesto2);
        List<Repuesto> listaRepuestos4 = new ArrayList<>();
        listaRepuestos4.add(repuesto1);
        //ReparacionRepuesto
        reparacionService.agregarReparacion(reparacion1, listaRepuestos1);
        reparacionService.agregarReparacion(reparacion2, listaRepuestos0);
        reparacionService.agregarReparacion(reparacion3, listaRepuestos2);
        reparacionService.agregarReparacion(reparacion4, listaRepuestos0);
        reparacionService.agregarReparacion(reparacion5, listaRepuestos0);
        reparacionService.agregarReparacion(reparacion6, listaRepuestos3);
        reparacionService.agregarReparacion(reparacion7, listaRepuestos4);
        reparacionService.agregarReparacion(reparacion8, listaRepuestos0);
        reparacionService.agregarReparacion(reparacion9, listaRepuestos0);
        reparacionService.agregarReparacion(reparacion10, listaRepuestos0);
           
        //Venta
        Venta venta = new Venta(1, 3, fecha9, cliente, new BigDecimal("16000"));
        Venta venta1 = new Venta(2, 5, fecha10, cliente1, new BigDecimal("72000"));
        Venta venta2 = new Venta(3, 1, fecha11, cliente2, new BigDecimal("8000"));
        Venta venta3 = new Venta(4, 1, fecha12, cliente3, new BigDecimal("4000"));
        //ListaRepuestos Venta
        List<Repuesto> listaRepuestos5 = new ArrayList<>();
        listaRepuestos1.add(repuesto1);
        listaRepuestos1.add(repuesto1);
        listaRepuestos1.add(repuesto2);
        List<Repuesto> listaRepuestos6 = new ArrayList<>();
        listaRepuestos2.add(repuesto3);
        listaRepuestos2.add(repuesto3);
        listaRepuestos2.add(repuesto4);
        listaRepuestos2.add(repuesto4);
        listaRepuestos1.add(repuesto2);
        List<Repuesto> listaRepuestos7 = new ArrayList<>();
        listaRepuestos3.add(repuesto2);
        List<Repuesto> listaRepuestos8 = new ArrayList<>();
        listaRepuestos3.add(repuesto1);
        //VentaRepuesto
        ventaController.agregarVenta(venta, listaRepuestos5);
        ventaController.agregarVenta(venta1, listaRepuestos6);
        ventaController.agregarVenta(venta2, listaRepuestos7);
        ventaController.agregarVenta(venta3, listaRepuestos8);
        */
    }
    
    @Test
    public void pruebaObtenerReparaciones() throws SQLException{
        pruebaCrearReparacion();
        List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparaciones();
        
        assertEquals(1, listaReparaciones.get(0).getId_reparacion());
        assertEquals("Rota la tapa", listaReparaciones.get(0).getDetalles());
        assertEquals("Perez", listaReparaciones.get(0).getCliente().getApellido());
        
        assertEquals(2, listaReparaciones.get(1).getId_reparacion());
        assertEquals("Color plateado", listaReparaciones.get(1).getDetalles());
        assertEquals("Carrizo", listaReparaciones.get(1).getCliente().getApellido());
    }
    
    @Test
    public void pruebaObtenerReparacion() throws SQLException{
        pruebaCrearReparacion();
        Reparacion reparacion = reparacionDAO.obtenerReparacion(2);
        
        assertEquals(2, reparacion.getId_reparacion());
        assertEquals("Color plateado", reparacion.getDetalles());
        assertEquals("En Revision", reparacion.getEstado().getNombre_estado());
    }
    /*
    @Test
    public void pruebaActualizarReparacion() throws SQLException{
        pruebaCrearReparacion();
        Reparacion reparacion = reparacionDAO.obtenerReparacion(1);
        reparacion.setDetalles("Sin tapa");
        System.out.println(reparacion.getDetalles());
        reparacionDAO.actualizarReparacion(reparacion);
        reparacion = new Reparacion();
        reparacion = reparacionDAO.obtenerReparacion(1);
        System.out.println(reparacion.getDetalles());
        
        assertEquals(1, reparacion.getId_reparacion());
        assertEquals("Sin tapa", reparacion.getDetalles());
    }
    */
    //Eliminar utiliza metodo cascada
    /*
    @Test
    public void pruebaEliminarReparacion() throws SQLException{
        pruebaCrearReparacion();
        reparacionDAO.eliminarReparacion(1);
        List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparaciones();
        
        assertEquals(9, listaReparaciones.size());
        assertEquals("Color plateado", listaReparaciones.get(0).getDetalles());
    }
    */
    @Test
    public void pruebaObtenerReparacionesPorIdCliente() throws SQLException{
        pruebaCrearReparacion();
        List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparacionesPorIdCliente(1);
        
        assertEquals(1, listaReparaciones.get(0).getCliente().getId_cliente());
        assertEquals("Rota la tapa", listaReparaciones.get(0).getDetalles());
    }
    
    @Test
    public void pruebaObtenerReparacionesPorIdCategoria() throws SQLException{
        pruebaCrearReparacion();
        List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparacionesPorIdCategoria(2);
        
        assertEquals(2, listaReparaciones.get(0).getCliente().getId_cliente());
        assertEquals("Color plateado", listaReparaciones.get(0).getDetalles());
    }
}