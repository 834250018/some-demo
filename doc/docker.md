docker run -dit -p 80:80 -p 22:22 -p 443:443 --name gitlab --restart always -v /srv/gitlab/config:/etc/gitlab -v /srv/gitlab/logs:/var/log/gitlab -v /srv/gitlab/data:/var/opt/gitlab gitlab/gitlab-ce

部署一个git
配置一个push钩子
push的时候执行脚本	1.进入目标目录
	2.停止容器
	3.删除容器
	4.删除镜像
	5.创建镜像
	5.生成容器并启动
通过jar包创建image
似乎只要进入某个文件夹,就可以使用docker build命令,通过jar跟dockerfile生成容器

跑本机脚本
Processprocess;
Stringcmd="cmdcde:/excelJson/build/libs&&./a.sh";
try{
Runtimeruntime=Runtime.getRuntime();
System.out.println("开始执行");
process=runtime.exec(cmd);
//打印执行的输出结果
InputStreamis=process.getInputStream();
InputStreamReaderisr=newInputStreamReader(is,"gbk");//gbk：解决输出乱码
BufferedReaderbr=newBufferedReader(isr);
Stringline;
while((line=br.readLine())!=null){
System.out.println(line);
}
is.close();
isr.close();
br.close();
}catch(IOExceptione){
e.printStackTrace();
}

脚本rebuild.sh
echocde:/excelJson/build/libs
cde:/excelJson/build/libs
echogitpull
gitpull
echodockerstopexceljson
dockerstopexceljson
echodockerrmexceljson
dockerrmexceljson
echodockerrmiexceljson
dockerrmiexceljson
echodockerbuild-texceljson:latest./
dockerbuild-texceljson:latest./
echorun
dockerrun-itd--nameexceljson-p30003:30003exceljson

Dockerfile
FROMfabric8/java-jboss-openjdk8-jdk:1.4.0
MAINTAINERve834250018@qq.com
LABELversion="1.0"name="excelJson"
ADD./excelJson.jarexcelJson.jar
CMDjava-jarexcelJson.jar
EXPOSE3003


Docker run -v 宿主机路径:容器路径
-d 后台运行 
--net="bridge"， 容器网络设置:
	bridge 使用docker daemon指定的网桥
	host //容器使用主机的网络
	container:NAME_or_ID >//使用其他容器的网路，共享IP和PORT等网络资源
	none 容器使用自己的网络（类似--net=bridge），但是不进行配置
-v 挂载存储
--net host
docker run -d --name jenkins --restart always  -p 8080:8080 -p 50000:50000 -v /usr/bin/docker:/usr/bin/docker -v /var/run/docker.sock:/var/run/docker.sock -v /jenkins_home:/var/jenkins_home -u root jenkins/jenkins

jenkins安装不能联网
http://localhost:8080/pluginManager/advanced。 这里面最底下有个【升级站点】，把其中的链接改成http的就好了，http://updates.jenkins.io/update-center.json。 然后在服务列表中关闭jenkins，再启动，这样就能正常联网了

Auth fail,请检查用户名跟密码
Unable to access 请检查目标连接是否能正常打开
http://localhost:8080/job/learn/build?token=testBuild

docker run --name mysql -p 3306:3306 --restart=always -v /mysql/datadir:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456  -d mysql

docker exec -it mongo /bin/bash
mongo localhost:27017
show dbs;
use supplier_query; 
db.supplierEntry.find({});

文件上传 须将docker跟宿主机的文件夹做映射

mq连接着连接着突然又拒绝了,重新生成容器即可,命令如下
docker run -d --name rabbitmq -p 5671:5671  -p 5672:5672 -p 4369:4369 -p 25672:25672 -p 15671:15671 -p 15672:15672 rabbitmq:management


Docker run permission defend
dockerfile里面的volume,不能指定宿主机的目录,所以在run命令里面加,比较强大
