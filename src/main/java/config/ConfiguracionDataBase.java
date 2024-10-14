package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfiguracionDataBase {
   private Connection connection = null;
   private final String SENTENCIA_CREAR_BD_TIENDALOCAL = "CREATE SCHEMA IF NOT EXISTS TiendaLocal;";
   private final String SENTENCIA_CREAR_TABLA_MARCA = "CREATE TABLE IF NOT EXISTS TiendaLocal.marca(id_marca INT PRIMARY KEY AUTO_INCREMENT,nombre_marca VARCHAR(255) NOT NULL UNIQUE)";
   private final String SENTENCIA_CREAR_TABLA_NOMBRE_REPUESTO = "CREATE TABLE IF NOT EXISTS TiendaLocal.nombrerepuesto(id_nombrerepuesto INT PRIMARY KEY AUTO_INCREMENT,nombre_repuesto VARCHAR(255) NOT NULL UNIQUE)";
   private final String SENTENCIA_CREAR_TABLA_MODELO = "CREATE TABLE IF NOT EXISTS TiendaLocal.modelo(id_modelo INT PRIMARY KEY AUTO_INCREMENT,nombre_modelo VARCHAR(255) NOT NULL UNIQUE)";
   private final String SENTENCIA_CREAR_TABLA_UBICACION = "CREATE TABLE IF NOT EXISTS TiendaLocal.ubicacion(id_ubicacion INT PRIMARY KEY AUTO_INCREMENT,nombre_ubicacion VARCHAR(255) NOT NULL UNIQUE)";
   private final String SENTENCIA_CREAR_TABLA_CATEGORIA = "CREATE TABLE IF NOT EXISTS TiendaLocal.categoria(id_categoria INT PRIMARY KEY AUTO_INCREMENT,nombre_categoria VARCHAR(255) NOT NULL UNIQUE)";
   private final String SENTENCIA_CREAR_TABLA_ESTADO = "CREATE TABLE IF NOT EXISTS TiendaLocal.estado(id_estado INT PRIMARY KEY AUTO_INCREMENT,nombre_estado VARCHAR(255) NOT NULL UNIQUE)";
   private final String SENTENCIA_CREAR_TABLA_PAGADO = "CREATE TABLE IF NOT EXISTS TiendaLocal.pagado(id_pagado INT PRIMARY KEY AUTO_INCREMENT,nombre_pago VARCHAR(255) NOT NULL UNIQUE)";
   private final String SENTENCIA_CREAR_TABLA_CLIENTE = "CREATE TABLE IF NOT EXISTS TiendaLocal.cliente(id_cliente INT PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(255) NOT NULL,apellido VARCHAR(255) NOT NULL,telefono VARCHAR(255) NOT NULL,domicilio VARCHAR(255),UNIQUE (nombre, apellido, telefono))";
   private final String SENTENCIA_CREAR_TABLA_TECNICO = "CREATE TABLE IF NOT EXISTS TiendaLocal.tecnico(id_tecnico INT PRIMARY KEY AUTO_INCREMENT,nombre_tecnico VARCHAR(255) NOT NULL,apellido_tecnico VARCHAR(255) NOT NULL,telefono_tecnico VARCHAR(255) NOT NULL,domicilio_tecnico VARCHAR(255))";
   private final String SENTENCIA_CREAR_TABLA_FACTURA = "CREATE TABLE IF NOT EXISTS TiendaLocal.factura(id_factura INT PRIMARY KEY AUTO_INCREMENT,estado VARCHAR(255) NOT NULL,montoTotal DECIMAL(10, 2) NOT NULL)";
   private final String SENTENCIA_CREAR_TABLA_PAGO = "CREATE TABLE IF NOT EXISTS TiendaLocal.pago(id_pago INT PRIMARY KEY AUTO_INCREMENT,id_factura INT,FOREIGN KEY (id_factura) REFERENCES TiendaLocal.factura(id_factura),montoAbonado DECIMAL(10, 2) NOT NULL,fechaPago TIMESTAMP NOT NULL,detalle VARCHAR(255))";
   private final String SENTENCIA_CREAR_TABLA_VENTA = "CREATE TABLE IF NOT EXISTS TiendaLocal.venta(id_venta INT PRIMARY KEY AUTO_INCREMENT,cantidad INTEGER NOT NULL,fecha_venta TIMESTAMP  NOT NULL,precioFinal DECIMAL(10, 2) NOT NULL,id_cliente INT,FOREIGN KEY (id_cliente) REFERENCES TiendaLocal.cliente(id_cliente))";
   private final String SENTENCIA_CREAR_TABLA_REPUESTO = "CREATE TABLE IF NOT EXISTS TiendaLocal.repuesto(id_repuesto INT PRIMARY KEY AUTO_INCREMENT,stock INT NOT NULL,codigo VARCHAR(255),id_nombrerepuesto INT,FOREIGN KEY (id_nombrerepuesto) REFERENCES TiendaLocal.nombrerepuesto(id_nombrerepuesto),id_marca INT,FOREIGN KEY (id_marca) REFERENCES TiendaLocal.marca(id_marca),id_modelo INT,FOREIGN KEY (id_modelo) REFERENCES TiendaLocal.modelo(id_modelo),id_categoria INT,FOREIGN KEY (id_categoria) REFERENCES TiendaLocal.categoria(id_categoria),id_ubicacion INT,FOREIGN KEY (id_ubicacion) REFERENCES TiendaLocal.ubicacion(id_ubicacion))";
   private final String SENTENCIA_CREAR_TABLA_PRECIO = "CREATE TABLE IF NOT EXISTS TiendaLocal.precio(id_precio INT PRIMARY KEY AUTO_INCREMENT,fechaPrecio TIMESTAMP  NOT NULL,valor DECIMAL(10, 2) NOT NULL,id_repuesto INT,FOREIGN KEY (id_repuesto) REFERENCES TiendaLocal.repuesto(id_repuesto))";
   private final String SENTENCIA_CREAR_TABLA_REPARACION = "CREATE TABLE IF NOT EXISTS TiendaLocal.reparacion(id_reparacion INT PRIMARY KEY AUTO_INCREMENT,costo DECIMAL(10, 2) NOT NULL,detalles VARCHAR(255),fecha_ingreso TIMESTAMP NOT NULL,fecha_devolucion TIMESTAMP,id_factura INT,FOREIGN KEY (id_factura) REFERENCES TiendaLocal.factura(id_factura),id_categoria INT,FOREIGN KEY (id_categoria) REFERENCES TiendaLocal.categoria(id_categoria),id_cliente  INT,FOREIGN KEY (id_cliente) REFERENCES TiendaLocal.cliente(id_cliente),id_estado  INT,FOREIGN KEY (id_estado) REFERENCES TiendaLocal.estado(id_estado),id_tecnico INT,FOREIGN KEY (id_tecnico) REFERENCES TiendaLocal.tecnico(id_tecnico))";
   private final String SENTENCIA_CREAR_TABLA_VENTA_REPUESTO = "CREATE TABLE IF NOT EXISTS TiendaLocal.Venta_Repuesto(id_venta INT,id_repuesto INT,cantidad_repuestos INT,PRIMARY KEY (id_venta, id_repuesto),FOREIGN KEY (id_venta) REFERENCES TiendaLocal.venta(id_venta),FOREIGN KEY (id_repuesto) REFERENCES TiendaLocal.repuesto (id_repuesto))";
   private final String SENTENCIA_CREAR_TABLA_REPARACION_REPUESTO = "CREATE TABLE IF NOT EXISTS TiendaLocal.Reparacion_Repuesto(id_reparacion INT,id_repuesto INT,cantidad_repuestos INT,PRIMARY KEY (id_reparacion , id_repuesto),FOREIGN KEY (id_reparacion) REFERENCES TiendaLocal.reparacion(id_reparacion),FOREIGN KEY (id_repuesto) REFERENCES TiendaLocal.repuesto(id_repuesto))";
   private final String SENTENCIA_ELIMINAR_TABLA_MARCA = "DROP TABLE IF EXISTS TiendaLocal.marca";
   private final String SENTENCIA_ELIMINAR_TABLA_NOMBRE_REPUESTO = "DROP TABLE IF EXISTS TiendaLocal.nombrerepuesto";
   private final String SENTENCIA_ELIMINAR_TABLA_MODELO = "DROP TABLE IF EXISTS TiendaLocal.modelo";
   private final String SENTENCIA_ELIMINAR_TABLA_UBICACION = "DROP TABLE IF EXISTS TiendaLocal.ubicacion";
   private final String SENTENCIA_ELIMINAR_TABLA_CATEGORIA = "DROP TABLE IF EXISTS TiendaLocal.categoria";
   private final String SENTENCIA_ELIMINAR_TABLA_ESTADO = "DROP TABLE IF EXISTS TiendaLocal.estado";
   private final String SENTENCIA_ELIMINAR_TABLA_PAGADO = "DROP TABLE IF EXISTS TiendaLocal.pagado";
   private final String SENTENCIA_ELIMINAR_TABLA_CLIENTE = "DROP TABLE IF EXISTS TiendaLocal.cliente";
   private final String SENTENCIA_ELIMINAR_TABLA_TECNICO = "DROP TABLE IF EXISTS TiendaLocal.tecnico";
   private final String SENTENCIA_ELIMINAR_TABLA_FACTURA = "DROP TABLE IF EXISTS TiendaLocal.factura";
   private final String SENTENCIA_ELIMINAR_TABLA_PAGO = "DROP TABLE IF EXISTS TiendaLocal.pago";
   private final String SENTENCIA_ELIMINAR_TABLA_VENTA = "DROP TABLE IF EXISTS TiendaLocal.venta";
   private final String SENTENCIA_ELIMINAR_TABLA_PRECIO = "DROP TABLE IF EXISTS TiendaLocal.precio";
   private final String SENTENCIA_ELIMINAR_TABLA_REPUESTO = "DROP TABLE IF EXISTS TiendaLocal.repuesto";
   private final String SENTENCIA_ELIMINAR_TABLA_REPARACION = "DROP TABLE IF EXISTS TiendaLocal.reparacion";
   private final String SENTENCIA_ELIMINAR_TABLA_VENTA_REPUESTO = "DROP TABLE IF EXISTS TiendaLocal.Venta_Repuesto";
   private final String SENTENCIA_ELIMINAR_TABLA_REPARACION_REPUESTO = "DROP TABLE IF EXISTS TiendaLocal.Reparacion_Repuesto";

   public ConfiguracionDataBase(Connection connection) {
      this.connection = connection;
   }

   public void crearBDTiendaLocal() throws SQLException {
      PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE SCHEMA IF NOT EXISTS TiendaLocal;");

      try {
         preparedStatement.executeUpdate();
      } catch (Throwable var5) {
         if (preparedStatement != null) {
            try {
               preparedStatement.close();
            } catch (Throwable var4) {
               var5.addSuppressed(var4);
            }
         }

         throw var5;
      }

      if (preparedStatement != null) {
         preparedStatement.close();
      }

   }

   public void crearTablaMarca() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.marca(id_marca INT PRIMARY KEY AUTO_INCREMENT,nombre_marca VARCHAR(255) NOT NULL UNIQUE)");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaNombreRepuesto() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.nombrerepuesto(id_nombrerepuesto INT PRIMARY KEY AUTO_INCREMENT,nombre_repuesto VARCHAR(255) NOT NULL UNIQUE)");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaModelo() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.modelo(id_modelo INT PRIMARY KEY AUTO_INCREMENT,nombre_modelo VARCHAR(255) NOT NULL UNIQUE)");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaUbicacion() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.ubicacion(id_ubicacion INT PRIMARY KEY AUTO_INCREMENT,nombre_ubicacion VARCHAR(255) NOT NULL UNIQUE)");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaCategoria() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.categoria(id_categoria INT PRIMARY KEY AUTO_INCREMENT,nombre_categoria VARCHAR(255) NOT NULL UNIQUE)");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaEstado() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.estado(id_estado INT PRIMARY KEY AUTO_INCREMENT,nombre_estado VARCHAR(255) NOT NULL UNIQUE)");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaPagado() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.pagado(id_pagado INT PRIMARY KEY AUTO_INCREMENT,nombre_pago VARCHAR(255) NOT NULL UNIQUE)");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaCliente() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.cliente(id_cliente INT PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(255) NOT NULL,apellido VARCHAR(255) NOT NULL,telefono VARCHAR(255) NOT NULL,domicilio VARCHAR(255),UNIQUE (nombre, apellido, telefono))");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaTecnico() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.tecnico(id_tecnico INT PRIMARY KEY AUTO_INCREMENT,nombre_tecnico VARCHAR(255) NOT NULL,apellido_tecnico VARCHAR(255) NOT NULL,telefono_tecnico VARCHAR(255) NOT NULL,domicilio_tecnico VARCHAR(255))");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaFactura() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.factura(id_factura INT PRIMARY KEY AUTO_INCREMENT,estado VARCHAR(255) NOT NULL,montoTotal DECIMAL(10, 2) NOT NULL)");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaPago() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.pago(id_pago INT PRIMARY KEY AUTO_INCREMENT,id_factura INT,FOREIGN KEY (id_factura) REFERENCES TiendaLocal.factura(id_factura),montoAbonado DECIMAL(10, 2) NOT NULL,fechaPago TIMESTAMP NOT NULL,detalle VARCHAR(255))");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaPrecio() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.precio(id_precio INT PRIMARY KEY AUTO_INCREMENT,fechaPrecio TIMESTAMP  NOT NULL,valor DECIMAL(10, 2) NOT NULL,id_repuesto INT,FOREIGN KEY (id_repuesto) REFERENCES TiendaLocal.repuesto(id_repuesto))");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaVenta() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.venta(id_venta INT PRIMARY KEY AUTO_INCREMENT,cantidad INTEGER NOT NULL,fecha_venta TIMESTAMP  NOT NULL,precioFinal DECIMAL(10, 2) NOT NULL,id_cliente INT,FOREIGN KEY (id_cliente) REFERENCES TiendaLocal.cliente(id_cliente))");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaRepuesto() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.repuesto(id_repuesto INT PRIMARY KEY AUTO_INCREMENT,stock INT NOT NULL,codigo VARCHAR(255),id_nombrerepuesto INT,FOREIGN KEY (id_nombrerepuesto) REFERENCES TiendaLocal.nombrerepuesto(id_nombrerepuesto),id_marca INT,FOREIGN KEY (id_marca) REFERENCES TiendaLocal.marca(id_marca),id_modelo INT,FOREIGN KEY (id_modelo) REFERENCES TiendaLocal.modelo(id_modelo),id_categoria INT,FOREIGN KEY (id_categoria) REFERENCES TiendaLocal.categoria(id_categoria),id_ubicacion INT,FOREIGN KEY (id_ubicacion) REFERENCES TiendaLocal.ubicacion(id_ubicacion))");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaReparacion() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.reparacion(id_reparacion INT PRIMARY KEY AUTO_INCREMENT,costo DECIMAL(10, 2) NOT NULL,detalles VARCHAR(255),fecha_ingreso TIMESTAMP NOT NULL,fecha_devolucion TIMESTAMP,id_factura INT,FOREIGN KEY (id_factura) REFERENCES TiendaLocal.factura(id_factura),id_categoria INT,FOREIGN KEY (id_categoria) REFERENCES TiendaLocal.categoria(id_categoria),id_cliente  INT,FOREIGN KEY (id_cliente) REFERENCES TiendaLocal.cliente(id_cliente),id_estado  INT,FOREIGN KEY (id_estado) REFERENCES TiendaLocal.estado(id_estado),id_tecnico INT,FOREIGN KEY (id_tecnico) REFERENCES TiendaLocal.tecnico(id_tecnico))");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaVentaRepuesto() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.Venta_Repuesto(id_venta INT,id_repuesto INT,cantidad_repuestos INT,PRIMARY KEY (id_venta, id_repuesto),FOREIGN KEY (id_venta) REFERENCES TiendaLocal.venta(id_venta),FOREIGN KEY (id_repuesto) REFERENCES TiendaLocal.repuesto (id_repuesto))");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void crearTablaReparacionRepuesto() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS TiendaLocal.Reparacion_Repuesto(id_reparacion INT,id_repuesto INT,cantidad_repuestos INT,PRIMARY KEY (id_reparacion , id_repuesto),FOREIGN KEY (id_reparacion) REFERENCES TiendaLocal.reparacion(id_reparacion),FOREIGN KEY (id_repuesto) REFERENCES TiendaLocal.repuesto(id_repuesto))");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaMarca() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.marca");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaNombreRepuesto() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.nombrerepuesto");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaModelo() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.modelo");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaUbicacion() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.ubicacion");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaCategoria() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.categoria");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaEstado() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.estado");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaPagado() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.pagado");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaCliente() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.cliente");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaTecnico() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.tecnico");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaFactura() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.factura");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaPago() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.pago");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaPrecio() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.precio");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaVenta() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.venta");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaRepuesto() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.repuesto");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaReparacion() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.reparacion");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaVentaRepuesto() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.Venta_Repuesto");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }

   public void eliminarTablaReparacionRepuesto() {
      try {
         PreparedStatement preparedStatement = this.connection.prepareStatement("DROP TABLE IF EXISTS TiendaLocal.Reparacion_Repuesto");
         preparedStatement.executeUpdate();
      } catch (SQLException var2) {
         Logger.getLogger(ConfiguracionDataBase.class.getName()).log(Level.SEVERE, (String)null, var2);
      }

   }
}
