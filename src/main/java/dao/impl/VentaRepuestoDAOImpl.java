package dao.impl;

import dao.interfaces.VentaRepuestoDAO;
import java.sql.Connection;
import java.util.List;
import model.Repuesto;
import model.Venta;
import model.VentaRepuesto;

public class VentaRepuestoDAOImpl implements VentaRepuestoDAO{

    private final Connection connection;
    private final String SENTENCIA_CREAR_VENTA_REPUESTO = 
            "INSERT INTO TiendaLocal.Venta_Repuesto (id_venta, id_repuesto) VALUES ( ? , ? )";
    private final String SENTENCIA_OBTENER_VENTA_REPUESTOS = 
            "SELECT * FROM TiendaLocal.Venta_Repuesto ORDER BY id_repuesto ASC";
    private final String SENTENCIA_OBTENER_VENTA_REPUESTOS_POR_VENTA = 
            "SELECT * FROM TiendaLocal.Venta_Repuesto WHERE id_venta = ?";
    private final String SENTENCIA_OBTENER_VENTA_REPUESTOS_POR_REPUESTO = 
            "SELECT * FROM TiendaLocal.Venta_Repuesto WHERE id_repuesto = ?";
    private final String SENTENCIA_ACTUALIZAR_AGREGAR_VENTA_REPUESTO_POR_VENTA = 
            "UPDATE TiendaLocal.Venta_Repuesto SET id_repuesto = ? WHERE id_venta = ?";
    private final String SENTENCIA_ACTUALIZAR_ELIMINAR_VENTA_REPUESTO_POR_REPUESTO = 
            "UPDATE TiendaLocal.Venta_Repuesto SET id_venta = ? WHERE id_repuesto = ?";
    private final String SENTENCIA_ELIMINAR_VENTA_REPUESTO = 
            "DELETE FROM TiendaLocal.Venta_Repuesto WHERE id_venta = ? AND id_repuesto = ?";
    private final String SENTENCIA_ELIMINAR_VENTA_REPUESTO_POR_VENTA = 
            "DELETE FROM TiendaLocal.Venta_Repuesto WHERE id_venta = ?";
    
    
    public VentaRepuestoDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void crearVentaRepuesto(Venta venta, List<Repuesto> listaRepuestos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VentaRepuesto> obtenerVentaRepuestos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VentaRepuesto> obtenerVentaRepuestoPorVenta(int id_venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VentaRepuesto> obtenerVentaRepuestoPorRepuesto(int id_repuesto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarAgregarVentaRepuestoPorVenta(int id_venta, List<Repuesto> listaRepuesto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarEliminarVentaRepuestoPorRepuesto(int id_venta, List<Repuesto> listaRepuesto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarVentaRepuesto(int id_venta, int id_repuesto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarVentaRepuestoPorVenta(int id_venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
