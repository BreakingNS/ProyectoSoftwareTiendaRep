package dao.impl;

import dao.interfaces.ModeloDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Modelo;
import model.Modelo;
import model.Repuesto;

public class ModeloDAOImpl implements ModeloDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_MODELO = "DELETE FROM TiendaLocal.modelo WHERE id_modelo = ?";
    private final String SENTENCIA_OBTENER_MODELOS = "SELECT * FROM TiendaLocal.modelo";
    private final String SENTENCIA_OBTENER_MODELO = "SELECT * FROM TiendaLocal.modelo WHERE id_modelo = ?";
    private final String SENTENCIA_OBTENER_MODELO_POR_NOMBRE = "SELECT * FROM TiendaLocal.modelo WHERE nombre_modelo = ?";
    private final String SENTENCIA_CREAR_MODELO = "INSERT INTO TiendaLocal.modelo (nombre_modelo) VALUES ( ? )";
    private final String SENTENCIA_ACTUALIZAR_MODELO = "UPDATE TiendaLocal.modelo SET nombre_modelo = ? WHERE id_modelo = ?";
    private final String SENTENCIA_EXISTE_MODELO = "SELECT nombre_modelo FROM TiendaLocal.modelo WHERE nombre_modelo = ?";
    
    public ModeloDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void crearModelo(Modelo modelo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_MODELO);
            preparedStatement.setString(1, modelo.getNombre_modelo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Modelo> obtenerModelos() {
        List<Modelo> listaModelos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_MODELOS);
            ResultSet modelo_Resultado = preparedStatement.executeQuery();
            
            while (modelo_Resultado.next()){
                String nombreModelo = modelo_Resultado.getString("nombre_modelo");
                int idModelo = modelo_Resultado.getInt("id_modelo");
                
                Modelo modelo = new Modelo(idModelo, nombreModelo);
                
                listaModelos.add(modelo);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaModelos;
    }


    @Override
    public void actualizarModelo(Modelo modelo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_MODELO);
            preparedStatement.setString(1, modelo.getNombre_modelo());
            preparedStatement.setInt(2, modelo.getId_modelo());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarModelo(int id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_MODELO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Modelo obtenerModelo(int id) {
        Modelo modelo = null;
        ResultSet modelo_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_MODELO);
            preparedStatement.setInt(1, id);
            modelo_Resultado = preparedStatement.executeQuery();
            
            if(modelo_Resultado.next()){
                String nombreModelo = modelo_Resultado.getString("nombre_modelo");
                int idModelo = modelo_Resultado.getInt("id_modelo");
                
                modelo = new Modelo(idModelo, nombreModelo);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return modelo;
    }
    
    @Override
    public boolean existeModelo(String nombreModelo) {
        ResultSet modelo_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_EXISTE_MODELO);
            preparedStatement.setString(1, nombreModelo);
            modelo_Resultado = preparedStatement.executeQuery();

            if (modelo_Resultado.next()) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
            // Asegúrate de cerrar los recursos para evitar fugas de memoria
            if (modelo_Resultado != null) {
                try {
                    modelo_Resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ModeloDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return false;
    }

    @Override
    public Modelo obtenerModeloPorNombre(String nombreModeloBuscar) {
        Modelo modelo = null;
        ResultSet modelo_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_MODELO_POR_NOMBRE);
            preparedStatement.setString(1, nombreModeloBuscar);
            modelo_Resultado = preparedStatement.executeQuery();

            if (modelo_Resultado.next()) {
                String nombreModelo = modelo_Resultado.getString("nombre_modelo");
                int idModelo = modelo_Resultado.getInt("id_modelo");
                
                modelo = new Modelo(idModelo, nombreModelo);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
            // Asegúrate de cerrar los recursos para evitar fugas de memoria
            if (modelo_Resultado != null) {
                try {
                    modelo_Resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ModeloDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println("EL MODELO ENCONTRADO: " + modelo.getNombre_modelo());
        return modelo;
    }
    
}
