-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Apr 07, 2022 at 07:35 PM
-- Server version: 5.7.32
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Tomatos`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer_customer`
--

CREATE TABLE `customer_customer` (
  `id` int(11) NOT NULL,
  `Customer_name` varchar(50) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `inventory_category`
--

CREATE TABLE `inventory_category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory_category`
--

INSERT INTO `inventory_category` (`id`, `name`) VALUES
(1, 'Chicken Dishes'),
(2, 'NON-Veg Snackes'),
(3, 'Veg Dishes'),
(4, 'Veg Snackes'),
(5, 'Breads'),
(6, 'Sides And Condiments'),
(7, 'Drinks'),
(8, 'Deserts'),
(9, 'Rice and Dishes'),
(10, 'Plate Specials'),
(11, 'Lamb Dishes'),
(12, 'Goat Dishes'),
(13, 'Seafood Curry'),
(14, 'Liquor,Beers and Wine');

-- --------------------------------------------------------

--
-- Table structure for table `inventory_menu`
--

CREATE TABLE `inventory_menu` (
  `id` int(11) NOT NULL,
  `Item` varchar(50) NOT NULL,
  `price` varchar(50) NOT NULL,
  `sold` int(11) DEFAULT NULL,
  `left` int(11) DEFAULT NULL,
  `GST` tinyint(1) NOT NULL,
  `PLT` tinyint(1) NOT NULL,
  `PST` tinyint(1) NOT NULL,
  `category_id` int(11) NOT NULL,
  `Discription` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory_menu`
--

INSERT INTO `inventory_menu` (`id`, `Item`, `price`, `sold`, `left`, `GST`, `PLT`, `PST`, `category_id`, `Discription`) VALUES
(1, 'Shahi Paneer', '12', 0, 0, 1, 0, 0, 3, 'Fresh Indian Cheese Simmered In rich tomatos and Onion Gravy'),
(2, 'Karahi Paneer', '12', 0, 0, 1, 0, 0, 3, 'Indian Cheese with bell peppers and stir-fry in onion curry'),
(3, 'Butter Chicken', '13', 0, 0, 1, 0, 0, 1, 'Boneless chicken simmered in a rich creamy Tomatos Sauce.'),
(4, 'Chicken Curry', '12', 0, 0, 1, 0, 0, 1, 'Boneless Chicken cooked in onions,Tomatos and Indian Spices'),
(5, 'Goat Curry', '14', 0, 0, 1, 0, 0, 12, 'Goat cooked in onions,Tomatos and Indian Spices'),
(8, ' BASA Fish Pakora', '8', 0, 0, 1, 0, 0, 2, 'Basa Fish fritters fried with flour and traditional Spices'),
(9, 'Chicken pakora', '12', 0, 0, 1, 0, 0, 2, 'boneless chicken fritters fried with flour and traditional spices.'),
(10, 'Veg Pakora', '7', 0, 0, 1, 0, 0, 4, 'Mixed Vegetables fritters with chick pea flour and deep fried'),
(11, 'Paneer Pakora', '11', 0, 0, 1, 0, 0, 4, 'Cheese battered with chick pea flour and deep and deep fried'),
(12, 'Tandoori Fish', '16', 0, 0, 1, 0, 0, 2, 'Cod fish marinated in exotic tandoori spices and baked slowly in tandoori oven'),
(13, 'Tandoori Chicken', '11', 0, 0, 1, 0, 0, 2, 'Leg and Thighs marinated in exotic tandoori spices and baked slowly in tandoori oven'),
(14, 'Chicken Tikka', '13', 0, 0, 1, 0, 0, 2, 'Boneless chicken marinated in exotic tandoori spices and baked slowly in tandoori oven'),
(15, 'Malai chicken tikka', '13', 0, 0, 1, 0, 0, 2, 'Boneless chicken marinated with creme cheese and cashew paste'),
(16, 'Seekh Kabab', '13', 0, 0, 1, 0, 0, 2, 'Ground lamb and chicken with chopped bell peppers and onions on skewers and baked in tandoori oven'),
(17, 'Shrimp Pakora', '20', 0, 0, 1, 0, 0, 2, 'Shrimp fitters fried with flour and traditional spices.'),
(18, 'Mint Chicken Tikka', '13', 0, 0, 1, 0, 0, 2, 'boneless Chicken marinated with fresh mint, spices, cooked slowly in tandoori oven.'),
(19, 'Chicken Wings', '12', 0, 0, 1, 0, 0, 2, 'Fire hot chicken wings in a Tomato chilli Sauce.'),
(20, 'Chilli Chicken Dry', '14', 0, 0, 1, 0, 0, 2, 'Boneless chicken with bell peppers and stir-fry in a dry chilli Sauce'),
(21, 'Lamb Tikka', '16', 0, 0, 1, 0, 0, 2, 'Lamb marinated in exotic tandoori spices and baked slowly in tandoori oven'),
(22, 'Tandoori Prawn', '18', 0, 0, 1, 0, 0, 2, 'Prawn marinated in exotic tandoori spices and baked slowly in tandoori oven'),
(23, 'Karahi Chicken', '13', 0, 0, 1, 0, 0, 1, 'Boneless chicken with bell peppers and stir-fry in onion curry'),
(24, 'Chicken Vindaloo', '12', 0, 0, 1, 0, 0, 1, 'The original spicy Goa Chicken curry'),
(25, 'Chicken Roganjosh', '12', 0, 0, 1, 0, 0, 1, 'Boneless chicken cooked in rich garlic,onion and yogurt curry.'),
(26, 'Chicken Coconut', '12', 0, 0, 1, 0, 0, 1, 'Boneless chicken simmered in mint and Coconut creamy Sauce.'),
(27, 'Chicken Tikka Masala', '13', 0, 0, 1, 0, 0, 1, 'Boneless Chicken with bell peppers and onions in a creamy and rich curry'),
(28, 'Chicken Korma', '13', 0, 0, 1, 0, 0, 1, 'Aromatic saffron,Cashew nut and creamy chicken Curry'),
(29, 'Chicken Palak', '12', 0, 0, 1, 0, 0, 1, 'Boneless chicken with freshly grounded spinach and spices.'),
(30, 'Chicken Malai', '13', 0, 0, 1, 0, 0, 1, 'Boneless Chicken with onions,Tomatos and rich creamy cheese curry.'),
(31, 'Chicken Chilli Saucy', '13', 0, 0, 1, 0, 0, 1, 'Boneless chicken with bell peppers and Stir-fry cooked in Indian style chilli curry'),
(32, 'Aloo Tikki Chat', '7', 0, 0, 1, 0, 0, 4, ''),
(33, 'Gol Gappe 8 Pcs', '6', 0, 0, 1, 0, 0, 4, 'Round hollow puri filled with flavoured water and potatoes.'),
(34, 'Sev Poori', '8', 0, 0, 1, 0, 0, 4, 'Round hollow puri filled with yogurt,chutnies,potatoes and spices.'),
(35, 'Veg Samosa 2 PCs With Sauces', '6', 0, 0, 1, 0, 0, 4, 'Crisped Paties stuffed with spiced potatoes,green peas and deep fried.'),
(36, 'Take Out Samosa ', '1.50', 0, 0, 1, 0, 0, 4, ''),
(37, 'Aloo Tikki 2 Pcs with Sauces', '6', 0, 0, 1, 0, 0, 4, 'Deep fried Crispy Potato Patty '),
(38, 'Aloo tikki 1 pc Take out', '1.25', 0, 0, 1, 0, 0, 4, ''),
(39, 'Chat Papri', '7', 0, 0, 1, 0, 0, 4, 'A mixture of wafle, yogurt, chutnies,chickpea and potatoes, served cold'),
(40, 'Dahi Bhalla Chat', '8', 0, 0, 1, 0, 0, 4, 'lentil fried balls served with wafle,  yogurt, chutnies,chickpea and potatoes, served cold'),
(41, 'Paneer TIkka', '13', 0, 0, 1, 0, 0, 4, 'Fresh Creamy Paneer marinated in exotic tandoori spices and baked slowly in tandoori oven'),
(43, 'Chana Tikki', '7', 0, 0, 1, 0, 0, 4, '2 Aloo Tikki served with Chana Masala,chutnies and spices.'),
(44, 'Chana Samosa', '7', 0, 0, 1, 0, 0, 4, '2 veg Samosas served with Chana Masala,chutnies and spices.'),
(45, 'Bread Pakore 2 Pcs', '6', 0, 0, 1, 0, 0, 4, 'Two bread pieces stuffed with spiced potatoes,battered with chick pea flour and deep fried.'),
(46, 'Gobi Pakore', '8', 0, 0, 1, 0, 0, 4, 'Cauliflower battered with chick pea flour and deep fried'),
(47, 'Veg Manchurian Saucy', '11', 0, 0, 1, 0, 0, 4, 'Vegetable Balls cooked in sweet and spicy chilli sauce.'),
(48, 'Karahi Goat', '14', 0, 0, 1, 0, 0, 12, 'Goat with bell peppers and stir-fry in onion curry'),
(53, 'Lamb Curry', '14', 0, 0, 1, 0, 0, 11, 'Lamb cooked in onions,Tomatos and Indian Spices'),
(54, 'Lamb Korma', '14', 0, 0, 1, 0, 0, 11, 'Aromatic saffron,Cashew nut and creamy Lamb Curry'),
(55, 'Karahi Lamb', '14', 0, 0, 1, 0, 0, 11, 'Lamb with bell peppers and stir-fry in onion curry'),
(56, 'Lamb Vindaloo', '14', 0, 0, 1, 0, 0, 11, 'The original spicy Goa Lamb curry'),
(57, 'Lamb Roganjosh', '14', 0, 0, 1, 0, 0, 11, 'Lamb cooked in rich garlic,onion and yogurt curry.'),
(58, 'Lamb Coconut', '14', 0, 0, 1, 0, 0, 11, 'Lamb simmered in mint and Coconut creamy Sauce.'),
(59, 'Lamb Palak', '14', 0, 0, 1, 0, 0, 11, 'Lamb with freshly grounded spinach and spices.'),
(60, 'Goat Palak', '14', 0, 0, 1, 0, 0, 12, 'Goat with freshly grounded spinach and spices.'),
(61, 'Mix Veg', '11', 0, 0, 1, 0, 0, 3, 'mix vegetable with exotic Spices and Onions'),
(62, 'Paneer Tikka Masala', '13', 0, 0, 1, 0, 0, 3, 'Indian Cheese with bell peppers and onions in a creamy and rich curry'),
(63, 'Chana Masala', '11', 0, 0, 1, 0, 0, 3, 'Traditional Indian Spicy Chickpeas Curry'),
(64, 'Palak Paneer', '12', 0, 0, 1, 0, 0, 3, 'Spinach and paneer cooked with exotic spices.'),
(65, 'Saag', '12', 0, 0, 1, 0, 0, 3, 'Minced Mustard Leaves with unique Indian Spices'),
(66, 'Dal Makhni', '11', 0, 0, 1, 0, 0, 3, 'Rich creamy indian Lentils'),
(67, 'Dal Turka', '11', 0, 0, 1, 0, 0, 3, 'Black lentils fried with onion,ginger,garlic and traditional spices'),
(68, 'Dal Fry', '11', 0, 0, 1, 0, 0, 3, 'Yellow Lintils with indian spices.'),
(69, 'Eggplant Bhartha ', '12', 0, 0, 1, 0, 0, 3, 'Roasted Eggplant cooked with onions and spices.'),
(70, 'Bhindi Masala Okra', '13', 0, 0, 1, 0, 0, 3, 'Fresh stir-fried okra cooked with onions,tomatos and spices'),
(71, 'Chilli Mushroom', '13', 0, 0, 1, 0, 0, 3, 'Mushroom with bell peppers and Stir-fry cooked in Indian style chilli curry'),
(72, 'Chilli Paneer Saucy', '12', 0, 0, 1, 0, 0, 3, 'Indian Cheese with bell peppers and Stir-fry cooked in Indian style chilli curry'),
(73, 'Mattar paneer', '12', 0, 0, 1, 0, 0, 3, 'Green peas and cheese with creamy onion Sauce and spices'),
(74, 'Mattar Mushroom', '12', 0, 0, 1, 0, 0, 3, 'Fresh Mushroom and Peas Cooked in a Delicious Onion gravy'),
(75, 'Aloo Gobi', '11', 0, 0, 1, 0, 0, 3, 'Cauliflower and Potatoes cooked with garlic,ginger and spices.'),
(76, 'Malai Kofta', '12', 0, 0, 1, 0, 0, 3, 'Fresh Grated potato balls with rich and creamy nut sauce'),
(78, 'Paneer Bhurji', '13', 0, 0, 1, 0, 0, 3, 'Grounded Cheese cooked with Fresh onion and Tomatos'),
(79, 'Veg Korma', '11', 0, 0, 1, 0, 0, 3, 'Aromatic saffron,Cashew nut and creamy veggie Curry'),
(80, 'Veg Briyani', '11', 0, 0, 1, 0, 0, 9, 'Fresh rice with mixed vegetables cooked in onions and spices.'),
(81, 'Chicken Briyani', '12', 0, 0, 1, 0, 0, 9, 'Chicken and rice cooked with bell peppers, onions, infused with Indian spices.'),
(82, 'Goat Briyani', '14', 0, 0, 1, 0, 0, 9, 'Goat and rice cooked with bell peppers, onions, infused with Indian spices.'),
(83, 'Lamb Briyani', '14', 0, 0, 1, 0, 0, 9, 'Lamb and rice cooked with bell peppers, onions, infused with Indian spices.'),
(84, 'Plain Rice', '4', 0, 0, 1, 0, 0, 9, ''),
(85, 'Rice Pullow', '5', 0, 0, 1, 0, 0, 9, 'Rice cooked with green pea.'),
(86, 'Plain Naan', '1.75', 0, 0, 1, 0, 0, 5, ''),
(87, 'Garlic Naan', '2.50', 0, 0, 1, 0, 0, 5, ''),
(88, 'Butter Naan', '2.00', 0, 0, 1, 0, 0, 5, ''),
(89, 'Onion Naan', '4', 0, 0, 1, 0, 0, 5, ''),
(90, 'Chicken Naan', '4', 0, 0, 1, 0, 0, 5, ''),
(91, 'Potato Naan', '4', 0, 0, 1, 0, 0, 5, ''),
(92, 'Paneer Naan', '4', 0, 0, 1, 0, 0, 5, ''),
(93, 'Spinach Naan', '4', 0, 0, 1, 0, 0, 5, ''),
(94, 'Lacchedar Parantha', '3.50', 0, 0, 1, 0, 0, 5, ''),
(95, 'Tandoori Roti', '1.50', 0, 0, 1, 0, 0, 5, ''),
(96, 'Tawa Roti', '2.50', 0, 0, 1, 0, 0, 5, ''),
(98, 'Salad', '3.50', 0, 0, 1, 0, 0, 6, ''),
(99, 'Papad', '1', 0, 0, 1, 0, 0, 6, ''),
(100, 'Raita', '4', 0, 0, 1, 0, 0, 6, ''),
(101, 'Dahi', '4', 0, 0, 1, 0, 0, 6, ''),
(103, 'Masala Tea', '2.50', 0, 0, 1, 0, 0, 7, ''),
(104, 'Black Coffee', '2.50', 0, 0, 1, 0, 0, 7, ''),
(105, 'Indian Style Coffee', '2.50', 0, 0, 1, 0, 0, 7, ''),
(106, 'Mango Shake', '4', 0, 0, 1, 0, 0, 7, ''),
(107, 'Strawberry Shake', '4', 0, 0, 1, 0, 0, 7, ''),
(108, 'Salt Lassi', '3', 0, 0, 1, 0, 0, 7, ''),
(109, 'Sweet Lassi', '3', 0, 0, 1, 0, 0, 7, ''),
(110, 'Mango Lassi', '4', 0, 0, 1, 0, 0, 7, ''),
(111, 'Soft Drink', '2', 0, 0, 1, 0, 1, 7, ''),
(112, 'Chana Bhatura', '8', 0, 0, 1, 0, 0, 10, '2 Fried Breads served with Chana masala,Yogurt and Pickle.'),
(113, 'Chana Poori', '8', 0, 0, 1, 0, 0, 10, '2 wholewheat Fried Breads served with Chana masala,Yogurt and Pickle.'),
(114, 'Ambarsari Kulcha Plate', '12', 0, 0, 1, 0, 0, 10, 'Flour Bread stuffed with potatoes and onions and served with chana masala,yogurt and pickles.'),
(115, 'Veg Noodle', '10', 0, 0, 1, 0, 0, 10, 'Noodles and Mixed Veggies cooked with Indian style.'),
(116, 'Bhaji Pao', '12', 0, 0, 1, 0, 0, 10, 'Bombay style bhaji served with bread.  '),
(117, 'Veg Dinner 3 Dishes', '14', 0, 0, 1, 0, 0, 10, 'Combination of 3 Veggie Curries(Shahi Paneer or Malai Kofta,Aloo gobi and palak Paneer) with Rice,Naan,Raita and Rasmalai'),
(118, 'Non-Veg Dinner 3dish 2pcChicken', '17', 0, 0, 1, 0, 0, 10, 'Combination of 3 Non-Veg Curries(Butter Chicken, Lamb Curry and Aloo gobi) with 2Pcs Tandoori Chicken,Rice,Naan,Raita and Rasmalai'),
(119, 'Veg Lunch 1Dish', '10', 0, 0, 1, 0, 0, 10, 'Combinaion of a Veggie curry,Rice,Naan and Raita'),
(120, 'Chicken Lunch 1 Dish', '11', 0, 0, 1, 0, 0, 10, 'Combinaion of a Chicken curry,Rice,Naan and Raita'),
(121, 'Goat Or Lamb Lunch 1 Dish', '13', 0, 0, 1, 0, 0, 10, 'Combinaion of a Goat or Lamb curry,Rice,Naan and Raita'),
(122, 'Tandoori lunch 5 pc Meat', '13', 0, 0, 1, 0, 0, 10, 'Combination of 2Pcs Tandoori chicken,2 Pcs Chicken Tikka and 1 Pc lamb tikka With Naan,Rice and Raita'),
(123, 'Ras Malai 2 PC', '4', 0, 0, 1, 0, 0, 8, ''),
(124, 'Gajrela', '5', 0, 0, 1, 0, 0, 8, ''),
(125, 'Gulab Jamun 2 PC', '4', 0, 0, 1, 0, 0, 8, ''),
(126, 'Icecream', '4', 0, 0, 1, 0, 0, 8, ''),
(127, 'Hot and Mild', '5', 0, 0, 1, 0, 0, 8, '2 Hot Gulabjamuns served with icecream'),
(128, 'Faluda Kulfi', '6', 0, 0, 1, 0, 0, 8, 'kulfi dessert, layered with condensed milk, noodles with rose syrup, topped with dry fruits.'),
(129, 'Kulfi', '4', 0, 0, 1, 0, 0, 8, ''),
(130, 'Fish Curry', '14', 0, 0, 1, 0, 0, 13, 'Fish cooked in onions,Tomatos and Indian Spices'),
(131, 'Fish Korma', '14', 0, 0, 1, 0, 0, 13, 'Aromatic saffron,Cashew nut and creamy Fish Curry'),
(132, 'Fish Vindaloo', '14', 0, 0, 1, 0, 0, 13, 'The original spicy Goa Fish curry'),
(134, 'Fish Coconut', '14', 0, 0, 1, 0, 0, 13, 'Cod fish simmered in mint and Coconut creamy Sauce.'),
(135, 'Karahi Fish', '14', 0, 0, 1, 0, 0, 13, 'Cod Fish with bell peppers and stir-fry in onion curry'),
(136, 'Chilli Fish', '14', 0, 0, 1, 0, 0, 13, 'Cod fish with bell peppers and Stir-fry cooked in Indian style chilli curry'),
(137, 'Shrimp Curry', '14', 0, 0, 1, 0, 0, 13, 'Shrimp cooked in onions,Tomatos and Indian Spices'),
(138, 'Tawa Sabji', '11', 0, 0, 1, 0, 0, 3, 'Mixed Vegetable with exotic spices,garlic  and onions'),
(139, 'Veg Spring Rolls 6 PCs', '6', 0, 0, 1, 0, 0, 4, 'Crispy patties stuffed vegetable and deep fried.'),
(140, 'Extra Bhatura', '2', 0, 0, 1, 0, 0, 5, ''),
(141, 'Extra Poori', '2', 0, 0, 1, 0, 0, 5, ''),
(142, 'Extra Parantha', '4', 0, 0, 1, 0, 0, 5, ''),
(143, 'Parantha Plate', '11', 0, 0, 1, 0, 0, 10, 'Wholewheat Shallow Fried Breads Stuffed with spiced potatoes served with  yogurt and pickle.'),
(144, 'Goat Masala', '15', 0, 0, 1, 0, 0, 12, 'Goat meat Cooked in thick and rich Onion Sauce.'),
(145, 'Shrimp Curry Lunch', '13', 0, 0, 1, 0, 0, 10, 'Combination of Shrimp curry,Naan,Rice and Raita.'),
(146, 'Shrimp Cocunut', '14', 0, 0, 1, 0, 0, 13, 'Shrimp simmered in mint and Coconut creamy Sauce.'),
(147, 'Shrimp Vindallo', '14', 0, 0, 1, 0, 0, 13, 'The original spicy Goa Shrimp curry'),
(148, 'Karahi Shrimp', '14', 0, 0, 1, 0, 0, 13, 'Shrimps with bell peppers and stir-fry in onion curry'),
(149, 'Chilli Shrimp', '14', 0, 0, 1, 0, 0, 13, 'Shrimp with bell peppers and Stir-fry cooked in Indian style chilli curry'),
(150, 'Paneer Vindaloo', '12', 0, 0, 1, 0, 0, 3, 'Indian Cheese Simmered In Spicy Onion and Vineger Curry'),
(151, 'Shrimp Korma', '14', 0, 0, 1, 0, 0, 13, 'Aromatic saffron,Cashew nut and creamy Shrimp Curry'),
(152, 'Shrimp Korma', '14', 0, 0, 1, 0, 0, 13, 'Aromatic saffron,Cashew nut and creamy Shrimp Curry'),
(153, 'Punjabi Kadi Pakora', '11', 0, 0, 1, 0, 0, 3, 'Yogurt and chick pea flour curry cooked with traditional indian spices.'),
(154, 'Tomatos All Day Special', '12', 0, 0, 1, 0, 0, 10, 'Combination of Butter chicken,2PC Tandoori Chicken, Naan And rice.'),
(155, 'Water Bottle', '1', NULL, NULL, 1, 0, 0, 7, ''),
(156, 'Corona', '6.00', NULL, NULL, 1, 1, 0, 14, ''),
(157, 'Budweiser', '5', NULL, NULL, 1, 1, 0, 14, ''),
(158, 'Kokanee', '5.00', NULL, NULL, 1, 1, 0, 14, ''),
(159, 'Canadian Molson', '5.00', NULL, NULL, 1, 1, 0, 14, ''),
(160, 'Stella', '6.00', NULL, NULL, 1, 1, 0, 14, ''),
(161, 'KingFisher', '6.00', NULL, NULL, 1, 1, 0, 14, ''),
(163, 'Wine Glass', '6.00', NULL, NULL, 1, 1, 0, 14, ''),
(164, 'Wine Bottle', '25.00', NULL, NULL, 1, 1, 0, 14, ''),
(165, 'Jameson Single', '6.50', NULL, NULL, 1, 1, 0, 14, ''),
(166, 'Jameson Double', '9.50', NULL, NULL, 1, 1, 0, 14, ''),
(167, 'Crown Royal Single', '6.00', NULL, NULL, 1, 1, 0, 14, ''),
(168, 'Crown Royal Double', '9.00', NULL, NULL, 1, 1, 0, 14, ''),
(169, 'Smirnoff Single', '6.00', NULL, NULL, 1, 1, 0, 14, ''),
(170, 'Smirnoff Double', '9.00', NULL, NULL, 1, 1, 0, 14, ''),
(171, 'Captain Morgan Single', '6.00', NULL, NULL, 1, 1, 0, 14, ''),
(172, 'Captain Morgan Double', '9.00', NULL, NULL, 1, 1, 0, 14, ''),
(173, 'Chicken Noodle', '12', 0, 0, 1, 0, 0, 2, ''),
(174, 'Fish Pakora', '13', 0, 0, 1, 0, 0, 2, ''),
(175, 'Tattar Sauce', '1.00', 0, 0, 1, 0, 0, 6, ''),
(176, 'Extra Butter', '2', 0, 0, 1, 0, 0, 6, ''),
(177, 'Small Dahi or raita', '2', 0, 0, 1, 0, 0, 6, ''),
(178, 'Small Channe', '3', 0, 0, 1, 0, 0, 6, ''),
(179, 'Oreo Shake', '5', 0, 0, 1, 0, 0, 7, ''),
(180, 'Shrimp Biriyani', '15', 0, 0, 1, 0, 0, 9, ''),
(181, 'Ambarsari Fish Pakora', '10', NULL, NULL, 1, 0, 0, 2, ''),
(182, 'Chilli Paneer Dry', '13', 0, 0, 1, 0, 0, 4, 'Indian Cheese with bell peppers and stir fry cooked in indian style chilli curry'),
(183, 'Veg munchurian Dry', '12', 0, 0, 1, 0, 0, 4, 'Vegetable balls cooked in sweet and spicy chilli sauce.'),
(184, 'Black Label S', '7', 0, 0, 1, 1, 0, 14, ''),
(185, 'Balck Label D', '10', 0, 0, 1, 1, 0, 14, '');

-- --------------------------------------------------------

--
-- Table structure for table `orders_orderitems`
--

CREATE TABLE `orders_orderitems` (
  `id` int(11) NOT NULL,
  `Active` tinyint(1) NOT NULL,
  `Qty` int(11) NOT NULL,
  `GuestId` int(11) NOT NULL,
  `Item_id` int(11) NOT NULL,
  `order_ID_id` int(11) NOT NULL,
  `Comment` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `orders_orders`
--

CREATE TABLE `orders_orders` (
  `order_ID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time(6) NOT NULL,
  `Active` tinyint(1) NOT NULL,
  `paymentType` varchar(50) DEFAULT NULL,
  `Tip` double DEFAULT NULL,
  `GST` double DEFAULT NULL,
  `PLT` double DEFAULT NULL,
  `SubTotal` double NOT NULL,
  `Table` varchar(50) DEFAULT NULL,
  `TakeOutNumber` int(11) DEFAULT NULL,
  `Guest` int(11) NOT NULL DEFAULT '1',
  `Cutomer_name_id` int(11) DEFAULT NULL,
  `DiscountPrice` double NOT NULL,
  `Discount` varchar(50) DEFAULT '',
  `PST` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_customer`
--
ALTER TABLE `customer_customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inventory_category`
--
ALTER TABLE `inventory_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inventory_menu`
--
ALTER TABLE `inventory_menu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Inventory_menu_category_id_20ef8636_fk_Inventory_category_id` (`category_id`);

--
-- Indexes for table `orders_orderitems`
--
ALTER TABLE `orders_orderitems`
  ADD PRIMARY KEY (`id`),
  ADD KEY `orders_orderitems_Item_id_46d2e63b_fk_Inventory_menu_id` (`Item_id`),
  ADD KEY `orders_orderitems_order_ID_id_d336ad92_fk_orders_orders_id` (`order_ID_id`);

--
-- Indexes for table `orders_orders`
--
ALTER TABLE `orders_orders`
  ADD PRIMARY KEY (`order_ID`),
  ADD UNIQUE KEY `orders_orders_order_ID_1c4d5dae_uniq` (`order_ID`),
  ADD KEY `orders_orders_Cutomer_name_id_f2764bb7_fk_Customer_customer_id` (`Cutomer_name_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_customer`
--
ALTER TABLE `customer_customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `inventory_category`
--
ALTER TABLE `inventory_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `inventory_menu`
--
ALTER TABLE `inventory_menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=186;

--
-- AUTO_INCREMENT for table `orders_orderitems`
--
ALTER TABLE `orders_orderitems`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orders_orders`
--
ALTER TABLE `orders_orders`
  MODIFY `order_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory_menu`
--
ALTER TABLE `inventory_menu`
  ADD CONSTRAINT `Inventory_menu_category_id_20ef8636_fk_Inventory_category_id` FOREIGN KEY (`category_id`) REFERENCES `inventory_category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
