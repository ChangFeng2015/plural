/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : word
Target Host     : localhost:3306
Target Database : word
Date: 2017-09-28 13:46:03
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for word_list
-- ----------------------------
DROP TABLE IF EXISTS `word_list`;
CREATE TABLE `word_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `word` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '单词(单数形式)',
  `plural_word` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '单词(复数形式)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of word_list
-- ----------------------------
INSERT INTO `word_list` VALUES ('4', 'apple', 'apples');
