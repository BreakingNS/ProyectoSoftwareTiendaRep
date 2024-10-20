-- H2 2.2.220;
;             
CREATE USER IF NOT EXISTS "SA" SALT '44a162da9e536c57' HASH '664c8e28b51c502b308221f91e6769764f29fc7d868344f45468cc03d9ee241c' ADMIN;         
CREATE SCHEMA IF NOT EXISTS "TIENDALOCAL" AUTHORIZATION "SA"; 
CREATE CACHED TABLE "TIENDALOCAL"."MARCA"(
    "ID_MARCA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 33) NOT NULL,
    "NOMBRE_MARCA" CHARACTER VARYING(255) NOT NULL
);           
ALTER TABLE "TIENDALOCAL"."MARCA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_4" PRIMARY KEY("ID_MARCA");        
-- 20 +/- SELECT COUNT(*) FROM TIENDALOCAL.MARCA;             
INSERT INTO "TIENDALOCAL"."MARCA" VALUES
(1, 'SGGSFDG'),
(2, 'SDGSG'),
(3, 'SGDGF'),
(4, 'FDG'),
(5, 'FGH'),
(6, 'H'),
(7, 'RTYRYT'),
(8, 'UYTU'),
(9, 'TUYTUY'),
(10, 'EQWEQWQEW'),
(11, 'WRREWR'),
(12, 'ETTETR'),
(13, 'RYRYT'),
(14, 'SFFDSF'),
(15, 'DGGDFGD'),
(16, 'DHHDHD'),
(17, 'DHFHFDFH'),
(18, 'DHDHFHD'),
(19, ' D DHDHFHDF'),
(20, 'DHDFH DDH');           
CREATE CACHED TABLE "TIENDALOCAL"."NOMBREREPUESTO"(
    "ID_NOMBREREPUESTO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "NOMBRE_REPUESTO" CHARACTER VARYING(255) NOT NULL
);      
ALTER TABLE "TIENDALOCAL"."NOMBREREPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_6" PRIMARY KEY("ID_NOMBREREPUESTO");      
-- 0 +/- SELECT COUNT(*) FROM TIENDALOCAL.NOMBREREPUESTO;     
CREATE CACHED TABLE "TIENDALOCAL"."MODELO"(
    "ID_MODELO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 33) NOT NULL,
    "NOMBRE_MODELO" CHARACTER VARYING(255) NOT NULL
);        
ALTER TABLE "TIENDALOCAL"."MODELO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8" PRIMARY KEY("ID_MODELO");      
-- 20 +/- SELECT COUNT(*) FROM TIENDALOCAL.MODELO;            
INSERT INTO "TIENDALOCAL"."MODELO" VALUES
(1, 'SDFGSGD'),
(2, 'SDFGSDG'),
(3, 'GSDG'),
(4, 'ASADSA'),
(5, 'ASDFASD'),
(6, 'QQQ'),
(7, 'WWWW'),
(8, 'EEEE'),
(9, 'RRRR'),
(10, 'TTTT'),
(11, 'YYYY'),
(12, 'ETET'),
(13, 'WEWE'),
(14, 'REERRE'),
(15, 'TETRTR'),
(16, 'ETRER'),
(17, 'YTRYTYR'),
(18, 'YRYYT'),
(19, 'ZZZ'),
(20, 'ZZZZZ');               
CREATE CACHED TABLE "TIENDALOCAL"."UBICACION"(
    "ID_UBICACION" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 33) NOT NULL,
    "NOMBRE_UBICACION" CHARACTER VARYING(255) NOT NULL
);               
ALTER TABLE "TIENDALOCAL"."UBICACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8E" PRIMARY KEY("ID_UBICACION");               
-- 10 +/- SELECT COUNT(*) FROM TIENDALOCAL.UBICACION;         
INSERT INTO "TIENDALOCAL"."UBICACION" VALUES
(1, 'QQQQQQ'),
(2, 'WWWWWW'),
(3, 'EEEEEEEEE'),
(4, 'RRRRRRRRRRR'),
(5, 'TTTTTTTTTTT'),
(6, 'YYYYYYYYYYY'),
(7, 'UUUUUUUUUUU'),
(8, 'AAAAAAAAAAAA'),
(9, 'SSSSSSSSS'),
(10, 'DDDDDDDDD');              
CREATE CACHED TABLE "TIENDALOCAL"."CATEGORIA"(
    "ID_CATEGORIA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 33) NOT NULL,
    "NOMBRE_CATEGORIA" CHARACTER VARYING(255) NOT NULL
);               
ALTER TABLE "TIENDALOCAL"."CATEGORIA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_3" PRIMARY KEY("ID_CATEGORIA");
-- 10 +/- SELECT COUNT(*) FROM TIENDALOCAL.CATEGORIA;         
INSERT INTO "TIENDALOCAL"."CATEGORIA" VALUES
(1, 'AAAAAAAAA'),
(2, 'AAAAAA'),
(3, 'AAA'),
(4, 'A'),
(5, 'QQQ'),
(6, 'WWW'),
(7, 'EEEE'),
(8, 'RRRR'),
(9, 'TTTT'),
(10, 'YYYY');    
CREATE CACHED TABLE "TIENDALOCAL"."ESTADO"(
    "ID_ESTADO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 33) NOT NULL,
    "NOMBRE_ESTADO" CHARACTER VARYING(255) NOT NULL
);        
ALTER TABLE "TIENDALOCAL"."ESTADO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_7" PRIMARY KEY("ID_ESTADO");      
-- 10 +/- SELECT COUNT(*) FROM TIENDALOCAL.ESTADO;            
INSERT INTO "TIENDALOCAL"."ESTADO" VALUES
(1, 'AAAA'),
(2, 'QQQQ'),
(3, 'EEE'),
(4, 'WWW'),
(5, 'RRR'),
(6, 'WERWE'),
(7, 'RWRE'),
(8, 'WWWRE'),
(9, 'RERRE'),
(10, 'WEWWE');       
CREATE CACHED TABLE "TIENDALOCAL"."CLIENTE"(
    "ID_CLIENTE" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 33) NOT NULL,
    "NOMBRE" CHARACTER VARYING(255) NOT NULL,
    "APELLIDO" CHARACTER VARYING(255) NOT NULL,
    "TELEFONO" CHARACTER VARYING(255) NOT NULL,
    "DOMICILIO" CHARACTER VARYING(255) NOT NULL
);         
ALTER TABLE "TIENDALOCAL"."CLIENTE" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_5" PRIMARY KEY("ID_CLIENTE");    
-- 4 +/- SELECT COUNT(*) FROM TIENDALOCAL.CLIENTE;            
INSERT INTO "TIENDALOCAL"."CLIENTE" VALUES
(1, 'SFGSGDFGS', 'SDFGSGDFGS', '65165', 'SDGGSDF  564465'),
(2, 'SHDFSFDHD', 'SDFHHSDF', '549874', 'SFHHSD 46546'),
(3, 'SHFDHFSDSH', 'SDHFSHD', '6548', 'SFHDSHDSHDF 549854'),
(4, 'SDGSGD', 'SDFGGSDFSG', '4684987', 'VALLE VIEJO 54222');   
CREATE CACHED TABLE "TIENDALOCAL"."TECNICO"(
    "ID_TECNICO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 33) NOT NULL,
    "NOMBRE_TECNICO" CHARACTER VARYING(255) NOT NULL,
    "APELLIDO_TECNICO" CHARACTER VARYING(255) NOT NULL,
    "TELEFONO_TECNICO" CHARACTER VARYING(255) NOT NULL,
    "DOMICILIO_TECNICO" CHARACTER VARYING(255)
);  
ALTER TABLE "TIENDALOCAL"."TECNICO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_D" PRIMARY KEY("ID_TECNICO");    
-- 3 +/- SELECT COUNT(*) FROM TIENDALOCAL.TECNICO;            
INSERT INTO "TIENDALOCAL"."TECNICO" VALUES
(1, 'ASDFSF', 'ASFFAD', '38345', 'ASDFAS 65469 '),
(2, 'AFDSAFSD', 'ADFSAFSD', '35468', 'ADSFF 6546954'),
(3, 'AFFAFSD', 'ADFF', '354654', 'AFDAF 654654');     
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
ALTER TABLE "TIENDALOCAL"."NOMBREREPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_6A" UNIQUE("NOMBRE_REPUESTO");            
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
ALTER TABLE "TIENDALOCAL"."VENTA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_4DC" FOREIGN KEY("ID_CLIENTE") REFERENCES "TIENDALOCAL"."CLIENTE"("ID_CLIENTE") NOCHECK;           
ALTER TABLE "TIENDALOCAL"."REPARACION" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_AA6C23" FOREIGN KEY("ID_TECNICO") REFERENCES "TIENDALOCAL"."TECNICO"("ID_TECNICO") NOCHECK;   
ALTER TABLE "TIENDALOCAL"."PRECIO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8D2" FOREIGN KEY("ID_REPUESTO") REFERENCES "TIENDALOCAL"."REPUESTO"("ID_REPUESTO") NOCHECK;       
