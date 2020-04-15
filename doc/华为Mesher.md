## Mesher

### mesher基础配置
1. [下载Mesher](https://console.huaweicloud.com/servicestage/?agencyId=084ec2b26e00f4a01fe2c004d16dca9e&region=cn-south-1&locale=zh-cn#/appdev/toolsNew)
2. ak/sk `auth.yaml`
3. 微服务描述信息 `microservice.yaml`
4. 注册中心/配置中心 `chassis.yaml`
    * cse.protocols.http.listenAddress使用局域网ip,不使用127.0.0.1
5. 启动mesher
### 消费方接入使用
1. 配置代理
2. 使用服务名请求
### 提供方接入使用
1. 未接入微服务的消费方可参考上面**消费方接入使用**进行接入
1. 已接入微服务的消费方调用微服务请求"cse://微服务名称/url"地址
2. Mesher修改start.bat配置环境变量SPECIFIC_ADDR=127.0.0.1:本地服务端口
3. 编写提供方的契约
    * 契约文件路径%MESHER_HOME%/conf/提供方微服务名/schema/提供方微服务名.yaml
    * 需符合OpenApi规范
    ```
    swagger: '2.0'
    info:
      title: consumer
      version: 1.0.0
    basePath: /
    produces:
    ‐ application/json
    paths:
      /hello: # 接口
        get:
          operationId: "hello"
          produces:
          ‐ "application/json"
          parameters:
          ‐ name: "id"
             in: "query"
             required: false
             type: "string"
          responses:
            200:
              description: "response of 200"
              schema:
                type: "object"
    ```