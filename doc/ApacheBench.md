## ApacheBench ab

1. 请求:
    ```
    ab -n 1000 -c 50 https:localhost:8080/test
    -n 请求数
    -c 并发数
    ```
```
Concurrency Level:      50 并发
Time taken for tests:   0.552 seconds 请求耗时
Complete requests:      1000 成功请求
Failed requests:        0 失败请求
Total transferred:      136000 bytes 总请求返回数据
HTML transferred:       4000 bytes  总请求正文返回数据
Requests per second:    1811.14 [#/sec] (mean) 每秒请求数(complete_request/time_taken_for_tests)
Time per request:       27.607 [ms] (mean) 用户平均等待时间;;;并发下总耗时*并发数/总请求数量(即不在并发状态下的请求等待时间理论值)(time_taken_for_tests*concurrency_level/complete_requests)
Time per request:       0.552 [ms] (mean, across all concurrent requests) 服务器平均等待时间,并发下总耗时/总请求数量(time_taken_for_tests/complete_requests)
Transfer rate:          240.54 [Kbytes/sec] received 每秒传输数据量(total_transferred/time_taken_for_tests)
```
