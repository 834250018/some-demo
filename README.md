# some-demo about everything
### 排序算法
1. 插入排序
2. 冒泡排序
3. 快速排序
### 设计模式
1. 建造者模式
2. 工厂模式
3. 静/动态代理
4. 责任链
5. 模板模式
6. 单例模式
7. 策略模式
8. 原型模式
9. 适配器模式
### 线程
1. 线程池的数据结构
2. 自定义一个线程池
### jdk8流操作
1. sort
### PKI 公钥基础设施
1. 摘要算法
    ```
    md5
    sha1
    sha*: where * is 224,256,384 and 512
    sha3-*: where * is 256,384 and 512
    ```
2. 对称加密算法(不属于pki)
    ```
    AES(ECB,CBC,CTR,OCF,CFB)
    ```
3. 非对称加密算法
4. 签名验签
5. csr生成
6. 自签名证书生成
    ```
    .DER .CER，文件是二进制格式，只保存证书，不保存私钥。
    .PEM，一般是文本格式，可保存证书，可保存私钥。
    .CRT，可以是二进制格式，可以是文本格式，与 .DER 格式相同，不保存私钥。
    .PFX .P12，二进制格式，同时包含证书和私钥，一般有密码保护。
    .JKS，二进制格式，同时包含证书和私钥，一般有密码保护。
    ```
7. 证书颁发
    ```
    X.509 Certificate v3
    ```
8. CRL颁发(jdk自带的没有找到,需要bouncyCastle依赖)
    ```
    compile group: 'org.bouncycastle', name: 'bcpkix-jdk15on', version: '1.64'
    X.509 CRL v2
    ```
    
### 其他内容
1. 注解及注解上属性值的获取
2. String类型在方法中的传地址问题
3. 几种基本数据类型跟其封装类的比较
4. 浮点型精度问题
5. 单例枚举的线程安全
6. String类下的split方法分割连续字符
7. switch不能传入null
8. protoBuf-demo