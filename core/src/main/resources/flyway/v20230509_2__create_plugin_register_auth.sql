-- auto-generated definition
BEGIN;

-- auto-generated definition
CREATE TABLE "plugin_system_plugin"
(
    "row_id"              BIGSERIAL PRIMARY KEY,
    "name"                VARCHAR                  NOT NULL,
    "another"             VARCHAR                  NOT NULL,
    "version"             VARCHAR                  NOT NULL,
    "description"         VARCHAR                  NOT NULL,
    "listener_host_class" VARCHAR                  NOT NULL,
    "order"               INT                      NOT NULL,
    "enable"              BOOLEAN                  NOT NULL,
    "is_delete"           BOOLEAN                  NOT NULL,
    "create_time"         TIMESTAMP WITH TIME ZONE NOT NULL,
    "create_user"         BIGINT                   NOT NULL,
    "update_time"         TIMESTAMP WITH TIME ZONE NOT NULL,
    "update_user"         BIGINT                   NOT NULL
);

COMMENT ON TABLE "plugin_system_plugin" IS '插件表';
COMMENT ON COLUMN "plugin_system_plugin"."row_id" IS '主键';
COMMENT ON COLUMN "plugin_system_plugin"."name" IS '名称';
COMMENT ON COLUMN "plugin_system_plugin"."another" IS '作者';
COMMENT ON COLUMN "plugin_system_plugin"."version" IS '版本';
COMMENT ON COLUMN "plugin_system_plugin"."description" IS '描述';
COMMENT ON COLUMN "plugin_system_plugin"."listener_host_class" IS '监听器class全路径';
COMMENT ON COLUMN "plugin_system_plugin"."order" IS '插件排序';
COMMENT ON COLUMN "plugin_system_plugin"."enable" IS '是否启用';
COMMENT ON COLUMN "plugin_system_plugin"."is_delete" IS '逻辑删除({0:false,1:true})';
COMMENT ON COLUMN "plugin_system_plugin"."create_time" IS '创建时间';
COMMENT ON COLUMN "plugin_system_plugin"."create_user" IS '创建用户';
COMMENT ON COLUMN "plugin_system_plugin"."update_time" IS '更新时间';
COMMENT ON COLUMN "plugin_system_plugin"."update_user" IS '更新用户';

ALTER TABLE "plugin_system_plugin"
    OWNER TO "postgres";


-- auto-generated definition
CREATE TABLE "plugin_system_register"
(
    "row_id"      BIGSERIAL PRIMARY KEY,
    "register_id" BIGINT                   NOT NULL,
    "type"        SMALLINT                 NOT NULL,
    "auth_level"  SMALLINT                 NOT NULL,
    "is_delete"   BOOLEAN                  NOT NULL,
    "create_time" TIMESTAMP WITH TIME ZONE NOT NULL,
    "create_user" BIGINT                   NOT NULL,
    "update_time" TIMESTAMP WITH TIME ZONE NOT NULL,
    "update_user" BIGINT                   NOT NULL
);

COMMENT ON TABLE "plugin_system_register" IS '注册表';
COMMENT ON COLUMN "plugin_system_register"."row_id" IS '主键';
COMMENT ON COLUMN "plugin_system_register"."register_id" IS '注册对象id(qq)';
COMMENT ON COLUMN "plugin_system_register"."type" IS '注册对象类型';
COMMENT ON COLUMN "plugin_system_register"."auth_level" IS '注册对象权限等级';
COMMENT ON COLUMN "plugin_system_register"."is_delete" IS '逻辑删除({0:false,1:true})';
COMMENT ON COLUMN "plugin_system_register"."create_time" IS '创建时间';
COMMENT ON COLUMN "plugin_system_register"."create_user" IS '创建用户';
COMMENT ON COLUMN "plugin_system_register"."update_time" IS '更新时间';
COMMENT ON COLUMN "plugin_system_register"."update_user" IS '更新用户';

ALTER TABLE "plugin_system_register"
    OWNER TO "postgres";


-- auto-generated definition
CREATE TABLE "plugin_system_auth"
(
    "row_id"      BIGSERIAL PRIMARY KEY,
    "register_id" BIGINT                   NOT NULL,
    "plugin_id"   BIGINT                   NOT NULL,
    "pass"        BOOLEAN                  NOT NULL,
    "is_delete"   BOOLEAN                  NOT NULL,
    "create_time" TIMESTAMP WITH TIME ZONE NOT NULL,
    "create_user" BIGINT                   NOT NULL,
    "update_time" TIMESTAMP WITH TIME ZONE NOT NULL,
    "update_user" BIGINT                   NOT NULL
);

COMMENT ON TABLE "plugin_system_register" IS '注册表';
COMMENT ON COLUMN "plugin_system_register"."row_id" IS '主键';
COMMENT ON COLUMN "plugin_system_register"."register_id" IS '注册对象id(qq)';
COMMENT ON COLUMN "plugin_system_register"."type" IS '注册对象类型';
COMMENT ON COLUMN "plugin_system_register"."auth_level" IS '注册对象权限等级';
COMMENT ON COLUMN "plugin_system_register"."is_delete" IS '逻辑删除({0:false,1:true})';
COMMENT ON COLUMN "plugin_system_register"."create_time" IS '创建时间';
COMMENT ON COLUMN "plugin_system_register"."create_user" IS '创建用户';
COMMENT ON COLUMN "plugin_system_register"."update_time" IS '更新时间';
COMMENT ON COLUMN "plugin_system_register"."update_user" IS '更新用户';

ALTER TABLE "plugin_system_register"
    OWNER TO "postgres";

COMMIT;
