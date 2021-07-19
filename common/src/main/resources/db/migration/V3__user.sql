ALTER TABLE user
    ADD `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间';
ALTER TABLE user
    ADD `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间';
ALTER TABLE user
    ADD `create_user_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '创建人';
ALTER TABLE user
    ADD `update_account_id` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改人';
ALTER TABLE user
    ADD `deleted` tinyint(0) UNSIGNED NULL DEFAULT 0 COMMENT '逻辑删除标识(0、否 1、是)';
