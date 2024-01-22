-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: negociobd
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja` (
  `idCaja` int(11) NOT NULL AUTO_INCREMENT,
  `estado` bit(1) DEFAULT NULL,
  `nroCaja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCaja`),
  UNIQUE KEY `UK_t9b4l7hi84uo50g41kx4bx051` (`nroCaja`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
INSERT INTO `caja` VALUES (1,'\0','0001');
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE KEY `UK_35t4wyxqrevf09uwx9e9p6o75` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (2,'ALMACEN'),(3,'FIAMBRERIA'),(1,'PROMOCIONES');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleventa` (
  `idDetalleVenta` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idVenta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDetalleVenta`),
  KEY `FKg4y5upa3kbbequrelpphw4hjl` (`idProducto`),
  KEY `FK5jrugnl6k54f6cwfebogc4r2m` (`idVenta`),
  CONSTRAINT `FK5jrugnl6k54f6cwfebogc4r2m` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`),
  CONSTRAINT `FKg4y5upa3kbbequrelpphw4hjl` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventa`
--

LOCK TABLES `detalleventa` WRITE;
/*!40000 ALTER TABLE `detalleventa` DISABLE KEYS */;
INSERT INTO `detalleventa` VALUES (6,6,490.05000000000007,1,3),(7,20,1633.5000000000002,1,4),(8,10,816.7500000000001,1,4),(9,1,1650.0000000000002,2,4),(10,1,81.67500000000001,1,5),(11,1,1650.0000000000002,2,5),(12,1,1650.0000000000002,2,6),(13,1,1650.0000000000002,2,6),(14,1,1650.0000000000002,2,6),(15,1,81.67500000000001,1,6),(16,1,1650.0000000000002,2,7),(17,1,1650.0000000000002,2,7),(18,1,1650.0000000000002,2,8),(19,1,1800,3,9),(20,10,985,1,10);
/*!40000 ALTER TABLE `detalleventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formadepago`
--

DROP TABLE IF EXISTS `formadepago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formadepago` (
  `idFormaDePago` int(11) NOT NULL AUTO_INCREMENT,
  `formaDePago` varchar(255) NOT NULL,
  PRIMARY KEY (`idFormaDePago`),
  UNIQUE KEY `UK_icy227h847x3weam7d47hk4ky` (`formaDePago`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formadepago`
--

