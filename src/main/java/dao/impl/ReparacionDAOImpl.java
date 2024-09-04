package dao.impl;

import dao.interfaces.ReparacionDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Cliente;
import model.Estado;
import model.Reparacion;
import model.Repuesto;

public class ReparacionDAOImpl implements ReparacionDAO{
    /*
    Columnas/Campos de la Tabla Reparacion
    
    id_reparacion
    nombre_reparacion
    */
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_REPARACION = 
            "DELETE FROM TiendaLocal.reparacion WHERE id_reparacion = ?";
    private final String SENTENCIA_OBTENER_REPARACIONES = 
            "SELECT * FROM TiendaLocal.reparacion";
    private final String SENTENCIA_OBTENER_REPARACIONES_POR_ID_CLIENTE = 
            "SELECT * FROM TiendaLocal.reparacion WHILE id_cliente = ?";
    private final String SENTENCIA_OBTENER_REPARACIONES_POR_ID_CATEGORIA = 
            "SELECT * FROM TiendaLocal.reparacion WHILE id_categoria = ?";
    private final String SENTENCIA_OBTENER_REPARACION = 
            "SELECT * FROM TiendaLocal.reparacion WHILE id_reparacion = ?";
    private final String SENTENCIA_CREAR_REPARACION = 
            "INSERT INTO TiendaLocal.reparacion (costo, detalles, fecha_ingreso, fecha_devolucion, id_categoria, id_cliente, id_repuesto, id_estado) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_REPARACION = 
            "UPDATE TiendaLocal.reparacion SET costo = ?, detalles = ?, fecha_ingreso = ?, fecha_devolucion = ?, id_categoria = ?, id_cliente = ?, id_repuesto = ?, id_estado = ? WHERE id_reparacion = ?";

    public ReparacionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearReparacion(Reparacion reparacion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_REPARACION);
            preparedStatement.setBigDecimal(1, reparacion.getCosto());
            preparedStatement.setString(2, reparacion.getDetalles());
            preparedStatement.setDate(3, new java.sql.Date(reparacion.getFecha_ingreso().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(reparacion.getFecha_devolucion().getTime()));
            preparedStatement.setInt(5, reparacion.getCategoria().getId_categoria());
            preparedStatement.setInt(6, reparacion.getCliente().getId_cliente());
            preparedStatement.setInt(7, reparacion.getRepuesto().getId_repuesto());
            preparedStatement.setInt(8, reparacion.getEstado().getId_estado());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reparacion> obtenerReparaciones() {
        List<Reparacion> listaReparaciones = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACIONES);
            ResultSet reparacion_Resultado = preparedStatement.executeQuery();
            
            while(reparacion_Resultado.next()){
                BigDecimal costo = reparacion_Resultado.getBigDecimal("costo");
                String detalles = reparacion_Resultado.getString("detalles");
                Date fecha_ingreso = reparacion_Resultado.getDate("fecha_ingreso");
                Date fecha_devolucion = reparacion_Resultado.getDate("fecha_devolucion");
                int id_reparacion = reparacion_Resultado.getInt("id_reparacion");
                int id_categoria = reparacion_Resultado.getInt("id_categoria");
                int id_cliente = reparacion_Resultado.getInt("id_cliente");
                int id_repuesto = reparacion_Resultado.getInt("id_repuesto");
                int id_estado = reparacion_Resultado.getInt("id_estado");
                
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                RepuestoDAOImpl repuestoDAO = new RepuestoDAOImpl(connection);
                EstadoDAOImpl EstadoDAO = new EstadoDAOImpl(connection);
                
                Categoria categoria = categoriaDAO.obtenerCategoria(id_estado);
                Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                Repuesto repuesto = repuestoDAO.obtenerRepuesto(id_repuesto);
                Estado estado = EstadoDAO.obtenerEstado(id_estado);
                
                Reparacion reparacion = new Reparacion(id_reparacion, costo, detalles, fecha_ingreso, fecha_devolucion, categoria, cliente, repuesto, estado);
                
                listaReparaciones.add(reparacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaReparaciones;
    }

    @Override
    public void actualizarReparacion(Reparacion reparacion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACIONES);
            preparedStatement.setBigDecimal(1, reparacion.getCosto());
            preparedStatement.setString(2, reparacion.getDetalles());
            preparedStatement.setDate(3, new java.sql.Date(reparacion.getFecha_ingreso().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(reparacion.getFecha_devolucion().getTime()));
            preparedStatement.setInt(5, reparacion.getCategoria().getId_categoria());
            preparedStatement.setInt(6, reparacion.getCliente().getId_cliente());
            preparedStatement.setInt(7, reparacion.getRepuesto().getId_repuesto());
            preparedStatement.setInt(8, reparacion.getEstado().getId_estado());
            preparedStatement.setInt(9, reparacion.getId_reparacion());
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarReparacion(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_REPARACION);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Reparacion obtenerReparacion(int id) {
        ResultSet precio_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACION);
            preparedStatement.setInt(1, id);
            precio_Resultado = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (Reparacion) precio_Resultado;
    }

    @Override
    public List<Reparacion> obtenerReparacionesPorIdCliente(int id) {
        ResultSet precio_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACIONES_POR_ID_CLIENTE);
            preparedStatement.setInt(1, id);
            precio_Resultado = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (List<Reparacion>) precio_Resultado;
    }

    @Override
    public List<Reparacion> obtenerReparacionesPorIdCategoria(int id) {
        ResultSet precio_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACIONES_POR_ID_CATEGORIA);
            preparedStatement.setInt(1, id);
            precio_Resultado = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (List<Reparacion>) precio_Resultado;
    }
    
    
}
