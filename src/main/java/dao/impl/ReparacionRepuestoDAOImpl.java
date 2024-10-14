package dao.impl;

import dao.interfaces.ReparacionRepuestoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Repuesto;
import model.Reparacion;
import model.ReparacionRepuesto;

public class ReparacionRepuestoDAOImpl implements ReparacionRepuestoDAO{
    
    private final Connection connection;
    private final String SENTENCIA_CREAR_REPARACION_REPUESTO = 
            "INSERT INTO TiendaLocal.Reparacion_Repuesto (id_reparacion, id_repuesto, cantidad_repuestos) VALUES ( ? , ? , ?)";
    private final String SENTENCIA_OBTENER_REPARACION_REPUESTOS = 
            "SELECT * FROM TiendaLocal.Reparacion_Repuesto ORDER BY id_reparacion ASC, id_repuesto ASC";
    private final String SENTENCIA_OBTENER_REPARACION_REPUESTOS_POR_REPARACION = 
            "SELECT * FROM TiendaLocal.Reparacion_Repuesto WHERE id_reparacion = ? ORDER BY id_reparacion ASC, id_repuesto ASC";
    private final String SENTENCIA_OBTENER_REPARACION_REPUESTOS_POR_REPUESTO = 
            "SELECT * FROM TiendaLocal.Reparacion_Repuesto WHERE id_repuesto = ? ORDER BY id_reparacion ASC, id_repuesto ASC";
    private final String SENTENCIA_ACTUALIZAR_AGREGAR_REPARACION_REPUESTO_POR_REPARACION = 
            "UPDATE TiendaLocal.Reparacion_Repuesto SET cantidad_repuestos = ? WHERE id_reparacion = ? AND id_repuesto = ?";
    private final String SENTENCIA_ACTUALIZAR_ELIMINAR_REPARACION_REPUESTO_POR_REPUESTO = 
            "UPDATE TiendaLocal.Reparacion_Repuesto SET cantidad_repuestos = ? WHERE id_reparacion = ? AND id_repuesto = ?";
    private final String SENTENCIA_ELIMINAR_REPARACION_REPUESTO = 
            "DELETE FROM TiendaLocal.Reparacion_Repuesto WHERE id_reparacion = ? AND id_repuesto = ?";
    private final String SENTENCIA_ELIMINAR_REPARACION_REPUESTO_POR_REPARACION = 
            "DELETE FROM TiendaLocal.Reparacion_Repuesto WHERE id_reparacion = ?";
    
    
    public ReparacionRepuestoDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void crearReparacionRepuesto(int id_reparacion, int id_repuesto, int cantidad) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_REPARACION_REPUESTO);
            preparedStatement.setInt(1, id_reparacion);
            preparedStatement.setInt(2, id_repuesto);
            preparedStatement.setInt(3, cantidad);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                int cantidadRep = repuesto_ReparacionResultado.getInt("cantidad_repuestos");
                
                ReparacionRepuesto reparacionRepuesto = new ReparacionRepuesto(idReparacion, idRepuesto,cantidadRep);
                
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
                int cantidadRep = repuesto_ReparacionResultado.getInt("cantidad_repuestos");
                
                ReparacionRepuesto reparacionRepuesto = new ReparacionRepuesto(idReparacion, idRepuesto,cantidadRep);
                
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
                int cantidadRep = repuesto_ReparacionResultado.getInt("cantidad_repuestos");
                
                ReparacionRepuesto reparacionRepuesto = new ReparacionRepuesto(idReparacion, idRepuesto,cantidadRep);

                listaReparacionRepuestos.add(reparacionRepuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaReparacionRepuestos;
    }
    
    @Override
    public void actualizarAgregarReparacionRepuestoPorReparacion(int id_reparacion, List<Repuesto> listaRepuestosNuevos) {
        ReparacionRepuestoDAOImpl reparacionRepuestoDAO = new ReparacionRepuestoDAOImpl(connection);
        
        List<ReparacionRepuesto> listaRepuestosActualizar = reparacionRepuestoDAO.obtenerReparacionRepuestoPorReparacion(id_reparacion);
        List<ReparacionRepuesto> listaRepuestosNueva = reparacionRepuestoDAO.crearReparacionRepuestoAuxiliar(listaRepuestosNuevos);
        
        for (ReparacionRepuesto reparacionRep : listaRepuestosNueva) {
            boolean existe = false;
            for (ReparacionRepuesto reparacionRepuesto : listaRepuestosActualizar) {
                if (reparacionRepuesto.getId_repuesto() == reparacionRep.getId_repuesto()) {
                    reparacionRepuesto.setCantidad_repuestos(reparacionRepuesto.getCantidad_repuestos() + reparacionRep.getCantidad_repuestos());
                    existe = true;

                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_AGREGAR_REPARACION_REPUESTO_POR_REPARACION);
                        preparedStatement.setInt(1, reparacionRepuesto.getCantidad_repuestos());
                        preparedStatement.setInt(2, id_reparacion);
                        preparedStatement.setInt(3, reparacionRepuesto.getId_repuesto());
                        preparedStatement.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
            if (!existe) {
                ReparacionDAOImpl reparacionDAO = new ReparacionDAOImpl(connection);
                Reparacion reparacion = reparacionDAO.obtenerReparacion(id_reparacion);
                //crearReparacionRepuesto(reparacion, listaRepuestosNuevos); CORREGIR
            }
        }
    }
/*
    
    @Override
    public void actualizarAgregarReparacionRepuestoPorReparacion(int id_reparacion, List<Repuesto> listaRepuestosNuevos) {
        ReparacionRepuestoDAOImpl reparacionRepuestoDAO = new ReparacionRepuestoDAOImpl(connection);
        
        List<ReparacionRepuesto> listaRepuestosActualizar = reparacionRepuestoDAO.obtenerReparacionRepuestoPorReparacion(id_reparacion);
        List<ReparacionRepuesto> listaRepuestosNueva = reparacionRepuestoDAO.crearReparacionRepuestoAuxiliar(listaRepuestosNuevos);
        
        for(ReparacionRepuesto reparacionRepuesto : listaRepuestosActualizar){   
            for(ReparacionRepuesto reparacionRep : listaRepuestosNueva){
                if(reparacionRepuesto.getId_repuesto() == reparacionRep.getId_repuesto()){
                    reparacionRepuesto.setCantidad_repuestos(reparacionRepuesto.getCantidad_repuestos() + reparacionRep.getCantidad_repuestos());
                
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_AGREGAR_REPARACION_REPUESTO_POR_REPARACION);
                        preparedStatement.setInt(1, reparacionRepuesto.getId_repuesto());
                        preparedStatement.setInt(2, reparacionRepuesto.getCantidad_repuestos());
                        preparedStatement.setInt(3, id_reparacion);
                        preparedStatement.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
*/
    
    @Override
    public void actualizarEliminarReparacionRepuestoPorRepuesto(int id_reparacion, List<Repuesto> listaRepuestosEliminar) {
        ReparacionRepuestoDAOImpl reparacionRepuestoDAO = new ReparacionRepuestoDAOImpl(connection);

        List<ReparacionRepuesto> listaRepuestosActualizar = reparacionRepuestoDAO.obtenerReparacionRepuestoPorReparacion(id_reparacion);
        List<ReparacionRepuesto> listaRepuestosNueva = reparacionRepuestoDAO.crearReparacionRepuestoAuxiliar(listaRepuestosEliminar);

        for (ReparacionRepuesto reparacionRep : listaRepuestosNueva) {
            boolean existe = false;
            for (ReparacionRepuesto reparacionRepuesto : listaRepuestosActualizar) {
                if (reparacionRepuesto.getId_repuesto() == reparacionRep.getId_repuesto()) {
                    // Restar las cantidades
                    int nuevaCantidad = reparacionRepuesto.getCantidad_repuestos() - reparacionRep.getCantidad_repuestos();
                    existe = true;

                    try {
                        if (nuevaCantidad > 0) {
                            // Actualizar la cantidad si es mayor a 0
                            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_ELIMINAR_REPARACION_REPUESTO_POR_REPUESTO);
                            preparedStatement.setInt(1, reparacionRepuesto.getId_repuesto());
                            preparedStatement.setInt(2, nuevaCantidad);
                            preparedStatement.setInt(3, id_reparacion);
                            preparedStatement.executeUpdate();
                        } else {
                            // Eliminar la relación si la cantidad es 0 o menor
                            PreparedStatement deleteStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_REPARACION_REPUESTO);
                            deleteStatement.setInt(1, id_reparacion);
                            deleteStatement.setInt(2, reparacionRepuesto.getId_repuesto());
                            deleteStatement.executeUpdate();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }

            if (!existe) {
                // No se hace nada si el repuesto no existe en la lista actual
                // Si se requiere lógica adicional, puede añadirse aquí
            }
        }

    }
    
    /*
    @Override
    public void actualizarEliminarReparacionRepuestoPorRepuesto(int id_reparacion, List<Repuesto> listaRepuestosEliminar) {
        ReparacionRepuestoDAOImpl reparacionRepuestoDAO = new ReparacionRepuestoDAOImpl(connection);
        
        List<ReparacionRepuesto> listaRepuestosActualizar = reparacionRepuestoDAO.obtenerReparacionRepuestoPorReparacion(id_reparacion);
        List<ReparacionRepuesto> listaRepuestosNueva = reparacionRepuestoDAO.crearReparacionRepuestoAuxiliar(listaRepuestosEliminar);
        
        for(ReparacionRepuesto reparacionRepuesto : listaRepuestosActualizar){   
            for(ReparacionRepuesto reparacionRep : listaRepuestosNueva){
                if(reparacionRepuesto.getId_repuesto() == reparacionRep.getId_repuesto()){
                    reparacionRepuesto.setCantidad_repuestos(reparacionRepuesto.getCantidad_repuestos() - reparacionRep.getCantidad_repuestos());
                
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_ELIMINAR_REPARACION_REPUESTO_POR_REPUESTO);
                        preparedStatement.setInt(1, reparacionRepuesto.getCantidad_repuestos());
                        preparedStatement.setInt(2, id_reparacion);
                        preparedStatement.setInt(3, reparacionRepuesto.getId_repuesto());
                        preparedStatement.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    */
    

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

    private int obtenerCantidadRepuestos(List<Repuesto> listaRepuestos, int id_repuesto) {
        int cantidad = 0;
        for(Repuesto repuesto : listaRepuestos){
            if(repuesto.getId_repuesto() == id_repuesto){
                cantidad = cantidad + 1;
            }
        }
        
        return cantidad;
    }
    
    private List<ReparacionRepuesto> crearReparacionRepuestoAuxiliar(List<Repuesto> listaRepuestos) {
        List<ReparacionRepuesto> listaReparacionRepuesto = new ArrayList<>();
        Map<Integer, Integer> contadorRepuestos = new HashMap<>();

        // Cuenta la cantidad de cada repuesto
        for (Repuesto repuesto : listaRepuestos) {
            contadorRepuestos.put(repuesto.getId_repuesto(), 
                    contadorRepuestos.getOrDefault(repuesto.getId_repuesto(), 0) + 1);
        }

        // Crea objetos ReparacionRepuesto con las cantidades correctas
        for (Map.Entry<Integer, Integer> entry : contadorRepuestos.entrySet()) {
            int idRepuesto = entry.getKey();
            int cantidad = entry.getValue();
            ReparacionRepuesto reparacionRep = new ReparacionRepuesto(1, idRepuesto, cantidad);
            listaReparacionRepuesto.add(reparacionRep);
        }

        return listaReparacionRepuesto;
    }
    
    @Override
    public void actualizarReparacionRepuesto(int id_reparacion, int id_repuesto, int nuevaCantidad) {
        String sql = "UPDATE TiendaLocal.Reparacion_Repuesto " +
                     "SET cantidad_repuestos = ? " +
                     "WHERE id_reparacion = ? AND id_repuesto = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, nuevaCantidad);
            stmt.setInt(2, id_reparacion);
            stmt.setInt(3, id_repuesto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            try {
                // Manejar excepciones adecuadamente
                throw new SQLException("Error al actualizar la cantidad de repuestos", e);
            } catch (SQLException ex) {
                Logger.getLogger(ReparacionRepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
