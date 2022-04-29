-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 29, 2022 at 05:11 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `csit314_apr_2022_projecthd`
--

-- --------------------------------------------------------

--
-- Table structure for table `Account`
--

CREATE TABLE `Account` (
  `AccountID` int(5) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `RoleID` int(5) NOT NULL,
  `DateJoined` timestamp NOT NULL DEFAULT current_timestamp(),
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Status` varchar(10) NOT NULL DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Account`
--

INSERT INTO `Account` (`AccountID`, `Name`, `RoleID`, `DateJoined`, `Username`, `Password`, `Status`) VALUES
(1, 'name1', 2, '2022-04-29 03:09:51', 'username1', 'password1', 'Active'),
(2, 'name2', 3, '2022-04-29 03:09:51', 'username2', 'password2', 'Active'),
(4, 'name4', 3, '2022-04-29 03:09:51', 'username4', 'password4', 'Active'),
(5, 'name5', 3, '2022-04-29 03:09:51', 'username5', 'password5', 'Active'),
(6, 'name6', 1, '2022-04-29 03:09:51', 'username6', 'password6', 'Active'),
(7, 'name7', 3, '2022-04-29 03:09:51', 'username7', 'password7', 'Active'),
(9, 'name9', 3, '2022-04-29 03:09:51', 'username9', 'password9', 'Active'),
(10, 'name10', 1, '2022-04-29 03:09:51', 'username10', 'password10', 'Active'),
(11, 'name11', 3, '2022-04-29 03:09:52', 'username11', 'password11', 'Active'),
(12, 'name12', 1, '2022-04-29 03:09:52', 'username12', 'password12', 'Active'),
(14, 'name14', 2, '2022-04-29 03:09:52', 'username14', 'password14', 'Active'),
(17, 'name17', 2, '2022-04-29 03:09:52', 'username17', 'password17', 'Active'),
(18, 'name18', 2, '2022-04-29 03:09:52', 'username18', 'password18', 'Active'),
(19, 'name19', 2, '2022-04-29 03:09:52', 'username19', 'password19', 'Active'),
(20, 'name20', 3, '2022-04-29 03:09:52', 'username20', 'password20', 'Active'),
(23, 'name23', 3, '2022-04-29 03:09:52', 'username23', 'password23', 'Active'),
(24, 'name24', 1, '2022-04-29 03:09:52', 'username24', 'password24', 'Active'),
(26, 'name26', 2, '2022-04-29 03:09:52', 'username26', 'password26', 'Active'),
(28, 'name28', 3, '2022-04-29 03:09:52', 'username28', 'password28', 'Active'),
(29, 'name29', 1, '2022-04-29 03:09:52', 'username29', 'password29', 'Active'),
(30, 'name30', 3, '2022-04-29 03:09:52', 'username30', 'password30', 'Active'),
(31, 'name31', 3, '2022-04-29 03:09:52', 'username31', 'password31', 'Active'),
(33, 'name33', 3, '2022-04-29 03:09:52', 'username33', 'password33', 'Active'),
(35, 'name35', 2, '2022-04-29 03:09:52', 'username35', 'password35', 'Active'),
(37, 'name37', 3, '2022-04-29 03:09:52', 'username37', 'password37', 'Active'),
(38, 'name38', 2, '2022-04-29 03:09:52', 'username38', 'password38', 'Active'),
(39, 'name39', 2, '2022-04-29 03:09:52', 'username39', 'password39', 'Active'),
(40, 'name40', 1, '2022-04-29 03:09:52', 'username40', 'password40', 'Active'),
(41, 'name41', 3, '2022-04-29 03:09:52', 'username41', 'password41', 'Active'),
(42, 'name42', 1, '2022-04-29 03:09:52', 'username42', 'password42', 'Active'),
(43, 'name43', 1, '2022-04-29 03:09:52', 'username43', 'password43', 'Active'),
(44, 'name44', 2, '2022-04-29 03:09:52', 'username44', 'password44', 'Active'),
(45, 'name45', 2, '2022-04-29 03:09:52', 'username45', 'password45', 'Active'),
(49, 'name49', 1, '2022-04-29 03:09:52', 'username49', 'password49', 'Active'),
(50, 'name50', 2, '2022-04-29 03:09:52', 'username50', 'password50', 'Active'),
(53, 'name53', 3, '2022-04-29 03:09:52', 'username53', 'password53', 'Active'),
(55, 'name55', 1, '2022-04-29 03:09:52', 'username55', 'password55', 'Active'),
(56, 'name56', 3, '2022-04-29 03:09:52', 'username56', 'password56', 'Active'),
(57, 'name57', 3, '2022-04-29 03:09:52', 'username57', 'password57', 'Active'),
(59, 'name59', 1, '2022-04-29 03:09:52', 'username59', 'password59', 'Active'),
(60, 'name60', 2, '2022-04-29 03:09:52', 'username60', 'password60', 'Active'),
(61, 'name61', 2, '2022-04-29 03:09:52', 'username61', 'password61', 'Active'),
(62, 'name62', 3, '2022-04-29 03:09:52', 'username62', 'password62', 'Active'),
(63, 'name63', 3, '2022-04-29 03:09:52', 'username63', 'password63', 'Active'),
(64, 'name64', 1, '2022-04-29 03:09:52', 'username64', 'password64', 'Active'),
(65, 'name65', 1, '2022-04-29 03:09:52', 'username65', 'password65', 'Active'),
(66, 'name66', 1, '2022-04-29 03:09:52', 'username66', 'password66', 'Active'),
(68, 'name68', 3, '2022-04-29 03:09:52', 'username68', 'password68', 'Active'),
(69, 'name69', 3, '2022-04-29 03:09:52', 'username69', 'password69', 'Active'),
(70, 'name70', 1, '2022-04-29 03:09:52', 'username70', 'password70', 'Active'),
(71, 'name71', 2, '2022-04-29 03:09:52', 'username71', 'password71', 'Active'),
(73, 'name73', 3, '2022-04-29 03:09:52', 'username73', 'password73', 'Active'),
(74, 'name74', 1, '2022-04-29 03:09:52', 'username74', 'password74', 'Active'),
(75, 'name75', 3, '2022-04-29 03:09:52', 'username75', 'password75', 'Active'),
(77, 'name77', 2, '2022-04-29 03:09:52', 'username77', 'password77', 'Active'),
(79, 'name79', 1, '2022-04-29 03:09:52', 'username79', 'password79', 'Active'),
(80, 'name80', 2, '2022-04-29 03:09:52', 'username80', 'password80', 'Active'),
(82, 'name82', 2, '2022-04-29 03:09:52', 'username82', 'password82', 'Active'),
(83, 'name83', 2, '2022-04-29 03:09:52', 'username83', 'password83', 'Active'),
(84, 'name84', 1, '2022-04-29 03:09:52', 'username84', 'password84', 'Active'),
(85, 'name85', 2, '2022-04-29 03:09:52', 'username85', 'password85', 'Active'),
(86, 'name86', 3, '2022-04-29 03:09:52', 'username86', 'password86', 'Active'),
(87, 'name87', 2, '2022-04-29 03:09:52', 'username87', 'password87', 'Active'),
(88, 'name88', 3, '2022-04-29 03:09:52', 'username88', 'password88', 'Active'),
(90, 'name90', 2, '2022-04-29 03:09:52', 'username90', 'password90', 'Active'),
(91, 'name91', 3, '2022-04-29 03:09:52', 'username91', 'password91', 'Active'),
(92, 'name92', 1, '2022-04-29 03:09:52', 'username92', 'password92', 'Active'),
(93, 'name93', 1, '2022-04-29 03:09:52', 'username93', 'password93', 'Active'),
(95, 'name95', 2, '2022-04-29 03:09:52', 'username95', 'password95', 'Active'),
(96, 'name96', 1, '2022-04-29 03:09:52', 'username96', 'password96', 'Active'),
(97, 'name97', 1, '2022-04-29 03:09:52', 'username97', 'password97', 'Active'),
(98, 'name98', 1, '2022-04-29 03:09:52', 'username98', 'password98', 'Active'),
(99, 'name99', 1, '2022-04-29 03:09:52', 'username99', 'password99', 'Active'),
(100, 'name100', 1, '2022-04-29 03:09:52', 'username100', 'password100', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `AccountLog`
--

CREATE TABLE `AccountLog` (
  `LogID` int(5) NOT NULL,
  `AccountID` int(5) NOT NULL,
  `Date` datetime NOT NULL DEFAULT current_timestamp(),
  `OperationFlag` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Role`
--

CREATE TABLE `Role` (
  `RoleID` int(5) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Descriptions` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Role`
--

INSERT INTO `Role` (`RoleID`, `Name`, `Descriptions`) VALUES
(1, 'Restaurant Manager', 'This is Rsstaurant Manager'),
(2, 'Staff', 'This is Staff'),
(3, 'Restaurant Owner', 'This is Restaurant Owner'),
(4, 'User Admin', 'This is User Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Account`
--
ALTER TABLE `Account`
  ADD PRIMARY KEY (`AccountID`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD KEY `RoleID` (`RoleID`);

--
-- Indexes for table `AccountLog`
--
ALTER TABLE `AccountLog`
  ADD PRIMARY KEY (`LogID`),
  ADD KEY `AccountID` (`AccountID`);

--
-- Indexes for table `Role`
--
ALTER TABLE `Role`
  ADD PRIMARY KEY (`RoleID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Account`
--
ALTER TABLE `Account`
  MODIFY `AccountID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `AccountLog`
--
ALTER TABLE `AccountLog`
  MODIFY `LogID` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Role`
--
ALTER TABLE `Role`
  MODIFY `RoleID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Account`
--
ALTER TABLE `Account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`RoleID`) REFERENCES `Role` (`RoleID`);

--
-- Constraints for table `AccountLog`
--
ALTER TABLE `AccountLog`
  ADD CONSTRAINT `accountlog_ibfk_1` FOREIGN KEY (`AccountID`) REFERENCES `Account` (`AccountID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
