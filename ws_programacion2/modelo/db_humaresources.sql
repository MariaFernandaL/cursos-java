CREATE DATABASE  IF NOT EXISTS `humaresources` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `humaresources`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: humaresources
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
-- Table structure for table `countrie`
--

DROP TABLE IF EXISTS `countrie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countrie` (
  `idCountrie` int NOT NULL,
  `countryName` varchar(45) NOT NULL,
  `Region_idRegion` int NOT NULL,
  PRIMARY KEY (`idCountrie`),
  KEY `fk_Countrie_Region1_idx` (`Region_idRegion`),
  CONSTRAINT `fk_Countrie_Region1` FOREIGN KEY (`Region_idRegion`) REFERENCES `region` (`idRegion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countrie`
--

LOCK TABLES `countrie` WRITE;
/*!40000 ALTER TABLE `countrie` DISABLE KEYS */;
INSERT INTO `countrie` VALUES (1,'Quindio',1),(2,'Risaralda',1),(3,'Valle del Cauca',1),(4,'Cauca',1),(5,'Antioquia',1);
/*!40000 ALTER TABLE `countrie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departament`
--

DROP TABLE IF EXISTS `departament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departament` (
  `idDepartament` int NOT NULL,
  `departmentName` varchar(45) NOT NULL,
  `idEmployee` int DEFAULT NULL,
  `idLocation` int NOT NULL,
  PRIMARY KEY (`idDepartament`),
  KEY `fk_Departament_employee_idx` (`idEmployee`) /*!80000 INVISIBLE */,
  KEY `fk_Departament_Location1_idx` (`idLocation`),
  CONSTRAINT `fk_Departament_employee` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`idEmployee`),
  CONSTRAINT `fk_Departament_Location1` FOREIGN KEY (`idLocation`) REFERENCES `location` (`idLocation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departament`
--

LOCK TABLES `departament` WRITE;
/*!40000 ALTER TABLE `departament` DISABLE KEYS */;
INSERT INTO `departament` VALUES (10,'Administracion',NULL,1),(20,'Marketing',NULL,1),(30,'Ventas',NULL,1),(40,'Recursoso humanos',NULL,1),(50,'Envio',NULL,1),(60,'IT',NULL,2),(70,'Relaciones publicas',NULL,2),(80,'Ofertas',NULL,1),(90,'Ejecutivo',NULL,3),(100,'Finanzas',NULL,2),(110,'Contabilidad',NULL,1),(140,'Control y credito',NULL,1),(160,'Benefits',NULL,1),(170,'Manufacturing',NULL,1),(180,'Construction',NULL,1),(190,'Contracting',NULL,2),(200,'Operations',NULL,1),(210,'IT Support',NULL,1),(220,'NOC',NULL,1),(230,'IT Helpdesk',NULL,1),(240,'Government Sales',NULL,2),(250,'Retail Sales',NULL,4),(260,'Recruiting',NULL,5),(270,'Payroll',NULL,1);
/*!40000 ALTER TABLE `departament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `idEmployee` int NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(70) DEFAULT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  `hireDate` date DEFAULT NULL,
  `comisionPCT` varchar(45) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `idJob` int NOT NULL,
  `idDepartament` int NOT NULL,
  PRIMARY KEY (`idEmployee`),
  KEY `fk_Employee_Departament_idx` (`idDepartament`),
  KEY `fk_employee_Job1_idx` (`idJob`),
  CONSTRAINT `fk_Employee_Departament` FOREIGN KEY (`idDepartament`) REFERENCES `departament` (`idDepartament`),
  CONSTRAINT `fk_employee_Job1` FOREIGN KEY (`idJob`) REFERENCES `job` (`idJob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (100,'Steven','King','SKING','515.123.4567','2017-06-03','AD_PRES',24000,1,90),(101,'Neena','Kochhar','NKOCHHAR','515.123.4568','2021-09-05','AD_VP',17000,1,90),(102,'Lex','De Haan','LDEHAAN','515.123.4569','2013-01-01','AD_VP',17000,1,90),(103,'Alexander','Hunold','AHUNOLD','590.423.4567','2003-01-06','IT_PROG',9000,1,60),(104,'Bruce','Ernst','BERNST','590.423.4568','2021-05-07','IT_PROG',6000,1,60),(105,'David','Austin','DAUSTIN','590.423.4569','2025-06-05','IT_PROG',4800,1,60),(106,'Valli','Pataballa','VPATABAL','590.423.4560','2005-02-06','IT_PROG',4800,1,60),(107,'Diana','Lorentz','DLORENTZ','590.423.5567','2007-02-07','IT_PROG',4200,1,60),(108,'Nancy','Greenberg','NGREENBE','515.124.4569','2017-08-02','FI_MGR',12008,1,100),(109,'Daniel','Faviet','DFAVIET','515.124.4169','2016-08-02','FI_ACCOUNT',9000,1,100),(110,'John','Chen','JCHEN','515.124.4269','2028-09-05','FI_ACCOUNT',8200,1,100),(111,'Ismael','Sciarra','ISCIARRA','515.124.4369','2030-09-05','FI_ACCOUNT',7700,1,100),(112,'Jose Manuel','Urman','JMURMAN','515.124.4469','2007-03-06','FI_ACCOUNT',7800,1,100),(113,'Luis','Popp','LPOPP','515.124.4567','2007-12-07','FI_ACCOUNT',6900,2,100),(114,'Den','Raphaely','DRAPHEAL','515.127.4561','2007-12-02','PU_MAN',11000,2,30),(115,'Alexander','Khoo','AKHOO','515.127.4562','2018-05-03','PU_CLERK',3100,2,30),(116,'Shelli','Baida','SBAIDA','515.127.4563','2024-12-05','PU_CLERK',2900,2,30),(117,'Sigal','Tobias','STOBIAS','515.127.4564','2024-07-05','PU_CLERK',2800,2,30),(118,'Guy','Himuro','GHIMURO','515.127.4565','2015-11-06','PU_CLERK',2600,2,30),(119,'Karen','Colmenares','KCOLMENA','515.127.4566','2010-08-07','PU_CLERK',2500,2,30),(120,'Matthew','Weiss','MWEISS','650.123.1234','2018-07-04','ST_MAN',8000,2,50),(121,'Adam','Fripp','AFRIPP','650.123.2234','2010-04-05','ST_MAN',8200,2,50),(122,'Payam','Kaufling','PKAUFLIN','650.123.3234','2001-05-03','ST_MAN',7900,2,50),(123,'Shanta','Vollman','SVOLLMAN','650.123.4234','2010-10-05','ST_MAN',6500,2,50),(124,'Kevin','Mourgos','KMOURGOS','650.123.5234','2016-11-07','ST_MAN',5800,2,50),(125,'Julia','Nayer','JNAYER','650.124.1214','2016-07-05','ST_CLERK',3200,2,50),(126,'Irene','Mikkilineni','IMIKKILI','650.124.1224','2028-09-06','ST_CLERK',2700,2,50),(127,'James','Landry','JLANDRY','650.124.1334','2014-01-07','ST_CLERK',2400,2,50),(128,'Steven','Markle','SMARKLE','650.124.1434','2008-03-08','ST_CLERK',2200,2,50),(129,'Laura','Bissot','LBISSOT','650.124.5234','2020-08-05','ST_CLERK',3300,3,50),(130,'Mozhe','Atkinson','MATKINSO','650.124.6234','2030-10-05','ST_CLERK',2800,3,50),(131,'James','Marlow','JAMRLOW','650.124.7234','2016-02-05','ST_CLERK',2500,3,50),(132,'TJ','Olson','TJOLSON','650.124.8234','2010-04-07','ST_CLERK',2100,3,50),(133,'Jason','Mallin','JMALLIN','650.127.1934','2014-06-04','ST_CLERK',3300,3,50),(134,'Michael','Rogers','MROGERS','650.127.1834','2026-08-06','ST_CLERK',2900,3,50),(135,'Ki','Gee','KGEE','650.127.1734','2012-12-07','ST_CLERK',2400,3,50),(136,'Hazel','Philtanker','HPHILTAN','650.127.1634','2006-02-08','ST_CLERK',2200,4,50),(137,'Renske','Ladwig','RLADWIG','650.121.1234','2014-07-03','ST_CLERK',3600,4,50),(138,'Stephen','Stiles','SSTILES','650.121.2034','2026-10-05','ST_CLERK',3200,4,50),(139,'John','Seo','JSEO','650.121.2019','2012-02-06','ST_CLERK',2700,4,50),(140,'Joshua','Patel','JPATEL','650.121.1834','2006-04-06','ST_CLERK',2500,4,50),(141,'Trenna','Rajs','TRAJS','650.121.8009','2017-10-03','ST_CLERK',3500,4,50),(142,'Curtis','Davies','CDAVIES','650.121.2994','2029-01-05','ST_CLERK',3100,4,50),(143,'Randall','Matos','RMATOS','650.121.2874','2015-03-06','ST_CLERK',2600,4,50),(144,'Peter','Vargas','PVARGAS','650.121.2004','2009-07-06','ST_CLERK',2500,4,50),(145,'John','Russell','JRUSSEL','011.44.1344.429268','2001-10-04','SA_MAN',14000,4,80),(146,'Karen','Partners','KPARTNER','011.44.1344.467268','2005-01-05','SA_MAN',13500,4,80),(147,'Alberto','Errazuriz','AERRAZUR','011.44.1344.429278','2010-03-05','SA_MAN',12000,5,80),(148,'Gerald','Cambrault','GCAMBRAU','011.44.1344.619268','2015-10-07','SA_MAN',11000,4,80),(149,'Eleni','Zlotkey','EZLOTKEY','011.44.1344.429018','2029-01-08','SA_MAN',10500,5,80),(150,'Peter','Tucker','PTUCKER','011.44.1344.129268','2030-01-05','SA_REP',10000,5,80),(151,'David','Bernstein','DBERNSTE','011.44.1344.345268','2024-03-05','SA_REP',9500,5,80),(152,'Peter','Hall','PHALL','011.44.1344.478968','2020-08-05','SA_REP',9000,5,80),(153,'Christopher','Olsen','COLSEN','011.44.1344.498718','2030-03-06','SA_REP',8000,1,80),(154,'Nanette','Cambrault','NCAMBRAU','011.44.1344.987668','2009-12-06','SA_REP',7500,1,80),(155,'Oliver','Tuvault','OTUVAULT','011.44.1344.486508','2023-11-07','SA_REP',7000,1,80),(156,'Janette','King','JKING','011.44.1345.429268','2030-01-04','SA_REP',10000,1,80),(157,'Patrick','Sully','PSULLY','011.44.1345.929268','2004-03-04','SA_REP',9500,1,80),(158,'Allan','McEwen','AMCEWEN','011.44.1345.829268','2001-08-04','SA_REP',9000,1,80),(159,'Lindsey','Smith','LSMITH','011.44.1345.729268','2010-03-05','SA_REP',8000,1,80),(160,'Louise','Doran','LDORAN','011.44.1345.629268','2015-12-05','SA_REP',7500,1,80),(161,'Sarath','Sewall','SSEWALL','011.44.1345.529268','2003-11-06','SA_REP',7000,1,80),(162,'Clara','Vishney','CVISHNEY','011.44.1346.129268','2011-11-05','SA_REP',10500,2,80),(163,'Danielle','Greene','DGREENE','011.44.1346.229268','2019-03-07','SA_REP',9500,2,80),(164,'Mattea','Marvins','MMARVINS','011.44.1346.329268','2024-01-08','SA_REP',7200,2,80),(165,'David','Lee','DLEE','011.44.1346.529268','2023-02-08','SA_REP',6800,2,80),(166,'Sundar','Ande','SANDE','011.44.1346.629268','2024-03-08','SA_REP',6400,2,80),(167,'Amit','Banda','ABANDA','011.44.1346.729268','2021-04-08','SA_REP',6200,2,80),(168,'Lisa','Ozer','LOZER','011.44.1343.929268','2011-03-05','SA_REP',11500,2,80),(169,'Harrison','Bloom','HBLOOM','011.44.1343.829268','2023-03-06','SA_REP',10000,1,80),(170,'Tayler','Fox','TFOX','011.44.1343.729268','2024-01-06','SA_REP',9600,1,80),(171,'William','Smith','WSMITH','011.44.1343.629268','2023-02-07','SA_REP',7400,1,80),(172,'Elizabeth','Bates','EBATES','011.44.1343.529268','2024-03-07','SA_REP',7300,1,80),(173,'Sundita','Kumar','SKUMAR','011.44.1343.329268','2021-04-08','SA_REP',6100,1,80),(175,'Alyssa','Hutton','AHUTTON','011.44.1644.429266','2019-03-05','SA_REP',8800,2,80),(176,'Jonathon','Taylor','JTAYLOR','011.44.1644.429265','2024-03-06','SA_REP',8600,2,80),(177,'Jack','Livingston','JLIVINGS','011.44.1644.429264','2023-04-06','SA_REP',8400,2,80),(178,'Kimberely','Grant','KGRANT','011.44.1644.429263','2024-05-07','SA_REP',7000,2,80),(179,'Charles','Johnson','CJOHNSON','011.44.1644.429262','2004-01-08','SA_REP',2,3,80),(180,'Winston','Taylor','WTAYLOR','650.507.9876','2024-01-06','SH_CLERK',3200,4,50),(181,'Jean','Fleaur','JFLEAUR','650.507.9877','2023-02-06','SH_CLERK',3100,4,50),(182,'Martha','Sullivan','MSULLIVA','650.507.9878','2021-06-07','SH_CLERK',2500,4,50),(183,'Girard','Geoni','GGEONI','650.507.9879','2003-02-08','SH_CLERK',2800,4,50),(184,'Nandita','Sarchand','NSARCHAN','650.509.1876','2027-01-04','SH_CLERK',4200,4,50),(185,'Alexis','Bull','ABULL','650.509.2876','2020-02-05','SH_CLERK',4100,4,50),(186,'Julia','Dellinger','JDELLING','650.509.3876','2024-06-06','SH_CLERK',3400,1,50),(187,'Anthony','Cabrio','ACABRIO','650.509.4876','2007-02-07','SH_CLERK',3000,2,50),(188,'Kelly','Chung','KCHUNG','650.505.1876','2014-06-05','SH_CLERK',3800,3,50),(189,'Jennifer','Dilly','JDILLY','650.505.2876','2013-08-05','SH_CLERK',3600,4,50),(190,'Timothy','Gates','TGATES','650.505.3876','2011-07-06','SH_CLERK',2900,5,50),(191,'Randall','Perkins','RPERKINS','650.505.4876','2019-12-07','SH_CLERK',2500,5,50),(192,'Sarah','Bell','SBELL','650.501.1876','2004-02-04','SH_CLERK',4000,5,50),(193,'Britney','Everett','BEVERETT','650.501.2876','2003-03-05','SH_CLERK',3900,5,50),(194,'Samuel','McCain','SMCCAIN','650.501.3876','2001-07-06','SH_CLERK',3200,5,50),(195,'Vance','Jones','VJONES','650.501.4876','2017-03-07','SH_CLERK',2800,5,50),(196,'Alana','Walsh','AWALSH','650.507.9811','2024-04-06','SH_CLERK',3100,5,50),(197,'Kevin','Feeney','KFEENEY','650.507.9822','2023-05-06','SH_CLERK',3000,5,50),(198,'Donald','OConnell','DOCONNEL','650.507.9833','2021-06-07','SH_CLERK',2600,5,50),(199,'Douglas','Grant','DGRANT','650.507.9844','2013-01-08','SH_CLERK',2600,5,50),(200,'Jennifer','Whalen','JWHALEN','515.123.4444','2017-09-03','AD_ASST',4400,5,10),(201,'Michael','Hartstein','MHARTSTE','515.123.5555','2017-02-04','MK_MAN',13000,5,20),(202,'Pat','Fay','PFAY','603.123.6666','2017-08-05','MK_REP',6000,6,20),(203,'Susan','Mavris','SMAVRIS','515.123.7777','2007-06-02','HR_REP',6500,6,40),(204,'Hermann','Baer','HBAER','515.123.8888','2007-06-02','PR_REP',10000,7,70),(205,'Shelley','Higgins','SHIGGINS','515.123.8080','2007-06-02','AC_MGR',12008,1,110),(206,'William','Gietz','WGIETZ','515.123.8181','2007-06-02','AC_ACCOUNT',8300,7,110);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `idJob` int NOT NULL,
  `jobTitle` varchar(45) DEFAULT NULL,
  `minSalary` int DEFAULT NULL,
  `maxSalary` int DEFAULT NULL,
  PRIMARY KEY (`idJob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'Cajero',20080,40000),(2,'Asesor',15000,30000),(3,'Auxiliar administrativo',3000,6000),(4,'Gerente',8200,16000),(5,'Subgerente',4200,9000),(6,'Vigilante',6000,20080),(7,'Aseadora',2500,5500);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_history`
--

DROP TABLE IF EXISTS `job_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_history` (
  `idJob_History` int NOT NULL,
  `startDate` varchar(45) DEFAULT NULL,
  `endDate` varchar(45) DEFAULT NULL,
  `employeeEmail` varchar(45) DEFAULT NULL,
  `idDepartament` int NOT NULL,
  `idEmployee` int NOT NULL,
  `idJob` int NOT NULL,
  PRIMARY KEY (`idJob_History`),
  KEY `fk_Job_History_Departament1_idx` (`idDepartament`),
  KEY `fk_Job_History_employee1_idx` (`idEmployee`),
  KEY `fk_Job_History_Job1_idx` (`idJob`),
  CONSTRAINT `fk_Job_History_Departament1` FOREIGN KEY (`idDepartament`) REFERENCES `departament` (`idDepartament`),
  CONSTRAINT `fk_Job_History_employee1` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`idEmployee`),
  CONSTRAINT `fk_Job_History_Job1` FOREIGN KEY (`idJob`) REFERENCES `job` (`idJob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_history`
--

LOCK TABLES `job_history` WRITE;
/*!40000 ALTER TABLE `job_history` DISABLE KEYS */;
INSERT INTO `job_history` VALUES (1,'01-01-13','24-12-16',NULL,60,102,1),(2,'21-09-97','27-10-01',NULL,110,101,1),(3,'28-10-01','15-03-05',NULL,110,101,1),(4,'17-02-04','19-12-07\'',NULL,20,201,2),(5,'24-03-06','31-12-07',NULL,50,114,3),(6,'01-01-07','31-12-07',NULL,50,122,2),(7,'17-09-95','17-06-01',NULL,90,200,4),(8,'24-03-06','31-12-06',NULL,80,176,1),(9,'01-01-07','31-12-07',NULL,80,176,4),(10,'01-07-02','31-12-06',NULL,90,200,4);
/*!40000 ALTER TABLE `job_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `idLocation` int NOT NULL,
  `streetAddress` varchar(100) NOT NULL,
  `postalCode` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `stateProvince` varchar(45) DEFAULT NULL,
  `Countrie_idCountrie` int NOT NULL,
  PRIMARY KEY (`idLocation`),
  KEY `fk_Location_Countrie1_idx` (`Countrie_idCountrie`),
  CONSTRAINT `fk_Location_Countrie1` FOREIGN KEY (`Countrie_idCountrie`) REFERENCES `countrie` (`idCountrie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Carrera 46','630001','armenia','armenia',1),(2,'Carrera 20','630001','armenia','armenia',1),(3,'Carrera 88','630001','armenia','armenia',1),(4,'Calle 25','631001','circasia','circasia',1),(5,'Carrera 10','631020','salento','salento',1);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `region` (
  `idRegion` int NOT NULL,
  `regionName` varchar(45) NOT NULL,
  PRIMARY KEY (`idRegion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'Cafetera'),(2,'Amazonia'),(3,'Llanera'),(4,'Costa'),(5,'Capital');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-16 15:15:32
