package dao.impl;

import dao.interfaces.PrecioDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Precio;
import model.Repuesto;

public class PrecioDAOImpl implements PrecioDAO{
    
    private Connection connection = null;
    private final RepuestoDAOImpl repuestoDAO;
    private final String SENTENCIA_ELIMINAR_PRECIO = "DELETE FROM TiendaLocal.precio WHERE id_precio = ?";
    private final String SENTENCIA_ELIMINAR_PRECIO_POR_ID_REPUESTO = "DELETE FROM TiendaLocal.precio WHERE id_repuesto = ?";
    private final String SENTENCIA_OBTENER_PRECIOS = "SELECT * FROM TiendaLocal.precio ORDER BY id_precio ASC";
    private final String SENTENCIA_OBTENER_PRECIO = "SELECT * FROM TiendaLocal.precio WHERE id_precio = ?";
    private final String SENTENCIA_OBTENER_PRECIO_POR_ID_REPUESTO = "SELECT * FROM TiendaLocal.precio WHERE id_repuesto = ?";
    private final String SENTENCIA_CREAR_PRECIO = "INSERT INTO TiendaLocal.precio (fechaPrecio, valor, id_repuesto) VALUES ( ? , ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_PRECIO = "UPDATE TiendaLocal.precio SET fechaPrecio = ? , valor = ? , id_repuesto = ? WHERE id_precio = ?";

    public PrecioDAOImpl(Connection connection) {
        this.connection = connection;
        this.repuestoDAO = new RepuestoDAOImpl(connection);
    }

    @Override
    public void crearPrecio(Precio precio) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_PRECIO);
            preparedStatement.setTimestamp(1, java.sql.Timestamp.valueOf(precio.getFechaPrecio()));
            preparedStatement.setBigDecimal(2, precio.getValor());
            preparedStatement.setInt(3, precio.getRepuesto().getId_repuesto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Precio> obtenerPrecios() {
        List<Precio> listaPrecios = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_PRECIOS);
            ResultSet precio_Resultado = preparedStatement.executeQuery();
            
            while(precio_Resultado.next()){
                Timestamp fechaPrecio = precio_Resultado.getTimestamp("fechaPrecio");
                LocalDateTime fechaLocal = fechaPrecio.toLocalDateTime();
                
                BigDecimal valor = precio_Resultado.getBigDecimal("valor");
                int idPrecio = precio_Resultado.getInt("id_precio");
                int idRepuesto = precio_Resultado.getInt("id_repuesto");
                
                Repuesto repuesto = repuestoDAO.obtenerRepuesto(idRepuesto);

                Precio precio = new Precio(idPrecio, repuesto, fechaLocal, valor);
                
                listaPrecios.add(precio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPrecios;
    }

    @Override
    public void actualizarPrecio(Precio precio) {
        try { //UPDATE TiendaLocal.precio SET fechaPrecio = ? , valor = ? , id_repuesto = ? WHERE id_precio = ?
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_PRECIO);
            Timestamp timestamp = java.sql.Timestamp.valueOf(precio.getFechaPrecio());
            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setBigDecimal(2, precio.getValor());
            preparedStatement.setInt(3, precio.getRepuesto().getId_repuesto());
            preparedStatement.setInt(4, precio.getId_precio());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarPrecio(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_PRECIO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Precio obtenerPrecio(int id) {
        Precio precio = null;
        ResultSet precio_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_PRECIO);
            preparedStatement.setInt(1, id);
            precio_Resultado = preparedStatement.executeQuery();
            
            if(precio_Resultado.next()){
                Timestamp fechaPrecio = precio_Resultado.getTimestamp("fechaPrecio");
                LocalDateTime fechaLocal = fechaPrecio.toLocalDateTime();
                BigDecimal valor = precio_Resultado.getBigDecimal("valor");
                int idPrecio = precio_Resultado.getInt("id_precio");
                int idRepuesto = precio_Resultado.getInt("id_repuesto");
                
                Repuesto repuesto = repuestoDAO.obtenerRepuesto(idRepuesto);

                precio = new Precio(idPrecio, repuesto, fechaLocal, valor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return precio;
        
    }

    @Override
    public List<Precio> obtenerPreciosPorIdRepuesto(int id) {
        Precio precio = null;
        List<Precio> listaPrecios = new ArrayList<>();
        ResultSet precio_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_PRECIO_POR_ID_REPUESTO);
            preparedStatement.setInt(1, id);
            precio_Resultado = preparedStatement.executeQuery();
            
            while(precio_Resultado.next()){
                Timestamp fechaPrecio = precio_Resultado.getTimestamp("fechaPrecio");
                LocalDateTime fechaLocal = fechaPrecio.toLocalDateTime();
                BigDecimal valor = precio_Resultado.getBigDecimal("valor");
                int idPrecio = precio_Resultado.getInt("id_precio");
                int idRepuesto = precio_Resultado.getInt("id_repuesto");
                
                Repuesto repuesto = repuestoDAO.obtenerRepuesto(idRepuesto);

                precio = new Precio(idPrecio, repuesto, fechaLocal, valor);
                
                listaPrecios.add(precio);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaPrecios;
    }

    @Override
    public void eliminarPreciosPorIdRepuesto(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_PRECIO_POR_ID_REPUESTO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
