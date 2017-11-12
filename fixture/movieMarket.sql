-- Client :  localhost:3306
-- Généré le :  Ven 10 Novembre 2017 à 13:01
-- Version du serveur :  5.7.20-0ubuntu0.17.10.1
-- Version de PHP :  7.1.8-1ubuntu1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `movieMarket`
--

-- --------------------------------------------------------

--
-- Structure de la table `Movie`
--

CREATE TABLE `movie` (
  `id` BIGINT NOT NULL,
  `img` varchar(255),
  `name` varchar(255),
  `description` varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Movie`
--

INSERT INTO `movie` (`id`, `name`, `img`, `description`) VALUES
(0, 'Oblivion', 'oblivion.jpg', 'Après des décennies de guerre contre la terrible menace dénommée les Scavs, les humains ont quittés la Terre. Jack Harper, qui vit sur une station située dans les nuages, a pour mission d\'extraire des ressources vitales nécessaires aux humains expatriés. Son existence est bouleversée lorsqu\'il sauve une belle inconnue d\'un vaisseau en déperdition. Son arrivée va déclencher une série d\'évènements qui vont le forcer à remettre en question tout ce qu\'il connaissait.'),
(1, 'Wonder Women', 'wonder-woman.jpg', 'test'),
(2, 'oblivion', 'oblivion.jpg', 'test');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
