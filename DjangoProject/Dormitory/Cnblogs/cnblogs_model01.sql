/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : cnblogs_model01

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 26/04/2019 18:42:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_group
-- ----------------------------
DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE `auth_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for auth_group_permissions
-- ----------------------------
DROP TABLE IF EXISTS `auth_group_permissions`;
CREATE TABLE `auth_group_permissions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_group_permissions_group_id_permission_id_0cd325b0_uniq`(`group_id`, `permission_id`) USING BTREE,
  INDEX `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm`(`permission_id`) USING BTREE,
  CONSTRAINT `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auth_group_permissions_group_id_b120cbf9_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `codename` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_permission_content_type_id_codename_01ab375a_uniq`(`content_type_id`, `codename`) USING BTREE,
  CONSTRAINT `auth_permission_content_type_id_2f476e4b_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_permission
-- ----------------------------
INSERT INTO `auth_permission` VALUES (1, 'Can add log entry', 1, 'add_logentry');
INSERT INTO `auth_permission` VALUES (2, 'Can change log entry', 1, 'change_logentry');
INSERT INTO `auth_permission` VALUES (3, 'Can delete log entry', 1, 'delete_logentry');
INSERT INTO `auth_permission` VALUES (4, 'Can view log entry', 1, 'view_logentry');
INSERT INTO `auth_permission` VALUES (5, 'Can add permission', 2, 'add_permission');
INSERT INTO `auth_permission` VALUES (6, 'Can change permission', 2, 'change_permission');
INSERT INTO `auth_permission` VALUES (7, 'Can delete permission', 2, 'delete_permission');
INSERT INTO `auth_permission` VALUES (8, 'Can view permission', 2, 'view_permission');
INSERT INTO `auth_permission` VALUES (9, 'Can add group', 3, 'add_group');
INSERT INTO `auth_permission` VALUES (10, 'Can change group', 3, 'change_group');
INSERT INTO `auth_permission` VALUES (11, 'Can delete group', 3, 'delete_group');
INSERT INTO `auth_permission` VALUES (12, 'Can view group', 3, 'view_group');
INSERT INTO `auth_permission` VALUES (13, 'Can add user', 4, 'add_user');
INSERT INTO `auth_permission` VALUES (14, 'Can change user', 4, 'change_user');
INSERT INTO `auth_permission` VALUES (15, 'Can delete user', 4, 'delete_user');
INSERT INTO `auth_permission` VALUES (16, 'Can view user', 4, 'view_user');
INSERT INTO `auth_permission` VALUES (17, 'Can add content type', 5, 'add_contenttype');
INSERT INTO `auth_permission` VALUES (18, 'Can change content type', 5, 'change_contenttype');
INSERT INTO `auth_permission` VALUES (19, 'Can delete content type', 5, 'delete_contenttype');
INSERT INTO `auth_permission` VALUES (20, 'Can view content type', 5, 'view_contenttype');
INSERT INTO `auth_permission` VALUES (21, 'Can add session', 6, 'add_session');
INSERT INTO `auth_permission` VALUES (22, 'Can change session', 6, 'change_session');
INSERT INTO `auth_permission` VALUES (23, 'Can delete session', 6, 'delete_session');
INSERT INTO `auth_permission` VALUES (24, 'Can view session', 6, 'view_session');
INSERT INTO `auth_permission` VALUES (25, 'Can add author', 7, 'add_author');
INSERT INTO `auth_permission` VALUES (26, 'Can change author', 7, 'change_author');
INSERT INTO `auth_permission` VALUES (27, 'Can delete author', 7, 'delete_author');
INSERT INTO `auth_permission` VALUES (28, 'Can view author', 7, 'view_author');
INSERT INTO `auth_permission` VALUES (29, 'Can add author detail', 8, 'add_authordetail');
INSERT INTO `auth_permission` VALUES (30, 'Can change author detail', 8, 'change_authordetail');
INSERT INTO `auth_permission` VALUES (31, 'Can delete author detail', 8, 'delete_authordetail');
INSERT INTO `auth_permission` VALUES (32, 'Can view author detail', 8, 'view_authordetail');
INSERT INTO `auth_permission` VALUES (33, 'Can add book', 9, 'add_book');
INSERT INTO `auth_permission` VALUES (34, 'Can change book', 9, 'change_book');
INSERT INTO `auth_permission` VALUES (35, 'Can delete book', 9, 'delete_book');
INSERT INTO `auth_permission` VALUES (36, 'Can view book', 9, 'view_book');
INSERT INTO `auth_permission` VALUES (37, 'Can add publisher', 10, 'add_publisher');
INSERT INTO `auth_permission` VALUES (38, 'Can change publisher', 10, 'change_publisher');
INSERT INTO `auth_permission` VALUES (39, 'Can delete publisher', 10, 'delete_publisher');
INSERT INTO `auth_permission` VALUES (40, 'Can view publisher', 10, 'view_publisher');

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES (1, 'pbkdf2_sha256$120000$qXmhewzWZRAK$iM4dssw1BOab2D55cJ6EMcTaB1OP7Z10mgJrEE4tsiQ=', '2019-04-26 00:16:47.790081', 1, 'shiwei', '', '', '1936506751@qq.com', 1, 1, '2019-04-22 14:47:58.984937');

