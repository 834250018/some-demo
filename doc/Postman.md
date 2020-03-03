# Postman

1. 配置全局变量,可用于多套环境
    
    |key | value|
    |---|---|
    | host | http://localhost:8080 |
    | host.prod | http://www.prod.com |
    ```
    使用{{host}}/test请求http://localhost:8080/test
    使用{{host.prod}}/test请求http://www.prod.com/test
    ```
2. 鼠标指向某个collection,其右上角有个右三角,点击,选择run打开并发测试页面