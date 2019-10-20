create table tbl_client (
  id varchar(32) primary key comment '主键',
  code varchar(100) comment '客户端代码',
  secret varchar(100) comment '客户端密码',
  scope varchar(100) comment '客户端作用范围',
  grant_type varchar(100) comment '授权类型',
  created_by varchar(32) not null comment '创建人',
  created_date datetime not null comment '创建时间',
  updated_by varchar(32) comment '更新人',
  updated_date datetime comment '更新时间',
  version bigint default 0
);
alter table tbl_client add index idx_client_code(code);