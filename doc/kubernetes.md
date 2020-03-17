## hyper-v使用(win10专业版以上才有)

1. 开启Hyper-V功能

   1. 控制面板

   2. 程序与功能

   3. 启用或关闭Windows功能

   4. 勾选Hype-V

   5. 重启电脑进入BIOS

   6. 进入bios（F12 by主板厂家不同）->application menu->security->Virtualization->VMM->Enabled

      数据执行保护：

      进入bios（F12 by主板厂家不同）->application menu->security->Memory Protextion->Exection Prevention->Enabled

2. 下载镜像

3. 创建默认虚拟机,设置镜像,启动安装

4. 安装完了之后要去设置那边把镜像给去掉,否则一直在安装页面

5. 创建虚拟交换机,选择外部网络,配置此虚拟交换机到虚拟机

6. centos网络设置设置

   1. 启用网卡

      `vi /etc/sysconfig/network-scripts/ifcfg-ens
      ONBOOT=no改成ONBOOT=yes`

   2. 重新加载网络配置文件
      `nmcli c reload`

7. 使用其他常用的ssh工具登录(如Xshell,Hyper-v自带的不太好用)

8. 基本配置完,创建多个副本

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
1. 安装docker:

   1. 设置镜像仓库 `curl https://download.docker.com/linux/centos/docker-ce.repo -o /etc/yum.repos.d/docker-ce.repo`
   2. 安装依赖 `yum install https://download.docker.com/linux/fedora/30/x86_64/stable/Packages/containerd.io-1.2.6-3.3.fc30.x86_64.rpm`
   3. 安装docker `yum install docker-ce`
   4. 启动docker `systemctl start docker`

2. master(一台,安装etcd、kube-apiserver、kube-controller-manager、kube-scheduler、docker)

   1. etcd

      1. 下载https://github.com/etcd-io/etcd/releases

      2. 解压`tar -zxvf  etcd-v3.3.9-linux-amd64.tar.gz`

      3. 移动etcd和etcdctl到/usr/bin目录`cp etcd etcdctl /usr/bin`

      4. 配置systemd服务文件 `vi /usr/lib/systemd/system/etcd.service`

         ```
         [Unit]
         Description=Etcd Server
         After=network.target
         [Service]
         Type=simple
         EnvironmentFile=-/etc/etcd/etcd.conf
         WorkingDirectory=/var/lib/etcd/
         ExecStart=/usr/bin/etcd
         Restart=on-failure
         [Install]
         WantedBy=multi-user.target
         ```

      5. 启动与测试etcd服务

         1. `systemctl daemon-reload`
         2. `systemctl enable etcd.service`
         3. `mkdir -p /var/lib/etcd/`
         4. `systemctl start etcd.service`
         5. `etcdctl cluster-health`

   2. kube-apiserver

      1. 解压`tar -zxvf kubernetes-server-linux-amd64.tar.gz`

      2. 移动`cp kube-apiserver kube-controller-manager kube-scheduler kubectl /usr/bin/`

      3. 配置systemd服务文件 `vi /usr/lib/systemd/system/kube-apiserver.service`

         ```
         [Unit]
         Description=Kubernetes API Server
         Documentation=https://github.com/kubernetes/kubernetes
         After=etcd.service
         Wants=etcd.service
         [Service]
         EnvironmentFile=/etc/kubernetes/apiserver
         ExecStart=/usr/bin/kube-apiserver $KUBE_API_ARGS
         Restart=on-failure
         Type=notify
         [Install]
         WantedBy=multi-user.target
         ```

      4. 创建目录`mkdir /etc/kubenetes`

      5. 创建apiserver配置文件`vi /etc/kubernetes/apiserver`(可以调整端口)

         `KUBE_API_ARGS="--storage-backend=etcd3 --etcd-servers=http://127.0.0.1:2379 --insecure-bind-address=0.0.0.0 --insecure-port=8080 --service-cluster-ip-range=169.169.0.0/16 --service-node-port-range=1-65535 --admission-control=NamespaceLifecycle,NamespaceExists,LimitRanger,SecurityContextDeny,ServiceAccount,DefaultStorageClass,ResourceQuota --logtostderr=true --log-dir=/var/log/kubernetes --v=2"`

   3. kube-controller-manager服务(依赖于kube-apiserver服务)

      1. 配置systemd服务文件 `vi /usr/lib/systemd/system/kube-controller-manager.service`

         ```
         [Unit]
         Description=Kubernetes Controller Manager
         Documentation=https://github.com/GoogleCloudPlatform/kubernetes
         After=kube-apiserver.service
         Requires=kube-apiserver.service
         [Service]
         EnvironmentFile=/etc/kubernetes/controller-manager
         ExecStart=/usr/bin/kube-controller-manager $KUBE_CONTROLLER_MANAGER_ARGS
         Restart=on-failure
         LimitNOFILE=65536
         [Install]
         WantedBy=multi-user.target
         ```

      2. 配置文件 `vi /etc/kubernetes/controller-manager`(注意去掉换行,且修改ip)

         1. `KUBE_CONTROLLER_MANAGER_ARGS="--master=http://192.168.1.5:8080 --logtostderr=true --log-dir=/var/log/kubernetes --v=2"`

   4. kube-scheduler服务(依赖于kube-apiserver服务)

      1. 配置systemd服务文件 `vi /usr/lib/systemd/system/kube-scheduler.service`

         ```
         [Unit]
         Description=Kubernetes Scheduler
         Documentation=https://github.com/GoogleCloudPlatform/kubernetes
         After=kube-apiserver.service
         Requires=kube-apiserver.service
         [Service]
         EnvironmentFile=/etc/kubernetes/scheduler
         ExecStart=/usr/bin/kube-scheduler $KUBE_SCHEDULER_ARGS
         Restart=on-failure
         LimitNOFILE=65536
         [Install]
         WantedBy=multi-user.target
         ```

      2. 配置文件 `vi /etc/kubernetes/scheduler`(注意去掉换行,且修改ip)

         1. `KUBE_SCHEDULER_ARGS="--master=http://192.168.1.5:8080 --logtostderr=true --log-dir=/var/log/kubernetes --v=2"`

   5. 启动上述几项服务

      1. systemctl daemon-reload
      2. systemctl enable kube-apiserver.service
      3. systemctl start kube-apiserver.service
      4. systemctl enable kube-controller-manager.service
      5. systemctl start kube-controller-manager.service
      6. systemctl enable kube-scheduler.service
      7. systemctl start kube-scheduler.service

