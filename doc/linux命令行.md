Redis win 启动
.\redis-server.exe redis.windows.conf
mongod启动
./mongod --dbpath .\db

ps  -ef | grep nginx
Ls -F区分目录跟文件
Ls -lah 检查权限
/usr/local/openresty/nginx
/data/services/nginx_vhost/*.conf
./nginx -t 语法检测
./nginx -s reload
Git remote -v
Mkdir -p
Rm -r
Find / -name nginx.conf
Chmod -R 777 目录
Bash 文件.sh [参数]
netstat -ntulp | grep 9528

http://127.0.0.1:8001/no
http://localhost:8001/fe

/data/qunjia/www/html/index.html
http://10.30.221.243:8080/git/yn-cloud-new-retail/supplier-manager.git

netsh winsock reset


# 强制还原到最新的版本,覆盖本地修改

git fetch --all

git reset --hard origin/master
# 拉去更新代码,如果有冲突,会有提示
# echo git pull
# git pull


nmcli d wifi connect name password 'password'
arp -a

yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
                                                           http://mirrors.aliyun.com/docker-ce/linux/centos/

强制刷新依赖
gradle build --refresh-dependencies
