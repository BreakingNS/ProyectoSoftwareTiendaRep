package dao.impl;

import dao.interfaces.ReparacionRepuestoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Repuesto;
import model.Reparacion;
import model.ReparacionRepuesto;

public class ReparacionRepuestoDAOImpl implements ReparacionRepuestoDAO{
    
    private Connection connection = null;
    private final String SENTENCIA_CREAR_REPARACION_REPUESTO = 
            "INSERT INTO TiendaLocal.Reparacion_Repuesto (id_reparacion, id_repuesto) VALUES ( ? , ? )";
    private final String SENTENCIA_OBTENER_REPARACION_REPUESTOS = 
            "SELECT * FROM TiendaLocal.Reparacion_Repuesto ORDER BY id_repuesto ASC";
    private final String SENTENCIA_OBTENER_REPARACION_REPUESTOS_POR_REPARACION = 
            "SELECT * FROM TiendaLocal.Reparacion_Repuesto WHERE id_reparacion = ?";
    private final String SENTENCIA_OBTENER_REPARACION_REPUESTOS_POR_REPUESTO = 
            "SELECT * FROM TiendaLocal.Reparacion_Repuesto WHERE id_repuesto = ?";
    private final String SENTENCIA_ACTUALIZAR_AGREGAR_REPARACION_REPUESTO_POR_REPARACION = 
            "UPDATE TiendaLocal.Reparacion_Repuesto SET id_repuesto = ? WHERE id_reparacion = ?";
    private final String SENTENCIA_ACTUALIZAR_ELIMINAR_REPARACION_REPUESTO_POR_REPUESTO = 
            "UPDATE TiendaLocal.Reparacion_Repuesto SET id_reparacion = ? WHERE id_repuesto = ?";
    private final String SENTENCIA_ELIMINAR_REPARACION_REPUESTO = 
            "DELETE FROM TiendaLocal.Reparacion_Repuesto WHERE id_reparacion = ? AND id_repuesto = ?";
    private final String SENTENCIA_ELIMINAR_REPARACION_REPUESTO_POR_REPARACION = 
            "DELETE FROM TiendaLocal.Reparacion_Repuesto WHERE id_reparacion = ?";
    
    public ReparacionRepuestoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearReparacionRepuesto(Reparacion reparacion, List<Repuesto> listaRepuestos) {
        for(Repuesto repuesto : listaRepuestos){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_REPARACION_REPUESTO);
                preparedStatement.setInt(1, reparacion.getId_reparacion());
                preparedStatement.setInt(2, repuesto.getId_repuesto());
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    @Override
    public List<ReparacionRepuesto> obtenerReparacionRepuestos() {
        List<ReparacionRepuesto> listaReparacionRepuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACION_REPUESTOS);
            ResultSet repuesto_ReparacionResultado = preparedStatement.executeQuery();
            
            while(repuesto_ReparacionResultado.next()){
                int idReparacion = repuesto_ReparacionResultado.getInt("id_reparacion");
                int idRepuesto = repuesto_ReparacionResultado.getInt("id_repuesto");
                
                ReparacionRepuesto reparacionRepuesto = new ReparacionRepuesto(idReparacion, idRepuesto);
                
                listaReparacionRepuestos.add(reparacionRepuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaReparacionRepuestos;
    }

    @Override
    public List<ReparacionRepuesto> obtenerReparacionRepuestoPorReparacion(int id_reparacion) {
        List<ReparacionRepuesto> listaReparacionRepuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACION_REPUESTOS_POR_REPARACION);
            preparedStatement.setInt(1, id_reparacion);
            ResultSet repuesto_ReparacionResultado = preparedStatement.executeQuery();
            
            while(repuesto_ReparacionResultado.next()){
                int idReparacion = repuesto_ReparacionResultado.getInt("id_reparacion");
                int idRepuesto = repuesto_ReparacionResultado.getInt("id_repuesto");
                
                ReparacionRepuesto reparacionRepuesto = new ReparacionRepuesto(idReparacion, idRepuesto);
                
                listaReparacionRepuestos.add(reparacionRepuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaReparacionRepuestos;
    }

    @Override
    public List<ReparacionRepuesto> obtenerReparacionRepuestoPorRepuesto(int id_repuesto) {
        List<ReparacionRepuesto> listaReparacionRepuestos = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACION_REPUESTOS_POR_REPUESTO);
            preparedStatement.setInt(1, id_repuesto);
            ResultSet repuesto_ReparacionResultado = preparedStatement.executeQuery();

            while(repuesto_ReparacionResultado.next()){
                int idReparacion = repuesto_ReparacionResultado.getInt("id_reparacion");
                int idRepuesto = repuesto_ReparacionResultado.getInt("id_repuesto");

                ReparacionRepuesto reparacionRepuesto = new ReparacionRepuesto(idReparacion, idRepuesto);

                listaReparacionRepuestos.add(reparacionRepuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaReparacionRepuestos;
    }

    @Override
    public void actualizarAgregarReparacionRepuestoPorReparacion(int id_reparacion, List<Repuesto> listaRepuesto) {
        for(Repuesto repuesto : listaRepuesto){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_AGREGAR_REPARACION_REPUESTO_POR_REPARACION);
                preparedStatement.setInt(1, repuesto.getId_repuesto());
                preparedStatement.setInt(2, id_reparacion);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void actualizarEliminarReparacionRepuestoPorRepuesto(int id_reparacion, List<Repuesto> listaRepuesto) {
        for(Repuesto repuesto : listaRepuesto){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_ELIMINAR_REPARACION_REPUESTO_POR_REPUESTO);
                preparedStatement.setInt(1, id_reparacion);
                preparedStatement.setInt(2, repuesto.getId_repuesto());
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminarReparacionRepuesto(int id_reparacion, int id_repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_REPARACION_REPUESTO);
            preparedStatement.setInt(1, id_reparacion);
            preparedStatement.setInt(2, id_repuesto);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarReparacionRepuestoPorReparacion(int id_reparacion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_REPARACION_REPUESTO_POR_REPARACION);
            preparedStatement.setInt(1, id_reparacion);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
