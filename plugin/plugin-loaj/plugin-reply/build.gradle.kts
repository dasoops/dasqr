dependencies {
    api(project(":plugin:plugin-core"))
    api(project(":plugin:plugin-system:plugin-system-cache"))
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "消息回复插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "数据库管理的消息回复,能做到简单的消息回复"
}