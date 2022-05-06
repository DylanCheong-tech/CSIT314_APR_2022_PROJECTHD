-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 06, 2022 at 02:34 PM
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
(1, 'Test Account 1', 1, '2022-05-05 10:26:52', 'username1', 'password1', 'Active'),
(2, 'Test Account 2', 4, '2022-05-05 10:26:53', 'username2', 'password2', 'Active'),
(3, 'Test Account 3', 2, '2022-05-05 10:26:53', 'username3', 'password3', 'Active'),
(4, 'Test Account 4', 3, '2022-05-05 10:26:53', 'username4', 'password4', 'Active'),
(5, 'Test Account 5', 1, '2022-05-05 10:26:53', 'username5', 'password5', 'Active'),
(6, 'Test Account 6', 1, '2022-05-05 10:26:53', 'username6', 'password6', 'Active'),
(7, 'Test Account 7', 4, '2022-05-05 10:26:53', 'username7', 'password7', 'Active'),
(8, 'Test Account 8', 1, '2022-05-05 10:26:53', 'username8', 'password8', 'Active'),
(9, 'Test Account 9', 2, '2022-05-05 10:26:53', 'username9', 'password9', 'Active'),
(10, 'Test Account 10', 4, '2022-05-05 10:26:53', 'username10', 'password10', 'Active'),
(11, 'Test Account 11', 2, '2022-05-05 10:26:53', 'username11', 'password11', 'Active'),
(12, 'Test Account 12', 1, '2022-05-05 10:26:53', 'username12', 'password12', 'Active'),
(13, 'Test Account 13', 3, '2022-05-05 10:26:53', 'username13', 'password13', 'Active'),
(14, 'Test Account 14', 2, '2022-05-05 10:26:53', 'username14', 'password14', 'Active'),
(15, 'Test Account 15', 1, '2022-05-05 10:26:53', 'username15', 'password15', 'Active'),
(16, 'Test Account 16', 2, '2022-05-05 10:26:53', 'username16', 'password16', 'Active'),
(17, 'Test Account 17', 3, '2022-05-05 10:26:53', 'username17', 'password17', 'Active'),
(18, 'Test Account 18', 4, '2022-05-05 10:26:53', 'username18', 'password18', 'Active'),
(19, 'Test Account 19', 3, '2022-05-05 10:26:53', 'username19', 'password19', 'Active'),
(20, 'Test Account 20', 2, '2022-05-05 10:26:53', 'username20', 'password20', 'Active'),
(21, 'Test Account 21', 3, '2022-05-05 10:26:53', 'username21', 'password21', 'Active'),
(22, 'Test Account 22', 4, '2022-05-05 10:26:53', 'username22', 'password22', 'Active'),
(23, 'Test Account 23', 2, '2022-05-05 10:26:53', 'username23', 'password23', 'Active'),
(24, 'Test Account 24', 4, '2022-05-05 10:26:53', 'username24', 'password24', 'Active'),
(25, 'Test Account 25', 1, '2022-05-05 10:26:53', 'username25', 'password25', 'Active'),
(26, 'Test Account 26', 4, '2022-05-05 10:26:53', 'username26', 'password26', 'Active'),
(27, 'Test Account 27', 2, '2022-05-05 10:26:53', 'username27', 'password27', 'Active'),
(28, 'Test Account 28', 2, '2022-05-05 10:26:53', 'username28', 'password28', 'Active'),
(29, 'Test Account 29', 3, '2022-05-05 10:26:53', 'username29', 'password29', 'Active'),
(30, 'Test Account 30', 1, '2022-05-05 10:26:53', 'username30', 'password30', 'Active'),
(31, 'Test Account 31', 4, '2022-05-05 10:26:53', 'username31', 'password31', 'Active'),
(32, 'Test Account 32', 1, '2022-05-05 10:26:53', 'username32', 'password32', 'Active'),
(33, 'Test Account 33', 4, '2022-05-05 10:26:53', 'username33', 'password33', 'Active'),
(34, 'Test Account 34', 2, '2022-05-05 10:26:53', 'username34', 'password34', 'Active'),
(35, 'Test Account 35', 3, '2022-05-05 10:26:53', 'username35', 'password35', 'Active'),
(36, 'Test Account 36', 1, '2022-05-05 10:26:53', 'username36', 'password36', 'Active'),
(37, 'Test Account 37', 3, '2022-05-05 10:26:53', 'username37', 'password37', 'Active'),
(38, 'Test Account 38', 3, '2022-05-05 10:26:53', 'username38', 'password38', 'Active'),
(39, 'Test Account 39', 3, '2022-05-05 10:26:53', 'username39', 'password39', 'Active'),
(40, 'Test Account 40', 4, '2022-05-05 10:26:53', 'username40', 'password40', 'Active'),
(41, 'Test Account 41', 1, '2022-05-05 10:26:53', 'username41', 'password41', 'Active'),
(42, 'Test Account 42', 1, '2022-05-05 10:26:53', 'username42', 'password42', 'Active'),
(43, 'Test Account 43', 4, '2022-05-05 10:26:53', 'username43', 'password43', 'Active'),
(44, 'Test Account 44', 3, '2022-05-05 10:26:53', 'username44', 'password44', 'Active'),
(45, 'Test Account 45', 2, '2022-05-05 10:26:53', 'username45', 'password45', 'Active'),
(46, 'Test Account 46', 2, '2022-05-05 10:26:53', 'username46', 'password46', 'Active'),
(47, 'Test Account 47', 4, '2022-05-05 10:26:53', 'username47', 'password47', 'Active'),
(48, 'Test Account 48', 3, '2022-05-05 10:26:53', 'username48', 'password48', 'Active'),
(49, 'Test Account 49', 2, '2022-05-05 10:26:53', 'username49', 'password49', 'Active'),
(50, 'Test Account 50', 2, '2022-05-05 10:26:53', 'username50', 'password50', 'Active'),
(51, 'Test Account 51', 4, '2022-05-05 10:26:53', 'username51', 'password51', 'Active'),
(52, 'Test Account 52', 1, '2022-05-05 10:26:53', 'username52', 'password52', 'Active'),
(53, 'Test Account 53', 1, '2022-05-05 10:26:53', 'username53', 'password53', 'Active'),
(54, 'Test Account 54', 4, '2022-05-05 10:26:53', 'username54', 'password54', 'Active'),
(55, 'Test Account 55', 2, '2022-05-05 10:26:53', 'username55', 'password55', 'Active'),
(56, 'Test Account 56', 1, '2022-05-05 10:26:53', 'username56', 'password56', 'Active'),
(57, 'Test Account 57', 1, '2022-05-05 10:26:53', 'username57', 'password57', 'Active'),
(58, 'Test Account 58', 3, '2022-05-05 10:26:53', 'username58', 'password58', 'Active'),
(59, 'Test Account 59', 4, '2022-05-05 10:26:53', 'username59', 'password59', 'Active'),
(60, 'Test Account 60', 1, '2022-05-05 10:26:53', 'username60', 'password60', 'Active'),
(61, 'Test Account 61', 4, '2022-05-05 10:26:53', 'username61', 'password61', 'Active'),
(62, 'Test Account 62', 3, '2022-05-05 10:26:53', 'username62', 'password62', 'Active'),
(63, 'Test Account 63', 2, '2022-05-05 10:26:53', 'username63', 'password63', 'Active'),
(64, 'Test Account 64', 4, '2022-05-05 10:26:53', 'username64', 'password64', 'Active'),
(65, 'Test Account 65', 3, '2022-05-05 10:26:53', 'username65', 'password65', 'Active'),
(66, 'Test Account 66', 1, '2022-05-05 10:26:53', 'username66', 'password66', 'Active'),
(67, 'Test Account 67', 2, '2022-05-05 10:26:53', 'username67', 'password67', 'Active'),
(68, 'Test Account 68', 1, '2022-05-05 10:26:53', 'username68', 'password68', 'Active'),
(69, 'Test Account 69', 1, '2022-05-05 10:26:53', 'username69', 'password69', 'Active'),
(70, 'Test Account 70', 2, '2022-05-05 10:26:53', 'username70', 'password70', 'Active'),
(71, 'Test Account 71', 3, '2022-05-05 10:26:53', 'username71', 'password71', 'Active'),
(72, 'Test Account 72', 2, '2022-05-05 10:26:53', 'username72', 'password72', 'Active'),
(73, 'Test Account 73', 3, '2022-05-05 10:26:53', 'username73', 'password73', 'Active'),
(74, 'Test Account 74', 1, '2022-05-05 10:26:53', 'username74', 'password74', 'Active'),
(75, 'Test Account 75', 3, '2022-05-05 10:26:53', 'username75', 'password75', 'Active'),
(76, 'Test Account 76', 2, '2022-05-05 10:26:53', 'username76', 'password76', 'Active'),
(77, 'Test Account 77', 2, '2022-05-05 10:26:53', 'username77', 'password77', 'Active'),
(78, 'Test Account 78', 3, '2022-05-05 10:26:53', 'username78', 'password78', 'Active'),
(79, 'Test Account 79', 1, '2022-05-05 10:26:53', 'username79', 'password79', 'Active'),
(80, 'Test Account 80', 3, '2022-05-05 10:26:53', 'username80', 'password80', 'Active'),
(81, 'Test Account 81', 3, '2022-05-05 10:26:53', 'username81', 'password81', 'Active'),
(82, 'Test Account 82', 1, '2022-05-05 10:26:53', 'username82', 'password82', 'Active'),
(83, 'Test Account 83', 3, '2022-05-05 10:26:53', 'username83', 'password83', 'Active'),
(84, 'Test Account 84', 3, '2022-05-05 10:26:53', 'username84', 'password84', 'Active'),
(85, 'Test Account 85', 3, '2022-05-05 10:26:53', 'username85', 'password85', 'Active'),
(86, 'Test Account 86', 1, '2022-05-05 10:26:53', 'username86', 'password86', 'Active'),
(87, 'Test Account 87', 4, '2022-05-05 10:26:53', 'username87', 'password87', 'Active'),
(88, 'Test Account 88', 3, '2022-05-05 10:26:53', 'username88', 'password88', 'Active'),
(89, 'Test Account 89', 2, '2022-05-05 10:26:53', 'username89', 'password89', 'Active'),
(90, 'Test Account 90', 3, '2022-05-05 10:26:53', 'username90', 'password90', 'Active'),
(91, 'Test Account 91', 1, '2022-05-05 10:26:53', 'username91', 'password91', 'Active'),
(92, 'Test Account 92', 4, '2022-05-05 10:26:53', 'username92', 'password92', 'Active'),
(93, 'Test Account 93', 3, '2022-05-05 10:26:53', 'username93', 'password93', 'Active'),
(94, 'Test Account 94', 1, '2022-05-05 10:26:53', 'username94', 'password94', 'Active'),
(95, 'Test Account 95', 2, '2022-05-05 10:26:53', 'username95', 'password95', 'Active'),
(96, 'Test Account 96', 3, '2022-05-05 10:26:53', 'username96', 'password96', 'Active'),
(97, 'Test Account 97', 4, '2022-05-05 10:26:53', 'username97', 'password97', 'Active'),
(98, 'Test Account 98', 3, '2022-05-05 10:26:53', 'username98', 'password98', 'Active'),
(99, 'Test Account 99', 1, '2022-05-05 10:26:53', 'username99', 'password99', 'Active'),
(100, 'Test Account 100', 1, '2022-05-05 10:26:53', 'username100', 'password100', 'Active');

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

