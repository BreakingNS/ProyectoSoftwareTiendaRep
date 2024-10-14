package config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RestoreDataBase {
   public static void clearDatabase() {
      String url = "jdbc:h2:~/test";
      String user = "sa";
      String password = "";

      try {
         Connection conn = DriverManager.getConnection(url, user, password);

         try {
            Statement stmt = conn.createStatement();

            try {
               String dropQuery = "DROP ALL OBJECTS";
               stmt.execute(dropQuery);
               System.out.println("Base de datos borrada exitosamente.");
            } catch (Throwable var9) {
               if (stmt != null) {
                  try {
                     stmt.close();
                  } catch (Throwable var8) {
                     var9.addSuppressed(var8);
                  }
               }

               throw var9;
            }

            if (stmt != null) {
               stmt.close();
            }
         } catch (Throwable var10) {
            if (conn != null) {
               try {
                  conn.close();
               } catch (Throwable var7) {
                  var10.addSuppressed(var7);
               }
            }

            throw var10;
         }

         if (conn != null) {
            conn.close();
         }
      } catch (Exception var11) {
         System.err.println("Error al borrar la base de datos: " + var11.getMessage());
         var11.printStackTrace();
      }

   }

   public static void importBackup(String filePath) {
      String url = "jdbc:h2:~/test";
      String user = "sa";
      String password = "";
      File backupFile = new File(filePath);
      if (!backupFile.exists()) {
         System.err.println("El archivo de respaldo no existe: " + filePath);
      } else {
         try {
            Connection conn = DriverManager.getConnection(url, user, password);

            try {
               Statement stmt = conn.createStatement();

               try {
                  String restoreQuery = "RUNSCRIPT FROM '" + backupFile.getAbsolutePath() + "'";
                  stmt.execute(restoreQuery);
                  System.out.println("Restauración completada desde: " + filePath);
               } catch (Throwable var11) {
                  if (stmt != null) {
                     try {
                        stmt.close();
                     } catch (Throwable var10) {
                        var11.addSuppressed(var10);
                     }
                  }

                  throw var11;
               }

               if (stmt != null) {
                  stmt.close();
               }
            } catch (Throwable var12) {
               if (conn != null) {
                  try {
                     conn.close();
                  } catch (Throwable var9) {
                     var12.addSuppressed(var9);
                  }
               }

               throw var12;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Exception var13) {
            System.err.println("Error al restaurar la base de datos: " + var13.getMessage());
            var13.printStackTrace();
         }

      }
   }

   public static void main(String[] args) {
      String restoreFilePath = "C:/ruta/del/backup.sql";
      importBackup(restoreFilePath);
   }
}

