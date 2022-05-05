-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 05, 2022 at 12:14 PM
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
  `Status` varchar(20) NOT NULL DEFAULT 'Available'
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
  `UpdatedAt` datetime DEFAULT NULL,
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
  MODIFY `AccountID` int(5) NOT NULL AUTO_INCREMENT;

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
  MODIFY `RoleID` int(5) NOT NULL AUTO_INCREMENT;

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
