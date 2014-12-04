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
  `name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `estimate` int(11) NOT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  `last_modified_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproject`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'ProManage','Groups Tool','open','2014-09-19','2014-12-04',16,'2015-01-01 04:59:59',1,'2015-01-01 04:59:59',1);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `iduser` int(11) NOT NULL,
  `idproject` int(11) NOT NULL,
  `rolename` varchar(45) NOT NULL,
  PRIMARY KEY (`iduser`,`idproject`,`rolename`),
  KEY `fk_user` (`iduser`),
  KEY `fk_project` (`idproject`),
  KEY `fk_role` (`rolename`),
  CONSTRAINT `fk_project` FOREIGN KEY (`idproject`) REFERENCES `project` (`idproject`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role` FOREIGN KEY (`rolename`) REFERENCES `roles` (`rolename`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (2,1,'member'),(3,1,'project_leader');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `story`
--

DROP TABLE IF EXISTS `story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `story` (
  `idstory` int(11) NOT NULL AUTO_INCREMENT,
  `idproject` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `due_date` date DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `estimate` int(11) DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  `last_modified_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`idstory`),
  KEY `idproject_idx` (`idproject`),
  CONSTRAINT `idproject` FOREIGN KEY (`idproject`) REFERENCES `project` (`idproject`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story`
--


LOCK TABLES `story` WRITE;
/*!40000 ALTER TABLE `story` DISABLE KEYS */;
INSERT INTO `story` VALUES (1,1,'test',0,'2014-12-02','Let me tell you a story about the time my life got flipped opsidedown',14,1,'2014-12-02 03:45:32','2014-12-02 03:45:32',1),(2,1,'story2',0,'2014-12-02','I\'ll tell you how I became the prince of a town called Bel-Air',14,1,'2014-12-02 03:45:32','2014-12-02 03:45:32',1);
/*!40000 ALTER TABLE `story` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `idtask` int(11) NOT NULL AUTO_INCREMENT,
  `idstory` int(11) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL,
  `estimate` int(11) NOT NULL,
  `remaining` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  `last_modified_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtask`),
  KEY `fk_story` (`idstory`),
  CONSTRAINT `fk_story` FOREIGN KEY (`idstory`) REFERENCES `story` (`idstory`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,1,'task 1 description','test',1,4,2,NULL,'2014-12-02','2014-12-02 03:45:32','2014-12-02 03:45:32',1),(2,1,'task 2 description','test2',1,4,1,NULL,'2014-12-02','2014-12-02 03:45:32','2014-12-02 03:45:32',1),(3,2,'task 1 story 2','task 1',1,4,3,NULL,'2014-12-02','2014-12-02 03:45:32','2014-12-02 03:45:32',1),(4,2,'task2 story 2','task2',1,4,0,NULL,'2014-12-02','2014-12-02 03:45:32','2014-12-02 03:45:32',1),(5,1,'This is a unit test task','unitTestTask',1,4,1,NULL,'2014-12-25','2014-12-03 03:50:47','2014-12-03 03:50:47',1);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(128) DEFAULT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'root','57845de6539c1a76be0dfa87f17e069b948e4ff166f99a341c8214bd048c9ca3eb006c8dc02ba3d604cc5d85b98fd05d5edfa1f81f07927fc6b570bfba1f33ac',NULL,NULL,NULL,NULL,NULL),(2,'spiderman','7d4b83b002a19d46725716874d17391d2278cd2557cb9744ea9404cb3d90a78ad803331a0de27cb9cba4eaaa72f87503c790721cf7c471c2a119375b9300506a',NULL,NULL,NULL,NULL,NULL),(3,'cyclops','7d4b83b002a19d46725716874d17391d2278cd2557cb9744ea9404cb3d90a78ad803331a0de27cb9cba4eaaa72f87503c790721cf7c471c2a119375b9300506a',NULL,NULL,NULL,NULL,NULL),(5,'jean','7d4b83b002a19d46725716874d17391d2278cd2557cb9744ea9404cb3d90a78ad803331a0de27cb9cba4eaaa72f87503c790721cf7c471c2a119375b9300506a',NULL,NULL,NULL,NULL,NULL),(6,'venom','7d4b83b002a19d46725716874d17391d2278cd2557cb9744ea9404cb3d90a78ad803331a0de27cb9cba4eaaa72f87503c790721cf7c471c2a119375b9300506a',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `rolename` varchar(45) NOT NULL,
  PRIMARY KEY (`rolename`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES ('admin'),('customer'),('member'),('project_leader');
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

-- Dump completed on 2014-12-03  9:24:52

/* manually added to create the user */
GRANT ALL ON cs673.* TO cs673_user@localhost IDENTIFIED BY 'cs673';
