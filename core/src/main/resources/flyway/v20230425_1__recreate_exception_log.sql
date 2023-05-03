-- auto-generated definition
BEGIN;
-- 消息记录表
DROP TABLE IF EXISTS "core_exception_log";
CREATE TABLE "core_exception_log"
(
    "row_id"         BIGSERIAL                NOT NULL,
    "stack_info"     TEXT                     NOT NULL,
    "top_message"    VARCHAR                  NOT NULL,
    "exception_type" VARCHAR                  NOT NULL,
    "is_delete"      SMALLINT                 NOT NULL,
    "create_time"    TIMESTAMP WITH TIME ZONE NOT NULL,
    "create_user"    BIGINT                   NOT NULL,
    "update_time"    TIMESTAMP WITH TIME ZONE NOT NULL,
    "update_user"    BIGINT                   NOT NULL,
    PRIMARY KEY ("row_id")
);

COMMENT ON TABLE "core_exception_log" IS '异常记录表';
COMMENT ON COLUMN "core_exception_log"."row_id" IS '主键';
COMMENT ON COLUMN "core_exception_log"."stack_info" IS '堆栈信息';
COMMENT ON COLUMN "core_exception_log"."top_message" IS '顶层信息';
COMMENT ON COLUMN "core_exception_log"."exception_type" IS '异常类型';
COMMENT ON COLUMN "core_exception_log"."is_delete" IS '逻辑删除({0:FALSE,1:TRUE})';
COMMENT ON COLUMN "core_exception_log"."create_time" IS '创建时间';
COMMENT ON COLUMN "core_exception_log"."create_user" IS '创建用户';
COMMENT ON COLUMN "core_exception_log"."update_time" IS '更新时间';
COMMENT ON COLUMN "core_exception_log"."update_user" IS '更新用户';