3. node节点配置(两台,kube-proxy、kubelet、docker 拷贝出来)

   1. 拷贝`cp kubelet kube-proxy /usr/bin/`

   2. kubelet服务

      1. 配置systemd服务文件`vi /usr/lib/systemd/system/kubelet.service`

         ```
         [Unit]
         Description=Kubernetes Kubelet Server
         Documentation=https://github.com/GoogleCloudPlatform/kubernetes
         After=docker.service
         Requires=docker.service
         [Service]
         WorkingDirectory=/var/lib/kubelet
         EnvironmentFile=/etc/kubernetes/kubelet
         ExecStart=/usr/bin/kubelet $KUBELET_ARGS
         Restart=on-failure
         KillMode=process
         [Install]
         WantedBy=multi-user.target
         ```

      2. 创建工作空间 `mkdir -p /var/lib/kubelet`

      3. 配置文件`vi /etc/kubernetes/kubelet`(注意修改ip,同时注意此处有指定一个配置文件,用于kubelet连接Master Apiserver)

         `KUBELET_ARGS="--kubeconfig=/etc/kubernetes/kubeconfig --hostname-override=192.168.1.* --logtostderr=false --log-dir=/var/log/kubernetes --v=2 --fail-swap-on=false"`

      4. 连接apiserver的配置文件`vi /etc/kubernetes/kubeconfig`(注意yaml格式)

         ```
         apiVersion: v1
         kind: Config
         clusters:
         - cluster:
             server: http://192.168.1.5:8080
           name: local
         contexts:
         - context:
             cluster: local
           name: mycontext
         current-context: mycontext
         ```

   3. kube-proxy服务(依赖于network服务)

      1. 配置systemd服务文件`vi /usr/lib/systemd/system/kube-proxy.service`

         ```
         [Unit]
         Description=Kubernetes Kube-proxy Server
         Documentation=https://github.com/GoogleCloudPlatform/kubernetes
         After=network.service
         Requires=network.service(centos8似乎没有network,把这行删掉)
         [Service]
         EnvironmentFile=/etc/kubernetes/proxy
         ExecStart=/usr/bin/kube-proxy $KUBE_PROXY_ARGS
         Restart=on-failure
         LimitNOFILE=65536
         KillMode=process
         [Install]
         WantedBy=multi-user.target
         ```

      2. 配置文件`vi /etc/kubernetes/proxy`(注意修改两个ip)

         `KUBE_PROXY_ARGS="--master=http://192.168.1.5:8080 --hostname-override=192.168.1.* --logtostderr=true --log-dir=/var/log/kubernetes --v=2"`

   4. 启动上述服务

      1. systemctl daemon-reload
      2. systemctl enable kubelet
      3. systemctl start kubelet
      4. systemctl status kubelet
      5. systemctl enable kube-proxy
      6. systemctl start kube-proxy
      7. systemctl status kube-proxy

   5. 第二个Node节点,通过拷贝的方式直接创建,然后调整对应ip即可



### 注意,如果service启动不了,可以按以下流程测试一遍参数

1. 从服务文件中复制ExecStart的值 例如 `/usr/bin/kube-proxy`
2. 从配置文件中获取双引号中间的参数 例如`--master=http://192.168.1.5:8080 --hostname-override=192.168.1.5 --logtostderr=true --log-dir=/var/log/kubernetes --v=2`
3. 合并1跟2,执行一遍`/usr/bin/kube-proxy --master=http://192.168.1.5:8080 --hostname-override=192.168.1.5 --logtostderr=true --log-dir=/var/log/kubernetes --v=2`
4. 执行成功说明参数没有问题
5. 失败会提示相应错误