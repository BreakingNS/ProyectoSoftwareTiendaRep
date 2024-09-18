package dao.impl;

import controller.RepuestoController;
import dao.interfaces.RepuestoDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Repuesto;
import model.Marca;
import model.NombreRepuesto;
import model.Precio;
import model.Reparacion;
import model.ReparacionRepuesto;
import model.Repuesto;
import model.Ubicacion;
import model.Venta;
import model.VentaRepuesto;
import service.RepuestoService;

public class RepuestoDAOImpl implements RepuestoDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_REPUESTO = 
            "DELETE FROM TiendaLocal.repuesto WHERE id_repuesto = ?";
    private final String SENTENCIA_OBTENER_REPUESTOS = 
            "SELECT * FROM TiendaLocal.repuesto ORDER BY id_repuesto ASC";
    private final String SENTENCIA_OBTENER_REPUESTOS_POR_ID_VENTA = 
            "SELECT * FROM TiendaLocal.venta_repuesto WHERE id_venta = ? ORDER BY id_repuesto ASC";
    private final String SENTENCIA_OBTENER_REPUESTOS_POR_ID_REPARACION = 
            "SELECT * FROM TiendaLocal.reparacion_repuesto WHERE id_reparacion = ? ORDER BY id_repuesto ASC";
    private final String SENTENCIA_OBTENER_REPUESTO = 
            "SELECT * FROM TiendaLocal.repuesto WHERE id_repuesto = ?";
    private final String SENTENCIA_OBTENER_ULTIMO_ID = 
            "SELECT MAX(id_repuesto) AS max_id FROM TiendaLocal.repuesto";
    
    private final String SENTENCIA_BUSQUEDA_DE_REPUESTO = 
            "SELECT r.id_repuesto,"
                + "r.stock, "
                + "r.id_nombrerepuesto, "
                + "r.id_marca, "
                + "r.id_categoria, "
                + "r.id_ubicacion, "
                + "MIN(p.valor) AS valor "
            + "FROM TiendaLocal.repuesto r "
            + "INNER JOIN TiendaLocal.precio p "
            + "ON r.id_repuesto = p.id_repuesto "
            + "WHERE (r.id_nombrerepuesto = ? OR ? = 0) "
            + "AND (r.id_marca = ? OR ? = 0) "
            + "AND (r.id_categoria = ? OR ? = 0) "
            + "AND (r.id_ubicacion = ? OR ? = 0) "
            + "AND (r.stock = ? OR ? = 0) "
            + "GROUP BY r.id_repuesto, "
                + "r.stock, "
                + "r.id_nombrerepuesto, "
                + "r.id_marca, "
                + "r.id_categoria,"
                + "r.id_ubicacion;";

    private final String SENTENCIA_CREAR_REPUESTO = 
            "INSERT INTO TiendaLocal.repuesto (stock, id_nombrerepuesto, id_marca, id_categoria, id_ubicacion) VALUES ( ? , ? , ? , ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_REPUESTO = 
            "UPDATE TiendaLocal.repuesto SET stock = ?, id_nombrerepuesto = ?, id_marca = ?, id_categoria = ?, id_ubicacion = ? WHERE id_repuesto = ?";

    public RepuestoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearRepuesto(Repuesto repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_REPUESTO);
            preparedStatement.setInt(1, repuesto.getStock());
            preparedStatement.setInt(2, repuesto.getNombreRepuesto().getId_nombrerepuesto());
            preparedStatement.setInt(3, repuesto.getMarca().getId_marca());
            preparedStatement.setInt(4, repuesto.getCategoria().getId_categoria());
            preparedStatement.setInt(5, repuesto.getUbicacion().getId_ubicacion());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Repuesto> obtenerRepuestos() {
        List<Repuesto> listaRepuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPUESTOS);
            ResultSet repuesto_Resultado = preparedStatement.executeQuery();
            
            while(repuesto_Resultado.next()){
                int idRepuesto = repuesto_Resultado.getInt("id_repuesto");
                int stock = repuesto_Resultado.getInt("stock");
                int idNombreRepuesto = repuesto_Resultado.getInt("id_nombrerepuesto");
                int idMarca = repuesto_Resultado.getInt("id_marca");
                int idCategoria = repuesto_Resultado.getInt("id_categoria");
                int idUbicacion = repuesto_Resultado.getInt("id_ubicacion");
                
                NombreRepuestoDAOImpl nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
                MarcaDAOImpl marcaDAO = new MarcaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                UbicacionDAOImpl ubicacionDAO = new UbicacionDAOImpl(connection);
                
                NombreRepuesto nombreRepuesto = nombreRepuestoDAO.obtenerNombreRepuesto(idNombreRepuesto);
                Marca marca = marcaDAO.obtenerMarca(idMarca);
                Categoria categoria = categoriaDAO.obtenerCategoria(idCategoria);
                List<Precio> listaPrecios = new ArrayList<>();
                Ubicacion ubicacion = ubicacionDAO.obtenerUbicacion(idUbicacion);
                
                Repuesto repuesto = new Repuesto(idRepuesto, stock, nombreRepuesto, marca, categoria, listaPrecios, ubicacion);
                
                listaRepuestos.add(repuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaRepuestos;
    }
    
    @Override
    public List<Repuesto> buscarRepuesto(Repuesto repuesto) {
        List<Repuesto> listaRepuesto = new ArrayList<>();
        ResultSet repuesto_Resultado = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_BUSQUEDA_DE_REPUESTO);

            preparedStatement.setInt(1, repuesto.getNombreRepuesto().getId_nombrerepuesto());
            preparedStatement.setInt(2, repuesto.getNombreRepuesto().getId_nombrerepuesto());
            //System.out.println("idNombreRepuesto: " + repuesto.getNombreRepuesto().getId_nombrerepuesto());
            
            preparedStatement.setInt(3, repuesto.getMarca().getId_marca());
            preparedStatement.setInt(4, repuesto.getMarca().getId_marca());
            //System.out.println("idMarca: " + repuesto.getMarca().getId_marca());
            
            preparedStatement.setInt(5, repuesto.getCategoria().getId_categoria());
            preparedStatement.setInt(6, repuesto.getCategoria().getId_categoria());
            //System.out.println("idCategoria: " + repuesto.getCategoria().getNombre_categoria());
            
            preparedStatement.setInt(7, repuesto.getUbicacion().getId_ubicacion());
            preparedStatement.setInt(8, repuesto.getUbicacion().getId_ubicacion());
            //System.out.println("idUbicacion: " + repuesto.getUbicacion().getNombre_ubicacion());
            
            int stockBuscar = (repuesto.getStock() == 0) ? repuesto.getStock() : 0;
            preparedStatement.setInt(9, stockBuscar);
            preparedStatement.setInt(10, stockBuscar);

            repuesto_Resultado = preparedStatement.executeQuery();

            while (repuesto_Resultado.next()) {
                int idRepuestoRet = repuesto_Resultado.getInt("id_repuesto");
                int stockRet = repuesto_Resultado.getInt("stock");
                int idNombreRepuestoRet = repuesto_Resultado.getInt("id_nombrerepuesto");
                int idMarcaRet = repuesto_Resultado.getInt("id_marca");
                int idCategoriaRet = repuesto_Resultado.getInt("id_categoria");
                int idUbicacionRet = repuesto_Resultado.getInt("id_ubicacion");
                
                NombreRepuestoDAOImpl nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
                MarcaDAOImpl marcaDAO = new MarcaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                UbicacionDAOImpl ubicacionDAO = new UbicacionDAOImpl(connection);
                
                NombreRepuesto nombreRepuesto = nombreRepuestoDAO.obtenerNombreRepuesto(idNombreRepuestoRet);
                Marca marca = marcaDAO.obtenerMarca(idMarcaRet);
                Categoria categoria = categoriaDAO.obtenerCategoria(idCategoriaRet);
                List<Precio> listaPrecios = new ArrayList<>();
                Ubicacion ubicacion = ubicacionDAO.obtenerUbicacion(idUbicacionRet);
                
                Repuesto repuestoBusqueda = new Repuesto(idRepuestoRet, stockRet, nombreRepuesto, marca, categoria, listaPrecios, ubicacion);
                
                listaRepuesto.add(repuestoBusqueda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println("tamaño de lista de busqueda DAOIMPL: " + listaRepuesto.size());
        
        return listaRepuesto;
    }


    @Override
    public void actualizarRepuesto(Repuesto repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_REPUESTO);
            preparedStatement.setInt(1, repuesto.getStock());
            preparedStatement.setInt(2, repuesto.getNombreRepuesto().getId_nombrerepuesto());
            preparedStatement.setInt(3, repuesto.getMarca().getId_marca());
            preparedStatement.setInt(4, repuesto.getCategoria().getId_categoria());
            preparedStatement.setInt(5, repuesto.getUbicacion().getId_ubicacion());
            preparedStatement.setInt(6, repuesto.getId_repuesto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarRepuesto(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_REPUESTO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Repuesto obtenerRepuesto(int id) {
        Repuesto repuesto = null;
        ResultSet repuesto_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPUESTO);
            preparedStatement.setInt(1, id);
            repuesto_Resultado = preparedStatement.executeQuery();
            
            if(repuesto_Resultado.next()){
                int idRepuesto = repuesto_Resultado.getInt("id_repuesto");
                int stock = repuesto_Resultado.getInt("stock");
                int idNombreRepuesto = repuesto_Resultado.getInt("id_nombrerepuesto");
                int idMarca = repuesto_Resultado.getInt("id_marca");
                int idCategoria = repuesto_Resultado.getInt("id_categoria");
                int idUbicacion = repuesto_Resultado.getInt("id_ubicacion");
                
                NombreRepuestoDAOImpl nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
                MarcaDAOImpl marcaDAO = new MarcaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                UbicacionDAOImpl ubicacionDAO = new UbicacionDAOImpl(connection);
                
                NombreRepuesto nombreRepuesto = nombreRepuestoDAO.obtenerNombreRepuesto(idNombreRepuesto);
                Marca marca = marcaDAO.obtenerMarca(idMarca);
                Categoria categoria = categoriaDAO.obtenerCategoria(idCategoria);
                List<Precio> listaPrecios = new ArrayList<>();
                Ubicacion ubicacion = ubicacionDAO.obtenerUbicacion(idUbicacion);
                
                repuesto = new Repuesto(idRepuesto, stock, nombreRepuesto, marca, categoria, listaPrecios, ubicacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return repuesto;
    }

    @Override
    public int obtenerUltimoIdRepuesto() {
        int idRepuestoUltimo = 0;
        ResultSet repuesto_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_ULTIMO_ID);
            repuesto_Resultado = preparedStatement.executeQuery();
            
            if(repuesto_Resultado.next()){
                idRepuestoUltimo = repuesto_Resultado.getInt("max_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idRepuestoUltimo;
    }

    @Override
    public List<Repuesto> obtenerRepuestosPorIdVenta(int id_Venta) {
        List<VentaRepuesto> listaVentaRepuestos = new ArrayList<>();
        List<Repuesto> listaRepuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPUESTOS_POR_ID_VENTA);
            preparedStatement.setInt(1, id_Venta);
            ResultSet repuesto_Resultado = preparedStatement.executeQuery();
            while(repuesto_Resultado.next()){
                int idVenta = repuesto_Resultado.getInt("id_venta");
                int idRepuesto = repuesto_Resultado.getInt("id_repuesto");
                int cantidadRepuestos = repuesto_Resultado.getInt("cantidad_repuestos");
                
                VentaRepuesto ventaRepuesto = new VentaRepuesto(idVenta, idRepuesto, cantidadRepuestos);
                listaVentaRepuestos.add(ventaRepuesto);
            }
            for(VentaRepuesto ventaRep : listaVentaRepuestos){
                int idRepuesto = ventaRep.getId_repuesto();
                int cantidad = ventaRep.getCantidad_repuestos();
                
                PrecioDAOImpl precioDAO = new PrecioDAOImpl(connection);
                RepuestoService repuestoService = new RepuestoService(this, precioDAO);
                Repuesto repuestoObtenido = repuestoService.obtenerRepuestoPorId(idRepuesto);
                listaRepuestos.add(repuestoObtenido);
                while(cantidad != 1){
                    listaRepuestos.add(repuestoObtenido);
                    cantidad--;
                }
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaRepuestos;
    }

    @Override
    public List<Repuesto> obtenerRepuestosPorIdReparacion(int id_Reparacion) {
        List<ReparacionRepuesto> listaReparacionRepuestos = new ArrayList<>();
        List<Repuesto> listaRepuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPUESTOS_POR_ID_REPARACION);
            preparedStatement.setInt(1, id_Reparacion);
            ResultSet repuesto_Resultado = preparedStatement.executeQuery();
            while(repuesto_Resultado.next()){
                int idReparacion = repuesto_Resultado.getInt("id_reparacion");
                int idRepuesto = repuesto_Resultado.getInt("id_repuesto");
                int cantidadRepuestos = repuesto_Resultado.getInt("cantidad_repuestos");
                
                ReparacionRepuesto reparacionRepuesto = new ReparacionRepuesto(idReparacion, idRepuesto, cantidadRepuestos);
                listaReparacionRepuestos.add(reparacionRepuesto);
            }
            for(ReparacionRepuesto ReparacionRep : listaReparacionRepuestos){
                int idRepuesto = ReparacionRep.getId_repuesto();
                int cantidad = ReparacionRep.getCantidad_repuestos();
                
                PrecioDAOImpl precioDAO = new PrecioDAOImpl(connection);
                RepuestoService repuestoService = new RepuestoService(this, precioDAO);
                Repuesto repuestoObtenido = repuestoService.obtenerRepuestoPorId(idRepuesto);
                listaRepuestos.add(repuestoObtenido);
                while(cantidad != 1){
                    listaRepuestos.add(repuestoObtenido);
                    cantidad--;
                }
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaRepuestos;
    }

}
