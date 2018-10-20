/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : dbgirl

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2018-10-20 11:03:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for girl
-- ----------------------------
DROP TABLE IF EXISTS `girl`;
CREATE TABLE `girl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `cup_size` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of girl
-- ----------------------------
INSERT INTO `girl` VALUES ('1', '18', 'B');
INSERT INTO `girl` VALUES ('2', '22', 'D');
INSERT INTO `girl` VALUES ('4', '22', 'D');
INSERT INTO `girl` VALUES ('5', '22', 'D');
INSERT INTO `girl` VALUES ('6', '18', 'B');
INSERT INTO `girl` VALUES ('7', '1', 'B');
INSERT INTO `girl` VALUES ('8', '22', 'D');
INSERT INTO `girl` VALUES ('9', '20', 'B');
INSERT INTO `girl` VALUES ('12', '20', 'B');
INSERT INTO `girl` VALUES ('14', '20', 'B');
INSERT INTO `girl` VALUES ('16', '20', 'B');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('18');
