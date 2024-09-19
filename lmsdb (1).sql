-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 19, 2024 at 06:13 PM
-- Server version: 8.3.0
-- PHP Version: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lmsdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

DROP TABLE IF EXISTS `adminlogin`;
CREATE TABLE IF NOT EXISTS `adminlogin` (
  `userid` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`userid`, `password`) VALUES
('111', '111');

-- --------------------------------------------------------

--
-- Table structure for table `enquiries`
--

DROP TABLE IF EXISTS `enquiries`;
CREATE TABLE IF NOT EXISTS `enquiries` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contactno` varchar(15) NOT NULL,
  `emailaddress` varchar(50) NOT NULL,
  `enquirytext` varchar(1000) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `name` varchar(50) NOT NULL,
  `posteddate` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `enquiries`
--

INSERT INTO `enquiries` (`id`, `contactno`, `emailaddress`, `enquirytext`, `gender`, `name`, `posteddate`) VALUES
(1, '9555092636', 'shivam8899@gmail.com', 'vhvh', 'male', 'Shivam sen', 'Tue Sep 10 17:20:47 IST 2024'),
(2, '9555092636', 'shivam8899@gmail.com', 'no problem', 'male', 'Shivam ', 'Wed Sep 11 07:13:44 IST 2024'),
(3, '9555092636', 'shivam8899@gmail.com', 'no problem', 'male', 'Shivam ', 'Wed Sep 11 07:13:44 IST 2024'),
(4, '9555092636', 'shivam8899@gmail.com', 'no problem', 'male', 'anshu', 'Wed Sep 11 07:13:44 IST 2024'),
(5, '9555092636', 'shivam8899@gmail.com', 'no problem', 'male', 'anshu maurya', 'Wed Sep 11 07:13:44 IST 2024'),
(6, '11111111111', 'shivam8899@gmail.com', 'pagal ladki', 'female', 'priya', 'Sun Sep 15 22:37:13 IST 2024'),
(7, '95555092326', 'shivam8899@gmail.com', 'hello.good morning', 'male', 'Shivam sen', 'Tue Sep 17 08:04:51 IST 2024'),
(8, '95555092326', 'shivam8899@gmail.com', 'good mornig', 'male', 'Shivam sen', 'Tue Sep 17 08:07:27 IST 2024'),
(9, '9027758355', 'shivam8899@gmail.com', 'good mornig', 'male', 'Shivam sen', 'Tue Sep 17 08:10:46 IST 2024'),
(10, '9555092636', 'shivam8899@gmail.com', 'good mornig', 'male', 'Shivam sen', 'Wed Sep 18 08:08:25 IST 2024');

-- --------------------------------------------------------

--
-- Table structure for table `meterials`
--

DROP TABLE IF EXISTS `meterials`;
CREATE TABLE IF NOT EXISTS `meterials` (
  `id` int NOT NULL AUTO_INCREMENT,
  `branch` varchar(100) NOT NULL,
  `filename` varchar(500) NOT NULL,
  `materialtype` varchar(100) NOT NULL,
  `posteddate` varchar(100) NOT NULL,
  `program` varchar(100) NOT NULL,
  `subject` varchar(100) NOT NULL,
  `topic` varchar(500) NOT NULL,
  `year` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `meterials`
--

INSERT INTO `meterials` (`id`, `branch`, `filename`, `materialtype`, `posteddate`, `program`, `subject`, `topic`, `year`) VALUES
(123, 'cs', 'jjj', 'jjj', '16/09/2024', 'hhh', 'jjjjj', 'kkkkk', '2024'),
(124, 'cs', 'oooooo', 'ooooooooo', '16/09/2024', 'ooooooooo', 'jjjjj', 'ooooooooo', '2024'),
(125, 'IT', '1726629413992_WhatsApp Image 2024-08-25 at 4.31.16 PM (1).jpeg', 'smat', 'Wed Sep 18 08:46:54 IST 2024', 'B-Tech', 'java', 'c', '2nd Year'),
(126, 'CS', '1726631293186_Screenshot 2024-08-15 200736.png', 'smat', 'Wed Sep 18 09:18:13 IST 2024', 'BCA', 'java', 'arrays', '2nd Year');

-- --------------------------------------------------------

--
-- Table structure for table `responses`
--

DROP TABLE IF EXISTS `responses`;
CREATE TABLE IF NOT EXISTS `responses` (
  `resid` int NOT NULL AUTO_INCREMENT,
  `contactno` varchar(13) NOT NULL,
  `emailaddress` varchar(100) NOT NULL,
  `enrollmentno` varchar(50) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `name` varchar(60) NOT NULL,
  `resdate` varchar(50) NOT NULL,
  `responsetype` varchar(50) NOT NULL,
  `subject` varchar(200) NOT NULL,
  PRIMARY KEY (`resid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `responses`
