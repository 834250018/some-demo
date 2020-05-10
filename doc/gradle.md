gradle.build
Buildscript 指定build文件要使用的依赖
外面的才是模块的依赖
Implementation依赖的版本只在本模块使用
apiElements可传递依赖
compileOnly仅编译
runtimeOnly仅运行时

configurations.all{
//每次build检查远程依赖是否存在更新
resolutionStrategy.cacheChangingModulesFor 1,'seconds'
resolutionStrategy.cacheDynamicVersionsFor 1,'seconds'
}

gradle导入本地jar包
compile files('libs/SF-CSIM-EXPRESS-SDK-V1.6.jar')