--
-- Dumping data for table `Coupon`
--

INSERT INTO `Coupon` (`CouponID`, `Code`, `Name`, `Descriptions`, `DiscountType`, `DiscountAmount`, `Status`) VALUES
(1, 'Coupon1', 'Test Coupon 1', 'this is a Coupon 1', 'Value', '7.20', 'Expired'),
(2, 'Coupon2', 'Test Coupon 2', 'this is a Coupon 2', 'Percentage', '9.72', 'Active'),
(3, 'Coupon3', 'Test Coupon 3', 'this is a Coupon 3', 'Value', '9.57', 'Expired'),
(4, 'Coupon4', 'Test Coupon 4', 'this is a Coupon 4', 'Value', '9.54', 'Expired'),
(5, 'Coupon5', 'Test Coupon 5', 'this is a Coupon 5', 'Value', '6.65', 'Expired'),
(6, 'Coupon6', 'Test Coupon 6', 'this is a Coupon 6', 'Percentage', '3.03', 'Active'),
(7, 'Coupon7', 'Test Coupon 7', 'this is a Coupon 7', 'Value', '7.39', 'Expired'),
(8, 'Coupon8', 'Test Coupon 8', 'this is a Coupon 8', 'Value', '4.91', 'Expired'),
(9, 'Coupon9', 'Test Coupon 9', 'this is a Coupon 9', 'Value', '6.85', 'Expired'),
(10, 'Coupon10', 'Test Coupon 10', 'this is a Coupon 10', 'Percentage', '4.20', 'Active'),
(11, 'Coupon11', 'Test Coupon 11', 'this is a Coupon 11', 'Percentage', '1.35', 'Active'),
(12, 'Coupon12', 'Test Coupon 12', 'this is a Coupon 12', 'Percentage', '10.94', 'Active'),
(13, 'Coupon13', 'Test Coupon 13', 'this is a Coupon 13', 'Percentage', '7.77', 'Active'),
(14, 'Coupon14', 'Test Coupon 14', 'this is a Coupon 14', 'Percentage', '9.30', 'Active'),
(15, 'Coupon15', 'Test Coupon 15', 'this is a Coupon 15', 'Percentage', '3.77', 'Active'),
(16, 'Coupon16', 'Test Coupon 16', 'this is a Coupon 16', 'Value', '6.04', 'Expired'),
(17, 'Coupon17', 'Test Coupon 17', 'this is a Coupon 17', 'Percentage', '9.51', 'Active'),
(18, 'Coupon18', 'Test Coupon 18', 'this is a Coupon 18', 'Value', '10.65', 'Expired'),
(19, 'Coupon19', 'Test Coupon 19', 'this is a Coupon 19', 'Percentage', '1.89', 'Active'),
(20, 'Coupon20', 'Test Coupon 20', 'this is a Coupon 20', 'Value', '1.39', 'Expired'),
(21, 'Coupon21', 'Test Coupon 21', 'this is a Coupon 21', 'Percentage', '7.31', 'Active'),
(22, 'Coupon22', 'Test Coupon 22', 'this is a Coupon 22', 'Percentage', '7.87', 'Active'),
(23, 'Coupon23', 'Test Coupon 23', 'this is a Coupon 23', 'Value', '7.72', 'Expired'),
(24, 'Coupon24', 'Test Coupon 24', 'this is a Coupon 24', 'Value', '3.30', 'Expired'),
(25, 'Coupon25', 'Test Coupon 25', 'this is a Coupon 25', 'Percentage', '7.19', 'Active'),
(26, 'Coupon26', 'Test Coupon 26', 'this is a Coupon 26', 'Value', '9.06', 'Expired'),
(27, 'Coupon27', 'Test Coupon 27', 'this is a Coupon 27', 'Percentage', '7.64', 'Active'),
(28, 'Coupon28', 'Test Coupon 28', 'this is a Coupon 28', 'Percentage', '7.89', 'Active'),
(29, 'Coupon29', 'Test Coupon 29', 'this is a Coupon 29', 'Value', '4.51', 'Expired'),
(30, 'Coupon30', 'Test Coupon 30', 'this is a Coupon 30', 'Value', '5.36', 'Expired'),
(31, 'Coupon31', 'Test Coupon 31', 'this is a Coupon 31', 'Value', '7.74', 'Expired'),
(32, 'Coupon32', 'Test Coupon 32', 'this is a Coupon 32', 'Percentage', '7.25', 'Active'),
(33, 'Coupon33', 'Test Coupon 33', 'this is a Coupon 33', 'Percentage', '4.09', 'Active'),
(34, 'Coupon34', 'Test Coupon 34', 'this is a Coupon 34', 'Percentage', '3.72', 'Active'),
(35, 'Coupon35', 'Test Coupon 35', 'this is a Coupon 35', 'Percentage', '1.19', 'Active'),
(36, 'Coupon36', 'Test Coupon 36', 'this is a Coupon 36', 'Value', '3.75', 'Expired'),
(37, 'Coupon37', 'Test Coupon 37', 'this is a Coupon 37', 'Value', '7.69', 'Expired'),
(38, 'Coupon38', 'Test Coupon 38', 'this is a Coupon 38', 'Percentage', '8.60', 'Active'),
(39, 'Coupon39', 'Test Coupon 39', 'this is a Coupon 39', 'Percentage', '1.22', 'Active'),
(40, 'Coupon40', 'Test Coupon 40', 'this is a Coupon 40', 'Percentage', '5.97', 'Active'),
(41, 'Coupon41', 'Test Coupon 41', 'this is a Coupon 41', 'Value', '4.21', 'Expired'),
(42, 'Coupon42', 'Test Coupon 42', 'this is a Coupon 42', 'Value', '3.51', 'Expired'),
(43, 'Coupon43', 'Test Coupon 43', 'this is a Coupon 43', 'Value', '7.07', 'Expired'),
(44, 'Coupon44', 'Test Coupon 44', 'this is a Coupon 44', 'Percentage', '5.03', 'Active'),
(45, 'Coupon45', 'Test Coupon 45', 'this is a Coupon 45', 'Percentage', '8.59', 'Active'),
(46, 'Coupon46', 'Test Coupon 46', 'this is a Coupon 46', 'Percentage', '6.68', 'Active'),
(47, 'Coupon47', 'Test Coupon 47', 'this is a Coupon 47', 'Percentage', '10.36', 'Active'),
(48, 'Coupon48', 'Test Coupon 48', 'this is a Coupon 48', 'Value', '5.35', 'Expired'),
(49, 'Coupon49', 'Test Coupon 49', 'this is a Coupon 49', 'Value', '7.69', 'Expired'),
(50, 'Coupon50', 'Test Coupon 50', 'this is a Coupon 50', 'Percentage', '3.83', 'Active'),
(51, 'Coupon51', 'Test Coupon 51', 'this is a Coupon 51', 'Percentage', '6.40', 'Active'),
(52, 'Coupon52', 'Test Coupon 52', 'this is a Coupon 52', 'Value', '7.11', 'Expired'),
(53, 'Coupon53', 'Test Coupon 53', 'this is a Coupon 53', 'Percentage', '5.22', 'Active'),
(54, 'Coupon54', 'Test Coupon 54', 'this is a Coupon 54', 'Value', '2.40', 'Expired'),
(55, 'Coupon55', 'Test Coupon 55', 'this is a Coupon 55', 'Value', '8.24', 'Expired'),
(56, 'Coupon56', 'Test Coupon 56', 'this is a Coupon 56', 'Percentage', '1.01', 'Active'),
(57, 'Coupon57', 'Test Coupon 57', 'this is a Coupon 57', 'Value', '3.61', 'Expired'),
(58, 'Coupon58', 'Test Coupon 58', 'this is a Coupon 58', 'Value', '8.47', 'Expired'),
(59, 'Coupon59', 'Test Coupon 59', 'this is a Coupon 59', 'Percentage', '1.18', 'Active'),
(60, 'Coupon60', 'Test Coupon 60', 'this is a Coupon 60', 'Percentage', '7.57', 'Active'),
(61, 'Coupon61', 'Test Coupon 61', 'this is a Coupon 61', 'Value', '7.09', 'Expired'),
(62, 'Coupon62', 'Test Coupon 62', 'this is a Coupon 62', 'Value', '7.14', 'Expired'),
(63, 'Coupon63', 'Test Coupon 63', 'this is a Coupon 63', 'Percentage', '2.22', 'Active'),
(64, 'Coupon64', 'Test Coupon 64', 'this is a Coupon 64', 'Value', '4.27', 'Expired'),
(65, 'Coupon65', 'Test Coupon 65', 'this is a Coupon 65', 'Percentage', '9.41', 'Active'),
(66, 'Coupon66', 'Test Coupon 66', 'this is a Coupon 66', 'Value', '1.81', 'Expired'),
(67, 'Coupon67', 'Test Coupon 67', 'this is a Coupon 67', 'Percentage', '1.67', 'Active'),
(68, 'Coupon68', 'Test Coupon 68', 'this is a Coupon 68', 'Percentage', '3.97', 'Active'),
(69, 'Coupon69', 'Test Coupon 69', 'this is a Coupon 69', 'Percentage', '9.44', 'Active'),
(70, 'Coupon70', 'Test Coupon 70', 'this is a Coupon 70', 'Value', '6.08', 'Expired'),
(71, 'Coupon71', 'Test Coupon 71', 'this is a Coupon 71', 'Percentage', '4.19', 'Active'),
(72, 'Coupon72', 'Test Coupon 72', 'this is a Coupon 72', 'Value', '7.01', 'Expired'),
(73, 'Coupon73', 'Test Coupon 73', 'this is a Coupon 73', 'Value', '9.58', 'Expired'),
(74, 'Coupon74', 'Test Coupon 74', 'this is a Coupon 74', 'Percentage', '4.25', 'Active'),
(75, 'Coupon75', 'Test Coupon 75', 'this is a Coupon 75', 'Value', '2.47', 'Expired'),
(76, 'Coupon76', 'Test Coupon 76', 'this is a Coupon 76', 'Value', '7.68', 'Expired'),
(77, 'Coupon77', 'Test Coupon 77', 'this is a Coupon 77', 'Percentage', '5.31', 'Active'),
(78, 'Coupon78', 'Test Coupon 78', 'this is a Coupon 78', 'Value', '2.90', 'Expired'),
(79, 'Coupon79', 'Test Coupon 79', 'this is a Coupon 79', 'Percentage', '9.63', 'Active'),
(80, 'Coupon80', 'Test Coupon 80', 'this is a Coupon 80', 'Value', '2.91', 'Expired'),
(81, 'Coupon81', 'Test Coupon 81', 'this is a Coupon 81', 'Value', '8.91', 'Expired'),
(82, 'Coupon82', 'Test Coupon 82', 'this is a Coupon 82', 'Value', '6.67', 'Expired'),
(83, 'Coupon83', 'Test Coupon 83', 'this is a Coupon 83', 'Percentage', '5.82', 'Active'),
(84, 'Coupon84', 'Test Coupon 84', 'this is a Coupon 84', 'Value', '7.42', 'Expired'),
(85, 'Coupon85', 'Test Coupon 85', 'this is a Coupon 85', 'Value', '6.82', 'Expired'),
(86, 'Coupon86', 'Test Coupon 86', 'this is a Coupon 86', 'Value', '5.79', 'Expired'),
(87, 'Coupon87', 'Test Coupon 87', 'this is a Coupon 87', 'Percentage', '10.29', 'Active'),
(88, 'Coupon88', 'Test Coupon 88', 'this is a Coupon 88', 'Value', '4.78', 'Expired'),
(89, 'Coupon89', 'Test Coupon 89', 'this is a Coupon 89', 'Value', '7.91', 'Expired'),
(90, 'Coupon90', 'Test Coupon 90', 'this is a Coupon 90', 'Percentage', '1.60', 'Active'),
(91, 'Coupon91', 'Test Coupon 91', 'this is a Coupon 91', 'Value', '2.83', 'Expired'),
(92, 'Coupon92', 'Test Coupon 92', 'this is a Coupon 92', 'Percentage', '8.52', 'Active'),
(93, 'Coupon93', 'Test Coupon 93', 'this is a Coupon 93', 'Value', '9.77', 'Expired'),
(94, 'Coupon94', 'Test Coupon 94', 'this is a Coupon 94', 'Percentage', '9.04', 'Active'),
(95, 'Coupon95', 'Test Coupon 95', 'this is a Coupon 95', 'Value', '7.34', 'Expired'),
(96, 'Coupon96', 'Test Coupon 96', 'this is a Coupon 96', 'Percentage', '10.50', 'Active'),
(97, 'Coupon97', 'Test Coupon 97', 'this is a Coupon 97', 'Percentage', '10.66', 'Active'),
(98, 'Coupon98', 'Test Coupon 98', 'this is a Coupon 98', 'Percentage', '1.82', 'Active'),
(99, 'Coupon99', 'Test Coupon 99', 'this is a Coupon 99', 'Percentage', '5.99', 'Active'),
(100, 'Coupon100', 'Test Coupon 100', 'this is a Coupon 100', 'Percentage', '6.78', 'Active');

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

