-- auto-generated definition
BEGIN;
-- 消息记录表
DROP TABLE IF EXISTS "core_message_log";
CREATE TABLE "core_message_log"
(
    "row_id"          BIGSERIAL                NOT NULL,
    "sender_qq"       BIGINT                   NOT NULL,
    "sender_group_qq" BIGINT                   NOT NULL,
    "sender_name"     VARCHAR                  NOT NULL,
    "duty_bot_qq"     BIGINT                   NOT NULL,
    "msg_row_id"      BIGINT                   NOT NULL,
    "msg"             VARCHAR                  NOT NULL,
    "is_delete"       SMALLINT                 NOT NULL,
    "create_time"     TIMESTAMP WITH TIME ZONE NOT NULL,
    "create_user"     BIGINT                   NOT NULL,
    "update_time"     TIMESTAMP WITH TIME ZONE NOT NULL,
    "update_user"     BIGINT                   NOT NULL,
    PRIMARY KEY ("row_id")
);

COMMENT ON TABLE "core_message_log" IS '消息记录表';
COMMENT ON COLUMN "core_message_log"."row_id" IS '主键';
COMMENT ON COLUMN "core_message_log"."sender_qq" IS '发送人qq';
COMMENT ON COLUMN "core_message_log"."sender_group_qq" IS '发送人所在群qq';
COMMENT ON COLUMN "core_message_log"."sender_name" IS '发送人名称(不随其变化更新,请仅用于显示)';
COMMENT ON COLUMN "core_message_log"."duty_bot_qq" IS '值守botqq';
COMMENT ON COLUMN "core_message_log"."msg_row_id" IS '消息主键';
COMMENT ON COLUMN "core_message_log"."msg" IS '消息';
COMMENT ON COLUMN "core_message_log"."is_delete" IS '逻辑删除({0:FALSE,1:TRUE})';
COMMENT ON COLUMN "core_message_log"."create_time" IS '创建时间';
COMMENT ON COLUMN "core_message_log"."create_user" IS '创建用户';
COMMENT ON COLUMN "core_message_log"."update_time" IS '更新时间';
COMMENT ON COLUMN "core_message_log"."update_user" IS '更新用户';

-- 异常记录表
DROP TABLE IF EXISTS "core_exception_log";
CREATE TABLE "core_exception_log"
(
    "row_id"      BIGSERIAL                NOT NULL,
    "stackInfo"   TEXT                     NOT NULL,
    "is_delete"   SMALLINT                 NOT NULL,
    "create_time" TIMESTAMP WITH TIME ZONE NOT NULL,
    "create_user" BIGINT                   NOT NULL,
    "update_time" TIMESTAMP WITH TIME ZONE NOT NULL,
    "update_user" BIGINT                   NOT NULL,
    PRIMARY KEY ("row_id")
);

COMMENT ON TABLE "core_exception_log" IS '异常记录表';
COMMENT ON COLUMN "core_exception_log"."row_id" IS '主键';
COMMENT ON COLUMN "core_exception_log"."stackInfo" IS '堆栈信息';
COMMENT ON COLUMN "core_exception_log"."is_delete" IS '逻辑删除({0:FALSE,1:TRUE})';
COMMENT ON COLUMN "core_exception_log"."create_time" IS '创建时间';
COMMENT ON COLUMN "core_exception_log"."create_user" IS '创建用户';
COMMENT ON COLUMN "core_exception_log"."update_time" IS '更新时间';
COMMENT ON COLUMN "core_exception_log"."update_user" IS '更新用户';

COMMIT;