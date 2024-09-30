package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BackupDataBase {
    public static void exportBackup(String filePath) {
        String url = "jdbc:h2:~/test"; // Cambia la URL según tu configuración
        String user = "sa";
        String password = "";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            // Ejecutar el comando SCRIPT TO para exportar el esquema
            String backupQuery = "SCRIPT TO '" + filePath + "'";
            stmt.execute(backupQuery);
            System.out.println("Backup completado en: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String backupFilePath = "C:\\Users\\BreakingNS\\Documents\\BASES DE DATOS H2";  // Define la ruta donde guardar el backup
        exportBackup(backupFilePath);
    }
}