-- ----------------------------
-- Table structure for auth_user_groups
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_groups`;
CREATE TABLE `auth_user_groups`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_user_groups_user_id_group_id_94350c0c_uniq`(`user_id`, `group_id`) USING BTREE,
  INDEX `auth_user_groups_group_id_97559544_fk_auth_group_id`(`group_id`) USING BTREE,
  CONSTRAINT `auth_user_groups_group_id_97559544_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auth_user_groups_user_id_6a12ed8b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for auth_user_user_permissions
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_user_permissions`;
CREATE TABLE `auth_user_user_permissions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_user_user_permissions_user_id_permission_id_14a6b632_uniq`(`user_id`, `permission_id`) USING BTREE,
  INDEX `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm`(`permission_id`) USING BTREE,
  CONSTRAINT `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `auth_user_user_permissions_user_id_a95ead1b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for django_admin_log
-- ----------------------------
DROP TABLE IF EXISTS `django_admin_log`;
CREATE TABLE `django_admin_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `object_repr` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `action_flag` smallint(5) UNSIGNED NOT NULL,
  `change_message` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `django_admin_log_content_type_id_c4bce8eb_fk_django_co`(`content_type_id`) USING BTREE,
  INDEX `django_admin_log_user_id_c564eba6_fk_auth_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `django_admin_log_content_type_id_c4bce8eb_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `django_admin_log_user_id_c564eba6_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of django_admin_log
