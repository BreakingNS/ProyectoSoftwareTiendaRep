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
    /*
    Columnas/Campos de la Tabla Repuesto
    
    id_repuesto
    nombre_repuesto
    */
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_REPUESTO = 
            "DELETE FROM TiendaLocal.repuesto WHERE id_repuesto = ?";
    private final String SENTENCIA_OBTENER_REPUESTOS = 
            "SELECT * FROM TiendaLocal.repuesto";
    private final String SENTENCIA_OBTENER_REPUESTO = 
            "SELECT * FROM TiendaLocal.repuesto WHERE id_repuesto = ?";
    private final String SENTENCIA_CREAR_REPUESTO = 
            "INSERT INTO TiendaLocal.repuesto (stock, id_nombrerepuesto, id_marca, id_categoria, id_precio, id_ubicacion) VALUES ( ? , ? , ? , ? , ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_REPUESTO = 
            "UPDATE TiendaLocal.repuesto SET stock = ?, id_nombrerepuesto = ?, id_marca = ?, id_categoria = ?, id_precio = ?, id_ubicacion = ? WHERE id_repuesto = ?";

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
            preparedStatement.setInt(5, repuesto.getPrecio().getId_precio());
            preparedStatement.setInt(6, repuesto.getUbicacion().getId_ubicacion());
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
                int stock = repuesto_Resultado.getInt("stock");
                int id_repuesto = repuesto_Resultado.getInt("id_repuesto");
                int id_nombrepuesto = repuesto_Resultado.getInt("id_nombrepuesto");
                int id_marca = repuesto_Resultado.getInt("id_marca");
                int id_categoria = repuesto_Resultado.getInt("id_categoria");
                int id_precio = repuesto_Resultado.getInt("id_precio");
                int id_ubicacion = repuesto_Resultado.getInt("id_ubicacion");
                
                //RepuestoDAOImpl repuestoDAO = new RepuestoDAOImpl(connection);
                NombreRepuestoDAOImpl nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
                MarcaDAOImpl marcaDAO = new MarcaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                PrecioDAOImpl precioDAO = new PrecioDAOImpl(connection);
                UbicacionDAOImpl ubicacionDAO = new UbicacionDAOImpl(connection);
                
                NombreRepuesto nombreRepuesto = nombreRepuestoDAO.obtenerNombreRepuesto(id_repuesto);
                Marca marca = marcaDAO.obtenerMarca(id_marca);
                Categoria categoria = categoriaDAO.obtenerCategoria(id_categoria);
                Precio precio = precioDAO.obtenerPrecio(id_precio);
                Ubicacion ubicacion = ubicacionDAO.obtenerUbicacion(id_ubicacion);
                
                Repuesto repuesto = new Repuesto(id_repuesto, stock, nombreRepuesto, marca, categoria, precio, ubicacion);
                
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
            preparedStatement.setInt(1, repuesto.getId_repuesto());
            preparedStatement.setInt(2, repuesto.getStock());
            preparedStatement.setInt(3, repuesto.getNombreRepuesto().getId_nombrerepuesto());
            preparedStatement.setInt(4, repuesto.getMarca().getId_marca());
            preparedStatement.setInt(5, repuesto.getCategoria().getId_categoria());
            preparedStatement.setInt(6, repuesto.getPrecio().getId_precio());
            preparedStatement.setInt(7, repuesto.getUbicacion().getId_ubicacion());
            preparedStatement.setInt(8, repuesto.getId_repuesto());
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
        ResultSet repuesto_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPUESTO);
            preparedStatement.setInt(1, id);
            repuesto_Resultado = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (Repuesto) repuesto_Resultado;
    }

}
