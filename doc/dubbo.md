连接超时时,重新启动zookeeper

简单配置:
导入dubbo、zookeeper包
服务消费方
	<!-- 应用信息,用于计算依赖关系,此处name不能与别的重名 -->
	<dubbo:application name="test_consumer" />
	<!-- 使用zookeeper注册中心暴露服务地址 -->
	<dubbo:registry address="zookeeper://127.0.0.1:2181"/>
	<!-- 声明使用的服务接口 -->
	<dubbo:reference interface="cn.oa.service.api.TestService" id="testService"/>
服务提供方
    <!-- 应用信息，用于计算依赖关系 -->
    <dubbo:application name="test_provider" />
    <!-- 使用zookeeper注册中心暴露服务地址 -->
    <dubbo:registry address="zookeeper://127.0.0.1:2181" timeout="100000" />
    <!-- 用dubbo协议在20880端口暴露服务 -->
    <dubbo:protocol name="dubbo" port="20880" host="127.0.0.1" />
    <!-- 声明需要暴露的服务接口 -->
    <dubbo:service interface="cn.oa.service.api.TestService" ref="testService" />
    <bean id="testService" class="cn.oa.service.TestServiceImpl" />    
   <!-- 上面两句等同于下面一句 --> 
   <!-- 
	<dubbo:service interface="cn.oa.service.api.TestService" class="cn.oa.service.TestServiceImpl"/>
	class这里,如果此类用@resource或者@service标注了可以使用ref="testServiceImpl"
	 class="cn.oa.service.TestServiceImpl"相当于
	ref="testServiceImpl"
   -->

问题:
如果连接超时,重启zookeeper
如果没有zookeeper显示
可能是配置文件没有扫描
A component required a bean named 'configServiceImpl' that could not be found.

com.mongodb.MongoSecurityException 权限问题,一般跟用户名或者密码有关
类找不到  可能是maven依赖少了,或者是链接细节错了 也可能是没有扫描
@repository放在dao层
