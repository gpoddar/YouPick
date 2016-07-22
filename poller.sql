-- MySQL dump 10.13  Distrib 5.7.10, for Win64 (x86_64)
--
-- Host: localhost    Database: poller
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `poll_answers`
--

DROP TABLE IF EXISTS `poll_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poll_answers` (
  `pa_id` double NOT NULL AUTO_INCREMENT,
  `poll_id` int(11) DEFAULT NULL,
  `optionA` double DEFAULT NULL,
  `optionB` double DEFAULT NULL,
  `optionC` double DEFAULT NULL,
  `optionD` double DEFAULT NULL,
  `isbinary` binary(1) DEFAULT NULL,
  PRIMARY KEY (`pa_id`),
  KEY `poll_id` (`poll_id`),
  CONSTRAINT `poll_answers_ibfk_1` FOREIGN KEY (`poll_id`) REFERENCES `polls` (`poll_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poll_answers`
--

LOCK TABLES `poll_answers` WRITE;
/*!40000 ALTER TABLE `poll_answers` DISABLE KEYS */;
/*!40000 ALTER TABLE `poll_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poll_area`
--

DROP TABLE IF EXISTS `poll_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poll_area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(256) DEFAULT NULL,
  `visibility` int(10) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poll_area`
--

LOCK TABLES `poll_area` WRITE;
/*!40000 ALTER TABLE `poll_area` DISABLE KEYS */;
INSERT INTO `poll_area` VALUES (1,'Miscellaneous',1);
/*!40000 ALTER TABLE `poll_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poll_category`
--

DROP TABLE IF EXISTS `poll_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poll_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(256) DEFAULT NULL,
  `visibility` int(10) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poll_category`
--

LOCK TABLES `poll_category` WRITE;
/*!40000 ALTER TABLE `poll_category` DISABLE KEYS */;
INSERT INTO `poll_category` VALUES (1,'Miscellaneous',1);
/*!40000 ALTER TABLE `poll_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poll_school`
--

DROP TABLE IF EXISTS `poll_school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poll_school` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT,
  `school_name` varchar(256) DEFAULT NULL,
  `visibility` int(10) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poll_school`
--

LOCK TABLES `poll_school` WRITE;
/*!40000 ALTER TABLE `poll_school` DISABLE KEYS */;
INSERT INTO `poll_school` VALUES (1,'Miscellaneous',1);
/*!40000 ALTER TABLE `poll_school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `polls`
--

DROP TABLE IF EXISTS `polls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `polls` (
  `poll_id` int(11) NOT NULL AUTO_INCREMENT,
  `optionone` varchar(256) NOT NULL DEFAULT '',
  `optiontwo` varchar(256) NOT NULL DEFAULT '',
  `optionthree` varchar(256) DEFAULT NULL,
  `optionfour` varchar(256) DEFAULT NULL,
  `isbinary` tinyint(1) NOT NULL DEFAULT '0',
  `score` decimal(15,10) NOT NULL DEFAULT '0.0000000000',
  `category_id` int(11) DEFAULT NULL,
  `area_id` int(11) DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  `alive` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `title` varchar(256) NOT NULL DEFAULT '',
  `description` varchar(256) NOT NULL DEFAULT '',
  `imgsrc` varchar(256) DEFAULT NULL,
  `votes` int(10) unsigned NOT NULL DEFAULT '0',
  `FBcomment` int(10) unsigned DEFAULT NULL,
  `tagged` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`poll_id`),
  KEY `category_id` (`category_id`),
  KEY `area_id` (`area_id`),
  KEY `school_id` (`school_id`),
  CONSTRAINT `polls_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `poll_category` (`category_id`),
  CONSTRAINT `polls_ibfk_2` FOREIGN KEY (`area_id`) REFERENCES `poll_area` (`area_id`),
  CONSTRAINT `polls_ibfk_3` FOREIGN KEY (`school_id`) REFERENCES `poll_school` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polls`
--

LOCK TABLES `polls` WRITE;
/*!40000 ALTER TABLE `polls` DISABLE KEYS */;
/*!40000 ALTER TABLE `polls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_answers`
--

DROP TABLE IF EXISTS `user_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_answers` (
  `ua_id` double NOT NULL AUTO_INCREMENT,
  `poll_id` int(11) DEFAULT NULL,
  `usr_id` double DEFAULT NULL,
  `answer` int(11) NOT NULL,
  PRIMARY KEY (`ua_id`),
  UNIQUE KEY `poll_id` (`poll_id`,`usr_id`) USING HASH,
  CONSTRAINT `user_answers_ibfk_1` FOREIGN KEY (`poll_id`) REFERENCES `polls` (`poll_id`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_answers`
--

LOCK TABLES `user_answers` WRITE;
/*!40000 ALTER TABLE `user_answers` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `locationID` int(11) DEFAULT NULL,
  `schoolID` int(11) DEFAULT NULL,
  `emailID` varchar(256) DEFAULT NULL,
  `fb_userID` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `locationID` (`locationID`),
  KEY `schoolID` (`schoolID`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`locationID`) REFERENCES `poll_area` (`area_id`),
  CONSTRAINT `users_ibfk_2` FOREIGN KEY (`schoolID`) REFERENCES `poll_school` (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-05 13:30:14
