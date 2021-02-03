-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: shopee
-- ------------------------------------------------------
-- Server version	8.0.19
create database bai_tap_ve_nha;
use bai_tap_ve_nha;
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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Điện Thoại'),(2,'Xe Cộ'),(3,'Thời Trang Nam'),(4,'Thời Trang Nữ'),(5,'Đồng Hồ'),(6,'Máy Tính & Laptop'),(7,'Máy Ảnh & Máy Quay Phim'),(8,'Dụng Cụ Cầm Tay'),(9,'Đồ Dùng Nhà Bếp'),(10,'Mỹ Phẩm'),(11,'Đồ Điện Tử'),(12,'Thực Phẩm'),(13,'Bất Động Sản');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Cường','1996-10-22','123123','Đà Nẵng','cuong@gmail.com'),(2,'Duy','1996-10-05','131313','Sài Gòn','duy@gmail.com'),(3,'Ngân','2002-01-08','121212','Hội An','ngan@gmail.com'),(4,'Quân','1996-11-05','141414','Đà Nẵng','quan@gmail.com'),(5,'Hùng','1994-02-05','151515','Đak lak','hung@gmail.com'),(6,'Toàn','1992-05-08','161616','Huế','toan@gmail.com'),(7,'Tú','1982-03-13','171717','Đà Nẵng','tu@gmail.com'),(8,'Bách','1997-09-09','181818','Đà Nẵng','bach@gmail.com'),(9,'Tùng','1997-02-27','191919','Đà Nẵng','tung@gmail.com'),(10,'Hậu','1984-02-02','202020','Đà Nẵng','hau@gmail.com'),(11,'Lala','1990-03-03','131234','Bình Định','lala@gmail.com'),(12,'liulo','1990-05-28','131245','Quảng Ngãi','liulo@gmail.com');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Thiện','1998-10-22','Đà Nẵng','2020-01-01'),(2,'Thành','1992-01-01','Đà Nằng','2020-02-01'),(3,'Trà','1995-01-01','Quảng Trị','2019-10-02'),(4,'Mậu','1998-01-01','Hà Tĩnh','2019-11-04'),(5,'Long','1996-01-01','Đà Nẵng','2018-02-03'),(6,'An','1994-01-01','Tam Kỳ','2017-08-02'),(7,'Sơn','1995-01-01','Huế','2015-03-03'),(8,'Thảo','1995-01-01','Đà Nẵng','2020-12-12'),(9,'LiuLo','1992-05-28','Đà Nẵng','2020-05-28'),(10,'LaLa','1991-01-01','Đà Nẵng','2020-10-10');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetail` (
  `product_id` int NOT NULL,
  `order_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`product_id`,`order_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
INSERT INTO `orderdetail` VALUES (1,1,2),(1,3,3),(1,4,1),(1,5,2),(2,1,1),(3,1,1),(4,2,1),(5,2,1),(8,6,3),(8,7,4),(9,8,1),(9,9,2),(10,10,3);
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(200) DEFAULT NULL,
  `payment_method` varchar(200) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `date_order` datetime DEFAULT NULL,
  `date_ship` datetime DEFAULT NULL,
  `address_receiver` text,
  PRIMARY KEY (`order_id`),
  KEY `customer_id` (`customer_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'Done','Cash',5,1,'2020-05-28 00:00:00','2020-05-30 00:00:00','Đà Nẵng'),(2,'On The Way','Cash',3,3,'2020-05-28 00:00:00','2020-05-30 00:00:00','Hà Nội'),(3,'On The Way','Cash',2,4,'2020-05-28 00:00:00','2020-05-30 00:00:00','Sài Gòn'),(4,'On The Way','Cash',4,6,'2020-05-28 00:00:00','2020-05-30 00:00:00','Huế'),(5,'canceled','Cash',7,8,'2020-01-12 00:00:00','2020-01-15 00:00:00','Quảng Trị'),(6,'On The Way','Cash',10,7,'2020-05-11 00:00:00','2020-05-14 00:00:00','Quảng Ngãi'),(7,'canceled','CREADIT CARD',1,2,'2020-02-15 00:00:00','2020-02-20 00:00:00','Hội An'),(8,'Done','CREADIT CARD',1,9,'2020-03-11 00:00:00','2020-03-13 00:00:00','Bình Định'),(9,'canceled','CREADIT CARD',1,5,'2020-04-21 00:00:00','2020-04-28 00:00:00','Đak Lak'),(10,'Done','CREADIT CARD',1,10,'2020-01-01 00:00:00','2020-01-03 00:00:00','Hà Tĩnh');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `imageURL` text,
  `discount` int DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `supplier_id` int DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `catogory_id` (`category_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`),
  CONSTRAINT `products_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Iphone 8',1100,'aca',12,1,1,2),(2,'Organ T100',2000,'acac',10,11,11,3),(3,'Macbook Pro',2000,'asca',11,2,6,2),(4,'VSmart 3',276,'ascac',11,2,1,4),(5,'LV limited',2000,'ascv',11,4,4,10),(6,'Tivi SS10',676,'asvsa',13,5,11,1),(7,'Bột Giặt Omo',36,'ascxz',16,6,9,5),(8,'Cà Phê Hòa Tan',36,'asqwe',12,11,12,6),(9,'Iphone 7 Plus',1100,'asvfd',12,3,1,2),(10,'Iphone X',1100,'asdcz',13,11,1,2),(11,'Yamaha R2',25000,'dadsc',15,3,2,3),(22,'Tesst',1,'aa',4,4,1,1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers` (
  `supplier_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'SamSung','123312','Đà Nẵng'),(2,'Apple','112456','Đà Nẵng'),(3,'Yamaha','543678','Đà Nẵng'),(4,'Vin','123545','Đà Nẵng'),(5,'Unilever','132132','Đà Nẵng'),(6,'Trung Nguyên','121212','Đà Nẵng'),(7,'Nestle','131313','Đà Nẵng'),(8,'Channel','456452','Đà Nẵng'),(9,'Gucci','12553','Đà Nẵng'),(10,'Louis Vuitton','123345','Đà Nẵng');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-04 15:23:59

-- cau1
select * from products where products.discount <=10;
-- câu2
 select * from orderdetail where orderdetail.quantity <= 5;
 -- câu3
select * from products where products.price <= 1000;
-- câu4
select * from employees where employees.address = 'đà nẵng';
-- --câu5
select * from employees where employees.date = year(1990);
-- câu6
select * from employees where employees.date = localtime();
-- --câu7
select * from orders where orders.status = 'done';
-- câu8
select * from orders where orders.status = 'completed';
-- câu9
select * from orders where orders.status = 'canceled';
-- câu10
select * from orders where orders.status = 'canceled'and orders.date_order = localtime();
-- câu11
select* from orders where orders.payment_method = 'cash';
-- câu12
select * from orders where orders.payment_method = 'creadit card';
-- câu13
select * from orders where orders.address_receiver = 'hà nội';
-- câu14
select * from employees where employees.date = localtime();
-- câu15
select * from suppliers where suppliers.name = 'yamaha' or   suppliers.name ='samsung' 
or suppliers.name ='nestle' or suppliers.name ='apple';
