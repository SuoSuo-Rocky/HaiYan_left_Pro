/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50708
 Source Host           : localhost:3306
 Source Schema         : standyourground

 Target Server Type    : MySQL
 Target Server Version : 50708
 File Encoding         : 65001

 Date: 05/05/2019 21:17:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_group
-- ----------------------------
DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE `auth_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `codename` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `auth_permission_content_type_id_codename_01ab375a_uniq`(`content_type_id`, `codename`) USING BTREE,
  CONSTRAINT `auth_permission_content_type_id_2f476e4b_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

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
INSERT INTO `auth_permission` VALUES (25, 'Can add blog', 7, 'add_blog');
INSERT INTO `auth_permission` VALUES (26, 'Can change blog', 7, 'change_blog');
INSERT INTO `auth_permission` VALUES (27, 'Can delete blog', 7, 'delete_blog');
INSERT INTO `auth_permission` VALUES (28, 'Can view blog', 7, 'view_blog');
INSERT INTO `auth_permission` VALUES (29, 'Can add blog_tag', 8, 'add_blog_tag');
INSERT INTO `auth_permission` VALUES (30, 'Can change blog_tag', 8, 'change_blog_tag');
INSERT INTO `auth_permission` VALUES (31, 'Can delete blog_tag', 8, 'delete_blog_tag');
INSERT INTO `auth_permission` VALUES (32, 'Can view blog_tag', 8, 'view_blog_tag');
INSERT INTO `auth_permission` VALUES (33, 'Can add blog detail', 9, 'add_blogdetail');
INSERT INTO `auth_permission` VALUES (34, 'Can change blog detail', 9, 'change_blogdetail');
INSERT INTO `auth_permission` VALUES (35, 'Can delete blog detail', 9, 'delete_blogdetail');
INSERT INTO `auth_permission` VALUES (36, 'Can view blog detail', 9, 'view_blogdetail');
INSERT INTO `auth_permission` VALUES (37, 'Can add discuss', 10, 'add_discuss');
INSERT INTO `auth_permission` VALUES (38, 'Can change discuss', 10, 'change_discuss');
INSERT INTO `auth_permission` VALUES (39, 'Can delete discuss', 10, 'delete_discuss');
INSERT INTO `auth_permission` VALUES (40, 'Can view discuss', 10, 'view_discuss');
INSERT INTO `auth_permission` VALUES (41, 'Can add self_class', 11, 'add_self_class');
INSERT INTO `auth_permission` VALUES (42, 'Can change self_class', 11, 'change_self_class');
INSERT INTO `auth_permission` VALUES (43, 'Can delete self_class', 11, 'delete_self_class');
INSERT INTO `auth_permission` VALUES (44, 'Can view self_class', 11, 'view_self_class');
INSERT INTO `auth_permission` VALUES (45, 'Can add sp_tread', 12, 'add_sp_tread');
INSERT INTO `auth_permission` VALUES (46, 'Can change sp_tread', 12, 'change_sp_tread');
INSERT INTO `auth_permission` VALUES (47, 'Can delete sp_tread', 12, 'delete_sp_tread');
INSERT INTO `auth_permission` VALUES (48, 'Can view sp_tread', 12, 'view_sp_tread');
INSERT INTO `auth_permission` VALUES (49, 'Can add tag', 13, 'add_tag');
INSERT INTO `auth_permission` VALUES (50, 'Can change tag', 13, 'change_tag');
INSERT INTO `auth_permission` VALUES (51, 'Can delete tag', 13, 'delete_tag');
INSERT INTO `auth_permission` VALUES (52, 'Can view tag', 13, 'view_tag');
INSERT INTO `auth_permission` VALUES (53, 'Can add user', 14, 'add_user');
INSERT INTO `auth_permission` VALUES (54, 'Can change user', 14, 'change_user');
INSERT INTO `auth_permission` VALUES (55, 'Can delete user', 14, 'delete_user');
INSERT INTO `auth_permission` VALUES (56, 'Can view user', 14, 'view_user');
INSERT INTO `auth_permission` VALUES (57, 'Can add user fans', 15, 'add_userfans');
INSERT INTO `auth_permission` VALUES (58, 'Can change user fans', 15, 'change_userfans');
INSERT INTO `auth_permission` VALUES (59, 'Can delete user fans', 15, 'delete_userfans');
INSERT INTO `auth_permission` VALUES (60, 'Can view user fans', 15, 'view_userfans');
INSERT INTO `auth_permission` VALUES (61, 'Can add user info', 16, 'add_userinfo');
INSERT INTO `auth_permission` VALUES (62, 'Can change user info', 16, 'change_userinfo');
INSERT INTO `auth_permission` VALUES (63, 'Can delete user info', 16, 'delete_userinfo');
INSERT INTO `auth_permission` VALUES (64, 'Can view user info', 16, 'view_userinfo');

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `last_name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES (1, 'pbkdf2_sha256$120000$GMgmuQhI27XT$GL+7NRIHZzqv7nFVz0Kp0o1P8GF1ADYKgfwMQLxhqVw=', '2019-05-05 00:33:12.921587', 1, 'shiwei', '', '', '1936506751@qq.com', 1, 1, '2019-05-01 03:22:46.779165');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `bid` int(11) NOT NULL,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `summary` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ctime` date NOT NULL,
  `main_class` int(11) NOT NULL,
  `detail_id` int(11) NOT NULL,
  `self_class_id` int(11) NOT NULL,
  `comment_count` int(11) NOT NULL,
  `down_count` int(11) NOT NULL,
  `read_count` int(11) NOT NULL,
  `up_count` int(11) NOT NULL,
  PRIMARY KEY (`bid`) USING BTREE,
  UNIQUE INDEX `detail_id`(`detail_id`) USING BTREE,
  INDEX `Blog_self_class_id_b4457fff_fk_Self_class_id`(`self_class_id`) USING BTREE,
  CONSTRAINT `Blog_detail_id_0b177768_fk_BlogDetail_id` FOREIGN KEY (`detail_id`) REFERENCES `blogdetail` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Blog_self_class_id_b4457fff_fk_Self_class_id` FOREIGN KEY (`self_class_id`) REFERENCES `self_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, '基于Django+Bootstrap框架，设计微型小说网站', '为了回顾关于django的文件上传和分页功能，打算写一个微型的小说网站练练手。花了一个下午的时间，写了个小项目，发现其中其实遇到了许多问题，不过大部分通过debug之后就解决了，其他部分通过阅读了Pagination插件以及Bootstrap-FileInput插件的官方文档', '2019-05-01', 1, 3, 2, 0, 0, 0, 0);
