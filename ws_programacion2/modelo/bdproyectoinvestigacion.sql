-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: bdproyectoinvestigacion
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
-- Table structure for table `investigador`
--

DROP TABLE IF EXISTS `investigador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `investigador` (
  `idinvestigador` int NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `universidad` varchar(40) DEFAULT NULL,
  `direccion` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `postgrado_idpostgrado` int NOT NULL,
  `nacionalidad` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`idinvestigador`),
  KEY `fk_investigador_postgrado_idx` (`postgrado_idpostgrado`),
  CONSTRAINT `fk_investigador_postgrado` FOREIGN KEY (`postgrado_idpostgrado`) REFERENCES `postgrado` (`idpostgrado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investigador`
--

LOCK TABLES `investigador` WRITE;
/*!40000 ALTER TABLE `investigador` DISABLE KEYS */;
INSERT INTO `investigador` VALUES (1,'Carolina Gomez','Universidad del Quindío','Cra 12 #45-10','caro24@hotmail.com',1,'colombiano'),(2,'Carlos Sanchez','Universidad del Quindío','Cra 14 #','csanchez@gmail.com',3,'colombiano'),(3,'Miguel Angel Rico','Universidad del Cauca','Ed. Santa Monica Apto 202','mangelri@yahoo.es',4,'colombiano'),(4,'Andrea Zapata','Universidad del Cauca','Calle 25 # 15-10','andreazapata@uniquindio.edu.co',3,'colombiano'),(5,'Manuel Gomez','Universidad EAFIT','Cra 20 #12-12','manuelfergo@gmail.com',4,'colombiano');
/*!40000 ALTER TABLE `investigador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante`
--

DROP TABLE IF EXISTS `participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participante` (
  `idparticipante` int NOT NULL,
  `investigador_idinvestigador` int NOT NULL,
  `rol_idrol` int NOT NULL,
  `proyecto_idproyecto` int NOT NULL,
  PRIMARY KEY (`idparticipante`),
  KEY `fk_participante_investigador1_idx` (`investigador_idinvestigador`),
  KEY `fk_participante_rol1_idx` (`rol_idrol`),
  KEY `fk_participante_proyecto1_idx` (`proyecto_idproyecto`),
  CONSTRAINT `fk_participante_investigador1` FOREIGN KEY (`investigador_idinvestigador`) REFERENCES `investigador` (`idinvestigador`),
  CONSTRAINT `fk_participante_proyecto1` FOREIGN KEY (`proyecto_idproyecto`) REFERENCES `proyecto` (`idproyecto`),
  CONSTRAINT `fk_participante_rol1` FOREIGN KEY (`rol_idrol`) REFERENCES `rol` (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante`
--

LOCK TABLES `participante` WRITE;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
INSERT INTO `participante` VALUES (4,3,2,2),(5,4,2,2),(6,1,1,2);
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postgrado`
--

DROP TABLE IF EXISTS `postgrado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postgrado` (
  `idpostgrado` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpostgrado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postgrado`
--

LOCK TABLES `postgrado` WRITE;
/*!40000 ALTER TABLE `postgrado` DISABLE KEYS */;
INSERT INTO `postgrado` VALUES (1,'Especializacion'),(2,'Maestria'),(3,'Doctorado'),(4,'PostDoctorado');
/*!40000 ALTER TABLE `postgrado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idproducto` int DEFAULT NULL,
  `nombre` text,
  `codigo` int DEFAULT NULL,
  `valorU` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'dolex',123,3000,5),(2,'algodon',456,20000,3),(3,'guantes',789,10000,2),(4,'vitamina c',101,7000,2),(5,'helado',354,4000,1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto` (
  `idproyecto` int NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `totalPresupuesto` double(15,2) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  PRIMARY KEY (`idproyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (2,'Laboratorio robótica',120000000000.00,'2008-12-01','2010-12-01'),(3,'Red de alta velocidad RENATA ',130000000000.00,'2007-01-01','2009-01-01'),(4,'Componentes para realidad aumentada ',140000000000.00,'2007-01-01','2009-01-01');
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idrol` int NOT NULL,
  `descripcion` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Auxiliar'),(2,'Coinvestigadro'),(3,'Investigador Principal'),(4,'Joven Investigador');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-27 22:54:27
