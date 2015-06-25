CREATE DATABASE  IF NOT EXISTS `menu` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `menu`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: menu
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `mealitem`
--

DROP TABLE IF EXISTS `mealitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mealitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mealId` int(11) DEFAULT NULL,
  `ingredientId` int(11) NOT NULL DEFAULT '0',
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_meal_has_ingred_idx` (`id`),
  KEY `fk_meal_has_ingreds` (`mealId`),
  KEY `fk_ingred_has_meals_idx` (`ingredientId`),
  CONSTRAINT `fk_ingred_has_meals` FOREIGN KEY (`ingredientId`) REFERENCES `ingredients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_meal_has_ingreds` FOREIGN KEY (`mealId`) REFERENCES `meals` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mealitem`
--

LOCK TABLES `mealitem` WRITE;
/*!40000 ALTER TABLE `mealitem` DISABLE KEYS */;
INSERT INTO `mealitem` VALUES (1,1,2,300),(2,1,5,50),(3,1,3,50),(4,2,2,200),(5,2,6,200),(6,2,5,50),(7,2,4,300),(8,3,2,300),(9,3,9,300),(10,3,5,50),(11,3,3,50),(12,4,7,20),(13,4,4,300),(14,5,8,20),(15,5,4,300),(16,6,1,200),(17,6,6,200),(18,6,4,300);
/*!40000 ALTER TABLE `mealitem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-24 21:26:05
