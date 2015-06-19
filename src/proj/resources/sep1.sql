-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: sep1
-- ------------------------------------------------------
-- Server version	5.6.24-enterprise-commercial-advanced-log

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
-- Table structure for table `attendancelog`
--

DROP TABLE IF EXISTS `attendancelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendancelog` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `employeeid` int(11) NOT NULL,
  `entrydate` datetime NOT NULL,
  `logcode` int(11) NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendancelog`
--

LOCK TABLES `attendancelog` WRITE;
/*!40000 ALTER TABLE `attendancelog` DISABLE KEYS */;
INSERT INTO `attendancelog` VALUES (1,1,'2015-06-17 22:57:05',4),(2,1,'2015-06-17 23:08:18',5),(3,1,'2015-06-17 23:12:24',5),(4,1,'2015-06-17 23:16:16',5),(5,1,'2015-06-17 23:21:57',5),(6,1,'2015-06-17 23:27:23',5),(7,1,'2015-06-17 23:28:40',5),(8,1,'2015-06-17 23:29:24',5),(9,1,'2015-06-17 23:31:10',5),(10,1,'2015-06-17 23:33:42',5),(11,1,'2015-06-17 23:35:54',5),(12,1,'2015-06-17 23:39:43',5),(13,1,'2015-06-17 23:42:25',5),(14,1,'2015-06-17 23:46:20',5),(15,1,'2015-06-17 23:47:28',5),(16,1,'2015-06-17 23:50:45',5),(17,1,'2015-06-17 23:52:59',5),(18,1,'2015-06-17 23:55:15',5),(19,1,'2015-06-17 23:57:08',5),(20,1,'2015-06-18 00:04:50',2),(21,1,'2015-06-18 00:06:08',2),(22,1,'2015-06-18 00:08:12',2),(23,1,'2015-06-18 00:13:07',2),(24,1,'2015-06-18 00:13:13',3),(25,1,'2015-06-18 03:06:18',2),(26,1,'2015-06-18 03:06:47',3),(27,1,'2015-06-18 03:08:41',2),(28,1,'2015-06-18 03:08:53',3),(29,1,'2015-06-18 03:09:43',2),(30,1,'2015-06-18 03:09:47',2),(31,1,'2015-06-18 03:09:56',3),(32,1,'2015-06-18 03:14:24',2),(33,1,'2015-06-18 03:14:44',3),(34,1,'2015-06-18 07:55:11',2),(35,1,'2015-06-18 07:56:30',3),(36,1,'2015-06-18 07:59:15',2),(37,1,'2015-06-18 07:59:33',3),(38,1,'2015-06-18 08:01:15',2),(39,1,'2015-06-18 08:01:36',3),(40,1,'2015-06-18 13:14:53',2),(41,1,'2015-06-18 13:38:03',2),(42,1,'2015-06-18 13:39:04',2),(43,1,'2015-06-18 13:41:18',2),(44,1,'2015-06-18 13:42:22',2),(45,1,'2015-06-18 13:43:45',2),(46,1,'2015-06-18 13:46:24',2),(47,1,'2015-06-18 13:47:41',3),(48,1,'2015-06-18 13:48:18',2),(49,1,'2015-06-18 13:48:52',3),(50,1,'2015-06-18 13:48:56',2),(51,1,'2015-06-18 13:50:24',3),(52,1,'2015-06-18 13:58:51',2),(53,1,'2015-06-18 22:16:30',5),(54,1,'2015-06-18 22:21:53',5),(55,1,'2015-06-18 22:23:52',5),(56,1,'2015-06-18 22:24:27',5),(57,1,'2015-06-18 22:51:35',5),(58,1,'2015-06-18 22:55:23',5),(59,1,'2015-06-18 22:57:04',5),(60,1,'2015-06-18 22:58:05',5),(61,1,'2015-06-18 22:59:44',5),(62,1,'2015-06-18 23:01:43',5),(63,1,'2015-06-18 23:06:05',5),(64,1,'2015-06-18 23:07:45',5),(65,1,'2015-06-18 23:10:48',5),(66,1,'2015-06-18 23:12:26',5),(67,1,'2015-06-18 23:16:18',5),(68,1,'2015-06-18 23:19:20',5),(69,1,'2015-06-18 23:22:49',5),(70,1,'2015-06-18 23:30:35',5),(71,1,'2015-06-18 23:33:06',5),(72,1,'2015-06-18 23:34:11',5),(73,1,'2015-06-18 23:35:01',5),(74,1,'2015-06-18 23:48:20',5),(75,1,'2015-06-18 23:55:08',4),(76,1,'2015-06-19 14:49:34',2),(77,1,'2015-06-19 15:01:58',2),(78,1,'2015-06-19 15:03:04',2),(79,1,'2015-06-19 15:06:44',2),(80,1,'2015-06-19 15:08:26',2),(81,1,'2015-06-19 15:09:15',2),(82,1,'2015-06-19 15:10:19',2),(83,1,'2015-06-19 15:11:01',2),(84,1,'2015-06-19 15:20:48',2),(85,1,'2015-06-19 15:25:12',2),(86,1,'2015-06-19 15:26:58',2),(87,1,'2015-06-19 15:26:58',2),(88,1,'2015-06-19 15:33:17',2),(89,1,'2015-06-19 15:35:35',2),(90,1,'2015-06-19 15:36:32',2),(91,1,'2015-06-19 15:42:51',2),(92,2,'2015-06-19 16:41:46',2),(93,2,'2015-06-19 16:42:10',3),(94,1,'2015-06-19 16:42:16',2),(95,1,'2015-06-19 16:42:36',3),(96,3,'2015-06-19 16:42:41',2),(97,3,'2015-06-19 16:42:55',3),(98,1,'2015-06-19 16:47:02',2),(99,1,'2015-06-19 16:51:05',2),(100,1,'2015-06-19 16:56:46',2),(101,1,'2015-06-19 17:04:50',2),(102,1,'2015-06-19 17:06:34',2),(103,1,'2015-06-19 17:09:40',2),(104,1,'2015-06-19 17:12:08',2),(105,1,'2015-06-19 17:13:22',2),(106,1,'2015-06-19 17:16:10',2),(107,1,'2015-06-19 17:17:20',2),(108,1,'2015-06-19 17:19:18',2),(109,1,'2015-06-19 17:43:15',2),(110,1,'2015-06-19 17:49:04',2),(111,1,'2015-06-19 17:49:04',2),(112,1,'2015-06-19 17:51:07',2),(113,1,'2015-06-19 17:56:49',2),(114,1,'2015-06-19 17:59:11',2),(115,1,'2015-06-19 18:10:28',2),(116,1,'2015-06-19 18:12:03',2),(117,1,'2015-06-19 19:08:15',5),(118,1,'2015-06-19 19:24:35',5),(119,1,'2015-06-19 19:25:59',4),(120,1,'2015-06-19 19:26:24',5);
/*!40000 ALTER TABLE `attendancelog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employeeid` int(11) NOT NULL AUTO_INCREMENT,
  `employeetype` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `userpass` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `departmentID` int(11) NOT NULL,
  `gender` char(1) NOT NULL,
  `dob` date NOT NULL,
  `phone` int(11) DEFAULT NULL,
  `basesalary` float NOT NULL,
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1,'admin','admin','Admin',0,'m','1999-07-18',123,20000),(2,0,'test','test','test',0,'m','1997-10-10',123,10000),(3,0,'lozo','lozo','lozo',0,'m','1995-02-18',123,1000000),(4,0,'reza','reza','reza',0,'m','1994-11-11',1111,100000),(5,0,'mario','mario','mario',0,'m','1970-11-11',1111,111111);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logcode`
--

