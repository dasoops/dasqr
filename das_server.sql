/*
 Navicat Premium Data Transfer

 Source Server         : 106.13.5.29_3308
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 106.13.5.29:3308
 Source Schema         : das_server

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 25/01/2023 11:22:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_core_config
-- ----------------------------
DROP TABLE IF EXISTS `tb_core_config`;
CREATE TABLE `tb_core_config`
(
    `row_id`      INT(0)                                                            NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `keyword`     VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '配置项关键词',
    `value`       VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '配置项属性值',
    `can_edit`    TINYINT(1)                                                        NOT NULL COMMENT '是否支持web端修改(0:false;1:true)',
    `description` VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '配置描述',
    `is_delete`   TINYINT(1)                                                        NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
    `create_user` BIGINT(0)                                                         NOT NULL COMMENT '创建用户',
    `create_time` DATETIME(0)                                                       NOT NULL COMMENT '创建时间',
    `update_user` BIGINT(0)                                                         NOT NULL COMMENT '更新用户',
    `update_time` DATETIME(0)                                                       NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`row_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 31
  CHARACTER SET = `utf8mb4`
  COLLATE = `utf8mb4_0900_ai_ci` COMMENT = '配置表,储存配置信息,如:version,mutation等'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_core_config
-- ----------------------------
INSERT INTO
    `tb_core_config`
VALUES
    (1, 'cloudVersion', '142', 0, '版本', 0, 776465218, '2022-11-01 08:12:41', 776465218, '2022-11-01 08:12:38');
INSERT INTO
    `tb_core_config`
VALUES
    (2, 'localVersion', '140', 0, '本地运行版本', 0, 776465218, '2022-11-07 12:51:00', 776465218,
     '2022-11-07 12:51:02');
INSERT INTO
    `tb_core_config`
VALUES
    (3, 'defaultStyle', 'cool', 1, '默认风格', 0, 776465218, '2022-11-01 08:12:41', 776465218, '2022-12-30 15:32:48');
INSERT INTO
    `tb_core_config`
VALUES
    (4, 'defaultUserLevel', '5', 1, '默认权限等级', 0, 776465218, '2022-12-27 11:25:27', 776465218,
     '2022-12-30 15:23:55');
INSERT INTO
    `tb_core_config`
VALUES
    (5, 'defaultGroupLevel', '9', 1, '群组默认权限等级', 0, 776465218, '2022-12-27 13:55:12', 776465218,
     '2022-12-30 15:32:50');
INSERT INTO
    `tb_core_config`
VALUES
    (6, 'loginNeedMinLevel', '3', 1, '登录webManager所需的最低level', 0, 776465218, '2022-12-29 16:50:21', 776465218,
     '2022-12-30 15:32:33');
INSERT INTO
    `tb_core_config`
VALUES
    (7, 'signerKey', 'dasqServer', 1, '令牌签名密钥', 0, 776465218, '2022-12-30 16:45:47', 776465218,
     '2022-12-30 17:32:27');
INSERT INTO
    `tb_core_config`
VALUES
    (8, 'tokenEffectiveSeconds', '360000', 1, '令牌有效时间(秒)', 0, 776465218, '2022-12-30 16:46:11', 776465218,
     '2022-12-30 17:46:28');
INSERT INTO
    `tb_core_config`
VALUES
    (9, 'rollRecordEffectiveSeconds', '300', 1, '(plugin-loaj) roll点redis记录有效时间(秒)', 0, 776465218,
     '2023-01-08 17:30:18', 776465218, '2023-01-08 17:30:18');
INSERT INTO
    `tb_core_config`
VALUES
    (10, 'rollNiggerScore', '20', 1, '(plugin-roll) roll点触发黑鬼嘲讽分数(逻辑为<=)', 0, 776465218,
     '2023-01-09 09:52:57',
     776465218, '2023-01-09 09:52:57');
INSERT INTO
    `tb_core_config`
VALUES
    (11, 'alasNoticeType', '3', 1, 'alas通知类型(0:none;1:私聊;2:群组;3:群at用户)', 0, 776465218, '2023-01-11 11:06:49',
     776465218, '2023-01-11 11:28:22');
INSERT INTO
    `tb_core_config`
VALUES
    (12, 'alasNoticeGroup', '673745932', 1, 'alas通知群组', 0, 776465218, '2023-01-11 11:08:43', 776465218,
     '2023-01-11 11:08:43');
INSERT INTO
    `tb_core_config`
VALUES
    (13, 'alasNoticeUser', '776465218', 1, 'alas通知用户', 0, 776465218, '2023-01-11 11:08:58', 776465218,
     '2023-01-11 11:08:58');
INSERT INTO
    `tb_core_config`
VALUES
    (14, 'gitNoticeType', '2', 1, 'git通知类型(0:none;1:私聊;2:群组;3:群at用户)', 0, 776465218, '2023-01-11 14:32:08',
     776465218, '2023-01-11 14:33:27');
INSERT INTO
    `tb_core_config`
VALUES
    (15, 'gitNoticeGroup', '673745932', 1, 'git通知群组', 0, 776465218, '2023-01-11 14:32:52', 776465218,
     '2023-01-11 14:32:52');
INSERT INTO
    `tb_core_config`
VALUES
    (16, 'gitNoticeUser', '776465218', 1, 'git通知用户', 0, 776465218, '2023-01-11 14:33:16', 776465218,
     '2023-01-11 14:33:16');
INSERT INTO
    `tb_core_config`
VALUES
    (17, 'gitNoticeRefs', 'all', 1, 'git提醒分支', 0, 776465218, '2023-01-11 14:34:24', 776465218,
     '2023-01-11 14:34:24');
INSERT INTO
    `tb_core_config`
VALUES
    (18, 'gitRebootNoticeRefs', 'refactor,web-release,webManager-vue', 1, 'git重启提醒,更新版本分支', 0, 776465218,
     '2023-01-11 14:35:34', 776465218, '2023-01-11 14:35:34');
INSERT INTO
    `tb_core_config`
VALUES
    (19, 'gitNoticeXSelfId', '776465218,3488521150,2426867682', 1, 'git提醒发送botId', 0, 776465218,
     '2023-01-11 14:39:32', 776465218, '2023-01-11 14:39:32');
INSERT INTO
    `tb_core_config`
VALUES
    (20, 'quietBoot', '0', 1, '(plugin-reboot) 静默启动', 0, 776465218, '2023-01-13 08:39:14', 776465218,
     '2023-01-13 08:39:14');
INSERT INTO
    `tb_core_config`
VALUES
    (21, 'quietReboot', '0', 1, '(plugin-reboot) 静默重启', 0, 776465218, '2023-01-13 08:39:33', 776465218,
     '2023-01-13 08:39:33');
INSERT INTO
    `tb_core_config`
VALUES
    (22, 'serverMode', '0', 1, '服务模式(0:prod;1:dev)', 0, 776465218, '2023-01-19 13:56:32', 776465218,
     '2023-01-19 13:56:32');
INSERT INTO
    `tb_core_config`
VALUES
    (23, 'repeatReadCount', '3', 1, '(plugin-loaj) 复读触发所需消息条数', 0, 776465218, '2023-01-19 15:53:32',
     776465218,
     '2023-01-19 15:53:32');
INSERT INTO
    `tb_core_config`
VALUES
    (24, 'fastFailImageUrl', 'http://106.13.5.29:9000/dasqserver/980d4eaa-a536-4f4c-b160-7e8a13f3ce04.jpg', 1,
     'pluginResult快速失败图片', 0, 776465218, '2023-01-20 10:19:15', 776465218, '2023-01-20 10:23:21');
INSERT INTO
    `tb_core_config`
VALUES
    (25, 'scheduleNoticeGroup', '673745932', 1, '定时任务异常通知群组', 1, 776465218, '2023-01-20 13:10:53', 776465218,
     '2023-01-20 13:10:53');
INSERT INTO
    `tb_core_config`
VALUES
    (26, 'starCraft2MutationRecord', '168', 1, '(plugin-starCraft2) 本周突变rowId', 0, 776465218, '2023-01-20 19:35:04',
     776465218, '2023-01-20 19:35:48');
INSERT INTO
    `tb_core_config`
VALUES
    (27, 'apiRequestBaseUrl', 'https://api.lolicon.app/setu/v2', 1, '(plugin-setu) setuApi请求地址', 0, 776465218,
     '2023-01-22 17:17:04', 776465218, '2023-01-22 18:07:54');
INSERT INTO
    `tb_core_config`
VALUES
    (28, 'imageProxyBaseUrl', 'proxy.pixivel.moe', 1, '(plugin-setu) image代理url', 0, 776465218,
     '2023-01-22 17:17:41', 776465218, '2023-01-22 17:17:41');
INSERT INTO
    `tb_core_config`
VALUES
    (29, 'excludedAi', 'false', 1, '(plugin-setu) 是否屏蔽ai(boolean)', 0, 776465218, '2023-01-22 17:18:11', 776465218,
     '2023-01-22 17:18:19');
INSERT INTO
    `tb_core_config`
VALUES
    (30, 'defaultR18', '2', 1, '(plugin-setu) 默认r18;0为非R18,1:R18,2:混合', 0, 776465218, '2023-01-22 21:50:28',
     776465218, '2023-01-22 21:51:02');
INSERT INTO
    `tb_core_config`
VALUES
    (31, 'webSocketUrl', '/ws/shell', 1, '(plugin-sys-shell) shell连接地址', 0, 776465218, '2023-01-24 19:07:57',
     776465218, '2023-01-24 19:07:59');
INSERT INTO
    `tb_core_config`
VALUES
    (32, 'shellConfig',
     '{\"type\":\"group\",\"groupId\":\"673745932\",\"userId\":\"776465218\",\"selfId\":\"2426867682\"}', 1,
     '(plugin-sys-shell) shell配置', 0, 776465218, '2023-01-24 19:08:26', 776465218, '2023-01-24 19:08:24');
INSERT INTO
    `tb_core_config`
VALUES
    (33, 'pixivArtWorksUrl', 'https://www.pixiv.net/artworks/', 1, 'pixiv画廊url', 0, 776465218, '2023-01-24 21:23:12',
     776465218, '2023-01-24 21:23:12');
INSERT INTO
    `tb_core_config`
VALUES
    (34, 'proxyArtWorksUrl', 'https://pixivel.moe/illust/', 1, '代理画廊url', 0, 776465218, '2023-01-24 21:23:57',
     776465218, '2023-01-24 21:23:57');

-- ----------------------------
-- Table structure for tb_core_plugin
-- ----------------------------
DROP TABLE IF EXISTS `tb_core_plugin`;
CREATE TABLE `tb_core_plugin`
(
    `row_id`      INT(0)                                                            NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`        VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '名称',
    `class_path`  VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '全类名',
    `order`       INT(0)                                                            NOT NULL COMMENT '排序',
    `level`       TINYINT(1)                                                        NOT NULL COMMENT '权限等级',
    `description` VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '描述',
    `enable`      TINYINT(1)                                                        NOT NULL COMMENT '是否启用',
    `is_delete`   TINYINT(1)                                                        NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
    `create_user` BIGINT(0)                                                         NOT NULL COMMENT '创建用户',
    `create_time` DATETIME(0)                                                       NOT NULL COMMENT '创建时间',
    `update_user` BIGINT(0)                                                         NOT NULL COMMENT '更新用户',
    `update_time` DATETIME(0)                                                       NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`row_id`) USING BTREE,
    INDEX `INDEX_ORDOR` (`order`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 23
  CHARACTER SET = `utf8mb4`
  COLLATE = `utf8mb4_0900_ai_ci` COMMENT = '插件表,储存插件注册信息,权限,描述,启用状态等'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_core_plugin
-- ----------------------------
INSERT INTO
    `tb_core_plugin`
VALUES
    (1, 'template', 'com.dasoops.dasserver.core.TemplatePlugin', 0, 4, '模板插件', 0, 0, -1, '2022-11-02 15:23:56',
     776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (2, 'messageLog', 'com.dasoops.dasserver.plugin.log.plugin.MessageLogPlugin', 1, 4, '日志插件', 1, 0, -1,
     '2022-11-03 17:15:48', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (3, 'roll', 'com.dasoops.dasserver.plugin.loaj.plugin.RollPlugin', 9, 4, 'ROLL点插件', 1, 0, -1,
     '2022-11-04 17:38:28', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (4, 'Image', 'com.dasoops.dasserver.plugin.image.plugin.ImagePlugin', 10, 4, '存图取图插件', 1, 0, -1,
     '2022-11-08 10:17:26', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (5, 'error', 'com.dasoops.dasserver.plugin.exceptionwrapper.plugin.GetErrorPlugin', 5, 4, '异常信息插件', 1, 0, -1,
     '2022-11-10 14:56:35', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (6, 'throwException', 'com.dasoops.dasserver.plugin.exceptionwrapper.ThrowExceptionPlugin', 50, 4, '测试异常插件',
     1,
     1, -1, '2022-11-10 15:38:20', 776465218, '2023-01-17 11:44:31');
INSERT INTO
    `tb_core_plugin`
VALUES
    (7, 'getPlugin', 'com.dasoops.dasserver.plugin.pluginwrapper.plugin.GetPluginPlugin', 11, 2, '获取插件列表插件', 1,
     0,
     -1, '2022-11-10 15:57:21', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (8, 'addPlugin', 'com.dasoops.dasserver.plugin.pluginwrapper.plugin.AddPluginPlugin', 12, 2, '添加插件', 1, 0, -1,
     '2022-11-10 15:57:21', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (9, 'reply', 'com.dasoops.dasserver.plugin.loaj.plugin.ReplyPlugin', 14, 4, '回复插件', 1, 0, 776465218,
     '2023-01-09 14:37:23', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (10, 'setu', 'com.dasoops.dasserver.plugin.setu.plugin.SetuPlugin', 6, 4, '涩图插件', 1, 0, 776465218,
     '2023-01-22 17:16:10', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (11, 'StarCraftPlugin', 'com.dasoops.dasserver.plugin.starcraft2.plugin.StarCraftPlugin', 8, 4, '星际相关插件', 1,
     0,
     776465218, '2023-01-20 20:19:37', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (12, 'repeatRead', 'com.dasoops.dasserver.plugin.loaj.plugin.RepeatReadPlugin', 4, 4, '复读插件', 1, 0, 776465218,
     '2023-01-19 15:52:00', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (13, 'addReply', 'com.dasoops.dasserver.plugin.loaj.plugin.AddReplyPlugin', 13, 4, '添加回复插件', 1, 0, 776465218,
     '2023-01-09 17:14:36', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (14, 'reboot', 'com.dasoops.dasserver.plugin.reboot.plugin.RebootPlugin', 15, 2, '重启插件', 1, 0, 776465218,
     '2023-01-09 18:05:51', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (15, 'sleep', 'com.dasoops.dasserver.plugin.sleep.plugin.SleepPlugin', 16, 2, '静默插件', 1, 0, 776465218,
     '2023-01-10 10:33:25', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (16, 'checkSleep', 'com.dasoops.dasserver.plugin.sleep.plugin.CheckSleepPlugin', 3, 4, '静默检查插件', 1, 0,
     776465218,
     '2023-01-10 11:49:30', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (17, 'unSleep', 'com.dasoops.dasserver.plugin.sleep.plugin.UnSleepPlugin', 2, 4, '解除静默插件', 1, 0, 776465218,
     '2023-01-10 13:06:23', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (18, 'echo', 'com.dasoops.dasserver.plugin.echo.plugin.EchoPlugin', 17, 4, 'echo插件', 1, 0, 776465218,
     '2023-01-11 15:44:45', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (19, 'getError', 'com.dasoops.dasserver.plugin.exceptionwrapper.plugin.GetErrorPlugin', 85, 4, '获取error插件', 1,
     1,
     776465218, '2023-01-17 11:24:42', 776465218, '2023-01-17 11:30:55');
INSERT INTO
    `tb_core_plugin`
VALUES
    (20, 'throwException', 'com.dasoops.dasserver.plugin.exceptionwrapper.plugin.ThrowExceptionPlugin', 18, 2,
     '测试异常插件', 0, 0, 776465218, '2023-01-17 11:44:23', 776465218, '2023-01-24 13:14:40');
INSERT INTO
    `tb_core_plugin`
VALUES
    (21, 'exec', 'com.dasoops.dasserver.plugin.exec.plugin.ExecPlugin', 19, 2, 'exec执行插件', 1, 0, 776465218,
     '2023-01-19 15:51:36', 776465218, '2023-01-24 13:11:32');
INSERT INTO
    `tb_core_plugin`
VALUES
    (22, 'mutationRecord', 'com.dasoops.dasserver.plugin.starcraft2.plugin.MutationRecordPlugin', 7, 2,
     '因子记录操作插件',
     1, 0, 776465218, '2023-01-20 20:19:19', 776465218, '2023-01-24 13:11:32');

-- ----------------------------
-- Table structure for tb_core_register
-- ----------------------------
DROP TABLE IF EXISTS `tb_core_register`;
CREATE TABLE `tb_core_register`
(
    `row_id`      INT(0)      NOT NULL AUTO_INCREMENT COMMENT 'id',
    `register_id` BIGINT(0)   NOT NULL COMMENT '用户/群组id',
    `type`        TINYINT(1)  NOT NULL COMMENT '类型(0:user;1:group)',
    `level`       TINYINT(1)  NOT NULL COMMENT '默认权限等级\r\n>= pluginLevel 的将在插件首次注册时获取执行权限\r\n(0:sys;1:dasoops;2:dev;4:user;5:default;8:zxy;9:none)\r\n注:默认权限等级应只影响添加新插件时生成的权限',
    `is_delete`   TINYINT(1)  NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
    `create_user` BIGINT(0)   NOT NULL COMMENT '创建用户',
    `create_time` DATETIME(0) NOT NULL COMMENT '创建时间',
    `update_user` BIGINT(0)   NOT NULL COMMENT '更新用户',
    `update_time` DATETIME(0) NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`row_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 65
  CHARACTER SET = `utf8mb4`
  COLLATE = `utf8mb4_0900_ai_ci` COMMENT = '注册表,储存用户注册信息,初始权限,群组注册信息,每个用户/群组对应一条记录'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_core_register
-- ----------------------------
INSERT INTO
    `tb_core_register`
VALUES
    (1, 776465218, 0, 1, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO
    `tb_core_register`
VALUES
    (2, 943952775, 0, 3, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO
    `tb_core_register`
VALUES
    (3, 1318847648, 0, 4, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO
    `tb_core_register`
VALUES
    (4, 1422291466, 0, 4, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO
    `tb_core_register`
VALUES
    (5, 2426867682, 0, 4, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO
    `tb_core_register`
VALUES
    (6, 673745932, 1, 1, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO
    `tb_core_register`
VALUES
    (7, 601372611, 0, 4, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO
    `tb_core_register`
VALUES
    (8, 1006646003, 0, 4, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO
    `tb_core_register`
VALUES
    (9, 1743114170, 0, 2, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO
    `tb_core_register`
VALUES
    (10, 3488521150, 0, 4, 0, -1, '2022-12-28 09:30:35', -1, '2022-12-28 09:30:35');
INSERT INTO
    `tb_core_register`
VALUES
    (11, 66600000, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (12, 376598769, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (13, 815497799, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (14, 1685771220, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (15, 2268166258, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (16, 3281222021, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (17, 373987681, 1, 9, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (18, 872813288, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (19, 1582045623, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (20, 2290931956, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (21, 2898095501, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (22, 2943705862, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (23, 3119857328, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (24, 3308869364, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (25, 653936565, 1, 9, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (26, 191033190, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (27, 281537087, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (28, 295152096, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (29, 309457912, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (30, 398484535, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (31, 402775819, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (32, 451865073, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (33, 478147322, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (34, 499295639, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (35, 507832919, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (36, 524347450, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (37, 640597074, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (38, 648655736, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (39, 690727110, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (40, 786240179, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (41, 792015423, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (42, 822836583, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (43, 850720747, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (44, 873255119, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (45, 972110453, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (46, 980505442, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (47, 1004418300, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (48, 1029618990, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (49, 1064235805, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (50, 1069881532, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (51, 1251172835, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (52, 1277988762, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (53, 1316999601, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (54, 1577178035, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (55, 1713245586, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (56, 2178643083, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (57, 2324975940, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (58, 2409516721, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (59, 2425755708, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (60, 2452420890, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (61, 2683750855, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (62, 2945655156, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (63, 3228904545, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');
INSERT INTO
    `tb_core_register`
VALUES
    (64, 3528491944, 0, 5, 0, -1, '2023-01-02 17:54:40', -1, '2023-01-02 17:54:40');

-- ----------------------------
-- Table structure for tb_core_register_mtm_plugin
-- ----------------------------
DROP TABLE IF EXISTS `tb_core_register_mtm_plugin`;
CREATE TABLE `tb_core_register_mtm_plugin`
(
    `row_id`          INT(0)      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `plugin_id`       INT(0)      NOT NULL COMMENT '插件主键id',
    `register_row_id` BIGINT(0)   NOT NULL COMMENT '注册表主键id',
    `is_pass`         INT(0)      NOT NULL COMMENT '是否放行(0:否,拦截;1:是,放行)',
    `is_delete`       TINYINT(1)  NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
    `create_user`     BIGINT(0)   NOT NULL COMMENT '创建用户',
    `create_time`     DATETIME(0) NOT NULL COMMENT '创建时间',
    `update_user`     BIGINT(0)   NOT NULL COMMENT '更新用户',
    `update_time`     DATETIME(0) NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`row_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3106
  CHARACTER SET = `utf8mb4`
  COLLATE = `utf8mb4_0900_ai_ci` COMMENT = '注册用户 与 插件 多对多关联表\r\n每个用户都应有每个插件的权限关联记录\r\n此表将为控制用户插件权限的最终表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_core_register_mtm_plugin
-- ----------------------------
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1617, 1, 1, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1618, 2, 1, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1619, 3, 1, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1620, 4, 1, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1621, 5, 1, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1622, 6, 1, 1, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1623, 7, 1, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1624, 8, 1, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1625, 1, 2, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1626, 2, 2, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1627, 3, 2, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1628, 4, 2, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1629, 5, 2, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1630, 6, 2, 1, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1631, 7, 2, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1632, 8, 2, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1633, 1, 3, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1634, 2, 3, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1635, 3, 3, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1636, 4, 3, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1637, 5, 3, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1638, 6, 3, 1, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1639, 7, 3, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1640, 8, 3, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1641, 1, 4, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1642, 2, 4, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1643, 3, 4, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1644, 4, 4, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1645, 5, 4, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1646, 6, 4, 1, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1647, 7, 4, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1648, 8, 4, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1649, 1, 5, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1650, 2, 5, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1651, 3, 5, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1652, 4, 5, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1653, 5, 5, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1654, 6, 5, 1, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1655, 7, 5, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1656, 8, 5, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1665, 1, 7, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1666, 2, 7, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1667, 3, 7, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1668, 4, 7, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1669, 5, 7, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1670, 6, 7, 1, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1671, 7, 7, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1672, 8, 7, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1673, 1, 8, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1674, 2, 8, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1675, 3, 8, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1676, 4, 8, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1677, 5, 8, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1678, 6, 8, 1, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1679, 7, 8, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1680, 8, 8, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1681, 1, 9, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1682, 2, 9, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1683, 3, 9, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1684, 4, 9, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1685, 5, 9, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1686, 6, 9, 1, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1687, 7, 9, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1688, 8, 9, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1689, 1, 10, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1690, 2, 10, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1691, 3, 10, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1692, 4, 10, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1693, 5, 10, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1694, 6, 10, 1, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1695, 7, 10, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1696, 8, 10, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1697, 1, 11, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1698, 2, 11, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1699, 3, 11, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1700, 4, 11, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1701, 5, 11, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1702, 6, 11, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1703, 7, 11, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1704, 8, 11, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1705, 1, 12, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1706, 2, 12, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1707, 3, 12, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1708, 4, 12, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1709, 5, 12, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1710, 6, 12, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1711, 7, 12, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1712, 8, 12, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1713, 1, 13, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1714, 2, 13, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1715, 3, 13, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1716, 4, 13, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1717, 5, 13, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1718, 6, 13, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1719, 7, 13, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1720, 8, 13, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1721, 1, 14, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1722, 2, 14, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1723, 3, 14, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1724, 4, 14, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1725, 5, 14, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1726, 6, 14, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1727, 7, 14, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1728, 8, 14, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1729, 1, 15, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1730, 2, 15, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1731, 3, 15, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1732, 4, 15, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1733, 5, 15, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1734, 6, 15, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1735, 7, 15, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1736, 8, 15, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1737, 1, 16, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1738, 2, 16, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1739, 3, 16, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1740, 4, 16, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1741, 5, 16, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1742, 6, 16, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1743, 7, 16, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1744, 8, 16, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1745, 1, 17, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1746, 2, 17, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1747, 3, 17, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1748, 4, 17, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1749, 5, 17, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1750, 6, 17, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1751, 7, 17, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1752, 8, 17, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1753, 1, 18, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1754, 2, 18, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1755, 3, 18, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1756, 4, 18, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1757, 5, 18, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1758, 6, 18, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1759, 7, 18, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1760, 8, 18, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1761, 1, 19, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1762, 2, 19, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1763, 3, 19, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1764, 4, 19, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1765, 5, 19, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1766, 6, 19, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1767, 7, 19, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1768, 8, 19, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1769, 1, 20, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1770, 2, 20, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1771, 3, 20, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1772, 4, 20, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1773, 5, 20, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1774, 6, 20, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1775, 7, 20, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1776, 8, 20, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1777, 1, 21, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1778, 2, 21, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1779, 3, 21, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1780, 4, 21, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1781, 5, 21, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1782, 6, 21, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1783, 7, 21, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1784, 8, 21, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1785, 1, 22, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1786, 2, 22, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1787, 3, 22, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1788, 4, 22, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1789, 5, 22, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1790, 6, 22, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1791, 7, 22, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1792, 8, 22, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1793, 1, 23, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1794, 2, 23, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1795, 3, 23, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1796, 4, 23, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1797, 5, 23, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1798, 6, 23, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1799, 7, 23, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1800, 8, 23, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1801, 1, 24, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1802, 2, 24, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1803, 3, 24, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1804, 4, 24, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1805, 5, 24, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1806, 6, 24, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1807, 7, 24, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1808, 8, 24, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1809, 1, 25, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1810, 2, 25, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1811, 3, 25, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1812, 4, 25, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1813, 5, 25, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1814, 6, 25, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1815, 7, 25, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1816, 8, 25, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1817, 1, 26, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1818, 2, 26, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1819, 3, 26, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1820, 4, 26, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1821, 5, 26, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1822, 6, 26, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1823, 7, 26, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1824, 8, 26, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1825, 1, 27, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1826, 2, 27, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1827, 3, 27, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1828, 4, 27, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1829, 5, 27, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1830, 6, 27, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1831, 7, 27, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1832, 8, 27, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1833, 1, 28, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1834, 2, 28, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1835, 3, 28, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1836, 4, 28, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1837, 5, 28, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1838, 6, 28, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1839, 7, 28, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1840, 8, 28, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1841, 1, 29, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1842, 2, 29, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1843, 3, 29, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1844, 4, 29, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1845, 5, 29, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1846, 6, 29, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1847, 7, 29, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1848, 8, 29, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1849, 1, 30, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1850, 2, 30, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1851, 3, 30, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1852, 4, 30, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1853, 5, 30, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1854, 6, 30, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1855, 7, 30, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1856, 8, 30, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1857, 1, 31, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1858, 2, 31, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1859, 3, 31, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1860, 4, 31, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1861, 5, 31, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1862, 6, 31, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1863, 7, 31, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1864, 8, 31, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1865, 1, 32, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1866, 2, 32, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1867, 3, 32, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1868, 4, 32, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1869, 5, 32, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1870, 6, 32, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1871, 7, 32, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1872, 8, 32, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1873, 1, 33, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1874, 2, 33, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1875, 3, 33, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1876, 4, 33, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1877, 5, 33, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1878, 6, 33, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1879, 7, 33, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1880, 8, 33, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1881, 1, 34, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1882, 2, 34, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1883, 3, 34, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1884, 4, 34, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1885, 5, 34, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1886, 6, 34, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1887, 7, 34, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1888, 8, 34, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1889, 1, 35, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1890, 2, 35, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1891, 3, 35, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1892, 4, 35, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1893, 5, 35, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1894, 6, 35, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1895, 7, 35, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1896, 8, 35, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1897, 1, 36, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1898, 2, 36, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1899, 3, 36, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1900, 4, 36, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1901, 5, 36, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1902, 6, 36, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1903, 7, 36, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1904, 8, 36, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1905, 1, 37, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1906, 2, 37, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1907, 3, 37, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1908, 4, 37, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1909, 5, 37, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1910, 6, 37, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1911, 7, 37, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1912, 8, 37, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1913, 1, 38, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1914, 2, 38, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1915, 3, 38, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1916, 4, 38, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1917, 5, 38, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1918, 6, 38, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1919, 7, 38, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1920, 8, 38, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1921, 1, 39, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1922, 2, 39, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1923, 3, 39, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1924, 4, 39, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1925, 5, 39, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1926, 6, 39, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1927, 7, 39, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1928, 8, 39, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1929, 1, 40, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1930, 2, 40, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1931, 3, 40, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1932, 4, 40, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1933, 5, 40, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1934, 6, 40, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1935, 7, 40, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1936, 8, 40, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1937, 1, 41, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1938, 2, 41, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1939, 3, 41, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1940, 4, 41, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1941, 5, 41, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1942, 6, 41, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1943, 7, 41, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1944, 8, 41, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1945, 1, 42, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1946, 2, 42, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1947, 3, 42, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1948, 4, 42, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1949, 5, 42, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1950, 6, 42, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1951, 7, 42, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1952, 8, 42, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1953, 1, 43, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1954, 2, 43, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1955, 3, 43, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1956, 4, 43, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1957, 5, 43, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1958, 6, 43, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1959, 7, 43, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1960, 8, 43, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1961, 1, 44, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1962, 2, 44, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1963, 3, 44, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1964, 4, 44, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1965, 5, 44, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1966, 6, 44, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1967, 7, 44, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1968, 8, 44, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1969, 1, 45, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1970, 2, 45, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1971, 3, 45, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1972, 4, 45, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1973, 5, 45, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1974, 6, 45, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1975, 7, 45, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1976, 8, 45, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1977, 1, 46, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1978, 2, 46, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1979, 3, 46, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1980, 4, 46, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1981, 5, 46, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1982, 6, 46, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1983, 7, 46, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1984, 8, 46, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1985, 1, 47, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1986, 2, 47, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1987, 3, 47, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1988, 4, 47, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1989, 5, 47, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1990, 6, 47, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1991, 7, 47, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1992, 8, 47, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1993, 1, 48, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1994, 2, 48, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1995, 3, 48, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1996, 4, 48, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1997, 5, 48, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1998, 6, 48, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (1999, 7, 48, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2000, 8, 48, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2001, 1, 49, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2002, 2, 49, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2003, 3, 49, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2004, 4, 49, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2005, 5, 49, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2006, 6, 49, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2007, 7, 49, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2008, 8, 49, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2009, 1, 50, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2010, 2, 50, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2011, 3, 50, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2012, 4, 50, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2013, 5, 50, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2014, 6, 50, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2015, 7, 50, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2016, 8, 50, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2017, 1, 51, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2018, 2, 51, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2019, 3, 51, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2020, 4, 51, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2021, 5, 51, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2022, 6, 51, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2023, 7, 51, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2024, 8, 51, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2025, 1, 52, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2026, 2, 52, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2027, 3, 52, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2028, 4, 52, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2029, 5, 52, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2030, 6, 52, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2031, 7, 52, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2032, 8, 52, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2033, 1, 53, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2034, 2, 53, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2035, 3, 53, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2036, 4, 53, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2037, 5, 53, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2038, 6, 53, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2039, 7, 53, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2040, 8, 53, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2041, 1, 54, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2042, 2, 54, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2043, 3, 54, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2044, 4, 54, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2045, 5, 54, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2046, 6, 54, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2047, 7, 54, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2048, 8, 54, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2049, 1, 55, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2050, 2, 55, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2051, 3, 55, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2052, 4, 55, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2053, 5, 55, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2054, 6, 55, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2055, 7, 55, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2056, 8, 55, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2057, 1, 56, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2058, 2, 56, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2059, 3, 56, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2060, 4, 56, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2061, 5, 56, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2062, 6, 56, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2063, 7, 56, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2064, 8, 56, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2065, 1, 57, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2066, 2, 57, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2067, 3, 57, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2068, 4, 57, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2069, 5, 57, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2070, 6, 57, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2071, 7, 57, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2072, 8, 57, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2073, 1, 58, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2074, 2, 58, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2075, 3, 58, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2076, 4, 58, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2077, 5, 58, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2078, 6, 58, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2079, 7, 58, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2080, 8, 58, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2081, 1, 59, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2082, 2, 59, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2083, 3, 59, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2084, 4, 59, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2085, 5, 59, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2086, 6, 59, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2087, 7, 59, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2088, 8, 59, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2089, 1, 60, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2090, 2, 60, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2091, 3, 60, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2092, 4, 60, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2093, 5, 60, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2094, 6, 60, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2095, 7, 60, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2096, 8, 60, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2097, 1, 61, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2098, 2, 61, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2099, 3, 61, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2100, 4, 61, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2101, 5, 61, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2102, 6, 61, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2103, 7, 61, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2104, 8, 61, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2105, 1, 62, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2106, 2, 62, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2107, 3, 62, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2108, 4, 62, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2109, 5, 62, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2110, 6, 62, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2111, 7, 62, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2112, 8, 62, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2113, 1, 63, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2114, 2, 63, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2115, 3, 63, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2116, 4, 63, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2117, 5, 63, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2118, 6, 63, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2119, 7, 63, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2120, 8, 63, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2121, 1, 64, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2122, 2, 64, 1, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2123, 3, 64, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2124, 4, 64, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2125, 5, 64, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2126, 6, 64, 0, 1, -1, '2023-01-08 20:32:59', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2127, 7, 64, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2128, 8, 64, 0, 0, -1, '2023-01-08 20:32:59', -1, '2023-01-08 20:32:59');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2129, 9, 1, 1, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2130, 10, 1, 1, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2131, 9, 2, 1, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2132, 10, 2, 1, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2133, 9, 3, 1, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2134, 10, 3, 1, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2135, 9, 4, 1, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2136, 10, 4, 1, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2137, 9, 5, 1, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2138, 10, 5, 1, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2141, 9, 7, 1, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2142, 10, 7, 1, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2143, 9, 8, 1, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2144, 10, 8, 1, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2145, 9, 9, 1, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2146, 10, 9, 1, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2147, 9, 10, 1, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2148, 10, 10, 1, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2149, 9, 11, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2150, 10, 11, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2151, 9, 12, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2152, 10, 12, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2153, 9, 13, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2154, 10, 13, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2155, 9, 14, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2156, 10, 14, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2157, 9, 15, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2158, 10, 15, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2159, 9, 16, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2160, 10, 16, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2161, 9, 17, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2162, 10, 17, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2163, 9, 18, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2164, 10, 18, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2165, 9, 19, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2166, 10, 19, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2167, 9, 20, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2168, 10, 20, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2169, 9, 21, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2170, 10, 21, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2171, 9, 22, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2172, 10, 22, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2173, 9, 23, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2174, 10, 23, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2175, 9, 24, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2176, 10, 24, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2177, 9, 25, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2178, 10, 25, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2179, 9, 26, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2180, 10, 26, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2181, 9, 27, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2182, 10, 27, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2183, 9, 28, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2184, 10, 28, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2185, 9, 29, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2186, 10, 29, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2187, 9, 30, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2188, 10, 30, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2189, 9, 31, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2190, 10, 31, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2191, 9, 32, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2192, 10, 32, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2193, 9, 33, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2194, 10, 33, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2195, 9, 34, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2196, 10, 34, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2197, 9, 35, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2198, 10, 35, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2199, 9, 36, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2200, 10, 36, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2201, 9, 37, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2202, 10, 37, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2203, 9, 38, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2204, 10, 38, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2205, 9, 39, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2206, 10, 39, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2207, 9, 40, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2208, 10, 40, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2209, 9, 41, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2210, 10, 41, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2211, 9, 42, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2212, 10, 42, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2213, 9, 43, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2214, 10, 43, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2215, 9, 44, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2216, 10, 44, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2217, 9, 45, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2218, 10, 45, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2219, 9, 46, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2220, 10, 46, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2221, 9, 47, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2222, 10, 47, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2223, 9, 48, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2224, 10, 48, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2225, 9, 49, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2226, 10, 49, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2227, 9, 50, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2228, 10, 50, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2229, 9, 51, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2230, 10, 51, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2231, 9, 52, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2232, 10, 52, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2233, 9, 53, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2234, 10, 53, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2235, 9, 54, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2236, 10, 54, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2237, 9, 55, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2238, 10, 55, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2239, 9, 56, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2240, 10, 56, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2241, 9, 57, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2242, 10, 57, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2243, 9, 58, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2244, 10, 58, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2245, 9, 59, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2246, 10, 59, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2247, 9, 60, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2248, 10, 60, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2249, 9, 61, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2250, 10, 61, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2251, 9, 62, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2252, 10, 62, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2253, 9, 63, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2254, 10, 63, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2255, 9, 64, 0, 0, -1, '2023-01-09 17:26:34', -1, '2023-01-09 17:26:34');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2256, 10, 64, 0, 1, -1, '2023-01-09 17:26:34', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2257, 11, 1, 1, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2258, 11, 2, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2259, 11, 3, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2260, 11, 4, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2261, 11, 5, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2263, 11, 7, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2264, 11, 8, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2265, 11, 9, 1, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2266, 11, 10, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2267, 11, 11, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2268, 11, 12, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2269, 11, 13, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2270, 11, 14, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2271, 11, 15, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2272, 11, 16, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2273, 11, 17, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2274, 11, 18, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2275, 11, 19, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2276, 11, 20, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2277, 11, 21, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2278, 11, 22, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2279, 11, 23, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2280, 11, 24, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2281, 11, 25, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2282, 11, 26, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2283, 11, 27, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2284, 11, 28, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2285, 11, 29, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2286, 11, 30, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2287, 11, 31, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2288, 11, 32, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2289, 11, 33, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2290, 11, 34, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2291, 11, 35, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2292, 11, 36, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2293, 11, 37, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2294, 11, 38, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2295, 11, 39, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2296, 11, 40, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2297, 11, 41, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2298, 11, 42, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2299, 11, 43, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2300, 11, 44, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2301, 11, 45, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2302, 11, 46, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2303, 11, 47, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2304, 11, 48, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2305, 11, 49, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2306, 11, 50, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2307, 11, 51, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2308, 11, 52, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2309, 11, 53, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2310, 11, 54, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2311, 11, 55, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2312, 11, 56, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2313, 11, 57, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2314, 11, 58, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2315, 11, 59, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2316, 11, 60, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2317, 11, 61, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2318, 11, 62, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2319, 11, 63, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2320, 11, 64, 0, 1, -1, '2023-01-09 19:53:24', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2321, 14, 1, 1, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2322, 14, 2, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2323, 14, 3, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2324, 14, 4, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2325, 14, 5, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2327, 14, 7, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2328, 14, 8, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2329, 14, 9, 1, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2330, 14, 10, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2331, 14, 11, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2332, 14, 12, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2333, 14, 13, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2334, 14, 14, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2335, 14, 15, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2336, 14, 16, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2337, 14, 17, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2338, 14, 18, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2339, 14, 19, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2340, 14, 20, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2341, 14, 21, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2342, 14, 22, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2343, 14, 23, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2344, 14, 24, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2345, 14, 25, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2346, 14, 26, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2347, 14, 27, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2348, 14, 28, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2349, 14, 29, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2350, 14, 30, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2351, 14, 31, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2352, 14, 32, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2353, 14, 33, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2354, 14, 34, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2355, 14, 35, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2356, 14, 36, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2357, 14, 37, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2358, 14, 38, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2359, 14, 39, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2360, 14, 40, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2361, 14, 41, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2362, 14, 42, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2363, 14, 43, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2364, 14, 44, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2365, 14, 45, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2366, 14, 46, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2367, 14, 47, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2368, 14, 48, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2369, 14, 49, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2370, 14, 50, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2371, 14, 51, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2372, 14, 52, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2373, 14, 53, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2374, 14, 54, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2375, 14, 55, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2376, 14, 56, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2377, 14, 57, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2378, 14, 58, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2379, 14, 59, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2380, 14, 60, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2381, 14, 61, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2382, 14, 62, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2383, 14, 63, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2384, 14, 64, 0, 0, 776465218, '2023-01-10 10:33:25', 776465218, '2023-01-10 10:33:25');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2385, 15, 1, 1, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2386, 15, 2, 1, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2387, 15, 3, 1, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2388, 15, 4, 1, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2389, 15, 5, 1, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2391, 15, 7, 1, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2392, 15, 8, 1, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2393, 15, 9, 1, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2394, 15, 10, 1, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2395, 15, 11, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2396, 15, 12, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2397, 15, 13, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2398, 15, 14, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2399, 15, 15, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2400, 15, 16, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2401, 15, 17, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2402, 15, 18, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2403, 15, 19, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2404, 15, 20, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2405, 15, 21, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2406, 15, 22, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2407, 15, 23, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2408, 15, 24, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2409, 15, 25, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2410, 15, 26, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2411, 15, 27, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2412, 15, 28, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2413, 15, 29, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2414, 15, 30, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2415, 15, 31, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2416, 15, 32, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2417, 15, 33, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2418, 15, 34, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2419, 15, 35, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2420, 15, 36, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2421, 15, 37, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2422, 15, 38, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2423, 15, 39, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2424, 15, 40, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2425, 15, 41, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2426, 15, 42, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2427, 15, 43, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2428, 15, 44, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2429, 15, 45, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2430, 15, 46, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2431, 15, 47, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2432, 15, 48, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2433, 15, 49, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2434, 15, 50, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2435, 15, 51, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2436, 15, 52, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2437, 15, 53, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2438, 15, 54, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2439, 15, 55, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2440, 15, 56, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2441, 15, 57, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2442, 15, 58, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2443, 15, 59, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2444, 15, 60, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2445, 15, 61, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2446, 15, 62, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2447, 15, 63, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2448, 15, 64, 0, 0, 776465218, '2023-01-10 11:49:30', 776465218, '2023-01-10 11:49:30');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2449, 16, 1, 1, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2450, 16, 2, 1, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2451, 16, 3, 1, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2452, 16, 4, 1, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2453, 16, 5, 1, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2455, 16, 7, 1, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2456, 16, 8, 1, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2457, 16, 9, 1, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2458, 16, 10, 1, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2459, 16, 11, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2460, 16, 12, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2461, 16, 13, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2462, 16, 14, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2463, 16, 15, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2464, 16, 16, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2465, 16, 17, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2466, 16, 18, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2467, 16, 19, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2468, 16, 20, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2469, 16, 21, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2470, 16, 22, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2471, 16, 23, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2472, 16, 24, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2473, 16, 25, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2474, 16, 26, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2475, 16, 27, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2476, 16, 28, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2477, 16, 29, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2478, 16, 30, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2479, 16, 31, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2480, 16, 32, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2481, 16, 33, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2482, 16, 34, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2483, 16, 35, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2484, 16, 36, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2485, 16, 37, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2486, 16, 38, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2487, 16, 39, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2488, 16, 40, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2489, 16, 41, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2490, 16, 42, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2491, 16, 43, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2492, 16, 44, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2493, 16, 45, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2494, 16, 46, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2495, 16, 47, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2496, 16, 48, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2497, 16, 49, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2498, 16, 50, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2499, 16, 51, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2500, 16, 52, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2501, 16, 53, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2502, 16, 54, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2503, 16, 55, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2504, 16, 56, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2505, 16, 57, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2506, 16, 58, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2507, 16, 59, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2508, 16, 60, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2509, 16, 61, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2510, 16, 62, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2511, 16, 63, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2512, 16, 64, 0, 0, 776465218, '2023-01-10 13:06:23', 776465218, '2023-01-10 13:06:23');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2513, 13, 1, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2514, 17, 1, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2515, 13, 2, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2516, 17, 2, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2517, 13, 3, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2518, 17, 3, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2519, 13, 4, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2520, 17, 4, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2521, 13, 5, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2522, 17, 5, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2525, 13, 7, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2526, 17, 7, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2527, 13, 8, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2528, 17, 8, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2529, 13, 9, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2530, 17, 9, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2531, 13, 10, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2532, 17, 10, 1, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2533, 13, 11, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2534, 17, 11, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2535, 13, 12, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2536, 17, 12, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2537, 13, 13, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2538, 17, 13, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2539, 13, 14, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2540, 17, 14, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2541, 13, 15, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2542, 17, 15, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2543, 13, 16, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2544, 17, 16, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2545, 13, 17, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2546, 17, 17, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2547, 13, 18, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2548, 17, 18, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2549, 13, 19, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2550, 17, 19, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2551, 13, 20, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2552, 17, 20, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2553, 13, 21, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2554, 17, 21, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2555, 13, 22, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2556, 17, 22, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2557, 13, 23, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2558, 17, 23, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2559, 13, 24, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2560, 17, 24, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2561, 13, 25, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2562, 17, 25, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2563, 13, 26, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2564, 17, 26, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2565, 13, 27, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2566, 17, 27, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2567, 13, 28, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2568, 17, 28, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2569, 13, 29, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2570, 17, 29, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2571, 13, 30, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2572, 17, 30, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2573, 13, 31, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2574, 17, 31, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2575, 13, 32, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2576, 17, 32, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2577, 13, 33, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2578, 17, 33, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2579, 13, 34, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2580, 17, 34, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2581, 13, 35, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2582, 17, 35, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2583, 13, 36, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2584, 17, 36, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2585, 13, 37, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2586, 17, 37, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2587, 13, 38, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2588, 17, 38, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2589, 13, 39, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2590, 17, 39, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2591, 13, 40, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2592, 17, 40, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2593, 13, 41, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2594, 17, 41, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2595, 13, 42, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2596, 17, 42, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2597, 13, 43, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2598, 17, 43, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2599, 13, 44, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2600, 17, 44, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2601, 13, 45, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2602, 17, 45, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2603, 13, 46, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2604, 17, 46, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2605, 13, 47, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2606, 17, 47, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2607, 13, 48, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2608, 17, 48, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2609, 13, 49, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2610, 17, 49, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2611, 13, 50, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2612, 17, 50, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2613, 13, 51, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2614, 17, 51, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2615, 13, 52, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2616, 17, 52, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2617, 13, 53, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2618, 17, 53, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2619, 13, 54, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2620, 17, 54, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2621, 13, 55, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2622, 17, 55, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2623, 13, 56, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2624, 17, 56, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2625, 13, 57, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2626, 17, 57, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2627, 13, 58, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2628, 17, 58, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2629, 13, 59, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2630, 17, 59, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2631, 13, 60, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2632, 17, 60, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2633, 13, 61, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2634, 17, 61, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2635, 13, 62, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2636, 17, 62, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2637, 13, 63, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2638, 17, 63, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2639, 13, 64, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2640, 17, 64, 0, 0, -1, '2023-01-10 19:34:04', -1, '2023-01-10 19:34:04');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2641, 18, 1, 1, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2642, 18, 2, 1, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2643, 18, 3, 1, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2644, 18, 4, 1, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2645, 18, 5, 1, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2647, 18, 7, 1, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2648, 18, 8, 1, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2649, 18, 9, 1, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2650, 18, 10, 1, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2651, 18, 11, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2652, 18, 12, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2653, 18, 13, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2654, 18, 14, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2655, 18, 15, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2656, 18, 16, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2657, 18, 17, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2658, 18, 18, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2659, 18, 19, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2660, 18, 20, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2661, 18, 21, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2662, 18, 22, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2663, 18, 23, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2664, 18, 24, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2665, 18, 25, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2666, 18, 26, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2667, 18, 27, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2668, 18, 28, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2669, 18, 29, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2670, 18, 30, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2671, 18, 31, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2672, 18, 32, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2673, 18, 33, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2674, 18, 34, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2675, 18, 35, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2676, 18, 36, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2677, 18, 37, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2678, 18, 38, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2679, 18, 39, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2680, 18, 40, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2681, 18, 41, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2682, 18, 42, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2683, 18, 43, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2684, 18, 44, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2685, 18, 45, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2686, 18, 46, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2687, 18, 47, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2688, 18, 48, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2689, 18, 49, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2690, 18, 50, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2691, 18, 51, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2692, 18, 52, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2693, 18, 53, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2694, 18, 54, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2695, 18, 55, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2696, 18, 56, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2697, 18, 57, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2698, 18, 58, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2699, 18, 59, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2700, 18, 60, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2701, 18, 61, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2702, 18, 62, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2703, 18, 63, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2704, 18, 64, 0, 0, -1, '2023-01-11 17:53:29', -1, '2023-01-11 17:53:29');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2705, 20, 1, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2706, 20, 2, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2707, 20, 3, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2708, 20, 4, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2709, 20, 5, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2711, 20, 7, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2712, 20, 8, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2713, 20, 9, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2714, 20, 10, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2715, 20, 11, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2716, 20, 12, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2717, 20, 13, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2718, 20, 14, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2719, 20, 15, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2720, 20, 16, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2721, 20, 17, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2722, 20, 18, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2723, 20, 19, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2724, 20, 20, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2725, 20, 21, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2726, 20, 22, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2727, 20, 23, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2728, 20, 24, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2729, 20, 25, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2730, 20, 26, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2731, 20, 27, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2732, 20, 28, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2733, 20, 29, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2734, 20, 30, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2735, 20, 31, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2736, 20, 32, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2737, 20, 33, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2738, 20, 34, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2739, 20, 35, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2740, 20, 36, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2741, 20, 37, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2742, 20, 38, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2743, 20, 39, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2744, 20, 40, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2745, 20, 41, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2746, 20, 42, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2747, 20, 43, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2748, 20, 44, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2749, 20, 45, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2750, 20, 46, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2751, 20, 47, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2752, 20, 48, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2753, 20, 49, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2754, 20, 50, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2755, 20, 51, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2756, 20, 52, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2757, 20, 53, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2758, 20, 54, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2759, 20, 55, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2760, 20, 56, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2761, 20, 57, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2762, 20, 58, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2763, 20, 59, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2764, 20, 60, 0, 0, -1, '2023-01-17 15:01:35', -1, '2023-01-17 15:01:35');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2765, 20, 61, 0, 0, -1, '2023-01-17 15:01:36', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2766, 20, 62, 0, 0, -1, '2023-01-17 15:01:36', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2767, 20, 63, 0, 0, -1, '2023-01-17 15:01:36', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2768, 20, 64, 0, 0, -1, '2023-01-17 15:01:36', -1, '2023-01-17 15:01:36');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2769, 21, 1, 1, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2770, 21, 2, 1, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2771, 21, 3, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2772, 21, 4, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2773, 21, 5, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2775, 21, 7, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2776, 21, 8, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2777, 21, 9, 1, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2778, 21, 10, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2779, 21, 11, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2780, 21, 12, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2781, 21, 13, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2782, 21, 14, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2783, 21, 15, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2784, 21, 16, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2785, 21, 17, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2786, 21, 18, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2787, 21, 19, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2788, 21, 20, 0, 0, -1, '2023-01-18 12:40:48', -1, '2023-01-18 12:40:48');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2789, 21, 21, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2790, 21, 22, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2791, 21, 23, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2792, 21, 24, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2793, 21, 25, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2794, 21, 26, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2795, 21, 27, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2796, 21, 28, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2797, 21, 29, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2798, 21, 30, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2799, 21, 31, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2800, 21, 32, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2801, 21, 33, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2802, 21, 34, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2803, 21, 35, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2804, 21, 36, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2805, 21, 37, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2806, 21, 38, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2807, 21, 39, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2808, 21, 40, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2809, 21, 41, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2810, 21, 42, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2811, 21, 43, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2812, 21, 44, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2813, 21, 45, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2814, 21, 46, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2815, 21, 47, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2816, 21, 48, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2817, 21, 49, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2818, 21, 50, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2819, 21, 51, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2820, 21, 52, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2821, 21, 53, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2822, 21, 54, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2823, 21, 55, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2824, 21, 56, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2825, 21, 57, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2826, 21, 58, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2827, 21, 59, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2828, 21, 60, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2829, 21, 61, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2830, 21, 62, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2831, 21, 63, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2832, 21, 64, 0, 0, -1, '2023-01-18 12:40:49', -1, '2023-01-18 12:40:49');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2833, 22, 1, 1, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2834, 22, 2, 1, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2835, 22, 3, 1, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2836, 22, 4, 1, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2837, 22, 5, 1, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2839, 22, 7, 1, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2840, 22, 8, 1, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2841, 22, 9, 1, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2842, 22, 10, 1, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2843, 22, 11, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2844, 22, 12, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2845, 22, 13, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2846, 22, 14, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2847, 22, 15, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2848, 22, 16, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2849, 22, 17, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2850, 22, 18, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2851, 22, 19, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2852, 22, 20, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2853, 22, 21, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2854, 22, 22, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2855, 22, 23, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2856, 22, 24, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2857, 22, 25, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2858, 22, 26, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2859, 22, 27, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2860, 22, 28, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2861, 22, 29, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2862, 22, 30, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2863, 22, 31, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2864, 22, 32, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2865, 22, 33, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2866, 22, 34, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2867, 22, 35, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2868, 22, 36, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2869, 22, 37, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2870, 22, 38, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2871, 22, 39, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2872, 22, 40, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2873, 22, 41, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2874, 22, 42, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2875, 22, 43, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2876, 22, 44, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2877, 22, 45, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2878, 22, 46, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2879, 22, 47, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2880, 22, 48, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2881, 22, 49, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2882, 22, 50, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2883, 22, 51, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2884, 22, 52, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2885, 22, 53, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2886, 22, 54, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2887, 22, 55, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2888, 22, 56, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2889, 22, 57, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2890, 22, 58, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2891, 22, 59, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2892, 22, 60, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2893, 22, 61, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2894, 22, 62, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2895, 22, 63, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2896, 22, 64, 0, 0, -1, '2023-01-19 16:06:55', -1, '2023-01-19 16:06:55');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2897, 1, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2898, 2, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2899, 3, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2900, 4, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2901, 5, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2902, 7, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2903, 8, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2904, 9, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2905, 13, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2906, 14, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2907, 15, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2908, 16, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2909, 17, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2910, 18, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2911, 20, 6, 0, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2912, 21, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2913, 22, 6, 1, 0, -1, '2023-01-22 23:27:13', -1, '2023-01-22 23:27:13');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2914, 23, 1, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2915, 24, 1, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2916, 25, 1, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2917, 23, 2, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2918, 24, 2, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2919, 25, 2, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2920, 23, 3, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2921, 24, 3, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2922, 25, 3, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2923, 23, 4, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2924, 24, 4, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2925, 25, 4, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2926, 23, 5, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2927, 24, 5, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2928, 25, 5, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2929, 23, 6, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2930, 24, 6, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2931, 25, 6, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2932, 23, 7, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2933, 24, 7, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2934, 25, 7, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2935, 23, 8, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2936, 24, 8, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2937, 25, 8, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2938, 23, 9, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2939, 24, 9, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2940, 25, 9, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2941, 23, 10, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2942, 24, 10, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2943, 25, 10, 1, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2944, 23, 11, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2945, 24, 11, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2946, 25, 11, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2947, 23, 12, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2948, 24, 12, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2949, 25, 12, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2950, 23, 13, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2951, 24, 13, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2952, 25, 13, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2953, 23, 14, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2954, 24, 14, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2955, 25, 14, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2956, 23, 15, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2957, 24, 15, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2958, 25, 15, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2959, 23, 16, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2960, 24, 16, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2961, 25, 16, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2962, 23, 17, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2963, 24, 17, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2964, 25, 17, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2965, 23, 18, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2966, 24, 18, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2967, 25, 18, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2968, 23, 19, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2969, 24, 19, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2970, 25, 19, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2971, 23, 20, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2972, 24, 20, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2973, 25, 20, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2974, 23, 21, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2975, 24, 21, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2976, 25, 21, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2977, 23, 22, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2978, 24, 22, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2979, 25, 22, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2980, 23, 23, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2981, 24, 23, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2982, 25, 23, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2983, 23, 24, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2984, 24, 24, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2985, 25, 24, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2986, 23, 25, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2987, 24, 25, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2988, 25, 25, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2989, 23, 26, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2990, 24, 26, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2991, 25, 26, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2992, 23, 27, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2993, 24, 27, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2994, 25, 27, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2995, 23, 28, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2996, 24, 28, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2997, 25, 28, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2998, 23, 29, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (2999, 24, 29, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3000, 25, 29, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3001, 23, 30, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3002, 24, 30, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3003, 25, 30, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3004, 23, 31, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3005, 24, 31, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3006, 25, 31, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3007, 23, 32, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3008, 24, 32, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3009, 25, 32, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3010, 23, 33, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3011, 24, 33, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3012, 25, 33, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3013, 23, 34, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3014, 24, 34, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3015, 25, 34, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3016, 23, 35, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3017, 24, 35, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3018, 25, 35, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3019, 23, 36, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3020, 24, 36, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3021, 25, 36, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3022, 23, 37, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3023, 24, 37, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3024, 25, 37, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3025, 23, 38, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3026, 24, 38, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3027, 25, 38, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3028, 23, 39, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3029, 24, 39, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3030, 25, 39, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3031, 23, 40, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3032, 24, 40, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3033, 25, 40, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3034, 23, 41, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3035, 24, 41, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3036, 25, 41, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3037, 23, 42, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3038, 24, 42, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3039, 25, 42, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3040, 23, 43, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3041, 24, 43, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3042, 25, 43, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3043, 23, 44, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3044, 24, 44, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3045, 25, 44, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3046, 23, 45, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3047, 24, 45, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3048, 25, 45, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3049, 23, 46, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3050, 24, 46, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3051, 25, 46, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3052, 23, 47, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3053, 24, 47, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3054, 25, 47, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3055, 23, 48, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3056, 24, 48, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3057, 25, 48, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3058, 23, 49, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3059, 24, 49, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3060, 25, 49, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3061, 23, 50, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3062, 24, 50, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3063, 25, 50, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3064, 23, 51, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3065, 24, 51, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3066, 25, 51, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3067, 23, 52, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3068, 24, 52, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3069, 25, 52, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3070, 23, 53, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3071, 24, 53, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3072, 25, 53, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3073, 23, 54, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3074, 24, 54, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3075, 25, 54, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3076, 23, 55, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3077, 24, 55, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3078, 25, 55, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3079, 23, 56, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3080, 24, 56, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3081, 25, 56, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3082, 23, 57, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3083, 24, 57, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3084, 25, 57, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3085, 23, 58, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3086, 24, 58, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3087, 25, 58, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3088, 23, 59, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3089, 24, 59, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3090, 25, 59, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3091, 23, 60, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3092, 24, 60, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3093, 25, 60, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3094, 23, 61, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3095, 24, 61, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3096, 25, 61, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3097, 23, 62, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3098, 24, 62, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3099, 25, 62, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3100, 23, 63, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3101, 24, 63, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3102, 25, 63, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3103, 23, 64, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3104, 24, 64, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3105, 25, 64, 0, 1, -1, '2023-01-23 12:41:12', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3106, 10, 1, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3107, 11, 1, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3108, 12, 1, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3109, 10, 2, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3110, 11, 2, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3111, 12, 2, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3112, 10, 3, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3113, 11, 3, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3114, 12, 3, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3115, 10, 4, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3116, 11, 4, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3117, 12, 4, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3118, 10, 5, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3119, 11, 5, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3120, 12, 5, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3121, 10, 6, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3122, 11, 6, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3123, 12, 6, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3124, 10, 7, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3125, 11, 7, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3126, 12, 7, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3127, 10, 8, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3128, 11, 8, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3129, 12, 8, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3130, 10, 9, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3131, 11, 9, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3132, 12, 9, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3133, 10, 10, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3134, 11, 10, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3135, 12, 10, 1, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3136, 10, 11, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3137, 11, 11, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3138, 12, 11, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3139, 10, 12, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3140, 11, 12, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3141, 12, 12, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3142, 10, 13, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3143, 11, 13, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3144, 12, 13, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3145, 10, 14, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3146, 11, 14, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3147, 12, 14, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3148, 10, 15, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3149, 11, 15, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3150, 12, 15, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3151, 10, 16, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3152, 11, 16, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3153, 12, 16, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3154, 10, 17, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3155, 11, 17, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3156, 12, 17, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3157, 10, 18, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3158, 11, 18, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3159, 12, 18, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3160, 10, 19, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3161, 11, 19, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3162, 12, 19, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3163, 10, 20, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3164, 11, 20, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3165, 12, 20, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3166, 10, 21, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3167, 11, 21, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3168, 12, 21, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3169, 10, 22, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3170, 11, 22, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3171, 12, 22, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3172, 10, 23, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3173, 11, 23, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3174, 12, 23, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3175, 10, 24, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3176, 11, 24, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3177, 12, 24, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3178, 10, 25, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3179, 11, 25, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3180, 12, 25, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3181, 10, 26, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3182, 11, 26, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3183, 12, 26, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3184, 10, 27, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3185, 11, 27, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3186, 12, 27, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3187, 10, 28, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3188, 11, 28, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3189, 12, 28, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3190, 10, 29, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3191, 11, 29, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3192, 12, 29, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3193, 10, 30, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3194, 11, 30, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3195, 12, 30, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3196, 10, 31, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3197, 11, 31, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3198, 12, 31, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3199, 10, 32, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3200, 11, 32, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3201, 12, 32, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3202, 10, 33, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3203, 11, 33, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3204, 12, 33, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3205, 10, 34, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3206, 11, 34, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3207, 12, 34, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3208, 10, 35, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3209, 11, 35, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3210, 12, 35, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3211, 10, 36, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3212, 11, 36, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3213, 12, 36, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3214, 10, 37, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3215, 11, 37, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3216, 12, 37, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3217, 10, 38, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3218, 11, 38, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3219, 12, 38, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3220, 10, 39, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3221, 11, 39, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3222, 12, 39, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3223, 10, 40, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3224, 11, 40, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3225, 12, 40, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3226, 10, 41, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3227, 11, 41, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3228, 12, 41, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3229, 10, 42, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3230, 11, 42, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3231, 12, 42, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3232, 10, 43, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3233, 11, 43, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3234, 12, 43, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3235, 10, 44, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3236, 11, 44, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3237, 12, 44, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3238, 10, 45, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3239, 11, 45, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3240, 12, 45, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3241, 10, 46, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3242, 11, 46, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3243, 12, 46, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3244, 10, 47, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3245, 11, 47, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3246, 12, 47, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3247, 10, 48, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3248, 11, 48, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3249, 12, 48, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3250, 10, 49, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3251, 11, 49, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3252, 12, 49, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3253, 10, 50, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3254, 11, 50, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3255, 12, 50, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3256, 10, 51, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3257, 11, 51, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3258, 12, 51, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3259, 10, 52, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3260, 11, 52, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3261, 12, 52, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3262, 10, 53, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3263, 11, 53, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3264, 12, 53, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3265, 10, 54, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3266, 11, 54, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3267, 12, 54, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3268, 10, 55, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3269, 11, 55, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3270, 12, 55, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3271, 10, 56, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3272, 11, 56, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3273, 12, 56, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3274, 10, 57, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3275, 11, 57, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3276, 12, 57, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3277, 10, 58, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3278, 11, 58, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3279, 12, 58, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3280, 10, 59, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3281, 11, 59, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3282, 12, 59, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3283, 10, 60, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3284, 11, 60, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3285, 12, 60, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3286, 10, 61, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3287, 11, 61, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3288, 12, 61, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3289, 10, 62, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3290, 11, 62, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3291, 12, 62, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3292, 10, 63, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3293, 11, 63, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3294, 12, 63, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3295, 10, 64, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3296, 11, 64, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');
INSERT INTO
    `tb_core_register_mtm_plugin`
VALUES
    (3297, 12, 64, 0, 0, -1, '2023-01-25 03:09:08', -1, '2023-01-25 03:09:08');

-- ----------------------------
-- Table structure for tb_plugin_image
-- ----------------------------
DROP TABLE IF EXISTS `tb_plugin_image`;
CREATE TABLE `tb_plugin_image`
(
    `row_id`      BIGINT(0)                                                         NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `keyword`     VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '存/取 关键词',
    `file_name`   VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '存储文件名',
    `group_id`    BIGINT(0)                                                         NOT NULL DEFAULT -1 COMMENT '群组id,私聊存储为-1',
    `author_id`   BIGINT(0)                                                         NOT NULL COMMENT '创建人id',
    `is_delete`   TINYINT(1)                                                        NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
    `create_user` BIGINT(0)                                                         NOT NULL COMMENT '创建用户',
    `create_time` DATETIME(0)                                                       NOT NULL COMMENT '创建时间',
    `update_user` BIGINT(0)                                                         NOT NULL COMMENT '更新用户',
    `update_time` DATETIME(0)                                                       NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`row_id`) USING BTREE,
    INDEX `INDEX_IMAGE_KEYWORD` (`keyword`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 277
  CHARACTER SET = `utf8mb4`
  COLLATE = `utf8mb4_0900_ai_ci` COMMENT = '图片信息'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_plugin_image
-- ----------------------------
INSERT INTO
    `tb_plugin_image`
VALUES
    (1, 'test', '375c87b4-1b5f-45ae-9f30-6f2ee17ec62e.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-11 16:22:56', 776465218, '2022-10-11 16:22:56');
INSERT INTO
    `tb_plugin_image`
VALUES
    (2, '乐', '454e653b-4886-4365-8ab0-9ecbfd30a36d.jpg', 673745932, 776465218, 0, 776465218, '2022-10-18 08:53:09',
     776465218, '2022-10-18 08:53:09');
INSERT INTO
    `tb_plugin_image`
VALUES
    (3, 'error', 'eb4d73ae-3746-4850-8ceb-64559ed1f3e1.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-11 16:31:30', 776465218, '2022-10-11 16:31:30');
INSERT INTO
    `tb_plugin_image`
VALUES
    (4, '老狗', 'a5c0afdd-0108-4e01-8528-ce5ead77bc8c.jpg', 673745932, 776465218, 0, 776465218, '2022-10-11 16:36:03',
     776465218, '2022-10-11 16:36:03');
INSERT INTO
    `tb_plugin_image`
VALUES
    (5, '傻了', '37ae322c-c79e-4438-adeb-5b25dc07cd7b.jpg', 673745932, 776465218, 0, 776465218, '2022-10-11 17:02:48',
     776465218, '2022-10-11 17:02:48');
INSERT INTO
    `tb_plugin_image`
VALUES
    (6, '来点没看过的', '848e3d76-2de6-4212-9042-bfedae00bca4.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-11 17:15:02', 776465218, '2022-10-11 17:15:02');
INSERT INTO
    `tb_plugin_image`
VALUES
    (7, '突变表', '813ded03-4fa0-4a22-a897-027f2f2aa957.jpg', 673745932, 776465218, 0, 776465218, '2022-10-11 17:19:48',
     776465218, '2022-10-11 17:19:48');
INSERT INTO
    `tb_plugin_image`
VALUES
    (8, '千里眼', '1bf308a4-6e56-46a7-9a1f-7c61037b4a8c.jpg', 673745932, 776465218, 1, 776465218, '2022-10-11 17:53:30',
     776465218, '2022-10-11 17:53:30');
INSERT INTO
    `tb_plugin_image`
VALUES
    (9, '给老子死', '4384e79c-d373-4bcb-83b6-f09a9fdbd280.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-12 10:51:39', 776465218, '2022-10-12 10:51:39');
INSERT INTO
    `tb_plugin_image`
VALUES
    (10, '不写不写', 'a3031073-30c1-47e4-acb6-e3f8e8eed772.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-12 11:03:03', 776465218, '2022-10-12 11:03:03');
INSERT INTO
    `tb_plugin_image`
VALUES
    (11, '好好好', 'a1042403-94da-494d-80d3-ea6365248e4a.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-12 15:33:44', 776465218, '2022-10-12 15:33:44');
INSERT INTO
    `tb_plugin_image`
VALUES
    (12, '同化完成', '81fbdf68-3a8a-46fd-a5d4-06abea16f0c2.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-12 15:48:54', 776465218, '2022-10-12 15:48:54');
INSERT INTO
    `tb_plugin_image`
VALUES
    (13, '草', '8b6b9024-f3ff-49b1-9d4c-2f2cd2a0976d.png', 673745932, 776465218, 0, 776465218, '2022-10-12 15:51:36',
     776465218, '2022-10-12 15:51:36');
INSERT INTO
    `tb_plugin_image`
VALUES
    (14, '好好好2', 'af541241-e00b-494c-ae9c-9e923c362599.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-12 15:54:07', 776465218, '2022-10-12 15:54:07');
INSERT INTO
    `tb_plugin_image`
VALUES
    (15, '水过了', '24555e93-a802-44e1-bc34-a5f1709d9b95.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-12 15:56:17', 776465218, '2022-10-12 15:56:17');
INSERT INTO
    `tb_plugin_image`
VALUES
    (16, '傻了2', '4ead96c3-7078-4412-8662-56d063e192a7.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 16:16:37',
     776465218, '2022-10-12 16:16:37');
INSERT INTO
    `tb_plugin_image`
VALUES
    (17, '狗头', 'bd12e6de-375b-4fd4-8515-50456492d4f6.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 16:22:53',
     776465218, '2022-10-12 16:22:53');
INSERT INTO
    `tb_plugin_image`
VALUES
    (18, '不给', '8ec7df72-a4b1-49ce-91bd-e8b86d796cf2.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 16:26:13',
     776465218, '2022-10-12 16:26:13');
INSERT INTO
    `tb_plugin_image`
VALUES
    (19, '已阅', 'caeb17d0-313f-4fa2-ac5c-bafa506484cc.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 16:26:31',
     776465218, '2022-10-12 16:26:31');
INSERT INTO
    `tb_plugin_image`
VALUES
    (20, '有了', '846bd462-1b24-4a09-a9c4-2d3828efc3ef.jpg', 673745932, 776465218, 0, 776465218, '2022-10-12 17:04:36',
     776465218, '2022-10-12 17:04:36');
INSERT INTO
    `tb_plugin_image`
VALUES
    (21, '我拿什么跟她比', '9b5a7bc9-1c7a-4026-a37f-b96a72f070e4.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-12 19:55:07', 776465218, '2022-10-12 19:55:07');
INSERT INTO
    `tb_plugin_image`
VALUES
    (22, '啊对对对', 'f08cebea-1778-46d5-bd30-ab67feac08c6.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-13 12:36:52', 776465218, '2022-10-13 12:36:52');
INSERT INTO
    `tb_plugin_image`
VALUES
    (23, '怎么又', 'e658ea07-fe8b-4b62-9057-bc97b627051e.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-13 12:37:20', 776465218, '2022-10-13 12:37:20');
INSERT INTO
    `tb_plugin_image`
VALUES
    (24, '晓希', '5efd9177-259c-4aee-b005-3343684da3df.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:53:36',
     776465218, '2022-10-13 12:53:36');
INSERT INTO
    `tb_plugin_image`
VALUES
    (25, '假笑', 'c16e057a-921d-498e-88bb-d0ec5adac05f.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:54:13',
     776465218, '2022-10-13 12:54:13');
INSERT INTO
    `tb_plugin_image`
VALUES
    (26, '?', '31d1e0d7-f88d-4225-9988-84643f25eeff.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:56:18',
     776465218, '2022-10-13 12:56:18');
INSERT INTO
    `tb_plugin_image`
VALUES
    (27, '振刀', 'ccb3777a-f6e8-46d7-a4aa-307a6d6d9d77.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:57:20',
     776465218, '2022-10-13 12:57:20');
INSERT INTO
    `tb_plugin_image`
VALUES
    (28, '死啊', '880cca52-bee6-4794-8a00-7aed2a397975.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 12:57:38',
     776465218, '2022-10-13 12:57:38');
INSERT INTO
    `tb_plugin_image`
VALUES
    (29, '我是cb', '9154854c-1198-4b6d-86bd-9914d390a0ba.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-13 12:59:39', 776465218, '2022-10-13 12:59:39');
INSERT INTO
    `tb_plugin_image`
VALUES
    (30, '疯狂星期四', '66bdf732-c51b-4573-b744-2e0bdef00505.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-13 13:02:31', 776465218, '2022-10-13 13:02:31');
INSERT INTO
    `tb_plugin_image`
VALUES
    (31, '疯狂星期四2', 'dbfff249-f1b0-4238-8ca1-2e0370b8d297.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-13 13:02:44', 776465218, '2022-10-13 13:02:44');
INSERT INTO
    `tb_plugin_image`
VALUES
    (32, '疯狂星期四3', '62b576c6-42d2-43bf-b497-9e3369896e52.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-13 13:02:55', 776465218, '2022-10-13 13:02:55');
INSERT INTO
    `tb_plugin_image`
VALUES
    (33, '未成年的目光', 'dfc16453-9e61-4b86-b511-bebb7411b07f.png', 673745932, 776465218, 0, 776465218,
     '2022-10-13 13:04:37', 776465218, '2022-10-13 13:04:37');
INSERT INTO
    `tb_plugin_image`
VALUES
    (34, '麻中麻中麻', '035dcb40-638f-4a99-a4b0-61d1f260d4b9.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-13 13:45:13', 1743114170, '2022-10-13 13:45:13');
INSERT INTO
    `tb_plugin_image`
VALUES
    (35, '麻了', 'b471fef8-1770-4dfb-83e3-29d902cacfc4.jpg', 673745932, 776465218, 0, 776465218, '2022-10-13 13:52:37',
     776465218, '2022-10-13 13:52:37');
INSERT INTO
    `tb_plugin_image`
VALUES
    (36, '恶心', '676f81ce-6aea-4290-8ea5-4689b298f705.jpg', 673745932, 80000000, 0, 80000000, '2022-10-13 14:07:10',
     80000000, '2022-10-13 14:07:10');
INSERT INTO
    `tb_plugin_image`
VALUES
    (37, '我觉得很恶星', '93a72105-6a37-4b82-838a-730aeb6a09d7.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-13 14:08:10', 1743114170, '2022-10-13 14:08:10');
INSERT INTO
    `tb_plugin_image`
VALUES
    (38, '没办法人家就是好色嘛', 'c56cb1a8-1678-4dda-8401-6dc9dd2fc57f.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-13 14:11:58', 601372611, '2022-10-13 14:11:58');
INSERT INTO
    `tb_plugin_image`
VALUES
    (39, '我小猫咪也绝非善类', '957248f0-1c0c-405f-b212-220f70b01e48.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-13 14:12:38', 601372611, '2022-10-13 14:12:38');
INSERT INTO
    `tb_plugin_image`
VALUES
    (40, '训练师生涯', '02c6be8a-4918-4f85-a226-8632f87e9882.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-14 15:19:26', 776465218, '2022-10-14 15:19:26');
INSERT INTO
    `tb_plugin_image`
VALUES
    (41, '还想要', '7bbe1c36-5b67-4c75-9c76-9463f2bc36b1.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-14 15:20:02', 601372611, '2022-10-14 15:20:02');
INSERT INTO
    `tb_plugin_image`
VALUES
    (42, '疯狂暗示', '857609b1-40d6-4e57-a216-d56645222216.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-14 15:24:03', 601372611, '2022-10-14 15:24:03');
INSERT INTO
    `tb_plugin_image`
VALUES
    (43, '栞傻了', 'f1ff3f3f-7d11-40ee-8cdc-3cc2e607f356.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-14 15:26:06', 601372611, '2022-10-14 15:26:06');
INSERT INTO
    `tb_plugin_image`
VALUES
    (44, 'zxycb', '687049ff-46d7-4351-9798-64229532ecd1.jpg', 673745932, 776465218, 0, 776465218, '2022-10-14 15:27:04',
     776465218, '2022-10-14 15:27:04');
INSERT INTO
    `tb_plugin_image`
VALUES
    (45, '我小猫咪的心好痛', '5d9210b9-e142-471f-ac87-ec8a5cae86eb.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-14 15:38:36', 601372611, '2022-10-14 15:38:36');
INSERT INTO
    `tb_plugin_image`
VALUES
    (46, '被生活击倒在地', '65bc9838-d47f-4075-ac53-8488db3e55f0.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-14 16:47:34', 601372611, '2022-10-14 16:47:34');
INSERT INTO
    `tb_plugin_image`
VALUES
    (47, '徐姜权', '232b99ce-353c-4c45-a01c-4f9d635dea0e.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-14 16:49:46', 1743114170, '2022-10-14 16:49:46');
INSERT INTO
    `tb_plugin_image`
VALUES
    (48, '放下助人情节', '35daab2e-cc6d-4569-9a06-1e0f39f90af0.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-14 23:03:55', 776465218, '2022-10-14 23:03:55');
INSERT INTO
    `tb_plugin_image`
VALUES
    (49, '我睡不着', '841623ec-81bf-45fe-be8e-f5806ba663aa.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-15 00:19:43', 776465218, '2022-10-15 00:19:43');
INSERT INTO
    `tb_plugin_image`
VALUES
    (50, '不知道你在叫什么', 'c21b756e-9e50-4cd9-a4ab-8de7749049b4.png', 673745932, 601372611, 0, 601372611,
     '2022-10-15 00:29:49', 601372611, '2022-10-15 00:29:49');
INSERT INTO
    `tb_plugin_image`
VALUES
    (51, '不知道为什么柠檬老是围着我转', '16e872e9-66cd-4e77-88c8-23798dab51bd.gif', 673745932, 601372611, 0, 601372611,
     '2022-10-15 00:30:56', 601372611, '2022-10-15 00:30:56');
INSERT INTO
    `tb_plugin_image`
VALUES
    (52, '活活笑死', '159cc0cb-4b95-4703-879f-0ff7913cfc47.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-15 00:31:17', 601372611, '2022-10-15 00:31:17');
INSERT INTO
    `tb_plugin_image`
VALUES
    (53, '我小猫咪听不懂', '6235f8e7-bbae-4c8f-bf57-8e87c3610ae3.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-15 00:42:06', 601372611, '2022-10-15 00:42:06');
INSERT INTO
    `tb_plugin_image`
VALUES
    (54, '我想不通', 'ce3a35d0-93de-4c67-91e9-7b97ddab3563.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-15 00:47:02', 601372611, '2022-10-15 00:47:02');
INSERT INTO
    `tb_plugin_image`
VALUES
    (55, '这可能就是命吧', 'ecb04ff4-84a3-42e9-8b8a-52fe81e005fa.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-15 00:49:26', 601372611, '2022-10-15 00:49:26');
INSERT INTO
    `tb_plugin_image`
VALUES
    (56, '你和我说这些没用', '0eff3f11-a201-4f02-a20b-e93fd15c028d.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-15 00:49:52', 601372611, '2022-10-15 00:49:52');
INSERT INTO
    `tb_plugin_image`
VALUES
    (57, '丢人箱', '19bdf922-d233-4ce0-b5c1-751abf288d2d.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-15 00:51:24', 601372611, '2022-10-15 00:51:24');
INSERT INTO
    `tb_plugin_image`
VALUES
    (58, '一句话', '9c9460d0-d9f0-4e2b-96b5-cee279d28746.png', 673745932, 776465218, 0, 776465218,
     '2022-10-17 10:00:29', 776465218, '2022-10-17 10:00:29');
INSERT INTO
    `tb_plugin_image`
VALUES
    (59, '自欺欺人', 'd52caaba-8898-44dd-9b35-65b0728491ed.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-17 16:15:23', 776465218, '2022-10-17 16:15:23');
INSERT INTO
    `tb_plugin_image`
VALUES
    (60, '掩耳盗铃', 'a2e1bce7-2b74-4c58-906e-2a92219a47bc.png', 673745932, 601372611, 0, 601372611,
     '2022-10-17 16:21:42', 601372611, '2022-10-17 16:21:42');
INSERT INTO
    `tb_plugin_image`
VALUES
    (61, '未卜先知', '058db012-1b1e-4a97-8ff6-1dff85990a7a.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-17 16:22:12', 1743114170, '2022-10-17 16:22:12');
INSERT INTO
    `tb_plugin_image`
VALUES
    (62, '濒死上班', 'a7f6ef6f-d9c8-4607-9f49-e8f89ec39ce7.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-18 08:52:43', 601372611, '2022-10-18 08:52:43');
INSERT INTO
    `tb_plugin_image`
VALUES
    (63, 'yly本人', 'f807c9da-73be-413c-9ffd-8525282f83dd.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-18 13:58:19', 776465218, '2022-10-18 13:58:19');
INSERT INTO
    `tb_plugin_image`
VALUES
    (64, '我是傻狗', '0fa27eee-aa06-4626-8500-abd7cdd93722.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-18 16:53:21', 776465218, '2022-10-18 16:53:21');
INSERT INTO
    `tb_plugin_image`
VALUES
    (65, '时间扭曲', 'eda5de58-4f95-4f19-ad84-c213c5e50b69.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:06:37', 943952775, '2022-10-18 17:06:37');
INSERT INTO
    `tb_plugin_image`
VALUES
    (66, '闪避机动', 'd7d8c92a-4028-4fb2-b612-b43da1b1aaa8.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:07:58', 943952775, '2022-10-18 17:07:58');
INSERT INTO
    `tb_plugin_image`
VALUES
    (67, '短视症', 'f2132576-6939-4e3a-9990-a2270a20b386.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:08:12', 943952775, '2022-10-18 17:08:12');
INSERT INTO
    `tb_plugin_image`
VALUES
    (68, '震荡攻击', '13df4213-6cd0-4cbb-a929-1e0d5c6b3af0.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:08:26', 943952775, '2022-10-18 17:08:26');
INSERT INTO
    `tb_plugin_image`
VALUES
    (69, '时空力场', '4614dac7-a905-4d59-8edb-ab4a3c332abd.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:08:46', 943952775, '2022-10-18 17:08:46');
INSERT INTO
    `tb_plugin_image`
VALUES
    (70, '轨道轰炸', '136b75ab-1f93-47c7-aae9-7548fb8b11c3.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:08:59', 943952775, '2022-10-18 17:08:59');
INSERT INTO
    `tb_plugin_image`
VALUES
    (71, '光子过载', '9cfb8390-4a4b-4cd0-8f72-9f994892d9f6.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:09:08', 943952775, '2022-10-18 17:09:08');
INSERT INTO
    `tb_plugin_image`
VALUES
    (72, '生命吸取', '1bfbf78d-c6c0-4f66-b9d3-879bbed14ffe.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:09:27', 943952775, '2022-10-18 17:09:27');
INSERT INTO
    `tb_plugin_image`
VALUES
    (73, '强行征用', 'c7dc2da4-4473-4bbf-b003-40fda21c8390.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:09:52', 943952775, '2022-10-18 17:09:52');
INSERT INTO
    `tb_plugin_image`
VALUES
    (74, '行尸走肉', '06296f9a-5bf0-4d91-8b5c-f57e543d0c5b.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:10:06', 943952775, '2022-10-18 17:10:06');
INSERT INTO
    `tb_plugin_image`
VALUES
    (75, '暗无天日', '2fe64464-6b9e-425b-aa36-69dd4b269b33.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:10:14', 943952775, '2022-10-18 17:10:14');
INSERT INTO
    `tb_plugin_image`
VALUES
    (76, '速度狂魔', '3f038ee7-6642-43b3-8b13-2ebdb5638798.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:10:27', 943952775, '2022-10-18 17:10:27');
INSERT INTO
    `tb_plugin_image`
VALUES
    (77, '晶矿护盾', '9907ac29-d575-4e7d-bf43-c7661a9519e9.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:10:48', 943952775, '2022-10-18 17:10:48');
INSERT INTO
    `tb_plugin_image`
VALUES
    (78, '减伤屏障', 'ed7e754a-1e56-452e-8dc2-d8e993e84492.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:11:02', 943952775, '2022-10-18 17:11:02');
INSERT INTO
    `tb_plugin_image`
VALUES
    (79, '焦土政策', '38b36988-8ed0-4eca-a902-7dda2363aa10.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:11:11', 943952775, '2022-10-18 17:11:11');
INSERT INTO
    `tb_plugin_image`
VALUES
    (80, '异形寄生', '3aa42b09-6e2b-4b28-9838-3afb91baba6a.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:11:23', 943952775, '2022-10-18 17:11:23');
INSERT INTO
    `tb_plugin_image`
VALUES
    (81, '激光钻机', 'bef55dbc-abf5-4db6-8645-e7d595e6d879.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:11:32', 943952775, '2022-10-18 17:11:32');
INSERT INTO
    `tb_plugin_image`
VALUES
    (82, '超远视距', 'a967c80a-2747-46b3-b08c-131745aa867a.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:11:47', 943952775, '2022-10-18 17:11:47');
INSERT INTO
    `tb_plugin_image`
VALUES
    (83, '龙卷风暴', '7775bacc-bddb-4d1c-8e1f-a5631fceafed.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:11:58', 943952775, '2022-10-18 17:11:58');
INSERT INTO
    `tb_plugin_image`
VALUES
    (84, '净化光束', 'af042327-617b-434e-8e0e-1e81c2f85da5.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:12:18', 943952775, '2022-10-18 17:12:18');
INSERT INTO
    `tb_plugin_image`
VALUES
    (85, '鼓舞人心', '835aae56-5727-4c7e-96b4-f7a9b5da0369.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:12:26', 943952775, '2022-10-18 17:12:26');
INSERT INTO
    `tb_plugin_image`
VALUES
    (86, '坚强意志', 'a66a62cf-ee44-4df8-a1f6-7d49be596989.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:12:35', 943952775, '2022-10-18 17:12:35');
INSERT INTO
    `tb_plugin_image`
VALUES
    (87, '默哀', '25945535-a79f-48e3-8183-9f460f1761ed.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:12:42',
     943952775, '2022-10-18 17:12:42');
INSERT INTO
    `tb_plugin_image`
VALUES
    (88, '丧尸大战', 'bac2cef1-175a-4e40-bbeb-598cc14d4964.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:12:51', 943952775, '2022-10-18 17:12:51');
INSERT INTO
    `tb_plugin_image`
VALUES
    (89, '岩浆爆发', '0c94e549-5a0d-4f7c-b378-8ffe81946980.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:13:12', 943952775, '2022-10-18 17:13:12');
INSERT INTO
    `tb_plugin_image`
VALUES
    (90, '自毁程序', '84664384-73a0-4052-b56a-39c994c3fe53.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:13:21', 943952775, '2022-10-18 17:13:21');
INSERT INTO
    `tb_plugin_image`
VALUES
    (91, '进攻部署', '21bd9f64-aeda-46f6-a055-1d98c205e15b.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:13:32', 943952775, '2022-10-18 17:13:32');
INSERT INTO
    `tb_plugin_image`
VALUES
    (92, '来去无踪', 'c42f8ca5-d6b3-453b-b1f7-736b22301c79.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:13:46', 943952775, '2022-10-18 17:13:46');
INSERT INTO
    `tb_plugin_image`
VALUES
    (93, '无边恐惧', 'dbe02214-3520-4ca3-a13c-60acc754e29d.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:14:01', 943952775, '2022-10-18 17:14:01');
INSERT INTO
    `tb_plugin_image`
VALUES
    (94, '核弹打击', 'f68f275b-1346-4e64-ac7b-51d1343016b1.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:14:08', 943952775, '2022-10-18 17:14:08');
INSERT INTO
    `tb_plugin_image`
VALUES
    (95, '飞弹大战', '18a5905f-6d31-43bc-a737-544d2dc78e63.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:14:16', 943952775, '2022-10-18 17:14:16');
INSERT INTO
    `tb_plugin_image`
VALUES
    (96, '伤害散射', '16bf44bc-649a-4f6c-a314-67206a856800.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:14:25', 943952775, '2022-10-18 17:14:25');
INSERT INTO
    `tb_plugin_image`
VALUES
    (97, '双重压力', '2b1fce4b-1099-4eae-a07d-09ab28e9f029.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:21:24', 943952775, '2022-10-18 17:21:24');
INSERT INTO
    `tb_plugin_image`
VALUES
    (98, '致命勾引', '43b7263f-6260-4969-a4b1-04b7d283bbaf.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:24:14', 943952775, '2022-10-18 17:24:14');
INSERT INTO
    `tb_plugin_image`
VALUES
    (99, '强磁雷场', '15b06e83-753b-4466-a75c-b6dd773d4043.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:25:09', 943952775, '2022-10-18 17:25:09');
INSERT INTO
    `tb_plugin_image`
VALUES
    (100, '暴风雪', '3a1d1faf-7b11-4522-9af5-40800f263b83.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:25:19', 943952775, '2022-10-18 17:25:19');
INSERT INTO
    `tb_plugin_image`
VALUES
    (101, '复仇战士', 'a26b6c0c-798c-44a1-87b1-40818ea29dd8.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:25:28', 943952775, '2022-10-18 17:25:28');
INSERT INTO
    `tb_plugin_image`
VALUES
    (102, '相互摧毁', 'c2e280cc-c6e6-4ee3-96db-6cb634a83f54.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:25:39', 943952775, '2022-10-18 17:25:39');
INSERT INTO
    `tb_plugin_image`
VALUES
    (103, '小捞油水', '06a6e4f0-bcdc-4f53-9b9f-2e9b3203faf2.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:25:52', 943952775, '2022-10-18 17:25:52');
INSERT INTO
    `tb_plugin_image`
VALUES
    (104, '虚空重生者', 'f5fabc2d-fef5-433b-ae92-8f3296b79bbd.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:26:01', 943952775, '2022-10-18 17:26:01');
INSERT INTO
    `tb_plugin_image`
VALUES
    (105, '灵能爆表', '208f8ffc-de4d-4930-9818-164f6ed3b10c.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:26:10', 943952775, '2022-10-18 17:26:10');
INSERT INTO
    `tb_plugin_image`
VALUES
    (106, '拿钱说话', 'cdc681a4-fcdf-44f8-bbb7-608e739b5b7e.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:26:22', 943952775, '2022-10-18 17:26:22');
INSERT INTO
    `tb_plugin_image`
VALUES
    (107, '扫雷专家', '907d5363-d78b-4634-a56b-dc8022ef53bd.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:26:34', 943952775, '2022-10-18 17:26:34');
INSERT INTO
    `tb_plugin_image`
VALUES
    (108, '杀戮机器人', '0941635d-1915-472b-a9da-ac7ac5ed9b28.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:26:44', 943952775, '2022-10-18 17:26:44');
INSERT INTO
    `tb_plugin_image`
VALUES
    (109, '给我死吧', 'c744f035-a1b0-447e-be28-e4563cf22232.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:26:52', 943952775, '2022-10-18 17:26:52');
INSERT INTO
    `tb_plugin_image`
VALUES
    (110, '极性不定', '9324b5b0-3b39-4b97-b90d-39d39af6d022.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:27:04', 943952775, '2022-10-18 17:27:04');
INSERT INTO
    `tb_plugin_image`
VALUES
    (111, '力量蜕变', '1b628a5f-fffb-44a8-abf2-83772ae041aa.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:27:16', 943952775, '2022-10-18 17:27:16');
INSERT INTO
    `tb_plugin_image`
VALUES
    (112, '黑死病', '2322d2b1-f604-463a-a736-b9f5b4bfd858.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:27:23', 943952775, '2022-10-18 17:27:23');
INSERT INTO
    `tb_plugin_image`
VALUES
    (113, '同化体', 'e22c952d-05ed-4fe3-abea-5c4ed7159085.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:29:10', 943952775, '2022-10-18 17:29:10');
INSERT INTO
    `tb_plugin_image`
VALUES
    (114, '虚空裂隙', '5956b7e2-f51e-4317-b7b5-2bfc2c1b4c04.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:30:33', 943952775, '2022-10-18 17:30:33');
INSERT INTO
    `tb_plugin_image`
VALUES
    (115, '风暴英雄', '47bfc0ed-0b1e-4e36-91ba-a06b15bc199d.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:30:40', 943952775, '2022-10-18 17:30:40');
INSERT INTO
    `tb_plugin_image`
VALUES
    (116, '随机', '49b343e5-20e1-4c46-872c-3d710b39d2bb.jpg', 673745932, 943952775, 0, 943952775, '2022-10-18 17:30:51',
     943952775, '2022-10-18 17:30:51');
INSERT INTO
    `tb_plugin_image`
VALUES
    (117, '上班偷睡', 'f8eb2315-af2b-48f2-b36f-aad51e3d3e9d.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:31:18', 943952775, '2022-10-18 17:31:18');
INSERT INTO
    `tb_plugin_image`
VALUES
    (118, '石像狂热者', '65401f43-007c-4c0f-8054-c28236ac9e12.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:31:35', 943952775, '2022-10-18 17:31:35');
INSERT INTO
    `tb_plugin_image`
VALUES
    (119, '混乱工作室', '820e978e-bad4-4b55-b51e-a5154dd4913d.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:31:53', 943952775, '2022-10-18 17:31:53');
INSERT INTO
    `tb_plugin_image`
VALUES
    (120, '迷失方向', '13d14544-0a43-4de6-95e5-0419acfc5f0a.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:32:05', 943952775, '2022-10-18 17:32:05');
INSERT INTO
    `tb_plugin_image`
VALUES
    (121, '不死邪魔', '7b107928-413c-4f18-94a6-13397ecd8143.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:32:17', 943952775, '2022-10-18 17:32:17');
INSERT INTO
    `tb_plugin_image`
VALUES
    (122, '惧怕黑暗', '04b46a3c-a1bc-4062-a1c3-1d1f59b4e0c1.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:32:33', 943952775, '2022-10-18 17:32:33');
INSERT INTO
    `tb_plugin_image`
VALUES
    (123, '不给糖果就捣蛋', '51a14cec-12cf-45dd-a309-efebf3a4b602.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:32:46', 943952775, '2022-10-18 17:32:46');
INSERT INTO
    `tb_plugin_image`
VALUES
    (124, '补给共享', 'fb155906-7988-4f40-8770-4509fe963837.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:33:19', 943952775, '2022-10-18 17:33:19');
INSERT INTO
    `tb_plugin_image`
VALUES
    (125, '礼尚往来', '738035ed-32c9-4afa-8fc6-65553a35bd5f.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:33:33', 943952775, '2022-10-18 17:33:33');
INSERT INTO
    `tb_plugin_image`
VALUES
    (126, '杀生业报', '4481ad71-10ff-4d4b-a297-73b43a63adb0.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:34:01', 943952775, '2022-10-18 17:34:01');
INSERT INTO
    `tb_plugin_image`
VALUES
    (127, '极度谨慎', '4e1b0e91-7785-4e88-9f80-d4a0430daf5a.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:34:14', 943952775, '2022-10-18 17:34:14');
INSERT INTO
    `tb_plugin_image`
VALUES
    (128, '刺头兵', 'b21960c6-9fc8-4324-a0a4-e28e36233579.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:34:25', 943952775, '2022-10-18 17:34:25');
INSERT INTO
    `tb_plugin_image`
VALUES
    (129, '焰火秀', '5966de7c-9b7e-4b7a-be4a-452cd2e5ca72.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:34:33', 943952775, '2022-10-18 17:34:33');
INSERT INTO
    `tb_plugin_image`
VALUES
    (130, '幸运红包', '10e0faec-fbb2-491b-98bf-63b2b15c81ef.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:34:45', 943952775, '2022-10-18 17:34:45');
INSERT INTO
    `tb_plugin_image`
VALUES
    (131, '消极战斗', '896666cc-b6ba-47c6-9f2a-9f16cccab663.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:34:55', 943952775, '2022-10-18 17:34:55');
INSERT INTO
    `tb_plugin_image`
VALUES
    (132, '炸弹机器人', 'cadd1323-1286-46a7-a24b-04863d61949e.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:35:02', 943952775, '2022-10-18 17:35:02');
INSERT INTO
    `tb_plugin_image`
VALUES
    (133, '集结国王', '3aedb677-3279-4d24-899b-7d0c8a203390.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-18 17:38:06', 943952775, '2022-10-18 17:38:06');
INSERT INTO
    `tb_plugin_image`
VALUES
    (134, '爬', '637b4cfe-1af9-46f0-8138-27b5cf6595a3.gif', 673745932, 776465218, 0, 776465218, '2022-10-18 17:52:18',
     776465218, '2022-10-18 17:52:18');
INSERT INTO
    `tb_plugin_image`
VALUES
    (135, '捕杀火鸡', '891bef53-b2e0-4b1d-8c56-8a6234ad9605.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-18 19:27:37', 776465218, '2022-10-18 19:27:37');
INSERT INTO
    `tb_plugin_image`
VALUES
    (136, '合情合理', 'ac303f00-b4b1-4705-8165-e12351705210.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-19 09:41:17', 1743114170, '2022-10-19 09:41:17');
INSERT INTO
    `tb_plugin_image`
VALUES
    (137, '合情合理2', 'd4f49639-0444-495e-a0e4-f6dbdd771247.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-19 14:25:10', 1743114170, '2022-10-19 14:25:10');
INSERT INTO
    `tb_plugin_image`
VALUES
    (138, 'cb', '980d4eaa-a536-4f4c-b160-7e8a13f3ce04.jpg', 673745932, 776465218, 0, 776465218, '2022-10-19 14:25:38',
     776465218, '2022-10-19 14:25:38');
INSERT INTO
    `tb_plugin_image`
VALUES
    (139, '就这', '73291a84-8c7a-4d33-862b-98f3c1272b4b.jpg', 673745932, 776465218, 0, 776465218, '2022-10-20 12:50:53',
     776465218, '2022-10-20 12:50:53');
INSERT INTO
    `tb_plugin_image`
VALUES
    (140, '不对', 'd62612ec-fd2d-4095-9201-13348237b7b0.jpg', 673745932, 776465218, 0, 776465218, '2022-10-20 12:51:48',
     776465218, '2022-10-20 12:51:48');
INSERT INTO
    `tb_plugin_image`
VALUES
    (141, 'das', 'ec621a1b-88da-4342-a94d-28651c14dc15.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-20 18:01:20', 1743114170, '2022-10-20 18:01:20');
INSERT INTO
    `tb_plugin_image`
VALUES
    (142, '我柴郡都想给你一拳', '641706ca-a900-4ea5-88fd-bb0abbf3ace1.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-08 16:01:01', 776465218, '2022-11-08 16:01:01');
INSERT INTO
    `tb_plugin_image`
VALUES
    (143, '下面我简单喵两句@碧蓝航线吧', 'db997689-d1e3-4aae-994d-a24a3e7aa4b5.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-08 16:21:18', 776465218, '2022-11-08 16:21:18');
INSERT INTO
    `tb_plugin_image`
VALUES
    (144, '见鬼了猪怎么会说话贴(碧蓝航线吧', '8b6c3414-3153-4c06-9d3b-75f8988a4e3d.jpg', 673745932, 601372611, 0,
     776465218, '2022-11-08 16:22:48', 776465218, '2022-11-08 16:22:48');
INSERT INTO
    `tb_plugin_image`
VALUES
    (145, '柴郡从来不看这种色色的东西', '5a6eabff-c756-4754-a011-2764252f0d47.jpg', 673745932, 601372611, 0, 776465218,
     '2022-11-08 16:23:58', 776465218, '2022-11-08 16:23:58');
INSERT INTO
    `tb_plugin_image`
VALUES
    (146, '猫听完也死了', 'e62c4414-472f-4694-8430-62f50c743ae2.png', 673745932, 776465218, 0, 776465218,
     '2022-11-08 16:26:27', 776465218, '2022-11-08 16:26:27');
INSERT INTO
    `tb_plugin_image`
VALUES
    (147, '早上坏', 'db6a8575-8d96-48fa-aada-6a1f427e7b0d.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 10:40:59', 776465218, '2022-11-10 10:40:59');
INSERT INTO
    `tb_plugin_image`
VALUES
    (148, '有这种事?', 'cd85c6ba-3db5-4439-8393-f9891eb4fce8.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 10:45:20', 776465218, '2022-11-10 10:45:20');
INSERT INTO
    `tb_plugin_image`
VALUES
    (149, '纵须猛犸屎山堆出来了', '6c6323de-84aa-4a31-939f-eb4ca0d3f353.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 11:20:00', 776465218, '2022-11-10 11:20:00');
INSERT INTO
    `tb_plugin_image`
VALUES
    (150, '奥欸', '97d53d08-679a-4d43-a33f-aeb0e58f1c9c.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 11:30:06',
     776465218, '2022-11-10 11:30:06');
INSERT INTO
    `tb_plugin_image`
VALUES
    (151, '奥欸(', 'c69ac875-4a48-4b3f-808e-cf3cae17b6a2.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 11:30:34', 776465218, '2022-11-10 11:30:34');
INSERT INTO
    `tb_plugin_image`
VALUES
    (152, '奥欸饿哦爱哦二', '8fd887c8-88cc-4e7f-9350-2a4bb0a02e17.gif', 673745932, 776465218, 0, 776465218,
     '2022-11-10 11:38:27', 776465218, '2022-11-10 11:38:27');
INSERT INTO
    `tb_plugin_image`
VALUES
    (153, '奥欸饿哦爱哦二564', 'bf310f2f-fcd6-45b7-a538-e4da9233cd72.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 11:41:37', 776465218, '2022-11-10 11:41:37');
INSERT INTO
    `tb_plugin_image`
VALUES
    (154, '寄', 'ba94e07c-dc2c-4101-b7b3-89ee66037d0a.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:02:57',
     776465218, '2022-11-10 13:02:57');
INSERT INTO
    `tb_plugin_image`
VALUES
    (155, '乐乐', 'a39466dd-5f7b-41d7-a848-6c7df96575e8.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:04:29',
     776465218, '2022-11-10 13:04:29');
INSERT INTO
    `tb_plugin_image`
VALUES
    (156, '乐乐乐', '0b1cdb50-d274-41ed-9b70-55abd6c8a1a6.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 13:05:47', 776465218, '2022-11-10 13:05:47');
INSERT INTO
    `tb_plugin_image`
VALUES
    (157, '乐乐乐乐乐', '51e0f6cb-baff-4e9e-b2cc-d33273817af1.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 13:08:42', 776465218, '2022-11-10 13:08:42');
INSERT INTO
    `tb_plugin_image`
VALUES
    (158, '乐乐乐乐乐乐', 'd52b9df8-a1a6-4e1b-b617-b53818b3a0cd.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 13:09:46', 776465218, '2022-11-10 13:09:46');
INSERT INTO
    `tb_plugin_image`
VALUES
    (159, '乐乐乐乐乐乐奥欸', 'ff7a03e0-7cb6-4354-8e14-aa6869a1aa55.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 13:40:46', 776465218, '2022-11-10 13:40:46');
INSERT INTO
    `tb_plugin_image`
VALUES
    (160, '乐乐乐乐乐乐奥欸存图', '3ba1c044-29dd-4776-8d20-33bf00ff39b3.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 13:42:03', 776465218, '2022-11-10 13:42:03');
INSERT INTO
    `tb_plugin_image`
VALUES
    (161, '乐乐乐乐乐乐奥欸存图存图', '3b3f1382-4c6c-49e4-8089-e960d6f0c9b6.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 13:43:05', 776465218, '2022-11-10 13:43:05');
INSERT INTO
    `tb_plugin_image`
VALUES
    (162, '乐乐乐乐乐乐奥', '889d6922-9591-478b-97d2-e54f917181ca.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 13:43:30', 776465218, '2022-11-10 13:43:30');
INSERT INTO
    `tb_plugin_image`
VALUES
    (163, '呕', 'c64199d7-e727-466f-bfa0-42776c25baed.png', 673745932, 943952775, 0, 943952775, '2022-11-10 13:50:56',
     943952775, '2022-11-10 13:50:56');
INSERT INTO
    `tb_plugin_image`
VALUES
    (164, '新年第一张图捏', '1a33d66e-2cd1-4faf-8f08-5decac92ebaa.jpeg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 13:52:09', 776465218, '2023-01-02 13:34:10');
INSERT INTO
    `tb_plugin_image`
VALUES
    (165, '艾莉丝的鱼已阅', 'd0b61e89-787b-441a-8348-7b70c9ac1077.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-10 13:52:17', 776465218, '2022-11-10 13:52:17');
INSERT INTO
    `tb_plugin_image`
VALUES
    (166, '艾莉丝的鱼知悉，图意 艾莉丝的鱼已阅', 'ea3a151a-b59f-4362-b341-f3535dd01b4b.jpg', 673745932, 776465218, 0,
     776465218,
     '2022-11-10 13:52:35', 776465218, '2022-11-10 13:52:35');
INSERT INTO
    `tb_plugin_image`
VALUES
    (167, '艾莉丝的鱼艾莉丝的鱼知悉，图意艾莉丝的鱼已阅', '5fe655f4-9589-4e82-93b1-dc2132c43208.jpg', 673745932,
     776465218, 0, 776465218,
     '2022-11-10 13:54:26', 776465218, '2022-11-10 13:54:26');
INSERT INTO
    `tb_plugin_image`
VALUES
    (168, '艾莉丝的鱼艾莉丝的鱼艾莉丝的鱼知悉， 图意艾莉丝的鱼已阅 ', 'e9977da1-88f4-498e-8c8e-a106281eb2ff.jpg',
     673745932, 776465218, 1,
     776465218, '2022-11-10 13:55:06', 776465218, '2023-01-02 14:47:53');
INSERT INTO
    `tb_plugin_image`
VALUES
    (169, '测一下', '069c570f-9afa-4e54-90cf-0da3db7fa61a.jpeg', -1, 776465218, 1, 776465218, '2023-01-02 14:46:03',
     776465218, '2023-01-02 14:46:11');
INSERT INTO
    `tb_plugin_image`
VALUES
    (170, '测测测测', 'a1cdce85-7405-45b0-b7a6-ca0ca411f67e.jpeg', -1, 776465218, 1, 776465218, '2023-01-02 14:47:03',
     776465218, '2023-01-20 09:36:29');
INSERT INTO
    `tb_plugin_image`
VALUES
    (171, '我是急急国王', '8d81cd64-7bf7-4223-8a2e-ed3dce1b36e8.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-21 17:11:28', 776465218, '2022-10-21 17:11:28');
INSERT INTO
    `tb_plugin_image`
VALUES
    (172, '你先别急', '21b3f7b1-a6d3-466e-86b1-f6ea73c60347.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-21 17:12:24', 1743114170, '2022-10-21 17:12:24');
INSERT INTO
    `tb_plugin_image`
VALUES
    (173, '我是急先锋', 'c738f684-4a04-4ed7-96a2-1a1d00cf3c3e.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-21 17:12:45', 1743114170, '2022-10-21 17:12:45');
INSERT INTO
    `tb_plugin_image`
VALUES
    (174, '❤', '99e88c6c-0317-4bab-b257-e3768ce1495a.jpg', 673745932, 776465218, 0, 776465218, '2022-10-21 17:13:24',
     776465218, '2022-10-21 17:13:24');
INSERT INTO
    `tb_plugin_image`
VALUES
    (175, '我不知道', '2ef8d3f2-3d21-48d0-87db-3e02a453731a.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-23 09:23:14', 1743114170, '2022-10-23 09:23:14');
INSERT INTO
    `tb_plugin_image`
VALUES
    (176, '你百度一下', 'e7deed9d-b243-40b1-8165-8c1e757717b1.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-23 09:23:36', 1743114170, '2022-10-23 09:23:36');
INSERT INTO
    `tb_plugin_image`
VALUES
    (177, '捏猫猫的', '80b33822-1ae2-45d9-8bc3-6615cffef141.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-23 14:05:06', 776465218, '2022-10-23 14:05:06');
INSERT INTO
    `tb_plugin_image`
VALUES
    (178, '捏猫猫滴', '06acab38-389a-4a89-b72c-7da3f47e3ae4.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-23 14:05:14', 776465218, '2022-10-23 14:05:14');
INSERT INTO
    `tb_plugin_image`
VALUES
    (179, '目睹作案现场', '3b15689e-211a-4bd8-bcf5-8cf67d624912.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-23 14:08:24', 776465218, '2022-10-23 14:08:24');
INSERT INTO
    `tb_plugin_image`
VALUES
    (180, '你百度下', 'b8fa33d5-024e-476e-922c-0e830c7baa36.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-23 14:15:04', 776465218, '2022-10-23 14:15:04');
INSERT INTO
    `tb_plugin_image`
VALUES
    (181, '停止战斗', '7406f39c-33de-4150-89b7-b1832349b901.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-23 14:15:36', 1743114170, '2022-10-23 14:15:36');
INSERT INTO
    `tb_plugin_image`
VALUES
    (182, '我呆在原地', '16ecae86-2b0e-4f15-8bfe-3cb5917bfe23.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-23 14:17:07', 1743114170, '2022-10-23 14:17:07');
INSERT INTO
    `tb_plugin_image`
VALUES
    (183, '一伯昏', '791c970f-8df8-4c32-8812-40877624497b.gif', 673745932, 776465218, 0, 776465218,
     '2022-10-23 15:02:03', 776465218, '2022-10-23 15:02:03');
INSERT INTO
    `tb_plugin_image`
VALUES
    (184, '你有问题', '71d2045a-8d53-4d40-952a-c613213dd5a6.jpg', 673745932, 943952775, 0, 943952775,
     '2022-10-23 16:43:41', 943952775, '2022-10-23 16:43:41');
INSERT INTO
    `tb_plugin_image`
VALUES
    (185, '别在这理发店', '8623be7e-c3e2-4d6b-a9ad-28e8515e7ab4.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-24 09:21:49', 601372611, '2022-10-24 09:21:49');
INSERT INTO
    `tb_plugin_image`
VALUES
    (186, '别在这里发癫', 'cd47482b-225c-42ab-9755-23839b23d1d6.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-24 09:23:12', 1743114170, '2022-10-24 09:23:12');
INSERT INTO
    `tb_plugin_image`
VALUES
    (187, '你咋跑出来了', '09c0f33c-50cf-4ad2-b166-41ad4b261220.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-24 09:23:34', 1743114170, '2022-10-24 09:23:34');
INSERT INTO
    `tb_plugin_image`
VALUES
    (188, '你没救了', '6bc3fe1a-05af-4ff2-bb1d-48dd2512fc09.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-24 09:23:50', 1743114170, '2022-10-24 09:23:50');
INSERT INTO
    `tb_plugin_image`
VALUES
    (189, '你有病', '2e961b2c-30b5-4448-af20-ca4fc9b194f2.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-24 09:24:11', 1743114170, '2022-10-24 09:24:11');
INSERT INTO
    `tb_plugin_image`
VALUES
    (190, '你就是我手中的棉花糖', '4ed861be-1aab-4d28-90e4-5cb78f822bde.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-24 09:24:39', 601372611, '2022-10-24 09:24:39');
INSERT INTO
    `tb_plugin_image`
VALUES
    (191, '我派车来接你了', '3259ddeb-670f-4336-9d20-f20c98d34616.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-24 09:27:32', 1743114170, '2022-10-24 09:27:32');
INSERT INTO
    `tb_plugin_image`
VALUES
    (192, '啧啧啧', 'ee68210e-7d1f-49fe-9cdf-3eb345721feb.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-24 10:32:20', 776465218, '2022-10-24 10:32:20');
INSERT INTO
    `tb_plugin_image`
VALUES
    (193, '淦', '20b3095c-75b9-4eb4-b81f-6c01de76fbae.jpg', 673745932, 776465218, 0, 776465218, '2022-10-24 10:37:28',
     776465218, '2022-10-24 10:37:28');
INSERT INTO
    `tb_plugin_image`
VALUES
    (194, '有傻狗', 'de60b5e2-71e4-43a8-857a-5f48488f586d.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-24 14:03:45', 776465218, '2022-10-24 14:03:45');
INSERT INTO
    `tb_plugin_image`
VALUES
    (195, '好惨哦', '38db6534-b525-4670-9db1-078233464620.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-24 14:08:59', 776465218, '2022-10-24 14:08:59');
INSERT INTO
    `tb_plugin_image`
VALUES
    (196, '关我屁事', 'f03d209b-1352-4f51-a765-c0625f4a4084.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-24 14:15:31', 776465218, '2022-10-24 14:15:31');
INSERT INTO
    `tb_plugin_image`
VALUES
    (197, 'Das疑问', '091eba48-2cef-4c6a-83dc-47bc13938456.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-24 14:16:04', 1743114170, '2022-10-24 14:16:04');
INSERT INTO
    `tb_plugin_image`
VALUES
    (198, '战术去世', 'c2a201c9-42af-4d7a-8368-2ed9cb0eb527.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-24 14:52:34', 1743114170, '2022-10-24 14:52:34');
INSERT INTO
    `tb_plugin_image`
VALUES
    (199, '敢怒不敢言', '70700236-8b0b-47cc-930b-85ebf2aa7e93.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-24 15:30:55', 1743114170, '2022-10-24 15:30:55');
INSERT INTO
    `tb_plugin_image`
VALUES
    (200, '谁提出', 'd41b4514-de1a-4425-b936-395565b52133.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-24 17:10:04', 776465218, '2022-10-24 17:10:04');
INSERT INTO
    `tb_plugin_image`
VALUES
    (201, '那不可能', 'e819dcd2-1126-45b8-95b8-4957c19cedef.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-24 17:14:24', 1743114170, '2022-10-24 17:14:24');
INSERT INTO
    `tb_plugin_image`
VALUES
    (202, '谢谢老板', 'f925c3ef-ef3b-46dc-bbf7-34c355fca2f6.png', 673745932, 776465218, 0, 776465218,
     '2022-10-24 17:39:59', 776465218, '2022-10-24 17:39:59');
INSERT INTO
    `tb_plugin_image`
VALUES
    (203, '滚', '96d9e00d-55a3-42ca-9357-31ed180c717e.png', 673745932, 776465218, 0, 776465218, '2022-10-24 18:35:23',
     776465218, '2022-10-24 18:35:23');
INSERT INTO
    `tb_plugin_image`
VALUES
    (204, '日志', '20c89359-e054-474e-b780-0a2b86834b07.png', 673745932, 776465218, 0, 776465218, '2022-10-24 20:49:10',
     776465218, '2022-10-24 20:49:10');
INSERT INTO
    `tb_plugin_image`
VALUES
    (205, '逆天', '22062636-db43-4042-a6ef-6e4e8632ca50.jpg', 673745932, 1422291466, 0, 1422291466,
     '2022-10-24 22:49:06', 1422291466, '2022-10-24 22:49:06');
INSERT INTO
    `tb_plugin_image`
VALUES
    (206, '我不信', '67418503-b489-4ea2-914d-ea56477cb12d.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-25 11:16:37', 776465218, '2022-10-25 11:16:37');
INSERT INTO
    `tb_plugin_image`
VALUES
    (207, '建议躺床上开始睡觉', '4a1562dd-6c0d-4b36-9893-24aa8149ef11.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-25 11:17:09', 776465218, '2022-10-25 11:17:09');
INSERT INTO
    `tb_plugin_image`
VALUES
    (208, '嗯好', '767475b4-371b-4c78-a901-ffd14922bfff.jpg', 673745932, 776465218, 0, 776465218, '2022-10-25 11:17:40',
     776465218, '2022-10-25 11:17:40');
INSERT INTO
    `tb_plugin_image`
VALUES
    (209, '睡觉觉鸟', '48c91570-a4ee-4d0b-acf1-ceb2fa179480.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-25 11:19:11', 1743114170, '2022-10-25 11:19:11');
INSERT INTO
    `tb_plugin_image`
VALUES
    (210, '好耶', '1f3bbf9f-4183-45c7-a87c-c13d962d2f4e.jpg', 673745932, 776465218, 0, 776465218, '2022-10-25 11:19:49',
     776465218, '2022-10-25 11:19:49');
INSERT INTO
    `tb_plugin_image`
VALUES
    (211, '使用门槛', 'be2207ce-dd58-45c6-a383-cb9ba9936021.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-25 11:20:05', 776465218, '2022-10-25 11:20:05');
INSERT INTO
    `tb_plugin_image`
VALUES
    (212, '挺有画面感的', '8f683a4f-4908-4845-9c18-fa2718354afc.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-25 12:34:54', 776465218, '2022-10-25 12:34:54');
INSERT INTO
    `tb_plugin_image`
VALUES
    (213, 'ip', '1a1b37dc-cbb5-499f-bcde-b1f5880199a7.jpg', 673745932, 776465218, 0, 776465218, '2022-10-25 15:35:15',
     776465218, '2022-10-25 15:35:15');
INSERT INTO
    `tb_plugin_image`
VALUES
    (214, '服了', '72c5d81b-1031-498f-a646-75384bafea5a.jpg', 673745932, 776465218, 0, 776465218, '2022-10-26 17:36:14',
     776465218, '2022-10-26 17:36:14');
INSERT INTO
    `tb_plugin_image`
VALUES
    (215, '改变一个人', 'd2252c34-b497-4a60-8769-4df21348562e.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-27 08:09:17', 776465218, '2022-10-27 08:09:17');
INSERT INTO
    `tb_plugin_image`
VALUES
    (216, '可乐很冰', '110f9999-4328-4f7e-84f5-4017d59536d2.jpg', 673745932, 601372611, 0, 601372611,
     '2022-10-27 20:05:13', 601372611, '2022-10-27 20:05:13');
INSERT INTO
    `tb_plugin_image`
VALUES
    (217, 'sakana', 'd442d811-fe54-4ed1-ad4e-dc50a64548b6.jpg', 673745932, 776465218, 0, 776465218,
     '2022-10-28 15:14:58', 776465218, '2022-10-28 15:14:58');
INSERT INTO
    `tb_plugin_image`
VALUES
    (218, '什么jb', '6b6df425-a098-416c-9ec7-88224c96c023.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-30 10:49:48', 1743114170, '2022-10-30 10:49:48');
INSERT INTO
    `tb_plugin_image`
VALUES
    (219, '我指定是不行了', 'e46cd1f8-b209-4b5d-9d2b-b6cb2b1fed52.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-10-31 08:31:01', 1743114170, '2022-10-31 08:31:01');
INSERT INTO
    `tb_plugin_image`
VALUES
    (220, '不许乐', 'e55a22bc-591e-4f9e-8773-90cf8313e202.png', -1, 776465218, 0, 776465218, '2022-10-31 08:54:05',
     776465218, '2022-10-31 08:54:05');
INSERT INTO
    `tb_plugin_image`
VALUES
    (221, '没发过就是没看过', '48bc92de-4cb7-496f-a3ea-593387f6d70c.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-01 09:26:17', 776465218, '2022-11-01 09:26:17');
INSERT INTO
    `tb_plugin_image`
VALUES
    (222, '推荐你买小米', '94917e6a-b92d-47ad-8fa3-f51be9561ca1.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-11-01 09:45:19', 1743114170, '2022-11-01 09:45:19');
INSERT INTO
    `tb_plugin_image`
VALUES
    (223, '发生什么事了', 'd495ecaa-4c63-4baa-8867-8670f68dca4e.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-11-02 09:54:26', 1743114170, '2022-11-02 09:54:26');
INSERT INTO
    `tb_plugin_image`
VALUES
    (224, '处男', 'b23f2c54-8539-4529-a60a-7d091c1fc58c.jpg', 673745932, 776465218, 0, 776465218, '2022-11-02 10:30:51',
     776465218, '2022-11-02 10:30:51');
INSERT INTO
    `tb_plugin_image`
VALUES
    (225, '这都给你存下来了', 'f1172796-426c-4069-9e8d-2c681d5478b8.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-03 09:51:56', 776465218, '2022-11-03 09:51:56');
INSERT INTO
    `tb_plugin_image`
VALUES
    (226, '我有说过这话吗', '8d321840-cbfc-46c1-9929-ae8a37ad32d0.jpg', 673745932, 943952775, 0, 943952775,
     '2022-11-03 11:10:18', 943952775, '2022-11-03 11:10:18');
INSERT INTO
    `tb_plugin_image`
VALUES
    (227, '什么勾8', '1fda70c6-b790-42d1-8701-3af9abbe6bc4.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-03 11:10:55', 776465218, '2022-11-03 11:10:55');
INSERT INTO
    `tb_plugin_image`
VALUES
    (228, '我有说过这话吗2', '5435dd18-4fb0-4cda-8ad1-17977473a2f6.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-03 11:11:12', 776465218, '2022-11-03 11:11:12');
INSERT INTO
    `tb_plugin_image`
VALUES
    (229, '取图取图乐', '5feac571-d96e-42e0-8198-94116ac329d3.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-03 11:11:38', 776465218, '2022-11-03 11:11:38');
INSERT INTO
    `tb_plugin_image`
VALUES
    (230, '呵 老狗', '18e50d19-2cb5-4fb1-94fd-8aaa06ab2ce9.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-11-03 13:46:21', 1743114170, '2022-11-03 13:46:21');
INSERT INTO
    `tb_plugin_image`
VALUES
    (231, '狠人', '3f2d100c-22cd-4c1f-968a-211064847687.jpg', 673745932, 776465218, 0, 776465218, '2022-11-04 10:13:14',
     776465218, '2022-11-04 10:13:14');
INSERT INTO
    `tb_plugin_image`
VALUES
    (232, '仓皇出逃', '10d09927-3640-424e-ad43-e8dcf2a99a77.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-11-07 18:23:35', 1743114170, '2022-11-07 18:23:35');
INSERT INTO
    `tb_plugin_image`
VALUES
    (233, '大家早上好', 'a3f66b10-315b-4a50-8010-57287f04afbc.gif', 673745932, 1743114170, 0, 1743114170,
     '2022-11-08 10:11:37', 1743114170, '2022-11-08 10:11:37');
INSERT INTO
    `tb_plugin_image`
VALUES
    (234, '哥哥你好帅', 'ac0862cb-1362-454f-b304-5c06fe47ab53.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-11-08 10:11:58', 1743114170, '2022-11-08 10:11:58');
INSERT INTO
    `tb_plugin_image`
VALUES
    (235, '老人看手机', '891f6f0d-6450-4512-81a1-6e76ada695d8.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-08 14:16:41', 776465218, '2022-11-08 14:16:41');
INSERT INTO
    `tb_plugin_image`
VALUES
    (236, '你是什么Das', '87e78707-5286-4e8b-acd4-96d5bc23e81a.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-08 15:31:08', 776465218, '2022-11-08 15:31:08');
INSERT INTO
    `tb_plugin_image`
VALUES
    (237, '噫', '9eddecdb-2097-4dd1-8a2f-93a513113039.jpg', 673745932, 1743114170, 0, 1743114170, '2022-11-09 14:57:45',
     1743114170, '2022-11-09 14:57:45');
INSERT INTO
    `tb_plugin_image`
VALUES
    (238, '噫2', '200ff85e-fe22-4a7d-8d64-4e83dcfba469.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-11-09 14:57:54', 1743114170, '2022-11-09 14:57:54');
INSERT INTO
    `tb_plugin_image`
VALUES
    (239, '早', 'dc1680f5-f203-4692-9300-75787d674a6f.jpg', 673745932, 1422291466, 0, 1422291466, '2022-11-10 10:35:02',
     1422291466, '2022-11-10 10:35:02');
INSERT INTO
    `tb_plugin_image`
VALUES
    (240, '孕吐', 'f344f28e-52d1-45f2-b323-50ff19711dca.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:51:29',
     776465218, '2022-11-10 13:51:29');
INSERT INTO
    `tb_plugin_image`
VALUES
    (241, '套娃', '88dbdb4f-76b3-4832-bb63-55d57857a60c.jpg', 673745932, 776465218, 0, 776465218, '2022-11-10 13:55:27',
     776465218, '2022-11-10 13:55:27');
INSERT INTO
    `tb_plugin_image`
VALUES
    (242, 'work', '436e0ad6-67f0-47fd-a2b3-dcf6d377b5a1.gif', 673745932, 776465218, 0, 776465218, '2022-11-13 21:58:59',
     776465218, '2022-11-13 21:58:59');
INSERT INTO
    `tb_plugin_image`
VALUES
    (243, '你不要再睡了', '2a49f594-f753-4209-8cdd-9725e201e10c.jpg', 673745932, 601372611, 0, 601372611,
     '2022-11-16 17:07:21', 601372611, '2022-11-16 17:07:21');
INSERT INTO
    `tb_plugin_image`
VALUES
    (244, '你这像素', 'd0ec31da-537a-4f50-b2fc-509b197b9782.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-11-16 17:20:29', 1743114170, '2022-11-16 17:20:29');
INSERT INTO
    `tb_plugin_image`
VALUES
    (245, '我来了', 'e4170bc4-d2b9-4831-ac4e-4a24a849b038.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-11-16 17:20:41', 1743114170, '2022-11-16 17:20:41');
INSERT INTO
    `tb_plugin_image`
VALUES
    (246, 'Das挠头', 'bd45e3bf-b38b-4af6-bc86-04f1e2c96c34.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-16 19:25:56', 776465218, '2022-11-16 19:25:56');
INSERT INTO
    `tb_plugin_image`
VALUES
    (247, '啊对对对', '1cacb876-181c-41d6-be52-2a7abb170eb2.jpg', 673745932, 776465218, 1, 776465218,
     '2022-11-17 10:19:49', 776465218, '2022-11-17 10:19:49');
INSERT INTO
    `tb_plugin_image`
VALUES
    (248, '啊对对对zxy', '9792166f-5ca1-4266-bdf1-d8c5081a75f2.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-17 10:20:51', 776465218, '2022-11-17 10:20:51');
INSERT INTO
    `tb_plugin_image`
VALUES
    (249, '腰子给你噶了', '52e93c8b-45d1-4023-a788-b6beab47065f.jpg', 673745932, 776465218, 0, 776465218,
     '2022-11-23 08:44:28', 776465218, '2022-11-23 08:44:28');
INSERT INTO
    `tb_plugin_image`
VALUES
    (250, '大寄', '99251532-322a-4db5-be07-08eef9eb3b35.jpg', 673745932, 776465218, 0, 776465218, '2022-11-25 18:04:35',
     776465218, '2022-11-25 18:04:35');
INSERT INTO
    `tb_plugin_image`
VALUES
    (251, '这个点还没起床的', '8d3e51a2-fd63-46f5-8dc2-9f0423d885c6.jpg', 673745932, 776465218, 0, 776465218,
     '2022-12-01 11:17:17', 776465218, '2022-12-01 11:17:17');
INSERT INTO
    `tb_plugin_image`
VALUES
    (252, '一路走好', 'fa16d39b-fc70-46ce-8dc8-0004f8243f60.jpg', 673745932, 776465218, 0, 776465218,
     '2022-12-01 12:43:20', 776465218, '2022-12-01 12:43:20');
INSERT INTO
    `tb_plugin_image`
VALUES
    (253, '哪来的狗', 'bad681d8-72c4-42a4-ab72-e94047507b74.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-12-01 15:28:34', 1743114170, '2022-12-01 15:28:34');
INSERT INTO
    `tb_plugin_image`
VALUES
    (254, '偷心', '5b4c3c82-a556-4578-a2d7-f2eb66dc3be9.jpg', 673745932, 1422291466, 0, 1422291466,
     '2022-12-01 15:53:18', 1422291466, '2022-12-01 15:53:18');
INSERT INTO
    `tb_plugin_image`
VALUES
    (255, '冲', '7e442bbc-f348-49da-b6fa-3a44ef840b5b.jpg', 673745932, 1422291466, 0, 1422291466,
     '2022-12-05 18:45:37', 1422291466, '2022-12-05 18:45:37');
INSERT INTO
    `tb_plugin_image`
VALUES
    (256, '一二天', '31b7487e-3865-4d36-b6b5-ffb3ec80a48b.jpg', 673745932, 776465218, 0, 776465218,
     '2022-12-09 20:11:48', 776465218, '2022-12-09 20:11:48');
INSERT INTO
    `tb_plugin_image`
VALUES
    (257, '三天', '472343d8-d8ac-497f-9001-6b835a5cd6ff.jpg', 673745932, 776465218, 0, 776465218,
     '2022-12-09 20:12:02', 776465218, '2022-12-09 20:12:02');
INSERT INTO
    `tb_plugin_image`
VALUES
    (258, '四天', '832c14c1-1da9-41c3-a8a1-aa54e2566a9f.jpg', 673745932, 776465218, 0, 776465218,
     '2022-12-09 20:12:09', 776465218, '2022-12-09 20:12:09');
INSERT INTO
    `tb_plugin_image`
VALUES
    (259, '五天', '76c7bfd2-ff79-4b94-a7cc-56e7d2a2bf56.jpg', 673745932, 776465218, 0, 776465218,
     '2022-12-09 20:12:14', 776465218, '2022-12-09 20:12:14');
INSERT INTO
    `tb_plugin_image`
VALUES
    (260, '我看不懂Pro', 'f839b4e4-4041-44d4-894b-f1524ef4c287.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-12-12 15:38:46', 1743114170, '2022-12-12 15:38:46');
INSERT INTO
    `tb_plugin_image`
VALUES
    (261, '这叫抢', 'eb3851ce-44f4-4b83-964b-15c1e51b4e97.jpg', 673745932, 776465218, 0, 776465218,
     '2022-12-13 21:38:28', 776465218, '2022-12-13 21:38:28');
INSERT INTO
    `tb_plugin_image`
VALUES
    (262, '写bug呢', 'd1320669-638d-45d6-8d87-62667415d74a.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-12-19 12:37:43', 1743114170, '2022-12-19 12:37:43');
INSERT INTO
    `tb_plugin_image`
VALUES
    (263, '害你加班', 'da2f7ed1-35fb-476d-a3a2-7931c4455cf9.jpg', 673745932, 1743114170, 0, 1743114170,
     '2022-12-19 12:38:20', 1743114170, '2022-12-19 12:38:20');
INSERT INTO
    `tb_plugin_image`
VALUES
    (264, '千里眼', '516b413b-c6a2-4180-83c1-83c61e5747d1.jpg', 673745932, 943952775, 0, 943952775,
     '2022-12-27 10:46:01', 943952775, '2022-12-27 10:46:01');
INSERT INTO
    `tb_plugin_image`
VALUES
    (265, '作业', 'a245e676-02cc-40ec-b7f1-de474d6c2083.jpeg', -1, 1422291466, 0, 1422291466, '2023-01-02 21:27:14',
     1422291466, '2023-01-02 21:27:14');
INSERT INTO
    `tb_plugin_image`
VALUES
    (266, '测试', 'b952b820-7ba4-4b3d-abd3-489efd391d1c.jpg', 673745932, 776465218, 0, 776465218,
     '2023-01-02 22:44:20', 776465218, '2023-01-02 22:44:20');
INSERT INTO
    `tb_plugin_image`
VALUES
    (267, 'c', 'e21e723a-f062-45e7-a6dc-38ff59f9efa5.jpg', 673745932, 776465218, 0, 776465218, '2023-01-02 22:48:09',
     776465218, '2023-01-02 22:48:09');
INSERT INTO
    `tb_plugin_image`
VALUES
    (268, '测试测', 'ddfd1b23-a74f-4c78-b233-bde9316a873b.jpg', 673745932, 776465218, 0, 776465218,
     '2023-01-02 22:58:30', 776465218, '2023-01-02 22:58:30');
INSERT INTO
    `tb_plugin_image`
VALUES
    (269,
     '莉莉丝的仓鼠@Das收到了新的push!sender:Gitee(gitee@gitee.com)branch: test_versioncommit1:这是一条测试Push类型WebHook 触发的推送 https://gitee.com/oschina/gitee/commit/3a6902040b2fd1e240315a84611d36eef14b4f2f',
     '7796944b-0994-43e3-8b7d-a87185dfd55c.jpg', 673745932, 776465218, 1, 776465218, '2023-01-02 22:58:59',
     776465218, '2023-01-02 22:59:26');
INSERT INTO
    `tb_plugin_image`
VALUES
    (270, '好变态哦', '7ba99971-4b5f-4d12-88f1-3a0facaf469f.jpg', 673745932, 776465218, 0, 776465218,
     '2023-01-03 16:43:57', 776465218, '2023-01-03 16:43:57');
INSERT INTO
    `tb_plugin_image`
VALUES
    (271, '没有bug', 'd1337a70-c0e2-4f8b-be51-e14f976c3ff7.jpg', 673745932, 776465218, 0, 776465218,
     '2023-01-04 13:08:27', 776465218, '2023-01-04 13:08:27');
INSERT INTO
    `tb_plugin_image`
VALUES
    (272, '取图', '85957c5a-0cf3-45f1-9dcb-819f0468bde9.png', -1, 776465218, 0, 776465218, '2023-01-05 16:35:12',
     776465218, '2023-01-05 16:35:12');
INSERT INTO
    `tb_plugin_image`
VALUES
    (273, '6', '3bf8d393-dd56-4400-8922-f9681adc8d5a.jpg', 673745932, 776465218, 0, 776465218, '2023-01-06 09:51:21',
     776465218, '2023-01-06 09:51:21');
INSERT INTO
    `tb_plugin_image`
VALUES
    (274, '你是什么品种怎么这么凶', '2d460ec9-4643-42c9-a464-c63054ef007e.jpg', 673745932, 776465218, 0, 776465218,
     '2023-01-08 11:46:36', 776465218, '2023-01-08 11:46:36');
INSERT INTO
    `tb_plugin_image`
VALUES
    (275, '我喜欢', 'd8ba41a9-37f4-496b-90c3-5433bfa2feca.jpg', 673745932, 776465218, 0, 776465218,
     '2023-01-13 08:48:54', 776465218, '2023-01-13 08:48:54');
INSERT INTO
    `tb_plugin_image`
VALUES
    (276, 'xjx', '106bb47f-327d-449c-a5f7-3a3f0a5a56a7.jpg', 673745932, 776465218, 0, 776465218,
     '2023-01-14 15:25:04', 776465218, '2023-01-14 15:25:04');

-- ----------------------------
-- Table structure for tb_plugin_loaj_reply
-- ----------------------------
DROP TABLE IF EXISTS `tb_plugin_loaj_reply`;
CREATE TABLE `tb_plugin_loaj_reply`
(
    `row_id`      BIGINT(0)                                                         NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `keyword`     VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '触发关键词',
    `reply`       VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '回复',
    `ignore_case` TINYINT(1)                                                        NOT NULL COMMENT '忽略大小写',
    `ignore_dbc`  TINYINT(1)                                                        NOT NULL COMMENT '忽略全半角',
    `match_type`  TINYINT(1)                                                        NOT NULL COMMENT '匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)',
    `is_delete`   TINYINT(1)                                                        NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
    `create_user` BIGINT(0)                                                         NOT NULL COMMENT '创建用户',
    `create_time` DATETIME(0)                                                       NOT NULL COMMENT '创建时间',
    `update_user` BIGINT(0)                                                         NOT NULL COMMENT '更新用户',
    `update_time` DATETIME(0)                                                       NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`row_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  CHARACTER SET = `utf8mb4`
  COLLATE = `utf8mb4_0900_ai_ci`
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_plugin_loaj_reply
-- ----------------------------
INSERT INTO
    `tb_plugin_loaj_reply`
VALUES
    (1, 'help', 'help个屁,妹写', 1, 1, 0, 0, 776465218, '2023-01-09 14:49:34', 776465218, '2023-01-09 14:49:36');
INSERT INTO
    `tb_plugin_loaj_reply`
VALUES
    (2, '6', '7', 1, 1, 0, 0, 776465218, '2023-01-11 16:11:58', 776465218, '2023-01-11 16:11:54');
INSERT INTO
    `tb_plugin_loaj_reply`
VALUES
    (3, '傻狗', '傻狗叫谁', 1, 1, 0, 0, 776465218, '2023-01-11 16:12:17', 776465218, '2023-01-11 16:12:19');
INSERT INTO
    `tb_plugin_loaj_reply`
VALUES
    (4, '你拍一', '我拍一', 1, 1, 0, 0, 776465218, '2023-01-11 18:15:13', 776465218, '2023-01-11 18:15:13');
INSERT INTO
    `tb_plugin_loaj_reply`
VALUES
    (5, 'DasServer start', '来啦老弟', 1, 1, 0, 0, 776465218, '2023-01-12 18:43:12', 776465218, '2023-01-12 18:43:12');
INSERT INTO
    `tb_plugin_loaj_reply`
VALUES
    (6, '1', '2', 1, 1, 0, 0, 776465218, '2023-01-19 15:00:02', 776465218, '2023-01-19 15:00:02');
INSERT INTO
    `tb_plugin_loaj_reply`
VALUES
    (7, '来点瑟图', '傻狗', 1, 1, 0, 0, 776465218, '2023-01-22 20:03:54', 776465218, '2023-01-22 20:03:54');

-- ----------------------------
-- Table structure for tb_plugin_schedule
-- ----------------------------
DROP TABLE IF EXISTS `tb_plugin_schedule`;
CREATE TABLE `tb_plugin_schedule`
(
    `row_id`                INT(0)                                                            NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `cron`                  VARCHAR(30) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci`  NOT NULL COMMENT 'cron表达式',
    `run_method`            VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '执行方法名',
    `run_method_class_name` VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '执行方法类',
    `parameter_class_name`  VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '执行方法参数类名',
    `parameter_json`        VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '执行方法参数(json格式)',
    `description`           VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '定时任务描述',
    `enable`                TINYINT(1)                                                        NOT NULL COMMENT '是否启用',
    `is_delete`             TINYINT(1)                                                        NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
    `create_user`           BIGINT(0)                                                         NOT NULL COMMENT '创建用户',
    `create_time`           DATETIME(0)                                                       NOT NULL COMMENT '创建时间',
    `update_user`           BIGINT(0)                                                         NOT NULL COMMENT '更新用户',
    `update_time`           DATETIME(0)                                                       NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`row_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = `utf8mb4`
  COLLATE = `utf8mb4_0900_ai_ci` COMMENT = 'plugin-sys-schedule 任务调度插件记录表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_plugin_schedule
-- ----------------------------
INSERT INTO
    `tb_plugin_schedule`
VALUES
    (1, '1 * * * * ?', 'sendShamMessage', 'com.dasoops.dasserver.plugin.schedule.task.ScheduleTask',
     'com.dasoops.dasserver.plugin.schedule.entity.param.ShamMessageScheduleParam',
     '{\"message\":\"echo 定时任务测试\",\"groupId\":\"673745932\",\"userId\":\"776465218\",\"xSelfId\":\"3488521150\"}',
     '测试任务', 0, 0, 776465218, '2023-01-20 18:05:57', 776465218, '2023-01-20 18:06:02');
INSERT INTO
    `tb_plugin_schedule`
VALUES
    (2, '0 0 3 ? * 2', 'sendShamMessage', 'com.dasoops.dasserver.plugin.schedule.task.ScheduleTask',
     'com.dasoops.dasserver.plugin.schedule.entity.param.ShamMessageScheduleParam',
     '{\"message\":\"quietIncrementMutation\",\"groupId\":\"673745932\",\"userId\":\"776465218\",\"xSelfId\":\"3488521150\"}',
     '每周突变记录数自增', 1, 0, 776465218, '2023-01-20 18:05:57', 776465218, '2023-01-20 18:06:02');

-- ----------------------------
-- Table structure for tb_plugin_star_craft_2_factor
-- ----------------------------
DROP TABLE IF EXISTS `tb_plugin_star_craft_2_factor`;
CREATE TABLE `tb_plugin_star_craft_2_factor`
(
    `row_id`          BIGINT(0)                                                         NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`            VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '名称',
    `score`           VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '分数',
    `description`     VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '描述',
    `image_file_name` VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '对应图片名称',
    `is_delete`       TINYINT(1)                                                        NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
    `create_user`     BIGINT(0)                                                         NOT NULL COMMENT '创建用户',
    `create_time`     DATETIME(0)                                                       NOT NULL COMMENT '创建时间',
    `update_user`     BIGINT(0)                                                         NOT NULL COMMENT '更新用户',
    `update_time`     DATETIME(0)                                                       NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`row_id`) USING BTREE,
    INDEX `INDEX_NAME` (`name`, `image_file_name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 69
  CHARACTER SET = `utf8mb4`
  COLLATE = `utf8mb4_0900_ai_ci` COMMENT = 'sc2 因子'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_plugin_star_craft_2_factor
-- ----------------------------
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (1, '时间扭曲', '1', '地图上会周期性地部署敌人的时间扭曲。', 'eda5de58-4f95-4f19-ad84-c213c5e50b69.jpg', 0, -1,
     '2022-10-18 19:29:21',
     -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (2, '闪避机动', '1', '敌方单位受到伤害时将传送一小段距离。', 'd7d8c92a-4028-4fb2-b612-b43da1b1aaa8.jpg', 0, -1,
     '2022-10-18 19:29:21',
     -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (3, '短视症', '1', '玩家单位及其建筑的视野范围缩短。', 'f2132576-6939-4e3a-9990-a2270a20b386.jpg', 0, -1,
     '2022-10-18 19:29:21', -1,
     '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (4, '震荡攻击', '1', '玩家单位会被所有敌方攻击减速。', '13df4213-6cd0-4cbb-a929-1e0d5c6b3af0.jpg', 0, -1,
     '2022-10-18 19:29:21', -1,
     '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (5, '时空力场', '1', '地图上会周期性地部署敌人的时空力场。', '4614dac7-a905-4d59-8edb-ab4a3c332abd.jpg', 0, -1,
     '2022-10-18 19:29:21',
     -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (6, '轨道轰炸', '1', '敌人会在地图上周期性地施放轨道轰炸。', '136b75ab-1f93-47c7-aae9-7548fb8b11c3.jpg', 0, -1,
     '2022-10-18 19:29:21',
     -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (7, '光子过载', '1', '所有敌方建筑会攻击附近的敌对单位。', '9cfb8390-4a4b-4cd0-8f72-9f994892d9f6.jpg', 0, -1,
     '2022-10-18 19:29:21',
     -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (8, '生命吸取', '1', '敌方单位和建筑在造成伤害时偷取生命值或护盾。', '1bfbf78d-c6c0-4f66-b9d3-879bbed14ffe.jpg', 0,
     -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (9, '强行征用', '1', '敌人摧毁你的建筑后将获得建筑的控制权。', 'c7dc2da4-4473-4bbf-b003-40fda21c8390.jpg', 0, -1,
     '2022-10-18 19:29:21',
     -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (10, '行尸走肉', '2', '敌方单位在死亡时生成大量的被感染的人类，具体数量由死亡单位的生命值决定。',
     '06296f9a-5bf0-4d91-8b5c-f57e543d0c5b.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (11, '暗无天日', '2', '先前探索过的区域若离开了玩家的视野范围将会重新变成一片黑色。',
     '2fe64464-6b9e-425b-aa36-69dd4b269b33.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (12, '速度狂魔', '2', '敌方单位移动速度提高。', '3f038ee7-6642-43b3-8b13-2ebdb5638798.jpg', 0, -1,
     '2022-10-18 19:29:21', -1,
     '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (13, '晶矿护盾', '2', '玩家基地中的晶体矿簇会被周期性包覆一层护盾，必须将其摧毁才能继续采集资源。',
     '9907ac29-d575-4e7d-bf43-c7661a9519e9.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (14, '减伤屏障', '2', '敌方单位和建筑在第一次受到伤害时会获得一个临时护盾。',
     'ed7e754a-1e56-452e-8dc2-d8e993e84492.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (15, '焦土政策', '2', '敌方单位死亡时会点燃地面。', '38b36988-8ed0-4eca-a902-7dda2363aa10.jpg', 0, -1,
     '2022-10-18 19:29:21', -1,
     '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (16, '异形寄生', '2', '所有敌方单位在死亡时会孵化巢虫。', '3aa42b09-6e2b-4b28-9838-3afb91baba6a.jpg', 0, -1,
     '2022-10-18 19:29:21',
     -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (17, '激光钻机', '2', '一台敌方激光钻机会不停地攻击位于敌人视野范围内的玩家单位。',
     'bef55dbc-abf5-4db6-8645-e7d595e6d879.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (18, '超远视距', '2', '敌方单位和建筑的武器射程与视野范围提高。', 'a967c80a-2747-46b3-b08c-131745aa867a.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (19, '龙卷风暴', '2', '多股龙卷风在地图上移动，对位于其行进路线上的玩家单位造成伤害并将其击退。',
     '7775bacc-bddb-4d1c-8e1f-a5631fceafed.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (20, '净化光束', '2', '地图上会出现一道敌人的净化光束并朝附近的玩家单位移动。',
     'af042327-617b-434e-8e0e-1e81c2f85da5.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (21, '鼓舞人心', '2', '敌方英雄单位提高小范围内所有敌人的攻击速度和护甲。',
     '835aae56-5727-4c7e-96b4-f7a9b5da0369.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (22, '坚强意志', '2', '敌方英雄单位附近有任何非英雄敌方单位时，其所受到的伤害最高不超过10点。',
     'a66a62cf-ee44-4df8-a1f6-7d49be596989.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (23, '默哀', '2', '敌方英雄单位死亡时，在其周围的所有玩家单位都会反思自己的过错，无法攻击或使用技能。',
     '25945535-a79f-48e3-8183-9f460f1761ed.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (24, '丧尸大战', '3', '敌方被感染的人类会不断地出现在地图上。', 'bac2cef1-175a-4e40-bbeb-598cc14d4964.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (25, '岩浆爆发', '3', '岩浆会周期性地在随机位置从地下喷发，并对玩家的空中和地面单位造成伤害。',
     '0c94e549-5a0d-4f7c-b378-8ffe81946980.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (26, '自毁程序', '3', '敌方单位死亡时发生爆炸，并对附近的玩家单位造成伤害。',
     '84664384-73a0-4052-b56a-39c994c3fe53.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (27, '进攻部署', '3', '周期性地将额外的敌方单位部署到战场上。', '21bd9f64-aeda-46f6-a055-1d98c205e15b.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (28, '来去无踪', '3', '所有敌方单位永久隐形。', 'c42f8ca5-d6b3-453b-b1f7-736b22301c79.jpg', 0, -1,
     '2022-10-18 19:29:21', -1,
     '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (29, '无边恐惧', '3', '玩家的单位在受到伤害时会不时地停止攻击，并且害怕地到处乱跑。',
     'dbe02214-3520-4ca3-a13c-60acc754e29d.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (30, '核弹打击', '3', '核弹会随机在整张地图上进行发射。', 'f68f275b-1346-4e64-ac7b-51d1343016b1.jpg', 0, -1,
     '2022-10-18 19:29:21',
     -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (31, '飞弹大战', '3', '你的建筑会不停地遭受飞弹轰炸的袭击，你必须将它们击落。',
     '18a5905f-6d31-43bc-a737-544d2dc78e63.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (32, '伤害散射', '3', '对敌人造成的伤害将平摊给所有附近的单位，包括你的单位。',
     '16bf44bc-649a-4f6c-a314-67206a856800.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (33, '双重压力', '3', '你的单位也会受到他们自身造成的所有伤害，但是会持续恢复。',
     '2b1fce4b-1099-4eae-a07d-09ab28e9f029.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (34, '致命勾引', '3', '敌方单位或建筑被摧毁后，你附近的任何单位将被牵拉至被它们的位置。',
     '43b7263f-6260-4969-a4b1-04b7d283bbaf.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (35, '强磁雷场', '4', '麦格天雷会在任务一开始布满整个地图。', '15b06e83-753b-4466-a75c-b6dd773d4043.jpg', 0, -1,
     '2022-10-18 19:29:21',
     -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (36, '暴风雪', '4', '风暴雷云在地图上飘荡，对位于其行进路线上的玩家单位造成伤害并将其冻结。',
     '3a1d1faf-7b11-4522-9af5-40800f263b83.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (37, '复仇战士', '5', '当附近的敌方单位死亡时，敌方单位的攻击速度、移动速度、护甲、生命值以及生命回复速度提高。',
     'a26b6c0c-798c-44a1-87b1-40818ea29dd8.jpg', 0,
     -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (38, '相互摧毁', '5', '敌方混合体死亡时会引爆一发核弹。', 'c2e280cc-c6e6-4ee3-96db-6cb634a83f54.jpg', 0, -1,
     '2022-10-18 19:29:21',
     -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (39, '小捞油水', '5', '玩家的工人单位采集资源的效率降低，但是地图上会生成可以拾取的资源。',
     '06a6e4f0-bcdc-4f53-9b9f-2e9b3203faf2.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (40, '虚空重生者', '5', '虚空重生者游荡在战场上，不断地复活你的敌人。', 'f5fabc2d-fef5-433b-ae92-8f3296b79bbd.jpg', 0,
     -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (41, '灵能爆表', '5', '所有敌方单位拥有能量并且使用随机技能。', '208f8ffc-de4d-4930-9818-164f6ed3b10c.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (42, '拿钱说话', '5', '对你的单位发出指令会消耗资源，数量取决于该单位的生产价格。',
     'cdc681a4-fcdf-44f8-bbb7-608e739b5b7e.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (43, '扫雷专家', '6', '数量庞大的寡妇雷和蜘蛛雷遍布整个战场。', '907d5363-d78b-4634-a56b-dc8022ef53bd.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (44, '杀戮机器人', '6',
     '来源不明的进攻性机器人已被释放到了科普卢星区，意图制造毁灭。经过用心险恶的工程改造后，它们在达到预先设定的击杀数量之前都是无敌的存在。只有在那之后，它们才能被阻止。不过，你能撑到最后吗？',
     '0941635d-1915-472b-a9da-ac7ac5ed9b28.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (45, '给我死吧', '7', '敌方单位死亡后会自动复活。', 'c744f035-a1b0-447e-be28-e4563cf22232.jpg', 0, -1,
     '2022-10-18 19:29:21', -1,
     '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (46, '极性不定', '7', '每一个敌方单位不是对你的单位免疫，就是对你盟友的单位免疫。',
     '9324b5b0-3b39-4b97-b90d-39d39af6d022.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (47, '力量蜕变', '7', '敌方单位造成伤害时有一定几率变形成更强大的单位。', '1b628a5f-fffb-44a8-abf2-83772ae041aa.jpg',
     0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (48, '黑死病', '7',
     '一些敌方单位携带着一种疫病，不仅会持续造成伤害，还会传染给附近的其它单位。此类敌人被消灭时，他们会把这种疫病传染给你的单位。',
     '2322d2b1-f604-463a-a736-b9f5b4bfd858.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (49, '同化体', '8', '无形的软泥怪缓慢爬向你的基地，被其接触到的任何单位和建筑都将变成和它们一样的复制体。',
     'e22c952d-05ed-4fe3-abea-5c4ed7159085.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (50, '虚空裂隙', '10', '虚空裂隙周期性地出现在随机位置，并会不断地生成敌方单位，直至其被摧毁。',
     '5956b7e2-f51e-4317-b7b5-2bfc2c1b4c04.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (51, '风暴英雄', '10', '每一轮攻击波次都会由实力越来越强的英雄率领。', '47bfc0ed-0b1e-4e36-91ba-a06b15bc199d.jpg', 0,
     -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (52, '上班偷睡', '0', '玩家的工人单位会周期性地陷入沉睡，必须使用命令面板上的“苏醒”技能才能将其唤醒。',
     'f8eb2315-af2b-48f2-b36f-aad51e3d3e9d.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (53, '石像狂热者', '0', '敌人已部署石像狂热者。', '65401f43-007c-4c0f-8054-c28236ac9e12.jpg', 0, -1,
     '2022-10-18 19:29:21', -1,
     '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (54, '混乱工作室', '0', '突变因子会随机选择，并且在任务中周期性轮换。', '820e978e-bad4-4b55-b51e-a5154dd4913d.jpg', 0,
     -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (55, '迷失方向', '0', '你的镜头会随机改变位置。', '13d14544-0a43-4de6-95e5-0419acfc5f0a.jpg', 0, -1,
     '2022-10-18 19:29:21', -1,
     '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (56, '不死邪魔', '0', '有只怪物缠上你了，而且你杀它的次数越多，你下一次遇到的它越强大。',
     '7b107928-413c-4f18-94a6-13397ecd8143.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (57, '惧怕黑暗', '0', '通过各种方式提供的视野都会受到极大的限制，只有你镜头中的视野一切正常。',
     '04b46a3c-a1bc-4062-a1c3-1d1f59b4e0c1.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (58, '不给糖果就捣蛋', '0',
     '平民们会拜访你的糖果碗寻找零食，这些零食是通过花费晶体矿产生的。如果没有零食可以享用，平民们就会变身成随机的敌方单位。',
     '51a14cec-12cf-45dd-a309-efebf3a4b602.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (59, '捕杀火鸡', '0', '补给只能通过击杀火鸡产生，它们在整个地图上漫游。这么做可能会激怒其它的火鸡。',
     '891bef53-b2e0-4b1d-8c56-8a6234ad9605.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (60, '补给共享', '0', '你和你的搭档共享补给，双方的部队单位会占用你们共有的补给。',
     'fb155906-7988-4f40-8770-4509fe963837.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (61, '礼尚往来', '0', '地图上会周期性地放置一些礼物。你们不抢就会便宜了埃蒙哟！',
     '738035ed-32c9-4afa-8fc6-65553a35bd5f.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (62, '杀生业报', '0', '玩家的单位和建筑每消灭一个敌人，其所受到的伤害就会提高。',
     '4481ad71-10ff-4d4b-a297-73b43a63adb0.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (63, '极度谨慎', '0', '你的单位不会接受你在他们看不见的地方所下达的任何命令。',
     '4e1b0e91-7785-4e88-9f80-d4a0430daf5a.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (64, '刺头兵', '0', '你的单位不会准确地执行命令。', 'b21960c6-9fc8-4324-a0a4-e28e36233579.jpg', 0, -1,
     '2022-10-18 19:29:21', -1,
     '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (65, '焰火秀', '0', '敌人死亡时会发射灿烂的烟花，对你周围的单位造成伤害。',
     '5966de7c-9b7e-4b7a-be4a-452cd2e5ca72.jpg', 0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (66, '幸运红包', '0', '塞满物资的节日红包，被随机丢弃在地图的各个角落。', '10e0faec-fbb2-491b-98bf-63b2b15c81ef.jpg',
     0, -1,
     '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (67, '消极战斗', '0', '你的单位先加速，然后再减速。', '896666cc-b6ba-47c6-9f2a-9f16cccab663.jpg', 0, -1,
     '2022-10-18 19:29:21', -1,
     '2022-10-18 19:29:21');
INSERT INTO
    `tb_plugin_star_craft_2_factor`
VALUES
    (68, '炸弹机器人', '0',
     '对一切都毫不在意的机器人携带着聚变弹头朝你的基地进发。一名玩家必须识别出拆弹的顺序，另一名玩家则必须正确输入才能解除危机。',
     'cadd1323-1286-46a7-a24b-04863d61949e.jpg', 0, -1, '2022-10-18 19:29:21', -1, '2022-10-18 19:29:21');

-- ----------------------------
-- Table structure for tb_plugin_star_craft_2_mutation
-- ----------------------------
DROP TABLE IF EXISTS `tb_plugin_star_craft_2_mutation`;
CREATE TABLE `tb_plugin_star_craft_2_mutation`
(
    `row_id`      BIGINT(0)                                                         NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`        VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '突变名',
    `factor`      VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '因子',
    `map`         VARCHAR(255) CHARACTER SET `utf8mb4` COLLATE `utf8mb4_0900_ai_ci` NOT NULL COMMENT '地图',
    `score`       INT(0)                                                            NOT NULL COMMENT '因子分数',
    `level`       INT(0)                                                            NOT NULL COMMENT '对应等级(+1)',
    `is_delete`   TINYINT(1)                                                        NOT NULL COMMENT '逻辑删除(0:未删除;1:删除)',
    `create_user` BIGINT(0)                                                         NOT NULL COMMENT '创建用户',
    `create_time` DATETIME(0)                                                       NOT NULL COMMENT '创建时间',
    `update_user` BIGINT(0)                                                         NOT NULL COMMENT '更新用户',
    `update_time` DATETIME(0)                                                       NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`row_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 718
  CHARACTER SET = `utf8mb4`
  COLLATE = `utf8mb4_0900_ai_ci` COMMENT = 'sc2 突变'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_plugin_star_craft_2_mutation
-- ----------------------------
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (1, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (2, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (3, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (4, '恶劣天气', '虚空裂隙,龙卷风暴', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (5, '雪茫危机', '暴风雪,小捞油水', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (6, '战场炼狱', '焦土政策,岩浆爆发,闪避机动', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (7, '痛苦神庙', '晶矿护盾,减伤屏障,复仇战士', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (8, '末日之矛', '轨道轰炸,时空力场,净化光束', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (9, '特别快递', '进攻部署,自毁程序,异形寄生', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (10, '城市巷战', '光子过载,扫雷专家,来去无踪', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (11, '灾难之轮', '混乱工作室', '虚空撕裂', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (12, '完美风暴', '暴风雪,龙卷风暴,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (13, '全面核战', '核弹打击,自毁程序,无边恐惧', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (14, '黑暗仪式', '灵能爆表,速度狂魔', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (15, '完全失控', '拿钱说话,暗无天日,时间扭曲', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (16, '燃烧军团', '焦土政策,虚空裂隙,复仇战士', '天界封锁', 17, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (17, '三重威胁', '激光钻机,轨道轰炸,丧尸大战', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (18, '烈焰战场', '飞弹大战,核弹打击,净化光束', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (19, '失心疯', '迷失方向,无边恐惧,闪避机动', '升格之链', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (20, '威胁递增', '力量蜕变,相互摧毁,异形寄生', '机会渺茫', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (21, '资源危机', '强磁雷场,无边恐惧,小捞油水', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (22, '外交豁免', '极性不定,闪避机动,减伤屏障', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (23, '灾难之轮', '混乱工作室', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (24, '造恶之息', '速度狂魔,进攻部署,复仇战士', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (25, '惊魂之夜', '惧怕黑暗,不给糖果就捣蛋', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (26, '玩火自焚', '行尸走肉,异形寄生,焦土政策', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (27, '天轰地爆', '核弹打击,相互摧毁,自毁程序', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (28, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (29, '能量超负', '灵能爆表,超远视距,光子过载', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (30, '拉克希尔大乱斗', '丧尸大战,速度狂魔,给我死吧', '升格之链', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (31, '适者生存', '减伤屏障,力量蜕变', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (32, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (33, '丛林激斗', '来去无踪,进攻部署,时空力场', '机会渺茫', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (34, '终极代价', '拿钱说话,晶矿护盾,飞弹大战', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (35, '火葬仪式', '虚空重生者,焦土政策', '营救矿工', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (36, '高举盾牌！', '伤害散射,晶矿护盾,短视症', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (37, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (38, '死疫横生', '黑死病,拿钱说话', '机会渺茫', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (39, '旧忆重惊', '强行征用,相互摧毁', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (40, '星门异动', '虚空裂隙,灵能爆表', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (41, '灾难之轮', '混乱工作室', '熔火危机', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (42, '强行霸占', '飞弹大战,强行征用,激光钻机', '克哈裂痕', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (43, '死亡危机', '虚空重生者,行尸走肉,力量蜕变', '往日神庙', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (44, '黑暗时刻', '风暴英雄,坚强意志,鼓舞人心', '克哈裂痕', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (45, '没钱麻烦大了', '小捞油水,自毁程序,龙卷风暴', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (46, '雷鸣弹啸', '极性不定,扫雷专家', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (47, '杀机讯发', '玩家对战', '背叛平原', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (48, '疫鬼狂潮', '速度狂魔,黑死病', '亡者之夜', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (49, '隐形威胁', '来去无踪,净化光束', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (50, '灾难之轮', '混乱工作室', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (51, '噬骨之寒', '强磁雷场,暴风雪', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (52, '无间死局', '复仇战士,虚空重生者', '升格之链', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (53, '火线快递', '给我死吧,核弹打击,减伤屏障', '虚空降临', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (54, '烈火金刚', '致命勾引,自毁程序,行尸走肉', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (55, '寒冷即是虚空', '暴风雪,虚空重生者,虚空裂隙', '湮灭快车', 19, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (56, '异形进击', '同化体,时空力场,震荡攻击', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (57, '硬骨头', '坚强意志,极性不定,减伤屏障', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (58, '疫区逃生', '暗无天日,光子过载,黑死病', '营救矿工', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (59, '步步为营', '时间扭曲,速度狂魔,震荡攻击', '机会渺茫', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (60, '现世现报', '双重压力,相互摧毁,自毁程序', '升格之链', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (61, '仁至义尽', '给我死吧,超远视距,鼓舞人心', '往日神庙', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (62, '飞蛾扑火', '致命勾引,净化光束,异形寄生', '克哈裂痕', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (63, '火海惊魂', '虚空裂隙,无边恐惧', '熔火危机', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (64, '灾难之轮', '混乱工作室', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (65, '机器人大战', '杀戮机器人,默哀', '机会渺茫', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (66, '磁性牵引', '强磁雷场,致命勾引,来去无踪', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (67, '地发杀机', '焦土政策,岩浆爆发,扫雷专家', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (68, '天发杀机', '进攻部署,飞弹大战,轨道轰炸', '虚空降临', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (69, '兵贵神速', '速度狂魔,同化体', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (70, '自作自受', '相互摧毁,双重压力', '黑暗杀星', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (71, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (72, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (73, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (74, '恶劣天气', '虚空裂隙,龙卷风暴', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (75, '雪茫危机', '暴风雪,小捞油水', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (76, '战场炼狱', '焦土政策,岩浆爆发,闪避机动', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (77, '痛苦神庙', '晶矿护盾,减伤屏障,复仇战士', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (78, '末日之矛', '轨道轰炸,时空力场,净化光束', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (79, '特别快递', '进攻部署,自毁程序,异形寄生', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (80, '城市巷战', '光子过载,扫雷专家,来去无踪', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (81, '灾难之轮', '混乱工作室', '虚空撕裂', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (82, '完美风暴', '暴风雪,龙卷风暴,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (83, '全面核战', '核弹打击,自毁程序,无边恐惧', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (84, '黑暗仪式', '灵能爆表,速度狂魔', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (85, '完全失控', '拿钱说话,暗无天日,时间扭曲', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (86, '燃烧军团', '焦土政策,虚空裂隙,复仇战士', '天界封锁', 17, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (87, '三重威胁', '激光钻机,轨道轰炸,丧尸大战', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (88, '烈焰战场', '飞弹大战,核弹打击,净化光束', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (89, '失心疯', '迷失方向,无边恐惧,闪避机动', '升格之链', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (90, '威胁递增', '力量蜕变,相互摧毁,异形寄生', '机会渺茫', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (91, '资源危机', '强磁雷场,无边恐惧,小捞油水', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (92, '外交豁免', '极性不定,闪避机动,减伤屏障', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (93, '灾难之轮', '混乱工作室', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (94, '造恶之息', '速度狂魔,进攻部署,复仇战士', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (95, '惊魂之夜', '惧怕黑暗,不给糖果就捣蛋', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (96, '玩火自焚', '行尸走肉,异形寄生,焦土政策', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (97, '天轰地爆', '核弹打击,相互摧毁,自毁程序', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (98, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (99, '能量超负', '灵能爆表,超远视距,光子过载', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (100, '拉克希尔大乱斗', '丧尸大战,速度狂魔,给我死吧', '升格之链', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (101, '适者生存', '减伤屏障,力量蜕变', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (102, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (103, '丛林激斗', '来去无踪,进攻部署,时空力场', '机会渺茫', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (104, '终极代价', '拿钱说话,晶矿护盾,飞弹大战', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (105, '火葬仪式', '虚空重生者,焦土政策', '营救矿工', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (106, '高举盾牌！', '伤害散射,晶矿护盾,短视症', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (107, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (108, '死疫横生', '黑死病,拿钱说话', '机会渺茫', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (109, '旧忆重惊', '强行征用,相互摧毁', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (110, '星门异动', '虚空裂隙,灵能爆表', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (111, '灾难之轮', '混乱工作室', '熔火危机', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (112, '强行霸占', '飞弹大战,强行征用,激光钻机', '克哈裂痕', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (113, '死亡危机', '虚空重生者,行尸走肉,力量蜕变', '往日神庙', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (114, '黑暗时刻', '风暴英雄,坚强意志,鼓舞人心', '克哈裂痕', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (115, '没钱麻烦大了', '小捞油水,自毁程序,龙卷风暴', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (116, '雷鸣弹啸', '极性不定,扫雷专家', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (117, '疫鬼狂潮', '速度狂魔,黑死病', '亡者之夜', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (118, '隐形威胁', '来去无踪,净化光束', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (119, '灾难之轮', '混乱工作室', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (120, '封禁行为', '灵能爆表,闪避机动', '净网行动', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (121, '午夜大师', '生命吸取,短视症,无边恐惧', '聚铁成兵', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (122, '雷场夜战', '惧怕黑暗,强磁雷场', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (123, '极限压迫', '强行征用,晶矿护盾,自毁程序', '亡者之夜', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (124, '杀劫迫临', '杀戮机器人,速度狂魔,鼓舞人心', '往日神庙', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (125, '时空气象战', '龙卷风暴,岩浆爆发,时间扭曲', '黑暗杀星', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (126, '死亡无声', '同化体,默哀', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (127, '无尽感染', '黑死病,行尸走肉,异形寄生', '虚空降临', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (128, '顽强作战', '飞弹大战,鼓舞人心,坚强意志', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (129, '灾难之轮', '混乱工作室', '死亡摇篮', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (130, '寒冷适应', '暴风雪,力量蜕变', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (131, '惊魂之夜', '惧怕黑暗,不给糖果就捣乱', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (132, '进步的代价', '杀戮机器人,拿钱说话', '净网行动', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (133, '消极增员', '致命勾引,复仇战士', '聚铁成兵', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (134, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (135, '报应不爽', '虚空裂隙,双重压力', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (136, '灰烬重生', '自毁程序,虚空重生者,岩浆爆发', '黑暗杀星', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (137, '扭曲空间', '时空力场,时间扭曲,龙卷风暴', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (138, '训练有素', '鼓舞人心,进攻部署,复仇战士', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (139, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (140, '末日报告', '同化体,核弹打击,轨道轰炸', '熔火危机', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (141, '安全违规', '自毁程序,激光钻机,强磁雷场', '营救矿工', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (142, '重生神殿', '给我死吧,减伤屏障,生命吸取', '往日神庙', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (143, '疯狂超频', '速度狂魔,复仇战士,光子过载', '净网行动', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (144, '消耗战', '伤害散射,扫雷专家', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (145, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (146, '永不分离', '极性不定,给我死吧', '升格之链', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (147, '死亡鬼影', '来去无踪,虚空重生者', '聚铁成兵', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (148, '远距威胁', '超远视距,时间扭曲,净化光束', '亡者之夜', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (149, '辐射区', '核弹打击,丧尸大战,黑死病', '克哈裂痕', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (150, '心灵力量', '异形寄生,灵能爆表', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (151, '调遣军费', '拿钱说话,焦土政策', '死亡摇篮', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (152, '梦魇敌酋', '风暴英雄,默哀', '虚空降临', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (153, '基地翻转', '飞弹大战,净化光束,强行征用', '机会渺茫', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (154, '防火墙', '岩浆爆发,扫雷专家,减伤屏障', '净网行动', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (155, '死亡税金', '拿钱说话,小捞油水,黑死病', '亡者之夜', 17, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (156, '灾难之轮', '混乱工作室', '营救矿工', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (157, '感痛身受', '双重压力,伤害散射,时空力场', '虚空降临', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (158, '地狱列车', '给我死吧,焦土政策', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (159, '感染危机', '异形寄生,丧尸大战,自毁程序', '净网行动', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (160, '机会尽出', '速度狂魔,减伤屏障,灵能爆表', '机会渺茫', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (161, '一将千军', '坚强意志,鼓舞人心,力量蜕变', '往日神庙', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (162, '实验巨炮', '激光钻机,光子过载,超远视距', '聚铁成兵', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (163, '核族入侵', '相互摧毁,丧尸大战,坚强意志', '升格之链', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (164, '同归于尽', '极性不定,给我死吧', '黑暗杀星', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (165, '烈火营救', '强行征用,焦土政策,复仇战士', '营救矿工', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (166, '复仇者集结', '风暴英雄,复仇战士', '往日神庙', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (167, '铁轨换线', '给我死吧,极性不定', '湮灭快车', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (168, '敌对领地', '减伤屏障,光子过载,灵能爆表', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (169, '媒体抹黑', '暗无天日,飞弹大战,来去无踪', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (170, '雷霆穹顶', '风暴英雄,强磁雷场', '天界封锁', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (171, '躲灾避祸', '暗无天日,核弹打击,轨道轰炸', '黑暗杀星', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (172, '二元选择', '极性不定,虚空重生者', '净网行动', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (173, '升格蜕变', '鼓舞人心,力量蜕变', '升格之链', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (174, '森严壁垒', '减伤屏障,核弹打击,光子过载', '死亡摇篮', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (175, '双重麻烦', '杀戮机器人,同化体', '虚空降临', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (176, '星沉地裂', '进攻部署,虚空裂隙', '聚铁成兵', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (177, '赶夜车', '惧怕黑暗,短视症,速度狂魔', '湮灭快车', 3, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (178, '恐惧神庙', '惧怕黑暗,异形寄生,无边恐惧', '往日神庙', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (179, '光炫神迷', '震荡攻击,激光钻机,净化光束', '机会渺茫', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (180, '无尽花火', '异形寄生,自毁程序', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (181, '坟场夜班', '惧怕黑暗,净化光束', '亡者之夜', 2, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (182, '机器重生', '无边恐惧,给我死吧,激光钻机', '聚铁成兵', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (183, '秘密突击', '进攻部署,龙卷风暴,来去无踪', '天界封锁', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (184, '暗地破坏', '扫雷专家,虚空裂隙', '克哈裂痕', 16, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (185, '散光', '超远视距,短视症,来去无踪', '净网行动', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (186, '永不言死', '减伤屏障,给我死吧,生命吸取', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (187, '中世纪', '黑死病,力量蜕变', '黑暗杀星', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (188, '全力猛攻', '进攻部署,丧尸大战,虚空重生者', '亡者之夜', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (189, '等价交换', '伤害散射,给我死吧', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (190, '迫近的疯狂', '强行征用,净化光束,虚空裂隙', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (191, '感恩季', '暴风雪,礼尚往来,杀生业报', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (192, '决择抉择', '坚强意志,鼓舞人心,相互摧毁', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (193, '过度反应', '复仇战士,灵能爆表', '黑暗杀星', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (194, '火焰净化', '核弹打击,岩浆爆发,焦土政策', '湮灭快车', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (195, '极速增援', '时空力场,虚空裂隙', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (196, '盲目进贡', '杀戮机器人,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (197, '进击壁垒', '减伤屏障,晶矿护盾,给我死吧', '天界封锁', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (198, '虫人海啸', '异形寄生,飞弹大战,丧尸大战', '死亡摇篮', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (199, '心有灵犀', '极性不定,补给共享', '熔火危机', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (200, '夜半敲门', '复仇战士,同化体', '亡者之夜', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (201, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (202, '舞舞生疯', '默哀,速度狂魔,力量蜕变', '机会渺茫', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (203, '痛苦列车', '双重压力,核弹打击,相互摧毁', '湮灭快车', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (204, '刚硬裂隙', '给我死吧,虚空裂隙', '克哈裂痕', 17, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (205, '爆炸之链', '岩浆爆发,行尸走肉', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (206, '噩梦重临', '复仇战士,强行征用,给我死吧', '往日神庙', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (207, '排爆行动', '扫雷专家,小捞油水', '聚铁成兵', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (208, '缴税日', '无边恐惧,拿钱说话', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (209, '侵袭强征', '同化体,速度狂魔,来去无踪', '净网行动', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (210, '坟场拾荒', '丧尸大战,小捞油水', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (211, '虚空召唤', '虚空重生者,虚空裂隙', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (212, '因爱之名', '震荡攻击,净化光束,时间扭曲', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (213, '锁定击发', '杀戮机器人,晶矿护盾,时空力场', '天界封锁', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (214, '雷劫难逃', '强磁雷场,扫雷专家,飞弹大战', '营救矿工', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (215, '恶棍联盟', '闪避机动,风暴英雄', '熔火危机', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (216, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (217, '合作无间', '极性不定,同化体', '天界封锁', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (218, '冰火之歌', '暴风雪,岩浆爆发,焦土政策', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (219, '吸血鬼生活', '暗无天日,短视症,来去无踪', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (220, '硬件故障', '杀戮机器人,激光钻机,扫雷专家', '净网行动', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (221, '分担痛苦', '伤害散射,致命勾引', '聚铁成兵', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (222, '漫漫长夜', '给我死吧,超远视距,光子过载', '亡者之夜', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (223, '迅捷亡尸', '速度狂魔,虚空重生者', '黑暗杀星', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (224, '征战十年', '焰火秀,幸运红包,礼尚往来', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (225, '泡泡世界', '减伤屏障,晶矿护盾,时间扭曲', '死亡摇篮', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (226, '协同防御', '飞弹大战,极性不定', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (227, '饥不择食', '强磁雷场,扫雷专家,小捞油水', '天界封锁', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (228, '我的机器人！', '炸弹机器人,杀戮机器人', '机会渺茫', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (229, '多线操作训练', '拿钱说话,虚空裂隙', '净网行动', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (230, '老友重聚', '黑死病,暗无天日,默哀', '黑暗杀星', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (231, '万众一心', '炸弹机器人,极性不定,补给共享', '克哈裂痕', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (232, '发射升空', '核弹打击,岩浆爆发,灵能爆表', '虚空降临', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (233, '进入时空枢纽', '暴风雪,风暴英雄', '死亡摇篮', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (234, '死亡转瞬即逝', '给我死吧,虚空重生者', '亡者之夜', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (235, '批量生产', '同化体,虚空裂隙', '聚铁成兵', 18, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (236, '小心手雷', '炸弹机器人,飞弹大战', '营救矿工', 3, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (237, '亡者列车', '丧尸大战,暗无天日', '行尸走肉', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (238, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (239, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (240, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (241, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (242, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (243, '恶劣天气', '虚空裂隙,龙卷风暴', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (244, '雪茫危机', '暴风雪,小捞油水', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (245, '战场炼狱', '焦土政策,岩浆爆发,闪避机动', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (246, '痛苦神庙', '晶矿护盾,减伤屏障,复仇战士', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (247, '末日之矛', '轨道轰炸,时空力场,净化光束', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (248, '特别快递', '进攻部署,自毁程序,异形寄生', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (249, '城市巷战', '光子过载,扫雷专家,来去无踪', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (250, '灾难之轮', '混乱工作室', '虚空撕裂', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (251, '完美风暴', '暴风雪,龙卷风暴,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (252, '全面核战', '核弹打击,自毁程序,无边恐惧', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (253, '黑暗仪式', '灵能爆表,速度狂魔', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (254, '完全失控', '拿钱说话,暗无天日,时间扭曲', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (255, '燃烧军团', '焦土政策,虚空裂隙,复仇战士', '天界封锁', 17, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (256, '三重威胁', '激光钻机,轨道轰炸,丧尸大战', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (257, '烈焰战场', '飞弹大战,核弹打击,净化光束', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (258, '失心疯', '迷失方向,无边恐惧,闪避机动', '升格之链', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (259, '威胁递增', '力量蜕变,相互摧毁,异形寄生', '机会渺茫', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (260, '资源危机', '强磁雷场,无边恐惧,小捞油水', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (261, '外交豁免', '极性不定,闪避机动,减伤屏障', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (262, '灾难之轮', '混乱工作室', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (263, '造恶之息', '速度狂魔,进攻部署,复仇战士', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (264, '惊魂之夜', '惧怕黑暗,不给糖果就捣蛋', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (265, '玩火自焚', '行尸走肉,异形寄生,焦土政策', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (266, '天轰地爆', '核弹打击,相互摧毁,自毁程序', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (267, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (268, '能量超负', '灵能爆表,超远视距,光子过载', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (269, '拉克希尔大乱斗', '丧尸大战,速度狂魔,给我死吧', '升格之链', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (270, '适者生存', '减伤屏障,力量蜕变', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (271, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (272, '丛林激斗', '来去无踪,进攻部署,时空力场', '机会渺茫', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (273, '终极代价', '拿钱说话,晶矿护盾,飞弹大战', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (274, '火葬仪式', '虚空重生者,焦土政策', '营救矿工', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (275, '高举盾牌！', '伤害散射,晶矿护盾,短视症', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (276, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (277, '死疫横生', '黑死病,拿钱说话', '机会渺茫', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (278, '旧忆重惊', '强行征用,相互摧毁', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (279, '星门异动', '虚空裂隙,灵能爆表', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (280, '灾难之轮', '混乱工作室', '熔火危机', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (281, '强行霸占', '飞弹大战,强行征用,激光钻机', '克哈裂痕', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (282, '死亡危机', '虚空重生者,行尸走肉,力量蜕变', '往日神庙', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (283, '黑暗时刻', '风暴英雄,坚强意志,鼓舞人心', '克哈裂痕', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (284, '没钱麻烦大了', '小捞油水,自毁程序,龙卷风暴', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (285, '雷鸣弹啸', '极性不定,扫雷专家', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (286, '杀机讯发', '玩家对战', '背叛平原', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (287, '疫鬼狂潮', '速度狂魔,黑死病', '亡者之夜', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (288, '隐形威胁', '来去无踪,净化光束', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (289, '灾难之轮', '混乱工作室', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (290, '噬骨之寒', '强磁雷场,暴风雪', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (291, '无间死局', '复仇战士,虚空重生者', '升格之链', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (292, '火线快递', '给我死吧,核弹打击,减伤屏障', '虚空降临', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (293, '烈火金刚', '致命勾引,自毁程序,行尸走肉', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (294, '寒冷即是虚空', '暴风雪,虚空重生者,虚空裂隙', '湮灭快车', 19, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (295, '异形进击', '同化体,时空力场,震荡攻击', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (296, '硬骨头', '坚强意志,极性不定,减伤屏障', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (297, '疫区逃生', '暗无天日,光子过载,黑死病', '营救矿工', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (298, '步步为营', '时间扭曲,速度狂魔,震荡攻击', '机会渺茫', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (299, '现世现报', '双重压力,相互摧毁,自毁程序', '升格之链', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (300, '仁至义尽', '给我死吧,超远视距,鼓舞人心', '往日神庙', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (301, '飞蛾扑火', '致命勾引,净化光束,异形寄生', '克哈裂痕', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (302, '火海惊魂', '虚空裂隙,无边恐惧', '熔火危机', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (303, '灾难之轮', '混乱工作室', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (304, '机器人大战', '杀戮机器人,默哀', '机会渺茫', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (305, '磁性牵引', '强磁雷场,致命勾引,来去无踪', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (306, '地发杀机', '焦土政策,岩浆爆发,扫雷专家', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (307, '天发杀机', '进攻部署,飞弹大战,轨道轰炸', '虚空降临', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (308, '兵贵神速', '速度狂魔,同化体', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (309, '自作自受', '相互摧毁,双重压力', '黑暗杀星', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (310, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (311, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (312, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (313, '恶劣天气', '虚空裂隙,龙卷风暴', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (314, '雪茫危机', '暴风雪,小捞油水', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (315, '战场炼狱', '焦土政策,岩浆爆发,闪避机动', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (316, '痛苦神庙', '晶矿护盾,减伤屏障,复仇战士', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (317, '末日之矛', '轨道轰炸,时空力场,净化光束', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (318, '特别快递', '进攻部署,自毁程序,异形寄生', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (319, '城市巷战', '光子过载,扫雷专家,来去无踪', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (320, '灾难之轮', '混乱工作室', '虚空撕裂', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (321, '完美风暴', '暴风雪,龙卷风暴,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (322, '全面核战', '核弹打击,自毁程序,无边恐惧', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (323, '黑暗仪式', '灵能爆表,速度狂魔', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (324, '完全失控', '拿钱说话,暗无天日,时间扭曲', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (325, '燃烧军团', '焦土政策,虚空裂隙,复仇战士', '天界封锁', 17, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (326, '三重威胁', '激光钻机,轨道轰炸,丧尸大战', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (327, '烈焰战场', '飞弹大战,核弹打击,净化光束', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (328, '失心疯', '迷失方向,无边恐惧,闪避机动', '升格之链', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (329, '威胁递增', '力量蜕变,相互摧毁,异形寄生', '机会渺茫', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (330, '资源危机', '强磁雷场,无边恐惧,小捞油水', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (331, '外交豁免', '极性不定,闪避机动,减伤屏障', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (332, '灾难之轮', '混乱工作室', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (333, '造恶之息', '速度狂魔,进攻部署,复仇战士', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (334, '惊魂之夜', '惧怕黑暗,不给糖果就捣蛋', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (335, '玩火自焚', '行尸走肉,异形寄生,焦土政策', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (336, '天轰地爆', '核弹打击,相互摧毁,自毁程序', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (337, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (338, '能量超负', '灵能爆表,超远视距,光子过载', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (339, '拉克希尔大乱斗', '丧尸大战,速度狂魔,给我死吧', '升格之链', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (340, '适者生存', '减伤屏障,力量蜕变', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (341, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (342, '丛林激斗', '来去无踪,进攻部署,时空力场', '机会渺茫', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (343, '终极代价', '拿钱说话,晶矿护盾,飞弹大战', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (344, '火葬仪式', '虚空重生者,焦土政策', '营救矿工', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (345, '高举盾牌！', '伤害散射,晶矿护盾,短视症', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (346, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (347, '死疫横生', '黑死病,拿钱说话', '机会渺茫', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (348, '旧忆重惊', '强行征用,相互摧毁', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (349, '星门异动', '虚空裂隙,灵能爆表', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (350, '灾难之轮', '混乱工作室', '熔火危机', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (351, '强行霸占', '飞弹大战,强行征用,激光钻机', '克哈裂痕', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (352, '死亡危机', '虚空重生者,行尸走肉,力量蜕变', '往日神庙', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (353, '黑暗时刻', '风暴英雄,坚强意志,鼓舞人心', '克哈裂痕', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (354, '没钱麻烦大了', '小捞油水,自毁程序,龙卷风暴', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (355, '雷鸣弹啸', '极性不定,扫雷专家', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (356, '疫鬼狂潮', '速度狂魔,黑死病', '亡者之夜', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (357, '隐形威胁', '来去无踪,净化光束', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (358, '灾难之轮', '混乱工作室', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (359, '封禁行为', '灵能爆表,闪避机动', '净网行动', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (360, '午夜大师', '生命吸取,短视症,无边恐惧', '聚铁成兵', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (361, '雷场夜战', '惧怕黑暗,强磁雷场', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (362, '极限压迫', '强行征用,晶矿护盾,自毁程序', '亡者之夜', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (363, '杀劫迫临', '杀戮机器人,速度狂魔,鼓舞人心', '往日神庙', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (364, '时空气象战', '龙卷风暴,岩浆爆发,时间扭曲', '黑暗杀星', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (365, '死亡无声', '同化体,默哀', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (366, '无尽感染', '黑死病,行尸走肉,异形寄生', '虚空降临', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (367, '顽强作战', '飞弹大战,鼓舞人心,坚强意志', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (368, '灾难之轮', '混乱工作室', '死亡摇篮', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (369, '寒冷适应', '暴风雪,力量蜕变', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (370, '惊魂之夜', '惧怕黑暗,不给糖果就捣乱', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (371, '进步的代价', '杀戮机器人,拿钱说话', '净网行动', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (372, '消极增员', '致命勾引,复仇战士', '聚铁成兵', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (373, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (374, '报应不爽', '虚空裂隙,双重压力', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (375, '灰烬重生', '自毁程序,虚空重生者,岩浆爆发', '黑暗杀星', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (376, '扭曲空间', '时空力场,时间扭曲,龙卷风暴', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (377, '训练有素', '鼓舞人心,进攻部署,复仇战士', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (378, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (379, '末日报告', '同化体,核弹打击,轨道轰炸', '熔火危机', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (380, '安全违规', '自毁程序,激光钻机,强磁雷场', '营救矿工', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (381, '重生神殿', '给我死吧,减伤屏障,生命吸取', '往日神庙', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (382, '疯狂超频', '速度狂魔,复仇战士,光子过载', '净网行动', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (383, '消耗战', '伤害散射,扫雷专家', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (384, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (385, '永不分离', '极性不定,给我死吧', '升格之链', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (386, '死亡鬼影', '来去无踪,虚空重生者', '聚铁成兵', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (387, '远距威胁', '超远视距,时间扭曲,净化光束', '亡者之夜', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (388, '辐射区', '核弹打击,丧尸大战,黑死病', '克哈裂痕', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (389, '心灵力量', '异形寄生,灵能爆表', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (390, '调遣军费', '拿钱说话,焦土政策', '死亡摇篮', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (391, '梦魇敌酋', '风暴英雄,默哀', '虚空降临', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (392, '基地翻转', '飞弹大战,净化光束,强行征用', '机会渺茫', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (393, '防火墙', '岩浆爆发,扫雷专家,减伤屏障', '净网行动', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (394, '死亡税金', '拿钱说话,小捞油水,黑死病', '亡者之夜', 17, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (395, '灾难之轮', '混乱工作室', '营救矿工', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (396, '感痛身受', '双重压力,伤害散射,时空力场', '虚空降临', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (397, '地狱列车', '给我死吧,焦土政策', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (398, '感染危机', '异形寄生,丧尸大战,自毁程序', '净网行动', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (399, '机会尽出', '速度狂魔,减伤屏障,灵能爆表', '机会渺茫', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (400, '一将千军', '坚强意志,鼓舞人心,力量蜕变', '往日神庙', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (401, '实验巨炮', '激光钻机,光子过载,超远视距', '聚铁成兵', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (402, '核族入侵', '相互摧毁,丧尸大战,坚强意志', '升格之链', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (403, '同归于尽', '极性不定,给我死吧', '黑暗杀星', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (404, '烈火营救', '强行征用,焦土政策,复仇战士', '营救矿工', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (405, '复仇者集结', '风暴英雄,复仇战士', '往日神庙', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (406, '铁轨换线', '给我死吧,极性不定', '湮灭快车', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (407, '敌对领地', '减伤屏障,光子过载,灵能爆表', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (408, '媒体抹黑', '暗无天日,飞弹大战,来去无踪', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (409, '雷霆穹顶', '风暴英雄,强磁雷场', '天界封锁', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (410, '躲灾避祸', '暗无天日,核弹打击,轨道轰炸', '黑暗杀星', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (411, '二元选择', '极性不定,虚空重生者', '净网行动', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (412, '升格蜕变', '鼓舞人心,力量蜕变', '升格之链', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (413, '森严壁垒', '减伤屏障,核弹打击,光子过载', '死亡摇篮', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (414, '双重麻烦', '杀戮机器人,同化体', '虚空降临', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (415, '星沉地裂', '进攻部署,虚空裂隙', '聚铁成兵', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (416, '赶夜车', '惧怕黑暗,短视症,速度狂魔', '湮灭快车', 3, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (417, '恐惧神庙', '惧怕黑暗,异形寄生,无边恐惧', '往日神庙', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (418, '光炫神迷', '震荡攻击,激光钻机,净化光束', '机会渺茫', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (419, '无尽花火', '异形寄生,自毁程序', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (420, '坟场夜班', '惧怕黑暗,净化光束', '亡者之夜', 2, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (421, '机器重生', '无边恐惧,给我死吧,激光钻机', '聚铁成兵', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (422, '秘密突击', '进攻部署,龙卷风暴,来去无踪', '天界封锁', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (423, '暗地破坏', '扫雷专家,虚空裂隙', '克哈裂痕', 16, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (424, '散光', '超远视距,短视症,来去无踪', '净网行动', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (425, '永不言死', '减伤屏障,给我死吧,生命吸取', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (426, '中世纪', '黑死病,力量蜕变', '黑暗杀星', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (427, '全力猛攻', '进攻部署,丧尸大战,虚空重生者', '亡者之夜', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (428, '等价交换', '伤害散射,给我死吧', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (429, '迫近的疯狂', '强行征用,净化光束,虚空裂隙', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (430, '感恩季', '暴风雪,礼尚往来,杀生业报', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (431, '决择抉择', '坚强意志,鼓舞人心,相互摧毁', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (432, '过度反应', '复仇战士,灵能爆表', '黑暗杀星', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (433, '火焰净化', '核弹打击,岩浆爆发,焦土政策', '湮灭快车', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (434, '极速增援', '时空力场,虚空裂隙', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (435, '盲目进贡', '杀戮机器人,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (436, '进击壁垒', '减伤屏障,晶矿护盾,给我死吧', '天界封锁', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (437, '虫人海啸', '异形寄生,飞弹大战,丧尸大战', '死亡摇篮', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (438, '心有灵犀', '极性不定,补给共享', '熔火危机', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (439, '夜半敲门', '复仇战士,同化体', '亡者之夜', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (440, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (441, '舞舞生疯', '默哀,速度狂魔,力量蜕变', '机会渺茫', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (442, '痛苦列车', '双重压力,核弹打击,相互摧毁', '湮灭快车', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (443, '刚硬裂隙', '给我死吧,虚空裂隙', '克哈裂痕', 17, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (444, '爆炸之链', '岩浆爆发,行尸走肉', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (445, '噩梦重临', '复仇战士,强行征用,给我死吧', '往日神庙', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (446, '排爆行动', '扫雷专家,小捞油水', '聚铁成兵', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (447, '缴税日', '无边恐惧,拿钱说话', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (448, '侵袭强征', '同化体,速度狂魔,来去无踪', '净网行动', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (449, '坟场拾荒', '丧尸大战,小捞油水', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (450, '虚空召唤', '虚空重生者,虚空裂隙', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (451, '因爱之名', '震荡攻击,净化光束,时间扭曲', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (452, '锁定击发', '杀戮机器人,晶矿护盾,时空力场', '天界封锁', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (453, '雷劫难逃', '强磁雷场,扫雷专家,飞弹大战', '营救矿工', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (454, '恶棍联盟', '闪避机动,风暴英雄', '熔火危机', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (455, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (456, '合作无间', '极性不定,同化体', '天界封锁', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (457, '冰火之歌', '暴风雪,岩浆爆发,焦土政策', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (458, '吸血鬼生活', '暗无天日,短视症,来去无踪', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (459, '硬件故障', '杀戮机器人,激光钻机,扫雷专家', '净网行动', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (460, '分担痛苦', '伤害散射,致命勾引', '聚铁成兵', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (461, '漫漫长夜', '给我死吧,超远视距,光子过载', '亡者之夜', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (462, '迅捷亡尸', '速度狂魔,虚空重生者', '黑暗杀星', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (463, '征战十年', '焰火秀,幸运红包,礼尚往来', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (464, '泡泡世界', '减伤屏障,晶矿护盾,时间扭曲', '死亡摇篮', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (465, '协同防御', '飞弹大战,极性不定', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (466, '饥不择食', '强磁雷场,扫雷专家,小捞油水', '天界封锁', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (467, '我的机器人！', '炸弹机器人,杀戮机器人', '机会渺茫', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (468, '多线操作训练', '拿钱说话,虚空裂隙', '净网行动', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (469, '老友重聚', '黑死病,暗无天日,默哀', '黑暗杀星', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (470, '万众一心', '炸弹机器人,极性不定,补给共享', '克哈裂痕', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (471, '发射升空', '核弹打击,岩浆爆发,灵能爆表', '虚空降临', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (472, '进入时空枢纽', '暴风雪,风暴英雄', '死亡摇篮', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (473, '死亡转瞬即逝', '给我死吧,虚空重生者', '亡者之夜', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (474, '批量生产', '同化体,虚空裂隙', '聚铁成兵', 18, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (475, '小心手雷', '炸弹机器人,飞弹大战', '营救矿工', 3, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (476, '亡者列车', '丧尸大战,暗无天日', '行尸走肉', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (477, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (478, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (479, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (480, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (481, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (482, '恶劣天气', '虚空裂隙,龙卷风暴', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (483, '雪茫危机', '暴风雪,小捞油水', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (484, '战场炼狱', '焦土政策,岩浆爆发,闪避机动', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (485, '痛苦神庙', '晶矿护盾,减伤屏障,复仇战士', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (486, '末日之矛', '轨道轰炸,时空力场,净化光束', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (487, '特别快递', '进攻部署,自毁程序,异形寄生', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (488, '城市巷战', '光子过载,扫雷专家,来去无踪', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (489, '灾难之轮', '混乱工作室', '虚空撕裂', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (490, '完美风暴', '暴风雪,龙卷风暴,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (491, '全面核战', '核弹打击,自毁程序,无边恐惧', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (492, '黑暗仪式', '灵能爆表,速度狂魔', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (493, '完全失控', '拿钱说话,暗无天日,时间扭曲', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (494, '燃烧军团', '焦土政策,虚空裂隙,复仇战士', '天界封锁', 17, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (495, '三重威胁', '激光钻机,轨道轰炸,丧尸大战', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (496, '烈焰战场', '飞弹大战,核弹打击,净化光束', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (497, '失心疯', '迷失方向,无边恐惧,闪避机动', '升格之链', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (498, '威胁递增', '力量蜕变,相互摧毁,异形寄生', '机会渺茫', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (499, '资源危机', '强磁雷场,无边恐惧,小捞油水', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (500, '外交豁免', '极性不定,闪避机动,减伤屏障', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (501, '灾难之轮', '混乱工作室', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (502, '造恶之息', '速度狂魔,进攻部署,复仇战士', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (503, '惊魂之夜', '惧怕黑暗,不给糖果就捣蛋', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (504, '玩火自焚', '行尸走肉,异形寄生,焦土政策', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (505, '天轰地爆', '核弹打击,相互摧毁,自毁程序', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (506, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (507, '能量超负', '灵能爆表,超远视距,光子过载', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (508, '拉克希尔大乱斗', '丧尸大战,速度狂魔,给我死吧', '升格之链', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (509, '适者生存', '减伤屏障,力量蜕变', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (510, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (511, '丛林激斗', '来去无踪,进攻部署,时空力场', '机会渺茫', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (512, '终极代价', '拿钱说话,晶矿护盾,飞弹大战', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (513, '火葬仪式', '虚空重生者,焦土政策', '营救矿工', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (514, '高举盾牌！', '伤害散射,晶矿护盾,短视症', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (515, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (516, '死疫横生', '黑死病,拿钱说话', '机会渺茫', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (517, '旧忆重惊', '强行征用,相互摧毁', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (518, '星门异动', '虚空裂隙,灵能爆表', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (519, '灾难之轮', '混乱工作室', '熔火危机', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (520, '强行霸占', '飞弹大战,强行征用,激光钻机', '克哈裂痕', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (521, '死亡危机', '虚空重生者,行尸走肉,力量蜕变', '往日神庙', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (522, '黑暗时刻', '风暴英雄,坚强意志,鼓舞人心', '克哈裂痕', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (523, '没钱麻烦大了', '小捞油水,自毁程序,龙卷风暴', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (524, '雷鸣弹啸', '极性不定,扫雷专家', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (525, '杀机讯发', '玩家对战', '背叛平原', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (526, '疫鬼狂潮', '速度狂魔,黑死病', '亡者之夜', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (527, '隐形威胁', '来去无踪,净化光束', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (528, '灾难之轮', '混乱工作室', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (529, '噬骨之寒', '强磁雷场,暴风雪', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (530, '无间死局', '复仇战士,虚空重生者', '升格之链', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (531, '火线快递', '给我死吧,核弹打击,减伤屏障', '虚空降临', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (532, '烈火金刚', '致命勾引,自毁程序,行尸走肉', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (533, '寒冷即是虚空', '暴风雪,虚空重生者,虚空裂隙', '湮灭快车', 19, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (534, '异形进击', '同化体,时空力场,震荡攻击', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (535, '硬骨头', '坚强意志,极性不定,减伤屏障', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (536, '疫区逃生', '暗无天日,光子过载,黑死病', '营救矿工', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (537, '步步为营', '时间扭曲,速度狂魔,震荡攻击', '机会渺茫', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (538, '现世现报', '双重压力,相互摧毁,自毁程序', '升格之链', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (539, '仁至义尽', '给我死吧,超远视距,鼓舞人心', '往日神庙', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (540, '飞蛾扑火', '致命勾引,净化光束,异形寄生', '克哈裂痕', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (541, '火海惊魂', '虚空裂隙,无边恐惧', '熔火危机', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (542, '灾难之轮', '混乱工作室', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (543, '机器人大战', '杀戮机器人,默哀', '机会渺茫', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (544, '磁性牵引', '强磁雷场,致命勾引,来去无踪', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (545, '地发杀机', '焦土政策,岩浆爆发,扫雷专家', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (546, '天发杀机', '进攻部署,飞弹大战,轨道轰炸', '虚空降临', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (547, '兵贵神速', '速度狂魔,同化体', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (548, '自作自受', '相互摧毁,双重压力', '黑暗杀星', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (549, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (550, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (551, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (552, '恶劣天气', '虚空裂隙,龙卷风暴', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (553, '雪茫危机', '暴风雪,小捞油水', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (554, '战场炼狱', '焦土政策,岩浆爆发,闪避机动', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (555, '痛苦神庙', '晶矿护盾,减伤屏障,复仇战士', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (556, '末日之矛', '轨道轰炸,时空力场,净化光束', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (557, '特别快递', '进攻部署,自毁程序,异形寄生', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (558, '城市巷战', '光子过载,扫雷专家,来去无踪', '克哈裂痕', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (559, '灾难之轮', '混乱工作室', '虚空撕裂', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (560, '完美风暴', '暴风雪,龙卷风暴,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (561, '全面核战', '核弹打击,自毁程序,无边恐惧', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (562, '黑暗仪式', '灵能爆表,速度狂魔', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (563, '完全失控', '拿钱说话,暗无天日,时间扭曲', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (564, '燃烧军团', '焦土政策,虚空裂隙,复仇战士', '天界封锁', 17, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (565, '三重威胁', '激光钻机,轨道轰炸,丧尸大战', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (566, '烈焰战场', '飞弹大战,核弹打击,净化光束', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (567, '失心疯', '迷失方向,无边恐惧,闪避机动', '升格之链', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (568, '威胁递增', '力量蜕变,相互摧毁,异形寄生', '机会渺茫', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (569, '资源危机', '强磁雷场,无边恐惧,小捞油水', '克哈裂痕', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (570, '外交豁免', '极性不定,闪避机动,减伤屏障', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (571, '灾难之轮', '混乱工作室', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (572, '造恶之息', '速度狂魔,进攻部署,复仇战士', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (573, '惊魂之夜', '惧怕黑暗,不给糖果就捣蛋', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (574, '玩火自焚', '行尸走肉,异形寄生,焦土政策', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (575, '天轰地爆', '核弹打击,相互摧毁,自毁程序', '虚空撕裂', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (576, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (577, '能量超负', '灵能爆表,超远视距,光子过载', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (578, '拉克希尔大乱斗', '丧尸大战,速度狂魔,给我死吧', '升格之链', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (579, '适者生存', '减伤屏障,力量蜕变', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (580, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (581, '丛林激斗', '来去无踪,进攻部署,时空力场', '机会渺茫', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (582, '终极代价', '拿钱说话,晶矿护盾,飞弹大战', '天界封锁', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (583, '火葬仪式', '虚空重生者,焦土政策', '营救矿工', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (584, '高举盾牌！', '伤害散射,晶矿护盾,短视症', '虚空降临', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (585, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (586, '死疫横生', '黑死病,拿钱说话', '机会渺茫', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (587, '旧忆重惊', '强行征用,相互摧毁', '往日神庙', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (588, '星门异动', '虚空裂隙,灵能爆表', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (589, '灾难之轮', '混乱工作室', '熔火危机', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (590, '强行霸占', '飞弹大战,强行征用,激光钻机', '克哈裂痕', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (591, '死亡危机', '虚空重生者,行尸走肉,力量蜕变', '往日神庙', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (592, '黑暗时刻', '风暴英雄,坚强意志,鼓舞人心', '克哈裂痕', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (593, '没钱麻烦大了', '小捞油水,自毁程序,龙卷风暴', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (594, '雷鸣弹啸', '极性不定,扫雷专家', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (595, '疫鬼狂潮', '速度狂魔,黑死病', '亡者之夜', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (596, '隐形威胁', '来去无踪,净化光束', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (597, '灾难之轮', '混乱工作室', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (598, '封禁行为', '灵能爆表,闪避机动', '净网行动', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (599, '午夜大师', '生命吸取,短视症,无边恐惧', '聚铁成兵', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (600, '雷场夜战', '惧怕黑暗,强磁雷场', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (601, '极限压迫', '强行征用,晶矿护盾,自毁程序', '亡者之夜', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (602, '杀劫迫临', '杀戮机器人,速度狂魔,鼓舞人心', '往日神庙', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (603, '时空气象战', '龙卷风暴,岩浆爆发,时间扭曲', '黑暗杀星', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (604, '死亡无声', '同化体,默哀', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (605, '无尽感染', '黑死病,行尸走肉,异形寄生', '虚空降临', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (606, '顽强作战', '飞弹大战,鼓舞人心,坚强意志', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (607, '灾难之轮', '混乱工作室', '死亡摇篮', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (608, '寒冷适应', '暴风雪,力量蜕变', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (609, '惊魂之夜', '惧怕黑暗,不给糖果就捣乱', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (610, '进步的代价', '杀戮机器人,拿钱说话', '净网行动', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (611, '消极增员', '致命勾引,复仇战士', '聚铁成兵', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (612, '捉鸡行动', '捕杀火鸡,补给共享', '湮灭快车', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (613, '报应不爽', '虚空裂隙,双重压力', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (614, '灰烬重生', '自毁程序,虚空重生者,岩浆爆发', '黑暗杀星', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (615, '扭曲空间', '时空力场,时间扭曲,龙卷风暴', '天界封锁', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (616, '训练有素', '鼓舞人心,进攻部署,复仇战士', '湮灭快车', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (617, '暴力之夜', '礼尚往来,杀生业报', '虚空降临', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (618, '末日报告', '同化体,核弹打击,轨道轰炸', '熔火危机', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (619, '安全违规', '自毁程序,激光钻机,强磁雷场', '营救矿工', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (620, '重生神殿', '给我死吧,减伤屏障,生命吸取', '往日神庙', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (621, '疯狂超频', '速度狂魔,复仇战士,光子过载', '净网行动', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (622, '消耗战', '伤害散射,扫雷专家', '虚空撕裂', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (623, '乌历新年', '焰火秀,幸运红包', '天界封锁', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (624, '永不分离', '极性不定,给我死吧', '升格之链', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (625, '死亡鬼影', '来去无踪,虚空重生者', '聚铁成兵', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (626, '远距威胁', '超远视距,时间扭曲,净化光束', '亡者之夜', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (627, '辐射区', '核弹打击,丧尸大战,黑死病', '克哈裂痕', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (628, '心灵力量', '异形寄生,灵能爆表', '往日神庙', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (629, '调遣军费', '拿钱说话,焦土政策', '死亡摇篮', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (630, '梦魇敌酋', '风暴英雄,默哀', '虚空降临', 12, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (631, '基地翻转', '飞弹大战,净化光束,强行征用', '机会渺茫', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (632, '防火墙', '岩浆爆发,扫雷专家,减伤屏障', '净网行动', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (633, '死亡税金', '拿钱说话,小捞油水,黑死病', '亡者之夜', 17, 6, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (634, '灾难之轮', '混乱工作室', '营救矿工', 0, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (635, '感痛身受', '双重压力,伤害散射,时空力场', '虚空降临', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (636, '地狱列车', '给我死吧,焦土政策', '湮灭快车', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (637, '感染危机', '异形寄生,丧尸大战,自毁程序', '净网行动', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (638, '机会尽出', '速度狂魔,减伤屏障,灵能爆表', '机会渺茫', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (639, '一将千军', '坚强意志,鼓舞人心,力量蜕变', '往日神庙', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (640, '实验巨炮', '激光钻机,光子过载,超远视距', '聚铁成兵', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (641, '核族入侵', '相互摧毁,丧尸大战,坚强意志', '升格之链', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (642, '同归于尽', '极性不定,给我死吧', '黑暗杀星', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (643, '烈火营救', '强行征用,焦土政策,复仇战士', '营救矿工', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (644, '复仇者集结', '风暴英雄,复仇战士', '往日神庙', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (645, '铁轨换线', '给我死吧,极性不定', '湮灭快车', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (646, '敌对领地', '减伤屏障,光子过载,灵能爆表', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (647, '媒体抹黑', '暗无天日,飞弹大战,来去无踪', '熔火危机', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (648, '雷霆穹顶', '风暴英雄,强磁雷场', '天界封锁', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (649, '躲灾避祸', '暗无天日,核弹打击,轨道轰炸', '黑暗杀星', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (650, '二元选择', '极性不定,虚空重生者', '净网行动', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (651, '升格蜕变', '鼓舞人心,力量蜕变', '升格之链', 9, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (652, '森严壁垒', '减伤屏障,核弹打击,光子过载', '死亡摇篮', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (653, '双重麻烦', '杀戮机器人,同化体', '虚空降临', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (654, '星沉地裂', '进攻部署,虚空裂隙', '聚铁成兵', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (655, '赶夜车', '惧怕黑暗,短视症,速度狂魔', '湮灭快车', 3, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (656, '恐惧神庙', '惧怕黑暗,异形寄生,无边恐惧', '往日神庙', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (657, '光炫神迷', '震荡攻击,激光钻机,净化光束', '机会渺茫', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (658, '无尽花火', '异形寄生,自毁程序', '营救矿工', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (659, '坟场夜班', '惧怕黑暗,净化光束', '亡者之夜', 2, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (660, '机器重生', '无边恐惧,给我死吧,激光钻机', '聚铁成兵', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (661, '秘密突击', '进攻部署,龙卷风暴,来去无踪', '天界封锁', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (662, '暗地破坏', '扫雷专家,虚空裂隙', '克哈裂痕', 16, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (663, '散光', '超远视距,短视症,来去无踪', '净网行动', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (664, '永不言死', '减伤屏障,给我死吧,生命吸取', '机会渺茫', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (665, '中世纪', '黑死病,力量蜕变', '黑暗杀星', 14, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (666, '全力猛攻', '进攻部署,丧尸大战,虚空重生者', '亡者之夜', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (667, '等价交换', '伤害散射,给我死吧', '虚空撕裂', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (668, '迫近的疯狂', '强行征用,净化光束,虚空裂隙', '机会渺茫', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (669, '感恩季', '暴风雪,礼尚往来,杀生业报', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (670, '决择抉择', '坚强意志,鼓舞人心,相互摧毁', '往日神庙', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (671, '过度反应', '复仇战士,灵能爆表', '黑暗杀星', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (672, '火焰净化', '核弹打击,岩浆爆发,焦土政策', '湮灭快车', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (673, '极速增援', '时空力场,虚空裂隙', '营救矿工', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (674, '盲目进贡', '杀戮机器人,短视症', '升格之链', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (675, '进击壁垒', '减伤屏障,晶矿护盾,给我死吧', '天界封锁', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (676, '虫人海啸', '异形寄生,飞弹大战,丧尸大战', '死亡摇篮', 8, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (677, '心有灵犀', '极性不定,补给共享', '熔火危机', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (678, '夜半敲门', '复仇战士,同化体', '亡者之夜', 13, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (679, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (680, '舞舞生疯', '默哀,速度狂魔,力量蜕变', '机会渺茫', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (681, '痛苦列车', '双重压力,核弹打击,相互摧毁', '湮灭快车', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (682, '刚硬裂隙', '给我死吧,虚空裂隙', '克哈裂痕', 17, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (683, '爆炸之链', '岩浆爆发,行尸走肉', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (684, '噩梦重临', '复仇战士,强行征用,给我死吧', '往日神庙', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (685, '排爆行动', '扫雷专家,小捞油水', '聚铁成兵', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (686, '缴税日', '无边恐惧,拿钱说话', '虚空降临', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (687, '侵袭强征', '同化体,速度狂魔,来去无踪', '净网行动', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (688, '坟场拾荒', '丧尸大战,小捞油水', '亡者之夜', 8, 3, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (689, '虚空召唤', '虚空重生者,虚空裂隙', '虚空撕裂', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (690, '因爱之名', '震荡攻击,净化光束,时间扭曲', '死亡摇篮', 4, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (691, '锁定击发', '杀戮机器人,晶矿护盾,时空力场', '天界封锁', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (692, '雷劫难逃', '强磁雷场,扫雷专家,飞弹大战', '营救矿工', 13, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (693, '恶棍联盟', '闪避机动,风暴英雄', '熔火危机', 11, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (694, '亡者列车', '行尸走肉,丧尸大战,暗无天日', '湮灭快车', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (695, '合作无间', '极性不定,同化体', '天界封锁', 15, 5, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (696, '冰火之歌', '暴风雪,岩浆爆发,焦土政策', '虚空降临', 9, 3, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (697, '吸血鬼生活', '暗无天日,短视症,来去无踪', '虚空撕裂', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (698, '硬件故障', '杀戮机器人,激光钻机,扫雷专家', '净网行动', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (699, '分担痛苦', '伤害散射,致命勾引', '聚铁成兵', 6, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (700, '漫漫长夜', '给我死吧,超远视距,光子过载', '亡者之夜', 10, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (701, '迅捷亡尸', '速度狂魔,虚空重生者', '黑暗杀星', 7, 2, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (702, '征战十年', '焰火秀,幸运红包,礼尚往来', '克哈裂痕', 0, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (703, '泡泡世界', '减伤屏障,晶矿护盾,时间扭曲', '死亡摇篮', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (704, '协同防御', '飞弹大战,极性不定', '熔火危机', 10, 4, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (705, '饥不择食', '强磁雷场,扫雷专家,小捞油水', '天界封锁', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (706, '我的机器人！', '炸弹机器人,杀戮机器人', '机会渺茫', 6, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (707, '多线操作训练', '拿钱说话,虚空裂隙', '净网行动', 15, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (708, '老友重聚', '黑死病,暗无天日,默哀', '黑暗杀星', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (709, '万众一心', '炸弹机器人,极性不定,补给共享', '克哈裂痕', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (710, '发射升空', '核弹打击,岩浆爆发,灵能爆表', '虚空降临', 11, 4, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (711, '进入时空枢纽', '暴风雪,风暴英雄', '死亡摇篮', 14, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (712, '死亡转瞬即逝', '给我死吧,虚空重生者', '亡者之夜', 12, 5, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (713, '批量生产', '同化体,虚空裂隙', '聚铁成兵', 18, 6, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (714, '小心手雷', '炸弹机器人,飞弹大战', '营救矿工', 3, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (715, '亡者列车', '丧尸大战,暗无天日', '行尸走肉', 5, 1, 0, -1, '2022-10-18 03:25:06', -1, '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (716, '先发制人', '超远视距,短视症,激光钻机', '升格之链', 5, 1, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');
INSERT INTO
    `tb_plugin_star_craft_2_mutation`
VALUES
    (717, '时空枷锁', '时间扭曲,速度狂魔,强磁雷场', '天界封锁', 7, 2, 0, -1, '2022-10-18 03:25:06', -1,
     '2022-10-18 03:25:06');

SET
    FOREIGN_KEY_CHECKS = 1;
