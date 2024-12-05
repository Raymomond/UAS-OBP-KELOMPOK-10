-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2024 at 02:15 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `new_pinjol`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`) VALUES
(3);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`) VALUES
(8),
(9),
(10),
(11),
(12);

-- --------------------------------------------------------

--
-- Table structure for table `loans`
--

CREATE TABLE `loans` (
  `id` bigint(20) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `no_telpon` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `email` varchar(255) NOT NULL,
  `jumlah_pinjaman` decimal(15,2) NOT NULL,
  `lama_pinjaman` int(11) NOT NULL,
  `nama_bank` varchar(255) NOT NULL,
  `nomor_rekening` varchar(255) NOT NULL,
  `status` enum('approved','pending','rejected') NOT NULL DEFAULT 'pending',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loans`
--

INSERT INTO `loans` (`id`, `nama`, `no_telpon`, `alamat`, `email`, `jumlah_pinjaman`, `lama_pinjaman`, `nama_bank`, `nomor_rekening`, `status`, `created_at`, `updated_at`) VALUES
(4, 'CustDua', '08999999999', 'Jl. Cust Dua 2', 'customerdua@gmail.com', 22222222.00, 2, 'BCA', '2222222', 'approved', '2024-11-28 06:38:31', '2024-11-28 07:56:37'),
(5, 'Mon', '08123456789', 'jl konci', 'RAYMONDNIU31@GMAIL.COM', 10000.00, 10, 'BCA', '00000000', 'approved', '2024-11-28 07:56:05', '2024-12-05 12:13:22'),
(6, 'Jojo', '089513293658', 'jln. customer', 'jojo@gmail.com', 1000000.00, 6, 'BCA', '5390660199', 'approved', '2024-11-28 08:52:28', '2024-11-28 08:53:30'),
(7, 'Mon', '08123456789', 'Jalan jalan kekota surabaya', 'Mondmon@gmail.com', 1000000.00, 2, 'Amin Bank', '5555555', 'approved', '2024-12-05 12:11:29', '2024-12-05 12:13:39');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('ADMIN','USER') NOT NULL DEFAULT 'USER',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fullname`, `email`, `username`, `password`, `role`, `created_at`) VALUES
(3, 'Admin', 'admin@admin.com', 'admin', '$2a$10$FlupRPrD0gNfmgCKlJuhT.MaXH6yF6nf4EakwH20vMkpVPZ7/18BO', 'ADMIN', '2024-11-25 22:23:44'),
(8, 'Raymond', 'customer@gmail.com', 'customer', '$2a$10$tSZ08z6pWhHHk4Lh7i3RdOcsxXGEynyHOaXoCopIztK7/7S3ZThgO', 'USER', '2024-11-28 02:39:00'),
(9, 'Customer Dua', 'customerdua@gmail.com', 'customerdua', '$2a$10$.FLCOajuuPWwxiwfn47Tsu1ulV2Jy9zTZ6a0niIyb6KLonlD/6mLa', 'USER', '2024-11-28 06:37:40'),
(10, 'Raymond', 'RAYMONDNIU31@GMAIL.COM', 'fefefef', '$2a$10$EKxLKfsUE0ZT4VzNqYuZpe2Ers7l57iyVPOPGDweBmjlSmB0FeHW6', 'USER', '2024-11-28 07:55:08'),
(11, 'Jojo', 'jojo@gmail.com', 'jojo', '$2a$10$yrljSE2ZBslN0JYgUqgaEODFNwf5cSDlzEploAq7lHStyn/2rXM4W', 'USER', '2024-11-28 08:51:17'),
(12, 'Monmond', 'Mondmon@gmail.com', 'Mon', '$2a$10$f3RCZ7jHrC3tKktS2Q5sKORvABKuVIgR49VZc2UpLQDqKpXSO0bQW', 'USER', '2024-12-05 12:04:18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loans`
--
ALTER TABLE `loans`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `loans`
--
ALTER TABLE `loans`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admins`
--
ALTER TABLE `admins`
  ADD CONSTRAINT `FKanhsicqm3lc8ya77tr7r0je18` FOREIGN KEY (`id`) REFERENCES `users` (`id`);

--
-- Constraints for table `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `FKpog72rpahj62h7nod9wwc28if` FOREIGN KEY (`id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
