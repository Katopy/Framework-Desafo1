-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 01-09-2023 a las 05:34:17
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cuponeradb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

DROP TABLE IF EXISTS `compras`;
CREATE TABLE IF NOT EXISTS `compras` (
  `codigoCompra` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `precioOferta` decimal(10,2) DEFAULT NULL,
  `pagos` decimal(10,2) DEFAULT NULL,
  `codigoOferta` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `usuarioLogin` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`codigoCompra`),
  KEY `codigoOferta` (`codigoOferta`),
  KEY `usuarioLogin` (`usuarioLogin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cupones`
--

DROP TABLE IF EXISTS `cupones`;
CREATE TABLE IF NOT EXISTS `cupones` (
  `duiUsuario` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `codigoCompra` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `codigoEmpresa` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `usuarioLogin` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `comision` decimal(10,2) DEFAULT NULL,
  `categorizacion` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`duiUsuario`),
  KEY `codigoCompra` (`codigoCompra`),
  KEY `codigoEmpresa` (`codigoEmpresa`),
  KEY `usuarioLogin` (`usuarioLogin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE IF NOT EXISTS `empresa` (
  `codigoEmpresa` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `nombreEmpresa` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `direccion` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nombreContacto` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `usuarioLogin` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefono` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `correo` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `rubroEmpresa` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `comision` decimal(10,2) DEFAULT NULL,
  `cuponesVendidos` int DEFAULT NULL,
  `ingresosTotales` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`codigoEmpresa`),
  UNIQUE KEY `usuarioLogin` (`usuarioLogin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

DROP TABLE IF EXISTS `oferta`;
CREATE TABLE IF NOT EXISTS `oferta` (
  `codigoOferta` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `tituloOferta` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `codigoEmpresa` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `precioRegular` decimal(10,2) DEFAULT NULL,
  `precioOferta` decimal(10,2) DEFAULT NULL,
  `fechaInicioOferta` date DEFAULT NULL,
  `fechaFinOferta` date DEFAULT NULL,
  `fechaLimiteCupon` date DEFAULT NULL,
  `cantidadLimiteCupones` int DEFAULT NULL,
  `cuponesVendidos` int DEFAULT NULL,
  `cuponesDisponibles` int DEFAULT NULL,
  `estado` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `descripcionOferta` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `usuarioLogin` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `comision` decimal(10,2) DEFAULT NULL,
  `ingresosTotales` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`codigoOferta`),
  KEY `codigoEmpresa` (`codigoEmpresa`),
  KEY `usuarioLogin` (`usuarioLogin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `usuarioLogin` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `contraLogin` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tipoUsuario` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `duiUsuario` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `correoUsuario` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nombreUsuario` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `apellidoUsuario` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefonoUsuario` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `direccionUsuario` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`usuarioLogin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usuarioLogin`, `contraLogin`, `tipoUsuario`, `duiUsuario`, `correoUsuario`, `nombreUsuario`, `apellidoUsuario`, `telefonoUsuario`, `direccionUsuario`) VALUES
('Administrador', 'administrador', 'Administrador', '01234567-8', 'ronaldomendozamancia@gmail.com', 'Ronaldo', 'Mendoza', '6655-5588', 'San salvador, El salvador'),
('Cliente', 'cliente', 'Cliente', '02014455-6', 'asiel@gmail.com', 'Asiel', 'Zavaleta', '6611-5566', 'San salvador, el salvador'),
('Dependiente', 'dependiente', 'Dependiente', '09954123-2', 'Andres@gmail.com', 'Andres', 'López', '7711-2233', 'San Salvador, El salvador'),
('Empresas', 'empresas', 'AdministradorEmpresa', '08765432-1', 'kath@gmail.com', 'Katherine', 'García', '7755-6655', 'San salvador, El salvador\r\n');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`codigoOferta`) REFERENCES `oferta` (`codigoOferta`),
  ADD CONSTRAINT `compras_ibfk_2` FOREIGN KEY (`usuarioLogin`) REFERENCES `usuarios` (`usuarioLogin`);

--
-- Filtros para la tabla `cupones`
--
ALTER TABLE `cupones`
  ADD CONSTRAINT `cupones_ibfk_1` FOREIGN KEY (`codigoCompra`) REFERENCES `compras` (`codigoCompra`),
  ADD CONSTRAINT `cupones_ibfk_2` FOREIGN KEY (`codigoEmpresa`) REFERENCES `empresa` (`codigoEmpresa`),
  ADD CONSTRAINT `cupones_ibfk_3` FOREIGN KEY (`usuarioLogin`) REFERENCES `usuarios` (`usuarioLogin`);

--
-- Filtros para la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD CONSTRAINT `oferta_ibfk_1` FOREIGN KEY (`codigoEmpresa`) REFERENCES `empresa` (`codigoEmpresa`),
  ADD CONSTRAINT `oferta_ibfk_2` FOREIGN KEY (`usuarioLogin`) REFERENCES `usuarios` (`usuarioLogin`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
