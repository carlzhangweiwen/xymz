DROP TABLE IF EXISTS `tb_user`;
create table tb_user(
id	int(8) not null auto_increment comment '用户表id' ,
mobilephone	varchar(15) not null comment '用户手机号',
password	varchar(60) not null comment '用户登录密码',
username	varchar(30) comment '用户名',
realname	varchar(15) comment '用户真实姓名',
gender	int(1) comment '用户性别0:女,1:男',
birthday	varchar(15) comment '出生年月1989-12-19',
email	varchar(30) comment '邮箱地址',
photourl	varchar(100) comment '头像',
resumeId	int(8) comment '简历',
regip	varchar(30) comment '注册时ip地址',
create_time varchar(18) comment '创建时间20150901 115959000',
update_time varchar(18) comment '修改时间20150901 115959000',
primary key(id)
)
;

