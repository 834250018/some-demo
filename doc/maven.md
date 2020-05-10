eclipse下maven本地仓库路径修改：settings.xml
不使用自带maven插件而是maven官网下载稳定版然后修改eclipse默认maven
maven检出不了：配置了maven环境变量之后，或者重启eclipse解决
global settings 跟user settings只需一个，重复则报错
maven环境配好了，执行mvn -v命令，提示mvn不是内部或外部命令：重新查看环境变量maven路径后面的分号
记得配置本地仓库路径，避免使用默认路径（C:\\User\用户名\.m2.repository）

找不到jar
到maven仓库下查看，若不存在相应jar包，把整个目录删除，让maven重新加载

scope属性
1.compile：默认值 他表示被依赖项目需要参与当前项目的编译，还有后续的测试，运行周期也参与其中，是一个比较强的依赖。打包的时候通常需要包含进去

2.test：依赖项目仅仅参与测试相关的工作，包括测试代码的编译和执行，不会被打包，例如：junit

3.runtime：表示被依赖项目无需参与项目的编译，不过后期的测试和运行周期需要其参与。与compile相比，跳过了编译而已。例如JDBC驱动，适用运行和测试阶段

4.provided：打包的时候可以不用包进去，别的设施会提供。事实上该依赖理论上可以参与编译，测试，运行等周期。相当于compile，但是打包阶段做了exclude操作

5.system：从参与度来说，和provided相同，不过被依赖项不会从maven仓库下载，而是从本地文件系统拿。需要添加systemPath的属性来定义路径

maven下载不了依赖
1.检查offline work开关是否打开
2.检查maven使用的是自带插件还是本地maven组件
3.maven的conf.xml中的远程仓库配置是否有配
4.重启idea