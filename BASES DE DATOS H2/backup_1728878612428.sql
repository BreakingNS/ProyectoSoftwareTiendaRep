-- H2 2.2.220;
;             
CREATE USER IF NOT EXISTS "SA" SALT '44a162da9e536c57' HASH '664c8e28b51c502b308221f91e6769764f29fc7d868344f45468cc03d9ee241c' ADMIN;         
CREATE SCHEMA IF NOT EXISTS "TIENDALOCAL" AUTHORIZATION "SA"; 
CREATE CACHED TABLE "TIENDALOCAL"."CONFIGURACION"(
    "ID_CONFIGURACION" INTEGER,
    "RUTA_BD" CHARACTER VARYING(255),
    "STOCKBAJOMAX" INTEGER,
    "STOCKMEDIOMAX" INTEGER
);      
-- 4 +/- SELECT COUNT(*) FROM TIENDALOCAL.CONFIGURACION;      
INSERT INTO "TIENDALOCAL"."CONFIGURACION" VALUES
(1, 'C:\Users\BreakingNS\Documents\BASE DE DATOS PARA PROBAR', 10, 20),
(1, '', 10, 20),
(1, '', 10, 20),
(1, '', 10, 20);               
CREATE CACHED TABLE "TIENDALOCAL"."MARCA"(
    "ID_MARCA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "NOMBRE_MARCA" CHARACTER VARYING(255) NOT NULL
);           
ALTER TABLE "TIENDALOCAL"."MARCA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_4" PRIMARY KEY("ID_MARCA");        
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.MARCA;              
CREATE CACHED TABLE "TIENDALOCAL"."NOMBREREPUESTO"(
    "ID_NOMBREREPUESTO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "NOMBRE_RESPUESTO" CHARACTER VARYING(255) NOT NULL
);     
ALTER TABLE "TIENDALOCAL"."NOMBREREPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_6" PRIMARY KEY("ID_NOMBREREPUESTO");      
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.NOMBREREPUESTO;     
CREATE CACHED TABLE "TIENDALOCAL"."MODELO"(
    "ID_MODELO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "NOMBRE_MODELO" CHARACTER VARYING(255) NOT NULL
);        
ALTER TABLE "TIENDALOCAL"."MODELO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8" PRIMARY KEY("ID_MODELO");      
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.MODELO;             
CREATE CACHED TABLE "TIENDALOCAL"."UBICACION"(
    "ID_UBICACION" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "NOMBRE_UBICACION" CHARACTER VARYING(255) NOT NULL
);               
ALTER TABLE "TIENDALOCAL"."UBICACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8E" PRIMARY KEY("ID_UBICACION");               
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.UBICACION;          
CREATE CACHED TABLE "TIENDALOCAL"."CATEGORIA"(
    "ID_CATEGORIA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "NOMBRE_CATEGORIA" CHARACTER VARYING(255) NOT NULL
);               
ALTER TABLE "TIENDALOCAL"."CATEGORIA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_3" PRIMARY KEY("ID_CATEGORIA");
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.CATEGORIA;          
CREATE CACHED TABLE "TIENDALOCAL"."ESTADO"(
    "ID_ESTADO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "NOMBRE_ESTADO" CHARACTER VARYING(255) NOT NULL
);        
ALTER TABLE "TIENDALOCAL"."ESTADO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_7" PRIMARY KEY("ID_ESTADO");      
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.ESTADO;             
CREATE CACHED TABLE "TIENDALOCAL"."CLIENTE"(
    "ID_CLIENTE" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "NOMBRE" CHARACTER VARYING(255) NOT NULL,
    "APELLIDO" CHARACTER VARYING(255) NOT NULL,
    "TELEFONO" CHARACTER VARYING(255) NOT NULL,
    "DOMICILIO" CHARACTER VARYING(255) NOT NULL
);         
ALTER TABLE "TIENDALOCAL"."CLIENTE" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_5" PRIMARY KEY("ID_CLIENTE");    
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.CLIENTE;            
CREATE CACHED TABLE "TIENDALOCAL"."TECNICO"(
    "ID_TECNICO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "NOMBRE_TECNICO" CHARACTER VARYING(255) NOT NULL,
    "APELLIDO_TECNICO" CHARACTER VARYING(255) NOT NULL,
    "TELEFONO_TECNICO" CHARACTER VARYING(255) NOT NULL,
    "DOMICILIO_TECNICO" CHARACTER VARYING(255)
);  
ALTER TABLE "TIENDALOCAL"."TECNICO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_D" PRIMARY KEY("ID_TECNICO");    
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.TECNICO;            
CREATE CACHED TABLE "TIENDALOCAL"."FACTURA"(
    "ID_FACTURA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "ESTADO" CHARACTER VARYING(255) NOT NULL,
    "MONTOTOTAL" DECIMAL(10, 2) NOT NULL
);  
ALTER TABLE "TIENDALOCAL"."FACTURA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_E" PRIMARY KEY("ID_FACTURA");    
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.FACTURA;            
CREATE CACHED TABLE "TIENDALOCAL"."PAGO"(
    "ID_PAGO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "ID_FACTURA" INTEGER,
    "MONTOABONADO" DECIMAL(10, 2) NOT NULL,
    "FECHAPAGO" TIMESTAMP NOT NULL,
    "DETALLE" CHARACTER VARYING(255)
);              
ALTER TABLE "TIENDALOCAL"."PAGO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_2" PRIMARY KEY("ID_PAGO");          
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.PAGO;               
CREATE CACHED TABLE "TIENDALOCAL"."REPUESTO"(
    "ID_REPUESTO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "STOCK" INTEGER NOT NULL,
    "CODIGO" CHARACTER VARYING(255),
    "ID_NOMBREREPUESTO" INTEGER,
    "ID_MARCA" INTEGER,
    "ID_MODELO" INTEGER,
    "ID_CATEGORIA" INTEGER,
    "ID_UBICACION" INTEGER
);      
ALTER TABLE "TIENDALOCAL"."REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_1" PRIMARY KEY("ID_REPUESTO");  
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.REPUESTO;           
CREATE CACHED TABLE "TIENDALOCAL"."PRECIO"(
    "ID_PRECIO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "FECHAPRECIO" TIMESTAMP NOT NULL,
    "VALOR" DECIMAL(10, 2) NOT NULL,
    "ID_REPUESTO" INTEGER
);     
ALTER TABLE "TIENDALOCAL"."PRECIO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8D" PRIMARY KEY("ID_PRECIO");     
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.PRECIO;             
CREATE CACHED TABLE "TIENDALOCAL"."REPARACION"(
    "ID_REPARACION" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "COSTO" DECIMAL(10, 2) NOT NULL,
    "DETALLES" CHARACTER VARYING(255),
    "FECHA_INGRESO" TIMESTAMP NOT NULL,
    "FECHA_DEVOLUCION" TIMESTAMP,
    "ID_FACTURA" INTEGER,
    "ID_CATEGORIA" INTEGER,
    "ID_CLIENTE" INTEGER,
    "ID_ESTADO" INTEGER,
    "ID_TECNICO" INTEGER
);    
ALTER TABLE "TIENDALOCAL"."REPARACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_A" PRIMARY KEY("ID_REPARACION");              
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.REPARACION;         
CREATE CACHED TABLE "TIENDALOCAL"."VENTA"(
    "ID_VENTA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "CANTIDAD" INTEGER NOT NULL,
    "FECHA_VENTA" TIMESTAMP NOT NULL,
    "PRECIOFINAL" DECIMAL(10, 2) NOT NULL,
    "ID_CLIENTE" INTEGER
);
ALTER TABLE "TIENDALOCAL"."VENTA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_4D" PRIMARY KEY("ID_VENTA");       
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.VENTA;              
CREATE CACHED TABLE "TIENDALOCAL"."VENTA_REPUESTO"(
    "ID_VENTA" INTEGER NOT NULL,
    "ID_REPUESTO" INTEGER NOT NULL,
    "CANTIDAD_REPUESTOS" INTEGER
);              
ALTER TABLE "TIENDALOCAL"."VENTA_REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_7E" PRIMARY KEY("ID_VENTA", "ID_REPUESTO");               
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.VENTA_REPUESTO;     
CREATE CACHED TABLE "TIENDALOCAL"."REPARACION_REPUESTO"(
    "ID_REPARACION" INTEGER NOT NULL,
    "ID_REPUESTO" INTEGER NOT NULL,
    "CANTIDAD_REPUESTOS" INTEGER
);    
ALTER TABLE "TIENDALOCAL"."REPARACION_REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_9" PRIMARY KEY("ID_REPARACION", "ID_REPUESTO");      
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.REPARACION_REPUESTO;
ALTER TABLE "TIENDALOCAL"."NOMBREREPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_6A" UNIQUE("NOMBRE_RESPUESTO");           
ALTER TABLE "TIENDALOCAL"."MODELO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_87" UNIQUE("NOMBRE_MODELO");      
ALTER TABLE "TIENDALOCAL"."MARCA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_45" UNIQUE("NOMBRE_MARCA");        
ALTER TABLE "TIENDALOCAL"."UBICACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8E7" UNIQUE("NOMBRE_UBICACION");               
ALTER TABLE "TIENDALOCAL"."ESTADO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_7A" UNIQUE("NOMBRE_ESTADO");      
ALTER TABLE "TIENDALOCAL"."CATEGORIA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_36" UNIQUE("NOMBRE_CATEGORIA");
ALTER TABLE "TIENDALOCAL"."CLIENTE" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_5E" UNIQUE("NOMBRE", "APELLIDO", "TELEFONO");    
ALTER TABLE "TIENDALOCAL"."REPARACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_AA6" FOREIGN KEY("ID_CATEGORIA") REFERENCES "TIENDALOCAL"."CATEGORIA"("ID_CATEGORIA") NOCHECK;
ALTER TABLE "TIENDALOCAL"."VENTA_REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_7E88" FOREIGN KEY("ID_REPUESTO") REFERENCES "TIENDALOCAL"."REPUESTO"("ID_REPUESTO") NOCHECK;              
ALTER TABLE "TIENDALOCAL"."PAGO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_25" FOREIGN KEY("ID_FACTURA") REFERENCES "TIENDALOCAL"."FACTURA"("ID_FACTURA") NOCHECK;             
ALTER TABLE "TIENDALOCAL"."REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_158" FOREIGN KEY("ID_MARCA") REFERENCES "TIENDALOCAL"."MARCA"("ID_MARCA") NOCHECK;              
ALTER TABLE "TIENDALOCAL"."REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_15807" FOREIGN KEY("ID_CATEGORIA") REFERENCES "TIENDALOCAL"."CATEGORIA"("ID_CATEGORIA") NOCHECK;
ALTER TABLE "TIENDALOCAL"."REPARACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_AA6C" FOREIGN KEY("ID_CLIENTE") REFERENCES "TIENDALOCAL"."CLIENTE"("ID_CLIENTE") NOCHECK;     
ALTER TABLE "TIENDALOCAL"."REPARACION_REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_92" FOREIGN KEY("ID_REPARACION") REFERENCES "TIENDALOCAL"."REPARACION"("ID_REPARACION") NOCHECK;     
ALTER TABLE "TIENDALOCAL"."VENTA_REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_7E8" FOREIGN KEY("ID_VENTA") REFERENCES "TIENDALOCAL"."VENTA"("ID_VENTA") NOCHECK;        
ALTER TABLE "TIENDALOCAL"."REPARACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_AA6C2" FOREIGN KEY("ID_ESTADO") REFERENCES "TIENDALOCAL"."ESTADO"("ID_ESTADO") NOCHECK;       
ALTER TABLE "TIENDALOCAL"."REPARACION_REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_926" FOREIGN KEY("ID_REPUESTO") REFERENCES "TIENDALOCAL"."REPUESTO"("ID_REPUESTO") NOCHECK;          
ALTER TABLE "TIENDALOCAL"."REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_1580" FOREIGN KEY("ID_MODELO") REFERENCES "TIENDALOCAL"."MODELO"("ID_MODELO") NOCHECK;          
ALTER TABLE "TIENDALOCAL"."REPARACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_AA" FOREIGN KEY("ID_FACTURA") REFERENCES "TIENDALOCAL"."FACTURA"("ID_FACTURA") NOCHECK;       
ALTER TABLE "TIENDALOCAL"."REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_158077" FOREIGN KEY("ID_UBICACION") REFERENCES "TIENDALOCAL"."UBICACION"("ID_UBICACION") NOCHECK;               
ALTER TABLE "TIENDALOCAL"."REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_15" FOREIGN KEY("ID_NOMBREREPUESTO") REFERENCES "TIENDALOCAL"."NOMBREREPUESTO"("ID_NOMBREREPUESTO") NOCHECK;    
ALTER TABLE "TIENDALOCAL"."VENTA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_4DC" FOREIGN KEY("ID_CLIENTE") REFERENCES "TIENDALOCAL"."CLIENTE"("ID_CLIENTE") NOCHECK;           
ALTER TABLE "TIENDALOCAL"."REPARACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_AA6C23" FOREIGN KEY("ID_TECNICO") REFERENCES "TIENDALOCAL"."TECNICO"("ID_TECNICO") NOCHECK;   
ALTER TABLE "TIENDALOCAL"."PRECIO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8D2" FOREIGN KEY("ID_REPUESTO") REFERENCES "TIENDALOCAL"."REPUESTO"("ID_REPUESTO") NOCHECK;       
