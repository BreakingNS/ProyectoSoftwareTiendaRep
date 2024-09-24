package dao.impl;

import dao.interfaces.ReparacionDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Cliente;
import model.Estado;
import model.Reparacion;

public class ReparacionDAOImpl implements ReparacionDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_REPARACION =
            "DELETE FROM TiendaLocal.reparacion WHERE id_reparacion = ?";
    private final String SENTENCIA_OBTENER_REPARACIONES =
            "SELECT * FROM TiendaLocal.reparacion ORDER BY id_reparacion ASC";
    private final String SENTENCIA_OBTENER_REPARACIONES_POR_ID_CLIENTE =
            "SELECT * FROM TiendaLocal.reparacion WHERE id_cliente = ?";
    private final String SENTENCIA_OBTENER_REPARACIONES_POR_ID_CATEGORIA =
            "SELECT * FROM TiendaLocal.reparacion WHERE id_categoria = ?";
    private final String SENTENCIA_OBTENER_REPARACION =
            "SELECT * FROM TiendaLocal.reparacion WHERE id_reparacion = ?";
    private final String SENTENCIA_CREAR_REPARACION =
            "INSERT INTO TiendaLocal.reparacion (costo, detalles, fecha_ingreso, fecha_devolucion, pagado, id_categoria, id_cliente, id_estado) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_REPARACION =
            "UPDATE TiendaLocal.reparacion SET costo = ?, detalles = ?, fecha_ingreso = ?, fecha_devolucion = ?, pagado = ?, id_categoria = ?, id_cliente = ?, id_estado = ? WHERE id_reparacion = ?";

    public ReparacionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearReparacion(Reparacion reparacion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_REPARACION);
            preparedStatement.setBigDecimal(1, reparacion.getCosto());
            preparedStatement.setString(2, reparacion.getDetalles());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(reparacion.getFecha_ingreso()));
            if(reparacion.getFecha_devolucion().equals(LocalDateTime.of(1900, 1, 1, 0, 0))){
                preparedStatement.setNull(4, java.sql.Types.TIMESTAMP);
            }
            else{
                preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(reparacion.getFecha_devolucion()));
            }   
            
            preparedStatement.setBoolean(5, reparacion.getPagado());
            preparedStatement.setInt(6, reparacion.getCategoria().getId_categoria());
            preparedStatement.setInt(7, reparacion.getCliente().getId_cliente());
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
                
                Timestamp fecha = reparacion_Resultado.getTimestamp("fecha_ingreso");
                LocalDateTime fecha_ingreso = fecha.toLocalDateTime();
                fecha = reparacion_Resultado.getTimestamp("fecha_devolucion");
                
                LocalDateTime fecha_devolucion;
                if (fecha != null) {
                    fecha_devolucion = fecha.toLocalDateTime();
                } else {
                    // Manejar el caso donde fecha es null
                    fecha_devolucion = null;
                    System.out.println("La fecha es nula");
                }

                Boolean pagado = reparacion_Resultado.getBoolean("pagado");
                int id_reparacion = reparacion_Resultado.getInt("id_reparacion");
                int id_categoria = reparacion_Resultado.getInt("id_categoria");
                int id_cliente = reparacion_Resultado.getInt("id_cliente");
                int id_estado = reparacion_Resultado.getInt("id_estado");
                
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                EstadoDAOImpl estadoDAO = new EstadoDAOImpl(connection);
                
                Categoria categoria = categoriaDAO.obtenerCategoria(id_estado);
                Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                Estado estado = estadoDAO.obtenerEstado(id_estado);
                
                Reparacion reparacion = new Reparacion(id_reparacion, costo, detalles, fecha_ingreso, fecha_devolucion, pagado, categoria, cliente, estado);
                
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
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_REPARACION);
            preparedStatement.setBigDecimal(1, reparacion.getCosto());
            preparedStatement.setString(2, reparacion.getDetalles());
             preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(reparacion.getFecha_ingreso()));
            preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(reparacion.getFecha_devolucion()));
            preparedStatement.setBoolean(5, reparacion.getPagado());
            preparedStatement.setInt(6, reparacion.getCategoria().getId_categoria());
            preparedStatement.setInt(7, reparacion.getCliente().getId_cliente());
            preparedStatement.setInt(8, reparacion.getEstado().getId_estado());
            preparedStatement.setInt(9, reparacion.getId_reparacion());
            
            preparedStatement.executeUpdate();
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
        Reparacion reparacion = null;
        ResultSet reparacion_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACION);
            preparedStatement.setInt(1, id);
            reparacion_Resultado = preparedStatement.executeQuery();
            
            if(reparacion_Resultado.next()){
                BigDecimal costo = reparacion_Resultado.getBigDecimal("costo");
                String detalles = reparacion_Resultado.getString("detalles");
                
                Timestamp fecha = reparacion_Resultado.getTimestamp("fecha_ingreso");
                LocalDateTime fecha_ingreso = fecha.toLocalDateTime();
                fecha = reparacion_Resultado.getTimestamp("fecha_devolucion");
                
                LocalDateTime fecha_devolucion;
                if (fecha != null) {
                    fecha_devolucion = fecha.toLocalDateTime();
                } else {
                    // Manejar el caso donde fecha es null
                    fecha_devolucion = null;
                    System.out.println("La fecha es nula");
                }

                Boolean pagado = reparacion_Resultado.getBoolean("pagado");
                int id_reparacion = reparacion_Resultado.getInt("id_reparacion");
                int id_categoria = reparacion_Resultado.getInt("id_categoria");
                int id_cliente = reparacion_Resultado.getInt("id_cliente");
                int id_estado = reparacion_Resultado.getInt("id_estado");
                
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                EstadoDAOImpl EstadoDAO = new EstadoDAOImpl(connection);
                
                Categoria categoria = categoriaDAO.obtenerCategoria(id_categoria);
                Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                Estado estado = EstadoDAO.obtenerEstado(id_estado);
                
                reparacion = new Reparacion(id_reparacion, costo, detalles, fecha_ingreso, fecha_devolucion, pagado, categoria, cliente, estado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reparacion;
    }

    @Override
    public List<Reparacion> obtenerReparacionesPorIdCliente(int id) {
        List<Reparacion> listaReparaciones = new ArrayList<>();
        ResultSet reparacion_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACIONES_POR_ID_CLIENTE);
            preparedStatement.setInt(1, id);
            reparacion_Resultado = preparedStatement.executeQuery();
            
            while(reparacion_Resultado.next()){
                BigDecimal costo = reparacion_Resultado.getBigDecimal("costo");
                String detalles = reparacion_Resultado.getString("detalles");
                
                Timestamp fecha = reparacion_Resultado.getTimestamp("fecha_ingreso");
                LocalDateTime fecha_ingreso = fecha.toLocalDateTime();
                fecha = reparacion_Resultado.getTimestamp("fecha_devolucion");
                
                LocalDateTime fecha_devolucion;
                if (fecha != null) {
                    fecha_devolucion = fecha.toLocalDateTime();
                } else {
                    // Manejar el caso donde fecha es null
                    fecha_devolucion = null;
                    System.out.println("La fecha es nula");
                }

                Boolean pagado = reparacion_Resultado.getBoolean("pagado");
                int id_reparacion = reparacion_Resultado.getInt("id_reparacion");
                int id_categoria = reparacion_Resultado.getInt("id_categoria");
                int id_cliente = reparacion_Resultado.getInt("id_cliente");
                int id_estado = reparacion_Resultado.getInt("id_estado");
                
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                EstadoDAOImpl estadoDAO = new EstadoDAOImpl(connection);
                
                Categoria categoria = categoriaDAO.obtenerCategoria(id_estado);
                Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                Estado estado = estadoDAO.obtenerEstado(id_estado);
                
                Reparacion reparacion = new Reparacion(id_reparacion, costo, detalles, fecha_ingreso, fecha_devolucion, pagado, categoria, cliente, estado);
                
                listaReparaciones.add(reparacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaReparaciones;
    }

    @Override
    public List<Reparacion> obtenerReparacionesPorIdCategoria(int id) {
        List<Reparacion> listaReparaciones = new ArrayList<>();
        ResultSet reparacion_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACIONES_POR_ID_CATEGORIA);
            preparedStatement.setInt(1, id);
            reparacion_Resultado = preparedStatement.executeQuery();
            
            while(reparacion_Resultado.next()){
                BigDecimal costo = reparacion_Resultado.getBigDecimal("costo");
                String detalles = reparacion_Resultado.getString("detalles");
                
                Timestamp fecha = reparacion_Resultado.getTimestamp("fecha_ingreso");
                LocalDateTime fecha_ingreso = fecha.toLocalDateTime();
                fecha = reparacion_Resultado.getTimestamp("fecha_devolucion");
                
                LocalDateTime fecha_devolucion;
                if (fecha != null) {
                    fecha_devolucion = fecha.toLocalDateTime();
                } else {
                    // Manejar el caso donde fecha es null
                    fecha_devolucion = null;
                    System.out.println("La fecha es nula");
                }

                Boolean pagado = reparacion_Resultado.getBoolean("pagado");
                int id_reparacion = reparacion_Resultado.getInt("id_reparacion");
                int id_categoria = reparacion_Resultado.getInt("id_categoria");
                int id_cliente = reparacion_Resultado.getInt("id_cliente");
                int id_estado = reparacion_Resultado.getInt("id_estado");
                
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                EstadoDAOImpl estadoDAO = new EstadoDAOImpl(connection);
                
                Categoria categoria = categoriaDAO.obtenerCategoria(id_estado);
                Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                Estado estado = estadoDAO.obtenerEstado(id_estado);
                
                Reparacion reparacion = new Reparacion(id_reparacion, costo, detalles, fecha_ingreso, fecha_devolucion, pagado, categoria, cliente, estado);
                
                listaReparaciones.add(reparacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaReparaciones;
    }
    
    
}
