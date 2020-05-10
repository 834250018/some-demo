交给Srping管理    
```
    @Bean(name="name1")若不指定name,则使用方法名即name2
    public Test1 name2() {
        return new Test1("tttt1111");
    }
@Bean
    public Test1 tttt() {
        return new Test1("tttt1111");
    }
    @Bean
    @Primary
    public Test1 aaaa() {
        return new Test1("aaaaaa5555");
    }
显性指定注入
    @Autowired
    @Qualifier("tttt")
    Test1 tttt;
    ```

配置https服务
生成证书
keytool -genkey -alias tomcat -keypass 123456 -keyalg RSA -keysize 1024 -validity 365 -keystore e:/tomcat.keystore -storepass 123456
把证书移到项目目录

server:
  port: 8443
  ssl:
    protocol: TLS
    key-store: classpath:tomcat.keystore
    key-store-password: 123456
    key-store-type: JKS
    key-alias: tomcat


拦截器
1、创建我们自己的拦截器类并实现 HandlerInterceptor接口。
2、创建一个Java类继承WebMvcConfigurerAdapter，并重写 addInterceptors 方法。
2、实例化我们自定义的拦截器，然后将对像手动添加到拦截器链中（在addInterceptors方法中添加）。
registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
表单传入数据不能直接使用@requestBody获取
要用@requestParem


logging.level.root=INFO
server.servlet-path=/           此处默认/而不是/*
/是拦截除jsp外所有请求.
/*是拦截所有请求(用于服务层)
@SpringBootApplication自带扫描，应该放在最高层，让应用自动扫描其子包内容
@SpringBootApplication自动从下面这些目录加载配置文件
	• 当前目录下的/config子目录，
	• 当前目录。
	• 一个classpath下的/config包
	• classpath根路径（root）
下面这些文件,优先级从高到低排序
application.properties
application.yml

spring.datasource.url=jdbc:mysql://localhost:3306/itcast_oa
spring.datasource.username=itcastoa
spring.datasource.password=1234
spring.datasource.driverClassName=com.mysql.jdbc.Driver
spring.jpa.database=MYSQL
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQLInnoDBDialect
spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.ImprovedNamingStrategy
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp

不解析视图:jar包错误,重复等等
或者是
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<!-- <scope>provided</scope> -->
			//此处一定要删除,此处,请仔细看的scope作用
		</dependency>

时间 格式 转换
@InitBinder
Protected void initBinder(WebDataBinderbinder){
binder.registerCustomEditor(Date.class,newDateEditor(true));
}

Public class DateEditor extends PropertyEditorSupport


Feign
1.需要feign客户端的依赖
2.配置文件需要配置服务名
3.检查两个客户端的注册是否在同一个注册中心
4.@RequestMapping注解要放到接口上,而且方法跟参数也需要注解,参数需要序列化
5.消费方要创建一个接口继承提供方的接口,再注入这个接口,而不是直接注入提供方接口


后端返回一个excel
controller注入一个HttpServletResponse response
OutputStream out = response.getOutputStream();
response.setHeader("content-Type", "application/vnd.ms-excel");
response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("充值账单.xlsx", "utf-8"));
XSSFWorkbook wb = new XSSFWorkbook();
Wb.write(out);
axios前端接收
recharge(startTime, endTime).then(res => {
            let fileName = '车商充值记录.xlsx'
            let blob = new Blob([res.data], {type: 'application/x-xls'})
            if (window.navigator.msSaveOrOpenBlob) {
              navigator.msSaveBlob(blob, fileName);
            } else {
              var link = document.createElement('a');
              link.href = window.URL.createObjectURL(blob);
              link.download = fileName;
              link.click();
              window.URL.revokeObjectURL(link.href);
            }
          }


Public ResponseEntity<byte[]> apkDownload(@NotNullStringid,HttpServletRequestrequest){
Stringurl=mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),ApkEntry.class).getUrl();
Filefile=new File(url);
HttpHeaders headers=new HttpHeaders();
//attachment模式为下载
headers.setContentDispositionFormData("attachment",file.getName());
//application/octet-stream二进制流数据
headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
returnnewResponseEntity<byte[]>(,headers,HttpStatus.MULTI_STATUS.CREATED);
}

Spring mvc可以自动把文件资源注入
MultipartFile (此操作会在系统缓存文件夹创建一个tmp文件)
此类有三个常用方法 transferTo getInputStream getOriginalFilename

transferTo(file) 把缓存文件保存为file(类似于剪切更名),如果file的路径是相对路径,则此方法会自动在路径前面加入缓存文件夹路径

environment.getActiveProfiles()[0])   
// 一定是application-local.yml里面的配置(不是dev也不是prod)
等于yml配置文件的这个
spring:
	profiles:local
@DBRef 注解使用
此注解放在查询侧实体的字段上,拥有此注解的字段会自动把相应实体查询出来
在命令侧中,与查询侧对应的字段类型为String , 存 id
(查询侧保存数据的时候,需要新建一个实体,然后把存的id塞进去)
Public ResponseEntity<byte[]> apkDownload(@NotNullStringid,HttpServletRequestrequest){
Stringurl=mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),ApkEntry.class).getUrl();
Filefile=new File(url);
HttpHeaders headers=new HttpHeaders();
//attachment模式为下载
headers.setContentDispositionFormData("attachment",file.getName());
//application/octet-stream二进制流数据
headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
returnnewResponseEntity<byte[]>(,headers,HttpStatus.MULTI_STATUS.CREATED);
}



@ControllerAdvice 对全部的Controller
@ExceptionHandler 与上面的注解一起使用,找去某个返回的异常

//配置转换器
Public void configureMessageConverters(List<HttpMessageConverter<?>>converters){
converters.add(new ByteArrayHttpMessageConverter());
converters.add(new MappingJackson2HttpMessageConverter(
Jackson2ObjectMapperBuilder.json()
.simpleDateFormat("yyyy-MM-ddHH:mm:ss")
.timeZone("GMT+8")
.build()));
converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
super.configureMessageConverters(converters);
}

忽视@value找不到占位符启动不了的错误
@Configuration
publicclassDynamicServerConfigextendsPropertySourcesPlaceholderConfigurer{
@Override
Public void postProcessBeanFactory(ConfigurableListableBeanFactorybeanFactory) throws BeansException{
	setIgnoreUnresolvablePlaceholders(true);
	super.postProcessBeanFactory(beanFactory);
}
}

springmvc接收数组
@RequestParam("ids[]")ArrayList<String>ids

// 配置切面增强类
@Aspect
@Component
Public class UserSessionAspect{
	// 切面
	// 表示com.yn.channel.web.controller.user包下的所有类的所有方法(带任何参数)
	@Pointcut("execution(public*com.yn.channel.web.controller.user.*.*(..))")
	Public void anyMethod(){
	}
}
前置增强
@Before("anyMethod()")
Public void doAccessCheck(JoinPointjoinPoint){
}


jsr303显性校验dto
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<EnterCreateCommand>> constraintViolations = validator.validate(command);
        ConstraintViolation<EnterCreateCommand> constraintViolation = Iterables.getFirst(constraintViolations, null);
        if (constraintViolation != null) {
            throw new ValidationException(constraintViolation.getMessage());
        }
