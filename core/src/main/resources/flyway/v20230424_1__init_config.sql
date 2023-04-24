-- auto-generated definition
begin;
create table core_config
(
    row_id      bigserial                not null,
    keyword     varchar                  not null,
    value       json                     not null,
    description varchar                  not null,
    is_delete   smallint                 not null,
    create_time timestamp with time zone not null,
    create_user bigint                   not null,
    update_time timestamp with time zone not null,
    update_user bigint                   not null,
    primary key (row_id)
);

comment on table core_config is '配置表';
comment on column core_config.row_id is '主键';
comment on column core_config.keyword is '关键词';
comment on column core_config.value is '值';
comment on column core_config.description is '描述';
comment on column core_config.is_delete is '逻辑删除({0:false,1:true})';
comment on column core_config.create_time is '创建时间';
comment on column core_config.create_user is '创建用户';
comment on column core_config.update_time is '更新时间';
comment on column core_config.update_user is '更新用户';

commit;