/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1_3306
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 127.0.0.1:3306
 Source Schema         : das_server

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 02/01/2023 17:33:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_core_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_core_config`;
CREATE TABLE `tb_core_config`  (
  `row_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '配置项关键词',
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '配置项属性值',
  `can_edit` tinyint(1) NOT NULL COMMENT '是否支持web端修改(0:false;1:true)',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '配置描述',
  `is_delete` tinyint(1) NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
  `create_user` bigint(0) NOT NULL COMMENT '创建用户',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_user` bigint(0) NOT NULL COMMENT '更新用户',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`row_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '配置表,储存配置信息,如:version,mutation等' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_core_config
-- ----------------------------
INSERT INTO `tb_core_config` VALUES (1, 'cloudVersion', '5', 0, '版本', 0, 776465218, '2022-11-01 08:12:41', 776465218, '2022-11-01 08:12:38');
INSERT INTO `tb_core_config` VALUES (2, 'localVersion', '5', 0, '本地运行版本', 0, 776465218, '2022-11-07 12:51:00', 776465218, '2022-11-07 12:51:02');
INSERT INTO `tb_core_config` VALUES (3, 'defaultStyle', 'cool', 1, '默认风格', 0, 776465218, '2022-11-01 08:12:41', 776465218, '2022-12-30 15:32:48');
INSERT INTO `tb_core_config` VALUES (4, 'defaultUserLevel', '5', 1, '默认权限等级', 0, 776465218, '2022-12-27 11:25:27', 776465218, '2022-12-30 15:23:55');
INSERT INTO `tb_core_config` VALUES (5, 'defaultGroupLevel', '9', 1, '群组默认权限等级', 0, 776465218, '2022-12-27 13:55:12', 776465218, '2022-12-30 15:32:50');
INSERT INTO `tb_core_config` VALUES (6, 'loginNeedMinLevel', '3', 1, '登录webManager所需的最低level', 0, 776465218, '2022-12-29 16:50:21', 776465218, '2022-12-30 15:32:33');
INSERT INTO `tb_core_config` VALUES (7, 'testConfig', 'async', 1, '测试配置1', 1, 776465218, '2022-12-30 09:57:50', 776465218, '2022-12-31 12:11:24');
INSERT INTO `tb_core_config` VALUES (8, '测试测试', '测试测试', 1, '测试测试', 1, 776465218, '2022-12-30 14:55:36', 776465218, '2022-12-31 12:24:17');
INSERT INTO `tb_core_config` VALUES (9, 'signerKey', 'dasqServer', 1, '令牌签名密钥', 0, 776465218, '2022-12-30 16:45:47', 776465218, '2022-12-30 17:32:27');
INSERT INTO `tb_core_config` VALUES (10, 'tokenEffectiveSeconds', '360000', 1, '令牌有效时间(秒)', 0, 776465218, '2022-12-30 16:46:11', 776465218, '2022-12-30 17:46:28');
INSERT INTO `tb_core_config` VALUES (11, 'testConfig1', 'testConfig1', 1, '测试配置1', 0, 776465218, '2022-12-30 16:46:45', 776465218, '2022-12-31 12:04:26');
INSERT INTO `tb_core_config` VALUES (12, 'testConfig2', 'testConfig2', 1, '测试配置2', 0, 776465218, '2022-12-30 16:46:50', 776465218, '2022-12-31 12:04:16');
INSERT INTO `tb_core_config` VALUES (13, 'testConfig3', 'testConfig3', 1, '测试配置3', 0, 776465218, '2022-12-30 16:51:39', 776465218, '2022-12-30 17:57:44');
INSERT INTO `tb_core_config` VALUES (14, 'testConfig4', 'testConfig4', 1, '测试配置4', 0, 776465218, '2022-12-30 16:51:42', 776465218, '2022-12-31 12:04:25');
INSERT INTO `tb_core_config` VALUES (15, 'testConfig5', 'testConfig5', 1, '测试配置5', 0, 776465218, '2022-12-30 16:51:45', 776465218, '2022-12-31 12:04:21');
INSERT INTO `tb_core_config` VALUES (16, 'testConfig6', 'testConfig6', 1, '测试配置6', 1, 776465218, '2022-12-30 16:51:49', 776465218, '2022-12-31 12:20:21');
INSERT INTO `tb_core_config` VALUES (17, 'testConfig7', 'testConfig7', 1, '测试配置7', 0, 776465218, '2022-12-30 16:51:57', 776465218, '2022-12-31 12:04:20');
INSERT INTO `tb_core_config` VALUES (18, 'testConfig8', 'testConfig8', 1, '测试配置8', 0, 776465218, '2022-12-30 16:52:04', 776465218, '2022-12-31 12:04:19');
INSERT INTO `tb_core_config` VALUES (19, 'testConfig9', 'testConfig9', 1, '测试配置9', 0, 776465218, '2022-12-30 16:52:04', 776465218, '2022-12-31 12:04:24');
INSERT INTO `tb_core_config` VALUES (20, 'testConfig10', 'testConfig10', 1, '测试配置10', 0, 776465218, '2022-12-30 16:52:04', 776465218, '2022-12-31 12:04:24');
INSERT INTO `tb_core_config` VALUES (21, 'testConfig11', 'testConfig11', 1, '测试配置11', 0, 776465218, '2022-12-30 16:52:04', 776465218, '2022-12-31 12:04:23');
INSERT INTO `tb_core_config` VALUES (22, 'testConfig12', 'testConfig12', 1, '测试配置12', 0, 776465218, '2022-12-30 17:58:44', 776465218, '2022-12-31 12:04:22');
INSERT INTO `tb_core_config` VALUES (23, 'testConfig13', 'testConfig13', 1, '测试配置13', 1, 776465218, '2022-12-31 12:03:22', 776465218, '2022-12-31 12:23:44');

