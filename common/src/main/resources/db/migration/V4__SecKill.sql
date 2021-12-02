DROP TABLE IF EXISTS `seckill`;
DROP TABLE IF EXISTS `seckill_log`;
CREATE TABLE `seckill`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`        VARCHAR(120) NOT NULL COMMENT '商品名称',
    `number`      INT          NOT NULL COMMENT '库存数量',
    `start_time`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀开启的时间',
    `end_time`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀结束的时间',
    `create_time` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建的时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8;
CREATE TABLE `seckill_log`
(
    `id`          int(11)   NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `seckill_id`  int(11)            DEFAULT NULL COMMENT 'seckill_id',
    `state`       char(11)           DEFAULT NULL COMMENT '执行秒杀结果的状态',
    `msg`         varchar(64)        DEFAULT NULL COMMENT '状态的明文标示',
    `user_phone`  char(11)           DEFAULT NULL COMMENT '用户的手机号码',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建的时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8;
