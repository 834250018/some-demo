Permission denied
修改权限 chmod 777 文件

Nginx root的路径会与passproxy路径合并
而alias是别名,比如alias: /aaa/  passproxy: /bbb/ccc/
访问  域名/aaa/实际路径为服务器中的/bbb/ccc/
nginx中 include引入其他配置文件
在主配置文件中可以引入带server的配置(前提是server的serverName跟端口,在主配置文件中不存在相同的,存在相同的,会冲突)
在server的配置块中间可以引入location,同样的,location访问路径不可以跟已有的相同,但是指向的路径可以相同
