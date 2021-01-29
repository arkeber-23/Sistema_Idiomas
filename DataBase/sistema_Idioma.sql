-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_idioma
-- ------------------------------------------------------
-- Server version	5.6.49-log

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
-- Table structure for table `tab_cursos`
--

DROP TABLE IF EXISTS `tab_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_cursos` (
  `ID_CURSO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DOCENTES` int(11) DEFAULT NULL,
  `NIVEL` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_CURSO`),
  KEY `FK_REFERENCE_3` (`ID_DOCENTES`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`ID_DOCENTES`) REFERENCES `tab_docentes` (`ID_DOCENTES`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_cursos`
--

LOCK TABLES `tab_cursos` WRITE;
/*!40000 ALTER TABLE `tab_cursos` DISABLE KEYS */;
INSERT INTO `tab_cursos` VALUES (10,5,'A1');
/*!40000 ALTER TABLE `tab_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_docentes`
--

DROP TABLE IF EXISTS `tab_docentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_docentes` (
  `ID_DOCENTES` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `APELLIDO` varchar(30) DEFAULT NULL,
  `CEDULA` varchar(10) DEFAULT NULL,
  `DIRECION` varchar(100) DEFAULT NULL,
  `TELEFONO` varchar(10) DEFAULT NULL,
  `EDAD` varchar(2) DEFAULT NULL,
  `TITULO` varchar(30) DEFAULT NULL,
  `GENERO` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_DOCENTES`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_docentes`
--

LOCK TABLES `tab_docentes` WRITE;
/*!40000 ALTER TABLE `tab_docentes` DISABLE KEYS */;
INSERT INTO `tab_docentes` VALUES (5,'Mari','Sanchez','1000000001','San Lorenzo','0999999991','24','Ingeniero/a','Masculino');
/*!40000 ALTER TABLE `tab_docentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_estudiantes`
--

DROP TABLE IF EXISTS `tab_estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_estudiantes` (
  `ID_ESTU` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CURSO` int(11) DEFAULT NULL,
  `NOMBRE` varchar(20) DEFAULT NULL,
  `APELLIDO` varchar(30) DEFAULT NULL,
  `CEDULA` varchar(10) DEFAULT NULL,
  `DIRECCION` varchar(100) DEFAULT NULL,
  `TELEFONO` varchar(10) DEFAULT NULL,
  `EDAD` varchar(2) DEFAULT NULL,
  `GENERO` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_ESTU`),
  KEY `FK_REFERENCE_8` (`ID_CURSO`),
  CONSTRAINT `FK_REFERENCE_8` FOREIGN KEY (`ID_CURSO`) REFERENCES `tab_cursos` (`ID_CURSO`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_estudiantes`
--

LOCK TABLES `tab_estudiantes` WRITE;
/*!40000 ALTER TABLE `tab_estudiantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_notas`
--

DROP TABLE IF EXISTS `tab_notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tab_notas` (
  `ID_NOTA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DOCENTES` int(11) DEFAULT NULL,
  `ID_CURSO` int(11) DEFAULT NULL,
  `ID_ESTU` int(11) DEFAULT NULL,
  `NOTA` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`ID_NOTA`),
  KEY `FK_REFERENCE_4` (`ID_DOCENTES`),
  KEY `FK_REFERENCE_6` (`ID_CURSO`),
  KEY `FK_REFERENCE_7` (`ID_ESTU`),
  CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`ID_DOCENTES`) REFERENCES `tab_docentes` (`ID_DOCENTES`),
  CONSTRAINT `FK_REFERENCE_6` FOREIGN KEY (`ID_CURSO`) REFERENCES `tab_cursos` (`ID_CURSO`),
  CONSTRAINT `FK_REFERENCE_7` FOREIGN KEY (`ID_ESTU`) REFERENCES `tab_estudiantes` (`ID_ESTU`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_notas`
--

LOCK TABLES `tab_notas` WRITE;
/*!40000 ALTER TABLE `tab_notas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_notas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-29 14:24:35
