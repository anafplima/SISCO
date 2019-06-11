CREATE DATABASE  IF NOT EXISTS `SISCO_NEW` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `SISCO_NEW`;
-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: SISCO_NEW
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Item`
--

DROP TABLE IF EXISTS `Item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Item` (
  `idItem` int(11) NOT NULL AUTO_INCREMENT,
  `idLista` int(11) DEFAULT NULL,
  `idProduto` int(11) DEFAULT NULL,
  `valorCotacao` varchar(45) DEFAULT NULL,
  `idUsuarioFornecedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idItem`),
  KEY `fk_idLista_idx` (`idLista`),
  KEY `fk_Item_1_idx` (`idProduto`),
  KEY `fk_idUsuarioFornecedor_idx` (`idUsuarioFornecedor`),
  CONSTRAINT `fk_idLista` FOREIGN KEY (`idLista`) REFERENCES `Lista` (`idLista`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_idProduto` FOREIGN KEY (`idProduto`) REFERENCES `Produto` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idUsuarioFornecedor` FOREIGN KEY (`idUsuarioFornecedor`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Item`
--

LOCK TABLES `Item` WRITE;
/*!40000 ALTER TABLE `Item` DISABLE KEYS */;
/*!40000 ALTER TABLE `Item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Lista`
--

DROP TABLE IF EXISTS `Lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Lista` (
  `idLista` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuarioCliente` int(11) NOT NULL,
  `nomeLista` varchar(45) NOT NULL,
  `dataCotacao` datetime DEFAULT NULL,
  `totalCotacao` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`idLista`),
  KEY `fk_Lista_1_idx` (`idUsuarioCliente`),
  CONSTRAINT `fk_idUsuario_idUsuarioCliente` FOREIGN KEY (`idUsuarioCliente`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lista`
--

LOCK TABLES `Lista` WRITE;
/*!40000 ALTER TABLE `Lista` DISABLE KEYS */;
/*!40000 ALTER TABLE `Lista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Produto`
--

DROP TABLE IF EXISTS `Produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `peso` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Produto`
--

LOCK TABLES `Produto` WRITE;
/*!40000 ALTER TABLE `Produto` DISABLE KEYS */;
INSERT INTO `Produto` VALUES (1,'ARROZ','5 kg'),(2,'FEIJÃO','1 kg'),(3,'MACARRÃO','500 g'),(4,'ÓLEO','1 l'),(5,'FARINHA DE TRIGO','1 kg'),(6,'ACHOCOLATADO','500 g'),(7,'AÇÚCAR','1 kg'),(8,'PÓ DE CAFÉ','500 g'),(9,'LEITE CONDENSADO','395 ml'),(10,'LEITE','1 l'),(11,'REFRIGERANTE','2 l'),(12,'ÁGUA','500 ml'),(13,'SUCO','1 l'),(14,'IOGURTE','1 l'),(15,'MAIONESE','500 g'),(16,'MARGARINA','500 ml'),(17,'FERMENTO','250 g'),(18,'SAL','1 kg'),(19,'DESINFETANTE','2 l'),(20,'ÁGUA SANITÁRIA','2 l');
/*!40000 ALTER TABLE `Produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `cep` int(11) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (4,'ana','ana','ana',123,'AC','ana@ana.com','ana','Fornecedor'),(6,'glenda','glenda','glenda',123,'AC','glenda@glenda.com','glenda','Fornecedor'),(10,'thayane','thayane','thayane',123,'AC','thayane@thayane.com','thayane','Fornecedor'),(16,'mario','mario','mario',456,'AC','mario@mario.com','mario','Cliente');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ValorProduto`
--

DROP TABLE IF EXISTS `ValorProduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ValorProduto` (
  `idValorProduto` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuarioFornecedor` int(11) DEFAULT NULL,
  `idProduto` int(11) DEFAULT NULL,
  `valorProduto` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`idValorProduto`),
  KEY `idProduto_idx` (`idProduto`),
  KEY `fk_ValorProduto_Usuario1_idx` (`idUsuarioFornecedor`),
  CONSTRAINT `fk_ValorProduto_Usuario1` FOREIGN KEY (`idUsuarioFornecedor`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idProduto` FOREIGN KEY (`idProduto`) REFERENCES `Produto` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ValorProduto`
--

LOCK TABLES `ValorProduto` WRITE;
/*!40000 ALTER TABLE `ValorProduto` DISABLE KEYS */;
INSERT INTO `ValorProduto` VALUES (3,4,19,6.70),(6,4,1,5.50),(7,4,8,3.25),(8,10,6,2.00),(9,10,7,5.00),(10,10,12,8.00),(11,10,20,6.00),(12,10,1,4.00),(13,10,19,5.00),(15,6,6,1.00),(16,6,7,2.00),(17,6,12,5.00),(18,6,20,6.00),(19,6,1,3.00),(20,6,19,7.00),(21,6,5,5.00),(22,6,2,9.00),(23,6,17,8.00);
/*!40000 ALTER TABLE `ValorProduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'SISCO_NEW'
--

--
-- Dumping routines for database 'SISCO_NEW'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-09 19:16:47
