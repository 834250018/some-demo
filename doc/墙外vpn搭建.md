# VPN搭建流程

0. 前期准备
    1. 需要准备一架临时梯子
    2. 外币信用卡(visa,MasterCard)
1. 获取境外服务器
    1. 地区
        1. 香港
        2. 台湾
        3. 东京
        4. 首尔
    2. 供应商
        1. 谷歌云
        2. 亚马逊云
        3. 阿里云
        4. 其他...
    3. 费用
        1. 收费版
        2. 一年体验(各个供应商均有体验套餐)
    4. 系统选用
        1. Ubuntu LTS
        2. Debian
        3. CentOS
2. VPN搭建
    1. 自动化搭建脚本>>>>[setup-ipsec-vpn](https://github.com/hwdsl2/setup-ipsec-vpn)
3. 配置网络安全组
    1. 开放udp500入站端口
    2. 开放udp4500入站端口