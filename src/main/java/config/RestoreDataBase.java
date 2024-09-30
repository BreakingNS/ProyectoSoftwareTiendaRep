package config;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RestoreDataBase {
    public static void clearDatabase() {
        String url = "jdbc:h2:~/test"; // Cambia la URL según tu configuración
        String user = "sa";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            // Borrar todos los objetos en la base de datos
            String dropQuery = "DROP ALL OBJECTS";
            stmt.execute(dropQuery);
            System.out.println("Base de datos borrada exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al borrar la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void importBackup(String filePath) {
        String url = "jdbc:h2:~/test"; // Cambia la URL según tu configuración
        String user = "sa";
        String password = "";

        // Verificar si el archivo existe
        File backupFile = new File(filePath);
        if (!backupFile.exists()) {
            System.err.println("El archivo de respaldo no existe: " + filePath);
            return;
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            // Ejecutar el comando RUNSCRIPT para restaurar desde el archivo SQL
            String restoreQuery = "RUNSCRIPT FROM '" + backupFile.getAbsolutePath() + "'";
            stmt.execute(restoreQuery);
            System.out.println("Restauración completada desde: " + filePath);
        } catch (Exception e) {
            System.err.println("Error al restaurar la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String restoreFilePath = "C:/ruta/del/backup.sql";  // Define la ruta del archivo de backup a restaurar
        importBackup(restoreFilePath);
    }
}

