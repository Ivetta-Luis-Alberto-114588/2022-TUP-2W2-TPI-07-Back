-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: heladeriaprueba2
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dni` decimal(12,0) NOT NULL,
  `nombre_apellido` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `eliminado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,38239843,'Adrian Perez','3515782901','Cochabamba 3445','adrianperez@gmail.com',0),(2,34386729,'Carla Farias','3512234782','Los Olmos 2134','carlafarias@gmail.com',0),(3,35982736,'Ana Golzalez','3516483907','Corrientes 1126','anagonzalez@gmail.com',0),(4,33245314,'Marcelo Ponce','3515465342','Illia 1620','marceloponce@gmail.com',0),(5,32765198,'Pedro Lujan','3515378231','Paraguay 3452','pedrolujan@gmail.com',0),(6,35347288,'Julieta Palacios','3513897632','Puma 2226','julietapalacios@gmail.com',0),(7,34653213,'Gonzalo Martinez','3513446254','General Paz 1315','gonzalomartinez@gmail.com',0),(8,35100344,'Romina Carbajal','3512236547','Toledo 2342','rominacarbajal@gmail.com',0),(9,38239843,'Adrianss Perez','3515782901','Cochabamba 3445','adrianperez@gmail.com',0),(10,35100341,'Juanessss','3515782901','Cochabamba 3445','adrianperez@gmail.com',0),(11,35100341,'Santis','3516007799','Av Cerro Pan de Azucar','f65d@gmail.com',0),(12,12345678,'Carlos','3516007799','Colon 1234','la@ewa.com',0),(13,35100342,'Santo Perez','3516007799','Av Cerro Pan de Azucar','f65d@gmail.com',0);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalles_compras`
--

DROP TABLE IF EXISTS `detalles_compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalles_compras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_compra` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_producto` (`id_producto`),
  KEY `id_compra` (`id_compra`),
  CONSTRAINT `detalles_compras_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`),
  CONSTRAINT `detalles_compras_ibfk_2` FOREIGN KEY (`id_compra`) REFERENCES `ordenes_compras` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles_compras`
--

LOCK TABLES `detalles_compras` WRITE;
/*!40000 ALTER TABLE `detalles_compras` DISABLE KEYS */;
INSERT INTO `detalles_compras` VALUES (1,5,20,12),(2,8,2,14),(3,8,17,30),(4,8,16,14),(5,6,11,18),(6,6,21,12),(7,7,5,8),(8,3,2,22),(9,2,18,16),(10,1,13,14),(11,9,19,25),(13,12,13,14),(15,14,13,14),(19,18,3,1),(21,20,4,1),(22,20,17,2),(24,23,8,1),(25,23,15,2),(27,26,3,1),(28,26,18,2),(30,29,3,1),(31,29,18,2),(33,32,16,1),(34,32,18,2),(36,35,3,1),(38,37,20,1),(39,37,22,2),(53,52,4,2),(54,52,18,7),(59,58,4,3),(60,58,3,2),(62,61,8,2),(63,61,17,4),(65,64,2,1),(66,64,18,2),(68,67,3,1),(70,69,17,1),(72,71,4,1),(74,73,6,1),(76,75,16,1),(78,77,2,1),(83,82,4,1),(85,84,24,1),(87,86,20,1),(89,88,3,12),(91,90,34,1),(93,92,31,1),(95,94,3,1),(97,96,9,2),(99,98,4,2),(101,100,8,2),(102,100,6,1),(104,103,3,1),(106,105,16,2);
/*!40000 ALTER TABLE `detalles_compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalles_facturas`
--

DROP TABLE IF EXISTS `detalles_facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalles_facturas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_factura` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_producto` (`id_producto`),
  KEY `id_factura` (`id_factura`),
  CONSTRAINT `detalles_facturas_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`),
  CONSTRAINT `detalles_facturas_ibfk_2` FOREIGN KEY (`id_factura`) REFERENCES `facturas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles_facturas`
--

