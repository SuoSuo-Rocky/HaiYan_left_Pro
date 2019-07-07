/*
MySQL Data Transfer
Source Host: localhost
Source Database: mybook
Target Host: localhost
Target Database: mybook
Date: 2018/12/26 1:09:02
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for book
-- ----------------------------
CREATE TABLE `book` (
  `boid` int(100) NOT NULL,
  `dukind` int(100) DEFAULT NULL,
  `boname` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `borank` int(100) DEFAULT NULL,
  `boimg` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`boid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for login
-- ----------------------------
CREATE TABLE `login` (
  `stuid` int(100) NOT NULL,
  `stuname` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `password` int(100) DEFAULT NULL,
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for reader
-- ----------------------------
CREATE TABLE `reader` (
  `stuid` int(100) NOT NULL,
  `dupart` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `dukind` int(100) DEFAULT NULL,
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for self
-- ----------------------------
CREATE TABLE `self` (
  `stuid` int(100) NOT NULL,
  `boid` int(100) NOT NULL,
  PRIMARY KEY (`stuid`,`boid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `book` VALUES ('3', '300', '八宅明镜', '2', 's (3).jpg');
INSERT INTO `book` VALUES ('4', '400', '麻衣神相', '2', 's (4).jpg');
INSERT INTO `book` VALUES ('7', '200', '浪漫时代', '3', 's (7).jpg');
INSERT INTO `book` VALUES ('8', '300', '摄影美学', '4', 's (8).jpg');
INSERT INTO `book` VALUES ('10', '200', '世说新语', '3', 's (10).jpg');
INSERT INTO `book` VALUES ('11', '400', '666', '666', '666');
INSERT INTO `book` VALUES ('888', null, 'shiwei', '888', '888');
INSERT INTO `book` VALUES ('9999', null, '9999', '9999', '9999');
INSERT INTO `login` VALUES ('100', '100', '100');
INSERT INTO `login` VALUES ('200', '200', '200');
INSERT INTO `login` VALUES ('300', '300', '300');
INSERT INTO `login` VALUES ('500', '500', '500');
INSERT INTO `login` VALUES ('1313', '13', '1313');
INSERT INTO `login` VALUES ('4545', '4545', '4545');
INSERT INTO `login` VALUES ('5959', '5959', '5959');
INSERT INTO `login` VALUES ('7777', '7777', '7777');
INSERT INTO `login` VALUES ('8989', '8989', '8989');
INSERT INTO `reader` VALUES ('100', 'one', '100');
INSERT INTO `reader` VALUES ('200', 'two', '200');
INSERT INTO `reader` VALUES ('300', 'three', '300');
INSERT INTO `reader` VALUES ('400', 'four', '400');
INSERT INTO `reader` VALUES ('500', 'five', '500');
INSERT INTO `self` VALUES ('100', '3');
INSERT INTO `self` VALUES ('100', '4');
INSERT INTO `self` VALUES ('100', '7');
INSERT INTO `self` VALUES ('100', '8');
INSERT INTO `self` VALUES ('100', '9');
INSERT INTO `self` VALUES ('100', '10');
INSERT INTO `self` VALUES ('100', '9999');
INSERT INTO `self` VALUES ('200', '1');
INSERT INTO `self` VALUES ('200', '2');
INSERT INTO `self` VALUES ('200', '3');
INSERT INTO `self` VALUES ('200', '4');
INSERT INTO `self` VALUES ('200', '5');
INSERT INTO `self` VALUES ('200', '6');
INSERT INTO `self` VALUES ('200', '7');
INSERT INTO `self` VALUES ('200', '8');
INSERT INTO `self` VALUES ('1313', '7');
INSERT INTO `self` VALUES ('1313', '10');
