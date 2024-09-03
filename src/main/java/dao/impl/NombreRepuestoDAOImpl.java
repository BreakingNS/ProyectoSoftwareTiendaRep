package dao.impl;

import dao.interfaces.NombreRepuestoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NombreRepuesto;

public class NombreRepuestoDAOImpl implements NombreRepuestoDAO{

    /*
    Columnas/Campos de la Tabla NombreRepuesto
    
    id_nombrerepuesto
    nombre_respuesto
    */
    
    private Connection connection = null; 
    private final String SENTENCIA_CREAR_NOMBREREP = "INSERT INTO TiendaLocal.nombrerepuesto (nombre_repuesto) VALUES ( ? )";
    private final String SENTENCIA_OBTENER_NOMBRESREP = "SELECT * FROM TiendaLocal.nombrerepuesto";
    private final String SENTENCIA_OBTENER_NOMBREREP = "SELECT * FROM TiendaLocal.nombrerepuesto WHERE id_nombrerepuesto = ?";
    private final String SENTENCIA_ACTUALIZAR_NOMBREREP = "UPDATE TiendaLocal.nombrerepuesto SET nombre_respuesto = ? WHERE id_nombrerepuesto = ?";
    private final String SENTENCIA_ELIMINAR_NOMBREREP = "DELETE FROM TiendaLocal.nombrerepuesto WHERE id_nombrerepuesto = ?";

    public NombreRepuestoDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void crearNombreRepuesto(NombreRepuesto nombreRepuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_NOMBREREP);
            preparedStatement.setString(1, nombreRepuesto.getNombre_repuesto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NombreRepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<NombreRepuesto> obtenerNombreRepuestos() {
        List<NombreRepuesto> listaNombresRespuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_NOMBRESREP);
            ResultSet nombrerepuesto_Resultado = preparedStatement.executeQuery();
            
            while(nombrerepuesto_Resultado.next()){
                String nombre_Repuesto = nombrerepuesto_Resultado.getString("nombre_repuesto");
                int idNombreRepuesto =  nombrerepuesto_Resultado.getInt("id_nombrerepuesto");
                
                NombreRepuesto nombreRepuesto = new NombreRepuesto(idNombreRepuesto, nombre_Repuesto);
                
                listaNombresRespuestos.add(nombreRepuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NombreRepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaNombresRespuestos;
    }

    @Override
    public void actualizarNombreRepuesto(NombreRepuesto nombreRepuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_NOMBREREP);
            preparedStatement.setString(1, nombreRepuesto.getNombre_repuesto());
            preparedStatement.setInt(2, nombreRepuesto.getId_nombrerepuesto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NombreRepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarNombreRepuesto(int id) {
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SENTENCIA_ELIMINAR_NOMBREREP);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NombreRepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public NombreRepuesto obtenerNombreRepuesto(int id) {
        ResultSet nombreRepuesto_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_NOMBRESREP);
            preparedStatement.setInt(1, id);
            nombreRepuesto_Resultado = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(NombreRepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (NombreRepuesto) nombreRepuesto_Resultado;
    }
    
}
