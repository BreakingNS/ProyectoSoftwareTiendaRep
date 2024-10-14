package app;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import controller.CategoriaController;
import controller.ClienteController;
import controller.EstadoController;
import controller.FacturaController;
import controller.MarcaController;
import controller.ModeloController;
import controller.NombreRepuestoController;
import controller.PagoController;
import controller.ReparacionController;
import controller.RepuestoController;
import controller.TecnicoController;
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
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketImpl;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import service.CategoriaService;
import service.ClienteService;
import service.EstadoService;
import service.FacturaService;
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
import view.App;


public class ProyectoSoftwareTiendaRep {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    
    private static MarcaDAOImpl marcaDAO;
    private static ModeloDAOImpl modeloDAO;
    private static NombreRepuestoDAOImpl nombreRepuestoDAO;
    private static UbicacionDAOImpl ubicacionDAO;
    private static CategoriaDAOImpl categoriaDAO;
    private static EstadoDAOImpl estadoDAO;
    private static ClienteDAOImpl clienteDAO;
    private static RepuestoDAOImpl repuestoDAO;
    private static PrecioDAOImpl precioDAO;
    private static ReparacionDAOImpl reparacionDAO;
    private static VentaDAOImpl ventaDAO;
    private static ReparacionRepuestoDAOImpl reparacionRepuestoDAO;
    private static VentaRepuestoDAOImpl ventaRepuestoDAO;
    private static TecnicoDAOImpl tecnicoDAO;
    private static FacturaDAOImpl facturaDAO;
    private static PagoDAOImpl pagoDAO;
    
    private static ClienteService clienteService;
    private static RepuestoService repuestoService;
    private static MarcaService marcaService;
    private static ModeloService modeloService;
    private static NombreRepuestoService nombreRepuestoService;
    private static UbicacionService ubicacionService;
    private static CategoriaService categoriaService;
    private static EstadoService estadoService;
    private static PrecioService precioService;
    private static VentaService ventaService;
    private static ReparacionService reparacionService;
    private static TecnicoService tecnicoService;
    private static FacturaService facturaService;
    private static PagoService pagoService;
    
    private static MarcaController marcaController;
    private static NombreRepuestoController nombreRepuestoController;
    private static UbicacionController ubicacionController;
    private static CategoriaController categoriaController;
    private static EstadoController estadoController;
    private static ModeloController modeloController;
    private static FacturaController facturaController;
    private static PagoController pagoController;
    
    private static ClienteController clienteController;
    private static RepuestoController repuestoController;
    private static VentaController ventaController;
    private static ReparacionController reparacionController;
    private static TecnicoController tecnicoController;
    
    private static final int PORT = 9999; // Puerto arbitrario para chequear

    public static void main(String[] args) throws ClassNotFoundException {
        // Chequeo para ver si el programa ya está en ejecución
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            // Si llegamos aquí, significa que el puerto está disponible
            iniciarAplicacion();  // Método que contiene tu lógica principal
        } catch (IOException e) {
            // Si hay una excepción, significa que el puerto ya está en uso, lo que indica que la app ya está corriendo
            JOptionPane.showMessageDialog(null, "EL PROGRAMA YA ESTÁ EN EJECUCIÓN", "Advertencia", JOptionPane.WARNING_MESSAGE);
            System.exit(0); // Terminar el programa si ya está en ejecución
        }
    }
    
    private static void iniciarAplicacion() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        
        marcaDAO = new MarcaDAOImpl(connection);
        modeloDAO = new ModeloDAOImpl(connection);
        nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
        ubicacionDAO = new UbicacionDAOImpl(connection);
        categoriaDAO = new CategoriaDAOImpl(connection);
        estadoDAO = new EstadoDAOImpl(connection);
        clienteDAO = new ClienteDAOImpl(connection);
        repuestoDAO = new RepuestoDAOImpl(connection);
        precioDAO = new PrecioDAOImpl(connection);
        reparacionDAO = new ReparacionDAOImpl(connection);
        ventaDAO = new VentaDAOImpl(connection);
        reparacionRepuestoDAO = new ReparacionRepuestoDAOImpl(connection);
        ventaRepuestoDAO = new VentaRepuestoDAOImpl(connection);
        tecnicoDAO = new TecnicoDAOImpl(connection);
        facturaDAO = new FacturaDAOImpl(connection);
        pagoDAO = new PagoDAOImpl(connection);
        
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
        reparacionService = new ReparacionService(reparacionDAO, repuestoDAO, reparacionRepuestoDAO, facturaDAO, connection);
        tecnicoService = new TecnicoService(tecnicoDAO, ventaDAO, reparacionDAO);
        facturaService = new FacturaService(facturaDAO);
        pagoService = new PagoService(pagoDAO);
        
        marcaController = new MarcaController(marcaService);
        nombreRepuestoController = new NombreRepuestoController(nombreRepuestoService);
        ubicacionController = new UbicacionController(ubicacionService);
        categoriaController = new CategoriaController(categoriaService);
        estadoController = new EstadoController(estadoService);
        modeloController = new ModeloController(modeloService);
        facturaController = new FacturaController(facturaService);
        pagoController = new PagoController(pagoService);
        
        clienteController = new ClienteController(clienteService);
        repuestoController = new RepuestoController(nombreRepuestoService, repuestoService, marcaService, categoriaService, ubicacionService, precioService, modeloService, tecnicoService);
        ventaController = new VentaController(ventaService, clienteService, repuestoController);
        reparacionController = new ReparacionController(reparacionService, categoriaService, clienteService, estadoService, tecnicoService, pagoService, repuestoController);
        tecnicoController = new TecnicoController(tecnicoService);
        
        App app = new App(connection, 
                conexionDataBase, 
                clienteController, 
                repuestoController, 
                marcaController, 
                modeloController,
                nombreRepuestoController, 
                ubicacionController, 
                tecnicoController,
                categoriaController,
                estadoController,
                ventaController,
                reparacionController,
                facturaController,
                pagoController
        );
        
        app.setResizable(false);
        app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        app.setVisible(true);
        app.setLocation(-8, 0);
    }
}

