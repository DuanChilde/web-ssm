
CREATE TABLE `t_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `content` text,
  `is_attach` tinyint(1) DEFAULT NULL,
  `ctime` bigint(11) DEFAULT NULL,
  `mtime` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8