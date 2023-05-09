-- auto-generated definition
BEGIN;

-- auto-generated definition
CREATE TABLE "plguin_reply"
(
    "row_id" BIGSERIAL PRIMARY KEY,
    "keyword"       VARCHAR  NOT NULL,
    "match_type"    VARCHAR  NOT NULL,
    "must_at"       BOOLEAN  NOT NULL,
    "enable"        BOOLEAN  NOT NULL,
    "reply_message" VARCHAR  NOT NULL,
    "is_delete"     BOOLEAN NOT NULL,
    "create_time"   TIMESTAMP WITH TIME ZONE NOT NULL,
    "create_user"   BIGINT   NOT NULL,
    "update_time"   TIMESTAMP WITH TIME ZONE NOT NULL,
    "update_user"   BIGINT   NOT NULL
);

COMMENT ON TABLE "plguin_reply" IS '配置表';
COMMENT ON COLUMN "plguin_reply"."row_id" IS '主键';
COMMENT ON COLUMN "plguin_reply"."keyword" IS '关键词';
COMMENT ON COLUMN "plguin_reply"."must_at" IS '是否需要包含at(对象为bot)';
COMMENT ON COLUMN "plguin_reply"."enable" IS '是否启用';
COMMENT ON COLUMN "plguin_reply"."keyword" IS '关键词';
COMMENT ON COLUMN "plguin_reply"."match_type" IS '匹配类型';
COMMENT ON COLUMN "plguin_reply"."reply_message" IS '返回消息';
COMMENT ON COLUMN "plguin_reply"."is_delete" IS '逻辑删除({0:false,1:true})';
COMMENT ON COLUMN "plguin_reply"."create_time" IS '创建时间';
COMMENT ON COLUMN "plguin_reply"."create_user" IS '创建用户';
COMMENT ON COLUMN "plguin_reply"."update_time" IS '更新时间';
COMMENT ON COLUMN "plguin_reply"."update_user" IS '更新用户';

ALTER TABLE "plguin_reply"
    OWNER TO "postgres";

COMMIT;
