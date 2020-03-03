## 配置环境变量,提高效率

太简单了,不再阐述

## 安装前须知

1. 部分mysql版本没有my.ini文件,可以自己新建,编码格式据说一定要ANSI,但我的好像是UTF-8没事

2. my.ini文件跟data目录理论上可以放到任何地方,建议是放到mysql根目录,方便管理
3. 关于mysql根目录,理论上可以放到任何地方,建议放到盘符根目录或者是Program Files目录下,一是路径简单方便查找,二是可以避免一些问题:如中文目录编码问题,如\s目录在脚本运行时被当做空格

## 安装

```
// 配置win服务自启,配置my.ini,注意my.ini里面的路径也要对应上
mysqld --install MySQL --defaults-file="msql安装目录\my.ini"
// 根据my.ini初始化服务
mysqld --initialize
// 启动mysql
net start MySQL
```

**my.ini**

```
[client]
port = 3306
 
[mysqld]
#跳过密码登陆
#skip-grant-tables
#设置3306端口
port = 3306
# 设置mysql的安装目录 tips:这里的目录是你自己的安装目录，这个是我的安装目录，你不能用的哦
basedir=msql安装目录
# 设置mysql数据库的数据的存放目录 tips:同上一条
datadir=msql安装目录\data
# 允许最大连接数
max_connections=200
# 服务端使用的字符集默认为8比特编码的latin1字符集
character-set-server=utf8
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
 
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8
```

## 跳过密码登陆

```
1.在my.ini的mysqld节点增加skip-grant-tables
2.重启服务
3.mysql -u root -p回车
4.再次回车,跳过密码
```

## 修改密码

```
use mysql;
select * from user;
能看到密码字段是authentication_string或者password
如果是前者
update user set authentication_string=PASSWORD('root') where user = 'root';
如果是后者
update user set password=PASSWORD('root') where user = 'root';
代码刷新权限,如不刷新,则需要重启服务
flush privileges;
```

## 密码过期

```
1.把上文中跳过密码的配置注释掉#skip-grant-tables
2.使用修改的密码(上文密码是root)进入
3.ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
4.flush privileges;
```

