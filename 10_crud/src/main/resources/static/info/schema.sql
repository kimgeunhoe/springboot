CREATE TABLE `board` (
  `bno` int NOT NULL,
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` text NOT NULL,
  `readcount` int NOT NULL DEFAULT '0',
  `regdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `regid` varchar(50) NOT NULL,
  `moddate` datetime DEFAULT NULL,
  `modid` varchar(50) DEFAULT NULL,
  `isremoved` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;