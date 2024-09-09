package dao.impl;

import dao.interfaces.RepuestoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Marca;
import model.NombreRepuesto;
import model.Precio;
import model.Repuesto;
import model.Ubicacion;

public class RepuestoDAOImpl implements RepuestoDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_REPUESTO = 
            "DELETE FROM TiendaLocal.repuesto WHERE id_repuesto = ?";
    private final String SENTENCIA_OBTENER_REPUESTOS = 
            "SELECT * FROM TiendaLocal.repuesto ORDER BY id_repuesto ASC";
    private final String SENTENCIA_OBTENER_REPUESTO = 
            "SELECT * FROM TiendaLocal.repuesto WHERE id_repuesto = ?";
    private final String SENTENCIA_CREAR_REPUESTO = 
            "INSERT INTO TiendaLocal.repuesto (stock, id_nombrerepuesto, id_marca, id_categoria, id_ubicacion) VALUES ( ? , ? , ? , ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_REPUESTO = 
            "UPDATE TiendaLocal.repuesto SET stock = ?, id_nombrerepuesto = ?, id_marca = ?, id_categoria = ?, id_ubicacion = ? WHERE id_repuesto = ?";

    public RepuestoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearRepuesto(Repuesto repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_REPUESTO);
            preparedStatement.setInt(1, repuesto.getStock());
            preparedStatement.setInt(2, repuesto.getNombreRepuesto().getId_nombrerepuesto());
            preparedStatement.setInt(3, repuesto.getMarca().getId_marca());
            preparedStatement.setInt(4, repuesto.getCategoria().getId_categoria());
            preparedStatement.setInt(5, repuesto.getUbicacion().getId_ubicacion());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Repuesto> obtenerRepuestos() {
        List<Repuesto> listaRepuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPUESTOS);
            ResultSet repuesto_Resultado = preparedStatement.executeQuery();
            
            while(repuesto_Resultado.next()){
                int idRepuesto = repuesto_Resultado.getInt("id_repuesto");
                int stock = repuesto_Resultado.getInt("stock");
                int idNombreRepuesto = repuesto_Resultado.getInt("id_nombrerepuesto");
                int idMarca = repuesto_Resultado.getInt("id_marca");
                int idCategoria = repuesto_Resultado.getInt("id_categoria");
                int idUbicacion = repuesto_Resultado.getInt("id_ubicacion");
                
                NombreRepuestoDAOImpl nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
                MarcaDAOImpl marcaDAO = new MarcaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                UbicacionDAOImpl ubicacionDAO = new UbicacionDAOImpl(connection);
                
                NombreRepuesto nombreRepuesto = nombreRepuestoDAO.obtenerNombreRepuesto(idNombreRepuesto);
                Marca marca = marcaDAO.obtenerMarca(idMarca);
                Categoria categoria = categoriaDAO.obtenerCategoria(idCategoria);
                List<Precio> listaPrecios = new ArrayList<>();
                Ubicacion ubicacion = ubicacionDAO.obtenerUbicacion(idUbicacion);
                
                Repuesto repuesto = new Repuesto(idRepuesto, stock, nombreRepuesto, marca, categoria, listaPrecios, ubicacion);
                
                listaRepuestos.add(repuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaRepuestos;
    }

    @Override
    public void actualizarRepuesto(Repuesto repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_REPUESTO);
            preparedStatement.setInt(1, repuesto.getStock());
            preparedStatement.setInt(2, repuesto.getNombreRepuesto().getId_nombrerepuesto());
            preparedStatement.setInt(3, repuesto.getMarca().getId_marca());
            preparedStatement.setInt(4, repuesto.getCategoria().getId_categoria());
            preparedStatement.setInt(5, repuesto.getUbicacion().getId_ubicacion());
            preparedStatement.setInt(6, repuesto.getId_repuesto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarRepuesto(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_REPUESTO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Repuesto obtenerRepuesto(int id) {
        Repuesto repuesto = null;
        ResultSet repuesto_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPUESTO);
            preparedStatement.setInt(1, id);
            repuesto_Resultado = preparedStatement.executeQuery();
            
            if(repuesto_Resultado.next()){
                int idRepuesto = repuesto_Resultado.getInt("id_repuesto");
                int stock = repuesto_Resultado.getInt("stock");
                int idNombreRepuesto = repuesto_Resultado.getInt("id_nombrerepuesto");
                int idMarca = repuesto_Resultado.getInt("id_marca");
                int idCategoria = repuesto_Resultado.getInt("id_categoria");
                int idUbicacion = repuesto_Resultado.getInt("id_ubicacion");
                
                NombreRepuestoDAOImpl nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
                MarcaDAOImpl marcaDAO = new MarcaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                UbicacionDAOImpl ubicacionDAO = new UbicacionDAOImpl(connection);
                
                NombreRepuesto nombreRepuesto = nombreRepuestoDAO.obtenerNombreRepuesto(idNombreRepuesto);
                Marca marca = marcaDAO.obtenerMarca(idMarca);
                Categoria categoria = categoriaDAO.obtenerCategoria(idCategoria);
                List<Precio> listaPrecios = new ArrayList<>();
                Ubicacion ubicacion = ubicacionDAO.obtenerUbicacion(idUbicacion);
                
                repuesto = new Repuesto(idRepuesto, stock, nombreRepuesto, marca, categoria, listaPrecios, ubicacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return repuesto;
    }

}
