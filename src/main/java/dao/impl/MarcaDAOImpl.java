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
import model.Repuesto;

public class MarcaDAOImpl implements MarcaDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_MARCA = "DELETE FROM TiendaLocal.marca WHERE id_marca = ?";
    private final String SENTENCIA_OBTENER_MARCAS = "SELECT * FROM TiendaLocal.marca ORDER BY nombre_marca ASC";
    private final String SENTENCIA_OBTENER_MARCA = "SELECT * FROM TiendaLocal.marca WHERE id_marca = ?";
    private final String SENTENCIA_OBTENER_MARCA_POR_NOMBRE = "SELECT * FROM TiendaLocal.marca WHERE nombre_marca = ?";
    private final String SENTENCIA_CREAR_MARCA = "INSERT INTO TiendaLocal.marca (nombre_marca) VALUES ( ? )";
    private final String SENTENCIA_ACTUALIZAR_MARCA = "UPDATE TiendaLocal.marca SET nombre_marca = ? WHERE id_marca = ?";
    private final String SENTENCIA_EXISTE_MARCA = "SELECT nombre_marca FROM TiendaLocal.marca WHERE nombre_marca = ?";
    
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
                String nombreMarca = marca_Resultado.getString("nombre_marca");
                int idMarca = marca_Resultado.getInt("id_marca");
                
                List<Repuesto> listaRepuestos = new ArrayList<>();
                
                Marca marca = new Marca(idMarca, nombreMarca, listaRepuestos);
                
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
                String nombreMarca = marca_Resultado.getString("nombre_marca");
                int idMarca = marca_Resultado.getInt("id_marca");
                
                List<Repuesto> listaRepuestos = new ArrayList<>();
                
                marca = new Marca(idMarca, nombreMarca, listaRepuestos);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return marca;
    }

    @Override
    public boolean existeMarca(String nombreMarca) {
        ResultSet marca_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_EXISTE_MARCA);
            preparedStatement.setString(1, nombreMarca);
            marca_Resultado = preparedStatement.executeQuery();

            if (marca_Resultado.next()) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
            // Asegúrate de cerrar los recursos para evitar fugas de memoria
            if (marca_Resultado != null) {
                try {
                    marca_Resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return false;
    }
    //SENTENCIA_OBTENER_MARCA_POR_NOMBRE
    @Override
    public Marca obtenerMarcaPorNombre(String nombreMarcaBuscar) {
        Marca marca = null;
        ResultSet marca_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_MARCA_POR_NOMBRE);
            preparedStatement.setString(1, nombreMarcaBuscar);
            marca_Resultado = preparedStatement.executeQuery();

            if (marca_Resultado.next()) {
                String nombreMarca = marca_Resultado.getString("nombre_marca");
                int idMarca = marca_Resultado.getInt("id_marca");
                
                List<Repuesto> listaRepuestos = new ArrayList<>();
                
                marca = new Marca(idMarca, nombreMarca, listaRepuestos);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
            // Asegúrate de cerrar los recursos para evitar fugas de memoria
            if (marca_Resultado != null) {
                try {
                    marca_Resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return marca;
    }
}
