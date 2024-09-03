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
import model.Marca;
import model.Ubicacion;

public class UbicacionDAOImpl implements UbicacionDAO{
    /*
    Columnas/Campos de la Tabla Ubicacion
    
    id_ubicacion
    nombre_ubicacion
    */
    
    private Connection connection = null; 
    private final String SENTENCIA_CREAR_UBICACION = "INSERT INTO TiendaLocal.ubicacion (nombre_ubicacion) VALUES ( ? )";
    private final String SENTENCIA_OBTENER_UBICACIONES = "SELECT * FROM TiendaLocal.ubicacion";
    private final String SENTENCIA_OBTENER_UBICACION = "SELECT * FROM TiendaLocal.ubicacion WHERE id_ubicacion = ?";
    private final String SENTENCIA_ACTUALIZAR_UBICACION = "UPDATE TiendaLocal.ubicacion SET nombre_ubicacion = ? WHERE id_ubicacion = ?";
    private final String SENTENCIA_ELIMINAR_UBICACION = "DELETE FROM TiendaLocal.ubicacion WHERE id_ubicacion = ?";
    
    
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
                int idUbicacion = ubicacion_Resultado.getInt("id_marca");
                
                Ubicacion ubicacion = new Ubicacion(idUbicacion, nombreUbicacion);
                
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
    public void toStringUbicacion() {
        List<Ubicacion> listaUbicaciones = obtenerUbicaciones();
        
        for(Ubicacion ubi : listaUbicaciones){
            System.out.println("------------------");
            System.out.println("Id: " + ubi.getId_ubicacion());
            System.out.println("Nombre: " + ubi.getNombre_ubicacion());
        }
    }

    @Override
    public Ubicacion obtenerUbicacion(int id) {
        ResultSet ubicacion_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_UBICACION);
            preparedStatement.setInt(1, id);
            ubicacion_Resultado = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(UbicacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (Ubicacion) ubicacion_Resultado;
    }
}
