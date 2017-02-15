-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 15, 2017 at 05:52 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nahiyanhotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE IF NOT EXISTS `adminlogin` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`username`, `password`) VALUES
('abc', '123');

-- --------------------------------------------------------

--
-- Table structure for table `checkin`
--

CREATE TABLE IF NOT EXISTS `checkin` (
  `customar_id` int(11) NOT NULL,
  `room_number` int(11) NOT NULL,
  `checkin_date` varchar(12) NOT NULL,
  `checkout_date` varchar(12) NOT NULL,
  `amount` double NOT NULL,
  `payed` double NOT NULL,
  `due` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `checkin`
--

INSERT INTO `checkin` (`customar_id`, `room_number`, `checkin_date`, `checkout_date`, `amount`, `payed`, `due`) VALUES
(2, 444, '22/12/2015', '23/12/2015', 1500, 1000, 500);

-- --------------------------------------------------------

--
-- Table structure for table `checkoutinfo`
--

CREATE TABLE IF NOT EXISTS `checkoutinfo` (
  `customer_id` int(11) NOT NULL,
  `room_number` int(11) NOT NULL,
  `total_room_bill` int(11) NOT NULL,
  `room_bill_due` int(11) NOT NULL,
  `food_bill_due` int(11) NOT NULL,
  `total_bill_payed` int(11) NOT NULL,
  `checkin` varchar(20) NOT NULL,
  `checkout` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `checkoutinfo`
--

INSERT INTO `checkoutinfo` (`customer_id`, `room_number`, `total_room_bill`, `room_bill_due`, `food_bill_due`, `total_bill_payed`, `checkin`, `checkout`) VALUES
(1, 222, 2000, 0, 0, 2600, '22/12/2015', '23/12/2015');

-- --------------------------------------------------------

--
-- Table structure for table `customarinfo`
--

CREATE TABLE IF NOT EXISTS `customarinfo` (
  `id` int(11) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `marrage_status` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `mobile_number` int(11) NOT NULL,
  `email` varchar(20) NOT NULL,
  `national_id` varchar(20) NOT NULL,
  `passport_no` varchar(20) NOT NULL,
  `number_of_adults` int(11) NOT NULL,
  `number_of_children` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `national_id` (`national_id`),
  UNIQUE KEY `passport_no` (`passport_no`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `mobile_number` (`mobile_number`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customarinfo`
--

INSERT INTO `customarinfo` (`id`, `first_name`, `last_name`, `gender`, `marrage_status`, `address`, `mobile_number`, `email`, `national_id`, `passport_no`, `number_of_adults`, `number_of_children`) VALUES
(1, 'qwe', 'qwe', 'Male', 'Married', 'qwe', 789, '789@qwe', '789', '789', 1, 1),
(2, 'asd', 'asd', 'Female', 'Married', 'asd', 456, '456@asd', '456', '456', 3, 3),
(3, 'zxc', 'zxc', 'Male', 'Un-Married', 'zxc', 123, '123@zxc', '123', '123', 0, 0),
(4, 'qaz', 'qaz', 'Female', 'Un-Married', 'qaz', 741, '741@qaz', '741', '741', 6, 5);

-- --------------------------------------------------------

--
-- Table structure for table `foodinfo`
--

CREATE TABLE IF NOT EXISTS `foodinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `price` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `foodinfo`
--

INSERT INTO `foodinfo` (`id`, `name`, `type`, `price`) VALUES
(1, 'Ilish fry', 'Bangladeshi', '500'),
(2, 'Alu Parata', 'Indian', '300'),
(3, 'Corn Soup', 'Thai', '600'),
(4, 'Nuddles', 'Chaines', '200'),
(5, 'Barger', 'Western', '150');

-- --------------------------------------------------------

--
-- Table structure for table `foodorderinfo`
--

CREATE TABLE IF NOT EXISTS `foodorderinfo` (
  `customer_id` int(11) NOT NULL,
  `food_type` varchar(50) NOT NULL,
  `food_name` varchar(50) NOT NULL,
  `food_price` int(11) NOT NULL,
  `food_quantity` int(11) NOT NULL,
  `total_amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foodorderinfo`
--

INSERT INTO `foodorderinfo` (`customer_id`, `food_type`, `food_name`, `food_price`, `food_quantity`, `total_amount`) VALUES
(1, 'Indian', 'Alu Parata', 300, 2, 600),
(2, 'Bangladeshi', 'Ilish fry', 500, 2, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `roominfo`
--

CREATE TABLE IF NOT EXISTS `roominfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_type` varchar(10) NOT NULL,
  `bed_type` varchar(10) NOT NULL,
  `room_number` int(11) NOT NULL,
  `room_price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `roominfo`
--

INSERT INTO `roominfo` (`id`, `room_type`, `bed_type`, `room_number`, `room_price`) VALUES
(1, 'AC', 'singal', 111, 1000),
(2, 'AC', 'double', 222, 2000),
(3, 'Non-AC', 'singal', 333, 500),
(4, 'Non-AC', 'double', 444, 1500),
(5, 'AC', 'singal', 112, 1000),
(6, 'AC', 'double', 223, 2000),
(7, 'Non-AC', 'singal', 334, 500),
(8, 'Non-AC', 'double', 445, 1500),
(9, 'NoN-AC', 'Double', 446, 1500);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
