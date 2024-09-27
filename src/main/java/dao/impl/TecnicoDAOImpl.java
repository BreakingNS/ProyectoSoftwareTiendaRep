package dao.impl;

import dao.interfaces.TecnicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tecnico;
import model.Reparacion;

public class TecnicoDAOImpl implements TecnicoDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_TECNICO = "DELETE FROM TiendaLocal.tecnico WHERE id_tecnico = ?";
    private final String SENTENCIA_OBTENER_TECNICOS = "SELECT * FROM TiendaLocal.tecnico ORDER BY id_tecnico ASC";
    private final String SENTENCIA_OBTENER_TECNICO = "SELECT * FROM TiendaLocal.tecnico WHERE id_tecnico = ?";
    private final String SENTENCIA_BUSQUEDA_DE_TECNICO = 
            "SELECT * " + 
            "FROM TiendaLocal.tecnico " +
            "WHERE UPPER(nombre_tecnico) LIKE ? " +
            "AND UPPER(apellido_tecnico) LIKE ? " +
            "AND UPPER(telefono_tecnico) LIKE ? " +
            "AND UPPER(domicilio_tecnico) LIKE ? ";
    private final String SENTENCIA_CREAR_TECNICO = "INSERT INTO TiendaLocal.tecnico (nombre_tecnico, apellido_tecnico, telefono_tecnico, domicilio_tecnico) VALUES ( ? , ? , ?, ? )";
    private final String SENTENCIA_ACTUALIZAR_TECNICO = "UPDATE TiendaLocal.tecnico SET nombre_tecnico = ?, apellido_tecnico = ?, telefono_tecnico = ?, domicilio_tecnico = ? WHERE id_tecnico = ?";

    public TecnicoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearTecnico(Tecnico tecnico) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_TECNICO);
            preparedStatement.setString(1, tecnico.getNombre_tecnico());
            preparedStatement.setString(2, tecnico.getApellido_tecnico());
            preparedStatement.setString(3, tecnico.getTelefono_tecnico());
            preparedStatement.setString(4, tecnico.getDomicilio_tecnico());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Tecnico> obtenerTecnicos() {
        List<Tecnico> listaTecnicos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_TECNICOS);
            ResultSet tecnico_Resultado = preparedStatement.executeQuery();
            
            while(tecnico_Resultado.next()){
                String nombre_tecnico = tecnico_Resultado.getString("nombre_tecnico");
                String apellido_tecnico = tecnico_Resultado.getString("apellido_tecnico");
                String telefono_tecnico = tecnico_Resultado.getString("telefono_tecnico");
                String domicilio_tecnico = tecnico_Resultado.getString("domicilio_tecnico");
                int idTecnico = tecnico_Resultado.getInt("id_tecnico");
                
                List<Reparacion> listaReparaciones = new ArrayList<>();
                
                Tecnico tecnico = new Tecnico(idTecnico, nombre_tecnico, apellido_tecnico, telefono_tecnico, domicilio_tecnico, listaReparaciones);
                
                listaTecnicos.add(tecnico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTecnicos;
    }

    @Override
    public List<Tecnico> buscarTecnico(Tecnico tecnico) {
        List<Tecnico> listaTecnicos = new ArrayList<>();
        ResultSet tecnico_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_BUSQUEDA_DE_TECNICO);
        
            // Usa '%' para envolver los parámetros de búsqueda
            preparedStatement.setString(1, "%" + tecnico.getNombre_tecnico().toUpperCase() + "%");
            preparedStatement.setString(2, "%" + tecnico.getApellido_tecnico().toUpperCase() + "%");
            preparedStatement.setString(3, "%" + tecnico.getTelefono_tecnico().toUpperCase() + "%");
            preparedStatement.setString(4, "%" + tecnico.getDomicilio_tecnico().toUpperCase() + "%");

            tecnico_Resultado = preparedStatement.executeQuery();
            
            while(tecnico_Resultado.next()){
                int idTecnico = tecnico_Resultado.getInt("id_tecnico");
                String nombre_tecnico = tecnico_Resultado.getString("nombre_tecnico");
                String apellido_tecnico = tecnico_Resultado.getString("apellido_tecnico");
                String telefono_tecnico = tecnico_Resultado.getString("telefono_tecnico");
                String domicilio_tecnico = tecnico_Resultado.getString("domicilio_tecnico");
                
                List<Reparacion> listaReparaciones = new ArrayList<>();
                
                tecnico = new Tecnico(idTecnico, nombre_tecnico, apellido_tecnico, telefono_tecnico, domicilio_tecnico, listaReparaciones);
            
                listaTecnicos.add(tecnico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaTecnicos;
    }
    
    @Override
    public void actualizarTecnico(Tecnico tecnico) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_TECNICO);
            preparedStatement.setString(1, tecnico.getNombre_tecnico());
            preparedStatement.setString(2, tecnico.getApellido_tecnico());
            preparedStatement.setString(3, tecnico.getTelefono_tecnico());
            preparedStatement.setString(4, tecnico.getDomicilio_tecnico());
            preparedStatement.setInt(5, tecnico.getId_tecnico());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarTecnico(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_TECNICO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Tecnico obtenerTecnico(int id) {
        Tecnico tecnico = null;
        ResultSet tecnico_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_TECNICO);
            preparedStatement.setInt(1, id);
            tecnico_Resultado = preparedStatement.executeQuery();
            
            if(tecnico_Resultado.next()){
                int idTecnico = tecnico_Resultado.getInt("id_tecnico");
                String nombre_tecnico = tecnico_Resultado.getString("nombre_tecnico");
                String apellido_tecnico = tecnico_Resultado.getString("apellido_tecnico");
                String telefono_tecnico = tecnico_Resultado.getString("telefono_tecnico");
                String domicilio_tecnico = tecnico_Resultado.getString("domicilio_tecnico");
                
                List<Reparacion> listaReparaciones = new ArrayList<>();
                
                tecnico = new Tecnico(idTecnico, nombre_tecnico, apellido_tecnico, telefono_tecnico, domicilio_tecnico, listaReparaciones);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tecnico;
    }
    
}
