package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfiguracionDataBase {
    private Connection connection = null;
    
    //------------ SENTENCIAS CREAR TABLAS
    private final String SENTENCIA_CREAR_TABLA_MARCA = 
            "CREATE TABLE IF NOT EXISTS TiendaLocal.marca("
            + "id_marca INT PRIMARY KEY AUTO_INCREMENT,"
            + "nombre_marca VARCHAR(255) NOT NULL UNIQUE"
            + ")";
    
    private final String SENTENCIA_CREAR_TABLA_NOMBRE_REPUESTO = 
            "CREATE TABLE IF NOT EXISTS TiendaLocal.nombrerepuesto("
            + "id_nombrerepuesto INT PRIMARY KEY AUTO_INCREMENT,"
            + "nombre_repuesto VARCHAR(255) NOT NULL UNIQUE"
            + ")";
    
    private final String SENTENCIA_CREAR_TABLA_UBICACION = 
            "CREATE TABLE IF NOT EXISTS TiendaLocal.ubicacion("
            + "id_ubicacion INT PRIMARY KEY AUTO_INCREMENT,"
            + "nombre_ubicacion VARCHAR(255) NOT NULL UNIQUE"
            + ")";
    
    private final String SENTENCIA_CREAR_TABLA_CATEGORIA = 
            "CREATE TABLE IF NOT EXISTS TiendaLocal.categoria("
            + "id_categoria INT PRIMARY KEY AUTO_INCREMENT,"
            + "nombre_categoria VARCHAR(255) NOT NULL UNIQUE"
            + ")";
    
    private final String SENTENCIA_CREAR_TABLA_ESTADO = 
            "CREATE TABLE IF NOT EXISTS TiendaLocal.estado("
            + "id_estado INT PRIMARY KEY AUTO_INCREMENT,"
            + "nombre_estado VARCHAR(255) NOT NULL UNIQUE"
            + ")";
    
    //------------- SENTENCIAS ELIMINAR TABLAS
    private final String SENTENCIA_ELIMINAR_TABLA_MARCA =
            "DROP TABLE TiendaLocal.marca";
    
    private final String SENTENCIA_ELIMINAR_TABLA_NOMBRE_REPUESTO = 
            "DROP TABLE TiendaLocal.nombrerepuesto";
    
    private final String SENTENCIA_ELIMINAR_TABLA_UBICACION = 
            "DROP TABLE TiendaLocal.ubicacion";
    
    private final String SENTENCIA_ELIMINAR_TABLA_CATEGORIA = 
            "DROP TABLE TiendaLocal.categoria";
    
    private final String SENTENCIA_ELIMINAR_TABLA_ESTADO = 
            "DROP TABLE TiendaLocal.estado";
    
    //------------- CONSTRUCTOR

    public ConfiguracionDataBase(Connection connection) {
        this.connection = connection;
    }
    
    //------------- METODOS CREAR TABLAS
    
    public void crearTablaMarca(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_TABLA_MARCA);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearTablaNombreRepuesto(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_TABLA_NOMBRE_REPUESTO);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearTablaUbicacion(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_TABLA_UBICACION);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearTablaCategoria(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_TABLA_CATEGORIA);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearTablaEstado(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_TABLA_ESTADO);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //------------- METODOS ELIMINAR TABLAS
    
    public void eliminarTablaMarca(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_TABLA_MARCA);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTablaNombreRepuesto(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_TABLA_NOMBRE_REPUESTO);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTablaUbicacion(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_TABLA_UBICACION);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTablaCategoria(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_TABLA_CATEGORIA);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTablaEstado(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_TABLA_ESTADO);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
