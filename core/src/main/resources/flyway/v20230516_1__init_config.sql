begin;
create table public.core_exception_log
(
    row_id         bigserial
        primary key,
    stack_info     text                     not null,
    top_message    varchar                  not null,
    exception_type varchar                  not null,
    is_delete      boolean                  not null,
    create_time    timestamp with time zone not null,
    create_user    bigint                   not null,
    update_time    timestamp with time zone not null,
    update_user    bigint                   not null
);

comment on table public.core_exception_log is '异常记录表';
comment on column public.core_exception_log.row_id is '主键';
comment on column public.core_exception_log.stack_info is '堆栈信息';
comment on column public.core_exception_log.top_message is '顶层信息';
comment on column public.core_exception_log.exception_type is '异常类型';
comment on column public.core_exception_log.is_delete is '逻辑删除({0:FALSE,1:TRUE})';
comment on column public.core_exception_log.create_time is '创建时间';
comment on column public.core_exception_log.create_user is '创建用户';
comment on column public.core_exception_log.update_time is '更新时间';
comment on column public.core_exception_log.update_user is '更新用户';

alter table public.core_exception_log
    owner to postgres;

create table public.core_message_log
(
    row_id                    bigserial
        primary key,
    sender_id                 bigint                   not null,
    sender_group_id           bigint,
    sender_name               varchar                  not null,
    duty_bot_id               bigint                   not null,
    message_mirai_internal_id integer                  not null,
    message                   varchar                  not null,
    raw_message               varchar                  not null,
    message_type              smallint                 not null,
    is_delete                 boolean                  not null,
    create_time               timestamp with time zone not null,
    create_user               bigint                   not null,
    update_time               timestamp with time zone not null,
    update_user               bigint                   not null
);

comment on table public.core_message_log is '消息记录表';
comment on column public.core_message_log.row_id is '主键';
comment on column public.core_message_log.sender_id is '发送人qq';
comment on column public.core_message_log.sender_group_id is '发送人所在群qq';
comment on column public.core_message_log.sender_name is '发送人名称(不随其变化更新,请仅用于显示)';
comment on column public.core_message_log.duty_bot_id is '值守botqq';
comment on column public.core_message_log.message_mirai_internal_id is '消息主键(mirai内部id)';
comment on column public.core_message_log.message is '消息';
comment on column public.core_message_log.raw_message is '原始消息';
comment on column public.core_message_log.message_type is '消息类型';
comment on column public.core_message_log.is_delete is '逻辑删除({0:FALSE,1:TRUE})';
comment on column public.core_message_log.create_time is '创建时间';
comment on column public.core_message_log.create_user is '创建用户';
comment on column public.core_message_log.update_time is '更新时间';
comment on column public.core_message_log.update_user is '更新用户';

alter table public.core_message_log
    owner to postgres;

create table public.plugin_system_config
(
    row_id      bigserial
        primary key,
    keyword     varchar                  not null,
    value       varchar                  not null,
    description varchar                  not null,
    is_delete   boolean                  not null,
    create_time timestamp with time zone not null,
    create_user bigint                   not null,
    update_time timestamp with time zone not null,
    update_user bigint                   not null
);

comment on table public.plugin_system_config is '配置表';
comment on column public.plugin_system_config.row_id is '主键';
comment on column public.plugin_system_config.keyword is '关键词';
comment on column public.plugin_system_config.value is '值';
comment on column public.plugin_system_config.description is '描述';
comment on column public.plugin_system_config.is_delete is '逻辑删除({0:false,1:true})';
comment on column public.plugin_system_config.create_time is '创建时间';
comment on column public.plugin_system_config.create_user is '创建用户';
comment on column public.plugin_system_config.update_time is '更新时间';
comment on column public.plugin_system_config.update_user is '更新用户';

alter table public.plugin_system_config
    owner to postgres;

