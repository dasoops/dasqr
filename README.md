# Dasqr

基于
[Mirai](https://gitter.im/mamoe/mirai?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
的qqBot实现,开发中

依赖仓库 [common](https://github.com/dasoops/common)

task `launchTest` : 打包后在工作路径测试,用于测试插件加载等(mcl抄来的)

在项目根目录下新建`config.gradle`并添加以下代码可重写工作目录
```kotlin script
ext {
    dasqrWorkingDir = "D:/temp/dasqr"
}
```

`plugin-system`     提供系统级插件,包括数据库加载配置插件等

`plugin-loaj`       乱七八糟的插件

`plugin-test`       开发环境可直接在该项目下添加其他插件的依赖
                    运行com.dasoops.dasqr.plugin.MainKt.main()进行测试
 