package dao.impl;

import dao.interfaces.VentaRepuestoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Repuesto;
import model.Venta;
import model.VentaRepuesto;

public class VentaRepuestoDAOImplVIEJOOOOO implements VentaRepuestoDAO{

    private Connection connection = null;
    private final String SENTENCIA_CREAR_VENTA_REPUESTO = 
            "INSERT INTO TiendaLocal.Venta_Repuesto (id_venta, id_repuesto) VALUES ( ? , ? )";
    private final String SENTENCIA_OBTENER_VENTA_REPUESTOS = 
            "SELECT * FROM TiendaLocal.Venta_Repuesto ORDER BY id_repuesto ASC";
    private final String SENTENCIA_OBTENER_VENTA_REPUESTOS_POR_VENTA = 
            "SELECT * FROM TiendaLocal.Venta_Repuesto WHERE id_venta = ?";
    private final String SENTENCIA_OBTENER_VENTA_REPUESTOS_POR_REPUESTO = 
            "SELECT * FROM TiendaLocal.Venta_Repuesto WHERE id_repuesto = ?";
    private final String SENTENCIA_ACTUALIZAR_VENTA_REPUESTO_POR_VENTA = 
            "UPDATE TiendaLocal.Venta_Repuesto SET id_repuesto = ? WHERE id_venta = ?";
    private final String SENTENCIA_ACTUALIZAR_VENTA_REPUESTO_POR_REPUESTO = 
            "UPDATE TiendaLocal.Venta_Repuesto SET id_venta = ? WHERE id_repuesto = ?";
    private final String SENTENCIA_ELIMINAR_VENTA_REPUESTO_POR_VENTA = 
            "DELETE FROM TiendaLocal.Venta_Repuesto WHERE id_venta = ? AND id_repuesto = ?";

    public VentaRepuestoDAOImplVIEJOOOOO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearVentaRepuesto(Venta venta, Repuesto repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_VENTA_REPUESTO);
            preparedStatement.setInt(1, venta.getId_venta());
            preparedStatement.setInt(2, repuesto.getId_repuesto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<VentaRepuesto> obtenerVentaRepuestos() {
        List<VentaRepuesto> listaVentaRepuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_VENTA_REPUESTOS);
            ResultSet repuesto_VentaResultado = preparedStatement.executeQuery();
            
            while(repuesto_VentaResultado.next()){
                int idVenta = repuesto_VentaResultado.getInt("id_venta");
                int idRepuesto = repuesto_VentaResultado.getInt("id_repuesto");
                
                VentaRepuesto ventaRepuesto = new VentaRepuesto(idVenta, idRepuesto);
                
                listaVentaRepuestos.add(ventaRepuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaVentaRepuestos;
    }
        
    @Override
    public List<VentaRepuesto> obtenerVentaRepuestoPorVenta(int id_venta) {
        List<VentaRepuesto> listaVentaRepuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_VENTA_REPUESTOS_POR_VENTA);
            preparedStatement.setInt(1, id_venta);
            ResultSet repuesto_VentaResultado = preparedStatement.executeQuery();
            
            while(repuesto_VentaResultado.next()){
                int idVenta = repuesto_VentaResultado.getInt("id_venta");
                int idRepuesto = repuesto_VentaResultado.getInt("id_repuesto");
                
                VentaRepuesto ventaRepuesto = new VentaRepuesto(idVenta, idRepuesto);
                
                listaVentaRepuestos.add(ventaRepuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaVentaRepuestos;
    }

    @Override
    public List<VentaRepuesto> obtenerVentaRepuestoPorRepuesto(int id_repuesto) {
        List<VentaRepuesto> listaVentaRepuestos = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_VENTA_REPUESTOS_POR_REPUESTO);
            preparedStatement.setInt(1, id_repuesto);
            ResultSet repuesto_VentaResultado = preparedStatement.executeQuery();

            while(repuesto_VentaResultado.next()){
                int idVenta = repuesto_VentaResultado.getInt("id_venta");
                int idRepuesto = repuesto_VentaResultado.getInt("id_repuesto");

                VentaRepuesto ventaRepuesto = new VentaRepuesto(idVenta, idRepuesto);

                listaVentaRepuestos.add(ventaRepuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaVentaRepuestos;
    }


    @Override
    public void actualizarVentaRepuestoPorVenta(int id_venta, int id_repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_VENTA_REPUESTO_POR_VENTA);
            preparedStatement.setInt(1, id_repuesto);
            preparedStatement.setInt(2, id_venta);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void actualizarVentaRepuestoPorRepuesto(int id_venta, int id_repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_VENTA_REPUESTO_POR_REPUESTO);
            preparedStatement.setInt(1, id_venta);
            preparedStatement.setInt(2, id_repuesto);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarVentaRepuesto(int id_venta, int id_repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_VENTA_REPUESTO_POR_VENTA);
            preparedStatement.setInt(1, id_venta);
            preparedStatement.setInt(2, id_repuesto);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
