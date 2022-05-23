-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2022 a las 18:40:06
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `soleus`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client_request`
--

CREATE TABLE `client_request` (
  `request_id` int(11) NOT NULL,
  `topic` varchar(45) DEFAULT NULL,
  `item` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `client_room` varchar(3) DEFAULT NULL,
  `ended` tinyint(1) DEFAULT NULL,
  `request_time` varchar(45) DEFAULT NULL,
  `request_end` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `client_request`
--

INSERT INTO `client_request` (`request_id`, `topic`, `item`, `description`, `department`, `client_room`, `ended`, `request_time`, `request_end`) VALUES
(1, 'Limpieza', 'Limpieza', 'nada', 'HOUSEKEEPING', '101', 1, '', '19:00 11-05-22'),
(2, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', '19:00 11-05-22'),
(3, 'BaÃ±o', 'Cepillo de dientes', '2', 'HOUSEKEEPING', '102', 1, '', '19:27 11-05-22'),
(4, 'BaÃ±o', 'Toalla rostro', '2', 'HOUSEKEEPING', '104', 1, '', '19:27 11-05-22'),
(5, 'BaÃ±o', 'Toalla rostro', 'prueba ', 'HOUSEKEEPING', '101', 1, '', NULL),
(6, 'Cama', 'Cambio de sÃ¡banas', '', 'HOUSEKEEPING', '102', 1, '', NULL),
(7, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(8, 'BaÃ±o', 'Toalla rostro', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(9, 'IluminaciÃ³n', 'Fallo electricidad', '', 'MAINTENANCE', '101', 1, '', '19:00 11-05-22'),
(10, 'Televisor', 'Problemas con el televisor', '', 'MAINTENANCE', '101', 1, '', '19:00 11-05-22'),
(11, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(12, 'Televisor', 'Problemas con el televisor', '', 'MAINTENANCE', '101', 1, '', '18:49 11-05-22'),
(13, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '103', 1, '', NULL),
(14, 'IluminaciÃ³n', 'Cambio bombilla', '', 'MAINTENANCE', '103', 1, '', '18:49 11-05-22'),
(15, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(16, 'IluminaciÃ³n', 'Cambio bombilla', '', 'MAINTENANCE', '101', 1, '', '19:00 11-05-22'),
(17, 'Limpieza', 'Limpieza', '', 'MAINTENANCE', '101', 1, '', NULL),
(18, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '102', 1, '', NULL),
(19, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '102', 1, '', '19:28 11-05-22'),
(20, 'Televisor', 'Problemas con el televisor', 'Paula', 'MAINTENANCE', '101', 1, '', NULL),
(22, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(23, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(24, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(25, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(26, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(27, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(28, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(29, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(30, 'Cama', 'Almohada extra', '', 'HOUSEKEEPING', '102', 1, '', NULL),
(31, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '102', 1, '', NULL),
(32, 'Televisor', 'Problemas con el televisor', '', 'MAINTENANCE', '102', 1, '', NULL),
(33, 'Iluminación', 'Fallo electricidad', '', 'MAINTENANCE', '103', 1, '', NULL),
(34, 'Cama', 'Almohada extra', '', 'HOUSEKEEPING', '103', 1, '', NULL),
(35, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '104', 1, '', NULL),
(36, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '104', 1, '', NULL),
(37, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '104', 1, '', NULL),
(38, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '104', 1, '', NULL),
(39, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '104', 1, '', NULL),
(40, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '104', 1, '', NULL),
(41, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(42, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '101', 1, '', NULL),
(43, 'Televisor', 'Problemas con el televisor', '', 'MAINTENANCE', '101', 1, '', '19:00 11-05-22'),
(44, 'Televisor', 'Problemas con el televisor', '', 'MAINTENANCE', '101', 1, '', '19:00 11-05-22'),
(45, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(46, 'Televisor', 'Problemas con el televisor', '', 'MAINTENANCE', '101', 1, '', '19:00 11-05-22'),
(47, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', 'ADM', 1, '', NULL),
(48, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '101', 1, '', NULL),
(49, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(50, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '104', 1, '', NULL),
(51, 'Cama', 'Almohada extra', '', 'HOUSEKEEPING', '104', 1, '', NULL),
(52, 'Cama', 'Almohada extra', 'pruebas', 'HOUSEKEEPING', '104', 1, '', '18:51 11-05-22'),
(53, 'Cama', 'Almohada extra', 'prueba', 'HOUSEKEEPING', '104', 1, '', NULL),
(54, 'Cama', 'Almohada extra', 'prueba', 'HOUSEKEEPING', '104', 1, '', NULL),
(55, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', 'ADM', 1, '', NULL),
(56, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', 'ADM', 1, '', NULL),
(57, 'Televisor', 'Problemas con el televisor', '', 'MAINTENANCE', '103', 1, '', NULL),
(58, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '103', 1, '', NULL),
(59, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '104', 1, '', NULL),
(60, 'Baño', 'Bañera', '', 'MAINTENANCE', '104', 1, '', NULL),
(61, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', 'ADM', 1, '', NULL),
(62, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', 'ADM', 1, '', NULL),
(63, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', 'ADM', 1, '', NULL),
(64, 'Baño', 'Gel y champú', 'pasta de dientes', 'HOUSEKEEPING', '101', 1, '', '19:00 11-05-22'),
(65, 'Televisor', 'Problemas con el televisor', 'no salen los canales', 'MAINTENANCE', '101', 1, '', '19:00 11-05-22'),
(66, 'Limpieza', 'Limpieza', 'ndndndndndndndndndndndndndndnd', 'HOUSEKEEPING', '101', 1, '', NULL),
(67, 'Limpieza', 'Limpieza', 'por favor limpiadme la cama eh', 'HOUSEKEEPING', '101', 1, '', NULL),
(68, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '102', 1, '', '19:28 11-05-22'),
(69, 'Cama', 'Almohada extra', 'f\nf\nf\nf\nf\nf\nf\nf\nff\nf\nf\nf\nf\nf\n\n', 'HOUSEKEEPING', '101', 1, '', NULL),
(70, 'Baño', 'Cepillo de dientes', '101', 'HOUSEKEEPING', '101', 1, '', '19:00 11-05-22'),
(71, 'Baño', 'Cepillo de dientes', '', 'HOUSEKEEPING', '101', 1, '', '19:00 11-05-22'),
(72, 'Baño', 'Toalla baño', '', 'HOUSEKEEPING', '101', 1, '', '19:01 11-05-22'),
(73, 'Baño', 'Kit Dental', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(74, 'Televisor', 'Problemas con el mando', '', 'MAINTENANCE', '101', 1, '', '19:01 11-05-22'),
(75, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '101', 1, '', NULL),
(76, 'Baño', 'Toalla rostro', '', 'HOUSEKEEPING', '101', 1, '', '19:01 11-05-22'),
(77, 'Baño', 'Toalla rostro', '', 'HOUSEKEEPING', '101', 1, '', '19:01 11-05-22'),
(78, 'Baño', 'Bañera', '', 'MAINTENANCE', '101', 1, '', NULL),
(79, 'Cama', 'Cambio de sábanas', 'dep', 'HOUSEKEEPING', '101', 1, '', NULL),
(80, 'Iluminación', 'Fallo eléctrico', 'dep', 'MAINTENANCE', '101', 1, '', NULL),
(81, 'Baño', 'Toalla baño', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(82, 'Televisor', 'Problemas con el televisor', '', 'MAINTENANCE', '101', 1, '', '19:01 11-05-22'),
(83, 'Limpieza', 'Limpieza', '0905', 'HOUSEKEEPING', '101', 1, '', NULL),
(84, 'Cama', 'Almohada extra', '09051205', 'HOUSEKEEPING', '101', 1, '', NULL),
(85, 'Televisor', 'Problemas con el televisor', '', 'MAINTENANCE', '101', 1, '', NULL),
(86, 'Limpieza', 'Limpieza', 'ADMIN', 'HOUSEKEEPING', 'ADM', 1, '', NULL),
(87, 'Limpieza', 'Limpieza', 'ADMIN', 'HOUSEKEEPING', 'ADM', 1, '', NULL),
(88, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '', NULL),
(89, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', 'ADM', 1, '', '19:28 11-05-22'),
(90, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', 'ADM', 1, '', '19:27 11-05-22'),
(91, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', 'ADM', 1, '22:34 09-05-22', '19:27 11-05-22'),
(92, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', 'ADM', 1, '22:35 09-05-22', '18:51 11-05-22'),
(93, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', 'ADM', 1, '22:40 09-05-22', '19:28 11-05-22'),
(94, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '18:25 11-05-22', '19:01 11-05-22'),
(95, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '18:42 11-05-22', '18:43 11-05-22'),
(96, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '101', 1, '18:42 11-05-22', '19:01 11-05-22'),
(97, 'Baño', 'Kit Dental', '', 'HOUSEKEEPING', '101', 1, '19:27 11-05-22', '19:27 11-05-22'),
(98, 'Televisor', 'Problemas con el mando', '', 'MAINTENANCE', '101', 1, '19:27 11-05-22', '19:28 11-05-22'),
(99, 'Cama', 'Almohada extra', '', 'HOUSEKEEPING', '101', 1, '19:28 11-05-22', '19:31 11-05-22'),
(100, 'Cama', 'Cambio de sábanas', '', 'HOUSEKEEPING', '101', 1, '19:28 11-05-22', '19:29 11-05-22'),
(101, 'Iluminación', 'Fallo eléctrico', '', 'MAINTENANCE', '101', 1, '19:28 11-05-22', '19:29 11-05-22'),
(102, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '19:32 11-05-22', '19:32 11-05-22'),
(103, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '101', 1, '19:32 11-05-22', '19:33 11-05-22'),
(104, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '101', 1, '19:32 11-05-22', '19:33 11-05-22'),
(105, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '19:33 11-05-22', '19:34 11-05-22'),
(106, 'Iluminación', 'Fallo eléctrico', '', 'MAINTENANCE', '101', 1, '19:34 11-05-22', '19:35 11-05-22'),
(107, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '19:35 11-05-22', '19:36 11-05-22'),
(108, 'Iluminación', 'Cambio bombilla', '', 'MAINTENANCE', '101', 1, '19:35 11-05-22', '19:38 11-05-22'),
(109, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', 'ADM', 1, '19:37 11-05-22', '19:25 17-05-22'),
(110, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '19:38 11-05-22', '19:39 11-05-22'),
(111, 'Iluminación', 'Fallo eléctrico', '', 'MAINTENANCE', '101', 1, '19:38 11-05-22', '19:39 11-05-22'),
(112, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '19:40 11-05-22', '20:00 12-05-22'),
(113, 'Iluminación', 'Fallo eléctrico', '', 'MAINTENANCE', '101', 1, '19:41 11-05-22', '19:41 11-05-22'),
(114, 'Televisor', 'Problemas con el televisor', '', 'MAINTENANCE', '101', 1, '19:41 11-05-22', '19:42 11-05-22'),
(115, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '20:00 12-05-22', '20:00 12-05-22'),
(116, 'Limpieza', 'Limpieza', '', 'HOUSEKEEPING', '101', 1, '18:07 14-05-22', '19:25 17-05-22'),
(117, 'Baño', 'Toalla rostro', '', 'HOUSEKEEPING', '101', 1, '18:07 14-05-22', '19:25 17-05-22'),
(118, 'Baño', 'Toalla baño', '2 toallas', 'HOUSEKEEPING', '101', 0, '19:24 17-05-22', 'Pendiente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `room` varchar(3) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(14) DEFAULT NULL,
  `department` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`room`, `password`, `name`, `department`) VALUES
('101', 'Mrt8m2RdMgnO5ls0INfUDw==', 'LUNA', 'CLIENT'),
('102', 'Mrt8m2RdMgnO5ls0INfUDw==', 'PEREIRA', 'CLIENT'),
('103', 'Mrt8m2RdMgnO5ls0INfUDw==', 'LUNA', 'CLIENT'),
('104', 'Mrt8m2RdMgnO5ls0INfUDw==', 'PEREIRA', 'CLIENT'),
('106', 'Mrt8m2RdMgnO5ls0INfUDw==', 'LUNA', 'CLIENT'),
('ADM', '2dQItiTcLLHs5znXoeUQVQ==', 'ADMIN', 'ADMIN'),
('HK1', 'FAW3ydlQzadi793NdyKuYA==', 'HK1', 'HOUSEKEEPING'),
('HK2', 'FAW3ydlQzadi793NdyKuYA==', 'HK2', 'HOUSEKEEPING'),
('MT1', 'FAW3ydlQzadi793NdyKuYA==', 'MT1', 'MAINTENANCE'),
('MT2', 'FAW3ydlQzadi793NdyKuYA==', 'MT2', 'MAINTENANCE');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `client_request`
--
ALTER TABLE `client_request`
  ADD PRIMARY KEY (`request_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`room`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `client_request`
--
ALTER TABLE `client_request`
  MODIFY `request_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=119;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
