CREATE DATABASE IF NOT EXISTS `products` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `body_html` text COLLATE utf8mb4_unicode_ci,
  `img` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tags` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `vendor` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cost` decimal(11,2) DEFAULT NULL,
  `price` decimal(11,2) NOT NULL,
  `compare_at_price` decimal(11,2) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `sku` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `barcode` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `product_title_IDX` (`title`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;