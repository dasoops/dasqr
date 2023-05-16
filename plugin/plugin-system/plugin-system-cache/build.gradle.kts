dependencies {
    api(project(":plugin:plugin-core"))
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "缓存插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "[System] 提供缓存统一管理,清除"
}