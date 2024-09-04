package dao.impl;

import dao.interfaces.CategoriaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Reparacion;

public class CategoriaDAOImpl implements CategoriaDAO{
    /*
    Columnas/Campos de la Tabla Categoria
    
    id_categoria
    nombre_categoria
    */
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_CATEGORIA = "DELETE FROM TiendaLocal.categoria WHERE id_categoria = ?";
    private final String SENTENCIA_OBTENER_CATEGORIAS = "SELECT * FROM TiendaLocal.categoria ORDER BY id_categoria ASC";
    private final String SENTENCIA_OBTENER_CATEGORIA = "SELECT * FROM TiendaLocal.categoria WHERE id_categoria = ? ";
    private final String SENTENCIA_CREAR_CATEGORIA = "INSERT INTO TiendaLocal.categoria (nombre_categoria) VALUES ( ? )";
    private final String SENTENCIA_ACTUALIZAR_CATEGORIA = "UPDATE TiendaLocal.categoria SET nombre_categoria = ? WHERE id_categoria = ?";
    
    public CategoriaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearCategoria(Categoria categoria) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_CATEGORIA);
            preparedStatement.setString(1, categoria.getNombre_categoria());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Categoria> obtenerCategorias() {
        List<Categoria> listaCategorias = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_CATEGORIAS);
            ResultSet categoria_Categoria = preparedStatement.executeQuery();
            
            while (categoria_Categoria.next()){
                String nombreCategoria = categoria_Categoria.getString("nombre_categoria");
                int idCategoria = categoria_Categoria.getInt("id_categoria");
                
                ReparacionDAOImpl reparacionDAO = new ReparacionDAOImpl(connection);
                List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparacionesPorIdCategoria(idCategoria);
                
                Categoria categoria = new Categoria(idCategoria, nombreCategoria, listaReparaciones);
                
                listaCategorias.add(categoria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaCategorias;
    }

    @Override
    public void actualizarCategoria(Categoria categoria) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_CATEGORIA);
            preparedStatement.setString(1, categoria.getNombre_categoria());
            preparedStatement.setInt(2, categoria.getId_categoria());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarCategoria(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_CATEGORIA);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Categoria obtenerCategoria(int id) {
        Categoria categoria = null;
        ResultSet categoria_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_CATEGORIA);
            preparedStatement.setInt(1, id);
            categoria_Resultado = preparedStatement.executeQuery();
            
            if(categoria_Resultado.next()){
                int idCategoria = categoria_Resultado.getInt("id_categoria");
                String nombreCategoria = categoria_Resultado.getString("nombre_categoria");
                
                ReparacionDAOImpl reparacionDAO = new ReparacionDAOImpl(connection);
                List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparacionesPorIdCategoria(idCategoria);
                
                categoria = new Categoria(idCategoria, nombreCategoria, listaReparaciones);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return categoria;
    }
    
}
