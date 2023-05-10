dependencies {
    api(project(":plugin:plugin-core"))
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "注册用户管理插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "[System] 提供数据库注册用户管理"
}