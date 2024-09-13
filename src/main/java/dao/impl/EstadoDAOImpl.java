package dao.impl;

import dao.interfaces.EstadoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estado;
import model.Reparacion;

public class EstadoDAOImpl implements EstadoDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_ESTADO = "DELETE FROM TiendaLocal.estado WHERE id_estado = ?";
    private final String SENTENCIA_OBTENER_ESTADOS = "SELECT * FROM TiendaLocal.estado ORDER BY id_estado ASC";
    private final String SENTENCIA_OBTENER_ESTADO = "SELECT * FROM TiendaLocal.estado WHERE id_estado = ?";
    private final String SENTENCIA_CREAR_ESTADO = "INSERT INTO TiendaLocal.estado (nombre_estado) VALUES ( ? )";
    private final String SENTENCIA_ACTUALIZAR_ESTADO = "UPDATE TiendaLocal.estado SET nombre_estado = ? WHERE id_estado = ?";
    private final String SENTENCIA_EXISTE_ESTADO = "SELECT nombre_estado FROM TiendaLocal.estado WHERE nombre_estado = ?";

    public EstadoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearEstado(Estado estado) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_ESTADO);
            preparedStatement.setString(1, estado.getNombre_estado());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Estado> obtenerEstados() {
        List<Estado> listaEstados = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_ESTADOS);
            ResultSet estado_Resultado = preparedStatement.executeQuery();
            
            while (estado_Resultado.next()){
                String nombreEstado = estado_Resultado.getString("nombre_estado");
                int idCategoria = estado_Resultado.getInt("id_estado");
                
                ReparacionDAOImpl reparacionDAO = new ReparacionDAOImpl(connection);
                List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparaciones();

                Estado estado = new Estado(idCategoria, nombreEstado, listaReparaciones);
                
                listaEstados.add(estado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaEstados;
    }

    @Override
    public void actualizarEstado(Estado estado) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_ESTADO);
            preparedStatement.setString(1, estado.getNombre_estado());
            preparedStatement.setInt(2, estado.getId_estado());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarEstado(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_ESTADO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Estado obtenerEstado(int id) {
        Estado estado = null;
        ResultSet estado_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_ESTADO);
            preparedStatement.setInt(1, id);
            estado_Resultado = preparedStatement.executeQuery();
            
            if(estado_Resultado.next()){
                int idEstado = estado_Resultado.getInt("id_estado");
                String nombreEstado = estado_Resultado.getString("nombre_estado");
                
                List<Reparacion> listaReparaciones = new ArrayList<>();
                
                estado = new Estado(idEstado, nombreEstado, listaReparaciones);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return estado;
    }

    @Override
    public boolean existeEstado(String nombreEstado) {
        ResultSet estado_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_EXISTE_ESTADO);
            preparedStatement.setString(1, nombreEstado);
            estado_Resultado = preparedStatement.executeQuery();

            if (estado_Resultado.next()) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
            // Asegúrate de cerrar los recursos para evitar fugas de memoria
            if (estado_Resultado != null) {
                try {
                    estado_Resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EstadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return false;
    }
}
