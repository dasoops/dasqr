-- auto-generated definition
BEGIN;

ALTER TABLE "core_message_log"
    RENAME COLUMN "msg_id" TO "message_id";

ALTER TABLE "core_message_log"
    ALTER COLUMN "message_id" TYPE INT USING "message_id"::INT;

ALTER TABLE "core_message_log"
    RENAME COLUMN "msg" TO "message";

ALTER TABLE "core_message_log"
    ADD "raw_message" INTEGER;

ALTER TABLE "core_message_log"
    ADD "message_type" SMALLINT;

COMMIT;
