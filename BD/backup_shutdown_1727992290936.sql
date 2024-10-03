-- H2 2.2.220;
;             
CREATE USER IF NOT EXISTS "SA" SALT '1f239ac3c9eb91ad' HASH '3c76e03beef7330f062a0629c341271aafb805af22623d89dc71f503d29da547' ADMIN;         
CREATE SCHEMA IF NOT EXISTS "TIENDALOCAL" AUTHORIZATION "SA"; 
CREATE CACHED TABLE "TIENDALOCAL"."MARCA"(
    "ID_MARCA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 7) NOT NULL,
    "NOMBRE_MARCA" CHARACTER VARYING(255) NOT NULL
);            
ALTER TABLE "TIENDALOCAL"."MARCA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_4" PRIMARY KEY("ID_MARCA");        
-- 6 +/- SELECT COUNT(*) FROM TIENDALOCAL.MARCA;              
INSERT INTO "TIENDALOCAL"."MARCA" VALUES
(1, 'GENERICO'),
(2, 'PANASONIC'),
(3, 'LG'),
(4, 'ARIETE'),
(5, 'WHIRLPOOL'),
(6, 'PHILIPS'); 
CREATE CACHED TABLE "TIENDALOCAL"."NOMBREREPUESTO"(
    "ID_NOMBREREPUESTO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 11) NOT NULL,
    "NOMBRE_REPUESTO" CHARACTER VARYING(255) NOT NULL
);      
ALTER TABLE "TIENDALOCAL"."NOMBREREPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_6" PRIMARY KEY("ID_NOMBREREPUESTO");      
-- 10 +/- SELECT COUNT(*) FROM TIENDALOCAL.NOMBREREPUESTO;    
INSERT INTO "TIENDALOCAL"."NOMBREREPUESTO" VALUES
(1, 'BOBINA'),
(2, 'FUENTE'),
(3, 'ACOPLE'),
(4, 'ACTUADOR'),
(5, 'AGITADOR'),
(6, 'EMBRAGUE'),
(7, 'SEMICONDUCTOR'),
(8, 'SELLO DE AGUA'),
(9, 'TERMINAL'),
(10, 'PLAQUETA');    
CREATE CACHED TABLE "TIENDALOCAL"."MODELO"(
    "ID_MODELO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 6) NOT NULL,
    "NOMBRE_MODELO" CHARACTER VARYING(255) NOT NULL
);         
ALTER TABLE "TIENDALOCAL"."MODELO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8" PRIMARY KEY("ID_MODELO");      
-- 5 +/- SELECT COUNT(*) FROM TIENDALOCAL.MODELO;             
INSERT INTO "TIENDALOCAL"."MODELO" VALUES
(1, 'PLUS'),
(2, 'PLUS ULTRA'),
(3, 'GOLD'),
(4, 'PLATINUM'),
(5, 'WHITE');    
CREATE CACHED TABLE "TIENDALOCAL"."UBICACION"(
    "ID_UBICACION" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 7) NOT NULL,
    "NOMBRE_UBICACION" CHARACTER VARYING(255) NOT NULL
);
ALTER TABLE "TIENDALOCAL"."UBICACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8E" PRIMARY KEY("ID_UBICACION");               
-- 6 +/- SELECT COUNT(*) FROM TIENDALOCAL.UBICACION;          
INSERT INTO "TIENDALOCAL"."UBICACION" VALUES
(1, 'DEPOSITO'),
(2, 'PISO 1'),
(3, 'PISO 2'),
(4, 'MOSTRADOR'),
(5, 'VIDRIERA'),
(6, 'ALMACEN');          
CREATE CACHED TABLE "TIENDALOCAL"."CATEGORIA"(
    "ID_CATEGORIA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 5) NOT NULL,
    "NOMBRE_CATEGORIA" CHARACTER VARYING(255) NOT NULL
);
ALTER TABLE "TIENDALOCAL"."CATEGORIA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_3" PRIMARY KEY("ID_CATEGORIA");
-- 4 +/- SELECT COUNT(*) FROM TIENDALOCAL.CATEGORIA;          
INSERT INTO "TIENDALOCAL"."CATEGORIA" VALUES
(1, 'LAVARROPAS'),
(2, 'HELADERA'),
(3, 'AIRE ACONDICIONADO'),
(4, 'LINEA BLANCA');          
CREATE CACHED TABLE "TIENDALOCAL"."ESTADO"(
    "ID_ESTADO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 10) NOT NULL,
    "NOMBRE_ESTADO" CHARACTER VARYING(255) NOT NULL
);        
ALTER TABLE "TIENDALOCAL"."ESTADO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_7" PRIMARY KEY("ID_ESTADO");      
-- 9 +/- SELECT COUNT(*) FROM TIENDALOCAL.ESTADO;             
INSERT INTO "TIENDALOCAL"."ESTADO" VALUES
(1, 'INGRESADO'),
(2, 'EN REVISION'),
(3, 'PRESUPUESTO EMITIDO'),
(4, 'APROBADO PARA REPARACION'),
(5, 'EN REPARACION'),
(6, 'REPARACION'),
(7, 'LISTO PARA RETIRAR'),
(8, 'DDEVUELTO SIN REPARAR'),
(9, 'CANCELADO');     
CREATE CACHED TABLE "TIENDALOCAL"."CLIENTE"(
    "ID_CLIENTE" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 12) NOT NULL,
    "NOMBRE" CHARACTER VARYING(255) NOT NULL,
    "APELLIDO" CHARACTER VARYING(255) NOT NULL,
    "TELEFONO" CHARACTER VARYING(255) NOT NULL,
    "DOMICILIO" CHARACTER VARYING(255)
);  
ALTER TABLE "TIENDALOCAL"."CLIENTE" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_5" PRIMARY KEY("ID_CLIENTE");    
-- 11 +/- SELECT COUNT(*) FROM TIENDALOCAL.CLIENTE;           
INSERT INTO "TIENDALOCAL"."CLIENTE" VALUES
(1, 'CARLOS', 'PEREZ', '3834123456', 'VALLE VIEJO'),
(2, 'MARIA', 'CARRIZO', '3834654321', 'ACHACHAY'),
(3, 'FRANCO', 'ESPINDOLA', '3834001234', 'EVA PERON'),
(4, 'CRISTINA', 'AGUILERA', '3834874457', 'VALLE VIEJO'),
(5, 'MIRIAM', 'NIEVA', '3834987445', '1000 VIVIENDAS'),
(6, 'LISANDRO', 'MARTINEZ', '3834132345', 'ACHACHAY'),
(7, 'PABLO', 'PEREZ', '3834445778', '1000 VIVIENDAS'),
(8, 'JUDITH', U&'ARGA\00d1ARAZ', '3834998665', 'VALLE VIEJO'),
(9, 'MARLA', 'PEREA', '3834774477', 'EVA PERON'),
(10, 'VANESA', 'RIZZARDO', '3834887552', '1000 VIVIENDAS'),
(11, 'NAHUEL HERNAN', 'SEGURA', '3834904649', U&'B\00b0 MALVINAS ARGENTINAS');              
CREATE CACHED TABLE "TIENDALOCAL"."TECNICO"(
    "ID_TECNICO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 4) NOT NULL,
    "NOMBRE_TECNICO" CHARACTER VARYING(255) NOT NULL,
    "APELLIDO_TECNICO" CHARACTER VARYING(255) NOT NULL,
    "TELEFONO_TECNICO" CHARACTER VARYING(255) NOT NULL,
    "DOMICILIO_TECNICO" CHARACTER VARYING(255)
);   
ALTER TABLE "TIENDALOCAL"."TECNICO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_D" PRIMARY KEY("ID_TECNICO");    
-- 3 +/- SELECT COUNT(*) FROM TIENDALOCAL.TECNICO;            
INSERT INTO "TIENDALOCAL"."TECNICO" VALUES
(1, 'MARIO', 'MONTENEGRO', '3834557788', 'CENTRO'),
(2, 'PABLO', 'CASTRO', '3834650078', 'SUR'),
(3, 'SILVIO', 'MARTINEZ', '3834882104', 'CENTRO');             
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
CREATE CACHED TABLE "TIENDALOCAL"."VENTA"(
    "ID_VENTA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "CANTIDAD" INTEGER NOT NULL,
    "FECHA_VENTA" TIMESTAMP NOT NULL,
    "PRECIOFINAL" DECIMAL(10, 2) NOT NULL,
    "ID_CLIENTE" INTEGER
);
ALTER TABLE "TIENDALOCAL"."VENTA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_4D" PRIMARY KEY("ID_VENTA");       
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.VENTA;              
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
ALTER TABLE "TIENDALOCAL"."NOMBREREPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_6A" UNIQUE("NOMBRE_REPUESTO");            
ALTER TABLE "TIENDALOCAL"."MODELO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_87" UNIQUE("NOMBRE_MODELO");      
ALTER TABLE "TIENDALOCAL"."MARCA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_45" UNIQUE("NOMBRE_MARCA");        
ALTER TABLE "TIENDALOCAL"."UBICACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8E7" UNIQUE("NOMBRE_UBICACION");               
ALTER TABLE "TIENDALOCAL"."ESTADO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_7A" UNIQUE("NOMBRE_ESTADO");      
ALTER TABLE "TIENDALOCAL"."CATEGORIA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_36" UNIQUE("NOMBRE_CATEGORIA");
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
ALTER TABLE "TIENDALOCAL"."VENTA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_4DC" FOREIGN KEY("ID_CLIENTE") REFERENCES "TIENDALOCAL"."CLIENTE"("ID_CLIENTE") NOCHECK;           
ALTER TABLE "TIENDALOCAL"."REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_15" FOREIGN KEY("ID_NOMBREREPUESTO") REFERENCES "TIENDALOCAL"."NOMBREREPUESTO"("ID_NOMBREREPUESTO") NOCHECK;    
ALTER TABLE "TIENDALOCAL"."REPARACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_AA6C23" FOREIGN KEY("ID_TECNICO") REFERENCES "TIENDALOCAL"."TECNICO"("ID_TECNICO") NOCHECK;   
ALTER TABLE "TIENDALOCAL"."PRECIO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8D2" FOREIGN KEY("ID_REPUESTO") REFERENCES "TIENDALOCAL"."REPUESTO"("ID_REPUESTO") NOCHECK;       
