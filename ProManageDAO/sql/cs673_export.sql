CREATE DATABASE  IF NOT EXISTS `cs673` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cs673`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: cs673
-- ------------------------------------------------------
-- Server version	5.5.23

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
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `idproject` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  `last_modified_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproject`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'ProManage','Groups Tool','2014-09-19','2014-12-04','2015-01-01 04:59:59',1,'2015-01-01 04:59:59',1),(4,'unitTestProject','This is a unit test project','2014-10-12','2014-10-12','2014-10-12 21:30:03',1,'2014-10-12 21:30:03',1),(5,'unitTestProject','This is a unit test project','2014-10-12','2014-10-12','2014-10-12 21:34:41',1,'2014-10-12 21:34:41',1),(6,'unitTestProject','This is a unit test project','2014-10-12','2014-10-12','2014-10-12 21:36:26',1,'2014-10-12 21:36:26',1),(7,'unitTestProject','This is a unit test project','2014-10-12','2014-10-12','2014-10-12 21:38:54',1,'2014-10-12 21:38:54',1),(8,'unitTestProject','This is a unit test project','2014-10-12','2014-10-12','2014-10-12 21:44:13',1,'2014-10-12 21:44:13',1),(9,'unitTestProject','This is a unit test project','2014-10-12','2014-10-12','2014-10-12 21:49:18',1,'2014-10-12 21:49:18',1),(10,'unitTestProject','This is a unit test project','2014-10-12','2014-10-12','2014-10-12 21:50:21',1,'2014-10-12 21:50:21',1),(11,'unitTestProject','This is a unit test project','2014-10-12','2014-10-12','2014-10-12 21:50:48',1,'2014-10-12 21:50:48',1),(12,'unitTestProject','This is a unit test project','2014-10-12','2014-10-12','2014-10-12 21:52:34',1,'2014-10-12 21:52:34',1),(13,'unitTestProject','This is a unit test project','2014-10-12','2014-10-12','2014-10-12 22:07:04',1,'2014-10-12 22:07:04',1);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story`
--

DROP TABLE IF EXISTS `story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `story` (
  `idstory` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  `last_modified_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`idstory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story`
--

LOCK TABLES `story` WRITE;
/*!40000 ALTER TABLE `story` DISABLE KEYS */;
/*!40000 ALTER TABLE `story` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `idtask` int(11) NOT NULL,
  PRIMARY KEY (`idtask`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'root','57845de6539c1a76be0dfa87f17e069b948e4ff166f99a341c8214bd048c9ca3eb006c8dc02ba3d604cc5d85b98fd05d5edfa1f81f07927fc6b570bfba1f33ac'),(2,'spiderman','69d508b3aeb65c170e06810b1cb530aeb0f5381a12b775028bbb2d3d5bb32a2794be2e1dc3940cef1920c93f90ab33c7c280546169799ab36ce7017c9627118b'),(3,'cyclops','7d4b83b002a19d46725716874d17391d2278cd2557cb9744ea9404cb3d90a78ad803331a0de27cb9cba4eaaa72f87503c790721cf7c471c2a119375b9300506a'),(5,'jean','14e1ea231fcc698eb43f49dbfed6338520c59865ffbb7d10d4845639640382dc8bb87828b7811581c505fc23f84a81c0e3bf949d709fb507704f0b3d161dca6d'),(6,'venom','106f7a0b246cc638f0e7f52bbc804d7ece63b847001b2f595ff3caf2a780211931f4325333dc17e75d0356c39dd0ee766e571cb8dde44200fc1ad19188b83021');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `idroles` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idroles`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin'),(2,'customer'),(3,'project_leader'),(4,'member');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `username` varchar(100) NOT NULL,
  `rolename` varchar(45) NOT NULL,
  PRIMARY KEY (`username`,`rolename`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES ('cyclops','customer');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-04 21:20:09

/* Manually added to create the user */
GRANT ALL ON cs673.* TO cs673_user@localhost IDENTIFIED BY 'cs673';