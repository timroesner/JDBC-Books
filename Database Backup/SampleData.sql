-- MySqlBackup.NET 2.0.9.2
-- Dump Time: 2017-11-16 17:48:07
-- --------------------------------------
-- Server version 5.7.19-log MySQL Community Server (GPL)

-- 
-- Create schema books3
-- 

CREATE DATABASE IF NOT EXISTS `books3` /*!40100 DEFAULT CHARACTER SET utf8 */;
Use `books3`;



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 
-- Definition of authorisbn
-- 

DROP TABLE IF EXISTS `authorisbn`;
CREATE TABLE IF NOT EXISTS `authorisbn` (
  `authorID` int(11) DEFAULT NULL,
  `isbn` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table authorisbn
-- 

/*!40000 ALTER TABLE `authorisbn` DISABLE KEYS */;
INSERT INTO `authorisbn`(`authorID`,`isbn`) VALUES
(1,'0141439518'),
(2,'0307474278'),
(3,'0142437629'),
(4,'0743273565'),
(5,'0345543240'),
(6,'0684801223'),
(7,'1501127625'),
(8,'1501175466'),
(9,'0307949486'),
(10,'0451524935'),
(11,'0439708180'),
(12,'0142000687'),
(13,'0547928227'),
(14,'0385333849'),
(15,'0553418026');
/*!40000 ALTER TABLE `authorisbn` ENABLE KEYS */;

-- 
-- Definition of authors
-- 

DROP TABLE IF EXISTS `authors`;
CREATE TABLE IF NOT EXISTS `authors` (
  `authorID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` char(20) DEFAULT NULL,
  `lastName` char(20) DEFAULT NULL,
  PRIMARY KEY (`authorID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table authors
-- 

/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors`(`authorID`,`firstName`,`lastName`) VALUES
(1,'Jane','Austen'),
(2,'Dan','Brown'),
(3,'Ralph Waldo','Emerson'),
(4,'F.Scott','Firtzgerald'),
(5,'John','Grisham'),
(6,'Ernest','Hemingway'),
(7,'Walter','Isaacson'),
(8,'Stephen','King'),
(9,'Stieg','Larsson'),
(10,'George','Orwell'),
(11,'Joanne K.','Rowling'),
(12,'John','Steinbeck'),
(13,'John R. R.','Tolkien'),
(14,'Kurt','Vonnegut'),
(15,'Andy','Weir');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;

-- 
-- Definition of publishers
-- 

DROP TABLE IF EXISTS `publishers`;
CREATE TABLE IF NOT EXISTS `publishers` (
  `publisherID` int(11) NOT NULL AUTO_INCREMENT,
  `publisherName` char(100) DEFAULT NULL,
  PRIMARY KEY (`publisherID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table publishers
-- 

/*!40000 ALTER TABLE `publishers` DISABLE KEYS */;
INSERT INTO `publishers`(`publisherID`,`publisherName`) VALUES
(1,'Penguin'),
(2,'Anchor'),
(3,'Scribner'),
(4,'Dell Books'),
(5,'Simon & Schuster'),
(6,'Vintage Crime'),
(7,'Signet'),
(8,'Scholastic'),
(9,'Houghton Mifflin'),
(10,'Dial Press'),
(11,'Broadway');
/*!40000 ALTER TABLE `publishers` ENABLE KEYS */;

-- 
-- Definition of titles
-- 

DROP TABLE IF EXISTS `titles`;
CREATE TABLE IF NOT EXISTS `titles` (
  `isbn` char(13) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `editionNumber` int(11) DEFAULT NULL,
  `year` char(4) DEFAULT NULL,
  `publisherID` int(11) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table titles
-- 

/*!40000 ALTER TABLE `titles` DISABLE KEYS */;
INSERT INTO `titles`(`isbn`,`title`,`editionNumber`,`year`,`publisherID`,`price`) VALUES
('0141439518','Pride and Prejudice',10,'2002',1,8.00),
('0142000687','Cannery Row',18,'2002',1,13.60),
('0142437629','Nature and Selected Essays',8,'2003',1,13.58),
('0307474278','The Da Vinci Code',10,'2009',2,8.99),
('0307949486','The Girl with the Dragon Tattoo',5,'2011',6,8.60),
('0345543240','Sycamore Row',5,'2014',4,8.49),
('0385333849','Slaughterhouse-Five',2,'1999',10,12.51),
('0439708180','Harry Potter and the Sorcerer''s Stone',1,'1999',8,7.47),
('0451524935','1984',3,'1961',7,7.64),
('0547928227','The Hobbit',12,'2012',9,11.16),
('0553418026','The Martian',3,'2014',11,10.76),
('0684801223','The Old Man and The Sea',7,'1995',3,9.98),
('0743273565','The Great Gatsby',4,'2004',3,6.99),
('1501127625','Steve Jobs',3,'2015',5,11.99),
('1501175466','It: A Novel',14,'2017',3,9.55);
/*!40000 ALTER TABLE `titles` ENABLE KEYS */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


-- Dump completed on 2017-11-16 17:48:07
-- Total time: 0:0:0:0:312 (d:h:m:s:ms)
