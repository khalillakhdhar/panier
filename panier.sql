-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : Dim 13 juin 2021 à 12:48
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `panier`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `numCli` int(11) NOT NULL,
  `nomCli` varchar(20) DEFAULT NULL,
  `prenomCli` varchar(20) DEFAULT NULL,
  `adrCli` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`numCli`, `nomCli`, `prenomCli`, `adrCli`) VALUES
(123, 'Ali', 'Ahmed', 'Gabes'),
(456, 'Nefzaoui', 'Mohamed', 'Gab?s sud'),
(1234, 'lakhdhar', 'khalil', '555 Cit? El Amel');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `numCom` int(11) NOT NULL,
  `numcli` int(11) DEFAULT NULL,
  `dateCde` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `famille`
--

CREATE TABLE `famille` (
  `numFam` int(11) NOT NULL,
  `nomFam` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `famille`
--

INSERT INTO `famille` (`numFam`, `nomFam`) VALUES
(1, 'habilles'),
(2, 'nourriture');

-- --------------------------------------------------------

--
-- Structure de la table `lignecommande`
--

CREATE TABLE `lignecommande` (
  `numCde` int(11) NOT NULL,
  `numPro` int(11) NOT NULL,
  `qteCde` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `numPro` int(11) NOT NULL,
  `nomPro` varchar(40) DEFAULT NULL,
  `puProd` decimal(6,2) DEFAULT NULL,
  `famPro` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`numPro`, `nomPro`, `puProd`, `famPro`) VALUES
(12, 'Tomate', '800.00', 12),
(13, 'Beure', '900.00', 14);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`numCli`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`numCom`),
  ADD KEY `c2` (`numcli`);

--
-- Index pour la table `famille`
--
ALTER TABLE `famille`
  ADD PRIMARY KEY (`numFam`);

--
-- Index pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD PRIMARY KEY (`numCde`,`numPro`),
  ADD KEY `c5` (`numPro`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`numPro`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `c2` FOREIGN KEY (`numcli`) REFERENCES `client` (`numCli`);

--
-- Contraintes pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD CONSTRAINT `c4` FOREIGN KEY (`numCde`) REFERENCES `commande` (`numCom`),
  ADD CONSTRAINT `c5` FOREIGN KEY (`numPro`) REFERENCES `produit` (`numPro`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
