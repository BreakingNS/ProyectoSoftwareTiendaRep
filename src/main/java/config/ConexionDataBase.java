package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDataBase {
    
    public String username = "sa";
    public String password = "";
    public String url = "jdbc:h2:~/test";
    public String driveDB = "org.h2.Driver";
    
    public Connection getConexionDBH2() throws ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName(driveDB);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexion exitosa!");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDataBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se logro la conexion");
        }
        return connection;
    }
    
    public void cerrarConexion(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion cerrada con exito!");
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDataBase.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error al cerrar la conexion");
            }
        }
    }
}

