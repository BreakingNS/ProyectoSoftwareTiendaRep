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
import model.Estado;

public class EstadoDAOImpl implements EstadoDAO{
    /*
    Columnas/Campos de la Tabla Estado
    
    id_estado
    nombre_estado
    */
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_ESTADO = "DELETE FROM TiendaLocal.estado WHERE id_estado = ?";
    private final String SENTENCIA_OBTENER_ESTADOS = "SELECT * FROM TiendaLocal.estado";
    private final String SENTENCIA_OBTENER_ESTADO = "SELECT * FROM TiendaLocal.estado WHERE id_estado = ?";
    private final String SENTENCIA_CREAR_ESTADO = "INSERT INTO TiendaLocal.estado (nombre_estado) VALUES ( ? )";
    private final String SENTENCIA_ACTUALIZAR_ESTADO = "UPDATE TiendaLocal.estado SET nombre_estado = ? WHERE id_estado = ?";

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
                
                Estado estado = new Estado();
                
                listaEstados.add(estado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaEstados;
    }

    @Override
    public void actualizarEstado(Estado estado, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_ESTADO);
            preparedStatement.setString(1, estado.getNombre_estado());
            preparedStatement.setInt(2, id);
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
    public void toStringEstado() {
        List<Estado> listaEstados = obtenerEstados();
        
        for(Estado mar : listaEstados){
            System.out.println("------------------");
            System.out.println("Id: " + mar.getId_estado());
            System.out.println("Nombre: " + mar.getNombre_estado());
        }
    }    

    @Override
    public Estado obtenerEstado(int id) {
        ResultSet estado_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_ESTADO);
            preparedStatement.setInt(1, id);
            estado_Resultado = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (Estado) estado_Resultado;
    }
}
