-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 03, 2022 at 04:02 AM
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
(1, 'Test Account 1', 2, '2022-05-03 02:01:08', 'username1', 'password1', 'Active'),
(2, 'Test Account 2', 3, '2022-05-03 02:01:08', 'username2', 'password2', 'Active'),
(3, 'Test Account 3', 1, '2022-05-03 02:01:08', 'username3', 'password3', 'Active'),
(4, 'Test Account 4', 2, '2022-05-03 02:01:08', 'username4', 'password4', 'Active'),
(5, 'Test Account 5', 1, '2022-05-03 02:01:08', 'username5', 'password5', 'Active'),
(6, 'Test Account 6', 1, '2022-05-03 02:01:08', 'username6', 'password6', 'Active'),
(7, 'Test Account 7', 3, '2022-05-03 02:01:08', 'username7', 'password7', 'Active'),
(8, 'Test Account 8', 2, '2022-05-03 02:01:08', 'username8', 'password8', 'Active'),
(9, 'Test Account 9', 1, '2022-05-03 02:01:08', 'username9', 'password9', 'Active'),
(10, 'Test Account 10', 3, '2022-05-03 02:01:08', 'username10', 'password10', 'Active'),
(11, 'Test Account 11', 2, '2022-05-03 02:01:08', 'username11', 'password11', 'Active'),
(12, 'Test Account 12', 3, '2022-05-03 02:01:08', 'username12', 'password12', 'Active'),
(13, 'Test Account 13', 3, '2022-05-03 02:01:08', 'username13', 'password13', 'Active'),
(14, 'Test Account 14', 1, '2022-05-03 02:01:08', 'username14', 'password14', 'Active'),
(15, 'Test Account 15', 2, '2022-05-03 02:01:08', 'username15', 'password15', 'Active'),
(16, 'Test Account 16', 2, '2022-05-03 02:01:08', 'username16', 'password16', 'Active'),
(17, 'Test Account 17', 3, '2022-05-03 02:01:08', 'username17', 'password17', 'Active'),
(18, 'Test Account 18', 1, '2022-05-03 02:01:08', 'username18', 'password18', 'Active'),
(19, 'Test Account 19', 2, '2022-05-03 02:01:08', 'username19', 'password19', 'Active'),
(20, 'Test Account 20', 1, '2022-05-03 02:01:08', 'username20', 'password20', 'Active'),
(21, 'Test Account 21', 3, '2022-05-03 02:01:08', 'username21', 'password21', 'Active'),
(22, 'Test Account 22', 3, '2022-05-03 02:01:08', 'username22', 'password22', 'Active'),
(23, 'Test Account 23', 3, '2022-05-03 02:01:08', 'username23', 'password23', 'Active'),
(24, 'Test Account 24', 1, '2022-05-03 02:01:08', 'username24', 'password24', 'Active'),
(25, 'Test Account 25', 1, '2022-05-03 02:01:08', 'username25', 'password25', 'Active'),
(26, 'Test Account 26', 3, '2022-05-03 02:01:08', 'username26', 'password26', 'Active'),
(27, 'Test Account 27', 1, '2022-05-03 02:01:08', 'username27', 'password27', 'Active'),
(28, 'Test Account 28', 2, '2022-05-03 02:01:08', 'username28', 'password28', 'Active'),
(29, 'Test Account 29', 3, '2022-05-03 02:01:08', 'username29', 'password29', 'Active'),
(30, 'Test Account 30', 2, '2022-05-03 02:01:08', 'username30', 'password30', 'Active'),
(31, 'Test Account 31', 1, '2022-05-03 02:01:08', 'username31', 'password31', 'Active'),
(32, 'Test Account 32', 3, '2022-05-03 02:01:08', 'username32', 'password32', 'Active'),
(33, 'Test Account 33', 3, '2022-05-03 02:01:08', 'username33', 'password33', 'Active'),
(34, 'Test Account 34', 3, '2022-05-03 02:01:08', 'username34', 'password34', 'Active'),
(35, 'Test Account 35', 3, '2022-05-03 02:01:08', 'username35', 'password35', 'Active'),
(36, 'Test Account 36', 2, '2022-05-03 02:01:08', 'username36', 'password36', 'Active'),
(37, 'Test Account 37', 3, '2022-05-03 02:01:08', 'username37', 'password37', 'Active'),
(38, 'Test Account 38', 1, '2022-05-03 02:01:08', 'username38', 'password38', 'Active'),
(39, 'Test Account 39', 3, '2022-05-03 02:01:08', 'username39', 'password39', 'Active'),
(40, 'Test Account 40', 1, '2022-05-03 02:01:08', 'username40', 'password40', 'Active'),
(41, 'Test Account 41', 1, '2022-05-03 02:01:08', 'username41', 'password41', 'Active'),
(42, 'Test Account 42', 1, '2022-05-03 02:01:08', 'username42', 'password42', 'Active'),
(43, 'Test Account 43', 2, '2022-05-03 02:01:08', 'username43', 'password43', 'Active'),
(44, 'Test Account 44', 3, '2022-05-03 02:01:08', 'username44', 'password44', 'Active'),
(45, 'Test Account 45', 1, '2022-05-03 02:01:08', 'username45', 'password45', 'Active'),
(46, 'Test Account 46', 3, '2022-05-03 02:01:08', 'username46', 'password46', 'Active'),
(47, 'Test Account 47', 1, '2022-05-03 02:01:08', 'username47', 'password47', 'Active'),
(48, 'Test Account 48', 3, '2022-05-03 02:01:08', 'username48', 'password48', 'Active'),
(49, 'Test Account 49', 1, '2022-05-03 02:01:08', 'username49', 'password49', 'Active'),
(50, 'Test Account 50', 2, '2022-05-03 02:01:08', 'username50', 'password50', 'Active'),
(51, 'Test Account 51', 3, '2022-05-03 02:01:08', 'username51', 'password51', 'Active'),
(52, 'Test Account 52', 3, '2022-05-03 02:01:08', 'username52', 'password52', 'Active'),
(53, 'Test Account 53', 2, '2022-05-03 02:01:08', 'username53', 'password53', 'Active'),
(54, 'Test Account 54', 3, '2022-05-03 02:01:08', 'username54', 'password54', 'Active'),
(55, 'Test Account 55', 3, '2022-05-03 02:01:08', 'username55', 'password55', 'Active'),
(56, 'Test Account 56', 2, '2022-05-03 02:01:08', 'username56', 'password56', 'Active'),
(57, 'Test Account 57', 2, '2022-05-03 02:01:08', 'username57', 'password57', 'Active'),
(58, 'Test Account 58', 3, '2022-05-03 02:01:08', 'username58', 'password58', 'Active'),
(59, 'Test Account 59', 3, '2022-05-03 02:01:08', 'username59', 'password59', 'Active'),
(60, 'Test Account 60', 1, '2022-05-03 02:01:08', 'username60', 'password60', 'Active'),
(61, 'Test Account 61', 2, '2022-05-03 02:01:08', 'username61', 'password61', 'Active'),
(62, 'Test Account 62', 1, '2022-05-03 02:01:08', 'username62', 'password62', 'Active'),
(63, 'Test Account 63', 3, '2022-05-03 02:01:08', 'username63', 'password63', 'Active'),
(64, 'Test Account 64', 3, '2022-05-03 02:01:08', 'username64', 'password64', 'Active'),
(65, 'Test Account 65', 1, '2022-05-03 02:01:08', 'username65', 'password65', 'Active'),
(66, 'Test Account 66', 2, '2022-05-03 02:01:08', 'username66', 'password66', 'Active'),
(67, 'Test Account 67', 3, '2022-05-03 02:01:08', 'username67', 'password67', 'Active'),
(68, 'Test Account 68', 3, '2022-05-03 02:01:08', 'username68', 'password68', 'Active'),
(69, 'Test Account 69', 3, '2022-05-03 02:01:08', 'username69', 'password69', 'Active'),
(70, 'Test Account 70', 3, '2022-05-03 02:01:08', 'username70', 'password70', 'Active'),
(71, 'Test Account 71', 1, '2022-05-03 02:01:08', 'username71', 'password71', 'Active'),
(72, 'Test Account 72', 1, '2022-05-03 02:01:08', 'username72', 'password72', 'Active'),
(73, 'Test Account 73', 2, '2022-05-03 02:01:08', 'username73', 'password73', 'Active'),
(74, 'Test Account 74', 3, '2022-05-03 02:01:08', 'username74', 'password74', 'Active'),
(75, 'Test Account 75', 1, '2022-05-03 02:01:08', 'username75', 'password75', 'Active'),
(76, 'Test Account 76', 1, '2022-05-03 02:01:08', 'username76', 'password76', 'Active'),
(77, 'Test Account 77', 1, '2022-05-03 02:01:08', 'username77', 'password77', 'Active'),
(78, 'Test Account 78', 2, '2022-05-03 02:01:08', 'username78', 'password78', 'Active'),
(79, 'Test Account 79', 1, '2022-05-03 02:01:08', 'username79', 'password79', 'Active'),
(80, 'Test Account 80', 2, '2022-05-03 02:01:08', 'username80', 'password80', 'Active'),
(81, 'Test Account 81', 2, '2022-05-03 02:01:08', 'username81', 'password81', 'Active'),
(82, 'Test Account 82', 3, '2022-05-03 02:01:08', 'username82', 'password82', 'Active'),
(83, 'Test Account 83', 3, '2022-05-03 02:01:08', 'username83', 'password83', 'Active'),
(84, 'Test Account 84', 1, '2022-05-03 02:01:08', 'username84', 'password84', 'Active'),
(85, 'Test Account 85', 1, '2022-05-03 02:01:08', 'username85', 'password85', 'Active'),
(86, 'Test Account 86', 2, '2022-05-03 02:01:08', 'username86', 'password86', 'Active'),
(87, 'Test Account 87', 1, '2022-05-03 02:01:08', 'username87', 'password87', 'Active'),
(88, 'Test Account 88', 3, '2022-05-03 02:01:08', 'username88', 'password88', 'Active'),
(89, 'Test Account 89', 2, '2022-05-03 02:01:08', 'username89', 'password89', 'Active'),
(90, 'Test Account 90', 3, '2022-05-03 02:01:08', 'username90', 'password90', 'Active'),
(91, 'Test Account 91', 1, '2022-05-03 02:01:08', 'username91', 'password91', 'Active'),
(92, 'Test Account 92', 2, '2022-05-03 02:01:08', 'username92', 'password92', 'Active'),
(93, 'Test Account 93', 2, '2022-05-03 02:01:08', 'username93', 'password93', 'Active'),
(94, 'Test Account 94', 3, '2022-05-03 02:01:08', 'username94', 'password94', 'Active'),
(95, 'Test Account 95', 2, '2022-05-03 02:01:08', 'username95', 'password95', 'Active'),
(96, 'Test Account 96', 3, '2022-05-03 02:01:08', 'username96', 'password96', 'Active'),
(97, 'Test Account 97', 3, '2022-05-03 02:01:08', 'username97', 'password97', 'Active'),
(98, 'Test Account 98', 2, '2022-05-03 02:01:08', 'username98', 'password98', 'Active'),
(99, 'Test Account 99', 3, '2022-05-03 02:01:08', 'username99', 'password99', 'Active'),
(100, 'Test Account 100', 1, '2022-05-03 02:01:08', 'username100', 'password100', 'Active');

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
-- Table structure for table `Coupon`
--

