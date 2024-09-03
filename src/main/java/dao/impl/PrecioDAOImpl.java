package dao.impl;

import dao.interfaces.PrecioDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Marca;
import model.Precio;

public class PrecioDAOImpl implements PrecioDAO{
    /*
    Columnas/Campos de la Tabla Precio
    
    id_precio
    nombre_precio
    */
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_PRECIO = "DELETE FROM TiendaLocal.precio WHERE id_precio = ?";
    private final String SENTENCIA_OBTENER_PRECIOS = "SELECT * FROM TiendaLocal.precio";
    private final String SENTENCIA_OBTENER_PRECIO = "SELECT * FROM TiendaLocal.precio WHERE id_precio = ?";
    private final String SENTENCIA_CREAR_PRECIO = "INSERT INTO TiendaLocal.precio (fechaPrecio, valor) VALUES ( ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_PRECIO = "UPDATE TiendaLocal.precio SET fechaPrecio = ? , valor = ? WHERE id_precio = ?";

    public PrecioDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearPrecio(Precio precio) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_PRECIO);
            preparedStatement.setDate(1, precio.getFechaPrecio());
            preparedStatement.setBigDecimal(1, precio.getValor());
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
                Date fechaPrecio = precio_Resultado.getDate("fechaPrecio");
                BigDecimal valor = precio_Resultado.getBigDecimal("valor");
                int idPrecio = precio_Resultado.getInt("id_precio");
                
                Precio precio = new Precio(idPrecio, fechaPrecio, valor);
                
                listaPrecios.add(precio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPrecios;
    }

    @Override
    public void actualizarPrecio(Precio precio) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_PRECIO);
            preparedStatement.setDate(1, precio.getFechaPrecio());
            preparedStatement.setBigDecimal(2, precio.getValor());
            preparedStatement.setInt(3, precio.getId_precio());
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
    public void toStringPrecio() {
        List<Precio> listaPrecios = obtenerPrecios();
        
        for(Precio pre : listaPrecios){
            System.out.println("------------------");
            System.out.println("Id: " + pre.getId_precio());
            System.out.println("Fecha de Precio: " + pre.getFechaPrecio());
            System.out.println("Valor: " + pre.getValor());
        }
    }

    @Override
    public Precio obtenerPrecio(int id) {
        ResultSet precio_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_PRECIO);
            preparedStatement.setInt(1, id);
            precio_Resultado = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (Precio) precio_Resultado;
        
    }
}
