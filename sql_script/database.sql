CREATE DATABASE  IF NOT EXISTS `bookstore_renting` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bookstore_renting`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore_renting
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `user_role` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'admin','ROLE_ADMIN'),(2,'admin','ROLE_USER');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietthongtinmuonsach`
--

DROP TABLE IF EXISTS `chitietthongtinmuonsach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietthongtinmuonsach` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ChiTietThongTinMuonSachID` int(11) DEFAULT NULL,
  `SachID` varchar(500) DEFAULT NULL,
  `NgayMuon` datetime DEFAULT NULL,
  `NgayTra` datetime DEFAULT NULL,
  `GhiChu` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietthongtinmuonsach`
--

LOCK TABLES `chitietthongtinmuonsach` WRITE;
/*!40000 ALTER TABLE `chitietthongtinmuonsach` DISABLE KEYS */;
INSERT INTO `chitietthongtinmuonsach` VALUES (1,1,'1','2017-06-01 20:03:00','2017-06-07 20:05:00',NULL),(2,2,'2','2017-06-01 20:05:00','2017-06-12 20:05:00',NULL),(3,2,'3','2017-06-01 20:05:00','2017-06-12 20:05:00',NULL),(4,3,'2',NULL,NULL,NULL),(5,4,'1','2017-06-08 21:15:00','2017-06-16 21:15:00',NULL),(6,4,'2','2017-06-08 21:15:00','2017-06-16 21:15:00',NULL),(7,4,'3','2017-06-08 21:15:00','2017-06-16 21:15:00',NULL);
/*!40000 ALTER TABLE `chitietthongtinmuonsach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sach` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MaSach` varchar(12) DEFAULT NULL,
  `Ten` varchar(500) DEFAULT NULL,
  `TacGia` varchar(2000) DEFAULT NULL,
  `TomTat` varchar(1000) DEFAULT NULL,
  `SoBan` int(11) DEFAULT NULL,
  `ISBN` varchar(2000) DEFAULT NULL,
  `NgayTao` datetime DEFAULT NULL,
  `GiaMuon` decimal(19,4) DEFAULT NULL,
  `GhiChu` varchar(2000) DEFAULT NULL,
  `ImageUrl` varchar(1000) DEFAULT NULL,
  `TheLoai` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES (1,NULL,'Into the Water: A Novel','Paula Hawkins','A single mother turns up dead at the bottom of the river that runs through town. Earlier in the summer, a vulnerable teenage girl met the same fate. They are not the first women lost to these dark waters, but their deaths disturb the river and its history, dredging up secrets long submerged.',10,'0735211205','2017-05-22 15:14:13',5.0000,NULL,NULL,'Literature & Fiction'),(2,NULL,'A Man Called Ove: A Novel','Fredrik Backman','Meet Ove. He’s a curmudgeon—the kind of man who points at people he dislikes as if they were burglars caught outside his bedroom window. He has staunch principles, strict routines, and a short fuse. People call him “the bitter neighbor from hell.” But must Ove be bitter just because he doesn’t walk around with a smile plastered to his face all the time?',5,'1476738025','2017-05-22 15:16:38',3.0000,NULL,NULL,'Literature & Fiction'),(3,NULL,'Clean Code: A Handbook of Agile Software Craftsmanship','Robert C. Martin','Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way.',2,'0132350882','2017-05-22 23:59:13',3.0000,NULL,NULL,'Computers & Technology'),(4,'b1','test 1','author1','some test',10,'1232145555','2017-06-03 00:16:29',3.0000,'',NULL,'story'),(5,'t1','test2','acb','cdf',0,'','2017-06-03 00:20:14',0.0000,'',NULL,'xyz');
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongtinmuonsach`
--

DROP TABLE IF EXISTS `thongtinmuonsach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thongtinmuonsach` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TenDocGia` varchar(50) DEFAULT NULL,
  `DiaChi` varchar(500) DEFAULT NULL,
  `SoDienThoai` varchar(20) DEFAULT NULL,
  `NgayTao` datetime DEFAULT NULL,
  `GhiChu` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongtinmuonsach`
--

LOCK TABLES `thongtinmuonsach` WRITE;
/*!40000 ALTER TABLE `thongtinmuonsach` DISABLE KEYS */;
INSERT INTO `thongtinmuonsach` VALUES (1,'cuong','ktx b','0987456314','2017-06-01 20:03:22','hello'),(2,'cuong nguyen','ktx c','1697547785','2017-06-01 20:06:01','hello form the mars'),(3,'cuong','','0966794618','2017-06-01 20:59:39',''),(4,'quoc cuong','ktx','08998989898','2017-06-01 21:15:37','');
/*!40000 ALTER TABLE `thongtinmuonsach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-03 16:08:29
