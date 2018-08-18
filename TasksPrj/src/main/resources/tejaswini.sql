-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.7-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for tasksprj
DROP DATABASE IF EXISTS `tasksprj`;
CREATE DATABASE IF NOT EXISTS `tasksprj` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tasksprj`;

-- Dumping structure for table tasksprj.tasks
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE IF NOT EXISTS `tasks` (
  `taskid` int(11) NOT NULL AUTO_INCREMENT,
  `templateId` int(11) NOT NULL DEFAULT 0,
  `stdate` date NOT NULL,
  `enddate` date NOT NULL,
  `percentComplete` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`taskid`),
  KEY `FK__tasktemplates` (`templateId`),
  CONSTRAINT `FK__tasktemplates` FOREIGN KEY (`templateId`) REFERENCES `tasktemplates` (`templateId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table tasksprj.tasks: ~0 rows (approximately)
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;

-- Dumping structure for table tasksprj.tasktemplates
DROP TABLE IF EXISTS `tasktemplates`;
CREATE TABLE IF NOT EXISTS `tasktemplates` (
  `templateId` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(500) DEFAULT NULL,
  `duration` int(11) NOT NULL DEFAULT 0,
  `adminId` varchar(20) DEFAULT NULL,
  `ttype` int(11) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `recurringfrequency` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`templateId`),
  KEY `FK_tasktemplates_tusers` (`adminId`),
  CONSTRAINT `FK_tasktemplates_tusers` FOREIGN KEY (`adminId`) REFERENCES `tusers` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table tasksprj.tasktemplates: ~0 rows (approximately)
/*!40000 ALTER TABLE `tasktemplates` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasktemplates` ENABLE KEYS */;

-- Dumping structure for table tasksprj.taskupdates
DROP TABLE IF EXISTS `taskupdates`;
CREATE TABLE IF NOT EXISTS `taskupdates` (
  `updateId` int(11) NOT NULL,
  `userId` varchar(50) DEFAULT NULL,
  `taskId` int(11) DEFAULT NULL,
  `updateInfo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`updateId`),
  KEY `FK__tusers1` (`userId`),
  KEY `FK__tasks1` (`taskId`),
  CONSTRAINT `FK__tasks1` FOREIGN KEY (`taskId`) REFERENCES `tasks` (`taskid`),
  CONSTRAINT `FK__tusers1` FOREIGN KEY (`userId`) REFERENCES `tusers` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table tasksprj.taskupdates: ~0 rows (approximately)
/*!40000 ALTER TABLE `taskupdates` DISABLE KEYS */;
/*!40000 ALTER TABLE `taskupdates` ENABLE KEYS */;

-- Dumping structure for table tasksprj.taskusers
DROP TABLE IF EXISTS `taskusers`;
CREATE TABLE IF NOT EXISTS `taskusers` (
  `tuid` int(11) NOT NULL,
  `taskid` int(11) DEFAULT NULL,
  `userid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tuid`),
  KEY `FK__tasks` (`taskid`),
  KEY `FK__tusers` (`userid`),
  CONSTRAINT `FK__tasks` FOREIGN KEY (`taskid`) REFERENCES `tasks` (`taskid`),
  CONSTRAINT `FK__tusers` FOREIGN KEY (`userid`) REFERENCES `tusers` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table tasksprj.taskusers: ~0 rows (approximately)
/*!40000 ALTER TABLE `taskusers` DISABLE KEYS */;
/*!40000 ALTER TABLE `taskusers` ENABLE KEYS */;

-- Dumping structure for table tasksprj.tusers
DROP TABLE IF EXISTS `tusers`;
CREATE TABLE IF NOT EXISTS `tusers` (
  `userId` varchar(50) NOT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table tasksprj.tusers: ~0 rows (approximately)
/*!40000 ALTER TABLE `tusers` DISABLE KEYS */;
/*!40000 ALTER TABLE `tusers` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
