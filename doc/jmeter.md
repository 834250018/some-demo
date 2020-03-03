# jmeter
1. 设置中文
    ```
    bin目录/jmeter.properties
    line 37
    language=zh_CN
    ```
2. 线程组
    ```
    线程数 50
    ramp-up时间 1  多少秒内启动完所有的线程(这里表示1秒内启动50个线程)
    循环次数 20  每个线程要执行多少次
    ```