package service;

import dao.impl.RepuestoDAOImpl;
import dao.impl.VentaDAOImpl;
import dao.interfaces.RepuestoDAO;
import dao.interfaces.VentaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Repuesto;
import model.Venta;

public class VentaService {
    
    private final Connection connection;
    private final VentaDAOImpl ventaDAO;
    private final RepuestoDAOImpl repuestoDAO;

    public VentaService(VentaDAOImpl ventaDAO, RepuestoDAOImpl repuestoDAO, Connection connection) {
        this.ventaDAO = ventaDAO;
        this.repuestoDAO = repuestoDAO;
        this.connection = connection;
    }
    
    public void agregarVenta(Venta venta){
        ventaDAO.crearVenta(venta);
    }
    
    public List<Venta> listarVentas() {
        return ventaDAO.obtenerVentas();
    }
    
    public Venta obtenerVentaPorId(int id) {
        // Lógica adicional si es necesario
        return ventaDAO.obtenerVenta(id);
    }
    
    public void editarVenta(Venta venta){
        ventaDAO.actualizarVenta(venta);
    }
    
    public void eliminarVentaPorId(int id){
        ventaDAO.eliminarVenta(id);
    }
    
    // Método para imprimir las categorías (si esto es parte de la lógica de negocio)
    public void imprimirVentas() {
        List<Venta> listaVentas = listarVentas();
        
        for(Venta ven : listaVentas){
            System.out.println("------------------");
            System.out.println("Id: " + ven.getId_venta());
            System.out.println("Cantidad: " + ven.getCantidad());
            System.out.println("Fecha Venta: " + ven.getFecha_venta());
            System.out.println("Cliente: " + ven.getCliente().getId_cliente());
        }
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


    
    public void nuevaVenta1(Venta venta, Repuesto repuesto){
        ventaDAO.crearVenta(venta);
        
        int stockVenta = venta.getCantidad();
        int stockActual = repuesto.getStock() - stockVenta;
        repuesto.setStock(stockVenta);
        
        repuestoDAO.actualizarRepuesto(repuesto);
    }
    
    //Reportes Ventas
}
