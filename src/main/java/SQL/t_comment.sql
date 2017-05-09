
CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL,
  `uid` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL,
  `content` binary(255) DEFAULT NULL,
  `ctime` bigint(11) DEFAULT NULL,
  `mtime` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8