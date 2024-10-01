package app;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import controller.CategoriaController;
import controller.ClienteController;
import controller.EstadoController;
import controller.MarcaController;
import controller.ModeloController;
import controller.NombreRepuestoController;
import controller.ReparacionController;
import controller.RepuestoController;
import controller.TecnicoController;
import controller.UbicacionController;
import controller.VentaController;
import dao.impl.CategoriaDAOImpl;
import dao.impl.ClienteDAOImpl;
import dao.impl.EstadoDAOImpl;
import dao.impl.MarcaDAOImpl;
import dao.impl.ModeloDAOImpl;
import dao.impl.NombreRepuestoDAOImpl;
import dao.impl.PrecioDAOImpl;
import dao.impl.ReparacionDAOImpl;
import dao.impl.ReparacionRepuestoDAOImpl;
import dao.impl.RepuestoDAOImpl;
import dao.impl.TecnicoDAOImpl;
import dao.impl.UbicacionDAOImpl;
import dao.impl.VentaDAOImpl;
import dao.impl.VentaRepuestoDAOImpl;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JFrame;
import service.CategoriaService;
import service.ClienteService;
import service.EstadoService;
import service.MarcaService;
import service.ModeloService;
import service.NombreRepuestoService;
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
    
    private static ClienteService clienteService;
    private static RepuestoService repuestoService;
    private static ReparacionService reparacionService;
    private static VentaService ventaService;
    private static TecnicoService tecnicoService;
    
    private static ClienteController clienteController;
    private static RepuestoController repuestoController;
    private static TecnicoController tecnicoController;
    
    public static void main(String[] args) throws ClassNotFoundException {  
        ConexionDataBase conexionDataBase = new ConexionDataBase();
        Connection connection = conexionDataBase.getConexionDBH2();
        
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
        
        
        ClienteService clienteService = new ClienteService(clienteDAO, ventaDAO, reparacionDAO);
        RepuestoService repuestoService = new RepuestoService(repuestoDAO, precioDAO);
        MarcaService marcaService = new MarcaService(marcaDAO, repuestoDAO);
        ModeloService modeloService = new ModeloService(modeloDAO);
        NombreRepuestoService nombreRepuestoService = new NombreRepuestoService(nombreRepuestoDAO);
        UbicacionService ubicacionService = new UbicacionService(ubicacionDAO, repuestoDAO);
        CategoriaService categoriaService = new CategoriaService(categoriaDAO, repuestoDAO, reparacionDAO);
        EstadoService estadoService = new EstadoService(estadoDAO, reparacionDAO);
        PrecioService precioService = new PrecioService(precioDAO);
        VentaService ventaService = new VentaService(ventaDAO, repuestoDAO, ventaRepuestoDAO, connection);
        ReparacionService reparacionService = new ReparacionService(reparacionDAO, repuestoDAO, reparacionRepuestoDAO, connection);
        TecnicoService tecnicoService = new TecnicoService(tecnicoDAO, ventaDAO, reparacionDAO);
        
        
        MarcaController marcaController = new MarcaController(marcaService);
        NombreRepuestoController nombreRepuestoController = new NombreRepuestoController(nombreRepuestoService);
        UbicacionController ubicacionController = new UbicacionController(ubicacionService);
        CategoriaController categoriaController = new CategoriaController(categoriaService);
        EstadoController estadoController = new EstadoController(estadoService);
        ModeloController modeloController = new ModeloController(modeloService);
        
        ClienteController clienteController = new ClienteController(clienteService);
        RepuestoController repuestoController = new RepuestoController(nombreRepuestoService, repuestoService, marcaService, categoriaService, ubicacionService, precioService, modeloService);
        VentaController ventaController = new VentaController(ventaService, clienteService, repuestoController);
        ReparacionController reparacionController = new ReparacionController(reparacionService, categoriaService, clienteService, estadoService, repuestoController);
        TecnicoController tecnicoController = new TecnicoController(tecnicoService);
        
        /*
            id_venta 
            cantidad 
            fecha_venta
            precioFinal
            id_cliente
        */
        
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
                reparacionController
        );
        
        app.setResizable(false);
        app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        app.setVisible(true);
        //app.setLocation(-8, 0);
        app.setLocationRelativeTo(null);
    }
}
