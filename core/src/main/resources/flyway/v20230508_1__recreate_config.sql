-- auto-generated definition
BEGIN;

DROP TABLE IF EXISTS "plugin_system_config";
DROP TABLE IF EXISTS "plugin_config";
CREATE TABLE "plugin_system_config"
(
    "row_id"      BIGSERIAL PRIMARY KEY,
    "keyword"     VARCHAR                  NOT NULL,
    "value"       VARCHAR                  NOT NULL,
    "description" VARCHAR                  NOT NULL,
    "is_delete"   BOOLEAN                  NOT NULL,
    "create_time" TIMESTAMP WITH TIME ZONE NOT NULL,
    "create_user" BIGINT                   NOT NULL,
    "update_time" TIMESTAMP WITH TIME ZONE NOT NULL,
    "update_user" BIGINT                   NOT NULL
);

COMMENT ON TABLE "plugin_system_config" IS '配置表';
COMMENT ON COLUMN "plugin_system_config"."row_id" IS '主键';
COMMENT ON COLUMN "plugin_system_config"."keyword" IS '关键词';
COMMENT ON COLUMN "plugin_system_config"."value" IS '值';
COMMENT ON COLUMN "plugin_system_config"."description" IS '描述';
COMMENT ON COLUMN "plugin_system_config"."is_delete" IS '逻辑删除({0:false,1:true})';
COMMENT ON COLUMN "plugin_system_config"."create_time" IS '创建时间';
COMMENT ON COLUMN "plugin_system_config"."create_user" IS '创建用户';
COMMENT ON COLUMN "plugin_system_config"."update_time" IS '更新时间';
COMMENT ON COLUMN "plugin_system_config"."update_user" IS '更新用户';

ALTER TABLE "plugin_system_config"
    OWNER TO "postgres";

INSERT INTO plugin_system_config (row_id, keyword, value, description, is_delete, create_time, create_user, update_time, update_user) VALUES (1, 'mirai', '{"bot":{"qq":2,"password":"","type":"password","protocol":"android_phone"},"file":{"deviceInfoPath":"device.json","cachePath":"mirai/cache","workingDir":"/temp/dasqr/"},"log":{"useLog4j2":true}}', 'mirai配置', false, '2023-05-08 19:26:31.143000 +00:00', 0, '2023-05-08 19:26:32.973000 +00:00', 0);
INSERT INTO plugin_system_config (row_id, keyword, value, description, is_delete, create_time, create_user, update_time, update_user) VALUES (2, 'dasqr', '{"exception":{"excludeClass":[],"scanPath":["com.dasoops.dasqr.core","com.dasoops.dasqr.plugin"]},"plugin":{"scanPath":["com.dasoops.dasqr.core","com.dasoops.dasqr.plugin"]}}', 'dasqr配置', false, '2023-05-08 19:27:15.942000 +00:00', 0, '2023-05-08 19:27:17.558000 +00:00', 0);

COMMIT;
