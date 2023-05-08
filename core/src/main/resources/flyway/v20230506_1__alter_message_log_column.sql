-- auto-generated definition
BEGIN;

ALTER TABLE "core_message_log"

    ALTER COLUMN "sender_group_qq" DROP NOT NULL;
ALTER TABLE "core_message_log"
    RENAME COLUMN "msg_row_id" TO "msg_id";

ALTER TABLE "core_message_log"
    RENAME COLUMN "sender_qq" TO "sender_id";

ALTER TABLE "core_message_log"
    RENAME COLUMN "sender_group_qq" TO "sender_group_id";

ALTER TABLE "core_message_log"
    RENAME COLUMN "duty_bot_qq" TO "duty_bot_id";


COMMIT;
