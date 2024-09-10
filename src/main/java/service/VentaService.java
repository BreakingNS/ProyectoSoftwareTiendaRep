package service;

import dao.impl.RepuestoDAOImpl;
import dao.impl.VentaDAOImpl;
import dao.impl.VentaRepuestoDAOImplVIEJOOOOO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Repuesto;
import model.Venta;

public class VentaService {
    
    private final Connection connection;
    private final VentaDAOImpl ventaDAO;
    private final RepuestoDAOImpl repuestoDAO;
    private final VentaRepuestoDAOImplVIEJOOOOO VentaRepuestoDAO;

    public VentaService(VentaDAOImpl ventaDAO, RepuestoDAOImpl repuestoDAO, VentaRepuestoDAOImplVIEJOOOOO VentaRepuestoDAO, Connection connection) {
        this.ventaDAO = ventaDAO;
        this.repuestoDAO = repuestoDAO;
        this.VentaRepuestoDAO = VentaRepuestoDAO;
        this.connection = connection;
    }
    
    public void agregarVenta(Venta venta, Repuesto repuesto) throws SQLException{
        boolean autoCommitState = connection.getAutoCommit(); // Guardar el estado original
        connection.setAutoCommit(false); // Desactivar auto-commit
        try {
            // Realizar operaciones de la transacción
            ventaDAO.crearVenta(venta);
        
            VentaRepuestoDAO.crearVentaRepuesto(venta, repuesto);

            connection.commit(); // Confirmar la transacción

        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(autoCommitState); // Restablecer auto-commit al estado original
        }
    }
    
    public List<Venta> listarVentas() {
        return ventaDAO.obtenerVentas();
    }
    
    public Venta obtenerVentaPorId(int id) {
        return ventaDAO.obtenerVenta(id);
    }
    
    public void editarVenta(Venta venta){
        ventaDAO.actualizarVenta(venta);
    }
    
    public void eliminarVentaPorId(int id){
        ventaDAO.eliminarVenta(id);
    }
    
    public void nuevaVenta(Venta venta, Repuesto repuesto) throws SQLException {
        boolean autoCommitState = connection.getAutoCommit(); // Guardar el estado original
        connection.setAutoCommit(false); // Desactivar auto-commit

        try {
            // Realizar operaciones de la transacción
            ventaDAO.crearVenta(venta); // Usar la conexión proporcionada
            int stockVenta = venta.getCantidad();
            int stockActual = repuesto.getStock() - stockVenta;
            repuesto.setStock(stockActual);

            repuestoDAO.actualizarRepuesto(repuesto); // Usar la conexión proporcionada

            connection.commit(); // Confirmar la transacción

        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(autoCommitState); // Restablecer auto-commit al estado original
        }
    }
}
