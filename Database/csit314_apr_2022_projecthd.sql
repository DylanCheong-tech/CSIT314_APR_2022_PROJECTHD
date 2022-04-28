-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 28, 2022 at 07:02 AM
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
(1, 'name1', 2, '2022-04-28 05:01:33', 'username1', 'password1', 'Active'),
(2, 'name2', 1, '2022-04-28 05:01:33', 'username2', 'password2', 'Active'),
(3, 'name3', 2, '2022-04-28 05:01:33', 'username3', 'password3', 'Active'),
(4, 'name4', 3, '2022-04-28 05:01:33', 'username4', 'password4', 'Active'),
(5, 'name5', 1, '2022-04-28 05:01:33', 'username5', 'password5', 'Active'),
(6, 'name6', 2, '2022-04-28 05:01:33', 'username6', 'password6', 'Active'),
(7, 'name7', 2, '2022-04-28 05:01:33', 'username7', 'password7', 'Active'),
(8, 'name8', 1, '2022-04-28 05:01:33', 'username8', 'password8', 'Active'),
(9, 'name9', 1, '2022-04-28 05:01:33', 'username9', 'password9', 'Active'),
(10, 'name10', 3, '2022-04-28 05:01:33', 'username10', 'password10', 'Active'),
(11, 'name11', 3, '2022-04-28 05:01:33', 'username11', 'password11', 'Active'),
(12, 'name12', 1, '2022-04-28 05:01:33', 'username12', 'password12', 'Active'),
(13, 'name13', 3, '2022-04-28 05:01:33', 'username13', 'password13', 'Active'),
(14, 'name14', 1, '2022-04-28 05:01:33', 'username14', 'password14', 'Active'),
(15, 'name15', 2, '2022-04-28 05:01:33', 'username15', 'password15', 'Active'),
(16, 'name16', 3, '2022-04-28 05:01:33', 'username16', 'password16', 'Active'),
(17, 'name17', 1, '2022-04-28 05:01:33', 'username17', 'password17', 'Active'),
(18, 'name18', 2, '2022-04-28 05:01:33', 'username18', 'password18', 'Active'),
(19, 'name19', 1, '2022-04-28 05:01:33', 'username19', 'password19', 'Active'),
(20, 'name20', 1, '2022-04-28 05:01:33', 'username20', 'password20', 'Active'),
(21, 'name21', 2, '2022-04-28 05:01:33', 'username21', 'password21', 'Active'),
(22, 'name22', 2, '2022-04-28 05:01:33', 'username22', 'password22', 'Active'),
(23, 'name23', 1, '2022-04-28 05:01:33', 'username23', 'password23', 'Active'),
(24, 'name24', 1, '2022-04-28 05:01:33', 'username24', 'password24', 'Active'),
(25, 'name25', 2, '2022-04-28 05:01:33', 'username25', 'password25', 'Active'),
(26, 'name26', 2, '2022-04-28 05:01:33', 'username26', 'password26', 'Active'),
(27, 'name27', 1, '2022-04-28 05:01:33', 'username27', 'password27', 'Active'),
(28, 'name28', 3, '2022-04-28 05:01:33', 'username28', 'password28', 'Active'),
(29, 'name29', 3, '2022-04-28 05:01:33', 'username29', 'password29', 'Active'),
(30, 'name30', 2, '2022-04-28 05:01:33', 'username30', 'password30', 'Active'),
(31, 'name31', 3, '2022-04-28 05:01:33', 'username31', 'password31', 'Active'),
(32, 'name32', 2, '2022-04-28 05:01:33', 'username32', 'password32', 'Active'),
(33, 'name33', 1, '2022-04-28 05:01:33', 'username33', 'password33', 'Active'),
(34, 'name34', 1, '2022-04-28 05:01:33', 'username34', 'password34', 'Active'),
(35, 'name35', 1, '2022-04-28 05:01:33', 'username35', 'password35', 'Active'),
(36, 'name36', 1, '2022-04-28 05:01:33', 'username36', 'password36', 'Active'),
(37, 'name37', 2, '2022-04-28 05:01:33', 'username37', 'password37', 'Active'),
(38, 'name38', 3, '2022-04-28 05:01:33', 'username38', 'password38', 'Active'),
(39, 'name39', 2, '2022-04-28 05:01:33', 'username39', 'password39', 'Active'),
(40, 'name40', 2, '2022-04-28 05:01:33', 'username40', 'password40', 'Active'),
(41, 'name41', 2, '2022-04-28 05:01:33', 'username41', 'password41', 'Active'),
(42, 'name42', 1, '2022-04-28 05:01:33', 'username42', 'password42', 'Active'),
(43, 'name43', 2, '2022-04-28 05:01:33', 'username43', 'password43', 'Active'),
(44, 'name44', 1, '2022-04-28 05:01:33', 'username44', 'password44', 'Active'),
(45, 'name45', 3, '2022-04-28 05:01:33', 'username45', 'password45', 'Active'),
(46, 'name46', 1, '2022-04-28 05:01:33', 'username46', 'password46', 'Active'),
(47, 'name47', 1, '2022-04-28 05:01:33', 'username47', 'password47', 'Active'),
(48, 'name48', 2, '2022-04-28 05:01:33', 'username48', 'password48', 'Active'),
(49, 'name49', 3, '2022-04-28 05:01:33', 'username49', 'password49', 'Active'),
(50, 'name50', 1, '2022-04-28 05:01:33', 'username50', 'password50', 'Active'),
(51, 'name51', 1, '2022-04-28 05:01:33', 'username51', 'password51', 'Active'),
(52, 'name52', 1, '2022-04-28 05:01:33', 'username52', 'password52', 'Active'),
(53, 'name53', 1, '2022-04-28 05:01:33', 'username53', 'password53', 'Active'),
(54, 'name54', 3, '2022-04-28 05:01:33', 'username54', 'password54', 'Active'),
(55, 'name55', 2, '2022-04-28 05:01:33', 'username55', 'password55', 'Active'),
(56, 'name56', 1, '2022-04-28 05:01:33', 'username56', 'password56', 'Active'),
(57, 'name57', 2, '2022-04-28 05:01:33', 'username57', 'password57', 'Active'),
(58, 'name58', 1, '2022-04-28 05:01:33', 'username58', 'password58', 'Active'),
(59, 'name59', 3, '2022-04-28 05:01:33', 'username59', 'password59', 'Active'),
(60, 'name60', 3, '2022-04-28 05:01:33', 'username60', 'password60', 'Active'),
(61, 'name61', 2, '2022-04-28 05:01:33', 'username61', 'password61', 'Active'),
(62, 'name62', 1, '2022-04-28 05:01:33', 'username62', 'password62', 'Active'),
(63, 'name63', 3, '2022-04-28 05:01:33', 'username63', 'password63', 'Active'),
(64, 'name64', 1, '2022-04-28 05:01:33', 'username64', 'password64', 'Active'),
(65, 'name65', 2, '2022-04-28 05:01:33', 'username65', 'password65', 'Active'),
(66, 'name66', 2, '2022-04-28 05:01:33', 'username66', 'password66', 'Active'),
(67, 'name67', 3, '2022-04-28 05:01:33', 'username67', 'password67', 'Active'),
(68, 'name68', 2, '2022-04-28 05:01:33', 'username68', 'password68', 'Active'),
(69, 'name69', 3, '2022-04-28 05:01:33', 'username69', 'password69', 'Active'),
(70, 'name70', 1, '2022-04-28 05:01:33', 'username70', 'password70', 'Active'),
(71, 'name71', 3, '2022-04-28 05:01:33', 'username71', 'password71', 'Active'),
(72, 'name72', 1, '2022-04-28 05:01:33', 'username72', 'password72', 'Active'),
(73, 'name73', 2, '2022-04-28 05:01:33', 'username73', 'password73', 'Active'),
(74, 'name74', 2, '2022-04-28 05:01:33', 'username74', 'password74', 'Active'),
(75, 'name75', 2, '2022-04-28 05:01:33', 'username75', 'password75', 'Active'),
(76, 'name76', 1, '2022-04-28 05:01:33', 'username76', 'password76', 'Active'),
(77, 'name77', 3, '2022-04-28 05:01:33', 'username77', 'password77', 'Active'),
(78, 'name78', 2, '2022-04-28 05:01:33', 'username78', 'password78', 'Active'),
(79, 'name79', 2, '2022-04-28 05:01:33', 'username79', 'password79', 'Active'),
(80, 'name80', 2, '2022-04-28 05:01:33', 'username80', 'password80', 'Active'),
(81, 'name81', 1, '2022-04-28 05:01:33', 'username81', 'password81', 'Active'),
(82, 'name82', 1, '2022-04-28 05:01:33', 'username82', 'password82', 'Active'),
(83, 'name83', 1, '2022-04-28 05:01:33', 'username83', 'password83', 'Active'),
(84, 'name84', 2, '2022-04-28 05:01:33', 'username84', 'password84', 'Active'),
(85, 'name85', 1, '2022-04-28 05:01:33', 'username85', 'password85', 'Active'),
(86, 'name86', 2, '2022-04-28 05:01:33', 'username86', 'password86', 'Active'),
(87, 'name87', 2, '2022-04-28 05:01:33', 'username87', 'password87', 'Active'),
(88, 'name88', 3, '2022-04-28 05:01:33', 'username88', 'password88', 'Active'),
(89, 'name89', 1, '2022-04-28 05:01:33', 'username89', 'password89', 'Active'),
(90, 'name90', 2, '2022-04-28 05:01:33', 'username90', 'password90', 'Active'),
(91, 'name91', 2, '2022-04-28 05:01:33', 'username91', 'password91', 'Active'),
(92, 'name92', 3, '2022-04-28 05:01:33', 'username92', 'password92', 'Active'),
(93, 'name93', 1, '2022-04-28 05:01:33', 'username93', 'password93', 'Active'),
(94, 'name94', 1, '2022-04-28 05:01:33', 'username94', 'password94', 'Active'),
(95, 'name95', 1, '2022-04-28 05:01:33', 'username95', 'password95', 'Active'),
(96, 'name96', 3, '2022-04-28 05:01:33', 'username96', 'password96', 'Active'),
(97, 'name97', 2, '2022-04-28 05:01:33', 'username97', 'password97', 'Active'),
(98, 'name98', 1, '2022-04-28 05:01:33', 'username98', 'password98', 'Active'),
(99, 'name99', 3, '2022-04-28 05:01:33', 'username99', 'password99', 'Active'),
(100, 'name100', 3, '2022-04-28 05:01:33', 'username100', 'password100', 'Active');

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
(1, 'Restaurant Owner', 'This is Rsstaurant Manager'),
(2, 'Staff', 'This is Staff'),
(3, 'Restaurant Owner', 'This is Restaurant Owner');

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
  MODIFY `RoleID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
