package dao.impl;

import dao.interfaces.VentaDAO;
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
import model.Cliente;
import model.Venta;

public class VentaDAOImpl implements VentaDAO{
    /*
    Columnas/Campos de la Tabla Venta
    
    id_venta
    nombre_venta
    */
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_VENTA = "DELETE FROM TiendaLocal.venta WHERE id_venta = ?";
    private final String SENTENCIA_OBTENER_VENTAS = "SELECT * FROM TiendaLocal.venta";
    private final String SENTENCIA_OBTENER_VENTA = "SELECT * FROM TiendaLocal.venta WHILE id_venta = ?";
    private final String SENTENCIA_OBTENER_VENTA_POR_ID_CLIENTE = "SELECT * FROM TiendaLocal.venta WHILE id_cliente = ?";
    private final String SENTENCIA_CREAR_VENTA = "INSERT INTO TiendaLocal.venta (cantidad, fecha-venta, id_cliente, precioFinal) VALUES ( ? , ? , ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_VENTA = "UPDATE TiendaLocal.venta SET cantidad = ?, fecha-venta = ?, id_cliente = ? , precioFinal = ? WHERE id_venta = ?";

    public VentaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearVenta(Venta venta) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_VENTA);
            preparedStatement.setInt(1, venta.getCantidad());
            preparedStatement.setDate(2, venta.getFecha_venta());
            preparedStatement.setInt(3, venta.getCliente().getId_cliente());
            preparedStatement.setBigDecimal(4, venta.getPrecioFinal());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Venta> obtenerVentas() {
        List<Venta> listaVentas = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_VENTAS);
            ResultSet venta_Resultado = preparedStatement.executeQuery();
            
            while(venta_Resultado.next()){
                Integer cantidadVenta = venta_Resultado.getInt("cantidad");
                Date fechaVenta = venta_Resultado.getDate("fecha_venta");
                int idVenta = venta_Resultado.getInt("id_venta");
                int idCliente = venta_Resultado.getInt("id_cliente");
                BigDecimal precioFinal = venta_Resultado.getBigDecimal("precioFinal");
                
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                
                Cliente cliente = clienteDAO.obtenerCliente(idCliente);
                
                Venta venta = new Venta(idVenta, cantidadVenta, fechaVenta, cliente, precioFinal);
                
                listaVentas.add(venta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentas;
    }

    @Override
    public void actualizarVenta(Venta venta) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_VENTA);
            preparedStatement.setInt(1, venta.getCantidad());
            preparedStatement.setDate(2, venta.getFecha_venta());
            preparedStatement.setInt(3,venta.getId_venta());
            preparedStatement.setBigDecimal(4, venta.getPrecioFinal());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarVenta(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_VENTA);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Venta obtenerVenta(int id) {
        ResultSet venta_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_VENTA);
            preparedStatement.setInt(1, id);
            venta_Resultado = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (Venta) venta_Resultado;
    }

    @Override
    public List<Venta> obtenerVentasPorIdCliente(int id) {
        ResultSet venta_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_VENTA_POR_ID_CLIENTE);
            preparedStatement.setInt(1, id);
            venta_Resultado = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (List<Venta>) venta_Resultado;
    }
}
