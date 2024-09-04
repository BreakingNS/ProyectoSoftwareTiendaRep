package dao.impl;

import dao.interfaces.MarcaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Marca;

public class MarcaDAOImpl implements MarcaDAO{
    
    /*
    Columnas/Campos de la Tabla Marca
    
    id_marca
    nombre_marca
    */
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_MARCA = "DELETE FROM TiendaLocal.marca WHERE id_marca = ?";
    private final String SENTENCIA_OBTENER_MARCAS = "SELECT * FROM TiendaLocal.marca ORDER BY id_marca ASC";
    private final String SENTENCIA_OBTENER_MARCA = "SELECT * FROM TiendaLocal.marca WHERE id_marca = ?";
    private final String SENTENCIA_CREAR_MARCA = "INSERT INTO TiendaLocal.marca (nombre_marca) VALUES ( ? )";
    private final String SENTENCIA_ACTUALIZAR_MARCA = "UPDATE TiendaLocal.marca SET nombre_marca = ? WHERE id_marca = ?";

    public MarcaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearMarca(Marca marca) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_MARCA);
            preparedStatement.setString(1, marca.getNombre_marca());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Marca> obtenerMarcas() {
        List<Marca> listaMarcas = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_MARCAS);
            ResultSet marca_Resultado = preparedStatement.executeQuery();
            
            while (marca_Resultado.next()){
                String nombreCategoria = marca_Resultado.getString("nombre_marca");
                int idCategoria = marca_Resultado.getInt("id_marca");
                
                Marca marca = new Marca(idCategoria, nombreCategoria);
                
                listaMarcas.add(marca);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaMarcas;
    }

    @Override
    public void actualizarMarca(Marca marca) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_MARCA);
            preparedStatement.setString(1, marca.getNombre_marca());
            preparedStatement.setInt(2, marca.getId_marca());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarMarca(int id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_MARCA);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Marca obtenerMarca(int id) {
        Marca marca = null;
        ResultSet marca_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_MARCA);
            preparedStatement.setInt(1, id);
            marca_Resultado = preparedStatement.executeQuery();
            
            if(marca_Resultado.next()){
                int idMarca = marca_Resultado.getInt("id_marca");
                String nombreMarca = marca_Resultado.getString("nombre_marca");
                
                marca = new Marca(idMarca, nombreMarca);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return marca;
    }
    
}
