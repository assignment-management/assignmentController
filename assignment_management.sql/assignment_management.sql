-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 08, 2016 at 10:58 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `assignment_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignments`
--

CREATE TABLE IF NOT EXISTS `assignments` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `facilitator_id` int(6) NOT NULL,
  `title` varchar(100) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `submission_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `total_students` int(6) NOT NULL,
  `modified_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `facilitator_id` (`facilitator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `assignments`
--


-- --------------------------------------------------------

--
-- Table structure for table `facilitators`
--

CREATE TABLE IF NOT EXISTS `facilitators` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` int(100) NOT NULL,
  `contact_no` int(30) NOT NULL,
  `address` int(100) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `facilitators`
--


-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `contact_no` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `students`
--


-- --------------------------------------------------------

--
-- Table structure for table `student_facilitator`
--

CREATE TABLE IF NOT EXISTS `student_facilitator` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `facilitator_id` int(6) NOT NULL,
  `student_id` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `facilitator_id` (`facilitator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `student_facilitator`
--


--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignments`
--
ALTER TABLE `assignments`
  ADD CONSTRAINT `assignments_ibfk_1` FOREIGN KEY (`facilitator_id`) REFERENCES `facilitators` (`id`);

--
-- Constraints for table `student_facilitator`
--
ALTER TABLE `student_facilitator`
  ADD CONSTRAINT `student_facilitator_ibfk_2` FOREIGN KEY (`facilitator_id`) REFERENCES `facilitators` (`id`),
  ADD CONSTRAINT `student_facilitator_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
