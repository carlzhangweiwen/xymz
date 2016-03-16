# xymz
校园萌主


兼职平台，为大学在校生服务


/xymz/getAuthCodeImg
获取动态验证码



---------
环境搭建：
1.安装mysql数据库；
2.先运行src\main\webapp\DB\DBInitial.txt中的sql语句，创建用户和测试表
3.运行src\main\webapp\DB\create_tables.sql创建需要的表

----------------------------------------------
说明，如下文件是用来初始化项目的。根据数据库中的表，生成bean，mapper及mapper.xml(可以参考这篇文章http://www.cnblogs.com/xdp-gacl/p/4271627.html)：
mybatis-generator-core-1.3.2.jar
mysql-connector-java-5.1.30-bin.jar
generator.xml
command.txt