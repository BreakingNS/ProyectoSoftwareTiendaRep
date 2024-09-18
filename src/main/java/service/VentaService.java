package service;

import dao.impl.RepuestoDAOImpl;
import dao.impl.VentaDAOImpl;
import dao.impl.VentaRepuestoDAOImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Repuesto;
import model.Venta;

public class VentaService {
    
    private final Connection connection;
    private final VentaDAOImpl ventaDAO;
    private final RepuestoDAOImpl repuestoDAO;
    private final VentaRepuestoDAOImpl VentaRepuestoDAO;

    public VentaService(VentaDAOImpl ventaDAO, RepuestoDAOImpl repuestoDAO, VentaRepuestoDAOImpl VentaRepuestoDAO, Connection connection) {
        this.ventaDAO = ventaDAO;
        this.repuestoDAO = repuestoDAO;
        this.VentaRepuestoDAO = VentaRepuestoDAO;
        this.connection = connection;
    }
    
    public void agregarVenta(Venta venta, List<Repuesto> listaRepuestos) throws SQLException{
        boolean autoCommitState = connection.getAutoCommit(); // Guardar el estado original
        connection.setAutoCommit(false); // Desactivar auto-commit
        try {
            // Realizar operaciones de la transacción
            ventaDAO.crearVenta(venta);
            
            List<Venta> listaVentas= ventaDAO.obtenerVentas();
            venta = listaVentas.get(listaVentas.size()-1);
            
            Map<Repuesto, Integer> contador = new HashMap<>();
            
            for(Repuesto repuesto : listaRepuestos){
                contador.put(repuesto, contador.getOrDefault(repuesto, 0) + 1);
            }
            
            for(Map.Entry<Repuesto, Integer> entry : contador.entrySet()){
                Repuesto repuesto = entry.getKey();
                int cantidad = entry.getValue();
                
                System.out.println("Repuesto: " + repuesto.getNombreRepuesto().getNombre_repuesto() + ". Cantidad: " + cantidad );
                
                VentaRepuestoDAO.crearVentaRepuesto(venta.getId_venta(), repuesto.getId_repuesto(), cantidad);
            }
            
            descontarStockPorLista(listaRepuestos);

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
    
    public void eliminarVentaPorId(int id) throws SQLException{
        
        boolean autoCommitState = connection.getAutoCommit(); 
        connection.setAutoCommit(false); 
        try {
            ventaDAO.eliminarVenta(id);
        
            VentaRepuestoDAO.eliminarVentaRepuestoPorVenta(id);

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(autoCommitState);
        }
    }
    /*
    public void nuevaVenta(Venta venta, List<Repuesto> listaRepuestos) throws SQLException {
        boolean autoCommitState = connection.getAutoCommit();
        connection.setAutoCommit(false);

        try {
            ventaDAO.crearVenta(venta); 
            
            VentaRepuestoDAO.crearVentaRepuesto(venta, listaRepuestos);
            
            descontarStockPorLista(listaRepuestos);

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(autoCommitState);
        }
    }
    */
    public void descontarStockPorIdRepuesto(Repuesto repuesto){
        Repuesto repAux = repuestoDAO.obtenerRepuesto(repuesto.getId_repuesto());
        repAux.setStock(repAux.getStock() - 1);
        repuestoDAO.actualizarRepuesto(repAux);
    }
    
    public void descontarStockPorLista(List<Repuesto> listaRepuestos){
        for(Repuesto rep : listaRepuestos){
            Repuesto repAux = repuestoDAO.obtenerRepuesto(rep.getId_repuesto());
            repAux.setStock(repAux.getStock() - 1);
            repuestoDAO.actualizarRepuesto(repAux);
        }
    }

}
