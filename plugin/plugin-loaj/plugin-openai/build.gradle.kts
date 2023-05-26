dependencies {
    api(project(":plugin:plugin-core"))
    api(project(":plugin:plugin-system:plugin-system-config"))
    api(project(":plugin:plugin-system:plugin-system-http-client"))

}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "openAi插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "openAi你还不知道干什么吗"
}