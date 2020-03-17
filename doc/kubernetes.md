## hyper-v使用

1. 下载镜像

2. 创建默认虚拟机,设置镜像,启动安装

3. 安装完了之后要去设置那边把镜像给去掉,否则一直在安装页面

4. 创建虚拟交换机,选择外部网络,配置此虚拟交换机到虚拟机

5. centos网络设置设置

   1. 启用网卡

      `vi /etc/sysconfig/network-scripts/ifcfg-ens
      ONBOOT=no改成ONBOOT=yes`

   2. 重新加载网络配置文件
      `nmcli c reload`

6. 使用其他常用的ssh工具登录(如Xshell,Hyper-v自带的不太好用)

7. 基本配置完,创建多个副本

   1. 导出配置好的虚拟机
   2. 指定导入文件夹为1中导出的文件夹
   3. 导入类型为复制虚拟机(创建唯一的ID)
   4. 设置存储目录为新目录
   5. 完成

## Kubernetes(k8s)

#### 特性

* **自动包装 **(根据资源跟其他约束自动放置容器,同时不牺牲可用性,混合关键和最大努力的工作负载,以提高资源利用率并节省更多资源)
* **横向缩放 **(简单命令或ui控制,或根据cpu自动调整副本数)
* **自动部署和回滚 **(k8s逐渐部署对应用或其配置的更改,同时监控运行状态,确保不会同时终止所有实例)
* **存储编排** (自动安装所选择的存储系统)
* **自我修复 **(重新启动失败的容器,在节点不可用时,替换和重新编排节点上的容器,终止不对用户定义的健康检查做出响应的容器,并且不会再客户端准备投放之前将其告知给客户端)
* **服务发现和负载均衡 **(不需要修改你的应用程序来使用不熟悉的服务发现机制,k8s为容器提供了自己的ip地址和一组容器的当个DNS名称,并可以在他们之前进行负载均衡)
* **密钥和配置管理 **(部署和更新密钥和应用程序配置,不会重新编译你的镜像,不会再堆栈配置中暴露密钥)
  批处理(除了服务之外,k8s还可以管理你的批处理和CI工作负载,如果需要,替换出现故障的容器)

#### 常用术语及介绍

* **Replication Controller** 定义一个Pod的创建过程及副本数量的自动控制
  * Pod期待的副本数(replicas)
  * 用于筛选目标Pod的Label Selector
  * 当Pod的副本数量小于预期数量时,用于创建新Pod的Pod模板(template)
  * RC包含完整的Pod定义模板
  * RC通过Label Selector机制实现对Pod副本的自动控制
  * 通过改变RC里的Pod副本数量,可以实现Pod的扩容或缩容功能
  * 通过改变RC里Pod模板中的镜像版本,可以实现Pod的滚动升级功能

* **Service** k8s中的微服务,指定node对外服务入口,及其他一些配置

* **kubelet** 负责维护容器的生命周期,同时也负责Volume(CVI)和网络(CNI)的管理

* **Container** runtime负责镜像管理以及Pod和容器的真正运行(CRI)

* **kube-proxy** 负责为Service提供cluster内部的服务发现和负载均衡

* **Cluster** 是计算、存储和网络资源的集合,K8S利用这些资源运行各种容器的应用,由Master和Node组成
  *  **Master** 主要职责是调度
    * **apiserver** 提供了资源操作的统一入口,并提供认证、授权、访问控制、API注册和发现等机制
    * **scheduler** 负责资源的调度,按照预定的调度策略将Pod调度到相应的机器上
    * **Controller Manager** 自动化控制中心,管理资源
      * replication controller管理Deployment、StatefulSet、DaemonSet的生命周期
      * endpoints controller
      * namespace controller管理Namespace资源
      * serviceaccounts controller
    * **etcd** 保存了cluster的配置信息和各种资源的状态信息,当数据发生变化时,etcd会快速通知k8s相关组件
    * **Pod网络** Pod要能够互相同学,必须部署Pod网络,flannel是其中一个可选方案
  * **Node** 除了Master,k8s集群中的其他机器被称为Node节点 Node职责是运行容器运用,Node由Master管理,Node负责监控并汇报容器的状态,同时根据Master的要求管理容器的生命周期.
    * **kubelet** 负责Pod对应的容器的创建、启动等任务,同时与Master节点密切协作,实现集群管理的基本功能
    * **kube-proxy** 实现k8s Service的通信与负载均衡机制的重要组件
    * **Docker Enginer** Docker 负责本机的容器创建和管理工作
    * **Pod** k8s的最小单元,每个Pod包含一个或多个容器,Pod的容器会作为一个整体被Master调度到一个Node上运行.k8s为每个Pod都分配了唯一的IP地址,称为PodIP,一个Pod里面多个容器共享PodIp地址,再k8s里,一个Pod里的容器与另外主机上的Pod容器能够直接通信

#### Kubernetes(k8s)单机快速安装
1. 关闭防火墙
   systemctl disable firewalld
   systemctl stop firewalld

2. yum update

3. 安装etcd k8s (含docker) 
   yum install -y etcd kubernetes(centos8似乎没有找到源,可以以二进制的方式安装,下面集群部分有二进制安装方式)

4. 启动docker
   systemctl start docker

5. 启动master相关服务
   systemctl start etcd
   systemctl start kube-apiserver
   systemctl start kube-controller-manager
   systemctl start kube-scheduler

6. 启动node相关服务(此处为单机,所以node服务跟master装在一起)
   systemctl start kubelet
   systemctl start kube-proxy

7. 配置容器,这里以tomcat为例

   1. 创建配置文件
      0. yaml格式下tab缩进应当为两个单位
      1. 建议写完去在线yml格式化网站校验一遍
      2. 冒号后面跟随一个空格
      3. 横线表示上一级是数组,横线缩进数量与上一级相同
      4. 横线后面跟随一个空格
      5. 数组中所有元素缩进多上一级元素两个缩进(包括横线)

      * mytomcat.rc.yml

      ```
      apiVersion: v1
      kind: ReplicationController
      metadata:
        name: mytomcat
      spec:
        replicas: 2
        selector:
      	  app: mytomcat
      	template:
      	  metadata:
      	    labels:
              app: mytomcat
          spec:
            containers:
            - name: mytomcat
              image: tomcat:7-jre7
              ports:
              - containerPort: 8080
      ```

      * mytomcat.svc.yml

      ```
      apiVersion: v1
      kind: Service
      metadata:
        name: mytomcat
      spec:
      	type: NodePort
      	ports:
      	- port: 8080
      	  nodePort: 30001
      	selector:
      	  app: mytomcat
      ```

      

   2. 部署

      1. kubectl create -f mytomcat.rc.yaml
      2. kubectl create -f mytomcat.svc.yaml

   3. 查询kubectl get all

   4. kubectl get pods

#### Kubernetes(k8s)集群
一台master,安装etcd、kube-apiserver、kube-controller-manager、kube-scheduler、docker
两台node,kube-proxy、kubelet、docker