create table public.plugin_reply
(
    row_id        bigserial
        primary key,
    keyword       varchar                  not null,
    match_type    varchar                  not null,
    must_at       boolean                  not null,
    enable        boolean                  not null,
    reply_message varchar                  not null,
    is_delete     boolean                  not null,
    create_time   timestamp with time zone not null,
    create_user   bigint                   not null,
    update_time   timestamp with time zone not null,
    update_user   bigint                   not null,
    "order"       integer
);

comment on table public.plugin_reply is '配置表';
comment on column public.plugin_reply.row_id is '主键';
comment on column public.plugin_reply.keyword is '关键词';
comment on column public.plugin_reply.match_type is '匹配类型';
comment on column public.plugin_reply.must_at is '是否需要包含at(对象为bot)';
comment on column public.plugin_reply.enable is '是否启用';
comment on column public.plugin_reply.reply_message is '返回消息';
comment on column public.plugin_reply.is_delete is '逻辑删除({0:false,1:true})';
comment on column public.plugin_reply.create_time is '创建时间';
comment on column public.plugin_reply.create_user is '创建用户';
comment on column public.plugin_reply.update_time is '更新时间';
comment on column public.plugin_reply.update_user is '更新用户';
comment on column public.plugin_reply."order" is '排序';

alter table public.plugin_reply
    owner to postgres;

create table public.plugin_system_plugin
(
    row_id              bigserial
        primary key,
    name                varchar                  not null,
    another             varchar                  not null,
    version             varchar                  not null,
    description         varchar                  not null,
    listener_host_class varchar                  not null,
    "order"             integer                  not null,
    enable              boolean                  not null,
    is_delete           boolean                  not null,
    create_time         timestamp with time zone not null,
    create_user         bigint                   not null,
    update_time         timestamp with time zone not null,
    update_user         bigint                   not null
);

comment on table public.plugin_system_plugin is '插件表';
comment on column public.plugin_system_plugin.row_id is '主键';
comment on column public.plugin_system_plugin.name is '名称';
comment on column public.plugin_system_plugin.another is '作者';
comment on column public.plugin_system_plugin.version is '版本';
comment on column public.plugin_system_plugin.description is '描述';
comment on column public.plugin_system_plugin.listener_host_class is '监听器class全路径';
comment on column public.plugin_system_plugin."order" is '插件排序';
comment on column public.plugin_system_plugin.enable is '是否启用';
comment on column public.plugin_system_plugin.is_delete is '逻辑删除({0:false,1:true})';
comment on column public.plugin_system_plugin.create_time is '创建时间';
comment on column public.plugin_system_plugin.create_user is '创建用户';
comment on column public.plugin_system_plugin.update_time is '更新时间';
comment on column public.plugin_system_plugin.update_user is '更新用户';

alter table public.plugin_system_plugin
    owner to postgres;

create table public.plugin_system_register
(
    row_id      bigserial
        primary key,
    register_id bigint                   not null,
    type        smallint                 not null,
    auth_level  smallint                 not null,
    is_delete   boolean                  not null,
    create_time timestamp with time zone not null,
    create_user bigint                   not null,
    update_time timestamp with time zone not null,
    update_user bigint                   not null
);

comment on table public.plugin_system_register is '注册表';
comment on column public.plugin_system_register.row_id is '主键';
comment on column public.plugin_system_register.register_id is '注册对象id(qq)';
comment on column public.plugin_system_register.type is '注册对象类型';
comment on column public.plugin_system_register.auth_level is '注册对象权限等级';
comment on column public.plugin_system_register.is_delete is '逻辑删除({0:false,1:true})';
comment on column public.plugin_system_register.create_time is '创建时间';
comment on column public.plugin_system_register.create_user is '创建用户';
comment on column public.plugin_system_register.update_time is '更新时间';
comment on column public.plugin_system_register.update_user is '更新用户';

alter table public.plugin_system_register
    owner to postgres;

commit;