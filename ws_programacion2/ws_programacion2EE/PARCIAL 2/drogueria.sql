CREATE DATABASE  IF NOT EXISTS `drogueria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `drogueria`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: drogueria
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `cedula` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `pago` double NOT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'maria','1091004788','3226135755','armenia','maria@gmail.com',100000),(2,'juan','1092546754','3756768768','calarca','juan@gmail.com',3000),(3,'daniel','1093576567','3568575687','armenia','daniel@gmail.com',4000),(4,'samuel','1094567568','3656856436','armenia','samuel@gmail.com',5000),(5,'santiago','1095656788','3566876589','cali','santiago@gmail.com',6000),(6,'sergio','1096654734','3765758887','pereira','sergio@gmail.com',4000),(7,'simon','1097365477','3756786799','filandia','simon@gmail.com',8000),(8,'sebastian','1098736664','3868679897','pereira','sebastian@gmail.com',4000),(12,'mario','1090324555','3868569685','pijao','mario@gmail.com',10000);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domicilio`
--

DROP TABLE IF EXISTS `domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domicilio` (
  `iddomicilio` int NOT NULL AUTO_INCREMENT,
  `cliente_idcliente` int NOT NULL,
  `producto_idproducto` int NOT NULL,
  `empleado_idempleado` int NOT NULL,
  `codigo` varchar(100) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `costo` double DEFAULT NULL,
  PRIMARY KEY (`iddomicilio`),
  KEY `fk_domicilio_cliente_idx` (`cliente_idcliente`),
  KEY `fk_domicilio_producto1_idx` (`producto_idproducto`),
  KEY `fk_domicilio_empleado1_idx` (`empleado_idempleado`),
  CONSTRAINT `fk_domicilio_cliente` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `fk_domicilio_empleado1` FOREIGN KEY (`empleado_idempleado`) REFERENCES `empleado` (`idempleado`),
  CONSTRAINT `fk_domicilio_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
INSERT INTO `domicilio` VALUES (1,3,4,2,'001','2022-03-01','medellin',5000),(2,2,2,3,'002','2022-03-01','calarca',4000),(3,4,3,1,'003','2022-03-02','armenia',1000),(4,1,1,4,'004','2022-03-02','armenia',2000),(5,6,7,5,'005','2022-03-03','calarca',6000),(6,7,5,6,'006','2022-03-03','armenia',30000),(7,5,6,7,'007','2022-03-04','quimbaya',2000);
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idempleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `cedula` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  PRIMARY KEY (`idempleado`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'manuel','1290','3456','manuel@gmail.com',10000),(2,'sebastian','1291','3457','sebastian@gmail.com',30000),(3,'daniel','1292','3458','daniel@gmail.com',21000),(4,'sara','1293','3459','sara@gmail.com',23000),(5,'gabriela','1294','3451','gabriela@gmail.com',45000),(6,'samara','1295','3452','samara@gmail.com',4000),(7,'teresa','1296','3453','teresa@gmail.com',32000);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idproducto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `codigo` varchar(100) NOT NULL,
  `valorUnidad` double NOT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'dolex','1092',2000,1),(2,'guantes','1093',4000,2),(3,'gasa ','1094',1000,1),(4,'vitaminaC','1095',5000,2),(5,'loratadina','1096',2000,2),(6,'crema','1097',30000,1),(7,'cepillo','1098',5000,3);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-04 22:32:46
