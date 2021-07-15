DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;
CREATE TABLE `user`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`      varchar(32)  DEFAULT NULL COMMENT '姓名',
    `phone`     char(11)     DEFAULT NULL COMMENT '手机号码',
    `telephone` varchar(16)  DEFAULT NULL COMMENT '住宅电话',
    `address`   varchar(64)  DEFAULT NULL COMMENT '联系地址',
    `enabled`   tinyint(1)   DEFAULT '1',
    `username`  varchar(255) DEFAULT NULL COMMENT '用户名',
    `password`  varchar(255) DEFAULT NULL COMMENT '密码',
    `userface`  varchar(255) DEFAULT NULL,
    `remark`    varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8;


insert into `user`(`id`, `name`, `phone`, `telephone`, `address`, `enabled`, `username`, `password`, `userface`,
                   `remark`)
values (3, '系统管理员', '18568887789', '029-82881234', '深圳南山', 1, 'admin',
        '$2a$10$H8UOGm0XF75Qufulgg3YDeircaSCHLWa.lSkBry5nqFBAfT6xfFO2',
        'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', NULL),
       (5, '李白', '18568123489', '029-82123434', '海口美兰', 1, 'libai',
        '$2a$10$H8UOGm0XF75Qufulgg3YDeircaSCHLWa.lSkBry5nqFBAfT6xfFO2',
        'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514093920321&di=913e88c23f382933ef430024afd9128a&imgtype=0&src=http%3A%2F%2Fp.3761.com%2Fpic%2F9771429316733.jpg',
        NULL),
       (10, '韩愈', '18568123666', '029-82111555', '广州番禺', 1, 'hanyu',
        '$2a$10$H8UOGm0XF75Qufulgg3YDeircaSCHLWa.lSkBry5nqFBAfT6xfFO2',
        'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg',
        NULL),
       (11, '柳宗元', '18568123377', '029-82111333', '广州天河', 1, 'liuzongyuan',
        '$2a$10$H8UOGm0XF75Qufulgg3YDeircaSCHLWa.lSkBry5nqFBAfT6xfFO2',
        'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515233756&di=0856d923a0a37a87fd26604a2c871370&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2014-09-27%2F041716704.jpg',
        NULL),
       (12, '曾巩', '18568128888', '029-82111222', '广州越秀', 1, 'zenggong',
        '$2a$10$H8UOGm0XF75Qufulgg3YDeircaSCHLWa.lSkBry5nqFBAfT6xfFO2',
        'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg',
        NULL);
/*Table structure for table `role` */


CREATE TABLE `role`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `name`    varchar(64) DEFAULT NULL,
    `name_zh` varchar(64) DEFAULT NULL COMMENT '角色名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 22
  DEFAULT CHARSET = utf8;

/*Data for the table `role` */

insert into `role`(`id`, `name`, `name_zh`)
values (1, 'ROLE_manager', '部门经理'),
       (2, 'ROLE_personnel', '人事专员'),
       (3, 'ROLE_recruiter', '招聘主管'),
       (4, 'ROLE_train', '培训主管'),
       (5, 'ROLE_performance', '薪酬绩效主管'),
       (6, 'ROLE_admin', '系统管理员'),
       (13, 'ROLE_test2', '测试角色2'),
       (14, 'ROLE_test1', '测试角色1'),
       (17, 'ROLE_test3', '测试角色3'),
       (18, 'ROLE_test4', '测试角色4'),
       (19, 'ROLE_test4', '测试角色4'),
       (20, 'ROLE_test5', '测试角色5'),
       (21, 'ROLE_test6', '测试角色6');

/*Table structure for table `user_role` */

CREATE TABLE `user_role`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) DEFAULT NULL,
    `role_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `role_id` (`role_id`),
    KEY `user_role_ibfk_1` (`user_id`),
    CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
    CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 75
  DEFAULT CHARSET = utf8;

/*Data for the table `hr_role` */

insert into `user_role`(`id`, `user_id`, `role_id`)
values (1, 3, 6),
       (35, 12, 4),
       (36, 12, 3),
       (37, 12, 2),
       (43, 11, 3),
       (44, 11, 2),
       (45, 11, 4),
       (46, 11, 5),
       (48, 10, 3),
       (49, 10, 4),
       (72, 5, 1),
       (73, 5, 2),
       (74, 5, 3);
