package config;

import java.awt.EventQueue;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BackupDataBase {
   private static final String url = "jdbc:h2:~/test";
   private static final String user = "sa";
   private static final String password = "";
   private static final String BACKUP_DIR = "C:\\Users\\BreakingNS\\Documents\\BASES DE DATOS H2";
   private static final int MAX_BACKUPS = 50;

   public static void showBackupMessage(String message, JPanel jPanel1) {
      EventQueue.invokeLater(() -> {
         JOptionPane optionPane = new JOptionPane(message, 1, -1);
         JDialog dialog = optionPane.createDialog("Backup Completado");
         dialog.setDefaultCloseOperation(2);
         Timer timer = new Timer(10000, (e) -> {
            dialog.dispose();
         });
         timer.setRepeats(false);
         timer.start();
         dialog.setLocation(jPanel1.getWidth() - dialog.getWidth(), 0);
         dialog.setVisible(true);
      });
   }

   public static void exportBackup(String filePath, JPanel jPanel1) {
      try {
         Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

         try {
            Statement stmt = conn.createStatement();

            try {
               String backupQuery = "SCRIPT TO '" + filePath + "'";
               stmt.execute(backupQuery);
               showBackupMessage("Backup de Base de Datos completado!", jPanel1);
            } catch (Throwable var8) {
               if (stmt != null) {
                  try {
                     stmt.close();
                  } catch (Throwable var7) {
                     var8.addSuppressed(var7);
                  }
               }

               throw var8;
            }

            if (stmt != null) {
               stmt.close();
            }
         } catch (Throwable var9) {
            if (conn != null) {
               try {
                  conn.close();
               } catch (Throwable var6) {
                  var9.addSuppressed(var6);
               }
            }

            throw var9;
         }

         if (conn != null) {
            conn.close();
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }

   }

   public static void cleanOldBackups() {
      File backupDir = new File("C:\\Users\\BreakingNS\\Documents\\BASES DE DATOS H2");
      File[] backups = backupDir.listFiles((dir, name) -> {
         return name.endsWith(".sql");
      });
      if (backups != null && backups.length > 50) {
         Arrays.sort(backups, (a, b) -> {
            return Long.compare(a.lastModified(), b.lastModified());
         });

         for(int i = 0; i < backups.length - 50; ++i) {
            if (backups[i].delete()) {
               System.out.println("Backup eliminado: " + backups[i].getName());
            } else {
               System.out.println("No se pudo eliminar: " + backups[i].getName());
            }
         }
      }

   }
}