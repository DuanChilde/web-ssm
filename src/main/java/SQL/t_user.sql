/*
Navicat MySQL Data Transfer

Source Server         : zhangxq
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2016-07-17 13:23:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL auto_increment,
  `user_name` varchar(255) default NULL COMMENT '用户名',
  `user_phone` varchar(20) default NULL COMMENT '手机号',
  `user_email` varchar(255) default NULL COMMENT '邮箱地址',
  `user_pwd` varchar(32) default NULL COMMENT '加盐后用户密码',
  `pwd_salt` varchar(6) default NULL COMMENT 'MD5盐',
  `ctime`  bigint(11) default NULL COMMENT '创建时间',
  `mtime`  bigint(11) default NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) default NULL COMMENT '是否删除，0-未删除；1-已删除',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户登录表';

