Unable to resolve plug-in "platform:/plugin/org.eclipse.team.svn.ui/icons/vi
删除org.eclipse.team.svn.ui

mongod启动不起来了，提示
 couldn't connect to server 127.0.0.1:27017 src/mongo/shell/mongo.js:91错误，
在网上查了下解决办法，大部分人说设置一下 dbpath, 这个固然能解决问题，但并非找到问题的根源，
问题的根源在于，机器非法关机导致的mongod 非法关掉，留下了，一个mongod.lock, 将数据库给锁定了，只要删除此文件，重启服务即可，

Localhost:8080/swagger-ui.html无法打开,
(swagger-ui.html已经在classpath:/META-INF/resources/中,不需要配置静态资源)
原因是RequestMappingHandlerMapping优先级高于SimpleUrlHandlerMapping
我在controller上配置了@RequestMapping(value="/{str1})
每次打开Localhost:8080/swagger-ui.html,都是进入到controller而不是静态文件/swagger-ui.html

使用ResponseEntity下载文件,出现文件被损坏的bug
把ByteArrayHttpMessageConverter配置到
MappingJacksonHttpMessageConverter前面


CreateProcess error=206, 文件名或扩展名太长。
原因：gradle(或maven)配置的仓库路径过长。 解决方法：修改仓库路径尽量短 

maven一直用旧版本jar包bug
注释gradle.xml不能解决,需要手动删本地仓库

引入的jar包无法注入 Could not find
原因一: 扫描路径,入口类的路径必须在相同路径下,必须是父路径
原因二: 同时使用同名的bean注入时会出现上述问题,
解决方法:在需要的接口上取别名,也可能是需要使用
@EnableMongoRepositories(basePackages = {"com.yn.report.entry.channel",
        "com.yn.report.repository.channel",})

gradle本地不更新仓库jar包(快照)
一:本地gradle没装
二:配置文件
configurations.all { 
//每隔24小时检查远程依赖是否存在更新 resolutionStrategy.cacheChangingModulesFor 24, 'hours' //每隔10分钟.. 
 // 采用动态版本声明的依赖缓存10分钟 resolutionStrategy.cacheDynamicVersionsFor 10*60, 'seconds' } 

Git 文件一直是白色(不提交)
1.重启webstorm
2.git add -f 文件路径

cookie中文乱码问题
存入前先把中文ecodeURI(str)
取出前unescape(decodeURI(str))

Nginx404
可能是root跟alias的问题,路径拼错了

修改了nginx后没反应,
外网不能使用service nginx reload
100使用service nginx reload


ELIFECYCLE
删除node_modules


依赖注入不成功
是否有get set和构造方法
当前类是否有@Component,是否被@Autowired
是否为static,如果是,则@Value需要特殊处理,且不能使用final



Vue router的两个bug
bug1:无限刷新:由于roles的长度被我改成了0也可以进入,所以每次进入判断长度为零,又继续加载路由
正确的情况应该是当登录的用户roles的长度为0时,抛出异常,不让它进入

bug2:进入到某个页面之后,F5刷新后进入空白或者进入首页,是因为
{ path: '*', redirect: '/404', hidden: true }这个路由被我配置到了constantRouterMap而不是asyncRouterMap
constantRouterMap下面的路由,不需要动态加载,当按下F5之后直接在constantRouterMap,找到上述路由,所以进入404(错误结果)
若上述路由配置到asyncRouterMap,则是动态生成路由之后加载(正确结果)