CREATE TABLE `Coupon` (
  `CouponID` int(5) NOT NULL,
  `Code` varchar(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Descriptions` varchar(1000) NOT NULL,
  `DiscountType` varchar(50) NOT NULL,
  `DiscountAmount` decimal(10,2) NOT NULL,
  `Status` varchar(20) NOT NULL DEFAULT 'Available',
  `CreatedAt` datetime NOT NULL DEFAULT current_timestamp(),
  `UpdatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `MenuItem`
--

CREATE TABLE `MenuItem` (
  `MenuItemID` int(5) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  `Descriptions` varchar(1000) NOT NULL,
  `Status` varchar(20) NOT NULL DEFAULT 'Available',
  `CreatedAt` datetime NOT NULL DEFAULT current_timestamp(),
  `UpdatedAt` datetime NOT NULL,
  `ImageDataURL` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Role`
--

CREATE TABLE `Role` (
  `RoleID` int(5) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Descriptions` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Role`
--

INSERT INTO `Role` (`RoleID`, `Name`, `Descriptions`) VALUES
(1, 'Restaurant Manager', 'This is Restaurant Manager'),
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
-- Indexes for table `Coupon`
--
ALTER TABLE `Coupon`
  ADD PRIMARY KEY (`CouponID`);

--
-- Indexes for table `MenuItem`
--
ALTER TABLE `MenuItem`
  ADD PRIMARY KEY (`MenuItemID`);

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
-- AUTO_INCREMENT for table `Coupon`
--
ALTER TABLE `Coupon`
  MODIFY `CouponID` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `MenuItem`
--
ALTER TABLE `MenuItem`
  MODIFY `MenuItemID` int(5) NOT NULL AUTO_INCREMENT;

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
