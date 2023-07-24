dependencies {
    api(project(":plugin:plugin-core"))
    api(project(":plugin:plugin-system:plugin-system-cache"))
    api(project(":plugin:plugin-system:plugin-system-db-ktorm"))
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "插件管理功能插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "[System] 插件管理功能"
}