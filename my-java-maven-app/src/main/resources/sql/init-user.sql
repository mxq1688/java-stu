-- 在 SIT 数据库 ioam_backend 中执行
CREATE TABLE IF NOT EXISTS `user` (
    id         BIGINT       NOT NULL AUTO_INCREMENT  COMMENT '主键ID',
    username   VARCHAR(50)  NOT NULL                 COMMENT '用户名',
    email      VARCHAR(100) NOT NULL                 COMMENT '邮箱',
    name       VARCHAR(50)  NOT NULL                 COMMENT '姓名',
    created_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uk_username (username),
    UNIQUE KEY uk_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
