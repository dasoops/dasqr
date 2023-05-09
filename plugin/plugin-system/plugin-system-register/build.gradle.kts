dependencies {
    api(project(":plugin-core"))
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "权限验证拦截插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "[System] 提供数据库权限管理,对listenerHost进行权限验证"
}