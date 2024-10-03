package dao.impl;

import dao.interfaces.PagoDAO;
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
import model.Factura;
import model.Pago;
import model.Pago;

public class PagoDAOImpl implements PagoDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_PAGO = "DELETE FROM TiendaLocal.pago WHERE id_pago = ?";
    private final String SENTENCIA_OBTENER_PAGOS = "SELECT * FROM TiendaLocal.pago ORDER BY id_pago ASC";
    private final String SENTENCIA_OBTENER_PAGOS_POR_ID_FACTURA = "SELECT * FROM TiendaLocal.pago WHERE id_factura = ?";
    private final String SENTENCIA_OBTENER_PAGO = "SELECT * FROM TiendaLocal.pago WHERE id_pago = ?";
    private final String SENTENCIA_CREAR_PAGO = "INSERT INTO TiendaLocal.pago (id_factura, montoAbonado, fechaPago, detalle) VALUES ( ? , ? , ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_PAGO = "UPDATE TiendaLocal.pago SET id_factura = ?, montoAbonado = ?, fechaPago = ?, detalle = ? WHERE id_pago = ?";

    public PagoDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void crearPago(Pago pago) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_PAGO);
            preparedStatement.setInt(1, pago.getFactura().getId_factura());
            preparedStatement.setBigDecimal(2, pago.getMontoAbonado());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(pago.getFechaPago()));
            preparedStatement.setString(4, pago.getDetalle());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pago> obtenerPagos() {
        List<Pago> listaPagos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_PAGOS);
            ResultSet pago_Resultado = preparedStatement.executeQuery();
            
            while (pago_Resultado.next()){
                Timestamp fechaPrecio = pago_Resultado.getTimestamp("fechaPago");
                LocalDateTime fechaLocal = fechaPrecio.toLocalDateTime();
                
                int idPago = pago_Resultado.getInt("id_pago");
                int idFactura = pago_Resultado.getInt("id_factura");
                String detalle = pago_Resultado.getString("detalle");
                BigDecimal montoAbonado = pago_Resultado.getBigDecimal("montoAbonado");
                
                FacturaDAOImpl facturaDAO = new FacturaDAOImpl(connection);
                Factura factura = facturaDAO.obtenerFactura(idFactura);
                
                Pago pago = new Pago(idPago, factura, montoAbonado, fechaLocal, detalle);
                
                listaPagos.add(pago);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaPagos;
    }

    @Override
    public Pago obtenerPago(int id) {
        Pago pago = null;
        ResultSet pago_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_PAGOS);
            pago_Resultado = preparedStatement.executeQuery();
            
            if(pago_Resultado.next()){
                Timestamp fechaPrecio = pago_Resultado.getTimestamp("fechaPago");
                LocalDateTime fechaLocal = fechaPrecio.toLocalDateTime();
                
                int idPago = pago_Resultado.getInt("id_pago");
                int idFactura = pago_Resultado.getInt("id_factura");
                String detalle = pago_Resultado.getString("detalle");
                BigDecimal montoAbonado = pago_Resultado.getBigDecimal("montoAbonado");
                
                FacturaDAOImpl facturaDAO = new FacturaDAOImpl(connection);
                Factura factura = facturaDAO.obtenerFactura(idFactura);
                
                pago = new Pago(idPago, factura, montoAbonado, fechaLocal, detalle);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pago;
    }

    @Override
    public void actualizarPago(Pago pago) {
        try { //UPDATE TiendaLocal.precio SET fechaPrecio = ? , valor = ? , id_repuesto = ? WHERE id_precio = ?
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_PAGO);
            preparedStatement.setInt(1, pago.getFactura().getId_factura());
            preparedStatement.setBigDecimal(2, pago.getMontoAbonado());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(pago.getFechaPago()));
            preparedStatement.setString(4, pago.getDetalle());
            preparedStatement.setInt(5, pago.getId_pago());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarPago(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_PAGO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pago> obtenerPagosPorIdFactura(int id_factura) {
        List<Pago> listaPagos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_PAGOS_POR_ID_FACTURA);
            preparedStatement.setInt(1, id_factura);
            ResultSet pago_Resultado = preparedStatement.executeQuery();
            
            while (pago_Resultado.next()){
                Timestamp fechaPrecio = pago_Resultado.getTimestamp("fechaPago");
                LocalDateTime fechaLocal = fechaPrecio.toLocalDateTime();
                
                int idPago = pago_Resultado.getInt("id_pago");
                int idFactura = pago_Resultado.getInt("id_factura");
                String detalle = pago_Resultado.getString("detalle");
                BigDecimal montoAbonado = pago_Resultado.getBigDecimal("montoAbonado");
                
                FacturaDAOImpl facturaDAO = new FacturaDAOImpl(connection);
                Factura factura = facturaDAO.obtenerFactura(idFactura);
                
                Pago pago = new Pago(idPago, factura, montoAbonado, fechaLocal, detalle);
                
                listaPagos.add(pago);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaPagos;
    }
}
