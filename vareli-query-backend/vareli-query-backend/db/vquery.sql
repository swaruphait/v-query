CREATE DATABASE  IF NOT EXISTS `v-query` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `v-query`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 192.168.1.190    Database: v-query
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `mst_option`
--

DROP TABLE IF EXISTS `mst_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mst_option` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `qsn_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe51ark2vrcdyuckoh3p8lk1kd` (`qsn_id`),
  CONSTRAINT `FKe51ark2vrcdyuckoh3p8lk1kd` FOREIGN KEY (`qsn_id`) REFERENCES `mst_qsn` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_option`
--

LOCK TABLES `mst_option` WRITE;
/*!40000 ALTER TABLE `mst_option` DISABLE KEYS */;
INSERT INTO `mst_option` VALUES (1,'anonymousUser','2025-05-30 11:04:00','anonymousUser','2025-05-30 11:04:00','Waste Management Company',5),(2,'anonymousUser','2025-05-30 11:04:00','anonymousUser','2025-05-30 11:04:00','Bio-Gas Plant Operator',5),(3,'anonymousUser','2025-05-30 11:04:00','anonymousUser','2025-05-30 11:04:00','Agricultural Business',5),(4,'anonymousUser','2025-05-30 11:04:00','anonymousUser','2025-05-30 11:04:00','Renewable Energy Consultant',5),(5,'anonymousUser','2025-05-30 11:05:23','anonymousUser','2025-05-30 11:05:23','Plant logistics & operations tracking',6),(6,'anonymousUser','2025-05-30 11:05:23','anonymousUser','2025-05-30 11:05:23','Cost analytics and reporting',6),(7,'anonymousUser','2025-05-30 11:05:23','anonymousUser','2025-05-30 11:05:23','Mobile operations',6),(8,'anonymousUser','2025-05-30 11:05:23','anonymousUser','2025-05-30 11:05:23','Procurement & raw material tracking',6),(9,'anonymousUser','2025-05-30 11:05:23','anonymousUser','2025-05-30 11:05:23','Secure data platform',6),(10,'anonymousUser','2025-05-30 11:05:23','anonymousUser','2025-05-30 11:05:23','End-to-end automation',6),(11,'anonymousUser','2025-05-30 11:06:28','anonymousUser','2025-05-30 11:06:28','Small (1-2 plants)',7),(12,'anonymousUser','2025-05-30 11:06:28','anonymousUser','2025-05-30 11:06:28','Medium (3–5 plants)',7),(13,'anonymousUser','2025-05-30 11:06:28','anonymousUser','2025-05-30 11:06:28','Large (6+ plants)',7),(14,'anonymousUser','2025-05-30 11:06:28','anonymousUser','2025-05-30 11:06:28','Just getting started',7),(15,'anonymousUser','2025-05-30 11:07:21','anonymousUser','2025-05-30 11:07:21','Immediately',8),(16,'anonymousUser','2025-05-30 11:07:21','anonymousUser','2025-05-30 11:07:21','Within 1–3 months',8),(18,'anonymousUser','2025-05-30 11:07:21','anonymousUser','2025-05-30 11:07:21','Within 6 months',8),(19,'anonymousUser','2025-05-30 11:07:21','anonymousUser','2025-05-30 11:07:21','Just exploring',8);
/*!40000 ALTER TABLE `mst_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_qsn`
--

DROP TABLE IF EXISTS `mst_qsn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mst_qsn` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `multiple_choose` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `qsn_type` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `mandatory` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_qsn`
--