-- ----------------------------
-- Table structure for tb_core_plugin
-- ----------------------------
DROP TABLE IF EXISTS `tb_core_plugin`;
CREATE TABLE `tb_core_plugin`  (
  `row_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '触发关键词(已废弃,现意为名称)',
  `class_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '全类名',
  `order` int(0) NOT NULL COMMENT '排序',
  `level` tinyint(1) NOT NULL COMMENT '权限等级',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述',
  `enable` tinyint(1) NOT NULL COMMENT '是否启用',
  `is_delete` tinyint(1) NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
  `create_user` bigint(0) NOT NULL COMMENT '创建用户',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_user` bigint(0) NOT NULL COMMENT '更新用户',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`row_id`) USING BTREE,
  INDEX `INDEX_ORDOR`(`order`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '插件表,储存插件注册信息,权限,描述,启用状态等' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_core_plugin
-- ----------------------------
INSERT INTO `tb_core_plugin` VALUES (1, 'template', 'com.dasoops.dasserver.core.TemplatePlugin', 0, 5, '模板插件', 1, 0, -1, '2022-11-02 15:23:56', -1, '2022-11-02 15:23:58');
INSERT INTO `tb_core_plugin` VALUES (2, 'messageLog', 'com.dasoops.dasserver.plugin.log.plugin.MessageLogPlugin', 10, 7, '日志插件', 1, 0, -1, '2022-11-03 17:15:48', -1, '2022-11-03 17:15:51');
INSERT INTO `tb_core_plugin` VALUES (3, 'roll', 'com.dasoops.dasserver.plugin.loaj.plugin.RollPlugin', 20, 5, 'ROLL点插件', 1, 0, -1, '2022-11-04 17:38:28', -1, '2022-11-04 17:38:23');
INSERT INTO `tb_core_plugin` VALUES (4, 'Image', 'com.dasoops.dasserver.plugin.image.plugin.ImagePlugin', 30, 5, '存图取图插件', 1, 0, -1, '2022-11-08 10:17:26', -1, '2022-11-08 10:17:30');
INSERT INTO `tb_core_plugin` VALUES (5, 'error', 'com.dasoops.dasserver.plugin.exceptionwrapper.plugin.GetErrorPlugin', 40, 5, '异常信息插件', 1, 0, -1, '2022-11-10 14:56:35', -1, '2022-11-10 14:56:33');
INSERT INTO `tb_core_plugin` VALUES (6, 'throwException', 'com.dasoops.dasserver.plugin.exceptionwrapper.plugin.ThrowExceptionPlugin', 50, 5, '测试异常插件', 1, 0, -1, '2022-11-10 15:38:20', -1, '2022-11-10 15:38:18');
INSERT INTO `tb_core_plugin` VALUES (7, 'getPlugin', 'com.dasoops.dasserver.plugin.pluginwrapper.plugin.GetPluginPlugin', 60, 2, '获取插件列表插件', 1, 0, -1, '2022-11-10 15:57:21', -1, '2022-11-10 15:57:23');
INSERT INTO `tb_core_plugin` VALUES (8, 'addPlugin', 'com.dasoops.dasserver.plugin.pluginwrapper.plugin.AddPluginPlugin', 70, 2, '添加插件', 1, 0, -1, '2022-11-10 15:57:21', -1, '2022-11-10 15:57:23');

-- ----------------------------
-- Table structure for tb_core_register
-- ----------------------------
DROP TABLE IF EXISTS `tb_core_register`;
CREATE TABLE `tb_core_register`  (
  `row_id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `register_id` bigint(0) NOT NULL COMMENT '用户/群组id',
  `type` tinyint(1) NOT NULL COMMENT '类型(0:user;1:group)',
  `level` tinyint(1) NOT NULL COMMENT '默认权限等级\r\n>= pluginLevel 的将在插件首次注册时获取执行权限\r\n(0:sys;1:dasoops;2:dev;5:user;8:zxy;9:none)\r\n注:默认权限等级应只影响添加新插件时生成的权限',
  `is_delete` tinyint(1) NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
  `create_user` bigint(0) NOT NULL COMMENT '创建用户',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_user` bigint(0) NOT NULL COMMENT '更新用户',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`row_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '注册表,储存用户注册信息,初始权限,群组注册信息,每个用户/群组对应一条记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_core_register
-- ----------------------------
INSERT INTO `tb_core_register` VALUES (1, 776465218, 0, 5, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO `tb_core_register` VALUES (2, 943952775, 0, 5, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO `tb_core_register` VALUES (3, 1318847648, 0, 5, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO `tb_core_register` VALUES (4, 1422291466, 0, 5, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO `tb_core_register` VALUES (5, 2426867682, 0, 5, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO `tb_core_register` VALUES (6, 673745932, 1, 5, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO `tb_core_register` VALUES (7, 601372611, 0, 5, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO `tb_core_register` VALUES (8, 1006646003, 0, 5, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO `tb_core_register` VALUES (9, 1743114170, 0, 5, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO `tb_core_register` VALUES (10, 3488521150, 0, 5, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');

-- ----------------------------
-- Table structure for tb_core_register_mtm_plugin
-- ----------------------------
DROP TABLE IF EXISTS `tb_core_register_mtm_plugin`;
CREATE TABLE `tb_core_register_mtm_plugin`  (
  `row_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `plugin_id` int(0) NOT NULL COMMENT '插件主键id',
  `register_row_id` bigint(0) NOT NULL COMMENT '注册表主键id',
  `is_pass` int(0) NOT NULL COMMENT '是否放行(0:否,拦截;1:是,放行)',
  `is_delete` tinyint(1) NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
  `create_user` bigint(0) NOT NULL COMMENT '创建用户',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_user` bigint(0) NOT NULL COMMENT '更新用户',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`row_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 161 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '注册用户 与 插件 多对多关联表\r\n每个用户都应有每个插件的权限关联记录\r\n此表将为控制用户插件权限的最终表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_core_register_mtm_plugin
-- ----------------------------
INSERT INTO `tb_core_register_mtm_plugin` VALUES (81, 1, 1, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (82, 2, 1, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (83, 3, 1, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (84, 4, 1, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (85, 5, 1, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (86, 6, 1, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (87, 7, 1, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (88, 8, 1, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (89, 1, 2, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (90, 2, 2, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (91, 3, 2, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (92, 4, 2, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (93, 5, 2, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (94, 6, 2, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (95, 7, 2, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (96, 8, 2, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (97, 1, 3, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (98, 2, 3, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (99, 3, 3, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (100, 4, 3, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (101, 5, 3, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (102, 6, 3, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (103, 7, 3, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (104, 8, 3, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (105, 1, 4, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (106, 2, 4, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (107, 3, 4, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (108, 4, 4, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (109, 5, 4, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (110, 6, 4, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (111, 7, 4, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (112, 8, 4, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (113, 1, 5, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (114, 2, 5, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (115, 3, 5, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (116, 4, 5, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (117, 5, 5, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (118, 6, 5, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (119, 7, 5, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (120, 8, 5, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (121, 1, 6, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (122, 2, 6, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (123, 3, 6, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (124, 4, 6, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (125, 5, 6, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (126, 6, 6, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (127, 7, 6, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (128, 8, 6, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (129, 1, 7, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (130, 2, 7, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (131, 3, 7, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (132, 4, 7, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (133, 5, 7, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (134, 6, 7, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (135, 7, 7, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (136, 8, 7, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (137, 1, 8, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (138, 2, 8, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (139, 3, 8, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (140, 4, 8, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (141, 5, 8, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (142, 6, 8, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (143, 7, 8, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (144, 8, 8, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (145, 1, 9, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (146, 2, 9, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (147, 3, 9, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (148, 4, 9, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (149, 5, 9, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (150, 6, 9, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (151, 7, 9, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (152, 8, 9, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (153, 1, 10, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (154, 2, 10, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (155, 3, 10, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (156, 4, 10, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (157, 5, 10, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (158, 6, 10, 1, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (159, 7, 10, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');
INSERT INTO `tb_core_register_mtm_plugin` VALUES (160, 8, 10, 0, 0, -1, '2022-12-31 15:27:28', -1, '2022-12-31 15:27:28');

-- ----------------------------
-- Table structure for tb_plugin_image
-- ----------------------------
DROP TABLE IF EXISTS `tb_plugin_image`;
CREATE TABLE `tb_plugin_image`  (
  `row_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '存/取 关键词',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '存储文件名',
  `group_id` bigint(0) NOT NULL DEFAULT -1 COMMENT '群组id,私聊存储为-1',
  `author_id` bigint(0) NOT NULL COMMENT '创建人id',
  `is_delete` tinyint(1) NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
  `create_user` bigint(0) NOT NULL COMMENT '创建用户',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_user` bigint(0) NOT NULL COMMENT '更新用户',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`row_id`) USING BTREE,
  INDEX `INDEX_IMAGE_KEYWORD`(`keyword`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 265 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '图片信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_plugin_image
-- ----------------------------
INSERT INTO `tb_plugin_image` VALUES (1, 'test', '375c87b4-1b5f-45ae-9f30-6f2ee17ec62e.jpg', 673745932, 776465218, 0, 776465218, '2022-10-11 16:22:56', 776465218, '2022-10-11 16:22:56');
INSERT INTO `tb_plugin_image` VALUES (2, '乐', '454e653b-4886-4365-8ab0-9ecbfd30a36d.jpg', 673745932, 776465218, 0, 776465218, '2022-10-18 08:53:09', 776465218, '2022-10-18 08:53:09');
INSERT INTO `tb_plugin_image` VALUES (3, 'error', 'eb4d73ae-3746-4850-8ceb-64559ed1f3e1.jpg', 673745932, 776465218, 0, 776465218, '2022-10-11 16:31:30', 776465218, '2022-10-11 16:31:30');
INSERT INTO `tb_plugin_image` VALUES (4, '老狗', 'a5c0afdd-0108-4e01-8528-ce5ead77bc8c.jpg', 673745932, 776465218, 0, 776465218, '2022-10-11 16:36:03', 776465218, '2022-10-11 16:36:03');
INSERT INTO `tb_plugin_image` VALUES (5, '傻了', '37ae322c-c79e-4438-adeb-5b25dc07cd7b.jpg', 673745932, 776465218, 0, 776465218, '2022-10-11 17:02:48', 776465218, '2022-10-11 17:02:48');
INSERT INTO `tb_plugin_image` VALUES (6, '来点没看过的', '848e3d76-2de6-4212-9042-bfedae00bca4.jpg', 673745932, 776465218, 0, 776465218, '2022-10-11 17:15:02', 776465218, '2022-10-11 17:15:02');
INSERT INTO `tb_plugin_image` VALUES (7, '突变表', '813ded03-4fa0-4a22-a897-027f2f2aa957.jpg', 673745932, 776465218, 0, 776465218, '2022-10-11 17:19:48', 776465218, '2022-10-11 17:19:48');
INSERT INTO `tb_plugin_image` VALUES (8, '千里眼', '1bf308a4-6e56-46a7-9a1f-7c61037b4a8c.jpg', 673745932, 776465218, 1, 776465218, '2022-10-11 17:53:30', 776465218, '2022-10-11 17:53:30');
INSERT INTO `tb_plugin_image` VALUES (9, '给老子死', '4384e79c-d373-4bcb-83b6-f09a9fdbd280.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 10:51:39', 776465218, '2022-10-12 10:51:39');
INSERT INTO `tb_plugin_image` VALUES (10, '不写不写', 'a3031073-30c1-47e4-acb6-e3f8e8eed772.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 11:03:03', 776465218, '2022-10-12 11:03:03');
INSERT INTO `tb_plugin_image` VALUES (11, '好好好', 'a1042403-94da-494d-80d3-ea6365248e4a.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 15:33:44', 776465218, '2022-10-12 15:33:44');
INSERT INTO `tb_plugin_image` VALUES (12, '同化完成', '81fbdf68-3a8a-46fd-a5d4-06abea16f0c2.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 15:48:54', 776465218, '2022-10-12 15:48:54');
INSERT INTO `tb_plugin_image` VALUES (13, '草', '8b6b9024-f3ff-49b1-9d4c-2f2cd2a0976d.png', 673745932, 776465218, 0, 776465218, '2022-10-12 15:51:36', 776465218, '2022-10-12 15:51:36');
INSERT INTO `tb_plugin_image` VALUES (14, '好好好2', 'af541241-e00b-494c-ae9c-9e923c362599.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 15:54:07', 776465218, '2022-10-12 15:54:07');
INSERT INTO `tb_plugin_image` VALUES (15, '水过了', '24555e93-a802-44e1-bc34-a5f1709d9b95.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 15:56:17', 776465218, '2022-10-12 15:56:17');
INSERT INTO `tb_plugin_image` VALUES (16, '傻了2', '4ead96c3-7078-4412-8662-56d063e192a7.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 16:16:37', 776465218, '2022-10-12 16:16:37');
INSERT INTO `tb_plugin_image` VALUES (17, '狗头', 'bd12e6de-375b-4fd4-8515-50456492d4f6.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 16:22:53', 776465218, '2022-10-12 16:22:53');
INSERT INTO `tb_plugin_image` VALUES (18, '不给', '8ec7df72-a4b1-49ce-91bd-e8b86d796cf2.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 16:26:13', 776465218, '2022-10-12 16:26:13');
INSERT INTO `tb_plugin_image` VALUES (19, '已阅', 'caeb17d0-313f-4fa2-ac5c-bafa506484cc.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 16:26:31', 776465218, '2022-10-12 16:26:31');
INSERT INTO `tb_plugin_image` VALUES (20, '有了', '846bd462-1b24-4a09-a9c4-2d3828efc3ef.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 17:04:36', 776465218, '2022-10-12 17:04:36');
INSERT INTO `tb_plugin_image` VALUES (21, '我拿什么跟她比', '9b5a7bc9-1c7a-4026-a37f-b96a72f070e4.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 19:55:07', 776465218, '2022-10-12 19:55:07');
INSERT INTO `tb_plugin_image` VALUES (22, '啊对对对', 'f08cebea-1778-46d5-bd30-ab67feac08c6.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:36:52', 776465218, '2022-10-13 12:36:52');
INSERT INTO `tb_plugin_image` VALUES (23, '怎么又', 'e658ea07-fe8b-4b62-9057-bc97b627051e.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:37:20', 776465218, '2022-10-13 12:37:20');
INSERT INTO `tb_plugin_image` VALUES (24, '晓希', '5efd9177-259c-4aee-b005-3343684da3df.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:53:36', 776465218, '2022-10-13 12:53:36');
INSERT INTO `tb_plugin_image` VALUES (25, '假笑', 'c16e057a-921d-498e-88bb-d0ec5adac05f.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:54:13', 776465218, '2022-10-13 12:54:13');
INSERT INTO `tb_plugin_image` VALUES (26, '?', '31d1e0d7-f88d-4225-9988-84643f25eeff.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:56:18', 776465218, '2022-10-13 12:56:18');
INSERT INTO `tb_plugin_image` VALUES (27, '振刀', 'ccb3777a-f6e8-46d7-a4aa-307a6d6d9d77.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:57:20', 776465218, '2022-10-13 12:57:20');
INSERT INTO `tb_plugin_image` VALUES (28, '死啊', '880cca52-bee6-4794-8a00-7aed2a397975.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:57:38', 776465218, '2022-10-13 12:57:38');
INSERT INTO `tb_plugin_image` VALUES (29, '我是cb', '9154854c-1198-4b6d-86bd-9914d390a0ba.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:59:39', 776465218, '2022-10-13 12:59:39');
INSERT INTO `tb_plugin_image` VALUES (30, '疯狂星期四', '66bdf732-c51b-4573-b744-2e0bdef00505.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 13:02:31', 776465218, '2022-10-13 13:02:31');
INSERT INTO `tb_plugin_image` VALUES (31, '疯狂星期四2', 'dbfff249-f1b0-4238-8ca1-2e0370b8d297.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 13:02:44', 776465218, '2022-10-13 13:02:44');
INSERT INTO `tb_plugin_image` VALUES (32, '疯狂星期四3', '62b576c6-42d2-43bf-b497-9e3369896e52.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 13:02:55', 776465218, '2022-10-13 13:02:55');
INSERT INTO `tb_plugin_image` VALUES (33, '未成年的目光', 'dfc16453-9e61-4b86-b511-bebb7411b07f.png', 673745932, 776465218, 0, 776465218, '2022-10-13 13:04:37', 776465218, '2022-10-13 13:04:37');
INSERT INTO `tb_plugin_image` VALUES (34, '麻中麻中麻', '035dcb40-638f-4a99-a4b0-61d1f260d4b9.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-13 13:45:13', 1743114170, '2022-10-13 13:45:13');
INSERT INTO `tb_plugin_image` VALUES (35, '麻了', 'b471fef8-1770-4dfb-83e3-29d902cacfc4.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 13:52:37', 776465218, '2022-10-13 13:52:37');
INSERT INTO `tb_plugin_image` VALUES (36, '恶心', '676f81ce-6aea-4290-8ea5-4689b298f705.jpg', 673745932, 80000000, 0, 80000000, '2022-10-13 14:07:10', 80000000, '2022-10-13 14:07:10');
INSERT INTO `tb_plugin_image` VALUES (37, '我觉得很恶星', '93a72105-6a37-4b82-838a-730aeb6a09d7.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-13 14:08:10', 1743114170, '2022-10-13 14:08:10');
INSERT INTO `tb_plugin_image` VALUES (38, '没办法人家就是好色嘛', 'c56cb1a8-1678-4dda-8401-6dc9dd2fc57f.jpg', 673745932, 601372611, 0, 601372611, '2022-10-13 14:11:58', 601372611, '2022-10-13 14:11:58');
INSERT INTO `tb_plugin_image` VALUES (39, '我小猫咪也绝非善类', '957248f0-1c0c-405f-b212-220f70b01e48.jpg', 673745932, 601372611, 0, 601372611, '2022-10-13 14:12:38', 601372611, '2022-10-13 14:12:38');
INSERT INTO `tb_plugin_image` VALUES (40, '训练师生涯', '02c6be8a-4918-4f85-a226-8632f87e9882.jpg', 673745932, 776465218, 0, 776465218, '2022-10-14 15:19:26', 776465218, '2022-10-14 15:19:26');
INSERT INTO `tb_plugin_image` VALUES (41, '还想要', '7bbe1c36-5b67-4c75-9c76-9463f2bc36b1.jpg', 673745932, 601372611, 0, 601372611, '2022-10-14 15:20:02', 601372611, '2022-10-14 15:20:02');
INSERT INTO `tb_plugin_image` VALUES (42, '疯狂暗示', '857609b1-40d6-4e57-a216-d56645222216.jpg', 673745932, 601372611, 0, 601372611, '2022-10-14 15:24:03', 601372611, '2022-10-14 15:24:03');
INSERT INTO `tb_plugin_image` VALUES (43, '栞傻了', 'f1ff3f3f-7d11-40ee-8cdc-3cc2e607f356.jpg', 673745932, 601372611, 0, 601372611, '2022-10-14 15:26:06', 601372611, '2022-10-14 15:26:06');
INSERT INTO `tb_plugin_image` VALUES (44, 'zxycb', '687049ff-46d7-4351-9798-64229532ecd1.jpg', 673745932, 776465218, 0, 776465218, '2022-10-14 15:27:04', 776465218, '2022-10-14 15:27:04');
INSERT INTO `tb_plugin_image` VALUES (45, '我小猫咪的心好痛', '5d9210b9-e142-471f-ac87-ec8a5cae86eb.jpg', 673745932, 601372611, 0, 601372611, '2022-10-14 15:38:36', 601372611, '2022-10-14 15:38:36');
INSERT INTO `tb_plugin_image` VALUES (46, '被生活击倒在地', '65bc9838-d47f-4075-ac53-8488db3e55f0.jpg', 673745932, 601372611, 0, 601372611, '2022-10-14 16:47:34', 601372611, '2022-10-14 16:47:34');
INSERT INTO `tb_plugin_image` VALUES (47, '徐姜权', '232b99ce-353c-4c45-a01c-4f9d635dea0e.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-14 16:49:46', 1743114170, '2022-10-14 16:49:46');
INSERT INTO `tb_plugin_image` VALUES (48, '放下助人情节', '35daab2e-cc6d-4569-9a06-1e0f39f90af0.jpg', 673745932, 776465218, 0, 776465218, '2022-10-14 23:03:55', 776465218, '2022-10-14 23:03:55');
INSERT INTO `tb_plugin_image` VALUES (49, '我睡不着', '841623ec-81bf-45fe-be8e-f5806ba663aa.jpg', 673745932, 776465218, 0, 776465218, '2022-10-15 00:19:43', 776465218, '2022-10-15 00:19:43');
INSERT INTO `tb_plugin_image` VALUES (50, '不知道你在叫什么', 'c21b756e-9e50-4cd9-a4ab-8de7749049b4.png', 673745932, 601372611, 0, 601372611, '2022-10-15 00:29:49', 601372611, '2022-10-15 00:29:49');
INSERT INTO `tb_plugin_image` VALUES (51, '不知道为什么柠檬老是围着我转', '16e872e9-66cd-4e77-88c8-23798dab51bd.gif', 673745932, 601372611, 0, 601372611, '2022-10-15 00:30:56', 601372611, '2022-10-15 00:30:56');
INSERT INTO `tb_plugin_image` VALUES (52, '活活笑死', '159cc0cb-4b95-4703-879f-0ff7913cfc47.jpg', 673745932, 601372611, 0, 601372611, '2022-10-15 00:31:17', 601372611, '2022-10-15 00:31:17');
INSERT INTO `tb_plugin_image` VALUES (53, '我小猫咪听不懂', '6235f8e7-bbae-4c8f-bf57-8e87c3610ae3.jpg', 673745932, 601372611, 0, 601372611, '2022-10-15 00:42:06', 601372611, '2022-10-15 00:42:06');
INSERT INTO `tb_plugin_image` VALUES (54, '我想不通', 'ce3a35d0-93de-4c67-91e9-7b97ddab3563.jpg', 673745932, 601372611, 0, 601372611, '2022-10-15 00:47:02', 601372611, '2022-10-15 00:47:02');
INSERT INTO `tb_plugin_image` VALUES (55, '这可能就是命吧', 'ecb04ff4-84a3-42e9-8b8a-52fe81e005fa.jpg', 673745932, 601372611, 0, 601372611, '2022-10-15 00:49:26', 601372611, '2022-10-15 00:49:26');
INSERT INTO `tb_plugin_image` VALUES (56, '你和我说这些没用', '0eff3f11-a201-4f02-a20b-e93fd15c028d.jpg', 673745932, 601372611, 0, 601372611, '2022-10-15 00:49:52', 601372611, '2022-10-15 00:49:52');
INSERT INTO `tb_plugin_image` VALUES (57, '丢人箱', '19bdf922-d233-4ce0-b5c1-751abf288d2d.jpg', 673745932, 601372611, 0, 601372611, '2022-10-15 00:51:24', 601372611, '2022-10-15 00:51:24');
INSERT INTO `tb_plugin_image` VALUES (58, '一句话', '9c9460d0-d9f0-4e2b-96b5-cee279d28746.png', 673745932, 776465218, 0, 776465218, '2022-10-17 10:00:29', 776465218, '2022-10-17 10:00:29');
INSERT INTO `tb_plugin_image` VALUES (59, '自欺欺人', 'd52caaba-8898-44dd-9b35-65b0728491ed.jpg', 673745932, 776465218, 0, 776465218, '2022-10-17 16:15:23', 776465218, '2022-10-17 16:15:23');
INSERT INTO `tb_plugin_image` VALUES (60, '掩耳盗铃', 'a2e1bce7-2b74-4c58-906e-2a92219a47bc.png', 673745932, 601372611, 0, 601372611, '2022-10-17 16:21:42', 601372611, '2022-10-17 16:21:42');
INSERT INTO `tb_plugin_image` VALUES (61, '未卜先知', '058db012-1b1e-4a97-8ff6-1dff85990a7a.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-17 16:22:12', 1743114170, '2022-10-17 16:22:12');
INSERT INTO `tb_plugin_image` VALUES (62, '濒死上班', 'a7f6ef6f-d9c8-4607-9f49-e8f89ec39ce7.jpg', 673745932, 601372611, 0, 601372611, '2022-10-18 08:52:43', 601372611, '2022-10-18 08:52:43');
INSERT INTO `tb_plugin_image` VALUES (63, 'yly本人', 'f807c9da-73be-413c-9ffd-8525282f83dd.jpg', 673745932, 776465218, 0, 776465218, '2022-10-18 13:58:19', 776465218, '2022-10-18 13:58:19');
INSERT INTO `tb_plugin_image` VALUES (64, '我是傻狗', '0fa27eee-aa06-4626-8500-abd7cdd93722.jpg', 673745932, 776465218, 0, 776465218, '2022-10-18 16:53:21', 776465218, '2022-10-18 16:53:21');
INSERT INTO `tb_plugin_image` VALUES (65, '时间扭曲', 'eda5de58-4f95-4f19-ad84-c213c5e50b69.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:06:37', 943952775, '2022-10-18 17:06:37');
INSERT INTO `tb_plugin_image` VALUES (66, '闪避机动', 'd7d8c92a-4028-4fb2-b612-b43da1b1aaa8.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:07:58', 943952775, '2022-10-18 17:07:58');
INSERT INTO `tb_plugin_image` VALUES (67, '短视症', 'f2132576-6939-4e3a-9990-a2270a20b386.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:08:12', 943952775, '2022-10-18 17:08:12');
INSERT INTO `tb_plugin_image` VALUES (68, '震荡攻击', '13df4213-6cd0-4cbb-a929-1e0d5c6b3af0.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:08:26', 943952775, '2022-10-18 17:08:26');
INSERT INTO `tb_plugin_image` VALUES (69, '时空力场', '4614dac7-a905-4d59-8edb-ab4a3c332abd.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:08:46', 943952775, '2022-10-18 17:08:46');
INSERT INTO `tb_plugin_image` VALUES (70, '轨道轰炸', '136b75ab-1f93-47c7-aae9-7548fb8b11c3.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:08:59', 943952775, '2022-10-18 17:08:59');
INSERT INTO `tb_plugin_image` VALUES (71, '光子过载', '9cfb8390-4a4b-4cd0-8f72-9f994892d9f6.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:09:08', 943952775, '2022-10-18 17:09:08');
INSERT INTO `tb_plugin_image` VALUES (72, '生命吸取', '1bfbf78d-c6c0-4f66-b9d3-879bbed14ffe.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:09:27', 943952775, '2022-10-18 17:09:27');
INSERT INTO `tb_plugin_image` VALUES (73, '强行征用', 'c7dc2da4-4473-4bbf-b003-40fda21c8390.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:09:52', 943952775, '2022-10-18 17:09:52');
INSERT INTO `tb_plugin_image` VALUES (74, '行尸走肉', '06296f9a-5bf0-4d91-8b5c-f57e543d0c5b.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:10:06', 943952775, '2022-10-18 17:10:06');
INSERT INTO `tb_plugin_image` VALUES (75, '暗无天日', '2fe64464-6b9e-425b-aa36-69dd4b269b33.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:10:14', 943952775, '2022-10-18 17:10:14');
INSERT INTO `tb_plugin_image` VALUES (76, '速度狂魔', '3f038ee7-6642-43b3-8b13-2ebdb5638798.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:10:27', 943952775, '2022-10-18 17:10:27');
INSERT INTO `tb_plugin_image` VALUES (77, '晶矿护盾', '9907ac29-d575-4e7d-bf43-c7661a9519e9.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:10:48', 943952775, '2022-10-18 17:10:48');
INSERT INTO `tb_plugin_image` VALUES (78, '减伤屏障', 'ed7e754a-1e56-452e-8dc2-d8e993e84492.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:11:02', 943952775, '2022-10-18 17:11:02');
INSERT INTO `tb_plugin_image` VALUES (79, '焦土政策', '38b36988-8ed0-4eca-a902-7dda2363aa10.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:11:11', 943952775, '2022-10-18 17:11:11');
INSERT INTO `tb_plugin_image` VALUES (80, '异形寄生', '3aa42b09-6e2b-4b28-9838-3afb91baba6a.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:11:23', 943952775, '2022-10-18 17:11:23');
INSERT INTO `tb_plugin_image` VALUES (81, '激光钻机', 'bef55dbc-abf5-4db6-8645-e7d595e6d879.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:11:32', 943952775, '2022-10-18 17:11:32');
INSERT INTO `tb_plugin_image` VALUES (82, '超远视距', 'a967c80a-2747-46b3-b08c-131745aa867a.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:11:47', 943952775, '2022-10-18 17:11:47');
INSERT INTO `tb_plugin_image` VALUES (83, '龙卷风暴', '7775bacc-bddb-4d1c-8e1f-a5631fceafed.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:11:58', 943952775, '2022-10-18 17:11:58');
INSERT INTO `tb_plugin_image` VALUES (84, '净化光束', 'af042327-617b-434e-8e0e-1e81c2f85da5.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:12:18', 943952775, '2022-10-18 17:12:18');
INSERT INTO `tb_plugin_image` VALUES (85, '鼓舞人心', '835aae56-5727-4c7e-96b4-f7a9b5da0369.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:12:26', 943952775, '2022-10-18 17:12:26');
INSERT INTO `tb_plugin_image` VALUES (86, '坚强意志', 'a66a62cf-ee44-4df8-a1f6-7d49be596989.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:12:35', 943952775, '2022-10-18 17:12:35');
INSERT INTO `tb_plugin_image` VALUES (87, '默哀', '25945535-a79f-48e3-8183-9f460f1761ed.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:12:42', 943952775, '2022-10-18 17:12:42');
INSERT INTO `tb_plugin_image` VALUES (88, '丧尸大战', 'bac2cef1-175a-4e40-bbeb-598cc14d4964.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:12:51', 943952775, '2022-10-18 17:12:51');
INSERT INTO `tb_plugin_image` VALUES (89, '岩浆爆发', '0c94e549-5a0d-4f7c-b378-8ffe81946980.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:13:12', 943952775, '2022-10-18 17:13:12');
INSERT INTO `tb_plugin_image` VALUES (90, '自毁程序', '84664384-73a0-4052-b56a-39c994c3fe53.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:13:21', 943952775, '2022-10-18 17:13:21');
INSERT INTO `tb_plugin_image` VALUES (91, '进攻部署', '21bd9f64-aeda-46f6-a055-1d98c205e15b.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:13:32', 943952775, '2022-10-18 17:13:32');
INSERT INTO `tb_plugin_image` VALUES (92, '来去无踪', 'c42f8ca5-d6b3-453b-b1f7-736b22301c79.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:13:46', 943952775, '2022-10-18 17:13:46');
INSERT INTO `tb_plugin_image` VALUES (93, '无边恐惧', 'dbe02214-3520-4ca3-a13c-60acc754e29d.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:14:01', 943952775, '2022-10-18 17:14:01');
INSERT INTO `tb_plugin_image` VALUES (94, '核弹打击', 'f68f275b-1346-4e64-ac7b-51d1343016b1.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:14:08', 943952775, '2022-10-18 17:14:08');
INSERT INTO `tb_plugin_image` VALUES (95, '飞弹大战', '18a5905f-6d31-43bc-a737-544d2dc78e63.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:14:16', 943952775, '2022-10-18 17:14:16');
INSERT INTO `tb_plugin_image` VALUES (96, '伤害散射', '16bf44bc-649a-4f6c-a314-67206a856800.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:14:25', 943952775, '2022-10-18 17:14:25');
INSERT INTO `tb_plugin_image` VALUES (97, '双重压力', '2b1fce4b-1099-4eae-a07d-09ab28e9f029.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:21:24', 943952775, '2022-10-18 17:21:24');
INSERT INTO `tb_plugin_image` VALUES (98, '致命勾引', '43b7263f-6260-4969-a4b1-04b7d283bbaf.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:24:14', 943952775, '2022-10-18 17:24:14');
INSERT INTO `tb_plugin_image` VALUES (99, '强磁雷场', '15b06e83-753b-4466-a75c-b6dd773d4043.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:25:09', 943952775, '2022-10-18 17:25:09');
INSERT INTO `tb_plugin_image` VALUES (100, '暴风雪', '3a1d1faf-7b11-4522-9af5-40800f263b83.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:25:19', 943952775, '2022-10-18 17:25:19');
INSERT INTO `tb_plugin_image` VALUES (101, '复仇战士', 'a26b6c0c-798c-44a1-87b1-40818ea29dd8.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:25:28', 943952775, '2022-10-18 17:25:28');
INSERT INTO `tb_plugin_image` VALUES (102, '相互摧毁', 'c2e280cc-c6e6-4ee3-96db-6cb634a83f54.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:25:39', 943952775, '2022-10-18 17:25:39');
INSERT INTO `tb_plugin_image` VALUES (103, '小捞油水', '06a6e4f0-bcdc-4f53-9b9f-2e9b3203faf2.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:25:52', 943952775, '2022-10-18 17:25:52');
INSERT INTO `tb_plugin_image` VALUES (104, '虚空重生者', 'f5fabc2d-fef5-433b-ae92-8f3296b79bbd.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:26:01', 943952775, '2022-10-18 17:26:01');
INSERT INTO `tb_plugin_image` VALUES (105, '灵能爆表', '208f8ffc-de4d-4930-9818-164f6ed3b10c.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:26:10', 943952775, '2022-10-18 17:26:10');
INSERT INTO `tb_plugin_image` VALUES (106, '拿钱说话', 'cdc681a4-fcdf-44f8-bbb7-608e739b5b7e.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:26:22', 943952775, '2022-10-18 17:26:22');
INSERT INTO `tb_plugin_image` VALUES (107, '扫雷专家', '907d5363-d78b-4634-a56b-dc8022ef53bd.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:26:34', 943952775, '2022-10-18 17:26:34');
INSERT INTO `tb_plugin_image` VALUES (108, '杀戮机器人', '0941635d-1915-472b-a9da-ac7ac5ed9b28.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:26:44', 943952775, '2022-10-18 17:26:44');
INSERT INTO `tb_plugin_image` VALUES (109, '给我死吧', 'c744f035-a1b0-447e-be28-e4563cf22232.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:26:52', 943952775, '2022-10-18 17:26:52');
INSERT INTO `tb_plugin_image` VALUES (110, '极性不定', '9324b5b0-3b39-4b97-b90d-39d39af6d022.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:27:04', 943952775, '2022-10-18 17:27:04');
INSERT INTO `tb_plugin_image` VALUES (111, '力量蜕变', '1b628a5f-fffb-44a8-abf2-83772ae041aa.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:27:16', 943952775, '2022-10-18 17:27:16');
INSERT INTO `tb_plugin_image` VALUES (112, '黑死病', '2322d2b1-f604-463a-a736-b9f5b4bfd858.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:27:23', 943952775, '2022-10-18 17:27:23');
INSERT INTO `tb_plugin_image` VALUES (113, '同化体', 'e22c952d-05ed-4fe3-abea-5c4ed7159085.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:29:10', 943952775, '2022-10-18 17:29:10');
INSERT INTO `tb_plugin_image` VALUES (114, '虚空裂隙', '5956b7e2-f51e-4317-b7b5-2bfc2c1b4c04.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:30:33', 943952775, '2022-10-18 17:30:33');
INSERT INTO `tb_plugin_image` VALUES (115, '风暴英雄', '47bfc0ed-0b1e-4e36-91ba-a06b15bc199d.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:30:40', 943952775, '2022-10-18 17:30:40');
INSERT INTO `tb_plugin_image` VALUES (116, '随机', '49b343e5-20e1-4c46-872c-3d710b39d2bb.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:30:51', 943952775, '2022-10-18 17:30:51');
INSERT INTO `tb_plugin_image` VALUES (117, '上班偷睡', 'f8eb2315-af2b-48f2-b36f-aad51e3d3e9d.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:31:18', 943952775, '2022-10-18 17:31:18');
INSERT INTO `tb_plugin_image` VALUES (118, '石像狂热者', '65401f43-007c-4c0f-8054-c28236ac9e12.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:31:35', 943952775, '2022-10-18 17:31:35');
INSERT INTO `tb_plugin_image` VALUES (119, '混乱工作室', '820e978e-bad4-4b55-b51e-a5154dd4913d.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:31:53', 943952775, '2022-10-18 17:31:53');
INSERT INTO `tb_plugin_image` VALUES (120, '迷失方向', '13d14544-0a43-4de6-95e5-0419acfc5f0a.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:32:05', 943952775, '2022-10-18 17:32:05');
INSERT INTO `tb_plugin_image` VALUES (121, '不死邪魔', '7b107928-413c-4f18-94a6-13397ecd8143.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:32:17', 943952775, '2022-10-18 17:32:17');
INSERT INTO `tb_plugin_image` VALUES (122, '惧怕黑暗', '04b46a3c-a1bc-4062-a1c3-1d1f59b4e0c1.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:32:33', 943952775, '2022-10-18 17:32:33');
INSERT INTO `tb_plugin_image` VALUES (123, '不给糖果就捣蛋', '51a14cec-12cf-45dd-a309-efebf3a4b602.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:32:46', 943952775, '2022-10-18 17:32:46');
INSERT INTO `tb_plugin_image` VALUES (124, '补给共享', 'fb155906-7988-4f40-8770-4509fe963837.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:33:19', 943952775, '2022-10-18 17:33:19');
INSERT INTO `tb_plugin_image` VALUES (125, '礼尚往来', '738035ed-32c9-4afa-8fc6-65553a35bd5f.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:33:33', 943952775, '2022-10-18 17:33:33');
INSERT INTO `tb_plugin_image` VALUES (126, '杀生业报', '4481ad71-10ff-4d4b-a297-73b43a63adb0.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:34:01', 943952775, '2022-10-18 17:34:01');
INSERT INTO `tb_plugin_image` VALUES (127, '极度谨慎', '4e1b0e91-7785-4e88-9f80-d4a0430daf5a.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:34:14', 943952775, '2022-10-18 17:34:14');
INSERT INTO `tb_plugin_image` VALUES (128, '刺头兵', 'b21960c6-9fc8-4324-a0a4-e28e36233579.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:34:25', 943952775, '2022-10-18 17:34:25');
INSERT INTO `tb_plugin_image` VALUES (129, '焰火秀', '5966de7c-9b7e-4b7a-be4a-452cd2e5ca72.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:34:33', 943952775, '2022-10-18 17:34:33');
INSERT INTO `tb_plugin_image` VALUES (130, '幸运红包', '10e0faec-fbb2-491b-98bf-63b2b15c81ef.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:34:45', 943952775, '2022-10-18 17:34:45');
INSERT INTO `tb_plugin_image` VALUES (131, '消极战斗', '896666cc-b6ba-47c6-9f2a-9f16cccab663.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:34:55', 943952775, '2022-10-18 17:34:55');
INSERT INTO `tb_plugin_image` VALUES (132, '炸弹机器人', 'cadd1323-1286-46a7-a24b-04863d61949e.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:35:02', 943952775, '2022-10-18 17:35:02');
INSERT INTO `tb_plugin_image` VALUES (133, '集结国王', '3aedb677-3279-4d24-899b-7d0c8a203390.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:38:06', 943952775, '2022-10-18 17:38:06');
INSERT INTO `tb_plugin_image` VALUES (134, '爬', '637b4cfe-1af9-46f0-8138-27b5cf6595a3.gif', 673745932, 776465218, 0, 776465218, '2022-10-18 17:52:18', 776465218, '2022-10-18 17:52:18');
INSERT INTO `tb_plugin_image` VALUES (135, '捕杀火鸡', '891bef53-b2e0-4b1d-8c56-8a6234ad9605.jpg', 673745932, 776465218, 0, 776465218, '2022-10-18 19:27:37', 776465218, '2022-10-18 19:27:37');
INSERT INTO `tb_plugin_image` VALUES (136, '合情合理', 'ac303f00-b4b1-4705-8165-e12351705210.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-19 09:41:17', 1743114170, '2022-10-19 09:41:17');
INSERT INTO `tb_plugin_image` VALUES (137, '合情合理2', 'd4f49639-0444-495e-a0e4-f6dbdd771247.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-19 14:25:10', 1743114170, '2022-10-19 14:25:10');
INSERT INTO `tb_plugin_image` VALUES (138, 'cb', '980d4eaa-a536-4f4c-b160-7e8a13f3ce04.jpg', 673745932, 776465218, 0, 776465218, '2022-10-19 14:25:38', 776465218, '2022-10-19 14:25:38');
INSERT INTO `tb_plugin_image` VALUES (139, '就这', '73291a84-8c7a-4d33-862b-98f3c1272b4b.jpg', 673745932, 776465218, 0, 776465218, '2022-10-20 12:50:53', 776465218, '2022-10-20 12:50:53');
INSERT INTO `tb_plugin_image` VALUES (140, '不对', 'd62612ec-fd2d-4095-9201-13348237b7b0.jpg', 673745932, 776465218, 0, 776465218, '2022-10-20 12:51:48', 776465218, '2022-10-20 12:51:48');
INSERT INTO `tb_plugin_image` VALUES (141, 'das', 'ec621a1b-88da-4342-a94d-28651c14dc15.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-20 18:01:20', 1743114170, '2022-10-20 18:01:20');
INSERT INTO `tb_plugin_image` VALUES (142, '我柴郡都想给你一拳', '641706ca-a900-4ea5-88fd-bb0abbf3ace1.jpg', 673745932, 776465218, 0, 776465218, '2022-11-08 16:01:01', 776465218, '2022-11-08 16:01:01');
INSERT INTO `tb_plugin_image` VALUES (143, '下面我简单喵两句@碧蓝航线吧', 'db997689-d1e3-4aae-994d-a24a3e7aa4b5.jpg', 673745932, 776465218, 0, 776465218, '2022-11-08 16:21:18', 776465218, '2022-11-08 16:21:18');
INSERT INTO `tb_plugin_image` VALUES (144, '见鬼了猪怎么会说话贴(碧蓝航线吧', '8b6c3414-3153-4c06-9d3b-75f8988a4e3d.jpg', 673745932, 601372611, 0, 776465218, '2022-11-08 16:22:48', 776465218, '2022-11-08 16:22:48');
INSERT INTO `tb_plugin_image` VALUES (145, '柴郡从来不看这种色色的东西', '5a6eabff-c756-4754-a011-2764252f0d47.jpg', 673745932, 601372611, 0, 776465218, '2022-11-08 16:23:58', 776465218, '2022-11-08 16:23:58');
INSERT INTO `tb_plugin_image` VALUES (146, '猫听完也死了', 'e62c4414-472f-4694-8430-62f50c743ae2.png', 673745932, 776465218, 0, 776465218, '2022-11-08 16:26:27', 776465218, '2022-11-08 16:26:27');
INSERT INTO `tb_plugin_image` VALUES (147, '早上坏', 'db6a8575-8d96-48fa-aada-6a1f427e7b0d.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 10:40:59', 776465218, '2022-11-10 10:40:59');
INSERT INTO `tb_plugin_image` VALUES (148, '有这种事?', 'cd85c6ba-3db5-4439-8393-f9891eb4fce8.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 10:45:20', 776465218, '2022-11-10 10:45:20');
INSERT INTO `tb_plugin_image` VALUES (149, '纵须猛犸屎山堆出来了', '6c6323de-84aa-4a31-939f-eb4ca0d3f353.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 11:20:00', 776465218, '2022-11-10 11:20:00');
INSERT INTO `tb_plugin_image` VALUES (150, '奥欸', '97d53d08-679a-4d43-a33f-aeb0e58f1c9c.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 11:30:06', 776465218, '2022-11-10 11:30:06');
INSERT INTO `tb_plugin_image` VALUES (151, '奥欸(', 'c69ac875-4a48-4b3f-808e-cf3cae17b6a2.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 11:30:34', 776465218, '2022-11-10 11:30:34');
INSERT INTO `tb_plugin_image` VALUES (152, '奥欸饿哦爱哦二', '8fd887c8-88cc-4e7f-9350-2a4bb0a02e17.gif', 673745932, 776465218, 0, 776465218, '2022-11-10 11:38:27', 776465218, '2022-11-10 11:38:27');
INSERT INTO `tb_plugin_image` VALUES (153, '奥欸饿哦爱哦二564', 'bf310f2f-fcd6-45b7-a538-e4da9233cd72.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 11:41:37', 776465218, '2022-11-10 11:41:37');
INSERT INTO `tb_plugin_image` VALUES (154, '寄', 'ba94e07c-dc2c-4101-b7b3-89ee66037d0a.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:02:57', 776465218, '2022-11-10 13:02:57');
INSERT INTO `tb_plugin_image` VALUES (155, '乐乐', 'a39466dd-5f7b-41d7-a848-6c7df96575e8.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:04:29', 776465218, '2022-11-10 13:04:29');
INSERT INTO `tb_plugin_image` VALUES (156, '乐乐乐', '0b1cdb50-d274-41ed-9b70-55abd6c8a1a6.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:05:47', 776465218, '2022-11-10 13:05:47');
INSERT INTO `tb_plugin_image` VALUES (157, '乐乐乐乐乐', '51e0f6cb-baff-4e9e-b2cc-d33273817af1.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:08:42', 776465218, '2022-11-10 13:08:42');
INSERT INTO `tb_plugin_image` VALUES (158, '乐乐乐乐乐乐', 'd52b9df8-a1a6-4e1b-b617-b53818b3a0cd.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:09:46', 776465218, '2022-11-10 13:09:46');
INSERT INTO `tb_plugin_image` VALUES (159, '乐乐乐乐乐乐奥欸', 'ff7a03e0-7cb6-4354-8e14-aa6869a1aa55.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:40:46', 776465218, '2022-11-10 13:40:46');
INSERT INTO `tb_plugin_image` VALUES (160, '乐乐乐乐乐乐奥欸存图', '3ba1c044-29dd-4776-8d20-33bf00ff39b3.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:42:03', 776465218, '2022-11-10 13:42:03');
INSERT INTO `tb_plugin_image` VALUES (161, '乐乐乐乐乐乐奥欸存图存图', '3b3f1382-4c6c-49e4-8089-e960d6f0c9b6.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:43:05', 776465218, '2022-11-10 13:43:05');
INSERT INTO `tb_plugin_image` VALUES (162, '乐乐乐乐乐乐奥', '889d6922-9591-478b-97d2-e54f917181ca.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:43:30', 776465218, '2022-11-10 13:43:30');
INSERT INTO `tb_plugin_image` VALUES (163, '呕', 'c64199d7-e727-466f-bfa0-42776c25baed.png', 673745932, 943952775, 0, 943952775, '2022-11-10 13:50:56', 943952775, '2022-11-10 13:50:56');
INSERT INTO `tb_plugin_image` VALUES (164, '新年第一张图捏', '1a33d66e-2cd1-4faf-8f08-5decac92ebaa.jpeg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:52:09', 776465218, '2023-01-02 13:34:10');
INSERT INTO `tb_plugin_image` VALUES (165, '艾莉丝的鱼已阅', 'd0b61e89-787b-441a-8348-7b70c9ac1077.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:52:17', 776465218, '2022-11-10 13:52:17');
INSERT INTO `tb_plugin_image` VALUES (166, '艾莉丝的鱼知悉，图意 艾莉丝的鱼已阅', 'ea3a151a-b59f-4362-b341-f3535dd01b4b.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:52:35', 776465218, '2022-11-10 13:52:35');
INSERT INTO `tb_plugin_image` VALUES (167, '艾莉丝的鱼艾莉丝的鱼知悉，图意艾莉丝的鱼已阅', '5fe655f4-9589-4e82-93b1-dc2132c43208.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:54:26', 776465218, '2022-11-10 13:54:26');
INSERT INTO `tb_plugin_image` VALUES (168, '艾莉丝的鱼艾莉丝的鱼艾莉丝的鱼知悉， 图意艾莉丝的鱼已阅 ', 'e9977da1-88f4-498e-8c8e-a106281eb2ff.jpg', 673745932, 776465218, 1, 776465218, '2022-11-10 13:55:06', 776465218, '2023-01-02 14:47:53');
INSERT INTO `tb_plugin_image` VALUES (169, '测一下', '069c570f-9afa-4e54-90cf-0da3db7fa61a.jpeg', -1, 776465218, 1, 776465218, '2023-01-02 14:46:03', 776465218, '2023-01-02 14:46:11');
INSERT INTO `tb_plugin_image` VALUES (170, '测测测测', 'a1cdce85-7405-45b0-b7a6-ca0ca411f67e.jpeg', -1, 776465218, 0, 776465218, '2023-01-02 14:47:03', 776465218, '2023-01-02 14:47:03');
INSERT INTO `tb_plugin_image` VALUES (171, '我是急急国王', '8d81cd64-7bf7-4223-8a2e-ed3dce1b36e8.jpg', 673745932, 776465218, 0, 776465218, '2022-10-21 17:11:28', 776465218, '2022-10-21 17:11:28');
INSERT INTO `tb_plugin_image` VALUES (172, '你先别急', '21b3f7b1-a6d3-466e-86b1-f6ea73c60347.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-21 17:12:24', 1743114170, '2022-10-21 17:12:24');
INSERT INTO `tb_plugin_image` VALUES (173, '我是急先锋', 'c738f684-4a04-4ed7-96a2-1a1d00cf3c3e.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-21 17:12:45', 1743114170, '2022-10-21 17:12:45');
INSERT INTO `tb_plugin_image` VALUES (174, '❤', '99e88c6c-0317-4bab-b257-e3768ce1495a.jpg', 673745932, 776465218, 0, 776465218, '2022-10-21 17:13:24', 776465218, '2022-10-21 17:13:24');
INSERT INTO `tb_plugin_image` VALUES (175, '我不知道', '2ef8d3f2-3d21-48d0-87db-3e02a453731a.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-23 09:23:14', 1743114170, '2022-10-23 09:23:14');
INSERT INTO `tb_plugin_image` VALUES (176, '你百度一下', 'e7deed9d-b243-40b1-8165-8c1e757717b1.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-23 09:23:36', 1743114170, '2022-10-23 09:23:36');
INSERT INTO `tb_plugin_image` VALUES (177, '捏猫猫的', '80b33822-1ae2-45d9-8bc3-6615cffef141.jpg', 673745932, 776465218, 0, 776465218, '2022-10-23 14:05:06', 776465218, '2022-10-23 14:05:06');
INSERT INTO `tb_plugin_image` VALUES (178, '捏猫猫滴', '06acab38-389a-4a89-b72c-7da3f47e3ae4.jpg', 673745932, 776465218, 0, 776465218, '2022-10-23 14:05:14', 776465218, '2022-10-23 14:05:14');
INSERT INTO `tb_plugin_image` VALUES (179, '目睹作案现场', '3b15689e-211a-4bd8-bcf5-8cf67d624912.jpg', 673745932, 776465218, 0, 776465218, '2022-10-23 14:08:24', 776465218, '2022-10-23 14:08:24');
INSERT INTO `tb_plugin_image` VALUES (180, '你百度下', 'b8fa33d5-024e-476e-922c-0e830c7baa36.jpg', 673745932, 776465218, 0, 776465218, '2022-10-23 14:15:04', 776465218, '2022-10-23 14:15:04');
INSERT INTO `tb_plugin_image` VALUES (181, '停止战斗', '7406f39c-33de-4150-89b7-b1832349b901.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-23 14:15:36', 1743114170, '2022-10-23 14:15:36');
INSERT INTO `tb_plugin_image` VALUES (182, '我呆在原地', '16ecae86-2b0e-4f15-8bfe-3cb5917bfe23.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-23 14:17:07', 1743114170, '2022-10-23 14:17:07');
INSERT INTO `tb_plugin_image` VALUES (183, '一伯昏', '791c970f-8df8-4c32-8812-40877624497b.gif', 673745932, 776465218, 0, 776465218, '2022-10-23 15:02:03', 776465218, '2022-10-23 15:02:03');
INSERT INTO `tb_plugin_image` VALUES (184, '你有问题', '71d2045a-8d53-4d40-952a-c613213dd5a6.jpg', 673745932, 943952775, 0, 943952775, '2022-10-23 16:43:41', 943952775, '2022-10-23 16:43:41');
INSERT INTO `tb_plugin_image` VALUES (185, '别在这理发店', '8623be7e-c3e2-4d6b-a9ad-28e8515e7ab4.jpg', 673745932, 601372611, 0, 601372611, '2022-10-24 09:21:49', 601372611, '2022-10-24 09:21:49');
INSERT INTO `tb_plugin_image` VALUES (186, '别在这里发癫', 'cd47482b-225c-42ab-9755-23839b23d1d6.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-24 09:23:12', 1743114170, '2022-10-24 09:23:12');
INSERT INTO `tb_plugin_image` VALUES (187, '你咋跑出来了', '09c0f33c-50cf-4ad2-b166-41ad4b261220.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-24 09:23:34', 1743114170, '2022-10-24 09:23:34');
INSERT INTO `tb_plugin_image` VALUES (188, '你没救了', '6bc3fe1a-05af-4ff2-bb1d-48dd2512fc09.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-24 09:23:50', 1743114170, '2022-10-24 09:23:50');
INSERT INTO `tb_plugin_image` VALUES (189, '你有病', '2e961b2c-30b5-4448-af20-ca4fc9b194f2.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-24 09:24:11', 1743114170, '2022-10-24 09:24:11');
INSERT INTO `tb_plugin_image` VALUES (190, '你就是我手中的棉花糖', '4ed861be-1aab-4d28-90e4-5cb78f822bde.jpg', 673745932, 601372611, 0, 601372611, '2022-10-24 09:24:39', 601372611, '2022-10-24 09:24:39');
INSERT INTO `tb_plugin_image` VALUES (191, '我派车来接你了', '3259ddeb-670f-4336-9d20-f20c98d34616.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-24 09:27:32', 1743114170, '2022-10-24 09:27:32');
INSERT INTO `tb_plugin_image` VALUES (192, '啧啧啧', 'ee68210e-7d1f-49fe-9cdf-3eb345721feb.jpg', 673745932, 776465218, 0, 776465218, '2022-10-24 10:32:20', 776465218, '2022-10-24 10:32:20');
INSERT INTO `tb_plugin_image` VALUES (193, '淦', '20b3095c-75b9-4eb4-b81f-6c01de76fbae.jpg', 673745932, 776465218, 0, 776465218, '2022-10-24 10:37:28', 776465218, '2022-10-24 10:37:28');
INSERT INTO `tb_plugin_image` VALUES (194, '有傻狗', 'de60b5e2-71e4-43a8-857a-5f48488f586d.jpg', 673745932, 776465218, 0, 776465218, '2022-10-24 14:03:45', 776465218, '2022-10-24 14:03:45');
INSERT INTO `tb_plugin_image` VALUES (195, '好惨哦', '38db6534-b525-4670-9db1-078233464620.jpg', 673745932, 776465218, 0, 776465218, '2022-10-24 14:08:59', 776465218, '2022-10-24 14:08:59');
INSERT INTO `tb_plugin_image` VALUES (196, '关我屁事', 'f03d209b-1352-4f51-a765-c0625f4a4084.jpg', 673745932, 776465218, 0, 776465218, '2022-10-24 14:15:31', 776465218, '2022-10-24 14:15:31');
INSERT INTO `tb_plugin_image` VALUES (197, 'Das疑问', '091eba48-2cef-4c6a-83dc-47bc13938456.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-24 14:16:04', 1743114170, '2022-10-24 14:16:04');
INSERT INTO `tb_plugin_image` VALUES (198, '战术去世', 'c2a201c9-42af-4d7a-8368-2ed9cb0eb527.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-24 14:52:34', 1743114170, '2022-10-24 14:52:34');
INSERT INTO `tb_plugin_image` VALUES (199, '敢怒不敢言', '70700236-8b0b-47cc-930b-85ebf2aa7e93.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-24 15:30:55', 1743114170, '2022-10-24 15:30:55');
INSERT INTO `tb_plugin_image` VALUES (200, '谁提出', 'd41b4514-de1a-4425-b936-395565b52133.jpg', 673745932, 776465218, 0, 776465218, '2022-10-24 17:10:04', 776465218, '2022-10-24 17:10:04');
INSERT INTO `tb_plugin_image` VALUES (201, '那不可能', 'e819dcd2-1126-45b8-95b8-4957c19cedef.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-24 17:14:24', 1743114170, '2022-10-24 17:14:24');
INSERT INTO `tb_plugin_image` VALUES (202, '谢谢老板', 'f925c3ef-ef3b-46dc-bbf7-34c355fca2f6.png', 673745932, 776465218, 0, 776465218, '2022-10-24 17:39:59', 776465218, '2022-10-24 17:39:59');
INSERT INTO `tb_plugin_image` VALUES (203, '滚', '96d9e00d-55a3-42ca-9357-31ed180c717e.png', 673745932, 776465218, 0, 776465218, '2022-10-24 18:35:23', 776465218, '2022-10-24 18:35:23');
INSERT INTO `tb_plugin_image` VALUES (204, '日志', '20c89359-e054-474e-b780-0a2b86834b07.png', 673745932, 776465218, 0, 776465218, '2022-10-24 20:49:10', 776465218, '2022-10-24 20:49:10');
INSERT INTO `tb_plugin_image` VALUES (205, '逆天', '22062636-db43-4042-a6ef-6e4e8632ca50.jpg', 673745932, 1422291466, 0, 1422291466, '2022-10-24 22:49:06', 1422291466, '2022-10-24 22:49:06');
INSERT INTO `tb_plugin_image` VALUES (206, '我不信', '67418503-b489-4ea2-914d-ea56477cb12d.jpg', 673745932, 776465218, 0, 776465218, '2022-10-25 11:16:37', 776465218, '2022-10-25 11:16:37');
INSERT INTO `tb_plugin_image` VALUES (207, '建议躺床上开始睡觉', '4a1562dd-6c0d-4b36-9893-24aa8149ef11.jpg', 673745932, 776465218, 0, 776465218, '2022-10-25 11:17:09', 776465218, '2022-10-25 11:17:09');
INSERT INTO `tb_plugin_image` VALUES (208, '嗯好', '767475b4-371b-4c78-a901-ffd14922bfff.jpg', 673745932, 776465218, 0, 776465218, '2022-10-25 11:17:40', 776465218, '2022-10-25 11:17:40');
INSERT INTO `tb_plugin_image` VALUES (209, '睡觉觉鸟', '48c91570-a4ee-4d0b-acf1-ceb2fa179480.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-25 11:19:11', 1743114170, '2022-10-25 11:19:11');
INSERT INTO `tb_plugin_image` VALUES (210, '好耶', '1f3bbf9f-4183-45c7-a87c-c13d962d2f4e.jpg', 673745932, 776465218, 0, 776465218, '2022-10-25 11:19:49', 776465218, '2022-10-25 11:19:49');
INSERT INTO `tb_plugin_image` VALUES (211, '使用门槛', 'be2207ce-dd58-45c6-a383-cb9ba9936021.jpg', 673745932, 776465218, 0, 776465218, '2022-10-25 11:20:05', 776465218, '2022-10-25 11:20:05');
INSERT INTO `tb_plugin_image` VALUES (212, '挺有画面感的', '8f683a4f-4908-4845-9c18-fa2718354afc.jpg', 673745932, 776465218, 0, 776465218, '2022-10-25 12:34:54', 776465218, '2022-10-25 12:34:54');
INSERT INTO `tb_plugin_image` VALUES (213, 'ip', '1a1b37dc-cbb5-499f-bcde-b1f5880199a7.jpg', 673745932, 776465218, 0, 776465218, '2022-10-25 15:35:15', 776465218, '2022-10-25 15:35:15');
INSERT INTO `tb_plugin_image` VALUES (214, '服了', '72c5d81b-1031-498f-a646-75384bafea5a.jpg', 673745932, 776465218, 0, 776465218, '2022-10-26 17:36:14', 776465218, '2022-10-26 17:36:14');
INSERT INTO `tb_plugin_image` VALUES (215, '改变一个人', 'd2252c34-b497-4a60-8769-4df21348562e.jpg', 673745932, 776465218, 0, 776465218, '2022-10-27 08:09:17', 776465218, '2022-10-27 08:09:17');
INSERT INTO `tb_plugin_image` VALUES (216, '可乐很冰', '110f9999-4328-4f7e-84f5-4017d59536d2.jpg', 673745932, 601372611, 0, 601372611, '2022-10-27 20:05:13', 601372611, '2022-10-27 20:05:13');
INSERT INTO `tb_plugin_image` VALUES (217, 'sakana', 'd442d811-fe54-4ed1-ad4e-dc50a64548b6.jpg', 673745932, 776465218, 0, 776465218, '2022-10-28 15:14:58', 776465218, '2022-10-28 15:14:58');
INSERT INTO `tb_plugin_image` VALUES (218, '什么jb', '6b6df425-a098-416c-9ec7-88224c96c023.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-30 10:49:48', 1743114170, '2022-10-30 10:49:48');
INSERT INTO `tb_plugin_image` VALUES (219, '我指定是不行了', 'e46cd1f8-b209-4b5d-9d2b-b6cb2b1fed52.jpg', 673745932, 1743114170, 0, 1743114170, '2022-10-31 08:31:01', 1743114170, '2022-10-31 08:31:01');
INSERT INTO `tb_plugin_image` VALUES (220, '不许乐', 'e55a22bc-591e-4f9e-8773-90cf8313e202.png', -1, 776465218, 0, 776465218, '2022-10-31 08:54:05', 776465218, '2022-10-31 08:54:05');
INSERT INTO `tb_plugin_image` VALUES (221, '没发过就是没看过', '48bc92de-4cb7-496f-a3ea-593387f6d70c.jpg', 673745932, 776465218, 0, 776465218, '2022-11-01 09:26:17', 776465218, '2022-11-01 09:26:17');
INSERT INTO `tb_plugin_image` VALUES (222, '推荐你买小米', '94917e6a-b92d-47ad-8fa3-f51be9561ca1.jpg', 673745932, 1743114170, 0, 1743114170, '2022-11-01 09:45:19', 1743114170, '2022-11-01 09:45:19');
INSERT INTO `tb_plugin_image` VALUES (223, '发生什么事了', 'd495ecaa-4c63-4baa-8867-8670f68dca4e.jpg', 673745932, 1743114170, 0, 1743114170, '2022-11-02 09:54:26', 1743114170, '2022-11-02 09:54:26');
INSERT INTO `tb_plugin_image` VALUES (224, '处男', 'b23f2c54-8539-4529-a60a-7d091c1fc58c.jpg', 673745932, 776465218, 0, 776465218, '2022-11-02 10:30:51', 776465218, '2022-11-02 10:30:51');
INSERT INTO `tb_plugin_image` VALUES (225, '这都给你存下来了', 'f1172796-426c-4069-9e8d-2c681d5478b8.jpg', 673745932, 776465218, 0, 776465218, '2022-11-03 09:51:56', 776465218, '2022-11-03 09:51:56');
INSERT INTO `tb_plugin_image` VALUES (226, '我有说过这话吗', '8d321840-cbfc-46c1-9929-ae8a37ad32d0.jpg', 673745932, 943952775, 0, 943952775, '2022-11-03 11:10:18', 943952775, '2022-11-03 11:10:18');
INSERT INTO `tb_plugin_image` VALUES (227, '什么勾8', '1fda70c6-b790-42d1-8701-3af9abbe6bc4.jpg', 673745932, 776465218, 0, 776465218, '2022-11-03 11:10:55', 776465218, '2022-11-03 11:10:55');
INSERT INTO `tb_plugin_image` VALUES (228, '我有说过这话吗2', '5435dd18-4fb0-4cda-8ad1-17977473a2f6.jpg', 673745932, 776465218, 0, 776465218, '2022-11-03 11:11:12', 776465218, '2022-11-03 11:11:12');
INSERT INTO `tb_plugin_image` VALUES (229, '取图取图乐', '5feac571-d96e-42e0-8198-94116ac329d3.jpg', 673745932, 776465218, 0, 776465218, '2022-11-03 11:11:38', 776465218, '2022-11-03 11:11:38');
INSERT INTO `tb_plugin_image` VALUES (230, '呵 老狗', '18e50d19-2cb5-4fb1-94fd-8aaa06ab2ce9.jpg', 673745932, 1743114170, 0, 1743114170, '2022-11-03 13:46:21', 1743114170, '2022-11-03 13:46:21');
INSERT INTO `tb_plugin_image` VALUES (231, '狠人', '3f2d100c-22cd-4c1f-968a-211064847687.jpg', 673745932, 776465218, 0, 776465218, '2022-11-04 10:13:14', 776465218, '2022-11-04 10:13:14');
INSERT INTO `tb_plugin_image` VALUES (232, '仓皇出逃', '10d09927-3640-424e-ad43-e8dcf2a99a77.jpg', 673745932, 1743114170, 0, 1743114170, '2022-11-07 18:23:35', 1743114170, '2022-11-07 18:23:35');
INSERT INTO `tb_plugin_image` VALUES (233, '大家早上好', 'a3f66b10-315b-4a50-8010-57287f04afbc.gif', 673745932, 1743114170, 0, 1743114170, '2022-11-08 10:11:37', 1743114170, '2022-11-08 10:11:37');
INSERT INTO `tb_plugin_image` VALUES (234, '哥哥你好帅', 'ac0862cb-1362-454f-b304-5c06fe47ab53.jpg', 673745932, 1743114170, 0, 1743114170, '2022-11-08 10:11:58', 1743114170, '2022-11-08 10:11:58');
INSERT INTO `tb_plugin_image` VALUES (235, '老人看手机', '891f6f0d-6450-4512-81a1-6e76ada695d8.jpg', 673745932, 776465218, 0, 776465218, '2022-11-08 14:16:41', 776465218, '2022-11-08 14:16:41');
INSERT INTO `tb_plugin_image` VALUES (236, '你是什么Das', '87e78707-5286-4e8b-acd4-96d5bc23e81a.jpg', 673745932, 776465218, 0, 776465218, '2022-11-08 15:31:08', 776465218, '2022-11-08 15:31:08');
INSERT INTO `tb_plugin_image` VALUES (237, '噫', '9eddecdb-2097-4dd1-8a2f-93a513113039.jpg', 673745932, 1743114170, 0, 1743114170, '2022-11-09 14:57:45', 1743114170, '2022-11-09 14:57:45');
INSERT INTO `tb_plugin_image` VALUES (238, '噫2', '200ff85e-fe22-4a7d-8d64-4e83dcfba469.jpg', 673745932, 1743114170, 0, 1743114170, '2022-11-09 14:57:54', 1743114170, '2022-11-09 14:57:54');
INSERT INTO `tb_plugin_image` VALUES (239, '早', 'dc1680f5-f203-4692-9300-75787d674a6f.jpg', 673745932, 1422291466, 0, 1422291466, '2022-11-10 10:35:02', 1422291466, '2022-11-10 10:35:02');
INSERT INTO `tb_plugin_image` VALUES (240, '孕吐', 'f344f28e-52d1-45f2-b323-50ff19711dca.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:51:29', 776465218, '2022-11-10 13:51:29');
INSERT INTO `tb_plugin_image` VALUES (241, '套娃', '88dbdb4f-76b3-4832-bb63-55d57857a60c.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:55:27', 776465218, '2022-11-10 13:55:27');
INSERT INTO `tb_plugin_image` VALUES (242, 'work', '436e0ad6-67f0-47fd-a2b3-dcf6d377b5a1.gif', 673745932, 776465218, 0, 776465218, '2022-11-13 21:58:59', 776465218, '2022-11-13 21:58:59');
INSERT INTO `tb_plugin_image` VALUES (243, '你不要再睡了', '2a49f594-f753-4209-8cdd-9725e201e10c.jpg', 673745932, 601372611, 0, 601372611, '2022-11-16 17:07:21', 601372611, '2022-11-16 17:07:21');
INSERT INTO `tb_plugin_image` VALUES (244, '你这像素', 'd0ec31da-537a-4f50-b2fc-509b197b9782.jpg', 673745932, 1743114170, 0, 1743114170, '2022-11-16 17:20:29', 1743114170, '2022-11-16 17:20:29');
INSERT INTO `tb_plugin_image` VALUES (245, '我来了', 'e4170bc4-d2b9-4831-ac4e-4a24a849b038.jpg', 673745932, 1743114170, 0, 1743114170, '2022-11-16 17:20:41', 1743114170, '2022-11-16 17:20:41');
INSERT INTO `tb_plugin_image` VALUES (246, 'Das挠头', 'bd45e3bf-b38b-4af6-bc86-04f1e2c96c34.jpg', 673745932, 776465218, 0, 776465218, '2022-11-16 19:25:56', 776465218, '2022-11-16 19:25:56');
INSERT INTO `tb_plugin_image` VALUES (247, '啊对对对', '1cacb876-181c-41d6-be52-2a7abb170eb2.jpg', 673745932, 776465218, 1, 776465218, '2022-11-17 10:19:49', 776465218, '2022-11-17 10:19:49');
INSERT INTO `tb_plugin_image` VALUES (248, '啊对对对zxy', '9792166f-5ca1-4266-bdf1-d8c5081a75f2.jpg', 673745932, 776465218, 0, 776465218, '2022-11-17 10:20:51', 776465218, '2022-11-17 10:20:51');
INSERT INTO `tb_plugin_image` VALUES (249, '腰子给你噶了', '52e93c8b-45d1-4023-a788-b6beab47065f.jpg', 673745932, 776465218, 0, 776465218, '2022-11-23 08:44:28', 776465218, '2022-11-23 08:44:28');
INSERT INTO `tb_plugin_image` VALUES (250, '大寄', '99251532-322a-4db5-be07-08eef9eb3b35.jpg', 673745932, 776465218, 0, 776465218, '2022-11-25 18:04:35', 776465218, '2022-11-25 18:04:35');
INSERT INTO `tb_plugin_image` VALUES (251, '这个点还没起床的', '8d3e51a2-fd63-46f5-8dc2-9f0423d885c6.jpg', 673745932, 776465218, 0, 776465218, '2022-12-01 11:17:17', 776465218, '2022-12-01 11:17:17');
INSERT INTO `tb_plugin_image` VALUES (252, '一路走好', 'fa16d39b-fc70-46ce-8dc8-0004f8243f60.jpg', 673745932, 776465218, 0, 776465218, '2022-12-01 12:43:20', 776465218, '2022-12-01 12:43:20');
INSERT INTO `tb_plugin_image` VALUES (253, '哪来的狗', 'bad681d8-72c4-42a4-ab72-e94047507b74.jpg', 673745932, 1743114170, 0, 1743114170, '2022-12-01 15:28:34', 1743114170, '2022-12-01 15:28:34');
INSERT INTO `tb_plugin_image` VALUES (254, '偷心', '5b4c3c82-a556-4578-a2d7-f2eb66dc3be9.jpg', 673745932, 1422291466, 0, 1422291466, '2022-12-01 15:53:18', 1422291466, '2022-12-01 15:53:18');
INSERT INTO `tb_plugin_image` VALUES (255, '冲', '7e442bbc-f348-49da-b6fa-3a44ef840b5b.jpg', 673745932, 1422291466, 0, 1422291466, '2022-12-05 18:45:37', 1422291466, '2022-12-05 18:45:37');
INSERT INTO `tb_plugin_image` VALUES (256, '一二天', '31b7487e-3865-4d36-b6b5-ffb3ec80a48b.jpg', 673745932, 776465218, 0, 776465218, '2022-12-09 20:11:48', 776465218, '2022-12-09 20:11:48');
INSERT INTO `tb_plugin_image` VALUES (257, '三天', '472343d8-d8ac-497f-9001-6b835a5cd6ff.jpg', 673745932, 776465218, 0, 776465218, '2022-12-09 20:12:02', 776465218, '2022-12-09 20:12:02');
INSERT INTO `tb_plugin_image` VALUES (258, '四天', '832c14c1-1da9-41c3-a8a1-aa54e2566a9f.jpg', 673745932, 776465218, 0, 776465218, '2022-12-09 20:12:09', 776465218, '2022-12-09 20:12:09');
INSERT INTO `tb_plugin_image` VALUES (259, '五天', '76c7bfd2-ff79-4b94-a7cc-56e7d2a2bf56.jpg', 673745932, 776465218, 0, 776465218, '2022-12-09 20:12:14', 776465218, '2022-12-09 20:12:14');
INSERT INTO `tb_plugin_image` VALUES (260, '我看不懂Pro', 'f839b4e4-4041-44d4-894b-f1524ef4c287.jpg', 673745932, 1743114170, 0, 1743114170, '2022-12-12 15:38:46', 1743114170, '2022-12-12 15:38:46');
INSERT INTO `tb_plugin_image` VALUES (261, '这叫抢', 'eb3851ce-44f4-4b83-964b-15c1e51b4e97.jpg', 673745932, 776465218, 0, 776465218, '2022-12-13 21:38:28', 776465218, '2022-12-13 21:38:28');
INSERT INTO `tb_plugin_image` VALUES (262, '写bug呢', 'd1320669-638d-45d6-8d87-62667415d74a.jpg', 673745932, 1743114170, 0, 1743114170, '2022-12-19 12:37:43', 1743114170, '2022-12-19 12:37:43');
INSERT INTO `tb_plugin_image` VALUES (263, '害你加班', 'da2f7ed1-35fb-476d-a3a2-7931c4455cf9.jpg', 673745932, 1743114170, 0, 1743114170, '2022-12-19 12:38:20', 1743114170, '2022-12-19 12:38:20');
INSERT INTO `tb_plugin_image` VALUES (264, '千里眼', '516b413b-c6a2-4180-83c1-83c61e5747d1.jpg', 673745932, 943952775, 0, 943952775, '2022-12-27 10:46:01', 943952775, '2022-12-27 10:46:01');

-- ----------------------------
-- Table structure for tb_plugin_loaj_reply
-- ----------------------------
DROP TABLE IF EXISTS `tb_plugin_loaj_reply`;
CREATE TABLE `tb_plugin_loaj_reply`  (
  `row_id` bigint(0) NOT NULL COMMENT '主键id',
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '触发关键词',
  `reply` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '回复',
  `is_delete` tinyint(1) NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
  `create_user` bigint(0) NOT NULL COMMENT '创建用户',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_user` bigint(0) NOT NULL COMMENT '更新用户',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`row_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_plugin_loaj_reply
-- ----------------------------

-- ----------------------------
-- Table structure for tb_plugin_sc2_factor
-- ----------------------------
DROP TABLE IF EXISTS `tb_plugin_sc2_factor`;
CREATE TABLE `tb_plugin_sc2_factor`  (
  `row_id` bigint(0) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分数',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述',
  `image_file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '对应图片名称',
  `is_delete` tinyint(1) NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
  `create_user` bigint(0) NOT NULL COMMENT '创建用户',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_user` bigint(0) NOT NULL COMMENT '更新用户',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`row_id`) USING BTREE,
  INDEX `INDEX_NAME`(`name`, `image_file_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'sc2 因子' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_plugin_sc2_factor
-- ----------------------------
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098882, '时间扭曲', '1', '地图上会周期性地部署敌人的时间扭曲。', 'eda5de58-4f95-4f19-ad84-c213c5e50b69.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098883, '闪避机动', '1', '敌方单位受到伤害时将传送一小段距离。', 'd7d8c92a-4028-4fb2-b612-b43da1b1aaa8.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098884, '短视症', '1', '玩家单位及其建筑的视野范围缩短。', 'f2132576-6939-4e3a-9990-a2270a20b386.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098885, '震荡攻击', '1', '玩家单位会被所有敌方攻击减速。', '13df4213-6cd0-4cbb-a929-1e0d5c6b3af0.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098886, '时空力场', '1', '地图上会周期性地部署敌人的时空力场。', '4614dac7-a905-4d59-8edb-ab4a3c332abd.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098887, '轨道轰炸', '1', '敌人会在地图上周期性地施放轨道轰炸。', '136b75ab-1f93-47c7-aae9-7548fb8b11c3.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098888, '光子过载', '1', '所有敌方建筑会攻击附近的敌对单位。', '9cfb8390-4a4b-4cd0-8f72-9f994892d9f6.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098889, '生命吸取', '1', '敌方单位和建筑在造成伤害时偷取生命值或护盾。', '1bfbf78d-c6c0-4f66-b9d3-879bbed14ffe.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098890, '强行征用', '1', '敌人摧毁你的建筑后将获得建筑的控制权。', 'c7dc2da4-4473-4bbf-b003-40fda21c8390.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098891, '行尸走肉', '2', '敌方单位在死亡时生成大量的被感染的人类，具体数量由死亡单位的生命值决定。', '06296f9a-5bf0-4d91-8b5c-f57e543d0c5b.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098892, '暗无天日', '2', '先前探索过的区域若离开了玩家的视野范围将会重新变成一片黑色。', '2fe64464-6b9e-425b-aa36-69dd4b269b33.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098893, '速度狂魔', '2', '敌方单位移动速度提高。', '3f038ee7-6642-43b3-8b13-2ebdb5638798.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098894, '晶矿护盾', '2', '玩家基地中的晶体矿簇会被周期性包覆一层护盾，必须将其摧毁才能继续采集资源。', '9907ac29-d575-4e7d-bf43-c7661a9519e9.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098895, '减伤屏障', '2', '敌方单位和建筑在第一次受到伤害时会获得一个临时护盾。', 'ed7e754a-1e56-452e-8dc2-d8e993e84492.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098896, '焦土政策', '2', '敌方单位死亡时会点燃地面。', '38b36988-8ed0-4eca-a902-7dda2363aa10.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098897, '异形寄生', '2', '所有敌方单位在死亡时会孵化巢虫。', '3aa42b09-6e2b-4b28-9838-3afb91baba6a.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098898, '激光钻机', '2', '一台敌方激光钻机会不停地攻击位于敌人视野范围内的玩家单位。', 'bef55dbc-abf5-4db6-8645-e7d595e6d879.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098899, '超远视距', '2', '敌方单位和建筑的武器射程与视野范围提高。', 'a967c80a-2747-46b3-b08c-131745aa867a.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098900, '龙卷风暴', '2', '多股龙卷风在地图上移动，对位于其行进路线上的玩家单位造成伤害并将其击退。', '7775bacc-bddb-4d1c-8e1f-a5631fceafed.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098901, '净化光束', '2', '地图上会出现一道敌人的净化光束并朝附近的玩家单位移动。', 'af042327-617b-434e-8e0e-1e81c2f85da5.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098902, '鼓舞人心', '2', '敌方英雄单位提高小范围内所有敌人的攻击速度和护甲。', '835aae56-5727-4c7e-96b4-f7a9b5da0369.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001599098903, '坚强意志', '2', '敌方英雄单位附近有任何非英雄敌方单位时，其所受到的伤害最高不超过10点。', 'a66a62cf-ee44-4df8-a1f6-7d49be596989.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819137, '默哀', '2', '敌方英雄单位死亡时，在其周围的所有玩家单位都会反思自己的过错，无法攻击或使用技能。', '25945535-a79f-48e3-8183-9f460f1761ed.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819138, '丧尸大战', '3', '敌方被感染的人类会不断地出现在地图上。', 'bac2cef1-175a-4e40-bbeb-598cc14d4964.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819139, '岩浆爆发', '3', '岩浆会周期性地在随机位置从地下喷发，并对玩家的空中和地面单位造成伤害。', '0c94e549-5a0d-4f7c-b378-8ffe81946980.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819140, '自毁程序', '3', '敌方单位死亡时发生爆炸，并对附近的玩家单位造成伤害。', '84664384-73a0-4052-b56a-39c994c3fe53.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819141, '进攻部署', '3', '周期性地将额外的敌方单位部署到战场上。', '21bd9f64-aeda-46f6-a055-1d98c205e15b.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819142, '来去无踪', '3', '所有敌方单位永久隐形。', 'c42f8ca5-d6b3-453b-b1f7-736b22301c79.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819143, '无边恐惧', '3', '玩家的单位在受到伤害时会不时地停止攻击，并且害怕地到处乱跑。', 'dbe02214-3520-4ca3-a13c-60acc754e29d.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819144, '核弹打击', '3', '核弹会随机在整张地图上进行发射。', 'f68f275b-1346-4e64-ac7b-51d1343016b1.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819145, '飞弹大战', '3', '你的建筑会不停地遭受飞弹轰炸的袭击，你必须将它们击落。', '18a5905f-6d31-43bc-a737-544d2dc78e63.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819146, '伤害散射', '3', '对敌人造成的伤害将平摊给所有附近的单位，包括你的单位。', '16bf44bc-649a-4f6c-a314-67206a856800.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819147, '双重压力', '3', '你的单位也会受到他们自身造成的所有伤害，但是会持续恢复。', '2b1fce4b-1099-4eae-a07d-09ab28e9f029.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819148, '致命勾引', '3', '敌方单位或建筑被摧毁后，你附近的任何单位将被牵拉至被它们的位置。', '43b7263f-6260-4969-a4b1-04b7d283bbaf.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819149, '强磁雷场', '4', '麦格天雷会在任务一开始布满整个地图。', '15b06e83-753b-4466-a75c-b6dd773d4043.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819150, '暴风雪', '4', '风暴雷云在地图上飘荡，对位于其行进路线上的玩家单位造成伤害并将其冻结。', '3a1d1faf-7b11-4522-9af5-40800f263b83.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819151, '复仇战士', '5', '当附近的敌方单位死亡时，敌方单位的攻击速度、移动速度、护甲、生命值以及生命回复速度提高。', 'a26b6c0c-798c-44a1-87b1-40818ea29dd8.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819152, '相互摧毁', '5', '敌方混合体死亡时会引爆一发核弹。', 'c2e280cc-c6e6-4ee3-96db-6cb634a83f54.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819153, '小捞油水', '5', '玩家的工人单位采集资源的效率降低，但是地图上会生成可以拾取的资源。', '06a6e4f0-bcdc-4f53-9b9f-2e9b3203faf2.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819154, '虚空重生者', '5', '虚空重生者游荡在战场上，不断地复活你的敌人。', 'f5fabc2d-fef5-433b-ae92-8f3296b79bbd.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819155, '灵能爆表', '5', '所有敌方单位拥有能量并且使用随机技能。', '208f8ffc-de4d-4930-9818-164f6ed3b10c.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819156, '拿钱说话', '5', '对你的单位发出指令会消耗资源，数量取决于该单位的生产价格。', 'cdc681a4-fcdf-44f8-bbb7-608e739b5b7e.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819157, '扫雷专家', '6', '数量庞大的寡妇雷和蜘蛛雷遍布整个战场。', '907d5363-d78b-4634-a56b-dc8022ef53bd.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819158, '杀戮机器人', '6', '来源不明的进攻性机器人已被释放到了科普卢星区，意图制造毁灭。经过用心险恶的工程改造后，它们在达到预先设定的击杀数量之前都是无敌的存在。只有在那之后，它们才能被阻止。不过，你能撑到最后吗？', '0941635d-1915-472b-a9da-ac7ac5ed9b28.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819159, '给我死吧', '7', '敌方单位死亡后会自动复活。', 'c744f035-a1b0-447e-be28-e4563cf22232.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819160, '极性不定', '7', '每一个敌方单位不是对你的单位免疫，就是对你盟友的单位免疫。', '9324b5b0-3b39-4b97-b90d-39d39af6d022.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819161, '力量蜕变', '7', '敌方单位造成伤害时有一定几率变形成更强大的单位。', '1b628a5f-fffb-44a8-abf2-83772ae041aa.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819162, '黑死病', '7', '一些敌方单位携带着一种疫病，不仅会持续造成伤害，还会传染给附近的其它单位。此类敌人被消灭时，他们会把这种疫病传染给你的单位。', '2322d2b1-f604-463a-a736-b9f5b4bfd858.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819163, '同化体', '8', '无形的软泥怪缓慢爬向你的基地，被其接触到的任何单位和建筑都将变成和它们一样的复制体。', 'e22c952d-05ed-4fe3-abea-5c4ed7159085.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819164, '虚空裂隙', '10', '虚空裂隙周期性地出现在随机位置，并会不断地生成敌方单位，直至其被摧毁。', '5956b7e2-f51e-4317-b7b5-2bfc2c1b4c04.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819165, '风暴英雄', '10', '每一轮攻击波次都会由实力越来越强的英雄率领。', '47bfc0ed-0b1e-4e36-91ba-a06b15bc199d.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819166, '上班偷睡', '0', '玩家的工人单位会周期性地陷入沉睡，必须使用命令面板上的“苏醒”技能才能将其唤醒。', 'f8eb2315-af2b-48f2-b36f-aad51e3d3e9d.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819167, '石像狂热者', '0', '敌人已部署石像狂热者。', '65401f43-007c-4c0f-8054-c28236ac9e12.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819168, '混乱工作室', '0', '突变因子会随机选择，并且在任务中周期性轮换。', '820e978e-bad4-4b55-b51e-a5154dd4913d.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819169, '迷失方向', '0', '你的镜头会随机改变位置。', '13d14544-0a43-4de6-95e5-0419acfc5f0a.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819170, '不死邪魔', '0', '有只怪物缠上你了，而且你杀它的次数越多，你下一次遇到的它越强大。', '7b107928-413c-4f18-94a6-13397ecd8143.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819171, '惧怕黑暗', '0', '通过各种方式提供的视野都会受到极大的限制，只有你镜头中的视野一切正常。', '04b46a3c-a1bc-4062-a1c3-1d1f59b4e0c1.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819172, '不给糖果就捣蛋', '0', '平民们会拜访你的糖果碗寻找零食，这些零食是通过花费晶体矿产生的。如果没有零食可以享用，平民们就会变身成随机的敌方单位。', '51a14cec-12cf-45dd-a309-efebf3a4b602.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819173, '捕杀火鸡', '0', '补给只能通过击杀火鸡产生，它们在整个地图上漫游。这么做可能会激怒其它的火鸡。', '891bef53-b2e0-4b1d-8c56-8a6234ad9605.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819174, '补给共享', '0', '你和你的搭档共享补给，双方的部队单位会占用你们共有的补给。', 'fb155906-7988-4f40-8770-4509fe963837.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819175, '礼尚往来', '0', '地图上会周期性地放置一些礼物。你们不抢就会便宜了埃蒙哟！', '738035ed-32c9-4afa-8fc6-65553a35bd5f.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819176, '杀生业报', '0', '玩家的单位和建筑每消灭一个敌人，其所受到的伤害就会提高。', '4481ad71-10ff-4d4b-a297-73b43a63adb0.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819177, '极度谨慎', '0', '你的单位不会接受你在他们看不见的地方所下达的任何命令。', '4e1b0e91-7785-4e88-9f80-d4a0430daf5a.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819178, '刺头兵', '0', '你的单位不会准确地执行命令。', 'b21960c6-9fc8-4324-a0a4-e28e36233579.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819179, '焰火秀', '0', '敌人死亡时会发射灿烂的烟花，对你周围的单位造成伤害。', '5966de7c-9b7e-4b7a-be4a-452cd2e5ca72.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819180, '幸运红包', '0', '塞满物资的节日红包，被随机丢弃在地图的各个角落。', '10e0faec-fbb2-491b-98bf-63b2b15c81ef.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819181, '消极战斗', '0', '你的单位先加速，然后再减速。', '896666cc-b6ba-47c6-9f2a-9f16cccab663.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO `tb_plugin_sc2_factor` VALUES (1582333001657819182, '炸弹机器人', '0', '对一切都毫不在意的机器人携带着聚变弹头朝你的基地进发。一名玩家必须识别出拆弹的顺序，另一名玩家则必须正确输入才能解除危机。', 'cadd1323-1286-46a7-a24b-04863d61949e.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');

-- ----------------------------
-- Table structure for tb_plugin_sc2_mutation
-- ----------------------------
DROP TABLE IF EXISTS `tb_plugin_sc2_mutation`;
CREATE TABLE `tb_plugin_sc2_mutation`  (
  `row_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '突变名',
  `factor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '因子',
  `map` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地图',
  `score` int(0) NOT NULL COMMENT '因子分数',
  `level` int(0) NOT NULL COMMENT '对应等级(+1)',
  `is_delete` tinyint(1) NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
  `create_user` bigint(0) NOT NULL COMMENT '创建用户',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_user` bigint(0) NOT NULL COMMENT '更新用户',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`row_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 240 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'sc2 突变' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_plugin_sc2_mutation
-- ----------------------------
INSERT INTO `tb_plugin_sc2_mutation` VALUES (1, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (2, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (3, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (4, '恶劣天气', '虚空裂隙,龙卷风暴', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (5, '雪茫危机', '暴风雪,小捞油水', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (6, '战场炼狱', '焦土政策,岩浆爆发,闪避机动', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (7, '痛苦神庙', '晶矿护盾,减伤屏障,复仇战士', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (8, '末日之矛', '轨道轰炸,时空力场,净化光束', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (9, '特别快递', '进攻部署,自毁程序,异形寄生', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (10, '城市巷战', '光子过载,扫雷专家,来去无踪', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (11, '灾难之轮', '混乱工作室', '虚空撕裂', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (12, '完美风暴', '暴风雪,龙卷风暴,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (13, '全面核战', '核弹打击,自毁程序,无边恐惧', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (14, '黑暗仪式', '灵能爆表,速度狂魔', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (15, '完全失控', '拿钱说话,暗无天日,时间扭曲', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (16, '燃烧军团', '焦土政策,虚空裂隙,复仇战士', '天界封锁', 17, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (17, '三重威胁', '激光钻机,轨道轰炸,丧尸大战', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (18, '烈焰战场', '飞弹大战,核弹打击,净化光束', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (19, '失心疯', '迷失方向,无边恐惧,闪避机动', '升格之链', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (20, '威胁递增', '力量蜕变,相互摧毁,异形寄生', '机会渺茫', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (21, '资源危机', '强磁雷场,无边恐惧,小捞油水', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (22, '外交豁免', '极性不定,闪避机动,减伤屏障', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (23, '灾难之轮', '混乱工作室', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (24, '造恶之息', '速度狂魔,进攻部署,复仇战士', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (25, '惊魂之夜', '惧怕黑暗,不给糖果就捣蛋', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (26, '玩火自焚', '行尸走肉,异形寄生,焦土政策', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (27, '天轰地爆', '核弹打击,相互摧毁,自毁程序', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (28, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (29, '能量超负', '灵能爆表,超远视距,光子过载', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (30, '拉克希尔大乱斗', '丧尸大战,速度狂魔,给我死吧', '升格之链', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (31, '适者生存', '减伤屏障,力量蜕变', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (32, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (33, '丛林激斗', '来去无踪,进攻部署,时空力场', '机会渺茫', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (34, '终极代价', '拿钱说话,晶矿护盾,飞弹大战', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (35, '火葬仪式', '虚空重生者,焦土政策', '营救矿工', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (36, '高举盾牌！', '伤害散射,晶矿护盾,短视症', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (37, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (38, '死疫横生', '黑死病,拿钱说话', '机会渺茫', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (39, '旧忆重惊', '强行征用,相互摧毁', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (40, '星门异动', '虚空裂隙,灵能爆表', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (41, '灾难之轮', '混乱工作室', '熔火危机', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (42, '强行霸占', '飞弹大战,强行征用,激光钻机', '克哈裂痕', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (43, '死亡危机', '虚空重生者,行尸走肉,力量蜕变', '往日神庙', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (44, '黑暗时刻', '风暴英雄,坚强意志,鼓舞人心', '克哈裂痕', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (45, '没钱麻烦大了', '小捞油水,自毁程序,龙卷风暴', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (46, '雷鸣弹啸', '极性不定,扫雷专家', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (47, '杀机讯发', '玩家对战', '背叛平原', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (48, '疫鬼狂潮', '速度狂魔,黑死病', '亡者之夜', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (49, '隐形威胁', '来去无踪,净化光束', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (50, '灾难之轮', '混乱工作室', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (51, '噬骨之寒', '强磁雷场,暴风雪', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (52, '无间死局', '复仇战士,虚空重生者', '升格之链', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (53, '火线快递', '给我死吧,核弹打击,减伤屏障', '虚空降临', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (54, '烈火金刚', '致命勾引,自毁程序,行尸走肉', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (55, '寒冷即是虚空', '暴风雪,虚空重生者,虚空裂隙', '湮灭快车', 19, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (56, '异形进击', '同化体,时空力场,震荡攻击', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (57, '硬骨头', '坚强意志,极性不定,减伤屏障', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (58, '疫区逃生', '暗无天日,光子过载,黑死病', '营救矿工', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (59, '步步为营', '时间扭曲,速度狂魔,震荡攻击', '机会渺茫', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (60, '现世现报', '双重压力,相互摧毁,自毁程序', '升格之链', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (61, '仁至义尽', '给我死吧,超远视距,鼓舞人心', '往日神庙', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (62, '飞蛾扑火', '致命勾引,净化光束,异形寄生', '克哈裂痕', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (63, '火海惊魂', '虚空裂隙,无边恐惧', '熔火危机', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (64, '灾难之轮', '混乱工作室', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (65, '机器人大战', '杀戮机器人,默哀', '机会渺茫', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (66, '磁性牵引', '强磁雷场,致命勾引,来去无踪', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (67, '地发杀机', '焦土政策,岩浆爆发,扫雷专家', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (68, '天发杀机', '进攻部署,飞弹大战,轨道轰炸', '虚空降临', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (69, '兵贵神速', '速度狂魔,同化体', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (70, '自作自受', '相互摧毁,双重压力', '黑暗杀星', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (71, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (72, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (73, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (74, '恶劣天气', '虚空裂隙,龙卷风暴', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (75, '雪茫危机', '暴风雪,小捞油水', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (76, '战场炼狱', '焦土政策,岩浆爆发,闪避机动', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (77, '痛苦神庙', '晶矿护盾,减伤屏障,复仇战士', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (78, '末日之矛', '轨道轰炸,时空力场,净化光束', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (79, '特别快递', '进攻部署,自毁程序,异形寄生', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (80, '城市巷战', '光子过载,扫雷专家,来去无踪', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (81, '灾难之轮', '混乱工作室', '虚空撕裂', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (82, '完美风暴', '暴风雪,龙卷风暴,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (83, '全面核战', '核弹打击,自毁程序,无边恐惧', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (84, '黑暗仪式', '灵能爆表,速度狂魔', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (85, '完全失控', '拿钱说话,暗无天日,时间扭曲', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (86, '燃烧军团', '焦土政策,虚空裂隙,复仇战士', '天界封锁', 17, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (87, '三重威胁', '激光钻机,轨道轰炸,丧尸大战', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (88, '烈焰战场', '飞弹大战,核弹打击,净化光束', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (89, '失心疯', '迷失方向,无边恐惧,闪避机动', '升格之链', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (90, '威胁递增', '力量蜕变,相互摧毁,异形寄生', '机会渺茫', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (91, '资源危机', '强磁雷场,无边恐惧,小捞油水', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (92, '外交豁免', '极性不定,闪避机动,减伤屏障', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (93, '灾难之轮', '混乱工作室', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (94, '造恶之息', '速度狂魔,进攻部署,复仇战士', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (95, '惊魂之夜', '惧怕黑暗,不给糖果就捣蛋', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (96, '玩火自焚', '行尸走肉,异形寄生,焦土政策', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (97, '天轰地爆', '核弹打击,相互摧毁,自毁程序', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (98, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (99, '能量超负', '灵能爆表,超远视距,光子过载', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (100, '拉克希尔大乱斗', '丧尸大战,速度狂魔,给我死吧', '升格之链', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (101, '适者生存', '减伤屏障,力量蜕变', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (102, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (103, '丛林激斗', '来去无踪,进攻部署,时空力场', '机会渺茫', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (104, '终极代价', '拿钱说话,晶矿护盾,飞弹大战', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (105, '火葬仪式', '虚空重生者,焦土政策', '营救矿工', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (106, '高举盾牌！', '伤害散射,晶矿护盾,短视症', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (107, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (108, '死疫横生', '黑死病,拿钱说话', '机会渺茫', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (109, '旧忆重惊', '强行征用,相互摧毁', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (110, '星门异动', '虚空裂隙,灵能爆表', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (111, '灾难之轮', '混乱工作室', '熔火危机', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (112, '强行霸占', '飞弹大战,强行征用,激光钻机', '克哈裂痕', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (113, '死亡危机', '虚空重生者,行尸走肉,力量蜕变', '往日神庙', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (114, '黑暗时刻', '风暴英雄,坚强意志,鼓舞人心', '克哈裂痕', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (115, '没钱麻烦大了', '小捞油水,自毁程序,龙卷风暴', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (116, '雷鸣弹啸', '极性不定,扫雷专家', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (117, '疫鬼狂潮', '速度狂魔,黑死病', '亡者之夜', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (118, '隐形威胁', '来去无踪,净化光束', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (119, '灾难之轮', '混乱工作室', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (120, '封禁行为', '灵能爆表,闪避机动', '净网行动', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (121, '午夜大师', '生命吸取,短视症,无边恐惧', '聚铁成兵', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (122, '雷场夜战', '惧怕黑暗,强磁雷场', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (123, '极限压迫', '强行征用,晶矿护盾,自毁程序', '亡者之夜', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (124, '杀劫迫临', '杀戮机器人,速度狂魔,鼓舞人心', '往日神庙', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (125, '时空气象战', '龙卷风暴,岩浆爆发,时间扭曲', '黑暗杀星', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (126, '死亡无声', '同化体,默哀', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (127, '无尽感染', '黑死病,行尸走肉,异形寄生', '虚空降临', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (128, '顽强作战', '飞弹大战,鼓舞人心,坚强意志', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (129, '灾难之轮', '混乱工作室', '死亡摇篮', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (130, '寒冷适应', '暴风雪,力量蜕变', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (131, '惊魂之夜', '惧怕黑暗,不给糖果就捣乱', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (132, '进步的代价', '杀戮机器人,拿钱说话', '净网行动', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (133, '消极增员', '致命勾引,复仇战士', '聚铁成兵', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (134, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (135, '报应不爽', '虚空裂隙,双重压力', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (136, '灰烬重生', '自毁程序,虚空重生者,岩浆爆发', '黑暗杀星', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (137, '扭曲空间', '时空力场,时间扭曲,龙卷风暴', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (138, '训练有素', '鼓舞人心,进攻部署,复仇战士', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (139, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (140, '末日报告', '同化体,核弹打击,轨道轰炸', '熔火危机', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (141, '安全违规', '自毁程序,激光钻机,强磁雷场', '营救矿工', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (142, '重生神殿', '给我死吧,减伤屏障,生命吸取', '往日神庙', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (143, '疯狂超频', '速度狂魔,复仇战士,光子过载', '净网行动', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (144, '消耗战', '伤害散射,扫雷专家', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (145, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (146, '永不分离', '极性不定,给我死吧', '升格之链', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (147, '死亡鬼影', '来去无踪,虚空重生者', '聚铁成兵', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (148, '远距威胁', '超远视距,时间扭曲,净化光束', '亡者之夜', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (149, '辐射区', '核弹打击,丧尸大战,黑死病', '克哈裂痕', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (150, '心灵力量', '异形寄生,灵能爆表', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (151, '调遣军费', '拿钱说话,焦土政策', '死亡摇篮', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (152, '梦魇敌酋', '风暴英雄,默哀', '虚空降临', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (153, '基地翻转', '飞弹大战,净化光束,强行征用', '机会渺茫', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (154, '防火墙', '岩浆爆发,扫雷专家,减伤屏障', '净网行动', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (155, '死亡税金', '拿钱说话,小捞油水,黑死病', '亡者之夜', 17, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (156, '灾难之轮', '混乱工作室', '营救矿工', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (157, '感痛身受', '双重压力,伤害散射,时空力场', '虚空降临', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (158, '地狱列车', '给我死吧,焦土政策', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (159, '感染危机', '异形寄生,丧尸大战,自毁程序', '净网行动', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (160, '机会尽出', '速度狂魔,减伤屏障,灵能爆表', '机会渺茫', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (161, '一将千军', '坚强意志,鼓舞人心,力量蜕变', '往日神庙', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (162, '实验巨炮', '激光钻机,光子过载,超远视距', '聚铁成兵', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (163, '核族入侵', '相互摧毁,丧尸大战,坚强意志', '升格之链', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (164, '同归于尽', '极性不定,给我死吧', '黑暗杀星', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (165, '烈火营救', '强行征用,焦土政策,复仇战士', '营救矿工', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (166, '复仇者集结', '风暴英雄,复仇战士', '往日神庙', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (167, '铁轨换线', '给我死吧,极性不定', '湮灭快车', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (168, '敌对领地', '减伤屏障,光子过载,灵能爆表', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (169, '媒体抹黑', '暗无天日,飞弹大战,来去无踪', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (170, '雷霆穹顶', '风暴英雄,强磁雷场', '天界封锁', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (171, '躲灾避祸', '暗无天日,核弹打击,轨道轰炸', '黑暗杀星', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (172, '二元选择', '极性不定,虚空重生者', '净网行动', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (173, '升格蜕变', '鼓舞人心,力量蜕变', '升格之链', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (174, '森严壁垒', '减伤屏障,核弹打击,光子过载', '死亡摇篮', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (175, '双重麻烦', '杀戮机器人,同化体', '虚空降临', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (176, '星沉地裂', '进攻部署,虚空裂隙', '聚铁成兵', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (177, '赶夜车', '惧怕黑暗,短视症,速度狂魔', '湮灭快车', 3, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (178, '恐惧神庙', '惧怕黑暗,异形寄生,无边恐惧', '往日神庙', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (179, '光炫神迷', '震荡攻击,激光钻机,净化光束', '机会渺茫', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (180, '无尽花火', '异形寄生,自毁程序', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (181, '坟场夜班', '惧怕黑暗,净化光束', '亡者之夜', 2, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (182, '机器重生', '无边恐惧,给我死吧,激光钻机', '聚铁成兵', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (183, '秘密突击', '进攻部署,龙卷风暴,来去无踪', '天界封锁', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (184, '暗地破坏', '扫雷专家,虚空裂隙', '克哈裂痕', 16, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (185, '散光', '超远视距,短视症,来去无踪', '净网行动', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (186, '永不言死', '减伤屏障,给我死吧,生命吸取', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (187, '中世纪', '黑死病,力量蜕变', '黑暗杀星', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (188, '全力猛攻', '进攻部署,丧尸大战,虚空重生者', '亡者之夜', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (189, '等价交换', '伤害散射,给我死吧', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (190, '迫近的疯狂', '强行征用,净化光束,虚空裂隙', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (191, '感恩季', '暴风雪,礼尚往来,杀生业报', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (192, '决择抉择', '坚强意志,鼓舞人心,相互摧毁', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (193, '过度反应', '复仇战士,灵能爆表', '黑暗杀星', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (194, '火焰净化', '核弹打击,岩浆爆发,焦土政策', '湮灭快车', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (195, '极速增援', '时空力场,虚空裂隙', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (196, '盲目进贡', '杀戮机器人,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (197, '进击壁垒', '减伤屏障,晶矿护盾,给我死吧', '天界封锁', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (198, '虫人海啸', '异形寄生,飞弹大战,丧尸大战', '死亡摇篮', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (199, '心有灵犀', '极性不定,补给共享', '熔火危机', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (200, '夜半敲门', '复仇战士,同化体', '亡者之夜', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (201, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (202, '舞舞生疯', '默哀,速度狂魔,力量蜕变', '机会渺茫', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (203, '痛苦列车', '双重压力,核弹打击,相互摧毁', '湮灭快车', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (204, '刚硬裂隙', '给我死吧,虚空裂隙', '克哈裂痕', 17, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (205, '爆炸之链', '岩浆爆发,行尸走肉', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (206, '噩梦重临', '复仇战士,强行征用,给我死吧', '往日神庙', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (207, '排爆行动', '扫雷专家,小捞油水', '聚铁成兵', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (208, '缴税日', '无边恐惧,拿钱说话', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (209, '侵袭强征', '同化体,速度狂魔,来去无踪', '净网行动', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (210, '坟场拾荒', '丧尸大战,小捞油水', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (211, '虚空召唤', '虚空重生者,虚空裂隙', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (212, '因爱之名', '震荡攻击,净化光束,时间扭曲', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (213, '锁定击发', '杀戮机器人,晶矿护盾,时空力场', '天界封锁', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (214, '雷劫难逃', '强磁雷场,扫雷专家,飞弹大战', '营救矿工', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (215, '恶棍联盟', '闪避机动,风暴英雄', '熔火危机', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (216, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (217, '合作无间', '极性不定,同化体', '天界封锁', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (218, '冰火之歌', '暴风雪,岩浆爆发,焦土政策', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (219, '吸血鬼生活', '暗无天日,短视症,来去无踪', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (220, '硬件故障', '杀戮机器人,激光钻机,扫雷专家', '净网行动', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (221, '分担痛苦', '伤害散射,致命勾引', '聚铁成兵', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (222, '漫漫长夜', '给我死吧,超远视距,光子过载', '亡者之夜', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (223, '迅捷亡尸', '速度狂魔,虚空重生者', '黑暗杀星', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (224, '征战十年', '焰火秀,幸运红包,礼尚往来', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (225, '泡泡世界', '减伤屏障,晶矿护盾,时间扭曲', '死亡摇篮', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (226, '协同防御', '飞弹大战,极性不定', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (227, '饥不择食', '强磁雷场,扫雷专家,小捞油水', '天界封锁', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (228, '我的机器人！', '炸弹机器人,杀戮机器人', '机会渺茫', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (229, '多线操作训练', '拿钱说话,虚空裂隙', '净网行动', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (230, '老友重聚', '黑死病,暗无天日,默哀', '黑暗杀星', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (231, '万众一心', '炸弹机器人,极性不定,补给共享', '克哈裂痕', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (232, '发射升空', '核弹打击,岩浆爆发,灵能爆表', '虚空降临', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (233, '进入时空枢纽', '暴风雪,风暴英雄', '死亡摇篮', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (234, '死亡转瞬即逝', '给我死吧,虚空重生者', '亡者之夜', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (235, '批量生产', '同化体,虚空裂隙', '聚铁成兵', 18, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (236, '小心手雷', '炸弹机器人,飞弹大战', '营救矿工', 3, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (237, '亡者列车', '丧尸大战,暗无天日', '行尸走肉', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (238, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO `tb_plugin_sc2_mutation` VALUES (239, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');

SET FOREIGN_KEY_CHECKS = 1;
