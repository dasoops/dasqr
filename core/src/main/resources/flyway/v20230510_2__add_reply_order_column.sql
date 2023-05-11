-- auto-generated definition
BEGIN;

alter table "plugin_reply"
    add "order" integer;

comment on column "plugin_reply"."order" is '排序';

COMMIT;
