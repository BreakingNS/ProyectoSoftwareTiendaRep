-- H2 2.2.220;
;             
CREATE USER IF NOT EXISTS "SA" SALT '44a162da9e536c57' HASH '664c8e28b51c502b308221f91e6769764f29fc7d868344f45468cc03d9ee241c' ADMIN;         
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
    "ID_NOMBREREPUESTO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 12) NOT NULL,
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
    "ID_ESTADO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 11) NOT NULL,
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
(6, 'LISTO PARA RETIRAR'),
(7, 'ENTREGADO'),
(8, 'DEVUELTO SIN REPARAR'),
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
(11, 'JUAN', 'SANCHEZ', '3834383444', 'VILLA CUBAS 1024');  
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
    "ID_FACTURA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 55) NOT NULL,
    "ESTADO" CHARACTER VARYING(255) NOT NULL,
    "MONTOTOTAL" DECIMAL(10, 2) NOT NULL
);  
ALTER TABLE "TIENDALOCAL"."FACTURA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_E" PRIMARY KEY("ID_FACTURA");    
-- 54 +/- SELECT COUNT(*) FROM TIENDALOCAL.FACTURA;           
INSERT INTO "TIENDALOCAL"."FACTURA" VALUES
(1, 'NO', 45000.00),
(2, 'PARCIAL', 15000.00),
(3, 'SI', 9000.00),
(4, 'NO', 0.00),
(5, 'NO', 0.00),
(6, 'PARCIAL', 70000.00),
(7, 'SI', 85000.00),
(8, 'SI', 265000.00),
(9, 'PARCIAL', 115000.00),
(10, 'PARCIAL', 115000.00),
(11, 'PARCIAL', 115000.00),
(12, 'PARCIAL', 115000.00),
(13, 'PARCIAL', 115000.00),
(14, 'PARCIAL', 115000.00),
(15, 'SI', 115000.00),
(16, 'PARCIAL', 90000.00),
(17, 'PARCIAL', 90000.00),
(18, 'PARCIAL', 90000.00),
(19, 'PARCIAL', 90000.00),
(20, 'PARCIAL', 90000.00),
(21, 'PARCIAL', 90000.00),
(22, 'PARCIAL', 90000.00),
(23, 'PARCIAL', 90000.00),
(24, 'PARCIAL', 90000.00),
(25, 'PARCIAL', 90000.00),
(26, 'PARCIAL', 90000.00),
(27, 'PARCIAL', 90000.00),
(28, 'PARCIAL', 90000.00),
(29, 'PARCIAL', 90000.00),
(30, 'PARCIAL', 90000.00),
(31, 'PARCIAL', 90000.00),
(32, 'PARCIAL', 90000.00),
(33, 'PARCIAL', 90000.00),
(34, 'PARCIAL', 90000.00),
(35, 'PARCIAL', 90000.00),
(36, 'PARCIAL', 90000.00),
(37, 'PARCIAL', 90000.00),
(38, 'PARCIAL', 90000.00),
(39, 'PARCIAL', 90000.00),
(40, 'PARCIAL', 90000.00),
(41, 'PARCIAL', 90000.00),
(42, 'PARCIAL', 85000.00),
(43, 'PARCIAL', 31000.00),
(44, 'PARCIAL', 31000.00),
(45, 'PARCIAL', 31000.00),
(46, 'SI', 31000.00),
(47, 'SI', 31000.00),
(48, 'SI', 31000.00),
(49, 'SI', 31000.00),
(50, 'NO', 31000.00),
(51, 'NO', 93000.00),
(52, 'PARCIAL', 95000.00),
(53, 'NO', 95000.00),
(54, 'SI', 40000.00); 
CREATE CACHED TABLE "TIENDALOCAL"."PAGO"(
    "ID_PAGO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 61) NOT NULL,
    "ID_FACTURA" INTEGER,
    "MONTOABONADO" DECIMAL(10, 2) NOT NULL,
    "FECHAPAGO" TIMESTAMP NOT NULL,
    "DETALLE" CHARACTER VARYING(255)
);              
ALTER TABLE "TIENDALOCAL"."PAGO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_2" PRIMARY KEY("ID_PAGO");          
-- 60 +/- SELECT COUNT(*) FROM TIENDALOCAL.PAGO;              
INSERT INTO "TIENDALOCAL"."PAGO" VALUES
(1, 1, 0.00, TIMESTAMP '2024-10-09 22:02:33.998198', NULL),
(2, 2, 5000.00, TIMESTAMP '2024-10-09 22:04:18.39719', NULL),
(3, 3, 9000.00, TIMESTAMP '2024-10-09 22:04:48.853797', NULL),
(4, 4, 0.00, TIMESTAMP '2024-10-09 22:24:53.241211', NULL),
(5, 5, 0.00, TIMESTAMP '2024-10-09 22:25:42.159361', NULL),
(6, 6, 30000.00, TIMESTAMP '2024-10-10 09:59:08.078991', NULL),
(7, 7, 0.00, TIMESTAMP '2024-10-10 11:57:38.094605', NULL),
(8, 8, 100000.00, TIMESTAMP '2024-10-10 12:06:24.238711', NULL),
(9, 7, 20000.00, TIMESTAMP '2024-10-10 14:46:47.76371', ''),
(10, 7, 65000.00, TIMESTAMP '2024-10-10 14:46:53.612741', ''),
(11, 8, 165000.00, TIMESTAMP '2024-10-10 14:47:38.168581', ''),
(12, 9, 500000.00, TIMESTAMP '2024-10-14 03:18:04.476993', NULL),
(13, 10, 5000.00, TIMESTAMP '2024-10-14 03:18:13.226236', NULL),
(14, 11, 5000.00, TIMESTAMP '2024-10-14 03:18:14.650501', NULL),
(15, 12, 5000.00, TIMESTAMP '2024-10-14 03:18:14.982291', NULL),
(16, 13, 5000.00, TIMESTAMP '2024-10-14 03:18:15.131334', NULL),
(17, 14, 5000.00, TIMESTAMP '2024-10-14 03:18:15.283811', NULL),
(18, 15, 0.00, TIMESTAMP '2024-10-14 03:18:50.882971', NULL),
(19, 15, 100000.00, TIMESTAMP '2024-10-14 03:24:15.424526', ''),
(20, 15, 15000.00, TIMESTAMP '2024-10-14 03:24:22.297299', ''),
(21, 15, 0.00, TIMESTAMP '2024-10-14 03:24:28.621215', ''),
(22, 16, 50000.00, TIMESTAMP '2024-10-14 03:25:38.632307', NULL),
(23, 17, 50000.00, TIMESTAMP '2024-10-14 03:25:39.508973', NULL),
(24, 18, 50000.00, TIMESTAMP '2024-10-14 03:25:39.685476', NULL),
(25, 19, 50000.00, TIMESTAMP '2024-10-14 03:25:39.827187', NULL),
(26, 20, 50000.00, TIMESTAMP '2024-10-14 03:25:39.969248', NULL),
(27, 21, 50000.00, TIMESTAMP '2024-10-14 03:25:40.131705', NULL),
(28, 22, 50000.00, TIMESTAMP '2024-10-14 03:25:40.277574', NULL),
(29, 23, 50000.00, TIMESTAMP '2024-10-14 03:25:40.429262', NULL),
(30, 24, 50000.00, TIMESTAMP '2024-10-14 03:25:40.592496', NULL),
(31, 25, 50000.00, TIMESTAMP '2024-10-14 03:25:40.9332', NULL),
(32, 26, 50000.00, TIMESTAMP '2024-10-14 03:25:41.109443', NULL),
(33, 27, 50000.00, TIMESTAMP '2024-10-14 03:25:41.264224', NULL),
(34, 28, 50000.00, TIMESTAMP '2024-10-14 03:25:41.697263', NULL),
(35, 29, 50000.00, TIMESTAMP '2024-10-14 03:25:42.016151', NULL),
(36, 30, 50000.00, TIMESTAMP '2024-10-14 03:25:42.207431', NULL),
(37, 31, 50000.00, TIMESTAMP '2024-10-14 03:25:42.37926', NULL),
(38, 32, 50000.00, TIMESTAMP '2024-10-14 03:25:42.694218', NULL),
(39, 33, 50000.00, TIMESTAMP '2024-10-14 03:25:42.855942', NULL),
(40, 34, 50000.00, TIMESTAMP '2024-10-14 03:25:43.079234', NULL),
(41, 35, 50000.00, TIMESTAMP '2024-10-14 03:25:43.269266', NULL),
(42, 36, 50000.00, TIMESTAMP '2024-10-14 03:25:43.46225', NULL),
(43, 37, 50000.00, TIMESTAMP '2024-10-14 03:25:43.817234', NULL),
(44, 38, 50000.00, TIMESTAMP '2024-10-14 03:25:44.310263', NULL),
(45, 39, 50000.00, TIMESTAMP '2024-10-14 03:25:44.589233', NULL),
(46, 40, 50000.00, TIMESTAMP '2024-10-14 03:25:44.812253', NULL),
(47, 41, 50000.00, TIMESTAMP '2024-10-14 03:25:44.999904', NULL),
(48, 42, 50000.00, TIMESTAMP '2024-10-14 03:27:59.309209', NULL),
(49, 43, 31001.00, TIMESTAMP '2024-10-14 03:28:33.499998', NULL),
(50, 44, 31000.00, TIMESTAMP '2024-10-14 03:28:37.735246', NULL),
(51, 45, 0.00, TIMESTAMP '2024-10-14 03:28:44.581158', NULL),
(52, 46, 31000.00, TIMESTAMP '2024-10-14 03:28:52.682906', NULL),
(53, 47, 31000.00, TIMESTAMP '2024-10-14 03:28:53.912256', NULL),
(54, 48, 31000.00, TIMESTAMP '2024-10-14 03:28:54.09224', NULL),
(55, 49, 31000.00, TIMESTAMP '2024-10-14 03:28:54.246281', NULL),
(56, 50, 0.00, TIMESTAMP '2024-10-14 03:29:08.376282', NULL),
(57, 51, 0.00, TIMESTAMP '2024-10-14 03:34:17.387081', NULL),
(58, 52, 5000.00, TIMESTAMP '2024-10-14 03:34:46.896287', NULL),
(59, 53, 0.00, TIMESTAMP '2024-10-14 03:35:13.145169', NULL),
(60, 54, 40000.00, TIMESTAMP '2024-10-14 03:37:28.560304', NULL);       
CREATE CACHED TABLE "TIENDALOCAL"."VENTA"(
    "ID_VENTA" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 6) NOT NULL,
    "CANTIDAD" INTEGER NOT NULL,
    "FECHA_VENTA" TIMESTAMP NOT NULL,
    "PRECIOFINAL" DECIMAL(10, 2) NOT NULL,
    "ID_CLIENTE" INTEGER
); 
ALTER TABLE "TIENDALOCAL"."VENTA" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_4D" PRIMARY KEY("ID_VENTA");       
-- 5 +/- SELECT COUNT(*) FROM TIENDALOCAL.VENTA;              
INSERT INTO "TIENDALOCAL"."VENTA" VALUES
(1, 2, TIMESTAMP '2024-10-09 21:59:45.293886', 118000.00, 1),
(2, 2, TIMESTAMP '2024-10-09 21:59:53.332723', 40000.00, 9),
(3, 2, TIMESTAMP '2024-10-09 22:00:04.683593', 40000.00, 9),
(4, 2, TIMESTAMP '2024-10-11 10:58:56.78513', 55000.00, 6),
(5, 2, TIMESTAMP '2024-10-10 11:56:25.460571', 170000.00, 9);               
CREATE CACHED TABLE "TIENDALOCAL"."REPUESTO"(
    "ID_REPUESTO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 7) NOT NULL,
    "STOCK" INTEGER NOT NULL,
    "CODIGO" CHARACTER VARYING(255),
    "ID_NOMBREREPUESTO" INTEGER,
    "ID_MARCA" INTEGER,
    "ID_MODELO" INTEGER,
    "ID_CATEGORIA" INTEGER,
    "ID_UBICACION" INTEGER
);       
ALTER TABLE "TIENDALOCAL"."REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_1" PRIMARY KEY("ID_REPUESTO");  
-- 6 +/- SELECT COUNT(*) FROM TIENDALOCAL.REPUESTO;           
INSERT INTO "TIENDALOCAL"."REPUESTO" VALUES
(1, 47, 'Q2235', 1, 4, 3, 1, 6),
(2, 11, 'Q7748', 2, 1, 4, 2, 1),
(3, 5, 'W5511', 3, 3, 1, 3, 4),
(4, 14, 'R7701', 4, 2, 2, 4, 2),
(5, 3, 'H4471', 9, 2, 4, 3, 1),
(6, 57, 'J1144', 5, 5, 5, 4, 1);         
CREATE CACHED TABLE "TIENDALOCAL"."PRECIO"(
    "ID_PRECIO" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 9) NOT NULL,
    "FECHAPRECIO" TIMESTAMP NOT NULL,
    "VALOR" DECIMAL(10, 2) NOT NULL,
    "ID_REPUESTO" INTEGER
);      
ALTER TABLE "TIENDALOCAL"."PRECIO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_8D" PRIMARY KEY("ID_PRECIO");     
-- 8 +/- SELECT COUNT(*) FROM TIENDALOCAL.PRECIO;             
INSERT INTO "TIENDALOCAL"."PRECIO" VALUES
(1, TIMESTAMP '2024-10-09 21:56:36.847019', 25000.00, 1),
(2, TIMESTAMP '2024-10-09 21:56:54.05586', 20000.00, 2),
(3, TIMESTAMP '2024-10-09 21:57:24.370579', 70000.00, 3),
(4, TIMESTAMP '2024-10-09 21:57:42.999896', 35000.00, 4),
(5, TIMESTAMP '2024-10-09 21:58:01.435377', 48000.00, 5),
(6, TIMESTAMP '2024-10-09 21:58:22.186769', 15000.00, 6),
(7, TIMESTAMP '2024-10-10 11:56:00.096846', 90000.00, 3),
(8, TIMESTAMP '2024-10-10 11:56:06.288022', 80000.00, 5);              
CREATE CACHED TABLE "TIENDALOCAL"."REPARACION"(
    "ID_REPARACION" INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 13) NOT NULL,
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
-- 12 +/- SELECT COUNT(*) FROM TIENDALOCAL.REPARACION;        
INSERT INTO "TIENDALOCAL"."REPARACION" VALUES
(1, 85000.00, U&'carloventor no funciona\000a', TIMESTAMP '2024-10-10 12:12:50', TIMESTAMP '2024-10-22 00:00:00', 7, 4, 7, 1, 1),
(2, 15000.00, 'service completo y revisar fuga de gas 1 service completo y revisar fuga de gas 2 service completo y revisar fuga de gas 3 service completo y revisar fuga de gas 4 service completo y revisar fuga de gas 5 service completo y revisar fuga de gas 6     ', TIMESTAMP '2024-10-09 22:04:14', TIMESTAMP '2024-10-21 00:00:00', 2, 3, 10, 1, 1),
(3, 9000.00, U&'revisar termotanque\000a\000a', TIMESTAMP '2024-10-09 22:04:46', NULL, 3, 1, 10, 1, 3),
(4, 0.00, '', TIMESTAMP '2024-10-09 22:24:50', NULL, 4, 3, 4, 1, NULL),
(5, 0.00, 'no enfria, no calienta, puede tener fugas, hace mucho ruido.', TIMESTAMP '2024-10-09 22:25:40', NULL, 5, 3, 1, 4, NULL),
(6, 70000.00, 'algo de detalle', TIMESTAMP '2024-10-10 09:59:01', TIMESTAMP '2024-10-17 00:00:00', 6, 4, 7, 4, 3),
(7, 85000.00, U&'carloventor no funciona\000a', TIMESTAMP '2024-10-10 11:57:35', TIMESTAMP '2024-10-22 00:00:00', 7, 4, 7, 1, 1),
(8, 265000.00, '', TIMESTAMP '2024-10-10 12:06:17', TIMESTAMP '2024-10-12 00:00:00', 8, 3, 11, 5, 1),
(9, 115000.00, '', TIMESTAMP '2024-10-14 03:17:57', NULL, 15, 1, 3, 1, NULL),
(10, 85000.00, '', TIMESTAMP '2024-10-14 03:27:54', NULL, 42, 3, 1, 1, NULL),
(11, 95000.00, '', TIMESTAMP '2024-10-14 03:34:42', NULL, 52, 1, 3, 1, NULL),
(12, 40000.00, '', TIMESTAMP '2024-10-14 03:37:26', NULL, 54, 2, 4, 2, NULL);             
CREATE CACHED TABLE "TIENDALOCAL"."VENTA_REPUESTO"(
    "ID_VENTA" INTEGER NOT NULL,
    "ID_REPUESTO" INTEGER NOT NULL,
    "CANTIDAD_REPUESTOS" INTEGER
);              
ALTER TABLE "TIENDALOCAL"."VENTA_REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_7E" PRIMARY KEY("ID_VENTA", "ID_REPUESTO");               
-- 9 +/- SELECT COUNT(*) FROM TIENDALOCAL.VENTA_REPUESTO;     
INSERT INTO "TIENDALOCAL"."VENTA_REPUESTO" VALUES
(1, 3, 1),
(1, 5, 1),
(2, 2, 2),
(3, 1, 1),
(3, 6, 1),
(5, 3, 1),
(5, 5, 1),
(5, 2, 1),
(5, 4, 1); 
CREATE CACHED TABLE "TIENDALOCAL"."REPARACION_REPUESTO"(
    "ID_REPARACION" INTEGER NOT NULL,
    "ID_REPUESTO" INTEGER NOT NULL,
    "CANTIDAD_REPUESTOS" INTEGER
);    
ALTER TABLE "TIENDALOCAL"."REPARACION_REPUESTO" ADD CONSTRAINT "TIENDALOCAL"."CONSTRAINT_9" PRIMARY KEY("ID_REPARACION", "ID_REPUESTO");      
-- 12 +/- SELECT COUNT(*) FROM TIENDALOCAL.REPARACION_REPUESTO;               
INSERT INTO "TIENDALOCAL"."REPARACION_REPUESTO" VALUES
(1, 1, 1),
(1, 6, 1),
(6, 1, 1),
(6, 6, 1),
(7, 4, 2),
(8, 3, 1),
(8, 5, 2),
(9, 2, 1),
(9, 4, 1),
(10, 5, 1),
(11, 3, 1),
(12, 4, 1);     
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