INSERT INTO `blog` VALUES (2, 'Python之守护线程与锁', '守护线程随着子线程结束而结束,与守护进程不一样--守护进程随着主进程代码执行完毕而结束', '2019-04-03', 1, 4, 2, 0, 0, 0, 0);
INSERT INTO `blog` VALUES (3, 'GO语言的结构体', '当我第一次接触到C语言时，就对结构体投入了极大的兴趣，认为这个东西以后大有作为，后来接触Java、C++，面向对象编程中的对象进入我的视线，经过了这么多年的磨练，回过头来再看结构体依旧是那么亲切；同时从另一个角度上看结构体与面向对象中的成员对象是多么的相像', '2019-03-06', 4, 5, 3, 0, 0, 0, 0);
INSERT INTO `blog` VALUES (4, '我的第一个比较实用的GO语言程序', '一边学一边写的，比较手生，翻了很多次文档才写出来。关键是正则，当然没有考虑所有的情况。 这门语言对GUI支持的不好，因为是面向服务器的开发。就胡乱弄了个B/S的，代码如下：', '2019-01-03', 4, 6, 4, 0, 0, 0, 0);
INSERT INTO `blog` VALUES (5, 'Linux关于文件的权限笔记', '原	 Linux关于文件的权限笔记 2019年04月08日 04:03:56 郝光明 阅读数：631 版权声明：欢迎转载，请保留作者的链接，文章会同步更新到微信公众号 ：DoNet技术分享平台 https://blog.csdn.net/xishining/article/details/89089987  640?wx_fmt=jpeg   1、调整文件的权限命令：chmod\\r\\n2、改变文', '2018-09-07', 2, 7, 5, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid_id` int(11) NOT NULL,
  `tid_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `blog_tag_bid_id_tid_id_542246ac_uniq`(`bid_id`, `tid_id`) USING BTREE,
  INDEX `blog_tag_tid_id_2f52ae41_fk_Tag_id`(`tid_id`) USING BTREE,
  CONSTRAINT `blog_tag_bid_id_00c5df9f_fk_Blog_bid` FOREIGN KEY (`bid_id`) REFERENCES `blog` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `blog_tag_tid_id_2f52ae41_fk_Tag_id` FOREIGN KEY (`tid_id`) REFERENCES `tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for blogdetail
-- ----------------------------
DROP TABLE IF EXISTS `blogdetail`;
CREATE TABLE `blogdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_img` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `detail` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blogdetail
-- ----------------------------
INSERT INTO `blogdetail` VALUES (3, 'static/img/blog_img/1_mbe7nch.webp', '二、详细设计：        省去小说网站的用户模块的功能，小说网站主要的功能就是上传文件，在线阅读小说。针对这两个功能，       主要用到dajngo内置的Pagination模块，以及选择一个上传文件插件即可。因为用的是Bootsrap前端框架，所以就选择了Bootsrap比较多人用的FileInput插件。       大致的流程：          在首页可以选择上传本地的txt文件到服务器上，然后首页上同时会异步更新已上传的txt文本文件列表。         并且可以在上面选择阅读或者删除的操作。阅读则跳转到另外一个页面，后台会读取该文本文件，并且进行分页操作，返回到前端。主要的流程就是这样。接下来讲讲Pagination和FileInput插件和核心代码。  三、合适的工具：       Django内置的Pagination实现分页功能，这个不用多说，用Django做web开发分页功能都会用到。      Bootstrap本身自带upload file文件上传插件太丑了，加上功能也不够完善。所以选择了Bootstrap FileInput插件。  版本选择：          Python 3.6.6         Django==2.1.7         Bootstrap v4.3.1         bootstrap-fileinput v4.5.2  四、代码详解：      首先代码主要分为两块，一块为文件上传后，接收文件对象，保存到指定的目录下；第二块为读取txt文本文件内容，分页展示到前端页面。');
INSERT INTO `blogdetail` VALUES (4, 'static/img/blog_img/8.webp', '# 守护线程随着子线程结束而结束,与守护进程不一样--守护进程随着主进程代码执行完毕而结束 # from threading import Thread # import time # # def func1(): # while True: # time.sleep(1) # print(\"in func1\") # def func2(): # print(\'func2 start...\') # time.sleep(5) # print(\'func2 end...\') # if __name__ == \'__main__\': # t1 = Thread(target=func1) # t1.daemon = True # t1.start() # t2 = Thread(target=func2) # t2.start() # print(\'主线程代码完毕\') \'\'\' 输出结果: func2 start... 主线程代码完毕 in func1 in func1 in func1 in func1 func2 end... \'\'\' # 多线程之数据安全问题 # from threading import Thread # import time # # # 模拟计算在CPU中发生的过程，且时间放大 # def func(): # global n # tmp = n # time.sleep(1) # n = tmp - 1 # if __name__ == \'__main__\': # n = 10 # t_lst = [] # for i in range(10): # t = Thread(target=func) # t.start() # t_lst.append(t)');
INSERT INTO `blogdetail` VALUES (5, 'static/img/blog_img/2_NVFHdMI.webp', '二、结构体初步认识  下面通过对比数组（复合类型）来了解一下结构体：  1、从存储类型来看  数组只能存储相同的类型：  s := []string{\"a\", \"b\", \"c\", \"d\", \"e\"}  结构体可以存储不同的类型  // 声明结构体  type employee struct {     name,address string  // 姓名、住址     age int          // 年龄     height,weight float64 // 身高、体重  }   2、从内存来看  它们都是在内存中占据连续的内存空间，但对于数组来说，每一个元素所占用的内存大小是相同的，而结构体每一个项所占用的内存大小不一定相同  wKioL1WacC7ARF99AAB2IrtGm7Q976.jpg   3、从类型组合角度来看  数组没有组合的用法，例如一个一维数组，一旦数组类型确定就不可以再把另一个一维数组设置为元素值，例如  s := []string{\"a\", \"b\", \"c\", \"d\", \"e\"}  s[0] = []string{\"f\", \"g\"}  此时运行该程序会出现类似此提示：cannot use []string literal (type []string) as type string in assignment;  结构体支持组合，');
INSERT INTO `blogdetail` VALUES (6, 'static/img/blog_img/9.webp', 'package main  import   (      \"io\"    \"fmt\"    \"regexp\"    \"strings\"     \"net/http\"  )     const(    SQL = \"EXEC sys.sp_addextendedproperty @name=N\'MS_Description\', @value=N\'AAAA\', @level0type=N\'SCHEMA\',@level0name=N\'dbo\', @level1type=N\'TABLE\',@level1name=N\'CCCC\', @level2type=N\'COLUMN\',@level2name=N\'BBBB\'\"   SQL2 = \"EXEC sys.sp_addextendedproperty @name=N\'MS_Description\', @value=N\'AAAA\', @level0type=N\'SCHEMA\',@level0name=N\'dbo\', @level1type=N\'TABLE\',@level1name=N\'CCCC\'\"   html =      `<html>     <head><title>提取<a/title></head>    \\\'`)');
INSERT INTO `blogdetail` VALUES (7, 'static/img/blog_img/9_GFI7Vio.webp', 'Linux的每个文件都定义了文件的拥有者：u(user)、拥有组：g（group）、其他人：o（others）权限，对应的权限用rwx的组合来定义。使用chmod命令，增加权限用+，删除权限用-，某个文件详细的权限用=号。  比如：  chmod u+r filename  #给某文件增加读的权限  chmod u-r filename  #给某文件删除读的权限  chmod u+w filename  #给某文件增加写的权限  chmod u-w filename  #给某文件删除写的权限  chmod u+x filename  #给某文件增可执行的权限  chmod u-x filename  #给某文件删除可执行的权限  chmod u+rwx filename  #给某文件增加读写可执行的权限  chmod u=rwx filename  #给某文件设定读写可执行的权限  通过这种方式可以同一时刻给文件拥有者、文件拥有组、或其他用户设置权限，如果想要同时设置所有用户的权限就要使用数字表示的方式了，Linux规定 r=4,w=2,x=1。比如权限rwx:7,r-x:5。如果想设置一个文件拥有者有读、写、执行，拥有组的权限是读、执行、其他人只读的话，可以使用命令：chmod 745 filename 进行设置。chmod -R 745 dirname #用来看设置目录权限 必须加 -R参数。 ---------------------  作者：郝光明  来源：CSDN  原文：https://blog.csdn.net/xishining/article/details/89089987  版权声明：本文为博主原创文章，转载请附上博文链接！');

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ctime` date NOT NULL,
  `bid_id` int(11) NOT NULL,
  `uid_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Discuss_bid_id_38dcd841_fk_Blog_bid`(`bid_id`) USING BTREE,
  INDEX `Discuss_uid_id_50b8cd93_fk`(`uid_id`) USING BTREE,
  CONSTRAINT `Discuss_bid_id_38dcd841_fk_Blog_bid` FOREIGN KEY (`bid_id`) REFERENCES `blog` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Discuss_uid_id_50b8cd93_fk` FOREIGN KEY (`uid_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for django_admin_log
-- ----------------------------
DROP TABLE IF EXISTS `django_admin_log`;
CREATE TABLE `django_admin_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `object_repr` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `action_flag` smallint(5) UNSIGNED NOT NULL,
  `change_message` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `django_admin_log_content_type_id_c4bce8eb_fk_django_co`(`content_type_id`) USING BTREE,
  INDEX `django_admin_log_user_id_c564eba6_fk_auth_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `django_admin_log_content_type_id_c4bce8eb_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `django_admin_log_user_id_c564eba6_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of django_admin_log
-- ----------------------------
INSERT INTO `django_admin_log` VALUES (1, '2019-05-01 03:23:57.206500', '1', 'shiwei', 1, '[{\"added\": {}}]', 14, 1);
INSERT INTO `django_admin_log` VALUES (2, '2019-05-01 03:24:06.966608', '1', 'python 基础', 1, '[{\"added\": {}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (3, '2019-05-01 03:38:17.478495', '2', 'wupeiqi', 1, '[{\"added\": {}}]', 14, 1);
INSERT INTO `django_admin_log` VALUES (4, '2019-05-01 03:38:35.807995', '2', 'python 随笔', 1, '[{\"added\": {}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (5, '2019-05-01 03:44:30.351955', '3', '3', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (6, '2019-05-01 03:44:39.841344', '1', '基于Django+Bootstrap框架，设计微型小说网站', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (7, '2019-05-01 03:46:18.569221', '4', '4', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (8, '2019-05-01 03:46:29.111629', '2', 'Python之守护线程与锁', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (9, '2019-05-01 03:52:43.415510', '3', 'GoLang 随想', 1, '[{\"added\": {}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (10, '2019-05-01 03:53:20.598641', '5', '5', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (11, '2019-05-01 03:53:29.382080', '3', 'GO语言的结构体', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (12, '2019-05-01 04:05:03.844484', '3', 'alex', 1, '[{\"added\": {}}]', 14, 1);
INSERT INTO `django_admin_log` VALUES (13, '2019-05-01 04:05:38.223482', '4', 'Go 小程序', 1, '[{\"added\": {}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (14, '2019-05-01 04:07:33.486366', '6', '6', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (15, '2019-05-01 04:07:37.517981', '4', '我的第一个比较实用的GO语言程序', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (16, '2019-05-01 05:34:37.469128', '6', '6', 2, '[{\"changed\": {\"fields\": [\"detail\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (17, '2019-05-01 05:34:55.894458', '5', '5', 2, '[{\"changed\": {\"fields\": [\"detail\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (18, '2019-05-01 05:35:16.099469', '4', '4', 2, '[{\"changed\": {\"fields\": [\"detail\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (19, '2019-05-01 05:35:25.750223', '3', '3', 2, '[]', 9, 1);
INSERT INTO `django_admin_log` VALUES (20, '2019-05-01 05:36:35.802376', '6', '6', 2, '[{\"changed\": {\"fields\": [\"detail\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (21, '2019-05-01 05:36:35.927682', '5', '5', 2, '[{\"changed\": {\"fields\": [\"detail\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (22, '2019-05-01 05:39:56.256941', '5', '5', 2, '[{\"changed\": {\"fields\": [\"detail\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (23, '2019-05-01 05:40:17.095334', '5', '5', 2, '[{\"changed\": {\"fields\": [\"detail\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (24, '2019-05-01 05:40:49.197828', '4', '4', 2, '[{\"changed\": {\"fields\": [\"detail\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (25, '2019-05-01 05:40:49.313992', '3', '3', 2, '[{\"changed\": {\"fields\": [\"detail\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (26, '2019-05-01 05:52:02.244353', '4', '4', 2, '[{\"changed\": {\"fields\": [\"blog_img\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (27, '2019-05-01 05:52:30.899172', '5', '5', 2, '[{\"changed\": {\"fields\": [\"blog_img\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (28, '2019-05-01 05:53:07.851658', '5', '5', 2, '[{\"changed\": {\"fields\": [\"blog_img\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (29, '2019-05-01 05:53:25.038397', '6', '6', 2, '[{\"changed\": {\"fields\": [\"blog_img\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (30, '2019-05-01 05:53:33.916611', '6', '6', 2, '[{\"changed\": {\"fields\": [\"blog_img\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (31, '2019-05-01 05:53:49.748036', '6', '6', 2, '[{\"changed\": {\"fields\": [\"blog_img\"]}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (32, '2019-05-01 05:55:34.250895', '1', '1', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (33, '2019-05-01 05:55:41.472629', '2', '2', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (34, '2019-05-01 05:55:49.248768', '3', '3', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (35, '2019-05-01 05:55:55.628611', '4', '4', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (36, '2019-05-01 05:56:14.309467', '5', '5', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (37, '2019-05-01 05:56:20.684272', '6', '6', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (38, '2019-05-01 05:56:30.829500', '7', '7', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (39, '2019-05-01 05:56:36.589628', '5', '5', 2, '[{\"changed\": {\"fields\": [\"type\"]}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (40, '2019-05-01 05:56:55.188155', '8', '8', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (41, '2019-05-01 06:53:45.561945', '1', '1', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (42, '2019-05-01 06:57:10.930281', '2', '2', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (43, '2019-05-01 06:57:52.215499', '4', '4', 2, '[{\"changed\": {\"fields\": [\"type\"]}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (44, '2019-05-01 06:58:58.913713', '4', '4', 2, '[{\"changed\": {\"fields\": [\"type\"]}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (45, '2019-05-01 07:24:18.577480', '4', '习近平', 1, '[{\"added\": {}}]', 14, 1);
INSERT INTO `django_admin_log` VALUES (46, '2019-05-01 07:24:36.183941', '5', '我的 Linux', 1, '[{\"added\": {}}]', 11, 1);
INSERT INTO `django_admin_log` VALUES (47, '2019-05-01 07:24:59.966771', '7', '7', 1, '[{\"added\": {}}]', 9, 1);
INSERT INTO `django_admin_log` VALUES (48, '2019-05-01 07:25:27.573320', '5', 'Linux关于文件的权限笔记', 1, '[{\"added\": {}}]', 7, 1);
INSERT INTO `django_admin_log` VALUES (49, '2019-05-01 07:26:15.561269', '3', '3', 1, '[{\"added\": {}}]', 10, 1);
INSERT INTO `django_admin_log` VALUES (50, '2019-05-01 07:26:46.577218', '9', '9', 1, '[{\"added\": {}}]', 12, 1);
INSERT INTO `django_admin_log` VALUES (51, '2019-05-01 07:35:14.419087', '7', '7', 2, '[{\"changed\": {\"fields\": [\"type\"]}}]', 12, 1);

-- ----------------------------
-- Table structure for django_content_type
-- ----------------------------
DROP TABLE IF EXISTS `django_content_type`;
CREATE TABLE `django_content_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `model` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `django_content_type_app_label_model_76bd3d3b_uniq`(`app_label`, `model`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of django_content_type
-- ----------------------------
INSERT INTO `django_content_type` VALUES (1, 'admin', 'logentry');
INSERT INTO `django_content_type` VALUES (3, 'auth', 'group');
INSERT INTO `django_content_type` VALUES (2, 'auth', 'permission');
INSERT INTO `django_content_type` VALUES (4, 'auth', 'user');
INSERT INTO `django_content_type` VALUES (5, 'contenttypes', 'contenttype');
INSERT INTO `django_content_type` VALUES (7, 'repository', 'blog');
INSERT INTO `django_content_type` VALUES (9, 'repository', 'blogdetail');
INSERT INTO `django_content_type` VALUES (8, 'repository', 'blog_tag');
INSERT INTO `django_content_type` VALUES (10, 'repository', 'discuss');
INSERT INTO `django_content_type` VALUES (11, 'repository', 'self_class');
INSERT INTO `django_content_type` VALUES (12, 'repository', 'sp_tread');
INSERT INTO `django_content_type` VALUES (13, 'repository', 'tag');
INSERT INTO `django_content_type` VALUES (14, 'repository', 'user');
INSERT INTO `django_content_type` VALUES (15, 'repository', 'userfans');
INSERT INTO `django_content_type` VALUES (16, 'repository', 'userinfo');
INSERT INTO `django_content_type` VALUES (6, 'sessions', 'session');

-- ----------------------------
-- Table structure for django_migrations
-- ----------------------------
DROP TABLE IF EXISTS `django_migrations`;
CREATE TABLE `django_migrations`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `applied` datetime(6) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of django_migrations
-- ----------------------------
INSERT INTO `django_migrations` VALUES (1, 'contenttypes', '0001_initial', '2019-05-01 03:21:01.391270');
INSERT INTO `django_migrations` VALUES (2, 'auth', '0001_initial', '2019-05-01 03:21:16.464327');
INSERT INTO `django_migrations` VALUES (3, 'admin', '0001_initial', '2019-05-01 03:21:19.241396');
INSERT INTO `django_migrations` VALUES (4, 'admin', '0002_logentry_remove_auto_add', '2019-05-01 03:21:19.290593');
INSERT INTO `django_migrations` VALUES (5, 'admin', '0003_logentry_add_action_flag_choices', '2019-05-01 03:21:19.397093');
INSERT INTO `django_migrations` VALUES (6, 'contenttypes', '0002_remove_content_type_name', '2019-05-01 03:21:20.812565');
INSERT INTO `django_migrations` VALUES (7, 'auth', '0002_alter_permission_name_max_length', '2019-05-01 03:21:22.053009');
INSERT INTO `django_migrations` VALUES (8, 'auth', '0003_alter_user_email_max_length', '2019-05-01 03:21:22.317213');
INSERT INTO `django_migrations` VALUES (9, 'auth', '0004_alter_user_username_opts', '2019-05-01 03:21:22.403339');
INSERT INTO `django_migrations` VALUES (10, 'auth', '0005_alter_user_last_login_null', '2019-05-01 03:21:23.704229');
INSERT INTO `django_migrations` VALUES (11, 'auth', '0006_require_contenttypes_0002', '2019-05-01 03:21:23.783301');
INSERT INTO `django_migrations` VALUES (12, 'auth', '0007_alter_validators_add_error_messages', '2019-05-01 03:21:23.846117');
INSERT INTO `django_migrations` VALUES (13, 'auth', '0008_alter_user_username_max_length', '2019-05-01 03:21:24.962419');
INSERT INTO `django_migrations` VALUES (14, 'auth', '0009_alter_user_last_name_max_length', '2019-05-01 03:21:26.011347');
INSERT INTO `django_migrations` VALUES (15, 'repository', '0001_initial', '2019-05-01 03:21:44.739483');
INSERT INTO `django_migrations` VALUES (16, 'sessions', '0001_initial', '2019-05-01 03:21:45.433202');
INSERT INTO `django_migrations` VALUES (17, 'repository', '0002_auto_20190505_0826', '2019-05-05 00:27:05.438550');
INSERT INTO `django_migrations` VALUES (18, 'repository', '0003_auto_20190505_1948', '2019-05-05 11:48:45.206782');
INSERT INTO `django_migrations` VALUES (19, 'repository', '0004_auto_20190505_2018', '2019-05-05 12:18:32.878406');
INSERT INTO `django_migrations` VALUES (20, 'repository', '0005_auto_20190505_2045', '2019-05-05 12:45:31.443663');

-- ----------------------------
-- Table structure for django_session
-- ----------------------------
DROP TABLE IF EXISTS `django_session`;
CREATE TABLE `django_session`  (
  `session_key` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `session_data` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `expire_date` datetime(6) NOT NULL,
  PRIMARY KEY (`session_key`) USING BTREE,
  INDEX `django_session_expire_date_a5c62663`(`expire_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of django_session
-- ----------------------------
INSERT INTO `django_session` VALUES ('2xn9fe69icajqeqdek3hk88j0jn4i12t', 'ZWI5MmVlOGJhODljZjY0MzVmMDU4MjgwNDMzNDk3YjUxZTQ5MzllZDp7Il9hdXRoX3VzZXJfaWQiOiIxIiwiX2F1dGhfdXNlcl9iYWNrZW5kIjoiZGphbmdvLmNvbnRyaWIuYXV0aC5iYWNrZW5kcy5Nb2RlbEJhY2tlbmQiLCJfYXV0aF91c2VyX2hhc2giOiIxNGFkNWRjNjBmZjU4YmQ0YjU5NTg5NDVlOThhYjg4OTU1NzliZGNiIn0=', '2019-05-15 11:09:22.607603');
INSERT INTO `django_session` VALUES ('96ykgtxuxol5tqztgjb1qstyn0z4xnya', 'YTkzODMwYzYxZTgzODJkNDM2MmVhMDMxMTEwMWJmNjRhODFiYTc0YTp7ImNoZWNrX2NvZGUiOiJLeHNOIn0=', '2019-05-19 12:46:37.290919');
INSERT INTO `django_session` VALUES ('b2ug9jm1u2m79jieacuqlhixkzu92guj', 'ZWQxY2M5N2YzMDdmYTJiN2FiOTlhNzE1MWFmMjMxOTZlMTQwMzI2ZDp7ImNoZWNrX2NvZGUiOiJwZENxIn0=', '2019-05-19 00:29:30.537702');
INSERT INTO `django_session` VALUES ('ccgc2jwa7vycbii8zrmag3exwwi2bcyt', 'ZWI5MmVlOGJhODljZjY0MzVmMDU4MjgwNDMzNDk3YjUxZTQ5MzllZDp7Il9hdXRoX3VzZXJfaWQiOiIxIiwiX2F1dGhfdXNlcl9iYWNrZW5kIjoiZGphbmdvLmNvbnRyaWIuYXV0aC5iYWNrZW5kcy5Nb2RlbEJhY2tlbmQiLCJfYXV0aF91c2VyX2hhc2giOiIxNGFkNWRjNjBmZjU4YmQ0YjU5NTg5NDVlOThhYjg4OTU1NzliZGNiIn0=', '2019-05-15 03:23:26.006559');
INSERT INTO `django_session` VALUES ('dxv3bl0t51tuppdir814jqjeeukgotu0', 'ZWQyOWIwMDdjMmM3NDcyOWE1ZTBhNGMyNDczYWUwMTNlZjc5NTg0Yjp7ImNoZWNrX2NvZGUiOiJHWWpNIn0=', '2019-05-18 02:46:25.220687');
INSERT INTO `django_session` VALUES ('n3rmn23t07mbb6fjw6udnx7zx2hmjtzu', 'NjM2YjUwZDA2MzMyODgyYzE4Mjc2MmEzMzg4MGM0YTliNDJlYmIwMDp7ImNoZWNrX2NvZGUiOiJOSFhkIiwiX2F1dGhfdXNlcl9pZCI6IjEiLCJfYXV0aF91c2VyX2JhY2tlbmQiOiJkamFuZ28uY29udHJpYi5hdXRoLmJhY2tlbmRzLk1vZGVsQmFja2VuZCIsIl9hdXRoX3VzZXJfaGFzaCI6IjE0YWQ1ZGM2MGZmNThiZDRiNTk1ODk0NWU5OGFiODg5NTU3OWJkY2IifQ==', '2019-05-19 01:05:34.454675');
INSERT INTO `django_session` VALUES ('nc7vscmjyil8xmnnz2ci7bf0c02w32bs', 'MWExOWJhMmYyM2JlN2UwZTU1N2RiZTRkOTQ5OWJkMzE1MzFiMTk0MDp7ImNoZWNrX2NvZGUiOiJocUR5IiwiX3Nlc3Npb25fZXhwaXJ5IjoyNTkyMDAwfQ==', '2019-06-02 05:36:01.678289');
INSERT INTO `django_session` VALUES ('qugtbbg022t84jtx35mx5p2y641qj4zd', 'YjdlZDk1YjYyMzMwYTY0YjIzNTJkMmJlYmZjNTUzZWY3MzIzYjMzODp7ImNoZWNrX2NvZGUiOiJONGZVIn0=', '2019-05-19 11:04:12.257690');

-- ----------------------------
-- Table structure for self_class
-- ----------------------------
DROP TABLE IF EXISTS `self_class`;
CREATE TABLE `self_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `caption` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `Self_class_user_id_caption_16d02153_uniq`(`user_id`, `caption`) USING BTREE,
  CONSTRAINT `Self_class_user_id_0289f30a_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of self_class
-- ----------------------------
INSERT INTO `self_class` VALUES (1, 'python 基础', 1);
INSERT INTO `self_class` VALUES (3, 'GoLang 随想', 2);
INSERT INTO `self_class` VALUES (2, 'python 随笔', 2);
INSERT INTO `self_class` VALUES (4, 'Go 小程序', 3);
INSERT INTO `self_class` VALUES (5, '我的 Linux', 4);

-- ----------------------------
-- Table structure for sp_tread
-- ----------------------------
DROP TABLE IF EXISTS `sp_tread`;
CREATE TABLE `sp_tread`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `bid_id` int(11) NOT NULL,
  `uid_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sp_tread_bid_id_uid_id_c14cba35_uniq`(`bid_id`, `uid_id`) USING BTREE,
  INDEX `sp_tread_uid_id_98f5c020_fk`(`uid_id`) USING BTREE,
  CONSTRAINT `sp_tread_bid_id_3b11a855_fk_Blog_bid` FOREIGN KEY (`bid_id`) REFERENCES `blog` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sp_tread_uid_id_98f5c020_fk` FOREIGN KEY (`uid_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sp_tread
-- ----------------------------
INSERT INTO `sp_tread` VALUES (1, 0, 2, 1);
INSERT INTO `sp_tread` VALUES (2, 1, 3, 1);
INSERT INTO `sp_tread` VALUES (3, 0, 4, 2);
INSERT INTO `sp_tread` VALUES (4, 1, 1, 2);
INSERT INTO `sp_tread` VALUES (5, 1, 4, 1);
INSERT INTO `sp_tread` VALUES (6, 0, 2, 3);
INSERT INTO `sp_tread` VALUES (7, 0, 3, 3);
INSERT INTO `sp_tread` VALUES (8, 0, 3, 2);
INSERT INTO `sp_tread` VALUES (9, 1, 5, 4);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `caption` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `Tag_user_id_caption_111feea1_uniq`(`user_id`, `caption`) USING BTREE,
  CONSTRAINT `Tag_user_id_e1c1c475_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pwd` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime(6) NOT NULL,
  `nickname` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'shiwei', 'shiwei666666', '1936506751@qq.com', 'static/img/user_img/1_5kFFC42.webp', '1025-02-23 00:00:00.000000', 'suosuo');
INSERT INTO `user` VALUES (2, 'wupeiqi', 'wupeiqi666666', '34839dkjfkdj@qq.com', 'static/img/user_img/2.webp', '1025-02-23 00:00:00.000000', 'suosuo');
INSERT INTO `user` VALUES (3, 'alex', 'alex666666', '54F5F545D4F@qq.com', 'static/img/user_img/3.webp', '1025-02-23 00:00:00.000000', 'suosuo');
INSERT INTO `user` VALUES (4, '习近平', 'xijingping666666', '1936506dfd@qq.com', 'static/img/user_img/4.webp', '1025-02-23 00:00:00.000000', 'suosuo');
INSERT INTO `user` VALUES (5, 'shiwei4512454', 'shiwei666666', '1936506751@qq.com', '', '2019-05-05 12:45:43.865280', NULL);

-- ----------------------------
-- Table structure for userfans
-- ----------------------------
DROP TABLE IF EXISTS `userfans`;
CREATE TABLE `userfans`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `follower_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `userfans_user_id_follower_id_8c3d31ad_uniq`(`user_id`, `follower_id`) USING BTREE,
  INDEX `userfans_follower_id_7e0d75c1_fk`(`follower_id`) USING BTREE,
  CONSTRAINT `userfans_follower_id_7e0d75c1_fk` FOREIGN KEY (`follower_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userfans_user_id_aa67b893_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `uiid` int(11) NOT NULL,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `site` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `theme` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`uiid`) USING BTREE,
  UNIQUE INDEX `site`(`site`) USING BTREE,
  INDEX `userinfo_user_id_70851ceb_fk`(`user_id`) USING BTREE,
  CONSTRAINT `userinfo_user_id_70851ceb_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
