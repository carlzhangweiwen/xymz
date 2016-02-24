DROP TABLE IF EXISTS `tb_user`;
create table tb_user(
id	int(8) not null auto_increment comment '用户表id' ,
mobilephone	varchar(15) not null comment '用户手机号',
cpassword	varchar(60) not null comment '用户登录密码',
username	varchar(30) comment '用户名',
realname	varchar(15) comment '用户真实姓名',
gender	int(1) comment '用户性别0:女,1:男',
birthday	varchar(15) comment '出生年月1989-12-19',
email	varchar(30) comment '邮箱地址',
photourl	varchar(100) comment '头像',
resumeId	int(8) comment '简历',
regip	varchar(30) comment '注册时ip地址',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间20150901 115959000',
update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间20150901 115959000',
primary key(id)
)
;
DROP TABLE IF EXISTS `tb_options`;
create table tb_options(
id	int(8) not null auto_increment comment '用户表id' ,
name varchar(40) comment '名字',
ctype int(1) comment '类型,0:选项组，1:选项',
cvalue varchar(40) comment '选项值，如果类型为type=0这里放空',
parent_id int(8) comment '父选项',
corder int(4) comment '排序',
enable int(1) comment '生效标识0,1',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间20150901 115959000',
create_person varchar(40) comment '创建人',
update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间20150901 115959000',
update_person varchar(40) comment '修改人',
primary key(id)
)
;
DROP TABLE IF EXISTS tb_resume;
create table tb_resume(
id	int(8) not null auto_increment comment '用户表id' ,
school varchar(40) comment '学校',
college varchar(40) comment '学院',
major varchar(40) comment '专业',
schoolyear varchar(15) comment '入学年份2015-03-12',
mylabel varchar(40) comment '我的标签（技术男;傻白甜）',
address varchar(40) comment '地址',
longitude varchar(40) comment '经度',
latitude varchar(40) comment '纬度',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间20150901 115959000',
update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间20150901 115959000',
primary key(id)
)
;
DROP TABLE IF EXISTS tb_job;
create table tb_job(
id	int(8) not null auto_increment comment '用户表id' ,
companyid int(8) comment '公司id',
jobtypeid varchar(2) comment '对应option表中的工种id',
jobtitle varchar(100) comment '工作标题',
jobcontent varchar(2000) comment '工作内容',
salary_amount int(8) comment '工作薪水金额',
salary_unit_id int(8) comment '薪水单位id',
work_begin_time varchar(18) comment '工作开始时间',
work_end_time varchar(18) comment '工作结束时间',
jobloction varchar(100) comment '工作地址',
longitude varchar(40) comment '经度',
latitude varchar(40) comment '纬度',
recruitment_num int(3) comment '招聘人数',
contacts_email varchar(30) comment '邮箱地址',
contacts_person varchar(18) comment '联系人',
contacts_tel varchar(30) comment  '咨询电话',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间20150901 115959000',
update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间20150901 115959000',
audit_state int(1) comment '审核状态	0待审核；1审核中；2审核未通过；3审核通过；4用户取消审核',
audit_person varchar(18) comment '审核人',
audit_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '审核时间',
audit_comment varchar(100) comment '审核备注',
primary key(id)
)
;
DROP TABLE IF EXISTS tb_company;
create table tb_company(
id	int(8) not null auto_increment comment '用户表id' ,
name varchar(30) comment '公司名称',
property varchar(30) comment '公司性质',
email varchar(30) comment '邮箱地址',
industry varchar(30) comment '所属行业',
contacts_person varchar(18) comment '联系人',
contacts_tel varchar(30) comment '咨询电话',
location varchar(100) comment '公司地址',
longitude varchar(40) comment '经度',
latitude varchar(40) comment '纬度',
company_info varchar(1000) comment '公司简介',
company_logo_img varchar(100) comment '公司logo地址',
cooperative_agreements_img varchar(100) comment '合作协议照片',
business_licence_img varchar(100) comment '营业执照照片',
audit_state int(1) comment '审核状态	0待审核；1审核通过',
audit_person varchar(18) comment '审核人',
audit_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '审核时间',
audit_comment varchar(100) comment '审核备注',
primary key(id)
)
;









