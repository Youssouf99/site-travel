-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : mysql
-- Généré le : ven. 24 mai 2024 à 12:13
-- Version du serveur : 5.7.44
-- Version de PHP : 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sitetravel`
--

-- --------------------------------------------------------

--
-- Structure de la table `travel`
--

CREATE TABLE `travel` (
  `available_of_rooms` int(11) DEFAULT NULL,
  `duration_hours` int(11) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `number_of_stars` int(11) NOT NULL,
  `price` double NOT NULL,
  `start_date` date DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `travel_type` varchar(31) NOT NULL,
  `activity_type` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `airline` varchar(255) DEFAULT NULL,
  `departure_city` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `destination_city` varchar(255) DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `hotel_name` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `travel`
--

INSERT INTO `travel` (`available_of_rooms`, `duration_hours`, `end_date`, `number_of_stars`, `price`, `start_date`, `id`, `travel_type`, `activity_type`, `address`, `airline`, `departure_city`, `description`, `destination_city`, `flight_number`, `hotel_name`, `image_url`, `name`) VALUES
(8, NULL, '2024-05-29', 3, 200, '2024-05-24', 1, 'HOTEL', NULL, '123 Main St', NULL, NULL, 'Luxury hotel in Paris', 'Paris', NULL, 'Hotel Eiffel', 'https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=600', 'Paris Getaway'),
(NULL, NULL, '2024-05-27', 3, 150, '2024-05-24', 2, 'FLIGHT', NULL, NULL, 'Air France', 'New York', 'Direct flight to Paris', 'Paris', 'AF123', NULL, 'https://images.pexels.com/photos/47044/aircraft-landing-reach-injection-47044.jpeg?auto=compress&cs=tinysrgb&w=600', 'New York to Paris'),
(NULL, 2, '2024-05-29', 5, 50, '2024-05-24', 3, 'ACTIVITY', 'Museum Visit', NULL, NULL, NULL, 'Visit the Louvre Museum', 'Paris', NULL, NULL, 'https://images.pexels.com/photos/2363/france-landmark-lights-night.jpg?auto=compress&cs=tinysrgb&w=600', 'Louvre Museum Visit'),
(20, NULL, '2024-05-26', 2, 180, '2024-05-24', 4, 'HOTEL', NULL, '456 Broadway', NULL, NULL, 'Budget hotel in New York', 'New York', NULL, 'Hotel Broadway', 'https://images.pexels.com/photos/261102/pexels-photo-261102.jpeg?auto=compress&cs=tinysrgb&w=600', 'New York Adventure'),
(NULL, NULL, '2024-05-27', 5, 120, '2024-05-24', 5, 'FLIGHT', NULL, NULL, 'Delta Airlines', 'Los Angeles', 'Direct flight to New York', 'New York', 'DL456', NULL, 'https://images.pexels.com/photos/358319/pexels-photo-358319.jpeg?auto=compress&cs=tinysrgb&w=600', 'Los Angeles to New York'),
(NULL, 4, '2024-05-26', 4, 80, '2024-05-24', 6, 'ACTIVITY', 'City Tour', NULL, NULL, NULL, 'Explore New York City', 'New York', NULL, NULL, 'https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/25/13/74.jpg', 'New York City Tour'),
(15, NULL, '2024-05-26', 3, 300, '2024-05-24', 7, 'HOTEL', NULL, '789 Park Ave', NULL, NULL, 'Luxury hotel in London', 'London', NULL, 'Hotel Park', 'https://images.pexels.com/photos/597909/pexels-photo-597909.jpeg?auto=compress&cs=tinysrgb&w=600', 'London Escape'),
(NULL, NULL, '2024-05-27', 4, 200, '2024-05-24', 8, 'FLIGHT', NULL, NULL, 'British Airways', 'Chicago', 'Direct flight to London', 'London', 'BA789', NULL, 'https://images.pexels.com/photos/164589/pexels-photo-164589.jpeg?auto=compress&cs=tinysrgb&w=600', 'Chicago to London'),
(NULL, 3, '2024-05-28', 2, 60, '2024-05-24', 9, 'ACTIVITY', 'Theater Show', NULL, NULL, NULL, 'Watch a show in London', 'London', NULL, NULL, 'https://images.pexels.com/photos/220887/pexels-photo-220887.jpeg?auto=compress&cs=tinysrgb&w=600', 'London Theater Show'),
(5, NULL, '2024-05-26', 3, 250, '2024-05-24', 10, 'HOTEL', NULL, '321 Rue de Rivoli', NULL, NULL, 'Boutique hotel in Paris', 'Paris', NULL, 'Hotel Rivoli', 'https://images.pexels.com/photos/2373201/pexels-photo-2373201.jpeg?auto=compress&cs=tinysrgb&w=600', 'Parisian Getaway'),
(10, NULL, '2024-05-29', 3, 200, '2024-05-24', 11, 'HOTEL', NULL, '123 Main St', NULL, NULL, 'Luxury hotel in Paris', 'Paris', NULL, 'Hotel Eiffel', 'https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=600', 'Paris Getaway'),
(NULL, NULL, '2024-05-29', 4, 150, '2024-05-24', 12, 'FLIGHT', NULL, NULL, 'Air France', 'New York', 'Direct flight to Paris', 'Paris', 'AF123', NULL, 'https://images.pexels.com/photos/47044/aircraft-landing-reach-injection-47044.jpeg?auto=compress&cs=tinysrgb&w=600', 'New York to Paris'),
(NULL, 2, '2024-05-29', 3, 50, '2024-05-24', 13, 'ACTIVITY', 'Museum Visit', NULL, NULL, NULL, 'Visit the Louvre Museum', 'Paris', NULL, NULL, 'https://images.pexels.com/photos/2363/france-landmark-lights-night.jpg?auto=compress&cs=tinysrgb&w=600', 'Louvre Museum Visit'),
(20, NULL, '2024-05-29', 2, 180, '2024-05-24', 14, 'HOTEL', NULL, '456 Broadway', NULL, NULL, 'Budget hotel in New York', 'New York', NULL, 'Hotel Broadway', 'https://images.pexels.com/photos/261102/pexels-photo-261102.jpeg?auto=compress&cs=tinysrgb&w=600', 'New York Adventure'),
(NULL, NULL, '2024-05-26', 4, 120, '2024-05-24', 15, 'FLIGHT', NULL, NULL, 'Delta Airlines', 'Los Angeles', 'Direct flight to New York', 'New York', 'DL456', NULL, 'https://images.pexels.com/photos/358319/pexels-photo-358319.jpeg?auto=compress&cs=tinysrgb&w=600', 'Los Angeles to New York'),
(NULL, 4, '2024-05-28', 5, 80, '2024-05-24', 16, 'ACTIVITY', 'City Tour', NULL, NULL, NULL, 'Explore New York City', 'New York', NULL, NULL, 'https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/25/13/74.jpg', 'New York City Tour'),
(15, NULL, '2024-05-27', 5, 300, '2024-05-24', 17, 'HOTEL', NULL, '789 Park Ave', NULL, NULL, 'Luxury hotel in London', 'London', NULL, 'Hotel Park', 'https://images.pexels.com/photos/597909/pexels-photo-597909.jpeg?auto=compress&cs=tinysrgb&w=600', 'London Escape'),
(NULL, NULL, '2024-05-28', 3, 200, '2024-05-24', 18, 'FLIGHT', NULL, NULL, 'British Airways', 'Chicago', 'Direct flight to London', 'London', 'BA789', NULL, 'https://images.pexels.com/photos/164589/pexels-photo-164589.jpeg?auto=compress&cs=tinysrgb&w=600', 'Chicago to London'),
(NULL, 3, '2024-05-28', 4, 60, '2024-05-24', 19, 'ACTIVITY', 'Theater Show', NULL, NULL, NULL, 'Watch a show in London', 'London', NULL, NULL, 'https://images.pexels.com/photos/220887/pexels-photo-220887.jpeg?auto=compress&cs=tinysrgb&w=600', 'London Theater Show'),
(5, NULL, '2024-05-27', 3, 250, '2024-05-24', 20, 'HOTEL', NULL, '321 Rue de Rivoli', NULL, NULL, 'Boutique hotel in Paris', 'Paris', NULL, 'Hotel Rivoli', 'https://images.pexels.com/photos/2373201/pexels-photo-2373201.jpeg?auto=compress&cs=tinysrgb&w=600', 'Parisian Getaway'),
(10, NULL, '2024-05-28', 3, 200, '2024-05-24', 21, 'HOTEL', NULL, '123 Main St', NULL, NULL, 'Luxury hotel in Paris', 'Paris', NULL, 'Hotel Eiffel', 'https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=600', 'Paris Getaway'),
(NULL, NULL, '2024-05-28', 3, 150, '2024-05-24', 22, 'FLIGHT', NULL, NULL, 'Air France', 'New York', 'Direct flight to Paris', 'Paris', 'AF123', NULL, 'https://images.pexels.com/photos/47044/aircraft-landing-reach-injection-47044.jpeg?auto=compress&cs=tinysrgb&w=600', 'New York to Paris'),
(NULL, 2, '2024-05-26', 3, 50, '2024-05-24', 23, 'ACTIVITY', 'Museum Visit', NULL, NULL, NULL, 'Visit the Louvre Museum', 'Paris', NULL, NULL, 'https://images.pexels.com/photos/2363/france-landmark-lights-night.jpg?auto=compress&cs=tinysrgb&w=600', 'Louvre Museum Visit'),
(20, NULL, '2024-05-28', 4, 180, '2024-05-24', 24, 'HOTEL', NULL, '456 Broadway', NULL, NULL, 'Budget hotel in New York', 'New York', NULL, 'Hotel Broadway', 'https://images.pexels.com/photos/261102/pexels-photo-261102.jpeg?auto=compress&cs=tinysrgb&w=600', 'New York Adventure'),
(NULL, NULL, '2024-05-28', 5, 120, '2024-05-24', 25, 'FLIGHT', NULL, NULL, 'Delta Airlines', 'Los Angeles', 'Direct flight to New York', 'New York', 'DL456', NULL, 'https://images.pexels.com/photos/358319/pexels-photo-358319.jpeg?auto=compress&cs=tinysrgb&w=600', 'Los Angeles to New York'),
(NULL, 4, '2024-05-29', 3, 80, '2024-05-24', 26, 'ACTIVITY', 'City Tour', NULL, NULL, NULL, 'Explore New York City', 'New York', NULL, NULL, 'https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/25/13/74.jpg', 'New York City Tour'),
(15, NULL, '2024-05-28', 5, 300, '2024-05-24', 27, 'HOTEL', NULL, '789 Park Ave', NULL, NULL, 'Luxury hotel in London', 'London', NULL, 'Hotel Park', 'https://images.pexels.com/photos/597909/pexels-photo-597909.jpeg?auto=compress&cs=tinysrgb&w=600', 'London Escape'),
(NULL, NULL, '2024-05-26', 3, 200, '2024-05-24', 28, 'FLIGHT', NULL, NULL, 'British Airways', 'Chicago', 'Direct flight to London', 'London', 'BA789', NULL, 'https://images.pexels.com/photos/164589/pexels-photo-164589.jpeg?auto=compress&cs=tinysrgb&w=600', 'Chicago to London'),
(NULL, 3, '2024-05-27', 3, 60, '2024-05-24', 29, 'ACTIVITY', 'Theater Show', NULL, NULL, NULL, 'Watch a show in London', 'London', NULL, NULL, 'https://images.pexels.com/photos/220887/pexels-photo-220887.jpeg?auto=compress&cs=tinysrgb&w=600', 'London Theater Show'),
(5, NULL, '2024-05-27', 2, 250, '2024-05-24', 30, 'HOTEL', NULL, '321 Rue de Rivoli', NULL, NULL, 'Boutique hotel in Paris', 'Paris', NULL, 'Hotel Rivoli', 'https://images.pexels.com/photos/2373201/pexels-photo-2373201.jpeg?auto=compress&cs=tinysrgb&w=600', 'Parisian Getaway'),
(10, NULL, '2024-05-29', 3, 200, '2024-05-24', 31, 'HOTEL', NULL, '123 Main St', NULL, NULL, 'Luxury hotel in Paris', 'Paris', NULL, 'Hotel Eiffel', 'https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=600', 'Paris Getaway'),
(NULL, NULL, '2024-05-26', 3, 150, '2024-05-24', 32, 'FLIGHT', NULL, NULL, 'Air France', 'New York', 'Direct flight to Paris', 'Paris', 'AF123', NULL, 'https://images.pexels.com/photos/47044/aircraft-landing-reach-injection-47044.jpeg?auto=compress&cs=tinysrgb&w=600', 'New York to Paris'),
(NULL, 2, '2024-05-27', 3, 50, '2024-05-24', 33, 'ACTIVITY', 'Museum Visit', NULL, NULL, NULL, 'Visit the Louvre Museum', 'Paris', NULL, NULL, 'https://images.pexels.com/photos/2363/france-landmark-lights-night.jpg?auto=compress&cs=tinysrgb&w=600', 'Louvre Museum Visit'),
(20, NULL, '2024-05-29', 4, 180, '2024-05-24', 34, 'HOTEL', NULL, '456 Broadway', NULL, NULL, 'Budget hotel in New York', 'New York', NULL, 'Hotel Broadway', 'https://images.pexels.com/photos/261102/pexels-photo-261102.jpeg?auto=compress&cs=tinysrgb&w=600', 'New York Adventure'),
(NULL, NULL, '2024-05-29', 5, 120, '2024-05-24', 35, 'FLIGHT', NULL, NULL, 'Delta Airlines', 'Los Angeles', 'Direct flight to New York', 'New York', 'DL456', NULL, 'https://images.pexels.com/photos/358319/pexels-photo-358319.jpeg?auto=compress&cs=tinysrgb&w=600', 'Los Angeles to New York'),
(NULL, 4, '2024-05-28', 5, 80, '2024-05-24', 36, 'ACTIVITY', 'City Tour', NULL, NULL, NULL, 'Explore New York City', 'New York', NULL, NULL, 'https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/25/13/74.jpg', 'New York City Tour'),
(15, NULL, '2024-05-27', 4, 300, '2024-05-24', 37, 'HOTEL', NULL, '789 Park Ave', NULL, NULL, 'Luxury hotel in London', 'London', NULL, 'Hotel Park', 'https://images.pexels.com/photos/597909/pexels-photo-597909.jpeg?auto=compress&cs=tinysrgb&w=600', 'London Escape'),
(NULL, NULL, '2024-05-27', 3, 200, '2024-05-24', 38, 'FLIGHT', NULL, NULL, 'British Airways', 'Chicago', 'Direct flight to London', 'London', 'BA789', NULL, 'https://images.pexels.com/photos/164589/pexels-photo-164589.jpeg?auto=compress&cs=tinysrgb&w=600', 'Chicago to London'),
(NULL, 3, '2024-05-26', 4, 60, '2024-05-24', 39, 'ACTIVITY', 'Theater Show', NULL, NULL, NULL, 'Watch a show in London', 'London', NULL, NULL, 'https://images.pexels.com/photos/220887/pexels-photo-220887.jpeg?auto=compress&cs=tinysrgb&w=600', 'London Theater Show'),
(5, NULL, '2024-05-29', 5, 250, '2024-05-24', 40, 'HOTEL', NULL, '321 Rue de Rivoli', NULL, NULL, 'Boutique hotel in Paris', 'Paris', NULL, 'Hotel Rivoli', 'https://images.pexels.com/photos/2373201/pexels-photo-2373201.jpeg?auto=compress&cs=tinysrgb&w=600', 'Parisian Getaway');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `travel`
--
ALTER TABLE `travel`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `travel`
--
ALTER TABLE `travel`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
