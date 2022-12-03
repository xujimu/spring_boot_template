/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : template

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 04/12/2022 02:08:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '测试表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (2, '1');
INSERT INTO `test` VALUES (3, '123');
INSERT INTO `test` VALUES (4, '');
INSERT INTO `test` VALUES (5, '');
INSERT INTO `test` VALUES (6, '');
INSERT INTO `test` VALUES (7, '');
INSERT INTO `test` VALUES (8, '');
INSERT INTO `test` VALUES (9, '');
INSERT INTO `test` VALUES (10, '');
INSERT INTO `test` VALUES (11, '');
INSERT INTO `test` VALUES (12, '');
INSERT INTO `test` VALUES (13, '');
INSERT INTO `test` VALUES (14, '123');
INSERT INTO `test` VALUES (15, '123');

SET FOREIGN_KEY_CHECKS = 1;
