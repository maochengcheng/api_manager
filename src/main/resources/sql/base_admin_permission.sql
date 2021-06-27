/*
 Navicat Premium Data Transfer

 Source Server         : 线下服务器
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 172.16.1.60:3306
 Source Schema         : tiantue

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 05/12/2018 10:56:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_admin_permission
-- ----------------------------
DROP TABLE IF EXISTS `base_admin_permission`;
CREATE TABLE `base_admin_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `pid` int(11) DEFAULT NULL COMMENT '父菜单id',
  `descpt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单url',
  `create_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) DEFAULT NULL COMMENT '删除标志（0:删除 1：存在）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of base_admin_permission
-- ----------------------------
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('1', '系统管理', '0', '系统管理', '', '2018-11-30 10:27:34', '2018-11-30 10:27:34', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('2', '账号管理', '1', '账号管理', '/user/userManage', '2018-11-30 11:44:41', '2018-11-30 11:56:34', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('3', '角色管理', '1', '角色管理', '/role/roleManage', '2018-11-30 11:45:27', '2018-11-30 11:45:27', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('7', '权限管理', '1', '权限管理', '/permission/permissionManage', '2018-11-30 11:48:35', '2018-11-30 15:13:38', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('9', '基本设置', '0', '基本设置', '', '2018-11-30 12:10:32', '2018-11-30 12:10:32', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('11', '权限码管理', '9', '权限码管理', '/secure/secretSecure', '2018-12-04 11:47:59', '2020-03-09 00:27:18', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('28ca4d8d-e5d1-4382-9a74-9cee81ec10c8', '接口调用履历', 'b35f822b-f5af-4500-a34b-7797c3304b05', '接口调用履历', '/base/operationHistory', '2020-03-16 17:02:34', '2020-03-17 09:45:36', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('b35f822b-f5af-4500-a34b-7797c3304b05', '接口管理', '0', '接口管理', '', '2020-03-16 17:01:22', '2020-03-16 17:01:22', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('e8fc368f-5ee2-4f09-8cd8-28306889abd9', '接口查询', 'b35f822b-f5af-4500-a34b-7797c3304b05', '接口查询', '/base/interfaceSearch', '2020-04-16 11:30:23', '2020-04-16 11:53:48', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('ed421f5d-415e-463a-b5c7-173e47f35ab2', '接口配置', '9', '接口配置', '/base/interfaceManage', '2020-03-16 17:03:42', '2020-03-16 17:58:13', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('0812eafc-75a9-4f23-b7fb-8e1b36df18d5', '数据库管理', '0', '数据库管理', '', '2021-02-24 10:38:44', '2021-02-24 10:38:44', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('0e6909e5-db9b-4bec-8d02-abe19c89f7d7', '数据查询', '0812eafc-75a9-4f23-b7fb-8e1b36df18d5', '数据库数据查询', '', '2021-02-24 10:51:51', '2021-02-24 11:48:39', 1);
INSERT INTO "base_admin_permission"("id", "name", "pid", "descpt", "url", "create_time", "update_time", "del_flag") VALUES ('5b33dfe8-48c3-4c2a-abcd-73ae71f8dff6', '数据库表管理', '0812eafc-75a9-4f23-b7fb-8e1b36df18d5', '数据库表管理', '/table/tableManage', '2021-02-24 10:52:25', '2021-02-24 11:48:46', 1);

SET FOREIGN_KEY_CHECKS = 1;
