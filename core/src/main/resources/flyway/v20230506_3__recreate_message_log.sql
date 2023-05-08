-- auto-generated definition
BEGIN;

DROP TABLE IF EXISTS "core_message_log";

CREATE TABLE "core_message_log"
(
    "row_id"          BIGSERIAL PRIMARY KEY,
    "sender_id"       BIGINT                   NOT NULL,
    "sender_group_id" BIGINT,
    "sender_name"     VARCHAR                  NOT NULL,
    "duty_bot_id"     BIGINT                   NOT NULL,
    "message_id"      INTEGER                  NOT NULL,
    "message"         VARCHAR                  NOT NULL,
    "raw_message"     VARCHAR                  NOT NULL,
    "message_type"    SMALLINT                 NOT NULL,
    "is_delete"       BOOLEAN                  NOT NULL,
    "create_time"     TIMESTAMP WITH TIME ZONE NOT NULL,
    "create_user"     BIGINT                   NOT NULL,
    "update_time"     TIMESTAMP WITH TIME ZONE NOT NULL,
    "update_user"     BIGINT                   NOT NULL
);

COMMENT ON TABLE "core_message_log" IS '消息记录表';
COMMENT ON COLUMN "core_message_log"."row_id" IS '主键';
COMMENT ON COLUMN "core_message_log"."sender_id" IS '发送人qq';
COMMENT ON COLUMN "core_message_log"."sender_group_id" IS '发送人所在群qq';
COMMENT ON COLUMN "core_message_log"."sender_name" IS '发送人名称(不随其变化更新,请仅用于显示)';
COMMENT ON COLUMN "core_message_log"."duty_bot_id" IS '值守botqq';
COMMENT ON COLUMN "core_message_log"."message_id" IS '消息主键';
COMMENT ON COLUMN "core_message_log"."message" IS '消息';
COMMENT ON COLUMN "core_message_log"."raw_message" IS '原始消息';
COMMENT ON COLUMN "core_message_log"."message_type" IS '消息类型';
COMMENT ON COLUMN "core_message_log"."is_delete" IS '逻辑删除({0:FALSE,1:TRUE})';
COMMENT ON COLUMN "core_message_log"."create_time" IS '创建时间';
COMMENT ON COLUMN "core_message_log"."create_user" IS '创建用户';
COMMENT ON COLUMN "core_message_log"."update_time" IS '更新时间';
COMMENT ON COLUMN "core_message_log"."update_user" IS '更新用户';

ALTER TABLE "core_message_log"
    OWNER TO "postgres";



COMMIT;
