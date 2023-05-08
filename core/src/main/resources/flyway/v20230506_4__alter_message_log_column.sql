-- auto-generated definition
BEGIN;
ALTER TABLE "core_message_log"
    RENAME COLUMN "message_id" TO "message_mirai_internal_id";

COMMENT ON COLUMN "core_message_log"."message_mirai_internal_id" IS '消息主键(mirai内部id)';

COMMIT;