LOCK TABLES `formadepago` WRITE;
/*!40000 ALTER TABLE `formadepago` DISABLE KEYS */;
INSERT INTO `formadepago` VALUES (1,'Credito'),(8,'Cuenta corriente'),(2,'Debito'),(3,'Efectivo'),(4,'Mercado Pago'),(6,'Otro'),(7,'Transferencia'),(5,'Uala');
/*!40000 ALTER TABLE `formadepago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formasdepagopedidos`
--

DROP TABLE IF EXISTS `formasdepagopedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formasdepagopedidos` (
  `idFormaDePagoPedido` int(11) NOT NULL AUTO_INCREMENT,
  `montoFDP1` double NOT NULL,
  `montoFDP2` double DEFAULT NULL,
  `forma1` int(11) NOT NULL,
  `forma2` int(11) DEFAULT NULL,
  `idPedido` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFormaDePagoPedido`),
  KEY `FKkgf9um3riild52sxo3n6vup9d` (`forma1`),
  KEY `FK21ysp6vv1k7ir7h2ct6ksuub1` (`forma2`),
  KEY `FKsm2wv5fqlk5bml0mhrn3pqy0l` (`idPedido`),
  CONSTRAINT `FK21ysp6vv1k7ir7h2ct6ksuub1` FOREIGN KEY (`forma2`) REFERENCES `formadepago` (`idFormaDePago`),
  CONSTRAINT `FKkgf9um3riild52sxo3n6vup9d` FOREIGN KEY (`forma1`) REFERENCES `formadepago` (`idFormaDePago`),
  CONSTRAINT `FKsm2wv5fqlk5bml0mhrn3pqy0l` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formasdepagopedidos`
--

LOCK TABLES `formasdepagopedidos` WRITE;
/*!40000 ALTER TABLE `formasdepagopedidos` DISABLE KEYS */;
INSERT INTO `formasdepagopedidos` VALUES (3,20000,NULL,2,NULL,3),(4,12000,NULL,2,NULL,4),(5,10000,NULL,3,NULL,5);
/*!40000 ALTER TABLE `formasdepagopedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formasdepagoventas`
--

DROP TABLE IF EXISTS `formasdepagoventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formasdepagoventas` (
  `idFormaDePagoVenta` int(11) NOT NULL AUTO_INCREMENT,
  `montoFDP1` double NOT NULL,
  `montoFDP2` double DEFAULT NULL,
  `idCaja` int(11) DEFAULT NULL,
  `forma1` int(11) NOT NULL,
  `forma2` int(11) DEFAULT NULL,
  `idVenta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFormaDePagoVenta`),
  KEY `FK8hrb9329dnpid6lrd0mcrmclb` (`idCaja`),
  KEY `FKdm6n98imuiefxn3u99p9xxofs` (`forma1`),
  KEY `FKf162oedpbhouk86dpg5oo5d4k` (`forma2`),
  KEY `FKkiesqck0gckgpmc8q32rds8up` (`idVenta`),
  CONSTRAINT `FK8hrb9329dnpid6lrd0mcrmclb` FOREIGN KEY (`idCaja`) REFERENCES `caja` (`idCaja`),
  CONSTRAINT `FKdm6n98imuiefxn3u99p9xxofs` FOREIGN KEY (`forma1`) REFERENCES `formadepago` (`idFormaDePago`),
  CONSTRAINT `FKf162oedpbhouk86dpg5oo5d4k` FOREIGN KEY (`forma2`) REFERENCES `formadepago` (`idFormaDePago`),
  CONSTRAINT `FKkiesqck0gckgpmc8q32rds8up` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formasdepagoventas`
--

LOCK TABLES `formasdepagoventas` WRITE;
/*!40000 ALTER TABLE `formasdepagoventas` DISABLE KEYS */;
INSERT INTO `formasdepagoventas` VALUES (3,490.05,NULL,1,5,NULL,3),(4,40000,10000,1,1,2,4),(5,1558.51,NULL,1,2,NULL,5),(6,4931.04,NULL,1,4,NULL,6),(7,3300,NULL,1,3,NULL,7),(8,1000,650,1,1,2,8),(9,1800,NULL,1,8,NULL,9),(10,886.5,NULL,1,3,NULL,10);
/*!40000 ALTER TABLE `formasdepagoventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `licencia`
--

DROP TABLE IF EXISTS `licencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `licencia` (
  `idLicencia` int(11) NOT NULL AUTO_INCREMENT,
  `estado` bit(1) DEFAULT NULL,
  `fechaAdquisicion` datetime DEFAULT NULL,
  `fechaTermino` datetime DEFAULT NULL,
  `meses` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLicencia`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `licencia`
--

LOCK TABLES `licencia` WRITE;
/*!40000 ALTER TABLE `licencia` DISABLE KEYS */;
INSERT INTO `licencia` VALUES (1,'','2023-10-16 00:00:00','2025-01-16 00:00:00',3);
/*!40000 ALTER TABLE `licencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientoscaja`
--

DROP TABLE IF EXISTS `movimientoscaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimientoscaja` (
  `idMovimientoCaja` int(11) NOT NULL AUTO_INCREMENT,
  `comentario` varchar(255) DEFAULT NULL,
  `diferencia` double DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `saldoRealCierre` double DEFAULT NULL,
  `saldoTeoricoCierre` double DEFAULT NULL,
  `operacion` varchar(255) DEFAULT NULL,
  `sucursal` varchar(255) DEFAULT NULL,
  `idCaja` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMovimientoCaja`),
  KEY `FKc65i65uxxss85l4rtk3bssh3k` (`idCaja`),
  KEY `FKst1wxoed7epmxicr15st2up94` (`idUsuario`),
  CONSTRAINT `FKc65i65uxxss85l4rtk3bssh3k` FOREIGN KEY (`idCaja`) REFERENCES `caja` (`idCaja`),
  CONSTRAINT `FKst1wxoed7epmxicr15st2up94` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientoscaja`
--

LOCK TABLES `movimientoscaja` WRITE;
/*!40000 ALTER TABLE `movimientoscaja` DISABLE KEYS */;
INSERT INTO `movimientoscaja` VALUES (5,'',NULL,'2024-01-17 20:30:35',1000,NULL,NULL,'APERTURA','PRINCIPAL',1,1),(6,'',NULL,'2024-01-17 20:32:02',600,NULL,NULL,'INGRESO','PRINCIPAL',1,1),(7,NULL,909.9499999999998,'2024-01-17 20:32:16',NULL,3000,2090.05,'CIERRE','PRINCIPAL',1,1),(8,'',NULL,'2024-01-17 20:32:38',1200,NULL,NULL,'APERTURA','PRINCIPAL',1,1),(9,'',NULL,'2024-01-17 20:43:57',900,NULL,NULL,'EGRESO','PRINCIPAL',1,1),(10,NULL,0,'2024-01-17 20:47:10',NULL,4000,3990.225000000001,'CIERRE','PRINCIPAL',1,1),(11,'',NULL,'2024-01-17 20:47:31',2000,NULL,NULL,'APERTURA','PRINCIPAL',1,1),(12,'',NULL,'2024-01-17 20:58:42',5000,NULL,NULL,'INGRESO','PRINCIPAL',1,1),(13,NULL,130954.45,'2024-01-17 20:59:08',NULL,144444,13489.55,'CIERRE','PRINCIPAL',1,1),(14,'',NULL,'2024-01-17 21:14:00',5550,NULL,NULL,'APERTURA','PRINCIPAL',1,1),(15,'',NULL,'2024-01-17 21:14:12',2654,NULL,NULL,'EGRESO','PRINCIPAL',1,1),(16,NULL,354,'2024-01-17 21:16:38',NULL,10000,9646,'CIERRE','PRINCIPAL',1,1),(17,'',NULL,'2024-01-18 00:25:43',0,NULL,NULL,'APERTURA','PRINCIPAL',1,1),(18,NULL,0,'2024-01-18 19:23:51',NULL,0,0,'CIERRE','PRINCIPAL',1,1),(19,'',NULL,'2024-01-18 19:25:51',5000,NULL,NULL,'APERTURA','PRINCIPAL',1,1),(20,'Anticipo de cliente',NULL,'2024-01-18 19:27:55',800,NULL,NULL,'INGRESO','PRINCIPAL',1,1),(21,'Pago proveedor',NULL,'2024-01-18 19:28:17',500,NULL,NULL,'EGRESO','PRINCIPAL',1,1),(22,NULL,-186.5,'2024-01-18 19:30:30',NULL,6000,6186.5,'CIERRE','PRINCIPAL',1,1);
/*!40000 ALTER TABLE `movimientoscaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `precioTotalCosto` double NOT NULL,
  `idFormaDePago` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `FKj9f41to734tao68b8250pmvmq` (`idFormaDePago`),
  KEY `FKsws6tbjam8u9tla9uot0sdmv1` (`idProveedor`),
  KEY `FK241ich8qx86pjiytatswu0cqe` (`idUsuario`),
  CONSTRAINT `FK241ich8qx86pjiytatswu0cqe` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `FKj9f41to734tao68b8250pmvmq` FOREIGN KEY (`idFormaDePago`) REFERENCES `formadepago` (`idFormaDePago`),
  CONSTRAINT `FKsws6tbjam8u9tla9uot0sdmv1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (3,'2024-01-17 20:58:13',20000,2,1,1),(4,'2024-01-18 00:26:48',12000,2,1,1),(5,'2024-01-18 00:28:14',10000,3,1,1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `precioCostoUnitario` double DEFAULT NULL,
  `precioVentaUnitario` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `UK_kxdt4u9c4w6vveo7ylph4pd09` (`codigo`),
  KEY `FK32mahme8tvtn8xid6n9carpjy` (`idCategoria`),
  CONSTRAINT `FK32mahme8tvtn8xid6n9carpjy` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'1','','Edulcorante x250ml',50,98.5,20,2),(2,'2','200 gr jamon cocido\n400 gr queso cremoso\n1 paquete de prepizza','Promo pizza 2',0,1815,-9,1),(3,'3','marca \"Paladini\"','Jamon cocido',0,0,-3,3);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `cuit` varchar(60) DEFAULT NULL,
  `direccion` varchar(120) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `telefono` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'','25 Mayo 566','Porkys',''),(2,'','','Carpe Diem','');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `acceso` int(11) NOT NULL,
  `contrasenia` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `UK_cto7dkti4t38iq8r4cqesbd8k` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,2,'202120','Nicolas');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` varchar(255) NOT NULL,
  `fecha` datetime NOT NULL,
  `precioTotalVenta` double NOT NULL,
  `idCaja` int(11) DEFAULT NULL,
  `idFormaDePago` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `FKb5wkjm9n90jbclrilgvqvj3n4` (`idCaja`),
  KEY `FKesoayaq5q6kdgvfjv2gmi8lb9` (`idFormaDePago`),
  KEY `FK8u7v8ufcs9m4uvtn7wicy6qxo` (`idUsuario`),
  CONSTRAINT `FK8u7v8ufcs9m4uvtn7wicy6qxo` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `FKb5wkjm9n90jbclrilgvqvj3n4` FOREIGN KEY (`idCaja`) REFERENCES `caja` (`idCaja`),
  CONSTRAINT `FKesoayaq5q6kdgvfjv2gmi8lb9` FOREIGN KEY (`idFormaDePago`) REFERENCES `formadepago` (`idFormaDePago`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (3,'CONSUMIDOR FINAL','2024-01-17 20:31:32',490.05,1,5,1),(4,'CONSUMIDOR FINAL','2024-01-17 20:40:38',3690.225000000001,1,6,1),(5,'CONSUMIDOR FINAL','2024-01-17 20:55:40',1558.51,1,2,1),(6,'CONSUMIDOR FINAL','2024-01-17 20:56:56',4931.04,1,4,1),(7,'CONSUMIDOR FINAL','2024-01-17 21:14:39',3300,1,3,1),(8,'CONSUMIDOR FINAL','2024-01-17 21:14:59',1650,1,6,1),(9,'CONSUMIDOR FINAL','2024-01-17 21:15:29',1800,1,8,1),(10,'CONSUMIDOR FINAL','2024-01-18 19:26:22',886.5,1,3,1);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-18 19:33:50
