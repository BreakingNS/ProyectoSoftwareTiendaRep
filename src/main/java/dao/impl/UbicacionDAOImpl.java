package dao.impl;

import dao.interfaces.UbicacionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ubicacion;

public class UbicacionDAOImpl implements UbicacionDAO{

    private Connection connection = null; 
    private final String SENTENCIA_CREAR_UBICACION = "INSERT INTO TiendaLocal.ubicacion (nombre_ubicacion) VALUES ( UPPER(?) )";
    private final String SENTENCIA_OBTENER_UBICACIONES = "SELECT * FROM TiendaLocal.ubicacion ORDER BY nombre_ubicacion ASC";
    private final String SENTENCIA_OBTENER_UBICACION = "SELECT * FROM TiendaLocal.ubicacion WHERE id_ubicacion = ?";
    private final String SENTENCIA_OBTENER_UBICACION_POR_NOMBRE = "SELECT * FROM TiendaLocal.ubicacion WHERE nombre_ubicacion = UPPER(?)";
    private final String SENTENCIA_ACTUALIZAR_UBICACION = "UPDATE TiendaLocal.ubicacion SET nombre_ubicacion = UPPER(?) WHERE id_ubicacion = ?";
    private final String SENTENCIA_ELIMINAR_UBICACION = "DELETE FROM TiendaLocal.ubicacion WHERE id_ubicacion = ?";
    private final String SENTENCIA_EXISTE_UBICACION = "SELECT nombre_ubicacion FROM TiendaLocal.ubicacion WHERE nombre_ubicacion = UPPER(?)";
    
    public UbicacionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearUbicacion(Ubicacion ubicacion) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_UBICACION);
            preparedStatement.setString(1, ubicacion.getNombre_ubicacion());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UbicacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Ubicacion> obtenerUbicaciones() {
        List<Ubicacion> listaUbicaciones = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_UBICACIONES);
            ResultSet ubicacion_Resultado = preparedStatement.executeQuery();
            
            while(ubicacion_Resultado.next()){
                String nombreUbicacion = ubicacion_Resultado.getString("nombre_ubicacion");
                int idUbicacion = ubicacion_Resultado.getInt("id_ubicacion");
                
                Ubicacion ubicacion = new Ubicacion(idUbicacion, nombreUbicacion, new ArrayList<>());
                
                listaUbicaciones.add(ubicacion);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(UbicacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaUbicaciones;
    }

    @Override
    public void actualizarUbicacion(Ubicacion ubicacion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_UBICACION);
            preparedStatement.setString(1, ubicacion.getNombre_ubicacion());
            preparedStatement.setInt(2, ubicacion.getId_ubicacion());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UbicacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarUbicacion(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_UBICACION);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UbicacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public Ubicacion obtenerUbicacion(int id) {
        Ubicacion ubicacion = null;
        ResultSet ubicacion_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_UBICACION);
            preparedStatement.setInt(1, id);
            ubicacion_Resultado = preparedStatement.executeQuery();
            
            if(ubicacion_Resultado.next()){
                int idUbicacion = ubicacion_Resultado.getInt("id_ubicacion");
                String nombreUbicacion = ubicacion_Resultado.getString("nombre_ubicacion");
                
                ubicacion = new Ubicacion(idUbicacion, nombreUbicacion, new ArrayList<>());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UbicacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ubicacion;
    }

    @Override
    public boolean existeUbicacion(String nombreUbicacion) {
        ResultSet ubicacion_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_EXISTE_UBICACION);
            preparedStatement.setString(1, nombreUbicacion);
            ubicacion_Resultado = preparedStatement.executeQuery();

            if (ubicacion_Resultado.next()) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UbicacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
            // Asegúrate de cerrar los recursos para evitar fugas de memoria
            if (ubicacion_Resultado != null) {
                try {
                    ubicacion_Resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UbicacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return false;
    }

    @Override
    public Ubicacion obtenerUbicacionPorNombre(String nombreUbicacionBuscar) {
        Ubicacion ubicacion = null;
        ResultSet ubicacion_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_UBICACION_POR_NOMBRE);
            preparedStatement.setString(1, nombreUbicacionBuscar);
            ubicacion_Resultado = preparedStatement.executeQuery();
            
            if(ubicacion_Resultado.next()){
                int idUbicacion = ubicacion_Resultado.getInt("id_ubicacion");
                String nombreUbicacion = ubicacion_Resultado.getString("nombre_ubicacion");
                
                ubicacion = new Ubicacion(idUbicacion, nombreUbicacion, new ArrayList<>());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UbicacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ubicacion;
    }
}
