-- auto-generated definition
BEGIN;

DROP TABLE IF EXISTS "core_config";
CREATE TABLE "core_config"
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

COMMENT ON TABLE "core_config" IS '配置表';
COMMENT ON COLUMN "core_config"."row_id" IS '主键';
COMMENT ON COLUMN "core_config"."keyword" IS '关键词';
COMMENT ON COLUMN "core_config"."value" IS '值';
COMMENT ON COLUMN "core_config"."description" IS '描述';
COMMENT ON COLUMN "core_config"."is_delete" IS '逻辑删除({0:false,1:true})';
COMMENT ON COLUMN "core_config"."create_time" IS '创建时间';
COMMENT ON COLUMN "core_config"."create_user" IS '创建用户';
COMMENT ON COLUMN "core_config"."update_time" IS '更新时间';
COMMENT ON COLUMN "core_config"."update_user" IS '更新用户';

ALTER TABLE "core_config"
    OWNER TO "postgres";


COMMIT;
