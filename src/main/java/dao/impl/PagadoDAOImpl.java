package dao.impl;

import dao.interfaces.PagadoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pagado;
import model.Pagado;

public class PagadoDAOImpl implements PagadoDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_PAGADO = "DELETE FROM TiendaLocal.pagado WHERE id_pagado = ?";
    private final String SENTENCIA_OBTENER_PAGADOS = "SELECT * FROM TiendaLocal.pagado";
    private final String SENTENCIA_OBTENER_PAGADO = "SELECT * FROM TiendaLocal.pagado WHERE id_pagado = ?";
    private final String SENTENCIA_OBTENER_PAGADO_POR_NOMBRE = "SELECT * FROM TiendaLocal.pagado WHERE nombre_pago = ?";
    private final String SENTENCIA_CREAR_PAGADO = "INSERT INTO TiendaLocal.pagado (nombre_pago) VALUES ( ? )";
    private final String SENTENCIA_ACTUALIZAR_PAGADO = "UPDATE TiendaLocal.pagado SET nombre_pago = ? WHERE id_pagado = ?";
    private final String SENTENCIA_EXISTE_PAGADO = "SELECT nombre_pago FROM TiendaLocal.pagado WHERE nombre_pago = ?";
    
    public PagadoDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void crearPagado(Pagado pagado) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_PAGADO);
            preparedStatement.setString(1, pagado.getNombre_pago());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PagadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pagado> obtenerPagados() {
        List<Pagado> listaPagados = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_PAGADOS);
            ResultSet pagado_Resultado = preparedStatement.executeQuery();
            
            while (pagado_Resultado.next()){
                String nombrePagado = pagado_Resultado.getString("nombre_pago");
                int idPagado = pagado_Resultado.getInt("id_pagado");
                
                Pagado pagado = new Pagado(idPagado, nombrePagado);
                
                listaPagados.add(pagado);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PagadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaPagados;
    }


    @Override
    public void actualizarPagado(Pagado pagado) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_PAGADO);
            preparedStatement.setString(1, pagado.getNombre_pago());
            preparedStatement.setInt(2, pagado.getId_pagado());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PagadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarPagado(int id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_PAGADO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PagadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Pagado obtenerPagado(int id) {
        Pagado pagado = null;
        ResultSet pagado_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_PAGADO);
            preparedStatement.setInt(1, id);
            pagado_Resultado = preparedStatement.executeQuery();
            
            if(pagado_Resultado.next()){
                String nombrePagado = pagado_Resultado.getString("nombre_pago");
                int idPagado = pagado_Resultado.getInt("id_pagado");
                
                pagado = new Pagado(idPagado, nombrePagado);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PagadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pagado;
    }
    
    @Override
    public boolean existePagado(String nombrePagado) {
        ResultSet pagado_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_EXISTE_PAGADO);
            preparedStatement.setString(1, nombrePagado);
            pagado_Resultado = preparedStatement.executeQuery();

            if (pagado_Resultado.next()) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PagadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
            // Asegúrate de cerrar los recursos para evitar fugas de memoria
            if (pagado_Resultado != null) {
                try {
                    pagado_Resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PagadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return false;
    }

    @Override
    public Pagado obtenerPagadoPorNombre(String nombrePagadoBuscar) {
        Pagado pagado = null;
        ResultSet pagado_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_PAGADO_POR_NOMBRE);
            preparedStatement.setString(1, nombrePagadoBuscar);
            pagado_Resultado = preparedStatement.executeQuery();

            if (pagado_Resultado.next()) {
                String nombrePagado = pagado_Resultado.getString("nombre_pago");
                int idPagado = pagado_Resultado.getInt("id_pagado");
                
                pagado = new Pagado(idPagado, nombrePagado);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PagadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   finally {
            // Asegúrate de cerrar los recursos para evitar fugas de memoria
            if (pagado_Resultado != null) {
                try {
                    pagado_Resultado.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PagadoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return pagado;
    }
}