LOCK TABLES `detalles_facturas` WRITE;
/*!40000 ALTER TABLE `detalles_facturas` DISABLE KEYS */;
INSERT INTO `detalles_facturas` VALUES (1,2,3,1),(2,2,21,2),(3,3,17,5),(4,3,35,3),(5,3,10,4),(6,5,19,2),(8,7,1,1),(9,7,17,2),(11,10,17,2),(17,16,3,1),(41,40,3,1),(42,40,17,2),(44,43,3,3),(45,43,15,2),(47,46,3,1),(48,46,18,2),(50,49,17,2),(51,49,4,2),(56,55,17,2),(57,55,6,1),(80,79,4,1),(81,79,16,1);
/*!40000 ALTER TABLE `detalles_facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `fecha` varchar(100) DEFAULT NULL,
  `monto_total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `facturas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (1,1,'01/08/2022',100.00),(2,2,'22/08/2022',700.00),(3,3,'10/09/2022',350.00),(4,4,'15/09/2022',550.00),(5,5,'04/10/2022',200.00),(6,6,'13/10/2022',600.00),(7,1,'10/11/2022',750.00),(10,5,'10/11/2022',500.00),(16,1,'10/11/2022',250.00),(40,2,'12/11/2022',750.00),(43,1,'12/11/2022',1350.00),(46,1,'12/11/2022',850.00),(49,5,'12/11/2022',1100.00),(55,5,'12/11/2022',750.00),(79,5,'13/11/2022',600.00);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (107);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marcas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (1,'Grido'),(2,'Frigor'),(3,'Eco-Jin'),(4,'Scott');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenes_compras`
--

DROP TABLE IF EXISTS `ordenes_compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenes_compras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_proveedor` int DEFAULT NULL,
  `fecha_emision` varchar(100) DEFAULT NULL,
  `fecha_fin` varchar(100) DEFAULT NULL,
  `monto_total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_proveedor` (`id_proveedor`),
  CONSTRAINT `ordenes_compras_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenes_compras`
--

LOCK TABLES `ordenes_compras` WRITE;
/*!40000 ALTER TABLE `ordenes_compras` DISABLE KEYS */;
INSERT INTO `ordenes_compras` VALUES (1,1,'01/08/2022','31/12/3999',3600.00),(2,2,'15/08/2022','31/12/3999',2400.00),(3,5,'25/08/2022','31/12/3999',1800.00),(4,6,'07/09/2022','31/12/3999',2400.00),(5,7,'16/09/2022','31/12/3999',2400.00),(6,3,'22/09/2022','31/12/3999',3300.00),(7,4,'03/10/2022','31/12/3999',4800.00),(8,3,'09/10/2022','31/12/3999',375.00),(9,4,'14/10/2022','31/12/3999',700.00),(12,1,'01/08/2022','31/12/2022',3600.00),(14,1,'01/11/2022','31/12/2022',300.00),(18,1,'11/11/2022','11/11/2022',1200.00),(20,2,'11/11/2022','11/11/2022',200.00),(23,3,'11/11/2022','11/11/2022',3000.00),(26,4,'11/11/2022','11/11/2022',3150.00),(29,4,'11/11/2022','11/11/2022',3150.00),(32,3,'11/11/2022','11/11/2022',4500.00),(35,2,'11/11/2022','11/11/2022',150.00),(37,3,'11/11/2022','11/11/2022',900.00),(52,1,'12/11/2022','12/11/2022',10700.00),(58,1,'12/11/2022','12/11/2022',600.00),(61,1,'12/11/2022','12/11/2022',600.00),(64,9,'13/11/2022','13/11/2022',3100.00),(67,3,'13/11/2022','13/11/2022',150.00),(69,5,'13/11/2022','13/11/2022',100.00),(71,2,'13/11/2022','13/11/2022',100.00),(73,8,'13/11/2022','13/11/2022',100.00),(75,2,'13/11/2022','13/11/2022',1500.00),(77,4,'13/11/2022','13/11/2022',100.00),(82,4,'13/11/2022','13/11/2022',100.00),(84,5,'13/11/2022','13/11/2022',350.00),(86,2,'13/11/2022','13/11/2022',200.00),(88,2,'13/11/2022','13/11/2022',1800.00),(90,3,'13/11/2022','13/11/2022',2500.00),(92,7,'13/11/2022','13/11/2022',11000.00),(94,3,'13/11/2022','13/11/2022',150.00),(96,3,'13/11/2022','13/11/2022',350.00),(98,2,'13/11/2022','13/11/2022',500.00),(100,2,'13/11/2022','13/11/2022',300.00),(103,2,'13/11/2022','13/11/2022',150.00),(105,4,'13/11/2022','13/11/2022',3000.00);
/*!40000 ALTER TABLE `ordenes_compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo_barra` int DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `id_tipo` int NOT NULL,
  `id_marca` int NOT NULL,
  `precio_unitario_venta` decimal(10,2) DEFAULT NULL,
  `precio_unitario_compra` decimal(10,2) DEFAULT NULL,
  `eliminado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_tipo` (`id_tipo`),
  KEY `id_marca` (`id_marca`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipos_productos` (`id`),
  CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`id_marca`) REFERENCES `marcas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,1000,'Helado de Frutilla',2,1,250.00,100.00,1),(2,1001,'Helado de Chocolate',2,1,250.00,100.00,0),(3,1002,'Helado de Vainilla',2,1,250.00,150.00,0),(4,1003,'Helado de Limon',2,1,300.00,100.00,0),(5,1004,'Helado de Crema del Cielo',2,1,300.00,100.00,0),(6,1005,'Helado de Menta Granizada',2,1,250.00,100.00,0),(7,1006,'Helado de Chocolate Blanco',2,1,300.00,150.00,0),(8,1007,'Helado de Durazno',2,1,250.00,100.00,0),(9,1008,'Helado de Frutilla al Agua',2,1,250.00,100.00,0),(10,1009,'Helado de Crema Rusa',2,1,250.00,100.00,0),(11,1010,'Helado de Sambayon',2,1,250.00,100.00,0),(12,1011,'Helado de Granizado',2,1,250.00,100.00,0),(13,1012,'Helado de Durazno al Agua',2,1,250.00,100.00,0),(14,1013,'Helado de Limon al Agua',2,1,300.00,1500.00,0),(15,1014,'Palito Bombon',2,2,300.00,1500.00,0),(16,1015,'Palito de Agua',2,2,300.00,1500.00,0),(17,1016,'Crocantes',2,2,250.00,100.00,0),(18,1017,'Torta Helada',2,2,300.00,1500.00,0),(19,1018,'Kilo de Helado',2,1,950.00,600.00,0),(20,1019,'1/2 Kilo de Helado',2,1,400.00,200.00,0),(21,1020,'1/4 Kilo de Helado',2,1,350.00,100.00,0),(22,1021,'Escoba',1,3,0.00,350.00,0),(23,1022,'Limpiador de Piso',1,3,0.00,300.00,0),(24,1023,'Mopa',1,3,0.00,350.00,0),(25,1024,'Alcohol en Gel',1,3,0.00,650.00,0),(26,1026,'Paño',1,4,0.00,3000.00,0),(27,1027,'Servilletas',3,4,0.00,3000.00,0),(28,1028,'Taza',3,4,0.00,8000.00,0),(29,1029,'Silla',3,4,0.00,3500.00,0),(30,1030,'Mesa',3,4,0.00,12000.00,0),(31,1031,'Sombrilla',3,4,0.00,11000.00,0),(32,1032,'Porta Servilleta',3,4,0.00,1500.00,0),(33,1033,'Cucharita',3,4,0.00,1500.00,0),(34,1034,'Rollo de Papel de Impresora',3,4,0.00,2500.00,0),(35,1025,'Lustra Muebles',1,3,0.00,150.00,0),(36,1035,'Palito de Crema',2,1,100.00,80.00,0),(37,1036,'Palito Bombon',2,2,320.00,160.00,0),(38,1037,'Crocante Dobles',2,2,100.00,34.00,0),(39,1033,'Crocante de Crema Americana',2,2,100.00,50.00,0),(40,1034,'Palito Frutilla',2,1,130.00,34.00,0),(41,1035,'Conogol',2,2,180.00,33.00,0),(42,1037,'conogol con Frutilla',2,2,180.00,36.00,0);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cuit` decimal(12,0) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `codigo_postal` int NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `eliminado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,26387462664,'Frigor','3534405331','25 de Mayo 5019, Córdoba',5006,'frigor@gmail.com',0),(2,27381342339,'NUSS Cucuruchos','3513125236','Alcira Arias, Malvinas Argentinas, Córdoba',5000,'nusscucuruchos@gmail.com',0),(3,24986942771,'Insulimp Articulos De Limpieza','3513342988','Av. Leandro N. Alem 79, Córdoba',5007,'insulimp@gmail.com',0),(4,27679381994,'Amoretto Helado Artesanal','3516373730','Rondeau 646, Córdoba',5010,'amoretto@gmail.com',0),(5,22355465572,'Tacu Muebles','3512407004','Buenos Aires 240, Córdoba',5000,'tacu@gmail.com',0),(6,26433668793,'Papelera Zoppetti','3514869640','Martín Cartechini 1351, Córdoba',5016,'zoppetti@gmail.com',0),(7,27365980077,'TecnoBoss','351156829416','Av. Colón 821, Córdoba',5004,'tecnoboss@gmail.com',0),(8,26387462664,'FrigorIIS','3534405331','25 de Mayo 5019, Córdoba',5006,'frigor@gmail.com',0),(9,24986942771,'Proveedor Palitosss','3513342988','Av Leandro N Alem 79 Córdoba',5003,'tacu@gmail.com',0),(10,26387462664,'Frigores','3534405331','25 de Mayo 5019, Córdoba',5006,'frigor@gmail.com',0),(11,26387462664,'Frigors','3534405331','25 de Mayo 5019, Córdoba',5006,'frigor@gmail.com',0),(12,26387462661,'Palitos SA','3534405331','Av Cerro Pan de Azucar',5105,'laivetta@gmail.com',0);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rol` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Administrador'),(2,'Caja'),(3,'Compras');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stocks`
--

DROP TABLE IF EXISTS `stocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stocks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_producto` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `stocks_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stocks`
--

LOCK TABLES `stocks` WRITE;
/*!40000 ALTER TABLE `stocks` DISABLE KEYS */;
INSERT INTO `stocks` VALUES (1,1,30),(2,2,30),(3,3,30),(4,4,30),(5,5,30),(6,6,30),(7,7,30),(8,8,30),(9,9,30),(10,10,30),(11,11,30),(12,12,30),(13,13,30),(14,14,30),(15,15,30),(16,16,30),(17,17,30),(18,18,30),(19,19,30),(20,20,30),(21,21,30),(22,22,30),(23,23,30),(24,24,30),(25,25,30),(26,26,30);
/*!40000 ALTER TABLE `stocks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_productos`
--

DROP TABLE IF EXISTS `tipos_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_productos`
--

LOCK TABLES `tipos_productos` WRITE;
/*!40000 ALTER TABLE `tipos_productos` DISABLE KEYS */;
INSERT INTO `tipos_productos` VALUES (1,'Limpieza'),(2,'Mercaderia'),(3,'Insumos');
/*!40000 ALTER TABLE `tipos_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `legajo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `eliminado` tinyint(1) DEFAULT NULL,
  `id_roles` int NOT NULL,
  PRIMARY KEY (`legajo`),
  UNIQUE KEY `UKio49vjba68pmbgpy9vtw8vm81` (`nombre`),
  KEY `id_roles` (`id_roles`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_roles`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Juan','administrador',0,1),(2,'Miguel','passmiguel',0,3),(3,'Maria','passmaria',0,2),(4,'Carla','passcarla',0,3),(5,'Agostina','passagostina',0,2),(6,'David','passdavid',0,2),(7,'luis','luis',0,1),(8,'ochossss','ocho',0,1),(9,'Marco','marco',0,2),(10,'Fedes','123',0,1),(15,'Carloss','123',0,1),(16,'Juan Carlos','1',0,1),(17,'Mario','1',0,1),(18,'Jose','1',0,2),(19,'andres','1',0,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-14 13:08:04