--

INSERT INTO `responses` (`resid`, `contactno`, `emailaddress`, `enrollmentno`, `message`, `name`, `resdate`, `responsetype`, `subject`) VALUES
(1, '95555092326', 'shivam8899@gmail.com', '456', 'kjj', 'avnish tiwari', 'Sat Sep 14 16:31:58 IST 2024', 'Complaint', 'kjj'),
(2, '95555092326', 'shivam8899@gmail.com', '456', 'jj', 'avnish tiwari', 'Sat Sep 14 16:44:24 IST 2024', 'Feedback', 'jj'),
(3, '95555092326', 'shivam8899@gmail.com', '456', 'shivam,,,,', 'avnish tiwari', 'Sat Sep 14 16:45:18 IST 2024', 'Complaint', 'shivam..'),
(4, '95555092326', 'shivam8899@gmail.com', '456', 'gggh', 'avnish tiwari', 'Mon Sep 16 08:13:57 IST 2024', 'Complaint', 'hhhhhhhggg'),
(5, '95555092326', 'shivam8899@gmail.com', '456', 'iiiiiiii', 'avnish tiwari', 'Mon Sep 16 08:14:10 IST 2024', 'Complaint', 'jjjj'),
(6, '95555092326', 'shivam8899@gmail.com', '456', 'gggg', 'avnish tiwari', 'Mon Sep 16 08:15:08 IST 2024', 'Feedback', 'gggg'),
(7, '95555092326', 'shivam8899@gmail.com', '456', 'qqqqqqq', 'avnish tiwari', 'Mon Sep 16 08:15:23 IST 2024', 'Feedback', 'qqqqqqq');

-- --------------------------------------------------------

--
-- Table structure for table `studentinfoes`
--

DROP TABLE IF EXISTS `studentinfoes`;
CREATE TABLE IF NOT EXISTS `studentinfoes` (
  `enrollmentno` varchar(60) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `branch` varchar(100) NOT NULL,
  `contactno` varchar(13) NOT NULL,
  `emailaddress` varchar(100) NOT NULL,
  `fname` varchar(60) NOT NULL,
  `gender` varchar(15) NOT NULL,
  `mname` varchar(60) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `program` varchar(100) NOT NULL,
  `regdate` varchar(60) NOT NULL,
  `year` varchar(50) NOT NULL,
  `profilepic` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`enrollmentno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `studentinfoes`
--

INSERT INTO `studentinfoes` (`enrollmentno`, `address`, `branch`, `contactno`, `emailaddress`, `fname`, `gender`, `mname`, `name`, `password`, `program`, `regdate`, `year`, `profilepic`) VALUES
('111', 'ayodhya', 'CS', '95555092326', '111', 'PAPA', 'male', 'MA', 'SHIVAM', '111', 'BCA', 'Tue Sep 17 11:48:23 IST 2024', '2nd Year', '1726581949779_logo1.png'),
('456', 'ayodhya', 'CS', '95555092326', 'shivam8899@gmail.com', 'papa', 'male', 'ma', '\"SHIVAM SEN\"', '333', 'BCA', 'Wed Sep 11 10:59:18 IST 2024', '2nd Year', '1726553815077_logo1.png');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
