package dao.impl;

import dao.interfaces.FacturaDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Factura;

public class FacturaDAOImpl implements FacturaDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_FACTURA = "DELETE FROM TiendaLocal.factura WHERE id_factura = ?";
    private final String SENTENCIA_OBTENER_FACTURAS = "SELECT * FROM TiendaLocal.factura ORDER BY id_factura ASC";
    private final String SENTENCIA_OBTENER_FACTURA = "SELECT * FROM TiendaLocal.factura WHERE id_factura = ?";
    private final String SENTENCIA_CREAR_FACTURA = "INSERT INTO TiendaLocal.factura (estado, montoTotal) VALUES ( ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_FACTURA = "UPDATE TiendaLocal.factura SET estado = ?, nombre_factura = ? WHERE id_factura = ?";

    public FacturaDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void crearFactura(Factura factura) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_FACTURA);
            preparedStatement.setString(1, factura.getEstado());
            preparedStatement.setBigDecimal(2, factura.getMontoTotal());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Factura> obtenerFacturas() {
        List<Factura> listaFacturas = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_FACTURAS);
            ResultSet factura_Resultado = preparedStatement.executeQuery();
            
            while (factura_Resultado.next()){
                int id = factura_Resultado.getInt("id_factura");
                String estado = factura_Resultado.getString("estado");
                BigDecimal montoTotal = factura_Resultado.getBigDecimal("montoTotal");
                
                Factura factura = new Factura(id, estado, montoTotal);
                
                listaFacturas.add(factura);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaFacturas;
    }

    @Override
    public Factura obtenerFactura(int id) {
        Factura factura = null;
        ResultSet factura_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_FACTURAS);
            factura_Resultado = preparedStatement.executeQuery();
            
            if(factura_Resultado.next()){
                String estado = factura_Resultado.getString("estado");
                BigDecimal montoTotal = factura_Resultado.getBigDecimal("montoTotal");
                
                factura = new Factura(id, estado, montoTotal);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return factura;
    }

    @Override
    public void actualizarFactura(Factura factura) {
        try { //UPDATE TiendaLocal.precio SET fechaPrecio = ? , valor = ? , id_repuesto = ? WHERE id_precio = ?
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_FACTURA);
            preparedStatement.setString(1, factura.getEstado());
            preparedStatement.setBigDecimal(2, factura.getMontoTotal());
            preparedStatement.setInt(3, factura.getId_factura());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarFactura(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_FACTURA);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrecioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
