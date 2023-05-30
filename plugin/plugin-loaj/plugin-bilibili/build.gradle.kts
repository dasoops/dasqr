dependencies {
    api(project(":plugin:plugin-core"))
    api(project(":plugin:plugin-system:plugin-system-cache"))
    api(project(":plugin:plugin-system:plugin-system-schedule"))
    api(project(":plugin:plugin-system:plugin-system-http-client"))
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "bilibili订阅插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "bilibili订阅插件"
}
