create table public."plugin_system_schedule"
(
    row_id        bigserial primary key,
    cron          varchar                  not null,
    class         varchar                  not null,
    "description" varchar                  not null,
    param_json     boolean                  null,
    "enable"      boolean                  not null,
    is_delete     boolean                  not null,
    create_time   timestamp with time zone not null,
    create_user   bigint                   not null,
    update_time   timestamp with time zone not null,
    update_user   bigint                   not null
);

comment on table public."plugin_system_schedule" is '异常记录表';
comment on column public."plugin_system_schedule".row_id is '主键';
comment on column public."plugin_system_schedule".cron is 'cron';
comment on column public."plugin_system_schedule".class is '运行类';
comment on column public."plugin_system_schedule".description is '描述';
comment on column public."plugin_system_schedule".param_json is '参数json';
comment on column public."plugin_system_schedule".enable is '是否启用';
comment on column public."plugin_system_schedule".is_delete is '逻辑删除({0:FALSE,1:TRUE})';
comment on column public."plugin_system_schedule".create_time is '创建时间';
comment on column public."plugin_system_schedule".create_user is '创建用户';
comment on column public."plugin_system_schedule".update_time is '更新时间';
comment on column public."plugin_system_schedule".update_user is '更新用户';

alter table public."plugin_system_schedule"
    owner to postgres;