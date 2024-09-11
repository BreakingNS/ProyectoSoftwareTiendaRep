package service;

import dao.impl.RepuestoDAOImpl;
import dao.impl.ReparacionDAOImpl;
import dao.impl.ReparacionRepuestoDAOImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Repuesto;
import model.Reparacion;

public class ReparacionService {
    
    private final Connection connection;
    private final ReparacionDAOImpl reparacionDAO;
    private final RepuestoDAOImpl repuestoDAO;
    private final ReparacionRepuestoDAOImpl ReparacionRepuestoDAO;

    public ReparacionService(ReparacionDAOImpl reparacionDAO, RepuestoDAOImpl repuestoDAO, ReparacionRepuestoDAOImpl ReparacionRepuestoDAO, Connection connection) {
        this.reparacionDAO = reparacionDAO;
        this.repuestoDAO = repuestoDAO;
        this.ReparacionRepuestoDAO = ReparacionRepuestoDAO;
        this.connection = connection;
    }
    
    public void agregarReparacion(Reparacion reparacion, List<Repuesto> listaRepuestos) throws SQLException{
        boolean autoCommitState = connection.getAutoCommit(); // Guardar el estado original
        connection.setAutoCommit(false); // Desactivar auto-commit
        try {
            // Realizar operaciones de la transacción
            reparacionDAO.crearReparacion(reparacion);
        
            ReparacionRepuestoDAO.crearReparacionRepuesto(reparacion, listaRepuestos);
            
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
    
    public List<Reparacion> listarReparaciones() {
        return reparacionDAO.obtenerReparaciones();
    }
    
    public Reparacion obtenerReparacionPorId(int id) {
        return reparacionDAO.obtenerReparacion(id);
    }
    
    public void editarReparacion(Reparacion reparacion){
        reparacionDAO.actualizarReparacion(reparacion);
    }
    
    public void eliminarReparacionPorId(int id) throws SQLException{
        
        boolean autoCommitState = connection.getAutoCommit(); 
        connection.setAutoCommit(false); 
        try {
            reparacionDAO.eliminarReparacion(id);
        
            ReparacionRepuestoDAO.eliminarReparacionRepuestoPorReparacion(id);

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
    
    public void nuevaReparacion(Reparacion reparacion, List<Repuesto> listaRepuestos) throws SQLException {
        boolean autoCommitState = connection.getAutoCommit();
        connection.setAutoCommit(false);

        try {
            reparacionDAO.crearReparacion(reparacion); 
            
            ReparacionRepuestoDAO.crearReparacionRepuesto(reparacion, listaRepuestos);
            
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
