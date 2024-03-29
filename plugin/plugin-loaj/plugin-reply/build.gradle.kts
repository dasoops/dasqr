dependencies {
    api(project(":plugin:plugin-core"))
    api(project(":plugin:plugin-system:plugin-system-cache"))
    api(project(":plugin:plugin-system:plugin-system-db-ktorm"))
    //爬虫框架
    implementation("org.jsoup:jsoup:1.15.3")
}

tasks.named<Jar>("jar") {
    manifest.attributes["Plugin-Name"] = "消息回复插件"
    manifest.attributes["Plugin-Author"] = "DasoopsNicole@Gmail.com"
    manifest.attributes["Plugin-Version"] = "1.0.0"
    manifest.attributes["Plugin-Description"] = "基于数据库管理的消息回复插件,提供简单命令配置,拦截"
}