-- ----------------------------
INSERT INTO `django_admin_log` VALUES (1, '2019-04-22 14:55:16.168532', '4', '54545', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (2, '2019-04-22 14:55:20.404784', '1', '莫言', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (3, '2019-04-22 14:56:07.654637', '5', '145122152', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (4, '2019-04-22 14:56:09.787892', '2', '王安石·', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (5, '2019-04-22 14:57:00.901397', '6', '2464124454125', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (6, '2019-04-22 14:57:14.689523', '3', '忽而覆盖', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (7, '2019-04-22 14:58:38.965926', '7', '21454512124', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (8, '2019-04-22 14:58:41.449572', '4', '但丁', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (9, '2019-04-22 14:59:54.372334', '1', '邮电出版社', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (10, '2019-04-22 15:00:06.378223', '1', 'java 基础', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (11, '2019-04-22 15:00:48.698632', '2', 'Tsinghua', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (12, '2019-04-22 15:00:56.813900', '2', 'python 进阶', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (13, '2019-04-22 15:02:03.456334', '3', 'PeKing', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (14, '2019-04-22 15:03:06.029853', '8', '34343434', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (15, '2019-04-22 15:03:09.046103', '5', '胡海燕', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (16, '2019-04-22 15:03:13.211792', '3', 'Web 前端', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (17, '2019-04-22 15:04:18.130175', '4', '人名出版社', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (18, '2019-04-22 15:05:17.512328', '3', '打客服健康的减肥', 2, '[{\"changed\": {\"fields\": [\"name\"]}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (19, '2019-04-22 15:05:48.619255', '3', '海南出版社', 2, '[{\"changed\": {\"fields\": [\"name\"]}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (20, '2019-04-22 15:05:48.822712', '2', '哈工大出版社', 2, '[{\"changed\": {\"fields\": [\"name\"]}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (21, '2019-04-22 15:06:10.087841', '3', '海南出版社', 2, '[{\"changed\": {\"fields\": [\"city\"]}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (22, '2019-04-22 15:06:10.265365', '2', '哈工大出版社', 2, '[{\"changed\": {\"fields\": [\"city\"]}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (23, '2019-04-22 16:11:37.982540', '10', 'shiwei', 2, '[]', 7, 1);
INSERT INTO `django_admin_log` VALUES (24, '2019-04-22 16:50:04.976698', '22', '2545455241', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (25, '2019-04-22 16:50:07.627610', '13', 'lihaimei', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (26, '2019-04-24 14:03:15.638954', '23', '54565124', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (27, '2019-04-24 14:03:18.189132', '14', '但丁', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (28, '2019-04-24 14:29:28.115582', '24', '245451215', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (29, '2019-04-24 14:29:32.149787', '15', 'panda', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (30, '2019-04-24 14:30:16.767467', '25', '57842245452', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (31, '2019-04-24 14:30:19.428349', '16', 'lion', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (32, '2019-04-24 14:58:32.982135', '26', '2222222', 1, '[{\"added\": {}}]', 8, 1);
INSERT INTO `django_admin_log` VALUES (33, '2019-04-24 14:58:36.461825', '17', '李克强', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (34, '2019-04-24 16:17:07.358174', '5', '天津出版社', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (35, '2019-04-24 16:17:15.721803', '4', 'C语言从入门到精通', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (36, '2019-04-24 16:18:38.476486', '6', '华盛顿出版社', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (37, '2019-04-24 16:18:48.353073', '5', 'Linu命令大全', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (38, '2019-04-24 16:57:26.533472', '7', 'ShiWei出版社', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (39, '2019-04-24 16:57:31.685693', '6', '阿弥陀佛么么哒', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (40, '2019-04-24 16:58:47.659168', '8', '英皇出版社', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (41, '2019-04-24 16:58:52.008534', '7', '钢铁是如何炼成的', 1, '[{\"added\": {}}]', 9, 1);

-- ----------------------------
-- Table structure for django_content_type
-- ----------------------------
DROP TABLE IF EXISTS `django_content_type`;
CREATE TABLE `django_content_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `model` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `django_content_type_app_label_model_76bd3d3b_uniq`(`app_label`, `model`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of django_content_type
-- ----------------------------
INSERT INTO `django_content_type` VALUES (1, 'admin', 'logentry');
INSERT INTO `django_content_type` VALUES (3, 'auth', 'group');
INSERT INTO `django_content_type` VALUES (2, 'auth', 'permission');
INSERT INTO `django_content_type` VALUES (4, 'auth', 'user');
INSERT INTO `django_content_type` VALUES (5, 'contenttypes', 'contenttype');
INSERT INTO `django_content_type` VALUES (6, 'sessions', 'session');
INSERT INTO `django_content_type` VALUES (7, 'shiwei', 'author');
INSERT INTO `django_content_type` VALUES (8, 'shiwei', 'authordetail');
INSERT INTO `django_content_type` VALUES (9, 'shiwei', 'book');
INSERT INTO `django_content_type` VALUES (10, 'shiwei', 'publisher');

-- ----------------------------
-- Table structure for django_migrations
-- ----------------------------
DROP TABLE IF EXISTS `django_migrations`;
CREATE TABLE `django_migrations`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `applied` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of django_migrations
-- ----------------------------
INSERT INTO `django_migrations` VALUES (1, 'contenttypes', '0001_initial', '2019-04-22 14:46:22.686044');
INSERT INTO `django_migrations` VALUES (2, 'auth', '0001_initial', '2019-04-22 14:46:44.532792');
INSERT INTO `django_migrations` VALUES (3, 'admin', '0001_initial', '2019-04-22 14:46:53.194626');
INSERT INTO `django_migrations` VALUES (4, 'admin', '0002_logentry_remove_auto_add', '2019-04-22 14:46:53.363629');
INSERT INTO `django_migrations` VALUES (5, 'admin', '0003_logentry_add_action_flag_choices', '2019-04-22 14:46:53.584771');
INSERT INTO `django_migrations` VALUES (6, 'contenttypes', '0002_remove_content_type_name', '2019-04-22 14:46:57.134133');
INSERT INTO `django_migrations` VALUES (7, 'auth', '0002_alter_permission_name_max_length', '2019-04-22 14:46:59.083086');
INSERT INTO `django_migrations` VALUES (8, 'auth', '0003_alter_user_email_max_length', '2019-04-22 14:46:59.713192');
INSERT INTO `django_migrations` VALUES (9, 'auth', '0004_alter_user_username_opts', '2019-04-22 14:46:59.790984');
INSERT INTO `django_migrations` VALUES (10, 'auth', '0005_alter_user_last_login_null', '2019-04-22 14:47:00.654691');
INSERT INTO `django_migrations` VALUES (11, 'auth', '0006_require_contenttypes_0002', '2019-04-22 14:47:00.714703');
INSERT INTO `django_migrations` VALUES (12, 'auth', '0007_alter_validators_add_error_messages', '2019-04-22 14:47:00.790309');
INSERT INTO `django_migrations` VALUES (13, 'auth', '0008_alter_user_username_max_length', '2019-04-22 14:47:02.401128');
INSERT INTO `django_migrations` VALUES (14, 'auth', '0009_alter_user_last_name_max_length', '2019-04-22 14:47:04.148588');
INSERT INTO `django_migrations` VALUES (15, 'sessions', '0001_initial', '2019-04-22 14:47:07.257807');
INSERT INTO `django_migrations` VALUES (16, 'shiwei', '0001_initial', '2019-04-22 14:47:18.065757');
INSERT INTO `django_migrations` VALUES (17, 'shiwei', '0002_auto_20190426_1156', '2019-04-26 03:56:52.936785');

-- ----------------------------
-- Table structure for django_session
-- ----------------------------
DROP TABLE IF EXISTS `django_session`;
CREATE TABLE `django_session`  (
  `session_key` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `session_data` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `expire_date` datetime(6) NOT NULL,
  PRIMARY KEY (`session_key`) USING BTREE,
  INDEX `django_session_expire_date_a5c62663`(`expire_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of django_session
-- ----------------------------
INSERT INTO `django_session` VALUES ('cuvmypjgp7tip19qmqdg792zhyxq467r', 'NWFiYWZmNjM0ZjEyMzQ1N2VkYzk2YmE3MmNiYjY1Y2FjYzY2YzY3MDp7Il9hdXRoX3VzZXJfaWQiOiIxIiwiX2F1dGhfdXNlcl9iYWNrZW5kIjoiZGphbmdvLmNvbnRyaWIuYXV0aC5iYWNrZW5kcy5Nb2RlbEJhY2tlbmQiLCJfYXV0aF91c2VyX2hhc2giOiJlYjQ4ZTlhN2Q2ZjNkYmRhNTVmZWMxNGJiODhiMzdhNzRiYWYwZTdlIn0=', '2019-05-10 00:16:47.868204');
INSERT INTO `django_session` VALUES ('li89x96hbf0idnebc2an6ejx1izljo0z', 'NWFiYWZmNjM0ZjEyMzQ1N2VkYzk2YmE3MmNiYjY1Y2FjYzY2YzY3MDp7Il9hdXRoX3VzZXJfaWQiOiIxIiwiX2F1dGhfdXNlcl9iYWNrZW5kIjoiZGphbmdvLmNvbnRyaWIuYXV0aC5iYWNrZW5kcy5Nb2RlbEJhY2tlbmQiLCJfYXV0aF91c2VyX2hhc2giOiJlYjQ4ZTlhN2Q2ZjNkYmRhNTVmZWMxNGJiODhiMzdhNzRiYWYwZTdlIn0=', '2019-05-06 14:50:05.470496');

-- ----------------------------
-- Table structure for shiwei_author
-- ----------------------------
DROP TABLE IF EXISTS `shiwei_author`;
CREATE TABLE `shiwei_author`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int(11) NOT NULL,
  `authorDetail_id` int(11) NOT NULL,
  PRIMARY KEY (`aid`) USING BTREE,
  UNIQUE INDEX `authorDetail_id`(`authorDetail_id`) USING BTREE,
  CONSTRAINT `shiwei_author_authorDetail_id_ace4a8f7_fk_shiwei_authordetail_id` FOREIGN KEY (`authorDetail_id`) REFERENCES `shiwei_authordetail` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shiwei_author
-- ----------------------------
INSERT INTO `shiwei_author` VALUES (1, '莫言', 56, 4);
INSERT INTO `shiwei_author` VALUES (2, '王安石·', 78, 5);
INSERT INTO `shiwei_author` VALUES (3, '忽而覆盖', 80, 6);
INSERT INTO `shiwei_author` VALUES (4, '但丁', 80, 7);
INSERT INTO `shiwei_author` VALUES (5, '胡海燕', 68, 8);
INSERT INTO `shiwei_author` VALUES (6, 'shiweiIslion', 1200, 27);
INSERT INTO `shiwei_author` VALUES (12, 'liping', 1200, 21);
INSERT INTO `shiwei_author` VALUES (13, 'lihaimei', 500, 22);
INSERT INTO `shiwei_author` VALUES (14, '但丁', 3838, 23);
INSERT INTO `shiwei_author` VALUES (15, 'panda', 154, 24);
INSERT INTO `shiwei_author` VALUES (16, 'shiweiIslion', 83, 25);
INSERT INTO `shiwei_author` VALUES (17, '李克强', 1001, 26);
INSERT INTO `shiwei_author` VALUES (18, '李克强', 1006, 20);

-- ----------------------------
-- Table structure for shiwei_authordetail
-- ----------------------------
DROP TABLE IF EXISTS `shiwei_authordetail`;
CREATE TABLE `shiwei_authordetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` datetime(6) NOT NULL,
  `qq` bigint(20) NOT NULL,
  `addr` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shiwei_authordetail
-- ----------------------------
INSERT INTO `shiwei_authordetail` VALUES (4, '2019-04-16 00:00:00.000000', 54545, 'fdfdfdf');
INSERT INTO `shiwei_authordetail` VALUES (5, '2019-04-12 00:00:00.000000', 145122152, 'nanjiangde  hutong');
INSERT INTO `shiwei_authordetail` VALUES (6, '2019-02-20 00:00:00.000000', 2464124454125, 'xinjiang de akesu kuche');
INSERT INTO `shiwei_authordetail` VALUES (7, '2018-09-05 00:00:00.000000', 21454512124, 'Amercieram ahaiezhou');
INSERT INTO `shiwei_authordetail` VALUES (8, '2019-01-15 00:00:00.000000', 34343434, '卡伦斯顿皇家商学院');
INSERT INTO `shiwei_authordetail` VALUES (9, '1997-08-02 00:00:00.000000', 2145788956, 'hunan badajie');
INSERT INTO `shiwei_authordetail` VALUES (15, '1997-08-02 00:00:00.000000', 2145788956, 'hunan badajie');
INSERT INTO `shiwei_authordetail` VALUES (20, '1997-08-02 00:00:00.000000', 2145788956, 'hunan badajie');
INSERT INTO `shiwei_authordetail` VALUES (21, '1298-12-02 00:00:00.000000', 1245785, 'guangxi de dazita');
INSERT INTO `shiwei_authordetail` VALUES (22, '1205-05-06 00:00:00.000000', 2545455241, 'PeKing de houdezaiwu');
INSERT INTO `shiwei_authordetail` VALUES (23, '2019-04-03 00:00:00.000000', 54565124, '发达发达 东风街道口房间');
INSERT INTO `shiwei_authordetail` VALUES (24, '0215-02-06 00:00:00.000000', 245451215, 'KDFKJFKJALS;FJKD');
INSERT INTO `shiwei_authordetail` VALUES (25, '3652-06-04 00:00:00.000000', 57842245452, 'kdmfkldklfjafld,ldf');
INSERT INTO `shiwei_authordetail` VALUES (26, '2222-02-02 00:00:00.000000', 2222222, '22222222lililililli');
INSERT INTO `shiwei_authordetail` VALUES (27, '2020-10-16 00:00:00.000000', 5751545454, 'fkdjfkdjkaer');

-- ----------------------------
-- Table structure for shiwei_book
-- ----------------------------
DROP TABLE IF EXISTS `shiwei_book`;
CREATE TABLE `shiwei_book`  (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(8, 3) NOT NULL,
  `publishDate` date NOT NULL,
  `publisher_id` int(11) NOT NULL,
  PRIMARY KEY (`bid`) USING BTREE,
  INDEX `shiwei_book_publisher_id_b4c2e163_fk_shiwei_publisher_pid`(`publisher_id`) USING BTREE,
  CONSTRAINT `shiwei_book_publisher_id_b4c2e163_fk_shiwei_publisher_pid` FOREIGN KEY (`publisher_id`) REFERENCES `shiwei_publisher` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shiwei_book
-- ----------------------------
INSERT INTO `shiwei_book` VALUES (1, 'java 基础', 451.260, '2019-01-09', 1);
INSERT INTO `shiwei_book` VALUES (2, 'python 进阶', 526.650, '2018-04-17', 2);
INSERT INTO `shiwei_book` VALUES (3, 'Web 前端', 125.260, '2019-04-01', 3);
INSERT INTO `shiwei_book` VALUES (4, 'C语言从入门到精通', 200.000, '2018-09-14', 5);
INSERT INTO `shiwei_book` VALUES (5, 'Linu命令大全', 900.000, '2018-06-06', 6);
INSERT INTO `shiwei_book` VALUES (6, '阿弥陀佛么么哒', 66.000, '2018-11-07', 7);
INSERT INTO `shiwei_book` VALUES (7, '钢铁是如何炼成的', 166.000, '2018-09-20', 8);

-- ----------------------------
-- Table structure for shiwei_book_authors
-- ----------------------------
DROP TABLE IF EXISTS `shiwei_book_authors`;
CREATE TABLE `shiwei_book_authors`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `shiwei_book_authors_book_id_author_id_40f223c5_uniq`(`book_id`, `author_id`) USING BTREE,
  INDEX `shiwei_book_authors_author_id_5e3c96e7_fk_shiwei_author_aid`(`author_id`) USING BTREE,
  CONSTRAINT `shiwei_book_authors_author_id_5e3c96e7_fk_shiwei_author_aid` FOREIGN KEY (`author_id`) REFERENCES `shiwei_author` (`aid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `shiwei_book_authors_book_id_ef3be89f_fk_shiwei_book_bid` FOREIGN KEY (`book_id`) REFERENCES `shiwei_book` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shiwei_book_authors
-- ----------------------------
INSERT INTO `shiwei_book_authors` VALUES (1, 1, 2);
INSERT INTO `shiwei_book_authors` VALUES (2, 1, 3);
INSERT INTO `shiwei_book_authors` VALUES (3, 2, 2);
INSERT INTO `shiwei_book_authors` VALUES (4, 2, 3);
INSERT INTO `shiwei_book_authors` VALUES (5, 3, 5);
INSERT INTO `shiwei_book_authors` VALUES (6, 4, 3);
INSERT INTO `shiwei_book_authors` VALUES (7, 4, 5);
INSERT INTO `shiwei_book_authors` VALUES (8, 5, 5);
INSERT INTO `shiwei_book_authors` VALUES (9, 5, 14);
INSERT INTO `shiwei_book_authors` VALUES (10, 6, 12);
INSERT INTO `shiwei_book_authors` VALUES (11, 6, 13);
INSERT INTO `shiwei_book_authors` VALUES (12, 7, 2);
INSERT INTO `shiwei_book_authors` VALUES (13, 7, 4);

-- ----------------------------
-- Table structure for shiwei_publisher
-- ----------------------------
DROP TABLE IF EXISTS `shiwei_publisher`;
CREATE TABLE `shiwei_publisher`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `city` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shiwei_publisher
-- ----------------------------
INSERT INTO `shiwei_publisher` VALUES (1, '邮电出版社', 'BeiJing', '5493859384@qq.com');
INSERT INTO `shiwei_publisher` VALUES (2, '哈工大出版社', '哈尔滨', '3957893489@qq.com');
INSERT INTO `shiwei_publisher` VALUES (3, '海南出版社', '海南', '5945jfkdfjk@qq.com');
INSERT INTO `shiwei_publisher` VALUES (4, '人名出版社', '南京', '83593kdfjdk@qq.com');
INSERT INTO `shiwei_publisher` VALUES (5, '天津出版社', '天津', '339539jdfjdf@qq.com');
INSERT INTO `shiwei_publisher` VALUES (6, '华盛顿出版社', '500', 'huashengdun@fh.jkdfj');
INSERT INTO `shiwei_publisher` VALUES (7, 'ShiWei出版社', 'shiwei', '329539dkgjdkf@fd.com');
INSERT INTO `shiwei_publisher` VALUES (8, '英皇出版社', 'London', '39RDJFDFJK@DFD.com');

SET FOREIGN_KEY_CHECKS = 1;
