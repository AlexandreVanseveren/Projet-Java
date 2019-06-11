-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 08 juin 2019 à 01:44
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

DROP TABLE IF EXISTS `articles`;
CREATE TABLE IF NOT EXISTS `articles` (
  `PK_article` int(11) NOT NULL AUTO_INCREMENT,
  `Art_des` varchar(50) NOT NULL,
  `FK_cat` int(11) NOT NULL,
  PRIMARY KEY (`PK_article`),
  KEY `FK_cat` (`FK_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `articles`
--

INSERT INTO `articles` (`PK_article`, `Art_des`, `FK_cat`) VALUES
(1, 'porte', 1),
(3, 'Rateau', 4);

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `PK_categories` int(11) NOT NULL AUTO_INCREMENT,
  `Cat_des` varchar(30) NOT NULL,
  PRIMARY KEY (`PK_categories`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`PK_categories`, `Cat_des`) VALUES
(1, 'En pierre'),
(2, 'En metal'),
(4, 'En plastique'),
(5, 'En carton'),
(6, 'En metal'),
(7, 'En roc'),
(9, 'En fer'),
(10, 'En papier'),
(11, 'En carton'),
(12, 'En pierre'),
(13, 'En saphir'),
(14, 'En rubis'),
(15, 'En diamant');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `articles_ibfk_1` FOREIGN KEY (`FK_cat`) REFERENCES `categories` (`PK_categories`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
