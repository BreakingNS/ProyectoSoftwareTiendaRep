package config;

import java.awt.EventQueue;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class BackupDataBase {
    private static final String url = "jdbc:h2:~/test"; // Cambia la URL según tu configuración
    private static final String user = "sa";
    private static final String password = "";
    private static final String BACKUP_DIR = "C:\\Users\\BreakingNS\\Documents\\BASES DE DATOS H2"; // Cambia la ruta según sea necesario
    private static final int MAX_BACKUPS = 50; // Máximo de copias de seguridad

    public static void showBackupMessage(String message) {
    EventQueue.invokeLater(() -> {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog("Backup Completado");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);

        // Cerrar el diálogo después de 5 segundos
        new Timer(5, e -> {
            dialog.dispose(); // Cierra el diálogo
        }).start();
    });
}

    
    public static void exportBackup(String filePath) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            String backupQuery = "SCRIPT TO '" + filePath + "'";
            stmt.execute(backupQuery);
            showBackupMessage("Backup completado en: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cleanOldBackups() {
        File backupDir = new File(BACKUP_DIR);
        File[] backups = backupDir.listFiles((dir, name) -> name.endsWith(".sql"));

        if (backups != null && backups.length > MAX_BACKUPS) {
            // Ordenar por fecha de modificación y eliminar los más antiguos
            Arrays.sort(backups, (a, b) -> Long.compare(a.lastModified(), b.lastModified()));
            for (int i = 0; i < backups.length - MAX_BACKUPS; i++) {
                if (backups[i].delete()) {
                    System.out.println("Backup eliminado: " + backups[i].getName());
                } else {
                    System.out.println("No se pudo eliminar: " + backups[i].getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        // Programar backup automático cada 1 hora
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            String backupFilePath = BACKUP_DIR + "\\backup_" + System.currentTimeMillis() + ".sql";
            exportBackup(backupFilePath);
            cleanOldBackups(); // Limpiar copias antiguas después de cada backup
            System.out.println("Copia de seguridad realizada con exito! (Una hora de uso del programa)");
        }, 0, 60, TimeUnit.SECONDS);

        // Shutdown hook para hacer backup al cerrar la aplicación
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            String backupFilePath = BACKUP_DIR + "\\backup_shutdown_" + System.currentTimeMillis() + ".sql";
            exportBackup(backupFilePath);
            cleanOldBackups(); // Limpiar copias antiguas también al cerrar
            System.out.println("Copia de seguridad realizada con exito! (Cierre del programa)");
        }));
    }
}