DROP TABLE IF EXISTS `logcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logcode` (
  `logcode` int(11) NOT NULL,
  `logname` varchar(100) NOT NULL,
  `logdescription` varchar(2000) DEFAULT NULL,
  `logcost` float NOT NULL,
  `logunit` varchar(7) NOT NULL,
  `logcost_permission` float NOT NULL,
  `available` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`logcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logcode`
--

LOCK TABLES `logcode` WRITE;
/*!40000 ALTER TABLE `logcode` DISABLE KEYS */;
INSERT INTO `logcode` VALUES (0,'Sick','Employee Sick',100,'Once',25,0);
/*!40000 ALTER TABLE `logcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `permissionid` int(11) NOT NULL AUTO_INCREMENT,
  `logcode` int(11) NOT NULL,
  PRIMARY KEY (`permissionid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (18,0),(19,0),(20,0);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissionglobal`
--

DROP TABLE IF EXISTS `permissionglobal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissionglobal` (
  `permissionid` int(11) NOT NULL,
  `repeatdays` varchar(7) NOT NULL,
  `starthour` int(11) NOT NULL,
  `startminute` int(11) NOT NULL,
  `endhour` int(11) NOT NULL,
  `endminute` int(11) NOT NULL,
  PRIMARY KEY (`permissionid`),
  CONSTRAINT `permissionglobal_ibfk_1` FOREIGN KEY (`permissionid`) REFERENCES `permission` (`permissionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissionglobal`
--

LOCK TABLES `permissionglobal` WRITE;
/*!40000 ALTER TABLE `permissionglobal` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissionglobal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissionindividual`
--

DROP TABLE IF EXISTS `permissionindividual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissionindividual` (
  `permissionid` int(11) NOT NULL,
  `employeeid` int(11) NOT NULL,
  `starttime` datetime NOT NULL,
  `endtime` datetime NOT NULL,
  PRIMARY KEY (`permissionid`),
  CONSTRAINT `permissionindividual_ibfk_1` FOREIGN KEY (`permissionid`) REFERENCES `permission` (`permissionid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissionindividual`
--

LOCK TABLES `permissionindividual` WRITE;
/*!40000 ALTER TABLE `permissionindividual` DISABLE KEYS */;
INSERT INTO `permissionindividual` VALUES (18,1,'2015-06-18 10:10:00','2015-06-18 00:10:00'),(19,1,'2015-06-18 10:10:00','2015-06-18 00:10:00'),(20,1,'2015-06-19 10:30:00','2015-06-20 20:10:00');
/*!40000 ALTER TABLE `permissionindividual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relation`
--

DROP TABLE IF EXISTS `relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relation` (
  `relationid` int(11) NOT NULL AUTO_INCREMENT,
  `superiorid` int(11) NOT NULL,
  `subordinateid` int(11) NOT NULL,
  PRIMARY KEY (`relationid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relation`
--

LOCK TABLES `relation` WRITE;
/*!40000 ALTER TABLE `relation` DISABLE KEYS */;
INSERT INTO `relation` VALUES (1,2,3),(2,2,4),(3,2,5),(4,1,2);
/*!40000 ALTER TABLE `relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setting`
--

DROP TABLE IF EXISTS `setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `setting` (
  `setting_ID` int(11) NOT NULL AUTO_INCREMENT,
  `setting_name` varchar(100) NOT NULL,
  `setting_content` varchar(50) NOT NULL,
  PRIMARY KEY (`setting_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setting`
--

LOCK TABLES `setting` WRITE;
/*!40000 ALTER TABLE `setting` DISABLE KEYS */;
INSERT INTO `setting` VALUES (6,'WorkStartTime','1000'),(7,'WorkFinishTime','1800'),(8,'OverworkStartTime','1900'),(9,'OverworkFinishTime','0200'),(10,'LogoutCode','3'),(11,'LoginCode','2'),(12,'InactivityLogCode','1'),(14,'OverworkEndCode','4'),(15,'OverworkStartCode','5');
/*!40000 ALTER TABLE `setting` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-19 19:34:17
