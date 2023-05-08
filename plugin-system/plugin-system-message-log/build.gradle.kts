dependencies {
    api(project(":plugin-core"))
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "消息持久化插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "[System] 提供消息持久化"
}