LOCK TABLES `mst_qsn` WRITE;
/*!40000 ALTER TABLE `mst_qsn` DISABLE KEYS */;
INSERT INTO `mst_qsn` VALUES (1,'anonymousUser','2025-05-30 11:01:44','anonymousUser','2025-05-30 11:01:44',_binary '\0','Full Name','BIOGRENETECH','T',_binary '',_binary ''),(2,'anonymousUser','2025-05-30 11:01:59','anonymousUser','2025-05-30 11:01:59',_binary '\0','Company Name','BIOGRENETECH','T',_binary '',_binary '\0'),(3,'anonymousUser','2025-05-30 11:02:19','anonymousUser','2025-05-30 11:02:19',_binary '\0','Business Email Address','BIOGRENETECH','T',_binary '',_binary ''),(4,'anonymousUser','2025-05-30 11:02:35','anonymousUser','2025-05-30 11:02:35',_binary '\0','Phone Number','BIOGRENETECH','T',_binary '',_binary ''),(5,'anonymousUser','2025-05-30 11:04:00','anonymousUser','2025-05-30 11:04:00',_binary '\0','What best describes your business?','BIOGRENETECH','R',_binary '',_binary '\0'),(6,'anonymousUser','2025-05-30 11:05:23','anonymousUser','2025-05-30 11:05:23',_binary '','Which features are you most interested in?','BIOGRENETECH','C',_binary '',_binary '\0'),(7,'anonymousUser','2025-05-30 11:06:28','anonymousUser','2025-05-30 11:06:28',_binary '\0','Approximate size of your operation?','BIOGRENETECH','R',_binary '',_binary '\0'),(8,'anonymousUser','2025-05-30 11:07:21','anonymousUser','2025-05-30 11:07:21',_binary '\0','When do you plan to implement a new digital system?','BIOGRENETECH','R',_binary '',_binary '\0'),(9,'anonymousUser','2025-05-30 11:07:57','anonymousUser','2025-05-30 11:07:57',_binary '\0','Any specific goals or challenges you\'d like to address?','BIOGRENETECH','T',_binary '\0',_binary '\0'),(10,'anonymousUser','2025-05-30 14:10:58','anonymousUser','2025-05-30 14:10:58',_binary '\0','Full Name','ND','T',_binary '',_binary ''),(11,'anonymousUser','2025-05-30 14:11:08','anonymousUser','2025-05-30 14:11:08',_binary '\0','Company / Organization Name','ND','T',_binary '',_binary '\0'),(12,'anonymousUser','2025-05-30 14:11:21','anonymousUser','2025-05-30 14:11:21',_binary '\0','Email Address','ND','T',_binary '',_binary ''),(13,'anonymousUser','2025-05-30 14:11:31','anonymousUser','2025-05-30 14:11:31',_binary '\0','Phone Number','ND','T',_binary '',_binary ''),(14,'anonymousUser','2025-05-30 14:12:23','anonymousUser','2025-05-30 14:12:23',_binary '\0','Number of Employees / Users','ND','T',_binary '',_binary '\0'),(15,'anonymousUser','2025-05-30 14:12:38','anonymousUser','2025-05-30 14:12:38',_binary '\0','What would you like to discuss?','ND','T',_binary '',_binary '\0'),(16,'anonymousUser','2025-05-30 14:13:25','anonymousUser','2025-05-30 14:13:25',_binary '\0','Full Name','PB','T',_binary '',_binary ''),(17,'anonymousUser','2025-05-30 14:13:37','anonymousUser','2025-05-30 14:13:37',_binary '\0','Company / Organization Name','PB','T',_binary '',_binary '\0'),(18,'anonymousUser','2025-05-30 14:13:46','anonymousUser','2025-05-30 14:13:46',_binary '\0','Email Address','PB','T',_binary '',_binary ''),(19,'anonymousUser','2025-05-30 14:13:56','anonymousUser','2025-05-30 14:13:56',_binary '\0','Phone Number','PB','T',_binary '',_binary ''),(20,'anonymousUser','2025-05-30 14:14:05','anonymousUser','2025-05-30 14:14:05',_binary '\0','Number of Employees / Users','PB','T',_binary '',_binary '\0'),(21,'anonymousUser','2025-05-30 14:14:17','anonymousUser','2025-05-30 14:14:17',_binary '\0','What would you like to discuss?','PB','T',_binary '',_binary '\0');
/*!40000 ALTER TABLE `mst_qsn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_user`
--

DROP TABLE IF EXISTS `mst_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mst_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_user`
--

LOCK TABLES `mst_user` WRITE;
/*!40000 ALTER TABLE `mst_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `mst_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trn_query_ans`
--

DROP TABLE IF EXISTS `trn_query_ans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trn_query_ans` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ans` varchar(255) DEFAULT NULL,
  `ans_id` varchar(255) DEFAULT NULL,
  `query_qsn_no` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiiev3q75ew996u2ahaucb5y32` (`query_qsn_no`),
  CONSTRAINT `FKiiev3q75ew996u2ahaucb5y32` FOREIGN KEY (`query_qsn_no`) REFERENCES `trn_query_dtls` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_query_ans`
--

LOCK TABLES `trn_query_ans` WRITE;
/*!40000 ALTER TABLE `trn_query_ans` DISABLE KEYS */;
INSERT INTO `trn_query_ans` VALUES (1,'rahul',NULL,1),(2,'vareli',NULL,2),(3,'rahul@gmail.com',NULL,3),(4,'987456324132',NULL,4),(5,'Agricultural Business','4',5),(6,'Procurement & raw material tracking','6',6),(7,'Plant logistics & operations tracking','9',6),(8,'Large (6+ plants)','15',7),(9,'Within 6 months','18',8),(10,'rahul',NULL,10),(11,'vareli',NULL,11),(12,'rahul@gmail.com',NULL,12),(13,'987456324132',NULL,13),(14,'Waste Management Company','5',14),(15,'End-to-end automation','11',15),(16,'Mobile operations','10',15),(17,'Small (1-2 plants)','13',16),(18,'Immediately','17',17),(19,'rahul',NULL,30),(20,'rahul@gmail.com',NULL,32),(21,'9856323447',NULL,33),(22,'test',NULL,36),(23,'rahul@gmail.com',NULL,38),(24,'3698521478',NULL,39),(25,'rahul',NULL,42),(26,'rahul@gmail.com',NULL,44),(27,'987456324132',NULL,45),(28,'rahul',NULL,50),(29,'vareli',NULL,51),(30,'rahul@gmail.com',NULL,52),(31,'987456321',NULL,53),(32,'5',NULL,54),(33,'test',NULL,55),(34,'rahul',NULL,56),(35,'vareli',NULL,57),(36,'rahul@gmail.com',NULL,58),(37,'987456324132',NULL,59),(38,'Bio-Gas Plant Operator','2',60),(39,'Plant logistics & operations tracking','5',61),(40,'Cost analytics and reporting','6',61),(41,'Medium (3–5 plants)','12',62),(42,'Immediately','15',63);
/*!40000 ALTER TABLE `trn_query_ans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trn_query_dtls`
--

DROP TABLE IF EXISTS `trn_query_dtls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trn_query_dtls` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `qsn` varchar(255) DEFAULT NULL,
  `qsn_id` int DEFAULT NULL,
  `query_no` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbi46ohf60jsqukj6oqf9lneoi` (`query_no`),
  CONSTRAINT `FKbi46ohf60jsqukj6oqf9lneoi` FOREIGN KEY (`query_no`) REFERENCES `trn_query_hdr` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_query_dtls`
--

LOCK TABLES `trn_query_dtls` WRITE;
/*!40000 ALTER TABLE `trn_query_dtls` DISABLE KEYS */;
INSERT INTO `trn_query_dtls` VALUES (1,'Full Name',1,1),(2,'Company Name',2,1),(3,'Business Email Address',3,1),(4,'Phone Number',4,1),(5,'What best describes your business?',5,1),(6,'Which features are you most interested in?',6,1),(7,'Approximate size of your operation?',7,1),(8,'When do you plan to implement a new digital system?',8,1),(9,'Any specific goals or challenges you\'d like to address?',9,1),(10,'Full Name',1,2),(11,'Company Name',2,2),(12,'Business Email Address',3,2),(13,'Phone Number',4,2),(14,'What best describes your business?',5,2),(15,'Which features are you most interested in?',6,2),(16,'Approximate size of your operation?',7,2),(17,'When do you plan to implement a new digital system?',8,2),(18,'Full Name',10,3),(19,'Company / Organization Name',11,3),(20,'Email Address',12,3),(21,'Phone Number',13,3),(22,'Number of Employees / Users',14,3),(23,'What would you like to discuss?',15,3),(24,'Full Name',16,4),(25,'Company / Organization Name',17,4),(26,'Email Address',18,4),(27,'Phone Number',19,4),(28,'Number of Employees / Users',20,4),(29,'What would you like to discuss?',21,4),(30,'Full Name',16,5),(31,'Company / Organization Name',17,5),(32,'Email Address',18,5),(33,'Phone Number',19,5),(34,'Number of Employees / Users',20,5),(35,'What would you like to discuss?',21,5),(36,'Full Name',10,6),(37,'Company / Organization Name',11,6),(38,'Email Address',12,6),(39,'Phone Number',13,6),(40,'Number of Employees / Users',14,6),(41,'What would you like to discuss?',15,6),(42,'Full Name',1,7),(43,'Company Name',2,7),(44,'Business Email Address',3,7),(45,'Phone Number',4,7),(46,'What best describes your business?',5,7),(47,'Which features are you most interested in?',6,7),(48,'Approximate size of your operation?',7,7),(49,'When do you plan to implement a new digital system?',8,7),(50,'Full Name',10,8),(51,'Company / Organization Name',11,8),(52,'Email Address',12,8),(53,'Phone Number',13,8),(54,'Number of Employees / Users',14,8),(55,'What would you like to discuss?',15,8),(56,'Full Name',1,9),(57,'Company Name',2,9),(58,'Business Email Address',3,9),(59,'Phone Number',4,9),(60,'What best describes your business?',5,9),(61,'Which features are you most interested in?',6,9),(62,'Approximate size of your operation?',7,9),(63,'When do you plan to implement a new digital system?',8,9);
/*!40000 ALTER TABLE `trn_query_dtls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trn_query_hdr`
--

DROP TABLE IF EXISTS `trn_query_hdr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trn_query_hdr` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `project` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trn_query_hdr`
--

LOCK TABLES `trn_query_hdr` WRITE;
/*!40000 ALTER TABLE `trn_query_hdr` DISABLE KEYS */;
INSERT INTO `trn_query_hdr` VALUES (1,'BIOGRENETECH'),(2,'BIOGRENETECH'),(3,'ND'),(4,'PB'),(5,'PB'),(6,'ND'),(7,'BIOGRENETECH'),(8,'ND'),(9,'BIOGRENETECH');
/*!40000 ALTER TABLE `trn_query_hdr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'v-query'
--

--
-- Dumping routines for database 'v-query'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-31 17:33:05