--
-- Dumping data for table `MenuItem`
--

INSERT INTO `MenuItem` (`MenuItemID`, `Name`, `Type`, `Price`, `Descriptions`, `Status`, `CreatedAt`, `UpdatedAt`, `ImageDataURL`) VALUES
(1, 'Test Menu Item 1', 'Beverage', '10.00', 'this is a menu item 1', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 1'),
(2, 'Test Menu Item 2', 'SideDish', '4.76', 'this is a menu item 2', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 2'),
(3, 'Test Menu Item 3', 'Beverage', '9.73', 'this is a menu item 3', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 3'),
(4, 'Test Menu Item 4', 'MainCourse', '5.78', 'this is a menu item 4', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 4'),
(5, 'Test Menu Item 5', 'MainCourse', '1.99', 'this is a menu item 5', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 5'),
(6, 'Test Menu Item 6', 'SideDish', '4.73', 'this is a menu item 6', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 6'),
(7, 'Test Menu Item 7', 'Beverage', '3.13', 'this is a menu item 7', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 7'),
(8, 'Test Menu Item 8', 'Beverage', '2.50', 'this is a menu item 8', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 8'),
(9, 'Test Menu Item 9', 'MainCourse', '1.26', 'this is a menu item 9', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 9'),
(10, 'Test Menu Item 10', 'MainCourse', '6.43', 'this is a menu item 10', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 10'),
(11, 'Test Menu Item 11', 'Beverage', '7.41', 'this is a menu item 11', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 11'),
(12, 'Test Menu Item 12', 'MainCourse', '5.81', 'this is a menu item 12', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 12'),
(13, 'Test Menu Item 13', 'Beverage', '3.13', 'this is a menu item 13', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 13'),
(14, 'Test Menu Item 14', 'Beverage', '7.72', 'this is a menu item 14', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 14'),
(15, 'Test Menu Item 15', 'MainCourse', '8.69', 'this is a menu item 15', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 15'),
(16, 'Test Menu Item 16', 'Beverage', '1.17', 'this is a menu item 16', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 16'),
(17, 'Test Menu Item 17', 'Beverage', '1.67', 'this is a menu item 17', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 17'),
(18, 'Test Menu Item 18', 'SideDish', '8.73', 'this is a menu item 18', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 18'),
(19, 'Test Menu Item 19', 'MainCourse', '1.46', 'this is a menu item 19', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 19'),
(20, 'Test Menu Item 20', 'MainCourse', '3.55', 'this is a menu item 20', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 20'),
(21, 'Test Menu Item 21', 'SideDish', '1.79', 'this is a menu item 21', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 21'),
(22, 'Test Menu Item 22', 'MainCourse', '10.82', 'this is a menu item 22', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 22'),
(23, 'Test Menu Item 23', 'MainCourse', '7.95', 'this is a menu item 23', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 23'),
(24, 'Test Menu Item 24', 'SideDish', '6.73', 'this is a menu item 24', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 24'),
(25, 'Test Menu Item 25', 'MainCourse', '5.77', 'this is a menu item 25', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 25'),
(26, 'Test Menu Item 26', 'MainCourse', '1.80', 'this is a menu item 26', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 26'),
(27, 'Test Menu Item 27', 'MainCourse', '6.73', 'this is a menu item 27', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 27'),
(28, 'Test Menu Item 28', 'MainCourse', '2.47', 'this is a menu item 28', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 28'),
(29, 'Test Menu Item 29', 'SideDish', '2.45', 'this is a menu item 29', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 29'),
(30, 'Test Menu Item 30', 'SideDish', '4.22', 'this is a menu item 30', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 30'),
(31, 'Test Menu Item 31', 'MainCourse', '6.31', 'this is a menu item 31', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 31'),
(32, 'Test Menu Item 32', 'MainCourse', '9.54', 'this is a menu item 32', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 32'),
(33, 'Test Menu Item 33', 'MainCourse', '3.48', 'this is a menu item 33', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 33'),
(34, 'Test Menu Item 34', 'MainCourse', '3.22', 'this is a menu item 34', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 34'),
(35, 'Test Menu Item 35', 'Beverage', '8.51', 'this is a menu item 35', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 35'),
(36, 'Test Menu Item 36', 'SideDish', '10.64', 'this is a menu item 36', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 36'),
(37, 'Test Menu Item 37', 'SideDish', '4.58', 'this is a menu item 37', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 37'),
(38, 'Test Menu Item 38', 'Beverage', '10.27', 'this is a menu item 38', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 38'),
(39, 'Test Menu Item 39', 'Beverage', '7.44', 'this is a menu item 39', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 39'),
(40, 'Test Menu Item 40', 'SideDish', '9.13', 'this is a menu item 40', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 40'),
(41, 'Test Menu Item 41', 'SideDish', '1.49', 'this is a menu item 41', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 41'),
(42, 'Test Menu Item 42', 'MainCourse', '8.97', 'this is a menu item 42', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 42'),
(43, 'Test Menu Item 43', 'SideDish', '4.36', 'this is a menu item 43', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 43'),
(44, 'Test Menu Item 44', 'SideDish', '6.31', 'this is a menu item 44', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 44'),
(45, 'Test Menu Item 45', 'Beverage', '9.54', 'this is a menu item 45', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 45'),
(46, 'Test Menu Item 46', 'Beverage', '9.61', 'this is a menu item 46', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 46'),
(47, 'Test Menu Item 47', 'SideDish', '5.61', 'this is a menu item 47', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 47'),
(48, 'Test Menu Item 48', 'SideDish', '4.58', 'this is a menu item 48', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 48'),
(49, 'Test Menu Item 49', 'Beverage', '3.10', 'this is a menu item 49', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 49'),
(50, 'Test Menu Item 50', 'MainCourse', '10.02', 'this is a menu item 50', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 50'),
(51, 'Test Menu Item 51', 'SideDish', '10.74', 'this is a menu item 51', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 51'),
(52, 'Test Menu Item 52', 'Beverage', '1.04', 'this is a menu item 52', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 52'),
(53, 'Test Menu Item 53', 'Beverage', '6.06', 'this is a menu item 53', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 53'),
(54, 'Test Menu Item 54', 'SideDish', '1.06', 'this is a menu item 54', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 54'),
(55, 'Test Menu Item 55', 'MainCourse', '10.62', 'this is a menu item 55', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 55'),
(56, 'Test Menu Item 56', 'SideDish', '1.35', 'this is a menu item 56', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 56'),
(57, 'Test Menu Item 57', 'SideDish', '7.37', 'this is a menu item 57', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 57'),
(58, 'Test Menu Item 58', 'MainCourse', '6.60', 'this is a menu item 58', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 58'),
(59, 'Test Menu Item 59', 'Beverage', '10.75', 'this is a menu item 59', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 59'),
(60, 'Test Menu Item 60', 'SideDish', '3.77', 'this is a menu item 60', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 60'),
(61, 'Test Menu Item 61', 'MainCourse', '6.41', 'this is a menu item 61', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 61'),
(62, 'Test Menu Item 62', 'Beverage', '9.28', 'this is a menu item 62', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 62'),
(63, 'Test Menu Item 63', 'Beverage', '3.24', 'this is a menu item 63', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 63'),
(64, 'Test Menu Item 64', 'MainCourse', '8.88', 'this is a menu item 64', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 64'),
(65, 'Test Menu Item 65', 'Beverage', '1.07', 'this is a menu item 65', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 65'),
(66, 'Test Menu Item 66', 'Beverage', '5.65', 'this is a menu item 66', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 66'),
(67, 'Test Menu Item 67', 'SideDish', '2.29', 'this is a menu item 67', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 67'),
(68, 'Test Menu Item 68', 'SideDish', '1.30', 'this is a menu item 68', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 68'),
(69, 'Test Menu Item 69', 'MainCourse', '8.16', 'this is a menu item 69', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 69'),
(70, 'Test Menu Item 70', 'Beverage', '6.22', 'this is a menu item 70', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 70'),
(71, 'Test Menu Item 71', 'SideDish', '1.44', 'this is a menu item 71', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 71'),
(72, 'Test Menu Item 72', 'MainCourse', '6.04', 'this is a menu item 72', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 72'),
(73, 'Test Menu Item 73', 'SideDish', '9.45', 'this is a menu item 73', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 73'),
(74, 'Test Menu Item 74', 'MainCourse', '8.66', 'this is a menu item 74', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 74'),
(75, 'Test Menu Item 75', 'SideDish', '8.13', 'this is a menu item 75', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 75'),
(76, 'Test Menu Item 76', 'Beverage', '3.46', 'this is a menu item 76', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 76'),
(77, 'Test Menu Item 77', 'SideDish', '8.62', 'this is a menu item 77', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 77'),
(78, 'Test Menu Item 78', 'MainCourse', '5.41', 'this is a menu item 78', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 78'),
(79, 'Test Menu Item 79', 'Beverage', '10.26', 'this is a menu item 79', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 79'),
(80, 'Test Menu Item 80', 'SideDish', '3.69', 'this is a menu item 80', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 80'),
(81, 'Test Menu Item 81', 'MainCourse', '4.32', 'this is a menu item 81', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 81'),
(82, 'Test Menu Item 82', 'Beverage', '10.03', 'this is a menu item 82', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 82'),
(83, 'Test Menu Item 83', 'Beverage', '1.94', 'this is a menu item 83', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 83'),
(84, 'Test Menu Item 84', 'SideDish', '3.57', 'this is a menu item 84', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 84'),
(85, 'Test Menu Item 85', 'Beverage', '1.70', 'this is a menu item 85', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 85'),
(86, 'Test Menu Item 86', 'SideDish', '10.11', 'this is a menu item 86', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 86'),
(87, 'Test Menu Item 87', 'Beverage', '10.79', 'this is a menu item 87', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 87'),
(88, 'Test Menu Item 88', 'Beverage', '6.35', 'this is a menu item 88', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 88'),
(89, 'Test Menu Item 89', 'Beverage', '10.33', 'this is a menu item 89', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 89'),
(90, 'Test Menu Item 90', 'SideDish', '8.60', 'this is a menu item 90', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 90'),
(91, 'Test Menu Item 91', 'MainCourse', '7.09', 'this is a menu item 91', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 91'),
(92, 'Test Menu Item 92', 'MainCourse', '7.44', 'this is a menu item 92', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 92'),
(93, 'Test Menu Item 93', 'Beverage', '9.53', 'this is a menu item 93', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 93'),
(94, 'Test Menu Item 94', 'Beverage', '9.37', 'this is a menu item 94', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 94'),
(95, 'Test Menu Item 95', 'SideDish', '5.95', 'this is a menu item 95', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 95'),
(96, 'Test Menu Item 96', 'MainCourse', '7.37', 'this is a menu item 96', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 96'),
(97, 'Test Menu Item 97', 'Beverage', '3.00', 'this is a menu item 97', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 97'),
(98, 'Test Menu Item 98', 'Beverage', '7.27', 'this is a menu item 98', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 98'),
(99, 'Test Menu Item 99', 'SideDish', '7.08', 'this is a menu item 99', 'Available', '2022-05-05 18:27:00', NULL, 'this is an image URL 99'),
(100, 'Test Menu Item 100', 'MainCourse', '6.44', 'this is a menu item 100', 'Unavailable', '2022-05-05 18:27:00', NULL, 'this is an image URL 100');

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
  MODIFY `CouponID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `MenuItem`
--
ALTER TABLE `MenuItem`
  MODIFY `MenuItemID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

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
